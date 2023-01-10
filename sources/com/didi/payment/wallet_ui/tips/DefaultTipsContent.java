package com.didi.payment.wallet_ui.tips;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.wallet_ui.UiUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/tips/DefaultTipsContent;", "Lcom/didi/payment/wallet_ui/tips/IContentView;", "tipContent", "", "(Ljava/lang/CharSequence;)V", "imageRes", "", "getImageRes", "()I", "setImageRes", "(I)V", "imageUrl", "", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "build", "", "parent", "Landroid/widget/LinearLayout;", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: DefaultTipsContent.kt */
public final class DefaultTipsContent implements IContentView {

    /* renamed from: a */
    private final CharSequence f35717a;

    /* renamed from: b */
    private int f35718b;

    /* renamed from: c */
    private String f35719c;

    public DefaultTipsContent() {
        this((CharSequence) null, 1, (DefaultConstructorMarker) null);
    }

    public DefaultTipsContent(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "tipContent");
        this.f35717a = charSequence;
        this.f35718b = -1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DefaultTipsContent(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    public final int getImageRes() {
        return this.f35718b;
    }

    public final void setImageRes(int i) {
        this.f35718b = i;
    }

    public final String getImageUrl() {
        return this.f35719c;
    }

    public final void setImageUrl(String str) {
        this.f35719c = str;
    }

    public void build(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "parent");
        int i = 0;
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        Context context = linearLayout.getContext();
        boolean z = this.f35718b != -1 || !TextUtils.isEmpty(this.f35719c);
        int intSize = UiUtils.Companion.intSize(56);
        if (z) {
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            linearLayout.addView(imageView, intSize, intSize);
            GlideUtils.loadRoundImageMix(context, this.f35718b, this.f35719c, ((float) intSize) / 2.0f, imageView);
        }
        TextView textView = new TextView(context);
        textView.setTextSize(0, UiUtils.Companion.floatSize(28));
        textView.setTextColor(-1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(3);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setIncludeFontPadding(false);
        textView.setMaxLines(2);
        textView.setText(this.f35717a);
        textView.measure(View.MeasureSpec.makeMeasureSpec(UiUtils.Companion.getScreenWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(UiUtils.Companion.getScreenHeight(), Integer.MIN_VALUE));
        int i2 = 24;
        int intSize2 = z ? UiUtils.Companion.intSize(24) : 0;
        int measuredWidth = textView.getMeasuredWidth();
        int maxContentWidth = WalletTips.Companion.getMaxContentWidth() - intSize2;
        if (z) {
            i = intSize;
        }
        int i3 = maxContentWidth - i;
        View view = textView;
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(Math.min(measuredWidth, i3), -2);
        marginLayoutParams.leftMargin = intSize2;
        UiUtils.Companion companion = UiUtils.Companion;
        if (measuredWidth <= i3) {
            i2 = 32;
        }
        int intSize3 = companion.intSize(i2);
        marginLayoutParams.topMargin = intSize3;
        marginLayoutParams.bottomMargin = intSize3;
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(view, marginLayoutParams);
    }
}
