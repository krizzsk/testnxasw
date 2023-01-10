package com.didi.dimina.container;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bean.JSAppConfig;
import com.didi.dimina.container.bridge.DMServiceJSModule;
import com.didi.dimina.container.bridge.DMWebViewJSModule;
import com.didi.dimina.container.bridge.ForceUpdateSubJSBridge;
import com.didi.dimina.container.bridge.LaunchOptionsSubJSBridge;
import com.didi.dimina.container.bridge.base.BridgeModule;
import com.didi.dimina.container.bridge.plugin.GlobalJSModuleManager;
import com.didi.dimina.container.bridge.plugin.MinaJSModuleManager;
import com.didi.dimina.container.bridge.plugin.exception.MinaBridgeModuleNotFoundException;
import com.didi.dimina.container.bridge.plugin.exception.MinaBridgeModuleRegisteredException;
import com.didi.dimina.container.bridge.storage.MMKVUtil;
import com.didi.dimina.container.bridge.storage.SpiltMMKVUtil;
import com.didi.dimina.container.bundle.BundleManager;
import com.didi.dimina.container.bundle.BundleManagerStrategy;
import com.didi.dimina.container.bundle.bean.AppInfo;
import com.didi.dimina.container.bundle.bean.BundleConfig;
import com.didi.dimina.container.debug.IWebSocketMsgSender;
import com.didi.dimina.container.jsengine.JSEngineWrapper;
import com.didi.dimina.container.jsengine.JSGlobalMethodInject;
import com.didi.dimina.container.messager.DMMessageTransfer;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.messager.jsmodule.BaseServiceModule;
import com.didi.dimina.container.messager.jsmodule.JSModuleWrapper;
import com.didi.dimina.container.mina.DMFrontBackgroundManager;
import com.didi.dimina.container.mina.DMLaunchLifecycleManager;
import com.didi.dimina.container.mina.DMMemoryManager;
import com.didi.dimina.container.mina.DMMinaHelper;
import com.didi.dimina.container.mina.DMMinaNavigatorDelegate;
import com.didi.dimina.container.mina.DMMinaPerformance;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.mina.DMSandboxHelper;
import com.didi.dimina.container.mina.DMThreadPool;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.mina.IDMNavigator;
import com.didi.dimina.container.mina.IDMVConsole;
import com.didi.dimina.container.monitor.DeviceMonitor;
import com.didi.dimina.container.monitor.DeviceTraceEvent;
import com.didi.dimina.container.monitor.ErrorCode;
import com.didi.dimina.container.monitor.PageProcessStat;
import com.didi.dimina.container.monitor.PerformanceDotType;
import com.didi.dimina.container.p065ui.dialog.BaseModal;
import com.didi.dimina.container.page.DMPagePool;
import com.didi.dimina.container.page.IPageHost;
import com.didi.dimina.container.util.CoreDottingExtra;
import com.didi.dimina.container.util.DebugKitStoreUtil;
import com.didi.dimina.container.util.HttpUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.PathUtil;
import com.didi.dimina.container.util.TimeUtil;
import com.didi.dimina.container.util.TraceUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.dimina.container.util.VersionUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class DMMina implements LifecycleObserver {
    public static final String TAG = "DMMina";
    public static final String TAG_FORCE_UPDATE = "forceUpdate";

    /* renamed from: A */
    private final IDMVConsole f18410A;

    /* renamed from: B */
    private volatile SpiltMMKVUtil f18411B;

    /* renamed from: C */
    private final ConcurrentHashMap<Integer, WebViewEngine> f18412C = new ConcurrentHashMap<>();

    /* renamed from: D */
    private boolean f18413D = false;

    /* renamed from: E */
    private IWebSocketMsgSender f18414E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public int f18415F = 1;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final int f18416a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final DMConfig f18417b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final List<DMMinaNavigatorDelegate> f18418c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public DMMinaNavigatorDelegate f18419d;

    /* renamed from: e */
    private JSEngineWrapper f18420e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public DMMessageTransfer f18421f;

    /* renamed from: g */
    private JSAppConfig f18422g;

    /* renamed from: h */
    private final AtomicInteger f18423h = new AtomicInteger(1);

    /* renamed from: i */
    private final DMPagePool f18424i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final DMMinaPerformance f18425j;

    /* renamed from: k */
    private IDMCommonAction<Void> f18426k = null;

    /* renamed from: l */
    private JSGlobalMethodInject f18427l = null;

    /* renamed from: m */
    private boolean f18428m;
    public final DMMemoryManager.MinaMemoryInfo memoryInfo = new DMMemoryManager.MinaMemoryInfo();

    /* renamed from: n */
    private boolean f18429n;

    /* renamed from: o */
    private int f18430o = 1;

    /* renamed from: p */
    private FragmentActivity f18431p;

    /* renamed from: q */
    private BundleConfig f18432q;

    /* renamed from: r */
    private BundleConfig f18433r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public BundleConfig f18434s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public BundleConfig f18435t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f18436u = 1;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public IDMCommonAction<Void> f18437v;

    /* renamed from: w */
    private IDMCommonAction<Void> f18438w;

    /* renamed from: x */
    private final DMFrontBackgroundManager f18439x;

    /* renamed from: y */
    private PageProcessStat f18440y;

    /* renamed from: z */
    private final MinaJSModuleManager f18441z = new MinaJSModuleManager();

    public enum InstallStatus {
        START,
        LOCAL_COMPLETE,
        REMOTE_COMPLETE,
        TRIGGER_FORCE_UPDATE,
        FORCE_UPDATE_COMPLETE,
        BUNDLE_CONFIG_VALID,
        SUB_PRE_COMPLETE
    }

    public interface LaunchExitStatus {
        public static final int LAUNCH_EXITED = 4;
        public static final int LAUNCH_EXITING = 3;
        public static final int LAUNCH_EXIT_READY = 2;
        public static final int LAUNCH_NORMAL = 1;
    }

    public interface PreInstallStatus {
        public static final int LOCAL_FINISH = 3;
        public static final int NO_START = 1;
        public static final int REMOTE_FINISH = 4;
        public static final int START_PRE_INSTALL = 2;
    }

    public interface PreloadStatus {
        public static final int FINISH = 3;
        public static final int LOADING = 2;
        public static final int NO_START = 1;
    }

    public DMMina(FragmentActivity fragmentActivity, int i, DMConfig dMConfig) {
        this.f18431p = fragmentActivity;
        this.f18417b = dMConfig;
        this.f18418c = new ArrayList();
        if (this.f18417b.checkParam()) {
            this.f18416a = i;
            this.f18425j = new DMMinaPerformance(this);
            this.f18439x = new DMFrontBackgroundManager();
            this.f18441z.initDiminaJSModules();
            this.f18424i = new DMPagePool(this, this.f18431p);
            if (DebugKitStoreUtil.getVConsole(this.f18417b.getLaunchConfig().getAppId())) {
                this.f18410A = new IDMVConsole.RealVConsole();
            } else {
                this.f18410A = new IDMVConsole.NOVConsole();
            }
            if (this.f18431p != null && this.f18417b.getLaunchConfig().isBindActivityLifecycle()) {
                this.f18431p.getLifecycle().addObserver(this);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("参数出错");
    }

    public void preload() {
        preload((IDMCommonAction<InstallStatus>) null, (IDMCommonAction<Void>) null, (IDMCommonAction<Void>) null);
    }

    public void launch(IDMNavigator iDMNavigator) {
        DMMina dMMina = DMMinaPool.get(this.f18416a);
        if (dMMina == null || dMMina.getConfig() == null || dMMina.getConfig().getLaunchConfig() == null) {
            LogUtil.eRelease(TAG, "实例已经被销毁，不需要再launch()了");
        } else {
            launch(iDMNavigator, (JSONObject) null, (JSONObject) null);
        }
    }

    public void launch(IDMNavigator iDMNavigator, JSONObject jSONObject, JSONObject jSONObject2) {
        TraceUtil.trackEventCoreDotting(this.f18416a, Constant.CORE_DOTTING.LAUNCH_DMMINA, CoreDottingExtra.create().with("navigator", iDMNavigator).with("stackOptions", jSONObject).with("showOptions", jSONObject2).toInfo());
        DeviceTraceEvent.trackEvent(this.f18416a, PerformanceDotType.OPEN_DIMINA, new DeviceMonitor());
        DMMinaNavigatorDelegate dMMinaNavigatorDelegate = this.f18419d;
        if (dMMinaNavigatorDelegate != null) {
            hideStack(dMMinaNavigatorDelegate.getIndex());
        }
        final DMMinaNavigatorDelegate dMMinaNavigatorDelegate2 = new DMMinaNavigatorDelegate(iDMNavigator);
        dMMinaNavigatorDelegate2.setExtraOptions(jSONObject);
        dMMinaNavigatorDelegate2.setExtraShowOptions(jSONObject2);
        this.f18419d = dMMinaNavigatorDelegate2;
        this.f18418c.add(dMMinaNavigatorDelegate2);
        DMLaunchLifecycleManager.getInstance().hookAppLaunch(this);
        this.f18425j.markAppLaunch();
        int i = this.f18430o;
        if (i == 1) {
            this.f18426k = new IDMCommonAction<Void>() {
                public void callback(Void voidR) {
                    DMMina.this.m15577a(dMMinaNavigatorDelegate2.getIndex());
                }
            };
            preload((IDMCommonAction<InstallStatus>) null, new IDMCommonAction<Void>() {
                public void callback(Void voidR) {
                    DMLaunchLifecycleManager.getInstance().hookAppConfigReady(DMMina.this);
                }
            }, (IDMCommonAction<Void>) null);
        } else if (i == 2) {
            this.f18426k = new IDMCommonAction<Void>() {
                public void callback(Void voidR) {
                    DMMina.this.m15577a(dMMinaNavigatorDelegate2.getIndex());
                }
            };
            DMLaunchLifecycleManager.getInstance().hookAppConfigReady(this);
        } else if (i == 3) {
            m15577a(dMMinaNavigatorDelegate2.getIndex());
            DMLaunchLifecycleManager.getInstance().hookAppConfigReady(this);
        }
        dMMinaNavigatorDelegate2.showLaunchView(this.f18416a);
        MMKVUtil instance = MMKVUtil.getInstance();
        instance.save(Constant.KEY_PRE_INSTALL_RECENTLY_USED_JSAPP_PREFIX + DMMinaHelper.getJsAppId(this), Long.valueOf(System.currentTimeMillis()));
    }

    public void release(boolean z) {
        TraceUtil.trackEventCoreDotting(this.f18416a, Constant.CORE_DOTTING.DMMINA_RELEASE, CoreDottingExtra.create().with("force", Boolean.valueOf(z)).with("dmmina", toString()).toInfo());
        if (!this.f18425j.isFirstDomReady()) {
            TraceUtil.traceSagaWaitingTiming(this.f18416a, TimeUtil.currentNanoMillis() - this.f18425j.getMarkAppLaunchTime());
        }
        this.f18428m = true;
        this.f18429n = false;
        JSEngineWrapper jSEngineWrapper = this.f18420e;
        if (jSEngineWrapper != null) {
            jSEngineWrapper.release(z);
        }
        JSGlobalMethodInject jSGlobalMethodInject = this.f18427l;
        if (jSGlobalMethodInject != null) {
            jSGlobalMethodInject.release();
        }
        DMMessageTransfer dMMessageTransfer = this.f18421f;
        if (dMMessageTransfer != null) {
            dMMessageTransfer.release();
        }
        this.f18441z.release();
        for (JSModuleWrapper releaseServiceModuleInstance : GlobalJSModuleManager.getDMServiceSubJSModuleWrapper(this)) {
            releaseServiceModuleInstance.releaseServiceModuleInstance();
        }
        for (JSModuleWrapper releaseServiceModuleInstance2 : GlobalJSModuleManager.getGlobalJSModuleTables(this).values()) {
            releaseServiceModuleInstance2.releaseServiceModuleInstance();
        }
        GlobalJSModuleManager.release(this);
        FragmentActivity fragmentActivity = this.f18431p;
        if (fragmentActivity != null) {
            fragmentActivity.getLifecycle().removeObserver(this);
            this.f18431p = null;
        }
    }

    public void launchStackPage(String str, IDMNavigator iDMNavigator) {
        launchStackPage(str, (JSONObject) null, (JSONObject) null, iDMNavigator);
    }

    public void launchStackPage(String str, JSONObject jSONObject, IDMNavigator iDMNavigator) {
        launchStackPage(str, jSONObject, (JSONObject) null, iDMNavigator);
    }

    public void launchStackPage(String str, JSONObject jSONObject, JSONObject jSONObject2, IDMNavigator iDMNavigator) {
        TraceUtil.trackEventCoreDotting(this.f18416a, Constant.CORE_DOTTING.DMMINA_LAUNCH_STACK_PAGE, CoreDottingExtra.create().with("path", str).with("stackOptions", jSONObject).with("showOptions", jSONObject2).with("navigator", iDMNavigator).toInfo());
        JSONObject combineJson = JSONUtil.combineJson(HttpUtil.parseUrlQueryJSONObject(getConfig().getLaunchConfig().getAppId(), str), jSONObject2);
        DMMinaNavigatorDelegate dMMinaNavigatorDelegate = new DMMinaNavigatorDelegate(iDMNavigator);
        dMMinaNavigatorDelegate.setExtraOptions(jSONObject);
        dMMinaNavigatorDelegate.setExtraShowOptions(combineJson);
        this.f18419d = dMMinaNavigatorDelegate;
        this.f18418c.add(dMMinaNavigatorDelegate);
        getMessageTransfer().ddInvokeJSToJSEngineWhileBusinessReady(new Runnable(dMMinaNavigatorDelegate, str, combineJson) {
            public final /* synthetic */ DMMinaNavigatorDelegate f$1;
            public final /* synthetic */ String f$2;
            public final /* synthetic */ JSONObject f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                DMMina.this.m15586a(this.f$1, this.f$2, this.f$3);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15586a(DMMinaNavigatorDelegate dMMinaNavigatorDelegate, String str, JSONObject jSONObject) {
        int index = dMMinaNavigatorDelegate.getIndex();
        m15578a(index, dMMinaNavigatorDelegate.getExtraShowOptions());
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "openType", (Object) "appLaunchStack");
        JSONUtil.put(jSONObject2, "url", (Object) str);
        JSONUtil.put(jSONObject2, "query", (Object) jSONObject);
        JSONObject build = new MessageWrapperBuilder().stackId(index).data(jSONObject2).build();
        LogUtil.iRelease("navigateStack", "appLaunchStack: " + build.toString());
        getMessageTransfer().sendMessageToServiceFromNative("launchPage", build);
    }

    public void pushPage(String str, JSONObject jSONObject, int i) {
        TraceUtil.trackEventCoreDotting(this.f18416a, Constant.CORE_DOTTING.DMMINA_PUSH_PAGE, CoreDottingExtra.create().with("mMinaIndex", Integer.valueOf(this.f18416a)).with("path", str).with("query", jSONObject).with(MessageWrapperBuilder.ARG_STACK_ID, Integer.valueOf(i)).toInfo());
        getMessageTransfer().ddInvokeJSToJSEngineWhileBusinessReady(new Runnable(str, jSONObject, i) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ JSONObject f$2;
            public final /* synthetic */ int f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                DMMina.this.m15592a(this.f$1, this.f$2, this.f$3);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15592a(String str, JSONObject jSONObject, int i) {
        JSONObject combineJson = JSONUtil.combineJson(HttpUtil.parseUrlQueryJSONObject(getConfig().getLaunchConfig().getAppId(), str), jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "openType", (Object) "pushPage");
        JSONUtil.put(jSONObject2, "url", (Object) str);
        JSONUtil.put(jSONObject2, "query", (Object) combineJson);
        JSONObject build = new MessageWrapperBuilder().stackId(i).data(jSONObject2).build();
        int i2 = this.f18416a;
        TraceUtil.trackEventCoreDotting(i2, Constant.CORE_DOTTING.NAVIGATE_PUSH_PAGE, "msg: " + build);
        getMessageTransfer().sendMessageToServiceFromNative("pushPage", build);
    }

    public int findStackId(IDMNavigator iDMNavigator) {
        for (DMMinaNavigatorDelegate next : this.f18418c) {
            if (next != null && iDMNavigator == next.getNavigator()) {
                return next.getIndex();
            }
        }
        return -1;
    }

    public void showStack(int i) {
        showStack(i, (JSONObject) null);
    }

    public void showStack(int i, JSONObject jSONObject) {
        TraceUtil.trackEventCoreDotting(this.f18416a, Constant.CORE_DOTTING.DMMINA_SHOW_STACK, CoreDottingExtra.create().with(MessageWrapperBuilder.ARG_STACK_ID, Integer.valueOf(i)).with("extraShowOptions", jSONObject).toInfo());
        getMessageTransfer().ddInvokeJSToJSEngineWhileBusinessReady(new Runnable(i, jSONObject) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ JSONObject f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DMMina.this.m15578a(this.f$1, this.f$2);
            }
        });
    }

    /* renamed from: showStackImmediate */
    public void m15578a(int i, JSONObject jSONObject) {
        DMMinaNavigatorDelegate navigator = getNavigator(i);
        if (navigator == null || navigator.isStackShow()) {
            LogUtil.iRelease("navigateStack", "showStack failed: " + i);
            return;
        }
        for (DMMinaNavigatorDelegate next : this.f18418c) {
            if (next.isStackShow()) {
                hideStack(next.getIndex());
            }
        }
        navigator.setExtraShowOptions(jSONObject);
        this.f18419d = navigator;
        JSONObject build = new MessageWrapperBuilder().stackId(i).data(new JSONObject()).build();
        this.f18421f.sendMessageToServiceFromNative("showStack", build);
        navigator.setIsStackShow(true);
        TraceUtil.trackEventCoreDotting(this.f18416a, Constant.CORE_DOTTING.NAVIGATE_SHOW_STACK, CoreDottingExtra.create().with("msg", build).with("extraShowOptions", jSONObject).toInfo());
    }

    public void hideStack(int i) {
        int i2 = this.f18416a;
        TraceUtil.trackEventCoreDotting(i2, Constant.CORE_DOTTING.DMMINA_HIDE_STACK, "stackId: " + i);
        getMessageTransfer().ddInvokeJSToJSEngineWhileBusinessReady(new Runnable(i) {
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                DMMina.this.m15598b(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m15598b(int i) {
        DMMinaNavigatorDelegate navigator = getNavigator(i);
        if (navigator == null || !navigator.isStackShow()) {
            LogUtil.iRelease("navigateStack", "hideStack failed: " + i);
        } else {
            JSONObject build = new MessageWrapperBuilder().stackId(i).data(new JSONObject()).build();
            this.f18421f.sendMessageToServiceFromNative("hideStack", build);
            navigator.setIsStackShow(false);
            int i2 = this.f18416a;
            TraceUtil.trackEventCoreDotting(i2, Constant.CORE_DOTTING.NAVIGATE_HIDE_STACK, "msg: " + build);
        }
        if (navigator == this.f18419d) {
            this.f18419d = null;
        }
    }

    public void removeStack(final int i) {
        int i2 = this.f18416a;
        TraceUtil.trackEventCoreDotting(i2, Constant.CORE_DOTTING.DMMINA_REMOVE_STACK, "stackId: " + i);
        getMessageTransfer().ddInvokeJSToJSEngineWhileBusinessReady(new Runnable() {
            public void run() {
                DMMinaNavigatorDelegate navigator = DMMina.this.getNavigator(i);
                if (navigator != null) {
                    JSONObject build = new MessageWrapperBuilder().stackId(i).data(new JSONObject()).build();
                    DMMina.this.f18421f.sendMessageToServiceFromNative("removeStack", build);
                    int b = DMMina.this.f18416a;
                    TraceUtil.trackEventCoreDotting(b, Constant.CORE_DOTTING.NAVIGATE_REMOVE_STACK, "msg: " + build);
                }
                if (DMMina.this.f18419d == navigator) {
                    DMMinaNavigatorDelegate unused = DMMina.this.f18419d = null;
                }
                DMMina.this.f18418c.remove(navigator);
            }
        });
    }

    public IPageHost findPageHost(int i) {
        IPageHost page;
        for (DMMinaNavigatorDelegate next : this.f18418c) {
            if (next != null && (page = next.getPage(i)) != null) {
                return page;
            }
        }
        return null;
    }

    public DMMinaNavigatorDelegate getNavigator(int i) {
        for (DMMinaNavigatorDelegate next : this.f18418c) {
            if (next != null && next.getIndex() == i) {
                return next;
            }
        }
        return null;
    }

    public void preload(IDMCommonAction<InstallStatus> iDMCommonAction, final IDMCommonAction<Void> iDMCommonAction2, final IDMCommonAction<Void> iDMCommonAction3) {
        int i = this.f18416a;
        TraceUtil.trackEventCoreDotting(i, Constant.CORE_DOTTING.DMMINA_PRELOAD, "stateChangeListener: " + iDMCommonAction + ", configComplete: " + iDMCommonAction2 + ", dmServiceComplete: " + iDMCommonAction3);
        DMLaunchLifecycleManager.getInstance().hookJSEnginePreload(this);
        this.f18425j.markJSEnginePreload();
        this.f18430o = 2;
        this.f18421f = new DMMessageTransfer(this.f18416a);
        this.f18420e = new JSEngineWrapper(this.f18416a);
        JSGlobalMethodInject jSGlobalMethodInject = new JSGlobalMethodInject(this);
        this.f18427l = jSGlobalMethodInject;
        jSGlobalMethodInject.inject();
        new DMSandboxHelper(this.f18417b).clearTmpFile();
        this.f18438w = new IDMCommonAction<Void>() {
            public void callback(Void voidR) {
                ForceUpdateSubJSBridge.notifyBundleManager(DMMina.this);
            }
        };
        int i2 = this.f18436u;
        if (i2 == 1) {
            this.f18437v = new IDMCommonAction<Void>() {
                public void callback(Void voidR) {
                    DMMina.this.m15588a((IDMCommonAction<Void>) iDMCommonAction2, (IDMCommonAction<Void>) iDMCommonAction3);
                }
            };
            mo58937a((IDMCommonAction<Void>) null, (IDMCommonAction<Void>) null, iDMCommonAction);
        } else if (i2 == 2) {
            this.f18437v = new IDMCommonAction<Void>() {
                public void callback(Void voidR) {
                    DMMina.this.m15588a((IDMCommonAction<Void>) iDMCommonAction2, (IDMCommonAction<Void>) iDMCommonAction3);
                }
            };
        } else if (i2 == 3 || i2 == 4) {
            m15588a(iDMCommonAction2, iDMCommonAction3);
        }
    }

    public void preInstall(IDMCommonAction<InstallStatus> iDMCommonAction) {
        mo58937a((IDMCommonAction<Void>) null, (IDMCommonAction<Void>) null, iDMCommonAction);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo58937a(IDMCommonAction<Void> iDMCommonAction, IDMCommonAction<Void> iDMCommonAction2, IDMCommonAction<InstallStatus> iDMCommonAction3) {
        int i = this.f18416a;
        TraceUtil.trackEventCoreDotting(i, Constant.CORE_DOTTING.DMMINA_PRE_INSTALL, "localComplete: " + iDMCommonAction + ", remoteComplete: " + iDMCommonAction2 + ", stateChangeListener: " + iDMCommonAction3);
        this.f18436u = 2;
        if (iDMCommonAction3 != null) {
            iDMCommonAction3.callback(InstallStatus.START);
        }
        final Runnable[] runnableArr = new Runnable[1];
        final long currentTimeMillis = System.currentTimeMillis();
        final IDMCommonAction<Void> iDMCommonAction4 = iDMCommonAction;
        final IDMCommonAction<InstallStatus> iDMCommonAction5 = iDMCommonAction3;
        final IDMCommonAction<Void> iDMCommonAction6 = iDMCommonAction2;
        BundleManager.getInstance().install(this, new BundleManagerStrategy.InstallCallback() {
            private BundleConfig mLocalInstallJsAppConfig = null;
            private BundleConfig mLocalInstallJsSdkConfig = null;

            public void onOriginalPackageInstalled(BundleConfig bundleConfig, BundleConfig bundleConfig2) {
                LogUtil.iRelease(DMMina.TAG, "接受到本地安装结果, onLocalInstalled()-> jsSdkConfig=" + bundleConfig2 + "\t jsAppConfig=" + bundleConfig);
                if (bundleConfig == BundleConfig.NO_VERSION_BUNDLE_CONFIG && bundleConfig2 == BundleConfig.NO_VERSION_BUNDLE_CONFIG) {
                    int unused = DMMina.this.f18436u = 4;
                    IDMCommonAction iDMCommonAction = iDMCommonAction4;
                    if (iDMCommonAction != null) {
                        iDMCommonAction.callback(null);
                    }
                    if (DMMina.this.f18437v != null) {
                        DMMina.this.f18437v.callback(null);
                    }
                    IDMCommonAction iDMCommonAction2 = iDMCommonAction5;
                    if (iDMCommonAction2 != null) {
                        iDMCommonAction2.callback(InstallStatus.LOCAL_COMPLETE);
                        iDMCommonAction5.callback(InstallStatus.BUNDLE_CONFIG_VALID);
                    }
                    DMMina.this.m15602c();
                } else if (DMMina.this.f18415F == 1 && bundleConfig == null && bundleConfig2 == null) {
                    int minaIndex = DMMina.this.getMinaIndex();
                    TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.LAUNCH_EXIT_EMPTY_BUNDLE_DOWNLOAD_FAILED, "mina index: " + DMMina.this.getMinaIndex());
                    DMMina.this.f18425j.markLaunchFail(-1000, "包管理失败,无资源包");
                    DMMina.this.m15576a();
                } else {
                    this.mLocalInstallJsAppConfig = bundleConfig;
                    this.mLocalInstallJsSdkConfig = bundleConfig2;
                    AppInfo.ModuleInfo sDKPackageInfo = BundleManager.getInstance().getSDKPackageInfo(DMMina.this, Constant.BundleConstant.SDK_MODULE_NAME);
                    String str = "";
                    String str2 = (sDKPackageInfo == null || TextUtils.isEmpty(sDKPackageInfo.version)) ? str : sDKPackageInfo.version;
                    if (TextUtils.isEmpty(str2) && bundleConfig2 != null) {
                        str2 = bundleConfig2.versionCode;
                    }
                    AppInfo.ModuleInfo appPackageInfo = BundleManager.getInstance().getAppPackageInfo(DMMina.this, "app");
                    if (appPackageInfo != null && !TextUtils.isEmpty(appPackageInfo.version)) {
                        str = appPackageInfo.version;
                    }
                    if (TextUtils.isEmpty(str) && bundleConfig != null) {
                        str = bundleConfig.versionCode;
                    }
                    String forceUpdateJSSDKVersion = DMMina.this.f18417b.getForceUpdateConfig().getForceUpdateJSSDKVersion();
                    String forceUpdateAppVersion = DMMina.this.f18417b.getForceUpdateConfig().getForceUpdateAppVersion();
                    int compareVersion = VersionUtil.compareVersion(forceUpdateJSSDKVersion, str2);
                    int compareVersion2 = VersionUtil.compareVersion(forceUpdateAppVersion, str);
                    LogUtil.iRelease(DMMina.TAG_FORCE_UPDATE, "jssdk比较结果：" + compareVersion + " 本地版本：" + str2 + " 强制升级版本:" + forceUpdateJSSDKVersion);
                    LogUtil.iRelease(DMMina.TAG_FORCE_UPDATE, "app比较结果：" + compareVersion2 + " 本地版本：" + str + " 强制升级版本:" + forceUpdateAppVersion);
                    if (compareVersion > 0 || compareVersion2 > 0) {
                        long forceUpdateTimeout = DMMina.this.f18417b.getForceUpdateConfig().getForceUpdateTimeout();
                        TraceUtil.traceForceUpdateStart(DMMina.this.f18416a, DMMina.this.f18417b.getForceUpdateConfig());
                        LogUtil.iRelease(DMMina.TAG_FORCE_UPDATE, "需要强制升级，本地安装等待，等待时间：" + forceUpdateTimeout + "ms");
                        if (forceUpdateTimeout == 0) {
                            LogUtil.iRelease(DMMina.TAG_FORCE_UPDATE, "设置超时时间为0，开始本地安装");
                            DMMina.this.getPerformance().markNotForceUpdate();
                            DMMina.this.m15585a(bundleConfig, bundleConfig2, currentTimeMillis, false);
                            IDMCommonAction iDMCommonAction3 = iDMCommonAction5;
                            if (iDMCommonAction3 != null) {
                                iDMCommonAction3.callback(InstallStatus.BUNDLE_CONFIG_VALID);
                            }
                        } else {
                            DMMina.this.getPerformance().markForceUpdate();
                            Runnable[] runnableArr = runnableArr;
                            runnableArr[0] = new Runnable(runnableArr, bundleConfig, bundleConfig2, currentTimeMillis, iDMCommonAction5) {
                                public final /* synthetic */ Runnable[] f$1;
                                public final /* synthetic */ BundleConfig f$2;
                                public final /* synthetic */ BundleConfig f$3;
                                public final /* synthetic */ long f$4;
                                public final /* synthetic */ IDMCommonAction f$5;

                                {
                                    this.f$1 = r2;
                                    this.f$2 = r3;
                                    this.f$3 = r4;
                                    this.f$4 = r5;
                                    this.f$5 = r7;
                                }

                                public final void run() {
                                    DMMina.C79878.this.lambda$onOriginalPackageInstalled$0$DMMina$8(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
                                }
                            };
                            UIHandlerUtil.postDelayed(runnableArr[0], forceUpdateTimeout);
                            IDMCommonAction iDMCommonAction4 = iDMCommonAction5;
                            if (iDMCommonAction4 != null) {
                                iDMCommonAction4.callback(InstallStatus.TRIGGER_FORCE_UPDATE);
                            }
                        }
                        IDMCommonAction iDMCommonAction5 = iDMCommonAction4;
                        if (iDMCommonAction5 != null) {
                            iDMCommonAction5.callback(null);
                        }
                        IDMCommonAction iDMCommonAction6 = iDMCommonAction5;
                        if (iDMCommonAction6 != null) {
                            iDMCommonAction6.callback(InstallStatus.LOCAL_COMPLETE);
                            return;
                        }
                        return;
                    }
                    LogUtil.iRelease(DMMina.TAG_FORCE_UPDATE, "不需要强制升级，直接本地安装即可");
                    DMMina.this.getPerformance().markNotForceUpdate();
                    DMMina.this.m15584a(bundleConfig, bundleConfig2);
                    IDMCommonAction iDMCommonAction7 = iDMCommonAction4;
                    if (iDMCommonAction7 != null) {
                        iDMCommonAction7.callback(null);
                    }
                    IDMCommonAction iDMCommonAction8 = iDMCommonAction5;
                    if (iDMCommonAction8 != null) {
                        iDMCommonAction8.callback(InstallStatus.LOCAL_COMPLETE);
                        iDMCommonAction5.callback(InstallStatus.BUNDLE_CONFIG_VALID);
                    }
                }
            }

            public /* synthetic */ void lambda$onOriginalPackageInstalled$0$DMMina$8(Runnable[] runnableArr, BundleConfig bundleConfig, BundleConfig bundleConfig2, long j, IDMCommonAction iDMCommonAction) {
                runnableArr[0] = null;
                LogUtil.iRelease(DMMina.TAG_FORCE_UPDATE, "超时等待结束，取消远程安装，开始本地安装");
                DMMina.this.m15585a(bundleConfig, bundleConfig2, j, false);
                if (iDMCommonAction != null) {
                    iDMCommonAction.callback(InstallStatus.FORCE_UPDATE_COMPLETE);
                    iDMCommonAction.callback(InstallStatus.BUNDLE_CONFIG_VALID);
                }
                TraceUtil.newTraceForceUpdateEnd(DMMina.this, this.mLocalInstallJsAppConfig, this.mLocalInstallJsSdkConfig, (BundleConfig) null, (BundleConfig) null, -1000, "发生超时");
            }

            public void onUpdateMainPackageInstalled(BundleConfig bundleConfig, BundleConfig bundleConfig2) {
                LogUtil.iRelease(DMMina.TAG, "接受到remote安装结果, onRemoteInstalled()-> jsSdkConfig=" + bundleConfig2 + "\t jsAppConfig=" + bundleConfig);
                if (bundleConfig != BundleConfig.NO_VERSION_BUNDLE_CONFIG || bundleConfig2 != BundleConfig.NO_VERSION_BUNDLE_CONFIG) {
                    LogUtil.iRelease(DMMina.TAG_FORCE_UPDATE, "开始远程安装");
                    Runnable[] runnableArr = runnableArr;
                    if (runnableArr[0] != null) {
                        UIHandlerUtil.removeCallbacks(runnableArr[0]);
                        DMMina.this.m15585a(bundleConfig != null ? bundleConfig : this.mLocalInstallJsAppConfig, bundleConfig2 != null ? bundleConfig2 : this.mLocalInstallJsSdkConfig, currentTimeMillis, true);
                        IDMCommonAction iDMCommonAction = iDMCommonAction5;
                        if (iDMCommonAction != null) {
                            iDMCommonAction.callback(InstallStatus.FORCE_UPDATE_COMPLETE);
                            iDMCommonAction5.callback(InstallStatus.BUNDLE_CONFIG_VALID);
                        }
                        if (!(bundleConfig == null && bundleConfig2 == null)) {
                            TraceUtil.newTraceForceUpdateEnd(DMMina.this, this.mLocalInstallJsAppConfig, this.mLocalInstallJsSdkConfig, bundleConfig, bundleConfig2, 0, "");
                        }
                    }
                    BundleConfig unused = DMMina.this.f18434s = bundleConfig;
                    BundleConfig unused2 = DMMina.this.f18435t = bundleConfig2;
                    int unused3 = DMMina.this.f18436u = 4;
                    DMMina.this.m15602c();
                    IDMCommonAction iDMCommonAction2 = iDMCommonAction6;
                    if (iDMCommonAction2 != null) {
                        iDMCommonAction2.callback(null);
                    }
                    IDMCommonAction iDMCommonAction3 = iDMCommonAction5;
                    if (iDMCommonAction3 != null) {
                        iDMCommonAction3.callback(InstallStatus.REMOTE_COMPLETE);
                    }
                    LogUtil.iRelease(DMMina.TAG_FORCE_UPDATE, "结束远程安装");
                }
            }

            public void onUpdateSubPackageInstalled(BundleConfig bundleConfig, BundleConfig bundleConfig2) {
                LogUtil.iRelease(DMMina.TAG, "onSubPreInstalled 结束");
                IDMCommonAction iDMCommonAction = iDMCommonAction5;
                if (iDMCommonAction != null) {
                    iDMCommonAction.callback(InstallStatus.SUB_PRE_COMPLETE);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15576a() {
        if (this.f18431p != null) {
            UIHandlerUtil.post(new Runnable() {
                public final void run() {
                    DMMina.this.m15607f();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m15607f() {
        BaseModal baseModal = new BaseModal(this.f18431p, R.style.DiminaDialogNoBg);
        baseModal.setCancelable(false);
        baseModal.setCanceledOnTouchOutside(false);
        baseModal.setContent(getActivity().getResources().getString(R.string.dimina_launch_empty_bundle_download_failed_content));
        baseModal.setPositiveButtonText(getActivity().getResources().getString(R.string.dimina_launch_empty_bundle_download_failed_ok));
        baseModal.setPositiveButtonTextColor(getActivity().getResources().getString(R.string.dimina_launch_empty_bundle_download_failed_ok_color));
        baseModal.setPositiveButtonListener(new View.OnClickListener(baseModal) {
            public final /* synthetic */ BaseModal f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                DMMina.this.m15591a(this.f$1, view);
            }
        });
        SystemUtils.showDialog(baseModal);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15591a(BaseModal baseModal, View view) {
        baseModal.hide();
        markExitInDMMinaLaunch();
        checkAndDoExitInMiniLaunch();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m15584a(BundleConfig bundleConfig, BundleConfig bundleConfig2) {
        if (this.f18436u < 3) {
            setJsAppBundleConfig(bundleConfig);
            setJsSdkBundleConfig(bundleConfig2);
            this.f18436u = 3;
            if (this.f18437v != null) {
                this.f18437v.callback(null);
            }
            AppInfo.ModuleInfo appPackageInfo = BundleManager.getInstance().getAppPackageInfo(this, "app");
            if (appPackageInfo != null && !TextUtils.isEmpty(appPackageInfo.version)) {
                LogUtil.iRelease(TAG_FORCE_UPDATE, "不走强制更新 app版本:" + appPackageInfo.version);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m15585a(BundleConfig bundleConfig, BundleConfig bundleConfig2, long j, boolean z) {
        if (this.f18436u < 3) {
            setJsAppBundleConfig(bundleConfig);
            setJsSdkBundleConfig(bundleConfig2);
            this.f18436u = 3;
            if (this.f18437v != null) {
                this.f18437v.callback(null);
            }
            if (z) {
                TraceUtil.traceForceUpdateEnd(this.f18416a, this.f18417b.getForceUpdateConfig(), 1, System.currentTimeMillis() - j);
            } else {
                TraceUtil.traceForceUpdateEnd(this.f18416a, this.f18417b.getForceUpdateConfig(), -1, System.currentTimeMillis() - j);
            }
            AppInfo.ModuleInfo appPackageInfo = BundleManager.getInstance().getAppPackageInfo(this, "app");
            if (appPackageInfo != null && !TextUtils.isEmpty(appPackageInfo.version)) {
                StringBuilder sb = new StringBuilder();
                sb.append("强制更新");
                sb.append(z ? "成功" : "失败");
                sb.append(" app版本:");
                sb.append(appPackageInfo.version);
                LogUtil.iRelease(TAG_FORCE_UPDATE, sb.toString());
            }
        } else {
            LogUtil.iRelease(TAG_FORCE_UPDATE, "远程安装，不更新配置");
        }
    }

    /* renamed from: b */
    private void m15597b() {
        DMThreadPool.post2HandlerThread(new Runnable() {
            public final void run() {
                DMMina.this.m15606e();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m15606e() {
        LogUtil.m16838d(TAG, "setDeviceStat apollo enable");
        this.f18440y = new PageProcessStat();
        try {
            this.f18440y.setPageCreateMemory((long) new DeviceMonitor().getAppTotalMemory());
        } catch (Exception e) {
            LogUtil.m16838d(TAG, "setDeviceStat " + e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15588a(IDMCommonAction<Void> iDMCommonAction, IDMCommonAction<Void> iDMCommonAction2) {
        LogUtil.iRelease("Dimina-Core-Dotting", "bundle local install finish");
        if (!checkAndDoExitInMiniLaunch()) {
            BundleManager.getInstance().requireContent(this, "app", Constant.LAUNCHER_JS.APP_CONFIG, new BundleManagerStrategy.ReadFileCallBack(iDMCommonAction, iDMCommonAction2) {
                public final /* synthetic */ IDMCommonAction f$1;
                public final /* synthetic */ IDMCommonAction f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onRead(boolean z, BundleManagerStrategy.FileInfo fileInfo) {
                    DMMina.this.m15589a(this.f$1, this.f$2, z, fileInfo);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15589a(IDMCommonAction iDMCommonAction, IDMCommonAction iDMCommonAction2, boolean z, BundleManagerStrategy.FileInfo fileInfo) {
        if (z) {
            int i = this.f18416a;
            TraceUtil.trackEventCoreDotting(i, Constant.CORE_DOTTING.LAUNCH_LOADED_APP_CONFIG_JSON, "length = " + fileInfo.getContent().length());
            LogUtil.iRelease("Dimina-Core-Dotting", "loaded config.json");
            JSAppConfig jSAppConfig = (JSAppConfig) JSONUtil.jsonToObject(fileInfo.getContent(), JSAppConfig.class);
            this.f18422g = jSAppConfig;
            if (jSAppConfig != null) {
                if (iDMCommonAction != null) {
                    iDMCommonAction.callback(null);
                }
                if (getConfig().getCallbackConfig().getOnAppConfigJsonLoaded() != null) {
                    getConfig().getCallbackConfig().getOnAppConfigJsonLoaded().callback(this.f18422g, this);
                }
                if (getConfig().getAdapterConfig().getFirstFetchService() != null) {
                    getConfig().getAdapterConfig().getFirstFetchService().requestFirstTogether(this);
                }
                this.f18424i.genDMPage4FirstCreate();
                LogUtil.iRelease("Dimina-Core-Dotting", "start dm-service.js");
                getConfig().getLaunchConfig().getBundleManagerStrategy();
                BundleManager.getInstance().requireContent(this, Constant.BundleConstant.SDK_MODULE_NAME, Constant.LAUNCHER_JS.DM_SERVICE, new BundleManagerStrategy.ReadFileCallBack(iDMCommonAction2) {
                    public final /* synthetic */ IDMCommonAction f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onRead(boolean z, BundleManagerStrategy.FileInfo fileInfo) {
                        DMMina.this.m15590a(this.f$1, z, fileInfo);
                    }
                });
                return;
            }
            try {
                TraceUtil.trackEventError(getMinaIndex(), "JSEngineException", 1007, fileInfo.getContent());
            } catch (Exception unused) {
            }
            this.f18425j.markLaunchFail(-1002, "app_config 转化的jsAppConfig为null");
            return;
        }
        try {
            TraceUtil.trackEventError(getMinaIndex(), "JSEngineException", 1006, "");
        } catch (Exception unused2) {
        }
        this.f18425j.markLaunchFail(-1001, "app_config 文件读取错误");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15590a(IDMCommonAction iDMCommonAction, boolean z, BundleManagerStrategy.FileInfo fileInfo) {
        if (z) {
            m15597b();
            int i = this.f18416a;
            TraceUtil.trackEventCoreDotting(i, Constant.CORE_DOTTING.LAUNCH_LOADED_DM_SERVICE_JS_START, "length = " + fileInfo.getContent().length());
            getPerformance().markJSDefinedDmStart();
            getPerformance().markDmServiceExecuteStart();
            String str = null;
            AppInfo.ModuleInfo sDKPackageInfo = BundleManager.getInstance().getSDKPackageInfo(this, Constant.BundleConstant.SDK_MODULE_NAME);
            if (sDKPackageInfo != null) {
                str = sDKPackageInfo.version;
            }
            String str2 = str;
            if (str2 == null) {
                this.f18420e.executeScriptFile(fileInfo.getContent(), PathUtil.DM_SERVICE_PATH_FOR_UNWIND_STACK, new IDMCommonAction(iDMCommonAction, fileInfo) {
                    public final /* synthetic */ IDMCommonAction f$1;
                    public final /* synthetic */ BundleManagerStrategy.FileInfo f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void callback(Object obj) {
                        DMMina.this.m15600b(this.f$1, this.f$2, (Void) obj);
                    }
                });
            } else {
                this.f18420e.executeScriptFile(fileInfo.getContent(), PathUtil.DM_SERVICE_PATH_FOR_UNWIND_STACK, getMinaIndex(), "", Constant.BundleConstant.SDK_MODULE_NAME, Constant.LAUNCHER_JS.DM_SERVICE, str2, new IDMCommonAction(iDMCommonAction, fileInfo) {
                    public final /* synthetic */ IDMCommonAction f$1;
                    public final /* synthetic */ BundleManagerStrategy.FileInfo f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void callback(Object obj) {
                        DMMina.this.m15587a(this.f$1, this.f$2, (Void) obj);
                    }
                });
            }
            LogUtil.iRelease("Dimina-Core-Dotting", "start app-service.js");
            BundleManager.getInstance().requireContent(this, "app", "/app-service.js", new BundleManagerStrategy.ReadFileCallBack() {
                public final void onRead(boolean z, BundleManagerStrategy.FileInfo fileInfo) {
                    DMMina.this.m15593a(z, fileInfo);
                }
            });
            return;
        }
        try {
            TraceUtil.trackEventError(getMinaIndex(), "JSEngineException", 1002, "");
        } catch (Exception unused) {
        }
        this.f18425j.markLaunchFail(ErrorCode.DM_SERVICE_READ_ERROR, "dm_service 文件读取错误");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m15600b(IDMCommonAction iDMCommonAction, BundleManagerStrategy.FileInfo fileInfo, Void voidR) {
        if (iDMCommonAction != null) {
            iDMCommonAction.callback(null);
        }
        int i = this.f18416a;
        TraceUtil.trackEventCoreDotting(i, Constant.CORE_DOTTING.LAUNCH_LOADED_DM_SERVICE_JS_END, "length = " + fileInfo.getContent().length());
        getPerformance().markJSDefinedDmEnd();
        this.f18421f.enableServiceMessageTransform();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15587a(IDMCommonAction iDMCommonAction, BundleManagerStrategy.FileInfo fileInfo, Void voidR) {
        if (iDMCommonAction != null) {
            iDMCommonAction.callback(null);
        }
        int i = this.f18416a;
        TraceUtil.trackEventCoreDotting(i, Constant.CORE_DOTTING.LAUNCH_LOADED_DM_SERVICE_JS_END, "length = " + fileInfo.getContent().length());
        getPerformance().markJSDefinedDmEnd();
        this.f18421f.enableServiceMessageTransform();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15593a(boolean z, BundleManagerStrategy.FileInfo fileInfo) {
        if (z) {
            int i = this.f18416a;
            TraceUtil.trackEventCoreDotting(i, Constant.CORE_DOTTING.LAUNCH_LOADED_APP_SERVICE_JS_START, "length = " + fileInfo.getContent().length());
            getPerformance().markJSDefinedAppStart();
            getPerformance().markAppServiceExecuteStart();
            String appId = getConfig().getLaunchConfig().getAppId();
            String str = null;
            AppInfo.ModuleInfo appPackageInfo = BundleManager.getInstance().getAppPackageInfo(this, "app");
            if (appPackageInfo != null) {
                str = appPackageInfo.version;
            }
            String str2 = str;
            if (str2 == null) {
                this.f18420e.executeScriptFile(fileInfo.getContent(), PathUtil.APP_SERVICE_PATH_FOR_UNWIND_STACK, new IDMCommonAction(fileInfo) {
                    public final /* synthetic */ BundleManagerStrategy.FileInfo f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void callback(Object obj) {
                        DMMina.this.m15599b(this.f$1, (Void) obj);
                    }
                });
            } else {
                this.f18420e.executeScriptFile(fileInfo.getContent(), PathUtil.APP_SERVICE_PATH_FOR_UNWIND_STACK, getMinaIndex(), appId, "App", "/app-service.js", str2, new IDMCommonAction(fileInfo) {
                    public final /* synthetic */ BundleManagerStrategy.FileInfo f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void callback(Object obj) {
                        DMMina.this.m15583a(this.f$1, (Void) obj);
                    }
                });
            }
        } else {
            try {
                TraceUtil.trackEventError(getMinaIndex(), "JSEngineException", 1004, "");
            } catch (Exception unused) {
            }
            this.f18425j.markLaunchFail(ErrorCode.APP_SERVICE_READ_ERROR, "app_serive 文件读取错误");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m15599b(BundleManagerStrategy.FileInfo fileInfo, Void voidR) {
        int i = this.f18416a;
        TraceUtil.trackEventCoreDotting(i, Constant.CORE_DOTTING.LAUNCH_LOADED_APP_SERVICE_JS_END, "length = " + fileInfo.getContent().length());
        getPerformance().markJSDefinedAppEnd();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15583a(BundleManagerStrategy.FileInfo fileInfo, Void voidR) {
        int i = this.f18416a;
        TraceUtil.trackEventCoreDotting(i, Constant.CORE_DOTTING.LAUNCH_LOADED_APP_SERVICE_JS_END, "length = " + fileInfo.getContent().length());
        DeviceTraceEvent.trackEvent(this.f18416a, PerformanceDotType.OPEN_DM_SERVICE, new DeviceMonitor(), this.f18440y);
        getPerformance().markJSDefinedAppEnd();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15577a(int i) {
        this.f18425j.markNativeJsReady();
        this.f18425j.markJSRequireStart();
        getJSEngine().registerOnUnHandledRejection();
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "saga_launch", (Object) String.valueOf(this.f18425j.getLaunchTime()));
        JSONObject build = new MessageWrapperBuilder().data(jSONObject).stackId(i).build();
        this.f18421f.sendMessageToServiceFromNative("nativeJsReady", build);
        int i2 = this.f18416a;
        TraceUtil.trackEventCoreDotting(i2, Constant.CORE_DOTTING.LAUNCH_NATIVE_JS_READY, "msg: " + build);
        m15602c();
    }

    public List<DMMinaNavigatorDelegate> getNavigatorList() {
        return Collections.unmodifiableList(this.f18418c);
    }

    public DMMinaNavigatorDelegate getCurNavigator() {
        return this.f18419d;
    }

    public DMConfig getConfig() {
        return this.f18417b;
    }

    public int getMinaIndex() {
        return this.f18416a;
    }

    public JSEngineWrapper getJSEngine() {
        return this.f18420e;
    }

    public DMMessageTransfer getMessageTransfer() {
        return this.f18421f;
    }

    public DMPagePool getDmPagePool() {
        return this.f18424i;
    }

    public DMMinaPerformance getPerformance() {
        return this.f18425j;
    }

    public JSModuleWrapper getJSModule(String str) {
        JSModuleWrapper jSModule = this.f18441z.getJSModule(str);
        return jSModule == null ? GlobalJSModuleManager.getRegisterJSModule(this, str) : jSModule;
    }

    public Object invokeServiceJSModuleMethod(String str, String str2, Object... objArr) {
        JSModuleWrapper jSModule = getJSModule(str);
        Method targetMethod = jSModule.getTargetMethod(str2);
        if (targetMethod != null) {
            BaseServiceModule serviceModuleInstance = jSModule.getServiceModuleInstance(this);
            if (!Modifier.isStatic(targetMethod.getModifiers()) && serviceModuleInstance != null) {
                try {
                    return targetMethod.invoke(serviceModuleInstance, objArr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void sendEvent(String str, String str2, JSONObject jSONObject) {
        DMMessageTransfer messageTransfer = getMessageTransfer();
        messageTransfer.sendMessageToServiceFromNative(str + "_" + str2, jSONObject);
    }

    public void registerJSModule(Class<? extends BaseServiceModule> cls) throws MinaBridgeModuleNotFoundException, MinaBridgeModuleRegisteredException {
        if (cls != null) {
            BridgeModule bridgeModule = (BridgeModule) cls.getAnnotation(BridgeModule.class);
            if (bridgeModule == null || TextUtils.isEmpty(bridgeModule.name())) {
                throw new MinaBridgeModuleNotFoundException("自定义的小程序Bridge模块类，必须用com.didi.dimina.container.bridge.base.BridgeModule注解注明模块名称");
            }
            this.f18441z.registerJSModule(bridgeModule.name(), cls);
        }
    }

    public void registerDMServiceSubJSModule(Class<? extends BaseServiceModule> cls) {
        if (cls != null) {
            this.f18441z.registerDMServiceSubJSModule(cls);
        }
    }

    public List<JSModuleWrapper> getDMServiceSubJSModuleWrapper() {
        return this.f18441z.getDMServiceSubJSModuleWrapper();
    }

    public List<JSModuleWrapper> getJSModuleList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new JSModuleWrapper("DMServiceBridgeModule", DMServiceJSModule.class));
        arrayList.add(new JSModuleWrapper("DMWebViewBridgeModule", DMWebViewJSModule.class));
        arrayList.addAll(GlobalJSModuleManager.getGlobalJSModuleTables(this).values());
        return arrayList;
    }

    public JSAppConfig getJSAppConfig() {
        return this.f18422g;
    }

    public int genWebViewId() {
        return this.f18423h.getAndIncrement();
    }

    public void invokePreloadReady() {
        TraceUtil.trackEventCoreDotting(this.f18416a, Constant.CORE_DOTTING.LAUNCH_INVOKE_SERVICE_READY, "");
        if (!checkAndDoExitInMiniLaunch()) {
            DMLaunchLifecycleManager.getInstance().hookJSEngineReady(this);
            this.f18429n = true;
            this.f18425j.markJSEngineReady();
            this.f18430o = 3;
            getPerformance().markDmServiceExecuteEnd();
            IDMCommonAction<Void> iDMCommonAction = this.f18426k;
            if (iDMCommonAction != null) {
                iDMCommonAction.callback(null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m15602c() {
        IDMCommonAction<Void> iDMCommonAction = this.f18438w;
        if (iDMCommonAction != null && this.f18436u == 4 && this.f18430o == 3) {
            iDMCommonAction.callback(null);
            this.f18438w = null;
        }
    }

    public boolean isRelease() {
        return this.f18428m;
    }

    public FragmentActivity getActivity() {
        return this.f18431p;
    }

    public IDMVConsole getVConsoleManager() {
        return this.f18410A;
    }

    public SpiltMMKVUtil getMMKVManager() {
        if (this.f18411B == null) {
            synchronized (this) {
                if (this.f18411B == null) {
                    this.f18411B = new SpiltMMKVUtil(getConfig().getLaunchConfig().getAppId());
                }
            }
        }
        return this.f18411B;
    }

    public IWebSocketMsgSender getWebSocketMsgSender() {
        return this.f18414E;
    }

    public void setWebSocketMsgSender(IWebSocketMsgSender iWebSocketMsgSender) {
        this.f18414E = iWebSocketMsgSender;
    }

    public boolean isEnablePerformanceData() {
        return this.f18413D;
    }

    public void setEnablePerformanceData(boolean z) {
        this.f18413D = z;
    }

    public ConcurrentHashMap<Integer, WebViewEngine> getDmWebViewManager() {
        return this.f18412C;
    }

    public JSGlobalMethodInject getMethodInject() {
        return this.f18427l;
    }

    public void setJsAppBundleConfig(BundleConfig bundleConfig) {
        this.f18432q = bundleConfig;
    }

    public BundleConfig getJsAppBundleConfig() {
        return this.f18432q;
    }

    public void setJsSdkBundleConfig(BundleConfig bundleConfig) {
        this.f18433r = bundleConfig;
    }

    public boolean checkAndDoExitInMiniLaunch() {
        int i = this.f18415F;
        if (i == 2) {
            this.f18415F = 3;
            UIHandlerUtil.runOnUiThread(new Runnable() {
                public final void run() {
                    DMMina.this.m15604d();
                }
            });
            return true;
        } else if (i == 3 || i == 4) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m15604d() {
        int minaIndex = getMinaIndex();
        TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.LAUNCH_EXIT_IN_MINI_LAUNCH, "mina index: " + getMinaIndex());
        DMMinaNavigatorDelegate dMMinaNavigatorDelegate = this.f18419d;
        if (dMMinaNavigatorDelegate != null) {
            dMMinaNavigatorDelegate.hideLaunchView(getMinaIndex());
            this.f18419d.closeDimina();
        } else {
            FragmentActivity fragmentActivity = this.f18431p;
            if (fragmentActivity != null) {
                fragmentActivity.finish();
            }
        }
        DMMinaPool.remove(this.f18416a, false);
        this.f18415F = 4;
    }

    public BundleConfig getJsSdkBundleConfig() {
        return this.f18433r;
    }

    public BundleConfig getJsUpdateAppBundleConfig() {
        return this.f18434s;
    }

    public BundleConfig getJsUpdateSdkBundleConfig() {
        return this.f18435t;
    }

    public int getPreloadStatus() {
        return this.f18430o;
    }

    public int getPreInstallStatus() {
        return this.f18436u;
    }

    public DMFrontBackgroundManager getFrontBackgroundManager() {
        return this.f18439x;
    }

    public void markExitInDMMinaLaunch() {
        if (this.f18415F == 1) {
            this.f18415F = 2;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        if (!this.f18428m && this.f18421f != null && this.f18429n) {
            this.f18421f.sendMessageToServiceFromNative("onAppEnterForeground", new MessageWrapperBuilder().data(LaunchOptionsSubJSBridge.getShowOption(new JSONObject(), this)).build());
        }
        this.f18439x.hookFrontCallback();
        int i = this.f18416a;
        TraceUtil.trackEventCoreDotting(i, Constant.CORE_DOTTING.DIMINA_PAGE_ACTIVITY_ON_START, "minaIndex: " + this.f18416a + ", appId:" + this.f18417b.getLaunchConfig().getAppId() + ", isBindActivityLifecycle:" + this.f18417b.getLaunchConfig().isBindActivityLifecycle());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        this.f18425j.markLaunchEntryBackground();
        if (!this.f18428m && this.f18421f != null && this.f18429n) {
            this.f18421f.sendMessageToServiceFromNative("onAppEnterBackground", new MessageWrapperBuilder().build());
        }
        DMMemoryManager.getInstance().notifyDiminaBackground(this);
        this.f18439x.hookBackgroundCallback();
        int i = this.f18416a;
        TraceUtil.trackEventCoreDotting(i, Constant.CORE_DOTTING.DIMINA_PAGE_ACTIVITY_ON_STOP, "minaIndex: " + this.f18416a + ", appId:" + this.f18417b.getLaunchConfig().getAppId() + ", isBindActivityLifecycle:" + this.f18417b.getLaunchConfig().isBindActivityLifecycle());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        int i = this.f18416a;
        TraceUtil.trackEventCoreDotting(i, Constant.CORE_DOTTING.DIMINA_PAGE_ACTIVITY_ON_DESTROY, "minaIndex: " + this.f18416a + ", appId:" + this.f18417b.getLaunchConfig().getAppId());
        IWebSocketMsgSender iWebSocketMsgSender = this.f18414E;
        if (iWebSocketMsgSender != null) {
            iWebSocketMsgSender.close(4001, "应用主动断开连接");
        }
        DMMinaPool.remove(this.f18416a, false);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DMMina{");
        sb.append(" mMinaIndex=");
        sb.append(this.f18416a);
        DMConfig dMConfig = this.f18417b;
        if (!(dMConfig == null || dMConfig.getLaunchConfig() == null)) {
            DMConfig.LaunchConfig launchConfig = this.f18417b.getLaunchConfig();
            sb.append(" mAppId=");
            sb.append(launchConfig.getAppId());
        }
        sb.append(" mWebViewId=");
        sb.append(this.f18423h);
        if (this.f18432q != null) {
            sb.append(" jsAppVersion=");
            sb.append(this.f18432q.versionCode);
        }
        if (this.f18433r != null) {
            sb.append(" jsSdkVersion=");
            sb.append(this.f18433r.versionCode);
        }
        if (this.f18434s != null) {
            sb.append(" jsAppUpdateVersion=");
            sb.append(this.f18434s.versionCode);
        }
        if (this.f18435t != null) {
            sb.append(" jsSdkUpdateVersion=");
            sb.append(this.f18435t.versionCode);
        }
        sb.append(" hashCode=");
        sb.append(hashCode());
        sb.append(" mConfig=");
        sb.append(this.f18417b);
        sb.append('}');
        return sb.toString();
    }
}
