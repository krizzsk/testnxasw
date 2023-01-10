package com.didi.flutter.nacho2.p116v2.container;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.didi.flutter.nacho2.p116v2.NachoAction;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.didi.sdk.apm.SystemUtils;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import p218io.flutter.embedding.android.FlutterActivityV1;
import p218io.flutter.embedding.android.FlutterSurfaceView;
import p218io.flutter.embedding.android.FlutterTextureView;
import p218io.flutter.embedding.engine.FlutterEngine;
import p218io.flutter.embedding.engine.renderer.RenderSurface;
import p218io.flutter.embedding.engine.systemchannels.PlatformChannel;
import p218io.flutter.plugin.platform.PlatformPlugin;

/* renamed from: com.didi.flutter.nacho2.v2.container.NachoFlutterActivity */
public abstract class NachoFlutterActivity extends FlutterActivityV1 {

    /* renamed from: a */
    static WeakReference<PlatformChannel.PlatformMessageHandler> f23011a;

    /* renamed from: b */
    private String f23012b;

    /* renamed from: c */
    private PlatformChannel.PlatformMessageHandler f23013c;

    /* renamed from: d */
    private RenderSurface f23014d;

    public abstract HashMap<String, Object> provideExtParams();

    public abstract String provideInitialRoute();

    public abstract NachoAction provideNachoAction();

    public FlutterEngine provideFlutterEngine(Context context) {
        return provideNachoAction().getEngine();
    }

    public String getInitialRoute() {
        return provideInitialRoute();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.f23012b = SystemClock.uptimeMillis() + "@" + Integer.toHexString(hashCode());
        HashMap hashMap = new HashMap();
        hashMap.put("initial_route", getInitialRoute());
        NachoLifecycleManager.sendLifecycleOnCreate(provideNachoAction(), this.f23012b, hashMap, provideExtParams());
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        NachoLifecycleManager.sendLifecycleOnResume(provideNachoAction(), this.f23012b);
        f23011a = new WeakReference<>(this.f23013c);
        m18978a(getFlutterEngine());
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        if (f23011a.get() == this.f23013c) {
            f23011a.clear();
        }
        super.onStop();
        m18977a();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        NachoLifecycleManager.sendLifecycleOnDestroy(provideNachoAction(), this.f23012b);
        FlutterEngine flutterEngine = getFlutterEngine();
        super.onDestroy();
        m18978a(flutterEngine);
        m18977a();
    }

    public void onFlutterSurfaceViewCreated(FlutterSurfaceView flutterSurfaceView) {
        super.onFlutterSurfaceViewCreated(flutterSurfaceView);
        this.f23014d = flutterSurfaceView;
    }

    public void onFlutterTextureViewCreated(FlutterTextureView flutterTextureView) {
        super.onFlutterTextureViewCreated(flutterTextureView);
        this.f23014d = flutterTextureView;
    }

    public PlatformPlugin providePlatformPlugin(Activity activity, FlutterEngine flutterEngine) {
        PlatformPlugin providePlatformPlugin = super.providePlatformPlugin(activity, flutterEngine);
        try {
            PlatformChannel platformChannel = flutterEngine.getPlatformChannel();
            Field declaredField = platformChannel.getClass().getDeclaredField("platformMessageHandler");
            declaredField.setAccessible(true);
            this.f23013c = (PlatformChannel.PlatformMessageHandler) declaredField.get(platformChannel);
            PrintStream printStream = System.out;
            printStream.println("======providePlatformPlugin======:" + this.f23013c);
        } catch (Exception unused) {
        }
        return providePlatformPlugin;
    }

    /* renamed from: a */
    private void m18978a(FlutterEngine flutterEngine) {
        PlatformChannel.PlatformMessageHandler platformMessageHandler = (PlatformChannel.PlatformMessageHandler) f23011a.get();
        if (platformMessageHandler != null && flutterEngine != null) {
            try {
                flutterEngine.getPlatformChannel().setPlatformMessageHandler(platformMessageHandler);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private void m18977a() {
        NachoFlutterActivity topContainer = NachoActivityManager.getInstance().getTopContainer();
        if (topContainer != null) {
            topContainer.m18979b();
        }
    }

    /* renamed from: b */
    private void m18979b() {
        FlutterEngine flutterEngine = getFlutterEngine();
        if (flutterEngine != null) {
            RenderSurface renderSurface = this.f23014d;
            if ((renderSurface != null && renderSurface.getAttachedRenderer() == null) || !this.f23014d.getAttachedRenderer().isDisplayingFlutterUi()) {
                this.f23014d.attachToRenderer(flutterEngine.getRenderer());
            }
            flutterEngine.getLifecycleChannel().appIsResumed();
        }
    }

    public String getPageId() {
        return this.f23012b;
    }
}
