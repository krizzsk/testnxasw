package com.didi.map.global.sctx.event_reveal;

import android.graphics.Bitmap;
import com.didi.common.map.util.DLog;
import com.didi.map.sdk.proto.driver_gl.event.ShowEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TrafficEventsController.kt */
final class TrafficEventsController$tryAddTrafficEventMarkers$2$2$1 extends Lambda implements Function1<Bitmap, Unit> {
    final /* synthetic */ ShowEvent $event;
    final /* synthetic */ String $iconUrl;
    final /* synthetic */ TrafficEventsController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrafficEventsController$tryAddTrafficEventMarkers$2$2$1(TrafficEventsController trafficEventsController, ShowEvent showEvent, String str) {
        super(1);
        this.this$0 = trafficEventsController;
        this.$event = showEvent;
        this.$iconUrl = str;
    }

    @Metadata(mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo148868d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    @DebugMetadata(mo23688c = "com.didi.map.global.sctx.event_reveal.TrafficEventsController$tryAddTrafficEventMarkers$2$2$1$1", mo23689f = "TrafficEventsController.kt", mo23690i = {}, mo23691l = {366}, mo23692m = "invokeSuspend", mo23693n = {}, mo23694s = {})
    /* renamed from: com.didi.map.global.sctx.event_reveal.TrafficEventsController$tryAddTrafficEventMarkers$2$2$1$1 */
    /* compiled from: TrafficEventsController.kt */
    static final class C106331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C106331(bitmap2, trafficEventsController, showEvent, str, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C106331) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (bitmap2 != null) {
                    Dispatchers dispatchers = Dispatchers.INSTANCE;
                    this.label = 1;
                    obj = BuildersKt.withContext(Dispatchers.getDefault(), new C10634xcaf74e7c(bitmap2, (Continuation<? super C10634xcaf74e7c>) null), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    String access$getTAG$p = trafficEventsController.f30052g;
                    DLog.m10773d(access$getTAG$p, "[Error] when download event icon|eventID:" + showEvent.eventId + "|url:" + str, new Object[0]);
                    return Unit.INSTANCE;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Bitmap bitmap = (Bitmap) obj;
            if (bitmap != null) {
                trafficEventsController.m23422a(showEvent, bitmap);
            }
            return Unit.INSTANCE;
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Bitmap) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Bitmap bitmap) {
        CoroutineScope access$getUiCoroutineScope$p = this.this$0.f30056k;
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        final TrafficEventsController trafficEventsController = this.this$0;
        final ShowEvent showEvent = this.$event;
        final String str = this.$iconUrl;
        final Bitmap bitmap2 = bitmap;
        Job unused = C2746d.m5821a(access$getUiCoroutineScope$p, Dispatchers.getMain().getImmediate(), (CoroutineStart) null, new C106331((Continuation<? super C106331>) null), 2, (Object) null);
    }
}
