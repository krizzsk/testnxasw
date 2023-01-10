package com.didi.dimina.container.mina;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.jsengine.JSEngine;
import com.didi.dimina.container.jsengine.JSEngineWrapper;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.page.IPageHost;
import com.didi.dimina.container.page.ITabBarPageHost;
import com.didi.dimina.container.util.CollectionsUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TraceUtil;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.Collection;
import java.util.List;

public class DMMemoryManager implements ComponentCallbacks2 {

    /* renamed from: a */
    private static final String f18770a = "DiminaMemoryManager";

    /* renamed from: b */
    private DiminaMemoryManagerCallback f18771b;

    /* renamed from: c */
    private boolean f18772c;

    /* renamed from: d */
    private int f18773d;

    public interface DiminaMemoryManagerCallback {
        void onTrimMemory(int i);
    }

    public static class MinaMemoryInfo {
        int currentHeapLimit;
        int expandTimes = 0;
        int initialHeapLimit;
        boolean relaunch = false;
        long startTime = 0;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    private DMMemoryManager() {
        this.f18772c = false;
        this.f18773d = 0;
    }

    public static DMMemoryManager getInstance() {
        return DiminaMemoryManagerHolder.diminaMemoryManager;
    }

    private static class DiminaMemoryManagerHolder {
        public static DMMemoryManager diminaMemoryManager = new DMMemoryManager();

        private DiminaMemoryManagerHolder() {
        }
    }

    public boolean isLowMemory() {
        return this.f18772c;
    }

    public void setLowMemory(boolean z) {
        this.f18772c = z;
    }

    public void handleMemory(List<IPageHost> list) {
        if (!CollectionsUtil.isEmpty((Collection) list) && getInstance().isLowMemory()) {
            for (int i = 1; i < list.size() - 1; i++) {
                IPageHost iPageHost = list.get(i);
                if (!(iPageHost instanceof ITabBarPageHost)) {
                    DMPage page = ((IPageHost) iPageHost.getPageHost()).getPage();
                    if (!page.isWebViewRelease) {
                        page.releaseWebView();
                        setLowMemory(false);
                        return;
                    }
                }
            }
        }
    }

    public void checkPageMemory(IPageHost iPageHost) {
        if (iPageHost != null && m15944b(iPageHost)) {
            m15943a(iPageHost);
        }
    }

    /* renamed from: a */
    private void m15943a(IPageHost iPageHost) {
        DMPage page = iPageHost.getPage();
        LogUtil.iRelease(f18770a, "DiminaMemoryManager: host webViewId= " + page.getWebViewId() + " reCreatePageWebView");
        page.reLoadView();
    }

    /* renamed from: b */
    private boolean m15944b(IPageHost iPageHost) {
        DMPage page = iPageHost.getPage();
        return page != null && page.isWebViewRelease;
    }

    public void onTrimMemory(int i) {
        LogUtil.iRelease(f18770a, "invoke onTrimMemory() level = " + i);
        this.f18773d = i;
        if (i == 15) {
            LogUtil.wRelease(f18770a, "invoke onTrimMemory() level = 15 mIsLowMemory = true");
            this.f18772c = true;
        }
        m15941a(i);
        if (i == 80) {
            for (DMMina a : DMMinaPool.getAll()) {
                m15942a(a, "memory");
            }
        }
        DiminaMemoryManagerCallback diminaMemoryManagerCallback = this.f18771b;
        if (diminaMemoryManagerCallback != null) {
            diminaMemoryManagerCallback.onTrimMemory(i);
        }
    }

    public void onLowMemory() {
        LogUtil.wRelease(f18770a, "onLowMemory ");
        m15941a(80);
    }

    /* renamed from: a */
    private void m15941a(int i) {
        JSEngine.PressLevel pressLevel;
        if (i >= 80 || i == 15) {
            pressLevel = JSEngine.PressLevel.CRITICAL;
        } else if (i >= 40) {
            pressLevel = JSEngine.PressLevel.MODERATE;
        } else {
            pressLevel = JSEngine.PressLevel.NONE;
        }
        for (DMMina jSEngine : DMMinaPool.getAll()) {
            JSEngineWrapper jSEngine2 = jSEngine.getJSEngine();
            if (jSEngine2 != null) {
                jSEngine2.notifyMemoryPress(pressLevel);
                LogUtil.iRelease("V8Dimina", "trackSagaV8GC");
            }
        }
    }

    public int onJSEngineNearHeapLimit(DMMina dMMina, int i, int i2) {
        int i3 = i + 104857600;
        dMMina.memoryInfo.currentHeapLimit = i3;
        dMMina.memoryInfo.initialHeapLimit = i2;
        dMMina.memoryInfo.expandTimes++;
        dMMina.getJSEngine().onLowMemory();
        LogUtil.iRelease("V8Dimina", "trackSagaV8GC");
        return i3;
    }

    public void notifyDiminaResumeMainPage(DMMina dMMina) {
        m15942a(dMMina, "home");
    }

    public void notifyDiminaBackground(DMMina dMMina) {
        m15942a(dMMina, Constants.BACKGROUND);
    }

    /* renamed from: a */
    private void m15942a(DMMina dMMina, String str) {
        if (dMMina.getConfig().getLaunchConfig().isIsUseReLaunch() && !dMMina.isRelease() && !dMMina.memoryInfo.relaunch && dMMina.memoryInfo.expandTimes != 0) {
            long reLaunchTimeDiff = dMMina.getConfig().getLaunchConfig().getReLaunchTimeDiff();
            if (System.currentTimeMillis() - dMMina.memoryInfo.startTime < reLaunchTimeDiff) {
                LogUtil.wRelease(f18770a, "dimina relaunch but diff time " + (System.currentTimeMillis() - dMMina.memoryInfo.startTime) + " and set " + reLaunchTimeDiff);
            } else if (this.f18773d >= 60) {
                DMConfig.ReLaunchCallback relaunchCallback = dMMina.getConfig().getCallbackConfig().getRelaunchCallback();
                if (relaunchCallback == null) {
                    LogUtil.wRelease(f18770a, "dimina relaunch fail by no callback set");
                    return;
                }
                dMMina.memoryInfo.relaunch = true;
                LogUtil.iRelease(f18770a, "dimina relaunch from " + str);
                TraceUtil.trackRelaunch(dMMina.getMinaIndex(), dMMina.memoryInfo.currentHeapLimit, str);
                DMMina relaunch = relaunchCallback.relaunch(dMMina);
                if (relaunch != null) {
                    relaunch.memoryInfo.startTime = System.currentTimeMillis();
                }
            }
        }
    }

    public void setMemoryManagerCallback(DiminaMemoryManagerCallback diminaMemoryManagerCallback) {
        this.f18771b = diminaMemoryManagerCallback;
    }
}
