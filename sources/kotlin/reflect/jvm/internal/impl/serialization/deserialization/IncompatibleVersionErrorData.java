package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.wallet.flutter.wallet_flutter.function.FlutterShareMethod;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.osgi.framework.VersionRange;

/* compiled from: IncompatibleVersionErrorData.kt */
public final class IncompatibleVersionErrorData<T> {

    /* renamed from: a */
    private final T f5704a;

    /* renamed from: b */
    private final T f5705b;

    /* renamed from: c */
    private final String f5706c;

    /* renamed from: d */
    private final ClassId f5707d;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IncompatibleVersionErrorData)) {
            return false;
        }
        IncompatibleVersionErrorData incompatibleVersionErrorData = (IncompatibleVersionErrorData) obj;
        return Intrinsics.areEqual((Object) this.f5704a, (Object) incompatibleVersionErrorData.f5704a) && Intrinsics.areEqual((Object) this.f5705b, (Object) incompatibleVersionErrorData.f5705b) && Intrinsics.areEqual((Object) this.f5706c, (Object) incompatibleVersionErrorData.f5706c) && Intrinsics.areEqual((Object) this.f5707d, (Object) incompatibleVersionErrorData.f5707d);
    }

    public int hashCode() {
        T t = this.f5704a;
        int i = 0;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.f5705b;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return ((((hashCode + i) * 31) + this.f5706c.hashCode()) * 31) + this.f5707d.hashCode();
    }

    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.f5704a + ", expectedVersion=" + this.f5705b + ", filePath=" + this.f5706c + ", classId=" + this.f5707d + VersionRange.RIGHT_OPEN;
    }

    public IncompatibleVersionErrorData(T t, T t2, String str, ClassId classId) {
        Intrinsics.checkNotNullParameter(str, FlutterShareMethod.filePathKey);
        Intrinsics.checkNotNullParameter(classId, "classId");
        this.f5704a = t;
        this.f5705b = t2;
        this.f5706c = str;
        this.f5707d = classId;
    }
}
