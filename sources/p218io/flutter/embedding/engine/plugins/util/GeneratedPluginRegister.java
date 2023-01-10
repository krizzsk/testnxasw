package p218io.flutter.embedding.engine.plugins.util;

import p218io.flutter.Log;
import p218io.flutter.embedding.engine.FlutterEngine;

/* renamed from: io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister */
public class GeneratedPluginRegister {

    /* renamed from: a */
    private static final String f60459a = "GeneratedPluginsRegister";

    public static void registerGeneratedPlugins(FlutterEngine flutterEngine) {
        try {
            Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", new Class[]{FlutterEngine.class}).invoke((Object) null, new Object[]{flutterEngine});
        } catch (Exception e) {
            Log.m45255e(f60459a, "Tried to automatically register plugins with FlutterEngine (" + flutterEngine + ") but could not find or invoke the GeneratedPluginRegistrant.");
            Log.m45256e(f60459a, "Received exception while registering", e);
        }
    }
}
