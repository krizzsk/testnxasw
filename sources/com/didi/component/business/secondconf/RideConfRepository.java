package com.didi.component.business.secondconf;

import android.content.Context;
import android.text.TextUtils;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.secondconf.model.RideConfBizModel;
import com.didi.component.business.secondconf.model.RideConfModel;
import com.didi.component.business.secondconf.model.RideConfRsp;
import com.didi.component.common.config.GlobalComponentConfig;
import com.didi.component.config.ComponentsConfig;
import com.didi.sdk.apm.utils.ApmThreadPool;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.misconfig.model.CarInfo;
import com.didi.sdk.store.BaseStore;
import com.didi.sdk.util.AppUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class RideConfRepository extends BaseStore {

    /* renamed from: a */
    private static final String f13177a = "ride_conf";

    /* renamed from: b */
    private String f13178b = "";

    /* renamed from: c */
    private RideConfModel f13179c;

    /* renamed from: d */
    private List<CarInfo> f13180d;

    public RideConfRepository() {
        super("framework-RideConfStore");
        updateConfigFromCache();
    }

    public String getCurVersion() {
        return this.f13178b;
    }

    public RideConfModel getConfModel() {
        return this.f13179c;
    }

    public void saveConfig(RideConfModel rideConfModel, String str) {
        m11044a(rideConfModel);
        putAndSave((Context) DIDIApplication.getAppContext(), f13177a, str);
    }

    public void updateConfigFromCache() {
        ApmThreadPool.execute((Runnable) new Runnable() {
            public void run() {
                RideConfRepository.this.getConfigFromCache();
            }
        });
    }

    public RideConfModel getConfigFromCache() {
        String a = m11042a(f13177a);
        RideConfModel rideConfModel = null;
        if (!TextUtils.isEmpty(a)) {
            try {
                RideConfRsp rideConfRsp = (RideConfRsp) new Gson().fromJson(a, RideConfRsp.class);
                if (rideConfRsp != null) {
                    rideConfModel = rideConfRsp.getData();
                }
                m11044a(rideConfModel);
            } catch (Throwable unused) {
            }
        }
        return rideConfModel;
    }

    /* renamed from: a */
    private String m11042a(String str) {
        Object inner = getInner(DIDIApplication.getAppContext(), str);
        if (inner == null) {
            return null;
        }
        if (inner instanceof byte[]) {
            return new String((byte[]) inner);
        }
        if (inner instanceof String) {
            return (String) inner;
        }
        return null;
    }

    /* renamed from: a */
    private synchronized void m11044a(RideConfModel rideConfModel) {
        if (rideConfModel != null) {
            this.f13178b = rideConfModel.getCurVersion();
            this.f13179c = rideConfModel;
            m11045a(rideConfModel.getSecondaryMenu());
        }
    }

    /* renamed from: a */
    private void m11045a(List<RideConfBizModel> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (RideConfBizModel next : list) {
                CarInfo carInfo = new CarInfo();
                carInfo.setBusinessId(next.getBusinessId());
                carInfo.setBusinessNumId(next.getBusinessNumId());
                carInfo.setMapIcon(next.getMapIcon());
                carInfo.setCarId(next.getCarId());
                carInfo.setCarLevel(next.getCarLevel());
                carInfo.setComboType(next.getComboType());
                arrayList.add(carInfo);
                m11043a(next.getBusinessNumId());
            }
        }
        this.f13180d = arrayList;
        if (FormStore.getInstance().Bid == 0 && this.f13180d.size() > 0 && this.f13180d.get(0) != null) {
            CarInfo carInfo2 = this.f13180d.get(0);
            FormStore.getInstance().initData(carInfo2.getBusinessId(), carInfo2.getBusinessNumId(), carInfo2.getComboType());
        }
    }

    /* renamed from: a */
    private void m11043a(int i) {
        ComponentsConfig.get().checkOrAddComponent(i, AppUtils.isBrazilApp(DIDIApplication.getAppContext()) ? GlobalComponentConfig.BRAZIL_COMMON : GlobalComponentConfig.MEXICO_COMMON);
    }

    public List<CarInfo> getCarInfo() {
        return this.f13180d;
    }
}
