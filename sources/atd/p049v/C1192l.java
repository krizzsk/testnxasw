package atd.p049v;

import android.content.Context;
import android.os.Build;
import atd.p025i.C1051c;
import atd.p046s0.C1172a;

/* renamed from: atd.v.l */
public final class C1192l extends C1179a0 {
    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-36198437702318L);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String mo13785c(Context context) throws C1051c {
        if (Build.VERSION.SDK_INT >= 19) {
            return mo13938d(context).getMmsUAProfUrl();
        }
        throw new C1051c(C1051c.C1052a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}
