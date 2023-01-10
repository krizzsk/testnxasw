package com.didi.component.business.polling;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.didi.sdk.util.UiThreadHandler;

public class PollingManager {

    /* renamed from: c */
    private static final int f13165c = 1;

    /* renamed from: a */
    private HandlerThread f13166a;

    /* renamed from: b */
    private Handler f13167b;

    private PollingManager() {
    }

    private static final class Singleton {
        /* access modifiers changed from: private */
        public static final PollingManager sInstance = new PollingManager();

        private Singleton() {
        }
    }

    public static PollingManager getInstance() {
        return Singleton.sInstance;
    }

    public void startLoop(PollingTask pollingTask) {
        m11033b(pollingTask);
        stopLoop();
        m11032a(pollingTask);
    }

    public synchronized void stopLoop() {
        if (this.f13166a != null) {
            this.f13166a.quit();
            this.f13166a = null;
        }
        if (this.f13167b != null) {
            this.f13167b.removeMessages(1);
            this.f13167b = null;
        }
    }

    /* renamed from: a */
    private synchronized void m11032a(final PollingTask pollingTask) {
        if (pollingTask != null) {
            if (pollingTask.matchPollCondication()) {
                if (pollingTask.loopInterval() > 0) {
                    HandlerThread handlerThread = new HandlerThread("LOOP_THREAD", 10);
                    this.f13166a = handlerThread;
                    handlerThread.start();
                    C51881 r0 = new Handler(this.f13166a.getLooper()) {
                        public void handleMessage(Message message) {
                            super.handleMessage(message);
                            if (message.what == 1) {
                                UiThreadHandler.post(new Runnable() {
                                    public void run() {
                                        if (pollingTask != null) {
                                            pollingTask.run();
                                        }
                                    }
                                });
                                sendEmptyMessageDelayed(1, pollingTask.loopInterval());
                            }
                        }
                    };
                    this.f13167b = r0;
                    r0.sendEmptyMessageDelayed(1, pollingTask.loopInterval());
                }
            }
        }
    }

    /* renamed from: b */
    private void m11033b(PollingTask pollingTask) {
        if (pollingTask == null) {
            throw new IllegalArgumentException("PollingTask must not be null!");
        }
    }
}
