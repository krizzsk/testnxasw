package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.EmptyIterator;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, mo148868d2 = {"Lkotlin/sequences/EmptySequence;", "Lkotlin/sequences/Sequence;", "", "Lkotlin/sequences/DropTakeSequence;", "()V", "drop", "n", "", "iterator", "", "take", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* renamed from: kotlin.sequences.b */
/* compiled from: Sequences.kt */
final class C2695b implements DropTakeSequence, Sequence {

    /* renamed from: a */
    public static final C2695b f5961a = new C2695b();

    private C2695b() {
    }

    public Iterator iterator() {
        return EmptyIterator.INSTANCE;
    }

    /* renamed from: a */
    public C2695b drop(int i) {
        return f5961a;
    }

    /* renamed from: b */
    public C2695b take(int i) {
        return f5961a;
    }
}
