package com.didi.payment.kycservice.kyc.fragment;

import android.text.Editable;
import com.didi.payment.kycservice.widget.NewPixInputView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/text/Editable;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SignUp99PayFragment.kt */
final class SignUp99PayFragment$initListener$6 extends Lambda implements Function1<Editable, Unit> {
    final /* synthetic */ SignUp99PayFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignUp99PayFragment$initListener$6(SignUp99PayFragment signUp99PayFragment) {
        super(1);
        this.this$0 = signUp99PayFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Editable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Editable editable) {
        NewPixInputView access$getMCPFInput$p = this.this$0.f33292d;
        NewPixInputView newPixInputView = null;
        if (access$getMCPFInput$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
            access$getMCPFInput$p = null;
        }
        if (access$getMCPFInput$p.getInputStr().length() == 14) {
            if (this.this$0.m25341h()) {
                NewPixInputView access$getMCPFInput$p2 = this.this$0.f33292d;
                if (access$getMCPFInput$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
                } else {
                    newPixInputView = access$getMCPFInput$p2;
                }
                newPixInputView.hideErrorInfo();
            } else {
                NewPixInputView access$getMCPFInput$p3 = this.this$0.f33292d;
                if (access$getMCPFInput$p3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCPFInput");
                } else {
                    newPixInputView = access$getMCPFInput$p3;
                }
                String string = this.this$0.getString(R.string.Fintech_Payment_Optimization_Please_fill_zqsp);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.Finte…ization_Please_fill_zqsp)");
                newPixInputView.showErrorInfo(string);
            }
        }
        this.this$0.m25338f();
    }
}
