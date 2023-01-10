package com.didiglobal.asset_manager;

import android.content.Context;
import com.didiglobal.font.DIDIFontUtils;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;
import p218io.flutter.plugin.common.MethodCall;
import p218io.flutter.plugin.common.MethodChannel;
import p218io.flutter.plugin.common.PluginRegistry;

public class AssetManagerPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: a */
    private MethodChannel f52301a;

    /* renamed from: b */
    private Context f52302b;

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f52302b = flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "asset_manager");
        this.f52301a = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new MethodChannel(registrar.messenger(), "asset_manager").setMethodCallHandler(new AssetManagerPlugin());
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals("getSupportFontFromNative")) {
            result.success(DIDIFontUtils.Companion.getFontByteArrayMap(this.f52302b));
        } else if (methodCall.method.equals("getFontWeightConf")) {
            String weightRuleConfig = DIDIFontUtils.Companion.getWeightRuleConfig();
            if (weightRuleConfig == null) {
                result.success("");
            } else {
                result.success(weightRuleConfig);
            }
        } else {
            result.notImplemented();
        }
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f52301a.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }
}
