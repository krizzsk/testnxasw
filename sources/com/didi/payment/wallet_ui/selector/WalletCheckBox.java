package com.didi.payment.wallet_ui.selector;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.didi.payment.wallet_ui.UiUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0007H\u0014¨\u0006\u0010"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/selector/WalletCheckBox;", "Lcom/didi/payment/wallet_ui/selector/WalletRadio;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "drawBg", "", "canvas", "Landroid/graphics/Canvas;", "drawBorder", "borderColor", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletCheckBox.kt */
public final class WalletCheckBox extends WalletRadio {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletCheckBox(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletCheckBox(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletCheckBox(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletCheckBox(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: protected */
    public void drawBg(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float selectorWidth = (float) getSelectorWidth();
        float selectorHeight = (float) getSelectorHeight();
        float floatSize = UiUtils.Companion.floatSize(14);
        float floatSize2 = UiUtils.Companion.floatSize(14);
        Paint bgPaint = getBgPaint();
        bgPaint.setColor(getBgColor());
        Unit unit = Unit.INSTANCE;
        canvas.drawRoundRect(0.0f, 0.0f, selectorWidth, selectorHeight, floatSize, floatSize2, bgPaint);
    }

    /* access modifiers changed from: protected */
    public void drawBorder(Canvas canvas, int i) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float selectorWidth = (float) getSelectorWidth();
        float selectorHeight = (float) getSelectorHeight();
        float floatSize = UiUtils.Companion.floatSize(14);
        float floatSize2 = UiUtils.Companion.floatSize(14);
        Paint borderPaint = getBorderPaint();
        borderPaint.setColor(i);
        Unit unit = Unit.INSTANCE;
        canvas.drawRoundRect(0.0f, 0.0f, selectorWidth, selectorHeight, floatSize, floatSize2, borderPaint);
    }
}
