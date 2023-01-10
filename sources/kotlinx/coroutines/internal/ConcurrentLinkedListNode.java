package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;

@Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\t\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u001aB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ \u0010\u000e\u001a\u0004\u0018\u00018\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0007J\u0015\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\nR\u0016\u0010\u0017\u001a\u0004\u0018\u00018\u00008BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0019\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0002\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0016R\u0014\u0010 \u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\nR\u0014\u0010\"\u001a\u00028\u00008BX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0016¨\u0006#"}, mo148868d2 = {"Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "prev", "<init>", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)V", "", "cleanPrev", "()V", "", "markAsClosed", "()Z", "Lkotlin/Function0;", "", "onClosedAction", "nextOrIfClosed", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "remove", "value", "trySetNext", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Z", "isTail", "getLeftmostAliveNode", "()Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "leftmostAliveNode", "getNext", "next", "", "getNextOrClosed", "()Ljava/lang/Object;", "nextOrClosed", "getPrev", "getRemoved", "removed", "getRightmostAliveNode", "rightmostAliveNode", "kotlinx-coroutines-core"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ConcurrentLinkedList.kt */
public abstract class ConcurrentLinkedListNode<N extends ConcurrentLinkedListNode<N>> {

    /* renamed from: a */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f6225a;

    /* renamed from: b */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f6226b;
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ Object _prev;

    static {
        Class<ConcurrentLinkedListNode> cls = ConcurrentLinkedListNode.class;
        f6225a = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_next");
        f6226b = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_prev");
    }

    public abstract boolean getRemoved();

    public ConcurrentLinkedListNode(N n) {
        this._prev = n;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final Object m6138a() {
        return this._next;
    }

    public final N nextOrIfClosed(Function0 function0) {
        N access$getNextOrClosed = m6138a();
        if (access$getNextOrClosed != ConcurrentLinkedListKt.f6224b) {
            return (ConcurrentLinkedListNode) access$getNextOrClosed;
        }
        function0.invoke();
        throw new KotlinNothingValueException();
    }

    public final boolean trySetNext(N n) {
        return f6225a.compareAndSet(this, (Object) null, n);
    }

    public final boolean isTail() {
        return getNext() == null;
    }

    public final N getPrev() {
        return (ConcurrentLinkedListNode) this._prev;
    }

    public final void cleanPrev() {
        f6226b.lazySet(this, (Object) null);
    }

    public final boolean markAsClosed() {
        return f6225a.compareAndSet(this, (Object) null, ConcurrentLinkedListKt.f6224b);
    }

    public final void remove() {
        if (DebugKt.getASSERTIONS_ENABLED() && !getRemoved()) {
            throw new AssertionError();
        } else if (!DebugKt.getASSERTIONS_ENABLED() || (!isTail())) {
            while (true) {
                ConcurrentLinkedListNode b = m6139b();
                ConcurrentLinkedListNode c = m6140c();
                c._prev = b;
                if (b != null) {
                    b._next = c;
                }
                if (!c.getRemoved() && (b == null || !b.getRemoved())) {
                    return;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: b */
    private final N m6139b() {
        N prev = getPrev();
        while (prev != null && prev.getRemoved()) {
            prev = (ConcurrentLinkedListNode) prev._prev;
        }
        return prev;
    }

    /* renamed from: c */
    private final N m6140c() {
        if (!DebugKt.getASSERTIONS_ENABLED() || (!isTail())) {
            N next = getNext();
            Intrinsics.checkNotNull(next);
            while (next.getRemoved()) {
                next = next.getNext();
                Intrinsics.checkNotNull(next);
            }
            return next;
        }
        throw new AssertionError();
    }

    public final N getNext() {
        N access$getNextOrClosed = m6138a();
        if (access$getNextOrClosed == ConcurrentLinkedListKt.f6224b) {
            return null;
        }
        return (ConcurrentLinkedListNode) access$getNextOrClosed;
    }
}
