package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;

/* compiled from: JavaClassDataFinder.kt */
public final class JavaClassDataFinder implements ClassDataFinder {

    /* renamed from: a */
    private final KotlinClassFinder f5347a;

    /* renamed from: b */
    private final DeserializedDescriptorResolver f5348b;

    public JavaClassDataFinder(KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver) {
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        Intrinsics.checkNotNullParameter(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        this.f5347a = kotlinClassFinder;
        this.f5348b = deserializedDescriptorResolver;
    }

    public ClassData findClassData(ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        KotlinJvmBinaryClass findKotlinClass = KotlinClassFinderKt.findKotlinClass(this.f5347a, classId);
        if (findKotlinClass == null) {
            return null;
        }
        boolean areEqual = Intrinsics.areEqual((Object) findKotlinClass.getClassId(), (Object) classId);
        if (!_Assertions.ENABLED || areEqual) {
            return this.f5348b.readClassData$descriptors_jvm(findKotlinClass);
        }
        throw new AssertionError("Class with incorrect id found: expected " + classId + ", actual " + findKotlinClass.getClassId());
    }
}
