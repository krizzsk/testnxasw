package com.jumio.core.api.calls;

import com.google.common.base.Ascii;
import com.jumio.commons.log.Log;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.network.C20984d;
import jumio.core.C19475f;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.jumio.core.api.calls.b */
/* compiled from: FinalizeCall.kt */
public final class C20948b extends C20984d<JSONObject> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C20948b(C19475f fVar, ApiCallDataModel<?> apiCallDataModel) {
        super(fVar, apiCallDataModel);
        Intrinsics.checkNotNullParameter(fVar, "apiCallSettings");
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
    }

    public String getRequest() throws Exception {
        return "";
    }

    public String getUri() {
        return StringDeobfuscator.deobfuscate(new byte[]{-93, -42, 35, -54, -66, Byte.MIN_VALUE, -40, Ascii.SYN}, 3486798841543688390L);
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
