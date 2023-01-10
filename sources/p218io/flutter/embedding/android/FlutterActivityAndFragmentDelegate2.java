package p218io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.lifecycle.Lifecycle;
import com.didi.flutter.nacho.Nacho;
import java.util.Arrays;
import p218io.flutter.FlutterInjector;
import p218io.flutter.Log;
import p218io.flutter.embedding.engine.FlutterEngine;
import p218io.flutter.embedding.engine.FlutterEngineCache;
import p218io.flutter.embedding.engine.FlutterShellArgs;
import p218io.flutter.embedding.engine.dart.DartExecutor;
import p218io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import p218io.flutter.plugin.platform.PlatformPlugin;
import p218io.flutter.util.ViewUtils;
import rui.config.RConfigConstants;

/* renamed from: io.flutter.embedding.android.FlutterActivityAndFragmentDelegate2 */
class FlutterActivityAndFragmentDelegate2 implements ExclusiveAppComponent<Activity> {

    /* renamed from: b */
    private static final String f60144b = "FlutterActivityAndFragmentDelegate";

    /* renamed from: c */
    private static final String f60145c = "framework";

    /* renamed from: d */
    private static final String f60146d = "plugins";

    /* renamed from: e */
    private static final int f60147e = 486947586;

    /* renamed from: a */
    ViewTreeObserver.OnPreDrawListener f60148a;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Host f60149f;

    /* renamed from: g */
    private FlutterEngine f60150g;

    /* renamed from: h */
    private FlutterView3 f60151h;

    /* renamed from: i */
    private PlatformPlugin f60152i;

    /* renamed from: j */
    private boolean f60153j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f60154k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f60155l;

    /* renamed from: m */
    private boolean f60156m;

    /* renamed from: n */
    private final FlutterUiDisplayListener f60157n = new FlutterUiDisplayListener() {
        public void onFlutterUiDisplayed() {
            FlutterActivityAndFragmentDelegate2.this.f60149f.onFlutterUiDisplayed();
            boolean unused = FlutterActivityAndFragmentDelegate2.this.f60154k = true;
            boolean unused2 = FlutterActivityAndFragmentDelegate2.this.f60155l = true;
        }

        public void onFlutterUiNoLongerDisplayed() {
            FlutterActivityAndFragmentDelegate2.this.f60149f.onFlutterUiNoLongerDisplayed();
            boolean unused = FlutterActivityAndFragmentDelegate2.this.f60154k = false;
        }
    };

    /* renamed from: io.flutter.embedding.android.FlutterActivityAndFragmentDelegate2$Host */
    interface Host extends FlutterEngineConfigurator, FlutterEngineProvider, SplashScreenProvider, PlatformPlugin.PlatformPluginDelegate {
        void cleanUpFlutterEngine(FlutterEngine flutterEngine);

        void configureFlutterEngine(FlutterEngine flutterEngine);

        void detachFromFlutterEngine();

        Activity getActivity();

        String getAppBundlePath();

        String getCachedEngineId();

        Context getContext();

        String getDartEntrypointFunctionName();

        FlutterShellArgs getFlutterShellArgs();

        String getInitialRoute();

        Lifecycle getLifecycle();

        RenderMode getRenderMode();

        TransparencyMode getTransparencyMode();

        void onFlutterSurfaceViewCreated(FlutterSurfaceView flutterSurfaceView);

        void onFlutterTextureViewCreated(FlutterTextureView flutterTextureView);

        void onFlutterUiDisplayed();

        void onFlutterUiNoLongerDisplayed();

        FlutterEngine provideFlutterEngine(Context context);

        PlatformPlugin providePlatformPlugin(Activity activity, FlutterEngine flutterEngine);

        SplashScreen provideSplashScreen();

        boolean shouldAttachEngineToActivity();

        boolean shouldDestroyEngineWithHost();

        boolean shouldHandleDeeplinking();

        boolean shouldRestoreAndSaveState();

        void updateSystemUiOverlays();
    }

