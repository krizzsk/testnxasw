package com.didi.payment.kycservice.kyc.fragment;

import android.text.Editable;
import com.didi.payment.kycservice.widget.NewPixInputView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/text/Editable;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: StepBaseInfoFragment.kt */
final class StepBaseInfoFragment$initListener$5 extends Lambda implements Function1<Editable, Unit> {
    final /* synthetic */ StepBaseInfoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StepBaseInfoFragment$initListener$5(StepBaseInfoFragment stepBaseInfoFragment) {
        super(1);
        this.this$0 = stepBaseInfoFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Editable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Editable editable) {
        if (editable != null) {
            StepBaseInfoFragment stepBaseInfoFragment = this.this$0;
            if (!StringsKt.isBlank(editable.toString())) {
                NewPixInputView newPixInputView = null;
                if (stepBaseInfoFragment.m25393i()) {
                    NewPixInputView access$getMNameInput$p = stepBaseInfoFragment.f33349e;
                    if (access$getMNameInput$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
                    } else {
                        newPixInputView = access$getMNameInput$p;
                    }
                    newPixInputView.hideErrorInfo();
                } else {
                    NewPixInputView access$getMNameInput$p2 = stepBaseInfoFragment.f33349e;
                    if (access$getMNameInput$p2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mNameInput");
                    } else {
                        newPixInputView = access$getMNameInput$p2;
                    }
                    String string = stepBaseInfoFragment.getString(R.string.Fintech_Payment_Optimization_Names_should_WgxS);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.Finte…zation_Names_should_WgxS)");
                    newPixInputView.showErrorInfo(string);
                }
            }
        }
        this.this$0.m25390f();
    }
}
