package com.didi.rfusion.widget.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.didi.rfusion.material.animation.RFAnimationUtils;
import com.didi.rfusion.material.animation.RFAnimatorSetCompat;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFTextView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.rfusion.widget.textfield.c */
/* compiled from: RFIndicatorViewController */
final class C12403c {

    /* renamed from: a */
    static final int f36649a = 0;

    /* renamed from: b */
    static final int f36650b = 1;

    /* renamed from: c */
    static final int f36651c = 2;

    /* renamed from: d */
    private static final int f36652d = 217;

    /* renamed from: e */
    private static final int f36653e = 167;

    /* renamed from: f */
    private static final int f36654f = 0;

    /* renamed from: g */
    private static final int f36655g = 1;

    /* renamed from: h */
    private static final int f36656h = 2;

    /* renamed from: A */
    private int f36657A;

    /* renamed from: B */
    private ColorStateList f36658B;

    /* renamed from: C */
    private Typeface f36659C;

    /* renamed from: i */
    private final Context f36660i;

    /* renamed from: j */
    private final RFTextInputLayout f36661j;

    /* renamed from: k */
    private LinearLayout f36662k;

    /* renamed from: l */
    private int f36663l;

    /* renamed from: m */
    private FrameLayout f36664m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Animator f36665n;

    /* renamed from: o */
    private final float f36666o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f36667p;

    /* renamed from: q */
    private int f36668q;

    /* renamed from: r */
    private CharSequence f36669r;

    /* renamed from: s */
    private boolean f36670s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public RFTextView f36671t;

    /* renamed from: u */
    private CharSequence f36672u;

    /* renamed from: v */
    private int f36673v;

    /* renamed from: w */
    private ColorStateList f36674w;

    /* renamed from: x */
    private CharSequence f36675x;

    /* renamed from: y */
    private boolean f36676y;

    /* renamed from: z */
    private RFTextView f36677z;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo94814a(int i) {
        return i == 0 || i == 1;
    }

