package kotlin.reflect.jvm.internal.impl.types;

import com.didi.beatles.p101im.access.utils.IMTextUtils;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: ErrorType.kt */
public class ErrorType extends SimpleType {

    /* renamed from: a */
    private final TypeConstructor f5807a;

    /* renamed from: b */
    private final MemberScope f5808b;

    /* renamed from: c */
    private final List<TypeProjection> f5809c;

    /* renamed from: d */
    private final boolean f5810d;

    /* renamed from: e */
    private final String f5811e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ErrorType(TypeConstructor typeConstructor, MemberScope memberScope) {
        this(typeConstructor, memberScope, (List) null, false, (String) null, 28, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ErrorType(TypeConstructor typeConstructor, MemberScope memberScope, List<? extends TypeProjection> list, boolean z) {
        this(typeConstructor, memberScope, list, z, (String) null, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        Intrinsics.checkNotNullParameter(list, "arguments");
    }

    public ErrorType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public TypeConstructor getConstructor() {
        return this.f5807a;
    }

    public MemberScope getMemberScope() {
        return this.f5808b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ErrorType(TypeConstructor typeConstructor, MemberScope memberScope, List list, boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeConstructor, memberScope, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? false : z, (i & 16) != 0 ? "???" : str);
    }

    public List<TypeProjection> getArguments() {
        return this.f5809c;
    }

    public boolean isMarkedNullable() {
        return this.f5810d;
    }

    public String getPresentableName() {
        return this.f5811e;
    }

    public ErrorType(TypeConstructor typeConstructor, MemberScope memberScope, List<? extends TypeProjection> list, boolean z, String str) {
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        Intrinsics.checkNotNullParameter(list, "arguments");
        Intrinsics.checkNotNullParameter(str, "presentableName");
        this.f5807a = typeConstructor;
        this.f5808b = memberScope;
        this.f5809c = list;
        this.f5810d = z;
        this.f5811e = str;
    }

    public Annotations getAnnotations() {
        return Annotations.Companion.getEMPTY();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getConstructor());
        sb.append(getArguments().isEmpty() ? "" : CollectionsKt.joinToString(getArguments(), ", ", IMTextUtils.STREET_IMAGE_TAG_START, IMTextUtils.STREET_IMAGE_TAG_END, -1, "...", (Function1) null));
        return sb.toString();
    }

    public SimpleType replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return this;
    }

    public SimpleType makeNullableAsSpecified(boolean z) {
        return new ErrorType(getConstructor(), getMemberScope(), getArguments(), z, (String) null, 16, (DefaultConstructorMarker) null);
    }
}
