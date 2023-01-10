package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0002\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00050\u001bj\u0002`\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0007R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0015R\u001c\u0010\u0018\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, mo148868d2 = {"Lkotlinx/coroutines/ThreadState;", "Lkotlinx/coroutines/Job;", "job", "<init>", "(Lkotlinx/coroutines/Job;)V", "", "clearInterrupt", "()V", "", "state", "", "invalidState", "(I)Ljava/lang/Void;", "", "cause", "invoke", "(Ljava/lang/Throwable;)V", "setup", "Lkotlinx/coroutines/DisposableHandle;", "cancelHandle", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Job;", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "targetThread", "Ljava/lang/Thread;", "kotlinx-coroutines-core", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: kotlinx.coroutines.ae */
/* compiled from: Interruptible.kt */
final class C2733ae implements Function1<Throwable, Unit> {

    /* renamed from: b */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f6073b = AtomicIntegerFieldUpdater.newUpdater(C2733ae.class, "_state");
    private volatile /* synthetic */ int _state = 0;

    /* renamed from: a */
    private final Job f6074a;

    /* renamed from: c */
    private final Thread f6075c = Thread.currentThread();

    /* renamed from: d */
    private DisposableHandle f6076d;

    public C2733ae(Job job) {
        this.f6074a = job;
    }

    public /* synthetic */ Object invoke(Object obj) {
        mo27737a((Throwable) obj);
        return Unit.INSTANCE;
    }

    /* renamed from: a */
    public final void mo27736a() {
        int i;
        this.f6076d = this.f6074a.invokeOnCompletion(true, true, this);
        do {
            i = this._state;
            if (i != 0) {
                if (i != 2 && i != 3) {
                    m5708a(i);
                    throw new KotlinNothingValueException();
                }
                return;
            }
        } while (!f6073b.compareAndSet(this, i, 0));
    }

    /* renamed from: a */
    private final Void m5708a(int i) {
        throw new IllegalStateException(Intrinsics.stringPlus("Illegal state ", Integer.valueOf(i)).toString());
    }

    /* renamed from: b */
    public final void mo27738b() {
        while (true) {
            int i = this._state;
            if (i != 0) {
                if (i != 2) {
                    if (i == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        m5708a(i);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (f6073b.compareAndSet(this, i, 1)) {
                DisposableHandle disposableHandle = this.f6076d;
                if (disposableHandle != null) {
                    disposableHandle.dispose();
                    return;
                }
                return;
            }
        }
    }

    /* renamed from: a */
    public void mo27737a(Throwable th) {
        int i;
        do {
            i = this._state;
            if (i != 0) {
                if (i != 1 && i != 2 && i != 3) {
                    m5708a(i);
                    throw new KotlinNothingValueException();
                }
                return;
            }
        } while (!f6073b.compareAndSet(this, i, 2));
        this.f6075c.interrupt();
        this._state = 3;
    }
}
