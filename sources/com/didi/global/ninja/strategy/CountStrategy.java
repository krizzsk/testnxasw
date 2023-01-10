package com.didi.global.ninja.strategy;

import android.content.Context;
import com.didi.global.ninja.Ninja;
import com.didi.global.ninja.utils.SharedPreferencesUtils;
import com.didi.global.ninja.utils.TrackEvent;
import com.didi.sdk.apm.SystemUtils;

public class CountStrategy implements IStrategy {

    /* renamed from: a */
    private Context f24786a;

    /* renamed from: b */
    private String f24787b;

    /* renamed from: c */
    private int f24788c = 1;

    /* renamed from: d */
    private long f24789d = 86400;

    /* renamed from: e */
    private int f24790e = 0;

    /* renamed from: f */
    private long f24791f = 0;

    /* renamed from: g */
    private boolean f24792g = false;

    /* renamed from: h */
    private boolean f24793h = false;

    /* renamed from: i */
    private boolean f24794i = false;

    public CountStrategy(String str) {
        this.f24787b = str;
    }

    public CountStrategy(String str, int i, long j) {
        this.f24787b = str;
        this.f24788c = i;
        this.f24789d = j;
    }

    public synchronized boolean isHit() {
        if (this.f24793h) {
            return this.f24794i;
        }
        boolean hitStatus = getHitStatus();
        this.f24794i = hitStatus;
        this.f24793h = true;
        return hitStatus;
    }

    public synchronized void filter() {
        int i = this.f24790e + 1;
        this.f24790e = i;
        m19874a(i);
    }

    public synchronized boolean init() {
        if (!this.f24792g) {
            this.f24790e = m19877b();
            this.f24791f = m19878c();
            SystemUtils.log(4, Ninja.TAG, ">>>>>>recordCount>>>>>" + this.f24790e, (Throwable) null, "com.didi.global.ninja.strategy.CountStrategy", 58);
            SystemUtils.log(4, Ninja.TAG, ">>>>>>recordTime>>>>>" + this.f24791f, (Throwable) null, "com.didi.global.ninja.strategy.CountStrategy", 59);
            this.f24792g = true;
        }
        return this.f24792g;
    }

    public String getName() {
        return this.f24787b;
    }

    public void setContext(Context context) {
        this.f24786a = context;
    }

    /* renamed from: a */
    private boolean m19876a() {
        return (System.currentTimeMillis() / 1000) - this.f24791f < this.f24789d;
    }

    public boolean getHitStatus() {
        boolean z = false;
        if (this.f24790e >= this.f24788c) {
            if (this.f24791f == 0) {
                m19875a(System.currentTimeMillis() / 1000);
            } else if (!m19876a()) {
                m19874a(0);
                m19875a(0);
                TrackEvent.trackResume(this.f24787b);
            }
            z = true;
        }
        if (z) {
            TrackEvent.trackHit(this.f24787b, true);
        }
        return z;
    }

    /* renamed from: a */
    private void m19874a(int i) {
        this.f24790e = i;
        SharedPreferencesUtils.getInstance(this.f24786a).writeSPInt(m19879d(), this.f24790e);
    }

    /* renamed from: b */
    private int m19877b() {
        return SharedPreferencesUtils.getInstance(this.f24786a).readSPInt(m19879d(), 0);
    }

    /* renamed from: a */
    private void m19875a(long j) {
        this.f24791f = j;
        SharedPreferencesUtils.getInstance(this.f24786a).writeSPLong(m19880e(), this.f24791f);
    }

    /* renamed from: c */
    private long m19878c() {
        return SharedPreferencesUtils.getInstance(this.f24786a).readSPLong(m19880e(), 0);
    }

    /* renamed from: d */
    private String m19879d() {
        return "count_" + this.f24787b;
    }

    /* renamed from: e */
    private String m19880e() {
        return "time_" + this.f24787b;
    }
}
