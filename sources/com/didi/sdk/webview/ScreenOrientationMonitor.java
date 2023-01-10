package com.didi.sdk.webview;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import com.didi.sdk.apm.SystemUtils;
import java.lang.reflect.Method;

public class ScreenOrientationMonitor {

    /* renamed from: a */
    private static final int f41105a = 0;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public BaseWebActivity f41106b;

    /* renamed from: c */
    private RotationObserver f41107c;

    /* renamed from: d */
    private boolean f41108d = false;

    public ScreenOrientationMonitor(BaseWebActivity baseWebActivity) {
        this.f41106b = baseWebActivity;
        this.f41107c = new RotationObserver(new Handler());
    }

    public void setH5ScreenOrientationSetting(boolean z) {
        this.f41108d = z;
        updateActivityOrientation(false);
    }

    public void onCreate() {
        this.f41107c.startObserver();
    }

    public void onDestroy() {
        this.f41107c.stopObserver();
    }

    private class RotationObserver extends ContentObserver {
        ContentResolver mResolver;

        public RotationObserver(Handler handler) {
            super(handler);
            this.mResolver = ScreenOrientationMonitor.this.f41106b.getContentResolver();
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
        if (Build.VERSION.SDK_INT == 26 && m30831a((Activity) this.f41106b)) {
            return;
        }
        if (z) {
            SystemUtils.hookSetRequestedOrientation(this.f41106b, 1);
        } else if (!this.f41108d || m30829a((Context) this.f41106b) == 0) {
            SystemUtils.hookSetRequestedOrientation(this.f41106b, 1);
        } else {
            SystemUtils.hookSetRequestedOrientation(this.f41106b, 10);
        }
    }

    /* renamed from: a */
    private boolean m30831a(Activity activity) {
        boolean z = true;
        try {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get((Object) null));
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", new Class[]{TypedArray.class});
            method.setAccessible(true);
            z = ((Boolean) method.invoke((Object) null, new Object[]{obtainStyledAttributes})).booleanValue();
            method.setAccessible(false);
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return z;
        }
    }

    /* renamed from: a */
    private int m30829a(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
