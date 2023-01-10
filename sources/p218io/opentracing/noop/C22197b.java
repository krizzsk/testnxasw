package p218io.opentracing.noop;

import java.util.Collections;
import java.util.Map;

/* renamed from: io.opentracing.noop.b */
/* compiled from: NoopSpanContext */
final class C22197b implements NoopSpanContext {

    /* renamed from: a */
    static final C22197b f60773a = new C22197b();

    public String toSpanId() {
        return "";
    }

    public String toTraceId() {
        return "";
    }

    C22197b() {
    }

    public Iterable<Map.Entry<String, String>> baggageItems() {
        return Collections.emptyList();
    }

    public String toString() {
        return NoopSpanContext.class.getSimpleName();
    }
}
