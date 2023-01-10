package com.jumio.core.persistence;

import com.jumio.commons.PersistWith;
import com.jumio.commons.log.Log;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003J%\u0010\u0007\u001a\u00028\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u000f\u001a\u00020\n2\u001a\u0010\u000e\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\r\"\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\n¨\u0006\u0014"}, mo148868d2 = {"Lcom/jumio/core/persistence/DataManager;", "Ljava/io/Serializable;", "T", "Ljava/lang/Class;", "clazz", "", "has", "get", "(Ljava/lang/Class;)Ljava/io/Serializable;", "model", "", "put", "(Ljava/lang/Class;Ljava/io/Serializable;)V", "", "clazzes", "remove", "([Ljava/lang/Class;)V", "removeAll", "<init>", "()V", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: DataManager.kt */
public final class DataManager implements Serializable {

    /* renamed from: a */
    public final String f57781a = "DataAccess";

    /* renamed from: b */
    public final ConcurrentHashMap<String, Serializable> f57782b = new ConcurrentHashMap<>();

    /* renamed from: a */
    public final String mo172431a(Class<?> cls) throws RuntimeException {
        PersistWith persistWith = (PersistWith) cls.getAnnotation(PersistWith.class);
        if (persistWith != null) {
            return persistWith.value();
        }
        throw new RuntimeException("Class " + cls.getName() + " must be annotated with PersistWith!");
    }

    public final synchronized <T extends Serializable> T get(Class<T> cls) {
        T t;
        Intrinsics.checkNotNullParameter(cls, "clazz");
        try {
            t = (Serializable) this.f57782b.get(mo172431a(cls));
            if (t == null) {
                t = (Serializable) cls.newInstance();
                this.f57782b.put(mo172431a(cls), t);
                Intrinsics.checkNotNullExpressionValue(t, "{\n\t\t\t\tval newModel = cla…wModel)\n\t\t\t\tnewModel\n\t\t\t}");
            }
        } catch (Exception e) {
            String str = this.f57781a;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.ENGLISH, "Error loading %s", Arrays.copyOf(new Object[]{cls.getName()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            Log.m43666w(str, format, (Throwable) e);
            T t2 = (Serializable) cls.newInstance();
            this.f57782b.put(mo172431a(cls), t2);
            Intrinsics.checkNotNullExpressionValue(t2, "{\n\t\t\tLog.w(TAG, String.f…newModel)\n\t\t\tnewModel\n\t\t}");
            return t2;
        }
        return t;
    }

    public final synchronized <T extends Serializable> boolean has(Class<T> cls) {
        boolean z;
        Intrinsics.checkNotNullParameter(cls, "clazz");
        z = false;
        try {
            z = this.f57782b.containsKey(mo172431a(cls));
        } catch (Exception e) {
            String str = this.f57781a;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.ENGLISH, "Error looking for %s", Arrays.copyOf(new Object[]{cls.getName()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            Log.m43666w(str, format, (Throwable) e);
        }
        return z;
    }

    public final synchronized <T extends Serializable> void put(Class<T> cls, T t) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(t, "model");
        try {
            this.f57782b.put(mo172431a(cls), t);
        } catch (RuntimeException e) {
            String str = this.f57781a;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.ENGLISH, "Error persisting %s", Arrays.copyOf(new Object[]{cls.getName()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            Log.m43666w(str, format, (Throwable) e);
        }
        return;
    }

    public final synchronized void remove(Class<?>... clsArr) {
        Intrinsics.checkNotNullParameter(clsArr, "clazzes");
        for (Class<?> a : clsArr) {
            this.f57782b.remove(mo172431a(a));
        }
    }

    public final synchronized void removeAll() {
        this.f57782b.clear();
    }
}
