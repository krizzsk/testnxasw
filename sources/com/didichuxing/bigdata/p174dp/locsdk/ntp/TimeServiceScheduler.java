package com.didichuxing.bigdata.p174dp.locsdk.ntp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.didichuxing.bigdata.p174dp.locsdk.ntp.ITimeServiceScheduler;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.ntp.TimeServiceScheduler */
public class TimeServiceScheduler implements ITimeServiceScheduler {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f48693a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ITimeServiceScheduler.OnTimeScheduleListener f48694b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Handler f48695c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Runnable f48696d = new Runnable() {
        public void run() {
            if (TimeServiceScheduler.this.f48694b != null) {
                TimeServiceScheduler.this.f48694b.onTimeTick(TimeServiceScheduler.this.f48693a);
            }
            if (TimeServiceScheduler.this.f48695c != null) {
                TimeServiceScheduler.this.f48695c.postDelayed(TimeServiceScheduler.this.f48696d, 60000);
            }
        }
    };

    public TimeServiceScheduler(Context context) {
        this.f48693a = context;
        this.f48695c = new Handler(Looper.getMainLooper());
    }

    public void setOnTimeScheduleListener(ITimeServiceScheduler.OnTimeScheduleListener onTimeScheduleListener) {
        this.f48694b = onTimeScheduleListener;
    }

    public void start() {
        Handler handler = this.f48695c;
        if (handler != null) {
            handler.postDelayed(this.f48696d, 60000);
        }
    }

    public void stop() {
        Handler handler = this.f48695c;
        if (handler != null) {
            handler.removeCallbacks(this.f48696d);
        }
    }
}
