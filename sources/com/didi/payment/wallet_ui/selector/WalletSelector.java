package com.didi.payment.wallet_ui.selector;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.didi.passenger.C11267R;
import com.didi.payment.wallet_ui.UiUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 .2\u00020\u0001:\u0001.B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010 \u001a\u00020\u0007H\u0004J\b\u0010!\u001a\u00020\u0007H&J\b\u0010\"\u001a\u00020\u0007H&J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0014J\u0010\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010)J\u0006\u0010*\u001a\u00020$J\u0006\u0010+\u001a\u00020$J\u0006\u0010,\u001a\u00020$J\u0006\u0010-\u001a\u00020$R\u001b\u0010\n\u001a\u00020\u000b8DX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00078\u0006@BX\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0012R \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u001a8F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/selector/WalletSelector;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "bgPaint", "Landroid/graphics/Paint;", "getBgPaint", "()Landroid/graphics/Paint;", "bgPaint$delegate", "Lkotlin/Lazy;", "closeBgColor", "getCloseBgColor", "()I", "setCloseBgColor", "(I)V", "<set-?>", "curType", "getCurType$annotations", "()V", "getCurType", "", "isSelect", "()Z", "lockCloseBgColor", "lockOpenBgColor", "openBgColor", "getBgColor", "getSelectorHeight", "getSelectorWidth", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setOnSelectorClickListener", "listener", "Lcom/didi/payment/wallet_ui/selector/OnSelectorClick;", "toClose", "toLockClose", "toLockOpen", "toOpen", "Companion", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletSelector.kt */
public abstract class WalletSelector extends View {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_CLOSE = 2;
    public static final int TYPE_LOCK_CLOSE = 4;
    public static final int TYPE_LOCK_OPEN = 3;
    public static final int TYPE_OPEN = 1;

    /* renamed from: a */
    private int f35704a;

    /* renamed from: b */
    private boolean f35705b;

    /* renamed from: c */
    private final Lazy f35706c;

    /* renamed from: d */
    private int f35707d;

    /* renamed from: e */
    private int f35708e;

    /* renamed from: f */
    private int f35709f;

    /* renamed from: g */
    private int f35710g;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletSelector(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletSelector(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletSelector(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @WalletSelectorType
    public static /* synthetic */ void getCurType$annotations() {
    }

    public abstract int getSelectorHeight();

    public abstract int getSelectorWidth();

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletSelector(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletSelector(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.WalletSelector);
        boolean z = false;
        this.f35704a = obtainStyledAttributes.getInt(0, 2);
        obtainStyledAttributes.recycle();
        this.f35704a = 2;
        this.f35705b = (2 == 1 || 2 == 3) ? true : z;
        this.f35706c = LazyKt.lazy(WalletSelector$bgPaint$2.INSTANCE);
        this.f35707d = UiUtils.Companion.getThemeBgColor();
        this.f35708e = -1;
        this.f35709f = ColorUtils.compositeColors(UiUtils.Companion.getThemeBgColor(), Color.parseColor("#66FFFFFF"));
        this.f35710g = Color.parseColor(com.didi.dcrypto.util.ColorUtils.DIDI_GREY);
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/selector/WalletSelector$Companion;", "", "()V", "TYPE_CLOSE", "", "TYPE_LOCK_CLOSE", "TYPE_LOCK_OPEN", "TYPE_OPEN", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalletSelector.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void toOpen() {
        this.f35704a = 1;
        invalidate();
    }

    public final void toClose() {
        this.f35704a = 2;
        invalidate();
    }

    public final void toLockOpen() {
        this.f35704a = 3;
        invalidate();
    }

    public final void toLockClose() {
        this.f35704a = 4;
        invalidate();
    }

    public final int getCurType() {
        return this.f35704a;
    }

    public final boolean isSelect() {
        int i = this.f35704a;
        return i == 1 || i == 3;
    }

    /* access modifiers changed from: protected */
    public final Paint getBgPaint() {
        return (Paint) this.f35706c.getValue();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(getSelectorWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getSelectorHeight(), 1073741824));
    }

    /* access modifiers changed from: protected */
    public int getCloseBgColor() {
        return this.f35708e;
    }

    /* access modifiers changed from: protected */
    public void setCloseBgColor(int i) {
        this.f35708e = i;
    }

    /* access modifiers changed from: protected */
    public final int getBgColor() {
        int i = this.f35704a;
        if (i == 1) {
            return this.f35707d;
        }
        if (i == 2) {
            return getCloseBgColor();
        }
        if (i == 3) {
            return this.f35709f;
        }
        if (i != 4) {
            return this.f35707d;
        }
        return this.f35710g;
    }

    public final void setOnSelectorClickListener(OnSelectorClick onSelectorClick) {
        if (onSelectorClick == null) {
            setOnClickListener((View.OnClickListener) null);
        } else {
            setOnClickListener(new View.OnClickListener(this) {
                public final /* synthetic */ WalletSelector f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    WalletSelector.m26915a(OnSelectorClick.this, this.f$1, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26915a(OnSelectorClick onSelectorClick, WalletSelector walletSelector, View view) {
        Intrinsics.checkNotNullParameter(walletSelector, "this$0");
        if (!onSelectorClick.onClick(walletSelector)) {
            return;
        }
        if (walletSelector.getCurType() == 1) {
            walletSelector.toClose();
        } else if (walletSelector.getCurType() == 2) {
            walletSelector.toOpen();
        }
    }
}
