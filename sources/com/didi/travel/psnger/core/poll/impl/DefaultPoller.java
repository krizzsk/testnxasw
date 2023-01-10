package com.didi.travel.psnger.core.poll.impl;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.travel.psnger.core.poll.BasePoller;
import com.didi.travel.psnger.core.poll.IPollCallbackProtocol;
import com.didi.travel.psnger.utils.LogUtil;

public class DefaultPoller extends BasePoller {

    /* renamed from: a */
    private static final int f46855a = 1;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public IPollCallbackProtocol f46856b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f46857c = 0;

    /* renamed from: d */
    private final int f46858d = 1000;

    /* renamed from: e */
    private CountDownTimer f46859e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f46860f = true;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f46861g = null;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public HandlerThread f46862h = null;

    public void registerPollCallback(IPollCallbackProtocol iPollCallbackProtocol) {
        super.registerPollCallback(iPollCallbackProtocol);
        this.f46856b = iPollCallbackProtocol;
    }

    public void startPoll(long j, long j2, long j3) {
        super.startPoll(j, j2, j3);
        LogUtil.m34919fi("startOrderStatusPoll");
        startPoll(j, j2, j3, false);
    }

    public void startPoll(long j, long j2, long j3, boolean z) {
        super.startPoll(j, j2, j3, z);
        LogUtil.m34919fi("startOrderStatusPoll isDelay=" + z);
        this.f46860f = false;
        this.mFrequencyTime = j2;
        m34890a(z);
        m34889a(j, j3);
    }

    public int getPollRunningTime() {
        return this.f46857c;
    }

    public synchronized void stopPoll() {
        super.stopPoll();
        LogUtil.m34919fi("stopPoll");
        if (this.f46859e != null) {
            this.f46859e.cancel();
            this.f46859e = null;
        }
        if (this.f46862h != null) {
            this.f46862h.quit();
            this.f46862h = null;
        }
        if (this.f46861g != null) {
            this.f46861g.removeMessages(1);
            this.f46861g = null;
        }
        if (this.f46856b != null) {
            this.f46856b.onPollStop();
        }
        this.f46860f = true;
    }

    public boolean checkPollerRunning() {
        super.checkPollerRunning();
        return !this.f46860f;
    }

    /* renamed from: a */
    private synchronized void m34890a(boolean z) {
        HandlerThread handlerThread = new HandlerThread("CHECK ORDER STATUS");
        this.f46862h = handlerThread;
        handlerThread.start();
        C151661 r0 = new Handler(this.f46862h.getLooper()) {
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    UiThreadHandler.post(new Runnable() {
                        public void run() {
                            if (DefaultPoller.this.f46856b != null) {
                                DefaultPoller.this.f46856b.onSendRequest(DefaultPoller.this.f46857c);
                            }
                        }
                    });
                    DefaultPoller.this.m34888a();
                }
            }
        };
        this.f46861g = r0;
        if (z) {
            r0.sendEmptyMessageDelayed(1, this.mFrequencyTime);
        } else {
            r0.sendEmptyMessage(1);
        }
    }

    /* renamed from: a */
    private void m34889a(long j, long j2) {
        final long j3 = j;
        final long j4 = j2;
        C151682 r0 = new CountDownTimer(j, 1000) {
            public void onTick(long j) {
                int unused = DefaultPoller.this.f46857c = (int) (((j3 / 1000) - ((long) (((int) j) / 1000))) + (j4 / 1000));
                if (DefaultPoller.this.f46856b != null) {
                    DefaultPoller.this.f46856b.onNotifyUpdateUI(DefaultPoller.this.f46857c);
                }
            }

            public void onFinish() {
                int unused = DefaultPoller.this.f46857c = (int) (j3 / 1000);
                boolean unused2 = DefaultPoller.this.f46860f = true;
                synchronized (DefaultPoller.this) {
                    if (DefaultPoller.this.f46862h != null) {
                        DefaultPoller.this.f46862h.quit();
                        HandlerThread unused3 = DefaultPoller.this.f46862h = null;
                    }
                    if (DefaultPoller.this.f46861g != null) {
                        DefaultPoller.this.f46861g.removeMessages(1);
                        Handler unused4 = DefaultPoller.this.f46861g = null;
                    }
                }
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        if (DefaultPoller.this.f46856b != null) {
                            DefaultPoller.this.f46856b.onPollTimeout();
                        }
                    }
                });
            }
        };
        this.f46859e = r0;
        r0.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m34888a() {
        if (this.f46861g != null) {
            Message obtain = Message.obtain();
            if (obtain == null) {
                this.f46861g.sendEmptyMessageDelayed(1, this.mFrequencyTime);
            } else {
                obtain.what = 1;
                this.f46861g.sendMessageDelayed(obtain, this.mFrequencyTime);
            }
        }
    }

    public synchronized void updatePollFrequenceTime(long j) {
        if (this.mFrequencyTime != j) {
            super.updatePollFrequenceTime(j);
            if (this.f46861g != null) {
                this.f46861g.removeMessages(1);
                m34888a();
            }
        }
    }
}
