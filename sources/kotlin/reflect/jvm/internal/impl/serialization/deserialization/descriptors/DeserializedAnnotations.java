package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: DeserializedAnnotations.kt */
public class DeserializedAnnotations implements Annotations {

    /* renamed from: a */
    static final /* synthetic */ KProperty<Object>[] f5725a = {C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(DeserializedAnnotations.class), "annotations", "getAnnotations()Ljava/util/List;"))};

    /* renamed from: b */
    private final NotNullLazyValue f5726b;

    public DeserializedAnnotations(StorageManager storageManager, Function0<? extends List<? extends AnnotationDescriptor>> function0) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(function0, "compute");
        this.f5726b = storageManager.createLazyValue(function0);
    }

    public AnnotationDescriptor findAnnotation(FqName fqName) {
        return Annotations.DefaultImpls.findAnnotation(this, fqName);
    }

    public boolean hasAnnotation(FqName fqName) {
        return Annotations.DefaultImpls.hasAnnotation(this, fqName);
    }

    /* renamed from: a */
    private final List<AnnotationDescriptor> m5180a() {
        return (List) StorageKt.getValue(this.f5726b, (Object) this, (KProperty<?>) f5725a[0]);
    }

    public boolean isEmpty() {
        return m5180a().isEmpty();
    }

    public Iterator<AnnotationDescriptor> iterator() {
        return m5180a().iterator();
    }
}
