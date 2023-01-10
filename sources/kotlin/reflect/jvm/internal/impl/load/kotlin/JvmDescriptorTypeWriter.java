package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;

/* compiled from: typeSignatureMapping.kt */
public class JvmDescriptorTypeWriter<T> {

    /* renamed from: a */
    private final JvmTypeFactory<T> f5349a;

    /* renamed from: b */
    private int f5350b;

    /* renamed from: c */
    private T f5351c;

    public void writeArrayEnd() {
    }

    public void writeArrayType() {
        if (this.f5351c == null) {
            this.f5350b++;
        }
    }

    public void writeClass(T t) {
        Intrinsics.checkNotNullParameter(t, "objectType");
        writeJvmTypeAsIs(t);
    }

    /* access modifiers changed from: protected */
    public final void writeJvmTypeAsIs(T t) {
        Intrinsics.checkNotNullParameter(t, "type");
        if (this.f5351c == null) {
            int i = this.f5350b;
            if (i > 0) {
                t = this.f5349a.createFromString(Intrinsics.stringPlus(StringsKt.repeat(Const.jaLeft, i), this.f5349a.toString(t)));
            }
            this.f5351c = t;
        }
    }

    public void writeTypeVariable(Name name, T t) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(t, "type");
        writeJvmTypeAsIs(t);
    }
}
