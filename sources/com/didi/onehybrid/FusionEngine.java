package com.didi.onehybrid;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.onehybrid.BusinessAgent;
import com.didi.onehybrid.container.FusionWebView;
import com.didi.onehybrid.internalmodules.HttpModule;
import com.didi.onehybrid.internalmodules.StaticModule;
import com.didi.onehybrid.internalmodules.TraceModule;
import com.didi.onehybrid.jsbridge.WebViewJavascriptBridge;
import com.didi.onehybrid.resource.FusionCacheClient;
import com.didi.onehybrid.resource.FusionResourceManager;
import com.didi.onehybrid.resource.offline.OfflineBundleManager;
import com.didi.onehybrid.util.NetworkUtil;
import java.util.List;
import java.util.Map;

public class FusionEngine {

    /* renamed from: a */
    private static final String f31950a = "FusionEngine";

    /* renamed from: b */
    private static volatile boolean f31951b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static volatile boolean f31952c = false;

    /* renamed from: d */
    private static volatile boolean f31953d = false;

    /* renamed from: e */
    private static final Object f31954e = new Object();

    /* renamed from: f */
    private static Application f31955f;

    /* renamed from: g */
    private static BusinessAgent f31956g;

    /* renamed from: h */
    private static Map<String, Object> f31957h;

    public static void init(Context context) {
        if (f31955f == null && context != null) {
            f31955f = (Application) context.getApplicationContext();
        }
    }

    public static void init(Application application, FusionInitConfig fusionInitConfig) {
        synchronized (f31954e) {
            if (!f31951b) {
                f31955f = application;
                f31956g = fusionInitConfig.getBusinessAgent();
                f31957h = fusionInitConfig.getExtraAttrsMap();
                if (f31956g != null) {
                    FusionCacheClient.init(application);
                    OfflineBundleManager.init(application, fusionInitConfig);
                    if (OfflineBundleManager.isInitialized()) {
                        OfflineBundleManager.getInstance().registerEventListener();
                    }
                    m24379a();
                    f31951b = true;
                }
            }
        }
    }

    public static void preloadWebView(Context context) {
        BusinessAgent businessAgent = f31956g;
        if (businessAgent != null && businessAgent.needPreInitWebView() && !f31952c) {
            m24380a(context);
        }
    }

    public static void startUp() {
        BusinessAgent businessAgent = f31956g;
        if (businessAgent != null && businessAgent.isOfflineOpen() && OfflineBundleManager.getInstance() != null) {
            OfflineBundleManager.getInstance().getBundleInfo();
        }
    }

    /* renamed from: a */
    private static void m24379a() {
        export("StaticModule", StaticModule.class);
        export("HttpModule", HttpModule.class);
        export("TraceModule", TraceModule.class);
    }

    /* renamed from: a */
    private static void m24380a(final Context context) {
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            public boolean queueIdle() {
                try {
                    new FusionWebView(context).destroy();
                    boolean unused = FusionEngine.f31952c = true;
                } catch (Exception unused2) {
                    boolean unused3 = FusionEngine.f31952c = false;
                }
                return false;
            }
        });
    }

    public static BusinessAgent getBusinessAgent() {
        if (f31956g == null) {
            f31956g = new BusinessAgent.DummyBusinessAgent(f31955f);
        }
        return f31956g;
    }

    public static Application getApplication() {
        return f31955f;
    }

    public static Object getAttr(String str) {
        Map<String, Object> map = f31957h;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public static void export(String str, Class cls) {
        WebViewJavascriptBridge.export(str, cls);
    }

    public static boolean isWebViewPreInited() {
        return f31952c;
    }

    public static void preloadResource(Context context) {
        List<String> preloadUrlList;
        if (!f31953d && (preloadUrlList = getBusinessAgent().getPreloadUrlList()) != null && !preloadUrlList.isEmpty()) {
            f31953d = true;
            FusionResourceManager.preloadResources(context, preloadUrlList);
        }
    }

    static class NetworkChangedReceiver extends BroadcastReceiver {
        NetworkChangedReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (NetworkUtil.isNetworkWifi(context)) {
                FusionEngine.preloadResource(context);
            }
        }
    }

    public static void notifyDownloadBundle(String str) {
        Intent intent = new Intent("fusion_offline_event");
        Bundle bundle = new Bundle();
        bundle.putString("fusion_offline_event_type", "1");
        bundle.putString("1", str);
        intent.putExtras(bundle);
        LocalBroadcastManager.getInstance(f31955f).sendBroadcast(intent);
    }
}
