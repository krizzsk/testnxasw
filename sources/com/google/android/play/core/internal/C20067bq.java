package com.google.android.play.core.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;

/* renamed from: com.google.android.play.core.internal.bq */
public final class C20067bq<T> {

    /* renamed from: a */
    private final Object f56096a;

    /* renamed from: b */
    private final Field f56097b;

    /* renamed from: c */
    private final Class<T> f56098c;

    C20067bq(Object obj, Field field, Class<T> cls) {
        this.f56096a = obj;
        this.f56097b = field;
        this.f56098c = cls;
    }

    C20067bq(Object obj, Field field, Class cls, byte[] bArr) {
        this(obj, field, Array.newInstance(cls, 0).getClass());
    }

    /* renamed from: c */
    private Class m42213c() {
        return mo164296b().getType().getComponentType();
    }

    /* renamed from: a */
    public final T mo164293a() {
        try {
            return this.f56098c.cast(this.f56097b.get(this.f56096a));
        } catch (Exception e) {
            throw new C20069bs(String.format("Failed to get value of field %s of type %s on object of type %s", new Object[]{this.f56097b.getName(), this.f56096a.getClass().getName(), this.f56098c.getName()}), e);
        }
    }

    /* renamed from: a */
    public final void mo164294a(T t) {
        try {
            this.f56097b.set(this.f56096a, t);
        } catch (Exception e) {
            throw new C20069bs(String.format("Failed to set value of field %s of type %s on object of type %s", new Object[]{this.f56097b.getName(), this.f56096a.getClass().getName(), this.f56098c.getName()}), e);
        }
    }

    /* renamed from: a */
    public void mo164295a(Collection collection) {
        Object[] objArr = (Object[]) mo164293a();
        int length = objArr == null ? 0 : objArr.length;
        Object[] objArr2 = (Object[]) Array.newInstance(m42213c(), collection.size() + length);
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        }
        for (Object obj : collection) {
            objArr2[length] = obj;
            length++;
        }
        mo164294a(objArr2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final Field mo164296b() {
        return this.f56097b;
    }

    /* renamed from: b */
    public void mo164297b(Collection collection) {
        Object[] objArr = (Object[]) mo164293a();
        int i = 0;
        Object[] objArr2 = (Object[]) Array.newInstance(m42213c(), (objArr == null ? 0 : objArr.length) + collection.size());
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, collection.size(), objArr.length);
        }
        for (Object obj : collection) {
            objArr2[i] = obj;
            i++;
        }
        mo164294a(objArr2);
    }
}
