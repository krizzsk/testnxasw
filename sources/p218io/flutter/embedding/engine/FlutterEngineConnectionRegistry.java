package p218io.flutter.embedding.engine;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.tracing.Trace;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p218io.flutter.Log;
import p218io.flutter.embedding.android.ExclusiveAppComponent;
import p218io.flutter.embedding.engine.loader.FlutterLoader;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;
import p218io.flutter.embedding.engine.plugins.PluginRegistry;
import p218io.flutter.embedding.engine.plugins.activity.ActivityAware;
import p218io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import p218io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p218io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverAware;
import p218io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface;
import p218io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverPluginBinding;
import p218io.flutter.embedding.engine.plugins.contentprovider.ContentProviderAware;
import p218io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface;
import p218io.flutter.embedding.engine.plugins.contentprovider.ContentProviderPluginBinding;
import p218io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import p218io.flutter.embedding.engine.plugins.service.ServiceAware;
import p218io.flutter.embedding.engine.plugins.service.ServiceControlSurface;
import p218io.flutter.embedding.engine.plugins.service.ServicePluginBinding;
import p218io.flutter.plugin.common.PluginRegistry;

/* renamed from: io.flutter.embedding.engine.FlutterEngineConnectionRegistry */
class FlutterEngineConnectionRegistry implements PluginRegistry, ActivityControlSurface, BroadcastReceiverControlSurface, ContentProviderControlSurface, ServiceControlSurface {

    /* renamed from: a */
    private static final String f60349a = "FlutterEngineCxnRegstry";

    /* renamed from: b */
    private final Map<Class<? extends FlutterPlugin>, FlutterPlugin> f60350b = new HashMap();

    /* renamed from: c */
    private final FlutterEngine f60351c;

    /* renamed from: d */
    private final FlutterPlugin.FlutterPluginBinding f60352d;

    /* renamed from: e */
    private final Map<Class<? extends FlutterPlugin>, ActivityAware> f60353e = new HashMap();

    /* renamed from: f */
    private ExclusiveAppComponent<Activity> f60354f;

    /* renamed from: g */
    private FlutterEngineActivityPluginBinding f60355g;

    /* renamed from: h */
    private boolean f60356h = false;

    /* renamed from: i */
    private final Map<Class<? extends FlutterPlugin>, ServiceAware> f60357i = new HashMap();

    /* renamed from: j */
    private Service f60358j;

    /* renamed from: k */
    private FlutterEngineServicePluginBinding f60359k;

    /* renamed from: l */
    private final Map<Class<? extends FlutterPlugin>, BroadcastReceiverAware> f60360l = new HashMap();

    /* renamed from: m */
    private BroadcastReceiver f60361m;

    /* renamed from: n */
    private FlutterEngineBroadcastReceiverPluginBinding f60362n;

    /* renamed from: o */
    private final Map<Class<? extends FlutterPlugin>, ContentProviderAware> f60363o = new HashMap();

    /* renamed from: p */
    private ContentProvider f60364p;

    /* renamed from: q */
    private FlutterEngineContentProviderPluginBinding f60365q;

    FlutterEngineConnectionRegistry(Context context, FlutterEngine flutterEngine, FlutterLoader flutterLoader) {
        this.f60351c = flutterEngine;
        this.f60352d = new FlutterPlugin.FlutterPluginBinding(context, flutterEngine, flutterEngine.getDartExecutor(), flutterEngine.getRenderer(), flutterEngine.getPlatformViewsController().getRegistry(), new DefaultFlutterAssets(flutterLoader));
    }

    /* renamed from: a */
    public void mo182144a() {
        Log.m45259v(f60349a, "Destroying.");
        m45538b();
        removeAll();
    }

