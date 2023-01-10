package com.didi.dimina.container.page;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bean.JSAppConfig;
import com.didi.dimina.container.bean.NavigateConfig;
import com.didi.dimina.container.bridge.InternalJSMethod;
import com.didi.dimina.container.bridge.blankscreen.CheckBlankScreenManager;
import com.didi.dimina.container.bridge.loading.CustomLoadingManager;
import com.didi.dimina.container.bridge.loading.DefaultLoadingManager;
import com.didi.dimina.container.bundle.BundleManager;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.messager.jsmodule.JSModuleWrapper;
import com.didi.dimina.container.mina.DMMinaNavigatorDelegate;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.mina.DMThreadPool;
import com.didi.dimina.container.monitor.DeviceMonitor;
import com.didi.dimina.container.monitor.DeviceTraceEvent;
import com.didi.dimina.container.monitor.PageProcessStat;
import com.didi.dimina.container.monitor.PerformanceDotType;
import com.didi.dimina.container.p065ui.custom.SameLayerRenderingUtil;
import com.didi.dimina.container.p065ui.loadpage.AbsLoadingManager;
import com.didi.dimina.container.p065ui.loadpage.DMBaseLoadingView;
import com.didi.dimina.container.p065ui.statusbar.ImmersionBar;
import com.didi.dimina.container.p065ui.statusbar.OnKeyboardListener;
import com.didi.dimina.container.p065ui.title.WebTitleBar;
import com.didi.dimina.container.p065ui.webview.DMWebViewContainer;
import com.didi.dimina.container.service.CapsuleButtonService;
import com.didi.dimina.container.util.CollectionsUtil;
import com.didi.dimina.container.util.CoreDottingExtra;
import com.didi.dimina.container.util.FileUtil;
import com.didi.dimina.container.util.HttpUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.KeyboardUtils;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.PathUtil;
import com.didi.dimina.container.util.SnapShotUtil;
import com.didi.dimina.container.util.TimeUtil;
import com.didi.dimina.container.util.TraceUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.taxis99.R;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

public class DMPage extends FrameLayout {
    public static final String METHOD_PULL_REFRESH = "onPullDownRefresh";
    public static final String ON_APP_ROUTE = "onAppRoute";
    public static final String PROPERTY_CURRENT_PATH = "currentPath";
    public static final String TAG_PAGE_FRAME = "PAGE_FRAME";

    /* renamed from: a */
    private static final String f18873a = "mapv2";

    /* renamed from: b */
    private static final String f18874b = "DMPage";

    /* renamed from: p */
    private static final long f18875p = 200;

    /* renamed from: A */
    private Boolean f18876A;

    /* renamed from: B */
    private PageProcessStat f18877B;

    /* renamed from: C */
    private Boolean f18878C = false;

    /* renamed from: D */
    private CheckBlankScreenManager f18879D = null;

    /* renamed from: E */
    private List<DMPageLifecycleListener> f18880E = new ArrayList();

    /* renamed from: F */
    private long f18881F = 0;

    /* renamed from: G */
    private long f18882G = 0;

    /* renamed from: H */
    private final DMWebViewContainer.OnTitleChangeListener f18883H = new DMWebViewContainer.OnTitleChangeListener() {
        public void onTitleChanged(String str) {
            DMPage.this.f18888g.setTitle(str);
        }
    };

    /* renamed from: c */
    private FrameLayout f18884c;

    /* renamed from: d */
    private NavigateConfig f18885d;

    /* renamed from: e */
    private DMMina f18886e;

    /* renamed from: f */
    private int f18887f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public WebTitleBar f18888g;

    /* renamed from: h */
    private View f18889h;
    protected ObjectAnimator hideAnimation;

    /* renamed from: i */
    private View f18890i;
    public boolean isWebViewRelease = false;

    /* renamed from: j */
    private DMWebViewContainer f18891j;

    /* renamed from: k */
    private DMMinaNavigatorDelegate f18892k;

    /* renamed from: l */
    private AbsLoadingManager f18893l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public NavigationBarStatus f18894m = NavigationBarStatus.VISIBLE;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public float f18895n;

    /* renamed from: o */
    private Fragment f18896o;
    public int poolMark = 1;

    /* renamed from: q */
    private PageRefreshHelper f18897q;

    /* renamed from: r */
    private View f18898r;

    /* renamed from: s */
    private boolean f18899s = false;
    protected ObjectAnimator showAnimation;

    /* renamed from: t */
    private DMWebViewContainer f18900t;

    /* renamed from: u */
    private boolean f18901u = false;

    /* renamed from: v */
    private boolean f18902v = false;

    /* renamed from: w */
    private long f18903w = -1;

    /* renamed from: x */
    private String f18904x = "";

    /* renamed from: y */
    private JSAppConfig.DidiPageFrameItem f18905y;

    /* renamed from: z */
    private boolean f18906z = false;

