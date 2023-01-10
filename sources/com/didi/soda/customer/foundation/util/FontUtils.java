package com.didi.soda.customer.foundation.util;

import android.graphics.Typeface;
import java.util.HashMap;

public final class FontUtils {

    /* renamed from: a */
    private static final int f43837a = 2131296258;

    /* renamed from: b */
    private static HashMap<Integer, Typeface> f43838b = new HashMap<>();

    private FontUtils() {
    }

    public static Typeface getIconTypeface() {
        return m32693a(f43837a);
    }

    /* renamed from: a */
    private static Typeface m32693a(int i) {
        if (f43838b.containsKey(Integer.valueOf(i)) && f43838b.get(Integer.valueOf(i)) != null) {
            return f43838b.get(Integer.valueOf(i));
        }
        Typeface font = ResourceHelper.getFont(i);
        f43838b.put(Integer.valueOf(i), font);
        return font;
    }
}
