package p218io.flutter.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p218io.flutter.embedding.engine.FlutterEngine;
import p218io.flutter.plugin.common.BinaryMessenger;
import p218io.flutter.plugin.common.PluginRegistry;
import p218io.flutter.plugin.platform.PlatformViewRegistry;
import p218io.flutter.plugin.platform.PlatformViewsController;
import p218io.flutter.view.FlutterMain;
import p218io.flutter.view.FlutterNativeView;
import p218io.flutter.view.FlutterView;
import p218io.flutter.view.TextureRegistry;

@Deprecated
/* renamed from: io.flutter.app.FlutterPluginRegistry */
public class FlutterPluginRegistry implements PluginRegistry, PluginRegistry.ActivityResultListener, PluginRegistry.NewIntentListener, PluginRegistry.RequestPermissionsResultListener, PluginRegistry.UserLeaveHintListener, PluginRegistry.ViewDestroyListener {

    /* renamed from: a */
    private static final String f60093a = "FlutterPluginRegistry";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Activity f60094b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f60095c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FlutterNativeView f60096d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FlutterView f60097e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final PlatformViewsController f60098f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Map<String, Object> f60099g = new LinkedHashMap(0);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final List<PluginRegistry.RequestPermissionsResultListener> f60100h = new ArrayList(0);
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final List<PluginRegistry.ActivityResultListener> f60101i = new ArrayList(0);
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final List<PluginRegistry.NewIntentListener> f60102j = new ArrayList(0);
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final List<PluginRegistry.UserLeaveHintListener> f60103k = new ArrayList(0);
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final List<PluginRegistry.ViewDestroyListener> f60104l = new ArrayList(0);

    public FlutterPluginRegistry(FlutterNativeView flutterNativeView, Context context) {
        this.f60096d = flutterNativeView;
        this.f60095c = context;
        this.f60098f = new PlatformViewsController();
    }

    public FlutterPluginRegistry(FlutterEngine flutterEngine, Context context) {
        this.f60095c = context;
        this.f60098f = new PlatformViewsController();
    }

    public boolean hasPlugin(String str) {
        return this.f60099g.containsKey(str);
    }

    public <T> T valuePublishedByPlugin(String str) {
        return this.f60099g.get(str);
    }

    public PluginRegistry.Registrar registrarFor(String str) {
        if (!this.f60099g.containsKey(str)) {
            this.f60099g.put(str, (Object) null);
            return new FlutterRegistrar(str);
        }
        throw new IllegalStateException("Plugin key " + str + " is already in use");
    }

    public void attach(FlutterView flutterView, Activity activity) {
        this.f60097e = flutterView;
        this.f60094b = activity;
        this.f60098f.attach(activity, flutterView, flutterView.getDartExecutor());
    }

    public void detach() {
        this.f60098f.detach();
        this.f60098f.onDetachedFromJNI();
        this.f60097e = null;
        this.f60094b = null;
    }

    public void onPreEngineRestart() {
        this.f60098f.onPreEngineRestart();
    }

    public PlatformViewsController getPlatformViewsController() {
        return this.f60098f;
    }

    /* renamed from: io.flutter.app.FlutterPluginRegistry$FlutterRegistrar */
    private class FlutterRegistrar implements PluginRegistry.Registrar {
        private final String pluginKey;

        FlutterRegistrar(String str) {
            this.pluginKey = str;
        }

        public Activity activity() {
            return FlutterPluginRegistry.this.f60094b;
        }

        public Context context() {
            return FlutterPluginRegistry.this.f60095c;
        }

        public Context activeContext() {
            return FlutterPluginRegistry.this.f60094b != null ? FlutterPluginRegistry.this.f60094b : FlutterPluginRegistry.this.f60095c;
        }

        public BinaryMessenger messenger() {
            return FlutterPluginRegistry.this.f60096d;
        }

        public TextureRegistry textures() {
            return FlutterPluginRegistry.this.f60097e;
        }

        public PlatformViewRegistry platformViewRegistry() {
            return FlutterPluginRegistry.this.f60098f.getRegistry();
        }

        public FlutterView view() {
            return FlutterPluginRegistry.this.f60097e;
        }

        public String lookupKeyForAsset(String str) {
            return FlutterMain.getLookupKeyForAsset(str);
        }

        public String lookupKeyForAsset(String str, String str2) {
            return FlutterMain.getLookupKeyForAsset(str, str2);
        }

        public PluginRegistry.Registrar publish(Object obj) {
            FlutterPluginRegistry.this.f60099g.put(this.pluginKey, obj);
            return this;
        }

        public PluginRegistry.Registrar addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
            FlutterPluginRegistry.this.f60100h.add(requestPermissionsResultListener);
            return this;
        }

        public PluginRegistry.Registrar addActivityResultListener(PluginRegistry.ActivityResultListener activityResultListener) {
            FlutterPluginRegistry.this.f60101i.add(activityResultListener);
            return this;
        }

        public PluginRegistry.Registrar addNewIntentListener(PluginRegistry.NewIntentListener newIntentListener) {
            FlutterPluginRegistry.this.f60102j.add(newIntentListener);
            return this;
        }

        public PluginRegistry.Registrar addUserLeaveHintListener(PluginRegistry.UserLeaveHintListener userLeaveHintListener) {
            FlutterPluginRegistry.this.f60103k.add(userLeaveHintListener);
            return this;
        }

        public PluginRegistry.Registrar addViewDestroyListener(PluginRegistry.ViewDestroyListener viewDestroyListener) {
            FlutterPluginRegistry.this.f60104l.add(viewDestroyListener);
            return this;
        }
    }

    public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        for (PluginRegistry.RequestPermissionsResultListener onRequestPermissionsResult : this.f60100h) {
            if (onRequestPermissionsResult.onRequestPermissionsResult(i, strArr, iArr)) {
                return true;
            }
        }
        return false;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        for (PluginRegistry.ActivityResultListener onActivityResult : this.f60101i) {
            if (onActivityResult.onActivityResult(i, i2, intent)) {
                return true;
            }
        }
        return false;
    }

    public boolean onNewIntent(Intent intent) {
        for (PluginRegistry.NewIntentListener onNewIntent : this.f60102j) {
            if (onNewIntent.onNewIntent(intent)) {
                return true;
            }
        }
        return false;
    }

    public void onUserLeaveHint() {
        for (PluginRegistry.UserLeaveHintListener onUserLeaveHint : this.f60103k) {
            onUserLeaveHint.onUserLeaveHint();
        }
    }

    public boolean onViewDestroy(FlutterNativeView flutterNativeView) {
        boolean z = false;
        for (PluginRegistry.ViewDestroyListener onViewDestroy : this.f60104l) {
            if (onViewDestroy.onViewDestroy(flutterNativeView)) {
                z = true;
            }
        }
        return z;
    }

    public void destroy() {
        this.f60098f.onDetachedFromJNI();
    }
}
