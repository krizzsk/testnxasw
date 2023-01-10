package com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3;

import com.didichuxing.bigdata.p174dp.locsdk.DLog;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.CountsLog */
public class CountsLog {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f48453a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f48454b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f48455c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f48456d;

    /* renamed from: e */
    private Timer f48457e;

    public CountsLog(String str, int i) {
        this(str, i, -1);
    }

    public CountsLog(String str, int i, int i2) {
        this.f48453a = str;
        this.f48455c = i;
        this.f48454b = 0;
        this.f48456d = i2;
        m36300a();
    }

    /* renamed from: a */
    private void m36300a() {
        Timer timer = new Timer(this.f48453a);
        this.f48457e = timer;
        timer.schedule(new TimerTask() {
            public void run() {
                if (CountsLog.this.f48454b < CountsLog.this.f48455c && CountsLog.this.f48454b > CountsLog.this.f48456d) {
                    DLog.m36225d(CountsLog.this.f48453a + ", timecount is low, count " + CountsLog.this.f48454b + "/ceil " + CountsLog.this.f48455c + "/floor " + CountsLog.this.f48456d + "/period 60s");
                }
                int unused = CountsLog.this.f48454b = 0;
            }
        }, 60000, 60000);
    }

    public void cancelTimer() {
        Timer timer = this.f48457e;
        if (timer != null) {
            timer.cancel();
            this.f48457e = null;
        }
    }

    public void count() {
        this.f48454b++;
    }
}
