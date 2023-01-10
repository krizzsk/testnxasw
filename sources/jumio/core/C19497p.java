package jumio.core;

import com.jumio.commons.PersistWith;
import com.jumio.commons.log.Log;
import com.jumio.core.Controller;
import com.jumio.core.credentials.C20951b;
import com.jumio.core.credentials.JumioDocumentCredential;
import com.jumio.core.enums.C20952a;
import com.jumio.core.model.StaticModel;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.credentials.JumioCredentialInfo;
import com.jumio.sdk.credentials.JumioFaceCredential;
import com.jumio.sdk.credentials.JumioIDCredential;
import com.jumio.sdk.document.JumioDocumentType;
import com.jumio.sdk.document.JumioDocumentVariant;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@PersistWith("ScanCredentialsModel")
/* renamed from: jumio.core.p */
/* compiled from: CredentialsModel.kt */
public final class C19497p implements StaticModel {

    /* renamed from: a */
    public int f55397a;

    /* renamed from: b */
    public String f55398b;

    /* renamed from: c */
    public final ArrayList<C19489l> f55399c = new ArrayList<>();

    /* renamed from: a */
    public final String mo148706a() {
        return this.f55398b;
    }

    /* renamed from: b */
    public final C19489l mo148710b() {
        C19489l lVar = this.f55399c.get(this.f55397a);
        Intrinsics.checkNotNullExpressionValue(lVar, "dataModels[index]");
        return lVar;
    }

