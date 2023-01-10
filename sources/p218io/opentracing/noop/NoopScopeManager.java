package p218io.opentracing.noop;

import p218io.opentracing.Scope;
import p218io.opentracing.ScopeManager;
import p218io.opentracing.noop.NoopScopeManagerImpl;

/* renamed from: io.opentracing.noop.NoopScopeManager */
public interface NoopScopeManager extends ScopeManager {
    public static final NoopScopeManager INSTANCE = new NoopScopeManagerImpl();

    /* renamed from: io.opentracing.noop.NoopScopeManager$NoopScope */
    public interface NoopScope extends Scope {
        public static final NoopScope INSTANCE = new NoopScopeManagerImpl.NoopScopeImpl();
    }
}
