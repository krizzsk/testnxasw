package com.didi.travel.psnger.core.order;

import android.text.TextUtils;
import com.didi.travel.psnger.utils.LogUtil;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class OrderEventManager {

    /* renamed from: a */
    private static OrderEventManager f46838a;

    /* renamed from: b */
    private Map<String, Set<DiDiEventReceiver>> f46839b = new HashMap();

    /* renamed from: c */
    private ConcurrentHashMap<String, Object> f46840c = new ConcurrentHashMap<>();

    public interface DiDiEventReceiver<T> {
        void onReceive(String str, T t);
    }

    private OrderEventManager() {
    }

    /* renamed from: a */
    public static OrderEventManager m34856a() {
        if (f46838a == null) {
            synchronized (OrderEventManager.class) {
                if (f46838a == null) {
                    f46838a = new OrderEventManager();
                }
            }
        }
        return f46838a;
    }

    /* renamed from: a */
    public boolean mo116769a(String str, DiDiEventReceiver diDiEventReceiver) {
        Class<? extends Object> a;
        Set set;
        if (TextUtils.isEmpty(str) || diDiEventReceiver == null || (a = m34857a((Class) diDiEventReceiver.getClass(), DiDiEventReceiver.class)) == null) {
            return false;
        }
        String a2 = m34858a(str, (Class) a);
        LogUtil.m34917e("DiDiEventManager", "registerEventReceiver key = " + a2);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        Map<String, Set<DiDiEventReceiver>> map = this.f46839b;
        synchronized (map) {
            set = map.get(a2);
            if (set == null) {
                set = new LinkedHashSet();
                map.put(a2, set);
            }
        }
        synchronized (set) {
            if (set.contains(diDiEventReceiver)) {
                return false;
            }
            set.add(diDiEventReceiver);
            m34859c(str, diDiEventReceiver);
            return true;
        }
    }

    /* renamed from: c */
    private void m34859c(String str, DiDiEventReceiver diDiEventReceiver) {
        for (String equals : this.f46840c.keySet()) {
            if (str.equals(equals)) {
                diDiEventReceiver.onReceive(str, this.f46840c.get(str));
            }
        }
    }

    /* renamed from: b */
    public boolean mo116771b(String str, DiDiEventReceiver diDiEventReceiver) {
        Class<? extends Object> a;
        Set set;
        boolean remove;
        if (TextUtils.isEmpty(str) || diDiEventReceiver == null || (a = m34857a((Class) diDiEventReceiver.getClass(), DiDiEventReceiver.class)) == null) {
            return false;
        }
        String a2 = m34858a(str, (Class) a);
        LogUtil.m34917e("DiDiEventManager", "unregisterEventReceiver key = " + a2);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        Map<String, Set<DiDiEventReceiver>> map = this.f46839b;
        synchronized (map) {
            set = map.get(a2);
        }
        if (set == null) {
            return false;
        }
        synchronized (set) {
            remove = set.remove(diDiEventReceiver);
        }
        return remove;
    }

    /* renamed from: a */
    public void mo116768a(String str, Object obj) {
        DiDiEventReceiver[] diDiEventReceiverArr;
        if (!TextUtils.isEmpty(str) && obj != null) {
            String a = m34858a(str, (Class) obj.getClass());
            LogUtil.m34917e("DiDiEventManager", "sendDiDiEvent key = " + a);
            if (!TextUtils.isEmpty(a)) {
                Map<String, Set<DiDiEventReceiver>> map = this.f46839b;
                synchronized (map) {
                    Set set = map.get(a);
                    diDiEventReceiverArr = set != null ? (DiDiEventReceiver[]) set.toArray(new DiDiEventReceiver[set.size()]) : null;
                }
                int length = diDiEventReceiverArr != null ? diDiEventReceiverArr.length : 0;
                for (int i = 0; i < length; i++) {
                    diDiEventReceiverArr[i].onReceive(str, obj);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo116770b(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.f46840c.put(str, obj);
            mo116768a(str, obj);
        }
    }

    /* renamed from: a */
    public void mo116767a(String str) {
        this.f46840c.remove(str);
    }

    /* renamed from: a */
    private String m34858a(String str, Class cls) {
        if (cls == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("@");
        stringBuffer.append(cls.getCanonicalName());
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static Class<? extends Object> m34857a(Class cls, Class cls2) {
        Type[] genericInterfaces = cls.getGenericInterfaces();
        int length = genericInterfaces != null ? genericInterfaces.length : 0;
        for (int i = 0; i < length; i++) {
            if (genericInterfaces[i] instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericInterfaces[i];
                if ((parameterizedType.getRawType() instanceof Class) && cls2.isAssignableFrom((Class) parameterizedType.getRawType())) {
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    if (actualTypeArguments[0] instanceof Class) {
                        return (Class) actualTypeArguments[0];
                    }
                    return null;
                }
            }
        }
        return null;
    }
}
