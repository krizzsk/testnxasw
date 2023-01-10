package p218io.reactivex.internal.queue;

import java.util.concurrent.atomic.AtomicReference;
import p218io.reactivex.internal.fuseable.SimplePlainQueue;

/* renamed from: io.reactivex.internal.queue.MpscLinkedQueue */
public final class MpscLinkedQueue<T> implements SimplePlainQueue<T> {

    /* renamed from: a */
    private final AtomicReference<LinkedQueueNode<T>> f61957a = new AtomicReference<>();

    /* renamed from: b */
    private final AtomicReference<LinkedQueueNode<T>> f61958b = new AtomicReference<>();

    public MpscLinkedQueue() {
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode();
        mo184914b(linkedQueueNode);
        mo184912a(linkedQueueNode);
    }

    public boolean offer(T t) {
        if (t != null) {
            LinkedQueueNode linkedQueueNode = new LinkedQueueNode(t);
            mo184912a(linkedQueueNode).soNext(linkedQueueNode);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public T poll() {
        LinkedQueueNode lvNext;
        LinkedQueueNode c = mo184915c();
        LinkedQueueNode lvNext2 = c.lvNext();
        if (lvNext2 != null) {
            T andNullValue = lvNext2.getAndNullValue();
            mo184914b(lvNext2);
            return andNullValue;
        } else if (c == mo184911a()) {
            return null;
        } else {
            do {
                lvNext = c.lvNext();
            } while (lvNext == null);
            T andNullValue2 = lvNext.getAndNullValue();
            mo184914b(lvNext);
            return andNullValue2;
        }
    }

    public boolean offer(T t, T t2) {
        offer(t);
        offer(t2);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r1 = this;
        L_0x0000:
            java.lang.Object r0 = r1.poll()
            if (r0 == 0) goto L_0x000d
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x000d
            goto L_0x0000
        L_0x000d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p218io.reactivex.internal.queue.MpscLinkedQueue.clear():void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public LinkedQueueNode<T> mo184911a() {
        return this.f61957a.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public LinkedQueueNode<T> mo184912a(LinkedQueueNode<T> linkedQueueNode) {
        return this.f61957a.getAndSet(linkedQueueNode);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public LinkedQueueNode<T> mo184913b() {
        return this.f61958b.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public LinkedQueueNode<T> mo184915c() {
        return this.f61958b.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo184914b(LinkedQueueNode<T> linkedQueueNode) {
        this.f61958b.lazySet(linkedQueueNode);
    }

    public boolean isEmpty() {
        return mo184913b() == mo184911a();
    }

    /* renamed from: io.reactivex.internal.queue.MpscLinkedQueue$LinkedQueueNode */
    static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        LinkedQueueNode() {
        }

        LinkedQueueNode(E e) {
            spValue(e);
        }

        public E getAndNullValue() {
            E lpValue = lpValue();
            spValue((Object) null);
            return lpValue;
        }

        public E lpValue() {
            return this.value;
        }

        public void spValue(E e) {
            this.value = e;
        }

        public void soNext(LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public LinkedQueueNode<E> lvNext() {
            return (LinkedQueueNode) get();
        }
    }
}
