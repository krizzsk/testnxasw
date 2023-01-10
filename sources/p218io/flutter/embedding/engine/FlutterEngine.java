package p218io.flutter.embedding.engine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import p218io.flutter.FlutterInjector;
import p218io.flutter.Log;
import p218io.flutter.embedding.engine.dart.DartExecutor;
import p218io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import p218io.flutter.embedding.engine.loader.FlutterLoader;
import p218io.flutter.embedding.engine.plugins.PluginRegistry;
import p218io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import p218io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface;
import p218io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface;
import p218io.flutter.embedding.engine.plugins.service.ServiceControlSurface;
import p218io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister;
import p218io.flutter.embedding.engine.renderer.FlutterRenderer;
import p218io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import p218io.flutter.embedding.engine.systemchannels.DeferredComponentChannel;
import p218io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import p218io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import p218io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import p218io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import p218io.flutter.embedding.engine.systemchannels.NavigationChannel;
import p218io.flutter.embedding.engine.systemchannels.PlatformChannel;
import p218io.flutter.embedding.engine.systemchannels.RestorationChannel;
import p218io.flutter.embedding.engine.systemchannels.SettingsChannel;
import p218io.flutter.embedding.engine.systemchannels.SystemChannel;
import p218io.flutter.embedding.engine.systemchannels.TextInputChannel;
import p218io.flutter.plugin.localization.LocalizationPlugin;
import p218io.flutter.plugin.platform.PlatformViewsController;

/* renamed from: io.flutter.embedding.engine.FlutterEngine */
public class FlutterEngine {

    /* renamed from: a */
    private static final String f60326a = "FlutterEngine";

    /* renamed from: b */
    private final FlutterJNI f60327b;

    /* renamed from: c */
    private final FlutterRenderer f60328c;

    /* renamed from: d */
    private final DartExecutor f60329d;

    /* renamed from: e */
    private final FlutterEngineConnectionRegistry f60330e;

    /* renamed from: f */
    private final LocalizationPlugin f60331f;

    /* renamed from: g */
    private final AccessibilityChannel f60332g;

    /* renamed from: h */
    private final DeferredComponentChannel f60333h;

    /* renamed from: i */
    private final KeyEventChannel f60334i;

    /* renamed from: j */
    private final LifecycleChannel f60335j;

    /* renamed from: k */
    private final LocalizationChannel f60336k;

    /* renamed from: l */
    private final MouseCursorChannel f60337l;

    /* renamed from: m */
    private final NavigationChannel f60338m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final RestorationChannel f60339n;

    /* renamed from: o */
    private final PlatformChannel f60340o;

    /* renamed from: p */
    private final SettingsChannel f60341p;

    /* renamed from: q */
    private final SystemChannel f60342q;

    /* renamed from: r */
    private final TextInputChannel f60343r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public final PlatformViewsController f60344s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public final Set<EngineLifecycleListener> f60345t;

    /* renamed from: u */
    private final EngineLifecycleListener f60346u;

    /* renamed from: io.flutter.embedding.engine.FlutterEngine$EngineLifecycleListener */
    public interface EngineLifecycleListener {
        void onEngineWillDestroy();

        void onPreEngineRestart();
    }

    public FlutterEngine(Context context) {
        this(context, (String[]) null);
    }

    public FlutterEngine(Context context, String[] strArr) {
        this(context, (FlutterLoader) null, (FlutterJNI) null, strArr, true);
    }

    public FlutterEngine(Context context, String[] strArr, boolean z) {
        this(context, (FlutterLoader) null, (FlutterJNI) null, strArr, z);
    }

    public FlutterEngine(Context context, String[] strArr, boolean z, boolean z2) {
        this(context, (FlutterLoader) null, (FlutterJNI) null, new PlatformViewsController(), strArr, z, z2);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI) {
        this(context, flutterLoader, flutterJNI, (String[]) null, true);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI, String[] strArr, boolean z) {
        this(context, flutterLoader, flutterJNI, new PlatformViewsController(), strArr, z);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI, PlatformViewsController platformViewsController, String[] strArr, boolean z) {
        this(context, flutterLoader, flutterJNI, platformViewsController, strArr, z, false);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI, PlatformViewsController platformViewsController, String[] strArr, boolean z, boolean z2) {
        AssetManager assetManager;
        this.f60345t = new HashSet();
        this.f60346u = new EngineLifecycleListener() {
            public void onEngineWillDestroy() {
            }

            public void onPreEngineRestart() {
                Log.m45259v(FlutterEngine.f60326a, "onPreEngineRestart()");
                for (EngineLifecycleListener onPreEngineRestart : FlutterEngine.this.f60345t) {
                    onPreEngineRestart.onPreEngineRestart();
                }
                FlutterEngine.this.f60344s.onPreEngineRestart();
                FlutterEngine.this.f60339n.clearData();
            }
        };
        try {
            assetManager = context.createPackageContext(context.getPackageName(), 0).getAssets();
        } catch (PackageManager.NameNotFoundException unused) {
            assetManager = context.getAssets();
        }
        FlutterInjector instance = FlutterInjector.instance();
        flutterJNI = flutterJNI == null ? instance.getFlutterJNIFactory().provideFlutterJNI() : flutterJNI;
        this.f60327b = flutterJNI;
        DartExecutor dartExecutor = new DartExecutor(flutterJNI, assetManager);
        this.f60329d = dartExecutor;
        dartExecutor.onAttachedToJNI();
        DeferredComponentManager deferredComponentManager = FlutterInjector.instance().deferredComponentManager();
        this.f60332g = new AccessibilityChannel(this.f60329d, flutterJNI);
        this.f60333h = new DeferredComponentChannel(this.f60329d);
        this.f60334i = new KeyEventChannel(this.f60329d);
        this.f60335j = new LifecycleChannel(this.f60329d);
        this.f60336k = new LocalizationChannel(this.f60329d);
        this.f60337l = new MouseCursorChannel(this.f60329d);
        this.f60338m = new NavigationChannel(this.f60329d);
        this.f60340o = new PlatformChannel(this.f60329d);
        this.f60339n = new RestorationChannel(this.f60329d, z2);
        this.f60341p = new SettingsChannel(this.f60329d);
        this.f60342q = new SystemChannel(this.f60329d);
        this.f60343r = new TextInputChannel(this.f60329d);
        if (deferredComponentManager != null) {
            deferredComponentManager.setDeferredComponentChannel(this.f60333h);
        }
        this.f60331f = new LocalizationPlugin(context, this.f60336k);
        flutterLoader = flutterLoader == null ? instance.flutterLoader() : flutterLoader;
        if (!flutterJNI.isAttached()) {
            flutterLoader.startInitialization(context.getApplicationContext());
            flutterLoader.ensureInitializationComplete(context, strArr);
        }
        flutterJNI.addEngineLifecycleListener(this.f60346u);
        flutterJNI.setPlatformViewsController(platformViewsController);
        flutterJNI.setLocalizationPlugin(this.f60331f);
        flutterJNI.setDeferredComponentManager(instance.deferredComponentManager());
        if (!flutterJNI.isAttached()) {
            m45532a();
        }
        this.f60328c = new FlutterRenderer(flutterJNI);
        this.f60344s = platformViewsController;
        platformViewsController.onAttachedToJNI();
        this.f60330e = new FlutterEngineConnectionRegistry(context.getApplicationContext(), this, flutterLoader);
        if (z && flutterLoader.automaticallyRegisterPlugins()) {
            GeneratedPluginRegister.registerGeneratedPlugins(this);
        }
    }

