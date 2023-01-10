package com.didi.component.substitute.call.present;

import android.text.TextUtils;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(mo148867d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo148868d2 = {"com/didi/component/substitute/call/present/SubstituteCallPresent$reqCallback$1", "Lcom/didi/xengine/callback/XEReqJSONParamsCallbackImpl;", "getRequestParams", "Lorg/json/JSONObject;", "comp-substitute-call_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SubstituteCallPresent.kt */
public final class SubstituteCallPresent$reqCallback$1 extends XEReqJSONParamsCallbackImpl {
    final /* synthetic */ SubstituteCallPresent this$0;

    SubstituteCallPresent$reqCallback$1(SubstituteCallPresent substituteCallPresent) {
        this.this$0 = substituteCallPresent;
    }

    public JSONObject getRequestParams() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.this$0.f17969a);
        if (!TextUtils.isEmpty(this.this$0.f17970b)) {
            jSONObject.put("name", this.this$0.f17970b);
        }
        if (!TextUtils.isEmpty(this.this$0.f17971c)) {
            jSONObject.put("phone", this.this$0.f17971c);
        }
        if (this.this$0.f17972d != 0) {
            jSONObject.put("id", this.this$0.f17972d);
        }
        if (!TextUtils.isEmpty(this.this$0.f17973e)) {
            jSONObject.put("country_code", this.this$0.f17973e);
        }
        return jSONObject;
    }
}