    public void add(FlutterPlugin flutterPlugin) {
        Trace.beginSection("FlutterEngineConnectionRegistry#add " + flutterPlugin.getClass().getSimpleName());
        try {
            if (has(flutterPlugin.getClass())) {
                Log.m45261w(f60349a, "Attempted to register plugin (" + flutterPlugin + ") but it was already registered with this FlutterEngine (" + this.f60351c + ").");
                return;
            }
            Log.m45259v(f60349a, "Adding plugin: " + flutterPlugin);
            this.f60350b.put(flutterPlugin.getClass(), flutterPlugin);
            flutterPlugin.onAttachedToEngine(this.f60352d);
            if (flutterPlugin instanceof ActivityAware) {
                ActivityAware activityAware = (ActivityAware) flutterPlugin;
                this.f60353e.put(flutterPlugin.getClass(), activityAware);
                if (m45539c()) {
                    activityAware.onAttachedToActivity(this.f60355g);
                }
            }
            if (flutterPlugin instanceof ServiceAware) {
                ServiceAware serviceAware = (ServiceAware) flutterPlugin;
                this.f60357i.put(flutterPlugin.getClass(), serviceAware);
                if (m45542f()) {
                    serviceAware.onAttachedToService(this.f60359k);
                }
            }
            if (flutterPlugin instanceof BroadcastReceiverAware) {
                BroadcastReceiverAware broadcastReceiverAware = (BroadcastReceiverAware) flutterPlugin;
                this.f60360l.put(flutterPlugin.getClass(), broadcastReceiverAware);
                if (m45543g()) {
                    broadcastReceiverAware.onAttachedToBroadcastReceiver(this.f60362n);
                }
            }
            if (flutterPlugin instanceof ContentProviderAware) {
                ContentProviderAware contentProviderAware = (ContentProviderAware) flutterPlugin;
                this.f60363o.put(flutterPlugin.getClass(), contentProviderAware);
                if (m45544h()) {
                    contentProviderAware.onAttachedToContentProvider(this.f60365q);
                }
            }
            Trace.endSection();
        } finally {
            Trace.endSection();
        }
    }

    public void add(Set<FlutterPlugin> set) {
        for (FlutterPlugin add : set) {
            add(add);
        }
    }

    public boolean has(Class<? extends FlutterPlugin> cls) {
        return this.f60350b.containsKey(cls);
    }

    public FlutterPlugin get(Class<? extends FlutterPlugin> cls) {
        return this.f60350b.get(cls);
    }

    public void remove(Class<? extends FlutterPlugin> cls) {
        FlutterPlugin flutterPlugin = this.f60350b.get(cls);
        if (flutterPlugin != null) {
            Trace.beginSection("FlutterEngineConnectionRegistry#remove " + cls.getSimpleName());
            try {
                Log.m45259v(f60349a, "Removing plugin: " + flutterPlugin);
                if (flutterPlugin instanceof ActivityAware) {
                    if (m45539c()) {
                        ((ActivityAware) flutterPlugin).onDetachedFromActivity();
                    }
                    this.f60353e.remove(cls);
                }
                if (flutterPlugin instanceof ServiceAware) {
                    if (m45542f()) {
                        ((ServiceAware) flutterPlugin).onDetachedFromService();
                    }
                    this.f60357i.remove(cls);
                }
                if (flutterPlugin instanceof BroadcastReceiverAware) {
                    if (m45543g()) {
                        ((BroadcastReceiverAware) flutterPlugin).onDetachedFromBroadcastReceiver();
                    }
                    this.f60360l.remove(cls);
                }
                if (flutterPlugin instanceof ContentProviderAware) {
                    if (m45544h()) {
                        ((ContentProviderAware) flutterPlugin).onDetachedFromContentProvider();
                    }
                    this.f60363o.remove(cls);
                }
                flutterPlugin.onDetachedFromEngine(this.f60352d);
                this.f60350b.remove(cls);
            } finally {
                Trace.endSection();
            }
        }
    }

    public void remove(Set<Class<? extends FlutterPlugin>> set) {
        for (Class<? extends FlutterPlugin> remove : set) {
            remove(remove);
        }
    }

