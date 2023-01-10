package com.didi.dimina.container.bridge;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.page.PageRefreshHelper;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.NavigateUtil;
import org.json.JSONObject;

public class PageRefreshSubJSBridge {

    /* renamed from: a */
    private final DMMina f18513a;

    PageRefreshSubJSBridge(DMMina dMMina) {
        this.f18513a = dMMina;
        LogUtil.m16841i("PageRefreshSubJSBridge init");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo59472a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        DMPage dMPage;
        try {
            dMPage = NavigateUtil.getCurPage(this.f18513a);
        } catch (Exception e) {
            e.printStackTrace();
            dMPage = null;
        }
        if (dMPage == null) {
            JSONObject jSONObject2 = new JSONObject();
            JSONUtil.put(jSONObject2, "success", false);
            callbackFunction.onCallBack(jSONObject2);
            return;
        }
        PageRefreshHelper refreshHelper = dMPage.getRefreshHelper();
        if (refreshHelper != null) {
            refreshHelper.startPullDownRefresh();
        }
        JSONObject jSONObject3 = new JSONObject();
        JSONUtil.put(jSONObject3, "success", true);
        callbackFunction.onCallBack(jSONObject3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo59473b(JSONObject jSONObject, CallbackFunction callbackFunction) {
        DMPage dMPage;
        try {
            dMPage = NavigateUtil.getCurPage(this.f18513a);
        } catch (Exception e) {
            e.printStackTrace();
            dMPage = null;
        }
        if (dMPage == null) {
            JSONObject jSONObject2 = new JSONObject();
            JSONUtil.put(jSONObject2, "success", false);
            callbackFunction.onCallBack(jSONObject2);
            return;
        }
        PageRefreshHelper refreshHelper = dMPage.getRefreshHelper();
        if (refreshHelper != null) {
            refreshHelper.stopPullDownRefresh();
        }
        JSONObject jSONObject3 = new JSONObject();
        JSONUtil.put(jSONObject3, "success", true);
        callbackFunction.onCallBack(jSONObject3);
    }

    public void enablePullDownRefresh(CallbackFunction callbackFunction) {
        m15700a(true, callbackFunction);
    }

    public void disablePullDownRefresh(CallbackFunction callbackFunction) {
        m15700a(false, callbackFunction);
    }

    /* renamed from: a */
    private void m15700a(boolean z, CallbackFunction callbackFunction) {
        DMPage dMPage;
        try {
            dMPage = NavigateUtil.getCurPage(this.f18513a);
        } catch (Exception e) {
            e.printStackTrace();
            dMPage = null;
        }
        if (dMPage == null) {
            JSONObject jSONObject = new JSONObject();
            JSONUtil.put(jSONObject, "success", false);
            callbackFunction.onCallBack(jSONObject);
            return;
        }
        PageRefreshHelper refreshHelper = dMPage.getRefreshHelper();
        if (refreshHelper != null) {
            refreshHelper.setEnablePullRefresh(z);
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "success", true);
        callbackFunction.onCallBack(jSONObject2);
    }
}
