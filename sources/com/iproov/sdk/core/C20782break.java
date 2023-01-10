package com.iproov.sdk.core;

import android.content.Context;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Debug;
import android.provider.Settings;
import com.iproov.sdk.logging.IPLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/* renamed from: com.iproov.sdk.core.break */
/* compiled from: IntrusionDetector */
public class C20782break {

    /* renamed from: a */
    private final C20883native f56932a;

    /* renamed from: b */
    private boolean f56933b = false;

    /* renamed from: c */
    private Method f56934c = null;

    /* renamed from: com.iproov.sdk.core.break$do */
    /* compiled from: IntrusionDetector */
    enum C20783do {
        AND15,
        AND16,
        AND17,
        AND18,
        AND19
    }

    public C20782break(Context context) {
        this.f56932a = new C20883native(context);
        C20781b.m43062a();
        C20893while.f57188a.clear();
        m43071c(C20783do.AND15);
        m43069b(context, C20783do.AND16);
        m43067a(context, C20783do.AND17);
        m43070b(C20783do.AND18);
        m43068a(C20783do.AND19);
    }

    /* renamed from: a */
    private void m43067a(Context context, C20783do doVar) {
        C20893while.m43453do(C20882import.AND9);
        C20781b.m43063a(doVar, Boolean.valueOf((context.getApplicationContext().getApplicationInfo().flags & 2) != 0));
    }

    /* renamed from: a */
    private void m43068a(C20783do doVar) {
        if (NativeLibraryLoader.f56928a) {
            try {
                C20891throw.f57187do = new NativeLibraryLoader().performance();
                C20893while.m43453do(C20882import.AND13);
                int i = C20891throw.f57187do;
                boolean z = true;
                if (i != 1) {
                    if (i != 2) {
                        z = false;
                    }
                }
                C20781b.m43063a(doVar, Boolean.valueOf(z));
            } catch (UnsatisfiedLinkError unused) {
                IPLog.m43494w("NativeLib", "Not loaded");
            }
        }
    }

    /* renamed from: c */
    private void m43071c(C20783do doVar) {
        C20893while.m43453do(C20882import.AND11);
        C20781b.m43063a(doVar, Boolean.valueOf(this.f56932a.m48137this()));
    }

    /* renamed from: b */
    private void m43069b(Context context, C20783do doVar) {
        boolean z;
        Settings.System.getString(context.getContentResolver(), "android_id");
        C20893while.m43453do(C20882import.AND12);
        String str = Build.FINGERPRINT;
        if ((!str.startsWith(C20786catch.m43156b()) || !str.endsWith(C20786catch.m43209c()) || !Build.MANUFACTURER.equals(C20786catch.m43231d()) || !Build.PRODUCT.startsWith(C20786catch.m43232e()) || !Build.BRAND.equals(C20786catch.m43233f()) || !Build.MODEL.startsWith(C20786catch.m43232e())) && !str.startsWith(C20786catch.m43234g()) && !str.startsWith(C20786catch.m43235h())) {
            String str2 = Build.MODEL;
            if (!str2.contains(C20786catch.m43236i()) && !str2.contains(C20786catch.m43237j()) && !str2.contains(C20786catch.m43238k()) && !Build.MANUFACTURER.contains(C20786catch.m43239l()) && !Build.HOST.equals(C20786catch.m43240m()) && ((!Build.BRAND.startsWith(C20786catch.m43234g()) || !Build.DEVICE.startsWith(C20786catch.m43234g())) && !Build.PRODUCT.equals(C20786catch.m43236i()) && !m43066a(C20786catch.m43241n(), "").equals("1") && !C20786catch.m43242o().equals(GLES20.glGetString(7937)))) {
                z = false;
                C20781b.m43063a(doVar, Boolean.valueOf(z));
            }
        }
        z = true;
        C20781b.m43063a(doVar, Boolean.valueOf(z));
    }

    /* renamed from: b */
    private void m43070b(C20783do doVar) {
        C20893while.m43453do(C20882import.AND10);
        C20781b.m43063a(doVar, Boolean.valueOf(Debug.isDebuggerConnected()));
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Process, java.lang.Object, java.lang.reflect.Method] */
    /* renamed from: a */
    private String m43066a(String str, String str2) {
        ? r3 = 0;
        if (!this.f56933b) {
            try {
                if (this.f56934c == null) {
                    this.f56934c = Class.forName(C20786catch.m43243p()).getMethod(C20786catch.m43245r(), new Class[]{String.class, String.class});
                }
                String str3 = (String) this.f56934c.invoke(r3, new Object[]{str, ""});
                return str3 == null ? str2 : str3;
            } catch (Exception unused) {
                this.f56934c = r3;
                this.f56933b = true;
            }
        }
        try {
            Process exec = Runtime.getRuntime().exec(String.format(C20786catch.m43244q(), new Object[]{str, str2}));
            String readLine = new BufferedReader(new InputStreamReader(exec.getInputStream())).readLine();
            exec.destroy();
            return readLine;
        } catch (IOException unused2) {
            if (r3 != 0) {
                r3.destroy();
            }
            return str2;
        } catch (Throwable th) {
            if (r3 != 0) {
                r3.destroy();
            }
            throw th;
        }
    }
}
