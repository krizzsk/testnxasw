package com.kwai.koom.javaoom.common;

import android.app.Application;
import com.kwai.koom.javaoom.monitor.HeapThreshold;
import com.kwai.koom.javaoom.report.DefaultRunningInfoFetcher;
import java.io.File;

public class KGlobalConfig {

    /* renamed from: a */
    static final String f58431a = "koom";

    /* renamed from: b */
    static final String f58432b = "hprof";

    /* renamed from: c */
    static final String f58433c = "report";

    /* renamed from: d */
    private static KGlobalConfig f58434d;

    /* renamed from: g */
    private static String f58435g;

    /* renamed from: h */
    private static String f58436h;

    /* renamed from: i */
    private static String f58437i;

    /* renamed from: e */
    private Application f58438e;

    /* renamed from: f */
    private KConfig f58439f;

    /* renamed from: j */
    private RunningInfoFetcher f58440j;

    /* renamed from: k */
    private KSoLoader f58441k;

    private KGlobalConfig() {
    }

    /* renamed from: a */
    private static KGlobalConfig m44284a() {
        KGlobalConfig kGlobalConfig = f58434d;
        if (kGlobalConfig != null) {
            return kGlobalConfig;
        }
        KGlobalConfig kGlobalConfig2 = new KGlobalConfig();
        f58434d = kGlobalConfig2;
        return kGlobalConfig2;
    }

    public void setApplicationInternal(Application application) {
        this.f58438e = application;
        this.f58440j = new DefaultRunningInfoFetcher(application);
    }

    public static void setApplication(Application application) {
        m44284a().setApplicationInternal(application);
    }

    public static Application getApplication() {
        return m44284a().f58438e;
    }

    public static void setKConfig(KConfig kConfig) {
        m44284a().setKConfigInternal(kConfig);
    }

    public void setKConfigInternal(KConfig kConfig) {
        this.f58439f = kConfig;
    }

    public static KConfig getKConfig() {
        return m44284a().f58439f;
    }

    public static HeapThreshold getHeapThreshold() {
        return m44284a().f58439f.getHeapThreshold();
    }

    public static void setRootDir(String str) {
        m44284a().f58439f.setRootDir(str);
    }

    public static String getRootDir() {
        String str = f58435g;
        if (str != null) {
            return str;
        }
        String rootDir = m44284a().f58439f.getRootDir();
        f58435g = rootDir;
        return rootDir;
    }

    public static String getReportDir() {
        String str = f58436h;
        if (str != null) {
            return str;
        }
        String str2 = getRootDir() + File.separator + f58433c;
        f58436h = str2;
        return str2;
    }

    public static String getHprofDir() {
        String str = f58437i;
        if (str != null) {
            return str;
        }
        String str2 = getRootDir() + File.separator + f58432b;
        f58437i = str2;
        return str2;
    }

    public static RunningInfoFetcher getRunningInfoFetcher() {
        return m44284a().f58440j;
    }

    public static void setSoLoader(KSoLoader kSoLoader) {
        m44284a().f58441k = kSoLoader;
    }

    public static KSoLoader getSoLoader() {
        KSoLoader kSoLoader = m44284a().f58441k;
        if (kSoLoader != null) {
            return kSoLoader;
        }
        KGlobalConfig a = m44284a();
        DefaultKSoLoader defaultKSoLoader = new DefaultKSoLoader();
        a.f58441k = defaultKSoLoader;
        return defaultKSoLoader;
    }
}
