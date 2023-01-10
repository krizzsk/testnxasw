package com.didi.payment.wallet_ui.form;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.wallet_ui.UiUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJT\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0003\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0018\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/form/WalletFormItemSmall;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mIvArrow", "Landroid/widget/ImageView;", "mIvIconSmall", "mTvTips", "Landroid/widget/TextView;", "mTvTitle", "mVRightClick", "Landroid/view/View;", "config", "", "imageUrl", "", "imageRes", "imageCorner", "", "title", "", "tips", "showArrow", "", "rightClick", "Landroid/view/View$OnClickListener;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletFormItemSmall.kt */
public final class WalletFormItemSmall extends ConstraintLayout {

    /* renamed from: a */
    private TextView f35557a;

    /* renamed from: b */
    private TextView f35558b;

    /* renamed from: c */
    private ImageView f35559c;

    /* renamed from: d */
    private ImageView f35560d;

    /* renamed from: e */
    private View f35561e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletFormItemSmall(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletFormItemSmall(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletFormItemSmall(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletFormItemSmall(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletFormItemSmall(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.wallet_ui_form_item_small, this);
        View findViewById = findViewById(R.id.iv_icon_small);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_icon_small)");
        this.f35560d = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.iv_arrow);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_arrow)");
        this.f35559c = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.tv_tips);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tv_tips)");
        this.f35558b = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tv_title)");
        this.f35557a = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.v_right_click);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.v_right_click)");
        this.f35561e = findViewById5;
        setBackground(new ColorDrawable(-1));
    }

    public static /* synthetic */ void config$default(WalletFormItemSmall walletFormItemSmall, String str, int i, float f, CharSequence charSequence, CharSequence charSequence2, boolean z, View.OnClickListener onClickListener, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            f = 0.0f;
        }
        if ((i2 & 8) != 0) {
            charSequence = null;
        }
        if ((i2 & 16) != 0) {
            charSequence2 = null;
        }
        if ((i2 & 32) != 0) {
            z = true;
        }
        if ((i2 & 64) != 0) {
            onClickListener = null;
        }
        walletFormItemSmall.config(str, i, f, charSequence, charSequence2, z, onClickListener);
    }

    public final void config(String str, int i, float f, CharSequence charSequence, CharSequence charSequence2, boolean z, View.OnClickListener onClickListener) {
        if (str == null && i == -1) {
            this.f35560d.setVisibility(8);
        } else {
            this.f35560d.setVisibility(0);
            GlideUtils.loadTopRoundImageMix(getContext(), i, str, f, this.f35560d);
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f35557a.setVisibility(8);
        } else {
            this.f35557a.setVisibility(0);
            this.f35557a.setText(charSequence);
        }
        if (TextUtils.isEmpty(charSequence2)) {
            this.f35558b.setVisibility(8);
        } else {
            this.f35558b.setVisibility(0);
            this.f35558b.setText(charSequence2);
        }
        this.f35559c.setVisibility(z ? 0 : 8);
        if (!TextUtils.isEmpty(charSequence2) || z) {
            this.f35561e.setVisibility(0);
            this.f35561e.setOnClickListener(onClickListener);
            return;
        }
        this.f35561e.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(UiUtils.Companion.getScreenWidth(), 1073741824), i2);
    }
}
