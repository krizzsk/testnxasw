package com.didi.rlab.uni_foundation;

import android.os.Build;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;
import p218io.flutter.plugin.common.MethodCall;
import p218io.flutter.plugin.common.MethodChannel;
import p218io.flutter.plugin.common.PluginRegistry;

public class UniFoundationPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: a */
    private MethodChannel f36776a;

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "uni_foundation");
        this.f36776a = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new MethodChannel(registrar.messenger(), "uni_foundation").setMethodCallHandler(new UniFoundationPlugin());
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals("getPlatformVersion")) {
            result.success("Android " + Build.VERSION.RELEASE);
            return;
        }
        result.notImplemented();
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f36776a.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }
}
