package git.xiaojukeji.com.uni_customer_business;

import android.os.Build;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;
import p218io.flutter.plugin.common.MethodCall;
import p218io.flutter.plugin.common.MethodChannel;
import p218io.flutter.plugin.common.PluginRegistry;

public class UniCustomerBusinessPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: a */
    private MethodChannel f60024a;

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "uni_customer_business");
        this.f60024a = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new MethodChannel(registrar.messenger(), "uni_customer_business").setMethodCallHandler(new UniCustomerBusinessPlugin());
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals("getPlatformVersion")) {
            result.success("Android " + Build.VERSION.RELEASE);
            return;
        }
        result.notImplemented();
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f60024a.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }
}
