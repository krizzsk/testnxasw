package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1 */
/* compiled from: findClassInModule.kt */
/* synthetic */ class C2464x24bfe126 extends FunctionReference implements Function1<ClassId, ClassId> {
    public static final C2464x24bfe126 INSTANCE = new C2464x24bfe126();

    C2464x24bfe126() {
        super(1);
    }

    public final String getName() {
        return "getOuterClassId";
    }

    public final String getSignature() {
        return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
    }

    public final KDeclarationContainer getOwner() {
        return C2404Reflection.getOrCreateKotlinClass(ClassId.class);
    }

    public final ClassId invoke(ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "p0");
        return classId.getOuterClassId();
    }
}
