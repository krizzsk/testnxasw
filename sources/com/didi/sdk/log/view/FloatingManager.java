package com.didi.sdk.log.view;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.WindowManager;
import com.didi.sdk.log.util.UiThreadHandler;

public class FloatingManager {

    /* renamed from: a */
    private static FloatingManager f39231a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public FloatingView f39232b = null;

    /* renamed from: c */
    private Handler f39233c = UiThreadHandler.getsUiHandler();

    private FloatingManager() {
    }

    public static FloatingManager getInstance() {
        if (f39231a == null) {
            synchronized (FloatingManager.class) {
                if (f39231a == null) {
                    f39231a = new FloatingManager();
                }
            }
        }
        return f39231a;
    }

    public void init(Context context) {
        if (this.f39232b == null) {
            final WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (this.f39232b == null) {
                this.f39232b = new FloatingView(context);
            }
            this.f39233c.post(new Runnable() {
                public void run() {
                    FloatingManager.this.m29574a(windowManager);
                }
            });
        }
    }

    public void setDChatMsg(final String str) {
        if (this.f39232b != null && !TextUtils.isEmpty(str)) {
            this.f39233c.post(new Runnable() {
                public void run() {
                    FloatingManager.this.f39232b.setMsg(str);
                }
            });
        }
    }

    public void removeFloatingView(final Context context) {
        if (context != null) {
            this.f39233c.post(new Runnable() {
                public void run() {
                    if (FloatingManager.this.f39232b != null) {
                        ((WindowManager) context.getSystemService("window")).removeView(FloatingManager.this.f39232b);
                    }
                }
            });
        }
    }

    public void clear(final Context context) {
        if (context != null) {
            this.f39233c.post(new Runnable() {
                public void run() {
                    if (FloatingManager.this.f39232b != null) {
                        ((WindowManager) context.getSystemService("window")).removeView(FloatingManager.this.f39232b);
                        FloatingView unused = FloatingManager.this.f39232b = null;
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29574a(WindowManager windowManager) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.type = 2002;
        layoutParams.flags = 24;
        layoutParams.format = -2;
        layoutParams.x = 0;
        layoutParams.y = (-windowManager.getDefaultDisplay().getHeight()) / 2;
        windowManager.addView(this.f39232b, layoutParams);
    }
}
