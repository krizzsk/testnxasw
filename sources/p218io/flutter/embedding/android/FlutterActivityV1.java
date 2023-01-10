package p218io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.didi.flutter.nacho2.p116v2.NachoConstants;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import p218io.flutter.Log;
import p218io.flutter.embedding.android.FlutterActivityAndFragmentDelegateV1;
import p218io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import p218io.flutter.embedding.engine.FlutterEngine;
import p218io.flutter.embedding.engine.FlutterShellArgs;
import p218io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister;
import p218io.flutter.plugin.platform.PlatformPlugin;
import p218io.flutter.util.ViewUtils;

/* renamed from: io.flutter.embedding.android.FlutterActivityV1 */
public class FlutterActivityV1 extends Activity implements LifecycleOwner, FlutterActivityAndFragmentDelegateV1.Host {
    public static final int FLUTTER_VIEW_ID = ViewUtils.generateViewId(61938);

    /* renamed from: b */
    private static final String f60183b = "FlutterActivity";

    /* renamed from: a */
    private Logger f60184a = LoggerFactory.getLogger("FlutterActivity2");

    /* renamed from: c */
    private LifecycleRegistry f60185c = new LifecycleRegistry(this);
    protected FlutterActivityAndFragmentDelegateV1 delegate;

    public void cleanUpFlutterEngine(FlutterEngine flutterEngine) {
    }

    public Activity getActivity() {
        return this;
    }

    public Context getContext() {
        return this;
    }

    public void onFlutterSurfaceViewCreated(FlutterSurfaceView flutterSurfaceView) {
    }

    public void onFlutterTextureViewCreated(FlutterTextureView flutterTextureView) {
    }

    public void onFlutterUiNoLongerDisplayed() {
    }

    public boolean popSystemNavigator() {
        return false;
    }

    public FlutterEngine provideFlutterEngine(Context context) {
        return null;
    }

    public boolean shouldAttachEngineToActivity() {
        return true;
    }

    public static Intent createDefaultIntent(Context context) {
        return withNewEngine().build(context);
    }

    public static NewEngineIntentBuilder withNewEngine() {
        return new NewEngineIntentBuilder(FlutterActivityV1.class);
    }

    /* renamed from: io.flutter.embedding.android.FlutterActivityV1$NewEngineIntentBuilder */
    public static class NewEngineIntentBuilder {
        private final Class<? extends FlutterActivityV1> activityClass;
        private String backgroundMode = FlutterActivityLaunchConfigs.f60182m;
        private String initialRoute = "/";

        public NewEngineIntentBuilder(Class<? extends FlutterActivityV1> cls) {
            this.activityClass = cls;
        }

        public NewEngineIntentBuilder initialRoute(String str) {
            this.initialRoute = str;
            return this;
        }

        public NewEngineIntentBuilder backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode backgroundMode2) {
            this.backgroundMode = backgroundMode2.name();
            return this;
        }

