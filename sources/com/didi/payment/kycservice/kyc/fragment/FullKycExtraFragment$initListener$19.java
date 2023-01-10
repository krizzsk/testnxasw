package com.didi.payment.kycservice.kyc.fragment;

import com.didi.payment.kycservice.kyc.SignUpVM;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FullKycExtraFragment.kt */
final class FullKycExtraFragment$initListener$19 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FullKycExtraFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FullKycExtraFragment$initListener$19(FullKycExtraFragment fullKycExtraFragment) {
        super(0);
        this.this$0 = fullKycExtraFragment;
    }

    public final void invoke() {
        SignUpVM access$getPixSignUpVM$p = this.this$0.f33257q;
        SignUpVM signUpVM = null;
        if (access$getPixSignUpVM$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            access$getPixSignUpVM$p = null;
        }
        access$getPixSignUpVM$p.onPreClick(KycFormStep.STEP_INCOME);
        SignUpVM access$getPixSignUpVM$p2 = this.this$0.f33257q;
        if (access$getPixSignUpVM$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
        } else {
            signUpVM = access$getPixSignUpVM$p2;
        }
        signUpVM.updateStepProgress(KycFormStep.STEP_CPF);
    }
}
