package p218io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.HorizontalChangeHandler;
import com.didi.flutter.nacho2.p116v2.NachoAction;
import com.didi.flutter.nacho2.p116v2.NachoChannelManager;
import com.didi.flutter.nacho2.p116v2.NachoConstants;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import p218io.flutter.FlutterInjector;
import p218io.flutter.embedding.android.FlutterActivityAndFragmentDelegate;
import p218io.flutter.embedding.android.NFlutterActivityInjector;
import p218io.flutter.embedding.android.locale.NFlutterSystemLocaleBlocker;
import p218io.flutter.embedding.android.registry.NFlutterContainerRegistry;
import p218io.flutter.embedding.engine.FlutterEngine;
import p218io.flutter.embedding.engine.FlutterShellArgs;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;
import p218io.flutter.embedding.engine.plugins.PluginRegistry;
import p218io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import p218io.flutter.embedding.engine.renderer.RenderSurface;
import p218io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import p218io.flutter.plugin.common.BasicMessageChannel;
import p218io.flutter.plugin.common.StandardMessageCodec;
import p218io.flutter.plugin.platform.PlatformPlugin;

/* renamed from: io.flutter.embedding.android.BaseNachoSkeletonPage */
public abstract class BaseNachoSkeletonPage extends Page implements LifecycleOwner, FlutterActivityAndFragmentDelegate.Host {

    /* renamed from: a */
    private String f60114a;

    /* renamed from: b */
    private RenderSurface f60115b;

    /* renamed from: c */
    private boolean f60116c = false;

    /* renamed from: d */
    private long f60117d;

    /* renamed from: e */
    private boolean f60118e = false;

    /* renamed from: f */
    private final FlutterUiDisplayListener f60119f = new FlutterUiDisplayListener() {
        public void onFlutterUiDisplayed() {
            BaseNachoSkeletonPage.this.onFlutterUiDisplayed();
        }

        public void onFlutterUiNoLongerDisplayed() {
            BaseNachoSkeletonPage.this.onFlutterUiNoLongerDisplayed();
        }
    };

