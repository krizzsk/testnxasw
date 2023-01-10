package com.didi.sdk.misconfig.p154v2.impl;

import android.text.TextUtils;
import android.util.Pair;
import com.didi.sdk.home.model.TopBarData;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.model.CarGrop;
import com.didi.sdk.misconfig.model.CountryInfo;
import com.didi.sdk.misconfig.model.HotInfo;
import com.didi.sdk.misconfig.p154v2.IPrimaryConf;
import com.didi.sdk.misconfig.p154v2.model.PriConfGroupModel;
import com.didi.sdk.misconfig.p154v2.model.PriConfModel;
import com.didi.sdk.misconfig.p154v2.store.PriConfRepository;
import com.didi.sdk.misconfig.p154v2.utils.ConfUtil;
import com.didi.sdk.misconfig.store.ICityChangeListener;
import com.didi.sdk.misconfig.store.MisRequestParams;
import com.didi.sdk.util.GlobalOmegaUtils;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.sdk.misconfig.v2.impl.PriConfImpl */
public class PriConfImpl implements IPrimaryConf {

    /* renamed from: a */
    private Logger f39621a = LoggerFactory.getLogger("PriConfImpl");

    /* renamed from: b */
    private PriConfRepository f39622b = new PriConfRepository();

    /* renamed from: c */
    private CityChangedNotifier f39623c = new CityChangedNotifier();

    /* renamed from: d */
    private int f39624d = 0;

    /* renamed from: a */
    static /* synthetic */ int m29832a(PriConfImpl priConfImpl) {
        int i = priConfImpl.f39624d;
        priConfImpl.f39624d = i + 1;
        return i;
    }

    public void updateConfigFromCache() {
        this.f39622b.updateConfigFromCache();
    }

