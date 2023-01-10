package rui.config.parser;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import rui.config.RConfigConstants;

public class RResourceDrawableIdHelper {

    /* renamed from: a */
    private static Map<String, Integer> f8601a = new HashMap();

    /* renamed from: b */
    private static final String f8602b = "res";

    /* renamed from: a */
    static void m7234a() {
        f8601a.clear();
    }

    /* renamed from: a */
    static int m7233a(Context context, String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String replace = str.toLowerCase().replace("-", "_");
        try {
            return Integer.parseInt(replace);
        } catch (NumberFormatException unused) {
            if (f8601a.containsKey(replace)) {
                return f8601a.get(replace).intValue();
            }
            int identifier = context.getResources().getIdentifier(replace, RConfigConstants.TYPE_DRAWABLE, context.getPackageName());
            if (identifier == 0) {
                identifier = context.getResources().getIdentifier(replace, "mipmap", context.getPackageName());
            }
            f8601a.put(replace, Integer.valueOf(identifier));
            return identifier;
        }
    }

    /* renamed from: b */
    static Drawable m7235b(Context context, String str) {
        int a = m7233a(context, str);
        if (a > 0) {
            return context.getResources().getDrawable(a);
        }
        return null;
    }

    /* renamed from: c */
    static Uri m7236c(Context context, String str) {
        int a = m7233a(context, str);
        return a > 0 ? new Uri.Builder().scheme("res").path(String.valueOf(a)).build() : Uri.EMPTY;
    }
}
