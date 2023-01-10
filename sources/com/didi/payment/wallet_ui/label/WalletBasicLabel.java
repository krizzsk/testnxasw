package com.didi.payment.wallet_ui.label;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.passenger.C11267R;
import com.didi.payment.wallet_ui.UiUtils;
import com.didi.payment.wallet_ui.label.WalletLabelStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u0007H\u0002J\u0012\u0010\r\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\u0007H\u0002J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0014R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/label/WalletBasicLabel;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "labelHeight", "configBg", "", "operationType", "configSize", "sizeType", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "Companion", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletBasicLabel.kt */
public final class WalletBasicLabel extends AppCompatTextView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int SIZE_BIG = 2;
    public static final int SIZE_SMALL = 1;
    public static final int TYPE_OPERATION_STRONG = 2;
    public static final int TYPE_OPERATION_WEAK = 1;

    /* renamed from: a */
    private int f35614a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletBasicLabel(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletBasicLabel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletBasicLabel(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 16842884 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletBasicLabel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
        setIncludeFontPadding(false);
        setGravity(17);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.WalletBasicLabel);
        m26904a(obtainStyledAttributes.getInt(0, 1));
        m26905b(obtainStyledAttributes.getInt(1, 1));
        obtainStyledAttributes.recycle();
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/label/WalletBasicLabel$Companion;", "", "()V", "SIZE_BIG", "", "SIZE_SMALL", "TYPE_OPERATION_STRONG", "TYPE_OPERATION_WEAK", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalletBasicLabel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: a */
    private final void m26904a(@WalletLabelStatus.BasicSizeType int i) {
        int i2;
        if (i == 1) {
            this.f35614a = UiUtils.Companion.intSize(28);
            i2 = UiUtils.Companion.intSize(12);
            setTextSize(0, UiUtils.Companion.floatSize(20));
        } else {
            this.f35614a = UiUtils.Companion.intSize(40);
            i2 = UiUtils.Companion.intSize(16);
            setTextSize(0, UiUtils.Companion.floatSize(28));
        }
        setPadding(i2, 0, i2, 0);
    }

    /* renamed from: b */
    private final void m26905b(@WalletLabelStatus.BasicLabelType int i) {
        if (i == 1) {
            setTextColor(Color.parseColor("#3FC790"));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(Color.parseColor("#1F3FC790"));
            gradientDrawable.setCornerRadius(((float) this.f35614a) / 2.0f);
            Unit unit = Unit.INSTANCE;
            setBackground(gradientDrawable);
        } else if (i == 2) {
            setTextColor(-1);
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor("#00CA79"), Color.parseColor("#02C79F")});
            gradientDrawable2.setCornerRadius(((float) this.f35614a) / 2.0f);
            Unit unit2 = Unit.INSTANCE;
            setBackground(gradientDrawable2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = this.f35614a;
        if (i3 > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        super.onMeasure(i, i2);
    }
}
