package com.didi.payment.pix.qrpayee.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.passenger.C11267R;
import com.didi.payment.commonsdk.p130ui.helper.NFloatInputHelper;
import com.didi.payment.pix.net.response.PixTransferOption;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001)B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\nJ\u0010\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u0012J\u000e\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u0016R\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, mo148868d2 = {"Lcom/didi/payment/pix/qrpayee/widget/AmountEditText;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "config", "Lcom/didi/payment/pix/net/response/PixTransferOption$TransferOptionInfo;", "getConfig", "()Lcom/didi/payment/pix/net/response/PixTransferOption$TransferOptionInfo;", "setConfig", "(Lcom/didi/payment/pix/net/response/PixTransferOption$TransferOptionInfo;)V", "etAmount", "Landroidx/appcompat/widget/AppCompatEditText;", "extraText", "", "floatInputHelper", "Lcom/didi/payment/commonsdk/ui/helper/NFloatInputHelper;", "innerWatcher", "Lcom/didi/payment/pix/qrpayee/widget/AmountEditText$IValueValidator;", "tvExtraInfo", "Landroid/widget/TextView;", "tvLabel", "getInputValue", "", "initAmountEditText", "", "initConfig", "configOption", "setDefaultExtraText", "text", "setEditable", "enable", "", "setLabelText", "charSequence", "setValueWatcher", "validator", "IValueValidator", "wallet-service-pix_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: AmountEditText.kt */
public final class AmountEditText extends ConstraintLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public IValueValidator f33717a;

    /* renamed from: b */
    private final TextView f33718b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AppCompatEditText f33719c;
    public PixTransferOption.TransferOptionInfo config;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final TextView f33720d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public NFloatInputHelper f33721e;

    /* renamed from: f */
    private CharSequence f33722f;

    @Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo148868d2 = {"Lcom/didi/payment/pix/qrpayee/widget/AmountEditText$IValueValidator;", "", "onValueChanged", "", "valid", "", "value", "", "wallet-service-pix_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: AmountEditText.kt */
    public interface IValueValidator {
        void onValueChanged(boolean z, String str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AmountEditText(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AmountEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AmountEditText(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AmountEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f33721e = new NFloatInputHelper();
        View.inflate(context, R.layout.common_amount_edit_lay, this);
        View findViewById = findViewById(R.id.amount_edit_label_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.amount_edit_label_tv)");
        this.f33718b = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.userinput_editview);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.userinput_editview)");
        this.f33719c = (AppCompatEditText) findViewById2;
        View findViewById3 = findViewById(R.id.value_exceed_tip_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.value_exceed_tip_tv)");
        this.f33720d = (TextView) findViewById3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.AmountEditText, i, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…ditText, defStyleAttr, 0)");
        String string = obtainStyledAttributes.getString(1);
        setLabelText(string == null ? "" : string);
        Unit unit = Unit.INSTANCE;
        obtainStyledAttributes.recycle();
        m25615a();
    }

    public final PixTransferOption.TransferOptionInfo getConfig() {
        PixTransferOption.TransferOptionInfo transferOptionInfo = this.config;
        if (transferOptionInfo != null) {
            return transferOptionInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("config");
        return null;
    }

    public final void setConfig(PixTransferOption.TransferOptionInfo transferOptionInfo) {
        Intrinsics.checkNotNullParameter(transferOptionInfo, "<set-?>");
        this.config = transferOptionInfo;
    }

    public final void initConfig(PixTransferOption.TransferOptionInfo transferOptionInfo) {
        Intrinsics.checkNotNullParameter(transferOptionInfo, "configOption");
        setConfig(transferOptionInfo);
    }

    public final void setEditable(boolean z) {
        this.f33719c.setEnabled(z);
    }

    public final void setLabelText(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        this.f33718b.setText(charSequence);
    }

    public final String getInputValue() {
        return String.valueOf(this.f33719c.getText());
    }

    /* renamed from: a */
    private final void m25615a() {
        this.f33719c.addTextChangedListener(new AmountEditText$initAmountEditText$1(this));
        this.f33719c.setFilters(new InputFilter[]{new NFloatInputHelper.NumberDecimalInputFilter(2, this.f33721e.decimalSeperatorBySys), new InputFilter.LengthFilter(10)});
    }

    public final void setDefaultExtraText(CharSequence charSequence) {
        this.f33722f = charSequence;
        this.f33720d.setText(charSequence);
        View view = this.f33720d;
        int i = 0;
        if (!(!(charSequence == null || charSequence.length() == 0))) {
            i = 8;
        }
        view.setVisibility(i);
        this.f33720d.setTextColor(-16777216);
    }

    public final void setValueWatcher(IValueValidator iValueValidator) {
        Intrinsics.checkNotNullParameter(iValueValidator, "validator");
        this.f33717a = iValueValidator;
    }
}
