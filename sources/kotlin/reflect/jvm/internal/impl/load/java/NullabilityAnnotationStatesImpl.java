package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;

/* compiled from: JavaNullabilityAnnotationSettings.kt */
public final class NullabilityAnnotationStatesImpl<T> implements NullabilityAnnotationStates<T> {

    /* renamed from: a */
    private final Map<FqName, T> f5127a;

    /* renamed from: b */
    private final LockBasedStorageManager f5128b;

    /* renamed from: c */
    private final MemoizedFunctionToNullable<FqName, T> f5129c;

    public NullabilityAnnotationStatesImpl(Map<FqName, ? extends T> map) {
        Intrinsics.checkNotNullParameter(map, "states");
        this.f5127a = map;
        LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("Java nullability annotation states");
        this.f5128b = lockBasedStorageManager;
        MemoizedFunctionToNullable<FqName, T> createMemoizedFunctionWithNullableValues = lockBasedStorageManager.createMemoizedFunctionWithNullableValues(new NullabilityAnnotationStatesImpl$cache$1(this));
        Intrinsics.checkNotNullExpressionValue(createMemoizedFunctionWithNullableValues, "storageManager.createMem…cificFqname(states)\n    }");
        this.f5129c = createMemoizedFunctionWithNullableValues;
    }

    public final Map<FqName, T> getStates() {
        return this.f5127a;
    }

    public T get(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return this.f5129c.invoke(fqName);
    }
}
