package com.didi.entrega.customer.foundation.locale;

import android.text.TextUtils;
import com.didi.entrega.customer.foundation.util.CollectionsUtil;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.ILocaleService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class CustomerLocaleUtil {
    public static final String TAG_EN_US = "en-US";
    public static final String TAG_ES_419 = "es-419";
    public static final String TAG_ES_MX = "es-MX";
    public static final String TAG_JA_JP = "ja-JP";
    public static final String TAG_PT_BR = "pt-BR";

    /* renamed from: a */
    private static List<Locale> f21767a = new ArrayList();

    /* renamed from: b */
    private static List<String> f21768b = new ArrayList();

    /* renamed from: c */
    private static Map<String, Boolean> f21769c = new HashMap();

    private CustomerLocaleUtil() {
    }

    public static List<Locale> getSupportLocaleList() {
        try {
            return ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getSupportList();
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public static List<String> getsSupportLocaleStringList() {
        if (CollectionsUtil.isEmpty(f21768b)) {
            for (Locale next : getSupportLocaleList()) {
                List<String> list = f21768b;
                list.add(next.getLanguage() + "-" + next.getCountry());
            }
            f21768b.add("en-US");
            f21769c.clear();
            for (String split : f21768b) {
                String[] split2 = split.split("-");
                if (split2 != null && split2.length > 0) {
                    Map<String, Boolean> map = f21769c;
                    map.put(split2[0], Boolean.valueOf(map.containsKey(split2[0])));
                }
            }
        }
        return f21768b;
    }

    public static boolean isInSameLanguageFamily(Locale locale) {
        return locale != null && !TextUtils.isEmpty(locale.getLanguage()) && Boolean.TRUE.equals(f21769c.get(locale.getLanguage()));
    }
}
