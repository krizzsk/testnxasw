package p218io.opentracing.util;

import java.util.concurrent.atomic.AtomicInteger;
import p218io.opentracing.Scope;
import p218io.opentracing.Span;

@Deprecated
/* renamed from: io.opentracing.util.AutoFinishScope */
public class AutoFinishScope implements Scope {

    /* renamed from: a */
    final AutoFinishScopeManager f60775a;

    /* renamed from: b */
    final AtomicInteger f60776b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Span f60777c;

    /* renamed from: d */
    private final AutoFinishScope f60778d;

    AutoFinishScope(AutoFinishScopeManager autoFinishScopeManager, AtomicInteger atomicInteger, Span span) {
        this.f60775a = autoFinishScopeManager;
        this.f60776b = atomicInteger;
        this.f60777c = span;
        this.f60778d = autoFinishScopeManager.f60779a.get();
        autoFinishScopeManager.f60779a.set(this);
    }

    /* renamed from: io.opentracing.util.AutoFinishScope$Continuation */
    public class Continuation {
        public Continuation() {
            AutoFinishScope.this.f60776b.incrementAndGet();
        }

        public AutoFinishScope activate() {
            return new AutoFinishScope(AutoFinishScope.this.f60775a, AutoFinishScope.this.f60776b, AutoFinishScope.this.f60777c);
        }
    }

    public Continuation capture() {
        return new Continuation();
    }

    public void close() {
        if (this.f60775a.f60779a.get() == this) {
            if (this.f60776b.decrementAndGet() == 0) {
                this.f60777c.finish();
            }
            this.f60775a.f60779a.set(this.f60778d);
        }
    }

    public Span span() {
        return this.f60777c;
    }
}
