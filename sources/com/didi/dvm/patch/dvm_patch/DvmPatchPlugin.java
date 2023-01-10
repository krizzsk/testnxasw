package com.didi.dvm.patch.dvm_patch;

import org.json.JSONObject;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;
import p218io.flutter.plugin.common.MethodCall;
import p218io.flutter.plugin.common.MethodChannel;

public class DvmPatchPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: a */
    private MethodChannel f21169a;

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), BuildConfig.LIBRARY_PACKAGE_NAME);
        this.f21169a = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        if (methodCall.method.equals("getPatchesInfo")) {
            JSONObject a = DVMPatchManager.m17850a(this);
            if (a == null) {
                str = null;
            } else {
                str = a.toString();
            }
            result.success(str);
            return;
        }
        result.notImplemented();
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f21169a.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void refresh() {
        this.f21169a.invokeMethod("refresh", (Object) null);
    }
}
