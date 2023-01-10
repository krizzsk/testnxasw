package jumio.core;

import com.jumio.commons.log.Log;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import org.osgi.framework.VersionRange;

/* renamed from: jumio.core.g0 */
/* compiled from: RejectReason.kt */
public final class C19478g0 implements Serializable {

    /* renamed from: a */
    public String f55347a;

    /* renamed from: b */
    public String f55348b;

    /* renamed from: c */
    public String f55349c;

    /* renamed from: d */
    public boolean f55350d;

    /* renamed from: e */
    public String f55351e;

    /* renamed from: f */
    public String f55352f;

    /* renamed from: g */
    public List<C19480h0> f55353g;

    /* renamed from: h */
    public boolean f55354h;

    public C19478g0() {
        this((String) null, (String) null, (String) null, false, (String) null, (String) null, (List) null, false, 255, (DefaultConstructorMarker) null);
    }

    public C19478g0(String str, String str2, String str3, boolean z, String str4, String str5, List<C19480h0> list, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "channel");
        Intrinsics.checkNotNullParameter(str2, "label");
        Intrinsics.checkNotNullParameter(str3, "rejectAction");
        Intrinsics.checkNotNullParameter(str4, "reasonCode");
        Intrinsics.checkNotNullParameter(str5, "category");
        Intrinsics.checkNotNullParameter(list, "details");
        this.f55347a = str;
        this.f55348b = str2;
        this.f55349c = str3;
        this.f55350d = z;
        this.f55351e = str4;
        this.f55352f = str5;
        this.f55353g = list;
        this.f55354h = z2;
    }

    /* renamed from: a */
    public final String mo148626a() {
        if (this.f55353g.isEmpty()) {
            return this.f55351e;
        }
        return this.f55353g.size() != 0 ? this.f55353g.get(0).mo148631a() : "";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19478g0)) {
            return false;
        }
        C19478g0 g0Var = (C19478g0) obj;
        return Intrinsics.areEqual((Object) this.f55347a, (Object) g0Var.f55347a) && Intrinsics.areEqual((Object) this.f55348b, (Object) g0Var.f55348b) && Intrinsics.areEqual((Object) this.f55349c, (Object) g0Var.f55349c) && this.f55350d == g0Var.f55350d && Intrinsics.areEqual((Object) this.f55351e, (Object) g0Var.f55351e) && Intrinsics.areEqual((Object) this.f55352f, (Object) g0Var.f55352f) && Intrinsics.areEqual((Object) this.f55353g, (Object) g0Var.f55353g) && this.f55354h == g0Var.f55354h;
    }

    public int hashCode() {
        int hashCode = ((((this.f55347a.hashCode() * 31) + this.f55348b.hashCode()) * 31) + this.f55349c.hashCode()) * 31;
        boolean z = this.f55350d;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int hashCode2 = (((((((hashCode + (z ? 1 : 0)) * 31) + this.f55351e.hashCode()) * 31) + this.f55352f.hashCode()) * 31) + this.f55353g.hashCode()) * 31;
        boolean z3 = this.f55354h;
        if (!z3) {
            z2 = z3;
        }
        return hashCode2 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "RejectReason(channel=" + this.f55347a + ", label=" + this.f55348b + ", rejectAction=" + this.f55349c + ", active=" + this.f55350d + ", reasonCode=" + this.f55351e + ", category=" + this.f55352f + ", details=" + this.f55353g + ", isRetryAllowed=" + this.f55354h + VersionRange.RIGHT_OPEN;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ C19478g0(java.lang.String r10, java.lang.String r11, java.lang.String r12, boolean r13, java.lang.String r14, java.lang.String r15, java.util.List r16, boolean r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000b
        L_0x000a:
            r1 = r10
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0012
        L_0x0011:
            r3 = r11
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = r2
            goto L_0x0019
        L_0x0018:
            r4 = r12
        L_0x0019:
            r5 = r0 & 8
            r6 = 0
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0021
        L_0x0020:
            r5 = r13
        L_0x0021:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0027
            r7 = r2
            goto L_0x0028
        L_0x0027:
            r7 = r14
        L_0x0028:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x002d
            goto L_0x002e
        L_0x002d:
            r2 = r15
        L_0x002e:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            goto L_0x003a
        L_0x0038:
            r8 = r16
        L_0x003a:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r6 = r17
        L_0x0041:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r7
            r16 = r2
            r17 = r8
            r18 = r6
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.C19478g0.<init>(java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.util.List, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public C19478g0(JSONObject jSONObject) {
        this((String) null, (String) null, (String) null, false, (String) null, (String) null, (List) null, false, 255, (DefaultConstructorMarker) null);
        if (jSONObject != null) {
            String optString = jSONObject.optString("channel");
            Intrinsics.checkNotNullExpressionValue(optString, "rejectReasonJson.optString(\"channel\")");
            this.f55347a = optString;
            String optString2 = jSONObject.optString("label");
            Intrinsics.checkNotNullExpressionValue(optString2, "rejectReasonJson.optString(\"label\")");
            this.f55348b = optString2;
            String optString3 = jSONObject.optString("rejectAction");
            Intrinsics.checkNotNullExpressionValue(optString3, "rejectReasonJson.optString(\"rejectAction\")");
            this.f55349c = optString3;
            int i = 0;
            this.f55350d = jSONObject.optBoolean("active", false);
            String optString4 = jSONObject.optString("reasonCode");
            Intrinsics.checkNotNullExpressionValue(optString4, "rejectReasonJson.optString(\"reasonCode\")");
            this.f55351e = optString4;
            String optString5 = jSONObject.optString("category");
            Intrinsics.checkNotNullExpressionValue(optString5, "rejectReasonJson.optString(\"category\")");
            this.f55352f = optString5;
            this.f55354h = jSONObject.optBoolean("retryAllowed", false);
            try {
                if (!jSONObject.isNull("details")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("details");
                    Intrinsics.checkNotNullExpressionValue(jSONArray, "rejectReasonJson.getJSONArray(\"details\")");
                    int length = jSONArray.length();
                    if (length > 0) {
                        while (true) {
                            int i2 = i + 1;
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String string = jSONObject2.getString("label");
                            Intrinsics.checkNotNullExpressionValue(string, "item.getString(\"label\")");
                            String string2 = jSONObject2.getString("reasonDetailCode");
                            Intrinsics.checkNotNullExpressionValue(string2, "item.getString(\"reasonDetailCode\")");
                            this.f55353g.add(new C19480h0(string, string2));
                            if (i2 < length) {
                                i = i2;
                            } else {
                                return;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                Log.printStackTrace(e);
            }
        }
    }
}
