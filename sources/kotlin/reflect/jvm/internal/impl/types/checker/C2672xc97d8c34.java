package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* renamed from: kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1 */
/* compiled from: IntersectionType.kt */
/* synthetic */ class C2672xc97d8c34 extends FunctionReference implements Function2<KotlinType, KotlinType, Boolean> {
    C2672xc97d8c34(Object obj) {
        super(2, obj);
    }

    public final String getName() {
        return "equalTypes";
    }

    public final String getSignature() {
        return "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
    }

    public final KDeclarationContainer getOwner() {
        return C2404Reflection.getOrCreateKotlinClass(NewKotlinTypeCheckerImpl.class);
    }

    public final Boolean invoke(KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics.checkNotNullParameter(kotlinType, "p0");
        Intrinsics.checkNotNullParameter(kotlinType2, "p1");
        return Boolean.valueOf(((NewKotlinTypeCheckerImpl) this.receiver).equalTypes(kotlinType, kotlinType2));
    }
}
