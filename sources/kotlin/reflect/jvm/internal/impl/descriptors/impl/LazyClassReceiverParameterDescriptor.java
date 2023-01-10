package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitClassReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

public class LazyClassReceiverParameterDescriptor extends AbstractReceiverParameterDescriptor {

    /* renamed from: a */
    private final ClassDescriptor f4937a;

    /* renamed from: b */
    private final ImplicitClassReceiver f4938b;

    /* renamed from: a */
    private static /* synthetic */ void m4714a(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 1 || i == 2) ? 2 : 3)];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i == 1) {
            objArr[1] = "getValue";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (!(i == 1 || i == 2)) {
            if (i != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String format = String.format(str, objArr);
        throw ((i == 1 || i == 2) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyClassReceiverParameterDescriptor(ClassDescriptor classDescriptor) {
        super(Annotations.Companion.getEMPTY());
        if (classDescriptor == null) {
            m4714a(0);
        }
        this.f4937a = classDescriptor;
        this.f4938b = new ImplicitClassReceiver(classDescriptor, (ImplicitClassReceiver) null);
    }

    public ReceiverValue getValue() {
        ImplicitClassReceiver implicitClassReceiver = this.f4938b;
        if (implicitClassReceiver == null) {
            m4714a(1);
        }
        return implicitClassReceiver;
    }

    public DeclarationDescriptor getContainingDeclaration() {
        ClassDescriptor classDescriptor = this.f4937a;
        if (classDescriptor == null) {
            m4714a(2);
        }
        return classDescriptor;
    }

    public String toString() {
        return "class " + this.f4937a.getName() + "::this";
    }
}
