package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.reflect.KCallable;

@Metadata(mo148867d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0005\"\u0004\u0018\u00010\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H@"}, mo148868d2 = {"callSuspend", "", "R", "Lkotlin/reflect/KCallable;", "args", "", "continuation", "Lkotlin/coroutines/Continuation;"}, mo148869k = 3, mo148870mv = {1, 5, 1})
@DebugMetadata(mo23688c = "kotlin.reflect.full.KCallables", mo23689f = "KCallables.kt", mo23690i = {}, mo23691l = {55}, mo23692m = "callSuspend", mo23693n = {}, mo23694s = {})
/* compiled from: KCallables.kt */
final class KCallables$callSuspend$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    KCallables$callSuspend$1(Continuation continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return KCallables.callSuspend((KCallable) null, (Object[]) null, this);
    }
}
