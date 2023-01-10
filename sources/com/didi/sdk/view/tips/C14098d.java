package com.didi.sdk.view.tips;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.sdk.util.ViewUtils;

/* renamed from: com.didi.sdk.view.tips.d */
/* compiled from: TipsWithoutLine */
class C14098d implements C14095a {

    /* renamed from: a */
    private TipsView f41015a;

    /* renamed from: b */
    private View f41016b;

    /* renamed from: c */
    private Context f41017c;

    /* renamed from: d */
    private TipsContainer f41018d;

    /* renamed from: e */
    private boolean f41019e;

    /* renamed from: f */
    private boolean f41020f = false;

    /* renamed from: g */
    private boolean f41021g = false;

    /* renamed from: h */
    private C14096b f41022h;

    /* renamed from: i */
    private int f41023i = 0;

    public C14098d(Context context, TipsContainer tipsContainer) {
        this.f41017c = context;
        this.f41018d = tipsContainer;
    }

    /* renamed from: a */
    public void mo104337a(View view, TipsView tipsView) {
        this.f41016b = view;
        this.f41015a = tipsView;
        Rect rect = new Rect();
        ((Activity) this.f41017c).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        if ((((Activity) this.f41017c).getWindow().getDecorView().getSystemUiVisibility() & 1024) == 1024) {
            this.f41023i = ViewUtils.getStatusBarHeight(this.f41017c);
        }
        this.f41022h = new C14096b(this.f41016b, i);
    }

    /* renamed from: a */
    public void mo104336a(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.f41019e = false;
        TipsView tipsView = this.f41015a;
        tipsView.measure(0, 0);
        int measuredWidth = tipsView.getMeasuredWidth();
        int measuredHeight = tipsView.getMeasuredHeight();
        Point a = this.f41022h.mo104340a(i4, i5, measuredWidth, measuredHeight, 0, i, i2);
        if (a.x < 0) {
            a.x = 0;
        }
        if (a.y < 0) {
            a.y = 0;
        }
        m30751a(a.x, a.y, measuredWidth, measuredHeight);
        if (z) {
            tipsView.setPosGone();
        } else {
            int i6 = i;
            int i7 = i2;
            tipsView.setPos(i, i2);
        }
        tipsView.attachContainer(this.f41018d);
        tipsView.showEnterAnim();
    }

    /* renamed from: a */
    private void m30751a(int i, int i2, int i3, int i4) {
        TipsView tipsView = this.f41015a;
        int i5 = i2 + this.f41023i;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i + tipsView.getLeftMargin(), i5 + tipsView.getTopMargin(), tipsView.getRightMargin(), tipsView.getBottomMargin());
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        this.f41018d.addView((View) tipsView, (ViewGroup.LayoutParams) layoutParams);
    }

    /* renamed from: a */
    public boolean mo104338a() {
        return this.f41019e;
    }

    /* renamed from: b */
    public void mo104339b() {
        this.f41019e = true;
        TipsContainer tipsContainer = this.f41018d;
        if (tipsContainer != null) {
            tipsContainer.clear();
        }
    }
}
