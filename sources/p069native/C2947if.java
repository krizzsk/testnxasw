package p069native;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: native.if */
/* compiled from: Preferences */
public class C2947if {

    /* renamed from: a */
    private static final int[] f6632a = {73, 80, 114, 111, 111, 118, 73, 110, 116, 101, 114, 110, 97, 108};

    /* renamed from: b */
    private final SharedPreferences f6633b;

    public C2947if(Context context) {
        this.f6633b = SystemUtils.getSharedPreferences(context, m6434a(), 0);
    }

    /* renamed from: a */
    private static String m6434a() {
        StringBuilder sb = new StringBuilder();
        for (int i : f6632a) {
            sb.append((char) i);
        }
        return sb.toString();
    }

    /* renamed from: break  reason: not valid java name */
    public String m46609break() {
        SharedPreferences sharedPreferences = this.f6633b;
        return sharedPreferences.getString(m6434a() + "_tooFarExpression", (String) null);
    }

    /* renamed from: case  reason: not valid java name */
    public String m46610case() {
        SharedPreferences sharedPreferences = this.f6633b;
        return sharedPreferences.getString(m6434a() + "_shouldLockAndPhotoExpression", (String) null);
    }

    /* renamed from: catch  reason: not valid java name */
    public boolean m46611catch() {
        SharedPreferences sharedPreferences = this.f6633b;
        return sharedPreferences.getBoolean(m6434a() + "_hasNotDeletedKey", true);
    }

    /* renamed from: class  reason: not valid java name */
    public boolean m46612class() {
        SharedPreferences sharedPreferences = this.f6633b;
        return sharedPreferences.getBoolean(m6434a() + "_debugAvailable", false);
    }

    /* renamed from: const  reason: not valid java name */
    public boolean m46613const() {
        SharedPreferences sharedPreferences = this.f6633b;
        return sharedPreferences.getBoolean(m6434a() + "_debugEnabled", false);
    }

    /* renamed from: do */
    public void mo29249do(boolean z) {
        SharedPreferences.Editor edit = this.f6633b.edit();
        edit.putBoolean(m6434a() + "_debugEnabled", z).apply();
    }

    /* renamed from: else  reason: not valid java name */
    public String m46614else() {
        SharedPreferences sharedPreferences = this.f6633b;
        return sharedPreferences.getString(m6434a() + "_shouldUnlockAndPhotoExpression", (String) null);
    }

    /* renamed from: final  reason: not valid java name */
    public boolean m46615final() {
        if (!m46613const()) {
            SharedPreferences sharedPreferences = this.f6633b;
            StringBuilder sb = new StringBuilder();
            sb.append(m6434a());
            sb.append("_loggingEnabled");
            return sharedPreferences.getBoolean(sb.toString(), false);
        }
    }

    /* renamed from: for  reason: not valid java name */
    public String m46616for() {
        SharedPreferences sharedPreferences = this.f6633b;
        return sharedPreferences.getString(m6434a() + "_cluxExpression", (String) null);
    }

    /* renamed from: goto  reason: not valid java name */
    public String m46617goto() {
        SharedPreferences sharedPreferences = this.f6633b;
        return sharedPreferences.getString(m6434a() + "_tooBrightExpression", (String) null);
    }

    /* renamed from: new  reason: not valid java name */
    public String m46618new() {
        SharedPreferences sharedPreferences = this.f6633b;
        return sharedPreferences.getString(m6434a() + "_estimatedBrightnessExpression", (String) null);
    }

    /* renamed from: super  reason: not valid java name */
    public void m46619super() {
        SharedPreferences.Editor edit = this.f6633b.edit();
        edit.putBoolean(m6434a() + "_hasNotDeletedKey", false).apply();
    }

    /* renamed from: this  reason: not valid java name */
    public String m46620this() {
        SharedPreferences sharedPreferences = this.f6633b;
        return sharedPreferences.getString(m6434a() + "_tooCloseExpression", (String) null);
    }

    /* renamed from: throw  reason: not valid java name */
    public boolean m46621throw() {
        SharedPreferences sharedPreferences = this.f6633b;
        return sharedPreferences.getBoolean(m6434a() + "_startFlashingAutomatically", false);
    }

    /* renamed from: try  reason: not valid java name */
    public String m46622try() {
        SharedPreferences sharedPreferences = this.f6633b;
        return sharedPreferences.getString(m6434a() + "_screenBrightnessExpression", (String) null);
    }

    /* renamed from: do */
    public boolean mo29250do() {
        SharedPreferences sharedPreferences = this.f6633b;
        return sharedPreferences.getBoolean(m6434a() + "_alwaysAllowFlashingStart", false);
    }
}
