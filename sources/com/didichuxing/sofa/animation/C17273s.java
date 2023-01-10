package com.didichuxing.sofa.animation;

import android.animation.TypeEvaluator;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didichuxing.sofa.animation.s */
/* compiled from: PropertyBuilder */
class C17273s extends C17258c {

    /* renamed from: a */
    private final int f51687a = 1000;

    /* renamed from: b */
    private final long f51688b = 0;

    /* renamed from: c */
    private WeakReference<View> f51689c;

    /* renamed from: d */
    private List<C17257b> f51690d = new ArrayList();

    /* renamed from: e */
    private int f51691e = 1000;

    /* renamed from: f */
    private int f51692f = 0;

    /* renamed from: g */
    private int f51693g = 1;

    /* renamed from: h */
    private Interpolator f51694h = new LinearInterpolator();

    /* renamed from: i */
    private long f51695i = 0;

    /* renamed from: j */
    private TypeEvaluator f51696j;

    C17273s(View view) {
        WeakReference<View> weakReference = null;
        this.f51696j = null;
        this.f51689c = view != null ? new WeakReference<>(view) : weakReference;
    }

    /* renamed from: b */
    private void m38806b(String str, float... fArr) {
        this.f51690d.add(C17257b.m38761a(str, fArr));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C17273s mo127643a(float... fArr) {
        m38806b(C17272q.f51679a, fArr);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C17273s mo127650b(float... fArr) {
        m38806b(C17272q.f51680b, fArr);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C17273s mo127652c(float... fArr) {
        m38806b("translationX", fArr);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C17273s mo127655d(float... fArr) {
        m38806b("translationY", fArr);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public C17273s mo127657e(float... fArr) {
        m38806b("rotation", fArr);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public C17273s mo127659f(float... fArr) {
        m38806b("scaleX", fArr);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public C17273s mo127661g(float... fArr) {
        m38806b("scaleY", fArr);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public C17273s mo127663h(float... fArr) {
        m38806b("alpha", fArr);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C17273s mo127642a(String str, float... fArr) {
        m38806b(str, fArr);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<C17257b> mo127644a() {
        return this.f51690d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public View mo127649b() {
        WeakReference<View> weakReference = this.f51689c;
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo127654d() {
        return this.f51691e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo127645a(int i) {
        if (i <= 0) {
            this.f51691e = 1000;
        } else {
            this.f51691e = i;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo127656e() {
        return this.f51693g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo127651b(int i) {
        this.f51693g = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo127658f() {
        return this.f51692f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo127653c(int i) {
        this.f51692f = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public Interpolator mo127660g() {
        return this.f51694h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo127648a(Interpolator interpolator) {
        this.f51694h = interpolator;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public long mo127662h() {
        return this.f51695i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo127646a(long j) {
        if (j < 0) {
            this.f51695i = 0;
        } else {
            this.f51695i = j;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public TypeEvaluator mo127664i() {
        return this.f51696j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo127647a(TypeEvaluator typeEvaluator) {
        this.f51696j = typeEvaluator;
    }
}
