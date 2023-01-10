package p218io.flutter.plugins.urllauncher;

import android.app.Activity;
import android.util.Log;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;
import p218io.flutter.embedding.engine.plugins.activity.ActivityAware;
import p218io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p218io.flutter.plugin.common.PluginRegistry;

/* renamed from: io.flutter.plugins.urllauncher.UrlLauncherPlugin */
public final class UrlLauncherPlugin implements FlutterPlugin, ActivityAware {

    /* renamed from: a */
    private static final String f60680a = "UrlLauncherPlugin";

    /* renamed from: b */
    private C22176a f60681b;

    /* renamed from: c */
    private UrlLauncher f60682c;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new C22176a(new UrlLauncher(registrar.context(), registrar.activity())).mo182727a(registrar.messenger());
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        UrlLauncher urlLauncher = new UrlLauncher(flutterPluginBinding.getApplicationContext(), (Activity) null);
        this.f60682c = urlLauncher;
        C22176a aVar = new C22176a(urlLauncher);
        this.f60681b = aVar;
        aVar.mo182727a(flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        C22176a aVar = this.f60681b;
        if (aVar == null) {
            Log.wtf(f60680a, "Already detached from the engine.");
            return;
        }
        aVar.mo182726a();
        this.f60681b = null;
        this.f60682c = null;
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        if (this.f60681b == null) {
            Log.wtf(f60680a, "urlLauncher was never set.");
        } else {
            this.f60682c.mo182715a(activityPluginBinding.getActivity());
        }
    }

    public void onDetachedFromActivity() {
        if (this.f60681b == null) {
            Log.wtf(f60680a, "urlLauncher was never set.");
        } else {
            this.f60682c.mo182715a((Activity) null);
        }
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }
}
