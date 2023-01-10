package com.didi.payment.wallet.global.prepaidcard.interceptor;

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

@Metadata(mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H@"}, mo148868d2 = {"<anonymous>", "Lcom/didi/payment/wallet/global/prepaidcard/resp/OpenSessionResp;", "kotlin.jvm.PlatformType"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@DebugMetadata(mo23688c = "com.didi.payment.wallet.global.prepaidcard.interceptor.IOpenSessionInterceptor$onInterceptor$1$resp$1", mo23689f = "IOpenSessionInterceptor.kt", mo23690i = {}, mo23691l = {}, mo23692m = "invokeSuspend", mo23693n = {}, mo23694s = {})
/* compiled from: IOpenSessionInterceptor.kt */
final class IOpenSessionInterceptor$onInterceptor$1$resp$1 extends SuspendLambda implements Function1<Continuation<? super OpenSessionResp>, Object> {
    final /* synthetic */ String $cardId;
    final /* synthetic */ WalletPageModel $netModel;
    final /* synthetic */ String $scene;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IOpenSessionInterceptor$onInterceptor$1$resp$1(WalletPageModel walletPageModel, String str, String str2, Continuation<? super IOpenSessionInterceptor$onInterceptor$1$resp$1> continuation) {
        super(1, continuation);
        this.$netModel = walletPageModel;
        this.$scene = str;
        this.$cardId = str2;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new IOpenSessionInterceptor$onInterceptor$1$resp$1(this.$netModel, this.$scene, this.$cardId, continuation);
    }

    public final Object invoke(Continuation<? super OpenSessionResp> continuation) {
        return ((IOpenSessionInterceptor$onInterceptor$1$resp$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.$netModel.openSession(this.$scene, this.$cardId);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
