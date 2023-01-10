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

/* renamed from: io.flutter.embedding.android.FlutterActivityAndFragmentDelegate */
class FlutterActivityAndFragmentDelegate implements ExclusiveAppComponent<Activity> {

    /* renamed from: b */
    private static final String f60130b = "FlutterActivityAndFragmentDelegate";

    /* renamed from: c */
    private static final String f60131c = "framework";

    /* renamed from: d */
    private static final String f60132d = "plugins";

    /* renamed from: e */
    private static final int f60133e = 486947586;

    /* renamed from: a */
    ViewTreeObserver.OnPreDrawListener f60134a;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Host f60135f;

    /* renamed from: g */
    private FlutterEngine f60136g;

    /* renamed from: h */
    private FlutterView f60137h;

    /* renamed from: i */
    private PlatformPlugin f60138i;

    /* renamed from: j */
    private boolean f60139j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f60140k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f60141l;

    /* renamed from: m */
    private boolean f60142m;

    /* renamed from: n */
    private final FlutterUiDisplayListener f60143n = new FlutterUiDisplayListener() {
        public void onFlutterUiDisplayed() {
            FlutterActivityAndFragmentDelegate.this.f60135f.onFlutterUiDisplayed();
            boolean unused = FlutterActivityAndFragmentDelegate.this.f60140k = true;
            boolean unused2 = FlutterActivityAndFragmentDelegate.this.f60141l = true;
        }

        public void onFlutterUiNoLongerDisplayed() {
            FlutterActivityAndFragmentDelegate.this.f60135f.onFlutterUiNoLongerDisplayed();
            boolean unused = FlutterActivityAndFragmentDelegate.this.f60140k = false;
        }
    };

    /* renamed from: io.flutter.embedding.android.FlutterActivityAndFragmentDelegate$Host */
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

