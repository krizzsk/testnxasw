package com.didi.foundation.sdk.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.didi.foundation.sdk.mlocale.LoadSupportListUtils;
import com.didi.foundation.sdk.mlocale.LocaleConstant;
import com.didi.foundation.sdk.service.LocaleServiceProvider;
import com.didi.foundation.sdk.utils.LocaleUtils;
import com.didi.foundation.sdk.utils.LogUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.GlobalCountryCode;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.global.didi.elvish.Elvish;
import com.global.didi.elvish.base.BaseDataLoader;
import com.global.didi.elvish.language.LanguageModel;
import com.global.didi.elvish.language.SupportLanguageItemModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.functions.Function1;

@ServiceProvider({LocaleServiceProvider.class})
public class LocaleServiceImpl implements LocaleServiceProvider {

    /* renamed from: a */
    private static Logger f23166a = LoggerFactory.getLogger("LocaleServiceImpl");

    /* renamed from: b */
    private static final String f23167b = "locale_sp";

    /* renamed from: c */
    private static final String f23168c = "current_locale";

    /* renamed from: d */
    private static final String f23169d = "current_real_locale";

    /* renamed from: e */
    private static final String f23170e = "current_rlab_locale";

    /* renamed from: f */
    private final ArrayList<LocaleServiceProvider.OnLocaleChangedListener> f23171f = new ArrayList<>();

    /* renamed from: g */
    private SharedPreferences f23172g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Context f23173h;

    /* renamed from: i */
    private boolean f23174i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public LocaleConfig f23175j;

    /* renamed from: k */
    private String f23176k = "";

    /* renamed from: l */
    private String f23177l = "";

