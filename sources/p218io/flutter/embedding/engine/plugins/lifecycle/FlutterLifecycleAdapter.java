package p218io.flutter.embedding.engine.plugins.lifecycle;

import androidx.lifecycle.Lifecycle;
import p218io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;

/* renamed from: io.flutter.embedding.engine.plugins.lifecycle.FlutterLifecycleAdapter */
public class FlutterLifecycleAdapter {

    /* renamed from: a */
    private static final String f60444a = "FlutterLifecycleAdapter";

    public static Lifecycle getActivityLifecycle(ActivityPluginBinding activityPluginBinding) {
        return ((HiddenLifecycleReference) activityPluginBinding.getLifecycle()).getLifecycle();
    }
}
