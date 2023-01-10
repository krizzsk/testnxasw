package com.didi.uni_entrega_business;

import android.os.Build;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;
import p218io.flutter.plugin.common.MethodCall;
import p218io.flutter.plugin.common.MethodChannel;

public class UniEntregaBusinessPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: a */
    private MethodChannel f47013a;

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "uni_entrega_business");
        this.f47013a = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals("getPlatformVersion")) {
            result.success("Android " + Build.VERSION.RELEASE);
            return;
        }
        result.notImplemented();
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f47013a.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }
}
