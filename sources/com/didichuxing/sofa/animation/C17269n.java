package com.didichuxing.sofa.animation;

import android.view.View;
import com.didichuxing.sofa.animation.Animator;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didichuxing.sofa.animation.n */
/* compiled from: FakeAnimator */
class C17269n extends Animator {

    /* renamed from: a */
    private static final String f51674a = "FakeAnimator";

    /* renamed from: b */
    private List<C17273s> f51675b = new ArrayList();

    /* renamed from: c */
    private boolean f51676c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f51677d = false;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo127538a() {
    }

    public void stop() {
    }

    C17269n() {
    }

    /* renamed from: a */
    private C17275u[] m38793a(List<C17257b> list) {
        int size = list.size();
        C17275u[] uVarArr = new C17275u[size];
        for (int i = 0; i < size; i++) {
            float[] b = list.get(i).mo127628b();
            uVarArr[i] = C17275u.m38832a(list.get(i).mo127627a(), b[b.length - 1]);
        }
        return uVarArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m38794d() {
        this.f51676c = true;
        AnimatorListener c = mo127630c();
        if (c != null) {
            c.onAnimationStart(this, (View) null);
        }
        for (C17273s next : this.f51675b) {
            AnimatorListener c2 = next.mo127630c();
            if (c2 != null) {
                c2.onAnimationStart(this, next.mo127649b());
            }
            View b = next.mo127649b();
            if (b != null) {
                m38790a(b, m38793a(next.mo127644a()));
                b.setVisibility(0);
                if (c2 != null) {
                    c2.onAnimationEnd(this, next.mo127649b());
                }
            }
        }
        if (c != null) {
            c.onAnimationEnd(this, (View) null);
        }
        this.f51676c = false;
    }

    /* renamed from: a */
    private void m38790a(View view, C17275u[] uVarArr) {
        for (C17275u uVar : uVarArr) {
            String a = uVar.mo127667a();
            char c = 65535;
            switch (a.hashCode()) {
                case -1225497657:
                    if (a.equals("translationX")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1225497656:
                    if (a.equals("translationY")) {
                        c = 3;
                        break;
                    }
                    break;
                case -908189618:
                    if (a.equals("scaleX")) {
                        c = 5;
                        break;
                    }
                    break;
                case -908189617:
                    if (a.equals("scaleY")) {
                        c = 6;
                        break;
                    }
                    break;
                case -40300674:
                    if (a.equals("rotation")) {
                        c = 4;
                        break;
                    }
                    break;
                case 88:
                    if (a.equals(C17272q.f51679a)) {
                        c = 0;
                        break;
                    }
                    break;
                case 89:
                    if (a.equals(C17272q.f51680b)) {
                        c = 1;
                        break;
                    }
                    break;
                case 92909918:
                    if (a.equals("alpha")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    view.setX(uVar.mo127668b());
                    break;
                case 1:
                    view.setY(uVar.mo127668b());
                    break;
                case 2:
                    view.setTranslationX(uVar.mo127668b());
                    break;
                case 3:
                    view.setTranslationY(uVar.mo127668b());
                    break;
                case 4:
                    view.setRotation(uVar.mo127668b());
                    break;
                case 5:
                    view.setScaleX(uVar.mo127668b());
                    break;
                case 6:
                    view.setScaleY(uVar.mo127668b());
                    break;
                case 7:
                    view.setAlpha(uVar.mo127668b());
                    break;
                default:
                    C17271p.m38805a(view, uVar.mo127667a(), uVar.mo127668b());
                    break;
            }
        }
    }

    /* renamed from: a */
    public void mo127540a(C17273s sVar) {
        this.f51675b.add(sVar);
    }

    /* renamed from: b */
    public void mo127542b(C17273s sVar) {
        this.f51675b.add(sVar);
    }

    /* renamed from: c */
    public void mo127544c(C17273s sVar) {
        this.f51675b.add(sVar);
    }

    /* renamed from: d */
    public void mo127545d(C17273s sVar) {
        this.f51675b.add(sVar);
    }

    public Animator start() {
        this.f51677d = true;
        mo127539a((Animator.PrepareAnimationCallback) new FakeAnimator$1(this));
        return this;
    }

    public boolean isRunning() {
        return this.f51676c;
    }

    public boolean isStarted() {
        return this.f51677d;
    }

    /* renamed from: e */
    private List<C17273s> m38795e() {
        return this.f51675b;
    }

    /* renamed from: a */
    private List<C17273s> m38789a(Animator[] animatorArr) {
        ArrayList arrayList = new ArrayList();
        int length = animatorArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            C17269n nVar = animatorArr[i];
            if (!(nVar instanceof C17269n)) {
                LoggerUtil.m38758e(f51674a, "collectAnimations: unsupported Animator type: " + nVar.getClass().getSimpleName());
                break;
            }
            arrayList.addAll(nVar.m38795e());
            i++;
        }
        return arrayList;
    }

    public Animator playTogether(Animator... animatorArr) {
        this.f51675b.clear();
        this.f51675b.addAll(m38789a(animatorArr));
        return this;
    }

    public Animator playSequentially(Animator... animatorArr) {
        return playTogether(animatorArr);
    }
}
