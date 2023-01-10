package com.didi.component.never.core.event;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.didi.component.never.core.util.GenericHelper;
import com.didi.sdk.apm.SystemUtils;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

public final class BaseEventPublisher {

    /* renamed from: a */
    private static BaseEventPublisher f16498a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Map<String, Set<OnEventListener>> f16499b = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Map<String, Set<OnEventListener>> f16500c = new HashMap();

    /* renamed from: d */
    private final Map<String, Set<OnEventListener>> f16501d = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Map<String, Object> f16502e = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SerialExecutor f16503f = new SerialExecutor();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f16504g = new Handler(Looper.getMainLooper());

    private interface Callback {
        public static final Callback NULL = null;

        void onCallback(boolean z);
    }

    public interface OnEventListener<T> {
        void onEvent(String str, T t);
    }

    @Target({ElementType.PARAMETER, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface StrictType {
    }

    @Deprecated
    public void setPage(Context context, String str) {
    }

    private BaseEventPublisher() {
    }

    public static BaseEventPublisher getPublisher() {
        if (f16498a == null) {
            synchronized (BaseEventPublisher.class) {
                if (f16498a == null) {
                    f16498a = new BaseEventPublisher();
                }
            }
        }
        return f16498a;
    }

    public boolean subscribe(String str, OnEventListener onEventListener) {
        if (TextUtils.isEmpty(str) || onEventListener == null) {
            return false;
        }
        m13824a(str, onEventListener, Callback.NULL);
        return true;
    }

    public boolean subscribeSync(String str, OnEventListener onEventListener) {
        Map<String, Set<OnEventListener>> map;
        Set set;
        String b = m13828b(str, GenericHelper.getGenericTypeArgument(onEventListener.getClass(), OnEventListener.class, 0));
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        if (m13833b((Class) onEventListener.getClass())) {
            map = this.f16499b;
        } else {
            map = this.f16500c;
        }
        synchronized (map) {
            set = map.get(b);
            if (set == null) {
                set = new LinkedHashSet();
                map.put(b, set);
            }
        }
        synchronized (set) {
            if (set.contains(onEventListener)) {
                return false;
            }
            set.add(onEventListener);
            return true;
        }
    }

    /* renamed from: a */
    private void m13824a(final String str, final OnEventListener onEventListener, final Callback callback) {
        this.f16503f.execute(new Runnable() {
            public void run() {
                Map map;
                Set set;
                OnEventListener onEventListener = onEventListener;
                if (onEventListener != null && onEventListener.getClass() != null) {
                    try {
                        String a = BaseEventPublisher.m13828b(str, GenericHelper.getGenericTypeArgument(onEventListener.getClass(), OnEventListener.class, 0));
                        if (TextUtils.isEmpty(a)) {
                            Callback callback = callback;
                            if (callback != null) {
                                callback.onCallback(false);
                                return;
                            }
                            return;
                        }
                        if (BaseEventPublisher.m13833b((Class) onEventListener.getClass())) {
                            map = BaseEventPublisher.this.f16499b;
                        } else {
                            map = BaseEventPublisher.this.f16500c;
                        }
                        synchronized (map) {
                            set = (Set) map.get(a);
                            if (set == null) {
                                set = new LinkedHashSet();
                                map.put(a, set);
                            }
                        }
                        synchronized (set) {
                            if (!set.contains(onEventListener)) {
                                set.add(onEventListener);
                                if (callback != null) {
                                    callback.onCallback(true);
                                }
                            } else if (callback != null) {
                                callback.onCallback(false);
                            }
                        }
                    } catch (Exception unused) {
                        SystemUtils.log(6, "BaseEventPublisher", "caught exception: category=" + str + ", listener=" + onEventListener, (Throwable) null, "com.didi.component.never.core.event.BaseEventPublisher$1", 129);
                    }
                }
            }
        });
    }

    public boolean subscribe(String str, OnEventListener onEventListener, Class<?> cls) {
        Map<String, Set<OnEventListener>> map;
        Set set;
        if (TextUtils.isEmpty(str) || onEventListener == null) {
            return false;
        }
        if (cls == null) {
            return subscribe(str, onEventListener);
        }
        String b = m13828b(str, (Class<? extends Object>) cls);
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        if (m13833b((Class) onEventListener.getClass())) {
            map = this.f16499b;
        } else {
            map = this.f16500c;
        }
        synchronized (map) {
            set = map.get(b);
            if (set == null) {
                set = new LinkedHashSet();
                map.put(b, set);
            }
        }
        synchronized (set) {
            if (set.contains(onEventListener)) {
                return false;
            }
            set.add(onEventListener);
            return true;
        }
    }

    public boolean subscribeStickySync(String str, OnEventListener onEventListener) {
        boolean subscribe = subscribe(str, onEventListener);
        if (subscribe) {
            synchronized (this.f16502e) {
                if (this.f16502e.containsKey(str)) {
                    onEventListener.onEvent(str, this.f16502e.get(str));
                }
            }
        }
        return subscribe;
    }

    public boolean subscribeSticky(final String str, final OnEventListener onEventListener) {
        if (TextUtils.isEmpty(str) || onEventListener == null) {
            return false;
        }
        m13824a(str, onEventListener, (Callback) new Callback() {
            public void onCallback(boolean z) {
                if (z) {
                    synchronized (BaseEventPublisher.this.f16502e) {
                        if (BaseEventPublisher.this.f16502e.containsKey(str)) {
                            BaseEventPublisher.this.f16504g.post(new Runnable() {
                                public void run() {
                                    if (!BaseEventPublisher.this.m13835c(str, onEventListener) && !BaseEventPublisher.this.m13835c(str, onEventListener)) {
                                        onEventListener.onEvent(str, BaseEventPublisher.this.f16502e.get(str));
                                    }
                                }
                            });
                        }
                    }
                }
            }
        });
        return true;
    }

    /* renamed from: a */
    private void m13823a(String str, OnEventListener onEventListener) {
        Set set;
        synchronized (this.f16501d) {
            set = this.f16501d.get(str);
            if (set == null) {
                set = new LinkedHashSet();
                this.f16501d.put(str, set);
            }
        }
        synchronized (set) {
            set.add(onEventListener);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m13831b(String str, OnEventListener onEventListener) {
        Set set;
        synchronized (this.f16501d) {
            set = this.f16501d.get(str);
        }
        if (set != null) {
            synchronized (set) {
                set.remove(onEventListener);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m13835c(String str, OnEventListener onEventListener) {
        Set set;
        boolean contains;
        synchronized (this.f16501d) {
            set = this.f16501d.get(str);
        }
        if (set == null) {
            return false;
        }
        synchronized (set) {
            contains = set.contains(onEventListener);
        }
        return contains;
    }

    public boolean unsubscribe(String str, OnEventListener onEventListener) {
        if (TextUtils.isEmpty(str) || onEventListener == null) {
            return false;
        }
        return unsubscribeAsync(str, onEventListener);
    }

    public boolean unsubscribeSync(String str, OnEventListener onEventListener) {
        Map<String, Set<OnEventListener>> map;
        Set set;
        boolean remove;
        String b = m13828b(str, GenericHelper.getGenericTypeArgument(onEventListener.getClass(), OnEventListener.class, 0));
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        if (m13833b((Class) onEventListener.getClass())) {
            map = this.f16499b;
        } else {
            map = this.f16500c;
        }
        synchronized (map) {
            set = map.get(b);
        }
        if (set == null) {
            return false;
        }
        synchronized (set) {
            remove = set.remove(onEventListener);
        }
        return remove;
    }

    public boolean unsubscribeAsync(final String str, final OnEventListener onEventListener) {
        if (TextUtils.isEmpty(str) || onEventListener == null) {
            return false;
        }
        m13823a(str, onEventListener);
        this.f16503f.execute(new Runnable() {
            public void run() {
                Map map;
                Set set;
                try {
                    try {
                        String a = BaseEventPublisher.m13828b(str, GenericHelper.getGenericTypeArgument(onEventListener.getClass(), OnEventListener.class, 0));
                        if (!TextUtils.isEmpty(a)) {
                            if (BaseEventPublisher.m13833b((Class) onEventListener.getClass())) {
                                map = BaseEventPublisher.this.f16499b;
                            } else {
                                map = BaseEventPublisher.this.f16500c;
                            }
                            synchronized (map) {
                                set = (Set) map.get(a);
                            }
                            if (set != null) {
                                synchronized (set) {
                                    set.remove(onEventListener);
                                }
                                BaseEventPublisher.this.m13831b(str, onEventListener);
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        BaseEventPublisher.this.m13831b(str, onEventListener);
                        throw th;
                    }
                } catch (Exception unused) {
                    SystemUtils.log(6, "BaseEventPublisher", "unsubscribe caught exception: category=" + str + ", listener=" + onEventListener, (Throwable) null, "com.didi.component.never.core.event.BaseEventPublisher$3", 351);
                }
                BaseEventPublisher.this.m13831b(str, onEventListener);
            }
        });
        return true;
    }

    public boolean unsubscribe(String str, OnEventListener onEventListener, Class<?> cls) {
        if (TextUtils.isEmpty(str) || onEventListener == null) {
            return false;
        }
        return unsubscribeAsync(str, onEventListener, cls);
    }

    public boolean unsubscribeSync(String str, OnEventListener onEventListener, Class<?> cls) {
        Map<String, Set<OnEventListener>> map;
        Set set;
        boolean remove;
        String b = m13828b(str, (Class<? extends Object>) cls);
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        if (m13833b((Class) onEventListener.getClass())) {
            map = this.f16499b;
        } else {
            map = this.f16500c;
        }
        synchronized (map) {
            set = map.get(b);
        }
        if (set == null) {
            return false;
        }
        synchronized (set) {
            remove = set.remove(onEventListener);
        }
        return remove;
    }

    public boolean unsubscribeAsync(final String str, final OnEventListener onEventListener, final Class<?> cls) {
        m13823a(str, onEventListener);
        this.f16503f.execute(new Runnable() {
            public void run() {
                Map map;
                Set set;
                try {
                    String a = BaseEventPublisher.m13828b(str, (Class<? extends Object>) cls);
                    if (!TextUtils.isEmpty(a)) {
                        if (BaseEventPublisher.m13833b((Class) onEventListener.getClass())) {
                            map = BaseEventPublisher.this.f16499b;
                        } else {
                            map = BaseEventPublisher.this.f16500c;
                        }
                        synchronized (map) {
                            set = (Set) map.get(a);
                        }
                        if (set != null) {
                            synchronized (set) {
                                set.remove(onEventListener);
                            }
                            BaseEventPublisher.this.m13831b(str, onEventListener);
                            return;
                        }
                    }
                    BaseEventPublisher.this.m13831b(str, onEventListener);
                } catch (Throwable th) {
                    BaseEventPublisher.this.m13831b(str, onEventListener);
                    throw th;
                }
            }
        });
        return true;
    }

    public void publish(String str) {
        publish(str, (Object) null);
    }

    public void publish(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            publishAsync(str, obj);
        }
    }

    public void publishSync(String str, Object obj) {
        Class cls = obj != null ? obj.getClass() : NullEvent.class;
        String b = m13828b(str, (Class<? extends Object>) cls);
        m13825a(b, str, obj, this.f16500c);
        m13825a(b, str, obj, this.f16499b);
        for (Class superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            m13825a(m13828b(str, (Class<? extends Object>) superclass), str, obj, this.f16499b);
        }
    }

    public void publishAsync(final String str, final Object obj) {
        this.f16503f.execute(new Runnable() {
            public void run() {
                Object obj = obj;
                Class cls = obj != null ? obj.getClass() : NullEvent.class;
                final String a = BaseEventPublisher.m13828b(str, (Class<? extends Object>) cls);
                BaseEventPublisher.this.f16503f.execute(new Runnable() {
                    public void run() {
                        BaseEventPublisher.this.m13832b(a, str, obj, BaseEventPublisher.this.f16500c);
                    }
                });
                BaseEventPublisher.this.f16503f.execute(new Runnable() {
                    public void run() {
                        BaseEventPublisher.this.m13832b(a, str, obj, BaseEventPublisher.this.f16499b);
                    }
                });
                for (Class superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
                    final String a2 = BaseEventPublisher.m13828b(str, (Class<? extends Object>) superclass);
                    BaseEventPublisher.this.f16503f.execute(new Runnable() {
                        public void run() {
                            BaseEventPublisher.this.m13832b(a2, str, obj, BaseEventPublisher.this.f16499b);
                        }
                    });
                }
            }
        });
    }

    public void publishSticky(String str) {
        publishSticky(str, (Object) null);
    }

    public void publishSticky(String str, Object obj) {
        Object obj2;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f16502e) {
                if (obj != null) {
                    obj2 = obj;
                } else {
                    obj2 = new NullEvent();
                }
                this.f16502e.put(str, obj2);
            }
            publish(str, obj);
        }
    }

    public void removeStickyEvent(String str) {
        synchronized (this.f16502e) {
            this.f16502e.remove(str);
        }
    }

    public void removeAllStickyEvent() {
        synchronized (this.f16502e) {
            this.f16502e.clear();
        }
    }

    /* renamed from: a */
    private void m13825a(String str, String str2, Object obj, Map<String, Set<OnEventListener>> map) {
        Set set;
        OnEventListener[] onEventListenerArr;
        synchronized (map) {
            set = map.get(str);
        }
        if (set != null) {
            synchronized (set) {
                if (set != null) {
                    try {
                        onEventListenerArr = (OnEventListener[]) set.toArray(new OnEventListener[set.size()]);
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                } else {
                    onEventListenerArr = null;
                }
            }
            int length = onEventListenerArr != null ? onEventListenerArr.length : 0;
            for (int i = 0; i < length; i++) {
                OnEventListener onEventListener = onEventListenerArr[i];
                if (onEventListener != null) {
                    onEventListener.onEvent(str2, obj);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m13832b(String str, String str2, Object obj, Map<String, Set<OnEventListener>> map) {
        Set set;
        OnEventListener[] onEventListenerArr;
        synchronized (map) {
            set = map.get(str);
        }
        if (set != null) {
            synchronized (set) {
                if (set != null) {
                    try {
                        onEventListenerArr = (OnEventListener[]) set.toArray(new OnEventListener[set.size()]);
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                } else {
                    onEventListenerArr = null;
                }
            }
            int length = onEventListenerArr != null ? onEventListenerArr.length : 0;
            for (int i = 0; i < length; i++) {
                final OnEventListener onEventListener = onEventListenerArr[i];
                if (onEventListener != null && !m13835c(str2, onEventListener)) {
                    final String str3 = str2;
                    final Set set2 = set;
                    final Object obj2 = obj;
                    this.f16504g.post(new Runnable() {
                        public void run() {
                            if (!BaseEventPublisher.this.m13835c(str3, onEventListener)) {
                                synchronized (set2) {
                                    if (set2.contains(onEventListener)) {
                                        onEventListener.onEvent(str3, obj2);
                                    }
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    public String toString() {
        return "{spread: " + this.f16499b + ", normal: " + this.f16500c + "}";
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m13833b(Class cls) {
        try {
            Annotation[][] parameterAnnotations = cls.getMethod("onEvent", new Class[]{String.class, Object.class}).getParameterAnnotations();
            if (parameterAnnotations != null && parameterAnnotations.length == 2) {
                int length = parameterAnnotations[1] != null ? parameterAnnotations[1].length : 0;
                for (int i = 0; i < length; i++) {
                    if (StrictType.class.isAssignableFrom(parameterAnnotations[1][i].getClass())) {
                        return false;
                    }
                }
            }
        } catch (NoSuchMethodException unused) {
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m13828b(String str, Class<? extends Object> cls) {
        if (TextUtils.isEmpty(str) || cls == null) {
            return null;
        }
        return str + "@" + cls.getCanonicalName();
    }

    public static final class NullEvent {
        private NullEvent() {
        }
    }

    private static class SerialExecutor implements Executor {
        Runnable mActive;
        final ArrayDeque<Runnable> mTasks;

        private SerialExecutor() {
            this.mTasks = new ArrayDeque<>();
        }

        public synchronized void execute(final Runnable runnable) {
            this.mTasks.offer(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        SerialExecutor.this.scheduleNext();
                    }
                }
            });
            if (this.mActive == null) {
                scheduleNext();
            }
        }

        /* access modifiers changed from: private */
        public synchronized void scheduleNext() {
            Runnable poll = this.mTasks.poll();
            this.mActive = poll;
            if (poll != null) {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(this.mActive);
            }
        }
    }
}
