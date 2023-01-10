package com.didi.soda.customer.mlocale;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.didi.foundation.sdk.mlocale.LoadSupportListUtils;
import com.didi.foundation.sdk.service.LocaleConfig;
import com.didi.foundation.sdk.service.LocaleConfigServiceProvider;
import com.didi.foundation.sdk.service.LocaleServiceProvider;
import com.didi.foundation.sdk.utils.LocaleUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.soda.customer.app.GlobalContext;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.global.didi.elvish.language.SupportLanguageItemModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class LocaleServiceEmb {

    /* renamed from: b */
    private static final String f43976b = "locale_sp";

    /* renamed from: c */
    private static final String f43977c = "current_locale";

    /* renamed from: d */
    private static final String f43978d = "current_real_locale";

    /* renamed from: l */
    private static LocaleServiceEmb f43979l;

    /* renamed from: a */
    private Logger f43980a = LoggerFactory.getLogger("LocaleServiceImpl");

    /* renamed from: e */
    private final ArrayList<LocaleServiceProvider.OnLocaleChangedListener> f43981e = new ArrayList<>();

    /* renamed from: f */
    private SharedPreferences f43982f;

    /* renamed from: g */
    private Context f43983g;

    /* renamed from: h */
    private boolean f43984h;

    /* renamed from: i */
    private LocaleConfig f43985i = new LocaleConfig();

    /* renamed from: j */
    private String f43986j = "";

    /* renamed from: k */
    private String f43987k = "";

    public static LocaleServiceEmb getInstance() {
        if (f43979l == null) {
            synchronized (LocaleServiceEmb.class) {
                if (f43979l == null) {
                    f43979l = new LocaleServiceEmb();
                }
            }
        }
        return f43979l;
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
            this.f43984h = true;
            this.f43983g = context;
            this.f43982f = SystemUtils.getSharedPreferences(context, f43976b, 0);
            try {
                if (TextUtils.isEmpty(str)) {
                    str = "en-US";
                }
                CustomerElvish.Companion.init(context, str);
            } catch (Exception e) {
                e.printStackTrace();
            }
            LocaleConfig localeConfig = ((LocaleConfigServiceProvider) ServiceLoader.load(LocaleConfigServiceProvider.class).get()).getLocaleConfig();
            this.f43985i = localeConfig;
            LocaleUtils.isGlobal = localeConfig.isGlobal;
            LocaleUtils.isDubug = this.f43985i.isDebug;
            m32801a(str);
        }
    }

    /* renamed from: a */
    private void m32801a(String str) {
        this.f43980a.info("calculateAppLocale called: from CustomerElvish", new Object[0]);
        Logger logger = this.f43980a;
        logger.info("rlab_locale:" + str, new Object[0]);
        LanguageModel languageAndLocale = CustomerElvish.Companion.getInstance().getLanguageAndLocale(this.f43983g, LocaleUtils.tagToLocale(str), LocaleUtils.isGlobal);
        Logger logger2 = this.f43980a;
        logger2.info("calculateAppLocale called: from CustomerElvish：language = " + languageAndLocale.toString(), new Object[0]);
        this.f43986j = languageAndLocale.getLang();
        String locale = languageAndLocale.getLocale();
        this.f43987k = locale;
        m32802a(this.f43986j, locale);
    }

    /* renamed from: a */
    private void m32802a(String str, String str2) {
        m32804b(str);
        m32805c(str2);
    }

    /* renamed from: b */
    private void m32804b(String str) {
        SharedPreferences sharedPreferences = this.f43982f;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(f43977c, str).apply();
        }
    }

    /* renamed from: a */
    private String m32800a() {
        SharedPreferences sharedPreferences = this.f43982f;
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString(f43977c, this.f43986j);
    }

    /* renamed from: c */
    private void m32805c(String str) {
        if (this.f43982f != null) {
            str.replace("_", "-");
            this.f43982f.edit().putString(f43978d, str).apply();
        }
    }

    /* renamed from: b */
    private String m32803b() {
        SharedPreferences sharedPreferences = this.f43982f;
        if (sharedPreferences == null) {
            return "";
        }
        String string = sharedPreferences.getString(f43978d, this.f43987k);
        if (!TextUtils.isEmpty(string)) {
            string = string.replace("_", "-");
        }
        return string == null ? "en-US" : string;
    }

    public List<Locale> getSupportLocaleList() {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        if (!(this.f43985i.remoteLanguageConfData == null || this.f43985i.remoteLanguageConfData.loadConf(GlobalContext.getContext()) == null)) {
            hashMap = this.f43985i.remoteLanguageConfData.loadConf(GlobalContext.getContext());
        }
        if (!(this.f43985i.localAssetsLanguageConfData == null || this.f43985i.localAssetsLanguageConfData.loadConf(GlobalContext.getContext()) == null)) {
            hashMap2 = this.f43985i.localAssetsLanguageConfData.loadConf(GlobalContext.getContext());
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
        return LocaleUtils.tagToLocale(m32803b());
    }

    public String getCurrentLocaleTag() {
        return m32803b();
    }

    public Locale getCurrentLang() {
        return LocaleUtils.tagToLocale(m32800a());
    }

    public String getCurrentLangTag() {
        return m32800a();
    }
}
