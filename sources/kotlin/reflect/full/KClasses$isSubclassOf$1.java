package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty1;

@Metadata(mo148869k = 3, mo148870mv = {1, 5, 1})
/* compiled from: KClasses.kt */
final /* synthetic */ class KClasses$isSubclassOf$1 extends PropertyReference1 {
    public static final KProperty1 INSTANCE = new KClasses$isSubclassOf$1();

    KClasses$isSubclassOf$1() {
    }

    public String getName() {
        return "superclasses";
    }

    public KDeclarationContainer getOwner() {
        return C2404Reflection.getOrCreateKotlinPackage(KClasses.class, "kotlin-reflection");
    }

    public String getSignature() {
        return "getSuperclasses(Lkotlin/reflect/KClass;)Ljava/util/List;";
    }

    public Object get(Object obj) {
        return KClasses.getSuperclasses((KClass) obj);
    }
}
