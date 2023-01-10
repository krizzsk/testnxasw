package p218io.flutter.embedding.engine.plugins.shim;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p218io.flutter.Log;
import p218io.flutter.embedding.engine.FlutterEngine;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;
import p218io.flutter.embedding.engine.plugins.activity.ActivityAware;
import p218io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p218io.flutter.plugin.common.PluginRegistry;

/* renamed from: io.flutter.embedding.engine.plugins.shim.ShimPluginRegistry */
public class ShimPluginRegistry implements PluginRegistry {

    /* renamed from: a */
    private static final String f60445a = "ShimPluginRegistry";

    /* renamed from: b */
    private final FlutterEngine f60446b;

    /* renamed from: c */
    private final Map<String, Object> f60447c = new HashMap();

    /* renamed from: d */
    private final ShimRegistrarAggregate f60448d;

    public ShimPluginRegistry(FlutterEngine flutterEngine) {
        this.f60446b = flutterEngine;
        this.f60448d = new ShimRegistrarAggregate();
        this.f60446b.getPlugins().add((FlutterPlugin) this.f60448d);
    }

    public PluginRegistry.Registrar registrarFor(String str) {
        Log.m45259v(f60445a, "Creating plugin Registrar for '" + str + "'");
        if (!this.f60447c.containsKey(str)) {
            this.f60447c.put(str, (Object) null);
            C22087a aVar = new C22087a(str, this.f60447c);
            this.f60448d.addPlugin(aVar);
            return aVar;
        }
        throw new IllegalStateException("Plugin key " + str + " is already in use");
    }

    public boolean hasPlugin(String str) {
        return this.f60447c.containsKey(str);
    }

    public <T> T valuePublishedByPlugin(String str) {
        return this.f60447c.get(str);
    }

    /* renamed from: io.flutter.embedding.engine.plugins.shim.ShimPluginRegistry$ShimRegistrarAggregate */
    private static class ShimRegistrarAggregate implements FlutterPlugin, ActivityAware {
        private ActivityPluginBinding activityPluginBinding;
        private FlutterPlugin.FlutterPluginBinding flutterPluginBinding;
        private final Set<C22087a> shimRegistrars;

        private ShimRegistrarAggregate() {
            this.shimRegistrars = new HashSet();
        }

        public void addPlugin(C22087a aVar) {
            this.shimRegistrars.add(aVar);
            FlutterPlugin.FlutterPluginBinding flutterPluginBinding2 = this.flutterPluginBinding;
            if (flutterPluginBinding2 != null) {
                aVar.onAttachedToEngine(flutterPluginBinding2);
            }
            ActivityPluginBinding activityPluginBinding2 = this.activityPluginBinding;
            if (activityPluginBinding2 != null) {
                aVar.onAttachedToActivity(activityPluginBinding2);
            }
        }

        public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding2) {
            this.flutterPluginBinding = flutterPluginBinding2;
            for (C22087a onAttachedToEngine : this.shimRegistrars) {
                onAttachedToEngine.onAttachedToEngine(flutterPluginBinding2);
            }
        }

        public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding2) {
            for (C22087a onDetachedFromEngine : this.shimRegistrars) {
                onDetachedFromEngine.onDetachedFromEngine(flutterPluginBinding2);
            }
            this.flutterPluginBinding = null;
            this.activityPluginBinding = null;
        }

        public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding2) {
            this.activityPluginBinding = activityPluginBinding2;
            for (C22087a onAttachedToActivity : this.shimRegistrars) {
                onAttachedToActivity.onAttachedToActivity(activityPluginBinding2);
            }
        }

        public void onDetachedFromActivityForConfigChanges() {
            for (C22087a onDetachedFromActivity : this.shimRegistrars) {
                onDetachedFromActivity.onDetachedFromActivity();
            }
            this.activityPluginBinding = null;
        }

        public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding2) {
            this.activityPluginBinding = activityPluginBinding2;
            for (C22087a onReattachedToActivityForConfigChanges : this.shimRegistrars) {
                onReattachedToActivityForConfigChanges.onReattachedToActivityForConfigChanges(activityPluginBinding2);
            }
        }

        public void onDetachedFromActivity() {
            for (C22087a onDetachedFromActivity : this.shimRegistrars) {
                onDetachedFromActivity.onDetachedFromActivity();
            }
            this.activityPluginBinding = null;
        }
    }
}
