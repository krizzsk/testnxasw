package com.didi.rfusion.material.internal;

import android.os.Build;
import java.util.Locale;

public class RFManufacturerUtils {

    /* renamed from: a */
    private static final String f36034a = "lge";

    /* renamed from: b */
    private static final String f36035b = "samsung";

    /* renamed from: c */
    private static final String f36036c = "meizu";

    private RFManufacturerUtils() {
    }

    public static boolean isMeizuDevice() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals(f36036c);
    }

    public static boolean isLGEDevice() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals(f36034a);
    }

    public static boolean isSamsungDevice() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("samsung");
    }

    public static boolean isDateInputKeyboardMissingSeparatorCharacters() {
        return isLGEDevice() || isSamsungDevice();
    }
}
