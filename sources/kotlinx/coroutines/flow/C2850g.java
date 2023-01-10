package kotlinx.coroutines.flow;

import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(mo148867d1 = {"\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aK\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\tø\u0001\u0000¢\u0006\u0002\u0010\n\u001aK\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\tø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001aK\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\tø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0010\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0011\u001a+\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0013\"\u0002H\u0002¢\u0006\u0002\u0010\u0014\u001aT\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u001724\b\u0001\u0010\u0003\u001a.\u0012\u0004\u0012\u00020\u0018\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00020\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\b\tH\u0007\u001a\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001eH\u0007\u001a!\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0013¢\u0006\u0002\u0010\u0014\u001a\u0010\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u0001*\u00020\u001f\u001a\u0010\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020 0\u0001*\u00020!\u001a\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\"\u001a\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020#\u001a\u0010\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u0001*\u00020$\u001a\u0010\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020 0\u0001*\u00020%\u001a\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020&\u001a6\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0'H\u0007ø\u0001\u0000¢\u0006\u0002\u0010(\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, mo148868d2 = {"callbackFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "channelFlow", "emptyFlow", "flow", "Lkotlinx/coroutines/flow/FlowCollector;", "flowOf", "value", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "elements", "", "([Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "flowViaChannel", "bufferSize", "", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/ParameterName;", "name", "channel", "asFlow", "Lkotlin/Function0;", "", "", "", "", "", "Lkotlin/ranges/IntRange;", "Lkotlin/ranges/LongRange;", "Lkotlin/sequences/Sequence;", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, mo148869k = 5, mo148870mv = {1, 5, 1}, mo148872xi = 48, mo148873xs = "kotlinx/coroutines/flow/FlowKt")
/* renamed from: kotlinx.coroutines.flow.g */
/* compiled from: Builders.kt */
final /* synthetic */ class C2850g {
    /* renamed from: a */
    public static final <T> Flow<T> m5936a(Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new C2880y<>(function2);
    }

    /* renamed from: a */
    public static final <T> Flow<T> m5928a() {
        return C2849f.f6183a;
    }

    /* renamed from: a */
    public static /* synthetic */ Flow m5930a(int i, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -2;
        }
        return FlowKt.flowViaChannel(i, function2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use channelFlow with awaitClose { } instead of flowViaChannel and invokeOnClose { }.")
    /* renamed from: a */
    public static final <T> Flow<T> m5929a(int i, Function2<? super CoroutineScope, ? super SendChannel<? super T>, Unit> function2) {
        return C2865j.m5969a(FlowKt.channelFlow(new FlowKt__BuildersKt$flowViaChannel$1(function2, (Continuation<? super FlowKt__BuildersKt$flowViaChannel$1>) null)), i, (BufferOverflow) null, 2, (Object) null);
    }

    /* renamed from: b */
    public static final <T> Flow<T> m5943b(Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new C2847d<>(function2, (CoroutineContext) null, 0, (BufferOverflow) null, 14, (DefaultConstructorMarker) null);
    }

    /* renamed from: c */
    public static final <T> Flow<T> m5945c(Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new C2837a<>(function2, (CoroutineContext) null, 0, (BufferOverflow) null, 14, (DefaultConstructorMarker) null);
    }

    /* renamed from: a */
    public static final <T> Flow<T> m5934a(Function0<? extends T> function0) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$1(function0);
    }

    /* renamed from: a */
    public static final <T> Flow<T> m5935a(Function1<? super Continuation<? super T>, ? extends Object> function1) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2(function1);
    }

    /* renamed from: a */
    public static final <T> Flow<T> m5931a(Iterable<? extends T> iterable) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3(iterable);
    }

    /* renamed from: a */
    public static final <T> Flow<T> m5933a(Iterator<? extends T> it) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4(it);
    }

    /* renamed from: a */
    public static final <T> Flow<T> m5939a(Sequence<? extends T> sequence) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5(sequence);
    }

    /* renamed from: a */
    public static final <T> Flow<T> m5942a(T... tArr) {
        return new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1(tArr);
    }

    /* renamed from: a */
    public static final <T> Flow<T> m5932a(T t) {
        return new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(t);
    }

    /* renamed from: b */
    public static final <T> Flow<T> m5944b(T[] tArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6(tArr);
    }

    /* renamed from: a */
    public static final Flow<Integer> m5940a(int[] iArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7(iArr);
    }

    /* renamed from: a */
    public static final Flow<Long> m5941a(long[] jArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8(jArr);
    }

    /* renamed from: a */
    public static final Flow<Integer> m5937a(IntRange intRange) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9(intRange);
    }

    /* renamed from: a */
    public static final Flow<Long> m5938a(LongRange longRange) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10(longRange);
    }
}
