package com.didi.flutter.nacho;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.flutter.nacho.Default;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p218io.flutter.embedding.engine.FlutterEngine;
import p218io.flutter.embedding.engine.FlutterEngineCache;
import p218io.flutter.embedding.engine.FlutterEngineGroup;
import p218io.flutter.embedding.engine.dart.DartExecutor;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;

public class Nacho {
    public static final String DEFAULT_ENGINE_ID = "_NACHO_ENGINE";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Nacho f22935a = new Nacho();

    /* renamed from: b */
    private Configuration f22936b;

    /* renamed from: c */
    private FlutterEngineGroup f22937c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Logger f22938d = LoggerFactory.getLogger("Nacho");
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f22939e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public WeakReference<Activity> f22940f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final LinkedList<WeakReference<Activity>> f22941g = new LinkedList<>();

    /* renamed from: h */
    private final Map<Activity, LinkedList<NachoFlutterFragment>> f22942h = new HashMap();

    /* renamed from: i */
    private boolean f22943i = false;

    public enum LaunchMode {
        Immediate,
        Idle,
        Requirement
    }

    public String getDefaultEngineId() {
        return DEFAULT_ENGINE_ID;
    }

    public void addEngineOption(EngineOption engineOption) {
        this.f22936b.addEngineOption(engineOption);
    }

    @Deprecated
    public FlutterEngine engine() {
        return getEngine(DEFAULT_ENGINE_ID);
    }

    private Nacho() {
    }

    public static Logger logger() {
        return f22935a.f22938d;
    }

    public static Nacho getInstance() {
        return f22935a;
    }

    public static Router Router() {
        return f22935a.f22936b.f62468router;
    }

    public static Configuration beginConfig(Application application) {
        return new Configuration(application);
    }

    public FlutterEngine getEngine() {
        return getEngine(DEFAULT_ENGINE_ID);
    }

    public NativeInfoFetcher nativeInfoFetcher() {
        return this.f22936b.nativeInfoFetcher;
    }

    public boolean isEngineStarted() {
        return this.f22943i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18932a(Configuration configuration) {
        this.f22936b = configuration;
        Logger logger = this.f22938d;
        logger.info("try init flutter engine,release:true,launchMode:" + this.f22936b.launchMode, new Object[0]);
        if (this.f22936b.launchMode == LaunchMode.Immediate) {
            getEngine(DEFAULT_ENGINE_ID);
        } else if (this.f22936b.launchMode == LaunchMode.Idle) {
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                public boolean queueIdle() {
                    Nacho.this.getEngine(Nacho.DEFAULT_ENGINE_ID);
                    return false;
                }
            });
        }
        configuration.context.registerActivityLifecycleCallbacks(new Default.ActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                Logger a = Nacho.this.f22938d;
                a.info("Nacho:: onActivityCreated ::" + activity, new Object[0]);
                String stringExtra = activity.getIntent().getStringExtra(Page.TAG_ROUTER_NAME);
                if (stringExtra != null) {
                    int intExtra = activity.getIntent().getIntExtra(Page.TAG_LAUNCH_MODE, 0);
                    int size = Nacho.this.f22941g.size();
                    for (int i = 0; i < size; i++) {
                        final Activity activity2 = (Activity) ((WeakReference) Nacho.this.f22941g.get(i)).get();
                        if (activity2 != null && intExtra == 1 && stringExtra.equals(activity2.getIntent().getStringExtra(Page.TAG_ROUTER_NAME))) {
                            new Handler().post(new Runnable() {
                                public void run() {
                                    activity2.finish();
                                }
                            });
                        }
                    }
                }
                Nacho.this.f22941g.add(new WeakReference(activity));
            }

            public void onActivityResumed(Activity activity) {
                Logger a = Nacho.this.f22938d;
                a.info("Nacho:: onActivityResumed ::" + activity, new Object[0]);
                WeakReference unused = Nacho.this.f22940f = new WeakReference(activity);
                if (Nacho.this.m18934a(activity)) {
                    boolean unused2 = Nacho.this.f22939e = false;
                }
            }

            public void onActivityPaused(Activity activity) {
                Logger a = Nacho.this.f22938d;
                a.info("Nacho:: onActivityPaused ::" + activity, new Object[0]);
                if (Nacho.this.f22940f != null && Nacho.this.f22940f.get() == activity) {
                    Nacho.this.f22940f.clear();
                    WeakReference unused = Nacho.this.f22940f = null;
                }
            }

