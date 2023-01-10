package com.didi.rfusion.widget.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.didi.rfusion.material.animation.RFAnimationUtils;
import com.didi.rfusion.material.internal.RFCheckableIconButton;
import com.didi.rfusion.widget.textfield.RFTextInputLayout;

/* renamed from: com.didi.rfusion.widget.textfield.a */
/* compiled from: RFClearTextEndIconDelegate */
class C12401a extends C12402b {

    /* renamed from: c */
    private static final int f36638c = 100;

    /* renamed from: d */
    private static final int f36639d = 150;

    /* renamed from: e */
    private static final float f36640e = 0.8f;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final TextWatcher f36641f = new RFClearTextEndIconDelegate$1(this);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final View.OnFocusChangeListener f36642g = new RFClearTextEndIconDelegate$2(this);

    /* renamed from: h */
    private final RFTextInputLayout.OnEditTextAttachedListener f36643h = new RFClearTextEndIconDelegate$3(this);

    /* renamed from: i */
    private AnimatorSet f36644i;

    /* renamed from: j */
    private ValueAnimator f36645j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public RFCheckableIconButton f36646k;

    C12401a(RFTextInputLayout rFTextInputLayout) {
        super(rFTextInputLayout);
        this.f36646k = rFTextInputLayout.getClearIcon();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94806a() {
        this.f36647a.setClearIconOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                C12401a.this.m27601a(view);
            }
        });
        this.f36647a.addOnEditTextAttachedListener(this.f36643h);
        m27608c();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27601a(View view) {
        Editable text = this.f36647a.getEditText().getText();
        if (text != null) {
            text.clear();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo94807b() {
        EditText editText = this.f36647a.getEditText();
        if (editText != null) {
            editText.post(new RFClearTextEndIconDelegate$4(this, editText));
            if (editText.getOnFocusChangeListener() == this.f36642g) {
                editText.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27603a(boolean z) {
        boolean z2 = this.f36647a.isEnableClearText() == z;
        if (z && !this.f36644i.isRunning()) {
            this.f36645j.cancel();
            this.f36644i.start();
            if (z2) {
                this.f36644i.end();
            }
        } else if (!z) {
            this.f36644i.cancel();
            this.f36645j.start();
            if (z2) {
                this.f36645j.end();
            }
        }
    }

    /* renamed from: c */
    private void m27608c() {
        ValueAnimator d = m27609d();
        ValueAnimator a = m27599a(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f36644i = animatorSet;
        animatorSet.playTogether(new Animator[]{d, a});
        this.f36644i.addListener(new RFClearTextEndIconDelegate$5(this));
        ValueAnimator a2 = m27599a(1.0f, 0.0f);
        this.f36645j = a2;
        a2.addListener(new RFClearTextEndIconDelegate$6(this));
    }

    /* renamed from: a */
    private ValueAnimator m27599a(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(RFAnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.setDuration(100);
        ofFloat.addUpdateListener(new RFClearTextEndIconDelegate$7(this));
        return ofFloat;
    }

    /* renamed from: d */
    private ValueAnimator m27609d() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.8f, 1.0f});
        ofFloat.setInterpolator(RFAnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        ofFloat.setDuration(150);
        ofFloat.addUpdateListener(new RFClearTextEndIconDelegate$8(this));
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m27606b(Editable editable) {
        return editable.length() > 0;
    }
}
