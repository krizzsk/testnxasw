package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* compiled from: UnsignedType.kt */
public final class UnsignedTypes {
    public static final UnsignedTypes INSTANCE = new UnsignedTypes();

    /* renamed from: a */
    private static final Set<Name> f4817a;

    /* renamed from: b */
    private static final Set<Name> f4818b;

    /* renamed from: c */
    private static final HashMap<ClassId, ClassId> f4819c = new HashMap<>();

    /* renamed from: d */
    private static final HashMap<ClassId, ClassId> f4820d = new HashMap<>();

    /* renamed from: e */
    private static final HashMap<UnsignedArrayType, Name> f4821e = MapsKt.hashMapOf(TuplesKt.m41339to(UnsignedArrayType.UBYTEARRAY, Name.identifier("ubyteArrayOf")), TuplesKt.m41339to(UnsignedArrayType.USHORTARRAY, Name.identifier("ushortArrayOf")), TuplesKt.m41339to(UnsignedArrayType.UINTARRAY, Name.identifier("uintArrayOf")), TuplesKt.m41339to(UnsignedArrayType.ULONGARRAY, Name.identifier("ulongArrayOf")));

    /* renamed from: f */
    private static final Set<Name> f4822f;

    private UnsignedTypes() {
    }

    static {
        UnsignedType[] values = UnsignedType.values();
        Collection arrayList = new ArrayList(values.length);
        int i = 0;
        for (UnsignedType typeName : values) {
            arrayList.add(typeName.getTypeName());
        }
        f4817a = CollectionsKt.toSet((List) arrayList);
        UnsignedArrayType[] values2 = UnsignedArrayType.values();
        Collection arrayList2 = new ArrayList(values2.length);
        for (UnsignedArrayType typeName2 : values2) {
            arrayList2.add(typeName2.getTypeName());
        }
        f4818b = CollectionsKt.toSet((List) arrayList2);
        UnsignedType[] values3 = UnsignedType.values();
        Collection linkedHashSet = new LinkedHashSet();
        for (UnsignedType arrayClassId : values3) {
            linkedHashSet.add(arrayClassId.getArrayClassId().getShortClassName());
        }
        f4822f = (Set) linkedHashSet;
        UnsignedType[] values4 = UnsignedType.values();
        int length = values4.length;
        while (i < length) {
            UnsignedType unsignedType = values4[i];
            i++;
            f4819c.put(unsignedType.getArrayClassId(), unsignedType.getClassId());
            f4820d.put(unsignedType.getClassId(), unsignedType.getArrayClassId());
        }
    }

    public final boolean isShortNameOfUnsignedArray(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return f4822f.contains(name);
    }

    public final ClassId getUnsignedClassIdByArrayClassId(ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "arrayClassId");
        return f4819c.get(classId);
    }

    @JvmStatic
    public static final boolean isUnsignedType(KotlinType kotlinType) {
        ClassifierDescriptor declarationDescriptor;
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        if (!TypeUtils.noExpectedType(kotlinType) && (declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor()) != null) {
            return INSTANCE.isUnsignedClass(declarationDescriptor);
        }
        return false;
    }

    public final boolean isUnsignedClass(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "descriptor");
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        return (containingDeclaration instanceof PackageFragmentDescriptor) && Intrinsics.areEqual((Object) ((PackageFragmentDescriptor) containingDeclaration).getFqName(), (Object) StandardNames.BUILT_INS_PACKAGE_FQ_NAME) && f4817a.contains(declarationDescriptor.getName());
    }
}
