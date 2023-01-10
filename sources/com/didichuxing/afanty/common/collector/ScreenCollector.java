package com.didichuxing.afanty.common.collector;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import com.didichuxing.afanty.common.utils.CommonUtil;
import java.lang.reflect.Field;

public class ScreenCollector {

    /* renamed from: a */
    private static Display f48218a;

    /* renamed from: b */
    private static int f48219b;

    /* renamed from: c */
    private static int f48220c;

    /* renamed from: d */
    private static Context f48221d;

    public static void init(Context context) {
        f48221d = context;
    }

    /* renamed from: a */
    private static int[] m36146a() {
        if (f48219b == 0) {
            if (f48218a == null) {
                f48218a = ((WindowManager) f48221d.getSystemService("window")).getDefaultDisplay();
            }
            Point point = new Point();
            if (CommonUtil.getAPILevel() < 13) {
                point.set(f48218a.getWidth(), f48218a.getHeight());
            } else {
                f48218a.getSize(point);
            }
            f48219b = point.x;
            f48220c = point.y;
        }
        return new int[]{f48219b, f48220c};
    }

    public static String getScreenSize() {
        int[] a = m36146a();
        return a[0] + "x" + a[1];
    }

    public static String getScreenInfo() {
        StringBuilder sb = new StringBuilder();
        if (f48218a == null) {
            f48218a = ((WindowManager) f48221d.getSystemService("window")).getDefaultDisplay();
        }
        sb.append(m36145a(f48218a));
        sb.append("screenSize: ");
        sb.append(getScreenSize());
        sb.append("\n");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        f48218a.getMetrics(displayMetrics);
        sb.append("density: ");
        sb.append(displayMetrics.density);
        sb.append("\n");
        sb.append("refreshRate: ");
        sb.append(f48218a.getRefreshRate());
        sb.append("\n");
        sb.append(m36147b(f48218a));
        return sb.toString();
    }

    /* renamed from: a */
    private static String m36145a(Display display) {
        StringBuilder sb = new StringBuilder();
        try {
            int intValue = ((Integer) display.getClass().getMethod("getFlags", new Class[0]).invoke(display, new Object[0])).intValue();
            SparseArray sparseArray = new SparseArray();
            for (Field field : display.getClass().getFields()) {
                if (field.getName().startsWith("FLAG_")) {
                    sparseArray.put(field.getInt((Object) null), field.getName());
                }
            }
            sb.append("flags: ");
            sb.append(m36144a(sparseArray, intValue));
            sb.append(10);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m36144a(SparseArray<String> sparseArray, int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            int keyAt = sparseArray.keyAt(i2) & i;
            if (keyAt > 0) {
                if (sb.length() > 0) {
                    sb.append('+');
                }
                sb.append(sparseArray.get(keyAt));
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    private static String m36147b(Display display) {
        StringBuilder sb = new StringBuilder();
        try {
            int intValue = ((Integer) display.getClass().getMethod("getRotation", new Class[0]).invoke(display, new Object[0])).intValue();
            sb.append("rotation: ");
            if (intValue == 0) {
                sb.append("0");
            } else if (intValue == 1) {
                sb.append("90");
            } else if (intValue == 2) {
                sb.append("180");
            } else if (intValue != 3) {
                sb.append(intValue);
            } else {
                sb.append("270");
            }
            sb.append(10);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }
}
