package com.didi.flutter.nacho;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import p218io.flutter.embedding.android.FlutterActivity2;
import p218io.flutter.embedding.android.FlutterSurfaceView;
import p218io.flutter.embedding.android.FlutterTextureView;
import p218io.flutter.embedding.engine.FlutterEngine;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;
import p218io.flutter.embedding.engine.renderer.RenderSurface;
import p218io.flutter.embedding.engine.systemchannels.PlatformChannel;
import p218io.flutter.plugin.platform.PlatformPlugin;

public class NachoFlutterActivity extends FlutterActivity2 implements INachoApp {
    public static final String PARAMS = "_params";
    public static final String THEME = "_theme";

    /* renamed from: a */
    static WeakReference<PlatformChannel.PlatformMessageHandler> f22944a = null;

    /* renamed from: b */
    private static final String f22945b = "_nacho_pageID";

    /* renamed from: c */
    private static final String f22946c = "_nacho_engineId";

    /* renamed from: d */
    private String f22947d;

    /* renamed from: e */
    private String f22948e;

    /* renamed from: f */
    private RenderSurface f22949f;

    /* renamed from: g */
    private boolean f22950g = false;

    /* renamed from: h */
    private boolean f22951h;

    /* renamed from: i */
    private PlatformChannel.PlatformMessageHandler f22952i;

    public String getCachedEngineId() {
        return null;
    }

