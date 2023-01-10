package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, mo148868d2 = {"Lkotlinx/coroutines/internal/ContextScope;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "coroutineContext", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "toString", "", "kotlinx-coroutines-core"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: Scopes.kt */
public final class ContextScope implements CoroutineScope {

    /* renamed from: a */
    private final CoroutineContext f6227a;

    public ContextScope(CoroutineContext coroutineContext) {
        this.f6227a = coroutineContext;
    }

    public CoroutineContext getCoroutineContext() {
        return this.f6227a;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + getCoroutineContext() + VersionRange.RIGHT_OPEN;
    }
}
