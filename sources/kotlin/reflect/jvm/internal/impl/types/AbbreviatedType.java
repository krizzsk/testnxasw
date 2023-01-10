package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: SpecialTypes.kt */
public final class AbbreviatedType extends DelegatingSimpleType {

    /* renamed from: a */
    private final SimpleType f5789a;

    /* renamed from: b */
    private final SimpleType f5790b;

    public AbbreviatedType(SimpleType simpleType, SimpleType simpleType2) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        Intrinsics.checkNotNullParameter(simpleType2, "abbreviation");
        this.f5789a = simpleType;
        this.f5790b = simpleType2;
    }

    public final SimpleType getAbbreviation() {
        return this.f5790b;
    }

    /* access modifiers changed from: protected */
    public SimpleType getDelegate() {
        return this.f5789a;
    }

    public final SimpleType getExpandedType() {
        return getDelegate();
    }

    public AbbreviatedType replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return new AbbreviatedType(getDelegate().replaceAnnotations(annotations), this.f5790b);
    }

    public AbbreviatedType makeNullableAsSpecified(boolean z) {
        return new AbbreviatedType(getDelegate().makeNullableAsSpecified(z), this.f5790b.makeNullableAsSpecified(z));
    }

    public AbbreviatedType replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        return new AbbreviatedType(simpleType, this.f5790b);
    }

    public AbbreviatedType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new AbbreviatedType((SimpleType) kotlinTypeRefiner.refineType(getDelegate()), (SimpleType) kotlinTypeRefiner.refineType(this.f5790b));
    }
}
