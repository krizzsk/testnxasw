package com.didi.app.nova.skeleton.image.glide;

import android.content.Context;
import android.os.Looper;
import com.bumptech.glide.RequestManager;
import com.didi.app.nova.skeleton.ScopeContext;

public final class SkeletonGlide {

    /* renamed from: a */
    private static final String f10294a = "KEY_SkeletonGlide_SUPPORT";

    /* renamed from: b */
    private static Context f10295b;

    public static void setup(Context context) {
        f10295b = context.getApplicationContext();
    }

    public static RequestManager with(ScopeContext scopeContext) {
        if (f10295b == null) {
            throw new IllegalStateException("Call setup(context) when application created.");
        } else if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            C4291a aVar = (C4291a) scopeContext.getObject(f10294a);
            if (aVar == null) {
                aVar = new C4291a(scopeContext, f10295b);
                scopeContext.attach(f10294a, aVar);
            }
            return aVar.mo45855a();
        } else {
            throw new IllegalStateException("Only call this method in main thread.");
        }
    }
}
