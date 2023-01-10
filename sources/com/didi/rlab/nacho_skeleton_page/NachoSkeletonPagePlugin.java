package com.didi.rlab.nacho_skeleton_page;

import android.os.Build;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;
import p218io.flutter.plugin.common.MethodCall;
import p218io.flutter.plugin.common.MethodChannel;

public class NachoSkeletonPagePlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: a */
    private MethodChannel f36775a;

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "nacho_skeleton_page");
        this.f36775a = methodChannel;
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
        this.f36775a.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }
}
