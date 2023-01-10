package com.didi.flutter.hotpatch.flutterhotpatch;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.didi.dynamic.manager.utils.SharedPreferencesWrapper;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.onehotpatch.commonstatic.PatchManager;
import com.didi.sdk.onehotpatch.commonstatic.bean.MetaBean;
import com.didi.sdk.onehotpatch.commonstatic.bean.PatchModule;
import com.didi.sdk.onehotpatch.commonstatic.bean.SoInfo;
import com.didi.sdk.onehotpatch.commonstatic.util.UtilsHub;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import java.io.File;

public class OnePatchAdapter implements HotPatchAdapter {
    public static final String FLUTTER_HOTPATCH_SP = "flutter_hotpatch_sp";

    /* renamed from: a */
    Logger f22927a = LoggerFactory.getLogger("OnePatchAdapter");

    /* renamed from: b */
    private PatchModule f22928b;

    /* renamed from: c */
    private Application f22929c;

    /* renamed from: d */
    private int f22930d = 3;

    public String getPatchPath(Application application) {
        try {
            if (this.f22928b == null) {
                return null;
            }
            File file = new File(new File(PatchManager.getPatchSoDir(application, this.f22928b), SoInfo.getCurrentAbi(application)), "libapp.so");
            if (!file.exists() || !file.canRead()) {
                return null;
            }
            return file.getCanonicalPath();
        } catch (Throwable th) {
            this.f22927a.error("getPatchPath error", th);
            return null;
        }
    }

    public void onFlutterError() {
        PatchModule patchModule = this.f22928b;
        if (patchModule != null) {
            int errorCount = getErrorCount(this.f22929c, patchModule);
            m18928a(errorCount + 1);
            Logger logger = this.f22927a;
            logger.info("onFlutterError new errorCount:" + errorCount, new Object[0]);
        }
    }

    /* renamed from: a */
    private void m18928a(int i) {
        SharedPreferencesWrapper.Editor edit = SharedPreferencesWrapper.m17955of(this.f22929c, FLUTTER_HOTPATCH_SP, 0).edit();
        edit.putInt("error_count_" + this.f22928b.version, i).apply();
    }

    public static int getErrorCount(Context context, PatchModule patchModule) {
        SharedPreferencesWrapper of = SharedPreferencesWrapper.m17955of(context, FLUTTER_HOTPATCH_SP, 0);
        return of.getInt("error_count_" + patchModule.version, 0);
    }

    public boolean canLoadPatch(Application application) {
        this.f22927a.debug("canLoadPatch", new Object[0]);
        this.f22929c = application;
        try {
            if (!UtilsHub.isMainProcess(application)) {
                return false;
            }
            if (PatchManager.isAppUpgraded(application)) {
                this.f22927a.info("isAppUpgraded", new Object[0]);
                return false;
            }
            IToggle a = m18927a();
            if (!a.allow()) {
                Logger logger = this.f22927a;
                logger.info("toggle not allow:" + a, new Object[0]);
                return false;
            }
            PatchModule loadPatch = PatchManager.getLoadPatch(application, true);
            if (loadPatch == null) {
                this.f22927a.info("patchModule == null", new Object[0]);
                return false;
            }
            MetaBean patchMeta = PatchManager.getPatchMeta(application, loadPatch);
            if (patchMeta == null) {
                this.f22927a.info("metaBean == null", new Object[0]);
                return false;
            }
            String versionNameAndCode = UtilsHub.getVersionNameAndCode(application);
            if (!patchMeta.target_version.equals(versionNameAndCode)) {
                Logger logger2 = this.f22927a;
                logger2.info("target_version is not equals，appVersion:" + versionNameAndCode + "target_version:" + patchMeta.target_version, new Object[0]);
                return false;
            }
            if (Build.VERSION.SDK_INT >= patchMeta.min_sdk) {
                if (Build.VERSION.SDK_INT <= patchMeta.max_sdk) {
                    int enabledFlag = PatchManager.getEnabledFlag(application, loadPatch);
                    if (enabledFlag != 1) {
                        Logger logger3 = this.f22927a;
                        logger3.info("enabledFlag:" + enabledFlag, new Object[0]);
                        return false;
                    }
                    this.f22930d = ((Integer) a.getExperiment().getParam("maxErrorCount", 3)).intValue();
                    int errorCount = getErrorCount(application, loadPatch);
                    if (errorCount > this.f22930d) {
                        Logger logger4 = this.f22927a;
                        logger4.info("errorCount:" + errorCount + ",maxErrorCount:" + this.f22930d, new Object[0]);
                        return false;
                    }
                    this.f22927a.info("canLoadPatch ok", new Object[0]);
                    this.f22928b = loadPatch;
                    return true;
                }
            }
            this.f22927a.info("SDK version not match", new Object[0]);
            return false;
        } catch (Throwable th) {
            this.f22927a.error("canLoadPatch error", th);
            return false;
        }
    }

    /* renamed from: a */
    private IToggle m18927a() {
        return Apollo.getToggle("flutter_hotpatch_config", true);
    }
}
