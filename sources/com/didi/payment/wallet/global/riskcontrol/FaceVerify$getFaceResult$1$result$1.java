package com.didi.payment.wallet.global.riskcontrol;

import com.didi.payment.wallet.global.riskcontrol.resp.FaceResultResp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H@"}, mo148868d2 = {"<anonymous>", "Lcom/didi/payment/wallet/global/riskcontrol/resp/FaceResultResp;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@DebugMetadata(mo23688c = "com.didi.payment.wallet.global.riskcontrol.FaceVerify$getFaceResult$1$result$1", mo23689f = "FaceVerify.kt", mo23690i = {}, mo23691l = {}, mo23692m = "invokeSuspend", mo23693n = {}, mo23694s = {})
/* compiled from: FaceVerify.kt */
final class FaceVerify$getFaceResult$1$result$1 extends SuspendLambda implements Function1<Continuation<? super FaceResultResp>, Object> {
    final /* synthetic */ String $sessionId;
    int label;
    final /* synthetic */ FaceVerify this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FaceVerify$getFaceResult$1$result$1(FaceVerify faceVerify, String str, Continuation<? super FaceVerify$getFaceResult$1$result$1> continuation) {
        super(1, continuation);
        this.this$0 = faceVerify;
        this.$sessionId = str;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new FaceVerify$getFaceResult$1$result$1(this.this$0, this.$sessionId, continuation);
    }

    public final Object invoke(Continuation<? super FaceResultResp> continuation) {
        return ((FaceVerify$getFaceResult$1$result$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.f34320f.getFaceResult(this.$sessionId, this.this$0.getScene());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
