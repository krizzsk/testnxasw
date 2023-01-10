package com.didi.payment.wallet.global.prepaidcard;

import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeTrackerManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/payment/wallet/global/prepaidcard/PrepaidSettingActivity$initData$adapter$1$onItemClick$listener$2", "Lcom/didi/drouter/router/RouterCallback;", "onResult", "", "result", "Lcom/didi/drouter/router/Result;", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PrepaidSettingActivity.kt */
public final class PrepaidSettingActivity$initData$adapter$1$onItemClick$listener$2 implements RouterCallback {
    final /* synthetic */ String $source;
    final /* synthetic */ PrepaidSettingActivity this$0;

    PrepaidSettingActivity$initData$adapter$1$onItemClick$listener$2(PrepaidSettingActivity prepaidSettingActivity, String str) {
        this.this$0 = prepaidSettingActivity;
        this.$source = str;
    }

    public void onResult(Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getInt("result") == 3) {
            PrepaidCardManager.Companion.start(this.this$0, this.$source, PrepaidConstant.SCENE_APPLY, WalletHomeTrackerManager.Companion.getStatus(), "1", this.this$0.getCardId(), this);
        } else {
            this.this$0.dismissLoadingDialog();
        }
    }
}
