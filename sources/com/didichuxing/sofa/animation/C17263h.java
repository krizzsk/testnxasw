package com.didichuxing.sofa.animation;

import android.animation.TypeEvaluator;

/* renamed from: com.didichuxing.sofa.animation.h */
/* compiled from: BaseEasingMethod */
abstract class C17263h implements TypeEvaluator<Number> {

    /* renamed from: a */
    private float f51670a;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Float mo127636a(float f, float f2, float f3, float f4);

    C17263h(float f) {
        this.f51670a = f;
    }

    /* renamed from: a */
    public void mo127638a(float f) {
        this.f51670a = f;
    }

    /* renamed from: a */
    public final Float evaluate(float f, Number number, Number number2) {
        return mo127636a(this.f51670a * f, number.floatValue(), number2.floatValue() - number.floatValue(), this.f51670a);
    }
}
