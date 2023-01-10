package p242if;

import android.content.Context;
import com.iproov.sdk.core.C20870final;
import org.json.JSONException;
import org.json.JSONObject;
import p055case.C1268case;
import p055case.C1272else;
import p094super.C3649else;
import p095switch.C3680try;
import p238for.C21842if;
import p238for.C21843new;

/* renamed from: if.if */
/* compiled from: ClaimResponse */
public final class C22005if {

    /* renamed from: a */
    private final String f60033a;

    /* renamed from: b */
    private final C22001for f60034b;

    /* renamed from: c */
    private final C21842if f60035c;

    /* renamed from: d */
    private final String f60036d;

    /* renamed from: e */
    private final String f60037e;

    /* renamed from: f */
    private final C3649else f60038f;

    /* renamed from: g */
    private final C21998do f60039g;

    /* renamed from: h */
    private final C1268case f60040h;

    /* renamed from: i */
    private final C21843new f60041i;

    /* renamed from: j */
    private final C20870final f60042j;

    /* renamed from: k */
    private final String f60043k;

    /* renamed from: l */
    private final double f60044l;

    /* renamed from: m */
    private final boolean f60045m;

    /* renamed from: n */
    private final boolean f60046n;

    public C22005if(Context context, JSONObject jSONObject) throws JSONException {
        this.f60033a = jSONObject.getString("token");
        this.f60034b = C22001for.m45180do(jSONObject.getString("type"));
        if (!jSONObject.isNull("flash_pattern")) {
            this.f60035c = new C21842if(jSONObject.getJSONArray("flash_pattern"));
        } else {
            this.f60035c = new C21842if(jSONObject.getString("flash_code"));
        }
        this.f60036d = C3680try.m7471if(jSONObject, "user_name");
        this.f60037e = jSONObject.optString("sp_name");
        this.f60044l = jSONObject.optDouble("omega", 0.0d);
        this.f60038f = C3649else.m7320do(context, jSONObject.optJSONObject("clux_parameters"));
        C20870final finalR = null;
        this.f60043k = C3680try.m7465do(jSONObject, "deprecation_warning", (String) null);
        this.f60046n = jSONObject.optBoolean("sim", false);
        this.f60045m = jSONObject.optBoolean("rtf", false);
        C21998do doVar = C21998do.m45179do(C3680try.m7465do(jSONObject, "assurance_type", (String) null));
        this.f60039g = doVar == null ? C21998do.GENUINE_PRESENCE_ASSURANCE : doVar;
        JSONObject optJSONObject = jSONObject.optJSONObject("lvn_parameters");
        this.f60042j = optJSONObject != null ? new C20870final(optJSONObject) : finalR;
        this.f60040h = new C1268case(C1272else.m985do(jSONObject.optString("codec", C1272else.AVC.f466do)), jSONObject.optJSONObject("factors"));
        JSONObject optJSONObject2 = jSONObject.optJSONObject("gpa_parameters");
        this.f60041i = optJSONObject2 == null ? C21843new.m45177do() : new C21843new(optJSONObject2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo181310a() {
        return this.f60036d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo181311b() {
        return this.f60037e;
    }

    /* renamed from: break  reason: not valid java name */
    public String m48267break() {
        return this.f60033a;
    }

    /* renamed from: case  reason: not valid java name */
    public C3649else m48268case() {
        return this.f60038f;
    }

    /* renamed from: catch  reason: not valid java name */
    public C22001for m48269catch() {
        return this.f60034b;
    }

    /* renamed from: const  reason: not valid java name */
    public boolean m48270const() {
        return this.f60045m;
    }

    /* renamed from: do */
    public C21998do mo181316do() {
        return this.f60039g;
    }

    /* renamed from: else  reason: not valid java name */
    public C20870final m48271else() {
        return this.f60042j;
    }

    /* renamed from: final  reason: not valid java name */
    public boolean m48272final() {
        return this.f60046n;
    }

    /* renamed from: for  reason: not valid java name */
    public C1268case m48273for() {
        return this.f60040h;
    }

    /* renamed from: goto  reason: not valid java name */
    public double m48274goto() {
        return this.f60044l;
    }

    /* renamed from: if */
    public String mo181321if() {
        return this.f60043k;
    }

    /* renamed from: new  reason: not valid java name */
    public C21842if m48275new() {
        return this.f60035c;
    }

    /* renamed from: try  reason: not valid java name */
    public C21843new m48276try() {
        return this.f60041i;
    }
}
