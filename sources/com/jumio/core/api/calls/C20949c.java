package com.jumio.core.api.calls;

import com.jumio.commons.log.Log;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.network.C20984d;
import com.jumio.core.plugins.C20991a;
import com.jumio.core.util.C20997a;
import java.util.ArrayList;
import jumio.core.C19475f;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.jumio.core.api.calls.c */
/* compiled from: SettingsCall.kt */
public final class C20949c extends C20984d<JSONObject> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C20949c(C19475f fVar, ApiCallDataModel<?> apiCallDataModel) {
        super(fVar, apiCallDataModel);
        Intrinsics.checkNotNullParameter(fVar, "apiCallSettings");
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
    }

    public String getRequest() throws Exception {
        JSONArray jSONArray = new JSONArray();
        ArrayList<String> a = C20991a.m43781a();
        C20991a.C20994c cVar = C20991a.C20994c.BARCODE_NATIVE;
        if (a.contains(cVar.name())) {
            a.remove(cVar.name());
            C20991a.C20994c cVar2 = C20991a.C20994c.BARCODE;
            if (!a.contains(cVar2.name())) {
                a.add(cVar2.name());
            }
        }
        Intrinsics.checkNotNullExpressionValue(a, "plugins");
        for (String put : a) {
            jSONArray.put(put);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("linkedModules", jSONArray);
        jSONObject.put("deviceDetails", C20997a.m43827a());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "requestJson.toString()");
        return jSONObject2;
    }

    public String getUri() {
        return StringDeobfuscator.deobfuscate(new byte[]{-22, -121, -25, 65, 43, 57, 98, -73}, -3991709031461092330L);
    }

    public JSONObject parseResponse(String str) {
        Intrinsics.checkNotNullParameter(str, "plainTextAnswer");
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            Log.m43666w(this.TAG, "Exception", (Throwable) e);
            return new JSONObject();
        }
    }
}
