package com.didichuxing.sofa.animation;

import android.animation.TypeEvaluator;
import android.view.View;
import android.view.animation.Interpolator;

public abstract class AnimatorBuilder implements C17260e, C17265j<AnimatorBuilder>, C17267l<AnimatorBuilder> {

    /* renamed from: a */
    C17273s f51644a;

    /* renamed from: b */
    Animator f51645b;

    public abstract AnimatorBuilder accelerate();

    public abstract AnimatorBuilder accelerateDecelerate();

    public abstract AnimatorBuilder anticipate();

    public abstract AnimatorBuilder anticipateOvershoot();

    public abstract AnimatorBuilder bounce();

    public abstract AnimatorBuilder decelerate();

    public abstract AnimatorBuilder duration(int i);

    public abstract AnimatorBuilder evaluator(TypeEvaluator typeEvaluator);

    public abstract AnimatorBuilder interpolator(Interpolator interpolator);

    public abstract AnimatorBuilder overshoot();

    public abstract AnimatorBuilder repeatCount(int i);

    public abstract AnimatorBuilder repeatInfinite();

    public abstract AnimatorBuilder repeatRestart();

    public abstract AnimatorBuilder repeatReverse();

    public abstract AnimatorBuilder startDelay(long j);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C17273s mo127553a(View view) {
        return new C17273s(view);
    }

    public AnimatorBuilder play(View view) {
        C17273s a = mo127553a(view);
        this.f51645b.mo127540a(a);
        this.f51644a = a;
        return this;
    }

    public AnimatorBuilder with(View view) {
        C17273s a = mo127553a(view);
        this.f51645b.mo127542b(a);
        this.f51644a = a;
        return this;
    }

    public AnimatorBuilder before(View view) {
        C17273s a = mo127553a(view);
        this.f51645b.mo127544c(a);
        this.f51644a = a;
        return this;
    }

    public AnimatorBuilder after(View view) {
        C17273s a = mo127553a(view);
        this.f51645b.mo127545d(a);
        this.f51644a = a;
        return this;
    }

    /* renamed from: x */
    public AnimatorBuilder mo127597x(float... fArr) {
        this.f51644a.mo127643a(fArr);
        return this;
    }

    /* renamed from: y */
    public AnimatorBuilder mo127598y(float... fArr) {
        this.f51644a.mo127650b(fArr);
        return this;
    }

    public AnimatorBuilder translateX(float... fArr) {
        this.f51644a.mo127652c(fArr);
        return this;
    }

    public AnimatorBuilder translateY(float... fArr) {
        this.f51644a.mo127655d(fArr);
        return this;
    }

    public AnimatorBuilder rotate(float... fArr) {
        this.f51644a.mo127657e(fArr);
        return this;
    }

    public AnimatorBuilder scale(float... fArr) {
        this.f51644a.mo127659f(fArr);
        this.f51644a.mo127661g(fArr);
        return this;
    }

    public AnimatorBuilder scaleX(float... fArr) {
        this.f51644a.mo127659f(fArr);
        return this;
    }

    public AnimatorBuilder scaleY(float... fArr) {
        this.f51644a.mo127661g(fArr);
        return this;
    }

    public AnimatorBuilder alpha(float... fArr) {
        this.f51644a.mo127663h(fArr);
        return this;
    }

    public AnimatorBuilder property(String str, float... fArr) {
        this.f51644a.mo127642a(str, fArr);
        return this;
    }

    public AnimatorBuilder withListener(AnimatorListener animatorListener) {
        this.f51644a.mo127629a(animatorListener);
        return this;
    }

    public Animator build() {
        this.f51645b.mo127538a();
        return this.f51645b;
    }

    public Animator buildWithListener(AnimatorListener animatorListener) {
        this.f51645b.mo127629a(animatorListener);
        return build();
    }

    public View getTarget() {
        return this.f51644a.mo127649b();
    }

    public AnimatorBuilder fadeIn() {
        return C17266k.m38770a(this);
    }

    public AnimatorBuilder fadeOut() {
        return C17266k.m38772b(this);
    }

    public AnimatorBuilder translateInFromTop() {
        return C17266k.m38774c(this);
    }

    public AnimatorBuilder translateOutToTop() {
        return C17266k.m38776d(this);
    }

    public AnimatorBuilder translateInFromBottom() {
        return C17266k.m38778e(this);
    }

    public AnimatorBuilder translateOutToBottom() {
        return C17266k.m38780f(this);
    }

    public AnimatorBuilder scaleIn() {
        return C17266k.m38782g(this);
    }

    public AnimatorBuilder scaleOut() {
        return C17266k.m38784h(this);
    }

    public AnimatorBuilder rotateCW() {
        return C17266k.m38786i(this);
    }

    public AnimatorBuilder rotateCCW() {
        return C17266k.m38787j(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AnimatorBuilder mo127552a(Runnable runnable) {
        this.f51645b.mo127541a(new C17274t(this.f51644a.mo127649b(), runnable));
        return this;
    }

    public Animator playTogether(Animator... animatorArr) {
        return this.f51645b.playTogether(animatorArr);
    }

    public Animator playSequentially(Animator... animatorArr) {
        return this.f51645b.playSequentially(animatorArr);
    }
}
