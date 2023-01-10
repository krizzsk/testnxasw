package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.handler;

import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

@Metadata(mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H@"}, mo148868d2 = {"<anonymous>", "Lcom/didi/payment/wallet/global/prepaidcard/resp/OpenSessionResp;", "kotlin.jvm.PlatformType"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@DebugMetadata(mo23688c = "com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$handle$1$resp$1", mo23689f = "WalletOpenSessionHandler.kt", mo23690i = {}, mo23691l = {}, mo23692m = "invokeSuspend", mo23693n = {}, mo23694s = {})
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$handle$1$resp$1 */
/* compiled from: WalletOpenSessionHandler.kt */
final class WalletOpenSessionHandler$handle$1$resp$1 extends SuspendLambda implements Function1<Continuation<? super OpenSessionResp>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $cardId;
    final /* synthetic */ WalletPageModel $netModel;
    final /* synthetic */ String $scene;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletOpenSessionHandler$handle$1$resp$1(WalletPageModel walletPageModel, String str, Ref.ObjectRef<String> objectRef, Continuation<? super WalletOpenSessionHandler$handle$1$resp$1> continuation) {
        super(1, continuation);
        this.$netModel = walletPageModel;
        this.$scene = str;
        this.$cardId = objectRef;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new WalletOpenSessionHandler$handle$1$resp$1(this.$netModel, this.$scene, this.$cardId, continuation);
    }

    public final Object invoke(Continuation<? super OpenSessionResp> continuation) {
        return ((WalletOpenSessionHandler$handle$1$resp$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.$netModel.openSession(this.$scene, (String) this.$cardId.element);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
