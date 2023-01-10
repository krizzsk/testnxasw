package com.didi.beatles.p101im.utils;

import java.lang.ref.SoftReference;

/* renamed from: com.didi.beatles.im.utils.IMStringBuilder */
public final class IMStringBuilder {

    /* renamed from: b */
    private static final int f11629b = 256;

    /* renamed from: c */
    private static final ThreadLocal<SoftReference<IMStringBuilder>> f11630c = new ThreadLocal<SoftReference<IMStringBuilder>>() {
        /* access modifiers changed from: protected */
        public SoftReference<IMStringBuilder> initialValue() {
            return new SoftReference<>(new IMStringBuilder());
        }
    };

    /* renamed from: a */
    private StringBuilder f11631a;

    private IMStringBuilder() {
        this.f11631a = new StringBuilder(256);
    }

    /* renamed from: of */
    public static IMStringBuilder m10035of() {
        IMStringBuilder iMStringBuilder;
        SoftReference softReference = f11630c.get();
        if (softReference != null && (iMStringBuilder = (IMStringBuilder) softReference.get()) != null) {
            return iMStringBuilder;
        }
        IMStringBuilder iMStringBuilder2 = new IMStringBuilder();
        SoftReference softReference2 = new SoftReference(iMStringBuilder2);
        f11630c.set(softReference2);
        if (softReference2.get() == null) {
            IMLog.m10021e("new BtsStringBuilder from softReference is null.", new Object[0]);
        }
        return iMStringBuilder2;
    }

    public IMStringBuilder append(String str) {
        this.f11631a.append(str);
        return this;
    }

    public IMStringBuilder append(Object obj) {
        this.f11631a.append(obj);
        return this;
    }

    public IMStringBuilder append(boolean z) {
        this.f11631a.append(z);
        return this;
    }

    public IMStringBuilder append(char c) {
        this.f11631a.append(c);
        return this;
    }

    public IMStringBuilder append(char[] cArr) {
        this.f11631a.append(cArr);
        return this;
    }

    public IMStringBuilder append(int i) {
        this.f11631a.append(i);
        return this;
    }

    public IMStringBuilder append(long j) {
        this.f11631a.append(j);
        return this;
    }

    public IMStringBuilder append(double d) {
        this.f11631a.append(d);
        return this;
    }

    public IMStringBuilder append(float f) {
        this.f11631a.append(f);
        return this;
    }

    public IMStringBuilder append(CharSequence charSequence) {
        this.f11631a.append(charSequence);
        return this;
    }

    public IMStringBuilder appendAll(Object... objArr) {
        if (objArr == null) {
            return this;
        }
        for (Object append : objArr) {
            this.f11631a.append(append);
        }
        return this;
    }

    public int length() {
        return this.f11631a.length();
    }

    public String toString() {
        String sb = this.f11631a.toString();
        m10034a();
        return sb;
    }

    /* renamed from: a */
    private void m10034a() {
        this.f11631a.setLength(0);
    }

    public void clear() {
        f11630c.remove();
    }
}
