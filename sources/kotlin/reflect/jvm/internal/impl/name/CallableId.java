package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.p074io.IOUtils;

/* compiled from: CallableId.kt */
public final class CallableId {

    /* renamed from: a */
    private static final Companion f5428a = new Companion((DefaultConstructorMarker) null);
    @Deprecated

    /* renamed from: f */
    private static final Name f5429f;
    @Deprecated

    /* renamed from: g */
    private static final FqName f5430g;

    /* renamed from: b */
    private final FqName f5431b;

    /* renamed from: c */
    private final FqName f5432c;

    /* renamed from: d */
    private final Name f5433d;

    /* renamed from: e */
    private final FqName f5434e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallableId)) {
            return false;
        }
        CallableId callableId = (CallableId) obj;
        return Intrinsics.areEqual((Object) this.f5431b, (Object) callableId.f5431b) && Intrinsics.areEqual((Object) this.f5432c, (Object) callableId.f5432c) && Intrinsics.areEqual((Object) this.f5433d, (Object) callableId.f5433d) && Intrinsics.areEqual((Object) this.f5434e, (Object) callableId.f5434e);
    }

    public int hashCode() {
        int hashCode = this.f5431b.hashCode() * 31;
        FqName fqName = this.f5432c;
        int i = 0;
        int hashCode2 = (((hashCode + (fqName == null ? 0 : fqName.hashCode())) * 31) + this.f5433d.hashCode()) * 31;
        FqName fqName2 = this.f5434e;
        if (fqName2 != null) {
            i = fqName2.hashCode();
        }
        return hashCode2 + i;
    }

    public CallableId(FqName fqName, FqName fqName2, Name name, FqName fqName3) {
        Intrinsics.checkNotNullParameter(fqName, "packageName");
        Intrinsics.checkNotNullParameter(name, "callableName");
        this.f5431b = fqName;
        this.f5432c = fqName2;
        this.f5433d = name;
        this.f5434e = fqName3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CallableId(FqName fqName, FqName fqName2, Name name, FqName fqName3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fqName, fqName2, name, (i & 8) != 0 ? null : fqName3);
    }

    public final FqName getPackageName() {
        return this.f5431b;
    }

    public final FqName getClassName() {
        return this.f5432c;
    }

    public final Name getCallableName() {
        return this.f5433d;
    }

    /* compiled from: CallableId.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Name special = Name.special("<local>");
        Intrinsics.checkNotNullExpressionValue(special, "special(\"<local>\")");
        f5429f = special;
        FqName fqName = FqName.topLevel(special);
        Intrinsics.checkNotNullExpressionValue(fqName, "topLevel(LOCAL_NAME)");
        f5430g = fqName;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CallableId(FqName fqName, Name name) {
        this(fqName, (FqName) null, name, (FqName) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(fqName, "packageName");
        Intrinsics.checkNotNullParameter(name, "callableName");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String asString = getPackageName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "packageName.asString()");
        sb.append(StringsKt.replace$default(asString, '.', (char) IOUtils.DIR_SEPARATOR_UNIX, false, 4, (Object) null));
        sb.append("/");
        if (getClassName() != null) {
            sb.append(getClassName());
            sb.append(".");
        }
        sb.append(getCallableName());
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
