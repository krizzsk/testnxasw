package com.didi.component.common.util;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

public class AppForegroundTracker {
    public static final int STATE_BACKGROUND = 1;
    public static final int STATE_FOREGROUND = 0;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static boolean f13586a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static int f13587b;

    public interface AppStateChangeListener {
        void appTurnIntoBackGround();

        void appTurnIntoForeground();
    }

    public static boolean isAppTurnInfoForeground() {
        return f13586a;
    }

    public static int getCurrentState() {
        return f13587b;
    }

    public static void track(Application application, final AppStateChangeListener appStateChangeListener) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            private int resumeActivityCount = 0;

            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            public void onActivityDestroyed(Activity activity) {
            }

            public void onActivityPaused(Activity activity) {
            }

            public void onActivityResumed(Activity activity) {
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityStarted(Activity activity) {
                if (this.resumeActivityCount == 0) {
                    boolean unused = AppForegroundTracker.f13586a = true;
                    int unused2 = AppForegroundTracker.f13587b = 0;
                    AppStateChangeListener appStateChangeListener = AppStateChangeListener.this;
                    if (appStateChangeListener != null) {
                        appStateChangeListener.appTurnIntoForeground();
                    }
                }
                this.resumeActivityCount++;
            }

            public void onActivityStopped(Activity activity) {
                this.resumeActivityCount--;
                boolean unused = AppForegroundTracker.f13586a = false;
                if (this.resumeActivityCount == 0) {
                    int unused2 = AppForegroundTracker.f13587b = 1;
                    AppStateChangeListener appStateChangeListener = AppStateChangeListener.this;
                    if (appStateChangeListener != null) {
                        appStateChangeListener.appTurnIntoBackGround();
                    }
                }
            }
        });
    }
}
