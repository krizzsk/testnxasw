package com.didi.sdk.appupdate;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.appupdate.AppUpdateAlertDialog;
import com.didi.sdk.p155ms.common.ICollector;
import com.didi.sdk.p155ms.common.tasks.OnFailureListener;
import com.didi.sdk.p155ms.common.tasks.OnSuccessListener;
import com.didi.sdk.p155ms.common.update.IAppUpdateInfo;
import com.didi.sdk.p155ms.common.update.IAppUpdateManager;
import com.didi.sdk.p155ms.common.update.IInstallState;
import com.didi.sdk.p155ms.common.update.StateUpdatedListener;
import com.didi.sdk.p155ms.common.utils.ServiceUtil;
import com.didi.sdk.util.AnalysisAPK;
import com.didi.sdk.util.AppUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppUpdateManager {
    public static final String APP_UPDATE_TOGGLE = "force_app_update";
    public static final String APP_UPDATE_TOGGLE_BRAZIL = "force_app_update_brazil";
    public static final String APP_UPDATE_TOGGLE_HMS = "force_app_update_hms";

    /* renamed from: a */
    private static final String f38010a = "com.android.vending";

    /* renamed from: b */
    private static final String f38011b = "com.huawei.appmarket";

    /* renamed from: e */
    private static final int f38012e = 1099;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FragmentActivity f38013c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AppUpdateAlertDialog f38014d;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f38015f = 0;

    /* renamed from: g */
    private ICollector f38016g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public IAppUpdateManager f38017h;

    /* renamed from: i */
    private StateUpdatedListener<IInstallState> f38018i = new StateUpdatedListener<IInstallState>() {
        public void onStateUpdate(IInstallState iInstallState) {
            if (AppUpdateManager.this.f38017h != null && !AppUpdateManager.this.f38017h.isForceUpdate(AppUpdateManager.this.f38015f) && AppUpdateManager.this.f38017h.isDownloaded(iInstallState.installStatus())) {
                AppUpdateManager.this.f38017h.completeUpdate(AppUpdateManager.this.f38013c);
            }
        }
    };

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public AppUpdateManager(FragmentActivity fragmentActivity) {
        this.f38013c = fragmentActivity;
        this.f38016g = (ICollector) ServiceUtil.getServiceImp(ICollector.class);
        this.f38017h = (IAppUpdateManager) ServiceUtil.getServiceImp(IAppUpdateManager.class);
    }

    /* access modifiers changed from: protected */
    public void startAppUpdateCheck(boolean z, final FragmentActivity fragmentActivity) {
        IAppUpdateManager iAppUpdateManager;
        if (this.f38016g != null && (iAppUpdateManager = this.f38017h) != null) {
            this.f38015f = iAppUpdateManager.getAppUpdateType(z);
            this.f38017h.registerListener(this.f38013c, this.f38018i);
            this.f38017h.createAppUpdateInfoTask(this.f38013c, new OnSuccessListener<IAppUpdateInfo>() {
                public void onSuccess(IAppUpdateInfo iAppUpdateInfo) {
                    if (iAppUpdateInfo != null) {
                        if (!iAppUpdateInfo.isUpdateAvailable() || !iAppUpdateInfo.isUpdateTypeAllowed(AppUpdateManager.this.f38015f)) {
                            if (!iAppUpdateInfo.isUpdateDeveloperTriggeredInProgress()) {
                                return;
                            }
                            if (AppUpdateManager.this.f38017h.isForceUpdate(AppUpdateManager.this.f38015f) || !AppUpdateManager.this.f38017h.isDownloaded(iAppUpdateInfo.installStatus())) {
                                if (AppUpdateManager.this.f38017h.isForceUpdate(AppUpdateManager.this.f38015f) && AppUpdateManager.this.f38017h != null) {
                                    AppUpdateManager.this.f38017h.startUpdateFlowForResult(iAppUpdateInfo, AppUpdateManager.this.f38015f, AppUpdateManager.this.f38013c, 1099);
                                }
                            } else if (AppUpdateManager.this.f38017h != null) {
                                AppUpdateManager.this.f38017h.completeUpdate(AppUpdateManager.this.f38013c);
                            }
                        } else if (AppUpdateManager.this.f38017h != null) {
                            AppUpdateManager.this.f38017h.startUpdateFlowForResult(iAppUpdateInfo, AppUpdateManager.this.f38015f, fragmentActivity, 1099);
                        }
                    }
                }
            }, new OnFailureListener() {
                public void onFailure(Exception exc) {
                    exc.printStackTrace();
                }
            });
        }
    }

    public void onResume() {
        IAppUpdateManager iAppUpdateManager = this.f38017h;
        if (iAppUpdateManager != null) {
            iAppUpdateManager.createAppUpdateInfoTask(this.f38013c, new OnSuccessListener<IAppUpdateInfo>() {
                public void onSuccess(IAppUpdateInfo iAppUpdateInfo) {
                    if (iAppUpdateInfo != null && AppUpdateManager.this.f38017h != null) {
                        if (!AppUpdateManager.this.f38017h.isForceUpdate(AppUpdateManager.this.f38015f) && AppUpdateManager.this.f38017h.isDownloaded(iAppUpdateInfo.installStatus())) {
                            AppUpdateManager.this.f38017h.completeUpdate(AppUpdateManager.this.f38013c);
                        } else if (AppUpdateManager.this.f38017h.isForceUpdate(AppUpdateManager.this.f38015f) && iAppUpdateInfo.isUpdateDeveloperTriggeredInProgress()) {
                            AppUpdateManager.this.f38017h.startUpdateFlowForResult(iAppUpdateInfo, AppUpdateManager.this.f38015f, AppUpdateManager.this.f38013c, 1099);
                        }
                    }
                }
            }, (OnFailureListener) null);
        }
    }

    public void onDestroy() {
        IAppUpdateManager iAppUpdateManager = this.f38017h;
        if (iAppUpdateManager != null) {
            iAppUpdateManager.unregisterListener(this.f38013c, this.f38018i);
        }
    }

    public void startAppCheckUpdate() {
        AppUpdateInfo loadAppUpdateInfo = loadAppUpdateInfo();
        boolean z = false;
        if (isSupportPlayUpdate() && this.f38013c != null && m28692b(loadAppUpdateInfo)) {
            if (loadAppUpdateInfo.isForceUpdate == 1) {
                z = true;
            }
            startAppUpdateCheck(z, this.f38013c);
        } else if (startAppCheckUpdate(loadAppUpdateInfo) && m28692b(loadAppUpdateInfo)) {
            showAppUpdateDialog(loadAppUpdateInfo, false);
        }
    }

    public void startAppCheckUpdateByPlay(AppUpdateInfo appUpdateInfo) {
        if (this.f38013c != null && appUpdateInfo != null) {
            boolean z = true;
            if (appUpdateInfo.isForceUpdate != 1) {
                z = false;
            }
            startAppUpdateCheck(z, this.f38013c);
        }
    }

    public boolean startAppCheckUpdate(AppUpdateInfo appUpdateInfo) {
        FragmentActivity fragmentActivity = this.f38013c;
        if (fragmentActivity == null || appUpdateInfo == null || m28683a(appUpdateInfo.latestVersion) <= m28683a(m28685a((Context) fragmentActivity))) {
            return false;
        }
        return true;
    }

    public AppUpdateInfo loadAppUpdateInfo() {
        IToggle iToggle;
        if (AnalysisAPK.isGlobalHmsApk(this.f38013c)) {
            iToggle = Apollo.getToggle(APP_UPDATE_TOGGLE_HMS);
        } else if (AppUtils.isGlobalApp(this.f38013c)) {
            iToggle = Apollo.getToggle(APP_UPDATE_TOGGLE);
        } else {
            iToggle = AppUtils.isBrazilApp(this.f38013c) ? Apollo.getToggle(APP_UPDATE_TOGGLE_BRAZIL) : null;
        }
        return loadAppUpdateInfo(iToggle);
    }

    public AppUpdateInfo loadAppUpdateInfo(IToggle iToggle) {
        if (iToggle != null && iToggle.allow()) {
            IExperiment experiment = iToggle.getExperiment();
            AppUpdateInfo appUpdateInfo = new AppUpdateInfo();
            if (experiment != null) {
                appUpdateInfo.updateUrl = (String) experiment.getParam("update_url_android", "");
                appUpdateInfo.title = (String) experiment.getParam("title", "");
                appUpdateInfo.content = (String) experiment.getParam("content", "");
                if (!TextUtils.isEmpty(appUpdateInfo.content)) {
                    appUpdateInfo.content = appUpdateInfo.content.replace("\\n", "\n");
                }
                appUpdateInfo.cancelBtn = (String) experiment.getParam("cancel_btn", "");
                appUpdateInfo.ensureBtn = (String) experiment.getParam("ensure_btn", "");
                appUpdateInfo.isForceUpdate = ((Integer) experiment.getParam("is_force", 0)).intValue();
                appUpdateInfo.latestVersion = (String) experiment.getParam("latest_version", "");
                appUpdateInfo.promptDurationHour = ((Integer) experiment.getParam("prompt_duration_hour", 0)).intValue();
                if (isSupportPlayUpdate() || !m28688a(appUpdateInfo)) {
                    return appUpdateInfo;
                }
                return null;
            } else if (isSupportPlayUpdate()) {
                appUpdateInfo.isForceUpdate = 0;
                return appUpdateInfo;
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m28688a(AppUpdateInfo appUpdateInfo) {
        if (appUpdateInfo == null || TextUtils.isEmpty(appUpdateInfo.title) || TextUtils.isEmpty(appUpdateInfo.content) || TextUtils.isEmpty(appUpdateInfo.ensureBtn)) {
            return true;
        }
        if (m28689a(appUpdateInfo, false) || !TextUtils.isEmpty(appUpdateInfo.cancelBtn)) {
            return false;
        }
        return true;
    }

    public boolean isSupportPlayUpdate() {
        ICollector iCollector = this.f38016g;
        return (iCollector == null || !iCollector.isSupportPlayUpdate(this.f38013c) || this.f38017h == null) ? false : true;
    }

    public void showAppUpdateDialog(final AppUpdateInfo appUpdateInfo, final boolean z) {
        FragmentActivity fragmentActivity = this.f38013c;
        if (fragmentActivity != null && appUpdateInfo != null) {
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            AppUpdateAlertDialog.Builder builder = new AppUpdateAlertDialog.Builder(this.f38013c);
            builder.setTitle(appUpdateInfo.title).setMessage(appUpdateInfo.content).setPositiveButton(appUpdateInfo.ensureBtn, new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    OmegaSDKAdapter.trackEvent("app_force_update_confirm_ck");
                    if (!AppUpdateManager.this.m28689a(appUpdateInfo, z) && AppUpdateManager.this.f38014d != null) {
                        AppUpdateManager.this.f38014d.dismiss();
                    }
                    AppUpdateManager.this.m28687a(appUpdateInfo.updateUrl, AnalysisAPK.isGlobalHmsApk(AppUpdateManager.this.f38013c) ? AppUpdateManager.f38011b : "com.android.vending");
                }
            });
            if (!m28689a(appUpdateInfo, z)) {
                builder.setNegativeButton(appUpdateInfo.cancelBtn, new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        OmegaSDKAdapter.trackEvent("app_force_update_cancel_ck");
                        if (AppUpdateManager.this.f38014d != null) {
                            AppUpdateManager.this.f38014d.dismiss();
                        }
                    }
                });
            }
            if (m28689a(appUpdateInfo, z)) {
                builder.setCancelable(false);
            }
            AppUpdateAlertDialog create = builder.create();
            this.f38014d = create;
            try {
                create.show(supportFragmentManager, (String) null);
                OmegaSDKAdapter.trackEvent("app_force_update_sw");
                this.f38013c.runOnUiThread(new Runnable() {
                    public void run() {
                        Dialog dialog = AppUpdateManager.this.f38014d.getDialog();
                        if (AppUpdateManager.this.m28689a(appUpdateInfo, z) && dialog != null) {
                            dialog.setCanceledOnTouchOutside(true);
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m28689a(AppUpdateInfo appUpdateInfo, boolean z) {
        return appUpdateInfo != null && appUpdateInfo.isForceUpdate > 0 && !z;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28687a(String str, String str2) {
        if (this.f38013c != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (!TextUtils.isEmpty(str2)) {
                    intent.setPackage(str2);
                }
                intent.addFlags(268435456);
                this.f38013c.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private int m28683a(String str) {
        try {
            Matcher matcher = Pattern.compile("^(\\d+\\.){2}\\d+$").matcher(str);
            if (matcher.find()) {
                String[] split = matcher.group().split("\\.");
                return (Integer.valueOf(split[0]).intValue() * 1000000) + (Integer.valueOf(split[1]).intValue() * 1000) + Integer.valueOf(split[2]).intValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /* renamed from: a */
    private String m28685a(Context context) {
        try {
            return SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: b */
    private boolean m28692b(AppUpdateInfo appUpdateInfo) {
        if (appUpdateInfo == null) {
            return false;
        }
        AppUpdateSharedPreferences appUpdateSharedPreferences = new AppUpdateSharedPreferences(this.f38013c);
        if (System.currentTimeMillis() - appUpdateSharedPreferences.getAppUpdateLastTime() <= ((long) (appUpdateInfo.promptDurationHour * 60 * 60 * 1000))) {
            return false;
        }
        appUpdateSharedPreferences.setAppUpdateLastTime(System.currentTimeMillis());
        return true;
    }
}
