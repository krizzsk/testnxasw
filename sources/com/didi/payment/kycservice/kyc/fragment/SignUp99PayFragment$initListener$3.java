package com.didi.payment.kycservice.kyc.fragment;

import android.view.View;
import android.view.ViewGroup;
import com.didi.payment.kycservice.kyc.SignUpVM;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SignUp99PayFragment.kt */
final class SignUp99PayFragment$initListener$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SignUp99PayFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignUp99PayFragment$initListener$3(SignUp99PayFragment signUp99PayFragment) {
        super(0);
        this.this$0 = signUp99PayFragment;
    }

    public final void invoke() {
        this.this$0.m25326b();
        SignUpVM access$getPixSignUpVM$p = this.this$0.f33309u;
        ViewGroup viewGroup = null;
        if (access$getPixSignUpVM$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
            access$getPixSignUpVM$p = null;
        }
        access$getPixSignUpVM$p.updateStepProgress(KycFormStep.STEP_CPF);
        ViewGroup access$getMContentView$p = this.this$0.f33289a;
        if (access$getMContentView$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
        } else {
            viewGroup = access$getMContentView$p;
        }
        viewGroup.setVisibility(0);
        View access$getMFaceGuideView$p = this.this$0.f33302n;
        if (access$getMFaceGuideView$p != null) {
            access$getMFaceGuideView$p.setVisibility(8);
        }
    }
}
