package connectionclass;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;

public class DeviceBandwidthSampler {

    /* renamed from: f */
    private static long f59054f = -1;

    /* renamed from: a */
    private final ConnectionClassManager f59055a;

    /* renamed from: b */
    private AtomicInteger f59056b;

    /* renamed from: c */
    private SamplingHandler f59057c;

    /* renamed from: d */
    private HandlerThread f59058d;

    /* renamed from: e */
    private long f59059e;

    private static class DeviceBandwidthSamplerHolder {
        public static final DeviceBandwidthSampler instance = new DeviceBandwidthSampler(ConnectionClassManager.getInstance());

        private DeviceBandwidthSamplerHolder() {
        }
    }

    public static DeviceBandwidthSampler getInstance() {
        return DeviceBandwidthSamplerHolder.instance;
    }

    private DeviceBandwidthSampler(ConnectionClassManager connectionClassManager) {
        this.f59055a = connectionClassManager;
        this.f59056b = new AtomicInteger();
        HandlerThread handlerThread = new HandlerThread("ParseThread");
        this.f59058d = handlerThread;
        handlerThread.start();
        this.f59057c = new SamplingHandler(this.f59058d.getLooper());
    }

    public void startSampling() {
        if (this.f59056b.getAndIncrement() == 0) {
            this.f59057c.startSamplingThread();
            this.f59059e = SystemClock.elapsedRealtime();
        }
    }

    public void stopSampling() {
        if (this.f59056b.decrementAndGet() == 0) {
            this.f59057c.stopSamplingThread();
            addFinalSample();
        }
    }

    /* access modifiers changed from: protected */
    public void addSample() {
        long totalRxBytes = TrafficStats.getTotalRxBytes();
        long j = f59054f;
        long j2 = totalRxBytes - j;
        if (j >= 0) {
            synchronized (this) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f59055a.addBandwidth(j2, elapsedRealtime - this.f59059e);
                this.f59059e = elapsedRealtime;
            }
        }
        f59054f = totalRxBytes;
    }

    /* access modifiers changed from: protected */
    public void addFinalSample() {
        addSample();
        f59054f = -1;
    }

    public boolean isSampling() {
        return this.f59056b.get() != 0;
    }

    private class SamplingHandler extends Handler {
        private static final int MSG_START = 1;
        static final long SAMPLE_TIME = 1000;

        public SamplingHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                DeviceBandwidthSampler.this.addSample();
                sendEmptyMessageDelayed(1, 1000);
                return;
            }
            throw new IllegalArgumentException("Unknown what=" + message.what);
        }

        public void startSamplingThread() {
            sendEmptyMessage(1);
        }

        public void stopSamplingThread() {
            removeMessages(1);
        }
    }
}
