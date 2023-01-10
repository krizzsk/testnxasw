package com.didi.sdk.app.mainactivitydelegate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.didi.address.TransparentStatusBarManager;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.remotereslibrary.RemoteResourceManager;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.delegate.ActivityDelegate;
import com.didi.sdk.log.Logger;
import com.didi.sdk.map.LocateKeeperImpl;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.misconfig.p154v2.ConfProxy;
import com.didi.sdk.oneconf.OneConfData;
import com.didi.sdk.oneconf.OneConfStore;
import com.didi.sdk.util.EventKeys;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.taxis99.R;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;

@ServiceProvider({ActivityDelegate.class})
public class MainActivityDelegate extends ActivityDelegate {

    /* renamed from: a */
    OneConfStore.OneConfConfigChangeListener f38000a = new OneConfStore.OneConfConfigChangeListener() {
        public void onChanged(OneConfData oneConfData, double d, double d2) {
            if (ConfProxy.getInstance().getCityId() != OneConfStore.getInstance().getCityId()) {
                EventBus.getDefault().post(new Pair(EventKeys.MisConfig.REFRESH_MIS, 0));
            }
        }
    };

    /* renamed from: b */
    TransparentStatusBarManager.OnStatusBarTransparentListener f38001b = new TransparentStatusBarManager.OnStatusBarTransparentListener() {
        public void OnStartusBarTransparent(Activity activity) {
            activity.setTheme(R.style.GlobalActivityTheme);
            StatusBarLightingCompat.setStatusBarBgLightning(activity, true, MainActivityDelegate.this.f38002c.getResources().getColor(R.color.common_status_background));
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f38002c;

    /* renamed from: d */
    private ActivityLifecycleManager.AppStateListener f38003d = new ActivityLifecycleManager.AppStateListener() {
        private static final int DELAY = 3;
        /* access modifiers changed from: private */
        public volatile boolean isBackground = false;
        LocationPerformer locationPerformer = LocationPerformer.getInstance();
        private final Runnable taskLocationChanged = new Runnable() {
            public void run() {
                if (C128451.this.locationPerformer != null && MainActivityDelegate.this.f38002c != null && C128451.this.isBackground) {
                    Logger.easylog("location", "stop locate");
                    C128451.this.locationPerformer.stop(MainActivityDelegate.this.f38002c);
                }
            }
        };
        private ScheduledExecutorService worker;

        public void onStateChanged(int i) {
            doLocationAppStateChanged(i);
        }

        private void doLocationAppStateChanged(int i) {
            if (i == 1) {
                this.isBackground = false;
                ScheduledExecutorService scheduledExecutorService = this.worker;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                }
                if (this.locationPerformer != null && MainActivityDelegate.this.f38002c != null) {
                    Logger.easylog("location", "start locate");
                    this.locationPerformer.start(MainActivityDelegate.this.f38002c);
                    return;
                }
                return;
            }
            this.isBackground = true;
            if (!LocateKeeperImpl.getInstance().keepLocate()) {
                ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
                this.worker = newSingleThreadScheduledExecutor;
                newSingleThreadScheduledExecutor.schedule(this.taskLocationChanged, 3, TimeUnit.SECONDS);
            }
        }
    };

    public void onStart(Activity activity) {
        super.onStart(activity);
    }

    public void onResume(Activity activity) {
        super.onResume(activity);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    public void onCreate(Activity activity) {
        super.onCreate(activity);
        this.f38002c = activity;
        RemoteResourceManager.getInstance().pullRemoteResource(0.0d, 0.0d);
        ActivityLifecycleManager.getInstance().addAppStateListener(this.f38003d);
        OneConfStore.getInstance().addOneConfChangeListener(this.f38000a);
        TransparentStatusBarManager.getInstance().setOnStatusBarTransparentListener(this.f38001b);
    }

    public void onStop(Activity activity) {
        super.onStop(activity);
    }

    public void onPause(Activity activity) {
        super.onPause(activity);
    }

    public void onDestroy(Activity activity) {
        super.onDestroy(activity);
        ActivityLifecycleManager.getInstance().removeAppStateListener(this.f38003d);
        OneConfStore.getInstance().removeOneConfChangeListener(this.f38000a);
    }
}
