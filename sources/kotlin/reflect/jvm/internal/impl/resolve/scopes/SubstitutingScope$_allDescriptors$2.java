package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;

/* compiled from: SubstitutingScope.kt */
final class SubstitutingScope$_allDescriptors$2 extends Lambda implements Function0<Collection<? extends DeclarationDescriptor>> {
    final /* synthetic */ SubstitutingScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubstitutingScope$_allDescriptors$2(SubstitutingScope substitutingScope) {
        super(0);
        this.this$0 = substitutingScope;
    }

    public final Collection<DeclarationDescriptor> invoke() {
        SubstitutingScope substitutingScope = this.this$0;
        return substitutingScope.m5143a(ResolutionScope.DefaultImpls.getContributedDescriptors$default(substitutingScope.f5627a, (DescriptorKindFilter) null, (Function1) null, 3, (Object) null));
    }
}