    public List<Locale> getDefaultList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Locale("en-US"));
        return arrayList;
    }

    public void init(Context context) {
        if (context != null) {
            this.f23174i = true;
            this.f23173h = context;
            this.f23172g = SystemUtils.getSharedPreferences(context, f23167b, 0);
            LocaleUtils.initCofnigLocale();
            LocaleConfig localeConfig = ((LocaleConfigServiceProvider) ServiceLoader.load(LocaleConfigServiceProvider.class).get()).getLocaleConfig();
            this.f23175j = localeConfig;
            if (localeConfig.preInitCB != null) {
                this.f23175j.preInitCB.onPreInit(context);
            }
            LocaleUtils.isGlobal = this.f23175j.isGlobal;
            LocaleUtils.isDubug = this.f23175j.isDebug;
            LanguageModel a = m19063a(m19064a());
            m19065a((Intent) null, LocaleUtils.tagToLocale(a.getLocale()));
            try {
                String[] split = a.getLocale().split("-");
                Elvish.Companion.init(context, a.getLocale(), LocaleUtils.localeToTag(LocaleUtils.defaultConfigLocale), split.length > 1 ? split[split.length - 1] : GlobalCountryCode.AMERICA, this.f23175j.city_id);
            } catch (Exception e) {
                e.printStackTrace();
                LogUtils logUtils = LogUtils.INSTANCE;
                logUtils.mo68531d("locale is null:" + e.getMessage());
            }
        } else {
            throw new NullPointerException("context is null!");
        }
    }

    /* renamed from: a */
    private LanguageModel m19063a(Locale locale) {
        LanguageModel loadLanguageConfig = new BaseDataLoader().loadLanguageConfig(this.f23173h, locale, this.f23175j.isGlobal, (Function1<? super Context, ? extends Map<String, Object>>) new Function1<Context, Map<String, Object>>() {
            public Map<String, Object> invoke(Context context) {
                if (LocaleServiceImpl.this.f23175j.remoteLanguageConfData != null) {
                    return LocaleServiceImpl.this.f23175j.remoteLanguageConfData.loadConf(LocaleServiceImpl.this.f23173h);
                }
                LogUtils.INSTANCE.mo68531d("remoteLanguageConfData is null,now is empty");
                return new HashMap();
            }
        }, (Function1<? super Context, ? extends Map<String, Object>>) new Function1<Context, Map<String, Object>>() {
            public Map<String, Object> invoke(Context context) {
                if (LocaleServiceImpl.this.f23175j.localAssetsLanguageConfData != null) {
                    return LocaleServiceImpl.this.f23175j.localAssetsLanguageConfData.loadConf(LocaleServiceImpl.this.f23173h);
                }
                LogUtils.INSTANCE.mo68531d("localAssetsLanguageConfData is null,now is empty");
                return new HashMap();
            }
        });
        Logger logger = f23166a;
        logger.info("calculateAppLocale called: from Elvish：language = " + loadLanguageConfig.toString(), new Object[0]);
        this.f23176k = loadLanguageConfig.getLang();
        this.f23177l = loadLanguageConfig.getLocale();
        return loadLanguageConfig;
    }

    /* renamed from: a */
    private Locale m19064a() {
        String str;
        String b = m19073b();
        f23166a.info("calculateAppLocale called: from Elvish", new Object[0]);
        if (TextUtils.isEmpty(b)) {
            f23166a.info("无缓存的lang————————————————", new Object[0]);
            str = LocaleUtils.localeToTag(LocaleUtils.defaultConfigLocale);
        } else {
            f23166a.info("存在缓存的lang————————————————", new Object[0]);
            String localeToTag = LocaleUtils.localeToTag(new Locale(LocaleUtils.tagToLocale(b).getLanguage(), LocaleUtils.getSysLocale().getCountry()));
            Logger logger = f23166a;
            logger.info("oldLang:" + b, new Object[0]);
            str = localeToTag;
        }
        Logger logger2 = f23166a;
        logger2.info("target4Checklocale:" + str, new Object[0]);
        Logger logger3 = f23166a;
        logger3.info("defaultConfigLocale:" + LocaleUtils.defaultConfigLocale.toString(), new Object[0]);
        Logger logger4 = f23166a;
        logger4.info("sysLocale:" + LocaleUtils.getSysLocale().toString(), new Object[0]);
        return LocaleUtils.tagToLocale(str);
    }

    /* renamed from: a */
    private void m19069a(String str, String str2) {
        m19068a(str);
        m19074b(str2);
    }

    /* renamed from: b */
    private boolean m19076b(String str, String str2) {
        if (TextUtils.equals(str, str2)) {
            return true;
        }
        return str.split("-")[0].equals(str2.split("-")[0]);
    }

    public Context attachBaseContext(Context context) {
        return Build.VERSION.SDK_INT >= 24 ? m19061a(context) : context;
    }

    /* renamed from: a */
    private Context m19061a(Context context) {
        Resources resources;
        if (!this.f23174i) {
            init(context);
        }
        if (context.getApplicationContext() == null) {
            resources = context.getResources();
        } else {
            resources = context.getApplicationContext().getResources();
        }
        Locale tagToLocale = LocaleUtils.tagToLocale(m19078c());
        Logger logger = f23166a;
        logger.info("updateResources:locale is " + tagToLocale, new Object[0]);
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(tagToLocale);
        LocaleList localeList = new LocaleList(new Locale[]{tagToLocale});
        configuration.setLocales(localeList);
        LocaleList.setDefault(localeList);
        Locale.setDefault(tagToLocale);
        LocaleUtils.initCofnigLocale();
        return context.createConfigurationContext(configuration);
    }

    public Locale switchLocale(Intent intent, String str) {
        return switchLocale(intent, LocaleUtils.tagToLocale(str));
    }

    public Locale switchLocale(Intent intent, Locale locale) {
        Locale locale2;
        String str;
        try {
            String localeToTag = LocaleUtils.localeToTag(locale);
            String substring = localeToTag.substring(0, localeToTag.indexOf("-"));
            String[] split = LocaleUtils.getSysLocaleTag().split("-");
            int length = split.length;
            if (length == 2) {
                str = split[1];
            } else if (length != 3) {
                str = GlobalCountryCode.AMERICA;
                m19079c(LocaleConstant.ERROR_SWITCH_SPLIT, "sysLocale:" + LocaleUtils.getSysLocaleTag());
            } else {
                str = split[2];
            }
            locale2 = new Locale(substring, str);
        } catch (Exception e) {
            e.printStackTrace();
            locale2 = getCurrentLocale();
            m19079c(LocaleConstant.ERROR_SWITCH_EXCEPTION, e.getMessage());
        }
        LanguageModel a = m19063a(locale2);
        Locale tagToLocale = LocaleUtils.tagToLocale(a.getLang());
        if (m19077b(tagToLocale)) {
            return tagToLocale;
        }
        return m19065a(intent, LocaleUtils.tagToLocale(a.getLocale()));
    }

    /* renamed from: c */
    private void m19079c(String str, String str2) {
        LocaleConfig localeConfig = this.f23175j;
        if (localeConfig != null && localeConfig.errorTrackCallBack != null) {
            try {
                this.f23175j.errorTrackCallBack.trackError(str, str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Locale getCurrentLocale() {
        return LocaleUtils.tagToLocale(m19078c());
    }

    public String getCurrentLocaleTag() {
        return m19078c();
    }

    public Locale getCurrentLang() {
        return LocaleUtils.tagToLocale(m19073b());
    }

    public String getCurrentLangTag() {
        return m19073b();
    }

    public List<Locale> getSupportLocaleList() {
        Map hashMap = new HashMap();
        if (!(this.f23175j.remoteLanguageConfData == null || this.f23175j.remoteLanguageConfData.loadConf(this.f23173h) == null)) {
            hashMap = this.f23175j.remoteLanguageConfData.loadConf(this.f23173h);
        }
        Map hashMap2 = new HashMap();
        if (!(this.f23175j.localAssetsLanguageConfData == null || this.f23175j.localAssetsLanguageConfData.loadConf(this.f23173h) == null)) {
            hashMap2 = this.f23175j.localAssetsLanguageConfData.loadConf(this.f23173h);
        }
        ArrayList<SupportLanguageItemModel> supportList = LoadSupportListUtils.getSupportList(hashMap, hashMap2);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (supportList == null || supportList.isEmpty()) {
            List<Locale> defaultList = getDefaultList();
            m19079c(LocaleConstant.ERROR_SUPPORT_LIST, "remote size:" + hashMap.size() + ",locale size:" + hashMap2.size());
            return defaultList;
        }
        for (SupportLanguageItemModel next : supportList) {
            if (m19075b(next)) {
                arrayList2.add(next);
            } else {
                arrayList.add(LocaleUtils.tagToLocale(next.getLang()));
            }
        }
        if (arrayList2.isEmpty()) {
            return arrayList;
        }
        arrayList.add(m19066a((List<SupportLanguageItemModel>) arrayList2));
        return arrayList;
    }

    /* renamed from: a */
    private Locale m19066a(List<SupportLanguageItemModel> list) {
        if (list == null || list.isEmpty()) {
            return LocaleUtils.tagToLocale("es-MX");
        }
        String country = LocaleUtils.getSysLocale().getCountry();
        for (SupportLanguageItemModel next : list) {
            if (country.equals(m19071a(next)[1])) {
                return LocaleUtils.tagToLocale(next.getLang());
            }
        }
        return LocaleUtils.tagToLocale(list.get(0).getLang());
    }

    /* renamed from: a */
    private String[] m19071a(SupportLanguageItemModel supportLanguageItemModel) {
        return supportLanguageItemModel.getLang().split("-");
    }

    /* renamed from: b */
    private boolean m19075b(SupportLanguageItemModel supportLanguageItemModel) {
        String[] a = m19071a(supportLanguageItemModel);
        return a.length > 0 && "es".equals(a[0]);
    }

    /* renamed from: b */
    private boolean m19077b(Locale locale) {
        return TextUtils.equals(LocaleUtils.localeToTag(locale), m19073b());
    }

    /* renamed from: a */
    private Locale m19065a(Intent intent, Locale locale) {
        String localeToTag = LocaleUtils.localeToTag(locale);
        Logger logger = f23166a;
        logger.debug("switchLocale: targetLocale is " + localeToTag, new Object[0]);
        Resources resources = this.f23173h.getResources();
        Configuration configuration = resources.getConfiguration();
        m19067a(configuration, locale);
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        String c = m19078c();
        if (c.isEmpty()) {
            c = LocaleUtils.getSysLocaleTag();
        }
        m19069a(this.f23176k, localeToTag);
        if (Build.VERSION.SDK_INT >= 24) {
            m19061a(this.f23173h);
        }
        resources.updateConfiguration(configuration, displayMetrics);
        LocaleUtils.initCofnigLocale();
        m19070a(LocaleUtils.tagToLocale(c), locale);
        Logger logger2 = f23166a;
        logger2.info("internalSwitchLocale:locale is " + locale, new Object[0]);
        if (intent != null) {
            f23166a.debug("switchLocale recreate", new Object[0]);
            intent.addFlags(32768);
            intent.addFlags(268435456);
            this.f23173h.startActivity(intent);
        }
        return locale;
    }

    public void addOnLocaleChangedListener(LocaleServiceProvider.OnLocaleChangedListener onLocaleChangedListener) {
        this.f23171f.add(onLocaleChangedListener);
    }

    public void removeOnLocaleChangedListener(LocaleServiceProvider.OnLocaleChangedListener onLocaleChangedListener) {
        this.f23171f.remove(onLocaleChangedListener);
    }

    /* renamed from: a */
    private void m19070a(Locale locale, Locale locale2) {
        if (!this.f23171f.isEmpty()) {
            for (int i = 0; i < this.f23171f.size(); i++) {
                this.f23171f.get(i).onLocaleChanged(locale, locale2);
            }
        }
    }

    public List<LocaleServiceProvider.OnLocaleChangedListener> getOnLocaleChangedListeners() {
        return new ArrayList(this.f23171f);
    }

    public void refreshLocale(Context context) {
        Locale tagToLocale = LocaleUtils.tagToLocale(m19078c());
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (Build.VERSION.SDK_INT >= 24) {
            configuration.setLocale(tagToLocale);
            LocaleList localeList = new LocaleList(new Locale[]{tagToLocale});
            configuration.setLocales(localeList);
            LocaleList.setDefault(localeList);
        } else {
            configuration.locale = tagToLocale;
        }
        resources.updateConfiguration(configuration, displayMetrics);
    }

    /* renamed from: a */
    private void m19068a(String str) {
        if (this.f23172g == null) {
            f23166a.info("saveLang:mPreferences is null", new Object[0]);
            return;
        }
        Logger logger = f23166a;
        logger.info("saveLang:" + str, new Object[0]);
        this.f23172g.edit().putString(f23168c, str).apply();
    }

    /* renamed from: b */
    private String m19073b() {
        SharedPreferences sharedPreferences = this.f23172g;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(f23168c, this.f23176k);
        }
        f23166a.info("getLangFromSP:mPreferences is null", new Object[0]);
        return "";
    }

    /* renamed from: b */
    private void m19074b(String str) {
        if (this.f23172g == null) {
            f23166a.info("saveLocale:mPreferences is null", new Object[0]);
            return;
        }
        Logger logger = f23166a;
        logger.info("saveLocale:mPreferences is " + str, new Object[0]);
        str.replace("_", "-");
        this.f23172g.edit().putString(f23169d, str).apply();
    }

    /* renamed from: c */
    private String m19078c() {
        SharedPreferences sharedPreferences = this.f23172g;
        if (sharedPreferences == null) {
            return "";
        }
        String string = sharedPreferences.getString(f23169d, this.f23177l);
        if (!TextUtils.isEmpty(string)) {
            string = string.replace("_", "-");
        }
        if (string != null) {
            return string;
        }
        f23166a.info("getLocaleFromSP:localeTag is null", new Object[0]);
        return "en-US";
    }

    /* renamed from: a */
    private void m19067a(Configuration configuration, Locale locale) {
        if (configuration != null && locale != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                configuration.setLocale(locale);
            } else {
                configuration.locale = locale;
            }
        }
    }
}
