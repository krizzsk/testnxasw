package com.didi.sdk.app;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.concurrent.CountDownLatch;

public class BroadcastSender implements IBroadcastSender {

    /* renamed from: a */
    private static final Object f37894a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Handler f37895b = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static Logger f37896c = LoggerFactory.getLogger("BroadcastSender");

    /* renamed from: d */
    private static IBroadcastSender f37897d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final LocalBroadcastManager f37898e;

    /* renamed from: f */
    private final LooperThread f37899f;

    /* renamed from: g */
    private final Handler f37900g = new Handler(this.f37899f.getLooper());

    private BroadcastSender(Context context) {
        this.f37898e = LocalBroadcastManager.getInstance(context);
        LooperThread looperThread = new LooperThread();
        this.f37899f = looperThread;
        looperThread.start();
    }

    public static IBroadcastSender getInstance(Context context) {
        IBroadcastSender iBroadcastSender;
        synchronized (f37894a) {
            if (f37897d == null) {
                f37897d = new BroadcastSender(context.getApplicationContext());
            }
            iBroadcastSender = f37897d;
        }
        return iBroadcastSender;
    }

    public void sendBroadcast(final Intent intent) {
        this.f37900g.post(new Runnable() {
            public void run() {
                BroadcastSender.f37895b.post(new Runnable() {
                    public void run() {
                        BroadcastSender.f37896c.debug("BEFORE sendBroadcastSync()", new Object[0]);
                        BroadcastSender.this.f37898e.sendBroadcastSync(intent);
                        BroadcastSender.f37896c.debug("AFTER sendBroadcastSync()", new Object[0]);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo96969a() {
        this.f37899f.tryResume();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo96970b() {
        this.f37899f.tryPause();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo96971c() {
        return this.f37899f.isPause();
    }

    private static class PairLocker {
        private static Logger log = LoggerFactory.getLogger("PairLocker");
        private volatile int count;

        public synchronized void unlock() {
            this.count--;
            if (this.count == 0) {
                log.debug("notify all", new Object[0]);
                notifyAll();
            } else {
                log.debug("nothing to notify", new Object[0]);
            }
        }

        public synchronized void lock() {
            this.count++;
            if (this.count > 0) {
                log.debug("wait", new Object[0]);
                try {
                    wait();
                } catch (InterruptedException unused) {
                }
            } else {
                log.debug("nothing to wait", new Object[0]);
            }
        }

        public int getCount() {
            return this.count;
        }
    }

    private static class LooperThread extends Thread {
        private Handler internHandler;
        /* access modifiers changed from: private */
        public final PairLocker locker = new PairLocker();
        private Looper looper;
        private final CountDownLatch looperLatch = new CountDownLatch(1);
        private final Runnable pauseRunnable = new Runnable() {
            public void run() {
                LooperThread.this.locker.lock();
            }
        };

        LooperThread() {
            super("BroadcastSenderThread");
        }

        public void run() {
            SystemUtils.setProcessThreadPriority(10);
            Looper.prepare();
            this.looper = Looper.myLooper();
            this.internHandler = new Handler(this.looper);
            tryPause();
            this.looperLatch.countDown();
            Looper.loop();
        }

        public void tryResume() {
            this.locker.unlock();
        }

        public void tryPause() {
            this.internHandler.post(this.pauseRunnable);
        }

        public boolean isPause() {
            return this.locker.getCount() > 0;
        }

        public Looper getLooper() {
            try {
                this.looperLatch.await();
            } catch (InterruptedException unused) {
            }
            return this.looper;
        }
    }
}
