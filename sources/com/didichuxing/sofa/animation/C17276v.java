package com.didichuxing.sofa.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didichuxing.sofa.animation.v */
/* compiled from: ValueAnimator */
class C17276v extends Animator {

    /* renamed from: a */
    private static final String f51701a = "ValueAnimator";

    /* renamed from: b */
    private AnimatorSet f51702b;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo127538a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo127540a(C17273s sVar) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo127542b(C17273s sVar) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo127544c(C17273s sVar) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo127545d(C17273s sVar) {
    }

    C17276v() {
    }

    /* renamed from: d */
    private AnimatorSet m38837d() {
        return this.f51702b;
    }

    /* renamed from: a */
    private List<Animator> m38835a(Animator... animatorArr) {
        ArrayList arrayList = new ArrayList();
        for (C17276v vVar : animatorArr) {
            if (vVar instanceof C17276v) {
                arrayList.add(vVar.m38837d());
            } else {
                LoggerUtil.m38758e(f51701a, "collectAnimators: unsupported Animator type: " + vVar.getClass().getSimpleName());
            }
        }
        return arrayList;
    }

    public Animator playTogether(Animator... animatorArr) {
        AnimatorSet animatorSet = new AnimatorSet();
        this.f51702b = animatorSet;
        animatorSet.playTogether(m38835a(animatorArr));
        return this;
    }

    public Animator playSequentially(Animator... animatorArr) {
        AnimatorSet animatorSet = new AnimatorSet();
        this.f51702b = animatorSet;
        animatorSet.playSequentially(m38835a(animatorArr));
        return this;
    }

    public Animator start() {
        this.f51702b.start();
        return this;
    }

    public void stop() {
        this.f51702b.end();
    }

    public boolean isRunning() {
        AnimatorSet animatorSet = this.f51702b;
        return animatorSet != null && animatorSet.isRunning();
    }

    public boolean isStarted() {
        AnimatorSet animatorSet = this.f51702b;
        return animatorSet != null && animatorSet.isStarted();
    }

    /* renamed from: a */
    public void mo127669a(ValueAnimatorBuilder valueAnimatorBuilder) {
        if (this.f51702b != null) {
            LoggerUtil.m38757d(f51701a, "Please do not build animator repeatedly!");
            return;
        }
        this.f51702b = new AnimatorSet();
        this.f51702b.play(m38836b(valueAnimatorBuilder));
    }

    /* renamed from: b */
    private ValueAnimator m38836b(ValueAnimatorBuilder valueAnimatorBuilder) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(valueAnimatorBuilder.f51647a);
        ofFloat.setDuration((long) valueAnimatorBuilder.f51648b);
        ofFloat.setRepeatCount(valueAnimatorBuilder.f51649c);
        ofFloat.setRepeatMode(valueAnimatorBuilder.f51650d);
        ofFloat.setStartDelay(valueAnimatorBuilder.f51652f);
        ofFloat.setInterpolator(valueAnimatorBuilder.f51651e);
        ofFloat.setEvaluator(valueAnimatorBuilder.f51653g);
        for (AnimatorUpdateListener gVar : valueAnimatorBuilder.f51654h) {
            ofFloat.addUpdateListener(new C17262g(this, gVar));
        }
        ofFloat.addListener(new ValueAnimator$1(this, ofFloat));
        return ofFloat;
    }
}
