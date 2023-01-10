package kotlinx.coroutines.debug.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

@Metadata(mo148867d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0019\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8G¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, mo148868d2 = {"Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "", "source", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/CoroutineContext;)V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "creationStackBottom", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCreationStackBottom", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "creationStackTrace", "", "Ljava/lang/StackTraceElement;", "getCreationStackTrace", "()Ljava/util/List;", "lastObservedFrame", "getLastObservedFrame", "lastObservedStackTrace", "lastObservedThread", "Ljava/lang/Thread;", "getLastObservedThread", "()Ljava/lang/Thread;", "sequenceNumber", "", "getSequenceNumber", "()J", "state", "", "getState", "()Ljava/lang/String;", "kotlinx-coroutines-core"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: DebugCoroutineInfo.kt */
public final class DebugCoroutineInfo {

    /* renamed from: a */
    private final CoroutineContext f6123a;

    /* renamed from: b */
    private final CoroutineStackFrame f6124b;

    /* renamed from: c */
    private final long f6125c;

    /* renamed from: d */
    private final List<StackTraceElement> f6126d;

    /* renamed from: e */
    private final String f6127e;

    /* renamed from: f */
    private final Thread f6128f;

    /* renamed from: g */
    private final CoroutineStackFrame f6129g;

    /* renamed from: h */
    private final List<StackTraceElement> f6130h;

    public DebugCoroutineInfo(DebugCoroutineInfoImpl debugCoroutineInfoImpl, CoroutineContext coroutineContext) {
        this.f6123a = coroutineContext;
        this.f6124b = debugCoroutineInfoImpl.getCreationStackBottom();
        this.f6125c = debugCoroutineInfoImpl.sequenceNumber;
        this.f6126d = debugCoroutineInfoImpl.getCreationStackTrace();
        this.f6127e = debugCoroutineInfoImpl.getState();
        this.f6128f = debugCoroutineInfoImpl.lastObservedThread;
        this.f6129g = debugCoroutineInfoImpl.getLastObservedFrame$kotlinx_coroutines_core();
        this.f6130h = debugCoroutineInfoImpl.lastObservedStackTrace();
    }

    public final CoroutineContext getContext() {
        return this.f6123a;
    }

    public final CoroutineStackFrame getCreationStackBottom() {
        return this.f6124b;
    }

    public final long getSequenceNumber() {
        return this.f6125c;
    }

    public final List<StackTraceElement> getCreationStackTrace() {
        return this.f6126d;
    }

    public final String getState() {
        return this.f6127e;
    }

    public final Thread getLastObservedThread() {
        return this.f6128f;
    }

    public final CoroutineStackFrame getLastObservedFrame() {
        return this.f6129g;
    }

    public final List<StackTraceElement> lastObservedStackTrace() {
        return this.f6130h;
    }
}
