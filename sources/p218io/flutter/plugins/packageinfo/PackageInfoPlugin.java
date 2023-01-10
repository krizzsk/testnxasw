package p218io.flutter.plugins.packageinfo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.biz.popdialog.AppsFlyerHelperKt;
import java.util.HashMap;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;
import p218io.flutter.plugin.common.BinaryMessenger;
import p218io.flutter.plugin.common.MethodCall;
import p218io.flutter.plugin.common.MethodChannel;
import p218io.flutter.plugin.common.PluginRegistry;

/* renamed from: io.flutter.plugins.packageinfo.PackageInfoPlugin */
public class PackageInfoPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: a */
    private Context f60661a;

    /* renamed from: b */
    private MethodChannel f60662b;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new PackageInfoPlugin().m45782a(registrar.context(), registrar.messenger());
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        m45782a(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
    }

    /* renamed from: a */
    private void m45782a(Context context, BinaryMessenger binaryMessenger) {
        this.f60661a = context;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "plugins.flutter.io/package_info");
        this.f60662b = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f60661a = null;
        this.f60662b.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.f60662b = null;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        try {
            if (methodCall.method.equals("getAll")) {
                PackageManager packageManager = this.f60661a.getPackageManager();
                PackageInfo packageInfo = SystemUtils.getPackageInfo(packageManager, this.f60661a.getPackageName(), 0);
                HashMap hashMap = new HashMap();
                hashMap.put(AppsFlyerHelperKt.appLinkAppName, packageInfo.applicationInfo.loadLabel(packageManager).toString());
                hashMap.put("packageName", this.f60661a.getPackageName());
                hashMap.put("version", packageInfo.versionName);
                hashMap.put("buildNumber", String.valueOf(m45781a(packageInfo)));
                result.success(hashMap);
                return;
            }
            result.notImplemented();
        } catch (PackageManager.NameNotFoundException e) {
            result.error("Name not found", e.getMessage(), (Object) null);
        }
    }

    /* renamed from: a */
    private static long m45781a(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return packageInfo.getLongVersionCode();
        }
        return (long) packageInfo.versionCode;
    }
}
