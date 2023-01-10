package p218io.opentracing.util;

import java.util.concurrent.Callable;
import p218io.opentracing.Scope;
import p218io.opentracing.ScopeManager;
import p218io.opentracing.Span;
import p218io.opentracing.SpanContext;
import p218io.opentracing.Tracer;
import p218io.opentracing.noop.NoopTracerFactory;
import p218io.opentracing.propagation.Format;

/* renamed from: io.opentracing.util.GlobalTracer */
public final class GlobalTracer implements Tracer {

    /* renamed from: a */
    private static final GlobalTracer f60780a = new GlobalTracer();

    /* renamed from: b */
    private static volatile Tracer f60781b = NoopTracerFactory.create();

    /* renamed from: c */
    private static volatile boolean f60782c = false;

    private GlobalTracer() {
    }

    public static Tracer get() {
        return f60780a;
    }

    public static boolean isRegistered() {
        return f60782c;
    }

    public static synchronized boolean registerIfAbsent(Callable<Tracer> callable) {
        synchronized (GlobalTracer.class) {
            m45904a(callable, "Cannot register GlobalTracer from provider <null>.");
            if (!isRegistered()) {
                try {
                    Tracer tracer = (Tracer) m45904a(callable.call(), "Cannot register GlobalTracer <null>.");
                    if (!(tracer instanceof GlobalTracer)) {
                        f60781b = tracer;
                        f60782c = true;
                        return true;
                    }
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new IllegalStateException("Exception obtaining tracer from provider: " + e2.getMessage(), e2);
                }
            }
            return false;
        }
    }

    public static synchronized boolean registerIfAbsent(final Tracer tracer) {
        boolean registerIfAbsent;
        synchronized (GlobalTracer.class) {
            m45904a(tracer, "Cannot register GlobalTracer. Tracer is null");
            registerIfAbsent = registerIfAbsent((Callable<Tracer>) new Callable<Tracer>() {
                public Tracer call() {
                    return tracer;
                }
            });
        }
        return registerIfAbsent;
    }

    @Deprecated
    public static void register(Tracer tracer) {
        if (!registerIfAbsent(m45905a(tracer)) && !tracer.equals(f60781b) && !(tracer instanceof GlobalTracer)) {
            throw new IllegalStateException("There is already a current global Tracer registered.");
        }
    }

    public ScopeManager scopeManager() {
        return f60781b.scopeManager();
    }

    public Tracer.SpanBuilder buildSpan(String str) {
        return f60781b.buildSpan(str);
    }

    public <C> void inject(SpanContext spanContext, Format<C> format, C c) {
        f60781b.inject(spanContext, format, c);
    }

    public <C> SpanContext extract(Format<C> format, C c) {
        return f60781b.extract(format, c);
    }

    public Span activeSpan() {
        return f60781b.activeSpan();
    }

    public Scope activateSpan(Span span) {
        return f60781b.activateSpan(span);
    }

    public void close() {
        f60781b.close();
    }

    public String toString() {
        return GlobalTracer.class.getSimpleName() + '{' + f60781b + '}';
    }

    /* renamed from: a */
    private static Callable<Tracer> m45905a(final Tracer tracer) {
        return new Callable<Tracer>() {
            public Tracer call() {
                return tracer;
            }
        };
    }

    /* renamed from: a */
    private static <T> T m45904a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
