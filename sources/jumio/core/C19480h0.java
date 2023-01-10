package jumio.core;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

/* renamed from: jumio.core.h0 */
/* compiled from: RejectReason.kt */
public final class C19480h0 implements Serializable {

    /* renamed from: a */
    public String f55355a;

    /* renamed from: b */
    public String f55356b;

    public C19480h0() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public C19480h0(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "label");
        Intrinsics.checkNotNullParameter(str2, "reasonDetailCode");
        this.f55355a = str;
        this.f55356b = str2;
    }

    /* renamed from: a */
    public final String mo148631a() {
        return this.f55356b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19480h0)) {
            return false;
        }
        C19480h0 h0Var = (C19480h0) obj;
        return Intrinsics.areEqual((Object) this.f55355a, (Object) h0Var.f55355a) && Intrinsics.areEqual((Object) this.f55356b, (Object) h0Var.f55356b);
    }

    public int hashCode() {
        return (this.f55355a.hashCode() * 31) + this.f55356b.hashCode();
    }

    public String toString() {
        return "RejectReasonDetail(label=" + this.f55355a + ", reasonDetailCode=" + this.f55356b + VersionRange.RIGHT_OPEN;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C19480h0(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}
