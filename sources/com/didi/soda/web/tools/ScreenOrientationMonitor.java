package com.didi.soda.web.tools;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.didi.sdk.apm.SystemUtils;

public class ScreenOrientationMonitor {

    /* renamed from: a */
    private static final int f46484a = 0;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Activity f46485b;

    /* renamed from: c */
    private RotationObserver f46486c;

    /* renamed from: d */
    private boolean f46487d = false;

    public ScreenOrientationMonitor(Activity activity) {
        this.f46485b = activity;
        this.f46486c = new RotationObserver(new Handler());
    }

    public void setH5ScreenOrientationSetting(boolean z) {
        this.f46487d = z;
        updateActivityOrientation(false);
    }

    public void onCreate() {
        this.f46486c.startObserver();
    }

    public void onDestroy() {
        this.f46486c.stopObserver();
    }

    private class RotationObserver extends ContentObserver {
        ContentResolver mResolver;

        public RotationObserver(Handler handler) {
            super(handler);
            this.mResolver = ScreenOrientationMonitor.this.f46485b.getContentResolver();
        }

        public void onChange(boolean z) {
            super.onChange(z);
            ScreenOrientationMonitor.this.updateActivityOrientation(false);
        }

        public void startObserver() {
            this.mResolver.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this);
        }

        public void stopObserver() {
            this.mResolver.unregisterContentObserver(this);
        }
    }

    public void updateActivityOrientation(boolean z) {
        if (z) {
            SystemUtils.hookSetRequestedOrientation(this.f46485b, 1);
        } else if (!this.f46487d || m34650a((Context) this.f46485b) == 0) {
            SystemUtils.hookSetRequestedOrientation(this.f46485b, 1);
        } else {
            SystemUtils.hookSetRequestedOrientation(this.f46485b, 10);
        }
    }

    /* renamed from: a */
    private int m34650a(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
