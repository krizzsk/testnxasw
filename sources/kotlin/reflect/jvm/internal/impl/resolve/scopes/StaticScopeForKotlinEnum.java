package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* compiled from: StaticScopeForKotlinEnum.kt */
public final class StaticScopeForKotlinEnum extends MemberScopeImpl {

    /* renamed from: a */
    static final /* synthetic */ KProperty<Object>[] f5624a = {C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(StaticScopeForKotlinEnum.class), "functions", "getFunctions()Ljava/util/List;"))};
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final ClassDescriptor f5625b;

    /* renamed from: c */
    private final NotNullLazyValue f5626c;

    public Void getContributedClassifier(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return null;
    }

    public StaticScopeForKotlinEnum(StorageManager storageManager, ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(classDescriptor, "containingClass");
        this.f5625b = classDescriptor;
        boolean z = classDescriptor.getKind() == ClassKind.ENUM_CLASS;
        if (!_Assertions.ENABLED || z) {
            this.f5626c = storageManager.createLazyValue(new StaticScopeForKotlinEnum$functions$2(this));
            return;
        }
        throw new AssertionError(Intrinsics.stringPlus("Class should be an enum: ", this.f5625b));
    }

    /* renamed from: a */
    private final List<SimpleFunctionDescriptor> m5141a() {
        return (List) StorageKt.getValue(this.f5626c, (Object) this, (KProperty<?>) f5624a[0]);
    }

    public List<SimpleFunctionDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return m5141a();
    }

    public SmartList<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        Collection smartList = new SmartList();
        for (Object next : m5141a()) {
            if (Intrinsics.areEqual((Object) ((SimpleFunctionDescriptor) next).getName(), (Object) name)) {
                smartList.add(next);
            }
        }
        return (SmartList) smartList;
    }
}
