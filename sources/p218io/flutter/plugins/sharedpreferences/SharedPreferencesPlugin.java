package p218io.flutter.plugins.sharedpreferences;

import android.content.Context;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;
import p218io.flutter.plugin.common.BinaryMessenger;
import p218io.flutter.plugin.common.MethodChannel;
import p218io.flutter.plugin.common.PluginRegistry;

/* renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin */
public class SharedPreferencesPlugin implements FlutterPlugin {

    /* renamed from: a */
    private static final String f60667a = "plugins.flutter.io/shared_preferences_android";

    /* renamed from: b */
    private MethodChannel f60668b;

    /* renamed from: c */
    private C22166a f60669c;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new SharedPreferencesPlugin().m45804a(registrar.messenger(), registrar.context());
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        m45804a(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getApplicationContext());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        m45803a();
    }

    /* renamed from: a */
    private void m45804a(BinaryMessenger binaryMessenger, Context context) {
        this.f60668b = new MethodChannel(binaryMessenger, f60667a);
        C22166a aVar = new C22166a(context);
        this.f60669c = aVar;
        this.f60668b.setMethodCallHandler(aVar);
    }

    /* renamed from: a */
    private void m45803a() {
        this.f60669c.mo182712a();
        this.f60669c = null;
        this.f60668b.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.f60668b = null;
    }
}
