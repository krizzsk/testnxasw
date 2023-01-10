package p218io.opentracing.util;

import p218io.opentracing.Scope;
import p218io.opentracing.ScopeManager;
import p218io.opentracing.Span;

/* renamed from: io.opentracing.util.ThreadLocalScopeManager */
public class ThreadLocalScopeManager implements ScopeManager {

    /* renamed from: a */
    final ThreadLocal<ThreadLocalScope> f60787a = new ThreadLocal<>();

    public Scope activate(Span span, boolean z) {
        return new ThreadLocalScope(this, span, z);
    }

    public Scope activate(Span span) {
        return new ThreadLocalScope(this, span);
    }

    public Scope active() {
        return this.f60787a.get();
    }

    public Span activeSpan() {
        Scope scope = this.f60787a.get();
        if (scope == null) {
            return null;
        }
        return scope.span();
    }
}