    /* renamed from: c */
    public final boolean mo148713c() {
        Iterator<C19489l> it = this.f55399c.iterator();
        while (it.hasNext()) {
            if (!it.next().mo148673g()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public final ArrayList<C19489l> mo148714d() {
        return this.f55399c;
    }

    /* renamed from: e */
    public final ArrayList<JumioCredentialInfo> mo148715e() {
        ArrayList<JumioCredentialInfo> arrayList = new ArrayList<>();
        Iterator<C19489l> it = this.f55399c.iterator();
        while (it.hasNext()) {
            C19489l next = it.next();
            arrayList.add(new JumioCredentialInfo(next.mo148670d(), next.mo148671e()));
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo148708a(org.json.JSONObject r9) {
        /*
            r8 = this;
            java.lang.String r0 = "jsonObject"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "id"
            java.lang.String r1 = r9.optString(r0)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r3 = "capabilities"
            org.json.JSONArray r4 = r9.getJSONArray(r3)
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x0033
            r5 = 0
        L_0x001d:
            int r6 = r5 + 1
            org.json.JSONArray r7 = r9.getJSONArray(r3)
            org.json.JSONObject r5 = r7.getJSONObject(r5)
            com.jumio.core.credentials.b r5 = com.jumio.core.credentials.C20951b.m43726a(r5)
            r2.add(r5)
            if (r6 < r4) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r5 = r6
            goto L_0x001d
        L_0x0033:
            java.lang.String r3 = "category"
            java.lang.String r3 = r9.getString(r3)
            if (r3 == 0) goto L_0x0082
            int r4 = r3.hashCode()
            r5 = -374349377(0xffffffffe9afe1bf, float:-2.657851E25)
            if (r4 == r5) goto L_0x0071
            r5 = 2331(0x91b, float:3.266E-42)
            if (r4 == r5) goto L_0x0060
            r9 = 1644347675(0x6202c11b, float:6.0299786E20)
            if (r4 == r9) goto L_0x004e
            goto L_0x0082
        L_0x004e:
            java.lang.String r9 = "DOCUMENT"
            boolean r9 = r3.equals(r9)
            if (r9 != 0) goto L_0x0057
            goto L_0x0082
        L_0x0057:
            jumio.core.m r9 = new jumio.core.m
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r9.<init>(r1, r2)
            goto L_0x0083
        L_0x0060:
            java.lang.String r4 = "ID"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0069
            goto L_0x0082
        L_0x0069:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            jumio.core.l r9 = r8.mo148707a(r9, r1, r2)
            goto L_0x0083
        L_0x0071:
            java.lang.String r4 = "FACEMAP"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x007a
            goto L_0x0082
        L_0x007a:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            jumio.core.n r9 = r8.mo148711b(r9, r1, r2)
            goto L_0x0083
        L_0x0082:
            r9 = 0
        L_0x0083:
            if (r9 != 0) goto L_0x0086
            goto L_0x008d
        L_0x0086:
            java.util.ArrayList r0 = r8.mo148714d()
            r0.add(r9)
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.C19497p.mo148708a(org.json.JSONObject):void");
    }

    /* renamed from: b */
    public final ArrayList<String> mo148709b(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("country");
        if (optJSONObject == null || !Intrinsics.areEqual((Object) optJSONObject.optString("predefinedType"), (Object) "DEFINED")) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        JSONArray jSONArray = optJSONObject.getJSONArray("values");
        int i = 0;
        int length = jSONArray.length();
        if (length <= 0) {
            return arrayList;
        }
        while (true) {
            int i2 = i + 1;
            arrayList.add(jSONArray.getString(i));
            if (i2 >= length) {
                return arrayList;
            }
            i = i2;
        }
    }

    /* renamed from: c */
    public final ArrayList<JumioDocumentType> mo148712c(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("type");
        if (optJSONObject == null || !Intrinsics.areEqual((Object) optJSONObject.optString("predefinedType"), (Object) "DEFINED")) {
            return null;
        }
        ArrayList<JumioDocumentType> arrayList = new ArrayList<>();
        JSONArray jSONArray = optJSONObject.getJSONArray("values");
        int i = 0;
        int length = jSONArray.length();
        if (length <= 0) {
            return arrayList;
        }
        while (true) {
            int i2 = i + 1;
            try {
                String string = jSONArray.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "values.getString(i)");
                arrayList.add(JumioDocumentType.valueOf(string));
            } catch (Exception unused) {
                Log.m43648e(Intrinsics.stringPlus(jSONArray.getString(i), " is not a valid DocumentType"));
            }
            if (i2 >= length) {
                return arrayList;
            }
            i = i2;
        }
    }

    /* renamed from: b */
    public final C19493n mo148711b(JSONObject jSONObject, String str, ArrayList<C20951b> arrayList) {
        ArrayList arrayList2;
        JSONObject optJSONObject = jSONObject.optJSONObject("type");
        if (optJSONObject != null && Intrinsics.areEqual((Object) optJSONObject.optString("predefinedType"), (Object) "DEFINED")) {
            arrayList2 = new ArrayList();
            JSONArray jSONArray = optJSONObject.getJSONArray("values");
            int i = 0;
            int length = jSONArray.length();
            if (length > 0) {
                while (true) {
                    int i2 = i + 1;
                    try {
                        String string = jSONArray.getString(i);
                        Intrinsics.checkNotNullExpressionValue(string, "values.getString(i)");
                        arrayList2.add(C20952a.valueOf(string));
                    } catch (Exception unused) {
                        Log.m43648e(Intrinsics.stringPlus(jSONArray.getString(i), " is not a valid DocumentType"));
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
        } else {
            arrayList2 = null;
        }
        return new C19493n(str, arrayList, arrayList2);
    }

    /* renamed from: a */
    public final C19489l mo148707a(JSONObject jSONObject, String str, ArrayList<C20951b> arrayList) {
        return new C19495o(str, arrayList, mo148709b(jSONObject), mo148712c(jSONObject), (JumioDocumentVariant) null);
    }

    /* renamed from: a */
    public final JumioCredential mo148705a(Controller controller, String str) {
        JumioCredential jumioCredential;
        C19489l data$jumio_core_release;
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(str, "id");
        Iterator<C19489l> it = this.f55399c.iterator();
        boolean z = false;
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (it.next().mo148671e().equals(str)) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            z = true;
        }
        if (z) {
            this.f55397a = i;
            C19489l b = mo148710b();
            String str2 = null;
            if (b instanceof C19495o) {
                jumioCredential = new JumioIDCredential(controller, (C19495o) mo148710b());
            } else if (b instanceof C19493n) {
                jumioCredential = new JumioFaceCredential(controller, (C19493n) mo148710b());
            } else {
                jumioCredential = b instanceof C19491m ? new JumioDocumentCredential(controller, (C19491m) mo148710b()) : null;
            }
            if (!(jumioCredential == null || (data$jumio_core_release = jumioCredential.getData$jumio_core_release()) == null)) {
                str2 = data$jumio_core_release.mo148671e();
            }
            this.f55398b = str2;
            return jumioCredential;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus(str, " not found").toString());
    }
}
