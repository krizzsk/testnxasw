package com.didi.payment.wallet_ui.form;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.payment.wallet_ui.UiUtils;
import com.didi.payment.wallet_ui.selector.OnSelectorClick;
import com.didi.payment.wallet_ui.selector.WalletSwitch;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ(\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/form/WalletFormItemSwitch;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mTvTitle", "Landroid/widget/TextView;", "mVSwitch", "Lcom/didi/payment/wallet_ui/selector/WalletSwitch;", "config", "", "title", "", "switchOpen", "", "onRadioClick", "Lcom/didi/payment/wallet_ui/selector/OnSelectorClick;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletFormItemSwitch.kt */
public final class WalletFormItemSwitch extends ConstraintLayout {

    /* renamed from: a */
    private TextView f35562a;

    /* renamed from: b */
    private WalletSwitch f35563b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletFormItemSwitch(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletFormItemSwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletFormItemSwitch(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletFormItemSwitch(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletFormItemSwitch(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.wallet_ui_form_item_switch, this);
        View findViewById = findViewById(R.id.v_switch);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.v_switch)");
        this.f35563b = (WalletSwitch) findViewById;
        View findViewById2 = findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_title)");
        this.f35562a = (TextView) findViewById2;
        setBackground(new ColorDrawable(-1));
    }

    public static /* synthetic */ void config$default(WalletFormItemSwitch walletFormItemSwitch, CharSequence charSequence, boolean z, OnSelectorClick onSelectorClick, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            onSelectorClick = null;
        }
        walletFormItemSwitch.config(charSequence, z, onSelectorClick);
    }

    public final void config(CharSequence charSequence, boolean z, OnSelectorClick onSelectorClick) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f35562a.setVisibility(8);
        } else {
            this.f35562a.setVisibility(0);
            this.f35562a.setText(charSequence);
        }
        this.f35563b.setVisibility(0);
        if (z) {
            this.f35563b.toOpen();
        } else {
            this.f35563b.toClose();
        }
        this.f35563b.setOnSelectorClickListener(onSelectorClick);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(UiUtils.Companion.getScreenWidth(), 1073741824), i2);
    }
}
