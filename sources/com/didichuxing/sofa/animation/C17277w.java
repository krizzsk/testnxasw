package com.didichuxing.sofa.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import com.didichuxing.sofa.animation.Animator;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didichuxing.sofa.animation.w */
/* compiled from: ViewAnimator */
class C17277w extends Animator {

    /* renamed from: a */
    private static final String f51703a = "ViewAnimator";

    /* renamed from: b */
    private AnimatorSet f51704b;

    /* renamed from: c */
    private C17273s f51705c;

    /* renamed from: d */
    private List<C17273s> f51706d = new ArrayList();

    /* renamed from: e */
    private List<C17273s> f51707e = new ArrayList();

    /* renamed from: f */
    private List<C17273s> f51708f = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f51709g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f51710h = false;

    C17277w() {
    }

    /* renamed from: a */
    private PropertyValuesHolder[] m38849a(List<C17257b> list) {
        int size = list.size();
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[size];
        for (int i = 0; i < size; i++) {
            propertyValuesHolderArr[i] = PropertyValuesHolder.ofFloat(list.get(i).mo127627a(), list.get(i).mo127628b());
        }
        return propertyValuesHolderArr;
    }

    /* renamed from: e */
    private Animator m38854e(C17273s sVar) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(sVar.mo127649b(), m38849a(sVar.mo127644a()));
        ofPropertyValuesHolder.setDuration((long) sVar.mo127654d());
        ofPropertyValuesHolder.setInterpolator(sVar.mo127660g());
        ofPropertyValuesHolder.setRepeatCount(sVar.mo127658f());
        ofPropertyValuesHolder.setRepeatMode(sVar.mo127656e());
        ofPropertyValuesHolder.setStartDelay(sVar.mo127662h());
        TypeEvaluator i = sVar.mo127664i();
        if (sVar.mo127664i() instanceof C17263h) {
            ((C17263h) sVar.mo127664i()).mo127638a((float) sVar.mo127654d());
        }
        ofPropertyValuesHolder.setEvaluator(i);
        ofPropertyValuesHolder.addListener(new ViewAnimator$1(this, sVar));
        if (sVar.mo127630c() != null) {
            ofPropertyValuesHolder.addListener(new C17259d(this, sVar, sVar.mo127630c()));
        }
        return ofPropertyValuesHolder;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m38853d() {
        this.f51704b = new AnimatorSet();
        m38847a("createAnimation mPlayViewBuilder: " + this.f51705c + " mWithViewBuilders: " + this.f51706d + " mAfterViewBuilders: " + this.f51708f);
        C17273s sVar = this.f51705c;
        if (sVar != null) {
            AnimatorSet.Builder play = this.f51704b.play(m38854e(sVar));
            if (!this.f51706d.isEmpty()) {
                for (C17273s e : this.f51706d) {
                    play.with(m38854e(e));
                }
            }
            if (!this.f51707e.isEmpty()) {
                for (C17273s e2 : this.f51707e) {
                    play.before(m38854e(e2));
                }
            }
            if (!this.f51708f.isEmpty()) {
                for (C17273s e3 : this.f51708f) {
                    play.after(m38854e(e3));
                }
            }
        }
        if (mo127630c() != null) {
            this.f51704b.addListener(new C17261f(this, mo127630c()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m38855e() {
        LoggerUtil.m38757d(f51703a, "startAnimation mAnimatorSet: " + this.f51704b);
        if (this.f51704b.isStarted()) {
            this.f51704b.end();
        }
        this.f51704b.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m38847a(String str) {
        LoggerUtil.m38757d(f51703a, str);
    }

    /* renamed from: a */
    public void mo127540a(C17273s sVar) {
        this.f51705c = sVar;
    }

    /* renamed from: b */
    public void mo127542b(C17273s sVar) {
        this.f51706d.add(sVar);
    }

    /* renamed from: c */
    public void mo127544c(C17273s sVar) {
        this.f51707e.add(sVar);
    }

    /* renamed from: d */
    public void mo127545d(C17273s sVar) {
        this.f51708f.add(sVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo127538a() {
        if (this.f51704b != null) {
            m38847a("Please do not build animator repeatedly!");
        } else {
            mo127539a((Animator.PrepareAnimationCallback) new ViewAnimator$2(this));
        }
    }

    public Animator start() {
        m38847a("start mPrepared: " + this.f51709g);
        if (this.f51709g) {
            m38855e();
        } else {
            this.f51710h = true;
        }
        return this;
    }

    public void stop() {
        StringBuilder sb = new StringBuilder();
        sb.append("stop mAnimatorSet: ");
        sb.append(this.f51704b);
        sb.append(" isStarted: ");
        AnimatorSet animatorSet = this.f51704b;
        boolean z = true;
        sb.append(animatorSet != null && animatorSet.isStarted());
        sb.append(" isRunning: ");
        AnimatorSet animatorSet2 = this.f51704b;
        if (animatorSet2 == null || !animatorSet2.isRunning()) {
            z = false;
        }
        sb.append(z);
        m38847a(sb.toString());
        AnimatorSet animatorSet3 = this.f51704b;
        if (animatorSet3 == null) {
            LoggerUtil.m38758e(f51703a, "Stop: this animator has not built yet!");
        } else {
            animatorSet3.end();
        }
    }

    public boolean isRunning() {
        AnimatorSet animatorSet = this.f51704b;
        return animatorSet != null && animatorSet.isRunning();
    }

    public boolean isStarted() {
        AnimatorSet animatorSet = this.f51704b;
        return animatorSet != null && animatorSet.isStarted();
    }

    /* renamed from: f */
    private AnimatorSet m38856f() {
        return this.f51704b;
    }

    /* renamed from: a */
    private List<android.animation.Animator> m38844a(Animator... animatorArr) {
        ArrayList arrayList = new ArrayList();
        for (C17277w wVar : animatorArr) {
            if (wVar instanceof C17277w) {
                arrayList.add(wVar.m38856f());
            } else {
                LoggerUtil.m38758e(f51703a, "collectAnimators: unsupported Animator type: " + wVar.getClass().getSimpleName());
            }
        }
        return arrayList;
    }

    public Animator playTogether(Animator... animatorArr) {
        AnimatorSet animatorSet = new AnimatorSet();
        this.f51704b = animatorSet;
        animatorSet.playTogether(m38844a(animatorArr));
        this.f51709g = true;
        return this;
    }

    public Animator playSequentially(Animator... animatorArr) {
        AnimatorSet animatorSet = new AnimatorSet();
        this.f51704b = animatorSet;
        animatorSet.playSequentially(m38844a(animatorArr));
        this.f51709g = true;
        return this;
    }
}
