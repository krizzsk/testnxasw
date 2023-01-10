package com.didi.payment.kycservice.kyc.fragment;

import android.content.Context;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.kycservice.kyc.p134vm.FullKycExtraVM;
import com.didi.payment.kycservice.kyc.response.GuidesInfoResp;
import com.didi.payment.kycservice.utils.KycSPUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: StepIncomeInfoFragment.kt */
final class StepIncomeInfoFragment$initListener$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StepIncomeInfoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StepIncomeInfoFragment$initListener$1(StepIncomeInfoFragment stepIncomeInfoFragment) {
        super(0);
        this.this$0 = stepIncomeInfoFragment;
    }

    public final void invoke() {
        ArrayList arrayList = new ArrayList();
        ArrayList access$getIncomeList$p = this.this$0.f33372h;
        if (access$getIncomeList$p != null) {
            int i = 0;
            for (Object next : access$getIncomeList$p) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (((GuidesInfoResp.Income) next).getSelected()) {
                    arrayList.add(Integer.valueOf(i2));
                }
                i = i2;
            }
        }
        arrayList.add(6);
        KycOmega.Companion.trackEvent("fin_table2_income_ck", MapsKt.mutableMapOf(TuplesKt.m41339to("button_name", arrayList.toString())));
        GuidesInfoResp.Income access$getIncomeSelect$p = this.this$0.f33373i;
        if (access$getIncomeSelect$p != null) {
            StepIncomeInfoFragment stepIncomeInfoFragment = this.this$0;
            Context context = stepIncomeInfoFragment.getContext();
            if (context != null) {
                KycSPUtils.Companion.putIncome(context, access$getIncomeSelect$p);
            }
            FullKycExtraVM access$getMExtraVM$p = stepIncomeInfoFragment.f33369e;
            FullKycExtraVM fullKycExtraVM = null;
            if (access$getMExtraVM$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mExtraVM");
                access$getMExtraVM$p = null;
            }
            access$getMExtraVM$p.setIncomeType(access$getIncomeSelect$p.getType());
            FullKycExtraVM access$getMExtraVM$p2 = stepIncomeInfoFragment.f33369e;
            if (access$getMExtraVM$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mExtraVM");
            } else {
                fullKycExtraVM = access$getMExtraVM$p2;
            }
            fullKycExtraVM.onNextClick(KycFormStep.STEP_ADDRESS);
        }
    }
}