    FlutterActivityAndFragmentDelegate2(Host host) {
        this.f60149f = host;
        this.f60155l = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo181778a() {
        this.f60149f = null;
        this.f60150g = null;
        this.f60151h = null;
        this.f60152i = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public FlutterEngine mo181785b() {
        return this.f60150g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo181787c() {
        return this.f60153j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo181788d() {
        return this.f60156m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo181782a(Context context) {
        m45349s();
        if (this.f60150g == null) {
            mo181790f();
        }
        if (this.f60149f.shouldAttachEngineToActivity()) {
            Log.m45259v(f60144b, "Attaching FlutterEngine to the Activity that owns this delegate.");
            this.f60150g.getActivityControlSurface().attachToActivity(this, this.f60149f.getLifecycle());
        }
        Host host = this.f60149f;
        this.f60152i = host.providePlatformPlugin(host.getActivity(), this.f60150g);
        this.f60149f.configureFlutterEngine(this.f60150g);
        this.f60156m = true;
    }

    /* renamed from: e */
    public Activity getAppComponent() {
        Activity activity = this.f60149f.getActivity();
        if (activity != null) {
            return activity;
        }
        throw new AssertionError("FlutterActivityAndFragmentDelegate's getAppComponent should only be queried after onAttach, when the host's activity should always be non-null");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo181790f() {
        Log.m45259v(f60144b, "Setting up FlutterEngine.");
        String cachedEngineId = this.f60149f.getCachedEngineId();
        if (cachedEngineId != null) {
            FlutterEngine flutterEngine = FlutterEngineCache.getInstance().get(cachedEngineId);
            this.f60150g = flutterEngine;
            this.f60153j = true;
            if (flutterEngine == null) {
                throw new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + cachedEngineId + "'");
            }
            return;
        }
        Host host = this.f60149f;
        FlutterEngine provideFlutterEngine = host.provideFlutterEngine(host.getContext());
        this.f60150g = provideFlutterEngine;
        if (provideFlutterEngine != null) {
            this.f60153j = true;
            return;
        }
        Log.m45259v(f60144b, "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
        this.f60150g = new FlutterEngine(this.f60149f.getContext(), this.f60149f.getFlutterShellArgs().toArray(), false, this.f60149f.shouldRestoreAndSaveState());
        this.f60153j = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo181777a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, int i, boolean z) {
        Log.m45259v(f60144b, "Creating FlutterView.");
        m45349s();
        boolean z2 = true;
        if (this.f60149f.getRenderMode() == RenderMode.surface) {
            Context context = this.f60149f.getContext();
            if (this.f60149f.getTransparencyMode() != TransparencyMode.transparent) {
                z2 = false;
            }
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context, z2);
            this.f60149f.onFlutterSurfaceViewCreated(flutterSurfaceView);
            this.f60151h = new FlutterView3(this.f60149f.getContext(), flutterSurfaceView);
        } else {
            FlutterTextureView flutterTextureView = new FlutterTextureView(this.f60149f.getContext());
            if (this.f60149f.getTransparencyMode() != TransparencyMode.opaque) {
                z2 = false;
            }
            flutterTextureView.setOpaque(z2);
            this.f60149f.onFlutterTextureViewCreated(flutterTextureView);
            this.f60151h = new FlutterView3(this.f60149f.getContext(), flutterTextureView);
        }
        this.f60151h.addOnFirstFrameRenderedListener(this.f60157n);
        Log.m45259v(f60144b, "Attaching FlutterEngine to FlutterView.");
        this.f60151h.attachToFlutterEngine(this.f60150g);
        this.f60151h.setId(i);
        SplashScreen provideSplashScreen = this.f60149f.provideSplashScreen();
        if (provideSplashScreen != null) {
            Log.m45261w(f60144b, "A splash screen was provided to Flutter, but this is deprecated. See flutter.dev/go/android-splash-migration for migration steps.");
            FlutterSplashView2 flutterSplashView2 = new FlutterSplashView2(this.f60149f.getContext());
            flutterSplashView2.setId(ViewUtils.generateViewId(f60147e));
            flutterSplashView2.mo181961a(this.f60151h, provideSplashScreen);
            return flutterSplashView2;
        }
        if (z) {
            m45343a(this.f60151h);
        }
        return this.f60151h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo181784a(Bundle bundle) {
        Bundle bundle2;
        Log.m45259v(f60144b, "onRestoreInstanceState. Giving framework and plugins an opportunity to restore state.");
        m45349s();
        byte[] bArr = null;
        if (bundle != null) {
            Bundle bundle3 = bundle.getBundle(f60146d);
            bArr = bundle.getByteArray("framework");
            bundle2 = bundle3;
        } else {
            bundle2 = null;
        }
        if (this.f60149f.shouldRestoreAndSaveState()) {
            this.f60150g.getRestorationChannel().setRestorationData(bArr);
        }
        if (this.f60149f.shouldAttachEngineToActivity()) {
            this.f60150g.getActivityControlSurface().onRestoreInstanceState(bundle2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo181791g() {
        Log.m45259v(f60144b, "onStart()");
        m45349s();
        m45348r();
    }

    /* renamed from: r */
    private void m45348r() {
        if (this.f60149f.getCachedEngineId() == null && !this.f60150g.getDartExecutor().isExecutingDart()) {
            String initialRoute = this.f60149f.getInitialRoute();
            if (initialRoute == null && (initialRoute = m45345b(this.f60149f.getActivity().getIntent())) == null) {
                initialRoute = "/";
            }
            Log.m45259v(f60144b, "Executing Dart entrypoint: " + this.f60149f.getDartEntrypointFunctionName() + ", and sending initial route: " + initialRoute);
            this.f60150g.getNavigationChannel().setInitialRoute(initialRoute);
            String appBundlePath = this.f60149f.getAppBundlePath();
            if (appBundlePath == null || appBundlePath.isEmpty()) {
                appBundlePath = FlutterInjector.instance().flutterLoader().findAppBundlePath();
            }
            this.f60150g.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint(appBundlePath, this.f60149f.getDartEntrypointFunctionName()));
        }
    }

    /* renamed from: b */
    private String m45345b(Intent intent) {
        Uri data;
        String path;
        if (!this.f60149f.shouldHandleDeeplinking() || (data = intent.getData()) == null || (path = data.getPath()) == null || path.isEmpty()) {
            return null;
        }
        if (data.getQuery() != null && !data.getQuery().isEmpty()) {
            path = path + "?" + data.getQuery();
        }
        if (data.getFragment() == null || data.getFragment().isEmpty()) {
            return path;
        }
        return path + RConfigConstants.KEYWORD_COLOR_SIGN + data.getFragment();
    }

    /* renamed from: a */
    private void m45343a(final FlutterView3 flutterView3) {
        if (this.f60149f.getRenderMode() == RenderMode.surface) {
            if (this.f60148a != null) {
                flutterView3.getViewTreeObserver().removeOnPreDrawListener(this.f60148a);
            }
            this.f60148a = new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    if (FlutterActivityAndFragmentDelegate2.this.f60154k && FlutterActivityAndFragmentDelegate2.this.f60148a != null) {
                        flutterView3.getViewTreeObserver().removeOnPreDrawListener(this);
                        FlutterActivityAndFragmentDelegate2.this.f60148a = null;
                    }
                    return FlutterActivityAndFragmentDelegate2.this.f60154k;
                }
            };
            flutterView3.getViewTreeObserver().addOnPreDrawListener(this.f60148a);
            return;
        }
        throw new IllegalArgumentException("Cannot delay the first Android view draw when the render mode is not set to `RenderMode.surface`.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo181792h() {
        Log.m45259v(f60144b, "onResume()");
        m45349s();
        this.f60151h.attachToRenderer();
        this.f60151h.fixViewSize();
        this.f60150g.getLifecycleChannel().appIsResumed();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo181793i() {
        Log.m45259v(f60144b, "onPostResume()");
        m45349s();
        if (this.f60150g != null) {
            mo181794j();
        } else {
            Log.m45261w(f60144b, "onPostResume() invoked before FlutterFragment was attached to an Activity.");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo181794j() {
        PlatformPlugin platformPlugin = this.f60152i;
        if (platformPlugin != null) {
            platformPlugin.updateSystemUiOverlays();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo181795k() {
        Log.m45259v(f60144b, "onPause()");
        m45349s();
        if (Nacho.getInstance().isPaddingOpenContainer()) {
            this.f60151h.detachFromRenderer();
        }
        this.f60150g.getLifecycleChannel().appIsInactive();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo181796l() {
        Log.m45259v(f60144b, "onStop()");
        m45349s();
        this.f60150g.getLifecycleChannel().appIsPaused();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo181797m() {
        Log.m45259v(f60144b, "onDestroyView()");
        m45349s();
        if (this.f60148a != null) {
            this.f60151h.getViewTreeObserver().removeOnPreDrawListener(this.f60148a);
            this.f60148a = null;
        }
        this.f60151h.detachFromFlutterEngine();
        this.f60151h.removeOnFirstFrameRenderedListener(this.f60157n);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo181786b(Bundle bundle) {
        Log.m45259v(f60144b, "onSaveInstanceState. Giving framework and plugins an opportunity to save state.");
        m45349s();
        if (this.f60149f.shouldRestoreAndSaveState()) {
            bundle.putByteArray("framework", this.f60150g.getRestorationChannel().getRestorationData());
        }
        if (this.f60149f.shouldAttachEngineToActivity()) {
            Bundle bundle2 = new Bundle();
            this.f60150g.getActivityControlSurface().onSaveInstanceState(bundle2);
            bundle.putBundle(f60146d, bundle2);
        }
    }

    public void detachFromFlutterEngine() {
        if (!this.f60149f.shouldDestroyEngineWithHost()) {
            this.f60149f.detachFromFlutterEngine();
            return;
        }
        throw new AssertionError("The internal FlutterEngine created by " + this.f60149f + " has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public void mo181798n() {
        Log.m45259v(f60144b, "onDetach()");
        m45349s();
        this.f60149f.cleanUpFlutterEngine(this.f60150g);
        if (this.f60149f.shouldAttachEngineToActivity()) {
            Log.m45259v(f60144b, "Detaching FlutterEngine from the Activity that owns this Fragment.");
            if (this.f60149f.getActivity().isChangingConfigurations()) {
                this.f60150g.getActivityControlSurface().detachFromActivityForConfigChanges();
            } else {
                this.f60150g.getActivityControlSurface().detachFromActivity();
            }
        }
        PlatformPlugin platformPlugin = this.f60152i;
        if (platformPlugin != null) {
            platformPlugin.destroy();
            this.f60152i = null;
        }
        this.f60150g.getLifecycleChannel().appIsDetached();
        if (this.f60149f.shouldDestroyEngineWithHost()) {
            this.f60150g.destroy();
            if (this.f60149f.getCachedEngineId() != null) {
                FlutterEngineCache.getInstance().remove(this.f60149f.getCachedEngineId());
            }
            this.f60150g = null;
        }
        this.f60156m = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public void mo181799o() {
        m45349s();
        if (this.f60150g != null) {
            Log.m45259v(f60144b, "Forwarding onBackPressed() to FlutterEngine.");
            this.f60150g.getNavigationChannel().popRoute();
            return;
        }
        Log.m45261w(f60144b, "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo181781a(int i, String[] strArr, int[] iArr) {
        m45349s();
        if (this.f60150g != null) {
            Log.m45259v(f60144b, "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr));
            this.f60150g.getActivityControlSurface().onRequestPermissionsResult(i, strArr, iArr);
            return;
        }
        Log.m45261w(f60144b, "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo181783a(Intent intent) {
        m45349s();
        if (this.f60150g != null) {
            Log.m45259v(f60144b, "Forwarding onNewIntent() to FlutterEngine and sending pushRoute message.");
            this.f60150g.getActivityControlSurface().onNewIntent(intent);
            String b = m45345b(intent);
            if (b != null && !b.isEmpty()) {
                this.f60150g.getNavigationChannel().pushRoute(b);
                return;
            }
            return;
        }
        Log.m45261w(f60144b, "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo181780a(int i, int i2, Intent intent) {
        m45349s();
        if (this.f60150g != null) {
            Log.m45259v(f60144b, "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i + "\nresultCode: " + i2 + "\ndata: " + intent);
            this.f60150g.getActivityControlSurface().onActivityResult(i, i2, intent);
            return;
        }
        Log.m45261w(f60144b, "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo181800p() {
        m45349s();
        if (this.f60150g != null) {
            Log.m45259v(f60144b, "Forwarding onUserLeaveHint() to FlutterEngine.");
            this.f60150g.getActivityControlSurface().onUserLeaveHint();
            return;
        }
        Log.m45261w(f60144b, "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo181779a(int i) {
        m45349s();
        if (this.f60150g != null) {
            if (this.f60155l && i >= 10) {
                this.f60150g.getDartExecutor().notifyLowMemoryWarning();
                this.f60150g.getSystemChannel().sendMemoryPressureWarning();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public void mo181801q() {
        Log.m45259v(f60144b, "Forwarding onLowMemory() to FlutterEngine.");
        m45349s();
        this.f60150g.getDartExecutor().notifyLowMemoryWarning();
        this.f60150g.getSystemChannel().sendMemoryPressureWarning();
    }

    /* renamed from: s */
    private void m45349s() {
        if (this.f60149f == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }
}
