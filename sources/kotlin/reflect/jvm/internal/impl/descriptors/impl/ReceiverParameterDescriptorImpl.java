package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

public class ReceiverParameterDescriptorImpl extends AbstractReceiverParameterDescriptor {

    /* renamed from: a */
    static final /* synthetic */ boolean f5009a = (!ReceiverParameterDescriptorImpl.class.desiredAssertionStatus());

    /* renamed from: b */
    private final DeclarationDescriptor f5010b;

    /* renamed from: c */
    private ReceiverValue f5011c;

    /* renamed from: a */
    private static /* synthetic */ void m4730a(int i) {
        String str = (i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 3 || i == 4) ? 2 : 3)];
        switch (i) {
            case 1:
                objArr[0] = "value";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
                break;
            case 5:
                objArr[0] = "newOwner";
                break;
            case 6:
                objArr[0] = "outType";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 3) {
            objArr[1] = "getValue";
        } else if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (!(i == 3 || i == 4)) {
            if (i == 5) {
                objArr[2] = "copy";
            } else if (i != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "setOutType";
            }
        }
        String format = String.format(str, objArr);
        throw ((i == 3 || i == 4) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReceiverParameterDescriptorImpl(DeclarationDescriptor declarationDescriptor, ReceiverValue receiverValue, Annotations annotations) {
        super(annotations);
        if (declarationDescriptor == null) {
            m4730a(0);
        }
        if (receiverValue == null) {
            m4730a(1);
        }
        if (annotations == null) {
            m4730a(2);
        }
        this.f5010b = declarationDescriptor;
        this.f5011c = receiverValue;
    }

    public ReceiverValue getValue() {
        ReceiverValue receiverValue = this.f5011c;
        if (receiverValue == null) {
            m4730a(3);
        }
        return receiverValue;
    }

    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor declarationDescriptor = this.f5010b;
        if (declarationDescriptor == null) {
            m4730a(4);
        }
        return declarationDescriptor;
    }
}
