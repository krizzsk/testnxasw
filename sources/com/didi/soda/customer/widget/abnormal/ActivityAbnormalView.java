package com.didi.soda.customer.widget.abnormal;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.didi.rfusion.widget.button.RFGhostButton;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010!\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010\u0017J\u0010\u0010#\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010\u0017J\u0010\u0010%\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010\u0017J\u0010\u0010'\u001a\u00020\u001a2\b\u0010(\u001a\u0004\u0018\u00010)R\u001a\u0010\t\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, mo148868d2 = {"Lcom/didi/soda/customer/widget/abnormal/ActivityAbnormalView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mContainer", "getMContainer", "()Landroid/widget/RelativeLayout;", "setMContainer", "(Landroid/widget/RelativeLayout;)V", "mDetail", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "mIcon", "Landroid/widget/ImageView;", "mRetryTv", "Lcom/didi/rfusion/widget/button/RFGhostButton;", "mTitle", "parseColor", "colorString", "", "defaultColorRes", "setBackgroundColor", "", "color", "setButtonString", "btn", "setContainerClickListener", "listener", "Landroid/view/View$OnClickListener;", "setDetail", "detail", "setImage", "imageUrl", "setTitle", "title", "show", "model", "Lcom/didi/soda/customer/widget/abnormal/ActivityAbnormalViewModel;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ActivityAbnormalView.kt */
public final class ActivityAbnormalView extends RelativeLayout {

    /* renamed from: a */
    private RelativeLayout f44233a;

    /* renamed from: b */
    private ImageView f44234b;

    /* renamed from: c */
    private CustomerAppCompatTextView f44235c;

    /* renamed from: d */
    private CustomerAppCompatTextView f44236d;

    /* renamed from: e */
    private RFGhostButton f44237e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ActivityAbnormalView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ActivityAbnormalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m32910a(View view) {
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActivityAbnormalView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActivityAbnormalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.widght_activity_error_view, this);
        View findViewById = findViewById(R.id.error_img);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.error_img)");
        this.f44234b = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.error_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.error_title)");
        this.f44235c = (CustomerAppCompatTextView) findViewById2;
        View findViewById3 = findViewById(R.id.error_detail);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.error_detail)");
        this.f44236d = (CustomerAppCompatTextView) findViewById3;
        View findViewById4 = findViewById(R.id.customer_bt_retry);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.customer_bt_retry)");
        this.f44237e = (RFGhostButton) findViewById4;
        View findViewById5 = findViewById(R.id.common_error_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.common_error_container)");
        this.f44233a = (RelativeLayout) findViewById5;
    }

    /* access modifiers changed from: protected */
    public final RelativeLayout getMContainer() {
        return this.f44233a;
    }

    /* access modifiers changed from: protected */
    public final void setMContainer(RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.f44233a = relativeLayout;
    }

    public final void setContainerClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            setOnClickListener(onClickListener);
        }
    }

    public final void setImage(String str) {
        if (!TextUtils.isEmpty(str)) {
            FlyImageLoader.loadImage1x1(getContext(), str).into(this.f44234b);
            this.f44234b.setVisibility(0);
            return;
        }
        this.f44234b.setVisibility(8);
    }

    public final void setTitle(String str) {
        CustomerAppCompatTextView customerAppCompatTextView = this.f44235c;
        if (str == null) {
            str = "";
        }
        customerAppCompatTextView.setText(str);
    }

    public final void setDetail(String str) {
        this.f44236d.setText(str != null ? str : "");
        CustomerAppCompatTextView customerAppCompatTextView = this.f44236d;
        CharSequence charSequence = str;
        int i = 0;
        if (charSequence == null || charSequence.length() == 0) {
            i = 8;
        }
        customerAppCompatTextView.setVisibility(i);
    }

    public final void setButtonString(String str) {
        RFGhostButton rFGhostButton = this.f44237e;
        if (str == null) {
            str = "";
        }
        rFGhostButton.setText(str);
    }

    public final void setBackgroundColor(String str) {
        RelativeLayout relativeLayout = this.f44233a;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(m32909a(str, R.color.rf_color_white_100_FFFFFF));
        }
    }

    /* renamed from: a */
    private final int m32909a(String str, int i) {
        if (str == null) {
            return ResourceHelper.getColor(i);
        }
        try {
            return Color.parseColor(str);
        } catch (Exception e) {
            e.printStackTrace();
            return ResourceHelper.getColor(i);
        }
    }

    public final void show(ActivityAbnormalViewModel activityAbnormalViewModel) {
        if (activityAbnormalViewModel != null) {
            setImage(activityAbnormalViewModel.getImageUrl());
            setTitle(activityAbnormalViewModel.getDesc());
            setDetail(activityAbnormalViewModel.getDetail());
            setButtonString(activityAbnormalViewModel.getButton());
            if (activityAbnormalViewModel.getClickListener() != null) {
                CharSequence button = activityAbnormalViewModel.getButton();
                if (!(button == null || button.length() == 0)) {
                    setContainerClickListener(activityAbnormalViewModel.getClickListener());
                    this.f44237e.setVisibility(0);
                    setBackgroundColor(activityAbnormalViewModel.getBgColor());
                    setVisibility(0);
                }
            }
            setContainerClickListener($$Lambda$ActivityAbnormalView$Gws0MAfNTVFXpQQ3yzet3k4J0.INSTANCE);
            this.f44237e.setVisibility(8);
            setBackgroundColor(activityAbnormalViewModel.getBgColor());
            setVisibility(0);
        }
    }
}
