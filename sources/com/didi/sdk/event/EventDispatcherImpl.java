package com.didi.sdk.event;

import android.os.Looper;
import com.didi.sdk.apm.SystemUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class EventDispatcherImpl {

    /* renamed from: a */
    static ExecutorService f38605a = Executors.newCachedThreadPool();

    /* renamed from: b */
    public static String f38606b = "EventDispatcherImpl";

    /* renamed from: c */
    private static final boolean f38607c = true;

    /* renamed from: d */
    private static final Map<Class<?>, List<Class<?>>> f38608d = new HashMap();

    /* renamed from: e */
    private final Map<Class<?>, CopyOnWriteArrayList<C13013h>> f38609e = new HashMap();

    /* renamed from: f */
    private final Map<Object, List<Class<?>>> f38610f = new HashMap();

    /* renamed from: g */
    private final Map<Class<?>, Event> f38611g = new ConcurrentHashMap();

    /* renamed from: h */
    private final ThreadLocal<PostingThreadState> f38612h = new ThreadLocal<PostingThreadState>() {
        /* access modifiers changed from: protected */
        public PostingThreadState initialValue() {
            return new PostingThreadState();
        }
    };

    /* renamed from: i */
    private final C13008c f38613i = new C13008c(this, Looper.getMainLooper(), 10);

    /* renamed from: j */
    private final C13007b f38614j = new C13007b(this);

    /* renamed from: k */
    private final C13006a f38615k = new C13006a(this);

    /* renamed from: l */
    private final C13012g f38616l = new C13012g();

    /* renamed from: m */
    private boolean f38617m;

    /* renamed from: a */
    public static void m29104a() {
        C13012g.m29139a();
        f38608d.clear();
    }

    /* renamed from: a */
    public static void m29107a(Class<?> cls) {
        C13012g.m29141b(cls);
    }

    /* renamed from: b */
    public static void m29113b() {
        C13012g.m29140b();
    }

    /* renamed from: a */
    public void mo98007a(Object obj) {
        m29110a(obj, false, 0);
    }

    /* renamed from: a */
    public void mo98008a(Object obj, int i) {
        m29110a(obj, false, i);
    }

    /* renamed from: b */
    public void mo98011b(Object obj) {
        m29110a(obj, true, 0);
    }

    /* renamed from: b */
    public void mo98012b(Object obj, int i) {
        m29110a(obj, true, i);
    }

    /* renamed from: a */
    private synchronized void m29110a(Object obj, boolean z, int i) {
        for (C13011f a : this.f38616l.mo98036a(obj.getClass())) {
            m29108a(obj, a, z, i);
        }
    }

    /* renamed from: a */
    private synchronized void m29111a(Object obj, boolean z, Class<?> cls, Class<?>... clsArr) {
        for (C13011f next : this.f38616l.mo98036a(obj.getClass())) {
            if (cls == next.f38636c) {
                m29108a(obj, next, z, 0);
            } else if (clsArr != null) {
                int length = clsArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (clsArr[i] == next.f38636c) {
                        m29108a(obj, next, z, 0);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m29108a(Object obj, C13011f fVar, boolean z, int i) {
        Event event;
        boolean z2 = true;
        this.f38617m = true;
        Class<?> cls = fVar.f38636c;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f38609e.get(cls);
        C13013h hVar = new C13013h(obj, fVar, i);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f38609e.put(cls, copyOnWriteArrayList);
        } else {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (((C13013h) it.next()).equals(hVar)) {
                    throw new StoreException("Subscriber " + obj.getClass() + " already registered to event " + cls);
                }
            }
        }
        int size = copyOnWriteArrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 > size) {
                break;
            } else if (i2 == size || hVar.f38643c > ((C13013h) copyOnWriteArrayList.get(i2)).f38643c) {
                copyOnWriteArrayList.add(i2, hVar);
            } else {
                i2++;
            }
        }
        List list = this.f38610f.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.f38610f.put(obj, list);
        }
        list.add(cls);
        if (z) {
            synchronized (this.f38611g) {
                event = this.f38611g.get(cls);
            }
            if (event != null) {
                if (Looper.getMainLooper() != Looper.myLooper()) {
                    z2 = false;
                }
                m29106a(hVar, event, z2);
            }
        }
    }

    /* renamed from: c */
    public synchronized boolean mo98015c(Object obj) {
        return this.f38610f.containsKey(obj);
    }

    /* renamed from: a */
    private void m29109a(Object obj, Class<?> cls) {
        List list = this.f38609e.get(cls);
        if (list != null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                C13013h hVar = (C13013h) list.get(i);
                if (hVar.f38641a == obj) {
                    hVar.f38644d = false;
                    list.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    /* renamed from: d */
    public synchronized void mo98016d(Object obj) {
        List<Class> list = this.f38610f.get(obj);
        if (list != null) {
            for (Class a : list) {
                m29109a(obj, (Class<?>) a);
            }
            this.f38610f.remove(obj);
        } else {
            String str = f38606b;
            SystemUtils.log(5, str, "Subscriber to unregister was not registered before: " + obj.getClass(), (Throwable) null, "com.didi.sdk.event.EventDispatcherImpl", 334);
        }
    }

    /* renamed from: a */
    public void mo98004a(Event event) {
        PostingThreadState postingThreadState = this.f38612h.get();
        List<Event> list = postingThreadState.eventQueue;
        list.add(event);
        if (!postingThreadState.isPosting) {
            postingThreadState.isMainThread = Looper.getMainLooper() == Looper.myLooper();
            postingThreadState.isPosting = true;
            if (!postingThreadState.canceled) {
                while (!list.isEmpty()) {
                    try {
                        m29105a(list.remove(0), postingThreadState);
                    } finally {
                        postingThreadState.isPosting = false;
                        postingThreadState.isMainThread = false;
                    }
                }
                return;
            }
            throw new StoreException("Internal error. Abort state was not reset");
        }
    }

    /* renamed from: e */
    public void mo98017e(Object obj) {
        PostingThreadState postingThreadState = this.f38612h.get();
        if (!postingThreadState.isPosting) {
            throw new StoreException("This method may only be called from inside event handling methods on the posting thread");
        } else if (obj == null) {
            throw new StoreException("Event may not be null");
        } else if (postingThreadState.event != obj) {
            throw new StoreException("Only the currently handled event may be aborted");
        } else if (postingThreadState.subscription.f38642b.f38635b == ThreadMode.PostThread) {
            postingThreadState.canceled = true;
        } else {
            throw new StoreException(" event handlers may only abort the incoming event");
        }
    }

    /* renamed from: b */
    public void mo98010b(Event event) {
        synchronized (this.f38611g) {
            this.f38611g.put(event.getClass(), event);
        }
        mo98004a(event);
    }

    /* renamed from: b */
    public <T> T mo98009b(Class<T> cls) {
        T cast;
        synchronized (this.f38611g) {
            cast = cls.cast(this.f38611g.get(cls));
        }
        return cast;
    }

    /* renamed from: c */
    public <T> T mo98013c(Class<T> cls) {
        T cast;
        synchronized (this.f38611g) {
            cast = cls.cast(this.f38611g.remove(cls));
        }
        return cast;
    }

    /* renamed from: f */
    public boolean mo98018f(Object obj) {
        synchronized (this.f38611g) {
            Class<?> cls = obj.getClass();
            if (!obj.equals(this.f38611g.get(cls))) {
                return false;
            }
            this.f38611g.remove(cls);
            return true;
        }
    }

    /* renamed from: c */
    public void mo98014c() {
        synchronized (this.f38611g) {
            this.f38611g.clear();
        }
    }

    /* renamed from: a */
    private void m29105a(Event event, PostingThreadState postingThreadState) throws Error {
        CopyOnWriteArrayList copyOnWriteArrayList;
        Class<?> cls = event.getClass();
        List<Class<?>> d = m29114d(cls);
        int size = d.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            Class cls2 = d.get(i);
            synchronized (this) {
                copyOnWriteArrayList = this.f38609e.get(cls2);
            }
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    C13013h hVar = (C13013h) it.next();
                    postingThreadState.event = event;
                    postingThreadState.subscription = hVar;
                    try {
                        m29106a(hVar, event, postingThreadState.isMainThread);
                        if (postingThreadState.canceled) {
                            break;
                        }
                    } finally {
                        postingThreadState.event = null;
                        postingThreadState.subscription = null;
                        postingThreadState.canceled = false;
                    }
                }
                z = true;
            }
        }
        if (!z) {
            String str = f38606b;
            SystemUtils.log(3, str, "No subscribers registered for event " + cls, (Throwable) null, "com.didi.sdk.event.EventDispatcherImpl", 483);
        }
    }

    /* renamed from: com.didi.sdk.event.EventDispatcherImpl$2 */
    static /* synthetic */ class C130052 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$sdk$event$ThreadMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.sdk.event.ThreadMode[] r0 = com.didi.sdk.event.ThreadMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$sdk$event$ThreadMode = r0
                com.didi.sdk.event.ThreadMode r1 = com.didi.sdk.event.ThreadMode.PostThread     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$sdk$event$ThreadMode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.sdk.event.ThreadMode r1 = com.didi.sdk.event.ThreadMode.MainThread     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$sdk$event$ThreadMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.sdk.event.ThreadMode r1 = com.didi.sdk.event.ThreadMode.BackgroundThread     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$sdk$event$ThreadMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.sdk.event.ThreadMode r1 = com.didi.sdk.event.ThreadMode.Async     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.event.EventDispatcherImpl.C130052.<clinit>():void");
        }
    }

    /* renamed from: a */
    private void m29106a(C13013h hVar, Event event, boolean z) {
        int i = C130052.$SwitchMap$com$didi$sdk$event$ThreadMode[hVar.f38642b.f38635b.ordinal()];
        if (i == 1) {
            mo98006a(hVar, event);
        } else if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    this.f38615k.mo98021a(hVar, event);
                    return;
                }
                throw new IllegalStateException("Unknown thread mode: " + hVar.f38642b.f38635b);
            } else if (z) {
                this.f38614j.mo98023a(hVar, event);
            } else {
                mo98006a(hVar, event);
            }
        } else if (z) {
            mo98006a(hVar, event);
        } else {
            this.f38613i.mo98025a(hVar, event);
        }
    }

    /* renamed from: d */
    private List<Class<?>> m29114d(Class<?> cls) {
        List<Class<?>> list;
        synchronized (f38608d) {
            list = f38608d.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    m29112a(list, (Class<?>[]) cls2.getInterfaces());
                }
                f38608d.put(cls, list);
            }
        }
        return list;
    }

    /* renamed from: a */
    static void m29112a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                m29112a(list, (Class<?>[]) cls.getInterfaces());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo98005a(C13009d dVar) {
        Event event = dVar.f38629a;
        C13013h hVar = dVar.f38630b;
        C13009d.m29134a(dVar);
        if (hVar.f38644d) {
            mo98006a(hVar, event);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo98006a(C13013h hVar, Event event) throws Error {
        try {
            hVar.f38642b.f38634a.invoke(hVar.f38641a, new Object[]{event});
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (event instanceof StoreExceptionEvent) {
                String str = f38606b;
                SystemUtils.log(6, str, "StoreExceptionEvent subscriber " + hVar.f38641a.getClass() + " threw an exception", cause, "com.didi.sdk.event.EventDispatcherImpl", 573);
                StoreExceptionEvent storeExceptionEvent = (StoreExceptionEvent) event;
                String str2 = f38606b;
                SystemUtils.log(6, str2, "Initial event " + storeExceptionEvent.causingEvent + " caused exception in " + storeExceptionEvent.causingSubscriber, storeExceptionEvent.throwable, "com.didi.sdk.event.EventDispatcherImpl", 578);
                return;
            }
            String str3 = f38606b;
            SystemUtils.log(6, str3, "Could not dispatch event: " + event.getClass() + " to subscribing class " + hVar.f38641a.getClass(), cause, "com.didi.sdk.event.EventDispatcherImpl", 583);
            mo98004a((Event) new StoreExceptionEvent(this, cause, event, hVar.f38641a));
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        }
    }

    static final class PostingThreadState {
        boolean canceled;
        Event event;
        List<Event> eventQueue = new ArrayList();
        boolean isMainThread;
        boolean isPosting;
        C13013h subscription;

        PostingThreadState() {
        }
    }
}
