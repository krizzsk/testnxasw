package com.didi.component.comp_new_xpanel.template;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import com.didi.component.comp_new_xpanel.AbsNewXPanelPresenter;
import com.didi.component.comp_new_xpanel.template.XpTemplateAdCardModel;
import com.didi.sdk.log.Logger;
import com.didi.sdk.paxadsdk.GlobalAdManager;
import com.didi.sdk.paxadsdk.NativeAdStyle;
import com.didi.sdk.paxadsdk.listener.AdLoadListenner;
import com.didi.sdk.paxadsdk.model.AdTraceInfo;
import com.didi.soda.compose.card.BaseCard;
import com.didiglobal.enginecore.template.temp.IXEView;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class XpTemplateAdCardView implements IXEView<XpTemplateAdCardModel> {

    /* renamed from: a */
    private static final String f14149a = "XpTemplateAdCardView";

    /* renamed from: b */
    private Context f14150b;

    /* renamed from: c */
    private View f14151c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CardView f14152d;

    public void initView(Context context) {
        this.f14150b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.g_xp_template_ad_card, (ViewGroup) null);
        this.f14151c = inflate;
        this.f14152d = (CardView) inflate.findViewById(R.id.ad_container);
    }

    public void bindData(final XpTemplateAdCardModel xpTemplateAdCardModel) {
        if (xpTemplateAdCardModel == null || xpTemplateAdCardModel.normal == null || xpTemplateAdCardModel.normal.data == null || xpTemplateAdCardModel.normal.data.ads == null || xpTemplateAdCardModel.normal.data.ads.size() <= 0) {
            this.f14151c.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (XpTemplateAdCardModel.AdModelWrapper next : xpTemplateAdCardModel.normal.data.ads) {
            if (!(next.data == null || next.data.getAdid() == null)) {
                arrayList2.add(next.data);
                arrayList.add(next.data.getAdid());
            }
        }
        View foundCacheByAdids = GlobalAdManager.getInstance().foundCacheByAdids(arrayList);
        if (foundCacheByAdids != null) {
            if (foundCacheByAdids.getParent() != null) {
                Logger.m29536d("admob", "last cached view has parent");
                ((ViewGroup) foundCacheByAdids.getParent()).removeView(foundCacheByAdids);
            }
            Logger.m29536d("admob", "add last cached view");
            this.f14152d.removeAllViews();
            this.f14152d.addView(foundCacheByAdids);
            return;
        }
        JSONObject jSONObject = null;
        if (!(xpTemplateAdCardModel.extension == null || xpTemplateAdCardModel.extension.log_data == null)) {
            jSONObject = xpTemplateAdCardModel.extension.log_data;
        }
        GlobalAdManager.getInstance().loadNativeAD(this.f14150b, NativeAdStyle.Small_CARD, arrayList2, jSONObject, new AdLoadListenner() {
            public void onAdClosed(AdTraceInfo adTraceInfo) {
            }

            public void onAdLoaded(AdTraceInfo adTraceInfo) {
            }

            public void onAdOpened(AdTraceInfo adTraceInfo) {
            }

            public void onFailed(String str, String str2, AdTraceInfo adTraceInfo) {
            }

            public void onSuccess(View view, AdTraceInfo adTraceInfo) {
                Logger.m29539i(XpTemplateAdCardView.f14149a, "load ad success ");
                if (AbsNewXPanelPresenter.entered) {
                    XpTemplateAdCardView.this.f14152d.removeAllViews();
                    XpTemplateAdCardView.this.f14152d.addView(view);
                    GlobalAdManager.getInstance().saveCache(adTraceInfo.adid, view);
                }
            }

            public void onAdClicked(AdTraceInfo adTraceInfo) {
                if (xpTemplateAdCardModel != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(BaseCard.KEY_CARD_ID, xpTemplateAdCardModel.f52708id);
                    if (adTraceInfo != null) {
                        try {
                            if (adTraceInfo.log_data != null) {
                                String jSONObject = adTraceInfo.log_data.toString();
                                HashMap hashMap2 = new HashMap();
                                if (xpTemplateAdCardModel.extension.extra != null) {
                                    for (String str : xpTemplateAdCardModel.extension.extra.keySet()) {
                                        hashMap.put(str, xpTemplateAdCardModel.extension.extra.get(str));
                                    }
                                }
                                hashMap.putAll((Map) new Gson().fromJson((JsonElement) new JsonParser().parse(jSONObject).getAsJsonObject(), hashMap2.getClass()));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    OmegaSDKAdapter.trackEvent("xpanel_card_ck", (Map<String, Object>) hashMap);
                }
            }

            public void onAdImpression(AdTraceInfo adTraceInfo) {
                if (xpTemplateAdCardModel != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(BaseCard.KEY_CARD_ID, xpTemplateAdCardModel.f52708id);
                    if (adTraceInfo != null) {
                        try {
                            if (adTraceInfo.log_data != null) {
                                String jSONObject = adTraceInfo.log_data.toString();
                                HashMap hashMap2 = new HashMap();
                                if (xpTemplateAdCardModel.extension.extra != null) {
                                    for (String str : xpTemplateAdCardModel.extension.extra.keySet()) {
                                        hashMap.put(str, xpTemplateAdCardModel.extension.extra.get(str));
                                    }
                                }
                                hashMap.putAll((Map) new Gson().fromJson((JsonElement) new JsonParser().parse(jSONObject).getAsJsonObject(), hashMap2.getClass()));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    OmegaSDKAdapter.trackEvent("ibt_gp_ad_xpanel_sw", (Map<String, Object>) hashMap);
                }
            }
        });
    }

    public View getView() {
        return this.f14151c;
    }
}
