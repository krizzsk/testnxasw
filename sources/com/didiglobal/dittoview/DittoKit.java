package com.didiglobal.dittoview;

import android.content.Context;
import android.text.TextUtils;
import com.didiglobal.dittoview.mvvm.DittoData;
import com.didiglobal.dittoview.mvvm.DittoView;
import com.didiglobal.dittoview.mvvm.DittoViewBinder;
import java.util.concurrent.ConcurrentHashMap;

public class DittoKit {
    public static final String TEMPLATE_CDN = "_cdn_template";

    /* renamed from: a */
    private static DittoKit f52446a = new DittoKit();

    /* renamed from: b */
    private ConcurrentHashMap<String, DittoViewBinder> f52447b = new ConcurrentHashMap<>();

    private DittoKit() {
    }

    public static void register(String str, DittoViewBinder dittoViewBinder, boolean z) {
        if (str != null && dittoViewBinder != null) {
            if (z || !f52446a.f52447b.containsKey(str)) {
                f52446a.f52447b.put(str, dittoViewBinder);
                return;
            }
            throw new RuntimeException(str + " already exists,register fail");
        }
    }

    public static void unRegister(String str) {
        f52446a.f52447b.remove(str);
    }

    public static DittoView createTemplateView(Context context, DittoData dittoData) {
        DittoViewBinder dittoViewBinder;
        if (context == null || dittoData == null || (dittoViewBinder = f52446a.f52447b.get(m39433a(dittoData))) == null) {
            return null;
        }
        DittoView dittoView = new DittoView(dittoViewBinder, dittoViewBinder.createView(context, dittoData));
        if (dittoView.getView() != null) {
            return dittoView;
        }
        return null;
    }

    /* renamed from: a */
    private static String m39433a(DittoData dittoData) {
        if (!TextUtils.isEmpty(dittoData.getCdn())) {
            return "_cdn_template";
        }
        return dittoData.getTemplate();
    }

    public static boolean isRegistered(String str) {
        return f52446a.f52447b.containsKey(str);
    }

    public static DittoViewBinder getViewBinder(String str) {
        return f52446a.f52447b.get(str);
    }

    public static DittoViewBinder getViewBinder(DittoData dittoData) {
        return f52446a.f52447b.get(m39433a(dittoData));
    }
}
