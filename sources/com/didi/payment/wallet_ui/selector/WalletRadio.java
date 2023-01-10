package com.didi.payment.wallet_ui.selector;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.core.graphics.ColorUtils;
import com.didi.payment.wallet_ui.UiUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u0000 $2\u00020\u0001:\u0001$B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0007H\u0014J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u0007H\u0002J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016J\u0012\u0010#\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014R\u001b\u0010\n\u001a\u00020\u000b8DX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\rR\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/selector/WalletRadio;", "Lcom/didi/payment/wallet_ui/selector/WalletSelector;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "borderPaint", "Landroid/graphics/Paint;", "getBorderPaint", "()Landroid/graphics/Paint;", "borderPaint$delegate", "Lkotlin/Lazy;", "selectorPaint", "getSelectorPaint", "selectorPaint$delegate", "selectorPath", "Landroid/graphics/Path;", "getSelectorPath", "()Landroid/graphics/Path;", "selectorPath$delegate", "drawBg", "", "canvas", "Landroid/graphics/Canvas;", "drawBorder", "borderColor", "drawOther", "drawSelector", "selectorColor", "getSelectorHeight", "getSelectorWidth", "onDraw", "Companion", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletRadio.kt */
public class WalletRadio extends WalletSelector {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: d */
    private static final int f35697d;

    /* renamed from: e */
    private static final int f35698e;

    /* renamed from: f */
    private static final float f35699f;

    /* renamed from: g */
    private static final float f35700g;

    /* renamed from: a */
    private final Lazy f35701a;

    /* renamed from: b */
    private final Lazy f35702b;

    /* renamed from: c */
    private final Lazy f35703c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletRadio(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletRadio(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletRadio(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletRadio(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/selector/WalletRadio$Companion;", "", "()V", "closeRadius", "", "radioHeight", "", "radioRadius", "radioWidth", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalletRadio.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletRadio(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f35701a = LazyKt.lazy(WalletRadio$borderPaint$2.INSTANCE);
        this.f35702b = LazyKt.lazy(WalletRadio$selectorPaint$2.INSTANCE);
        this.f35703c = LazyKt.lazy(WalletRadio$selectorPath$2.INSTANCE);
    }

    static {
        int intSize = UiUtils.Companion.intSize(40);
        f35697d = intSize;
        f35698e = intSize;
        float f = ((float) intSize) / 2.0f;
        f35699f = f;
        f35700g = f - UiUtils.Companion.floatSize(2);
    }

    public int getSelectorWidth() {
        return f35697d;
    }

    public int getSelectorHeight() {
        return f35698e;
    }

    /* access modifiers changed from: protected */
    public final Paint getBorderPaint() {
        return (Paint) this.f35701a.getValue();
    }

    private final Paint getSelectorPaint() {
        return (Paint) this.f35702b.getValue();
    }

    private final Path getSelectorPath() {
        return (Path) this.f35703c.getValue();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            drawBg(canvas);
            drawOther(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void drawBg(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float f = f35699f;
        Paint bgPaint = getBgPaint();
        bgPaint.setColor(getBgColor());
        Unit unit = Unit.INSTANCE;
        canvas.drawCircle(f, f, f, bgPaint);
    }

    /* access modifiers changed from: protected */
    public void drawOther(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int curType = getCurType();
        int i = -1;
        if (curType == 1) {
            if (!UiUtils.Companion.isWhiteInThemeBg()) {
                i = -16777216;
            }
            m26914a(canvas, i);
        } else if (curType == 2) {
            drawBorder(canvas, Color.parseColor("#D4D7D9"));
        } else if (curType == 3) {
            m26914a(canvas, ColorUtils.compositeColors(Color.parseColor("#66FFFFFF"), -1));
        } else if (curType == 4) {
            drawBorder(canvas, Color.parseColor("#E9EAEB"));
        }
    }

    /* renamed from: a */
    private final void m26914a(Canvas canvas, int i) {
        Path selectorPath = getSelectorPath();
        Paint selectorPaint = getSelectorPaint();
        selectorPaint.setColor(i);
        Unit unit = Unit.INSTANCE;
        canvas.drawPath(selectorPath, selectorPaint);
    }

    /* access modifiers changed from: protected */
    public void drawBorder(Canvas canvas, int i) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float f = f35699f;
        float f2 = f35700g;
        Paint borderPaint = getBorderPaint();
        borderPaint.setColor(i);
        Unit unit = Unit.INSTANCE;
        canvas.drawCircle(f, f, f2, borderPaint);
    }
}
