package com.adyen.checkout.adyen3ds2.model;

import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtilsKt;
import com.adyen.checkout.core.model.ModelObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo148867d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, mo148868d2 = {"com/adyen/checkout/adyen3ds2/model/SubmitFingerprintRequest$Companion$SERIALIZER$1", "Lcom/adyen/checkout/core/model/ModelObject$Serializer;", "Lcom/adyen/checkout/adyen3ds2/model/SubmitFingerprintRequest;", "deserialize", "jsonObject", "Lorg/json/JSONObject;", "serialize", "modelObject", "3ds2_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SubmitFingerprintRequest.kt */
public final class SubmitFingerprintRequest$Companion$SERIALIZER$1 implements ModelObject.Serializer<SubmitFingerprintRequest> {
    SubmitFingerprintRequest$Companion$SERIALIZER$1() {
    }

    public JSONObject serialize(SubmitFingerprintRequest submitFingerprintRequest) {
        Intrinsics.checkNotNullParameter(submitFingerprintRequest, "modelObject");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("fingerprintResult", submitFingerprintRequest.getEncodedFingerprint());
            jSONObject.putOpt("paymentData", submitFingerprintRequest.getPaymentData());
            return jSONObject;
        } catch (JSONException e) {
            throw new ModelSerializationException(SubmitFingerprintRequest.class, e);
        }
    }

    public SubmitFingerprintRequest deserialize(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        try {
            return new SubmitFingerprintRequest(JsonUtilsKt.getStringOrNull(jSONObject, "fingerprintResult"), JsonUtilsKt.getStringOrNull(jSONObject, "paymentData"));
        } catch (JSONException e) {
            throw new ModelSerializationException(SubmitFingerprintRequest.class, e);
        }
    }
}
