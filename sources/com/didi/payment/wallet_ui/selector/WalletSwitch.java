package com.didi.payment.wallet_ui.selector;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.core.graphics.ColorUtils;
import com.didi.payment.wallet_ui.UiUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0012\u0010\u0016\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014R\u001a\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/selector/WalletSwitch;", "Lcom/didi/payment/wallet_ui/selector/WalletSelector;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "closeBgColor", "getCloseBgColor", "()I", "setCloseBgColor", "(I)V", "drawBg", "", "canvas", "Landroid/graphics/Canvas;", "drawBtn", "getSelectorHeight", "getSelectorWidth", "onDraw", "Companion", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletSwitch.kt */
public final class WalletSwitch extends WalletSelector {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b */
    private static final int f35711b = UiUtils.Companion.intSize(80);

    /* renamed from: c */
    private static final int f35712c = UiUtils.Companion.intSize(48);

    /* renamed from: d */
    private static final float f35713d = UiUtils.Companion.floatSize(24);

    /* renamed from: e */
    private static final float f35714e = UiUtils.Companion.floatSize(20);

    /* renamed from: f */
    private static final float f35715f = UiUtils.Companion.floatSize(24);

    /* renamed from: a */
    private int f35716a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletSwitch(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletSwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletSwitch(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletSwitch(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/selector/WalletSwitch$Companion;", "", "()V", "switchBtnRadius", "", "switchBtnY", "switchCorner", "switchHeight", "", "switchWidth", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalletSwitch.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletSwitch(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f35716a = Color.parseColor("#E8EAEB");
    }

    /* access modifiers changed from: protected */
    public int getCloseBgColor() {
        return this.f35716a;
    }

    /* access modifiers changed from: protected */
    public void setCloseBgColor(int i) {
        this.f35716a = i;
    }

    public int getSelectorWidth() {
        return f35711b;
    }

    public int getSelectorHeight() {
        return f35712c;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            m26916a(canvas);
            m26917b(canvas);
        }
    }

    /* renamed from: a */
    private final void m26916a(Canvas canvas) {
        float f = (float) f35711b;
        float f2 = (float) f35712c;
        float f3 = f35713d;
        Paint bgPaint = getBgPaint();
        bgPaint.setColor(getBgColor());
        Unit unit = Unit.INSTANCE;
        canvas.drawRoundRect(0.0f, 0.0f, f, f2, f3, f3, bgPaint);
    }

    /* renamed from: b */
    private final void m26917b(Canvas canvas) {
        float f;
        int curType = getCurType();
        int i = -1;
        if (curType == 1) {
            f = UiUtils.Companion.floatSize(56);
        } else if (curType == 2) {
            f = f35715f;
        } else if (curType == 3) {
            i = ColorUtils.compositeColors(-1, Color.parseColor("#66FFFFFF"));
            f = UiUtils.Companion.floatSize(56);
        } else if (curType != 4) {
            f = 0.0f;
        } else {
            i = Color.parseColor(com.didi.dcrypto.util.ColorUtils.DIDI_GREY);
            f = f35715f;
        }
        float f2 = f35715f;
        float f3 = f35714e;
        Paint bgPaint = getBgPaint();
        bgPaint.setColor(i);
        Unit unit = Unit.INSTANCE;
        canvas.drawCircle(f, f2, f3, bgPaint);
    }
}
