package kotlin.reflect.full;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.reflect.KCallable;
import kotlin.reflect.KParameter;

@Metadata(mo148867d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH@"}, mo148868d2 = {"callSuspendBy", "", "R", "Lkotlin/reflect/KCallable;", "args", "", "Lkotlin/reflect/KParameter;", "continuation", "Lkotlin/coroutines/Continuation;"}, mo148869k = 3, mo148870mv = {1, 5, 1})
@DebugMetadata(mo23688c = "kotlin.reflect.full.KCallables", mo23689f = "KCallables.kt", mo23690i = {0}, mo23691l = {73}, mo23692m = "callSuspendBy", mo23693n = {"kCallable"}, mo23694s = {"L$2"})
/* compiled from: KCallables.kt */
final class KCallables$callSuspendBy$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    KCallables$callSuspendBy$1(Continuation continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return KCallables.callSuspendBy((KCallable) null, (Map<KParameter, ? extends Object>) null, this);
    }
}
