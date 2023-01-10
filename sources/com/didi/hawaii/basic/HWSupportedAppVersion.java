package com.didi.hawaii.basic;

import com.didi.hawaii.utils.StorageUtils;
import java.util.HashMap;
import java.util.Map;

public final class HWSupportedAppVersion {
    public static final String BUS_PACKAGE_NAME = "com.didichuxing.provider";
    public static final String DEMO_PACKAGE_NAME = "com.example.hawaii";
    public static final String DRIVER_HK_PACKAGE_NAME = "com.sdu.didi.gsui.hk";
    public static final String DRIVER_PACKAGE_NAME = "com.sdu.didi.gsui";
    public static final String ES_PACKAGE_NAME = "com.didi.es.psngr";
    public static final String PASSENGER_PACKAGE_NAME = "com.sdu.didi.psnger";

    /* renamed from: a */
    private static final Map<String, AppConfig> f25697a;

    private HWSupportedAppVersion() {
    }

    static {
        HashMap hashMap = new HashMap(10);
        f25697a = hashMap;
        hashMap.put(DEMO_PACKAGE_NAME, new AppConfig(StorageUtils.getSDRootPath() + ".WL/", "{phonenumber}_{hawaii}{count}_{date:yyyyMMdd}.txt"));
        Map<String, AppConfig> map = f25697a;
        map.put("com.sdu.didi.gsui", new AppConfig(StorageUtils.getSDRootPath() + ".WL/", "{phonenumber}_{hawaii}{count}_{date:yyyyMMdd}.txt"));
        Map<String, AppConfig> map2 = f25697a;
        map2.put(DRIVER_HK_PACKAGE_NAME, new AppConfig(StorageUtils.getSDRootPath() + ".WL/", "{phonenumber}_{hawaii}{count}_{date:yyyyMMdd}.txt"));
        Map<String, AppConfig> map3 = f25697a;
        map3.put("com.sdu.didi.psnger", new AppConfig(StorageUtils.getSDRootPath() + "/log/", "{phonenumber}_{hawaii}{count}_{date:yyyyMMdd}.txt"));
        Map<String, AppConfig> map4 = f25697a;
        map4.put(BUS_PACKAGE_NAME, new AppConfig(StorageUtils.getSDRootPath() + "SoFa/", "{phonenumber}_{hawaii}{count}_{date:yyyyMMdd}.txt"));
        Map<String, AppConfig> map5 = f25697a;
        map5.put(ES_PACKAGE_NAME, new AppConfig(StorageUtils.getSDRootPath() + ".WL/", "{phonenumber}_{hawaii}{count}_{date:yyyyMMdd}.txt"));
    }

    public static class AppConfig {
        public final String bamaiDir;
        public final String bamaiFileNameRule;

        private AppConfig(String str, String str2) {
            this.bamaiDir = str;
            this.bamaiFileNameRule = str2;
        }
    }

    /* renamed from: a */
    private static String m20415a(String str) {
        return StorageUtils.getSDRootPath();
    }

    public static String getBaMaiLogDir(String str, String str2) {
        AppConfig appConfig = f25697a.get(str);
        return appConfig != null ? appConfig.bamaiDir : str2;
    }

    public static String getBaMaiLogFileNameRule(String str, String str2) {
        AppConfig appConfig = f25697a.get(str);
        return appConfig != null ? appConfig.bamaiFileNameRule : str2;
    }

    public static AppConfig getAppConfig(String str) {
        return f25697a.get(str);
    }
}
