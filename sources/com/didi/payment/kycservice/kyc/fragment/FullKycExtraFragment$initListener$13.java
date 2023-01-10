package com.didi.payment.kycservice.kyc.fragment;

import android.content.Context;
import com.didi.payment.kycservice.utils.KycSPUtils;
import com.didi.payment.kycservice.widget.NewPixInputView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FullKycExtraFragment.kt */
final class FullKycExtraFragment$initListener$13 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $phone;
    final /* synthetic */ FullKycExtraFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FullKycExtraFragment$initListener$13(FullKycExtraFragment fullKycExtraFragment, String str) {
        super(0);
        this.this$0 = fullKycExtraFragment;
        this.$phone = str;
    }

    public final void invoke() {
        Context context = this.this$0.getContext();
        if (context != null) {
            String str = this.$phone;
            FullKycExtraFragment fullKycExtraFragment = this.this$0;
            KycSPUtils.Companion companion = KycSPUtils.Companion;
            Intrinsics.checkNotNullExpressionValue(str, "phone");
            NewPixInputView access$getMNumberInput$p = fullKycExtraFragment.f33249i;
            if (access$getMNumberInput$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNumberInput");
                access$getMNumberInput$p = null;
            }
            companion.putApartmentNum(context, str, access$getMNumberInput$p.getInputStr());
        }
    }
}
