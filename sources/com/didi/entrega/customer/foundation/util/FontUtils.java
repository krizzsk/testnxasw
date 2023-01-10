package com.didi.entrega.customer.foundation.util;

import android.graphics.Typeface;
import java.util.HashMap;

public final class FontUtils {

    /* renamed from: a */
    private static final int f21991a = 2131296263;

    /* renamed from: b */
    private static HashMap<Integer, Typeface> f21992b = new HashMap<>();

    private FontUtils() {
    }

    public static Typeface getIconTypeface() {
        return m18252a(f21991a);
    }

    /* renamed from: a */
    private static Typeface m18252a(int i) {
        if (f21992b.containsKey(Integer.valueOf(i)) && f21992b.get(Integer.valueOf(i)) != null) {
            return f21992b.get(Integer.valueOf(i));
        }
        Typeface font = ResourceHelper.getFont(i);
        f21992b.put(Integer.valueOf(i), font);
        return font;
    }
}
