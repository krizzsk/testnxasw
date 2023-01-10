package com.didi.entrega.customer.mlocale;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.foundation.sdk.mlocale.LoadSupportListUtils;
import com.didi.foundation.sdk.service.LocaleConfig;
import com.didi.foundation.sdk.service.LocaleConfigServiceProvider;
import com.didi.foundation.sdk.service.LocaleServiceProvider;
import com.didi.foundation.sdk.utils.LocaleUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.global.didi.elvish.language.SupportLanguageItemModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class LocaleServiceEmb {

    /* renamed from: b */
    private static final String f22061b = "current_locale";

    /* renamed from: c */
    private static final String f22062c = "current_real_locale";

    /* renamed from: k */
    private static LocaleServiceEmb f22063k;

    /* renamed from: a */
    private Logger f22064a = LoggerFactory.getLogger("LocaleServiceImpl");

    /* renamed from: d */
    private final ArrayList<LocaleServiceProvider.OnLocaleChangedListener> f22065d = new ArrayList<>();

    /* renamed from: e */
    private SharedPreferences f22066e;

    /* renamed from: f */
    private Context f22067f;

    /* renamed from: g */
    private boolean f22068g;

    /* renamed from: h */
    private LocaleConfig f22069h = new LocaleConfig();

    /* renamed from: i */
    private String f22070i = "";

    /* renamed from: j */
    private String f22071j = "";

    public static LocaleServiceEmb getInstance() {
        if (f22063k == null) {
            synchronized (LocaleServiceEmb.class) {
                if (f22063k == null) {
                    f22063k = new LocaleServiceEmb();
                }
            }
        }
        return f22063k;
    }

    private LocaleServiceEmb() {
    }

    public List<Locale> getDefaultList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Locale("en-US"));
        return arrayList;
    }

    public void initEmb(Context context, String str) {
        if (context != null) {
            this.f22068g = true;
            this.f22067f = context;
            this.f22066e = SystemUtils.getSharedPreferences(context, getClass().getName(), 0);
            try {
                if (TextUtils.isEmpty(str)) {
                    str = "en-US";
                }
                CustomerElvish.Companion.init(context, str);
            } catch (Exception e) {
                e.printStackTrace();
            }
            LocaleConfig localeConfig = ((LocaleConfigServiceProvider) ServiceLoader.load(LocaleConfigServiceProvider.class).get()).getLocaleConfig();
            this.f22069h = localeConfig;
            LocaleUtils.isGlobal = localeConfig.isGlobal;
            LocaleUtils.isDubug = this.f22069h.isDebug;
            m18291a(str);
        }
    }

    /* renamed from: a */
    private void m18291a(String str) {
        this.f22064a.info("calculateAppLocale called: from CustomerElvish", new Object[0]);
        Logger logger = this.f22064a;
        logger.info("rlab_locale:" + str, new Object[0]);
        LanguageModel languageAndLocale = CustomerElvish.Companion.getInstance().getLanguageAndLocale(this.f22067f, LocaleUtils.tagToLocale(str), LocaleUtils.isGlobal);
        Logger logger2 = this.f22064a;
        logger2.info("calculateAppLocale called: from CustomerElvish：language = " + languageAndLocale.toString(), new Object[0]);
        this.f22070i = languageAndLocale.getLang();
        String locale = languageAndLocale.getLocale();
        this.f22071j = locale;
        m18292a(this.f22070i, locale);
    }

    /* renamed from: a */
    private void m18292a(String str, String str2) {
        m18294b(str);
        m18295c(str2);
    }

    /* renamed from: b */
    private void m18294b(String str) {
        SharedPreferences sharedPreferences = this.f22066e;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(f22061b, str).apply();
        }
    }

    /* renamed from: a */
    private String m18290a() {
        SharedPreferences sharedPreferences = this.f22066e;
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString(f22061b, this.f22070i);
    }

    /* renamed from: c */
    private void m18295c(String str) {
        if (this.f22066e != null) {
            str.replace("_", "-");
            this.f22066e.edit().putString(f22062c, str).apply();
        }
    }

    /* renamed from: b */
    private String m18293b() {
        SharedPreferences sharedPreferences = this.f22066e;
        if (sharedPreferences == null) {
            return "";
        }
        String string = sharedPreferences.getString(f22062c, this.f22071j);
        if (!TextUtils.isEmpty(string)) {
            string = string.replace("_", "-");
        }
        return string == null ? "en-US" : string;
    }

    public List<Locale> getSupportLocaleList() {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        if (!(this.f22069h.remoteLanguageConfData == null || this.f22069h.remoteLanguageConfData.loadConf(GlobalContext.getContext()) == null)) {
            hashMap = this.f22069h.remoteLanguageConfData.loadConf(GlobalContext.getContext());
        }
        if (!(this.f22069h.localAssetsLanguageConfData == null || this.f22069h.localAssetsLanguageConfData.loadConf(GlobalContext.getContext()) == null)) {
            hashMap2 = this.f22069h.localAssetsLanguageConfData.loadConf(GlobalContext.getContext());
        }
        ArrayList<SupportLanguageItemModel> supportList = LoadSupportListUtils.getSupportList(hashMap, hashMap2);
        ArrayList arrayList = new ArrayList();
        if (supportList == null || supportList.isEmpty()) {
            return getDefaultList();
        }
        for (SupportLanguageItemModel lang : supportList) {
            arrayList.add(LocaleUtils.tagToLocale(lang.getLang()));
        }
        return arrayList;
    }

    public Locale getCurrentLocale() {
        return LocaleUtils.tagToLocale(m18293b());
    }

    public String getCurrentLocaleTag() {
        return m18293b();
    }

    public Locale getCurrentLang() {
        return LocaleUtils.tagToLocale(m18290a());
    }

    public String getCurrentLangTag() {
        return m18290a();
    }
}
