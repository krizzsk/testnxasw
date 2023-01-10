package com.didi.rfusion.widget.toast.helper;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.WindowManager;
import android.widget.Toast;
import com.didi.rfusion.utils.RFActivityManager;

public class RFNotificationToastHelper extends Handler {

    /* renamed from: d */
    private static final long f36769d = 4000;

    /* renamed from: a */
    private final Toast f36770a;

    /* renamed from: b */
    private final String f36771b;

    /* renamed from: c */
    private boolean f36772c;

    public RFNotificationToastHelper(Toast toast, Application application) {
        super(Looper.getMainLooper());
        this.f36770a = toast;
        this.f36771b = application.getPackageName();
    }

    public void handleMessage(Message message) {
        cancel();
    }

    public void show() {
        WindowManager windowManager;
        if (!mo95021a()) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            layoutParams.format = -3;
            layoutParams.windowAnimations = 16973828;
            layoutParams.flags = 152;
            layoutParams.packageName = this.f36771b;
            layoutParams.gravity = this.f36770a.getGravity();
            layoutParams.x = this.f36770a.getXOffset();
            layoutParams.y = this.f36770a.getYOffset();
            try {
                Activity topActivity = RFActivityManager.getInstance().getTopActivity();
                if (!(topActivity == null || topActivity.isFinishing() || (windowManager = (WindowManager) topActivity.getSystemService("window")) == null)) {
                    windowManager.addView(this.f36770a.getView(), layoutParams);
                }
                sendEmptyMessageDelayed(hashCode(), 4000);
                mo95020a(true);
            } catch (WindowManager.BadTokenException | IllegalStateException unused) {
            }
        }
    }

    public void cancel() {
        WindowManager windowManager;
        removeMessages(hashCode());
        if (mo95021a()) {
            try {
                Activity topActivity = RFActivityManager.getInstance().getTopActivity();
                if (!(topActivity == null || (windowManager = (WindowManager) topActivity.getSystemService("window")) == null)) {
                    windowManager.removeViewImmediate(this.f36770a.getView());
                }
            } catch (IllegalArgumentException unused) {
            }
            mo95020a(false);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo95021a() {
        return this.f36772c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo95020a(boolean z) {
        this.f36772c = z;
    }
}
