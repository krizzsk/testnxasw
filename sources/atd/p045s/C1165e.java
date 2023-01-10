package atd.p045s;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import atd.p025i.C1050b;
import atd.p025i.C1051c;
import atd.p046s0.C1172a;

/* renamed from: atd.s.e */
public class C1165e implements C1050b {
    /* renamed from: b */
    public Integer mo13780a(Context context) throws C1051c {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return Integer.valueOf(Settings.Secure.getInt(context.getContentResolver(), C1172a.m764a(-35214890191534L)));
            } catch (Settings.SettingNotFoundException unused) {
                return null;
            }
        } else {
            throw new C1051c(C1051c.C1052a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
        }
    }

    /* renamed from: a */
    public String mo13781a() {
        return C1172a.m764a(-35193415355054L);
    }
}
