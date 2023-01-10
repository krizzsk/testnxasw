package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: typeQualifiers.kt */
public final class JavaTypeQualifiers {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final JavaTypeQualifiers f5306e = new JavaTypeQualifiers((NullabilityQualifier) null, (MutabilityQualifier) null, false, false, 8, (DefaultConstructorMarker) null);

    /* renamed from: a */
    private final NullabilityQualifier f5307a;

    /* renamed from: b */
    private final MutabilityQualifier f5308b;

    /* renamed from: c */
    private final boolean f5309c;

    /* renamed from: d */
    private final boolean f5310d;

    public JavaTypeQualifiers(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z, boolean z2) {
        this.f5307a = nullabilityQualifier;
        this.f5308b = mutabilityQualifier;
        this.f5309c = z;
        this.f5310d = z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JavaTypeQualifiers(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(nullabilityQualifier, mutabilityQualifier, z, (i & 8) != 0 ? false : z2);
    }

    public final NullabilityQualifier getNullability() {
        return this.f5307a;
    }

    public final MutabilityQualifier getMutability() {
        return this.f5308b;
    }

    public final boolean isNotNullTypeParameter() {
        return this.f5309c;
    }

    public final boolean isNullabilityQualifierForWarning() {
        return this.f5310d;
    }

    /* compiled from: typeQualifiers.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JavaTypeQualifiers getNONE() {
            return JavaTypeQualifiers.f5306e;
        }
    }
}
