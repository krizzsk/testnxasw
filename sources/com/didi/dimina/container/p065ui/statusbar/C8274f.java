package com.didi.dimina.container.p065ui.statusbar;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.didi.dimina.container.ui.statusbar.f */
/* compiled from: SpecialBarFontUtils */
class C8274f {

    /* renamed from: a */
    private static Method f19662a;

    /* renamed from: b */
    private static Method f19663b;

    /* renamed from: c */
    private static Field f19664c;

    /* renamed from: d */
    private static int f19665d;

    /* renamed from: a */
    static int m16710a(int i) {
        return (((((i & 16711680) >> 16) * 38) + (((65280 & i) >> 8) * 75)) + ((i & 255) * 15)) >> 7;
    }

    C8274f() {
    }

    static {
        Class<Activity> cls = Activity.class;
        try {
            f19662a = cls.getMethod("setStatusBarDarkIcon", new Class[]{Integer.TYPE});
        } catch (NoSuchMethodException unused) {
        }
        Class<Activity> cls2 = Activity.class;
        try {
            f19663b = cls2.getMethod("setStatusBarDarkIcon", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException unused2) {
        }
        try {
            f19664c = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException unused3) {
        }
        try {
            f19665d = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt((Object) null);
        } catch (IllegalAccessException | NoSuchFieldException unused4) {
        }
    }

    /* renamed from: a */
    static boolean m16718a(int i, int i2) {
        return m16710a(i) < i2;
    }

    /* renamed from: a */
    public static void m16711a(Activity activity, int i) {
        Method method = f19662a;
        if (method != null) {
            try {
                method.invoke(activity, new Object[]{Integer.valueOf(i)});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        } else {
            boolean a = m16718a(i, 50);
            if (f19664c != null) {
                m16713a(activity, a, a);
                m16715a(activity.getWindow(), i);
                return;
            }
            m16712a(activity, a);
        }
    }

    /* renamed from: a */
    public static void m16715a(Window window, int i) {
        try {
            m16720b(window, i);
            if (Build.VERSION.SDK_INT > 22) {
                m16714a(window.getDecorView(), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m16712a(Activity activity, boolean z) {
        m16713a(activity, z, true);
    }

    /* renamed from: a */
    private static boolean m16719a(WindowManager.LayoutParams layoutParams, String str, boolean z) {
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            int i = declaredField.getInt(layoutParams);
            Field declaredField2 = layoutParams.getClass().getDeclaredField("meizuFlags");
            declaredField2.setAccessible(true);
            int i2 = declaredField2.getInt(layoutParams);
            int i3 = z ? i | i2 : (~i) & i2;
            if (i2 == i3) {
                return false;
            }
            declaredField2.setInt(layoutParams, i3);
            return true;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return false;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private static void m16714a(View view, boolean z) {
        int i;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z) {
            i = f19665d | systemUiVisibility;
        } else {
            i = (~f19665d) & systemUiVisibility;
        }
        if (i != systemUiVisibility) {
            view.setSystemUiVisibility(i);
        }
    }

    /* renamed from: b */
    private static void m16720b(Window window, int i) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = f19664c;
        if (field != null) {
            try {
                if (field.getInt(attributes) != i) {
                    f19664c.set(attributes, Integer.valueOf(i));
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m16717a(Window window, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            m16719a(window.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", z);
            return;
        }
        m16714a(window.getDecorView(), z);
        m16720b(window, 0);
    }

    /* renamed from: a */
    private static void m16713a(Activity activity, boolean z, boolean z2) {
        Method method = f19663b;
        if (method != null) {
            try {
                method.invoke(activity, new Object[]{Boolean.valueOf(z)});
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        } else if (z2) {
            m16717a(activity.getWindow(), z);
        }
    }

    /* renamed from: a */
    static void m16716a(Window window, String str, boolean z) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField(str).getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});
                if (z) {
                    method.invoke(window, new Object[]{Integer.valueOf(i), Integer.valueOf(i)});
                    return;
                }
                method.invoke(window, new Object[]{0, Integer.valueOf(i)});
            } catch (Exception unused) {
            }
        }
    }
}
