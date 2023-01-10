package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import org.osgi.framework.VersionRange;

/* compiled from: ClassData.kt */
public final class ClassData {

    /* renamed from: a */
    private final NameResolver f5659a;

    /* renamed from: b */
    private final ProtoBuf.Class f5660b;

    /* renamed from: c */
    private final BinaryVersion f5661c;

    /* renamed from: d */
    private final SourceElement f5662d;

    public final NameResolver component1() {
        return this.f5659a;
    }

    public final ProtoBuf.Class component2() {
        return this.f5660b;
    }

    public final BinaryVersion component3() {
        return this.f5661c;
    }

    public final SourceElement component4() {
        return this.f5662d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassData)) {
            return false;
        }
        ClassData classData = (ClassData) obj;
        return Intrinsics.areEqual((Object) this.f5659a, (Object) classData.f5659a) && Intrinsics.areEqual((Object) this.f5660b, (Object) classData.f5660b) && Intrinsics.areEqual((Object) this.f5661c, (Object) classData.f5661c) && Intrinsics.areEqual((Object) this.f5662d, (Object) classData.f5662d);
    }

    public int hashCode() {
        return (((((this.f5659a.hashCode() * 31) + this.f5660b.hashCode()) * 31) + this.f5661c.hashCode()) * 31) + this.f5662d.hashCode();
    }

    public String toString() {
        return "ClassData(nameResolver=" + this.f5659a + ", classProto=" + this.f5660b + ", metadataVersion=" + this.f5661c + ", sourceElement=" + this.f5662d + VersionRange.RIGHT_OPEN;
    }

    public ClassData(NameResolver nameResolver, ProtoBuf.Class classR, BinaryVersion binaryVersion, SourceElement sourceElement) {
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(classR, "classProto");
        Intrinsics.checkNotNullParameter(binaryVersion, "metadataVersion");
        Intrinsics.checkNotNullParameter(sourceElement, "sourceElement");
        this.f5659a = nameResolver;
        this.f5660b = classR;
        this.f5661c = binaryVersion;
        this.f5662d = sourceElement;
    }
}
