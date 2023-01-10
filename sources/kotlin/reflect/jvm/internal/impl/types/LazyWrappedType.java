package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: SpecialTypes.kt */
public final class LazyWrappedType extends WrappedType {

    /* renamed from: a */
    private final StorageManager f5829a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Function0<KotlinType> f5830b;

    /* renamed from: c */
    private final NotNullLazyValue<KotlinType> f5831c;

    public LazyWrappedType(StorageManager storageManager, Function0<? extends KotlinType> function0) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(function0, "computation");
        this.f5829a = storageManager;
        this.f5830b = function0;
        this.f5831c = storageManager.createLazyValue(function0);
    }

    /* access modifiers changed from: protected */
    public KotlinType getDelegate() {
        return (KotlinType) this.f5831c.invoke();
    }

    public boolean isComputed() {
        return this.f5831c.isComputed();
    }

    public LazyWrappedType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new LazyWrappedType(this.f5829a, new LazyWrappedType$refine$1(kotlinTypeRefiner, this));
    }
}