    public void getConfigFromNet(final MisRequestParams misRequestParams) {
        PriConfRequest priConfRequest = new PriConfRequest(this.f39622b, this.f39623c);
        if (GlobalOmegaUtils.isReportOmega("tech_bottomlead_get")) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", "bottomlead_request");
            OmegaSDKAdapter.trackEvent("tech_bottomlead_get", (Map<String, Object>) hashMap);
        }
        if (misRequestParams.callback == null) {
            double d = misRequestParams.lng;
            double d2 = misRequestParams.lat;
            int i = misRequestParams.cityId;
            int i2 = this.f39624d;
            this.f39624d = i2 + 1;
            priConfRequest.request(d, d2, i, i2);
            return;
        }
        priConfRequest.requestWithOutSave(misRequestParams.lng, misRequestParams.lat, new RpcService.Callback<PriConfModel>() {
            public void onSuccess(PriConfModel priConfModel) {
                if (GlobalOmegaUtils.isReportOmega("tech_bottomlead_get")) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("type", "bottomlead_success");
                    OmegaSDKAdapter.trackEvent("tech_bottomlead_get", (Map<String, Object>) hashMap);
                }
                List<CarGrop> castToCarGrops = ConfUtil.castToCarGrops(priConfModel.getPrimaryMenu());
                if (!(priConfModel == null || priConfModel.getPrimaryMenu() == null || !PriConfImpl.this.m29836a(priConfModel))) {
                    PriConfImpl priConfImpl = PriConfImpl.this;
                    priConfImpl.m29833a(1, PriConfImpl.m29832a(priConfImpl), priConfModel);
                }
                misRequestParams.callback.onSuccess(castToCarGrops);
            }

            public void onFailure(IOException iOException) {
                misRequestParams.callback.onFail(0);
            }
        });
    }

    public int getCityId() {
        return this.f39622b.getCityId();
    }

    public HotInfo getHotInfo() {
        if (this.f39622b.getPriConfData() != null) {
            return this.f39622b.getPriConfData().getHotInfo();
        }
        return null;
    }

    public String getCountryIsoCode() {
        if (this.f39622b.getPriConfData() != null) {
            return this.f39622b.getPriConfData().getCountryIsoCode();
        }
        return null;
    }

    public boolean isContainsGroupType(String str) {
        TopBarData topBarData = this.f39622b.getTopBarData();
        return topBarData != null && topBarData.containsType(str);
    }

    public int getSelectedGroupId() {
        TopBarData topBarData = this.f39622b.getTopBarData();
        if (topBarData != null) {
            return topBarData.covertTypeToGroupId(this.f39622b.getSelectedType());
        }
        return 0;
    }

    public int getGroupIdByType(String str) {
        TopBarData topBarData = this.f39622b.getTopBarData();
        if (topBarData != null) {
            return topBarData.covertTypeToGroupId(str);
        }
        return 0;
    }

    public int getDefaultGroupId() {
        TopBarData topBarData = this.f39622b.getTopBarData();
        if (topBarData != null) {
            return topBarData.covertTypeToGroupId(this.f39622b.getDefaultSelectedType());
        }
        return 0;
    }

    public String getDefaultSelectedType() {
        return this.f39622b.getDefaultSelectedType();
    }

    public void setSelectedType(String str) {
        this.f39622b.setSelectedType(str);
    }

    public String getSelectedType() {
        return this.f39622b.getSelectedType();
    }

    public String getGroupIdArrayString() {
        TopBarData topBarData = this.f39622b.getTopBarData();
        if (topBarData != null) {
            return topBarData.getGroupIdArrayString();
        }
        return null;
    }

    public Pair<Integer, Integer> getSelectGroupId() {
        TopBarData topBarData = this.f39622b.getTopBarData();
        if (!(topBarData == null || topBarData.dataList == null)) {
            for (int i = 0; i < topBarData.dataList.size(); i++) {
                if (topBarData.dataList.get(i) != null && topBarData.dataList.get(i).carGrop != null && topBarData.dataList.get(i).isSelected) {
                    return new Pair<>(Integer.valueOf(i), Integer.valueOf(topBarData.dataList.get(i).carGrop.getGroupId()));
                }
            }
        }
        return new Pair<>(0, 0);
    }

    public String getH5Link(String str) {
        List<PriConfGroupModel> primaryMenu;
        PriConfModel priConfData = this.f39622b.getPriConfData();
        if (priConfData == null || (primaryMenu = priConfData.getPrimaryMenu()) == null || primaryMenu.size() <= 0) {
            return null;
        }
        for (PriConfGroupModel next : primaryMenu) {
            if (TextUtils.equals(next.getGroupType(), str)) {
                return next.getH5link();
            }
        }
        return null;
    }

    public CarGrop getGroupByType(String str) {
        List<CarGrop> carGrops = this.f39622b.getCarGrops();
        if (carGrops == null || carGrops.size() <= 0) {
            return null;
        }
        for (CarGrop next : carGrops) {
            if (TextUtils.equals(next.getGroupType(), str) && (TextUtils.isEmpty(next.getSchema()) || next.getSchema().contains("entrance"))) {
                return next;
            }
        }
        return null;
    }

    public CountryInfo getCountryInfo() {
        return this.f39622b.getCountryInfo();
    }

    public TopBarData getTopBarData() {
        return this.f39622b.getTopBarData();
    }

    public void setSelectGroup(CarGrop carGrop) {
        if (this.f39622b.getTopBarData() != null) {
            this.f39622b.getTopBarData().selectedGroup = carGrop;
        }
    }

    public void registerCityChangeListener(ICityChangeListener iCityChangeListener) {
        this.f39623c.registerCityChangeListener(iCityChangeListener);
    }

    public void unRegisterCityChangeListener(ICityChangeListener iCityChangeListener) {
        this.f39623c.unRegisterCityChangeListener(iCityChangeListener);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29833a(int i, int i2, PriConfModel priConfModel) {
        int countryId = priConfModel.getCountryId();
        if (getCountryInfo() != null && countryId != getCountryInfo().getCountryId()) {
            ConfUtil.dispatchLawFromUpdate(i, i2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m29836a(PriConfModel priConfModel) {
        return (priConfModel == null || priConfModel.getPrimaryMenu() == null || priConfModel.getPrimaryMenu().size() == 0) ? false : true;
    }
}
