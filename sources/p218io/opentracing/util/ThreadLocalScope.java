package p218io.opentracing.util;

import p218io.opentracing.Scope;
import p218io.opentracing.Span;

/* renamed from: io.opentracing.util.ThreadLocalScope */
public class ThreadLocalScope implements Scope {

    /* renamed from: a */
    private final ThreadLocalScopeManager f60783a;

    /* renamed from: b */
    private final Span f60784b;

    /* renamed from: c */
    private final boolean f60785c;

    /* renamed from: d */
    private final ThreadLocalScope f60786d;

    ThreadLocalScope(ThreadLocalScopeManager threadLocalScopeManager, Span span) {
        this(threadLocalScopeManager, span, false);
    }

    ThreadLocalScope(ThreadLocalScopeManager threadLocalScopeManager, Span span, boolean z) {
        this.f60783a = threadLocalScopeManager;
        this.f60784b = span;
        this.f60785c = z;
        this.f60786d = threadLocalScopeManager.f60787a.get();
        threadLocalScopeManager.f60787a.set(this);
    }

    public void close() {
        if (this.f60783a.f60787a.get() == this) {
            if (this.f60785c) {
                this.f60784b.finish();
            }
            this.f60783a.f60787a.set(this.f60786d);
        }
    }

    public Span span() {
        return this.f60784b;
    }
}
