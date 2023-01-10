package com.didi.global.fintech.cashier.p118ui.widget.popup;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.didi.global.fintech.cashier.p118ui.kts.ContextKtxKt;
import com.taxis99.R;

/* renamed from: com.didi.global.fintech.cashier.ui.widget.popup.a */
/* compiled from: CashierPopup */
class C9111a extends PopupWindow {

    /* renamed from: a */
    private ViewGroup f23861a;

    /* renamed from: b */
    private CashierBubbleLayout f23862b;

    /* renamed from: c */
    private Context f23863c;

    C9111a(Context context) {
        this.f23863c = context;
        setWidth(-2);
        setHeight(-2);
        m19314e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71392a(int i) {
        this.f23862b.setBubbleBackgroundColor(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71399a(String str) {
        this.f23862b.setText(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo71405b(int i) {
        this.f23862b.setTypeface(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71394a(int i, int i2, int i3) {
        this.f23862b.mo71369a(i, i2, i3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71400a(String str, int i) {
        this.f23862b.mo71371a(str, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo71407b(String str) {
        this.f23862b.setLeftDrawable(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo71410c(int i) {
        this.f23862b.setLeftDrawable(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71396a(View view) {
        this.f23862b.setLeftView(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71397a(View view, int i, int i2) {
        this.f23862b.mo71370a(view, i, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71403a(boolean z) {
        this.f23862b.setCloseBtnVisible(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71395a(View.OnClickListener onClickListener) {
        this.f23862b.setCloseClickListener(onClickListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo71408b(boolean z) {
        setFocusable(z);
        setOutsideTouchable(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo71406b(View.OnClickListener onClickListener) {
        this.f23861a.setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo71414d(int i) {
        this.f23862b.setMaxLines(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71402a(String str, String str2, int i, String str3, int i2, View view, int i3, int i4, View.OnClickListener onClickListener) {
        CashierBubbleLayout cashierBubbleLayout = new CashierBubbleLayout(this.f23863c);
        this.f23862b = cashierBubbleLayout;
        cashierBubbleLayout.mo71371a(str2, 0);
        this.f23862b.setText(str);
        if (!TextUtils.isEmpty(str3)) {
            this.f23862b.setLeftDrawable(str3);
        }
        if (i2 > 0) {
            this.f23862b.setLeftDrawable(i2);
        }
        if (view != null) {
            if (i3 <= 0 || i4 <= 0) {
                this.f23862b.setLeftView(view);
            } else {
                this.f23862b.mo71370a(view, i3, i4);
            }
        }
        this.f23862b.setTypeface(i);
        this.f23862b.setCloseBtnVisible(true);
        CashierBubbleLayout cashierBubbleLayout2 = this.f23862b;
        if (onClickListener == null) {
            onClickListener = new CashierPopup$1(this);
        }
        cashierBubbleLayout2.setCloseClickListener(onClickListener);
        this.f23861a.addView(this.f23862b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71401a(String str, int i, String str2, int i2, String str3, int i3, View view, int i4, int i5, boolean z, View.OnClickListener onClickListener) {
        this.f23862b.mo71371a(str2, 0);
        this.f23862b.setBubbleBackgroundColor(i);
        this.f23862b.setPadding(20, 20, 20, 20);
        this.f23862b.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.f23862b.setText(str);
        if (!TextUtils.isEmpty(str3)) {
            this.f23862b.setLeftDrawable(str3);
        }
        if (i3 > 0) {
            this.f23862b.setLeftDrawable(i3);
        }
        if (view != null) {
            if (i4 <= 0 || i5 <= 0) {
                this.f23862b.setLeftView(view);
            } else {
                this.f23862b.mo71370a(view, i4, i5);
            }
        }
        this.f23862b.setTypeface(i2);
        this.f23862b.setCloseBtnVisible(z);
        CashierBubbleLayout cashierBubbleLayout = this.f23862b;
        if (onClickListener == null) {
            onClickListener = new CashierPopup$2(this);
        }
        cashierBubbleLayout.setCloseClickListener(onClickListener);
        this.f23861a.addView(this.f23862b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71398a(C9112b bVar) {
        if (bVar != null && bVar.f23864a != null && !TextUtils.isEmpty(bVar.f23864a.text)) {
            this.f23862b = new CashierBubbleLayout(this.f23863c);
            if (bVar.f23869f != null) {
                this.f23862b.mo71371a(bVar.f23869f.position, bVar.f23869f.offset);
            }
            if (!TextUtils.isEmpty(bVar.f23867d)) {
                this.f23862b.setBubbleBackgroundColor(ContextKtxKt.getColor(this.f23863c, bVar.f23867d, (String) null));
            }
            this.f23862b.setPadding(20, 20, 20, 20);
            this.f23862b.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            this.f23862b.setText(bVar.f23864a.text);
            this.f23862b.mo71369a(bVar.f23864a.size, bVar.f23864a.bold, bVar.f23864a.italic);
            CashierBubbleLayout cashierBubbleLayout = this.f23862b;
            boolean z = true;
            if (bVar.f23866c != 1) {
                z = false;
            }
            cashierBubbleLayout.setCloseBtnVisible(z);
            this.f23862b.setCloseClickListener(bVar.f23870g);
            this.f23862b.setLeftDrawable(bVar.f23868e);
            this.f23861a.addView(this.f23862b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo71409b(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT < 19) {
            mo71411c(view, i, i2);
            return true;
        } else if (!view.getRootView().isAttachedToWindow()) {
            return false;
        } else {
            mo71411c(view, i, i2);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo71411c(View view, int i, int i2) {
        if (view != null && view.getContext() != null && !m19313a(view.getContext())) {
            try {
                showAsDropDown(view, i, i2);
            } catch (Exception unused) {
                new Handler().postDelayed(new CashierPopup$3(this, view, i, i2), 500);
            }
            CashierBubbleLayout cashierBubbleLayout = this.f23862b;
            cashierBubbleLayout.setPivotX(cashierBubbleLayout.getPivot()[0]);
            CashierBubbleLayout cashierBubbleLayout2 = this.f23862b;
            cashierBubbleLayout2.setPivotY(cashierBubbleLayout2.getPivot()[1]);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f23862b, "translationX", new float[]{0.0f, 1.0f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f23862b, "translationY", new float[]{0.0f, 1.0f});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
            animatorSet.start();
        }
    }

    /* renamed from: a */
    private boolean m19313a(Context context) {
        if (context == null) {
            return true;
        }
        if (!(context instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing() || activity.isDestroyed()) {
            return true;
        }
        return false;
    }

    public void dismiss() {
        super.dismiss();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo71391a() {
        return this.f23862b.getLayoutWidth();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo71404b() {
        return this.f23862b.getLayoutHeight();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int[] mo71412c() {
        return this.f23862b.getMeasureWidthAndHeight();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo71393a(int i, int i2) {
        this.f23862b.mo71368a(i, i2);
    }

    /* renamed from: e */
    private void m19314e() {
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) this.f23863c.getSystemService("layout_inflater")).inflate(R.layout.global_cashier_popup_window, (ViewGroup) null);
        this.f23861a = viewGroup;
        viewGroup.setOnClickListener(new CashierPopup$4(this));
        setContentView(this.f23861a);
        setFocusable(false);
        setOutsideTouchable(false);
        update();
        setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
        CashierBubbleLayout cashierBubbleLayout = new CashierBubbleLayout(this.f23863c);
        this.f23862b = cashierBubbleLayout;
        cashierBubbleLayout.setBubbleBackgroundColor(this.f23863c.getResources().getColor(R.color.grayscale_color_2));
        this.f23862b.setPadding(20, 20, 20, 20);
        this.f23862b.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo71413d() {
        this.f23861a.addView(this.f23862b);
    }
}
