package com.didi.sdk.sidebar.setup.mutilocale;

import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIApplicationDelegate;
import com.didi.sdk.envsetbase.EnvPreferenceUtil;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.AppUtils;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

public class MultiLocaleStore {

    /* renamed from: a */
    private static final String f40148a = "multilocale-debug";

    /* renamed from: b */
    private static Logger f40149b = LoggerFactory.getLogger("MultiLocaleStore");

    /* renamed from: c */
    private static MultiLocaleStore f40150c = new MultiLocaleStore();

    /* renamed from: d */
    private HashSet<LocaleChangeListener> f40151d = new HashSet<>();

    /* renamed from: e */
    private MultiLocaleHelper f40152e = new MultiLocaleHelperImpl();

    /* renamed from: f */
    private int f40153f = -1;

    /* renamed from: g */
    private String f40154g = "";

    /* renamed from: h */
    private Locale f40155h;

    public boolean isSwitchOn() {
        return true;
    }

    private MultiLocaleStore() {
        Locale defaultLocale = MultiLocaleUtil.getDefaultLocale();
        this.f40155h = defaultLocale;
        if (defaultLocale != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lang", this.f40155h.getCountry());
            Logger logger = f40149b;
            logger.info("systemLocale code : " + this.f40155h.getCountry() + " " + this.f40155h.getLanguage(), new Object[0]);
            OmegaSDK.trackEvent("phone_system_lang", "", hashMap);
        }
    }

    /* renamed from: a */
    private int m30275a() {
        int i;
        String metaDataByKey = AppUtils.getMetaDataByKey("COUNTRY");
        if ("JP".equalsIgnoreCase(metaDataByKey)) {
            i = 1;
        } else if ("AU".equalsIgnoreCase(metaDataByKey)) {
            i = 2;
        } else {
            i = EnvPreferenceUtil.getIntSafely(DIDIApplicationDelegate.getAppContext(), "key_app_global_version", 0);
        }
        SystemUtils.log(4, "MetaDataCountry", "country:" + metaDataByKey + "  cy:" + i, (Throwable) null, "com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore", 68);
        Logger logger = f40149b;
        StringBuilder sb = new StringBuilder();
        sb.append("appCountry : ");
        sb.append(i);
        logger.info(sb.toString(), new Object[0]);
        return i;
    }

    public boolean isJapan() {
        return m30275a() == 1;
    }

    public boolean isAustralia() {
        return m30275a() == 2;
    }

    public Locale getSystemLocale() {
        return this.f40155h;
    }

    public static MultiLocaleStore getInstance() {
        return f40150c;
    }

    public MultiLocaleHelper getLocaleHelper() {
        return this.f40152e;
    }

    public synchronized void addLocaleChangeListener(LocaleChangeListener localeChangeListener) {
        if (this.f40151d != null) {
            if (localeChangeListener != null) {
                f40149b.infoEvent(f40148a, "addLocaleChangeListener...");
                this.f40151d.add(localeChangeListener);
                return;
            }
        }
        f40149b.infoEvent(f40148a, "addLocaleChangeListener is null");
    }

    public synchronized void removeLocaleChangeListener(LocaleChangeListener localeChangeListener) {
        if (this.f40151d != null) {
            if (localeChangeListener != null) {
                f40149b.infoEvent(f40148a, f40148a, "removeLocaleChangeListener...");
                this.f40151d.remove(localeChangeListener);
                return;
            }
        }
        f40149b.infoEvent(f40148a, f40148a, "removeLocaleChangeListener is null");
    }

    public synchronized void notifyLocaleChange(String str, String str2) {
        this.f40154g = str2;
        if (this.f40151d != null) {
            if (!this.f40151d.isEmpty()) {
                Iterator<LocaleChangeListener> it = this.f40151d.iterator();
                while (it.hasNext()) {
                    it.next().onLocaleChange(str, str2);
                }
                return;
            }
        }
        f40149b.infoEvent(f40148a, f40148a, "no listeners");
    }

    public synchronized String getLocaleCode() {
        if (this.f40154g == null) {
            return "";
        }
        return this.f40154g;
    }

    public boolean isEnglish() {
        return "en-US".equals(this.f40154g);
    }

    public boolean isJapanese() {
        return "ja-JP".equals(this.f40154g);
    }
}
