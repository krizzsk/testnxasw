package p218io.flutter.embedding.engine.systemchannels;

import java.util.HashMap;
import p218io.flutter.Log;
import p218io.flutter.embedding.engine.dart.DartExecutor;
import p218io.flutter.plugin.common.MethodCall;
import p218io.flutter.plugin.common.MethodChannel;
import p218io.flutter.plugin.common.StandardMethodCodec;

/* renamed from: io.flutter.embedding.engine.systemchannels.MouseCursorChannel */
public class MouseCursorChannel {

    /* renamed from: a */
    private static final String f60481a = "MouseCursorChannel";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public MouseCursorMethodHandler f60482b;

    /* renamed from: c */
    private final MethodChannel.MethodCallHandler f60483c = new MethodChannel.MethodCallHandler() {
        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            if (MouseCursorChannel.this.f60482b != null) {
                String str = methodCall.method;
                Log.m45259v(MouseCursorChannel.f60481a, "Received '" + str + "' message.");
                char c = 65535;
                try {
                    if (str.hashCode() == -1307105544) {
                        if (str.equals("activateSystemCursor")) {
                            c = 0;
                        }
                    }
                    if (c == 0) {
                        try {
                            MouseCursorChannel.this.f60482b.activateSystemCursor((String) ((HashMap) methodCall.arguments).get("kind"));
                            result.success(true);
                        } catch (Exception e) {
                            result.error("error", "Error when setting cursors: " + e.getMessage(), (Object) null);
                        }
                    }
                } catch (Exception e2) {
                    result.error("error", "Unhandled error: " + e2.getMessage(), (Object) null);
                }
            }
        }
    };
    public final MethodChannel channel;

    /* renamed from: io.flutter.embedding.engine.systemchannels.MouseCursorChannel$MouseCursorMethodHandler */
    public interface MouseCursorMethodHandler {
        void activateSystemCursor(String str);
    }

    public MouseCursorChannel(DartExecutor dartExecutor) {
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/mousecursor", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this.f60483c);
    }

    public void setMethodHandler(MouseCursorMethodHandler mouseCursorMethodHandler) {
        this.f60482b = mouseCursorMethodHandler;
    }

    public void synthesizeMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f60483c.onMethodCall(methodCall, result);
    }
}
