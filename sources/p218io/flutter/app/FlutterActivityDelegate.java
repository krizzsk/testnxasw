package p218io.flutter.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.didi.flutter.nacho2.p116v2.NachoConstants;
import java.util.ArrayList;
import p218io.flutter.Log;
import p218io.flutter.embedding.engine.FlutterShellArgs;
import p218io.flutter.plugin.common.PluginRegistry;
import p218io.flutter.util.Preconditions;
import p218io.flutter.view.FlutterMain;
import p218io.flutter.view.FlutterNativeView;
import p218io.flutter.view.FlutterRunArguments;
import p218io.flutter.view.FlutterView;

@Deprecated
/* renamed from: io.flutter.app.FlutterActivityDelegate */
public final class FlutterActivityDelegate implements FlutterActivityEvents, PluginRegistry, FlutterView.Provider {

    /* renamed from: a */
    private static final String f60081a = "io.flutter.app.android.SplashScreenUntilFirstFrame";

    /* renamed from: b */
    private static final String f60082b = "FlutterActivityDelegate";

    /* renamed from: c */
    private static final WindowManager.LayoutParams f60083c = new WindowManager.LayoutParams(-1, -1);

    /* renamed from: d */
    private final Activity f60084d;

    /* renamed from: e */
    private final ViewFactory f60085e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public FlutterView f60086f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public View f60087g;

    /* renamed from: io.flutter.app.FlutterActivityDelegate$ViewFactory */
    public interface ViewFactory {
        FlutterNativeView createFlutterNativeView();

        FlutterView createFlutterView(Context context);

        boolean retainFlutterNativeView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public FlutterActivityDelegate(Activity activity, ViewFactory viewFactory) {
        this.f60084d = (Activity) Preconditions.checkNotNull(activity);
        this.f60085e = (ViewFactory) Preconditions.checkNotNull(viewFactory);
    }

    public FlutterView getFlutterView() {
        return this.f60086f;
    }

    public boolean hasPlugin(String str) {
        return this.f60086f.getPluginRegistry().hasPlugin(str);
    }

    public <T> T valuePublishedByPlugin(String str) {
        return this.f60086f.getPluginRegistry().valuePublishedByPlugin(str);
    }

    public PluginRegistry.Registrar registrarFor(String str) {
        return this.f60086f.getPluginRegistry().registrarFor(str);
    }

    public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        return this.f60086f.getPluginRegistry().onRequestPermissionsResult(i, strArr, iArr);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        return this.f60086f.getPluginRegistry().onActivityResult(i, i2, intent);
    }

