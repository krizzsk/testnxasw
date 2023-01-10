package com.didi.dimina.starbox.p108ui.floaticon;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.WindowManager;
import com.didi.dimina.container.util.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.didi.dimina.starbox.ui.floaticon.FloatPageManager */
public class FloatPageManager {

    /* renamed from: a */
    private static final String f19999a = "FloatPageManager";

    /* renamed from: b */
    private WindowManager f20000b;

    /* renamed from: c */
    private Context f20001c;

    /* renamed from: d */
    private final List<BaseFloatPage> f20002d = new ArrayList();

    public void notifyBackground() {
        for (BaseFloatPage onEnterBackground : this.f20002d) {
            onEnterBackground.onEnterBackground();
        }
    }

    public void notifyForeground() {
        for (BaseFloatPage onEnterForeground : this.f20002d) {
            onEnterForeground.onEnterForeground();
        }
    }

    /* renamed from: com.didi.dimina.starbox.ui.floaticon.FloatPageManager$Holder */
    private static class Holder {
        /* access modifiers changed from: private */
        public static final FloatPageManager INSTANCE = new FloatPageManager();

        private Holder() {
        }
    }

    public static FloatPageManager getInstance() {
        return Holder.INSTANCE;
    }

    public void init(Context context) {
        this.f20001c = context.getApplicationContext();
        this.f20000b = (WindowManager) context.getSystemService("window");
    }

    public void add(PageIntent pageIntent) {
        try {
            if (pageIntent.targetClass != null) {
                if (pageIntent.mode == 1) {
                    for (BaseFloatPage isInstance : this.f20002d) {
                        if (pageIntent.targetClass.isInstance(isInstance)) {
                            return;
                        }
                    }
                }
                BaseFloatPage baseFloatPage = (BaseFloatPage) pageIntent.targetClass.newInstance();
                baseFloatPage.setBundle(pageIntent.bundle);
                baseFloatPage.setTag(pageIntent.tag);
                this.f20002d.add(baseFloatPage);
                baseFloatPage.performCreate(this.f20001c);
                if (Build.VERSION.SDK_INT >= 26) {
                    baseFloatPage.getLayoutParams().type = 2038;
                } else {
                    baseFloatPage.getLayoutParams().type = 2003;
                }
                this.f20000b.addView(baseFloatPage.getRootView(), baseFloatPage.getLayoutParams());
            }
        } catch (InstantiationException e) {
            LogUtil.m16840e(f19999a, e.toString());
        } catch (IllegalAccessException e2) {
            LogUtil.m16840e(f19999a, e2.toString());
        }
    }

    public boolean contain(Class<? extends BaseFloatPage> cls) {
        for (BaseFloatPage isInstance : this.f20002d) {
            if (cls.isInstance(isInstance)) {
                return true;
            }
        }
        return false;
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (BaseFloatPage next : this.f20002d) {
                if (str.equals(next.getTag())) {
                    this.f20000b.removeView(next.getRootView());
                    next.performDestroy();
                    this.f20002d.remove(next);
                    return;
                }
            }
        }
    }

    public void remove(BaseFloatPage baseFloatPage) {
        this.f20000b.removeView(baseFloatPage.getRootView());
        baseFloatPage.performDestroy();
        this.f20002d.remove(baseFloatPage);
    }

    public void removeAll(Class<? extends BaseFloatPage> cls) {
        Iterator<BaseFloatPage> it = this.f20002d.iterator();
        while (it.hasNext()) {
            BaseFloatPage next = it.next();
            if (cls.isInstance(next)) {
                this.f20000b.removeView(next.getRootView());
                next.performDestroy();
                it.remove();
            }
        }
    }

    public void removeAll() {
        Iterator<BaseFloatPage> it = this.f20002d.iterator();
        while (it.hasNext()) {
            BaseFloatPage next = it.next();
            this.f20000b.removeView(next.getRootView());
            next.performDestroy();
            it.remove();
        }
    }

    public BaseFloatPage getFloatPage(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (BaseFloatPage next : this.f20002d) {
            if (str.equals(next.getTag())) {
                return next;
            }
        }
        return null;
    }
}
