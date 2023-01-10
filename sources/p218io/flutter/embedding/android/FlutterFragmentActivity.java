package p218io.flutter.embedding.android;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import com.didi.flutter.nacho2.p116v2.NachoConstants;
import com.didi.sdk.apm.SystemUtils;
import p218io.flutter.Log;
import p218io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import p218io.flutter.embedding.engine.FlutterEngine;
import p218io.flutter.embedding.engine.FlutterShellArgs;
import p218io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister;

/* renamed from: io.flutter.embedding.android.FlutterFragmentActivity */
public class FlutterFragmentActivity extends FragmentActivity implements FlutterEngineConfigurator, FlutterEngineProvider, SplashScreenProvider {

    /* renamed from: a */
    private static final String f60192a = "FlutterFragmentActivity";

    /* renamed from: b */
    private static final String f60193b = "flutter_fragment";

    /* renamed from: c */
    private static final int f60194c = 609893468;

    /* renamed from: d */
    private FlutterFragment f60195d;

    public void cleanUpFlutterEngine(FlutterEngine flutterEngine) {
    }

    public FlutterEngine provideFlutterEngine(Context context) {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean shouldAttachEngineToActivity() {
        return true;
    }

    public static Intent createDefaultIntent(Context context) {
        return withNewEngine().build(context);
    }

    public static NewEngineIntentBuilder withNewEngine() {
        return new NewEngineIntentBuilder(FlutterFragmentActivity.class);
    }

    /* renamed from: io.flutter.embedding.android.FlutterFragmentActivity$NewEngineIntentBuilder */
    public static class NewEngineIntentBuilder {
        private final Class<? extends FlutterFragmentActivity> activityClass;
        private String backgroundMode = FlutterActivityLaunchConfigs.f60182m;
        private String initialRoute = "/";

        public NewEngineIntentBuilder(Class<? extends FlutterFragmentActivity> cls) {
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
        return new CachedEngineIntentBuilder(FlutterFragmentActivity.class, str);
    }

    /* renamed from: io.flutter.embedding.android.FlutterFragmentActivity$CachedEngineIntentBuilder */
    public static class CachedEngineIntentBuilder {
        private final Class<? extends FlutterFragmentActivity> activityClass;
        private String backgroundMode = FlutterActivityLaunchConfigs.f60182m;
        private final String cachedEngineId;
        private boolean destroyEngineWithActivity = false;

        public CachedEngineIntentBuilder(Class<? extends FlutterFragmentActivity> cls, String str) {
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

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        m45422b();
        this.f60195d = mo181920a();
        super.onCreate(bundle);
        m45424d();
        setContentView(m45425e());
        m45427g();
        m45426f();
    }

    /* renamed from: b */
    private void m45422b() {
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
            Log.m45259v(f60192a, "Using the launch theme as normal theme.");
        } catch (PackageManager.NameNotFoundException unused) {
            Log.m45255e(f60192a, "Could not read meta-data for FlutterFragmentActivity. Using the launch theme as normal theme.");
        }
    }

    public SplashScreen provideSplashScreen() {
        Drawable c = m45423c();
        if (c != null) {
            return new DrawableSplashScreen(c);
        }
        return null;
    }

    /* renamed from: c */
    private Drawable m45423c() {
        try {
            Bundle metaData = getMetaData();
            int i = metaData != null ? metaData.getInt("io.flutter.embedding.android.SplashScreenDrawable") : 0;
            if (i != 0) {
                return ResourcesCompat.getDrawable(getResources(), i, getTheme());
            }
            return null;
        } catch (Resources.NotFoundException e) {
            Log.m45255e(f60192a, "Splash screen not found. Ensure the drawable exists and that it's valid.");
            throw e;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: d */
    private void m45424d() {
        if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    /* renamed from: e */
    private View m45425e() {
        FrameLayout provideRootLayout = provideRootLayout(this);
        provideRootLayout.setId(f60194c);
        provideRootLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return provideRootLayout;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public FlutterFragment mo181920a() {
        return (FlutterFragment) getSupportFragmentManager().findFragmentByTag(f60193b);
    }

    /* renamed from: f */
    private void m45426f() {
        if (this.f60195d == null) {
            this.f60195d = mo181920a();
        }
        if (this.f60195d == null) {
            this.f60195d = createFlutterFragment();
            getSupportFragmentManager().beginTransaction().add(f60194c, this.f60195d, f60193b).commit();
        }
    }

    /* access modifiers changed from: protected */
    public FlutterFragment createFlutterFragment() {
        TransparencyMode transparencyMode;
        FlutterActivityLaunchConfigs.BackgroundMode backgroundMode = getBackgroundMode();
        RenderMode renderMode = getRenderMode();
        if (backgroundMode == FlutterActivityLaunchConfigs.BackgroundMode.opaque) {
            transparencyMode = TransparencyMode.opaque;
        } else {
            transparencyMode = TransparencyMode.transparent;
        }
        boolean z = renderMode == RenderMode.surface;
        if (getCachedEngineId() != null) {
            Log.m45259v(f60192a, "Creating FlutterFragment with cached engine:\nCached engine ID: " + getCachedEngineId() + "\nWill destroy engine when Activity is destroyed: " + shouldDestroyEngineWithHost() + "\nBackground transparency mode: " + backgroundMode + "\nWill attach FlutterEngine to Activity: " + shouldAttachEngineToActivity());
            return FlutterFragment.withCachedEngine(getCachedEngineId()).renderMode(renderMode).transparencyMode(transparencyMode).handleDeeplinking(Boolean.valueOf(shouldHandleDeeplinking())).shouldAttachEngineToActivity(shouldAttachEngineToActivity()).destroyEngineWithFragment(shouldDestroyEngineWithHost()).shouldDelayFirstAndroidViewDraw(z).build();
        }
        Log.m45259v(f60192a, "Creating FlutterFragment with new engine:\nBackground transparency mode: " + backgroundMode + "\nDart entrypoint: " + getDartEntrypointFunctionName() + "\nInitial route: " + getInitialRoute() + "\nApp bundle path: " + getAppBundlePath() + "\nWill attach FlutterEngine to Activity: " + shouldAttachEngineToActivity());
        return FlutterFragment.withNewEngine().dartEntrypoint(getDartEntrypointFunctionName()).initialRoute(getInitialRoute()).appBundlePath(getAppBundlePath()).flutterShellArgs(FlutterShellArgs.fromIntent(getIntent())).handleDeeplinking(Boolean.valueOf(shouldHandleDeeplinking())).renderMode(renderMode).transparencyMode(transparencyMode).shouldAttachEngineToActivity(shouldAttachEngineToActivity()).shouldDelayFirstAndroidViewDraw(z).build();
    }

    /* renamed from: g */
    private void m45427g() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(1073741824);
            window.getDecorView().setSystemUiVisibility(1280);
        }
    }

    public void onPostResume() {
        super.onPostResume();
        this.f60195d.onPostResume();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        this.f60195d.onNewIntent(intent);
        super.onNewIntent(intent);
    }

    public void onBackPressed() {
        this.f60195d.onBackPressed();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.f60195d.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void onUserLeaveHint() {
        this.f60195d.onUserLeaveHint();
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        this.f60195d.onTrimMemory(i);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f60195d.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: protected */
    public FlutterEngine getFlutterEngine() {
        return this.f60195d.getFlutterEngine();
    }

    public boolean shouldDestroyEngineWithHost() {
        return getIntent().getBooleanExtra("destroy_engine_with_activity", false);
    }

    /* access modifiers changed from: protected */
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

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        FlutterFragment flutterFragment = this.f60195d;
        if (flutterFragment == null || !flutterFragment.mo181862a()) {
            GeneratedPluginRegister.registerGeneratedPlugins(flutterEngine);
        }
    }

    /* access modifiers changed from: protected */
    public String getAppBundlePath() {
        String dataString;
        if (!m45428h() || !"android.intent.action.RUN".equals(getIntent().getAction()) || (dataString = getIntent().getDataString()) == null) {
            return null;
        }
        return dataString;
    }

    /* access modifiers changed from: protected */
    public Bundle getMetaData() throws PackageManager.NameNotFoundException {
        return getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
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

    /* access modifiers changed from: protected */
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

    /* access modifiers changed from: protected */
    public String getCachedEngineId() {
        return getIntent().getStringExtra("cached_engine_id");
    }

    /* access modifiers changed from: protected */
    public FlutterActivityLaunchConfigs.BackgroundMode getBackgroundMode() {
        if (getIntent().hasExtra("background_mode")) {
            return FlutterActivityLaunchConfigs.BackgroundMode.valueOf(getIntent().getStringExtra("background_mode"));
        }
        return FlutterActivityLaunchConfigs.BackgroundMode.opaque;
    }

    /* access modifiers changed from: protected */
    public RenderMode getRenderMode() {
        return getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque ? RenderMode.surface : RenderMode.texture;
    }

    /* renamed from: h */
    private boolean m45428h() {
        return (getApplicationInfo().flags & 2) != 0;
    }

    /* access modifiers changed from: protected */
    public FrameLayout provideRootLayout(Context context) {
        return new FrameLayout(context);
    }
}
