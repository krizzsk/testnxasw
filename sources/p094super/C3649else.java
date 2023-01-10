package p094super;

import android.content.Context;
import kotlin.text.Typography;
import org.json.JSONObject;
import p069native.C2947if;
import p095switch.C3680try;

/* renamed from: super.else */
/* compiled from: LightingModelParameters */
public class C3649else {

    /* renamed from: a */
    private String f8711a = "s > 0.9";

    /* renamed from: b */
    private String f8712b = "s < 0.55";

    /* renamed from: c */
    private String f8713c = "(i*A)<(400*(v+4)*(11-s)^2)";

    /* renamed from: d */
    private String f8714d = "clamp(0.5*(c*h(0.75)^2),0.95,1)";

    /* renamed from: e */
    private String f8715e = "vo*(1+(min(abs(h(0.5)-ho(0.5)),0.6)))";

    /* renamed from: f */
    private String f8716f = "(s<0) || (p > 5) || (abs(h(0.5)-ho(0.5))>0.3 && p > 2)";

    /* renamed from: g */
    private String f8717g = "p > 4";

    /* renamed from: h */
    private String f8718h = "(3*n^2)/(t*i)";

    private C3649else(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.f8711a = m7319a(str, "s > 0.9", str8);
        this.f8712b = m7319a(str2, this.f8712b, str8);
        this.f8713c = m7319a(str3, this.f8713c, str8);
        this.f8714d = m7319a(str4, this.f8714d, str8);
        this.f8715e = m7319a(str5, this.f8715e, str8);
        this.f8716f = m7319a(str6, this.f8716f, str8);
        this.f8717g = m7319a(str7, this.f8717g, str8);
        this.f8718h = m7319a(str8, this.f8718h, str8);
    }

    /* renamed from: a */
    private String m7319a(String str, String str2, String str3) {
        return (str == null || str3 == null) ? str2 : str;
    }

    /* renamed from: do */
    public static C3649else m7320do(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        C2947if ifVar = new C2947if(context);
        String str = ifVar.m46620this();
        String str2 = ifVar.m46617goto();
        String str3 = ifVar.m46609break();
        String str4 = ifVar.m46622try();
        String str5 = ifVar.m46618new();
        String str6 = ifVar.m46614else();
        String str7 = ifVar.m46610case();
        String str8 = ifVar.m46616for();
        if (str == null) {
            str = C3680try.m7471if(jSONObject2, "tc");
        }
        String str9 = str;
        if (str3 == null) {
            str3 = C3680try.m7471if(jSONObject2, "tf");
        }
        String str10 = str3;
        if (str2 == null) {
            str2 = C3680try.m7471if(jSONObject2, "tb");
        }
        String str11 = str2;
        if (str4 == null) {
            str4 = C3680try.m7471if(jSONObject2, "sd");
        }
        String str12 = str4;
        if (str5 == null) {
            str5 = C3680try.m7471if(jSONObject2, "ev");
        }
        String str13 = str5;
        if (str6 == null) {
            str6 = C3680try.m7471if(jSONObject2, "su");
        }
        String str14 = str6;
        if (str7 == null) {
            str7 = C3680try.m7471if(jSONObject2, "sl");
        }
        String str15 = str7;
        if (str8 == null) {
            str8 = C3680try.m7471if(jSONObject2, "cl");
        }
        return new C3649else(str9, str10, str11, str12, str13, str14, str15, str8);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo43445a() {
        return m7318a(this.f8711a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo43446b() {
        return m7318a(this.f8712b);
    }

    /* renamed from: break  reason: not valid java name */
    public String m46654break() {
        return this.f8712b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo43448c() {
        return m7318a(this.f8713c);
    }

    /* renamed from: case  reason: not valid java name */
    public String m46655case() {
        return this.f8717g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo43450d() {
        return m7318a(this.f8714d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo43451e() {
        return m7318a(this.f8715e);
    }

    /* renamed from: else  reason: not valid java name */
    public String m46656else() {
        return this.f8716f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public String mo43453f() {
        return m7318a(this.f8716f);
    }

    /* renamed from: for  reason: not valid java name */
    public String m46657for() {
        return this.f8718h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public String mo43455g() {
        return m7318a(this.f8717g);
    }

    /* renamed from: goto  reason: not valid java name */
    public String m46658goto() {
        return this.f8713c;
    }

    /* renamed from: new  reason: not valid java name */
    public String m46659new() {
        return this.f8715e;
    }

    /* renamed from: this  reason: not valid java name */
    public String m46660this() {
        return this.f8711a;
    }

    public String toString() {
        return "LightingModelParameters{tooCloseExpression='" + mo43445a() + '\'' + ", tooFarExpression='" + mo43446b() + '\'' + ", tooBrightExpression='" + mo43448c() + '\'' + ", screenBrightnessExpression='" + mo43450d() + '\'' + ", estimatedBrightnessExpression='" + mo43451e() + '\'' + ", shouldUnlockAndPhotoExpression='" + mo43453f() + '\'' + ", shouldLockAndPhotoExpression='" + mo43455g() + '\'' + ", cluxExpression='" + mo43457h() + '\'' + '}';
    }

    /* renamed from: try  reason: not valid java name */
    public String m46661try() {
        return this.f8714d;
    }

    /* renamed from: a */
    private static String m7318a(String str) {
        return str.replace("&&", String.valueOf(Typography.amp)).replace("||", String.valueOf('|')).replace("<=", String.valueOf(Typography.euro)).replace(">=", String.valueOf(Typography.pound));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public String mo43457h() {
        return m7318a(this.f8718h);
    }
}
