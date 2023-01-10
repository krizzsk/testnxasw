package p218io.flutter.plugins.deviceinfo;

import android.content.Context;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;
import p218io.flutter.plugin.common.BinaryMessenger;
import p218io.flutter.plugin.common.MethodChannel;
import p218io.flutter.plugin.common.PluginRegistry;

/* renamed from: io.flutter.plugins.deviceinfo.DeviceInfoPlugin */
public class DeviceInfoPlugin implements FlutterPlugin {

    /* renamed from: a */
    MethodChannel f60657a;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new DeviceInfoPlugin().m45777a(registrar.messenger(), registrar.context());
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        m45777a(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getApplicationContext());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        m45776a();
    }

    /* renamed from: a */
    private void m45777a(BinaryMessenger binaryMessenger, Context context) {
        this.f60657a = new MethodChannel(binaryMessenger, "plugins.flutter.io/device_info");
        this.f60657a.setMethodCallHandler(new C22130a(context.getContentResolver(), context.getPackageManager()));
    }

    /* renamed from: a */
    private void m45776a() {
        this.f60657a.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.f60657a = null;
    }
}
