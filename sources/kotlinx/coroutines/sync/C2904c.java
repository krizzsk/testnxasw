package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;

@Metadata(mo148867d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00020\u001eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\bJ\u001d\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u00060\nH\u0002¢\u0006\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00060\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u001c\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, mo148868d2 = {"Lkotlinx/coroutines/sync/SemaphoreImpl;", "", "permits", "acquiredPermits", "<init>", "(II)V", "", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireSlowPath", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "", "addAcquireToQueue", "(Lkotlinx/coroutines/CancellableContinuation;)Z", "release", "()V", "tryAcquire", "()Z", "tryResumeNextFromQueue", "tryResumeAcquire", "getAvailablePermits", "()I", "availablePermits", "Lkotlin/Function1;", "", "onCancellationRelease", "Lkotlin/jvm/functions/Function1;", "I", "kotlinx-coroutines-core", "Lkotlinx/coroutines/sync/Semaphore;"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: kotlinx.coroutines.sync.c */
/* compiled from: Semaphore.kt */
final class C2904c implements Semaphore {

    /* renamed from: a */
    static final /* synthetic */ AtomicIntegerFieldUpdater f6340a;

    /* renamed from: c */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f6341c;

    /* renamed from: d */
    private static final /* synthetic */ AtomicLongFieldUpdater f6342d;

    /* renamed from: e */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f6343e;

    /* renamed from: f */
    private static final /* synthetic */ AtomicLongFieldUpdater f6344f;
    volatile /* synthetic */ int _availablePermits;

    /* renamed from: b */
    private final int f6345b;
    private volatile /* synthetic */ long deqIdx = 0;
    private volatile /* synthetic */ long enqIdx = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Function1<Throwable, Unit> f6346g;
    private volatile /* synthetic */ Object head;
    private volatile /* synthetic */ Object tail;

    static {
        Class<C2904c> cls = C2904c.class;
        f6341c = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "head");
        f6342d = AtomicLongFieldUpdater.newUpdater(cls, "deqIdx");
        f6343e = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "tail");
        f6344f = AtomicLongFieldUpdater.newUpdater(cls, "enqIdx");
        f6340a = AtomicIntegerFieldUpdater.newUpdater(cls, "_availablePermits");
    }

    public C2904c(int i, int i2) {
        this.f6345b = i;
        boolean z = true;
        if (this.f6345b > 0) {
            if ((i2 < 0 || i2 > this.f6345b) ? false : z) {
                C2905d dVar = new C2905d(0, (C2905d) null, 2);
                this.head = dVar;
                this.tail = dVar;
                this._availablePermits = this.f6345b - i2;
                this.f6346g = new SemaphoreImpl$onCancellationRelease$1(this);
                return;
            }
            throw new IllegalArgumentException(Intrinsics.stringPlus("The number of acquired permits should be in 0..", Integer.valueOf(this.f6345b)).toString());
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Semaphore should have at least 1 permit, but had ", Integer.valueOf(this.f6345b)).toString());
    }

    public int getAvailablePermits() {
        return Math.max(this._availablePermits, 0);
    }

    public Object acquire(Continuation<? super Unit> continuation) {
        if (f6340a.getAndDecrement(this) > 0) {
            return Unit.INSTANCE;
        }
        Object a = m6278a(continuation);
        return a == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m6282a(CancellableContinuation<? super Unit> cancellableContinuation) {
        Object obj;
        boolean z;
        boolean z2;
        CancellableContinuation<? super Unit> cancellableContinuation2 = cancellableContinuation;
        C2905d dVar = (C2905d) this.tail;
        long andIncrement = f6344f.getAndIncrement(this);
        long access$getSEGMENT_SIZE$p = andIncrement / ((long) SemaphoreKt.f6336f);
        do {
            Segment segment = dVar;
            while (true) {
                if (segment.getId() >= access$getSEGMENT_SIZE$p && !segment.getRemoved()) {
                    obj = SegmentOrClosed.m46599constructorimpl(segment);
                    break;
                }
                Object access$getNextOrClosed = segment.m6138a();
                if (access$getNextOrClosed == ConcurrentLinkedListKt.f6224b) {
                    obj = SegmentOrClosed.m46599constructorimpl(ConcurrentLinkedListKt.f6224b);
                    break;
                }
                Segment segment2 = (Segment) ((ConcurrentLinkedListNode) access$getNextOrClosed);
                if (segment2 == null) {
                    segment2 = SemaphoreKt.m6271a(segment.getId() + 1, (C2905d) segment);
                    if (segment.trySetNext(segment2)) {
                        if (segment.getRemoved()) {
                            segment.remove();
                        }
                    }
                }
                segment = segment2;
            }
            z = true;
            if (SegmentOrClosed.m46604isClosedimpl(obj)) {
                break;
            }
            Segment r8 = SegmentOrClosed.m46602getSegmentimpl(obj);
            while (true) {
                Segment segment3 = (Segment) this.tail;
                if (segment3.getId() >= r8.getId()) {
                    break;
                } else if (!r8.tryIncPointers$kotlinx_coroutines_core()) {
                    z2 = false;
                    continue;
                    break;
                } else if (f6343e.compareAndSet(this, segment3, r8)) {
                    if (segment3.decPointers$kotlinx_coroutines_core()) {
                        segment3.remove();
                    }
                } else if (r8.decPointers$kotlinx_coroutines_core()) {
                    r8.remove();
                }
            }
            z2 = true;
            continue;
        } while (!z2);
        C2905d dVar2 = (C2905d) SegmentOrClosed.m46602getSegmentimpl(obj);
        int access$getSEGMENT_SIZE$p2 = (int) (andIncrement % ((long) SemaphoreKt.f6336f));
        if (dVar2.f6347a.compareAndSet(access$getSEGMENT_SIZE$p2, (Object) null, cancellableContinuation2)) {
            cancellableContinuation2.invokeOnCancellation(new C2902a(dVar2, access$getSEGMENT_SIZE$p2));
            return true;
        }
        if (dVar2.f6347a.compareAndSet(access$getSEGMENT_SIZE$p2, SemaphoreKt.f6332b, SemaphoreKt.f6333c)) {
            cancellableContinuation2.resume(Unit.INSTANCE, this.f6346g);
            return true;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (dVar2.f6347a.get(access$getSEGMENT_SIZE$p2) != SemaphoreKt.f6334d) {
                z = false;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0059, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0075, code lost:
        continue;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m6281a() {
        /*
            r15 = this;
            java.lang.Object r0 = r15.head
            kotlinx.coroutines.sync.d r0 = (kotlinx.coroutines.sync.C2905d) r0
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f6342d
            long r1 = r1.getAndIncrement(r15)
            int r3 = kotlinx.coroutines.sync.SemaphoreKt.f6336f
            long r3 = (long) r3
            long r3 = r1 / r3
        L_0x0011:
            r5 = r0
            kotlinx.coroutines.internal.Segment r5 = (kotlinx.coroutines.internal.Segment) r5
        L_0x0014:
            long r6 = r5.getId()
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 < 0) goto L_0x0028
            boolean r6 = r5.getRemoved()
            if (r6 == 0) goto L_0x0023
            goto L_0x0028
        L_0x0023:
            java.lang.Object r5 = kotlinx.coroutines.internal.SegmentOrClosed.m46599constructorimpl(r5)
            goto L_0x003d
        L_0x0028:
            r6 = r5
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r6 = (kotlinx.coroutines.internal.ConcurrentLinkedListNode) r6
            java.lang.Object r6 = r6.m6138a()
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.internal.ConcurrentLinkedListKt.f6224b
            if (r6 != r7) goto L_0x00db
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.internal.ConcurrentLinkedListKt.f6224b
            java.lang.Object r5 = kotlinx.coroutines.internal.SegmentOrClosed.m46599constructorimpl(r5)
        L_0x003d:
            boolean r6 = kotlinx.coroutines.internal.SegmentOrClosed.m46604isClosedimpl(r5)
            r7 = 0
            r8 = 1
            if (r6 != 0) goto L_0x0082
            kotlinx.coroutines.internal.Segment r6 = kotlinx.coroutines.internal.SegmentOrClosed.m46602getSegmentimpl(r5)
        L_0x0049:
            java.lang.Object r9 = r15.head
            kotlinx.coroutines.internal.Segment r9 = (kotlinx.coroutines.internal.Segment) r9
            long r10 = r9.getId()
            long r12 = r6.getId()
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x005b
        L_0x0059:
            r6 = 1
            goto L_0x0075
        L_0x005b:
            boolean r10 = r6.tryIncPointers$kotlinx_coroutines_core()
            if (r10 != 0) goto L_0x0063
            r6 = 0
            goto L_0x0075
        L_0x0063:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r10 = f6341c
            boolean r10 = r10.compareAndSet(r15, r9, r6)
            if (r10 == 0) goto L_0x0078
            boolean r6 = r9.decPointers$kotlinx_coroutines_core()
            if (r6 == 0) goto L_0x0059
            r9.remove()
            goto L_0x0059
        L_0x0075:
            if (r6 == 0) goto L_0x0011
            goto L_0x0082
        L_0x0078:
            boolean r9 = r6.decPointers$kotlinx_coroutines_core()
            if (r9 == 0) goto L_0x0049
            r6.remove()
            goto L_0x0049
        L_0x0082:
            kotlinx.coroutines.internal.Segment r0 = kotlinx.coroutines.internal.SegmentOrClosed.m46602getSegmentimpl(r5)
            kotlinx.coroutines.sync.d r0 = (kotlinx.coroutines.sync.C2905d) r0
            r0.cleanPrev()
            long r5 = r0.getId()
            int r9 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r9 <= 0) goto L_0x0094
            return r7
        L_0x0094:
            int r3 = kotlinx.coroutines.sync.SemaphoreKt.f6336f
            long r3 = (long) r3
            long r1 = r1 % r3
            int r2 = (int) r1
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.sync.SemaphoreKt.f6332b
            java.util.concurrent.atomic.AtomicReferenceArray r3 = r0.f6347a
            java.lang.Object r1 = r3.getAndSet(r2, r1)
            if (r1 != 0) goto L_0x00cd
            int r1 = kotlinx.coroutines.sync.SemaphoreKt.f6331a
        L_0x00ab:
            if (r7 >= r1) goto L_0x00bd
            java.util.concurrent.atomic.AtomicReferenceArray r3 = r0.f6347a
            java.lang.Object r3 = r3.get(r2)
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.sync.SemaphoreKt.f6333c
            if (r3 != r4) goto L_0x00ba
            return r8
        L_0x00ba:
            int r7 = r7 + 1
            goto L_0x00ab
        L_0x00bd:
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.sync.SemaphoreKt.f6332b
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.sync.SemaphoreKt.f6334d
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r0.f6347a
            boolean r0 = r0.compareAndSet(r2, r1, r3)
            r0 = r0 ^ r8
            return r0
        L_0x00cd:
            kotlinx.coroutines.internal.Symbol r0 = kotlinx.coroutines.sync.SemaphoreKt.f6335e
            if (r1 != r0) goto L_0x00d4
            return r7
        L_0x00d4:
            kotlinx.coroutines.CancellableContinuation r1 = (kotlinx.coroutines.CancellableContinuation) r1
            boolean r0 = r15.m6284b(r1)
            return r0
        L_0x00db:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r6 = (kotlinx.coroutines.internal.ConcurrentLinkedListNode) r6
            kotlinx.coroutines.internal.Segment r6 = (kotlinx.coroutines.internal.Segment) r6
            if (r6 == 0) goto L_0x00e4
        L_0x00e1:
            r5 = r6
            goto L_0x0014
        L_0x00e4:
            long r6 = r5.getId()
            r8 = 1
            long r6 = r6 + r8
            r8 = r5
            kotlinx.coroutines.sync.d r8 = (kotlinx.coroutines.sync.C2905d) r8
            kotlinx.coroutines.sync.d r6 = kotlinx.coroutines.sync.SemaphoreKt.m6271a(r6, r8)
            kotlinx.coroutines.internal.Segment r6 = (kotlinx.coroutines.internal.Segment) r6
            r7 = r6
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r7 = (kotlinx.coroutines.internal.ConcurrentLinkedListNode) r7
            boolean r7 = r5.trySetNext(r7)
            if (r7 == 0) goto L_0x0014
            boolean r7 = r5.getRemoved()
            if (r7 == 0) goto L_0x00e1
            r5.remove()
            goto L_0x00e1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.C2904c.m6281a():boolean");
    }

    /* renamed from: b */
    private final boolean m6284b(CancellableContinuation<? super Unit> cancellableContinuation) {
        Object tryResume = cancellableContinuation.tryResume(Unit.INSTANCE, (Object) null, this.f6346g);
        if (tryResume == null) {
            return false;
        }
        cancellableContinuation.completeResume(tryResume);
        return true;
    }

    public boolean tryAcquire() {
        int i;
        do {
            i = this._availablePermits;
            if (i <= 0) {
                return false;
            }
        } while (!f6340a.compareAndSet(this, i, i - 1));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final Object m6278a(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl<? super Unit> orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        CancellableContinuation cancellableContinuation = orCreateCancellableContinuation;
        while (true) {
            if (!m6282a((CancellableContinuation<? super Unit>) cancellableContinuation)) {
                if (f6340a.getAndDecrement(this) > 0) {
                    cancellableContinuation.resume(Unit.INSTANCE, this.f6346g);
                    break;
                }
            } else {
                break;
            }
        }
        Object result = orCreateCancellableContinuation.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    public void release() {
        while (true) {
            int i = this._availablePermits;
            if (i < this.f6345b) {
                if (f6340a.compareAndSet(this, i, i + 1) && (i >= 0 || m6281a())) {
                    return;
                }
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("The number of released permits cannot be greater than ", Integer.valueOf(this.f6345b)).toString());
            }
        }
    }
}
