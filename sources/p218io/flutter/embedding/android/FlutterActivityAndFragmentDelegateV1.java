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
import com.didi.flutter.nacho2.p116v2.container.NachoActivityManager;
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

/* renamed from: io.flutter.embedding.android.FlutterActivityAndFragmentDelegateV1 */
class FlutterActivityAndFragmentDelegateV1 implements ExclusiveAppComponent<Activity> {

    /* renamed from: b */
    private static final String f60158b = "FlutterActivityAndFragmentDelegate";

    /* renamed from: c */
    private static final String f60159c = "framework";

    /* renamed from: d */
    private static final String f60160d = "plugins";

    /* renamed from: e */
    private static final int f60161e = 486947586;

    /* renamed from: a */
    ViewTreeObserver.OnPreDrawListener f60162a;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Host f60163f;

    /* renamed from: g */
    private FlutterEngine f60164g;

    /* renamed from: h */
    private FlutterViewV1 f60165h;

    /* renamed from: i */
    private PlatformPlugin f60166i;

    /* renamed from: j */
    private boolean f60167j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f60168k;

    /* renamed from: l */
    private final FlutterUiDisplayListener f60169l = new FlutterUiDisplayListener() {
        public void onFlutterUiDisplayed() {
            FlutterActivityAndFragmentDelegateV1.this.f60163f.onFlutterUiDisplayed();
            boolean unused = FlutterActivityAndFragmentDelegateV1.this.f60168k = true;
        }

        public void onFlutterUiNoLongerDisplayed() {
            FlutterActivityAndFragmentDelegateV1.this.f60163f.onFlutterUiNoLongerDisplayed();
            boolean unused = FlutterActivityAndFragmentDelegateV1.this.f60168k = false;
        }
    };