    public boolean shouldDestroyEngineWithHost() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        Logger logger = Nacho.logger();
        logger.debug("onCreate:" + this, new Object[0]);
        int intExtra = getIntent().getIntExtra(THEME, 0);
        if (intExtra != 0) {
            setTheme(intExtra);
        }
        if (bundle == null) {
            String stringExtra = getIntent().getStringExtra(INachoApp.ENGINE_ID);
            this.f22948e = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                this.f22948e = Nacho.getInstance().getDefaultEngineId();
            }
            this.f22947d = SystemClock.uptimeMillis() + "@" + Integer.toHexString(hashCode());
            HashMap hashMap = new HashMap();
            hashMap.put("initial_route", getInitialRoute());
            super.onCreate((Bundle) null);
            ((NachoPlugin) Nacho.getInstance().getPlugin(getFlutterEngine(), (Class<? extends FlutterPlugin>) NachoPlugin.class)).sendLifecycleEvent(this.f22947d, NachoLifecycleManager.LIFECYCLE_ON_CREATE, this.f22948e, hashMap, getNachoParams());
            return;
        }
        this.f22948e = bundle.getString(f22946c);
        this.f22947d = bundle.getString(f22945b);
        super.onCreate(bundle);
    }

    public static CachedEngineIntentBuilder2 withCachedEngine(Class<? extends FlutterActivity2> cls) {
        return new CachedEngineIntentBuilder2(cls);
    }

    static class CachedEngineIntentBuilder2 extends FlutterActivity2.NewEngineIntentBuilder {
        private String engineId;
        private HashMap<String, String> params;
        private int theme;

        protected CachedEngineIntentBuilder2(Class<? extends FlutterActivity2> cls) {
            super(cls);
        }

        public CachedEngineIntentBuilder2 engineId(String str) {
            this.engineId = str;
            return this;
        }

        public CachedEngineIntentBuilder2 params(HashMap<String, String> hashMap) {
            this.params = hashMap;
            return this;
        }

        public Intent build(Context context) {
            Intent build = super.build(context);
            build.putExtra("destroy_engine_with_activity", false);
            build.putExtra(NachoFlutterActivity.PARAMS, this.params);
            build.putExtra(NachoFlutterActivity.THEME, this.theme);
            build.putExtra(INachoApp.ENGINE_ID, this.engineId);
            return build;
        }

        public CachedEngineIntentBuilder2 theme(int i) {
            this.theme = i;
            return this;
        }
    }

    public HashMap<String, String> getNachoParams() {
        return (HashMap) getIntent().getSerializableExtra(PARAMS);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        Logger logger = Nacho.logger();
        logger.debug("onStart:" + this, new Object[0]);
        super.onStart();
        ((NachoPlugin) Nacho.getInstance().getPlugin(getFlutterEngine(), (Class<? extends FlutterPlugin>) NachoPlugin.class)).sendLifecycleEvent(this.f22947d, "onStart", this.f22948e, (Map<String, String>) null, getNachoParams());
    }

    public FlutterEngine provideFlutterEngine(Context context) {
        return Nacho.getInstance().getEngine(this.f22948e);
    }

    public PlatformPlugin providePlatformPlugin(Activity activity, FlutterEngine flutterEngine) {
        PlatformPlugin providePlatformPlugin = super.providePlatformPlugin(activity, flutterEngine);
        try {
            PlatformChannel platformChannel = flutterEngine.getPlatformChannel();
            Field declaredField = platformChannel.getClass().getDeclaredField("platformMessageHandler");
            declaredField.setAccessible(true);
            this.f22952i = (PlatformChannel.PlatformMessageHandler) declaredField.get(platformChannel);
            PrintStream printStream = System.out;
            printStream.println("======providePlatformPlugin======:" + this.f22952i);
        } catch (Exception e) {
            Nacho.logger().error("get platformMessageHandler error", (Throwable) e);
        }
        return providePlatformPlugin;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        Logger logger = Nacho.logger();
        logger.debug("onResume:" + this, new Object[0]);
        super.onResume();
        ((NachoPlugin) Nacho.getInstance().getPlugin(getFlutterEngine(), (Class<? extends FlutterPlugin>) NachoPlugin.class)).sendLifecycleEvent(this.f22947d, "onResume", this.f22948e, (Map<String, String>) null, (Map<String, String>) null);
        f22944a = new WeakReference<>(this.f22952i);
        m18941a(getFlutterEngine());
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        Logger logger = Nacho.logger();
        boolean z = false;
        logger.debug("onStop:" + this + " isFinishing:" + isFinishing(), new Object[0]);
        WeakReference<PlatformChannel.PlatformMessageHandler> weakReference = f22944a;
        if (weakReference != null && weakReference.get() == this.f22952i) {
            f22944a.clear();
        }
        super.onStop();
        m18940a();
        ((NachoPlugin) Nacho.getInstance().getPlugin(getFlutterEngine(), (Class<? extends FlutterPlugin>) NachoPlugin.class)).sendLifecycleEvent(this.f22947d, "onStop", this.f22948e, (Map<String, String>) null, getNachoParams());
        if (Nacho.getInstance().getTopContainer() != this) {
            z = true;
        }
        this.f22951h = z;
    }

    public void fixRenderer() {
        FlutterEngine flutterEngine = getFlutterEngine();
        if (flutterEngine == null) {
            Nacho.logger().debug("fixRenderer:: Flutter Engine is no longer available, fixRenderer can't be execute", new Object[0]);
            return;
        }
        Logger logger = Nacho.logger();
        logger.debug("fixRenderer:" + this + ",renderSurface:" + this.f22949f + ",render:" + flutterEngine.getRenderer(), new Object[0]);
        RenderSurface renderSurface = this.f22949f;
        if ((renderSurface != null && renderSurface.getAttachedRenderer() == null) || !this.f22949f.getAttachedRenderer().isDisplayingFlutterUi()) {
            this.f22949f.attachToRenderer(flutterEngine.getRenderer());
        }
        flutterEngine.getLifecycleChannel().appIsResumed();
    }

    /* renamed from: a */
    private void m18941a(FlutterEngine flutterEngine) {
        PlatformChannel.PlatformMessageHandler platformMessageHandler = (PlatformChannel.PlatformMessageHandler) f22944a.get();
        if (platformMessageHandler != null && flutterEngine != null) {
            try {
                flutterEngine.getPlatformChannel().setPlatformMessageHandler(platformMessageHandler);
                Logger logger = Nacho.logger();
                logger.debug("fixPlatformMessageHandler:" + platformMessageHandler, new Object[0]);
            } catch (Exception e) {
                Nacho.logger().error("get platformMessageHandler error", (Throwable) e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        Logger logger = Nacho.logger();
        logger.debug("onPause:" + this, new Object[0]);
        super.onPause();
        ((NachoPlugin) Nacho.getInstance().getPlugin(getFlutterEngine(), (Class<? extends FlutterPlugin>) NachoPlugin.class)).sendLifecycleEvent(this.f22947d, "onPause", this.f22948e, (Map<String, String>) null, getNachoParams());
    }

    public void onFlutterSurfaceViewCreated(FlutterSurfaceView flutterSurfaceView) {
        super.onFlutterSurfaceViewCreated(flutterSurfaceView);
        this.f22949f = flutterSurfaceView;
        Logger logger = Nacho.logger();
        logger.debug("onFlutterSurfaceViewCreated:" + this + ",renderSurface:" + this.f22949f, new Object[0]);
    }

    public void onFlutterTextureViewCreated(FlutterTextureView flutterTextureView) {
        super.onFlutterTextureViewCreated(flutterTextureView);
        this.f22949f = flutterTextureView;
        Logger logger = Nacho.logger();
        logger.debug("onFlutterTextureViewCreated:" + this + ",renderSurface:" + this.f22949f, new Object[0]);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Logger logger = Nacho.logger();
        logger.debug("onDestroy:" + this, new Object[0]);
        if (!this.f22950g) {
            ((NachoPlugin) Nacho.getInstance().getPlugin(getFlutterEngine(), (Class<? extends FlutterPlugin>) NachoPlugin.class)).sendLifecycleEvent(this.f22947d, NachoLifecycleManager.LIFECYCLE_ON_DESTROY, this.f22948e, (Map<String, String>) null, (Map<String, String>) null);
        }
        FlutterEngine flutterEngine = getFlutterEngine();
        super.onDestroy();
        m18941a(flutterEngine);
        m18940a();
    }

    /* renamed from: a */
    private void m18940a() {
        INachoApp topContainer = Nacho.getInstance().getTopContainer();
        if (topContainer != null) {
            topContainer.fixRenderer();
        }
    }

    public String toString() {
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra(Page.TAG_ROUTER_NAME) : "";
        return super.toString() + " [pageId=" + this.f22947d + ",routerName=" + stringExtra + Const.jaRight;
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        Activity topActivity;
        Logger logger = Nacho.logger();
        logger.debug("onRestart:" + this, new Object[0]);
        super.onRestart();
        if (this.f22951h && (topActivity = Nacho.getInstance().getTopActivity()) != this && (topActivity instanceof NachoFlutterActivity)) {
            ((NachoPlugin) Nacho.getInstance().getPlugin(this.f22948e, (Class<? extends FlutterPlugin>) NachoPlugin.class)).sendLifecycleEvent(((NachoFlutterActivity) topActivity).f22947d, "onRestart", this.f22948e, (Map<String, String>) null, (Map<String, String>) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(f22945b, this.f22947d);
        bundle.putString(f22946c, this.f22948e);
        this.f22950g = true;
        super.onSaveInstanceState(bundle);
    }

    public String getPageId() {
        return this.f22947d;
    }
}
