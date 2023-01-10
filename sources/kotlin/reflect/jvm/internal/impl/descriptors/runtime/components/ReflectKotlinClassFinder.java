package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.io.InputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsResourceLoader;

/* compiled from: ReflectKotlinClassFinder.kt */
public final class ReflectKotlinClassFinder implements KotlinClassFinder {

    /* renamed from: a */
    private final ClassLoader f5031a;

    /* renamed from: b */
    private final BuiltInsResourceLoader f5032b = new BuiltInsResourceLoader();

    public ReflectKotlinClassFinder(ClassLoader classLoader) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        this.f5031a = classLoader;
    }

    /* renamed from: a */
    private final KotlinClassFinder.Result m4738a(String str) {
        ReflectKotlinClass create;
        Class<?> tryLoadClass = ReflectJavaClassFinderKt.tryLoadClass(this.f5031a, str);
        KotlinClassFinder.Result.KotlinClass kotlinClass = null;
        if (!(tryLoadClass == null || (create = ReflectKotlinClass.Factory.create(tryLoadClass)) == null)) {
            kotlinClass = new KotlinClassFinder.Result.KotlinClass(create, (byte[]) null, 2, (DefaultConstructorMarker) null);
        }
        return kotlinClass;
    }

    public KotlinClassFinder.Result findKotlinClassOrContent(ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        return m4738a(ReflectKotlinClassFinderKt.m4739a(classId));
    }

    public KotlinClassFinder.Result findKotlinClassOrContent(JavaClass javaClass) {
        Intrinsics.checkNotNullParameter(javaClass, "javaClass");
        FqName fqName = javaClass.getFqName();
        String asString = fqName == null ? null : fqName.asString();
        if (asString == null) {
            return null;
        }
        return m4738a(asString);
    }

    public InputStream findBuiltInsData(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "packageFqName");
        if (!fqName.startsWith(StandardNames.BUILT_INS_PACKAGE_NAME)) {
            return null;
        }
        return this.f5032b.loadResource(BuiltInSerializerProtocol.INSTANCE.getBuiltInsFilePath(fqName));
    }
}
