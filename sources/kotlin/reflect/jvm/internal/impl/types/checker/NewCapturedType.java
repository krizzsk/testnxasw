package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;

/* compiled from: NewCapturedType.kt */
public final class NewCapturedType extends SimpleType implements CapturedTypeMarker {

    /* renamed from: a */
    private final CaptureStatus f5861a;

    /* renamed from: b */
    private final NewCapturedTypeConstructor f5862b;

    /* renamed from: c */
    private final UnwrappedType f5863c;

    /* renamed from: d */
    private final Annotations f5864d;

    /* renamed from: e */
    private final boolean f5865e;

    /* renamed from: f */
    private final boolean f5866f;

    public final CaptureStatus getCaptureStatus() {
        return this.f5861a;
    }

    public NewCapturedTypeConstructor getConstructor() {
        return this.f5862b;
    }

    public final UnwrappedType getLowerType() {
        return this.f5863c;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NewCapturedType(CaptureStatus captureStatus, NewCapturedTypeConstructor newCapturedTypeConstructor, UnwrappedType unwrappedType, Annotations annotations, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(captureStatus, newCapturedTypeConstructor, unwrappedType, (i & 8) != 0 ? Annotations.Companion.getEMPTY() : annotations, (i & 16) != 0 ? false : z, (i & 32) != 0 ? false : z2);
    }

    public Annotations getAnnotations() {
        return this.f5864d;
    }

    public boolean isMarkedNullable() {
        return this.f5865e;
    }

    public final boolean isProjectionNotNull() {
        return this.f5866f;
    }

    public NewCapturedType(CaptureStatus captureStatus, NewCapturedTypeConstructor newCapturedTypeConstructor, UnwrappedType unwrappedType, Annotations annotations, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(captureStatus, "captureStatus");
        Intrinsics.checkNotNullParameter(newCapturedTypeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        this.f5861a = captureStatus;
        this.f5862b = newCapturedTypeConstructor;
        this.f5863c = unwrappedType;
        this.f5864d = annotations;
        this.f5865e = z;
        this.f5866f = z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NewCapturedType(CaptureStatus captureStatus, UnwrappedType unwrappedType, TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        this(captureStatus, new NewCapturedTypeConstructor(typeProjection, (Function0) null, (NewCapturedTypeConstructor) null, typeParameterDescriptor, 6, (DefaultConstructorMarker) null), unwrappedType, (Annotations) null, false, false, 56, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(captureStatus, "captureStatus");
        Intrinsics.checkNotNullParameter(typeProjection, "projection");
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
    }

    public List<TypeProjection> getArguments() {
        return CollectionsKt.emptyList();
    }

    public MemberScope getMemberScope() {
        MemberScope createErrorScope = ErrorUtils.createErrorScope("No member resolution should be done on captured type!", true);
        Intrinsics.checkNotNullExpressionValue(createErrorScope, "createErrorScope(\"No mem…on captured type!\", true)");
        return createErrorScope;
    }

    public NewCapturedType replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return new NewCapturedType(this.f5861a, getConstructor(), this.f5863c, annotations, isMarkedNullable(), false, 32, (DefaultConstructorMarker) null);
    }

    public NewCapturedType makeNullableAsSpecified(boolean z) {
        return new NewCapturedType(this.f5861a, getConstructor(), this.f5863c, getAnnotations(), z, false, 32, (DefaultConstructorMarker) null);
    }

    public NewCapturedType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        CaptureStatus captureStatus = this.f5861a;
        NewCapturedTypeConstructor refine = getConstructor().refine(kotlinTypeRefiner);
        UnwrappedType unwrappedType = this.f5863c;
        return new NewCapturedType(captureStatus, refine, unwrappedType == null ? null : kotlinTypeRefiner.refineType(unwrappedType).unwrap(), getAnnotations(), isMarkedNullable(), false, 32, (DefaultConstructorMarker) null);
    }
}
