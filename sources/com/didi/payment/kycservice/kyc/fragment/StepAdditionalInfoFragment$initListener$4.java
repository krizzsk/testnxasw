package com.didi.payment.kycservice.kyc.fragment;

import android.text.Editable;
import android.widget.LinearLayout;
import com.didi.payment.commonsdk.utils.KycOmega;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/text/Editable;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: StepAdditionalInfoFragment.kt */
final class StepAdditionalInfoFragment$initListener$4 extends Lambda implements Function1<Editable, Unit> {
    final /* synthetic */ StepAdditionalInfoFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StepAdditionalInfoFragment$initListener$4(StepAdditionalInfoFragment stepAdditionalInfoFragment) {
        super(1);
        this.this$0 = stepAdditionalInfoFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Editable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Editable editable) {
        if (editable != null) {
            StepAdditionalInfoFragment stepAdditionalInfoFragment = this.this$0;
            if (editable.toString().length() == 8) {
                StepAdditionalInfoFragment.access$getVm(stepAdditionalInfoFragment).requestAddress(editable.toString());
                LinearLayout access$getMExpandInfoContainer$p = stepAdditionalInfoFragment.f33329c;
                if (access$getMExpandInfoContainer$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mExpandInfoContainer");
                    access$getMExpandInfoContainer$p = null;
                }
                access$getMExpandInfoContainer$p.setVisibility(0);
                KycOmega.Companion.trackEvent("fin_table2_code2_sw");
            }
        }
        this.this$0.m25372d();
    }
}
