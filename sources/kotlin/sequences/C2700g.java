package kotlin.sequences;

import com.didi.entrega.customer.app.constant.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

@Metadata(mo148867d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\bø\u0001\u0000\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001ab\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\f2\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00050\u000eH\u0000\u001a&\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004\u001a<\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000e\u001a=\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u0001H\u00022\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000eH\u0007¢\u0006\u0002\u0010\u0014\u001a+\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0017\"\u0002H\u0002¢\u0006\u0002\u0010\u0018\u001a\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001aC\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00050\u000eH\u0002¢\u0006\u0002\b\u001c\u001a)\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001d0\u0001H\u0007¢\u0006\u0002\b\u001e\u001a\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a2\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0004H\u0007\u001a!\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\b\u001a\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a&\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0007\u001a@\u0010%\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0'0&\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0&0\u0001\u0002\u0007\n\u0005\b20\u0001¨\u0006("}, mo148868d2 = {"Sequence", "Lkotlin/sequences/Sequence;", "T", "iterator", "Lkotlin/Function0;", "", "emptySequence", "flatMapIndexed", "R", "C", "source", "transform", "Lkotlin/Function2;", "", "Lkotlin/Function1;", "generateSequence", "", "nextFunction", "seedFunction", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "sequenceOf", "elements", "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "constrainOnce", "flatten", "flatten$SequencesKt__SequencesKt", "", "flattenSequenceOfIterable", "ifEmpty", "defaultValue", "orEmpty", "shuffled", "random", "Lkotlin/random/Random;", "unzip", "Lkotlin/Pair;", "", "kotlin-stdlib"}, mo148869k = 5, mo148870mv = {1, 5, 1}, mo148872xi = 1, mo148873xs = "kotlin/sequences/SequencesKt")
/* renamed from: kotlin.sequences.g */
/* compiled from: Sequences.kt */
class C2700g extends C2699f {
    /* renamed from: a */
    private static final <T> Sequence<T> m5329a(Function0<? extends Iterator<? extends T>> function0) {
        return new SequencesKt__SequencesKt$Sequence$1(function0);
    }

    public static final <T> Sequence<T> asSequence(Iterator<? extends T> it) {
        Intrinsics.checkNotNullParameter(it, "$this$asSequence");
        return SequencesKt.constrainOnce(new SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(it));
    }

    public static final <T> Sequence<T> sequenceOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return tArr.length == 0 ? SequencesKt.emptySequence() : ArraysKt.asSequence(tArr);
    }

    public static final <T> Sequence<T> emptySequence() {
        return C2695b.f5961a;
    }

    /* renamed from: a */
    private static final <T> Sequence<T> m5330a(Sequence<? extends T> sequence) {
        return sequence != null ? sequence : SequencesKt.emptySequence();
    }

    public static final <T> Sequence<T> ifEmpty(Sequence<? extends T> sequence, Function0<? extends Sequence<? extends T>> function0) {
        Intrinsics.checkNotNullParameter(sequence, "$this$ifEmpty");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        return SequencesKt.sequence(new SequencesKt__SequencesKt$ifEmpty$1(sequence, function0, (Continuation) null));
    }

    public static final <T> Sequence<T> flatten(Sequence<? extends Sequence<? extends T>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$flatten");
        return m5331a(sequence, SequencesKt__SequencesKt$flatten$1.INSTANCE);
    }

    public static final <T> Sequence<T> flattenSequenceOfIterable(Sequence<? extends Iterable<? extends T>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$flatten");
        return m5331a(sequence, SequencesKt__SequencesKt$flatten$2.INSTANCE);
    }

    /* renamed from: a */
    private static final <T, R> Sequence<R> m5331a(Sequence<? extends T> sequence, Function1<? super T, ? extends Iterator<? extends R>> function1) {
        if (sequence instanceof TransformingSequence) {
            return ((TransformingSequence) sequence).flatten$kotlin_stdlib(function1);
        }
        return new FlatteningSequence<>(sequence, SequencesKt__SequencesKt$flatten$3.INSTANCE, function1);
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Sequence<? extends Pair<? extends T, ? extends R>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$unzip");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : sequence) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return TuplesKt.m41339to(arrayList, arrayList2);
    }

    public static final <T> Sequence<T> shuffled(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$shuffled");
        return SequencesKt.shuffled(sequence, Random.Default);
    }

    public static final <T> Sequence<T> shuffled(Sequence<? extends T> sequence, Random random) {
        Intrinsics.checkNotNullParameter(sequence, "$this$shuffled");
        Intrinsics.checkNotNullParameter(random, "random");
        return SequencesKt.sequence(new SequencesKt__SequencesKt$shuffled$1(sequence, random, (Continuation) null));
    }

    public static final <T, C, R> Sequence<R> flatMapIndexed(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, ? extends C> function2, Function1<? super C, ? extends Iterator<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(sequence, "source");
        Intrinsics.checkNotNullParameter(function2, Const.BillClickType.TRANSFORM);
        Intrinsics.checkNotNullParameter(function1, "iterator");
        return SequencesKt.sequence(new SequencesKt__SequencesKt$flatMapIndexed$1(sequence, function2, function1, (Continuation) null));
    }

    public static final <T> Sequence<T> constrainOnce(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$constrainOnce");
        return sequence instanceof ConstrainedOnceSequence ? sequence : new ConstrainedOnceSequence<>(sequence);
    }

    public static final <T> Sequence<T> generateSequence(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "nextFunction");
        return SequencesKt.constrainOnce(new C2696c(function0, new SequencesKt__SequencesKt$generateSequence$1(function0)));
    }

    public static final <T> Sequence<T> generateSequence(T t, Function1<? super T, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "nextFunction");
        if (t == null) {
            return C2695b.f5961a;
        }
        return new C2696c<>(new SequencesKt__SequencesKt$generateSequence$2(t), function1);
    }

    public static final <T> Sequence<T> generateSequence(Function0<? extends T> function0, Function1<? super T, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function0, "seedFunction");
        Intrinsics.checkNotNullParameter(function1, "nextFunction");
        return new C2696c<>(function0, function1);
    }
}
