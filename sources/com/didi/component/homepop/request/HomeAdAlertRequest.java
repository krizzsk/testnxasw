package com.didi.component.homepop.request;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.component.adalert.AdAlertModel;
import com.didi.component.adalert.HomeAdAlertDialog;
import com.didi.component.business.bff.callback_adapter.BffTravelCallbackAdapter;
import com.didi.component.business.constant.BffConstants;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.BaseMainActivity;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.paxadsdk.GlobalAdManager;
import com.didi.sdk.paxadsdk.NativeAdStyle;
import com.didi.sdk.paxadsdk.listener.AdLoadListenner;
import com.didi.sdk.paxadsdk.model.AdModel;
import com.didi.sdk.paxadsdk.model.AdTraceInfo;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import java.util.List;
import org.json.JSONObject;

public class HomeAdAlertRequest implements HomePopupRequest {
    protected Logger mLogger = LoggerFactory.getLogger("HomeAdAlertRequest");

    public void cancelGroup() {
    }

    public void closeWindow() {
    }

    public void requestByService(final Context context, String str) {
        Bff.call(new IBffProxy.Ability.Builder(context, BffConstants.AbilityID.ABILITY_HOME_AD_ALERT).setCallback(new BffTravelCallbackAdapter(new ResponseListener<AdAlertModel>() {
            public void onSuccess(AdAlertModel adAlertModel) {
                super.onSuccess(adAlertModel);
                HomeAdAlertRequest.this.mLogger.info("request bff ad onSuccess ", new Object[0]);
                if (adAlertModel != null && adAlertModel.list != null && adAlertModel.list.size() != 0) {
                    HomeAdAlertRequest.this.m13266a(context, adAlertModel.list, adAlertModel.mLogData);
                }
            }

            public void onError(AdAlertModel adAlertModel) {
                super.onError(adAlertModel);
                HomeAdAlertRequest.this.mLogger.info("request bff ad onError ", new Object[0]);
            }

            public void onFail(AdAlertModel adAlertModel) {
                super.onFail(adAlertModel);
                HomeAdAlertRequest.this.mLogger.info("request bff ad onFail ", new Object[0]);
            }
        }, context)).setServiceId(str).build());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13266a(final Context context, List<AdModel> list, JSONObject jSONObject) {
        GlobalAdManager.getInstance().loadNativeAD(context, NativeAdStyle.Dialog, list, jSONObject, new AdLoadListenner() {
            public void onAdClosed(AdTraceInfo adTraceInfo) {
            }

            public void onAdLoaded(AdTraceInfo adTraceInfo) {
            }

            public void onAdOpened(AdTraceInfo adTraceInfo) {
            }

            public void onFailed(String str, String str2, AdTraceInfo adTraceInfo) {
            }

            public void onSuccess(View view, AdTraceInfo adTraceInfo) {
                HomeAdAlertRequest.this.mLogger.info("load ad success ", new Object[0]);
                if (ActivityLifecycleManager.getInstance().getCurrentActivity() instanceof BaseMainActivity) {
                    new HomeAdAlertDialog().build().setAdView(adTraceInfo, view).show(((FragmentActivity) context).getSupportFragmentManager(), "mHomeAdAlertDialog");
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.util.Map} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onAdClicked(com.didi.sdk.paxadsdk.model.AdTraceInfo r4) {
                /*
                    r3 = this;
                    if (r4 == 0) goto L_0x003d
                    org.json.JSONObject r0 = r4.log_data
                    if (r0 == 0) goto L_0x003d
                    com.google.gson.JsonParser r0 = new com.google.gson.JsonParser     // Catch:{ Exception -> 0x0039 }
                    r0.<init>()     // Catch:{ Exception -> 0x0039 }
                    org.json.JSONObject r1 = r4.log_data     // Catch:{ Exception -> 0x0039 }
                    java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0039 }
                    com.google.gson.JsonElement r0 = r0.parse((java.lang.String) r1)     // Catch:{ Exception -> 0x0039 }
                    com.google.gson.JsonObject r0 = (com.google.gson.JsonObject) r0     // Catch:{ Exception -> 0x0039 }
                    java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x0039 }
                    r1.<init>()     // Catch:{ Exception -> 0x0039 }
                    if (r0 == 0) goto L_0x0033
                    com.google.gson.Gson r1 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0039 }
                    r1.<init>()     // Catch:{ Exception -> 0x0039 }
                    com.didi.component.homepop.request.HomeAdAlertRequest$2$1 r2 = new com.didi.component.homepop.request.HomeAdAlertRequest$2$1     // Catch:{ Exception -> 0x0039 }
                    r2.<init>()     // Catch:{ Exception -> 0x0039 }
                    java.lang.reflect.Type r2 = r2.getType()     // Catch:{ Exception -> 0x0039 }
                    java.lang.Object r0 = r1.fromJson((com.google.gson.JsonElement) r0, (java.lang.reflect.Type) r2)     // Catch:{ Exception -> 0x0039 }
                    r1 = r0
                    java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x0039 }
                L_0x0033:
                    java.lang.String r0 = "ibt_gp_commonmodule_btn_ck"
                    com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.Object>) r1)     // Catch:{ Exception -> 0x0039 }
                    goto L_0x003d
                L_0x0039:
                    r0 = move-exception
                    r0.printStackTrace()
                L_0x003d:
                    android.content.Context r0 = r7
                    androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
                    androidx.fragment.app.FragmentManager r0 = r0.getSupportFragmentManager()
                    java.lang.String r1 = "mHomeAdAlertDialog"
                    androidx.fragment.app.Fragment r0 = r0.findFragmentByTag(r1)
                    if (r0 == 0) goto L_0x0052
                    com.didi.component.adalert.HomeAdAlertDialog r0 = (com.didi.component.adalert.HomeAdAlertDialog) r0
                    r0.dismiss()
                L_0x0052:
                    if (r4 == 0) goto L_0x005f
                    com.didi.sdk.paxadsdk.GlobalAdManager r0 = com.didi.sdk.paxadsdk.GlobalAdManager.getInstance()
                    java.lang.String r1 = r4.agency
                    java.lang.String r4 = r4.adid
                    r0.release(r1, r4)
                L_0x005f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.component.homepop.request.HomeAdAlertRequest.C65232.onAdClicked(com.didi.sdk.paxadsdk.model.AdTraceInfo):void");
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.util.Map} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onAdImpression(com.didi.sdk.paxadsdk.model.AdTraceInfo r3) {
                /*
                    r2 = this;
                    if (r3 == 0) goto L_0x003d
                    org.json.JSONObject r0 = r3.log_data
                    if (r0 == 0) goto L_0x003d
                    com.google.gson.JsonParser r0 = new com.google.gson.JsonParser     // Catch:{ Exception -> 0x0039 }
                    r0.<init>()     // Catch:{ Exception -> 0x0039 }
                    org.json.JSONObject r3 = r3.log_data     // Catch:{ Exception -> 0x0039 }
                    java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0039 }
                    com.google.gson.JsonElement r3 = r0.parse((java.lang.String) r3)     // Catch:{ Exception -> 0x0039 }
                    com.google.gson.JsonObject r3 = (com.google.gson.JsonObject) r3     // Catch:{ Exception -> 0x0039 }
                    java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x0039 }
                    r0.<init>()     // Catch:{ Exception -> 0x0039 }
                    if (r3 == 0) goto L_0x0033
                    com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0039 }
                    r0.<init>()     // Catch:{ Exception -> 0x0039 }
                    com.didi.component.homepop.request.HomeAdAlertRequest$2$2 r1 = new com.didi.component.homepop.request.HomeAdAlertRequest$2$2     // Catch:{ Exception -> 0x0039 }
                    r1.<init>()     // Catch:{ Exception -> 0x0039 }
                    java.lang.reflect.Type r1 = r1.getType()     // Catch:{ Exception -> 0x0039 }
                    java.lang.Object r3 = r0.fromJson((com.google.gson.JsonElement) r3, (java.lang.reflect.Type) r1)     // Catch:{ Exception -> 0x0039 }
                    r0 = r3
                    java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x0039 }
                L_0x0033:
                    java.lang.String r3 = "ibt_gp_commonmodule_sw"
                    com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r3, (java.util.Map<java.lang.String, java.lang.Object>) r0)     // Catch:{ Exception -> 0x0039 }
                    goto L_0x003d
                L_0x0039:
                    r3 = move-exception
                    r3.printStackTrace()
                L_0x003d:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.component.homepop.request.HomeAdAlertRequest.C65232.onAdImpression(com.didi.sdk.paxadsdk.model.AdTraceInfo):void");
            }
        });
    }
}