    /* renamed from: io.flutter.embedding.android.FlutterActivityAndFragmentDelegateV1$Host */
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
    }

    FlutterActivityAndFragmentDelegateV1(Host host) {
        this.f60163f = host;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo181804a() {
        this.f60163f = null;
        this.f60164g = null;
        this.f60165h = null;
        this.f60166i = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public FlutterEngine mo181811b() {
        return this.f60164g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo181813c() {
        return this.f60167j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo181808a(Context context) {
        m45381q();
        if (this.f60164g == null) {
            mo181815e();
        }
        if (this.f60163f.shouldAttachEngineToActivity()) {
            Log.m45259v(f60158b, "Attaching FlutterEngine to the Activity that owns this delegate.");
            this.f60164g.getActivityControlSurface().attachToActivity(this, this.f60163f.getLifecycle());
        }
        Host host = this.f60163f;
        this.f60166i = host.providePlatformPlugin(host.getActivity(), this.f60164g);
        this.f60163f.configureFlutterEngine(this.f60164g);
    }

    /* renamed from: d */
    public Activity getAppComponent() {
        Activity activity = this.f60163f.getActivity();
        if (activity != null) {
            return activity;
        }
        throw new AssertionError("FlutterActivityAndFragmentDelegate's getAppComponent should only be queried after onAttach, when the host's activity should always be non-null");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo181815e() {
        Log.m45259v(f60158b, "Setting up FlutterEngine.");
        String cachedEngineId = this.f60163f.getCachedEngineId();
        if (cachedEngineId != null) {
            FlutterEngine flutterEngine = FlutterEngineCache.getInstance().get(cachedEngineId);
            this.f60164g = flutterEngine;
            this.f60167j = true;
            if (flutterEngine == null) {
                throw new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + cachedEngineId + "'");
            }
            return;
        }
        Host host = this.f60163f;
        FlutterEngine provideFlutterEngine = host.provideFlutterEngine(host.getContext());
        this.f60164g = provideFlutterEngine;
        if (provideFlutterEngine != null) {
            this.f60167j = true;
            return;
        }
        Log.m45259v(f60158b, "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
        this.f60164g = new FlutterEngine(this.f60163f.getContext(), this.f60163f.getFlutterShellArgs().toArray(), false, this.f60163f.shouldRestoreAndSaveState());
        this.f60167j = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo181803a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, int i, boolean z) {
        Log.m45259v(f60158b, "Creating FlutterView.");
        m45381q();
        boolean z2 = true;
        if (this.f60163f.getRenderMode() == RenderMode.surface) {
            Context context = this.f60163f.getContext();
            if (this.f60163f.getTransparencyMode() != TransparencyMode.transparent) {
                z2 = false;
            }
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context, z2);
            this.f60163f.onFlutterSurfaceViewCreated(flutterSurfaceView);
            this.f60165h = new FlutterViewV1(this.f60163f.getContext(), flutterSurfaceView);
        } else {
            FlutterTextureView flutterTextureView = new FlutterTextureView(this.f60163f.getContext());
            if (this.f60163f.getTransparencyMode() != TransparencyMode.opaque) {
                z2 = false;
            }
            flutterTextureView.setOpaque(z2);
            this.f60163f.onFlutterTextureViewCreated(flutterTextureView);
            this.f60165h = new FlutterViewV1(this.f60163f.getContext(), flutterTextureView);
        }
        this.f60165h.addOnFirstFrameRenderedListener(this.f60169l);
        Log.m45259v(f60158b, "Attaching FlutterEngine to FlutterView.");
        this.f60165h.attachToFlutterEngine(this.f60164g);
        this.f60165h.setId(i);
        SplashScreen provideSplashScreen = this.f60163f.provideSplashScreen();
        if (provideSplashScreen != null) {
            Log.m45261w(f60158b, "A splash screen was provided to Flutter, but this is deprecated. See flutter.dev/go/android-splash-migration for migration steps.");
            FlutterSplashViewV1 flutterSplashViewV1 = new FlutterSplashViewV1(this.f60163f.getContext());
            flutterSplashViewV1.setId(ViewUtils.generateViewId(f60161e));
            flutterSplashViewV1.mo181968a(this.f60165h, provideSplashScreen);
            return flutterSplashViewV1;
        }
        if (z) {
            m45376a(this.f60165h);
        }
        return this.f60165h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo181810a(Bundle bundle) {
        Bundle bundle2;
        Log.m45259v(f60158b, "onRestoreInstanceState. Giving framework and plugins an opportunity to restore state.");
        m45381q();
        byte[] bArr = null;
        if (bundle != null) {
            Bundle bundle3 = bundle.getBundle(f60160d);
            bArr = bundle.getByteArray("framework");
            bundle2 = bundle3;
        } else {
            bundle2 = null;
        }
        if (this.f60163f.shouldRestoreAndSaveState()) {
            this.f60164g.getRestorationChannel().setRestorationData(bArr);
        }
        if (this.f60163f.shouldAttachEngineToActivity()) {
            this.f60164g.getActivityControlSurface().onRestoreInstanceState(bundle2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo181816f() {
        Log.m45259v(f60158b, "onStart()");
        m45381q();
        m45380p();
    }

    /* renamed from: p */
    private void m45380p() {
        if (this.f60163f.getCachedEngineId() == null && !this.f60164g.getDartExecutor().isExecutingDart()) {
            String initialRoute = this.f60163f.getInitialRoute();
            if (initialRoute == null && (initialRoute = m45378b(this.f60163f.getActivity().getIntent())) == null) {
                initialRoute = "/";
            }
            Log.m45259v(f60158b, "Executing Dart entrypoint: " + this.f60163f.getDartEntrypointFunctionName() + ", and sending initial route: " + initialRoute);
            this.f60164g.getNavigationChannel().setInitialRoute(initialRoute);
            String appBundlePath = this.f60163f.getAppBundlePath();
            if (appBundlePath == null || appBundlePath.isEmpty()) {
                appBundlePath = FlutterInjector.instance().flutterLoader().findAppBundlePath();
            }
            this.f60164g.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint(appBundlePath, this.f60163f.getDartEntrypointFunctionName()));
        }
    }

    /* renamed from: b */
    private String m45378b(Intent intent) {
        Uri data;
        if (!this.f60163f.shouldHandleDeeplinking() || (data = intent.getData()) == null || data.getPath().isEmpty()) {
            return null;
        }
        String path = data.getPath();
        if (data.getQuery() != null && !data.getQuery().isEmpty()) {
            path = path + "?" + data.getQuery();
        }
        if (data.getFragment() == null || data.getFragment().isEmpty()) {
            return path;
        }
        return path + RConfigConstants.KEYWORD_COLOR_SIGN + data.getFragment();
    }

    /* renamed from: a */
    private void m45376a(final FlutterViewV1 flutterViewV1) {
        if (this.f60163f.getRenderMode() == RenderMode.surface) {
            if (this.f60162a != null) {
                flutterViewV1.getViewTreeObserver().removeOnPreDrawListener(this.f60162a);
            }
            this.f60162a = new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    if (FlutterActivityAndFragmentDelegateV1.this.f60168k && FlutterActivityAndFragmentDelegateV1.this.f60162a != null) {
                        flutterViewV1.getViewTreeObserver().removeOnPreDrawListener(this);
                        FlutterActivityAndFragmentDelegateV1.this.f60162a = null;
                    }
                    return FlutterActivityAndFragmentDelegateV1.this.f60168k;
                }
            };
            flutterViewV1.getViewTreeObserver().addOnPreDrawListener(this.f60162a);
            return;
        }
        throw new IllegalArgumentException("Cannot delay the first Android view draw when the render mode is not set to `RenderMode.surface`.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo181817g() {
        Log.m45259v(f60158b, "onResume()");
        m45381q();
        this.f60165h.attachToRenderer();
        this.f60164g.getLifecycleChannel().appIsResumed();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo181818h() {
        Log.m45259v(f60158b, "onPostResume()");
        m45381q();
        if (this.f60164g != null) {
            PlatformPlugin platformPlugin = this.f60166i;
            if (platformPlugin != null) {
                platformPlugin.updateSystemUiOverlays();
                return;
            }
            return;
        }
        Log.m45261w(f60158b, "onPostResume() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo181819i() {
        Log.m45259v(f60158b, "onPause()");
        m45381q();
        if (NachoActivityManager.getInstance().isPaddingOpenContainer()) {
            this.f60165h.detachFromRenderer();
        }
        this.f60164g.getLifecycleChannel().appIsInactive();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo181820j() {
        Log.m45259v(f60158b, "onStop()");
        m45381q();
        this.f60164g.getLifecycleChannel().appIsPaused();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo181821k() {
        Log.m45259v(f60158b, "onDestroyView()");
        m45381q();
        if (this.f60162a != null) {
            this.f60165h.getViewTreeObserver().removeOnPreDrawListener(this.f60162a);
            this.f60162a = null;
        }
        this.f60165h.detachFromFlutterEngine();
        this.f60165h.removeOnFirstFrameRenderedListener(this.f60169l);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo181812b(Bundle bundle) {
        Log.m45259v(f60158b, "onSaveInstanceState. Giving framework and plugins an opportunity to save state.");
        m45381q();
        if (this.f60163f.shouldRestoreAndSaveState()) {
            bundle.putByteArray("framework", this.f60164g.getRestorationChannel().getRestorationData());
        }
        if (this.f60163f.shouldAttachEngineToActivity()) {
            Bundle bundle2 = new Bundle();
            this.f60164g.getActivityControlSurface().onSaveInstanceState(bundle2);
            bundle.putBundle(f60160d, bundle2);
        }
    }

    public void detachFromFlutterEngine() {
        if (!this.f60163f.shouldDestroyEngineWithHost()) {
            this.f60163f.detachFromFlutterEngine();
            return;
        }
        throw new AssertionError("The internal FlutterEngine created by " + this.f60163f + " has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo181822l() {
        Log.m45259v(f60158b, "onDetach()");
        m45381q();
        this.f60163f.cleanUpFlutterEngine(this.f60164g);
        if (this.f60163f.shouldAttachEngineToActivity()) {
            Log.m45259v(f60158b, "Detaching FlutterEngine from the Activity that owns this Fragment.");
            if (this.f60163f.getActivity().isChangingConfigurations()) {
                this.f60164g.getActivityControlSurface().detachFromActivityForConfigChanges();
            } else {
                this.f60164g.getActivityControlSurface().detachFromActivity();
            }
        }
        PlatformPlugin platformPlugin = this.f60166i;
        if (platformPlugin != null) {
            platformPlugin.destroy();
            this.f60166i = null;
        }
        this.f60164g.getLifecycleChannel().appIsDetached();
        if (this.f60163f.shouldDestroyEngineWithHost()) {
            this.f60164g.destroy();
            if (this.f60163f.getCachedEngineId() != null) {
                FlutterEngineCache.getInstance().remove(this.f60163f.getCachedEngineId());
            }
            this.f60164g = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo181823m() {
        m45381q();
        if (this.f60164g != null) {
            Log.m45259v(f60158b, "Forwarding onBackPressed() to FlutterEngine.");
            this.f60164g.getNavigationChannel().popRoute();
            return;
        }
        Log.m45261w(f60158b, "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo181807a(int i, String[] strArr, int[] iArr) {
        m45381q();
        if (this.f60164g != null) {
            Log.m45259v(f60158b, "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr));
            this.f60164g.getActivityControlSurface().onRequestPermissionsResult(i, strArr, iArr);
            return;
        }
        Log.m45261w(f60158b, "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo181809a(Intent intent) {
        m45381q();
        if (this.f60164g != null) {
            Log.m45259v(f60158b, "Forwarding onNewIntent() to FlutterEngine and sending pushRoute message.");
            this.f60164g.getActivityControlSurface().onNewIntent(intent);
            String b = m45378b(intent);
            if (b != null && !b.isEmpty()) {
                this.f60164g.getNavigationChannel().pushRoute(b);
                return;
            }
            return;
        }
        Log.m45261w(f60158b, "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo181806a(int i, int i2, Intent intent) {
        m45381q();
        if (this.f60164g != null) {
            Log.m45259v(f60158b, "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i + "\nresultCode: " + i2 + "\ndata: " + intent);
            this.f60164g.getActivityControlSurface().onActivityResult(i, i2, intent);
            return;
        }
        Log.m45261w(f60158b, "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public void mo181824n() {
        m45381q();
        if (this.f60164g != null) {
            Log.m45259v(f60158b, "Forwarding onUserLeaveHint() to FlutterEngine.");
            this.f60164g.getActivityControlSurface().onUserLeaveHint();
            return;
        }
        Log.m45261w(f60158b, "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo181805a(int i) {
        m45381q();
        FlutterEngine flutterEngine = this.f60164g;
        if (flutterEngine != null) {
            flutterEngine.getDartExecutor().notifyLowMemoryWarning();
            if (i == 10) {
                Log.m45259v(f60158b, "Forwarding onTrimMemory() to FlutterEngine. Level: " + i);
                this.f60164g.getSystemChannel().sendMemoryPressureWarning();
                return;
            }
            return;
        }
        Log.m45261w(f60158b, "onTrimMemory() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public void mo181825o() {
        Log.m45259v(f60158b, "Forwarding onLowMemory() to FlutterEngine.");
        m45381q();
        this.f60164g.getDartExecutor().notifyLowMemoryWarning();
        this.f60164g.getSystemChannel().sendMemoryPressureWarning();
    }

    /* renamed from: q */
    private void m45381q() {
        if (this.f60163f == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }
}
