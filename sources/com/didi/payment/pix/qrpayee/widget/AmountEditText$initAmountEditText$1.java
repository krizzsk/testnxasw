package com.didi.payment.pix.qrpayee.widget;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.didi.payment.base.utils.MathUtil;
import com.didi.payment.pix.qrpayee.widget.AmountEditText;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, mo148868d2 = {"com/didi/payment/pix/qrpayee/widget/AmountEditText$initAmountEditText$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "wallet-service-pix_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: AmountEditText.kt */
public final class AmountEditText$initAmountEditText$1 implements TextWatcher {
    final /* synthetic */ AmountEditText this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    AmountEditText$initAmountEditText$1(AmountEditText amountEditText) {
        this.this$0 = amountEditText;
    }

    public void afterTextChanged(Editable editable) {
        String valueOf = String.valueOf(editable);
        CharSequence charSequence = valueOf;
        AmountEditText.IValueValidator iValueValidator = null;
        if (TextUtils.isEmpty(charSequence)) {
            AmountEditText.IValueValidator access$getInnerWatcher$p = this.this$0.f33717a;
            if (access$getInnerWatcher$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("innerWatcher");
            } else {
                iValueValidator = access$getInnerWatcher$p;
            }
            iValueValidator.onValueChanged(false, "");
            return;
        }
        if (StringsKt.startsWith$default(valueOf, "0", false, 2, (Object) null)) {
            String str = this.this$0.f33721e.decimalSeperatorBySys;
            Intrinsics.checkNotNullExpressionValue(str, "floatInputHelper.decimalSeperatorBySys");
            if (StringsKt.indexOf$default(charSequence, str, 0, false, 6, (Object) null) == -1) {
                AmountEditText.IValueValidator access$getInnerWatcher$p2 = this.this$0.f33717a;
                if (access$getInnerWatcher$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("innerWatcher");
                } else {
                    iValueValidator = access$getInnerWatcher$p2;
                }
                iValueValidator.onValueChanged(false, "");
                return;
            }
        }
        AmountEditText amountEditText = this.this$0;
        float parseFloatValue = amountEditText.f33721e.parseFloatValue(valueOf);
        if (parseFloatValue <= 0.0f) {
            AmountEditText.IValueValidator access$getInnerWatcher$p3 = amountEditText.f33717a;
            if (access$getInnerWatcher$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("innerWatcher");
            } else {
                iValueValidator = access$getInnerWatcher$p3;
            }
            iValueValidator.onValueChanged(false, "");
            return;
        }
        if (MathUtil.dollarToCent(parseFloatValue) > amountEditText.getConfig().getUserAvailableAmount()) {
            amountEditText.f33720d.setVisibility(0);
            amountEditText.f33719c.setTextColor(amountEditText.getResources().getColor(R.color.global_red));
            AmountEditText.IValueValidator access$getInnerWatcher$p4 = amountEditText.f33717a;
            if (access$getInnerWatcher$p4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("innerWatcher");
            } else {
                iValueValidator = access$getInnerWatcher$p4;
            }
            iValueValidator.onValueChanged(false, valueOf);
            return;
        }
        amountEditText.f33719c.setTextColor(-16777216);
        AmountEditText.IValueValidator access$getInnerWatcher$p5 = amountEditText.f33717a;
        if (access$getInnerWatcher$p5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerWatcher");
        } else {
            iValueValidator = access$getInnerWatcher$p5;
        }
        iValueValidator.onValueChanged(true, "");
    }
}
