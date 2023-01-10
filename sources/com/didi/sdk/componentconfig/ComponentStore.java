package com.didi.sdk.componentconfig;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.common.map.model.LatLng;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.bff.BffConstants;
import com.didi.sdk.bff.BffUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.store.BaseStore;
import com.didi.sdk.util.SingletonHolder;
import com.didi.sdk.util.TextUtil;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComponentStore extends BaseStore {
    public static final String EVENT = "Component_Config_Event";

    /* renamed from: b */
    private static final String f38444b = "component_store_sp";

    /* renamed from: c */
    private static final String f38445c = "framework-ComponentStore";

    /* renamed from: d */
    private static final String f38446d = "component_version";

    /* renamed from: e */
    private static final String f38447e = "component_cityId";

    /* renamed from: f */
    private static final String f38448f = "component_data";

    /* renamed from: g */
    private static final String f38449g = "timer,201";

    /* renamed from: a */
    private Logger f38450a = LoggerFactory.getLogger("ComponentStore");

    /* renamed from: h */
    private Object f38451h = new Object();

    /* renamed from: i */
    private Context f38452i;

    /* renamed from: j */
    private String f38453j;

    /* renamed from: k */
    private String f38454k;

    /* renamed from: l */
    private SharedPreferences f38455l;

    /* renamed from: m */
    private ComponentConfigInfo f38456m;

    /* renamed from: a */
    private String m28997a(int i) {
        if (i == 0) {
            return "wgs84";
        }
        if (i == 1) {
        }
        return "soso";
    }

    private ComponentStore() {
        super(f38445c);
    }

    public static ComponentStore getInstance() {
        return (ComponentStore) SingletonHolder.getInstance(ComponentStore.class);
    }

    public void init(Context context) {
        this.f38452i = context;
        this.f38455l = SystemUtils.getSharedPreferences(context, f38444b, 0);
        this.f38454k = m29006c(f38447e);
        this.f38453j = m29006c(f38446d);
    }

    public ComponentConfigInfo getConfigInfoFromLocal() {
        ComponentConfigInfo parse;
        synchronized (this.f38451h) {
            parse = ComponentConfigInfo.parse((String) get(f38448f));
            this.f38456m = parse;
        }
        return parse;
    }

    public ComponentConfigInfo getComponentInfo() {
        ComponentConfigInfo componentConfigInfo;
        synchronized (this.f38451h) {
            componentConfigInfo = this.f38456m;
        }
        return componentConfigInfo;
    }

    /* renamed from: a */
    private static int m28996a(String str) {
        try {
            if (TextUtil.isEmpty(str)) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public void getComponentConfig(String str, LatLng latLng) {
        if (this.f38456m == null || !str.equals(this.f38454k)) {
            DIDILocation lastLocation = LocationPerformer.getInstance().getLastLocation();
            String a = lastLocation != null ? m28997a(lastLocation.getCoordinateType()) : "soso";
            ComponentService componentService = (ComponentService) new RpcServiceFactory(this.f38452i).newRpcService(ComponentService.class, ComponentParams.URL);
            HashMap<String, Object> createParams = ComponentParams.createParams(this.f38452i, a, f38449g, "" + latLng.latitude, "" + latLng.longitude);
            if (BffUtils.isBffStageNewFifth()) {
                HashMap hashMap = new HashMap();
                hashMap.put(ComponentParams.PARAMS_FLAT, Double.valueOf(latLng.latitude));
                hashMap.put(ComponentParams.PARAMS_FLNG, Double.valueOf(latLng.longitude));
                hashMap.put(ComponentParams.PARAMS_CID, f38449g);
                Bff.call(new IBffProxy.Ability.Builder(this.f38452i, BffConstants.AbilityID.ABILITY_API_COMPONENT).setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
                    public void onSuccess(JsonObject jsonObject) {
                        ComponentStore.this.m29005b(jsonObject.get("data").getAsJsonObject().toString());
                    }

                    public void onFailure(IOException iOException) {
                        ComponentStore.this.m28998a();
                    }
                }).build());
                return;
            }
            componentService.getComponentConfig(createParams, new RpcService.Callback<String>() {
                public void onSuccess(String str) {
                    ComponentStore.this.m29005b(str);
                }

                public void onFailure(IOException iOException) {
                    ComponentStore.this.m28998a();
                }
            });
            return;
        }
        this.f38450a.infoEvent("ComponentStore", "ComponentStore", "getComponentConfig cid" + this.f38454k);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m29005b(String str) {
        synchronized (this.f38451h) {
            ComponentConfigInfo parse = ComponentConfigInfo.parse(str);
            this.f38456m = parse;
            m28999a(parse);
        }
        m29007c();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28998a() {
        Logger logger = this.f38450a;
        logger.infoEvent("ComponentStore", "ComponentStore", "getComponentConfig onFailure cityid=" + this.f38454k);
        m29004b();
    }

    /* renamed from: a */
    private void m28999a(ComponentConfigInfo componentConfigInfo) {
        if (componentConfigInfo != null) {
            this.f38453j = componentConfigInfo.version;
            this.f38454k = componentConfigInfo.cityId;
            m29002a(f38447e, componentConfigInfo.cityId);
            m29002a(f38446d, componentConfigInfo.version);
            putAndSave(this.f38452i, f38448f, componentConfigInfo.data);
        }
    }

    /* renamed from: b */
    private void m29004b() {
        synchronized (this.f38451h) {
            m29002a(f38447e, "");
            m29002a(f38446d, "");
            remove(f38448f);
        }
    }

    /* renamed from: c */
    private void m29007c() {
        synchronized (this.f38451h) {
            if (this.f38456m == null) {
                Logger logger = this.f38450a;
                logger.infoEvent("ComponentStore", "ComponentStore", "dispatchConfigEvent no " + this.f38454k);
                return;
            }
            Logger logger2 = this.f38450a;
            logger2.infoEvent("ComponentStore", "ComponentStore", "dispatchConfigEvent  " + this.f38454k);
            dispatchEvent(new ComponentConfigEvent(EVENT));
        }
    }

    /* renamed from: a */
    private void m29002a(String str, String str2) {
        this.f38455l.edit().putString(str, str2).apply();
    }

    /* renamed from: c */
    private String m29006c(String str) {
        return this.f38455l.getString(str, "");
    }

    /* renamed from: d */
    private Map<String, List<ConfigItem>> m29008d(String str) {
        ComponentConfigInfo componentConfigInfo = this.f38456m;
        if (componentConfigInfo != null && componentConfigInfo.data == null) {
        }
        return null;
    }

    public List<ConfigItem> getConfigs(String str, String str2) {
        Map<String, List<ConfigItem>> d = m29008d(str);
        if (d != null && d.containsKey(str2)) {
            return d.get(str2);
        }
        return null;
    }

    public ConfigItem getConfig(ComponentParam componentParam) {
        List<ConfigItem> configs;
        if (componentParam == null || TextUtils.isEmpty(componentParam.componentId) || TextUtils.isEmpty(componentParam.productId) || (configs = getConfigs(componentParam.componentId, componentParam.productId)) == null) {
            return null;
        }
        for (ConfigItem next : configs) {
            if (next != null && m29003a(next, componentParam)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m29003a(ConfigItem configItem, ComponentParam componentParam) {
        if (componentParam.carLevel != -1 && configItem.carLevel != componentParam.carLevel) {
            return false;
        }
        if (componentParam.orderType != -1 && configItem.orderType != componentParam.orderType) {
            return false;
        }
        if (TextUtils.isEmpty(componentParam.sceneType) || TextUtils.equals(configItem.scene, componentParam.sceneType)) {
            return true;
        }
        return false;
    }
}
