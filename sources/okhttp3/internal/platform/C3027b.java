package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: okhttp3.internal.platform.b */
/* compiled from: OptionalMethod */
class C3027b<T> {

    /* renamed from: a */
    private final Class<?> f7372a;

    /* renamed from: b */
    private final String f7373b;

    /* renamed from: c */
    private final Class[] f7374c;

    C3027b(Class<?> cls, String str, Class... clsArr) {
        this.f7372a = cls;
        this.f7373b = str;
        this.f7374c = clsArr;
    }

    /* renamed from: a */
    public boolean mo30642a(T t) {
        return m6944a(t.getClass()) != null;
    }

    /* renamed from: a */
    public Object mo30641a(T t, Object... objArr) throws InvocationTargetException {
        Method a = m6944a(t.getClass());
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
    public Object mo30643b(T t, Object... objArr) {
        try {
            return mo30641a(t, objArr);
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
    public Object mo30644c(T t, Object... objArr) throws InvocationTargetException {
        Method a = m6944a(t.getClass());
        if (a != null) {
            try {
                return a.invoke(t, objArr);
            } catch (IllegalAccessException e) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a);
                assertionError.initCause(e);
                throw assertionError;
            }
        } else {
            throw new AssertionError("Method " + this.f7373b + " not supported for object " + t);
        }
    }

    /* renamed from: d */
    public Object mo30645d(T t, Object... objArr) {
        try {
            return mo30644c(t, objArr);
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
    private Method m6944a(Class<?> cls) {
        Class<?> cls2;
        String str = this.f7373b;
        if (str == null) {
            return null;
        }
        Method a = m6945a(cls, str, this.f7374c);
        if (a == null || (cls2 = this.f7372a) == null || cls2.isAssignableFrom(a.getReturnType())) {
            return a;
        }
        return null;
    }

    /* renamed from: a */
    private static Method m6945a(Class<?> cls, String str, Class[] clsArr) {
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
