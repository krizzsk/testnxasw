package p218io.flutter.embedding.engine.plugins.shim;

import android.app.Activity;
import android.content.Context;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p218io.flutter.FlutterInjector;
import p218io.flutter.Log;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;
import p218io.flutter.embedding.engine.plugins.activity.ActivityAware;
import p218io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p218io.flutter.plugin.common.BinaryMessenger;
import p218io.flutter.plugin.common.PluginRegistry;
import p218io.flutter.plugin.platform.PlatformViewRegistry;
import p218io.flutter.view.FlutterNativeView;
import p218io.flutter.view.FlutterView;
import p218io.flutter.view.TextureRegistry;

/* renamed from: io.flutter.embedding.engine.plugins.shim.a */
/* compiled from: ShimRegistrar */
class C22087a implements FlutterPlugin, ActivityAware, PluginRegistry.Registrar {

    /* renamed from: a */
    private static final String f60449a = "ShimRegistrar";

    /* renamed from: b */
    private final Map<String, Object> f60450b;

    /* renamed from: c */
    private final String f60451c;

    /* renamed from: d */
    private final Set<PluginRegistry.ViewDestroyListener> f60452d = new HashSet();

    /* renamed from: e */
    private final Set<PluginRegistry.RequestPermissionsResultListener> f60453e = new HashSet();

    /* renamed from: f */
    private final Set<PluginRegistry.ActivityResultListener> f60454f = new HashSet();

    /* renamed from: g */
    private final Set<PluginRegistry.NewIntentListener> f60455g = new HashSet();

    /* renamed from: h */
    private final Set<PluginRegistry.UserLeaveHintListener> f60456h = new HashSet();

    /* renamed from: i */
    private FlutterPlugin.FlutterPluginBinding f60457i;

    /* renamed from: j */
    private ActivityPluginBinding f60458j;

    public C22087a(String str, Map<String, Object> map) {
        this.f60451c = str;
        this.f60450b = map;
    }

    public Activity activity() {
        ActivityPluginBinding activityPluginBinding = this.f60458j;
        if (activityPluginBinding != null) {
            return activityPluginBinding.getActivity();
        }
        return null;
    }

    public Context context() {
        FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.f60457i;
        if (flutterPluginBinding != null) {
            return flutterPluginBinding.getApplicationContext();
        }
        return null;
    }

    public Context activeContext() {
        return this.f60458j == null ? context() : activity();
    }

    public BinaryMessenger messenger() {
        FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.f60457i;
        if (flutterPluginBinding != null) {
            return flutterPluginBinding.getBinaryMessenger();
        }
        return null;
    }

    public TextureRegistry textures() {
        FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.f60457i;
        if (flutterPluginBinding != null) {
            return flutterPluginBinding.getTextureRegistry();
        }
        return null;
    }

    public PlatformViewRegistry platformViewRegistry() {
        FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.f60457i;
        if (flutterPluginBinding != null) {
            return flutterPluginBinding.getPlatformViewRegistry();
        }
        return null;
    }

    public FlutterView view() {
        throw new UnsupportedOperationException("The new embedding does not support the old FlutterView.");
    }

    public String lookupKeyForAsset(String str) {
        return FlutterInjector.instance().flutterLoader().getLookupKeyForAsset(str);
    }

    public String lookupKeyForAsset(String str, String str2) {
        return FlutterInjector.instance().flutterLoader().getLookupKeyForAsset(str, str2);
    }

    public PluginRegistry.Registrar publish(Object obj) {
        this.f60450b.put(this.f60451c, obj);
        return this;
    }

    public PluginRegistry.Registrar addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
        this.f60453e.add(requestPermissionsResultListener);
        ActivityPluginBinding activityPluginBinding = this.f60458j;
        if (activityPluginBinding != null) {
            activityPluginBinding.addRequestPermissionsResultListener(requestPermissionsResultListener);
        }
        return this;
    }

    public PluginRegistry.Registrar addActivityResultListener(PluginRegistry.ActivityResultListener activityResultListener) {
        this.f60454f.add(activityResultListener);
        ActivityPluginBinding activityPluginBinding = this.f60458j;
        if (activityPluginBinding != null) {
            activityPluginBinding.addActivityResultListener(activityResultListener);
        }
        return this;
    }

    public PluginRegistry.Registrar addNewIntentListener(PluginRegistry.NewIntentListener newIntentListener) {
        this.f60455g.add(newIntentListener);
        ActivityPluginBinding activityPluginBinding = this.f60458j;
        if (activityPluginBinding != null) {
            activityPluginBinding.addOnNewIntentListener(newIntentListener);
        }
        return this;
    }

    public PluginRegistry.Registrar addUserLeaveHintListener(PluginRegistry.UserLeaveHintListener userLeaveHintListener) {
        this.f60456h.add(userLeaveHintListener);
        ActivityPluginBinding activityPluginBinding = this.f60458j;
        if (activityPluginBinding != null) {
            activityPluginBinding.addOnUserLeaveHintListener(userLeaveHintListener);
        }
        return this;
    }

    public PluginRegistry.Registrar addViewDestroyListener(PluginRegistry.ViewDestroyListener viewDestroyListener) {
        this.f60452d.add(viewDestroyListener);
        return this;
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Log.m45259v(f60449a, "Attached to FlutterEngine.");
        this.f60457i = flutterPluginBinding;
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Log.m45259v(f60449a, "Detached from FlutterEngine.");
        for (PluginRegistry.ViewDestroyListener onViewDestroy : this.f60452d) {
            onViewDestroy.onViewDestroy((FlutterNativeView) null);
        }
        this.f60457i = null;
        this.f60458j = null;
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        Log.m45259v(f60449a, "Attached to an Activity.");
        this.f60458j = activityPluginBinding;
        m45592a();
    }

    public void onDetachedFromActivityForConfigChanges() {
        Log.m45259v(f60449a, "Detached from an Activity for config changes.");
        this.f60458j = null;
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        Log.m45259v(f60449a, "Reconnected to an Activity after config changes.");
        this.f60458j = activityPluginBinding;
        m45592a();
    }

    public void onDetachedFromActivity() {
        Log.m45259v(f60449a, "Detached from an Activity.");
        this.f60458j = null;
    }

    /* renamed from: a */
    private void m45592a() {
        for (PluginRegistry.RequestPermissionsResultListener addRequestPermissionsResultListener : this.f60453e) {
            this.f60458j.addRequestPermissionsResultListener(addRequestPermissionsResultListener);
        }
        for (PluginRegistry.ActivityResultListener addActivityResultListener : this.f60454f) {
            this.f60458j.addActivityResultListener(addActivityResultListener);
        }
        for (PluginRegistry.NewIntentListener addOnNewIntentListener : this.f60455g) {
            this.f60458j.addOnNewIntentListener(addOnNewIntentListener);
        }
        for (PluginRegistry.UserLeaveHintListener addOnUserLeaveHintListener : this.f60456h) {
            this.f60458j.addOnUserLeaveHintListener(addOnUserLeaveHintListener);
        }
    }
}
