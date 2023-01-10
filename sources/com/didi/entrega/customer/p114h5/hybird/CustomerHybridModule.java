package com.didi.entrega.customer.p114h5.hybird;

import android.app.Activity;
import android.text.TextUtils;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerOrderManager;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import com.didi.soda.web.model.CallBackModel;
import com.didi.soda.web.tools.WebJsBridgeTool;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didi.entrega.customer.h5.hybird.CustomerHybridModule */
public class CustomerHybridModule extends BaseHybridModule {
    public static final String NAME_SPACE = "sodaEntrega";

    /* renamed from: a */
    private static final String f22025a = "CustomerHybridModule";

    /* renamed from: b */
    private WebViewModelCallback f22026b;

    /* renamed from: c */
    private Activity f22027c;

    public CustomerHybridModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        this.f22027c = hybridableContainer.getActivity();
    }

    @JsInterface({"cancelOrder"})
    public void cancelOrder(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m18185i(f22025a, "cancelOrder");
        if (jSONObject != null) {
            LogUtil.m18185i(f22025a, jSONObject.toString());
            try {
                String string = jSONObject.getString("orderId");
                String string2 = jSONObject.getString("status");
                String optString = jSONObject.optString("statusDesc");
                String optString2 = jSONObject.optString("statusSubDesc");
                LogUtil.m18185i(f22025a, "orderId=" + string + " status" + string2 + " statusDesc=" + optString + "/" + optString2);
                int parseInt = Integer.parseInt(string2);
                if (!TextUtils.isEmpty(string) && parseInt == 1900) {
                    ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).requestOrderInfoById(string, 6);
                }
                if (callbackFunction == null) {
                    return;
                }
                if (!TextUtils.isEmpty(string)) {
                    callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
                    return;
                }
                callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, "param[orderId] is empty", (JSONObject) null)));
            } catch (JSONException e) {
                e.printStackTrace();
                if (callbackFunction != null) {
                    callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, e.getMessage(), (JSONObject) null)));
                }
            }
        }
    }

    public void setWebViewCallback(WebViewModelCallback webViewModelCallback) {
        this.f22026b = webViewModelCallback;
    }

    @JsInterface({"selectCoupon"})
    public void selectCoupon(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m18185i(f22025a, "selectCoupon");
        if (jSONObject != null) {
            LogUtil.m18185i(f22025a, jSONObject.toString());
            try {
                String string = jSONObject.getString("coupon_id");
                int optInt = jSONObject.optInt("bill_coupon_type", 0);
                String optString = jSONObject.optString("relate_id", "");
                if (this.f22026b != null) {
                    this.f22026b.selectCoupon(string, optInt, optString);
                }
                if (callbackFunction != null) {
                    callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
                }
            } catch (JSONException e) {
                e.printStackTrace();
                if (callbackFunction != null) {
                    callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, e.getMessage(), (JSONObject) null)));
                }
            }
        }
    }
}