        public Intent build(Context context) {
            return new Intent(context, this.activityClass).putExtra("route", this.initialRoute).putExtra("background_mode", this.backgroundMode).putExtra("destroy_engine_with_activity", true);
        }
    }

    public static CachedEngineIntentBuilder withCachedEngine(String str) {
        return new CachedEngineIntentBuilder(FlutterActivity.class, str);
    }

    /* renamed from: io.flutter.embedding.android.FlutterActivityV1$CachedEngineIntentBuilder */
    public static class CachedEngineIntentBuilder {
        private final Class<? extends FlutterActivity> activityClass;
        private String backgroundMode = FlutterActivityLaunchConfigs.f60182m;
        private final String cachedEngineId;
        private boolean destroyEngineWithActivity = false;

        public CachedEngineIntentBuilder(Class<? extends FlutterActivity> cls, String str) {
            this.activityClass = cls;
            this.cachedEngineId = str;
        }

        public CachedEngineIntentBuilder destroyEngineWithActivity(boolean z) {
            this.destroyEngineWithActivity = z;
            return this;
        }

        public CachedEngineIntentBuilder backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode backgroundMode2) {
            this.backgroundMode = backgroundMode2.name();
            return this;
        }

        public Intent build(Context context) {
            return new Intent(context, this.activityClass).putExtra("cached_engine_id", this.cachedEngineId).putExtra("destroy_engine_with_activity", this.destroyEngineWithActivity).putExtra("background_mode", this.backgroundMode);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo181843a(FlutterActivityAndFragmentDelegateV1 flutterActivityAndFragmentDelegateV1) {
        this.delegate = flutterActivityAndFragmentDelegateV1;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        m45405a();
        super.onCreate(bundle);
        FlutterActivityAndFragmentDelegateV1 flutterActivityAndFragmentDelegateV1 = new FlutterActivityAndFragmentDelegateV1(this);
        this.delegate = flutterActivityAndFragmentDelegateV1;
        flutterActivityAndFragmentDelegateV1.mo181808a((Context) this);
        this.delegate.mo181810a(bundle);
        this.f60185c.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        m45408c();
        setContentView(m45409d());
        m45410e();
    }

    /* renamed from: a */
    private void m45405a() {
        try {
            Bundle metaData = getMetaData();
            if (metaData != null) {
                int i = metaData.getInt("io.flutter.embedding.android.NormalTheme", -1);
                if (i != -1) {
                    setTheme(i);
                    return;
                }
                return;
            }
            Log.m45259v(f60183b, "Using the launch theme as normal theme.");
        } catch (PackageManager.NameNotFoundException unused) {
            Log.m45255e(f60183b, "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
        }
    }

    public SplashScreen provideSplashScreen() {
        Drawable b = m45407b();
        if (b != null) {
            return new DrawableSplashScreen(b);
        }
        return null;
    }

    /* renamed from: b */
    private Drawable m45407b() {
        try {
            Bundle metaData = getMetaData();
            int i = metaData != null ? metaData.getInt("io.flutter.embedding.android.SplashScreenDrawable") : 0;
            if (i != 0) {
                return ResourcesCompat.getDrawable(getResources(), i, getTheme());
            }
            return null;
        } catch (Resources.NotFoundException e) {
            Log.m45255e(f60183b, "Splash screen not found. Ensure the drawable exists and that it's valid.");
            throw e;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: c */
    private void m45408c() {
        if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    /* renamed from: d */
    private View m45409d() {
        return this.delegate.mo181803a((LayoutInflater) null, (ViewGroup) null, (Bundle) null, FLUTTER_VIEW_ID, getRenderMode() == RenderMode.surface);
    }

    /* renamed from: e */
    private void m45410e() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            window.getDecorView().setSystemUiVisibility(1280);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f60185c.handleLifecycleEvent(Lifecycle.Event.ON_START);
        if (m45406a("onStart")) {
            this.delegate.mo181816f();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f60185c.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        if (m45406a("onResume")) {
            this.delegate.mo181817g();
        }
    }

    public void onPostResume() {
        super.onPostResume();
        if (m45406a("onPostResume")) {
            this.delegate.mo181818h();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (m45406a("onPause")) {
            this.delegate.mo181819i();
        }
        this.f60185c.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (m45406a("onStop")) {
            this.delegate.mo181820j();
        }
        this.f60185c.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (m45406a("onSaveInstanceState")) {
            this.delegate.mo181812b(bundle);
        }
    }

    /* renamed from: f */
    private void m45411f() {
        this.delegate.mo181821k();
        this.delegate.mo181822l();
        this.delegate.mo181804a();
        this.delegate = null;
    }

    public void detachFromFlutterEngine() {
        Log.m45261w(f60183b, "FlutterActivity " + this + " connection to the engine " + getFlutterEngine() + " evicted by another attaching activity");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (m45406a(NachoLifecycleManager.LIFECYCLE_ON_DESTROY)) {
            m45411f();
        }
        this.f60185c.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (m45406a("onActivityResult")) {
            this.delegate.mo181806a(i, i2, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (m45406a("onNewIntent")) {
            this.delegate.mo181809a(intent);
        }
    }

    public void onBackPressed() {
        if (m45406a("onBackPressed")) {
            this.delegate.mo181823m();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (m45406a("onRequestPermissionsResult")) {
            this.delegate.mo181807a(i, strArr, iArr);
        }
    }

    public void onUserLeaveHint() {
        if (m45406a("onUserLeaveHint")) {
            this.delegate.mo181824n();
        }
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (m45406a("onTrimMemory")) {
            this.delegate.mo181805a(i);
        }
    }

    public Lifecycle getLifecycle() {
        return this.f60185c;
    }

    public FlutterShellArgs getFlutterShellArgs() {
        return FlutterShellArgs.fromIntent(getIntent());
    }

    public String getCachedEngineId() {
        return getIntent().getStringExtra("cached_engine_id");
    }

    public boolean shouldDestroyEngineWithHost() {
        boolean booleanExtra = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
        return (getCachedEngineId() != null || this.delegate.mo181813c()) ? booleanExtra : getIntent().getBooleanExtra("destroy_engine_with_activity", true);
    }

    public String getDartEntrypointFunctionName() {
        try {
            Bundle metaData = getMetaData();
            String string = metaData != null ? metaData.getString("io.flutter.Entrypoint") : null;
            if (string != null) {
                return string;
            }
            return NachoConstants.NACHO_ENTRYPOINT_NAME;
        } catch (PackageManager.NameNotFoundException unused) {
            return NachoConstants.NACHO_ENTRYPOINT_NAME;
        }
    }

    public String getInitialRoute() {
        if (getIntent().hasExtra("route")) {
            return getIntent().getStringExtra("route");
        }
        try {
            Bundle metaData = getMetaData();
            if (metaData != null) {
                return metaData.getString("io.flutter.InitialRoute");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public String getAppBundlePath() {
        String dataString;
        if (!m45412g() || !"android.intent.action.RUN".equals(getIntent().getAction()) || (dataString = getIntent().getDataString()) == null) {
            return null;
        }
        return dataString;
    }

    /* renamed from: g */
    private boolean m45412g() {
        return (getApplicationInfo().flags & 2) != 0;
    }

    public RenderMode getRenderMode() {
        return getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque ? RenderMode.surface : RenderMode.texture;
    }

    public TransparencyMode getTransparencyMode() {
        if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque) {
            return TransparencyMode.opaque;
        }
        return TransparencyMode.transparent;
    }

    /* access modifiers changed from: protected */
    public FlutterActivityLaunchConfigs.BackgroundMode getBackgroundMode() {
        if (getIntent().hasExtra("background_mode")) {
            return FlutterActivityLaunchConfigs.BackgroundMode.valueOf(getIntent().getStringExtra("background_mode"));
        }
        return FlutterActivityLaunchConfigs.BackgroundMode.opaque;
    }

    /* access modifiers changed from: protected */
    public FlutterEngine getFlutterEngine() {
        FlutterActivityAndFragmentDelegateV1 flutterActivityAndFragmentDelegateV1 = this.delegate;
        if (flutterActivityAndFragmentDelegateV1 != null) {
            return flutterActivityAndFragmentDelegateV1.mo181811b();
        }
        this.f60184a.debug("getFlutterEngine failed, because delegate is no longer available", new Object[0]);
        return null;
    }

    /* access modifiers changed from: protected */
    public Bundle getMetaData() throws PackageManager.NameNotFoundException {
        return getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
    }

    public PlatformPlugin providePlatformPlugin(Activity activity, FlutterEngine flutterEngine) {
        return new PlatformPlugin(getActivity(), flutterEngine.getPlatformChannel(), this);
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        if (!this.delegate.mo181813c()) {
            GeneratedPluginRegister.registerGeneratedPlugins(flutterEngine);
        }
    }

    public boolean shouldHandleDeeplinking() {
        try {
            Bundle metaData = getMetaData();
            if (metaData != null) {
                return metaData.getBoolean("flutter_deeplinking_enabled");
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public void onFlutterUiDisplayed() {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                reportFullyDrawn();
            } catch (Exception unused) {
            }
        }
    }

    public boolean shouldRestoreAndSaveState() {
        if (getIntent().hasExtra("enable_state_restoration")) {
            return getIntent().getBooleanExtra("enable_state_restoration", false);
        }
        if (getCachedEngineId() != null) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m45406a(String str) {
        if (this.delegate != null) {
            return true;
        }
        Log.m45261w(f60183b, "FlutterActivity " + hashCode() + " " + str + " called after release.");
        return false;
    }
}
