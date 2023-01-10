package com.didi.flutter.hotpatch.flutterhotpatch;

import android.app.Application;
import android.text.TextUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.io.File;
import java.lang.reflect.Field;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;
import p218io.flutter.plugin.common.MethodCall;
import p218io.flutter.plugin.common.MethodChannel;
import p218io.flutter.plugin.common.PluginRegistry;
import p218io.flutter.view.FlutterMain;

public class FlutterhotpatchPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static final String CHANNEL_NAME = "com.didi.flutter.hotpatch.flutterhotpatch.flutterhotpatch";

    /* renamed from: a */
    private static HotPatchAdapter f22925a;

    /* renamed from: b */
    private static Logger f22926b = LoggerFactory.getLogger("FlutterhotpatchPlugin");

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), CHANNEL_NAME).setMethodCallHandler(new FlutterhotpatchPlugin());
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new MethodChannel(registrar.messenger(), CHANNEL_NAME).setMethodCallHandler(new FlutterhotpatchPlugin());
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals("onFlutterError")) {
            HotPatchAdapter hotPatchAdapter = f22925a;
            if (hotPatchAdapter != null) {
                hotPatchAdapter.onFlutterError();
            }
            result.success((Object) null);
            return;
        }
        result.notImplemented();
    }

    public static void init(Application application, HotPatchAdapter hotPatchAdapter) {
        boolean z;
        if (hotPatchAdapter != null && hotPatchAdapter.canLoadPatch(application)) {
            String patchPath = hotPatchAdapter.getPatchPath(application);
            Logger logger = f22926b;
            logger.info("patchPath:" + patchPath, new Object[0]);
            if (!TextUtils.isEmpty(patchPath)) {
                if (!new File(patchPath).exists()) {
                    Logger logger2 = f22926b;
                    logger2.info("patch not exists:" + patchPath, new Object[0]);
                    return;
                }
                Class cls = FlutterMain.class;
                try {
                    cls = Class.forName("io.flutter.embedding.engine.loader.FlutterLoader");
                    z = true;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    z = false;
                }
                try {
                    Logger logger3 = f22926b;
                    logger3.info("targetClazz:" + cls, new Object[0]);
                    Field declaredField = cls.getDeclaredField("aotSharedLibraryName");
                    declaredField.setAccessible(true);
                    if (z) {
                        declaredField.set(cls.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]), patchPath);
                    } else {
                        declaredField.set((Object) null, patchPath);
                    }
                    f22925a = hotPatchAdapter;
                    f22926b.info("FlutterhotpatchPlugin init completed", new Object[0]);
                } catch (Throwable th) {
                    f22926b.error("init error", th);
                }
            }
        }
    }

    public static void init(Application application) {
        init(application, new OnePatchAdapter());
    }
}
