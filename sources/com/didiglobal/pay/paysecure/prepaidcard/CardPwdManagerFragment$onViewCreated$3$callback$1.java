package com.didiglobal.pay.paysecure.prepaidcard;

import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import com.didi.payment.wallet.global.prepaidcard.PrepaidConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo148868d2 = {"<anonymous>", "", "res", "Lcom/didi/drouter/router/Result;", "onResult"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: CardPwdManagerFragment.kt */
final class CardPwdManagerFragment$onViewCreated$3$callback$1 implements RouterCallback {
    final /* synthetic */ CardPwdManagerFragment$onViewCreated$3 this$0;

    CardPwdManagerFragment$onViewCreated$3$callback$1(CardPwdManagerFragment$onViewCreated$3 cardPwdManagerFragment$onViewCreated$3) {
        this.this$0 = cardPwdManagerFragment$onViewCreated$3;
    }

    public final void onResult(Result result) {
        Intrinsics.checkParameterIsNotNull(result, "res");
        this.this$0.this$0.getCardLoading().hideLoading();
        if (result.getInt("result") == 1) {
            this.this$0.this$0.setSessionId(result.getString("session_id"));
            CardPwdManager.startFragment$default(CardPwdManager.INSTANCE, this.this$0.this$0.getFragmentManager(), 5, false, this.this$0.this$0.getCardId(), this.this$0.this$0.getSessionId(), PrepaidConstant.SCENE_FORGET_PASSWORD, (String) null, 68, (Object) null);
        }
    }
}
