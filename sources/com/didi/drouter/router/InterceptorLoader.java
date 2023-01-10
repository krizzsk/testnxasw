package com.didi.drouter.router;

import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.didi.drouter.store.RouterMeta;
import com.didi.drouter.store.RouterStore;
import com.didi.drouter.utils.ReflectUtil;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class InterceptorLoader {

    /* renamed from: a */
    private static final Map<Class<? extends IRouterInterceptor>, IRouterInterceptor> f21046a = new ArrayMap();

    /* renamed from: b */
    private static final Map<Class<? extends IRouterInterceptor>, WeakReference<IRouterInterceptor>> f21047b = new ArrayMap();

    /* renamed from: c */
    private static final Set<Class<? extends IRouterInterceptor>> f21048c = new ArraySet();

    InterceptorLoader() {
    }

    static {
        for (Map.Entry next : RouterStore.getInterceptors().entrySet()) {
            if (((RouterMeta) next.getValue()).isGlobal()) {
                f21048c.add(next.getKey());
            }
        }
    }

    /* renamed from: a */
    static Queue<IRouterInterceptor> m17785a(RouterMeta routerMeta) {
        ArraySet<Class> arraySet = new ArraySet<>(f21048c);
        Class[] interceptors = routerMeta.getInterceptors();
        if (interceptors != null) {
            arraySet.addAll(Arrays.asList(interceptors));
        }
        PriorityQueue priorityQueue = new PriorityQueue(11, new InterceptorComparator());
        for (Class a : arraySet) {
            priorityQueue.add(m17784a((Class<? extends IRouterInterceptor>) a));
        }
        return priorityQueue;
    }

    private static class InterceptorComparator implements Comparator<IRouterInterceptor> {
        private InterceptorComparator() {
        }

        public int compare(IRouterInterceptor iRouterInterceptor, IRouterInterceptor iRouterInterceptor2) {
            return RouterStore.getInterceptors().get(iRouterInterceptor2.getClass()).getPriority() - RouterStore.getInterceptors().get(iRouterInterceptor.getClass()).getPriority();
        }
    }

    /* renamed from: a */
    private static IRouterInterceptor m17784a(Class<? extends IRouterInterceptor> cls) {
        IRouterInterceptor iRouterInterceptor;
        IRouterInterceptor iRouterInterceptor2 = f21046a.get(cls);
        if (iRouterInterceptor2 == null && f21047b.containsKey(cls)) {
            iRouterInterceptor2 = (IRouterInterceptor) f21047b.get(cls).get();
        }
        if (iRouterInterceptor == null) {
            synchronized (InterceptorLoader.class) {
                iRouterInterceptor = f21046a.get(cls);
                if (iRouterInterceptor == null && f21047b.containsKey(cls)) {
                    iRouterInterceptor = (IRouterInterceptor) f21047b.get(cls).get();
                }
                if (iRouterInterceptor == null) {
                    RouterMeta routerMeta = RouterStore.getInterceptors().get(cls);
                    if (routerMeta == null) {
                        routerMeta = RouterMeta.build(RouterMeta.INTERCEPTOR).assembleInterceptor(cls, 0, false, 0);
                        RouterStore.getInterceptors().put(cls, routerMeta);
                    }
                    IRouterInterceptor iRouterInterceptor3 = (IRouterInterceptor) ReflectUtil.getInstance((Class<?>) cls, new Object[0]);
                    if (routerMeta.getCache() == 2) {
                        f21046a.put(cls, iRouterInterceptor3);
                    } else if (routerMeta.getCache() == 1) {
                        f21047b.put(cls, new WeakReference(iRouterInterceptor3));
                    }
                    iRouterInterceptor = iRouterInterceptor3;
                }
            }
        }
        return iRouterInterceptor;
    }
}
