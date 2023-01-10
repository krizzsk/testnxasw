package com.didi.soda.cart;

import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;

public class SecurityHandlerHelper {

    /* renamed from: a */
    private AtomicReference<InnerRunable> f42462a = new AtomicReference<>();

    public void post(Runnable runnable) {
        clear();
        UiHandlerUtil.post(m31932a(runnable));
    }

    public void postDelayed(Runnable runnable, long j) {
        clear();
        UiHandlerUtil.postDelayed(m31932a(runnable), j);
    }

    public void clear() {
        m31933a();
        if (this.f42462a.get() != null) {
            this.f42462a.get().clear();
            this.f42462a.set((Object) null);
        }
    }

    /* renamed from: a */
    private void m31933a() {
        UiHandlerUtil.removeCallbacks(this.f42462a.get());
    }

    /* renamed from: a */
    private Runnable m31932a(Runnable runnable) {
        InnerRunable innerRunable;
        do {
            InnerRunable innerRunable2 = this.f42462a.get();
            if (innerRunable2 != null) {
                return innerRunable2;
            }
            innerRunable = new InnerRunable(runnable);
        } while (!this.f42462a.compareAndSet((Object) null, innerRunable));
        return innerRunable;
    }

    public static class InnerRunable implements Runnable {
        private WeakReference<Runnable> mWeakReference;

        public InnerRunable(Runnable runnable) {
            this.mWeakReference = new WeakReference<>(runnable);
        }

        public void clear() {
            WeakReference<Runnable> weakReference = this.mWeakReference;
            if (weakReference != null) {
                weakReference.clear();
            }
        }

        public void run() {
            if (this.mWeakReference.get() != null) {
                ((Runnable) this.mWeakReference.get()).run();
            }
            clear();
        }
    }
}
