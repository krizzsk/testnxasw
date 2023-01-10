package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt;
import org.osgi.framework.VersionRange;

/* compiled from: JavaToKotlinClassMap.kt */
public final class JavaToKotlinClassMap {
    public static final JavaToKotlinClassMap INSTANCE = new JavaToKotlinClassMap();

    /* renamed from: a */
    private static final String f4837a = (FunctionClassKind.Function.getPackageFqName().toString() + '.' + FunctionClassKind.Function.getClassNamePrefix());

    /* renamed from: b */
    private static final String f4838b = (FunctionClassKind.KFunction.getPackageFqName().toString() + '.' + FunctionClassKind.KFunction.getClassNamePrefix());

    /* renamed from: c */
    private static final String f4839c = (FunctionClassKind.SuspendFunction.getPackageFqName().toString() + '.' + FunctionClassKind.SuspendFunction.getClassNamePrefix());

    /* renamed from: d */
    private static final String f4840d = (FunctionClassKind.KSuspendFunction.getPackageFqName().toString() + '.' + FunctionClassKind.KSuspendFunction.getClassNamePrefix());

    /* renamed from: e */
    private static final ClassId f4841e;

    /* renamed from: f */
    private static final FqName f4842f;

    /* renamed from: g */
    private static final ClassId f4843g;

    /* renamed from: h */
    private static final ClassId f4844h;

    /* renamed from: i */
    private static final ClassId f4845i = INSTANCE.m4678a((Class<?>) Class.class);

    /* renamed from: j */
    private static final HashMap<FqNameUnsafe, ClassId> f4846j = new HashMap<>();

    /* renamed from: k */
    private static final HashMap<FqNameUnsafe, ClassId> f4847k = new HashMap<>();

    /* renamed from: l */
    private static final HashMap<FqNameUnsafe, FqName> f4848l = new HashMap<>();

    /* renamed from: m */
    private static final HashMap<FqNameUnsafe, FqName> f4849m = new HashMap<>();

    /* renamed from: n */
    private static final List<PlatformMutabilityMapping> f4850n;

    private JavaToKotlinClassMap() {
    }

