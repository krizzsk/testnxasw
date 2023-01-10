package com.didi.payment.kycservice.kyc.fragment;

import android.view.View;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.kycservice.kyc.SignUpVM;
import com.didi.payment.kycservice.kyc.response.GuidesInfoResp;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/payment/kycservice/kyc/fragment/FullKycExtraFragment$initListener$2", "Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;", "doClick", "", "v", "Landroid/view/View;", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FullKycExtraFragment.kt */
public final class FullKycExtraFragment$initListener$2 extends DoubleCheckOnClickListener {
    final /* synthetic */ FullKycExtraFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FullKycExtraFragment$initListener$2(FullKycExtraFragment fullKycExtraFragment) {
        super(800);
        this.this$0 = fullKycExtraFragment;
    }

    public void doClick(View view) {
        this.this$0.m25277b(1);
        FullKycExtraFragment fullKycExtraFragment = this.this$0;
        LinkedList<GuidesInfoResp.Income> access$getIncomeList$p = fullKycExtraFragment.f33259s;
        if (access$getIncomeList$p == null) {
            SignUpVM access$getPixSignUpVM$p = this.this$0.f33257q;
            if (access$getPixSignUpVM$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pixSignUpVM");
                access$getPixSignUpVM$p = null;
            }
            access$getIncomeList$p = access$getPixSignUpVM$p.getIncomeDetailList();
        }
        fullKycExtraFragment.f33259s = access$getIncomeList$p;
        if (this.this$0.f33259s != null) {
            this.this$0.m25281c();
        }
    }
}
