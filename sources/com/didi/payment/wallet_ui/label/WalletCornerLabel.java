package com.didi.payment.wallet_ui.label;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.passenger.C11267R;
import com.didi.payment.wallet_ui.UiUtils;
import com.didi.payment.wallet_ui.label.WalletLabelStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u0007H\u0002J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0014¨\u0006\u0010"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/label/WalletCornerLabel;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "configBg", "", "operationType", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "Companion", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletCornerLabel.kt */
public final class WalletCornerLabel extends AppCompatTextView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_STATUS_COMMON = 1;
    public static final int TYPE_STATUS_ERROR = 3;
    public static final int TYPE_STATUS_WARN = 2;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final int f35631a = Color.parseColor("#3FC790");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final int f35632b = Color.parseColor("#FCA009");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final int f35633c = Color.parseColor(ColorUtils.DIDI_RED);

    /* renamed from: d */
    private static final int f35634d = UiUtils.Companion.intSize(40);

    /* renamed from: e */
    private static final float f35635e;

    /* renamed from: f */
    private static final float[] f35636f;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletCornerLabel(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletCornerLabel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletCornerLabel(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 16842884 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletCornerLabel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
        setIncludeFontPadding(false);
        setGravity(17);
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextColor(-1);
        setTextSize(0, UiUtils.Companion.floatSize(20));
        int intSize = UiUtils.Companion.intSize(12);
        setPadding(intSize, 0, intSize, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.WalletCornerLabel);
        m26906a(obtainStyledAttributes.getInt(0, 1));
        obtainStyledAttributes.recycle();
    }

    @Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\t¨\u0006\u0013"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/label/WalletCornerLabel$Companion;", "", "()V", "TYPE_STATUS_COMMON", "", "TYPE_STATUS_ERROR", "TYPE_STATUS_WARN", "commonStatusBgColor", "getCommonStatusBgColor", "()I", "cornerRadiusArray", "", "errorStatusBgColor", "getErrorStatusBgColor", "labelCorner", "", "labelHeight", "midStatusBgColor", "getMidStatusBgColor", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalletCornerLabel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getCommonStatusBgColor() {
            return WalletCornerLabel.f35631a;
        }

        public final int getMidStatusBgColor() {
            return WalletCornerLabel.f35632b;
        }

        public final int getErrorStatusBgColor() {
            return WalletCornerLabel.f35633c;
        }
    }

    static {
        float floatSize = UiUtils.Companion.floatSize(40);
        f35635e = floatSize;
        f35636f = new float[]{floatSize, floatSize, floatSize, floatSize, 0.0f, 0.0f, floatSize, floatSize};
    }

    /* renamed from: a */
    private final void m26906a(@WalletLabelStatus.CornerStatus int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(f35636f);
        if (i == 1) {
            gradientDrawable.setColor(f35631a);
        } else if (i == 2) {
            gradientDrawable.setColor(f35632b);
        } else if (i == 3) {
            gradientDrawable.setColor(f35633c);
        }
        Unit unit = Unit.INSTANCE;
        setBackground(gradientDrawable);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(f35634d, 1073741824));
    }
}
