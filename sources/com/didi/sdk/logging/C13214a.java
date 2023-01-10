package com.didi.sdk.logging;

import java.io.File;
import java.util.Date;

/* renamed from: com.didi.sdk.logging.a */
/* compiled from: AbstractRollingPolicy */
abstract class C13214a {

    /* renamed from: a */
    protected Date f39285a = new Date();

    /* renamed from: a */
    public abstract void mo99013a();

    /* renamed from: a */
    public abstract boolean mo99015a(File file);

    /* renamed from: b */
    public abstract String mo99016b();

    /* renamed from: c */
    public abstract File mo99017c();

    C13214a() {
    }

    /* renamed from: a */
    public void mo99014a(long j) {
        this.f39285a.setTime(j);
    }
}
