package com.didi.sdk.misconfig.p154v2.impl;

import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.bff.BffConstants;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.p154v2.model.PriConfModel;
import com.didi.sdk.misconfig.p154v2.model.PriConfRsp;
import com.didi.sdk.misconfig.p154v2.store.PriConfRepository;
import com.didi.sdk.misconfig.p154v2.utils.ConfUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.sdk.misconfig.v2.impl.PriConfRequest */
public class PriConfRequest {

    /* renamed from: a */
    private Logger f39625a = LoggerFactory.getLogger("PriConfRequest");

    /* renamed from: b */
    private PriConfRepository f39626b;

    /* renamed from: c */
    private CityChangedNotifier f39627c;

    public PriConfRequest(PriConfRepository priConfRepository, CityChangedNotifier cityChangedNotifier) {
        this.f39626b = priConfRepository;
        this.f39627c = cityChangedNotifier;
    }

    public void requestWithOutSave(double d, double d2, final RpcService.Callback<PriConfModel> callback) {
        m29837a(d, d2, (RpcService.Callback<JsonObject>) new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                PriConfRsp priConfRsp = (PriConfRsp) new Gson().fromJson((JsonElement) jsonObject, PriConfRsp.class);
                if (priConfRsp == null || priConfRsp.getErrno() != 0 || priConfRsp.getData() == null) {
                    callback.onFailure(new IOException());
                }
            }

            public void onFailure(IOException iOException) {
                callback.onFailure(iOException);
            }
        });
    }

    public void request(double d, double d2, final int i, final int i2) {
        m29837a(d, d2, (RpcService.Callback<JsonObject>) new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                HashMap hashMap = new HashMap();
                hashMap.put("type", "bottomlead_success");
                OmegaSDKAdapter.trackEvent("tech_bottomlead_get", (Map<String, Object>) hashMap);
                PriConfRequest.this.m29841a(jsonObject, i, i2);
            }

            public void onFailure(IOException iOException) {
                PriConfRequest.this.m29838a(i, i2);
            }
        });
    }

    /* renamed from: a */
    private void m29837a(double d, double d2, RpcService.Callback<JsonObject> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("lat", Double.valueOf(d2));
        hashMap.put("lng", Double.valueOf(d));
        Bff.call(new IBffProxy.Ability.Builder(DIDIApplication.getAppContext(), BffConstants.AbilityID.ABILITY_PRIMARY_CONF).setParams(hashMap).setCallback(callback).build());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29841a(JsonObject jsonObject, int i, int i2) {
        PriConfRsp priConfRsp = (PriConfRsp) new Gson().fromJson((JsonElement) jsonObject, PriConfRsp.class);
        if (priConfRsp == null || priConfRsp.getErrno() != 0 || priConfRsp.getData() == null) {
            m29838a(i, i2);
            return;
        }
        PriConfModel data = priConfRsp.getData();
        boolean z = false;
        if (!this.f39626b.getCurVersion().equals(data.getCurVersion())) {
            this.f39626b.saveConfig(data, jsonObject.toString());
            if (this.f39626b.getCityId() != data.getCityId()) {
                this.f39627c.dispatchCityChangeEvent(this.f39626b.getCityId(), data.getCityId());
                this.f39626b.saveCityId(data.getCityId());
            }
            z = true;
        }
        ConfUtil.dispatchMisFromUpdate(1, i2, z);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29838a(int i, int i2) {
        if (this.f39626b.getConfigFromCache(i) != null) {
            ConfUtil.dispatchMisFromUpdate(2, i2, true);
        } else {
            ConfUtil.dispatchCarInfoUpdate(-1, i2, false);
        }
    }
}
