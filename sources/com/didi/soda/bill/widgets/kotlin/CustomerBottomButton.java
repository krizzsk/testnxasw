package com.didi.soda.bill.widgets.kotlin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u000eJ\u0006\u0010!\u001a\u00020\u001fJ\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$H\u0016J\u000e\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, mo148868d2 = {"Lcom/didi/soda/bill/widgets/kotlin/CustomerBottomButton;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "disabledMaskView", "Landroid/view/View;", "value", "", "isEnabledState", "()Z", "setEnabledState", "(Z)V", "leftTextView", "Landroid/widget/TextView;", "getLeftTextView", "()Landroid/widget/TextView;", "loadingContainer", "Landroid/widget/FrameLayout;", "loadingView", "Lcom/didi/soda/customer/widget/loading/LottieLoadingView;", "middleTextView", "rightBottomTextView", "rightTopTextView", "hideLoading", "", "isLoading", "loading", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setMiddleTextText", "str", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CustomerBottomButton.kt */
public final class CustomerBottomButton extends ConstraintLayout {

    /* renamed from: a */
    private final TextView f42020a;

    /* renamed from: b */
    private final TextView f42021b;

    /* renamed from: c */
    private final TextView f42022c;

    /* renamed from: d */
    private final LottieLoadingView f42023d;

    /* renamed from: e */
    private final FrameLayout f42024e;

    /* renamed from: f */
    private final View f42025f;

    /* renamed from: g */
    private final TextView f42026g;

    /* renamed from: h */
    private boolean f42027h;

    public void _$_clearFindViewByIdCache() {
    }

    public final TextView getLeftTextView() {
        return this.f42026g;
    }

    public final boolean isEnabledState() {
        return this.f42027h;
    }

    public final void setEnabledState(boolean z) {
        this.f42027h = z;
        boolean z2 = false;
        if (isEnabled()) {
            this.f42025f.setVisibility(4);
            z2 = true;
        } else {
            this.f42025f.setVisibility(0);
        }
        setClickable(z2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerBottomButton(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_bottom_button_container, this);
        View findViewById = findViewById(R.id.customer_tv_bottom_button_middle_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.custom…ottom_button_middle_text)");
        this.f42022c = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.customer_custom_loading);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_custom_loading)");
        this.f42023d = (LottieLoadingView) findViewById2;
        View findViewById3 = findViewById(R.id.customer_fl_loading_container);
        FrameLayout frameLayout = (FrameLayout) findViewById3;
        frameLayout.setBackground(getBackground());
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<FrameLayout…tton.background\n        }");
        this.f42024e = frameLayout;
        View findViewById4 = findViewById(R.id.customer_tv_bottom_button_left_num);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.custom…v_bottom_button_left_num)");
        this.f42026g = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.customer_tv_bottom_button_right_top_text);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.custom…om_button_right_top_text)");
        this.f42020a = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.customer_tv_bottom_button_right_bottom_text);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.custom…button_right_bottom_text)");
        this.f42021b = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.customer_view_disabled_mask);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.customer_view_disabled_mask)");
        this.f42025f = findViewById7;
        this.f42026g.setTextColor(SkinUtil.getMainButtonSideTextColor());
        this.f42022c.setTextColor(SkinUtil.getUponBrandPrimaryTextColorStateList());
        this.f42020a.setTextColor(SkinUtil.getMainButtonSideTextColor());
        this.f42021b.setTextColor(SkinUtil.getMainButtonSideTextColor());
        hideLoading();
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f42022c, IToolsService.FontType.BOLD);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerBottomButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_bottom_button_container, this);
        View findViewById = findViewById(R.id.customer_tv_bottom_button_middle_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.custom…ottom_button_middle_text)");
        this.f42022c = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.customer_custom_loading);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_custom_loading)");
        this.f42023d = (LottieLoadingView) findViewById2;
        View findViewById3 = findViewById(R.id.customer_fl_loading_container);
        FrameLayout frameLayout = (FrameLayout) findViewById3;
        frameLayout.setBackground(getBackground());
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<FrameLayout…tton.background\n        }");
        this.f42024e = frameLayout;
        View findViewById4 = findViewById(R.id.customer_tv_bottom_button_left_num);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.custom…v_bottom_button_left_num)");
        this.f42026g = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.customer_tv_bottom_button_right_top_text);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.custom…om_button_right_top_text)");
        this.f42020a = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.customer_tv_bottom_button_right_bottom_text);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.custom…button_right_bottom_text)");
        this.f42021b = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.customer_view_disabled_mask);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.customer_view_disabled_mask)");
        this.f42025f = findViewById7;
        this.f42026g.setTextColor(SkinUtil.getMainButtonSideTextColor());
        this.f42022c.setTextColor(SkinUtil.getUponBrandPrimaryTextColorStateList());
        this.f42020a.setTextColor(SkinUtil.getMainButtonSideTextColor());
        this.f42021b.setTextColor(SkinUtil.getMainButtonSideTextColor());
        hideLoading();
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f42022c, IToolsService.FontType.BOLD);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerBottomButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_bottom_button_container, this);
        View findViewById = findViewById(R.id.customer_tv_bottom_button_middle_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.custom…ottom_button_middle_text)");
        this.f42022c = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.customer_custom_loading);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_custom_loading)");
        this.f42023d = (LottieLoadingView) findViewById2;
        View findViewById3 = findViewById(R.id.customer_fl_loading_container);
        FrameLayout frameLayout = (FrameLayout) findViewById3;
        frameLayout.setBackground(getBackground());
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<FrameLayout…tton.background\n        }");
        this.f42024e = frameLayout;
        View findViewById4 = findViewById(R.id.customer_tv_bottom_button_left_num);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.custom…v_bottom_button_left_num)");
        this.f42026g = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.customer_tv_bottom_button_right_top_text);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.custom…om_button_right_top_text)");
        this.f42020a = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.customer_tv_bottom_button_right_bottom_text);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.custom…button_right_bottom_text)");
        this.f42021b = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.customer_view_disabled_mask);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.customer_view_disabled_mask)");
        this.f42025f = findViewById7;
        this.f42026g.setTextColor(SkinUtil.getMainButtonSideTextColor());
        this.f42022c.setTextColor(SkinUtil.getUponBrandPrimaryTextColorStateList());
        this.f42020a.setTextColor(SkinUtil.getMainButtonSideTextColor());
        this.f42021b.setTextColor(SkinUtil.getMainButtonSideTextColor());
        hideLoading();
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f42022c, IToolsService.FontType.BOLD);
    }

    public final void setMiddleTextText(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        this.f42022c.setText(str);
    }

    public final boolean isLoading() {
        return this.f42023d.isRunning();
    }

    public final void loading() {
        this.f42023d.setVisibility(0);
        this.f42023d.start();
        this.f42024e.setVisibility(0);
        this.f42022c.setVisibility(4);
    }

    public final void hideLoading() {
        this.f42023d.setVisibility(8);
        this.f42023d.stop();
        this.f42024e.setVisibility(8);
        this.f42022c.setVisibility(0);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (motionEvent.getAction() == 0) {
            CustomerSystemUtil.virate(getContext());
        }
        return super.onTouchEvent(motionEvent);
    }
}
