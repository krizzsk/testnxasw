package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: InnerClassesScopeWrapper.kt */
public final class InnerClassesScopeWrapper extends MemberScopeImpl {

    /* renamed from: a */
    private final MemberScope f5622a;

    public InnerClassesScopeWrapper(MemberScope memberScope) {
        Intrinsics.checkNotNullParameter(memberScope, "workerScope");
        this.f5622a = memberScope;
    }

    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        ClassifierDescriptor contributedClassifier = this.f5622a.getContributedClassifier(name, lookupLocation);
        ClassifierDescriptor classifierDescriptor = null;
        if (contributedClassifier != null) {
            ClassDescriptor classDescriptor = contributedClassifier instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier : null;
            if (classDescriptor == null) {
                if (contributedClassifier instanceof TypeAliasDescriptor) {
                    classifierDescriptor = (TypeAliasDescriptor) contributedClassifier;
                }
                classifierDescriptor = (ClassifierDescriptorWithTypeParameters) classifierDescriptor;
            } else {
                classifierDescriptor = classDescriptor;
            }
        }
        return classifierDescriptor;
    }

    public List<ClassifierDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        DescriptorKindFilter restrictedToKindsOrNull = descriptorKindFilter.restrictedToKindsOrNull(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK());
        if (restrictedToKindsOrNull == null) {
            return CollectionsKt.emptyList();
        }
        Collection arrayList = new ArrayList();
        for (Object next : this.f5622a.getContributedDescriptors(restrictedToKindsOrNull, function1)) {
            if (next instanceof ClassifierDescriptorWithTypeParameters) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public Set<Name> getFunctionNames() {
        return this.f5622a.getFunctionNames();
    }

    public Set<Name> getVariableNames() {
        return this.f5622a.getVariableNames();
    }

    public Set<Name> getClassifierNames() {
        return this.f5622a.getClassifierNames();
    }

    public void recordLookup(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        this.f5622a.recordLookup(name, lookupLocation);
    }

    public String toString() {
        return Intrinsics.stringPlus("Classes from ", this.f5622a);
    }
}
