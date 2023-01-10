package com.didi.unifylogin.api;

import android.content.Context;
import com.didi.sdk.dependency.ConstantHolder;
import com.didi.sdk.dependency.ConstantListener;
import com.didi.sdk.util.SystemUtil;
import com.didi.thirdpartylogin.base.ThirdPartyLoginLogListener;
import com.didi.thirdpartylogin.base.ThirdPartyLoginManager;
import com.didi.unifylogin.base.api.LoginBaseFacade;
import com.didi.unifylogin.base.api.LoginBaseParam;
import com.didi.unifylogin.base.net.LoginNetParamListener;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.ApolloSwitch;
import com.didi.unifylogin.utils.LoginLog;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.Locale;
import java.util.Map;

@ServiceProvider({ILoginFacade.class})
public class LoginFacadeApi implements ILoginFacade {

    /* renamed from: b */
    private static final String f47280b = "LoginFacadeApi";

    /* renamed from: a */
    long f47281a;

    public void init(Context context, LoginInitParam loginInitParam) {
        this.f47281a = System.currentTimeMillis();
        if (ConstantHolder.getInstance().getConstantListener() == null) {
            m35190a();
        }
        m35194a("initBaseStore");
        SystemUtil.init(context.getApplicationContext());
        m35194a("SystemUtil");
        m35196b(loginInitParam);
        m35194a("initBase");
        m35192a(context.getApplicationContext(), loginInitParam);
        m35194a("initStore");
        m35193a(loginInitParam);
        m35194a("initListener");
        m35195b(context.getApplicationContext(), loginInitParam);
        m35194a("initOther");
        m35191a(context.getApplicationContext());
        m35194a("initThirdParty");
        LoginLog.write("OneLoginFacade:init()");
    }

    /* renamed from: a */
    private void m35194a(String str) {
        this.f47281a = System.currentTimeMillis();
    }

    /* renamed from: a */
    private void m35191a(Context context) {
        ThirdPartyLoginManager.setLogListener(new ThirdPartyLoginLogListener() {
            public void addLogWithTab(String str) {
                LoginLog.write(str);
            }
        });
    }

    /* renamed from: a */
    private void m35192a(Context context, final LoginInitParam loginInitParam) {
        LoginLog.write("OneLoginFacade:initStore()");
        LoginStore.setContext(context.getApplicationContext());
        final LoginStore instance = LoginStore.getInstance();
        m35194a("LoginStore getIns");
        instance.setAppId(loginInitParam.appId);
        instance.setDefCountryId(loginInitParam.defCountryId);
        m35194a("LoginStore set");
        new Thread(new Runnable() {
            public void run() {
                instance.setAndSaveAppId(loginInitParam.appId);
            }
        }).start();
    }

    /* renamed from: a */
    private void m35193a(LoginInitParam loginInitParam) {
        ListenerManager.setWebViewListener(loginInitParam.webViewListener);
        ListenerManager.setLocationListener(loginInitParam.locationListener);
        ListenerManager.setGlobalizationListener(loginInitParam.globalizationListener);
        ListenerManager.setFaceListener(loginInitParam.faceListener);
    }

    /* renamed from: b */
    private void m35195b(Context context, LoginInitParam loginInitParam) {
        CountryManager ins = CountryManager.getIns();
        m35194a("CountryManager getIns");
        ins.init(context.getApplicationContext());
        m35194a("CountryManager init");
        ApolloSwitch.getInstance().init(context.getApplicationContext());
        LoginPreferredConfig.setBrand(loginInitParam.brand);
    }

    /* renamed from: b */
    private void m35196b(final LoginInitParam loginInitParam) {
        LoginBaseParam loginBaseParam = new LoginBaseParam();
        loginBaseParam.isGlobal = loginInitParam.isGlobal;
        loginBaseParam.isRussia = loginInitParam.isRussia;
        loginBaseParam.useCustomBaseUrl = loginInitParam.useCustomBaseUrl;
        loginBaseParam.customBaseUrl = loginInitParam.customBaseUrl;
        loginBaseParam.logListener = loginInitParam.logListener;
        loginBaseParam.netModeListener = loginInitParam.netModeListener;
        loginBaseParam.netParamListener = new LoginNetParamListener() {
            public double getLat() {
                if (ListenerManager.getLocationListener() != null) {
                    return ListenerManager.getLocationListener().getLat();
                }
                return 0.0d;
            }

            public double getLng() {
                if (ListenerManager.getLocationListener() != null) {
                    return ListenerManager.getLocationListener().getLng();
                }
                return 0.0d;
            }

            public String getMapType() {
                if (ListenerManager.getLocationListener() != null) {
                    return ListenerManager.getLocationListener().getMapType();
                }
                return null;
            }

            public int getAppId() {
                return LoginStore.getInstance().getAppId();
            }

            public int getRole() {
                return LoginStore.getInstance().getRole();
            }

            public String getCountryCallingCode() {
                return CountryManager.getIns().getCurrentCountryCode();
            }

            public String getCanonicalCountryCode() {
                return CountryManager.getIns().getAreaCode();
            }

            public int getCountryId() {
                return CountryManager.getIns().getCurrentCountryId();
            }

            public int getCityId() {
                if (ListenerManager.getLocationListener() != null) {
                    return ListenerManager.getLocationListener().getCityId();
                }
                return 0;
            }

            public String getA3(Context context) {
                if (loginInitParam.riskParamListener != null) {
                    return loginInitParam.riskParamListener.getA3(context);
                }
                return null;
            }

            public String getIdfa(Context context) {
                if (loginInitParam.riskParamListener != null) {
                    return loginInitParam.riskParamListener.getIdfa(context);
                }
                return null;
            }

            public int getUtcOffset(Context context) {
                if (ListenerManager.getLocationListener() != null) {
                    return ListenerManager.getLocationListener().getUtcOffset();
                }
                return 0;
            }

            public String getLanguage() {
                if (ListenerManager.getGlobalizationListener() != null) {
                    return ListenerManager.getGlobalizationListener().getLanguage();
                }
                return Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry();
            }

            public Map<String, Object> getExtraInfo() {
                if (loginInitParam.netParamListener != null) {
                    return loginInitParam.netParamListener.getExtraInfo();
                }
                return null;
            }

            public String getTerminalId() {
                return loginInitParam.terminalId;
            }
        };
        LoginBaseFacade.getInstance().initBaseSdk(loginBaseParam);
    }

    /* renamed from: a */
    private void m35190a() {
        LoginLog.write("initBaseStore");
        ConstantHolder.getInstance().setConstantListener(new ConstantListener() {
            public String[] getBusinessIds() {
                return new String[0];
            }
        });
    }
}
