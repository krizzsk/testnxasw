package com.jumio.core.api.calls;

import com.google.common.base.Ascii;
import com.jumio.commons.log.Log;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.network.C20984d;
import com.jumio.sdk.result.JumioCredentialResult;
import com.jumio.sdk.result.JumioIDResult;
import java.util.HashMap;
import java.util.Iterator;
import jumio.core.C19475f;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.jumio.core.api.calls.a */
/* compiled from: ExtractDataCall.kt */
public final class C20947a extends C20984d<HashMap<String, JumioCredentialResult>> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C20947a(C19475f fVar, ApiCallDataModel<?> apiCallDataModel) {
        super(fVar, apiCallDataModel);
        Intrinsics.checkNotNullParameter(fVar, "apiCallSettings");
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
    }

    /* renamed from: a */
    public final String mo171982a(String str) {
        if (str != null) {
            if (!(str.length() > 0) || Intrinsics.areEqual((Object) JSONObject.NULL.toString(), (Object) str)) {
                return null;
            }
            return str;
        }
        return null;
    }

    /* renamed from: b */
    public HashMap<String, JumioCredentialResult> parseResponse(String str) {
        Intrinsics.checkNotNullParameter(str, "plainTextAnswer");
        HashMap<String, JumioCredentialResult> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "result.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                JumioIDResult jumioIDResult = new JumioIDResult();
                jumioIDResult.setIssuingCountry(mo171982a(jSONObject2.optString("issuingCountry")));
                jumioIDResult.setIdType(mo171982a(jSONObject2.optString("idType")));
                jumioIDResult.setFirstName(mo171982a(jSONObject2.optString("firstName")));
                jumioIDResult.setLastName(mo171982a(jSONObject2.optString("lastName")));
                jumioIDResult.setDateOfBirth(mo171982a(jSONObject2.optString("dateOfBirth")));
                jumioIDResult.setIssuingDate(mo171982a(jSONObject2.optString("issuingDate")));
                jumioIDResult.setExpiryDate(mo171982a(jSONObject2.optString("expiryDate")));
                jumioIDResult.setDocumentNumber(mo171982a(jSONObject2.optString("documentNumber")));
                jumioIDResult.setPersonalNumber(mo171982a(jSONObject2.optString("personalNumber")));
                jumioIDResult.setGender(mo171982a(jSONObject2.optString("gender")));
                jumioIDResult.setNationality(mo171982a(jSONObject2.optString("nationality")));
                jumioIDResult.setPlaceOfBirth(mo171982a(jSONObject2.optString("placeOfBirth")));
                jumioIDResult.setCountry(mo171982a(jSONObject2.optString("country")));
                jumioIDResult.setAddress(mo171982a(jSONObject2.optString("address")));
                jumioIDResult.setCity(mo171982a(jSONObject2.optString("city")));
                jumioIDResult.setSubdivision(mo171982a(jSONObject2.optString("subdivision")));
                jumioIDResult.setPostalCode(mo171982a(jSONObject2.optString("postalCode")));
                jumioIDResult.setMrzLine1(mo171982a(jSONObject2.optString("mrzLine1")));
                jumioIDResult.setMrzLine2(mo171982a(jSONObject2.optString("mrzLine2")));
                jumioIDResult.setMrzLine3(mo171982a(jSONObject2.optString("mrzLine3")));
                jumioIDResult.setRawBarcodeData(mo171982a(jSONObject2.optString("rawBarcodeData")));
                hashMap.put(next, jumioIDResult);
            }
        } catch (Exception e) {
            Log.m43666w(this.TAG, "Exception", (Throwable) e);
        }
        return hashMap;
    }

    public String getRequest() throws Exception {
        return "";
    }

    public String getUri() {
        return StringDeobfuscator.deobfuscate(new byte[]{101, -35, -99, -103, -74, 101, -119, -9, 114, 4, -53, 7, 35, 94, 39, -23, Ascii.CAN, 5, 82, 40}, 1493473626205255869L);
    }
}
