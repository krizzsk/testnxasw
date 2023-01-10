package com.didi.addressold.view.tips;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import com.didi.sdk.util.ViewUtils;

/* renamed from: com.didi.addressold.view.tips.d */
/* compiled from: TipsWithoutLine */
class C4091d implements C4088a {

    /* renamed from: a */
    private TipsView f9882a;

    /* renamed from: b */
    private View f9883b;

    /* renamed from: c */
    private Context f9884c;

    /* renamed from: d */
    private TipsContainer f9885d;

    /* renamed from: e */
    private boolean f9886e;

    /* renamed from: f */
    private boolean f9887f = false;

    /* renamed from: g */
    private boolean f9888g = false;

    /* renamed from: h */
    private C4089b f9889h;

    /* renamed from: i */
    private int f9890i = 0;

    public C4091d(Context context, TipsContainer tipsContainer) {
        this.f9884c = context;
        this.f9885d = tipsContainer;
    }

    /* renamed from: a */
    public void mo44857a(View view, TipsView tipsView) {
        this.f9883b = view;
        this.f9882a = tipsView;
        Rect rect = new Rect();
        ((Activity) this.f9884c).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        if ((((Activity) this.f9884c).getWindow().getDecorView().getSystemUiVisibility() & 1024) == 1024) {
            this.f9890i = ViewUtils.getStatusBarHeight(this.f9884c);
        }
        this.f9889h = new C4089b(this.f9883b, i);
    }

    /* renamed from: a */
    public void mo44856a(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.f9886e = false;
        TipsView tipsView = this.f9882a;
        tipsView.measure(0, 0);
        int measuredWidth = tipsView.getMeasuredWidth();
        int measuredHeight = tipsView.getMeasuredHeight();
        Point a = this.f9889h.mo44860a(i4, i5, measuredWidth, measuredHeight, 0, i, i2);
        if (a.x < 0) {
            a.x = 0;
        }
        if (a.y < 0) {
            a.y = 0;
        }
        m8611a(a.x, a.y, measuredWidth, measuredHeight);
        if (z) {
            tipsView.setPosGone();
        } else {
            int i6 = i;
            int i7 = i2;
            tipsView.setPos(i, i2);
        }
        tipsView.attachContainer(this.f9885d);
        tipsView.showEnterAnim();
    }

    /* renamed from: a */
    private void m8611a(int i, int i2, int i3, int i4) {
        TipsView tipsView = this.f9882a;
        int i5 = i2 + this.f9890i;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMarginStart(i + tipsView.getLeftMargin());
        layoutParams.setMarginEnd(tipsView.getRightMargin());
        layoutParams.topMargin = i5 + tipsView.getTopMargin();
        layoutParams.bottomMargin = tipsView.getBottomMargin();
        if (com.didi.addressold.util.ViewUtils.isRTL()) {
            layoutParams.gravity = GravityCompat.END;
        } else {
            layoutParams.gravity = GravityCompat.START;
        }
        this.f9885d.addView((View) tipsView, layoutParams);
    }

    /* renamed from: a */
    public boolean mo44858a() {
        return this.f9886e;
    }

    /* renamed from: b */
    public void mo44859b() {
        this.f9886e = true;
        TipsContainer tipsContainer = this.f9885d;
        if (tipsContainer != null) {
            tipsContainer.clear();
        }
    }
}
