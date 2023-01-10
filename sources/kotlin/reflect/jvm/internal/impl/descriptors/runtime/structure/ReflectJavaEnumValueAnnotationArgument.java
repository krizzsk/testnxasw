package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaAnnotationArguments.kt */
public final class ReflectJavaEnumValueAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaEnumValueAnnotationArgument {

    /* renamed from: a */
    private final Enum<?> f5057a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReflectJavaEnumValueAnnotationArgument(Name name, Enum<?> enumR) {
        super(name, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(enumR, "value");
        this.f5057a = enumR;
    }

    public ClassId getEnumClassId() {
        Class<?> cls = this.f5057a.getClass();
        if (!cls.isEnum()) {
            cls = cls.getEnclosingClass();
        }
        Intrinsics.checkNotNullExpressionValue(cls, "enumClass");
        return ReflectClassUtilKt.getClassId(cls);
    }

    public Name getEntryName() {
        return Name.identifier(this.f5057a.name());
    }
}
