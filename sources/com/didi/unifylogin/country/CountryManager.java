package com.didi.unifylogin.country;

import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.didi.map.setting.common.MapSettingNavConstant;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.sidebar.history.HistoryRecordFragment;
import com.didi.sdk.util.GlobalCountryCode;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.request.CountryRequseParam;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.CommonUtils;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.taxis99.R;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CountryManager {
    public static final int BRAZIL = 76;
    public static final int CHINA = 156;
    public static final int MEXICO = 484;

    /* renamed from: a */
    private static final String f47385a = "CountryManager";

    /* renamed from: b */
    private static final String f47386b = "fragment_unify_login";

    /* renamed from: c */
    private static final String f47387c = "countryList";

    /* renamed from: d */
    private static final String f47388d = "commonCountryList";

    /* renamed from: e */
    private static final String f47389e = "common_country_text";

    /* renamed from: f */
    private static final String f47390f = "nat_flag_base_url";

    /* renamed from: g */
    private static final String f47391g = "countryMd5";

    /* renamed from: h */
    private static volatile CountryManager f47392h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public List<CountryListResponse.CountryRule> f47393i;

    /* renamed from: j */
    private CountryListResponse.CountryRule f47394j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public SharedPreferences f47395k;

    /* renamed from: l */
    private String f47396l = "";
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f47397m = 0;

    /* renamed from: n */
    private String f47398n;

    /* renamed from: o */
    private Context f47399o;

    public interface CountriesChangeListener {
        void onChange(List<CountryListResponse.CountryRule> list);

        void onServerResponse(CountryListResponse countryListResponse);
    }

    /* renamed from: f */
    static /* synthetic */ int m35247f(CountryManager countryManager) {
        int i = countryManager.f47397m;
        countryManager.f47397m = i + 1;
        return i;
    }

    public static CountryManager getIns() {
        if (f47392h == null) {
            synchronized (CountryManager.class) {
                if (f47392h == null) {
                    f47392h = new CountryManager();
                }
            }
        }
        return f47392h;
    }

    public void init(final Context context) {
        this.f47399o = context.getApplicationContext();
        new Thread(new Runnable() {
            public void run() {
                SharedPreferences unused = CountryManager.this.m35243c();
                CountryListResponse.CountryRule.NAT_FLAG_BASE_URL = CountryManager.this.f47395k.getString(CountryManager.f47390f, "http://img0.didiglobal.com/static/passport_flag_png/country_flag/");
                if (OneLoginFacade.getStore().isLoginNow() && LoginStore.getInstance().getCountryId() < 0) {
                    CountryManager.this.m35241b(context.getApplicationContext());
                }
                List c = CountryManager.this.m35231a();
                if (c == null || c.size() <= 0) {
                    CountryManager.this.getCountriesFromNet((CountriesChangeListener) null);
                }
            }
        }).start();
    }

    public void setContext(Context context) {
        if (context != null) {
            this.f47399o = context.getApplicationContext();
        }
    }

    public CountryListResponse.CountryRule getCurrentCountry() {
        if (this.f47394j == null) {
            LoginLog.write("CountryManager- getCurrentCountry() - getCountryById : " + LoginStore.getInstance().getCountryId());
            if (LoginStore.getInstance().getCountryId() > 0) {
                this.f47394j = getCountryById(LoginStore.getInstance().getCountryId());
            }
        }
        return this.f47394j;
    }

    public String getCurrentCountryCode() {
        if (getCurrentCountry() != null) {
            return getCurrentCountry().calling_code;
        }
        return null;
    }

    public int getCurrentCountryId() {
        if (getCurrentCountry() != null) {
            return getCurrentCountry().country_id;
        }
        return -1;
    }

    public String getAreaCode() {
        if (getCurrentCountry() != null) {
            return getCurrentCountry().area;
        }
        return null;
    }

    public synchronized CountryListResponse.CountryRule getDefCountry() {
        LoginLog.write("CountryManager- getDefCountry() entered");
        if (this.f47394j == null) {
            this.f47394j = getCurrentCountry();
        }
        if (this.f47394j == null && LoginStore.getInstance().getDefCountryId() > 0) {
            this.f47394j = getCountryById(LoginStore.getInstance().getDefCountryId());
            LoginLog.write("CountryManager- getDefCountry() - getCountryByDefId: " + this.f47394j);
        }
        if (this.f47394j == null && LoginPreferredConfig.getDefCountryOldId() > 0) {
            this.f47394j = getCountryById(LoginPreferredConfig.getDefCountryOldId());
            LoginLog.write("CountryManager- getDefCountry() - getDefCountryOldId: " + this.f47394j);
        }
        if (this.f47394j == null) {
            this.f47394j = m35230a(getLocaleCountry());
            LoginLog.write("CountryManager- getDefCountry() - getCountryByArea: " + this.f47394j);
            OmegaSDKAdapter.trackEvent(LoginOmegaUtil.TONE_P_X_LOGIN_GET_COUNTRY_BY_AREA);
        }
        if (this.f47394j == null) {
            this.f47394j = m35230a(getSimCountryIso());
            LoginLog.write("CountryManager- getDefCountry() - getCountryBySim: " + this.f47394j);
            OmegaSDKAdapter.trackEvent(LoginOmegaUtil.TONE_P_X_LOGIN_GET_COUNTRY_BY_SIM);
        }
        if (this.f47394j == null) {
            this.f47394j = getCountryById(CommonUtils.isBrazilApp(this.f47399o) ? 76 : 484);
            LoginLog.write("CountryManager- getDefCountry() - getDefault: " + this.f47394j);
            OmegaSDKAdapter.trackEvent(LoginOmegaUtil.TONE_P_X_LOGIN_GET_COUNTRY_CHINA);
        }
        LoginLog.write("CountryManager- getDefCountry() result: " + this.f47394j);
        return this.f47394j;
    }

    public void setCurrentCountry(CountryListResponse.CountryRule countryRule) {
        this.f47394j = countryRule;
        LoginLog.write("CountryManager- setCurrentCountry() - currentCountry : " + countryRule);
    }

    public List<CountryListResponse.CountryRule> getCountries() {
        if (this.f47393i == null) {
            this.f47393i = m35231a();
        }
        if (this.f47393i == null) {
            this.f47393i = m35232a(this.f47399o);
        }
        return this.f47393i;
    }

    public List<CountryListResponse.CountryRule> getCommonCountries() {
        String string = m35243c().getString(f47388d, "");
        LoginLog.write("CountryManager- getCommonCountries() - json : " + string.length());
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return (List) new Gson().fromJson(string, new TypeToken<ArrayList<CountryListResponse.CountryRule>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public CountryListResponse.CountryRule getCountryById(int i) {
        if (i < 0) {
            return null;
        }
        for (CountryListResponse.CountryRule next : getCountries()) {
            if (next.country_id == i) {
                return next;
            }
        }
        for (CountryListResponse.CountryRule next2 : getCountries()) {
            if (next2.old_country_id == i) {
                return next2;
            }
        }
        return null;
    }

    /* renamed from: a */
    private CountryListResponse.CountryRule m35230a(String str) {
        if (TextUtil.isEmpty(str)) {
            return null;
        }
        for (CountryListResponse.CountryRule next : getCountries()) {
            if (str.toUpperCase().equals(next.area)) {
                return next;
            }
        }
        return null;
    }

    public int getCurLanguage() {
        String localeCountry = getLocaleCountry();
        if (m35230a(localeCountry) == null) {
            return getDefCountry().country_id;
        }
        return m35230a(localeCountry).country_id;
    }

    public void getCountriesFromNet(final CountriesChangeListener countriesChangeListener) {
        if (this.f47399o != null) {
            LoginLog.write("CountryManager- getCountriesFromNet()");
            LoginModel.getNet(this.f47399o).getCountryList(new CountryRequseParam(this.f47399o).setMd5(m35240b()), new LoginRpcCallbackV2<CountryListResponse>() {
                public void onSuccess(RpcResponseProxy<CountryListResponse> rpcResponseProxy) {
                    super.onSuccess(rpcResponseProxy);
                    final CountryListResponse content = rpcResponseProxy.getContent();
                    if (content != null) {
                        if (!TextUtils.isEmpty(content.md5)) {
                            CountryManager.this.m35242b(content.md5);
                        }
                        CountryManager.this.m35233a(content);
                        UiThreadHandler.post(new Runnable() {
                            public void run() {
                                if (countriesChangeListener != null) {
                                    countriesChangeListener.onServerResponse(content);
                                }
                            }
                        });
                        if (content.getCoutryRules() != null) {
                            LoginLog.write("CountryManager- getCountriesFromNet() - onSuccess" + content.getCoutryRules().size());
                            CountryManager.this.m35238a(content.getCoutryRules());
                            UiThreadHandler.post(new Runnable() {
                                public void run() {
                                    if (countriesChangeListener != null) {
                                        countriesChangeListener.onChange(CountryManager.this.f47393i);
                                    }
                                }
                            });
                        }
                    }
                }

                public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                    super.onFailure(rpcRequest, iOException);
                    if (CountryManager.this.f47397m < 3) {
                        CountryManager.m35247f(CountryManager.this);
                        CountryManager.this.getCountriesFromNet((CountriesChangeListener) null);
                    }
                    iOException.printStackTrace();
                    HashMap hashMap = new HashMap();
                    hashMap.put("source", 4);
                    OmegaSDKAdapter.trackEvent("tech_gpfile_cache_read", (Map<String, Object>) hashMap);
                    LoginLog.write("CountryManager- getCountriesFromNet() - onFailure:");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35233a(CountryListResponse countryListResponse) {
        if (countryListResponse.common_country_list != null) {
            try {
                SharedPreferences.Editor edit = m35243c().edit();
                String json = new Gson().toJson((Object) countryListResponse.common_country_list);
                if (!TextUtils.isEmpty(json)) {
                    edit.putString(f47388d, json);
                }
                edit.apply();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (countryListResponse.common_country_text != null) {
            try {
                SharedPreferences.Editor edit2 = m35243c().edit();
                edit2.putString(f47389e, countryListResponse.common_country_text);
                edit2.apply();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (countryListResponse.nat_flag_base_url != null) {
            try {
                SharedPreferences.Editor edit3 = m35243c().edit();
                edit3.putString(f47390f, countryListResponse.nat_flag_base_url);
                edit3.apply();
                CountryListResponse.CountryRule.NAT_FLAG_BASE_URL = countryListResponse.nat_flag_base_url;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<CountryListResponse.CountryRule> m35231a() {
        String string = m35243c().getString(f47387c, "");
        LoginLog.write("CountryManager- getCountriesFromCache() - json : " + string.length());
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return (List) new Gson().fromJson(string, new TypeToken<ArrayList<CountryListResponse.CountryRule>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35238a(List<CountryListResponse.CountryRule> list) {
        try {
            this.f47393i = list;
            SharedPreferences.Editor edit = m35243c().edit();
            String json = new Gson().toJson((Object) list);
            if (!TextUtils.isEmpty(json)) {
                edit.putString(f47387c, json);
            }
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m35242b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f47396l = str;
                SharedPreferences.Editor edit = m35243c().edit();
                edit.putString(f47391g, str);
                edit.apply();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private String m35240b() {
        if (TextUtils.isEmpty(this.f47396l)) {
            this.f47396l = m35243c().getString(f47391g, "");
        }
        return this.f47396l;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public SharedPreferences m35243c() {
        if (this.f47395k == null) {
            this.f47395k = SystemUtils.getSharedPreferences(this.f47399o, f47386b, 0);
        }
        return this.f47395k;
    }

    /* renamed from: a */
    private List<CountryListResponse.CountryRule> m35232a(Context context) {
        Context context2 = context;
        LoginLog.write("CountryManager- getDefCountries()");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_china_name), "+86", 86, 156, GlobalCountryCode.CHINA, "xxx xxxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_usa_name), "+1", 1, 840, GlobalCountryCode.AMERICA, "xxx xxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_hongkong_name), "+852", 852, 344, "HK", "xxxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_taiwan_name), "+886", 886, 158, "TW", "xxxx xxx xxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_ca_name), "+1", 10001, 124, GlobalCountryCode.CANADA, "xxx xxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_uk_name), "+44", 44, 826, GlobalCountryCode.ENGLAND, "xxx xxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_france_name), "+33", 33, 250, GlobalCountryCode.FRANCE, "x xxxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_japan_name), "+81", 81, 392, "JP", "xxxx xxx xxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_korea_name), "+82", 82, 410, "KR", "xxx xxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_thailand_name), "+66", 66, 764, "TH", "x xxxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_australia_name), "+61", 61, 36, "AU", "x xxxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_brasil_name), "+55", 55, 76, "BR", "xx xxxxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_russia_name), "+7", 7, 643, MapSettingNavConstant.MAP_COUNTRY_CODE_RUSSIA, "xxx xxxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_malaysia_name), "+60", 60, 458, "MY", "xxx xxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_vietanm_name), "+84", 84, 704, "VN", "xxx xxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_mangolia_name), "+976", 976, 496, "MN", "xxxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_singapore_name), "+65", 65, 702, "SG", "xxxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_philippines_name), "+63", 63, 608, "PH", "xxx xxxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_india_name), "+91", 91, 356, "IN", "xxx xxxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_germany_name), "+49", 49, 276, GlobalCountryCode.GERMANY, "xxxx xxxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_indonesia_name), "+62", 62, 360, "ID", "xxx xxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_italy_name), "+39", 39, 380, GlobalCountryCode.ITALY, "xxx xxxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_mexico_name), "+52", 52, 484, "MX", "xx xxxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_co_name), "+57", 57, 170, HistoryRecordFragment.COUNTRY_CODE_CO, "xxx xxxxxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_pe_name), "+51", 51, 604, HistoryRecordFragment.COUNTRY_CODE_PE, "xxx xxx xxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_cl_name), "+56", 56, 152, HistoryRecordFragment.COUNTRY_CODE_CL, "x xxxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_ar_name), "+54", 54, 32, HistoryRecordFragment.COUNTRY_CODE_AR, "x xx xxxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_pa_name), "+507", 507, 591, HistoryRecordFragment.COUNTRY_CODE_PA, "xxxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_cr_name), "+506", 506, 188, HistoryRecordFragment.COUNTRY_CODE_CR, "xxxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_nz_name), "+64", 64, 554, HistoryRecordFragment.COUNTRY_CODE_NZ, "xx xxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_tz_name), "+255", 255, 834, "TZ", "xxx xxx xxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_ug_name), "+256", 256, 800, "UG", "xxx xxxxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_eg_name), "+20", 20, 818, "EG", "xxx xxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_za_name), "+27", 27, 710, HistoryRecordFragment.COUNTRY_CODE_ZA, "xx xxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_dm_name), "+1", 1, 212, "DM", "xxx xxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_do_name), "+1", 1, 214, HistoryRecordFragment.COUNTRY_CODE_DO, "xxx xxx xxxx", ""));
        arrayList.add(new CountryListResponse.CountryRule(context2.getString(R.string.login_unify_ec_name), "+593", 593, 218, "EC", "xx xxx xxxx", ""));
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m35241b(Context context) {
        String string = SystemUtils.getSharedPreferences(context, "fragment_login", 0).getString("selectCountry", "");
        int i = 76;
        if (!TextUtils.isEmpty(string)) {
            OldCountryRule oldCountryRule = (OldCountryRule) new Gson().fromJson(string, OldCountryRule.class);
            if (oldCountryRule != null) {
                LoginLog.write("CountryManager- compatibleOldData() - oldCountry : " + oldCountryRule.code);
                LoginLog.write("CountryManager- compatibleOldData() - area_id : " + oldCountryRule.area_id);
                CountryListResponse.CountryRule a = m35229a(oldCountryRule.area_id);
                if (a != null) {
                    LoginLog.write("CountryManager- compatibleOldData() - newCountry : " + a.calling_code);
                    LoginStore.getInstance().setAndSaveCountryId(a.country_id);
                    new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_MIGRATION_SUCCESS).send();
                    return;
                }
                LoginStore instance = LoginStore.getInstance();
                if (!CommonUtils.isBrazilApp(context)) {
                    i = 484;
                }
                instance.setAndSaveCountryId(i);
                new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_MIGRATION_ERROR).send();
            } else if (LoginStore.getInstance().getDefCountryId() > 0) {
                LoginStore.getInstance().setAndSaveCountryId(LoginStore.getInstance().getDefCountryId());
            } else {
                LoginStore instance2 = LoginStore.getInstance();
                if (!CommonUtils.isBrazilApp(context)) {
                    i = 484;
                }
                instance2.setAndSaveCountryId(i);
            }
        } else if (LoginStore.getInstance().getDefCountryId() > 0) {
            LoginStore.getInstance().setAndSaveCountryId(LoginStore.getInstance().getDefCountryId());
        } else {
            LoginStore instance3 = LoginStore.getInstance();
            if (!CommonUtils.isBrazilApp(context)) {
                i = 484;
            }
            instance3.setAndSaveCountryId(i);
        }
    }

    public void saveOldCountry(Context context, int i) {
        LoginLog.write("CountryManager- saveOldCountry() - countryId : " + i);
        CountryListResponse.CountryRule countryById = getCountryById(i);
        if (countryById != null) {
            OldCountryRule oldCountryRule = new OldCountryRule(countryById.name, countryById.calling_code, countryById.old_country_id, countryById.flag_url, countryById.max_len, countryById.prefixes, countryById.format, countryById.area, (String) null);
            LoginLog.write("CountryManager- saveOldCountry() - oldCountryRule : " + oldCountryRule.code);
            SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context, "fragment_login", 0);
            try {
                String json = new Gson().toJson((Object) oldCountryRule);
                if (!TextUtils.isEmpty(json)) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("selectCountry", json);
                    edit.commit();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private CountryListResponse.CountryRule m35229a(int i) {
        if (i < 0) {
            return null;
        }
        for (CountryListResponse.CountryRule next : getCountries()) {
            LoginLog.write("CountryManager- getCountryByOldId() - ruleId : " + next.old_country_id);
            if (next.old_country_id == i) {
                return next;
            }
        }
        return null;
    }

    public String getSimCountryIso() {
        try {
            if (TextUtils.isEmpty(this.f47398n)) {
                TelephonyManager telephonyManager = (TelephonyManager) this.f47399o.getSystemService("phone");
                String simCountryIso = telephonyManager.getSimCountryIso();
                this.f47398n = simCountryIso;
                if (TextUtils.isEmpty(simCountryIso)) {
                    this.f47398n = telephonyManager.getNetworkCountryIso();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.f47398n;
    }

    public String getLocaleCountry() {
        Locale systemLocale;
        if (ListenerManager.getGlobalizationListener() == null || (systemLocale = ListenerManager.getGlobalizationListener().getSystemLocale()) == null || TextUtil.isEmpty(systemLocale.getCountry())) {
            return Locale.getDefault().getCountry();
        }
        LoginLog.write("CountryManager- getLocaleCountry() - GlobalizationListener : " + systemLocale.getCountry());
        return systemLocale.getCountry();
    }

    public String getCommonCountryText() {
        return this.f47395k.getString(f47389e, "");
    }

    class OldCountryRule implements Serializable {
        public String area;
        public int area_id;
        public String code;
        public String flag_url;
        public String format;
        public String letter;
        public int max_len;
        public String name;
        public String[] prefixes;

        public OldCountryRule(String str, String str2, int i, String str3, int i2, String[] strArr, String str4, String str5, String str6) {
            this.name = str;
            this.code = str2;
            this.area_id = i;
            this.flag_url = str3;
            this.max_len = i2;
            this.prefixes = strArr;
            this.format = str4;
            this.area = str5;
            this.letter = str6;
        }
    }
}
