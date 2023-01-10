package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

@Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t0\bX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bX\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0013"}, mo148868d2 = {"Lkotlinx/coroutines/internal/ThreadState;", "", "context", "Lkotlin/coroutines/CoroutineContext;", "n", "", "(Lkotlin/coroutines/CoroutineContext;I)V", "elements", "", "Lkotlinx/coroutines/ThreadContextElement;", "[Lkotlinx/coroutines/ThreadContextElement;", "i", "values", "[Ljava/lang/Object;", "append", "", "element", "value", "restore", "kotlinx-coroutines-core"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: kotlinx.coroutines.internal.e */
/* compiled from: ThreadContext.kt */
final class C2890e {

    /* renamed from: a */
    public final CoroutineContext f6268a;

    /* renamed from: b */
    private final Object[] f6269b;

    /* renamed from: c */
    private final ThreadContextElement<Object>[] f6270c;

    /* renamed from: d */
    private int f6271d;

    public C2890e(CoroutineContext coroutineContext, int i) {
        this.f6268a = coroutineContext;
        this.f6269b = new Object[i];
        this.f6270c = new ThreadContextElement[i];
    }

    /* renamed from: a */
    public final void mo28265a(ThreadContextElement<?> threadContextElement, Object obj) {
        Object[] objArr = this.f6269b;
        int i = this.f6271d;
        objArr[i] = obj;
        ThreadContextElement<Object>[] threadContextElementArr = this.f6270c;
        this.f6271d = i + 1;
        threadContextElementArr[i] = threadContextElement;
    }

    /* renamed from: a */
    public final void mo28264a(CoroutineContext coroutineContext) {
        int length = this.f6270c.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                ThreadContextElement<Object> threadContextElement = this.f6270c[length];
                Intrinsics.checkNotNull(threadContextElement);
                threadContextElement.restoreThreadContext(coroutineContext, this.f6269b[length]);
                if (i >= 0) {
                    length = i;
                } else {
                    return;
                }
            }
        }
    }
}
