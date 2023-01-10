package p218io.flutter.embedding.engine.systemchannels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p218io.flutter.FlutterInjector;
import p218io.flutter.Log;
import p218io.flutter.embedding.engine.dart.DartExecutor;
import p218io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import p218io.flutter.plugin.common.MethodCall;
import p218io.flutter.plugin.common.MethodChannel;
import p218io.flutter.plugin.common.StandardMethodCodec;

/* renamed from: io.flutter.embedding.engine.systemchannels.DeferredComponentChannel */
public class DeferredComponentChannel {

    /* renamed from: b */
    private static final String f60472b = "DeferredComponentChannel";

    /* renamed from: a */
    final MethodChannel.MethodCallHandler f60473a = new MethodChannel.MethodCallHandler() {
        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            if (DeferredComponentChannel.this.f60475d != null) {
                String str = methodCall.method;
                Map map = (Map) methodCall.arguments();
                Log.m45259v(DeferredComponentChannel.f60472b, "Received '" + str + "' message.");
                int intValue = ((Integer) map.get("loadingUnitId")).intValue();
                String str2 = (String) map.get("componentName");
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1004447972) {
                    if (hashCode != 399701758) {
                        if (hashCode == 520962947 && str.equals("installDeferredComponent")) {
                            c = 0;
                        }
                    } else if (str.equals("getDeferredComponentInstallState")) {
                        c = 1;
                    }
                } else if (str.equals("uninstallDeferredComponent")) {
                    c = 2;
                }
                if (c == 0) {
                    DeferredComponentChannel.this.f60475d.installDeferredComponent(intValue, str2);
                    if (!DeferredComponentChannel.this.f60476e.containsKey(str2)) {
                        DeferredComponentChannel.this.f60476e.put(str2, new ArrayList());
                    }
                    ((List) DeferredComponentChannel.this.f60476e.get(str2)).add(result);
                } else if (c == 1) {
                    result.success(DeferredComponentChannel.this.f60475d.getDeferredComponentInstallState(intValue, str2));
                } else if (c != 2) {
                    result.notImplemented();
                } else {
                    DeferredComponentChannel.this.f60475d.uninstallDeferredComponent(intValue, str2);
                    result.success((Object) null);
                }
            }
        }
    };

    /* renamed from: c */
    private final MethodChannel f60474c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public DeferredComponentManager f60475d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Map<String, List<MethodChannel.Result>> f60476e;

    public DeferredComponentChannel(DartExecutor dartExecutor) {
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/deferredcomponent", StandardMethodCodec.INSTANCE);
        this.f60474c = methodChannel;
        methodChannel.setMethodCallHandler(this.f60473a);
        this.f60475d = FlutterInjector.instance().deferredComponentManager();
        this.f60476e = new HashMap();
    }

    public void setDeferredComponentManager(DeferredComponentManager deferredComponentManager) {
        this.f60475d = deferredComponentManager;
    }

    public void completeInstallSuccess(String str) {
        if (this.f60476e.containsKey(str)) {
            for (MethodChannel.Result success : this.f60476e.get(str)) {
                success.success((Object) null);
            }
            this.f60476e.get(str).clear();
        }
    }

    public void completeInstallError(String str, String str2) {
        if (this.f60476e.containsKey(str)) {
            for (MethodChannel.Result error : this.f60476e.get(str)) {
                error.error("DeferredComponent Install failure", str2, (Object) null);
            }
            this.f60476e.get(str).clear();
        }
    }
}
