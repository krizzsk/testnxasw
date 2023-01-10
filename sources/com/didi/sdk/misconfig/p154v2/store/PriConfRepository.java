package com.didi.sdk.misconfig.p154v2.store;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.apm.utils.ApmThreadPool;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.home.model.TopBarData;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.misconfig.model.CarGrop;
import com.didi.sdk.misconfig.model.CountryInfo;
import com.didi.sdk.misconfig.p154v2.model.PriConfModel;
import com.didi.sdk.misconfig.p154v2.model.PriConfRsp;
import com.didi.sdk.misconfig.p154v2.utils.ConfUtil;
import com.google.gson.Gson;
import java.util.List;

/* renamed from: com.didi.sdk.misconfig.v2.store.PriConfRepository */
public class PriConfRepository {

    /* renamed from: b */
    private static final String f39628b = "primary_config_store";

    /* renamed from: c */
    private static final String f39629c = "city_id";

    /* renamed from: d */
    private static final String f39630d = "selected_type";

    /* renamed from: e */
    private static final String f39631e = "latest_city_key";

    /* renamed from: f */
    private static final String f39632f = "primary_cfg_cityid_";

    /* renamed from: a */
    private Logger f39633a = LoggerFactory.getLogger("PriConfRepository");

    /* renamed from: g */
    private Context f39634g = DIDIApplication.getAppContext();

    /* renamed from: h */
    private SharedPreferences f39635h;

    /* renamed from: i */
    private PriConfStore f39636i = new PriConfStore();

    /* renamed from: j */
    private String f39637j;

    /* renamed from: k */
    private int f39638k;

    /* renamed from: l */
    private String f39639l;

    /* renamed from: m */
    private String f39640m;

    /* renamed from: n */
    private PriConfModel f39641n;

    /* renamed from: o */
    private TopBarData f39642o;

    /* renamed from: p */
    private List<CarGrop> f39643p;

    /* renamed from: q */
    private CountryInfo f39644q;

    public PriConfRepository() {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(this.f39634g, f39628b, 0);
        this.f39635h = sharedPreferences;
        this.f39638k = sharedPreferences.getInt("city_id", 0);
        this.f39637j = "";
        this.f39640m = m29843a();
    }

    public void updateConfigFromCache() {
        this.f39633a.debug("updateMisConfigFromCache begin", new Object[0]);
        ApmThreadPool.execute((Runnable) new Runnable() {
            public void run() {
                PriConfRepository priConfRepository = PriConfRepository.this;
                priConfRepository.getConfigFromCache(priConfRepository.m29847b());
            }
        });
    }

    public PriConfModel getConfigFromCache(int i) {
        Logger logger = this.f39633a;
        logger.debug("updateMisConfigFromCache getSpLatestCityKey = " + i, new Object[0]);
        int i2 = this.f39638k;
        PriConfModel priConfModel = null;
        if (!(i2 == 0 && i2 == -1)) {
            String a = m29844a(f39632f + i);
            if (!TextUtils.isEmpty(a)) {
                try {
                    PriConfRsp priConfRsp = (PriConfRsp) new Gson().fromJson(a, PriConfRsp.class);
                    if (priConfRsp != null) {
                        priConfModel = priConfRsp.getData();
                    }
                } catch (Throwable unused) {
                }
            }
        }
        if (priConfModel != null) {
            m29846a(priConfModel);
        }
        return priConfModel;
    }

    public void saveConfig(PriConfModel priConfModel, String str) {
        PriConfStore priConfStore = this.f39636i;
        Context context = this.f39634g;
        priConfStore.putAndSave(context, f39632f + priConfModel.getCityId(), str);
        m29846a(priConfModel);
        m29845a(priConfModel.getCityId());
    }

    public void saveCityId(int i) {
        this.f39638k = i;
        SharedPreferences.Editor edit = this.f39635h.edit();
        edit.putInt("city_id", i);
        edit.apply();
    }

    /* renamed from: a */
    private String m29844a(String str) {
        Object inner = this.f39636i.getInner(this.f39634g, str);
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

    public String getCurVersion() {
        return this.f39637j;
    }

    public int getCityId() {
        return this.f39638k;
    }

    public PriConfModel getPriConfData() {
        return this.f39641n;
    }

    public TopBarData getTopBarData() {
        return this.f39642o;
    }

    public CountryInfo getCountryInfo() {
        return this.f39644q;
    }

    public List<CarGrop> getCarGrops() {
        return this.f39643p;
    }

    public void setSelectedType(String str) {
        this.f39640m = str;
        TopBarData topBarData = this.f39642o;
        if (topBarData != null) {
            topBarData.setSelectedGroup(str);
        }
        this.f39635h.edit().putString(f39630d, str).apply();
    }

    public String getSelectedType() {
        if (TextUtils.isEmpty(this.f39640m)) {
            this.f39640m = "ride";
        }
        return this.f39640m;
    }

    /* renamed from: a */
    private String m29843a() {
        String string = this.f39635h.getString(f39630d, (String) null);
        this.f39639l = string;
        if (string == null) {
            this.f39639l = "ride";
        }
        return this.f39639l;
    }

    public String getDefaultSelectedType() {
        return this.f39639l;
    }

    /* renamed from: a */
    private void m29845a(int i) {
        this.f39635h.edit().putInt(f39631e, i).apply();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m29847b() {
        return this.f39635h.getInt(f39631e, 0);
    }

    /* renamed from: a */
    private synchronized void m29846a(PriConfModel priConfModel) {
        this.f39637j = priConfModel.getCurVersion();
        this.f39641n = priConfModel;
        List<CarGrop> castToCarGrops = ConfUtil.castToCarGrops(priConfModel.getPrimaryMenu());
        this.f39643p = castToCarGrops;
        this.f39642o = new TopBarData(castToCarGrops, getSelectedType());
        this.f39644q = m29848b(priConfModel);
    }

    public int getSelectedGroupId() {
        TopBarData topBarData = this.f39642o;
        if (topBarData != null) {
            return topBarData.covertTypeToGroupId(this.f39640m);
        }
        return 0;
    }

    /* renamed from: b */
    private CountryInfo m29848b(PriConfModel priConfModel) {
        CountryInfo countryInfo = new CountryInfo();
        countryInfo.setCountryIsoCode(priConfModel.getCountryIsoCode());
        countryInfo.setCountryId(priConfModel.getCountryId());
        countryInfo.setCityId(priConfModel.getCityId());
        countryInfo.setUtcOffSet(priConfModel.getUtcOffset());
        return countryInfo;
    }
}
