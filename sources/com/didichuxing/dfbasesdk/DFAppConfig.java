package com.didichuxing.dfbasesdk;

import android.content.Context;
import com.didichuxing.dfbasesdk.utils.LogUtils;

public class DFAppConfig {

    /* renamed from: c */
    private static DFAppConfig f49128c = new DFAppConfig();

    /* renamed from: a */
    private IAppConfig f49129a;

    /* renamed from: b */
    private ILogReporter f49130b;

    private DFAppConfig() {
    }

    public static DFAppConfig getInstance() {
        return f49128c;
    }

    @Deprecated
    public void setAppConfig(IAppConfig iAppConfig) {
        LogUtils.m37057i("DFAppConfig#setAppConfig, config====" + iAppConfig);
        this.f49129a = iAppConfig;
        if (iAppConfig != null) {
            AppContextHolder.init(iAppConfig.getAppContext());
        }
    }

    public IAppConfig getAppConfig() {
        return this.f49129a;
    }

    public Context getAppContext() {
        return AppContextHolder.getAppContext();
    }

    public boolean isDebug() {
        IAppConfig iAppConfig = this.f49129a;
        return iAppConfig != null && iAppConfig.isDebug();
    }

    public ILogReporter logReporter() {
        return this.f49130b;
    }

    public void setLogReporter(ILogReporter iLogReporter) {
        this.f49130b = iLogReporter;
    }
}
