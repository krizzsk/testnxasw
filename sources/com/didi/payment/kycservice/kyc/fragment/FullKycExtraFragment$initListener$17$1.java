package com.didi.payment.kycservice.kyc.fragment;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.didi.drouter.router.RouterCallback;
import com.didi.payment.kycservice.utils.KycSPUtils;
import com.didi.payment.kycservice.widget.NewPixInputView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo148868d2 = {"com/didi/payment/kycservice/kyc/fragment/FullKycExtraFragment$initListener$17$1", "Lcom/didi/drouter/router/RouterCallback$ActivityCallback;", "onActivityResult", "", "resultCode", "", "data", "Landroid/content/Intent;", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FullKycExtraFragment.kt */
public final class FullKycExtraFragment$initListener$17$1 extends RouterCallback.ActivityCallback {
    final /* synthetic */ String $phone;
    final /* synthetic */ FullKycExtraFragment this$0;

    FullKycExtraFragment$initListener$17$1(FullKycExtraFragment fullKycExtraFragment, String str) {
        this.this$0 = fullKycExtraFragment;
        this.$phone = str;
    }

    public void onActivityResult(int i, Intent intent) {
        String str;
        if (intent == null || (str = intent.getStringExtra("result")) == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            NewPixInputView access$getMStateInput$p = this.this$0.f33252l;
            NewPixInputView newPixInputView = null;
            if (access$getMStateInput$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
                access$getMStateInput$p = null;
            }
            if (!Intrinsics.areEqual((Object) str, (Object) access$getMStateInput$p.getInputStr())) {
                NewPixInputView access$getMCityInput$p = this.this$0.f33253m;
                if (access$getMCityInput$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCityInput");
                    access$getMCityInput$p = null;
                }
                access$getMCityInput$p.setInputStr("");
            }
            NewPixInputView access$getMStateInput$p2 = this.this$0.f33252l;
            if (access$getMStateInput$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
                access$getMStateInput$p2 = null;
            }
            access$getMStateInput$p2.setInputStr(str);
            Context context = this.this$0.getContext();
            if (context != null) {
                String str2 = this.$phone;
                FullKycExtraFragment fullKycExtraFragment = this.this$0;
                KycSPUtils.Companion companion = KycSPUtils.Companion;
                Intrinsics.checkNotNullExpressionValue(str2, "phone");
                NewPixInputView access$getMStateInput$p3 = fullKycExtraFragment.f33252l;
                if (access$getMStateInput$p3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStateInput");
                } else {
                    newPixInputView = access$getMStateInput$p3;
                }
                companion.putState(context, str2, newPixInputView.getInputStr());
            }
        }
    }
}
