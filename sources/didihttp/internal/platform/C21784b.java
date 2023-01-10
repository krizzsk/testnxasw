package didihttp.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: didihttp.internal.platform.b */
/* compiled from: OptionalMethod */
class C21784b<T> {

    /* renamed from: a */
    private final Class<?> f59656a;

    /* renamed from: b */
    private final String f59657b;

    /* renamed from: c */
    private final Class[] f59658c;

    public C21784b(Class<?> cls, String str, Class... clsArr) {
        this.f59656a = cls;
        this.f59657b = str;
        this.f59658c = clsArr;
    }

    /* renamed from: a */
    public boolean mo180141a(T t) {
        return m44950a(t.getClass()) != null;
    }

    /* renamed from: a */
    public Object mo180140a(T t, Object... objArr) throws InvocationTargetException {
        Method a = m44950a(t.getClass());
        if (a == null) {
            return null;
        }
        try {
            return a.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public Object mo180142b(T t, Object... objArr) {
        try {
            return mo180140a(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: c */
    public Object mo180143c(T t, Object... objArr) throws InvocationTargetException {
        Method a = m44950a(t.getClass());
        if (a != null) {
            try {
                return a.invoke(t, objArr);
            } catch (IllegalAccessException e) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a);
                assertionError.initCause(e);
                throw assertionError;
            }
        } else {
            throw new AssertionError("Method " + this.f59657b + " not supported for object " + t);
        }
    }

    /* renamed from: d */
    public Object mo180144d(T t, Object... objArr) {
        try {
            return mo180143c(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: a */
    private Method m44950a(Class<?> cls) {
        Class<?> cls2;
        String str = this.f59657b;
        if (str == null) {
            return null;
        }
        Method a = m44951a(cls, str, this.f59658c);
        if (a == null || (cls2 = this.f59656a) == null || cls2.isAssignableFrom(a.getReturnType())) {
            return a;
        }
        return null;
    }

    /* renamed from: a */
    private static Method m44951a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }
}
