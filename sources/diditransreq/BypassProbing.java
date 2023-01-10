package diditransreq;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import didinet.ApolloAPI;
import didinet.Logger;
import didinet.NetEngine;
import didinet.OmegaAPI;
import didinet.PushAPI;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.SocketFactory;

public class BypassProbing {

    /* renamed from: a */
    private static final String f59918a = "BypassProbing";

    /* renamed from: b */
    private static BypassProbing f59919b = null;

    /* renamed from: g */
    private static final int f59920g = 1;

    /* renamed from: h */
    private static final int f59921h = 2;

    /* renamed from: c */
    private LooperHandler f59922c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WorkHandler f59923d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<Long> f59924e = Collections.synchronizedList(new ArrayList());

    /* renamed from: f */
    private boolean f59925f = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f59926i;

    /* renamed from: j */
    private int f59927j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f59928k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f59929l;

    private BypassProbing() {
        ApolloAPI apolloAPI = NetEngine.getInstance().getApolloAPI();
        boolean allow = apolloAPI.getToggle("PushBypassCheck").allow();
        this.f59925f = allow;
        Logger.m45047d(f59918a, String.format("apollo enabled => [%s]", new Object[]{Boolean.valueOf(allow)}));
        if (this.f59925f) {
            ApolloAPI.Experiment experiment = apolloAPI.getToggle("PushBypassCheck").getExperiment();
            this.f59927j = ((Integer) experiment.getParam("delay", 10)).intValue();
            this.f59928k = ((Integer) experiment.getParam("interval", 10)).intValue();
            this.f59929l = ((Integer) experiment.getParam("timeout", 10)).intValue();
            m45085a();
            HandlerThread handlerThread = new HandlerThread("BypassProbingLooperThread");
            handlerThread.start();
            this.f59922c = new LooperHandler(handlerThread.getLooper());
            HandlerThread handlerThread2 = new HandlerThread("BypassProbingWorkerThread");
            handlerThread2.start();
            this.f59923d = new WorkHandler(handlerThread2.getLooper());
        }
    }

    /* renamed from: a */
    private void m45085a() {
        if (this.f59927j < 5) {
            this.f59927j = 5;
        }
        if (this.f59928k < 10) {
            this.f59928k = 10;
        }
        if (this.f59929l < 5) {
            this.f59929l = 5;
        }
    }

    public static BypassProbing getDefault() {
        if (f59919b == null) {
            synchronized (BypassProbing.class) {
                if (f59919b == null) {
                    f59919b = new BypassProbing();
                }
            }
        }
        return f59919b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo180376a(long j) {
        if (this.f59925f) {
            this.f59924e.add(Long.valueOf(j));
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = Long.valueOf(j);
            this.f59922c.sendMessageDelayed(obtain, (long) (this.f59927j * 1000));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo180377b(long j) {
        if (this.f59925f) {
            this.f59924e.remove(Long.valueOf(j));
        }
    }

    private class LooperHandler extends Handler {
        LooperHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                long longValue = ((Long) message.obj).longValue();
                if (BypassProbing.this.f59924e.contains(Long.valueOf(longValue))) {
                    BypassProbing.this.f59924e.remove(Long.valueOf(longValue));
                    BypassProbing.this.f59923d.addWork(longValue);
                }
            }
        }
    }

    private class WorkHandler extends Handler {
        private AtomicInteger atomic = new AtomicInteger();

        /* access modifiers changed from: package-private */
        public void addWork(long j) {
            if (this.atomic.get() == 0) {
                this.atomic.incrementAndGet();
                Logger.m45047d(BypassProbing.f59918a, String.format("seqId[%s] trigger bypass detect", new Object[]{Long.valueOf(j)}));
                sendEmptyMessage(2);
                return;
            }
            Logger.m45047d(BypassProbing.f59918a, String.format("seqId[%s] trigger bypass detect failed, because detect is doing!", new Object[]{Long.valueOf(j)}));
        }

        WorkHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 2) {
                doConnect();
            }
        }

        private void doConnect() {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - BypassProbing.this.f59926i < ((long) (BypassProbing.this.f59928k * 1000))) {
                Logger.m45047d(BypassProbing.f59918a, String.format("bypass detect interval be more than [%s] s", new Object[]{Integer.valueOf(BypassProbing.this.f59928k)}));
                this.atomic.decrementAndGet();
                return;
            }
            long unused = BypassProbing.this.f59926i = elapsedRealtime;
            PushAPI pushAPI = NetEngine.getInstance().getPushAPI();
            PushAPI.PushParam pushParam = pushAPI.getPushParam();
            String str = null;
            int i = -1;
            if (pushParam != null) {
                str = pushParam.pushHost;
                i = pushParam.pushPort;
            }
            if (TextUtils.isEmpty(str) || i < 0) {
                Logger.m45047d(BypassProbing.f59918a, String.format("push host[%s] or push port[%d] is not illegal!", new Object[]{"" + str, Integer.valueOf(i)}));
                this.atomic.decrementAndGet();
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("ip", str);
            hashMap.put("port", Integer.valueOf(i));
            hashMap.put("isconn", Boolean.valueOf(pushAPI.isConnected()));
            hashMap.put("ver", pushParam.pushVer);
            hashMap.put("tls", Integer.valueOf(pushParam.tls ? 2 : 1));
            SocketFactory socketFactory = SocketFactory.getDefault();
            try {
                Logger.m45047d(BypassProbing.f59918a, String.format("start connect server [%s:%d]", new Object[]{str, Integer.valueOf(i)}));
                Socket createSocket = socketFactory.createSocket();
                createSocket.connect(new InetSocketAddress(str, i), BypassProbing.this.f59929l * 1000);
                createSocket.close();
                Logger.m45047d(BypassProbing.f59918a, "bypass detect success");
                hashMap.put(C13234a.f39376f, 1);
            } catch (IOException e) {
                Logger.m45048d(BypassProbing.f59918a, "An IO Exception was thrown", e);
                if (e.getMessage().contains("connection refused")) {
                    hashMap.put(C13234a.f39376f, 1);
                    hashMap.put("reason", e.getMessage());
                } else {
                    hashMap.put(C13234a.f39376f, 0);
                    hashMap.put("reason", e.getMessage());
                }
            } catch (Throwable th) {
                this.atomic.decrementAndGet();
                OmegaAPI omegaAPI = NetEngine.getInstance().getOmegaAPI();
                Logger.m45047d(BypassProbing.f59918a, "Omega trackEvent");
                omegaAPI.trackEvent("socket_bypass_detect", "", hashMap);
                throw th;
            }
            this.atomic.decrementAndGet();
            OmegaAPI omegaAPI2 = NetEngine.getInstance().getOmegaAPI();
            Logger.m45047d(BypassProbing.f59918a, "Omega trackEvent");
            omegaAPI2.trackEvent("socket_bypass_detect", "", hashMap);
        }
    }
}
