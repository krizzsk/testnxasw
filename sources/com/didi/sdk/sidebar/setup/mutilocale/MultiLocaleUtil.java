package com.didi.sdk.sidebar.setup.mutilocale;

import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.debug.language.LanguageDebugUtil;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.oneconf.OneConfStore;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.global.didi.elvish.language.LanguageModel;
import java.lang.reflect.Field;
import java.util.Locale;

public class MultiLocaleUtil {

    /* renamed from: a */
    private static Logger f40156a = LoggerFactory.getLogger("MultiLocaleUtil");
    public static LanguageModel languageModel;
    public static Locale sysLocale = getDefaultLocale();

    public static LanguageModel getLanguageModel() {
        LanguageModel languageModel2 = languageModel;
        return languageModel2 == null ? new LanguageModel("en-US", "en_US") : languageModel2;
    }

    public static void initSystemLocale() {
        sysLocale = getDefaultLocale();
    }

    public static String locale2Code(Locale locale) {
        if (locale == null) {
            return null;
        }
        try {
            String country = locale.getCountry();
            String language = locale.getLanguage();
            if (!TextUtils.isEmpty(country)) {
                if (!TextUtils.isEmpty(language)) {
                    Logger logger = f40156a;
                    logger.info("lang: " + language + " country : " + country, new Object[0]);
                    return m30276a(language, country);
                }
            }
            Field declaredField = Locale.class.getDeclaredField("cachedToStringResult");
            if (declaredField == null) {
                return "";
            }
            String[] split = ((String) declaredField.get(locale)).split("_");
            Logger logger2 = f40156a;
            logger2.info("lang tags:" + split.toString(), new Object[0]);
            if (split == null || split.length < 2) {
                return "";
            }
            String a = m30276a(split[0], split[1]);
            Logger logger3 = f40156a;
            logger3.info("lang: " + split[0] + " country : " + split[1], new Object[0]);
            return a;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return "";
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    private static String m30276a(String str, String str2) {
        return str + "-" + str2;
    }

    public static Locale getDefaultLocale() {
        Locale locale;
        IExperiment experiment;
        Locale settingForDebug = LanguageDebugUtil.INSTANCE.getSettingForDebug(DIDIApplication.getAppContext());
        if (settingForDebug != null) {
            return settingForDebug;
        }
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = LocaleList.getDefault().get(0);
        } else {
            locale = Locale.getDefault();
        }
        IToggle toggle = Apollo.getToggle("ibt_language_fix_confg");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
            return locale;
        }
        String stringParam = experiment.getStringParam("language", "");
        if (TextUtils.isEmpty(stringParam)) {
            return locale;
        }
        String language = locale.getLanguage();
        String countryIsoCode = OneConfStore.getInstance().getCountryIsoCode();
        boolean z2 = !TextUtils.isEmpty(countryIsoCode);
        if (!z2) {
            return locale;
        }
        String[] split = stringParam.split(",");
        int i = 0;
        while (true) {
            if (i >= split.length) {
                break;
            } else if (language.equals(split[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        return (!z || !z2) ? locale : new Locale(language, countryIsoCode);
    }
}
