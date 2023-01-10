package com.didi.travel.p172v2.store;

import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.didi.travel.p172v2.IKey;
import com.didi.travel.p172v2.util.LogUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.travel.v2.store.Store */
public final class Store<T> implements LifecycleOwner, IKey {
    public static final Object[] S_NONE_INVOKE_ARGS = new Object[0];
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f47004a = Store.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Map<String, Store> f47005b = new HashMap();

    /* renamed from: c */
    private final String f47006c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Object[] f47007d = S_NONE_INVOKE_ARGS;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public T f47008e;

    /* renamed from: f */
    private IStoreCallback<T> f47009f;

    /* renamed from: g */
    private final LifecycleRegistry f47010g = LifecycleRegistry.createUnsafe(this);

    /* renamed from: h */
    private Lifecycle f47011h;

    /* renamed from: i */
    private final LifecycleEventObserver f47012i = new LifecycleEventObserver() {
        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                Store.this.destroy();
            }
        }
    };

    public static Map<String, Store> getStoreMap() {
        return new HashMap(f47005b);
    }

    public static synchronized <T> Store<T> getStore(String str) {
        synchronized (Store.class) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Store<T> store = f47005b.get(str);
            return store;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized <T> com.didi.travel.p172v2.store.Store<T> getOrCreateStore(java.lang.String r5) {
        /*
            java.lang.Class<com.didi.travel.v2.store.Store> r0 = com.didi.travel.p172v2.store.Store.class
            monitor-enter(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x000c
            r5 = 0
            monitor-exit(r0)
            return r5
        L_0x000c:
            java.util.Map<java.lang.String, com.didi.travel.v2.store.Store> r1 = f47005b     // Catch:{ all -> 0x003b }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x003b }
            com.didi.travel.v2.store.Store r1 = (com.didi.travel.p172v2.store.Store) r1     // Catch:{ all -> 0x003b }
            if (r1 != 0) goto L_0x0039
            com.didi.travel.v2.store.Store r1 = new com.didi.travel.v2.store.Store     // Catch:{ all -> 0x003b }
            r1.<init>(r5)     // Catch:{ all -> 0x003b }
            java.lang.String r2 = f47004a     // Catch:{ all -> 0x003b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x003b }
            r3.<init>()     // Catch:{ all -> 0x003b }
            java.lang.String r4 = "new, storeKey = "
            r3.append(r4)     // Catch:{ all -> 0x003b }
            r3.append(r5)     // Catch:{ all -> 0x003b }
            java.lang.String r5 = ", store = "
            r3.append(r5)     // Catch:{ all -> 0x003b }
            r3.append(r1)     // Catch:{ all -> 0x003b }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x003b }
            com.didi.travel.p172v2.util.LogUtils.m34982w(r2, r5)     // Catch:{ all -> 0x003b }
        L_0x0039:
            monitor-exit(r0)
            return r1
        L_0x003b:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.travel.p172v2.store.Store.getOrCreateStore(java.lang.String):com.didi.travel.v2.store.Store");
    }

    private Store(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(f47004a + ".new:storeKey is empty");
        } else if (f47005b.get(str) == null) {
            this.f47006c = str;
            this.f47010g.addObserver(new LifecycleEventObserver() {
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    String a = Store.f47004a;
                    LogUtils.m34979e(a, "onStateChanged:event = " + event + ", key = " + Store.this.getKey());
                    if (Lifecycle.Event.ON_CREATE.equals(event)) {
                        Object unused = Store.this.f47008e = null;
                        Object[] unused2 = Store.this.f47007d = null;
                        Store.f47005b.put(Store.this.getKey(), Store.this);
                    } else if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                        Store.f47005b.remove(Store.this.getKey());
                    }
                }
            });
            this.f47010g.setCurrentState(Lifecycle.State.CREATED);
        } else {
            throw new IllegalArgumentException(f47004a + ".new:storeKey conflict, storeKey = " + str + ", origin store = " + f47005b.get(str));
        }
    }

    public String getKey() {
        return this.f47006c;
    }

    public synchronized Object[] getInvokeArgs() {
        if (!isValid()) {
            return null;
        }
        return this.f47007d;
    }

    public synchronized T getData() {
        if (!isValid()) {
            return null;
        }
        return this.f47008e;
    }

    public synchronized void setCallback(IStoreCallback<T> iStoreCallback) {
        this.f47009f = iStoreCallback;
        checkState();
    }

    public synchronized void setStore(Object[] objArr, T t) {
        if (!Lifecycle.State.DESTROYED.equals(getLifecycle().getCurrentState())) {
            this.f47007d = objArr;
            this.f47008e = t;
            checkState();
        }
    }

    public synchronized Lifecycle getOuterLifecycle() {
        return this.f47011h;
    }

    public synchronized void setOuterLifecycle(Lifecycle lifecycle) {
        if (lifecycle != this.f47011h) {
            if (this.f47011h != null) {
                this.f47011h.removeObserver(this.f47012i);
            }
            this.f47011h = lifecycle;
            lifecycle.addObserver(this.f47012i);
        }
    }

    public synchronized void reset() {
        this.f47007d = S_NONE_INVOKE_ARGS;
        this.f47008e = null;
        this.f47010g.setCurrentState(Lifecycle.State.CREATED);
    }

    public synchronized void destroy() {
        this.f47007d = S_NONE_INVOKE_ARGS;
        this.f47008e = null;
        this.f47010g.setCurrentState(Lifecycle.State.DESTROYED);
    }

    public void checkState() {
        if (!Lifecycle.State.DESTROYED.equals(this.f47010g.getCurrentState())) {
            IStoreCallback<T> iStoreCallback = this.f47009f;
            if (iStoreCallback == null || iStoreCallback.isValid(this.f47007d, this.f47008e)) {
                this.f47010g.setCurrentState(Lifecycle.State.RESUMED);
            } else {
                this.f47010g.setCurrentState(Lifecycle.State.STARTED);
            }
        }
    }

    public synchronized boolean isValid() {
        checkState();
        return this.f47010g.getCurrentState().isAtLeast(Lifecycle.State.RESUMED);
    }

    public LifecycleRegistry getLifecycle() {
        return this.f47010g;
    }
}