    static {
        ClassId classId = ClassId.topLevel(new FqName("kotlin.jvm.functions.FunctionN"));
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(FqName(\"kotlin.jvm.functions.FunctionN\"))");
        f4841e = classId;
        FqName asSingleFqName = classId.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(asSingleFqName, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        f4842f = asSingleFqName;
        ClassId classId2 = ClassId.topLevel(new FqName("kotlin.reflect.KFunction"));
        Intrinsics.checkNotNullExpressionValue(classId2, "topLevel(FqName(\"kotlin.reflect.KFunction\"))");
        f4843g = classId2;
        ClassId classId3 = ClassId.topLevel(new FqName("kotlin.reflect.KClass"));
        Intrinsics.checkNotNullExpressionValue(classId3, "topLevel(FqName(\"kotlin.reflect.KClass\"))");
        f4844h = classId3;
        JavaToKotlinClassMap javaToKotlinClassMap = INSTANCE;
        ClassId classId4 = ClassId.topLevel(StandardNames.FqNames.iterable);
        Intrinsics.checkNotNullExpressionValue(classId4, "topLevel(FqNames.iterable)");
        FqName fqName = StandardNames.FqNames.mutableIterable;
        FqName packageFqName = classId4.getPackageFqName();
        FqName packageFqName2 = classId4.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName2, "kotlinReadOnly.packageFqName");
        FqName tail = FqNamesUtilKt.tail(fqName, packageFqName2);
        int i = 0;
        ClassId classId5 = new ClassId(packageFqName, tail, false);
        JavaToKotlinClassMap javaToKotlinClassMap2 = INSTANCE;
        ClassId classId6 = ClassId.topLevel(StandardNames.FqNames.iterator);
        Intrinsics.checkNotNullExpressionValue(classId6, "topLevel(FqNames.iterator)");
        FqName fqName2 = StandardNames.FqNames.mutableIterator;
        FqName packageFqName3 = classId6.getPackageFqName();
        FqName packageFqName4 = classId6.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName4, "kotlinReadOnly.packageFqName");
        ClassId classId7 = new ClassId(packageFqName3, FqNamesUtilKt.tail(fqName2, packageFqName4), false);
        JavaToKotlinClassMap javaToKotlinClassMap3 = INSTANCE;
        ClassId classId8 = ClassId.topLevel(StandardNames.FqNames.collection);
        Intrinsics.checkNotNullExpressionValue(classId8, "topLevel(FqNames.collection)");
        FqName fqName3 = StandardNames.FqNames.mutableCollection;
        FqName packageFqName5 = classId8.getPackageFqName();
        FqName packageFqName6 = classId8.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName6, "kotlinReadOnly.packageFqName");
        ClassId classId9 = new ClassId(packageFqName5, FqNamesUtilKt.tail(fqName3, packageFqName6), false);
        JavaToKotlinClassMap javaToKotlinClassMap4 = INSTANCE;
        ClassId classId10 = ClassId.topLevel(StandardNames.FqNames.list);
        Intrinsics.checkNotNullExpressionValue(classId10, "topLevel(FqNames.list)");
        FqName fqName4 = StandardNames.FqNames.mutableList;
        FqName packageFqName7 = classId10.getPackageFqName();
        FqName packageFqName8 = classId10.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName8, "kotlinReadOnly.packageFqName");
        ClassId classId11 = new ClassId(packageFqName7, FqNamesUtilKt.tail(fqName4, packageFqName8), false);
        JavaToKotlinClassMap javaToKotlinClassMap5 = INSTANCE;
        ClassId classId12 = ClassId.topLevel(StandardNames.FqNames.set);
        Intrinsics.checkNotNullExpressionValue(classId12, "topLevel(FqNames.set)");
        FqName fqName5 = StandardNames.FqNames.mutableSet;
        FqName packageFqName9 = classId12.getPackageFqName();
        FqName packageFqName10 = classId12.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName10, "kotlinReadOnly.packageFqName");
        ClassId classId13 = new ClassId(packageFqName9, FqNamesUtilKt.tail(fqName5, packageFqName10), false);
        JavaToKotlinClassMap javaToKotlinClassMap6 = INSTANCE;
        ClassId classId14 = ClassId.topLevel(StandardNames.FqNames.listIterator);
        Intrinsics.checkNotNullExpressionValue(classId14, "topLevel(FqNames.listIterator)");
        FqName fqName6 = StandardNames.FqNames.mutableListIterator;
        FqName packageFqName11 = classId14.getPackageFqName();
        FqName packageFqName12 = classId14.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName12, "kotlinReadOnly.packageFqName");
        ClassId classId15 = new ClassId(packageFqName11, FqNamesUtilKt.tail(fqName6, packageFqName12), false);
        JavaToKotlinClassMap javaToKotlinClassMap7 = INSTANCE;
        ClassId classId16 = ClassId.topLevel(StandardNames.FqNames.map);
        Intrinsics.checkNotNullExpressionValue(classId16, "topLevel(FqNames.map)");
        FqName fqName7 = StandardNames.FqNames.mutableMap;
        FqName packageFqName13 = classId16.getPackageFqName();
        FqName packageFqName14 = classId16.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName14, "kotlinReadOnly.packageFqName");
        ClassId classId17 = new ClassId(packageFqName13, FqNamesUtilKt.tail(fqName7, packageFqName14), false);
        JavaToKotlinClassMap javaToKotlinClassMap8 = INSTANCE;
        ClassId createNestedClassId = ClassId.topLevel(StandardNames.FqNames.map).createNestedClassId(StandardNames.FqNames.mapEntry.shortName());
        Intrinsics.checkNotNullExpressionValue(createNestedClassId, "topLevel(FqNames.map).cr…mes.mapEntry.shortName())");
        FqName fqName8 = StandardNames.FqNames.mutableMapEntry;
        FqName packageFqName15 = createNestedClassId.getPackageFqName();
        FqName packageFqName16 = createNestedClassId.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName16, "kotlinReadOnly.packageFqName");
        f4850n = CollectionsKt.listOf(new PlatformMutabilityMapping(javaToKotlinClassMap.m4678a((Class<?>) Iterable.class), classId4, classId5), new PlatformMutabilityMapping(javaToKotlinClassMap2.m4678a((Class<?>) Iterator.class), classId6, classId7), new PlatformMutabilityMapping(javaToKotlinClassMap3.m4678a((Class<?>) Collection.class), classId8, classId9), new PlatformMutabilityMapping(javaToKotlinClassMap4.m4678a((Class<?>) List.class), classId10, classId11), new PlatformMutabilityMapping(javaToKotlinClassMap5.m4678a((Class<?>) Set.class), classId12, classId13), new PlatformMutabilityMapping(javaToKotlinClassMap6.m4678a((Class<?>) ListIterator.class), classId14, classId15), new PlatformMutabilityMapping(javaToKotlinClassMap7.m4678a((Class<?>) Map.class), classId16, classId17), new PlatformMutabilityMapping(javaToKotlinClassMap8.m4678a((Class<?>) Map.Entry.class), createNestedClassId, new ClassId(packageFqName15, FqNamesUtilKt.tail(fqName8, packageFqName16), false)));
        INSTANCE.m4680a((Class<?>) Object.class, StandardNames.FqNames.any);
        INSTANCE.m4680a((Class<?>) String.class, StandardNames.FqNames.string);
        INSTANCE.m4680a((Class<?>) CharSequence.class, StandardNames.FqNames.charSequence);
        INSTANCE.m4679a((Class<?>) Throwable.class, StandardNames.FqNames.throwable);
        INSTANCE.m4680a((Class<?>) Cloneable.class, StandardNames.FqNames.cloneable);
        INSTANCE.m4680a((Class<?>) Number.class, StandardNames.FqNames.number);
        INSTANCE.m4679a((Class<?>) Comparable.class, StandardNames.FqNames.comparable);
        INSTANCE.m4680a((Class<?>) Enum.class, StandardNames.FqNames._enum);
        INSTANCE.m4679a((Class<?>) Annotation.class, StandardNames.FqNames.annotation);
        for (PlatformMutabilityMapping a : f4850n) {
            INSTANCE.m4681a(a);
        }
        JvmPrimitiveType[] values = JvmPrimitiveType.values();
        int length = values.length;
        int i2 = 0;
        while (i2 < length) {
            JvmPrimitiveType jvmPrimitiveType = values[i2];
            i2++;
            JavaToKotlinClassMap javaToKotlinClassMap9 = INSTANCE;
            ClassId classId18 = ClassId.topLevel(jvmPrimitiveType.getWrapperFqName());
            Intrinsics.checkNotNullExpressionValue(classId18, "topLevel(jvmType.wrapperFqName)");
            PrimitiveType primitiveType = jvmPrimitiveType.getPrimitiveType();
            Intrinsics.checkNotNullExpressionValue(primitiveType, "jvmType.primitiveType");
            ClassId classId19 = ClassId.topLevel(StandardNames.getPrimitiveFqName(primitiveType));
            Intrinsics.checkNotNullExpressionValue(classId19, "topLevel(StandardNames.g…e(jvmType.primitiveType))");
            javaToKotlinClassMap9.m4682a(classId18, classId19);
        }
        for (ClassId next : CompanionObjectMapping.INSTANCE.allClassesWithIntrinsicCompanions()) {
            JavaToKotlinClassMap javaToKotlinClassMap10 = INSTANCE;
            ClassId classId20 = ClassId.topLevel(new FqName("kotlin.jvm.internal." + next.getShortClassName().asString() + "CompanionObject"));
            Intrinsics.checkNotNullExpressionValue(classId20, "topLevel(FqName(\"kotlin.…g() + \"CompanionObject\"))");
            ClassId createNestedClassId2 = next.createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT);
            Intrinsics.checkNotNullExpressionValue(createNestedClassId2, "classId.createNestedClas…AME_FOR_COMPANION_OBJECT)");
            javaToKotlinClassMap10.m4682a(classId20, createNestedClassId2);
        }
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            JavaToKotlinClassMap javaToKotlinClassMap11 = INSTANCE;
            ClassId classId21 = ClassId.topLevel(new FqName(Intrinsics.stringPlus("kotlin.jvm.functions.Function", Integer.valueOf(i3))));
            Intrinsics.checkNotNullExpressionValue(classId21, "topLevel(FqName(\"kotlin.…m.functions.Function$i\"))");
            javaToKotlinClassMap11.m4682a(classId21, StandardNames.getFunctionClassId(i3));
            INSTANCE.m4683a(new FqName(Intrinsics.stringPlus(f4838b, Integer.valueOf(i3))), f4843g);
            if (i4 >= 23) {
                break;
            }
            i3 = i4;
        }
        while (true) {
            int i5 = i + 1;
            FunctionClassKind functionClassKind = FunctionClassKind.KSuspendFunction;
            INSTANCE.m4683a(new FqName(Intrinsics.stringPlus(functionClassKind.getPackageFqName().toString() + '.' + functionClassKind.getClassNamePrefix(), Integer.valueOf(i))), f4843g);
            if (i5 >= 22) {
                JavaToKotlinClassMap javaToKotlinClassMap12 = INSTANCE;
                FqName safe = StandardNames.FqNames.nothing.toSafe();
                Intrinsics.checkNotNullExpressionValue(safe, "nothing.toSafe()");
                javaToKotlinClassMap12.m4683a(safe, INSTANCE.m4678a((Class<?>) Void.class));
                return;
            }
            i = i5;
        }
    }

    public final FqName getFUNCTION_N_FQ_NAME() {
        return f4842f;
    }

    /* compiled from: JavaToKotlinClassMap.kt */
    public static final class PlatformMutabilityMapping {
        private final ClassId javaClass;
        private final ClassId kotlinMutable;
        private final ClassId kotlinReadOnly;

        public final ClassId component1() {
            return this.javaClass;
        }

        public final ClassId component2() {
            return this.kotlinReadOnly;
        }

        public final ClassId component3() {
            return this.kotlinMutable;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlatformMutabilityMapping)) {
                return false;
            }
            PlatformMutabilityMapping platformMutabilityMapping = (PlatformMutabilityMapping) obj;
            return Intrinsics.areEqual((Object) this.javaClass, (Object) platformMutabilityMapping.javaClass) && Intrinsics.areEqual((Object) this.kotlinReadOnly, (Object) platformMutabilityMapping.kotlinReadOnly) && Intrinsics.areEqual((Object) this.kotlinMutable, (Object) platformMutabilityMapping.kotlinMutable);
        }

        public int hashCode() {
            return (((this.javaClass.hashCode() * 31) + this.kotlinReadOnly.hashCode()) * 31) + this.kotlinMutable.hashCode();
        }

        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.javaClass + ", kotlinReadOnly=" + this.kotlinReadOnly + ", kotlinMutable=" + this.kotlinMutable + VersionRange.RIGHT_OPEN;
        }

        public PlatformMutabilityMapping(ClassId classId, ClassId classId2, ClassId classId3) {
            Intrinsics.checkNotNullParameter(classId, "javaClass");
            Intrinsics.checkNotNullParameter(classId2, "kotlinReadOnly");
            Intrinsics.checkNotNullParameter(classId3, "kotlinMutable");
            this.javaClass = classId;
            this.kotlinReadOnly = classId2;
            this.kotlinMutable = classId3;
        }

        public final ClassId getJavaClass() {
            return this.javaClass;
        }
    }

    public final List<PlatformMutabilityMapping> getMutabilityMappings() {
        return f4850n;
    }

    public final ClassId mapJavaToKotlin(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return f4846j.get(fqName.toUnsafe());
    }

    public final ClassId mapKotlinToJava(FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "kotlinFqName");
        if (m4684a(fqNameUnsafe, f4837a)) {
            return f4841e;
        }
        if (m4684a(fqNameUnsafe, f4839c)) {
            return f4841e;
        }
        if (m4684a(fqNameUnsafe, f4838b)) {
            return f4843g;
        }
        if (m4684a(fqNameUnsafe, f4840d)) {
            return f4843g;
        }
        return f4847k.get(fqNameUnsafe);
    }

    /* renamed from: a */
    private final boolean m4684a(FqNameUnsafe fqNameUnsafe, String str) {
        Integer intOrNull;
        String asString = fqNameUnsafe.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "kotlinFqName.asString()");
        String substringAfter = StringsKt.substringAfter(asString, str, "");
        CharSequence charSequence = substringAfter;
        if (!(charSequence.length() > 0) || StringsKt.startsWith$default(charSequence, '0', false, 2, (Object) null) || (intOrNull = StringsKt.toIntOrNull(substringAfter)) == null || intOrNull.intValue() < 23) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private final void m4681a(PlatformMutabilityMapping platformMutabilityMapping) {
        ClassId component1 = platformMutabilityMapping.component1();
        ClassId component2 = platformMutabilityMapping.component2();
        ClassId component3 = platformMutabilityMapping.component3();
        m4682a(component1, component2);
        FqName asSingleFqName = component3.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(asSingleFqName, "mutableClassId.asSingleFqName()");
        m4683a(asSingleFqName, component1);
        FqName asSingleFqName2 = component2.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(asSingleFqName2, "readOnlyClassId.asSingleFqName()");
        FqName asSingleFqName3 = component3.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(asSingleFqName3, "mutableClassId.asSingleFqName()");
        FqNameUnsafe unsafe = component3.asSingleFqName().toUnsafe();
        Intrinsics.checkNotNullExpressionValue(unsafe, "mutableClassId.asSingleFqName().toUnsafe()");
        f4848l.put(unsafe, asSingleFqName2);
        FqNameUnsafe unsafe2 = asSingleFqName2.toUnsafe();
        Intrinsics.checkNotNullExpressionValue(unsafe2, "readOnlyFqName.toUnsafe()");
        f4849m.put(unsafe2, asSingleFqName3);
    }

    /* renamed from: a */
    private final void m4682a(ClassId classId, ClassId classId2) {
        m4685b(classId, classId2);
        FqName asSingleFqName = classId2.asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(asSingleFqName, "kotlinClassId.asSingleFqName()");
        m4683a(asSingleFqName, classId);
    }

    /* renamed from: a */
    private final void m4680a(Class<?> cls, FqNameUnsafe fqNameUnsafe) {
        FqName safe = fqNameUnsafe.toSafe();
        Intrinsics.checkNotNullExpressionValue(safe, "kotlinFqName.toSafe()");
        m4679a(cls, safe);
    }

    /* renamed from: a */
    private final void m4679a(Class<?> cls, FqName fqName) {
        ClassId a = m4678a(cls);
        ClassId classId = ClassId.topLevel(fqName);
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(kotlinFqName)");
        m4682a(a, classId);
    }

    /* renamed from: b */
    private final void m4685b(ClassId classId, ClassId classId2) {
        FqNameUnsafe unsafe = classId.asSingleFqName().toUnsafe();
        Intrinsics.checkNotNullExpressionValue(unsafe, "javaClassId.asSingleFqName().toUnsafe()");
        f4846j.put(unsafe, classId2);
    }

    /* renamed from: a */
    private final void m4683a(FqName fqName, ClassId classId) {
        FqNameUnsafe unsafe = fqName.toUnsafe();
        Intrinsics.checkNotNullExpressionValue(unsafe, "kotlinFqNameUnsafe.toUnsafe()");
        f4847k.put(unsafe, classId);
    }

    public final FqName mutableToReadOnly(FqNameUnsafe fqNameUnsafe) {
        return (FqName) f4848l.get(fqNameUnsafe);
    }

    public final FqName readOnlyToMutable(FqNameUnsafe fqNameUnsafe) {
        return (FqName) f4849m.get(fqNameUnsafe);
    }

    public final boolean isMutable(FqNameUnsafe fqNameUnsafe) {
        Map map = f4848l;
        if (map != null) {
            return map.containsKey(fqNameUnsafe);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }

    public final boolean isReadOnly(FqNameUnsafe fqNameUnsafe) {
        Map map = f4849m;
        if (map != null) {
            return map.containsKey(fqNameUnsafe);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final ClassId m4678a(Class<?> cls) {
        boolean z = !cls.isPrimitive() && !cls.isArray();
        if (!_Assertions.ENABLED || z) {
            Class<?> declaringClass = cls.getDeclaringClass();
            if (declaringClass == null) {
                ClassId classId = ClassId.topLevel(new FqName(cls.getCanonicalName()));
                Intrinsics.checkNotNullExpressionValue(classId, "topLevel(FqName(clazz.canonicalName))");
                return classId;
            }
            ClassId createNestedClassId = m4678a(declaringClass).createNestedClassId(Name.identifier(cls.getSimpleName()));
            Intrinsics.checkNotNullExpressionValue(createNestedClassId, "classId(outer).createNes…tifier(clazz.simpleName))");
            return createNestedClassId;
        }
        throw new AssertionError(Intrinsics.stringPlus("Invalid class: ", cls));
    }
}
