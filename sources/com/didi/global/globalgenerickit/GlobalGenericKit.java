package com.didi.global.globalgenerickit;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.didi.global.globalgenerickit.helper.KitHelper;
import com.didiglobal.dittoview.impl.DittoViewBinderImpl;
import java.util.concurrent.ConcurrentHashMap;

public class GlobalGenericKit {
    public static final String TEMPLATE_CDN = "_cdn_template";

    /* renamed from: a */
    private static GlobalGenericKit f23960a = new GlobalGenericKit();

    /* renamed from: c */
    private static boolean f23961c = false;

    /* renamed from: b */
    private ConcurrentHashMap<String, GGKViewBinder> f23962b = new ConcurrentHashMap<>();

    public static <T> T getApolloParam(String str, String str2, T t) {
        return t;
    }

    public static boolean isShowDebugView() {
        return f23961c;
    }

    public static void showDebugView(boolean z) {
        f23961c = z;
    }

    private GlobalGenericKit() {
    }

    public static void register(String str, GGKViewBinder gGKViewBinder, boolean z) {
        if (str != null && gGKViewBinder != null) {
            if (z || !f23960a.f23962b.containsKey(str)) {
                f23960a.f23962b.put(str, gGKViewBinder);
                return;
            }
            throw new RuntimeException(str + " already exists,register fail");
        }
    }

    public static void unRegister(String str) {
        f23960a.f23962b.remove(str);
    }

    public static GGKView createTemplateView(Context context, GGKData gGKData) {
        GGKView gGKView;
        if (context == null || gGKData == null) {
            return null;
        }
        if (((Integer) getApolloParam("x_engine_cache_enable", "use_cache", 0)).intValue() == 1) {
            DittoViewBinderImpl dittoViewBinderImpl = new DittoViewBinderImpl();
            gGKView = new GGKView(dittoViewBinderImpl, dittoViewBinderImpl.createView(context, gGKData.parse2DittoData()));
        } else {
            GGKViewBinder gGKViewBinder = f23960a.f23962b.get(m19405a(gGKData));
            if (gGKViewBinder == null) {
                return null;
            }
            View createView = gGKViewBinder.createView(context, gGKData);
            if (isShowDebugView()) {
                createView = KitHelper.wrapperDebugView(createView, gGKData);
            }
            gGKView = new GGKView(gGKViewBinder, createView);
        }
        if (gGKView.getView() != null) {
            return gGKView;
        }
        return null;
    }

    /* renamed from: a */
    private static String m19405a(GGKData gGKData) {
        if (!TextUtils.isEmpty(gGKData.getCdn())) {
            return "_cdn_template";
        }
        return gGKData.getTemplate();
    }

    public static boolean isRegistered(String str) {
        return f23960a.f23962b.containsKey(str);
    }

    public static GGKViewBinder getViewBinder(String str) {
        return f23960a.f23962b.get(str);
    }

    public static GGKViewBinder getViewBinder(GGKData gGKData) {
        return f23960a.f23962b.get(m19405a(gGKData));
    }
}
