package com.didi.drouter.store;

import android.net.Uri;
import androidx.lifecycle.LifecycleOwner;
import com.didi.drouter.router.IRouterInterceptor;
import com.didi.drouter.utils.TextUtils;

public class RouterKey {

    /* renamed from: a */
    Uri f21097a;

    /* renamed from: b */
    Class<? extends IRouterInterceptor>[] f21098b;

    /* renamed from: c */
    int f21099c;

    /* renamed from: d */
    boolean f21100d;

    /* renamed from: e */
    LifecycleOwner f21101e;

    private RouterKey() {
    }

    public static RouterKey build(String str) {
        RouterKey routerKey = new RouterKey();
        routerKey.f21097a = TextUtils.getUriKey(str);
        return routerKey;
    }

    public void setThread(int i) {
        this.f21099c = i;
    }

    @SafeVarargs
    public final RouterKey setInterceptor(Class<? extends IRouterInterceptor>... clsArr) {
        this.f21098b = clsArr;
        return this;
    }

    public RouterKey setHold(boolean z) {
        this.f21100d = z;
        return this;
    }

    public RouterKey setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.f21101e = lifecycleOwner;
        return this;
    }
}
