package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0007H\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/HeadGlobalCartLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cartIcon", "Lcom/didi/rfusion/widget/RFIconView;", "cartTipText", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "cartView", "Landroid/widget/RelativeLayout;", "refreshCartNumLayout", "", "setCartData", "num", "showSpecial", "", "updateCartAmount", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HeadGlobalCartLayout.kt */
public final class HeadGlobalCartLayout extends ConstraintLayout {

    /* renamed from: a */
    private RelativeLayout f45570a;

    /* renamed from: b */
    private RFIconView f45571b;

    /* renamed from: c */
    private CustomerAppCompatTextView f45572c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HeadGlobalCartLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HeadGlobalCartLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HeadGlobalCartLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeadGlobalCartLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.customer_home_head_global_cart, this);
        View findViewById = findViewById(R.id.customer_global_cart);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_global_cart)");
        this.f45570a = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R.id.customer_global_cart_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_global_cart_icon)");
        this.f45571b = (RFIconView) findViewById2;
        View findViewById3 = findViewById(R.id.customer_global_cart_tip_text);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_global_cart_tip_text)");
        this.f45572c = (CustomerAppCompatTextView) findViewById3;
        setClipChildren(false);
    }

    /* renamed from: a */
    private final void m33851a(int i) {
        if (i <= 0) {
            this.f45571b.setText(ResourceHelper.getString(R.string.rf_icon_v3_outlined_cart));
            this.f45570a.setBackground((Drawable) null);
            this.f45572c.setVisibility(8);
            this.f45572c.setText("");
            return;
        }
        this.f45571b.setText(getContext().getString(R.string.rf_icon_v3_filled_cart));
        this.f45570a.setBackground(getContext().getDrawable(R.drawable.customer_home_header_address_global_cart_bg));
        this.f45572c.setVisibility(0);
        this.f45571b.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_brand1_1_a100));
        this.f45572c.setText(i < 99 ? String.valueOf(i) : String.valueOf(StringsKt.repeat("·", 3)));
    }

    public final void refreshCartNumLayout() {
        this.f45572c.requestLayout();
    }

    public static /* synthetic */ void setCartData$default(HeadGlobalCartLayout headGlobalCartLayout, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        headGlobalCartLayout.setCartData(i, z);
    }

    public final void setCartData(int i, boolean z) {
        this.f45571b.setTextColor(ResourceHelper.getColor(z ? R.color.rf_color_v2_grey4_1_a100 : R.color.rf_color_v2_grey2_1_a100));
        m33851a(i);
    }
}
