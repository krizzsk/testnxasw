package com.didi.flutter.nacho;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.didi.sdk.logging.Logger;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import p218io.flutter.embedding.android.FlutterFragment2;
import p218io.flutter.embedding.android.FlutterSurfaceView;
import p218io.flutter.embedding.android.FlutterTextureView;
import p218io.flutter.embedding.engine.FlutterEngine;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;
import p218io.flutter.embedding.engine.renderer.RenderSurface;
import p218io.flutter.embedding.engine.systemchannels.PlatformChannel;
import p218io.flutter.plugin.platform.PlatformPlugin;

public class NachoFlutterFragment extends FlutterFragment2 implements INachoApp {

    /* renamed from: a */
    private String f22953a;

    /* renamed from: b */
    private String f22954b;

    /* renamed from: c */
    private RenderSurface f22955c;

    /* renamed from: e */
    private boolean f22956e = false;

    /* renamed from: f */
    private PlatformChannel.PlatformMessageHandler f22957f;

    public String getCachedEngineId() {
        return null;
    }

    public boolean shouldDestroyEngineWithHost() {
        return false;
    }

    public void onAttach(Context context) {
        String string = getArguments().getString(INachoApp.ENGINE_ID);
        this.f22954b = string;
        if (TextUtils.isEmpty(string)) {
            this.f22954b = Nacho.getInstance().getDefaultEngineId();
        }
        super.onAttach(context);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f22953a = SystemClock.uptimeMillis() + "@" + Integer.toHexString(hashCode());
        HashMap hashMap = new HashMap();
        hashMap.put("initial_route", getInitialRoute());
        ((NachoPlugin) Nacho.getInstance().getPlugin(getFlutterEngine(), (Class<? extends FlutterPlugin>) NachoPlugin.class)).sendLifecycleEvent(this.f22953a, NachoLifecycleManager.LIFECYCLE_ON_CREATE, this.f22954b, hashMap, getParams());
        Nacho.getInstance().addFlutterFragment(getActivity(), this.f22953a, this);
    }

    public Map getParams() {
        return (Map) getArguments().getSerializable(NachoFlutterActivity.PARAMS);
    }

    public void onStart() {
        Logger logger = Nacho.logger();
        logger.debug("onStart:" + this, new Object[0]);
        super.onStart();
        NachoPlugin nachoPlugin = (NachoPlugin) Nacho.getInstance().getPlugin(getFlutterEngine(), (Class<? extends FlutterPlugin>) NachoPlugin.class);
        nachoPlugin.sendLifecycleEvent(this.f22953a, "onStart", this.f22954b, (Map<String, String>) null, (Map<String, String>) null);
        if (this.f22956e) {
            Activity topActivity = Nacho.getInstance().getTopActivity();
            if (topActivity instanceof NachoFlutterActivity) {
                nachoPlugin.sendLifecycleEvent(((NachoFlutterActivity) topActivity).getPageId(), "onRestart", this.f22954b, (Map<String, String>) null, (Map<String, String>) null);
            }
        }
    }

    public FlutterEngine provideFlutterEngine(Context context) {
        return Nacho.getInstance().getEngine(this.f22954b);
    }

    public PlatformPlugin providePlatformPlugin(Activity activity, FlutterEngine flutterEngine) {
        PlatformPlugin providePlatformPlugin = super.providePlatformPlugin(activity, flutterEngine);
        try {
            PlatformChannel platformChannel = flutterEngine.getPlatformChannel();
            Field declaredField = platformChannel.getClass().getDeclaredField("platformMessageHandler");
            declaredField.setAccessible(true);
            this.f22957f = (PlatformChannel.PlatformMessageHandler) declaredField.get(platformChannel);
            PrintStream printStream = System.out;
            printStream.println("======providePlatformPlugin======:" + this.f22957f);
        } catch (Exception e) {
            Nacho.logger().error("get platformMessageHandler error", (Throwable) e);
        }
        return providePlatformPlugin;
    }

    public void onResume() {
        Logger logger = Nacho.logger();
        logger.debug("onResume:" + this, new Object[0]);
        super.onResume();
        ((NachoPlugin) Nacho.getInstance().getPlugin(getFlutterEngine(), (Class<? extends FlutterPlugin>) NachoPlugin.class)).sendLifecycleEvent(this.f22953a, "onResume", this.f22954b, (Map<String, String>) null, (Map<String, String>) null);
        NachoFlutterActivity.f22944a = new WeakReference<>(this.f22957f);
        m18942a(getFlutterEngine());
    }

    public void onStop() {
        Logger logger = Nacho.logger();
        boolean z = false;
        logger.debug("onStop:" + this + " isFinishing:" + ((FragmentActivity) Objects.requireNonNull(getActivity())).isFinishing(), new Object[0]);
        if (NachoFlutterActivity.f22944a != null && NachoFlutterActivity.f22944a.get() == this.f22957f) {
            NachoFlutterActivity.f22944a.clear();
        }
        super.onStop();
        m18943c();
        ((NachoPlugin) Nacho.getInstance().getPlugin(getFlutterEngine(), (Class<? extends FlutterPlugin>) NachoPlugin.class)).sendLifecycleEvent(this.f22953a, "onStop", this.f22954b, (Map<String, String>) null, (Map<String, String>) null);
        if (getActivity() != null && !getActivity().isFinishing()) {
            if (Nacho.getInstance().getTopContainer() != this) {
                z = true;
            }
            this.f22956e = z;
        }
    }

