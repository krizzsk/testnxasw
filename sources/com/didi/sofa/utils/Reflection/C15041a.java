package com.didi.sofa.utils.Reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.sofa.utils.Reflection.a */
/* compiled from: MemberUtils */
class C15041a {

    /* renamed from: a */
    private static final int f46515a = 7;

    /* renamed from: b */
    private static final Class<?>[] f46516b = {Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};

    /* renamed from: c */
    private static final Map<Class<?>, Class<?>> f46517c;

    /* renamed from: d */
    private static final Map<Class<?>, Class<?>> f46518d = new HashMap();

    /* renamed from: a */
    private static boolean m34675a(int i) {
        return (i & 7) == 0;
    }

    C15041a() {
    }

    static {
        HashMap hashMap = new HashMap();
        f46517c = hashMap;
        hashMap.put(Boolean.TYPE, Boolean.class);
        f46517c.put(Byte.TYPE, Byte.class);
        f46517c.put(Character.TYPE, Character.class);
        f46517c.put(Short.TYPE, Short.class);
        f46517c.put(Integer.TYPE, Integer.class);
        f46517c.put(Long.TYPE, Long.class);
        f46517c.put(Double.TYPE, Double.class);
        f46517c.put(Float.TYPE, Float.class);
        f46517c.put(Void.TYPE, Void.TYPE);
        for (Class next : f46517c.keySet()) {
            Class cls = f46517c.get(next);
            if (!next.equals(cls)) {
                f46518d.put(cls, next);
            }
        }
    }

    /* renamed from: a */
    static boolean m34679a(Member member) {
        return member != null && Modifier.isPublic(member.getModifiers()) && !member.isSynthetic();
    }

    /* renamed from: a */
    static boolean m34678a(AccessibleObject accessibleObject) {
        if (accessibleObject != null && !accessibleObject.isAccessible()) {
            Member member = (Member) accessibleObject;
            if (!accessibleObject.isAccessible() && Modifier.isPublic(member.getModifiers()) && m34675a(member.getDeclaringClass().getModifiers())) {
                try {
                    accessibleObject.setAccessible(true);
                    return true;
                } catch (SecurityException unused) {
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    static boolean m34676a(Class<?> cls, Class<?> cls2) {
        return m34677a(cls, cls2, true);
    }

    /* renamed from: a */
    static boolean m34680a(Class<?>[] clsArr, Class<?>[] clsArr2, boolean z) {
        if (!ReflectUtils.m34668a((Object[]) clsArr, (Object[]) clsArr2)) {
            return false;
        }
        if (clsArr == null) {
            clsArr = ReflectUtils.f46514b;
        }
        if (clsArr2 == null) {
            clsArr2 = ReflectUtils.f46514b;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (!m34677a(clsArr[i], clsArr2[i], z)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    static boolean m34677a(Class<?> cls, Class<?> cls2, boolean z) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (z) {
            if (cls.isPrimitive() && !cls2.isPrimitive() && (cls = m34674a(cls)) == null) {
                return false;
            }
            if (cls2.isPrimitive() && !cls.isPrimitive() && (cls = m34682b(cls)) == null) {
                return false;
            }
        }
        if (cls.equals(cls2)) {
            return true;
        }
        if (!cls.isPrimitive()) {
            return cls2.isAssignableFrom(cls);
        }
        if (!cls2.isPrimitive()) {
            return false;
        }
        if (Integer.TYPE.equals(cls)) {
            if (Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2)) {
                return true;
            }
            return false;
        } else if (Long.TYPE.equals(cls)) {
            if (Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2)) {
                return true;
            }
            return false;
        } else if (Boolean.TYPE.equals(cls) || Double.TYPE.equals(cls)) {
            return false;
        } else {
            if (Float.TYPE.equals(cls)) {
                return Double.TYPE.equals(cls2);
            }
            if (Character.TYPE.equals(cls)) {
                if (Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2)) {
                    return true;
                }
                return false;
            } else if (Short.TYPE.equals(cls)) {
                if (Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2)) {
                    return true;
                }
                return false;
            } else if (!Byte.TYPE.equals(cls)) {
                return false;
            } else {
                if (Short.TYPE.equals(cls2) || Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2)) {
                    return true;
                }
                return false;
            }
        }
    }

    /* renamed from: a */
    static Class<?> m34674a(Class<?> cls) {
        return (cls == null || !cls.isPrimitive()) ? cls : f46517c.get(cls);
    }

    /* renamed from: b */
    static Class<?> m34682b(Class<?> cls) {
        return f46518d.get(cls);
    }

    /* renamed from: a */
    static int m34673a(Class<?>[] clsArr, Class<?>[] clsArr2, Class<?>[] clsArr3) {
        float a = m34672a(clsArr3, clsArr);
        float a2 = m34672a(clsArr3, clsArr2);
        if (a < a2) {
            return -1;
        }
        return a2 < a ? 1 : 0;
    }

    /* renamed from: a */
    private static float m34672a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        float f = 0.0f;
        for (int i = 0; i < clsArr.length; i++) {
            f += m34681b(clsArr[i], clsArr2[i]);
        }
        return f;
    }

    /* renamed from: b */
    private static float m34681b(Class<?> cls, Class<?> cls2) {
        if (cls2.isPrimitive()) {
            return m34683c(cls, cls2);
        }
        float f = 0.0f;
        Class<? super Object> cls3 = cls;
        while (true) {
            if (cls3 != null && !cls2.equals(cls3)) {
                if (cls2.isInterface() && m34676a(cls3, cls2)) {
                    f += 0.25f;
                    break;
                }
                f += 1.0f;
                cls3 = cls3.getSuperclass();
            } else {
                break;
            }
        }
        return cls3 == null ? f + 1.5f : f;
    }

    /* renamed from: c */
    private static float m34683c(Class<?> cls, Class<?> cls2) {
        float f;
        if (!cls.isPrimitive()) {
            cls = m34682b(cls);
            f = 0.1f;
        } else {
            f = 0.0f;
        }
        int i = 0;
        while (cls != cls2) {
            Class<?>[] clsArr = f46516b;
            if (i >= clsArr.length) {
                break;
            }
            if (cls == clsArr[i]) {
                f += 0.1f;
                if (i < clsArr.length - 1) {
                    cls = clsArr[i + 1];
                }
            }
            i++;
        }
        return f;
    }
}
