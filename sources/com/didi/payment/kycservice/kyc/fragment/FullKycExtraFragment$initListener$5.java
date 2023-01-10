package com.didi.payment.kycservice.kyc.fragment;

import android.text.Editable;
import com.didi.payment.kycservice.widget.NewPixInputView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/text/Editable;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FullKycExtraFragment.kt */
final class FullKycExtraFragment$initListener$5 extends Lambda implements Function1<Editable, Unit> {
    final /* synthetic */ FullKycExtraFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FullKycExtraFragment$initListener$5(FullKycExtraFragment fullKycExtraFragment) {
        super(1);
        this.this$0 = fullKycExtraFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Editable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Editable editable) {
        if (editable != null) {
            FullKycExtraFragment fullKycExtraFragment = this.this$0;
            NewPixInputView newPixInputView = null;
            if (!StringsKt.isBlank(editable.toString())) {
                NewPixInputView access$getMNumberInput$p = fullKycExtraFragment.f33249i;
                if (access$getMNumberInput$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                } else {
                    newPixInputView = access$getMNumberInput$p;
                }
                newPixInputView.hideCheckBox();
            } else {
                NewPixInputView access$getMNumberInput$p2 = fullKycExtraFragment.f33249i;
                if (access$getMNumberInput$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                } else {
                    newPixInputView = access$getMNumberInput$p2;
                }
                newPixInputView.showCheckBox();
            }
        }
        this.this$0.m25283e();
    }
}
