package com.didi.payment.kycservice.kyc.fragment;

import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.kycservice.kyc.p134vm.SignUp99PayVM;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: StepBaseInfoFragment.kt */
final class StepBaseInfoFragment$initListener$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StepBaseInfoFragment this$0;

    @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: StepBaseInfoFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KycFormStep.values().length];
            iArr[KycFormStep.STEP_NAME.ordinal()] = 1;
            iArr[KycFormStep.STEP_DATE.ordinal()] = 2;
            iArr[KycFormStep.STEP_CPF.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StepBaseInfoFragment$initListener$2(StepBaseInfoFragment stepBaseInfoFragment) {
        super(0);
        this.this$0 = stepBaseInfoFragment;
    }

    public final void invoke() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.this$0.f33361q.ordinal()];
        SignUp99PayVM signUp99PayVM = null;
        if (i == 1) {
            KycOmega.Companion.trackEvent("fin_table2_name_ck");
            SignUp99PayVM access$getMSignUpVM$p = this.this$0.f33357m;
            if (access$getMSignUpVM$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSignUpVM");
            } else {
                signUp99PayVM = access$getMSignUpVM$p;
            }
            signUp99PayVM.onNextClick(this.this$0.f33362r);
        } else if (i == 2) {
            KycOmega.Companion.trackEvent("fin_table2_birthday_ck");
            SignUp99PayVM access$getMSignUpVM$p2 = this.this$0.f33357m;
            if (access$getMSignUpVM$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSignUpVM");
            } else {
                signUp99PayVM = access$getMSignUpVM$p2;
            }
            signUp99PayVM.onNextClick(this.this$0.f33362r);
        } else if (i == 3) {
            KycOmega.Companion.trackEvent("fin_table2_cpf_ck");
            this.this$0.m25386b();
        }
    }
}
