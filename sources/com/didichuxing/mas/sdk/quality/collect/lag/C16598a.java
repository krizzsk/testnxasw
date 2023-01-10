package com.didichuxing.mas.sdk.quality.collect.lag;

import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.didichuxing.mas.sdk.quality.collect.lag.a */
/* compiled from: AbstractSampler */
abstract class C16598a {

    /* renamed from: c */
    private static final int f50687c = 300;

    /* renamed from: a */
    protected AtomicBoolean f50688a = new AtomicBoolean(false);

    /* renamed from: b */
    protected long f50689b;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Runnable f50690d = new AbstractSampler$1(this);

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract void mo124923c();

    public C16598a(long j) {
        this.f50689b = 0 == j ? 300 : j;
    }

    /* renamed from: a */
    public void mo124921a() {
        if (!this.f50688a.get()) {
            this.f50688a.set(true);
            HandlerThreadFactory.getTimerThreadHandler().removeCallbacks(this.f50690d);
            HandlerThreadFactory.getTimerThreadHandler().postDelayed(this.f50690d, BlockCanaryInternals.m37753a().mo124912b());
        }
    }

    /* renamed from: b */
    public void mo124922b() {
        if (this.f50688a.get()) {
            this.f50688a.set(false);
            HandlerThreadFactory.getTimerThreadHandler().removeCallbacks(this.f50690d);
        }
    }
}
