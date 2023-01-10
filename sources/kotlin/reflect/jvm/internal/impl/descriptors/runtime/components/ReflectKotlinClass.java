package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt;
import org.apache.commons.p074io.IOUtils;

/* compiled from: ReflectKotlinClass.kt */
public final class ReflectKotlinClass implements KotlinJvmBinaryClass {
    public static final Factory Factory = new Factory((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final Class<?> f5029a;

    /* renamed from: b */
    private final KotlinClassHeader f5030b;

    public /* synthetic */ ReflectKotlinClass(Class cls, KotlinClassHeader kotlinClassHeader, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, kotlinClassHeader);
    }

    private ReflectKotlinClass(Class<?> cls, KotlinClassHeader kotlinClassHeader) {
        this.f5029a = cls;
        this.f5030b = kotlinClassHeader;
    }

    public final Class<?> getKlass() {
        return this.f5029a;
    }

    public KotlinClassHeader getClassHeader() {
        return this.f5030b;
    }

    /* compiled from: ReflectKotlinClass.kt */
    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Factory() {
        }

        public final ReflectKotlinClass create(Class<?> cls) {
            Intrinsics.checkNotNullParameter(cls, "klass");
            ReadKotlinClassHeaderAnnotationVisitor readKotlinClassHeaderAnnotationVisitor = new ReadKotlinClassHeaderAnnotationVisitor();
            C2489a.f5036a.mo24766a(cls, (KotlinJvmBinaryClass.AnnotationVisitor) readKotlinClassHeaderAnnotationVisitor);
            KotlinClassHeader createHeader = readKotlinClassHeaderAnnotationVisitor.createHeader();
            if (createHeader == null) {
                return null;
            }
            return new ReflectKotlinClass(cls, createHeader, (DefaultConstructorMarker) null);
        }
    }

    public String getLocation() {
        String name = this.f5029a.getName();
        Intrinsics.checkNotNullExpressionValue(name, "klass.name");
        return Intrinsics.stringPlus(StringsKt.replace$default(name, '.', (char) IOUtils.DIR_SEPARATOR_UNIX, false, 4, (Object) null), ".class");
    }

    public ClassId getClassId() {
        return ReflectClassUtilKt.getClassId(this.f5029a);
    }

    public void loadClassAnnotations(KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor, byte[] bArr) {
        Intrinsics.checkNotNullParameter(annotationVisitor, "visitor");
        C2489a.f5036a.mo24766a(this.f5029a, annotationVisitor);
    }

    public void visitMembers(KotlinJvmBinaryClass.MemberVisitor memberVisitor, byte[] bArr) {
        Intrinsics.checkNotNullParameter(memberVisitor, "visitor");
        C2489a.f5036a.mo24767a(this.f5029a, memberVisitor);
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectKotlinClass) && Intrinsics.areEqual((Object) this.f5029a, (Object) ((ReflectKotlinClass) obj).f5029a);
    }

    public int hashCode() {
        return this.f5029a.hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + this.f5029a;
    }
}
