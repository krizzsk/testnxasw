package com.didi.unifylogin.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.unifylogin.utils.KeyboardHelper;
import com.didi.unifylogin.utils.customview.AbsLoginTitleBar;
import com.taxis99.R;

/* renamed from: com.didi.unifylogin.presenter.a */
/* compiled from: ViewAnimatorHelper */
final class C15457a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AbsLoginTitleBar f47505a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final View f47506b;

    /* renamed from: c */
    private final ImageView f47507c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final View f47508d;

    /* renamed from: e */
    private final TextView f47509e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final TextView f47510f;

    /* renamed from: g */
    private final View f47511g;

    /* renamed from: h */
    private final View f47512h;

    /* renamed from: i */
    private final View f47513i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final View f47514j;

    /* renamed from: k */
    private final View f47515k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final View f47516l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final View f47517m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final View f47518n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final View f47519o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public final EditText f47520p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public final View f47521q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final View f47522r;

    /* renamed from: s */
    private AnimatorSet f47523s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public AnimatorSet f47524t;

    C15457a(View view, AbsLoginTitleBar absLoginTitleBar) {
        this.f47505a = absLoginTitleBar;
        this.f47506b = view.findViewById(R.id.ll_scene_pre_container);
        this.f47507c = (ImageView) view.findViewById(R.id.iv_login_pre_bg);
        this.f47508d = view.findViewById(R.id.login_unify_fragment_phone_container);
        this.f47509e = (TextView) view.findViewById(R.id.tv_pre_phone_title);
        this.f47511g = view.findViewById(R.id.fl_pre_phone_container);
        this.f47512h = view.findViewById(R.id.v_pre_line);
        this.f47513i = view.findViewById(R.id.gv_third_party2);
        this.f47514j = view.findViewById(R.id.rl_third_party_hint);
        this.f47515k = view.findViewById(R.id.ll_law2);
        this.f47516l = view.findViewById(R.id.tv_title);
        this.f47517m = view.findViewById(R.id.tv_sub_title);
        this.f47518n = view.findViewById(R.id.rl_phone_container);
        this.f47521q = view.findViewById(R.id.btn_next);
        this.f47520p = (EditText) view.findViewById(R.id.et_phone);
        this.f47519o = view.findViewById(R.id.v_line);
        this.f47522r = view.findViewById(R.id.iv_clear_phone);
        this.f47510f = (TextView) view.findViewById(R.id.et_phone2);
        m35663c();
        m35665d();
    }

    /* renamed from: c */
    private void m35663c() {
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 0.5f}).setDuration(200);
        duration.addUpdateListener(new ViewAnimatorHelper$1(this));
        duration.addListener(new ViewAnimatorHelper$2(this));
        duration.setInterpolator(new LinearInterpolator());
        ValueAnimator duration2 = ValueAnimator.ofFloat(new float[]{0.5f, 1.0f}).setDuration(200);
        duration2.addUpdateListener(new ViewAnimatorHelper$3(this));
        duration2.addListener(new ViewAnimatorHelper$4(this));
        duration2.setInterpolator(new LinearInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        this.f47523s = animatorSet;
        animatorSet.setInterpolator(new LinearInterpolator());
        this.f47523s.playSequentially(new Animator[]{duration, duration2});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo119373a() {
        this.f47523s.start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo119374b() {
        this.f47520p.clearFocus();
        KeyboardHelper.hideInputMethod(this.f47520p.getContext(), this.f47520p);
        this.f47506b.postDelayed(new ViewAnimatorHelper$5(this), 50);
    }

    /* renamed from: d */
    private void m35665d() {
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{1.0f, 0.5f}).setDuration(200);
        duration.addUpdateListener(new ViewAnimatorHelper$6(this));
        duration.addListener(new ViewAnimatorHelper$7(this));
        duration.setInterpolator(new LinearInterpolator());
        ValueAnimator duration2 = ValueAnimator.ofFloat(new float[]{0.5f, 0.0f}).setDuration(200);
        duration2.addUpdateListener(new ViewAnimatorHelper$8(this));
        duration2.setInterpolator(new LinearInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        this.f47524t = animatorSet;
        animatorSet.setInterpolator(new LinearInterpolator());
        this.f47524t.playSequentially(new Animator[]{duration, duration2});
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35659a(float f) {
        float f2 = 0.0f;
        if (f <= 0.5f) {
            this.f47506b.setTranslationY(((float) (-this.f47507c.getHeight())) * f * 2.0f);
            float f3 = 1.0f - (f * 2.0f);
            if (f3 >= 0.0f) {
                f2 = f3;
            }
            this.f47509e.setAlpha(f2);
            this.f47511g.setAlpha(f2);
            this.f47512h.setAlpha(f2);
            this.f47513i.setAlpha(f2);
            this.f47515k.setAlpha(f2);
            return;
        }
        float f4 = (f - 0.5f) * 2.0f;
        if (f4 >= 0.0f) {
            f2 = f4;
        }
        this.f47516l.setAlpha(f2);
        this.f47519o.setAlpha(f2);
        this.f47517m.setAlpha(f2);
        this.f47518n.setAlpha(f2);
        this.f47521q.setAlpha(f2);
        this.f47522r.setAlpha(f2);
    }
}
