package com.didi.sofa.utils.Reflection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class ReflectUtils {

    /* renamed from: a */
    static final Object[] f46513a = new Object[0];

    /* renamed from: b */
    static final Class<?>[] f46514b = new Class[0];

    /* renamed from: a */
    static boolean m34668a(Object[] objArr, Object[] objArr2) {
        if (objArr == null && objArr2 != null && objArr2.length > 0) {
            return false;
        }
        if (objArr2 != null || objArr == null || objArr.length <= 0) {
            return objArr == null || objArr2 == null || objArr.length == objArr2.length;
        }
        return false;
    }

    /* renamed from: a */
    static Class<?>[] m34670a(Object... objArr) {
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return f46514b;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            clsArr[i] = objArr[i] == null ? null : objArr[i].getClass();
        }
        return clsArr;
    }

    /* renamed from: a */
    static Class<?>[] m34669a(Class<?>[] clsArr) {
        if (clsArr == null || clsArr.length == 0) {
            return f46514b;
        }
        return clsArr;
    }

    /* renamed from: b */
    static Object[] m34671b(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return f46513a;
        }
        return objArr;
    }

    public static List<Class<?>> getAllInterfaces(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        m34667a(cls, (HashSet<Class<?>>) linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    /* renamed from: a */
    private static void m34667a(Class<?> cls, HashSet<Class<?>> hashSet) {
        Class<? super Object> cls2;
        while (cls2 != null) {
            for (Class cls3 : cls2.getInterfaces()) {
                if (hashSet.add(cls3)) {
                    m34667a((Class<?>) cls3, hashSet);
                }
            }
            Class<? super Object> superclass = cls2.getSuperclass();
            cls2 = cls;
            cls2 = superclass;
        }
    }
}
