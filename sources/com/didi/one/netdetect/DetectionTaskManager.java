package com.didi.one.netdetect;

import android.content.Context;
import android.text.TextUtils;
import com.didi.one.netdetect.command.Command;
import com.didi.one.netdetect.command.PingResult;
import com.didi.one.netdetect.http.HttpService;
import com.didi.one.netdetect.http.ResponseListener;
import com.didi.one.netdetect.model.DetectionGroup;
import com.didi.one.netdetect.model.DetectionItem;
import com.didi.one.netdetect.model.DetectionItemResult;
import com.didi.one.netdetect.model.DetectionParam;
import com.didi.one.netdetect.model.DetectionReportInfo;
import com.didi.one.netdetect.model.PingParam;
import com.didi.one.netdetect.model.ResponseInfo;
import com.didi.one.netdetect.model.TraceRouteItemResult;
import com.didi.one.netdetect.model.TraceRouteParam;
import com.didi.one.netdetect.model.TraceRouteReportInfo;
import com.didi.one.netdetect.provider.ApolloProvider;
import com.didi.one.netdetect.provider.IDetectionGroupProvider;
import com.didi.one.netdetect.security.SignGenerator;
import com.didi.one.netdetect.task.DidiHttpTask;
import com.didi.one.netdetect.task.PingTask;
import com.didi.one.netdetect.task.TracePathTask;
import com.didi.one.netdetect.task.TraceRouteTask;
import com.didi.one.netdetect.util.ONDLog;
import com.didi.one.netdetect.util.PrefUtil;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class DetectionTaskManager {

    /* renamed from: a */
    private static final String f31858a = "OND_TaskManager";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f31859b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DetectionGroup f31860c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public List<DetectionItem> f31861d;

    /* renamed from: e */
    private Thread f31862e;

    /* renamed from: f */
    private DetectionTask f31863f;

    /* renamed from: g */
    private boolean f31864g;

    /* renamed from: h */
    private DetectionParam f31865h;

    /* renamed from: i */
    private SignGenerator f31866i;

    /* renamed from: j */
    private IDetectionGroupProvider f31867j;

    /* renamed from: k */
    private State f31868k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Logger f31869l;

    /* renamed from: m */
    private ExecutorService f31870m;

    /* renamed from: n */
    private AtomicBoolean f31871n;

    /* renamed from: o */
    private boolean f31872o;

    public static abstract class Callback<T> implements Command.OutPutHandler<T> {
        public void handleMsg(String str) {
        }

        public void handleResult(T t) {
        }
    }

    public enum State {
        NONE,
        STARTED,
        RUNNING,
        STOP,
        RESUME,
        CANCEL
    }

    private DetectionTaskManager() {
        this.f31861d = new ArrayList();
        this.f31868k = State.NONE;
        this.f31869l = LoggerFactory.getLogger("OneNetDetect");
        this.f31871n = new AtomicBoolean(false);
    }

    public static DetectionTaskManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    static class SingletonHolder {
        /* access modifiers changed from: private */
        public static DetectionTaskManager INSTANCE = new DetectionTaskManager();

        SingletonHolder() {
        }
    }

    public void init(Context context, DetectionParam detectionParam, SignGenerator signGenerator) {
        if (this.f31871n.compareAndSet(false, true)) {
            this.f31859b = context.getApplicationContext();
            this.f31865h = detectionParam;
            this.f31866i = signGenerator;
            this.f31867j = new ApolloProvider(detectionParam.apolloName);
            TraceRouteStore.m24322a().mo86360a(context, detectionParam, signGenerator);
        }
    }

    public void setDetectionGroupProvider(IDetectionGroupProvider iDetectionGroupProvider) {
        this.f31867j = iDetectionGroupProvider;
    }

    public synchronized void startDetection() {
        if (!this.f31871n.get()) {
            ONDLog.m24359d(f31858a, "not inited");
            return;
        }
        ONDLog.m24359d(f31858a, "invoke startDetection()");
        if (this.f31868k == State.STOP) {
            this.f31868k = State.STARTED;
        } else if (this.f31868k == State.NONE || this.f31868k == State.RESUME) {
            m24309a();
        }
        ONDLog.m24359d(f31858a, "current state: " + this.f31868k.toString());
    }

    /* renamed from: a */
    private void m24309a() {
        if (!this.f31864g) {
            DetectionGroup providerDetectionGroup = this.f31867j.providerDetectionGroup();
            this.f31860c = providerDetectionGroup;
            if (providerDetectionGroup == null) {
                this.f31868k = State.CANCEL;
                return;
            }
            this.f31864g = true;
            this.f31868k = State.RUNNING;
            this.f31863f = new DetectionTask();
            Thread thread = new Thread(this.f31863f);
            this.f31862e = thread;
            thread.setPriority(1);
            this.f31862e.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th) {
                    StringWriter stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    String stringWriter2 = stringWriter.toString();
                    HashMap hashMap = new HashMap();
                    hashMap.put("exception", stringWriter2);
                    DetectionTaskManager.this.f31869l.errorEvent("DetectionThreadException", (Map<?, ?>) hashMap);
                }
            });
            this.f31862e.start();
        }
    }

    public synchronized void cancelDetection() {
        if (!this.f31871n.get()) {
            ONDLog.m24359d(f31858a, "not inited");
            return;
        }
        ONDLog.m24363i(f31858a, "invoke cancelDetection()");
        this.f31868k = State.CANCEL;
        if (this.f31863f != null) {
            this.f31863f.cancel();
        }
        ONDLog.m24359d(f31858a, "current state: " + this.f31868k.toString());
    }

    public synchronized void stopDetection() {
        if (!this.f31871n.get()) {
            ONDLog.m24359d(f31858a, "not inited");
            return;
        }
        ONDLog.m24363i(f31858a, "invoke stopDetection()");
        if (this.f31868k != State.CANCEL) {
            this.f31868k = State.STOP;
            if (this.f31863f != null) {
                this.f31863f.stop();
            }
        }
        ONDLog.m24359d(f31858a, "current state: " + this.f31868k.toString());
    }

    public synchronized void resumeDetection() {
        if (!this.f31871n.get()) {
            ONDLog.m24359d(f31858a, "not inited");
            return;
        }
        ONDLog.m24363i(f31858a, "invoke resumeDetection()");
        if (this.f31868k == State.STARTED) {
            m24309a();
        } else if (this.f31868k == State.STOP) {
            if (this.f31864g) {
                this.f31868k = State.RUNNING;
            } else {
                this.f31868k = State.RESUME;
            }
            if (this.f31863f != null) {
                this.f31863f.resume();
            }
        }
        ONDLog.m24359d(f31858a, "current state: " + this.f31868k.toString());
    }

    private class DetectionTask implements Runnable {
        volatile boolean cancelled;
        volatile boolean stopped;

        private DetectionTask() {
        }

        public void cancel() {
            this.cancelled = true;
        }

        public void stop() {
            this.stopped = true;
        }

        public void resume() {
            this.stopped = false;
        }

        public void run() {
            while (!this.cancelled) {
                if (!this.stopped) {
                    DetectionTaskManager.this.f31861d.clear();
                    long currentTimeMillis = System.currentTimeMillis();
                    ArrayList arrayList = new ArrayList();
                    DidiHttpTask.TaskParams taskParams = new DidiHttpTask.TaskParams();
                    taskParams.mTimeout = DetectionTaskManager.this.f31860c.detecTimeout;
                    DidiHttpTask didiHttpTask = new DidiHttpTask(taskParams);
                    PingTask pingTask = new PingTask(DetectionTaskManager.this.f31859b);
                    pingTask.setTimeout(((DetectionTaskManager.this.f31860c.pingTimeout / 1000) * DetectionTaskManager.this.f31860c.pingCount) + 3);
                    pingTask.setCount(DetectionTaskManager.this.f31860c.pingCount);
                    for (DetectionItem next : DetectionTaskManager.this.f31860c.detectList) {
                        ONDLog.m24359d(DetectionTaskManager.f31858a, "START GET");
                        DidiHttpTask.HttpTaskResult doTask = didiHttpTask.doTask(next);
                        ONDLog.m24359d(DetectionTaskManager.f31858a, "END GET");
                        ONDLog.m24359d(DetectionTaskManager.f31858a, "START PING");
                        PingResult doTask2 = pingTask.doTask(next);
                        ONDLog.m24359d(DetectionTaskManager.f31858a, "END PING");
                        DetectionItemResult detectionItemResult = new DetectionItemResult();
                        detectionItemResult.detectId = next.f31905id;
                        detectionItemResult.resolveHttpTaskResult(doTask);
                        detectionItemResult.resolvePingTaskResult(doTask2);
                        DetectionTaskManager detectionTaskManager = DetectionTaskManager.this;
                        if (detectionTaskManager.m24314a(detectionTaskManager.f31860c, doTask2)) {
                            PrefUtil.setPingOutputTime(DetectionTaskManager.this.f31859b, System.currentTimeMillis());
                            detectionItemResult.resolvePingTaskResultExtra(doTask2);
                        }
                        arrayList.add(detectionItemResult);
                        DetectionTaskManager detectionTaskManager2 = DetectionTaskManager.this;
                        if (detectionTaskManager2.m24315a(detectionTaskManager2.f31860c, detectionItemResult)) {
                            DetectionTaskManager.this.f31861d.add(next);
                        }
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    ONDLog.m24359d(DetectionTaskManager.f31858a, "one round get and ping takes " + String.valueOf(currentTimeMillis2 - currentTimeMillis) + " ms");
                    DetectionTaskManager.this.m24319b((List<DetectionItemResult>) arrayList);
                    if (DetectionTaskManager.this.f31861d.size() > 0) {
                        PrefUtil.setTraceRouteTime(DetectionTaskManager.this.f31859b, System.currentTimeMillis());
                        long currentTimeMillis3 = System.currentTimeMillis();
                        ArrayList arrayList2 = new ArrayList();
                        TracePathTask tracePathTask = new TracePathTask(DetectionTaskManager.this.f31859b);
                        for (DetectionItem detectionItem : DetectionTaskManager.this.f31861d) {
                            ONDLog.m24359d(DetectionTaskManager.f31858a, "START TRACEROUTE");
                            String doTask3 = tracePathTask.doTask(detectionItem);
                            ONDLog.m24359d(DetectionTaskManager.f31858a, "END TRACEROUTE");
                            TraceRouteItemResult traceRouteItemResult = new TraceRouteItemResult();
                            traceRouteItemResult.detectId = detectionItem.f31905id;
                            traceRouteItemResult.trTime = System.currentTimeMillis();
                            traceRouteItemResult.info = doTask3;
                            arrayList2.add(traceRouteItemResult);
                        }
                        long currentTimeMillis4 = System.currentTimeMillis();
                        ONDLog.m24359d(DetectionTaskManager.f31858a, "one round traceRoute takes " + String.valueOf(currentTimeMillis4 - currentTimeMillis3) + " ms");
                        DetectionTaskManager.this.m24311a((List<TraceRouteItemResult>) arrayList2);
                        try {
                            if (DetectionTaskManager.this.f31860c.detectInterval > 0) {
                                Thread.sleep((long) (DetectionTaskManager.this.f31860c.detectInterval * 1000));
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            if (DetectionTaskManager.this.f31860c.detectInterval > 0) {
                                Thread.sleep((long) (DetectionTaskManager.this.f31860c.detectInterval * 1000));
                            }
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24311a(List<TraceRouteItemResult> list) {
        final TraceRouteReportInfo traceRouteReportInfo = new TraceRouteReportInfo();
        traceRouteReportInfo.setData(list);
        final String b = m24316b();
        if (!TextUtils.isEmpty(b)) {
            HttpService.traceRouteInfoReport(this.f31859b, b + HttpService.TRACE_ROUTE_REPORT_PATH, this.f31865h, traceRouteReportInfo, this.f31866i, new ResponseListener<ResponseInfo>() {
                public void onSuccess(ResponseInfo responseInfo) {
                }

                public void onFail(Throwable th) {
                    TraceRouteStore.m24322a().mo86362a(b, 1, traceRouteReportInfo);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m24319b(List<DetectionItemResult> list) {
        DetectionReportInfo detectionReportInfo = new DetectionReportInfo();
        detectionReportInfo.setData(list);
        String b = m24316b();
        if (!TextUtils.isEmpty(b)) {
            HttpService.detectionInfoReport(this.f31859b, b + HttpService.DETECTION_REPORT_PATH, this.f31865h, detectionReportInfo, this.f31866i, new ResponseListener<ResponseInfo>() {
                public void onSuccess(ResponseInfo responseInfo) {
                    ONDLog.m24359d(DetectionTaskManager.f31858a, "uploadDetectionInfo success");
                }

                public void onFail(Throwable th) {
                    ONDLog.m24359d(DetectionTaskManager.f31858a, "uploadDetectionInfo failed");
                }
            });
        }
    }

    /* renamed from: b */
    private String m24316b() {
        int i;
        DetectionGroup detectionGroup = this.f31860c;
        if (detectionGroup == null || detectionGroup.reportUrl == null || this.f31860c.reportUrl.size() == 0) {
            return "";
        }
        if (this.f31860c.reportUrl.size() == 1) {
            i = 0;
        } else {
            i = new Random().nextInt(this.f31860c.reportUrl.size());
        }
        String str = this.f31860c.reportUrl.get(i);
        if (str.startsWith("http") || str.startsWith("https")) {
            return str;
        }
        if (this.f31872o) {
            return "http://" + str;
        }
        return "https://" + str;
    }

    public void setDebugMode(boolean z) {
        this.f31872o = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m24314a(DetectionGroup detectionGroup, PingResult pingResult) {
        if (this.f31872o) {
            return true;
        }
        if (detectionGroup != null && pingResult != null && pingResult.isFailAll() && new Random().nextInt(1000) < detectionGroup.pingOutputPercent) {
            if (System.currentTimeMillis() - PrefUtil.getPingOutputTime(this.f31859b) > ((long) (detectionGroup.pingOutputInterval * 1000))) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m24315a(DetectionGroup detectionGroup, DetectionItemResult detectionItemResult) {
        if (this.f31872o) {
            return true;
        }
        if ((detectionItemResult.detectErrCode >= 2200 && detectionItemResult.detectErrCode <= 2300 && detectionItemResult.pingErrorNum != detectionGroup.pingCount) || new Random().nextInt(1000) >= detectionGroup.trPercent) {
            return false;
        }
        if (System.currentTimeMillis() - PrefUtil.getTraceRouteTime(this.f31859b) > ((long) (detectionGroup.trInterval * 1000))) {
            return true;
        }
        return false;
    }

    public void callPingCommand(final Context context, final PingParam pingParam, final Callback<PingResult> callback) {
        if (context != null && pingParam != null) {
            if (this.f31870m == null) {
                this.f31870m = Executors.newFixedThreadPool(2);
            }
            this.f31870m.execute(new Runnable() {
                public void run() {
                    DetectionItem detectionItem = new DetectionItem();
                    detectionItem.url = pingParam.getUrl();
                    PingTask pingTask = new PingTask(context, new Command.OutPutHandler<PingResult>() {
                        public void handleMsg(String str) {
                            if (callback != null) {
                                callback.handleMsg(str);
                            }
                        }

                        public void handleResult(PingResult pingResult) {
                            if (callback != null) {
                                callback.handleResult(pingResult);
                            }
                        }
                    });
                    pingTask.setTimeout((pingParam.getTimeout() * pingParam.getCount()) + 3);
                    pingTask.setCount(pingParam.getCount());
                    pingTask.doTask(detectionItem);
                }
            });
        }
    }

    public void callTraceRouteCommand(final Context context, final TraceRouteParam traceRouteParam, final Callback<String> callback) {
        if (context != null && traceRouteParam != null) {
            if (this.f31870m == null) {
                this.f31870m = Executors.newFixedThreadPool(2);
            }
            this.f31870m.execute(new Runnable() {
                public void run() {
                    DetectionItem detectionItem = new DetectionItem();
                    detectionItem.url = traceRouteParam.url;
                    TraceRouteTask traceRouteTask = new TraceRouteTask(context, new Command.OutPutHandler<String>() {
                        public void handleMsg(String str) {
                            if (callback != null) {
                                callback.handleMsg(str);
                            }
                        }

                        public void handleResult(String str) {
                            if (callback != null) {
                                callback.handleResult(str);
                            }
                        }
                    });
                    traceRouteTask.setMaxTTL(traceRouteParam.maxTTL);
                    traceRouteTask.setWaitTime(traceRouteParam.waitTime);
                    traceRouteTask.doTask(detectionItem);
                }
            });
        }
    }
}
