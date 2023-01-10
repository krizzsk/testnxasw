package com.didi.sdk.sidebar.component;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.appupdate.AppUpdateInfo;
import com.didi.sdk.appupdate.AppUpdateManager;
import com.didi.sdk.appupdate.AppUpdateProgressDialog;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.util.AnalysisAPK;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.taxis99.R;
import java.util.HashMap;

@ComponentType(name = "menu_setting_checkupdate")
public class CheckUpdateComponent extends NavigationWithArrowComponent {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f39903a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public AppUpdateManager f39904b;

    public CheckUpdateComponent(BaseBusinessContext baseBusinessContext, SidebarItem sidebarItem, String str) {
        super(baseBusinessContext, sidebarItem, str);
        this.f39903a = baseBusinessContext.getContext();
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        super.onClick(view);
        if (this.businessContext != null && (this.businessContext.getContext() instanceof FragmentActivity)) {
            try {
                final FragmentActivity fragmentActivity = (FragmentActivity) this.businessContext.getContext();
                AppUpdateProgressDialog.showDialog(fragmentActivity, ResourcesHelper.getString(fragmentActivity, R.string.app_is_checking_update), false);
                new Thread() {
                    public void run() {
                        IToggle iToggle;
                        super.run();
                        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
                        HashMap hashMap = new HashMap();
                        hashMap.put("__lang", nationComponentData.getGLang());
                        if (AnalysisAPK.isGlobalHmsApk(CheckUpdateComponent.this.f39903a)) {
                            iToggle = Apollo.getSyncToggle(AppUpdateManager.APP_UPDATE_TOGGLE_HMS, hashMap);
                        } else if (AppUtils.isGlobalApp(CheckUpdateComponent.this.f39903a)) {
                            iToggle = Apollo.getSyncToggle(AppUpdateManager.APP_UPDATE_TOGGLE, hashMap);
                        } else {
                            iToggle = AppUtils.isBrazilApp(CheckUpdateComponent.this.f39903a) ? Apollo.getSyncToggle(AppUpdateManager.APP_UPDATE_TOGGLE, hashMap) : null;
                        }
                        CheckUpdateComponent.this.m30033a(fragmentActivity, iToggle);
                    }
                }.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30033a(final FragmentActivity fragmentActivity, final IToggle iToggle) {
        if (fragmentActivity != null) {
            fragmentActivity.runOnUiThread(new Runnable() {
                public void run() {
                    AppUpdateProgressDialog.dismissProgressDialogFragmentSafely();
                    AppUpdateManager unused = CheckUpdateComponent.this.f39904b = new AppUpdateManager(fragmentActivity);
                    AppUpdateInfo loadAppUpdateInfo = CheckUpdateComponent.this.f39904b.loadAppUpdateInfo(iToggle);
                    if (CheckUpdateComponent.this.f39904b.isSupportPlayUpdate()) {
                        CheckUpdateComponent.this.f39904b.startAppCheckUpdateByPlay(loadAppUpdateInfo);
                    } else if (CheckUpdateComponent.this.f39904b.startAppCheckUpdate(loadAppUpdateInfo)) {
                        CheckUpdateComponent.this.f39904b.showAppUpdateDialog(loadAppUpdateInfo, true);
                    } else {
                        SystemUtils.showToast(Toast.makeText(CheckUpdateComponent.this.businessContext.getContext(), ResourcesHelper.getString(fragmentActivity, R.string.app_is_the_latest_version), 0));
                    }
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        AppUpdateManager appUpdateManager = this.f39904b;
        if (appUpdateManager != null) {
            appUpdateManager.onDestroy();
        }
    }

    public void onResume() {
        super.onResume();
        AppUpdateManager appUpdateManager = this.f39904b;
        if (appUpdateManager != null) {
            appUpdateManager.onResume();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        AppUpdateManager appUpdateManager = this.f39904b;
        if (appUpdateManager != null) {
            appUpdateManager.onActivityResult(i, i2, intent);
        }
    }
}
