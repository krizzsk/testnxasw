package kotlin.reflect.jvm.internal.impl.types;

import com.didi.sdk.push.ServerParam;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* compiled from: DisjointKeysUnionTypeSubstitution.kt */
public final class DisjointKeysUnionTypeSubstitution extends TypeSubstitution {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final TypeSubstitution f5804a;

    /* renamed from: b */
    private final TypeSubstitution f5805b;

    public /* synthetic */ DisjointKeysUnionTypeSubstitution(TypeSubstitution typeSubstitution, TypeSubstitution typeSubstitution2, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeSubstitution, typeSubstitution2);
    }

    @JvmStatic
    public static final TypeSubstitution create(TypeSubstitution typeSubstitution, TypeSubstitution typeSubstitution2) {
        return Companion.create(typeSubstitution, typeSubstitution2);
    }

    public boolean isEmpty() {
        return false;
    }

    /* compiled from: DisjointKeysUnionTypeSubstitution.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TypeSubstitution create(TypeSubstitution typeSubstitution, TypeSubstitution typeSubstitution2) {
            Intrinsics.checkNotNullParameter(typeSubstitution, ServerParam.PARAM_FIRST);
            Intrinsics.checkNotNullParameter(typeSubstitution2, "second");
            if (typeSubstitution.isEmpty()) {
                return typeSubstitution2;
            }
            if (typeSubstitution2.isEmpty()) {
                return typeSubstitution;
            }
            return new DisjointKeysUnionTypeSubstitution(typeSubstitution, typeSubstitution2, (DefaultConstructorMarker) null);
        }
    }

    private DisjointKeysUnionTypeSubstitution(TypeSubstitution typeSubstitution, TypeSubstitution typeSubstitution2) {
        this.f5804a = typeSubstitution;
        this.f5805b = typeSubstitution2;
    }

    public TypeProjection get(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "key");
        TypeProjection typeProjection = this.f5804a.get(kotlinType);
        return typeProjection == null ? this.f5805b.get(kotlinType) : typeProjection;
    }

    public KotlinType prepareTopLevelType(KotlinType kotlinType, Variance variance) {
        Intrinsics.checkNotNullParameter(kotlinType, "topLevelType");
        Intrinsics.checkNotNullParameter(variance, "position");
        return this.f5805b.prepareTopLevelType(this.f5804a.prepareTopLevelType(kotlinType, variance), variance);
    }

    public boolean approximateCapturedTypes() {
        return this.f5804a.approximateCapturedTypes() || this.f5805b.approximateCapturedTypes();
    }

    public boolean approximateContravariantCapturedTypes() {
        return this.f5804a.approximateContravariantCapturedTypes() || this.f5805b.approximateContravariantCapturedTypes();
    }

    public Annotations filterAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        return this.f5805b.filterAnnotations(this.f5804a.filterAnnotations(annotations));
    }
}