            public void onActivityDestroyed(Activity activity) {
                Logger a = Nacho.this.f22938d;
                a.info("Nacho:: onActivityDestroyed ::" + activity, new Object[0]);
                int size = Nacho.this.f22941g.size();
                for (int i = 0; i < size; i++) {
                    if (((WeakReference) Nacho.this.f22941g.get(i)).get() == activity) {
                        Nacho.this.f22941g.remove(i);
                        return;
                    }
                }
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                Logger a = Nacho.this.f22938d;
                a.info("Nacho:: onActivitySaveInstanceState ::" + activity, new Object[0]);
                super.onActivitySaveInstanceState(activity, bundle);
            }
        });
        this.f22943i = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m18934a(Activity activity) {
        return activity instanceof NachoFlutterActivity;
    }

    public FlutterEngine getEngine(String str) {
        FlutterEngine flutterEngine;
        if (!TextUtils.isEmpty(str)) {
            FlutterEngineCache instance = FlutterEngineCache.getInstance();
            synchronized (instance) {
                FlutterEngine flutterEngine2 = instance.get(str);
                if (flutterEngine2 != null) {
                    return flutterEngine2;
                }
                this.f22936b.flutterEngineLifecycleListener.onPreStart(this.f22936b.context, str);
                EngineOption engineOption = this.f22936b.getEngineOption(str);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("createByGroup", engineOption.f22934d);
                    jSONObject.put("engineId", engineOption.f22932b);
                    engineOption.addArg(jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (engineOption.f22934d) {
                    m18938b();
                    FlutterEngineGroup.Options options = new FlutterEngineGroup.Options(this.f22936b.context);
                    options.setDartEntrypointArgs(engineOption.f22933c);
                    flutterEngine = this.f22937c.createAndRunEngine(options);
                } else {
                    flutterEngine = new FlutterEngine(this.f22936b.context);
                    flutterEngine.getDartExecutor().executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault(), engineOption.f22933c);
                }
                if (engineOption.f22931a) {
                    flutterEngine.getDartExecutor().getBinaryMessenger().enableBufferingIncomingMessages();
                }
                instance.put(str, flutterEngine);
                ((NachoPlugin) getInstance().getPlugin(flutterEngine, (Class<? extends FlutterPlugin>) NachoPlugin.class)).onPluginRegistered(flutterEngine);
                this.f22936b.flutterEngineLifecycleListener.onPostStart(this.f22936b.context, str);
                return flutterEngine;
            }
        }
        throw new IllegalArgumentException("engineId can't be null");
    }

    /* renamed from: b */
    private synchronized void m18938b() {
        if (this.f22937c == null) {
            this.f22937c = new FlutterEngineGroup(this.f22936b.context);
        }
    }

    public INachoApp getTopContainer() {
        Activity topActivity = getTopActivity();
        if (topActivity instanceof INachoApp) {
            return (INachoApp) topActivity;
        }
        if (!(topActivity instanceof FragmentActivity)) {
            return null;
        }
        LinkedList<NachoFlutterFragment> fragmentList = getFragmentList(topActivity);
        if (fragmentList.isEmpty()) {
            return null;
        }
        Iterator it = fragmentList.iterator();
        while (it.hasNext()) {
            NachoFlutterFragment nachoFlutterFragment = (NachoFlutterFragment) it.next();
            if (nachoFlutterFragment != null && nachoFlutterFragment.isVisible()) {
                return nachoFlutterFragment;
            }
        }
        return null;
    }

    public boolean isPaddingOpenContainer() {
        return this.f22939e;
    }

    public void paddingOpenContainer() {
        this.f22939e = true;
    }

    public Context getContext() {
        return this.f22936b.context;
    }

    public static class Configuration {
        /* access modifiers changed from: private */
        public Application context;
        /* access modifiers changed from: private */
        public FlutterEngineLifecycleListener flutterEngineLifecycleListener = new Default.DefaultFlutterEngineLifecycleListener();
        /* access modifiers changed from: private */
        public LaunchMode launchMode = LaunchMode.Immediate;
        /* access modifiers changed from: private */
        public NativeInfoFetcher nativeInfoFetcher = new Default.DefaultNativeInfoFetcher();
        private Map<String, EngineOption> optionMap = new HashMap();
        /* access modifiers changed from: private */

        /* renamed from: router  reason: collision with root package name */
        public Router f62468router = new Default.DefaultRouter();

        public Configuration(Application application) {
            this.context = application;
        }

        public void init() {
            Nacho.f22935a.m18932a(this);
        }

        public Configuration lifecycleListener(FlutterEngineLifecycleListener flutterEngineLifecycleListener2) {
            if (flutterEngineLifecycleListener2 != null) {
                this.flutterEngineLifecycleListener = flutterEngineLifecycleListener2;
            }
            return this;
        }

        public Configuration router(Router router2) {
            this.f62468router = router2;
            return this;
        }

        public Configuration nativeInfoFetcher(NativeInfoFetcher nativeInfoFetcher2) {
            this.nativeInfoFetcher = nativeInfoFetcher2;
            return this;
        }

        public Configuration setLaunchMode(LaunchMode launchMode2) {
            this.launchMode = launchMode2;
            return this;
        }

        public Configuration addEngineOption(EngineOption engineOption) {
            this.optionMap.put(engineOption.f22932b, engineOption);
            return this;
        }

        public EngineOption getEngineOption(String str) {
            EngineOption engineOption = this.optionMap.get(str);
            return engineOption == null ? new EngineOption(str) : engineOption;
        }
    }

    public Activity getTopActivity() {
        if (this.f22940f == null && this.f22941g.size() > 0) {
            this.f22940f = this.f22941g.getLast();
        }
        WeakReference<Activity> weakReference = this.f22940f;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public <T extends FlutterPlugin> T getPlugin(Class<? extends FlutterPlugin> cls) {
        return getPlugin(getEngine(), cls);
    }

    public <T extends FlutterPlugin> T getPlugin(FlutterEngine flutterEngine, Class<? extends FlutterPlugin> cls) {
        return flutterEngine.getPlugins().get(cls);
    }

    public <T extends FlutterPlugin> T getPlugin(String str, Class<? extends FlutterPlugin> cls) {
        return FlutterEngineCache.getInstance().get(str).getPlugins().get(cls);
    }

    public NachoPlugin getNachoPlugin() {
        return (NachoPlugin) getPlugin(NachoPlugin.class);
    }

    public NachoPlugin getNachoPlugin(FlutterEngine flutterEngine) {
        return (NachoPlugin) getPlugin(flutterEngine, (Class<? extends FlutterPlugin>) NachoPlugin.class);
    }

    public boolean isFlutterOnTop() {
        Fragment findFragmentByTag;
        if (getTopContainer() != null) {
            return true;
        }
        Activity topActivity = getTopActivity();
        if (!(topActivity instanceof FragmentActivity) || (findFragmentByTag = ((FragmentActivity) topActivity).getSupportFragmentManager().findFragmentByTag(Default.TAG_BOTTOM_DIALOG)) == null || !findFragmentByTag.isResumed() || !findFragmentByTag.isVisible()) {
            return false;
        }
        return true;
    }

    public boolean dismissFlutterDialog() {
        boolean z = false;
        for (int size = this.f22941g.size() - 1; size >= 0; size--) {
            Activity activity = (Activity) this.f22941g.get(size).get();
            if (activity instanceof FragmentActivity) {
                Fragment findFragmentByTag = ((FragmentActivity) activity).getSupportFragmentManager().findFragmentByTag(Default.TAG_BOTTOM_DIALOG);
                if (findFragmentByTag instanceof DialogFragment) {
                    try {
                        ((DialogFragment) findFragmentByTag).dismissAllowingStateLoss();
                        z = true;
                    } catch (Exception e) {
                        logger().error("dismissFlutterDialog error", (Throwable) e);
                    }
                }
            }
        }
        return z;
    }

    public LinkedList<NachoFlutterFragment> getFragmentList(Activity activity) {
        LinkedList<NachoFlutterFragment> linkedList = this.f22942h.get(activity);
        if (linkedList != null) {
            return linkedList;
        }
        LinkedList<NachoFlutterFragment> linkedList2 = new LinkedList<>();
        this.f22942h.put(activity, linkedList2);
        return linkedList2;
    }

    public void addFlutterFragment(Activity activity, String str, NachoFlutterFragment nachoFlutterFragment) {
        getFragmentList(activity).add(nachoFlutterFragment);
    }

    public void removeFlutterFragment(Activity activity, NachoFlutterFragment nachoFlutterFragment) {
        getFragmentList(activity).remove(nachoFlutterFragment);
    }
}