    public C12403c(RFTextInputLayout rFTextInputLayout) {
        Context context = rFTextInputLayout.getContext();
        this.f36660i = context;
        this.f36661j = rFTextInputLayout;
        this.f36666o = RFResUtils.getDimens(context, R.dimen.rf_dimen_5);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94812a(CharSequence charSequence) {
        mo94821c();
        this.f36675x = charSequence;
        this.f36677z.setText(charSequence);
        if (this.f36667p != 2) {
            this.f36668q = 2;
        }
        m27619a(this.f36667p, this.f36668q, m27623a((TextView) this.f36677z, charSequence));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94808a() {
        mo94821c();
        if (this.f36667p == 2) {
            this.f36668q = 0;
        }
        m27619a(this.f36667p, this.f36668q, m27623a((TextView) this.f36677z, (CharSequence) null));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo94819b(CharSequence charSequence) {
        mo94821c();
        this.f36669r = charSequence;
        this.f36671t.setText(charSequence);
        if (this.f36667p != 1) {
            this.f36668q = 1;
        }
        m27619a(this.f36667p, this.f36668q, m27623a((TextView) this.f36671t, charSequence));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo94815b() {
        this.f36669r = null;
        mo94821c();
        if (this.f36667p == 1) {
            if (!this.f36676y || TextUtils.isEmpty(this.f36675x)) {
                this.f36668q = 0;
            } else {
                this.f36668q = 2;
            }
        }
        m27619a(this.f36667p, this.f36668q, m27623a((TextView) this.f36671t, (CharSequence) null));
    }

    /* renamed from: a */
    private boolean m27623a(TextView textView, CharSequence charSequence) {
        return ViewCompat.isLaidOut(this.f36661j) && this.f36661j.isEnabled() && (this.f36668q != this.f36667p || textView == null || !TextUtils.equals(textView.getText(), charSequence));
    }

    /* renamed from: a */
    private void m27619a(int i, int i2, boolean z) {
        boolean z2 = z;
        if (i != i2) {
            if (z2) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f36665n = animatorSet;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = arrayList;
                int i3 = i;
                int i4 = i2;
                m27622a(arrayList2, this.f36676y, this.f36677z, 2, i3, i4);
                m27622a(arrayList2, this.f36670s, this.f36671t, 1, i3, i4);
                RFAnimatorSetCompat.playTogether(animatorSet, arrayList);
                animatorSet.addListener(new RFIndicatorViewController$1(this, i2, m27624d(i), i, m27624d(i2)));
                animatorSet.start();
            } else {
                m27618a(i, i2);
            }
            this.f36661j.mo94690a();
            this.f36661j.mo94696a(z2);
            this.f36661j.mo94707e();
        }
    }

    /* renamed from: a */
    private void m27618a(int i, int i2) {
        TextView d;
        TextView d2;
        if (i != i2) {
            if (!(i2 == 0 || (d2 = m27624d(i2)) == null)) {
                d2.setVisibility(0);
                d2.setAlpha(1.0f);
            }
            if (!(i == 0 || (d = m27624d(i)) == null)) {
                d.setVisibility(4);
                if (i == 1) {
                    d.setText((CharSequence) null);
                }
            }
            this.f36667p = i2;
        }
    }

    /* renamed from: a */
    private void m27622a(List<Animator> list, boolean z, TextView textView, int i, int i2, int i3) {
        if (textView != null && z) {
            if (i == i3 || i == i2) {
                list.add(m27616a(textView, i3 == i));
                if (i3 == i) {
                    list.add(m27615a(textView));
                }
            }
        }
    }

    /* renamed from: a */
    private ObjectAnimator m27616a(TextView textView, boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, new float[]{z ? 1.0f : 0.0f});
        ofFloat.setDuration(167);
        ofFloat.setInterpolator(RFAnimationUtils.LINEAR_INTERPOLATOR);
        return ofFloat;
    }

    /* renamed from: a */
    private ObjectAnimator m27615a(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, new float[]{-this.f36666o, 0.0f});
        ofFloat.setDuration(217);
        ofFloat.setInterpolator(RFAnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        return ofFloat;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo94821c() {
        Animator animator = this.f36665n;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* renamed from: d */
    private TextView m27624d(int i) {
        if (i == 1) {
            return this.f36671t;
        }
        if (i != 2) {
            return null;
        }
        return this.f36677z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo94824d() {
        if (m27627r()) {
            this.f36661j.getEditText();
            ViewCompat.setPaddingRelative(this.f36662k, 0, (int) RFResUtils.getDimens(this.f36660i, R.dimen.rf_dimen_20), 0, 0);
        }
    }

    /* renamed from: r */
    private boolean m27627r() {
        return (this.f36662k == null || this.f36661j.getEditText() == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94811a(TextView textView, int i) {
        if (this.f36662k == null && this.f36664m == null) {
            LinearLayout linearLayout = new LinearLayout(this.f36660i);
            this.f36662k = linearLayout;
            linearLayout.setOrientation(0);
            this.f36661j.addView(this.f36662k, -1, -2);
            this.f36664m = new FrameLayout(this.f36660i);
            this.f36662k.addView(this.f36664m, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f36661j.getEditText() != null) {
                mo94824d();
            }
        }
        if (mo94814a(i)) {
            this.f36664m.setVisibility(0);
            this.f36664m.addView(textView);
        } else {
            this.f36662k.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f36662k.setVisibility(0);
        this.f36663l++;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo94818b(TextView textView, int i) {
        FrameLayout frameLayout;
        if (this.f36662k != null) {
            if (!mo94814a(i) || (frameLayout = this.f36664m) == null) {
                this.f36662k.removeView(textView);
            } else {
                frameLayout.removeView(textView);
            }
            int i2 = this.f36663l - 1;
            this.f36663l = i2;
            m27620a((ViewGroup) this.f36662k, i2);
        }
    }

    /* renamed from: a */
    private void m27620a(ViewGroup viewGroup, int i) {
        if (i == 0) {
            viewGroup.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94813a(boolean z) {
        if (this.f36670s != z) {
            mo94821c();
            if (z) {
                this.f36671t = new RFTextView(this.f36660i);
                if (Build.VERSION.SDK_INT >= 17) {
                    this.f36671t.setTextAlignment(5);
                }
                Typeface typeface = this.f36659C;
                if (typeface != null) {
                    this.f36671t.setTypeface(typeface);
                }
                mo94816b(this.f36673v);
                mo94809a(this.f36674w);
                mo94823c(this.f36672u);
                this.f36671t.setVisibility(4);
                ViewCompat.setAccessibilityLiveRegion(this.f36671t, 1);
                mo94811a((TextView) this.f36671t, 0);
            } else {
                mo94815b();
                mo94818b(this.f36671t, 0);
                this.f36671t = null;
                this.f36661j.mo94690a();
                this.f36661j.mo94707e();
            }
            this.f36670s = z;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo94825e() {
        return this.f36670s;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo94826f() {
        return this.f36676y;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo94820b(boolean z) {
        if (this.f36676y != z) {
            mo94821c();
            if (z) {
                this.f36677z = new RFTextView(this.f36660i);
                if (Build.VERSION.SDK_INT >= 17) {
                    this.f36677z.setTextAlignment(5);
                }
                Typeface typeface = this.f36659C;
                if (typeface != null) {
                    this.f36677z.setTypeface(typeface);
                }
                this.f36677z.setVisibility(4);
                ViewCompat.setAccessibilityLiveRegion(this.f36677z, 1);
                mo94822c(this.f36657A);
                mo94817b(this.f36658B);
                mo94811a((TextView) this.f36677z, 1);
            } else {
                mo94808a();
                mo94818b(this.f36677z, 1);
                this.f36677z = null;
                this.f36661j.mo94690a();
                this.f36661j.mo94707e();
            }
            this.f36676y = z;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo94827g() {
        return m27625e(this.f36667p);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo94828h() {
        return m27625e(this.f36668q);
    }

    /* renamed from: e */
    private boolean m27625e(int i) {
        if (i != 1 || this.f36671t == null || TextUtils.isEmpty(this.f36669r)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo94829i() {
        return m27626f(this.f36667p);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public boolean mo94830j() {
        return m27626f(this.f36668q);
    }

    /* renamed from: f */
    private boolean m27626f(int i) {
        return i == 2 && this.f36677z != null && !TextUtils.isEmpty(this.f36675x);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public CharSequence mo94831k() {
        return this.f36669r;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public CharSequence mo94832l() {
        return this.f36675x;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94810a(Typeface typeface) {
        if (typeface != this.f36659C) {
            this.f36659C = typeface;
            m27621a((TextView) this.f36671t, typeface);
            m27621a((TextView) this.f36677z, typeface);
        }
    }

    /* renamed from: a */
    private void m27621a(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public int mo94833m() {
        RFTextView rFTextView = this.f36671t;
        if (rFTextView != null) {
            return rFTextView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public ColorStateList mo94834n() {
        RFTextView rFTextView = this.f36671t;
        if (rFTextView != null) {
            return rFTextView.getTextColors();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94809a(ColorStateList colorStateList) {
        this.f36674w = colorStateList;
        RFTextView rFTextView = this.f36671t;
        if (rFTextView != null && colorStateList != null) {
            rFTextView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo94816b(int i) {
        this.f36673v = i;
        RFTextView rFTextView = this.f36671t;
        if (rFTextView != null) {
            this.f36661j.mo94693a(rFTextView, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo94823c(CharSequence charSequence) {
        this.f36672u = charSequence;
        RFTextView rFTextView = this.f36671t;
        if (rFTextView != null) {
            rFTextView.setContentDescription(charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public CharSequence mo94835o() {
        return this.f36672u;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public int mo94836p() {
        RFTextView rFTextView = this.f36677z;
        if (rFTextView != null) {
            return rFTextView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public ColorStateList mo94837q() {
        RFTextView rFTextView = this.f36677z;
        if (rFTextView != null) {
            return rFTextView.getTextColors();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo94817b(ColorStateList colorStateList) {
        this.f36658B = colorStateList;
        RFTextView rFTextView = this.f36677z;
        if (rFTextView != null && colorStateList != null) {
            rFTextView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo94822c(int i) {
        this.f36657A = i;
        RFTextView rFTextView = this.f36677z;
        if (rFTextView != null) {
            TextViewCompat.setTextAppearance(rFTextView, i);
            this.f36677z.setTypeface(1);
        }
    }
}
