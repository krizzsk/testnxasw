package com.didi.sdk.paxadsdk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.didi.sdk.paxadsdk.agency.AdAgency;
import com.didi.sdk.paxadsdk.agency.admob.AdmobLoader;
import com.didi.sdk.paxadsdk.listener.AdLoadListenner;
import com.didi.sdk.paxadsdk.listener._AdLoadListennerWrapper;
import com.didi.sdk.paxadsdk.model.AdModel;
import com.didi.sdk.paxadsdk.model.AdTraceInfo;
import com.didi.sdk.paxadsdk.repo.AdCacheManager;
import com.didi.sdk.paxadsdk.utils.AdLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class GlobalAdManager {

    /* renamed from: a */
    private Map<String, AdAgency> f39684a;

    /* renamed from: b */
    private boolean f39685b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map<String, AdLoadListenner> f39686c;

    /* renamed from: d */
    private AdCacheManager f39687d;

    /* renamed from: e */
    private AdLoaderConfig f39688e;

    private GlobalAdManager() {
        this.f39684a = new HashMap();
        this.f39685b = false;
        this.f39686c = new ConcurrentHashMap();
        this.f39687d = new AdCacheManager();
    }

    public static GlobalAdManager getInstance() {
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final GlobalAdManager sInstance = new GlobalAdManager();

        private SingletonHolder() {
        }
    }

    public void initial(Context context, AdLoaderConfig adLoaderConfig) {
        if (!this.f39685b) {
            this.f39688e = adLoaderConfig;
            AdmobLoader admobLoader = new AdmobLoader();
            this.f39684a.put(admobLoader.getName().toLowerCase(Locale.ROOT), admobLoader);
            for (AdAgency init : this.f39684a.values()) {
                init.init(context);
            }
            this.f39685b = true;
        }
    }

    public AdLoaderConfig getConfig() {
        return this.f39688e;
    }

    /* renamed from: a */
    private AdAgency m29873a(String str) {
        if (str == null) {
            return null;
        }
        return this.f39684a.get(str.trim().toLowerCase(Locale.ROOT));
    }

    public void loadNativeAD(Context context, NativeAdStyle nativeAdStyle, List<AdModel> list, JSONObject jSONObject, AdLoadListenner adLoadListenner) {
        if (list != null && list.size() > 0) {
            for (AdModel adid : list) {
                this.f39686c.put(adid.getAdid(), adLoadListenner);
            }
            boolean z = false;
            Iterator<AdModel> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AdModel next = it.next();
                AdAgency a = m29873a(next.getAgency());
                if (a != null && a.isLoading(next.getAdid())) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                m29875a(context, nativeAdStyle, list, 0, jSONObject, new AdLoadListenner() {
                    public void onSuccess(View view, AdTraceInfo adTraceInfo) {
                        if (GlobalAdManager.this.f39686c.get(adTraceInfo.adid) != null) {
                            ((AdLoadListenner) GlobalAdManager.this.f39686c.get(adTraceInfo.adid)).onSuccess(view, adTraceInfo);
                        }
                    }

                    public void onFailed(String str, String str2, AdTraceInfo adTraceInfo) {
                        if (GlobalAdManager.this.f39686c.get(adTraceInfo.adid) != null) {
                            ((AdLoadListenner) GlobalAdManager.this.f39686c.get(adTraceInfo.adid)).onFailed(str, str2, adTraceInfo);
                        }
                    }

                    public void onAdClosed(AdTraceInfo adTraceInfo) {
                        if (GlobalAdManager.this.f39686c.get(adTraceInfo.adid) != null) {
                            ((AdLoadListenner) GlobalAdManager.this.f39686c.get(adTraceInfo.adid)).onAdClosed(adTraceInfo);
                        }
                    }

                    public void onAdOpened(AdTraceInfo adTraceInfo) {
                        if (GlobalAdManager.this.f39686c.get(adTraceInfo.adid) != null) {
                            ((AdLoadListenner) GlobalAdManager.this.f39686c.get(adTraceInfo.adid)).onAdOpened(adTraceInfo);
                        }
                    }

                    public void onAdLoaded(AdTraceInfo adTraceInfo) {
                        if (GlobalAdManager.this.f39686c.get(adTraceInfo.adid) != null) {
                            ((AdLoadListenner) GlobalAdManager.this.f39686c.get(adTraceInfo.adid)).onAdLoaded(adTraceInfo);
                        }
                    }

                    public void onAdClicked(AdTraceInfo adTraceInfo) {
                        if (GlobalAdManager.this.f39686c.get(adTraceInfo.adid) != null) {
                            ((AdLoadListenner) GlobalAdManager.this.f39686c.get(adTraceInfo.adid)).onAdClicked(adTraceInfo);
                        }
                    }

                    public void onAdImpression(AdTraceInfo adTraceInfo) {
                        if (GlobalAdManager.this.f39686c.get(adTraceInfo.adid) != null) {
                            ((AdLoadListenner) GlobalAdManager.this.f39686c.get(adTraceInfo.adid)).onAdImpression(adTraceInfo);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29875a(Context context, NativeAdStyle nativeAdStyle, List<AdModel> list, int i, JSONObject jSONObject, AdLoadListenner adLoadListenner) {
        if (list == null || list.size() <= 0 || i >= list.size()) {
            return;
        }
        AdModel adModel = list.get(i);
        if (TextUtils.isEmpty(adModel.getAgency()) || TextUtils.isEmpty(adModel.getAdid()) || nativeAdStyle == null) {
            AdLogger.m29884e("empty agency or adid or style");
            return;
        }
        AdAgency a = m29873a(adModel.getAgency());
        if (a != null) {
            AdTraceInfo adTraceInfo = new AdTraceInfo();
            try {
                adTraceInfo.log_data = new JSONObject(jSONObject.toString());
                adTraceInfo.extraJSON = adModel.toJSONObject();
                Iterator<String> keys = adTraceInfo.extraJSON.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    adTraceInfo.log_data.put(next, adTraceInfo.extraJSON.get(next));
                }
                JSONObject jSONObject2 = jSONObject;
            } catch (JSONException e) {
                adTraceInfo.log_data = jSONObject;
                adTraceInfo.extraJSON = adModel.toJSONObject();
                e.printStackTrace();
            }
            adTraceInfo.agency = adModel.getAgency();
            adTraceInfo.adid = adModel.getAdid();
            final Context context2 = context;
            final NativeAdStyle nativeAdStyle2 = nativeAdStyle;
            final List<AdModel> list2 = list;
            final int i2 = i;
            final JSONObject jSONObject3 = jSONObject;
            final AdLoadListenner adLoadListenner2 = adLoadListenner;
            a.loadNativeAD(context, nativeAdStyle, adModel.getAdid(), adTraceInfo, new _AdLoadListennerWrapper(adLoadListenner) {
                public void onFailed(String str, String str2, AdTraceInfo adTraceInfo) {
                    super.onFailed(str, str2, adTraceInfo);
                    GlobalAdManager.this.m29875a(context2, nativeAdStyle2, list2, i2 + 1, jSONObject3, adLoadListenner2);
                }
            });
        }
    }

    public View foundCacheByAdids(List<String> list) {
        return this.f39687d.matchCachedNativeAdView(list);
    }

    public View foundCacheByAdid(String str) {
        return this.f39687d.matchCachedNativeAdView(str);
    }

    public void saveCache(String str, View view) {
        this.f39687d.cacheNativeAdView(str, view);
    }

    public void clearCache() {
        this.f39687d.clearCache();
    }

    public void release(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AdLogger.m29884e("release with empty args ");
            return;
        }
        for (String next : this.f39686c.keySet()) {
            if (next.startsWith(str2)) {
                this.f39686c.remove(next);
            }
        }
    }

    public void releaseAll() {
        this.f39686c.clear();
    }
}