    public void onCreate(Bundle bundle) {
        String findAppBundlePath;
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.f60084d.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(1073741824);
            window.getDecorView().setSystemUiVisibility(1280);
        }
        FlutterMain.ensureInitializationComplete(this.f60084d.getApplicationContext(), m45267a(this.f60084d.getIntent()));
        FlutterView createFlutterView = this.f60085e.createFlutterView(this.f60084d);
        this.f60086f = createFlutterView;
        if (createFlutterView == null) {
            FlutterView flutterView = new FlutterView(this.f60084d, (AttributeSet) null, this.f60085e.createFlutterNativeView());
            this.f60086f = flutterView;
            flutterView.setLayoutParams(f60083c);
            this.f60084d.setContentView(this.f60086f);
            View b = m45268b();
            this.f60087g = b;
            if (b != null) {
                m45273e();
            }
        }
        if (!m45270b(this.f60084d.getIntent()) && (findAppBundlePath = FlutterMain.findAppBundlePath()) != null) {
            m45265a(findAppBundlePath);
        }
    }

    public void onNewIntent(Intent intent) {
        if (!m45266a() || !m45270b(intent)) {
            this.f60086f.getPluginRegistry().onNewIntent(intent);
        }
    }

    /* renamed from: a */
    private boolean m45266a() {
        return (this.f60084d.getApplicationInfo().flags & 2) != 0;
    }

    public void onPause() {
        Application application = (Application) this.f60084d.getApplicationContext();
        if (application instanceof FlutterApplication) {
            FlutterApplication flutterApplication = (FlutterApplication) application;
            if (this.f60084d.equals(flutterApplication.getCurrentActivity())) {
                flutterApplication.setCurrentActivity((Activity) null);
            }
        }
        FlutterView flutterView = this.f60086f;
        if (flutterView != null) {
            flutterView.onPause();
        }
    }

    public void onStart() {
        FlutterView flutterView = this.f60086f;
        if (flutterView != null) {
            flutterView.onStart();
        }
    }

    public void onResume() {
        Application application = (Application) this.f60084d.getApplicationContext();
        if (application instanceof FlutterApplication) {
            ((FlutterApplication) application).setCurrentActivity(this.f60084d);
        }
    }

    public void onStop() {
        this.f60086f.onStop();
    }

    public void onPostResume() {
        FlutterView flutterView = this.f60086f;
        if (flutterView != null) {
            flutterView.onPostResume();
        }
    }

    public void onDestroy() {
        Application application = (Application) this.f60084d.getApplicationContext();
        if (application instanceof FlutterApplication) {
            FlutterApplication flutterApplication = (FlutterApplication) application;
            if (this.f60084d.equals(flutterApplication.getCurrentActivity())) {
                flutterApplication.setCurrentActivity((Activity) null);
            }
        }
        FlutterView flutterView = this.f60086f;
        if (flutterView == null) {
            return;
        }
        if (flutterView.getPluginRegistry().onViewDestroy(this.f60086f.getFlutterNativeView()) || this.f60085e.retainFlutterNativeView()) {
            this.f60086f.detach();
        } else {
            this.f60086f.destroy();
        }
    }

    public boolean onBackPressed() {
        FlutterView flutterView = this.f60086f;
        if (flutterView == null) {
            return false;
        }
        flutterView.popRoute();
        return true;
    }

    public void onUserLeaveHint() {
        this.f60086f.getPluginRegistry().onUserLeaveHint();
    }

    public void onTrimMemory(int i) {
        if (i == 10) {
            this.f60086f.onMemoryPressure();
        }
    }

    public void onLowMemory() {
        this.f60086f.onMemoryPressure();
    }

    /* renamed from: a */
    private static String[] m45267a(Intent intent) {
        ArrayList arrayList = new ArrayList();
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_TRACE_STARTUP, false)) {
            arrayList.add(FlutterShellArgs.ARG_TRACE_STARTUP);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_START_PAUSED, false)) {
            arrayList.add(FlutterShellArgs.ARG_START_PAUSED);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_DISABLE_SERVICE_AUTH_CODES, false)) {
            arrayList.add(FlutterShellArgs.ARG_DISABLE_SERVICE_AUTH_CODES);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_USE_TEST_FONTS, false)) {
            arrayList.add(FlutterShellArgs.ARG_USE_TEST_FONTS);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_ENABLE_DART_PROFILING, false)) {
            arrayList.add(FlutterShellArgs.ARG_ENABLE_DART_PROFILING);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_ENABLE_SOFTWARE_RENDERING, false)) {
            arrayList.add(FlutterShellArgs.ARG_ENABLE_SOFTWARE_RENDERING);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_SKIA_DETERMINISTIC_RENDERING, false)) {
            arrayList.add(FlutterShellArgs.ARG_SKIA_DETERMINISTIC_RENDERING);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_TRACE_SKIA, false)) {
            arrayList.add(FlutterShellArgs.ARG_TRACE_SKIA);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_TRACE_SYSTRACE, false)) {
            arrayList.add(FlutterShellArgs.ARG_TRACE_SYSTRACE);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_DUMP_SHADER_SKP_ON_SHADER_COMPILATION, false)) {
            arrayList.add(FlutterShellArgs.ARG_DUMP_SHADER_SKP_ON_SHADER_COMPILATION);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_CACHE_SKSL, false)) {
            arrayList.add(FlutterShellArgs.ARG_CACHE_SKSL);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_PURGE_PERSISTENT_CACHE, false)) {
            arrayList.add(FlutterShellArgs.ARG_PURGE_PERSISTENT_CACHE);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_VERBOSE_LOGGING, false)) {
            arrayList.add(FlutterShellArgs.ARG_VERBOSE_LOGGING);
        }
        int intExtra = intent.getIntExtra(FlutterShellArgs.ARG_KEY_OBSERVATORY_PORT, 0);
        if (intExtra > 0) {
            arrayList.add(FlutterShellArgs.ARG_OBSERVATORY_PORT + Integer.toString(intExtra));
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_ENDLESS_TRACE_BUFFER, false)) {
            arrayList.add(FlutterShellArgs.ARG_ENDLESS_TRACE_BUFFER);
        }
        if (intent.hasExtra(FlutterShellArgs.ARG_KEY_DART_FLAGS)) {
            arrayList.add("--dart-flags=" + intent.getStringExtra(FlutterShellArgs.ARG_KEY_DART_FLAGS));
        }
        if (!arrayList.isEmpty()) {
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return null;
    }

    /* renamed from: b */
    private boolean m45270b(Intent intent) {
        if (!"android.intent.action.RUN".equals(intent.getAction())) {
            return false;
        }
        String stringExtra = intent.getStringExtra("route");
        String dataString = intent.getDataString();
        if (dataString == null) {
            dataString = FlutterMain.findAppBundlePath();
        }
        if (stringExtra != null) {
            this.f60086f.setInitialRoute(stringExtra);
        }
        m45265a(dataString);
        return true;
    }

    /* renamed from: a */
    private void m45265a(String str) {
        if (!this.f60086f.getFlutterNativeView().isApplicationRunning()) {
            FlutterRunArguments flutterRunArguments = new FlutterRunArguments();
            flutterRunArguments.bundlePath = str;
            flutterRunArguments.entrypoint = NachoConstants.NACHO_ENTRYPOINT_NAME;
            this.f60086f.runFromBundle(flutterRunArguments);
        }
    }

    /* renamed from: b */
    private View m45268b() {
        Drawable c;
        if (!m45272d().booleanValue() || (c = m45271c()) == null) {
            return null;
        }
        View view = new View(this.f60084d);
        view.setLayoutParams(f60083c);
        view.setBackground(c);
        return view;
    }

    /* renamed from: c */
    private Drawable m45271c() {
        TypedValue typedValue = new TypedValue();
        if (!this.f60084d.getTheme().resolveAttribute(16842836, typedValue, true) || typedValue.resourceId == 0) {
            return null;
        }
        try {
            return this.f60084d.getResources().getDrawable(typedValue.resourceId);
        } catch (Resources.NotFoundException unused) {
            Log.m45255e(f60082b, "Referenced launch screen windowBackground resource does not exist");
            return null;
        }
    }

    /* renamed from: d */
    private Boolean m45272d() {
        try {
            Bundle bundle = this.f60084d.getPackageManager().getActivityInfo(this.f60084d.getComponentName(), 128).metaData;
            return Boolean.valueOf(bundle != null && bundle.getBoolean(f60081a));
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: e */
    private void m45273e() {
        View view = this.f60087g;
        if (view != null) {
            this.f60084d.addContentView(view, f60083c);
            this.f60086f.addFirstFrameListener(new FlutterView.FirstFrameListener() {
                public void onFirstFrame() {
                    FlutterActivityDelegate.this.f60087g.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            ((ViewGroup) FlutterActivityDelegate.this.f60087g.getParent()).removeView(FlutterActivityDelegate.this.f60087g);
                            View unused = FlutterActivityDelegate.this.f60087g = null;
                        }
                    });
                    FlutterActivityDelegate.this.f60086f.removeFirstFrameListener(this);
                }
            });
            this.f60084d.setTheme(16973833);
        }
    }
}
