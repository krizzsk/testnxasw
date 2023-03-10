package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: JvmBuiltInClassDescriptorFactory.kt */
final class JvmBuiltInClassDescriptorFactory$cloneable$2 extends Lambda implements Function0<ClassDescriptorImpl> {
    final /* synthetic */ StorageManager $storageManager;
    final /* synthetic */ JvmBuiltInClassDescriptorFactory this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JvmBuiltInClassDescriptorFactory$cloneable$2(JvmBuiltInClassDescriptorFactory jvmBuiltInClassDescriptorFactory, StorageManager storageManager) {
        super(0);
        this.this$0 = jvmBuiltInClassDescriptorFactory;
        this.$storageManager = storageManager;
    }

    public final ClassDescriptorImpl invoke() {
        ClassDescriptorImpl classDescriptorImpl = new ClassDescriptorImpl((DeclarationDescriptor) this.this$0.f4856c.invoke(this.this$0.f4855b), JvmBuiltInClassDescriptorFactory.f4853f, Modality.ABSTRACT, ClassKind.INTERFACE, CollectionsKt.listOf(this.this$0.f4855b.getBuiltIns().getAnyType()), SourceElement.NO_SOURCE, false, this.$storageManager);
        classDescriptorImpl.initialize(new CloneableClassScope(this.$storageManager, classDescriptorImpl), SetsKt.emptySet(), (ClassConstructorDescriptor) null);
        return classDescriptorImpl;
    }
}
