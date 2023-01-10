package com.didi.sdk.connectivity;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.didi.one.netdetect.DetectionTaskManager;
import com.didi.one.netdetect.command.PingResult;
import com.didi.one.netdetect.model.PingParam;
import com.didi.one.netdetect.model.TraceRouteParam;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.connectivity.Config;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

class Task implements Runnable {

    /* renamed from: a */
    private List<Config.Item> f38518a = new ArrayList();

    /* renamed from: b */
    private ExecutorService f38519b;

    /* renamed from: c */
    private Callback f38520c;

    /* renamed from: d */
    private Context f38521d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final AtomicBoolean f38522e = new AtomicBoolean(false);

    interface Callback {
        void onFinished(List<ConnStat> list);
    }

    Task(Context context, ExecutorService executorService, List<Config.Item> list, Callback callback) {
        this.f38519b = executorService;
        this.f38518a.addAll(list);
        this.f38520c = callback;
        this.f38521d = context;
    }

    public void run() {
        ArrayList<Future> arrayList = new ArrayList<>();
        for (final Config.Item next : this.f38518a) {
            arrayList.add(this.f38519b.submit(new Callable<ConnStat>() {
                public ConnStat call() {
                    long currentTimeMillis = System.currentTimeMillis();
                    ConnStat connStat = (ConnStat) Connectivity.getInstance().TCPConnect(next.f38487ip, next.port, next.timeout);
                    if (connStat != null) {
                        connStat.startTime = currentTimeMillis;
                        connStat.host = next.host;
                        if (!connStat.success && next.pingCnt > 0) {
                            Task.this.m29052a(next, connStat);
                        }
                        connStat.endTime = System.currentTimeMillis();
                    }
                    return connStat;
                }
            }));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Future future : arrayList) {
            try {
                ConnStat connStat = (ConnStat) future.get();
                if (connStat != null) {
                    arrayList2.add(connStat);
                }
            } catch (InterruptedException e) {
                SystemUtils.log(3, "didi-connectivity", Log.getStackTraceString(e), (Throwable) null, "com.didi.sdk.connectivity.Task", 77);
            } catch (ExecutionException e2) {
                SystemUtils.log(3, "didi-connectivity", Log.getStackTraceString(e2), (Throwable) null, "com.didi.sdk.connectivity.Task", 79);
            } catch (Throwable th) {
                SystemUtils.log(3, "didi-connectivity", Log.getStackTraceString(th), (Throwable) null, "com.didi.sdk.connectivity.Task", 81);
            }
        }
        Callback callback = this.f38520c;
        if (callback != null) {
            callback.onFinished(arrayList2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29052a(final Config.Item item, final ConnStat connStat) {
        C12992c.m29060a("触发ping操作 => " + item.toString());
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        PingParam pingParam = new PingParam();
        pingParam.setCount(item.pingCnt);
        pingParam.setTimeout(2);
        pingParam.setUrl("https://" + item.f38487ip);
        DetectionTaskManager.getInstance().callPingCommand(this.f38521d, pingParam, new DetectionTaskManager.Callback<PingResult>() {
            public void handleResult(PingResult pingResult) {
                connStat.pingResult = Task.this.m29050a(String.valueOf(pingResult));
                if (Task.this.m29054a(item, pingResult)) {
                    Task.this.m29056b(item, connStat);
                }
                countDownLatch.countDown();
            }
        });
        try {
            if (item.trTimeout > 0) {
                countDownLatch.await((long) (item.trTimeout + 60), TimeUnit.SECONDS);
            } else {
                countDownLatch.await();
            }
        } catch (InterruptedException e) {
            C12992c.m29060a("InterruptedException occur in ping => " + e.getLocalizedMessage());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m29054a(Config.Item item, PingResult pingResult) {
        if (pingResult == null || pingResult.getTotalCount() <= 0 || pingResult.getFailCount() != pingResult.getTotalCount() || item.trMaxTTL == -1 || !this.f38522e.compareAndSet(false, true)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m29056b(Config.Item item, final ConnStat connStat) {
        C12992c.m29060a("触发traceroute操作 => " + item.toString());
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        TraceRouteParam traceRouteParam = new TraceRouteParam();
        traceRouteParam.url = "https://" + item.f38487ip;
        DetectionTaskManager.getInstance().callTraceRouteCommand(this.f38521d, traceRouteParam, new DetectionTaskManager.Callback<String>() {
            public void handleResult(String str) {
                Task.this.f38522e.set(false);
                connStat.tracertResult = Task.this.m29050a(str);
                countDownLatch.countDown();
            }
        });
        try {
            if (item.trTimeout > 0) {
                countDownLatch.await((long) item.trTimeout, TimeUnit.SECONDS);
            } else {
                countDownLatch.await();
            }
        } catch (InterruptedException e) {
            C12992c.m29060a("InterruptedException occur in traceroute => " + e.getLocalizedMessage());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m29050a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.replaceAll("\t", " ").replaceAll("    ", " ").replaceAll("\r\n", "; ");
    }
}