    FlutterActivityAndFragmentDelegate(Host host) {
        this.f60135f = host;
        this.f60141l = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo181752a() {
        this.f60135f = null;
        this.f60136g = null;
        this.f60137h = null;
        this.f60138i = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public FlutterEngine mo181759b() {
        return this.f60136g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo181761c() {
        return this.f60139j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo181762d() {
        return this.f60142m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo181756a(Context context) {
        m45316s();
        if (this.f60136g == null) {
            mo181764f();
        }
        if (this.f60135f.shouldAttachEngineToActivity()) {
            Log.m45259v(f60130b, "Attaching FlutterEngine to the Activity that owns this delegate.");
            this.f60136g.getActivityControlSurface().attachToActivity(this, this.f60135f.getLifecycle());
        }
        Host host = this.f60135f;
        this.f60138i = host.providePlatformPlugin(host.getActivity(), this.f60136g);
        this.f60135f.configureFlutterEngine(this.f60136g);
        this.f60142m = true;
    }

    /* renamed from: e */
    public Activity getAppComponent() {
        Activity activity = this.f60135f.getActivity();
        if (activity != null) {
            return activity;
        }
        throw new AssertionError("FlutterActivityAndFragmentDelegate's getAppComponent should only be queried after onAttach, when the host's activity should always be non-null");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo181764f() {
        Log.m45259v(f60130b, "Setting up FlutterEngine.");
        String cachedEngineId = this.f60135f.getCachedEngineId();
        if (cachedEngineId != null) {
            FlutterEngine flutterEngine = FlutterEngineCache.getInstance().get(cachedEngineId);
            this.f60136g = flutterEngine;
            this.f60139j = true;
            if (flutterEngine == null) {
                throw new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + cachedEngineId + "'");
            }
            return;
        }
        Host host = this.f60135f;
        FlutterEngine provideFlutterEngine = host.provideFlutterEngine(host.getContext());
        this.f60136g = provideFlutterEngine;
        if (provideFlutterEngine != null) {
            this.f60139j = true;
            return;
        }
        Log.m45259v(f60130b, "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
        this.f60136g = new FlutterEngine(this.f60135f.getContext(), this.f60135f.getFlutterShellArgs().toArray(), false, this.f60135f.shouldRestoreAndSaveState());
        this.f60139j = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo181751a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, int i, boolean z) {
        Log.m45259v(f60130b, "Creating FlutterView.");
        m45316s();
        boolean z2 = true;
        if (this.f60135f.getRenderMode() == RenderMode.surface) {
            Context context = this.f60135f.getContext();
            if (this.f60135f.getTransparencyMode() != TransparencyMode.transparent) {
                z2 = false;
            }
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context, z2);
            this.f60135f.onFlutterSurfaceViewCreated(flutterSurfaceView);
            this.f60137h = new FlutterView(this.f60135f.getContext(), flutterSurfaceView);
        } else {
            FlutterTextureView flutterTextureView = new FlutterTextureView(this.f60135f.getContext());
            if (this.f60135f.getTransparencyMode() != TransparencyMode.opaque) {
                z2 = false;
            }
            flutterTextureView.setOpaque(z2);
            this.f60135f.onFlutterTextureViewCreated(flutterTextureView);
            this.f60137h = new FlutterView(this.f60135f.getContext(), flutterTextureView);
        }
        this.f60137h.addOnFirstFrameRenderedListener(this.f60143n);
        Log.m45259v(f60130b, "Attaching FlutterEngine to FlutterView.");
        this.f60137h.attachToFlutterEngine(this.f60136g);
        this.f60137h.setId(i);
        SplashScreen provideSplashScreen = this.f60135f.provideSplashScreen();
        if (provideSplashScreen != null) {
            Log.m45261w(f60130b, "A splash screen was provided to Flutter, but this is deprecated. See flutter.dev/go/android-splash-migration for migration steps.");
            FlutterSplashView flutterSplashView = new FlutterSplashView(this.f60135f.getContext());
            flutterSplashView.setId(ViewUtils.generateViewId(f60133e));
            flutterSplashView.mo181952a(this.f60137h, provideSplashScreen);
            return flutterSplashView;
        }
        if (z) {
            m45310a(this.f60137h);
        }
        return this.f60137h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo181758a(Bundle bundle) {
        Bundle bundle2;
        Log.m45259v(f60130b, "onRestoreInstanceState. Giving framework and plugins an opportunity to restore state.");
        m45316s();
        byte[] bArr = null;
        if (bundle != null) {
            Bundle bundle3 = bundle.getBundle(f60132d);
            bArr = bundle.getByteArray("framework");
            bundle2 = bundle3;
        } else {
            bundle2 = null;
        }
        if (this.f60135f.shouldRestoreAndSaveState()) {
            this.f60136g.getRestorationChannel().setRestorationData(bArr);
        }
        if (this.f60135f.shouldAttachEngineToActivity()) {
            this.f60136g.getActivityControlSurface().onRestoreInstanceState(bundle2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo181765g() {
        Log.m45259v(f60130b, "onStart()");
        m45316s();
        m45315r();
    }

    /* renamed from: r */
    private void m45315r() {
        if (this.f60135f.getCachedEngineId() == null && !this.f60136g.getDartExecutor().isExecutingDart()) {
            String initialRoute = this.f60135f.getInitialRoute();
            if (initialRoute == null && (initialRoute = m45312b(this.f60135f.getActivity().getIntent())) == null) {
                initialRoute = "/";
            }
            Log.m45259v(f60130b, "Executing Dart entrypoint: " + this.f60135f.getDartEntrypointFunctionName() + ", and sending initial route: " + initialRoute);
            this.f60136g.getNavigationChannel().setInitialRoute(initialRoute);
            String appBundlePath = this.f60135f.getAppBundlePath();
            if (appBundlePath == null || appBundlePath.isEmpty()) {
                appBundlePath = FlutterInjector.instance().flutterLoader().findAppBundlePath();
            }
            this.f60136g.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint(appBundlePath, this.f60135f.getDartEntrypointFunctionName()));
        }
    }

    /* renamed from: b */
    private String m45312b(Intent intent) {
        Uri data;
        String path;
        if (!this.f60135f.shouldHandleDeeplinking() || (data = intent.getData()) == null || (path = data.getPath()) == null || path.isEmpty()) {
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
    private void m45310a(final FlutterView flutterView) {
        if (this.f60135f.getRenderMode() == RenderMode.surface) {
            if (this.f60134a != null) {
                flutterView.getViewTreeObserver().removeOnPreDrawListener(this.f60134a);
            }
            this.f60134a = new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    if (FlutterActivityAndFragmentDelegate.this.f60140k && FlutterActivityAndFragmentDelegate.this.f60134a != null) {
                        flutterView.getViewTreeObserver().removeOnPreDrawListener(this);
                        FlutterActivityAndFragmentDelegate.this.f60134a = null;
                    }
                    return FlutterActivityAndFragmentDelegate.this.f60140k;
                }
            };
            flutterView.getViewTreeObserver().addOnPreDrawListener(this.f60134a);
            return;
        }
        throw new IllegalArgumentException("Cannot delay the first Android view draw when the render mode is not set to `RenderMode.surface`.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo181766h() {
        Log.m45259v(f60130b, "onResume()");
        m45316s();
        this.f60136g.getLifecycleChannel().appIsResumed();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo181767i() {
        Log.m45259v(f60130b, "onPostResume()");
        m45316s();
        if (this.f60136g != null) {
            mo181768j();
        } else {
            Log.m45261w(f60130b, "onPostResume() invoked before FlutterFragment was attached to an Activity.");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo181768j() {
        PlatformPlugin platformPlugin = this.f60138i;
        if (platformPlugin != null) {
            platformPlugin.updateSystemUiOverlays();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo181769k() {
        Log.m45259v(f60130b, "onPause()");
        m45316s();
        this.f60136g.getLifecycleChannel().appIsInactive();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo181770l() {
        Log.m45259v(f60130b, "onStop()");
        m45316s();
        this.f60136g.getLifecycleChannel().appIsPaused();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo181771m() {
        Log.m45259v(f60130b, "onDestroyView()");
        m45316s();
        if (this.f60134a != null) {
            this.f60137h.getViewTreeObserver().removeOnPreDrawListener(this.f60134a);
            this.f60134a = null;
        }
        this.f60137h.detachFromFlutterEngine();
        this.f60137h.removeOnFirstFrameRenderedListener(this.f60143n);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo181760b(Bundle bundle) {
        Log.m45259v(f60130b, "onSaveInstanceState. Giving framework and plugins an opportunity to save state.");
        m45316s();
        if (this.f60135f.shouldRestoreAndSaveState()) {
            bundle.putByteArray("framework", this.f60136g.getRestorationChannel().getRestorationData());
        }
        if (this.f60135f.shouldAttachEngineToActivity()) {
            Bundle bundle2 = new Bundle();
            this.f60136g.getActivityControlSurface().onSaveInstanceState(bundle2);
            bundle.putBundle(f60132d, bundle2);
        }
    }

    public void detachFromFlutterEngine() {
        if (!this.f60135f.shouldDestroyEngineWithHost()) {
            this.f60135f.detachFromFlutterEngine();
            return;
        }
        throw new AssertionError("The internal FlutterEngine created by " + this.f60135f + " has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public void mo181772n() {
        Log.m45259v(f60130b, "onDetach()");
        m45316s();
        this.f60135f.cleanUpFlutterEngine(this.f60136g);
        if (this.f60135f.shouldAttachEngineToActivity()) {
            Log.m45259v(f60130b, "Detaching FlutterEngine from the Activity that owns this Fragment.");
            if (this.f60135f.getActivity().isChangingConfigurations()) {
                this.f60136g.getActivityControlSurface().detachFromActivityForConfigChanges();
            } else {
                this.f60136g.getActivityControlSurface().detachFromActivity();
            }
        }
        PlatformPlugin platformPlugin = this.f60138i;
        if (platformPlugin != null) {
            platformPlugin.destroy();
            this.f60138i = null;
        }
        this.f60136g.getLifecycleChannel().appIsDetached();
        if (this.f60135f.shouldDestroyEngineWithHost()) {
            this.f60136g.destroy();
            if (this.f60135f.getCachedEngineId() != null) {
                FlutterEngineCache.getInstance().remove(this.f60135f.getCachedEngineId());
            }
            this.f60136g = null;
        }
        this.f60142m = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public void mo181773o() {
        m45316s();
        if (this.f60136g != null) {
            Log.m45259v(f60130b, "Forwarding onBackPressed() to FlutterEngine.");
            this.f60136g.getNavigationChannel().popRoute();
            return;
        }
        Log.m45261w(f60130b, "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo181755a(int i, String[] strArr, int[] iArr) {
        m45316s();
        if (this.f60136g != null) {
            Log.m45259v(f60130b, "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr));
            this.f60136g.getActivityControlSurface().onRequestPermissionsResult(i, strArr, iArr);
            return;
        }
        Log.m45261w(f60130b, "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo181757a(Intent intent) {
        m45316s();
        if (this.f60136g != null) {
            Log.m45259v(f60130b, "Forwarding onNewIntent() to FlutterEngine and sending pushRoute message.");
            this.f60136g.getActivityControlSurface().onNewIntent(intent);
            String b = m45312b(intent);
            if (b != null && !b.isEmpty()) {
                this.f60136g.getNavigationChannel().pushRoute(b);
                return;
            }
            return;
        }
        Log.m45261w(f60130b, "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo181754a(int i, int i2, Intent intent) {
        m45316s();
        if (this.f60136g != null) {
            Log.m45259v(f60130b, "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i + "\nresultCode: " + i2 + "\ndata: " + intent);
            this.f60136g.getActivityControlSurface().onActivityResult(i, i2, intent);
            return;
        }
        Log.m45261w(f60130b, "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo181774p() {
        m45316s();
        if (this.f60136g != null) {
            Log.m45259v(f60130b, "Forwarding onUserLeaveHint() to FlutterEngine.");
            this.f60136g.getActivityControlSurface().onUserLeaveHint();
            return;
        }
        Log.m45261w(f60130b, "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo181753a(int i) {
        m45316s();
        if (this.f60136g != null) {
            if (this.f60141l && i >= 10) {
                this.f60136g.getDartExecutor().notifyLowMemoryWarning();
                this.f60136g.getSystemChannel().sendMemoryPressureWarning();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public void mo181775q() {
        Log.m45259v(f60130b, "Forwarding onLowMemory() to FlutterEngine.");
        m45316s();
        this.f60136g.getDartExecutor().notifyLowMemoryWarning();
        this.f60136g.getSystemChannel().sendMemoryPressureWarning();
    }

    /* renamed from: s */
    private void m45316s() {
        if (this.f60135f == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }
}
