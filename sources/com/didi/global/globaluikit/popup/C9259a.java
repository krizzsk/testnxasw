package com.didi.global.globaluikit.popup;

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
import com.didi.global.globaluikit.utils.UiUtils;
import com.taxis99.R;

/* renamed from: com.didi.global.globaluikit.popup.a */
/* compiled from: LEGOPopup */
class C9259a extends PopupWindow {

    /* renamed from: a */
    private ViewGroup f24531a;

    /* renamed from: b */
    private LEGOBubbleLayout f24532b;

    /* renamed from: c */
    private Context f24533c;

    C9259a(Context context) {
        this.f24533c = context;
        setWidth(-2);
        setHeight(-2);
        m19698e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72279a(int i) {
        this.f24532b.setBubbleBackgroundColor(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72286a(String str) {
        this.f24532b.setText(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo72292b(int i) {
        this.f24532b.setTypeface(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72281a(int i, int i2, int i3) {
        this.f24532b.mo72256a(i, i2, i3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72287a(String str, int i) {
        this.f24532b.mo72258a(str, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo72294b(String str) {
        this.f24532b.setLeftDrawable(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo72297c(int i) {
        this.f24532b.setLeftDrawable(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72283a(View view) {
        this.f24532b.setLeftView(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72284a(View view, int i, int i2) {
        this.f24532b.mo72257a(view, i, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72290a(boolean z) {
        this.f24532b.setCloseBtnVisible(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72282a(View.OnClickListener onClickListener) {
        this.f24532b.setCloseClickListener(onClickListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo72295b(boolean z) {
        setFocusable(z);
        setOutsideTouchable(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo72293b(View.OnClickListener onClickListener) {
        this.f24531a.setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo72301d(int i) {
        this.f24532b.setMaxLines(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72289a(String str, String str2, int i, String str3, int i2, View view, int i3, int i4, View.OnClickListener onClickListener) {
        LEGOBubbleLayout lEGOBubbleLayout = new LEGOBubbleLayout(this.f24533c);
        this.f24532b = lEGOBubbleLayout;
        lEGOBubbleLayout.mo72258a(str2, 0);
        this.f24532b.setText(str);
        if (!TextUtils.isEmpty(str3)) {
            this.f24532b.setLeftDrawable(str3);
        }
        if (i2 > 0) {
            this.f24532b.setLeftDrawable(i2);
        }
        if (view != null) {
            if (i3 <= 0 || i4 <= 0) {
                this.f24532b.setLeftView(view);
            } else {
                this.f24532b.mo72257a(view, i3, i4);
            }
        }
        this.f24532b.setTypeface(i);
        this.f24532b.setCloseBtnVisible(true);
        LEGOBubbleLayout lEGOBubbleLayout2 = this.f24532b;
        if (onClickListener == null) {
            onClickListener = new LEGOPopup$1(this);
        }
        lEGOBubbleLayout2.setCloseClickListener(onClickListener);
        this.f24531a.addView(this.f24532b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72288a(String str, int i, String str2, int i2, String str3, int i3, View view, int i4, int i5, boolean z, View.OnClickListener onClickListener) {
        this.f24532b.mo72258a(str2, 0);
        this.f24532b.setBubbleBackgroundColor(i);
        this.f24532b.setPadding(20, 20, 20, 20);
        this.f24532b.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.f24532b.setText(str);
        if (!TextUtils.isEmpty(str3)) {
            this.f24532b.setLeftDrawable(str3);
        }
        if (i3 > 0) {
            this.f24532b.setLeftDrawable(i3);
        }
        if (view != null) {
            if (i4 <= 0 || i5 <= 0) {
                this.f24532b.setLeftView(view);
            } else {
                this.f24532b.mo72257a(view, i4, i5);
            }
        }
        this.f24532b.setTypeface(i2);
        this.f24532b.setCloseBtnVisible(z);
        LEGOBubbleLayout lEGOBubbleLayout = this.f24532b;
        if (onClickListener == null) {
            onClickListener = new LEGOPopup$2(this);
        }
        lEGOBubbleLayout.setCloseClickListener(onClickListener);
        this.f24531a.addView(this.f24532b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72285a(C9260b bVar) {
        if (bVar != null && bVar.f24534a != null && !TextUtils.isEmpty(bVar.f24534a.text)) {
            this.f24532b = new LEGOBubbleLayout(this.f24533c);
            if (bVar.f24539f != null) {
                this.f24532b.mo72258a(bVar.f24539f.position, bVar.f24539f.offset);
            }
            if (!TextUtils.isEmpty(bVar.f24537d)) {
                this.f24532b.setBubbleBackgroundColor(UiUtils.getColor(bVar.f24537d));
            }
            this.f24532b.setPadding(20, 20, 20, 20);
            this.f24532b.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            this.f24532b.setText(bVar.f24534a.text);
            this.f24532b.mo72256a(bVar.f24534a.size, bVar.f24534a.bold, bVar.f24534a.italic);
            LEGOBubbleLayout lEGOBubbleLayout = this.f24532b;
            boolean z = true;
            if (bVar.f24536c != 1) {
                z = false;
            }
            lEGOBubbleLayout.setCloseBtnVisible(z);
            this.f24532b.setCloseClickListener(bVar.f24540g);
            this.f24532b.setLeftDrawable(bVar.f24538e);
            this.f24531a.addView(this.f24532b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo72296b(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT < 19) {
            mo72298c(view, i, i2);
            return true;
        } else if (!view.getRootView().isAttachedToWindow()) {
            return false;
        } else {
            mo72298c(view, i, i2);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo72298c(View view, int i, int i2) {
        if (view != null && view.getContext() != null && !m19697a(view.getContext())) {
            try {
                showAsDropDown(view, i, i2);
            } catch (Exception unused) {
                new Handler().postDelayed(new LEGOPopup$3(this, view, i, i2), 500);
            }
            LEGOBubbleLayout lEGOBubbleLayout = this.f24532b;
            lEGOBubbleLayout.setPivotX(lEGOBubbleLayout.getPivot()[0]);
            LEGOBubbleLayout lEGOBubbleLayout2 = this.f24532b;
            lEGOBubbleLayout2.setPivotY(lEGOBubbleLayout2.getPivot()[1]);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f24532b, "translationX", new float[]{0.0f, 1.0f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f24532b, "translationY", new float[]{0.0f, 1.0f});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
            animatorSet.start();
        }
    }

    /* renamed from: a */
    private boolean m19697a(Context context) {
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
    public int mo72278a() {
        return this.f24532b.getLayoutWidth();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo72291b() {
        return this.f24532b.getLayoutHeight();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int[] mo72299c() {
        return this.f24532b.getMeasureWidthAndHeight();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo72280a(int i, int i2) {
        this.f24532b.mo72255a(i, i2);
    }

    /* renamed from: e */
    private void m19698e() {
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) this.f24533c.getSystemService("layout_inflater")).inflate(R.layout.lego_popup_window, (ViewGroup) null);
        this.f24531a = viewGroup;
        viewGroup.setOnClickListener(new LEGOPopup$4(this));
        setContentView(this.f24531a);
        setFocusable(false);
        setOutsideTouchable(false);
        update();
        setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
        LEGOBubbleLayout lEGOBubbleLayout = new LEGOBubbleLayout(this.f24533c);
        this.f24532b = lEGOBubbleLayout;
        lEGOBubbleLayout.setBubbleBackgroundColor(this.f24533c.getResources().getColor(R.color.grayscale_color_2));
        this.f24532b.setPadding(20, 20, 20, 20);
        this.f24532b.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo72300d() {
        this.f24531a.addView(this.f24532b);
    }
}
