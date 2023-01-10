package com.didi.map.global.sctx.event_reveal;

import android.graphics.Bitmap;
import com.didi.map.utils.BitmapUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo148868d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@DebugMetadata(mo23688c = "com.didi.map.global.sctx.event_reveal.TrafficEventsController$tryAddTrafficEventMarkers$2$2$1$1$scaleBitmap$1", mo23689f = "TrafficEventsController.kt", mo23690i = {}, mo23691l = {}, mo23692m = "invokeSuspend", mo23693n = {}, mo23694s = {})
/* renamed from: com.didi.map.global.sctx.event_reveal.TrafficEventsController$tryAddTrafficEventMarkers$2$2$1$1$scaleBitmap$1 */
/* compiled from: TrafficEventsController.kt */
final class C10634xcaf74e7c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C10634xcaf74e7c(Bitmap bitmap, Continuation<? super C10634xcaf74e7c> continuation) {
        super(2, continuation);
        this.$bitmap = bitmap;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C10634xcaf74e7c(this.$bitmap, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return ((C10634xcaf74e7c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return BitmapUtil.INSTANCE.scaleBitmap(this.$bitmap, 1.5f);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
