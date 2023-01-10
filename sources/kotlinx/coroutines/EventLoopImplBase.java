package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b \u0018\u00002\u0002092\u00020::\u00044567B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0002J\u0017\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\n\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u00032\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\u00112\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0002J\u000f\u0010\u0018\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0018\u0010\u0002J\u001d\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001f\u0010 J#\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u00142\n\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006H\u0004¢\u0006\u0004\b#\u0010$J%\u0010'\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00142\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030%H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u001aH\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0003H\u0014¢\u0006\u0004\b+\u0010\u0002R$\u0010-\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00118B@BX\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u00118TX\u0004¢\u0006\u0006\u001a\u0004\b1\u0010.R\u0014\u00103\u001a\u00020\u00148TX\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0016¨\u00068"}, mo148868d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "<init>", "()V", "", "closeQueue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dequeue", "()Ljava/lang/Runnable;", "Lkotlin/coroutines/CoroutineContext;", "context", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "", "processNextEvent", "()J", "rescheduleAllDelayed", "resetAll", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "", "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "shutdown", "value", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "getNextTime", "nextTime", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: EventLoop.common.kt */
public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {

    /* renamed from: a */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f6039a;

    /* renamed from: b */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f6040b;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;
    private volatile /* synthetic */ Object _queue = null;

    static {
        Class<EventLoopImplBase> cls = EventLoopImplBase.class;
        f6039a = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_queue");
        f6040b = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_delayed");
    }

    public Object delay(long j, Continuation<? super Unit> continuation) {
        return Delay.DefaultImpls.delay(this, j, continuation);
    }

    public DisposableHandle invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return Delay.DefaultImpls.invokeOnTimeout(this, j, runnable, coroutineContext);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [boolean, int] */
    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m5654a() {
        return this._isCompleted;
    }

    /* renamed from: a */
    private final void m5653a(boolean z) {
        this._isCompleted = z ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public boolean isEmpty() {
        if (!isUnconfinedQueueEmpty()) {
            return false;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue != null && !delayedTaskQueue.isEmpty()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof LockFreeTaskQueueCore) {
                return ((LockFreeTaskQueueCore) obj).isEmpty();
            }
            if (obj == EventLoop_commonKt.f6048h) {
                return true;
            }
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public long getNextTime() {
        if (super.getNextTime() == 0) {
            return 0;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof LockFreeTaskQueueCore) {
                if (!((LockFreeTaskQueueCore) obj).isEmpty()) {
                    return 0;
                }
            } else if (obj == EventLoop_commonKt.f6048h) {
                return Long.MAX_VALUE;
            } else {
                return 0;
            }
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        DelayedTask delayedTask = delayedTaskQueue == null ? null : (DelayedTask) delayedTaskQueue.peek();
        if (delayedTask == null) {
            return Long.MAX_VALUE;
        }
        long j = delayedTask.nanoTime;
        AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        return RangesKt.coerceAtLeast(j - (timeSource == null ? System.nanoTime() : timeSource.nanoTime()), 0);
    }

    /* access modifiers changed from: protected */
    public void shutdown() {
        ThreadLocalEventLoop.INSTANCE.resetEventLoop$kotlinx_coroutines_core();
        m5653a(true);
        m5658c();
        do {
        } while (processNextEvent() <= 0);
        m5659d();
    }

    public void scheduleResumeAfterDelay(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
        long delayToNanos = EventLoop_commonKt.delayToNanos(j);
        if (delayToNanos < 4611686018427387903L) {
            AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
            long nanoTime = timeSource == null ? System.nanoTime() : timeSource.nanoTime();
            DelayedResumeTask delayedResumeTask = new DelayedResumeTask(delayToNanos + nanoTime, cancellableContinuation);
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuation, delayedResumeTask);
            schedule(nanoTime, delayedResumeTask);
        }
    }

    /* access modifiers changed from: protected */
    public final DisposableHandle scheduleInvokeOnTimeout(long j, Runnable runnable) {
        long delayToNanos = EventLoop_commonKt.delayToNanos(j);
        if (delayToNanos >= 4611686018427387903L) {
            return NonDisposableHandle.INSTANCE;
        }
        AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        long nanoTime = timeSource == null ? System.nanoTime() : timeSource.nanoTime();
        DelayedRunnableTask delayedRunnableTask = new DelayedRunnableTask(delayToNanos + nanoTime, runnable);
        schedule(nanoTime, delayedRunnableTask);
        return delayedRunnableTask;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long processNextEvent() {
        /*
            r10 = this;
            boolean r0 = r10.processUnconfinedEvent()
            r1 = 0
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.lang.Object r0 = r10._delayed
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r0 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r0
            if (r0 == 0) goto L_0x0055
            boolean r3 = r0.isEmpty()
            if (r3 != 0) goto L_0x0055
            kotlinx.coroutines.AbstractTimeSource r3 = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource()
            if (r3 != 0) goto L_0x0020
            long r3 = java.lang.System.nanoTime()
            goto L_0x0024
        L_0x0020:
            long r3 = r3.nanoTime()
        L_0x0024:
            r5 = r0
            kotlinx.coroutines.internal.ThreadSafeHeap r5 = (kotlinx.coroutines.internal.ThreadSafeHeap) r5
            monitor-enter(r5)
            kotlinx.coroutines.internal.ThreadSafeHeapNode r6 = r5.firstImpl()     // Catch:{ all -> 0x0052 }
            r7 = 0
            if (r6 != 0) goto L_0x0031
            monitor-exit(r5)
            goto L_0x004d
        L_0x0031:
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r6 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r6     // Catch:{ all -> 0x0052 }
            boolean r8 = r6.timeToExecute(r3)     // Catch:{ all -> 0x0052 }
            r9 = 0
            if (r8 == 0) goto L_0x0041
            java.lang.Runnable r6 = (java.lang.Runnable) r6     // Catch:{ all -> 0x0052 }
            boolean r6 = r10.m5655a((java.lang.Runnable) r6)     // Catch:{ all -> 0x0052 }
            goto L_0x0042
        L_0x0041:
            r6 = 0
        L_0x0042:
            if (r6 == 0) goto L_0x004a
            kotlinx.coroutines.internal.ThreadSafeHeapNode r6 = r5.removeAtImpl(r9)     // Catch:{ all -> 0x0052 }
            r7 = r6
            goto L_0x004c
        L_0x004a:
            kotlinx.coroutines.internal.ThreadSafeHeapNode r7 = (kotlinx.coroutines.internal.ThreadSafeHeapNode) r7     // Catch:{ all -> 0x0052 }
        L_0x004c:
            monitor-exit(r5)
        L_0x004d:
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r7 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r7
            if (r7 != 0) goto L_0x0024
            goto L_0x0055
        L_0x0052:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L_0x0055:
            java.lang.Runnable r0 = r10.m5657b()
            if (r0 == 0) goto L_0x005f
            r0.run()
            return r1
        L_0x005f:
            long r0 = r10.getNextTime()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.processNextEvent():long");
    }

    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        enqueue(runnable);
    }

    public final void enqueue(Runnable runnable) {
        if (m5655a(runnable)) {
            unpark();
        } else {
            DefaultExecutor.INSTANCE.enqueue(runnable);
        }
    }

    /* renamed from: c */
    private final void m5658c() {
        if (!DebugKt.getASSERTIONS_ENABLED() || m5654a()) {
            while (true) {
                Object obj = this._queue;
                if (obj == null) {
                    if (f6039a.compareAndSet(this, (Object) null, EventLoop_commonKt.f6048h)) {
                        return;
                    }
                } else if (obj instanceof LockFreeTaskQueueCore) {
                    ((LockFreeTaskQueueCore) obj).close();
                    return;
                } else if (obj != EventLoop_commonKt.f6048h) {
                    LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                    if (obj != null) {
                        lockFreeTaskQueueCore.addLast((Runnable) obj);
                        if (f6039a.compareAndSet(this, obj, lockFreeTaskQueueCore)) {
                            return;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    public final void schedule(long j, DelayedTask delayedTask) {
        int a = m5652a(j, delayedTask);
        if (a != 0) {
            if (a == 1) {
                reschedule(j, delayedTask);
            } else if (a != 2) {
                throw new IllegalStateException("unexpected result".toString());
            }
        } else if (m5656a(delayedTask)) {
            unpark();
        }
    }

    /* renamed from: a */
    private final boolean m5656a(DelayedTask delayedTask) {
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        return (delayedTaskQueue == null ? null : (DelayedTask) delayedTaskQueue.peek()) == delayedTask;
    }

    /* renamed from: a */
    private final int m5652a(long j, DelayedTask delayedTask) {
        if (m5654a()) {
            return 1;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue == null) {
            EventLoopImplBase eventLoopImplBase = this;
            f6040b.compareAndSet(eventLoopImplBase, (Object) null, new DelayedTaskQueue(j));
            Object obj = eventLoopImplBase._delayed;
            Intrinsics.checkNotNull(obj);
            delayedTaskQueue = (DelayedTaskQueue) obj;
        }
        return delayedTask.scheduleTask(j, delayedTaskQueue, this);
    }

    /* access modifiers changed from: protected */
    public final void resetAll() {
        this._queue = null;
        this._delayed = null;
    }

    /* renamed from: d */
    private final void m5659d() {
        AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        long nanoTime = timeSource == null ? System.nanoTime() : timeSource.nanoTime();
        while (true) {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
            DelayedTask delayedTask = delayedTaskQueue == null ? null : (DelayedTask) delayedTaskQueue.removeFirstOrNull();
            if (delayedTask != null) {
                reschedule(nanoTime, delayedTask);
            } else {
                return;
            }
        }
    }

    @Metadata(mo148867d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0000H\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u0007J\b\u0010$\u001a\u00020%H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R0\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, mo148868d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "nanoTime", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "dispose", "", "scheduleTask", "now", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "toString", "", "kotlinx-coroutines-core"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: EventLoop.common.kt */
    public static abstract class DelayedTask implements Comparable<DelayedTask>, Runnable, DisposableHandle, ThreadSafeHeapNode {
        private Object _heap;
        private int index = -1;
        public long nanoTime;

        public DelayedTask(long j) {
            this.nanoTime = j;
        }

        public ThreadSafeHeap<?> getHeap() {
            Object obj = this._heap;
            if (obj instanceof ThreadSafeHeap) {
                return (ThreadSafeHeap) obj;
            }
            return null;
        }

        public void setHeap(ThreadSafeHeap<?> threadSafeHeap) {
            if (this._heap != EventLoop_commonKt.f6041a) {
                this._heap = threadSafeHeap;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public int getIndex() {
            return this.index;
        }

        public void setIndex(int i) {
            this.index = i;
        }

        public int compareTo(DelayedTask delayedTask) {
            int i = ((this.nanoTime - delayedTask.nanoTime) > 0 ? 1 : ((this.nanoTime - delayedTask.nanoTime) == 0 ? 0 : -1));
            if (i > 0) {
                return 1;
            }
            return i < 0 ? -1 : 0;
        }

        public final boolean timeToExecute(long j) {
            return j - this.nanoTime >= 0;
        }

        public final synchronized int scheduleTask(long j, DelayedTaskQueue delayedTaskQueue, EventLoopImplBase eventLoopImplBase) {
            if (this._heap == EventLoop_commonKt.f6041a) {
                return 2;
            }
            ThreadSafeHeap threadSafeHeap = delayedTaskQueue;
            synchronized (threadSafeHeap) {
                DelayedTask delayedTask = (DelayedTask) threadSafeHeap.firstImpl();
                if (eventLoopImplBase.m5654a()) {
                    return 1;
                }
                if (delayedTask == null) {
                    delayedTaskQueue.timeNow = j;
                } else {
                    long j2 = delayedTask.nanoTime;
                    if (j2 - j < 0) {
                        j = j2;
                    }
                    if (j - delayedTaskQueue.timeNow > 0) {
                        delayedTaskQueue.timeNow = j;
                    }
                }
                if (this.nanoTime - delayedTaskQueue.timeNow < 0) {
                    this.nanoTime = delayedTaskQueue.timeNow;
                }
                threadSafeHeap.addImpl(this);
                return 0;
            }
        }

        public final synchronized void dispose() {
            Object obj = this._heap;
            if (obj != EventLoop_commonKt.f6041a) {
                DelayedTaskQueue delayedTaskQueue = obj instanceof DelayedTaskQueue ? (DelayedTaskQueue) obj : null;
                if (delayedTaskQueue != null) {
                    delayedTaskQueue.remove(this);
                }
                this._heap = EventLoop_commonKt.f6041a;
            }
        }

        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + VersionRange.RIGHT_CLOSED;
        }
    }

    @Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo148868d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", "", "kotlinx-coroutines-core"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: EventLoop.common.kt */
    private final class DelayedResumeTask extends DelayedTask {
        private final CancellableContinuation<Unit> cont;

        public DelayedResumeTask(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
            super(j);
            this.cont = cancellableContinuation;
        }

        public void run() {
            this.cont.resumeUndispatched(EventLoopImplBase.this, Unit.INSTANCE);
        }

        public String toString() {
            return Intrinsics.stringPlus(super.toString(), this.cont);
        }
    }

    @Metadata(mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo148868d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(JLjava/lang/Runnable;)V", "run", "", "toString", "", "kotlinx-coroutines-core"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: EventLoop.common.kt */
    private static final class DelayedRunnableTask extends DelayedTask {
        private final Runnable block;

        public DelayedRunnableTask(long j, Runnable runnable) {
            super(j);
            this.block = runnable;
        }

        public void run() {
            this.block.run();
        }

        public String toString() {
            return Intrinsics.stringPlus(super.toString(), this.block);
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo148868d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: EventLoop.common.kt */
    public static final class DelayedTaskQueue extends ThreadSafeHeap<DelayedTask> {
        public long timeNow;

        public DelayedTaskQueue(long j) {
            this.timeNow = j;
        }
    }

    /* renamed from: a */
    private final boolean m5655a(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (m5654a()) {
                return false;
            }
            if (obj == null) {
                if (f6039a.compareAndSet(this, (Object) null, runnable)) {
                    return true;
                }
            } else if (obj instanceof LockFreeTaskQueueCore) {
                if (obj != null) {
                    LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                    int addLast = lockFreeTaskQueueCore.addLast(runnable);
                    if (addLast == 0) {
                        return true;
                    }
                    if (addLast == 1) {
                        f6039a.compareAndSet(this, obj, lockFreeTaskQueueCore.next());
                    } else if (addLast == 2) {
                        return false;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                }
            } else if (obj == EventLoop_commonKt.f6048h) {
                return false;
            } else {
                LockFreeTaskQueueCore lockFreeTaskQueueCore2 = new LockFreeTaskQueueCore(8, true);
                if (obj != null) {
                    lockFreeTaskQueueCore2.addLast((Runnable) obj);
                    lockFreeTaskQueueCore2.addLast(runnable);
                    if (f6039a.compareAndSet(this, obj, lockFreeTaskQueueCore2)) {
                        return true;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                }
            }
        }
    }

    /* renamed from: b */
    private final Runnable m5657b() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof LockFreeTaskQueueCore) {
                if (obj != null) {
                    LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                    Object removeFirstOrNull = lockFreeTaskQueueCore.removeFirstOrNull();
                    if (removeFirstOrNull != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                        return (Runnable) removeFirstOrNull;
                    }
                    f6039a.compareAndSet(this, obj, lockFreeTaskQueueCore.next());
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                }
            } else if (obj == EventLoop_commonKt.f6048h) {
                return null;
            } else {
                if (f6039a.compareAndSet(this, obj, (Object) null)) {
                    if (obj != null) {
                        return (Runnable) obj;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                }
            }
        }
    }
}
