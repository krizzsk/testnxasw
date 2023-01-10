package com.didi.dimina.container.bridge;

import android.content.Context;
import android.text.TextUtils;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.loading.DefaultLoadingManager;
import com.didi.dimina.container.bridge.loadsubpackage.CustomSubpackageLoadingManager;
import com.didi.dimina.container.bundle.BundleManager;
import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.bundle.bean.AppInfo;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.monitor.TrackSubPackExec;
import com.didi.dimina.container.p065ui.loadpage.AbsLoadingManager;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.PathUtil;
import com.didi.dimina.container.util.TimeUtil;
import com.didi.dimina.container.util.TraceUtil;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.bridge.d */
/* compiled from: PackageSubJSBridge */
class C8041d {

    /* renamed from: a */
    public static final String f18598a = "PackageSubJSBridge";

    /* renamed from: b */
    private final DMConfig f18599b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final DMMina f18600c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final AbsLoadingManager f18601d;

    public C8041d(DMMina dMMina, Context context, DMConfig dMConfig) {
        this.f18600c = dMMina;
        this.f18599b = dMConfig;
        if (dMConfig == null || dMConfig.getUIConfig().getSubPackageLoadingViewClazz() == null) {
            this.f18601d = new DefaultLoadingManager(context, (String) null, this.f18600c);
        } else {
            this.f18601d = new CustomSubpackageLoadingManager(context, this.f18600c);
        }
        LogUtil.m16841i("PackageSubJSBridge init");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo59662a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        int minaIndex = this.f18600c.getMinaIndex();
        TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.PACKAGE_LOAD_JS_FILE_TO_DATA_THREAD_START, "params: " + jSONObject);
        String optString = jSONObject.optString("package", "");
        if (TextUtils.isEmpty(optString)) {
            optString = "app";
        }
        this.f18600c.getPerformance().markJSPackageStart();
        LogUtil.iRelease(InternalJSMethod.LOAD_JS_FILE_TO_DATA_THREAD, "开始加载分包 packageName:" + optString);
        BundleManager.getInstance().isSubpackageInstalled(this.f18600c, optString, new BundleManagerStrategy.SubpackageInstallCallback(optString, callbackFunction, "/app-service.js") {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ CallbackFunction f$2;
            public final /* synthetic */ String f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void callback(boolean z) {
                C8041d.this.m15826a(this.f$1, this.f$2, this.f$3, z);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15826a(String str, CallbackFunction callbackFunction, String str2, boolean z) {
        if (z) {
            LogUtil.iRelease(InternalJSMethod.LOAD_JS_FILE_TO_DATA_THREAD, "分包已存在，直接读取分包 packageName:" + str);
            m15823a(callbackFunction, str, str2);
            return;
        }
        this.f18601d.show();
        LogUtil.iRelease(InternalJSMethod.LOAD_JS_FILE_TO_DATA_THREAD, "isInstall 为false, packageName:" + str);
        BundleManager.getInstance().cancelDownloadOtherPackage(this.f18600c);
        BundleManager.getInstance().installSubpackage(false, this.f18600c, str, new PackageSubJSBridge$1(this, TimeUtil.currentNanoMillis(), callbackFunction, str, str2));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15823a(CallbackFunction callbackFunction, String str, String str2) {
        BundleManager.getInstance().requireContent(this.f18600c, str, str2, new BundleManagerStrategy.ReadFileCallBack(str, str2, callbackFunction) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ String f$2;
            public final /* synthetic */ CallbackFunction f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onRead(boolean z, BundleManagerStrategy.FileInfo fileInfo) {
                C8041d.this.m15827a(this.f$1, this.f$2, this.f$3, z, fileInfo);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15827a(String str, String str2, CallbackFunction callbackFunction, boolean z, BundleManagerStrategy.FileInfo fileInfo) {
        if (!z) {
            LogUtil.iRelease(InternalJSMethod.LOAD_JS_FILE_TO_DATA_THREAD, "分包：" + str + str2 + "  内容为空");
            this.f18601d.dismiss();
            CallBackUtil.onFail("加载包" + str + str2 + "失败", callbackFunction);
            TraceUtil.trackEventCoreDotting(this.f18600c.getMinaIndex(), Constant.CORE_DOTTING.PACKAGE_LOAD_JS_FILE_TO_DATA_THREAD_FAILED, "content is empty");
            return;
        }
        LogUtil.iRelease(InternalJSMethod.LOAD_JS_FILE_TO_DATA_THREAD, "分包：" + str + str2 + "  加载成功");
        String appId = this.f18600c.getConfig().getLaunchConfig().getAppId();
        StringBuilder sb = new StringBuilder();
        sb.append("loadJSFileToDataThread-> mDmMina.getJsAppBundleConfig");
        sb.append(this.f18600c.getJsAppBundleConfig());
        LogUtil.iRelease(f18598a, sb.toString());
        AppInfo.ModuleInfo appPackageInfo = BundleManager.getInstance().getAppPackageInfo(this.f18600c, str);
        String str3 = appPackageInfo != null ? appPackageInfo.version : "";
        String jSFileForStackUnwind = PathUtil.getJSFileForStackUnwind(this.f18600c.getJSAppConfig(), str, str2);
        if (TextUtils.isEmpty(str3)) {
            this.f18600c.getJSEngine().executeScriptFile(fileInfo.getContent(), jSFileForStackUnwind, new TrackSubPackExec(this.f18600c, str, new IDMCommonAction(callbackFunction) {
                public final /* synthetic */ CallbackFunction f$1;

                {
                    this.f$1 = r2;
                }

                public final void callback(Object obj) {
                    C8041d.this.m15829b(this.f$1, (Void) obj);
                }
            }));
        } else {
            this.f18600c.getJSEngine().executeScriptFile(fileInfo.getContent(), jSFileForStackUnwind, this.f18600c.getMinaIndex(), appId, str, str2, str3, new TrackSubPackExec(this.f18600c, str, new IDMCommonAction(callbackFunction) {
                public final /* synthetic */ CallbackFunction f$1;

                {
                    this.f$1 = r2;
                }

                public final void callback(Object obj) {
                    C8041d.this.m15824a(this.f$1, (Void) obj);
                }
            }));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m15829b(CallbackFunction callbackFunction, Void voidR) {
        this.f18600c.getPerformance().markJSPackageEnd();
        this.f18601d.dismiss();
        CallBackUtil.onSuccess(callbackFunction);
        TraceUtil.trackEventCoreDotting(this.f18600c.getMinaIndex(), Constant.CORE_DOTTING.PACKAGE_LOAD_JS_FILE_TO_DATA_THREAD_SUCCESS, "type: localAction/remoteAction, isInstall");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15824a(CallbackFunction callbackFunction, Void voidR) {
        this.f18600c.getPerformance().markJSPackageEnd();
        this.f18601d.dismiss();
        CallBackUtil.onSuccess(callbackFunction);
        TraceUtil.trackEventCoreDotting(this.f18600c.getMinaIndex(), Constant.CORE_DOTTING.PACKAGE_LOAD_JS_FILE_TO_DATA_THREAD_SUCCESS, "type: releaseAction, isInstall");
    }
}
