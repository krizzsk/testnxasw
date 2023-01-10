package com.didi.component.business.secondconf;

import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.component.business.constant.BffConstants;
import com.didi.component.business.secondconf.model.RideConfModel;
import com.didi.component.business.secondconf.model.RideConfRsp;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.misconfig.p154v2.utils.ConfUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;

public class RideConfRequest {

    /* renamed from: a */
    private RideConfRepository f13181a;

    public RideConfRequest(RideConfRepository rideConfRepository) {
        this.f13181a = rideConfRepository;
    }

    public void request(double d, double d2, final int i, final int i2) {
        m11046a(d, d2, (RpcService.Callback<JsonObject>) new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                RideConfRequest.this.m11050a(jsonObject, i, i2);
            }

            public void onFailure(IOException iOException) {
                RideConfRequest.this.m11047a(i2);
            }
        });
    }

    /* renamed from: a */
    private void m11046a(double d, double d2, RpcService.Callback<JsonObject> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("lat", Double.valueOf(d2));
        hashMap.put("lng", Double.valueOf(d));
        Bff.call(new IBffProxy.Ability.Builder(DIDIApplication.getAppContext(), BffConstants.AbilityID.ABILITY_SECOND_CONF).setParams(hashMap).setCallback(callback).build());
    }

    public void requestWithOutSave(double d, double d2, final RpcService.Callback<RideConfRsp> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("lat", Double.valueOf(d2));
        hashMap.put("lng", Double.valueOf(d));
        Bff.call(new IBffProxy.Ability.Builder(DIDIApplication.getAppContext(), BffConstants.AbilityID.ABILITY_SECOND_CONF).setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                callback.onSuccess((RideConfRsp) new Gson().fromJson((JsonElement) jsonObject, RideConfRsp.class));
            }

            public void onFailure(IOException iOException) {
                callback.onFailure(iOException);
            }
        }).build());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11050a(JsonObject jsonObject, int i, int i2) {
        RideConfRsp rideConfRsp = (RideConfRsp) new Gson().fromJson((JsonElement) jsonObject, RideConfRsp.class);
        if (rideConfRsp == null || rideConfRsp.getErrno() != 0 || rideConfRsp.getData() == null) {
            m11047a(i2);
            return;
        }
        RideConfModel data = rideConfRsp.getData();
        RideConfRepository rideConfRepository = this.f13181a;
        if (rideConfRepository != null && !rideConfRepository.getCurVersion().equals(data.getCurVersion())) {
            this.f13181a.saveConfig(data, jsonObject.toString());
        }
        ConfUtil.dispatchCarInfoUpdate(1, i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11047a(int i) {
        if (this.f13181a.getConfigFromCache() != null) {
            ConfUtil.dispatchCarInfoUpdate(2, i);
        } else {
            ConfUtil.dispatchCarInfoUpdate(-1, i);
        }
    }
}
