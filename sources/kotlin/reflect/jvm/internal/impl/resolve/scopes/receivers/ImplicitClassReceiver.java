package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: ImplicitClassReceiver.kt */
public class ImplicitClassReceiver implements ImplicitReceiver, ThisClassReceiver {

    /* renamed from: a */
    private final ClassDescriptor f5635a;

    /* renamed from: b */
    private final ImplicitClassReceiver f5636b;

    /* renamed from: c */
    private final ClassDescriptor f5637c;

    public ImplicitClassReceiver(ClassDescriptor classDescriptor, ImplicitClassReceiver implicitClassReceiver) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        this.f5635a = classDescriptor;
        this.f5636b = implicitClassReceiver == null ? this : implicitClassReceiver;
        this.f5637c = this.f5635a;
    }

    public final ClassDescriptor getClassDescriptor() {
        return this.f5635a;
    }

    public SimpleType getType() {
        SimpleType defaultType = this.f5635a.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "classDescriptor.defaultType");
        return defaultType;
    }

    public boolean equals(Object obj) {
        ClassDescriptor classDescriptor = this.f5635a;
        ClassDescriptor classDescriptor2 = null;
        ImplicitClassReceiver implicitClassReceiver = obj instanceof ImplicitClassReceiver ? (ImplicitClassReceiver) obj : null;
        if (implicitClassReceiver != null) {
            classDescriptor2 = implicitClassReceiver.f5635a;
        }
        return Intrinsics.areEqual((Object) classDescriptor, (Object) classDescriptor2);
    }

    public int hashCode() {
        return this.f5635a.hashCode();
    }

    public String toString() {
        return "Class{" + getType() + '}';
    }
}