    /* renamed from: a */
    private void m45532a() {
        Log.m45259v(f60326a, "Attaching to JNI.");
        this.f60327b.attachToNative();
        if (!m45534b()) {
            throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
        }
    }

    /* renamed from: b */
    private boolean m45534b() {
        return this.f60327b.isAttached();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public FlutterEngine mo182112a(Context context, DartExecutor.DartEntrypoint dartEntrypoint, String str, List<String> list) {
        if (m45534b()) {
            return new FlutterEngine(context, (FlutterLoader) null, this.f60327b.spawn(dartEntrypoint.dartEntrypointFunctionName, dartEntrypoint.dartEntrypointLibrary, str, list));
        }
        throw new IllegalStateException("Spawn can only be called on a fully constructed FlutterEngine");
    }

    public void destroy() {
        Log.m45259v(f60326a, "Destroying.");
        for (EngineLifecycleListener onEngineWillDestroy : this.f60345t) {
            onEngineWillDestroy.onEngineWillDestroy();
        }
        this.f60330e.mo182144a();
        this.f60344s.onDetachedFromJNI();
        this.f60329d.onDetachedFromJNI();
        this.f60327b.removeEngineLifecycleListener(this.f60346u);
        this.f60327b.setDeferredComponentManager((DeferredComponentManager) null);
        this.f60327b.detachFromNativeAndReleaseResources();
        if (FlutterInjector.instance().deferredComponentManager() != null) {
            FlutterInjector.instance().deferredComponentManager().destroy();
            this.f60333h.setDeferredComponentManager((DeferredComponentManager) null);
        }
    }

    public void addEngineLifecycleListener(EngineLifecycleListener engineLifecycleListener) {
        this.f60345t.add(engineLifecycleListener);
    }

    public void removeEngineLifecycleListener(EngineLifecycleListener engineLifecycleListener) {
        this.f60345t.remove(engineLifecycleListener);
    }

    public DartExecutor getDartExecutor() {
        return this.f60329d;
    }

    public FlutterRenderer getRenderer() {
        return this.f60328c;
    }

    public AccessibilityChannel getAccessibilityChannel() {
        return this.f60332g;
    }

    public KeyEventChannel getKeyEventChannel() {
        return this.f60334i;
    }

    public LifecycleChannel getLifecycleChannel() {
        return this.f60335j;
    }

    public LocalizationChannel getLocalizationChannel() {
        return this.f60336k;
    }

    public NavigationChannel getNavigationChannel() {
        return this.f60338m;
    }

    public PlatformChannel getPlatformChannel() {
        return this.f60340o;
    }

    public RestorationChannel getRestorationChannel() {
        return this.f60339n;
    }

    public SettingsChannel getSettingsChannel() {
        return this.f60341p;
    }

    public DeferredComponentChannel getDeferredComponentChannel() {
        return this.f60333h;
    }

    public SystemChannel getSystemChannel() {
        return this.f60342q;
    }

    public MouseCursorChannel getMouseCursorChannel() {
        return this.f60337l;
    }

    public TextInputChannel getTextInputChannel() {
        return this.f60343r;
    }

    public PluginRegistry getPlugins() {
        return this.f60330e;
    }

    public LocalizationPlugin getLocalizationPlugin() {
        return this.f60331f;
    }

    public PlatformViewsController getPlatformViewsController() {
        return this.f60344s;
    }

    public ActivityControlSurface getActivityControlSurface() {
        return this.f60330e;
    }

    public ServiceControlSurface getServiceControlSurface() {
        return this.f60330e;
    }

    public BroadcastReceiverControlSurface getBroadcastReceiverControlSurface() {
        return this.f60330e;
    }

    public ContentProviderControlSurface getContentProviderControlSurface() {
        return this.f60330e;
    }
}
