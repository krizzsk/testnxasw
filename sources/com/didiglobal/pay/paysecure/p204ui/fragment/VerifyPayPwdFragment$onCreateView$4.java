package com.didiglobal.pay.paysecure.p204ui.fragment;

import com.didiglobal.pay.paysecure.p204ui.view.InputResultListener;
import com.didiglobal.pay.paysecure.util.PaySecurePref;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo148868d2 = {"com/didiglobal/pay/paysecure/ui/fragment/VerifyPayPwdFragment$onCreateView$4", "Lcom/didiglobal/pay/paysecure/ui/view/InputResultListener;", "onChange", "", "onResult", "result", "", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.fragment.VerifyPayPwdFragment$onCreateView$4 */
/* compiled from: VerifyPayPwdFragment.kt */
public final class VerifyPayPwdFragment$onCreateView$4 implements InputResultListener {
    final /* synthetic */ VerifyPayPwdFragment this$0;

    public void onChange() {
    }

    VerifyPayPwdFragment$onCreateView$4(VerifyPayPwdFragment verifyPayPwdFragment) {
        this.this$0 = verifyPayPwdFragment;
    }

    public void onResult(String str) {
        Intrinsics.checkParameterIsNotNull(str, "result");
        if (str.length() >= PaySecurePref.INSTANCE.getPwdCount()) {
            this.this$0.m39687a(str);
        }
    }
}
