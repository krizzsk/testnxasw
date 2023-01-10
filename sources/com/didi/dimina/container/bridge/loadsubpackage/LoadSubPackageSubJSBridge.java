package com.didi.dimina.container.bridge.loadsubpackage;

import android.content.Context;
import android.text.TextUtils;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bridge.InternalJSMethod;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.loading.DefaultLoadingManager;
import com.didi.dimina.container.bundle.BundleManager;
import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.bundle.bean.AppInfo;
import com.didi.dimina.container.p065ui.loadpage.AbsLoadingManager;
import com.didi.dimina.container.page.IPageHost;
import com.didi.dimina.container.page.ITabBarPageHost;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TimeUtil;
import com.didi.dimina.container.util.TraceUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import org.json.JSONObject;

public class LoadSubPackageSubJSBridge {

    /* renamed from: a */
    private final DMConfig f18631a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final DMMina f18632b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AbsLoadingManager f18633c;

    public LoadSubPackageSubJSBridge(DMMina dMMina, Context context, DMConfig dMConfig) {
        this.f18631a = dMConfig;
        this.f18632b = dMMina;
        if (dMConfig == null || dMConfig.getUIConfig().getSubPackageLoadingViewClazz() == null) {
            this.f18633c = new DefaultLoadingManager(context, (String) null, dMMina);
        } else {
            this.f18633c = new CustomSubpackageLoadingManager(context, dMMina);
        }
        LogUtil.m16841i("LoadSubPackageSubJSBridge init");
    }

    public void loadSubPackage(JSONObject jSONObject, CallbackFunction callbackFunction) {
        int minaIndex = this.f18632b.getMinaIndex();
        TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.PACKAGE_LOAD_SUB_PACKAGE_START, "params: " + jSONObject);
        String optString = jSONObject.optString("package", "");
        if (TextUtils.isEmpty(optString)) {
            int minaIndex2 = this.f18632b.getMinaIndex();
            TraceUtil.trackEventCoreDotting(minaIndex2, Constant.CORE_DOTTING.PACKAGE_LOAD_SUB_PACKAGE_FAILED, "params: " + jSONObject);
            CallBackUtil.onFail("加载分包 传入页面为空", callbackFunction);
            return;
        }
        LogUtil.iRelease(InternalJSMethod.LOAD_SUB_PACKAGE, "开始加载分包 packageName:" + optString);
        BundleManager.getInstance().isSubpackageInstalled(this.f18632b, optString, new BundleManagerStrategy.SubpackageInstallCallback(this.f18632b.getConfig().getLaunchConfig().getBundleManagerStrategy(), callbackFunction, optString) {
            public final /* synthetic */ BundleManagerStrategy f$1;
            public final /* synthetic */ CallbackFunction f$2;
            public final /* synthetic */ String f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void callback(boolean z) {
                LoadSubPackageSubJSBridge.this.m15876a(this.f$1, this.f$2, this.f$3, z);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15876a(BundleManagerStrategy bundleManagerStrategy, CallbackFunction callbackFunction, String str, boolean z) {
        if (z) {
            int minaIndex = this.f18632b.getMinaIndex();
            TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.PACKAGE_LOAD_SUB_PACKAGE_SUCCESS, "type: " + bundleManagerStrategy.getTag() + ", isInstall");
            CallBackUtil.onSuccess(callbackFunction);
            return;
        }
        this.f18633c.show();
        BundleManager.getInstance().cancelDownloadOtherPackage(this.f18632b);
        final long currentNanoMillis = TimeUtil.currentNanoMillis();
        final CallbackFunction callbackFunction2 = callbackFunction;
        final String str2 = str;
        BundleManager.getInstance().installSubpackage(false, this.f18632b, str, new BundleManagerStrategy.SubpackageInfoCallback() {
            public void callback(int i, AppInfo.ModuleInfo moduleInfo) {
                if (i == 0) {
                    LoadSubPackageSubJSBridge.this.f18632b.getPerformance().appendStartSubPackageLoadTime(TimeUtil.currentNanoMillis() - currentNanoMillis);
                    CallBackUtil.onSuccess(callbackFunction2);
                    LoadSubPackageSubJSBridge.this.f18633c.dismiss();
                    int minaIndex = LoadSubPackageSubJSBridge.this.f18632b.getMinaIndex();
                    TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.PACKAGE_LOAD_SUB_PACKAGE_SUCCESS, "type: releaseAction, moduleInfo: " + moduleInfo);
                    return;
                }
                CallBackUtil.onFail("加载分包" + str2 + "失败", callbackFunction2);
                LoadSubPackageSubJSBridge.this.f18633c.dismiss();
                int minaIndex2 = LoadSubPackageSubJSBridge.this.f18632b.getMinaIndex();
                TraceUtil.trackEventCoreDotting(minaIndex2, Constant.CORE_DOTTING.PACKAGE_LOAD_SUB_PACKAGE_FAILED, "type: releaseAction, errCode: " + i);
            }
        });
    }

    public void switchTabLoadJSFileToDataThreadFinish(JSONObject jSONObject, CallbackFunction callbackFunction) {
        TraceUtil.trackEventCoreDotting(this.f18632b.getMinaIndex(), Constant.CORE_DOTTING.LAUNCH_SWITCH_TAB_LOAD_JS_FILE_TO_DATA_THREAD_FINISH, "");
        IPageHost currentPage = this.f18632b.getCurNavigator().getCurrentPage();
        if (currentPage instanceof ITabBarPageHost) {
            UIHandlerUtil.runOnUiThread(new Runnable(jSONObject) {
                public final /* synthetic */ JSONObject f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    IPageHost.this.switchTabLoadJSFileToDataThreadFinish(this.f$1);
                }
            });
        }
    }
}
