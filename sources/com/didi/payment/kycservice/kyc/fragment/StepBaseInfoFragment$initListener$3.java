package com.didi.payment.kycservice.kyc.fragment;

import com.didi.payment.kycservice.kyc.SignUpVM;
import com.didi.payment.kycservice.kyc.p134vm.SignUp99PayVM;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: StepBaseInfoFragment.kt */
final class StepBaseInfoFragment$initListener$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StepBaseInfoFragment this$0;

    @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: StepBaseInfoFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KycFormStep.values().length];
            iArr[KycFormStep.STEP_DATE.ordinal()] = 1;
            iArr[KycFormStep.STEP_CPF.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StepBaseInfoFragment$initListener$3(StepBaseInfoFragment stepBaseInfoFragment) {
        super(0);
        this.this$0 = stepBaseInfoFragment;
    }

    public final void invoke() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.this$0.f33361q.ordinal()];
        SignUp99PayVM signUp99PayVM = null;
        if (i == 1) {
            SignUpVM access$getPixSignUpVM$p = this.this$0.f33358n;
            if (access$getPixSignUpVM$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                access$getPixSignUpVM$p = null;
            }
            access$getPixSignUpVM$p.updateStepProgress(KycFormStep.STEP_NAME);
        } else if (i != 2) {
            SignUpVM access$getPixSignUpVM$p2 = this.this$0.f33358n;
            if (access$getPixSignUpVM$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                access$getPixSignUpVM$p2 = null;
            }
            access$getPixSignUpVM$p2.updateStepProgress(KycFormStep.STEP_NAME);
        } else {
            SignUpVM access$getPixSignUpVM$p3 = this.this$0.f33358n;
            if (access$getPixSignUpVM$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                access$getPixSignUpVM$p3 = null;
            }
            access$getPixSignUpVM$p3.updateStepProgress(KycFormStep.STEP_DATE);
        }
        SignUp99PayVM access$getMSignUpVM$p = this.this$0.f33357m;
        if (access$getMSignUpVM$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSignUpVM");
        } else {
            signUp99PayVM = access$getMSignUpVM$p;
        }
        signUp99PayVM.onPreClick(true);
    }
}
