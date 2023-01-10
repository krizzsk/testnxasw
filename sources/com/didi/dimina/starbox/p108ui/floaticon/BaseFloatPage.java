package com.didi.dimina.starbox.p108ui.floaticon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;

/* renamed from: com.didi.dimina.starbox.ui.floaticon.BaseFloatPage */
public abstract class BaseFloatPage {

    /* renamed from: a */
    private static final String f19985a = "BaseFloatPage";

    /* renamed from: b */
    private View f19986b;

    /* renamed from: c */
    private WindowManager.LayoutParams f19987c;

    /* renamed from: d */
    private Handler f19988d;

    /* renamed from: e */
    private final InnerReceiver f19989e = new InnerReceiver();

    /* renamed from: f */
    private String f19990f;

    /* renamed from: g */
    private Bundle f19991g;

    /* access modifiers changed from: protected */
    public boolean onBackPressed() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Context context) {
    }

    /* access modifiers changed from: protected */
    public abstract View onCreateView(Context context, ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public void onDestroy() {
    }

    public void onEnterBackground() {
    }

    public void onEnterForeground() {
    }

    public void onHomeKeyPress() {
    }

    /* access modifiers changed from: protected */
    public void onLayoutParamsCreated(WindowManager.LayoutParams layoutParams) {
    }

    public void onRecentAppKeyPress() {
    }

    /* access modifiers changed from: protected */
    public void onViewCreated(View view) {
    }

    public void performCreate(Context context) {
        this.f19988d = new Handler(Looper.myLooper());
        onCreate(context);
        C83421 r0 = new FrameLayout(context) {
            public boolean dispatchKeyEvent(KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1 && (keyEvent.getKeyCode() == 4 || keyEvent.getKeyCode() == 3)) {
                    return BaseFloatPage.this.onBackPressed();
                }
                return super.dispatchKeyEvent(keyEvent);
            }
        };
        this.f19986b = r0;
        ((ViewGroup) this.f19986b).addView(onCreateView(context, r0));
        onViewCreated(this.f19986b);
        this.f19987c = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f19987c.type = 2038;
        } else {
            this.f19987c.type = 2002;
        }
        this.f19987c.format = -2;
        this.f19987c.gravity = 51;
        onLayoutParamsCreated(this.f19987c);
        try {
            context.registerReceiver(this.f19989e, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    public void performDestroy() {
        try {
            getContext().unregisterReceiver(this.f19989e);
        } catch (Exception e) {
            Log.d("Context", "unregisterReceiver", e);
        }
        this.f19988d = null;
        this.f19986b = null;
        onDestroy();
    }

    public Context getContext() {
        View view = this.f19986b;
        if (view != null) {
            return view.getContext();
        }
        return null;
    }

    public Resources getResources() {
        if (getContext() == null) {
            return null;
        }
        return getContext().getResources();
    }

    public String getString(int i) {
        if (getContext() == null) {
            return null;
        }
        return getContext().getString(i);
    }

    public boolean isShow() {
        return this.f19986b.isShown();
    }

    /* access modifiers changed from: protected */
    public <T extends View> T findViewById(int i) {
        return this.f19986b.findViewById(i);
    }

    public View getRootView() {
        return this.f19986b;
    }

    public WindowManager.LayoutParams getLayoutParams() {
        return this.f19987c;
    }

    public void post(Runnable runnable) {
        this.f19988d.post(runnable);
    }

    public void postDelayed(Runnable runnable, long j) {
        this.f19988d.postDelayed(runnable, j);
    }

    public void runAfterRenderFinish(final Runnable runnable) {
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            public boolean queueIdle() {
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
                Looper.myQueue().removeIdleHandler(this);
                return false;
            }
        });
    }

    public void finish() {
        FloatPageManager.getInstance().remove(this);
    }

    /* renamed from: com.didi.dimina.starbox.ui.floaticon.BaseFloatPage$InnerReceiver */
    private class InnerReceiver extends BroadcastReceiver {
        final String SYSTEM_DIALOG_REASON_HOME_KEY;
        final String SYSTEM_DIALOG_REASON_KEY;
        final String SYSTEM_DIALOG_REASON_RECENT_APPS;

        private InnerReceiver() {
            this.SYSTEM_DIALOG_REASON_KEY = "reason";
            this.SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";
            this.SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
        }

        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction()) && (stringExtra = intent.getStringExtra("reason")) != null) {
                if (stringExtra.equals("homekey")) {
                    BaseFloatPage.this.onHomeKeyPress();
                } else if (stringExtra.equals("recentapps")) {
                    BaseFloatPage.this.onRecentAppKeyPress();
                }
            }
        }
    }

    public void setBundle(Bundle bundle) {
        this.f19991g = bundle;
    }

    public Bundle getBundle() {
        return this.f19991g;
    }

    public String getTag() {
        return this.f19990f;
    }

    public void setTag(String str) {
        this.f19990f = str;
    }
}
