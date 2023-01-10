package p218io.opentracing.noop;

import p218io.opentracing.Scope;
import p218io.opentracing.Span;
import p218io.opentracing.SpanContext;
import p218io.opentracing.Tracer;
import p218io.opentracing.noop.NoopScopeManager;
import p218io.opentracing.tag.Tag;

/* renamed from: io.opentracing.noop.a */
/* compiled from: NoopSpanBuilder */
final class C22196a implements NoopSpanBuilder {
    public Tracer.SpanBuilder addReference(String str, SpanContext spanContext) {
        return this;
    }

    public Tracer.SpanBuilder asChildOf(Span span) {
        return this;
    }

    public Tracer.SpanBuilder asChildOf(SpanContext spanContext) {
        return this;
    }

    public Tracer.SpanBuilder ignoreActiveSpan() {
        return this;
    }

    public Tracer.SpanBuilder withStartTimestamp(long j) {
        return this;
    }

    public <T> Tracer.SpanBuilder withTag(Tag<T> tag, T t) {
        return this;
    }

    public Tracer.SpanBuilder withTag(String str, Number number) {
        return this;
    }

    public Tracer.SpanBuilder withTag(String str, String str2) {
        return this;
    }

    public Tracer.SpanBuilder withTag(String str, boolean z) {
        return this;
    }

    C22196a() {
    }

    public Scope startActive(boolean z) {
        return NoopScopeManager.NoopScope.INSTANCE;
    }

    public Span start() {
        return startManual();
    }

    public Span startManual() {
        return C22198c.INSTANCE;
    }

    public String toString() {
        return NoopSpanBuilder.class.getSimpleName();
    }
}
