package com.didichuxing.dfbasesdk.utils;

import android.os.Handler;
import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TimingTicker implements Handler.Callback {
    public static final int MSG_STOP = 2;
    public static final int MSG_TICKER = 1;

    /* renamed from: a */
    private final int f49416a;

    /* renamed from: b */
    private final ITicker f49417b;

    /* renamed from: c */
    private final int f49418c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final int f49419d;

    /* renamed from: e */
    private Timer f49420e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Handler f49421f = new Handler(this);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f49422g;

    public interface ITicker {
        void onStop();

        void onTicker(int i);
    }

    public static class TickerAdapter implements ITicker {
        public void onStop() {
        }

        public void onTicker(int i) {
        }
    }

    public TimingTicker(int i, int i2, int i3, TimeUnit timeUnit, ITicker iTicker) {
        this.f49416a = (int) timeUnit.toSeconds((long) i);
        this.f49417b = iTicker;
        this.f49418c = (int) timeUnit.toMillis((long) i2);
        this.f49419d = (int) timeUnit.toMillis((long) i3);
    }

    public void start() {
        if (this.f49420e != null) {
            exit();
        }
        Timer timer = new Timer();
        this.f49420e = timer;
        this.f49422g = this.f49416a;
        timer.schedule(new TimerTask() {
            public void run() {
                if (TimingTicker.this.f49422g <= 0) {
                    TimingTicker.this.exit();
                    TimingTicker.this.f49421f.obtainMessage(2).sendToTarget();
                } else {
                    TimingTicker.this.f49421f.obtainMessage(1, TimingTicker.this.f49422g, 0).sendToTarget();
                }
                TimingTicker timingTicker = TimingTicker.this;
                int unused = timingTicker.f49422g = timingTicker.f49422g - (TimingTicker.this.f49419d / 1000);
            }
        }, (long) this.f49418c, (long) this.f49419d);
    }

    public void exit() {
        Timer timer = this.f49420e;
        if (timer != null) {
            timer.cancel();
            this.f49420e.purge();
            this.f49420e = null;
        }
    }

    public boolean handleMessage(Message message) {
        ITicker iTicker;
        int i = message.what;
        if (i == 1) {
            ITicker iTicker2 = this.f49417b;
            if (iTicker2 == null) {
                return false;
            }
            iTicker2.onTicker(message.arg1);
            return false;
        } else if (i != 2 || (iTicker = this.f49417b) == null) {
            return false;
        } else {
            iTicker.onStop();
            return false;
        }
    }
}
