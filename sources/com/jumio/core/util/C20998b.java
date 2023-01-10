package com.jumio.core.util;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.jumio.core.util.b */
/* compiled from: JsonUtil.kt */
public final class C20998b {

    /* renamed from: a */
    public static final C20998b f57834a = new C20998b();

    /* renamed from: a */
    public final void mo172492a(JSONObject jSONObject, String str, String str2) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "request");
        Intrinsics.checkNotNullParameter(str, "name");
        if (str2 != null) {
            if (!(str2.length() == 0)) {
                jSONObject.put(str, str2);
            }
        }
    }
}