    enum NavigationBarStatus {
        SCROLLING_DOWN,
        SCROLLING_UP,
        GONE,
        VISIBLE
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ boolean m15967a(String str) {
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ boolean m15969b(String str) {
        return true;
    }

    public DMPage(Context context) {
        super(context);
    }

    public DMPage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DMPage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void preLoadView(DMMina dMMina) {
        this.f18881F = System.currentTimeMillis();
        String transformUrl = BundleManager.getInstance().transformUrl(dMMina, Constant.BundleConstant.SDK_MODULE_NAME, Constant.LAUNCHER_WEB_VIEW.PAGE_FRAME);
        if (FileUtil.isFileProtocolExists(transformUrl)) {
            m15965a(dMMina, transformUrl);
            return;
        }
        try {
            String path = new URL(BundleManager.getInstance().transformUrl(dMMina, Constant.BundleConstant.SDK_MODULE_NAME, "/")).getPath();
            List<String> list = FileUtil.list($$Lambda$DMPage$5qeWwmtdDTy0U4kgSDdqcL1_YaY.INSTANCE, path);
            List<String> list2 = FileUtil.list($$Lambda$DMPage$sKyQ4EyIDOQC3m6EwKmNHylnIZQ.INSTANCE, (String[]) list.toArray(new String[0]));
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            arrayList.addAll(list2);
            TraceUtil.trackEventError(this.f18886e.getMinaIndex(), "JSEngineException", 1008, JSONUtil.toJson(arrayList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean preLoadSingleView(DMMina dMMina, JSAppConfig.DidiPageFrameItem didiPageFrameItem) {
        DMMina dMMina2 = dMMina;
        JSAppConfig.DidiPageFrameItem didiPageFrameItem2 = didiPageFrameItem;
        this.f18882G = System.currentTimeMillis();
        String str = dMMina.getJsSdkBundleConfig() != null ? dMMina.getJsSdkBundleConfig().versionCode : null;
        if (TextUtils.isEmpty(str)) {
            str = "0.0.1";
        }
        String transformUrl = BundleManager.getInstance().transformUrl(dMMina2, getPageFrameConfig().root, didiPageFrameItem2.getFileName(str));
        String transformUrl2 = BundleManager.getInstance().transformUrl(dMMina2, getPageFrameConfig().root, didiPageFrameItem.getModelName());
        try {
            String path = new URL(transformUrl).getPath();
            File file = new File(path);
            if (file.exists() && file.length() == 0) {
                LogUtil.iRelease("PAGE_FRAME", "删除空文件:" + path);
                FileUtil.delete(path);
            }
            if (!file.exists()) {
                try {
                    String transformUrl3 = BundleManager.getInstance().transformUrl(dMMina2, Constant.BundleConstant.SDK_MODULE_NAME, Constant.LAUNCHER_JS.DM_WEB_VIEW_NAME);
                    String transformUrl4 = BundleManager.getInstance().transformUrl(dMMina2, "app", Constant.LAUNCHER_JS.APP_WEB_VIEW_NAME);
                    String transformUrl5 = BundleManager.getInstance().transformUrl(dMMina2, "app", Constant.LAUNCHER_JS.APP_WEB_VIEW_STYLE_NAME);
                    String transformUrl6 = BundleManager.getInstance().transformUrl(dMMina2, didiPageFrameItem2.root, Constant.LAUNCHER_JS.APP_WEB_VIEW_NAME);
                    String transformUrl7 = BundleManager.getInstance().transformUrl(dMMina2, didiPageFrameItem2.root, Constant.LAUNCHER_JS.APP_WEB_VIEW_STYLE_NAME);
                    String transformUrl8 = BundleManager.getInstance().transformUrl(dMMina2, didiPageFrameItem2.root, didiPageFrameItem.getJSName());
                    String transformUrl9 = BundleManager.getInstance().transformUrl(dMMina2, didiPageFrameItem2.root, didiPageFrameItem.getCSSName());
                    String replace = FileUtil.read(dMMina.getMinaIndex(), new URL(transformUrl2).getPath()).replace("dipffile://dm-webview.js", transformUrl3).replace("dipffile://app-webview.js", transformUrl4).replace("dipffile://app-webview.css", transformUrl5).replace("./app-webview.js", transformUrl6).replace("./app-webview.css", transformUrl7);
                    String replace2 = replace.replace("." + didiPageFrameItem.getJSName(), transformUrl8);
                    String replace3 = replace2.replace("." + didiPageFrameItem.getCSSName(), transformUrl9);
                    if (file.createNewFile()) {
                        LogUtil.iRelease("PAGE_FRAME", "创建文件:" + path);
                        FileUtil.write(replace3, path);
                    }
                } catch (Exception e) {
                    e = e;
                    LogUtil.iRelease("PAGE_FRAME", "生成特殊DMPage失败：" + getPageFrameConfig().url);
                    e.printStackTrace();
                    return false;
                }
            }
            if (!file.exists()) {
                LogUtil.iRelease("PAGE_FRAME", "写入quick-page-frame.html 失败：" + getPageFrameConfig().url);
                return false;
            }
            LogUtil.iRelease("PAGE_FRAME", "dmpage开始loadview：" + transformUrl);
            m15965a(dMMina2, transformUrl);
            return true;
        } catch (Exception e2) {
            e = e2;
            LogUtil.iRelease("PAGE_FRAME", "生成特殊DMPage失败：" + getPageFrameConfig().url);
            e.printStackTrace();
            return false;
        }
    }

    public void onCreate(Fragment fragment, int i, int i2, NavigateConfig navigateConfig) {
        TraceUtil.trackEventCoreDotting(i, Constant.CORE_DOTTING.PAGE_ON_CREATE, mo60210a().with("minaIndex", Integer.valueOf(i)).with(MessageWrapperBuilder.ARG_STACK_ID, Integer.valueOf(i2)).with("config", navigateConfig).toInfo());
        m15968b();
        this.f18904x = NachoLifecycleManager.LIFECYCLE_ON_CREATE;
        this.f18903w = TimeUtil.currentNanoMillis();
        m15964a(fragment, i, i2, navigateConfig);
        m15970c();
        PageRefreshHelper pageRefreshHelper = new PageRefreshHelper(this.f18886e, this);
        this.f18897q = pageRefreshHelper;
        pageRefreshHelper.mo60282a();
        if (this.poolMark == 2) {
            String str = getNavigateConfig().packages;
            if (TextUtils.isEmpty(str)) {
                str = "app";
            }
            String splitPath = HttpUtil.splitPath(getNavigateConfig().url);
            StringBuilder sb = new StringBuilder();
            sb.append(Constant.LAUNCHER_JS.PAGE_WEB_VIEW_STYLE_PREFIX);
            sb.append((splitPath.startsWith("/") ? splitPath.substring(1) : splitPath).replaceAll("/", "_"));
            String sb2 = sb.toString();
            String transform2AbsolutePath = BundleManager.getInstance().transform2AbsolutePath(this.f18886e, Constant.BundleConstant.SDK_MODULE_NAME, Constant.LAUNCHER_WEB_VIEW.PAGE_FRAME);
            StringBuilder sb3 = new StringBuilder(PathUtil.resolveRelativePath(transform2AbsolutePath, BundleManager.getInstance().transform2AbsolutePath(this.f18886e, str, Constant.LAUNCHER_JS.APP_WEB_VIEW_NAME)));
            StringBuilder sb4 = new StringBuilder(PathUtil.resolveRelativePath(transform2AbsolutePath, BundleManager.getInstance().transform2AbsolutePath(this.f18886e, "app", Constant.LAUNCHER_JS.APP_WEB_VIEW_NAME)));
            StringBuilder sb5 = new StringBuilder(PathUtil.resolveRelativePath(transform2AbsolutePath, BundleManager.getInstance().transform2AbsolutePath(this.f18886e, "app", Constant.LAUNCHER_JS.APP_WEB_VIEW_STYLE_NAME)));
            BundleManager instance = BundleManager.getInstance();
            DMMina dMMina = this.f18886e;
            StringBuilder sb6 = new StringBuilder(PathUtil.resolveRelativePath(transform2AbsolutePath, instance.transform2AbsolutePath(dMMina, str, sb2 + Constant.LAUNCHER_JS.PAGE_WEB_VIEW_STYLE_SUFFIX)));
            BundleManager instance2 = BundleManager.getInstance();
            DMMina dMMina2 = this.f18886e;
            StringBuilder sb7 = new StringBuilder(PathUtil.resolveRelativePath(transform2AbsolutePath, instance2.transform2AbsolutePath(dMMina2, str, sb2 + Constant.LAUNCHER_JS.PAGE_WEB_VIEW_JAVASCRIPT_SUFFIX)));
            JSONObject jSONObject = JSONUtil.toJSONObject(getNavigateConfig().query);
            if (!SameLayerRenderingUtil.isSameLayerRenderingReady(getWebViewContainer().getWebView())) {
                JSONUtil.put(jSONObject, SameLayerRenderingUtil.KEY_DOWNGRADE_VIEW_TYPE, 1);
            } else {
                JSONUtil.put(jSONObject, "downgradeTypeConfig", (Object) SameLayerRenderingUtil.getSameLayerRenderComponentConfig(this));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONUtil.put(jSONObject2, PROPERTY_CURRENT_PATH, (Object) this.f18885d.url);
            JSONUtil.put(jSONObject2, MessageWrapperBuilder.ARG_WEB_VIEW_ID, getWebViewId());
            JSONUtil.put(jSONObject2, "openType", (Object) getNavigateConfig().openType);
            JSONUtil.put(jSONObject2, "route", (Object) splitPath);
            JSONUtil.put(jSONObject2, "query", (Object) JSONUtil.combineJson(HttpUtil.parseUrlQueryJSONObject(this.f18886e.getConfig().getLaunchConfig().getAppId(), getNavigateConfig().url), jSONObject));
            JSONUtil.put(jSONObject2, "appWebViewPath", (Object) sb3.toString());
            JSONUtil.put(jSONObject2, "mainAppWebViewPath", (Object) sb4.toString());
            JSONUtil.put(jSONObject2, "appStyleSheetPath", (Object) sb5.toString());
            JSONUtil.put(jSONObject2, "pageStyleSheetPath", (Object) sb6.toString());
            JSONUtil.put(jSONObject2, "pageJavascriptPath", (Object) sb7.toString());
            JSONObject build = new MessageWrapperBuilder().data(jSONObject2).stackId(getNavigator().getIndex()).webViewId(getWebViewId()).build();
            this.f18886e.getMessageTransfer().sendMessageToWebView(getWebViewContainer().getWebView(), "invokeParamsToWinDone", build);
            this.f18886e.getDmWebViewManager().put(Integer.valueOf(getWebViewId()), getWebViewContainer().getWebView());
            this.f18896o.startPostponedEnterTransition();
            this.f18886e.getPerformance().markWinDone();
            int minaIndex = this.f18886e.getMinaIndex();
            TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.PAGE_INVOKE_PARAMS_TO_WIN_DONE, "from: onCreate(), msg: " + build);
        }
        for (DMPageLifecycleListener onCreate : this.f18880E) {
            onCreate.onCreate();
        }
    }

    /* renamed from: b */
    private void m15968b() {
        DMThreadPool.post2HandlerThread(new Runnable() {
            public final void run() {
                DMPage.this.m15974g();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m15974g() {
        LogUtil.m16838d(f18874b, "setDeviceStat apollo enbale");
        this.f18877B = new PageProcessStat();
        DeviceMonitor deviceMonitor = new DeviceMonitor();
        try {
            this.f18877B.setPageCreateMemory((long) deviceMonitor.getAppTotalMemory());
            this.f18877B.setPageCreatePower(deviceMonitor.getPower().floatValue());
        } catch (Exception e) {
            LogUtil.m16838d(f18874b, "setDeviceStat " + e.getMessage());
        }
    }

    public void onShow() {
        TraceUtil.trackEventCoreDotting(this.f18886e.getMinaIndex(), Constant.CORE_DOTTING.PAGE_ON_SHOW, mo60210a().toInfo());
        Boolean bool = this.f18876A;
        if (bool != null) {
            setStatusBarDarkStyle(bool.booleanValue());
        }
        for (DMPageLifecycleListener onShow : this.f18880E) {
            onShow.onShow();
        }
    }

    public void onHide() {
        TraceUtil.trackEventCoreDotting(this.f18886e.getMinaIndex(), Constant.CORE_DOTTING.PAGE_ON_HIDE, mo60210a().toInfo());
        for (DMPageLifecycleListener onHide : this.f18880E) {
            onHide.onHide();
        }
    }

    public void onDestroy() {
        DeviceTraceEvent.trackEvent(this.f18886e.getMinaIndex(), PerformanceDotType.PAGE_DESTROY, new DeviceMonitor(this.f18885d.url), this.f18877B);
        TraceUtil.trackEventCoreDotting(this.f18886e.getMinaIndex(), Constant.CORE_DOTTING.PAGE_ON_DESTROY, mo60210a().toInfo());
        this.f18901u = true;
        for (DMPageLifecycleListener onDestroy : this.f18880E) {
            onDestroy.onDestroy();
        }
        JSModuleWrapper jSModule = this.f18886e.getJSModule("DMWebViewBridgeModule");
        if (jSModule != null) {
            jSModule.releaseWebViewModuleInstance(this.f18891j.getWebView());
        }
        DMWebViewContainer dMWebViewContainer = this.f18891j;
        if (dMWebViewContainer != null) {
            dMWebViewContainer.release(getWebViewId());
        }
        long currentNanoMillis = TimeUtil.currentNanoMillis();
        long j = this.f18903w;
        long j2 = currentNanoMillis - j;
        if (j != -1) {
            TraceUtil.trackPageOnDestroyRendering(this.f18886e.getMinaIndex(), this.f18885d.url, j2, (long) getWebViewId(), this.f18904x);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public CoreDottingExtra mo60210a() {
        return CoreDottingExtra.create().with(MessageWrapperBuilder.ARG_WEB_VIEW_ID, Integer.valueOf(getWebViewId()));
    }

    public void onDomReady() {
        DeviceTraceEvent.trackEvent(this.f18886e.getMinaIndex(), PerformanceDotType.DOM_READY, new DeviceMonitor(this.f18885d.url), this.f18877B);
        this.f18902v = true;
        if (!this.f18906z) {
            hideLoadingView();
        } else {
            UIHandlerUtil.postDelayed(new Runnable() {
                public void run() {
                    DMPage.this.hideLoadingView();
                }
            }, this.f18886e.getConfig().getLaunchConfig().getSnapshotConfig().getSnapshotDurationTime());
        }
        for (DMPageLifecycleListener onDomReady : this.f18880E) {
            onDomReady.onDomReady();
        }
    }

    public void hideLoadingView() {
        if (this.f18898r != null) {
            LogUtil.iRelease(f18874b, "hideLoadingView");
            this.f18884c.removeView(this.f18898r);
        }
        AbsLoadingManager absLoadingManager = this.f18893l;
        if (absLoadingManager != null) {
            absLoadingManager.dismiss();
        }
    }

    public void reLoadView() {
        String transformUrl = BundleManager.getInstance().transformUrl(this.f18886e, Constant.BundleConstant.SDK_MODULE_NAME, Constant.LAUNCHER_WEB_VIEW.PAGE_FRAME);
        if (FileUtil.isFileProtocolExists(transformUrl)) {
            this.f18891j.initWebView();
            this.poolMark = 3;
            this.f18891j.getWebView().dmCreate(this.f18891j, this, this.f18886e, this.f18892k);
            this.f18891j.loadUrl(transformUrl);
        }
        this.isWebViewRelease = false;
        TraceUtil.trackEventCoreDotting(this.f18886e.getMinaIndex(), Constant.CORE_DOTTING.PAGE_RELOAD_WEB_VIEW, mo60210a().with("url", transformUrl).toInfo());
        this.f18903w = TimeUtil.currentNanoMillis();
        this.f18904x = "reload";
    }

    public void releaseWebView() {
        TraceUtil.trackEventCoreDotting(this.f18886e.getMinaIndex(), Constant.CORE_DOTTING.PAGE_RELEASE_WEB_VIEW, mo60210a().toInfo());
        DMWebViewContainer dMWebViewContainer = this.f18891j;
        if (dMWebViewContainer != null) {
            dMWebViewContainer.release(getWebViewId());
            this.isWebViewRelease = true;
            getNavigateConfig().openType = "pageReload";
            m15963a((ViewGroup) this.f18884c);
            try {
                TraceUtil.trackWebViewRelease(this.f18886e.getMinaIndex(), System.currentTimeMillis() - this.f18886e.getPerformance().getLaunchTime(), this.f18886e.getPerformance().getDidOpenCount());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setCapsuleButtonVisibility(boolean z) {
        this.f18890i.setVisibility(z ? 0 : 8);
    }

    public View getCapsuleButton() {
        return this.f18890i;
    }

    public String getUrl() {
        return this.f18885d.url;
    }

    public WebTitleBar getWebTitleBar() {
        return this.f18888g;
    }

    public DMWebViewContainer getWebViewContainer() {
        return this.f18891j;
    }

    public int getWebViewId() {
        return this.f18887f;
    }

    public PageRefreshHelper getRefreshHelper() {
        return this.f18897q;
    }

    public NavigateConfig getNavigateConfig() {
        return this.f18885d;
    }

    public long getRenderStartTime() {
        return this.f18903w;
    }

    /* renamed from: a */
    private void m15964a(Fragment fragment, int i, int i2, NavigateConfig navigateConfig) {
        this.f18896o = fragment;
        DMMina dMMina = DMMinaPool.get(i);
        this.f18886e = dMMina;
        this.f18892k = dMMina.getNavigator(i2);
        this.f18885d = navigateConfig;
    }

    /* renamed from: c */
    private void m15970c() {
        CapsuleButtonService capsuleButtonService;
        m15973f();
        m15963a((ViewGroup) this.f18884c);
        m15971d();
        m15972e();
        this.f18891j.setChangeTitleListener(this.f18883H);
        this.f18891j.initBackground(this.f18885d.url);
        JSAppConfig.PageConfig pageConfig = this.f18886e.getJSAppConfig().getPageConfig(this.f18885d.url);
        if (pageConfig != null) {
            this.f18890i.setVisibility((!this.f18886e.getConfig().getUIConfig().hasCapsuleButton() || !"show".equalsIgnoreCase(pageConfig.capsuleButton)) ? 8 : 0);
            this.f18890i.setBackgroundResource("black".equals(pageConfig.navigationBarTextStyle) ? R.drawable.dimina_capsule_black_icon : R.drawable.dimina_capsule_white_icon);
        }
        if (this.f18886e.getConfig().getCallbackConfig() != null && (capsuleButtonService = this.f18886e.getConfig().getCallbackConfig().getCapsuleButtonService()) != null) {
            this.f18890i.setOnClickListener(new View.OnClickListener(capsuleButtonService) {
                public final /* synthetic */ CapsuleButtonService f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    DMPage.this.m15966a(this.f$1, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15966a(CapsuleButtonService capsuleButtonService, View view) {
        capsuleButtonService.onCloseClick(this.f18886e);
    }

    public void setCapsuleButtonColorBlack(Boolean bool) {
        this.f18890i.setBackgroundResource(bool.booleanValue() ? R.drawable.dimina_capsule_black_icon : R.drawable.dimina_capsule_white_icon);
    }

    /* renamed from: a */
    private void m15963a(ViewGroup viewGroup) {
        Bitmap bitmap = null;
        try {
            if (this.f18886e.getConfig().getLaunchConfig().getSnapshotConfig().getSnapshotAllow() && this.f18886e.getJSAppConfig().snapshotAllow && !this.f18886e.getConfig().getLaunchConfig().getSnapshotConfig().getHasUsedSnapshot()) {
                bitmap = SnapShotUtil.getInstance().getSnapshot(this);
            }
            if (bitmap != null) {
                if (bitmap.getHeight() > 0 && bitmap.getWidth() > 0) {
                    this.f18886e.getConfig().getLaunchConfig().getSnapshotConfig().setHasUsedSnapshot(true);
                    this.f18906z = true;
                    LogUtil.iRelease(f18874b, "页面启动使用快照");
                    ImageView imageView = new ImageView(getContext());
                    imageView.setImageBitmap(bitmap);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            DMPage.this.m15962a(view);
                        }
                    });
                    this.f18898r = imageView;
                    if (this.f18898r != null && viewGroup != null) {
                        viewGroup.addView(this.f18898r, new LinearLayout.LayoutParams(-1, -1));
                        return;
                    }
                }
            }
            this.f18906z = false;
            LogUtil.iRelease(f18874b, "页面启动使用骨架屏");
            Class<? extends DMBaseLoadingView> pageLoadingViewClass = this.f18886e.getConfig().getUIConfig().getPageLoadingViewClass();
            if (pageLoadingViewClass != null) {
                this.f18898r = (DMBaseLoadingView) pageLoadingViewClass.getConstructor(new Class[]{Context.class, DMMina.class, DMPage.class}).newInstance(new Object[]{getContext(), this.f18886e, this});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.f18898r != null) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15962a(View view) {
        getLoadingManager().show();
    }

    private AbsLoadingManager getLoadingManager() {
        if (this.f18893l == null) {
            DMMina dMMina = this.f18886e;
            if (dMMina == null || dMMina.getConfig() == null || this.f18886e.getConfig().getUIConfig().getNoTitleLoadingViewClazz() == null) {
                this.f18893l = new DefaultLoadingManager(getContext(), (String) null, this.f18886e);
            } else {
                this.f18893l = new CustomLoadingManager(getContext(), this.f18886e);
            }
        }
        return this.f18893l;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m15971d() {
        /*
            r3 = this;
            com.didi.dimina.container.bean.NavigateConfig r0 = r3.f18885d
            java.lang.String r0 = r0.url
            com.didi.dimina.container.DMMina r1 = r3.f18886e
            com.didi.dimina.container.bean.JSAppConfig r1 = r1.getJSAppConfig()
            boolean r2 = r1.containPath(r0)
            if (r2 == 0) goto L_0x0034
            com.didi.dimina.container.bean.JSAppConfig$PageConfig r0 = r1.getPageConfig(r0)
            com.didi.dimina.container.bean.JSAppConfig$GlobalConfig r1 = r1.globalConfig
            java.lang.String r2 = r0.backgroundColor
            boolean r2 = com.didi.dimina.container.util.TextUtil.isEmpty(r2)
            if (r2 != 0) goto L_0x0021
            java.lang.String r0 = r0.backgroundColor
            goto L_0x0036
        L_0x0021:
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r0 = r1.window
            if (r0 == 0) goto L_0x0034
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r0 = r1.window
            java.lang.String r0 = r0.backgroundColor
            boolean r0 = com.didi.dimina.container.util.TextUtil.isEmpty(r0)
            if (r0 != 0) goto L_0x0034
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r0 = r1.window
            java.lang.String r0 = r0.backgroundColor
            goto L_0x0036
        L_0x0034:
            java.lang.String r0 = ""
        L_0x0036:
            boolean r1 = com.didi.dimina.container.util.ColorUtil.isValidColorStr(r0)
            if (r1 == 0) goto L_0x0047
            java.lang.String r0 = com.didi.dimina.container.util.ColorUtil.convert3To6(r0)
            int r0 = android.graphics.Color.parseColor(r0)
            r3.setBackgroundColor(r0)
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.page.DMPage.m15971d():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b5  */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m15972e() {
        /*
            r10 = this;
            android.content.Context r0 = r10.getContext()
            boolean r1 = r0 instanceof android.app.Activity
            r2 = 0
            if (r1 == 0) goto L_0x0010
            android.app.Activity r0 = (android.app.Activity) r0
            int r0 = com.didi.dimina.container.p065ui.statusbar.ImmersionBar.getStatusBarHeight((android.app.Activity) r0)
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            if (r0 >= 0) goto L_0x0014
            r0 = 0
        L_0x0014:
            com.didi.dimina.container.bean.NavigateConfig r1 = r10.f18885d
            java.lang.String r1 = r1.url
            com.didi.dimina.container.DMMina r3 = r10.f18886e
            com.didi.dimina.container.bean.JSAppConfig r3 = r3.getJSAppConfig()
            java.lang.String r4 = "#fff"
            java.lang.String r5 = ""
            boolean r6 = r3.containPath(r1)
            r7 = 8
            java.lang.String r8 = "black"
            if (r6 == 0) goto L_0x0098
            com.didi.dimina.container.bean.JSAppConfig$PageConfig r1 = r3.getPageConfig(r1)
            com.didi.dimina.container.bean.JSAppConfig$GlobalConfig r3 = r3.globalConfig
            java.lang.String r6 = r1.navigationBarBackgroundColor
            boolean r6 = com.didi.dimina.container.util.TextUtil.isEmpty(r6)
            if (r6 != 0) goto L_0x003d
            java.lang.String r4 = r1.navigationBarBackgroundColor
            goto L_0x004f
        L_0x003d:
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r6 = r3.window
            if (r6 == 0) goto L_0x004f
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r6 = r3.window
            java.lang.String r6 = r6.navigationBarBackgroundColor
            boolean r6 = com.didi.dimina.container.util.TextUtil.isEmpty(r6)
            if (r6 != 0) goto L_0x004f
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r4 = r3.window
            java.lang.String r4 = r4.navigationBarBackgroundColor
        L_0x004f:
            java.lang.String r6 = r1.navigationBarTitleText
            boolean r6 = com.didi.dimina.container.util.TextUtil.isEmpty(r6)
            if (r6 != 0) goto L_0x005a
            java.lang.String r5 = r1.navigationBarTitleText
            goto L_0x006c
        L_0x005a:
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r6 = r3.window
            if (r6 == 0) goto L_0x006c
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r6 = r3.window
            java.lang.String r6 = r6.navigationBarTitleText
            boolean r6 = com.didi.dimina.container.util.TextUtil.isEmpty(r6)
            if (r6 != 0) goto L_0x006c
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r5 = r3.window
            java.lang.String r5 = r5.navigationBarTitleText
        L_0x006c:
            java.lang.String r6 = r1.navigationBarTextStyle
            boolean r6 = com.didi.dimina.container.util.TextUtil.isEmpty(r6)
            if (r6 != 0) goto L_0x0077
            java.lang.String r3 = r1.navigationBarTextStyle
            goto L_0x008b
        L_0x0077:
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r6 = r3.window
            if (r6 == 0) goto L_0x008a
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r6 = r3.window
            java.lang.String r6 = r6.navigationBarTextStyle
            boolean r6 = com.didi.dimina.container.util.TextUtil.isEmpty(r6)
            if (r6 != 0) goto L_0x008a
            com.didi.dimina.container.bean.JSAppConfig$WindowConfig r3 = r3.window
            java.lang.String r3 = r3.navigationBarTextStyle
            goto L_0x008b
        L_0x008a:
            r3 = r8
        L_0x008b:
            java.lang.String r1 = r1.navigationStyle
            java.lang.String r6 = "custom"
            boolean r1 = android.text.TextUtils.equals(r1, r6)
            if (r1 == 0) goto L_0x0099
            r1 = 8
            goto L_0x009a
        L_0x0098:
            r3 = r8
        L_0x0099:
            r1 = 0
        L_0x009a:
            r6 = 1
            java.lang.String r9 = "dark"
            if (r1 != r7) goto L_0x00b5
            com.didi.dimina.container.ui.title.WebTitleBar r1 = r10.f18888g
            r1.setVisibility(r7)
            boolean r1 = r3.equals(r8)
            if (r1 != 0) goto L_0x00b0
            boolean r1 = r3.equals(r9)
            if (r1 == 0) goto L_0x00b1
        L_0x00b0:
            r2 = 1
        L_0x00b1:
            r10.setStatusBarDarkStyle(r2)
            goto L_0x011a
        L_0x00b5:
            com.didi.dimina.container.ui.title.WebTitleBar r1 = r10.f18888g
            r1.setVisibility(r2)
            com.didi.dimina.container.ui.title.WebTitleBar r1 = r10.f18888g
            r1.setTitle((java.lang.String) r5)
            boolean r1 = r3.equals(r8)
            if (r1 != 0) goto L_0x00cb
            boolean r1 = r3.equals(r9)
            if (r1 == 0) goto L_0x00cc
        L_0x00cb:
            r2 = 1
        L_0x00cc:
            r10.setStatusBarDarkStyle(r2)
            boolean r1 = r3.equals(r8)
            if (r1 != 0) goto L_0x00e8
            boolean r1 = r3.equals(r9)
            if (r1 == 0) goto L_0x00dc
            goto L_0x00e8
        L_0x00dc:
            com.didi.dimina.container.ui.title.WebTitleBar r1 = r10.f18888g
            java.lang.String r2 = "#ffffff"
            int r2 = android.graphics.Color.parseColor(r2)
            r1.setTitleBackgroundColor(r2)
            goto L_0x00f3
        L_0x00e8:
            com.didi.dimina.container.ui.title.WebTitleBar r1 = r10.f18888g
            java.lang.String r2 = "#000000"
            int r2 = android.graphics.Color.parseColor(r2)
            r1.setTitleBackgroundColor(r2)
        L_0x00f3:
            android.view.View r1 = r10.f18889h
            java.lang.String r2 = com.didi.dimina.container.util.ColorUtil.convert3To6(r4)
            int r2 = android.graphics.Color.parseColor(r2)
            r1.setBackgroundColor(r2)
            com.didi.dimina.container.ui.title.WebTitleBar r1 = r10.f18888g
            java.lang.String r2 = com.didi.dimina.container.util.ColorUtil.convert3To6(r4)
            int r2 = android.graphics.Color.parseColor(r2)
            r1.setBackgroundColor(r2)
            android.view.View r1 = r10.f18889h
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            r1.height = r0
            android.view.View r2 = r10.f18889h
            r2.setLayoutParams(r1)
        L_0x011a:
            android.view.View r1 = r10.f18890i
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r1 = (android.widget.FrameLayout.LayoutParams) r1
            int r2 = r1.topMargin
            int r2 = r2 + r0
            r1.topMargin = r2
            android.view.View r0 = r10.f18890i
            r0.setLayoutParams(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.page.DMPage.m15972e():void");
    }

    /* renamed from: f */
    private void m15973f() {
        if (!this.f18878C.booleanValue()) {
            this.f18878C = true;
            LayoutInflater.from(getContext()).inflate(R.layout.dimina_webview_page, this, true);
            this.f18891j = (DMWebViewContainer) findViewById(R.id.webview_container);
            this.f18890i = findViewById(R.id.capsule_button);
            this.f18884c = (FrameLayout) findViewById(R.id.page_container);
            this.f18888g = (WebTitleBar) findViewById(R.id.title_bar);
            this.f18889h = findViewById(R.id.status_bar);
        }
    }

    /* renamed from: a */
    private void m15965a(DMMina dMMina, String str) {
        this.f18887f = dMMina.genWebViewId();
        TraceUtil.trackEventCoreDotting(dMMina.getMinaIndex(), Constant.CORE_DOTTING.PAGE_PRELOAD_WEB_VIEW, mo60210a().with("url", str).toInfo());
        m15973f();
        this.f18891j.syncData(this, dMMina, this.f18892k);
        if (!TextUtils.isEmpty(str)) {
            this.f18891j.loadUrl(str);
        }
        int minaIndex = dMMina.getMinaIndex();
        int i = this.f18881F == 0 ? 0 : 1;
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f18881F;
        if (j == 0) {
            j = this.f18882G;
        }
        TraceUtil.trackPreloadWebview(minaIndex, i, currentTimeMillis - j);
    }

    public void showNavigationBar(boolean z) {
        if (this.f18894m != NavigationBarStatus.VISIBLE && this.f18894m != NavigationBarStatus.SCROLLING_DOWN) {
            long j = z ? 200 : 0;
            ObjectAnimator objectAnimator = this.hideAnimation;
            if (objectAnimator == null || !objectAnimator.isRunning()) {
                this.showAnimation = ObjectAnimator.ofFloat(this, "translationY", new float[]{(float) (-this.f18888g.getHeight()), 0.0f});
            } else {
                this.showAnimation = ObjectAnimator.ofFloat(this, "translationY", new float[]{-this.f18895n, 0.0f});
                this.hideAnimation.cancel();
            }
            this.showAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (valueAnimator.getAnimatedValue() instanceof Float) {
                        float unused = DMPage.this.f18895n = Math.abs(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        if (Math.abs(((Float) valueAnimator.getAnimatedValue()).floatValue()) == ((float) DMPage.this.f18888g.getHeight())) {
                            NavigationBarStatus unused2 = DMPage.this.f18894m = NavigationBarStatus.VISIBLE;
                        } else {
                            NavigationBarStatus unused3 = DMPage.this.f18894m = NavigationBarStatus.SCROLLING_DOWN;
                        }
                    }
                }
            });
            this.showAnimation.setDuration(j);
            this.showAnimation.start();
        }
    }

    public void hideNavigationBar(boolean z) {
        if (this.f18894m != NavigationBarStatus.GONE && this.f18894m != NavigationBarStatus.SCROLLING_UP) {
            long j = z ? 200 : 0;
            ObjectAnimator objectAnimator = this.showAnimation;
            if (objectAnimator == null || !objectAnimator.isRunning()) {
                this.hideAnimation = ObjectAnimator.ofFloat(this, "translationY", new float[]{0.0f, (float) (-this.f18888g.getHeight())});
            } else {
                this.hideAnimation = ObjectAnimator.ofFloat(this, "translationY", new float[]{-this.f18895n, (float) (-this.f18888g.getHeight())});
                this.showAnimation.cancel();
            }
            this.hideAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (valueAnimator.getAnimatedValue() instanceof Float) {
                        float unused = DMPage.this.f18895n = Math.abs(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        if (Math.abs(((Float) valueAnimator.getAnimatedValue()).floatValue()) == ((float) DMPage.this.f18888g.getHeight())) {
                            NavigationBarStatus unused2 = DMPage.this.f18894m = NavigationBarStatus.GONE;
                        } else {
                            NavigationBarStatus unused3 = DMPage.this.f18894m = NavigationBarStatus.SCROLLING_UP;
                        }
                    }
                }
            });
            this.hideAnimation.setDuration(j);
            this.hideAnimation.start();
        }
    }

    public void registerHiddenChangedListener(DMPageLifecycleListener dMPageLifecycleListener) {
        if (!this.f18880E.contains(dMPageLifecycleListener)) {
            this.f18880E.add(dMPageLifecycleListener);
        }
    }

    public void unregisterHiddenChangedListener(DMPageLifecycleListener dMPageLifecycleListener) {
        this.f18880E.remove(dMPageLifecycleListener);
    }

    public void setTitleBackClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f18888g.setOnBackClickListener(onClickListener);
        }
    }

    public boolean canSwipeBack() {
        if (InternalJSMethod.SWITCH_TAB.equals(this.f18885d.openType) || CollectionsUtil.isEmpty((Collection) this.f18892k.getCurrentPages()) || !this.f18886e.getConfig().getUIConfig().canSwipeBack()) {
            return false;
        }
        JSAppConfig.PageConfig pageConfig = this.f18886e.getJSAppConfig().getPageConfig(this.f18885d.url);
        if (pageConfig == null || !TextUtils.equals(pageConfig.type, "map")) {
            return true;
        }
        return false;
    }

    public Fragment getHost() {
        return this.f18896o;
    }

    public DMMina getDMMina() {
        return this.f18886e;
    }

    public DMMinaNavigatorDelegate getNavigator() {
        return this.f18892k;
    }

    public JSAppConfig.DidiPageFrameItem getPageFrameConfig() {
        return this.f18905y;
    }

    public void setPageFrameConfig(JSAppConfig.DidiPageFrameItem didiPageFrameItem) {
        this.f18905y = didiPageFrameItem;
    }

    public void setRenderFinish() {
        this.f18903w = -1;
    }

    public void setCheckBlankScreenManager(CheckBlankScreenManager checkBlankScreenManager) {
        this.f18879D = checkBlankScreenManager;
    }

    public CheckBlankScreenManager getCheckBlankScreenManager() {
        return this.f18879D;
    }

    public boolean isH5Page() {
        return this.f18899s;
    }

    public boolean isDestroyed() {
        return this.f18901u;
    }

    public boolean isDomReady() {
        return this.f18902v;
    }

    public void setH5Page(boolean z) {
        this.f18899s = z;
    }

    public void setH5WebViewContainer(DMWebViewContainer dMWebViewContainer) {
        this.f18900t = dMWebViewContainer;
    }

    public boolean tryH5GoBack() {
        DMWebViewContainer dMWebViewContainer = this.f18900t;
        if (dMWebViewContainer == null || dMWebViewContainer.getWebView() == null) {
            return false;
        }
        return this.f18900t.getWebView().tryH5GoBack();
    }

    public void setStatusBarDarkStyle(boolean z) {
        if (this.f18896o.getActivity() != null) {
            ImmersionBar with = ImmersionBar.with(this.f18896o);
            with.navigationBarEnable(false).keyboardEnable(true);
            if (ImmersionBar.isSupportStatusBarDarkFont()) {
                with.statusBarDarkFont(z);
                this.f18876A = new Boolean(z);
            }
            with.setOnKeyboardListener(new OnKeyboardListener() {
                public void onKeyboardChange(boolean z, int i, int i2) {
                    if (!z) {
                        DMPage.this.getWebViewContainer().getTouchInterceptFrameLayout().setTranslationY(0.0f);
                    } else if (KeyboardUtils.focusedComponentY > i2 - i) {
                        DMPage.this.getWebViewContainer().getTouchInterceptFrameLayout().setTranslationY((float) (((-KeyboardUtils.focusedComponentY) - i) + i2));
                    }
                }
            });
            with.init();
        }
    }
}
