package com.didiglobal.p205sa.biz.component.recommend;

import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didichuxing.omega.sdk.Omega;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(mo148867d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo148868d2 = {"com/didiglobal/sa/biz/component/recommend/RecommendPresenter$paramCallback$1", "Lcom/didi/xengine/callback/XEReqJSONParamsCallbackImpl;", "getRequestParams", "Lorg/json/JSONObject;", "biz-library_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.recommend.RecommendPresenter$paramCallback$1 */
/* compiled from: RecommendPresenter.kt */
public final class RecommendPresenter$paramCallback$1 extends XEReqJSONParamsCallbackImpl {
    RecommendPresenter$paramCallback$1() {
    }

    public JSONObject getRequestParams() {
        Map hashMap = new HashMap();
        hashMap.put("omega_id", Omega.getOmegaIdSafety());
        return new JSONObject(hashMap);
    }
}
