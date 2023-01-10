package p218io.opentracing.noop;

import p218io.opentracing.Scope;
import p218io.opentracing.ScopeManager;
import p218io.opentracing.Span;
import p218io.opentracing.SpanContext;
import p218io.opentracing.Tracer;
import p218io.opentracing.noop.NoopScopeManager;
import p218io.opentracing.propagation.Format;

/* renamed from: io.opentracing.noop.d */
/* compiled from: NoopTracer */
final class C22199d implements NoopTracer {

    /* renamed from: a */
    static final NoopTracer f60774a = new C22199d();

    public void close() {
    }

    public <C> void inject(SpanContext spanContext, Format<C> format, C c) {
    }

    C22199d() {
    }

    public ScopeManager scopeManager() {
        return NoopScopeManager.INSTANCE;
    }

    public Span activeSpan() {
        return C22198c.INSTANCE;
    }

    public Scope activateSpan(Span span) {
        return NoopScopeManager.NoopScope.INSTANCE;
    }

    public Tracer.SpanBuilder buildSpan(String str) {
        return C22196a.INSTANCE;
    }

    public <C> SpanContext extract(Format<C> format, C c) {
        return C22197b.f60773a;
    }

    public String toString() {
        return NoopTracer.class.getSimpleName();
    }
}
