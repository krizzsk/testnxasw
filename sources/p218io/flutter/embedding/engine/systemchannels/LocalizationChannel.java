package p218io.flutter.embedding.engine.systemchannels;

import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import p218io.flutter.Log;
import p218io.flutter.embedding.engine.dart.DartExecutor;
import p218io.flutter.plugin.common.JSONMethodCodec;
import p218io.flutter.plugin.common.MethodCall;
import p218io.flutter.plugin.common.MethodChannel;

/* renamed from: io.flutter.embedding.engine.systemchannels.LocalizationChannel */
public class LocalizationChannel {

    /* renamed from: a */
    private static final String f60479a = "LocalizationChannel";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LocalizationMessageHandler f60480b;
    public final MethodChannel channel;
    public final MethodChannel.MethodCallHandler handler = new MethodChannel.MethodCallHandler() {
        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            if (LocalizationChannel.this.f60480b != null) {
                String str = methodCall.method;
                char c = 65535;
                if (str.hashCode() == -259484608 && str.equals("Localization.getStringResource")) {
                    c = 0;
                }
                if (c != 0) {
                    result.notImplemented();
                    return;
                }
                JSONObject jSONObject = (JSONObject) methodCall.arguments();
                try {
                    result.success(LocalizationChannel.this.f60480b.getStringResource(jSONObject.getString("key"), jSONObject.has("locale") ? jSONObject.getString("locale") : null));
                } catch (JSONException e) {
                    result.error("error", e.getMessage(), (Object) null);
                }
            }
        }
    };

    /* renamed from: io.flutter.embedding.engine.systemchannels.LocalizationChannel$LocalizationMessageHandler */
    public interface LocalizationMessageHandler {
        String getStringResource(String str, String str2);
    }

    public LocalizationChannel(DartExecutor dartExecutor) {
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/localization", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this.handler);
    }

    public void setLocalizationMessageHandler(LocalizationMessageHandler localizationMessageHandler) {
        this.f60480b = localizationMessageHandler;
    }

    public void sendLocales(List<Locale> list) {
        Log.m45259v(f60479a, "Sending Locales to Flutter.");
        ArrayList arrayList = new ArrayList();
        for (Locale next : list) {
            Log.m45259v(f60479a, "Locale (Language: " + next.getLanguage() + ", Country: " + next.getCountry() + ", Variant: " + next.getVariant() + ")");
            arrayList.add(next.getLanguage());
            arrayList.add(next.getCountry());
            arrayList.add(Build.VERSION.SDK_INT >= 21 ? next.getScript() : "");
            arrayList.add(next.getVariant());
        }
        this.channel.invokeMethod("setLocale", arrayList);
    }
}
