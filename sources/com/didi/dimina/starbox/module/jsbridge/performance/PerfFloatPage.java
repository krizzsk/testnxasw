package com.didi.dimina.starbox.module.jsbridge.performance;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.didi.dimina.container.bridge.storage.MMKVUtil;
import com.didi.dimina.container.util.PixUtil;
import com.didi.dimina.starbox.p108ui.windowpop.AsyncWindow;
import com.didi.dimina.starbox.p108ui.windowpop.AsyncWindowPop;
import com.didi.dimina.starbox.p108ui.windowpop.ClosePop;
import com.didi.dimina.starbox.util.AppCtxProvider;
import com.google.android.material.badge.BadgeDrawable;
import java.util.HashMap;

public class PerfFloatPage implements AsyncWindow, ClosePop.OnCloseCallback {
    public static final String KEY_MONITOR_IS_OPEN = "monitor_is_open_";

    /* renamed from: f */
    private static final HashMap<String, PerfFloatPage> f19939f = new HashMap<>();

    /* renamed from: a */
    private final AsyncWindowPop f19940a;

    /* renamed from: b */
    private final Context f19941b;

    /* renamed from: c */
    private final ClosePop f19942c;

    /* renamed from: d */
    private final String f19943d;

    /* renamed from: e */
    private PerfUI f19944e;

    public PerfFloatPage(Context context, String str) {
        this.f19941b = context;
        this.f19943d = str;
        this.f19940a = new AsyncWindowPop(context, this);
        this.f19942c = new ClosePop(context, (AsyncWindow) null, this);
    }

    public static void trigger(boolean z, String str) {
        if (z) {
            MMKVUtil instance = MMKVUtil.getInstance();
            instance.save(KEY_MONITOR_IS_OPEN + str, true);
            PerfFloatPage perfFloatPage = f19939f.get(str);
            if (perfFloatPage == null) {
                perfFloatPage = new PerfFloatPage(AppCtxProvider.getApp(), str);
                f19939f.put(str, perfFloatPage);
            }
            perfFloatPage.m16932a();
            return;
        }
        PerfFloatPage perfFloatPage2 = f19939f.get(str);
        if (perfFloatPage2 != null) {
            perfFloatPage2.onClose();
        }
    }

    public View provideView() {
        PerfUI perfUI = new PerfUI(this.f19941b, this.f19943d);
        this.f19944e = perfUI;
        return perfUI;
    }

    public void onLayoutParams(WindowManager.LayoutParams layoutParams) {
        layoutParams.flags = 24;
        layoutParams.width = PixUtil.dip2px(this.f19941b, 250.0f);
        layoutParams.height = PixUtil.dip2px(this.f19941b, 320.0f);
        layoutParams.gravity = BadgeDrawable.TOP_END;
    }

    /* renamed from: a */
    private void m16932a() {
        this.f19940a.pop();
        this.f19942c.pop();
    }

    public void onClose() {
        this.f19940a.cancel();
        PerfUI perfUI = this.f19944e;
        if (perfUI != null) {
            perfUI.cancel();
        }
        f19939f.remove(this.f19943d);
        MMKVUtil instance = MMKVUtil.getInstance();
        instance.save(KEY_MONITOR_IS_OPEN + this.f19943d, false);
    }

    public boolean onForegroundChange(boolean z) {
        PerfUI perfUI = this.f19944e;
        if (perfUI == null) {
            return false;
        }
        perfUI.onChange(z);
        return false;
    }
}
