package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.lang.JoinPoint;

/* compiled from: locks.kt */
public class DefaultSimpleLock implements SimpleLock {

    /* renamed from: a */
    private final Lock f5786a;

    public DefaultSimpleLock() {
        this((Lock) null, 1, (DefaultConstructorMarker) null);
    }

    public DefaultSimpleLock(Lock lock) {
        Intrinsics.checkNotNullParameter(lock, JoinPoint.SYNCHRONIZATION_LOCK);
        this.f5786a = lock;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DefaultSimpleLock(Lock lock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ReentrantLock() : lock);
    }

    /* access modifiers changed from: protected */
    public final Lock getLock() {
        return this.f5786a;
    }

    public void lock() {
        this.f5786a.lock();
    }

    public void unlock() {
        this.f5786a.unlock();
    }
}
