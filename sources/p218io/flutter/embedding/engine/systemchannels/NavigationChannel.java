package p218io.flutter.embedding.engine.systemchannels;

import p218io.flutter.Log;
import p218io.flutter.embedding.engine.dart.DartExecutor;
import p218io.flutter.plugin.common.JSONMethodCodec;
import p218io.flutter.plugin.common.MethodCall;
import p218io.flutter.plugin.common.MethodChannel;

/* renamed from: io.flutter.embedding.engine.systemchannels.NavigationChannel */
public class NavigationChannel {

    /* renamed from: a */
    private static final String f60484a = "NavigationChannel";

    /* renamed from: b */
    private final MethodChannel.MethodCallHandler f60485b = new MethodChannel.MethodCallHandler() {
        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            result.success((Object) null);
        }
    };
    public final MethodChannel channel;

    public NavigationChannel(DartExecutor dartExecutor) {
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/navigation", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this.f60485b);
    }

    public void setInitialRoute(String str) {
        Log.m45259v(f60484a, "Sending message to set initial route to '" + str + "'");
        this.channel.invokeMethod("setInitialRoute", str);
    }

    public void pushRoute(String str) {
        Log.m45259v(f60484a, "Sending message to push route '" + str + "'");
        this.channel.invokeMethod("pushRoute", str);
    }

    public void popRoute() {
        Log.m45259v(f60484a, "Sending message to pop route.");
        this.channel.invokeMethod("popRoute", (Object) null);
    }

    public void setMethodCallHandler(MethodChannel.MethodCallHandler methodCallHandler) {
        this.channel.setMethodCallHandler(methodCallHandler);
    }
}