    public void removeAll() {
        remove((Set<Class<? extends FlutterPlugin>>) new HashSet(this.f60350b.keySet()));
        this.f60350b.clear();
    }

    /* renamed from: b */
    private void m45538b() {
        if (m45539c()) {
            detachFromActivity();
        } else if (m45542f()) {
            detachFromService();
        } else if (m45543g()) {
            detachFromBroadcastReceiver();
        } else if (m45544h()) {
            detachFromContentProvider();
        }
    }

    /* renamed from: c */
    private boolean m45539c() {
        return this.f60354f != null;
    }

    /* renamed from: d */
    private Activity m45540d() {
        ExclusiveAppComponent<Activity> exclusiveAppComponent = this.f60354f;
        if (exclusiveAppComponent != null) {
            return exclusiveAppComponent.getAppComponent();
        }
        return null;
    }

    public void attachToActivity(ExclusiveAppComponent<Activity> exclusiveAppComponent, Lifecycle lifecycle) {
        String str;
        Trace.beginSection("FlutterEngineConnectionRegistry#attachToActivity");
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Attaching to an exclusive Activity: ");
            sb.append(exclusiveAppComponent.getAppComponent());
            String str2 = "";
            if (m45539c()) {
                str = " evicting previous activity " + m45540d();
            } else {
                str = str2;
            }
            sb.append(str);
            sb.append(".");
            if (this.f60356h) {
                str2 = " This is after a config change.";
            }
            sb.append(str2);
            Log.m45259v(f60349a, sb.toString());
            if (this.f60354f != null) {
                this.f60354f.detachFromFlutterEngine();
            }
            m45538b();
            this.f60354f = exclusiveAppComponent;
            m45537a(exclusiveAppComponent.getAppComponent(), lifecycle);
        } finally {
            Trace.endSection();
        }
    }

    /* renamed from: a */
    private void m45537a(Activity activity, Lifecycle lifecycle) {
        this.f60355g = new FlutterEngineActivityPluginBinding(activity, lifecycle);
        this.f60351c.getPlatformViewsController().attach(activity, this.f60351c.getRenderer(), this.f60351c.getDartExecutor());
        for (ActivityAware next : this.f60353e.values()) {
            if (this.f60356h) {
                next.onReattachedToActivityForConfigChanges(this.f60355g);
            } else {
                next.onAttachedToActivity(this.f60355g);
            }
        }
        this.f60356h = false;
    }

    public void detachFromActivityForConfigChanges() {
        if (m45539c()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#detachFromActivityForConfigChanges");
            Log.m45259v(f60349a, "Detaching from an Activity for config changes: " + m45540d());
            try {
                this.f60356h = true;
                for (ActivityAware onDetachedFromActivityForConfigChanges : this.f60353e.values()) {
                    onDetachedFromActivityForConfigChanges.onDetachedFromActivityForConfigChanges();
                }
                m45541e();
            } finally {
                Trace.endSection();
            }
        } else {
            Log.m45255e(f60349a, "Attempted to detach plugins from an Activity when no Activity was attached.");
        }
    }

    public void detachFromActivity() {
        if (m45539c()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#detachFromActivity");
            try {
                Log.m45259v(f60349a, "Detaching from an Activity: " + m45540d());
                for (ActivityAware onDetachedFromActivity : this.f60353e.values()) {
                    onDetachedFromActivity.onDetachedFromActivity();
                }
                m45541e();
            } finally {
                Trace.endSection();
            }
        } else {
            Log.m45255e(f60349a, "Attempted to detach plugins from an Activity when no Activity was attached.");
        }
    }

    /* renamed from: e */
    private void m45541e() {
        this.f60351c.getPlatformViewsController().detach();
        this.f60354f = null;
        this.f60355g = null;
    }

    public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Log.m45259v(f60349a, "Forwarding onRequestPermissionsResult() to plugins.");
        if (m45539c()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onRequestPermissionsResult");
            try {
                return this.f60355g.onRequestPermissionsResult(i, strArr, iArr);
            } finally {
                Trace.endSection();
            }
        } else {
            Log.m45255e(f60349a, "Attempted to notify ActivityAware plugins of onRequestPermissionsResult, but no Activity was attached.");
            return false;
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        Log.m45259v(f60349a, "Forwarding onActivityResult() to plugins.");
        if (m45539c()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onActivityResult");
            try {
                return this.f60355g.onActivityResult(i, i2, intent);
            } finally {
                Trace.endSection();
            }
        } else {
            Log.m45255e(f60349a, "Attempted to notify ActivityAware plugins of onActivityResult, but no Activity was attached.");
            return false;
        }
    }

    public void onNewIntent(Intent intent) {
        Log.m45259v(f60349a, "Forwarding onNewIntent() to plugins.");
        if (m45539c()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onNewIntent");
            try {
                this.f60355g.onNewIntent(intent);
            } finally {
                Trace.endSection();
            }
        } else {
            Log.m45255e(f60349a, "Attempted to notify ActivityAware plugins of onNewIntent, but no Activity was attached.");
        }
    }

    public void onUserLeaveHint() {
        Log.m45259v(f60349a, "Forwarding onUserLeaveHint() to plugins.");
        if (m45539c()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onUserLeaveHint");
            try {
                this.f60355g.onUserLeaveHint();
            } finally {
                Trace.endSection();
            }
        } else {
            Log.m45255e(f60349a, "Attempted to notify ActivityAware plugins of onUserLeaveHint, but no Activity was attached.");
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        Log.m45259v(f60349a, "Forwarding onSaveInstanceState() to plugins.");
        if (m45539c()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onSaveInstanceState");
            try {
                this.f60355g.onSaveInstanceState(bundle);
            } finally {
                Trace.endSection();
            }
        } else {
            Log.m45255e(f60349a, "Attempted to notify ActivityAware plugins of onSaveInstanceState, but no Activity was attached.");
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        Log.m45259v(f60349a, "Forwarding onRestoreInstanceState() to plugins.");
        if (m45539c()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onRestoreInstanceState");
            try {
                this.f60355g.onRestoreInstanceState(bundle);
            } finally {
                Trace.endSection();
            }
        } else {
            Log.m45255e(f60349a, "Attempted to notify ActivityAware plugins of onRestoreInstanceState, but no Activity was attached.");
        }
    }

    /* renamed from: f */
    private boolean m45542f() {
        return this.f60358j != null;
    }

    public void attachToService(Service service, Lifecycle lifecycle, boolean z) {
        Trace.beginSection("FlutterEngineConnectionRegistry#attachToService");
        Log.m45259v(f60349a, "Attaching to a Service: " + service);
        try {
            m45538b();
            this.f60358j = service;
            this.f60359k = new FlutterEngineServicePluginBinding(service, lifecycle);
            for (ServiceAware onAttachedToService : this.f60357i.values()) {
                onAttachedToService.onAttachedToService(this.f60359k);
            }
        } finally {
            Trace.endSection();
        }
    }

    public void detachFromService() {
        if (m45542f()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#detachFromService");
            Log.m45259v(f60349a, "Detaching from a Service: " + this.f60358j);
            try {
                for (ServiceAware onDetachedFromService : this.f60357i.values()) {
                    onDetachedFromService.onDetachedFromService();
                }
                this.f60358j = null;
                this.f60359k = null;
            } finally {
                Trace.endSection();
            }
        } else {
            Log.m45255e(f60349a, "Attempted to detach plugins from a Service when no Service was attached.");
        }
    }

    public void onMoveToForeground() {
        if (m45542f()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onMoveToForeground");
            try {
                Log.m45259v(f60349a, "Attached Service moved to foreground.");
                this.f60359k.onMoveToForeground();
            } finally {
                Trace.endSection();
            }
        }
    }

    public void onMoveToBackground() {
        if (m45542f()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onMoveToBackground");
            Log.m45259v(f60349a, "Attached Service moved to background.");
            try {
                this.f60359k.onMoveToBackground();
            } finally {
                Trace.endSection();
            }
        }
    }

    /* renamed from: g */
    private boolean m45543g() {
        return this.f60361m != null;
    }

    public void attachToBroadcastReceiver(BroadcastReceiver broadcastReceiver, Lifecycle lifecycle) {
        Trace.beginSection("FlutterEngineConnectionRegistry#attachToBroadcastReceiver");
        Log.m45259v(f60349a, "Attaching to BroadcastReceiver: " + broadcastReceiver);
        try {
            m45538b();
            this.f60361m = broadcastReceiver;
            this.f60362n = new FlutterEngineBroadcastReceiverPluginBinding(broadcastReceiver);
            for (BroadcastReceiverAware onAttachedToBroadcastReceiver : this.f60360l.values()) {
                onAttachedToBroadcastReceiver.onAttachedToBroadcastReceiver(this.f60362n);
            }
        } finally {
            Trace.endSection();
        }
    }

    public void detachFromBroadcastReceiver() {
        if (m45543g()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#detachFromBroadcastReceiver");
            Log.m45259v(f60349a, "Detaching from BroadcastReceiver: " + this.f60361m);
            try {
                for (BroadcastReceiverAware onDetachedFromBroadcastReceiver : this.f60360l.values()) {
                    onDetachedFromBroadcastReceiver.onDetachedFromBroadcastReceiver();
                }
            } finally {
                Trace.endSection();
            }
        } else {
            Log.m45255e(f60349a, "Attempted to detach plugins from a BroadcastReceiver when no BroadcastReceiver was attached.");
        }
    }

    /* renamed from: h */
    private boolean m45544h() {
        return this.f60364p != null;
    }

    public void attachToContentProvider(ContentProvider contentProvider, Lifecycle lifecycle) {
        Trace.beginSection("FlutterEngineConnectionRegistry#attachToContentProvider");
        Log.m45259v(f60349a, "Attaching to ContentProvider: " + contentProvider);
        try {
            m45538b();
            this.f60364p = contentProvider;
            this.f60365q = new FlutterEngineContentProviderPluginBinding(contentProvider);
            for (ContentProviderAware onAttachedToContentProvider : this.f60363o.values()) {
                onAttachedToContentProvider.onAttachedToContentProvider(this.f60365q);
            }
        } finally {
            Trace.endSection();
        }
    }

    public void detachFromContentProvider() {
        if (m45544h()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#detachFromContentProvider");
            Log.m45259v(f60349a, "Detaching from ContentProvider: " + this.f60364p);
            try {
                for (ContentProviderAware onDetachedFromContentProvider : this.f60363o.values()) {
                    onDetachedFromContentProvider.onDetachedFromContentProvider();
                }
            } finally {
                Trace.endSection();
            }
        } else {
            Log.m45255e(f60349a, "Attempted to detach plugins from a ContentProvider when no ContentProvider was attached.");
        }
    }

    /* renamed from: io.flutter.embedding.engine.FlutterEngineConnectionRegistry$DefaultFlutterAssets */
    private static class DefaultFlutterAssets implements FlutterPlugin.FlutterAssets {
        final FlutterLoader flutterLoader;

        private DefaultFlutterAssets(FlutterLoader flutterLoader2) {
            this.flutterLoader = flutterLoader2;
        }

        public String getAssetFilePathByName(String str) {
            return this.flutterLoader.getLookupKeyForAsset(str);
        }

        public String getAssetFilePathByName(String str, String str2) {
            return this.flutterLoader.getLookupKeyForAsset(str, str2);
        }

        public String getAssetFilePathBySubpath(String str) {
            return this.flutterLoader.getLookupKeyForAsset(str);
        }

        public String getAssetFilePathBySubpath(String str, String str2) {
            return this.flutterLoader.getLookupKeyForAsset(str, str2);
        }
    }

    /* renamed from: io.flutter.embedding.engine.FlutterEngineConnectionRegistry$FlutterEngineActivityPluginBinding */
    private static class FlutterEngineActivityPluginBinding implements ActivityPluginBinding {
        private final Activity activity;
        private final HiddenLifecycleReference hiddenLifecycleReference;
        private final Set<PluginRegistry.ActivityResultListener> onActivityResultListeners = new HashSet();
        private final Set<PluginRegistry.NewIntentListener> onNewIntentListeners = new HashSet();
        private final Set<PluginRegistry.RequestPermissionsResultListener> onRequestPermissionsResultListeners = new HashSet();
        private final Set<ActivityPluginBinding.OnSaveInstanceStateListener> onSaveInstanceStateListeners = new HashSet();
        private final Set<PluginRegistry.UserLeaveHintListener> onUserLeaveHintListeners = new HashSet();

        public FlutterEngineActivityPluginBinding(Activity activity2, Lifecycle lifecycle) {
            this.activity = activity2;
            this.hiddenLifecycleReference = new HiddenLifecycleReference(lifecycle);
        }

        public Activity getActivity() {
            return this.activity;
        }

        public Object getLifecycle() {
            return this.hiddenLifecycleReference;
        }

        public void addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
            this.onRequestPermissionsResultListeners.add(requestPermissionsResultListener);
        }

        public void removeRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
            this.onRequestPermissionsResultListeners.remove(requestPermissionsResultListener);
        }

        /* access modifiers changed from: package-private */
        public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            Iterator<PluginRegistry.RequestPermissionsResultListener> it = this.onRequestPermissionsResultListeners.iterator();
            while (true) {
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        return z;
                    }
                    if (it.next().onRequestPermissionsResult(i, strArr, iArr) || z) {
                        z = true;
                    }
                }
            }
        }

        public void addActivityResultListener(PluginRegistry.ActivityResultListener activityResultListener) {
            this.onActivityResultListeners.add(activityResultListener);
        }

        public void removeActivityResultListener(PluginRegistry.ActivityResultListener activityResultListener) {
            this.onActivityResultListeners.remove(activityResultListener);
        }

        /* access modifiers changed from: package-private */
        public boolean onActivityResult(int i, int i2, Intent intent) {
            Iterator it = new HashSet(this.onActivityResultListeners).iterator();
            while (true) {
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        return z;
                    }
                    if (((PluginRegistry.ActivityResultListener) it.next()).onActivityResult(i, i2, intent) || z) {
                        z = true;
                    }
                }
            }
        }

        public void addOnNewIntentListener(PluginRegistry.NewIntentListener newIntentListener) {
            this.onNewIntentListeners.add(newIntentListener);
        }

        public void removeOnNewIntentListener(PluginRegistry.NewIntentListener newIntentListener) {
            this.onNewIntentListeners.remove(newIntentListener);
        }

        /* access modifiers changed from: package-private */
        public void onNewIntent(Intent intent) {
            for (PluginRegistry.NewIntentListener onNewIntent : this.onNewIntentListeners) {
                onNewIntent.onNewIntent(intent);
            }
        }

        public void addOnUserLeaveHintListener(PluginRegistry.UserLeaveHintListener userLeaveHintListener) {
            this.onUserLeaveHintListeners.add(userLeaveHintListener);
        }

        public void removeOnUserLeaveHintListener(PluginRegistry.UserLeaveHintListener userLeaveHintListener) {
            this.onUserLeaveHintListeners.remove(userLeaveHintListener);
        }

        public void addOnSaveStateListener(ActivityPluginBinding.OnSaveInstanceStateListener onSaveInstanceStateListener) {
            this.onSaveInstanceStateListeners.add(onSaveInstanceStateListener);
        }

        public void removeOnSaveStateListener(ActivityPluginBinding.OnSaveInstanceStateListener onSaveInstanceStateListener) {
            this.onSaveInstanceStateListeners.remove(onSaveInstanceStateListener);
        }

        /* access modifiers changed from: package-private */
        public void onUserLeaveHint() {
            for (PluginRegistry.UserLeaveHintListener onUserLeaveHint : this.onUserLeaveHintListeners) {
                onUserLeaveHint.onUserLeaveHint();
            }
        }

        /* access modifiers changed from: package-private */
        public void onSaveInstanceState(Bundle bundle) {
            for (ActivityPluginBinding.OnSaveInstanceStateListener onSaveInstanceState : this.onSaveInstanceStateListeners) {
                onSaveInstanceState.onSaveInstanceState(bundle);
            }
        }

        /* access modifiers changed from: package-private */
        public void onRestoreInstanceState(Bundle bundle) {
            for (ActivityPluginBinding.OnSaveInstanceStateListener onRestoreInstanceState : this.onSaveInstanceStateListeners) {
                onRestoreInstanceState.onRestoreInstanceState(bundle);
            }
        }
    }

    /* renamed from: io.flutter.embedding.engine.FlutterEngineConnectionRegistry$FlutterEngineServicePluginBinding */
    private static class FlutterEngineServicePluginBinding implements ServicePluginBinding {
        private final HiddenLifecycleReference hiddenLifecycleReference;
        private final Set<ServiceAware.OnModeChangeListener> onModeChangeListeners = new HashSet();
        private final Service service;

        FlutterEngineServicePluginBinding(Service service2, Lifecycle lifecycle) {
            this.service = service2;
            this.hiddenLifecycleReference = lifecycle != null ? new HiddenLifecycleReference(lifecycle) : null;
        }

        public Service getService() {
            return this.service;
        }

        public Object getLifecycle() {
            return this.hiddenLifecycleReference;
        }

        public void addOnModeChangeListener(ServiceAware.OnModeChangeListener onModeChangeListener) {
            this.onModeChangeListeners.add(onModeChangeListener);
        }

        public void removeOnModeChangeListener(ServiceAware.OnModeChangeListener onModeChangeListener) {
            this.onModeChangeListeners.remove(onModeChangeListener);
        }

        /* access modifiers changed from: package-private */
        public void onMoveToForeground() {
            for (ServiceAware.OnModeChangeListener onMoveToForeground : this.onModeChangeListeners) {
                onMoveToForeground.onMoveToForeground();
            }
        }

        /* access modifiers changed from: package-private */
        public void onMoveToBackground() {
            for (ServiceAware.OnModeChangeListener onMoveToBackground : this.onModeChangeListeners) {
                onMoveToBackground.onMoveToBackground();
            }
        }
    }

    /* renamed from: io.flutter.embedding.engine.FlutterEngineConnectionRegistry$FlutterEngineBroadcastReceiverPluginBinding */
    private static class FlutterEngineBroadcastReceiverPluginBinding implements BroadcastReceiverPluginBinding {
        private final BroadcastReceiver broadcastReceiver;

        FlutterEngineBroadcastReceiverPluginBinding(BroadcastReceiver broadcastReceiver2) {
            this.broadcastReceiver = broadcastReceiver2;
        }

        public BroadcastReceiver getBroadcastReceiver() {
            return this.broadcastReceiver;
        }
    }

    /* renamed from: io.flutter.embedding.engine.FlutterEngineConnectionRegistry$FlutterEngineContentProviderPluginBinding */
    private static class FlutterEngineContentProviderPluginBinding implements ContentProviderPluginBinding {
        private final ContentProvider contentProvider;

        FlutterEngineContentProviderPluginBinding(ContentProvider contentProvider2) {
            this.contentProvider = contentProvider2;
        }

        public ContentProvider getContentProvider() {
            return this.contentProvider;
        }
    }
}