    /* renamed from: g */
    private ViewTreeObserver.OnGlobalLayoutListener f60120g = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (!BaseNachoSkeletonPage.this.mFlutterView.isAttachedToFlutterEngine()) {
                BaseNachoSkeletonPage.this.mFlutterView.attachToFlutterEngine(BaseNachoSkeletonPage.this.provideNachoAction());
                BaseNachoSkeletonPage.this.updateLocale();
            }
            BaseNachoSkeletonPage.this.mRootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    };
    protected FlutterActivityAndFragmentDelegate mDelegate;
    protected View mFakeStatusBar;
    protected ViewGroup mFlutterContainer;
    protected NFlutterView mFlutterView;
    protected LifecycleRegistry mLifecycle;
    protected ViewGroup mRootView;

    public void detachFromFlutterEngine() {
    }

    public String getCachedEngineId() {
        return null;
    }

    public String getDartEntrypointFunctionName() {
        return NachoConstants.NACHO_ENTRYPOINT_NAME;
    }

    public String getInitialRoute() {
        return "/";
    }

    /* access modifiers changed from: protected */
    public Bundle getMetaData() throws PackageManager.NameNotFoundException {
        return null;
    }

    @Deprecated
    public void onFlutterSurfaceViewCreated(FlutterSurfaceView flutterSurfaceView) {
    }

    @Deprecated
    public void onFlutterTextureViewCreated(FlutterTextureView flutterTextureView) {
    }

    public boolean popSystemNavigator() {
        return false;
    }

    public abstract NachoAction provideNachoAction();

    public boolean shouldAttachEngineToActivity() {
        return true;
    }

    public boolean shouldDestroyEngineWithHost() {
        return false;
    }

    public boolean shouldHandleDeeplinking() {
        return false;
    }

    public boolean shouldRestoreAndSaveState() {
        return false;
    }

    public void updateLocale() {
    }

    public BaseNachoSkeletonPage() {
        m45288a();
    }

    public BaseNachoSkeletonPage(Bundle bundle) {
        super(bundle);
        m45288a();
    }

    /* renamed from: a */
    private void m45288a() {
        this.f60114a = SystemClock.uptimeMillis() + "@" + Integer.toHexString(hashCode());
        this.mLifecycle = new LifecycleRegistry(this);
        this.mDelegate = new FlutterActivityAndFragmentDelegate(this);
        NFlutterContainerRegistry.registerContainer(this.f60114a, this);
    }

    public View onInflateFlutterLayout(LayoutInflater layoutInflater, FrameLayout frameLayout) {
        return createFlutterView(frameLayout.getContext());
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        NSkeletonFlutter.log(this, "onInflateView()");
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.skeleton_flutter_container, viewGroup, false);
        this.mRootView = viewGroup2;
        viewGroup2.setBackgroundColor(-1);
        this.mDelegate.mo181756a(viewGroup.getContext());
        this.mFakeStatusBar = this.mRootView.findViewById(R.id.fake_status_bar);
        FrameLayout frameLayout = (FrameLayout) this.mRootView.findViewById(R.id.layout_container);
        frameLayout.addView(onInflateFlutterLayout(layoutInflater, frameLayout));
        return this.mRootView;
    }

    public View createFlutterView(Context context) {
        this.mFlutterContainer = new FrameLayout(context);
        FlutterTextureView flutterTextureView = new FlutterTextureView(getActivity());
        this.f60115b = flutterTextureView;
        NFlutterView nFlutterView = new NFlutterView(getActivity(), flutterTextureView);
        this.mFlutterView = nFlutterView;
        nFlutterView.addOnFirstFrameRenderedListener(this.f60119f);
        this.mFlutterContainer.addView(this.mFlutterView, new FrameLayout.LayoutParams(-1, -1));
        return this.mFlutterContainer;
    }

    public void onCreate(View view) {
        Bundle bundle;
        NSkeletonFlutter.log(this, "onCreate()");
        this.f60117d = System.currentTimeMillis();
        super.onCreate(view);
        try {
            NFlutterSystemLocaleBlocker.blockSendSystemLocale2Flutter(getApplicationContext(), provideNachoAction().getEngine());
        } catch (Exception e) {
            e.printStackTrace();
            NSkeletonFlutter.log(this, "blockSendSystemLocale2Flutter failed " + e.toString());
        }
        this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(this.f60120g);
        this.mLifecycle.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.mDelegate.mo181758a(getArgs());
        Bundle args = getArgs();
        String string = args.getString("path");
        HashMap hashMap = new HashMap();
        hashMap.putAll(transformBundleParameters(args));
        if (args.containsKey("params") && (bundle = args.getBundle("params")) != null) {
            hashMap.putAll(transformBundleParameters(bundle));
        }
        sendStartTimeStamp(string);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("initial_route", string);
        NachoLifecycleManager.sendLifecycleOnCreate(provideNachoAction(), this.f60114a, hashMap2, hashMap);
        if (getActivity() instanceof NFlutterActivityInjector) {
            ((NFlutterActivityInjector) getActivity()).injectFlutterActivityObserver(new NFlutterActivityInjector.Observer() {
                public void onActivityDestroy() {
                }

                public void onActivityStop() {
                }

                public void onTrimMemory(int i) {
                    NSkeletonFlutter.log(this, "activity hook -> onTrimMem()");
                    if (BaseNachoSkeletonPage.this.mDelegate != null) {
                        BaseNachoSkeletonPage.this.mDelegate.mo181753a(i);
                    }
                }
            });
        }
    }

    public void onStart() {
        NSkeletonFlutter.log(this, "onStart()");
        super.onStart();
        this.mLifecycle.handleLifecycleEvent(Lifecycle.Event.ON_START);
        provideNachoAction().getEngine().getLifecycleChannel().appIsResumed();
    }

    public void onResume() {
        NSkeletonFlutter.log(this, "onResume()");
        if (this.f60116c) {
            m45290c();
        }
        super.onResume();
        this.mLifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.mDelegate.mo181766h();
        if (this.f60115b != null && !this.mFlutterView.isAttachedToFlutterEngine()) {
            this.mFlutterView.attachToFlutterEngine(provideNachoAction());
            updateLocale();
        }
        NachoLifecycleManager.sendLifecycleOnResume(provideNachoAction(), this.f60114a);
    }

    public void onPause() {
        NSkeletonFlutter.log(this, "onPause()");
        super.onPause();
        this.mLifecycle.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        this.mDelegate.mo181769k();
        RenderSurface renderSurface = this.f60115b;
        if (renderSurface != null && renderSurface.getAttachedRenderer() != null) {
            this.mFlutterView.detachFromFlutterEngine();
        }
    }

    public void onStop() {
        NSkeletonFlutter.log(this, "onStop()");
        super.onStop();
        this.mLifecycle.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        this.mDelegate.mo181770l();
        FlutterEngine engine = provideNachoAction().getEngine();
        engine.getLifecycleChannel().appIsResumed();
        new BasicMessageChannel(engine.getDartExecutor().getBinaryMessenger(), "mas_quality_track_application_enter_background", new StandardMessageCodec()).send(null);
    }

    /* renamed from: b */
    private void m45289b() {
        FlutterActivityAndFragmentDelegate flutterActivityAndFragmentDelegate = this.mDelegate;
        if (flutterActivityAndFragmentDelegate != null) {
            flutterActivityAndFragmentDelegate.mo181752a();
            this.mDelegate = null;
        }
    }

    public void fastDestroy() {
        NSkeletonFlutter.log(this, "fastDestroy detachFromFlutterEngine()");
        if (!this.f60118e) {
            RenderSurface renderSurface = this.f60115b;
            if (!(renderSurface == null || renderSurface.getAttachedRenderer() == null)) {
                this.mFlutterView.detachFromFlutterEngine();
            }
            NachoLifecycleManager.sendLifecycleOnDestroy(provideNachoAction(), this.f60114a);
            this.f60118e = true;
        }
    }

    public void onDestroy() {
        NSkeletonFlutter.log(this, "onDestroy()");
        this.mRootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f60120g);
        this.f60120g = null;
        if (!this.f60118e) {
            NachoLifecycleManager.sendLifecycleOnDestroy(provideNachoAction(), this.f60114a);
        }
        super.onDestroy();
        if (getActivity() instanceof NFlutterActivityInjector) {
            ((NFlutterActivityInjector) getActivity()).releaseObserver();
        }
        this.mFlutterView.removeOnFirstFrameRenderedListener(this.f60119f);
        this.mDelegate.mo181772n();
        FlutterEngine engine = provideNachoAction().getEngine();
        engine.getLifecycleChannel().appIsResumed();
        NFlutterContainerRegistry.removeContainer(this.f60114a);
        this.mFlutterContainer.removeAllViews();
        this.mFlutterView.removeAllViews();
        RenderSurface renderSurface = this.f60115b;
        if (renderSurface != null) {
            ((FlutterTextureView) renderSurface).setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
        }
        engine.getMouseCursorChannel().setMethodHandler((MouseCursorChannel.MouseCursorMethodHandler) null);
        m45289b();
    }

    public void onPageResult(Bundle bundle) {
        NachoChannelManager.setPageResult(provideNachoAction(), this.f60114a, transformBundleParameters(bundle));
    }

    public void onSaveInstanceState(Bundle bundle) {
        NSkeletonFlutter.log(this, "onSaveInstanceState()");
        super.onSaveInstanceState(bundle);
        this.mDelegate.mo181760b(bundle);
    }

    public boolean onHandleBack() {
        NSkeletonFlutter.log(this, "onHandleBack()");
        this.mDelegate.mo181773o();
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.mDelegate.mo181754a(i, i2, intent);
    }

    public String getPageId() {
        return this.f60114a;
    }

    public FlutterEngine provideFlutterEngine(Context context) {
        return provideNachoAction().getEngine();
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycle;
    }

    public FlutterShellArgs getFlutterShellArgs() {
        return new FlutterShellArgs(new String[0]);
    }

    public String getAppBundlePath() {
        return FlutterInjector.instance().flutterLoader().findAppBundlePath();
    }

    public Context getContext() {
        return this.mRootView.getContext();
    }

    public Activity getActivity() {
        return (Activity) this.mRootView.getContext();
    }

    public RenderMode getRenderMode() {
        NSkeletonFlutter.log(this, "getRenderMode only texture mode");
        return RenderMode.texture;
    }

    public TransparencyMode getTransparencyMode() {
        return TransparencyMode.opaque;
    }

    public SplashScreen provideSplashScreen() {
        return new NSkeletonFlutterSplashView();
    }

    public PlatformPlugin providePlatformPlugin(Activity activity, FlutterEngine flutterEngine) {
        if (activity != null) {
            return new PlatformPlugin(getActivity(), flutterEngine.getPlatformChannel());
        }
        return null;
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        NSkeletonFlutter.log(this, "configureFlutterEngine");
    }

    public void cleanUpFlutterEngine(FlutterEngine flutterEngine) {
        NSkeletonFlutter.log(this, "cleanUpFlutterEngine");
    }

    public void onFlutterUiDisplayed() {
        NSkeletonFlutter.log(this, "onFlutterUiDisplayed");
        this.mRootView.setBackgroundColor(0);
        if (Build.VERSION.SDK_INT >= 21 && getActivity() != null) {
            try {
                getActivity().reportFullyDrawn();
            } catch (SecurityException unused) {
            }
        }
    }

    public void onFlutterUiNoLongerDisplayed() {
        NSkeletonFlutter.log(this, "onFlutterUiNoLongerDisplayed");
    }

    public void addFlutterPlugin(FlutterEngine flutterEngine, FlutterPlugin flutterPlugin) {
        if (flutterEngine != null) {
            PluginRegistry plugins = flutterEngine.getPlugins();
            if (!plugins.has(flutterPlugin.getClass())) {
                plugins.add(flutterPlugin);
            }
        }
    }

    public void removeFlutterPlugin(FlutterEngine flutterEngine, Class<? extends FlutterPlugin> cls) {
        if (flutterEngine != null) {
            PluginRegistry plugins = flutterEngine.getPlugins();
            if (plugins.has(cls)) {
                plugins.remove(cls);
            }
        }
    }

    public void removeFlutterPlugin(FlutterEngine flutterEngine, FlutterPlugin flutterPlugin) {
        if (flutterPlugin != null) {
            removeFlutterPlugin(flutterEngine, (Class<? extends FlutterPlugin>) flutterPlugin.getClass());
        }
    }

    public void sendStartTimeStamp(String str) {
        if (provideNachoAction().getEngine() != null) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(provideNachoAction().getEngine().getDartExecutor().getBinaryMessenger(), "mas_quality_track_container_launch_time", new StandardMessageCodec());
            HashMap hashMap = new HashMap();
            hashMap.put("startTimeStamp", Long.valueOf(this.f60117d));
            hashMap.put("initialRoute", str);
            basicMessageChannel.send(hashMap);
        }
    }

    public void setAdaptStatusBarEnable(boolean z) {
        this.f60116c = z;
        if (z) {
            m45290c();
            return;
        }
        View view = this.mFakeStatusBar;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void setStatusBarColor(int i) {
        View view = this.mFakeStatusBar;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public Map<String, Object> transformBundleParameters(Bundle bundle) {
        HashMap hashMap = new HashMap();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                if (!(bundle.get(str) instanceof Bundle) && !(bundle.get(str) instanceof Class)) {
                    hashMap.put(str, bundle.get(str));
                }
            }
        }
        return hashMap;
    }

    /* renamed from: c */
    private void m45290c() {
        Window window;
        View decorView;
        Resources resources;
        Activity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null && (resources = activity.getResources()) != null && Build.VERSION.SDK_INT > 19 && decorView.findViewById(16908335) == null) {
            int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
            if (this.mFakeStatusBar != null) {
                this.mFakeStatusBar.setLayoutParams(new LinearLayout.LayoutParams(-1, dimensionPixelSize));
                this.mFakeStatusBar.setVisibility(0);
            }
            NSkeletonFlutter.log(this, "adaptStatusBar fixed");
        }
    }

    public ControllerChangeHandler getPushHandler() {
        return new HorizontalChangeHandler(false);
    }

    public void updateSystemUiOverlays() {
        this.mDelegate.mo181768j();
    }
}
