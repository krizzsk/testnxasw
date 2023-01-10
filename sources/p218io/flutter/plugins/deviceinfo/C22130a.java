package p218io.flutter.plugins.deviceinfo;

import android.content.ContentResolver;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import java.util.Arrays;
import java.util.HashMap;
import p218io.flutter.plugin.common.MethodCall;
import p218io.flutter.plugin.common.MethodChannel;

/* renamed from: io.flutter.plugins.deviceinfo.a */
/* compiled from: MethodCallHandlerImpl */
class C22130a implements MethodChannel.MethodCallHandler {

    /* renamed from: c */
    private static final String[] f60658c = new String[0];

    /* renamed from: a */
    private final ContentResolver f60659a;

    /* renamed from: b */
    private final PackageManager f60660b;

    C22130a(ContentResolver contentResolver, PackageManager packageManager) {
        this.f60659a = contentResolver;
        this.f60660b = packageManager;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals("getAndroidDeviceInfo")) {
            HashMap hashMap = new HashMap();
            hashMap.put("board", Build.BOARD);
            hashMap.put("bootloader", Build.BOOTLOADER);
            hashMap.put("brand", Build.BRAND);
            hashMap.put("device", Build.DEVICE);
            hashMap.put("display", Build.DISPLAY);
            hashMap.put("fingerprint", Build.FINGERPRINT);
            hashMap.put("hardware", Build.HARDWARE);
            hashMap.put("host", Build.HOST);
            hashMap.put("id", Build.ID);
            hashMap.put("manufacturer", Build.MANUFACTURER);
            hashMap.put("model", Build.MODEL);
            hashMap.put("product", Build.PRODUCT);
            if (Build.VERSION.SDK_INT >= 21) {
                hashMap.put("supported32BitAbis", Arrays.asList(Build.SUPPORTED_32_BIT_ABIS));
                hashMap.put("supported64BitAbis", Arrays.asList(Build.SUPPORTED_64_BIT_ABIS));
                hashMap.put("supportedAbis", Arrays.asList(Build.SUPPORTED_ABIS));
            } else {
                hashMap.put("supported32BitAbis", Arrays.asList(f60658c));
                hashMap.put("supported64BitAbis", Arrays.asList(f60658c));
                hashMap.put("supportedAbis", Arrays.asList(f60658c));
            }
            hashMap.put("tags", Build.TAGS);
            hashMap.put("type", Build.TYPE);
            hashMap.put("isPhysicalDevice", Boolean.valueOf(!m45780c()));
            hashMap.put("androidId", m45779b());
            hashMap.put("systemFeatures", Arrays.asList(m45778a()));
            HashMap hashMap2 = new HashMap();
            if (Build.VERSION.SDK_INT >= 23) {
                hashMap2.put("baseOS", Build.VERSION.BASE_OS);
                hashMap2.put("previewSdkInt", Integer.valueOf(Build.VERSION.PREVIEW_SDK_INT));
                hashMap2.put("securityPatch", Build.VERSION.SECURITY_PATCH);
            }
            hashMap2.put("codename", Build.VERSION.CODENAME);
            hashMap2.put("incremental", Build.VERSION.INCREMENTAL);
            hashMap2.put("release", Build.VERSION.RELEASE);
            hashMap2.put("sdkInt", Integer.valueOf(Build.VERSION.SDK_INT));
            hashMap.put("version", hashMap2);
            result.success(hashMap);
            return;
        }
        result.notImplemented();
    }

    /* renamed from: a */
    private String[] m45778a() {
        FeatureInfo[] systemAvailableFeatures = this.f60660b.getSystemAvailableFeatures();
        if (systemAvailableFeatures == null) {
            return f60658c;
        }
        String[] strArr = new String[systemAvailableFeatures.length];
        for (int i = 0; i < systemAvailableFeatures.length; i++) {
            strArr[i] = systemAvailableFeatures[i].name;
        }
        return strArr;
    }

    /* renamed from: b */
    private String m45779b() {
        return Settings.Secure.getString(this.f60659a, "android_id");
    }

    /* renamed from: c */
    private boolean m45780c() {
        return (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.startsWith("unknown") || Build.HARDWARE.contains("goldfish") || Build.HARDWARE.contains("ranchu") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || Build.PRODUCT.contains("sdk_google") || Build.PRODUCT.contains("google_sdk") || Build.PRODUCT.contains("sdk") || Build.PRODUCT.contains("sdk_x86") || Build.PRODUCT.contains("vbox86p") || Build.PRODUCT.contains("emulator") || Build.PRODUCT.contains("simulator");
    }
}