    public void fixRenderer() {
        FlutterEngine flutterEngine = getFlutterEngine();
        if (flutterEngine == null) {
            Nacho.logger().debug("fixRenderer:: Flutter Engine is no longer available, fixRenderer can't be execute", new Object[0]);
            return;
        }
        Logger logger = Nacho.logger();
        logger.debug("fixRenderer:" + this + ",renderSurface:" + this.f22955c + ",render:" + flutterEngine.getRenderer(), new Object[0]);
        RenderSurface renderSurface = this.f22955c;
        if ((renderSurface != null && renderSurface.getAttachedRenderer() == null) || !this.f22955c.getAttachedRenderer().isDisplayingFlutterUi()) {
            this.f22955c.attachToRenderer(flutterEngine.getRenderer());
        }
        flutterEngine.getLifecycleChannel().appIsResumed();
    }

    /* renamed from: a */
    private void m18942a(FlutterEngine flutterEngine) {
        PlatformChannel.PlatformMessageHandler platformMessageHandler = (PlatformChannel.PlatformMessageHandler) NachoFlutterActivity.f22944a.get();
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

    public void onPause() {
        Logger logger = Nacho.logger();
        logger.debug("onPause:" + this, new Object[0]);
        super.onPause();
        ((NachoPlugin) Nacho.getInstance().getPlugin(getFlutterEngine(), (Class<? extends FlutterPlugin>) NachoPlugin.class)).sendLifecycleEvent(this.f22953a, "onPause", this.f22954b, (Map<String, String>) null, (Map<String, String>) null);
    }

    public void onFlutterSurfaceViewCreated(FlutterSurfaceView flutterSurfaceView) {
        super.onFlutterSurfaceViewCreated(flutterSurfaceView);
        this.f22955c = flutterSurfaceView;
        Logger logger = Nacho.logger();
        logger.debug("onFlutterSurfaceViewCreated:" + this + ",renderSurface:" + this.f22955c, new Object[0]);
    }

    public void onFlutterTextureViewCreated(FlutterTextureView flutterTextureView) {
        super.onFlutterTextureViewCreated(flutterTextureView);
        this.f22955c = flutterTextureView;
        Logger logger = Nacho.logger();
        logger.debug("onFlutterTextureViewCreated:" + this + ",renderSurface:" + this.f22955c, new Object[0]);
    }

    public void onDestroy() {
        Logger logger = Nacho.logger();
        logger.debug("onDestroy:" + this, new Object[0]);
        ((NachoPlugin) Nacho.getInstance().getPlugin(getFlutterEngine(), (Class<? extends FlutterPlugin>) NachoPlugin.class)).sendLifecycleEvent(this.f22953a, NachoLifecycleManager.LIFECYCLE_ON_DESTROY, this.f22954b, (Map<String, String>) null, (Map<String, String>) null);
        FlutterEngine flutterEngine = getFlutterEngine();
        super.onDestroy();
        Nacho.getInstance().removeFlutterFragment(getActivity(), this);
        m18942a(flutterEngine);
        m18943c();
    }

    /* renamed from: c */
    private void m18943c() {
        INachoApp topContainer = Nacho.getInstance().getTopContainer();
        if (topContainer != null && !(topContainer instanceof NachoFlutterFragment)) {
            topContainer.fixRenderer();
        }
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        RenderSurface renderSurface = this.f22955c;
        if (renderSurface instanceof FlutterSurfaceView) {
            ((FlutterSurfaceView) renderSurface).setVisibility(z ? 8 : 0);
        }
    }

    public String toString() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(Page.TAG_ROUTER_NAME) : "";
        return super.toString() + " [pageId=" + this.f22953a + ",routerName=" + string + Const.jaRight;
    }

    public static CachedEngineFragmentBuilder2 withCachedEngine(Class<? extends FlutterFragment2> cls) {
        return new CachedEngineFragmentBuilder2(cls);
    }

    public static class CachedEngineFragmentBuilder2 extends FlutterFragment2.NewEngineFragmentBuilder {
        private String engineId = (SystemClock.uptimeMillis() + "@" + Integer.toHexString(hashCode()));
        private final Class<? extends FlutterFragment2> fragmentClass;
        private HashMap params;
        private int theme;

        protected CachedEngineFragmentBuilder2(Class<? extends FlutterFragment2> cls) {
            super(cls);
            this.fragmentClass = cls;
        }

        public CachedEngineFragmentBuilder2 engineId(String str) {
            this.engineId = str;
            return this;
        }

        public CachedEngineFragmentBuilder2 params(HashMap hashMap) {
            this.params = hashMap;
            return this;
        }

        public CachedEngineFragmentBuilder2 theme(int i) {
            this.theme = i;
            return this;
        }

        public <T extends FlutterFragment2> T build() {
            try {
                T t = (FlutterFragment2) this.fragmentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (t != null) {
                    Bundle createArgs = createArgs();
                    createArgs.putString(INachoApp.ENGINE_ID, this.engineId);
                    t.setArguments(createArgs);
                    return t;
                }
                throw new RuntimeException("The FlutterFragment2 subclass sent in the constructor (" + NachoFlutterFragment.class.getCanonicalName() + ") does not match the expected return type.");
            } catch (Exception e) {
                throw new RuntimeException("Could not instantiate FlutterFragment2 subclass (" + NachoFlutterFragment.class.getName() + ")", e);
            }
        }
    }
}
