package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* renamed from: kotlin.reflect.jvm.internal.impl.types.d */
/* compiled from: KotlinTypeFactory.kt */
final class C2675d extends SimpleType {

    /* renamed from: a */
    private final TypeConstructor f5879a;

    /* renamed from: b */
    private final List<TypeProjection> f5880b;

    /* renamed from: c */
    private final boolean f5881c;

    /* renamed from: d */
    private final MemberScope f5882d;

    /* renamed from: e */
    private final Function1<KotlinTypeRefiner, SimpleType> f5883e;

    public TypeConstructor getConstructor() {
        return this.f5879a;
    }

    public List<TypeProjection> getArguments() {
        return this.f5880b;
    }

    public boolean isMarkedNullable() {
        return this.f5881c;
    }

    public MemberScope getMemberScope() {
        return this.f5882d;
    }

    public C2675d(TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z, MemberScope memberScope, Function1<? super KotlinTypeRefiner, ? extends SimpleType> function1) {
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(list, "arguments");
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        Intrinsics.checkNotNullParameter(function1, "refinedTypeFactory");
        this.f5879a = typeConstructor;
        this.f5880b = list;
        this.f5881c = z;
        this.f5882d = memberScope;
        this.f5883e = function1;
        if (getMemberScope() instanceof ErrorUtils.ErrorScope) {
            throw new IllegalStateException("SimpleTypeImpl should not be created for error type: " + getMemberScope() + 10 + getConstructor());
        }
    }

    public Annotations getAnnotations() {
        return Annotations.Companion.getEMPTY();
    }

    public SimpleType replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        if (annotations.isEmpty()) {
            return this;
        }
        return new C2665a(this, annotations);
    }

    public SimpleType makeNullableAsSpecified(boolean z) {
        if (z == isMarkedNullable()) {
            return this;
        }
        if (z) {
            return new C2667c(this);
        }
        return new C2666b(this);
    }

    /* renamed from: a */
    public SimpleType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        SimpleType invoke = this.f5883e.invoke(kotlinTypeRefiner);
        return invoke == null ? this : invoke;
    }
}
