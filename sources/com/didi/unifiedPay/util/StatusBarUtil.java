package com.didi.unifiedPay.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StatusBarUtil {
    public static final int DEFAULT_STATUS_BAR_ALPHA = 112;

    /* renamed from: a */
    private static final int f47262a = 2131434382;

    /* renamed from: b */
    private static final int f47263b = 2131434383;

    /* renamed from: c */
    private static final int f47264c = -123;

    /* renamed from: a */
    private static int m35173a(int i, int i2) {
        if (i2 == 0) {
            return i;
        }
        float f = 1.0f - (((float) i2) / 255.0f);
        return ((int) (((double) (((float) (i & 255)) * f)) + 0.5d)) | (((int) (((double) (((float) ((i >> 16) & 255)) * f)) + 0.5d)) << 16) | -16777216 | (((int) (((double) (((float) ((i >> 8) & 255)) * f)) + 0.5d)) << 8);
    }

    public static void setColor(Activity activity, int i) {
        setColor(activity, i, 112);
    }

    public static void setColor(Activity activity, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().clearFlags(View.STATUS_BAR_TRANSIENT);
            activity.getWindow().setStatusBarColor(m35173a(i, i2));
        } else if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(View.STATUS_BAR_TRANSIENT);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            View findViewById = viewGroup.findViewById(f47262a);
            if (findViewById != null) {
                if (findViewById.getVisibility() == 8) {
                    findViewById.setVisibility(0);
                }
                findViewById.setBackgroundColor(m35173a(i, i2));
            } else {
                viewGroup.addView(m35175a(activity, i, i2));
            }
            m35181b(activity);
        }
    }

    public static void setColorForSwipeBack(Activity activity, int i) {
        setColorForSwipeBack(activity, i, 112);
    }

    public static void setColorForSwipeBack(Activity activity, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
            View childAt = viewGroup.getChildAt(0);
            int a = m35174a((Context) activity);
            if (childAt == null || !(childAt instanceof CoordinatorLayout)) {
                viewGroup.setPadding(0, a, 0, 0);
                viewGroup.setBackgroundColor(m35173a(i, i2));
            } else {
                final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) childAt;
                if (Build.VERSION.SDK_INT < 21) {
                    coordinatorLayout.setFitsSystemWindows(false);
                    viewGroup.setBackgroundColor(m35173a(i, i2));
                    if (viewGroup.getPaddingTop() < a) {
                        viewGroup.setPadding(0, a, 0, 0);
                        coordinatorLayout.post(new Runnable() {
                            public void run() {
                                CoordinatorLayout.this.requestLayout();
                            }
                        });
                    }
                } else {
                    coordinatorLayout.setStatusBarBackgroundColor(m35173a(i, i2));
                }
            }
            m35184c(activity);
        }
    }

    public static void setColorNoTranslucent(Activity activity, int i) {
        setColor(activity, i, 0);
    }

    @Deprecated
    public static void setColorDiff(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            m35185d(activity);
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
            View findViewById = viewGroup.findViewById(f47262a);
            if (findViewById != null) {
                if (findViewById.getVisibility() == 8) {
                    findViewById.setVisibility(0);
                }
                findViewById.setBackgroundColor(i);
            } else {
                viewGroup.addView(m35180b(activity, i));
            }
            m35181b(activity);
        }
    }

    public static void setTranslucent(Activity activity) {
        setTranslucent(activity, 112);
    }

    public static void setTranslucent(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            setTransparent(activity);
            m35177a(activity, i);
        }
    }

    public static void setTranslucentForCoordinatorLayout(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            m35185d(activity);
            m35177a(activity, i);
        }
    }

    public static void setTransparent(Activity activity) {
        if (Build.VERSION.SDK_INT >= 19) {
            m35185d(activity);
            m35181b(activity);
        }
    }

    @Deprecated
    public static void setTranslucentDiff(Activity activity) {
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(View.STATUS_BAR_TRANSIENT);
            m35181b(activity);
        }
    }

    public static void setColorForDrawerLayout(Activity activity, DrawerLayout drawerLayout, int i) {
        setColorForDrawerLayout(activity, drawerLayout, i, 112);
    }

    public static void setColorNoTranslucentForDrawerLayout(Activity activity, DrawerLayout drawerLayout, int i) {
        setColorForDrawerLayout(activity, drawerLayout, i, 0);
    }

    public static void setColorForDrawerLayout(Activity activity, DrawerLayout drawerLayout, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            if (Build.VERSION.SDK_INT >= 21) {
                activity.getWindow().addFlags(Integer.MIN_VALUE);
                activity.getWindow().clearFlags(View.STATUS_BAR_TRANSIENT);
                activity.getWindow().setStatusBarColor(0);
            } else {
                activity.getWindow().addFlags(View.STATUS_BAR_TRANSIENT);
            }
            ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
            View findViewById = viewGroup.findViewById(f47262a);
            if (findViewById != null) {
                if (findViewById.getVisibility() == 8) {
                    findViewById.setVisibility(0);
                }
                findViewById.setBackgroundColor(i);
            } else {
                viewGroup.addView(m35180b(activity, i), 0);
            }
            if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
                viewGroup.getChildAt(1).setPadding(viewGroup.getPaddingLeft(), m35174a((Context) activity) + viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
            }
            m35179a(drawerLayout, viewGroup);
            m35177a(activity, i2);
        }
    }

    /* renamed from: a */
    private static void m35179a(DrawerLayout drawerLayout, ViewGroup viewGroup) {
        drawerLayout.setFitsSystemWindows(false);
        viewGroup.setFitsSystemWindows(false);
        viewGroup.setClipToPadding(true);
        ((ViewGroup) drawerLayout.getChildAt(1)).setFitsSystemWindows(false);
    }

    @Deprecated
    public static void setColorForDrawerLayoutDiff(Activity activity, DrawerLayout drawerLayout, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(View.STATUS_BAR_TRANSIENT);
            ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
            View findViewById = viewGroup.findViewById(f47262a);
            if (findViewById != null) {
                if (findViewById.getVisibility() == 8) {
                    findViewById.setVisibility(0);
                }
                findViewById.setBackgroundColor(m35173a(i, 112));
            } else {
                viewGroup.addView(m35180b(activity, i), 0);
            }
            if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
                viewGroup.getChildAt(1).setPadding(0, m35174a((Context) activity), 0, 0);
            }
            m35179a(drawerLayout, viewGroup);
        }
    }

    public static void setTranslucentForDrawerLayout(Activity activity, DrawerLayout drawerLayout) {
        setTranslucentForDrawerLayout(activity, drawerLayout, 112);
    }

    public static void setTranslucentForDrawerLayout(Activity activity, DrawerLayout drawerLayout, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            setTransparentForDrawerLayout(activity, drawerLayout);
            m35177a(activity, i);
        }
    }

    public static void setTransparentForDrawerLayout(Activity activity, DrawerLayout drawerLayout) {
        if (Build.VERSION.SDK_INT >= 19) {
            if (Build.VERSION.SDK_INT >= 21) {
                activity.getWindow().addFlags(Integer.MIN_VALUE);
                activity.getWindow().clearFlags(View.STATUS_BAR_TRANSIENT);
                activity.getWindow().setStatusBarColor(0);
            } else {
                activity.getWindow().addFlags(View.STATUS_BAR_TRANSIENT);
            }
            ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
            if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
                viewGroup.getChildAt(1).setPadding(0, m35174a((Context) activity), 0, 0);
            }
            m35179a(drawerLayout, viewGroup);
        }
    }

    @Deprecated
    public static void setTranslucentForDrawerLayoutDiff(Activity activity, DrawerLayout drawerLayout) {
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(View.STATUS_BAR_TRANSIENT);
            ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
            viewGroup.setFitsSystemWindows(true);
            viewGroup.setClipToPadding(true);
            ((ViewGroup) drawerLayout.getChildAt(1)).setFitsSystemWindows(false);
            drawerLayout.setFitsSystemWindows(false);
        }
    }

    public static void setTransparentForImageView(Activity activity, View view) {
        setTranslucentForImageView(activity, 0, view);
    }

    public static void setTranslucentForImageView(Activity activity, View view) {
        setTranslucentForImageView(activity, 112, view);
    }

    public static void setTranslucentForImageView(Activity activity, int i, View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            m35184c(activity);
            m35177a(activity, i);
            if (view != null) {
                Object tag = view.getTag(f47264c);
                if (tag == null || !((Boolean) tag).booleanValue()) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + m35174a((Context) activity), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    view.setTag(f47264c, true);
                }
            }
        }
    }

    public static void setTranslucentForImageViewInFragment(Activity activity, View view) {
        setTranslucentForImageViewInFragment(activity, 112, view);
    }

    public static void setTransparentForImageViewInFragment(Activity activity, View view) {
        setTranslucentForImageViewInFragment(activity, 0, view);
    }

    public static void setTranslucentForImageViewInFragment(Activity activity, int i, View view) {
        setTranslucentForImageView(activity, i, view);
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            m35176a(activity);
        }
    }

    public static void hideFakeStatusBarView(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewById = viewGroup.findViewById(f47262a);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        View findViewById2 = viewGroup.findViewById(f47263b);
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
    }

    public static void setLightMode(Activity activity) {
        m35178a(activity, true);
        m35182b(activity, true);
        if (Build.VERSION.SDK_INT >= 23) {
            activity.getWindow().getDecorView().setSystemUiVisibility(9216);
        }
    }

    public static void setDarkMode(Activity activity) {
        m35178a(activity, false);
        m35182b(activity, false);
        if (Build.VERSION.SDK_INT >= 23) {
            activity.getWindow().getDecorView().setSystemUiVisibility(1024);
        }
    }

    /* renamed from: a */
    private static void m35178a(Activity activity, boolean z) {
        Class<?> cls = activity.getWindow().getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});
            Window window = activity.getWindow();
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? i : 0);
            objArr[1] = Integer.valueOf(i);
            method.invoke(window, objArr);
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    private static void m35182b(Activity activity, boolean z) {
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i = declaredField.getInt((Object) null);
            int i2 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z ? i2 | i : (~i) & i2);
            activity.getWindow().setAttributes(attributes);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private static void m35176a(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewById = viewGroup.findViewById(f47262a);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
            ((ViewGroup) ((ViewGroup) activity.findViewById(16908290)).getChildAt(0)).setPadding(0, 0, 0, 0);
        }
    }

    /* renamed from: a */
    private static void m35177a(Activity activity, int i) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        View findViewById = viewGroup.findViewById(f47263b);
        if (findViewById != null) {
            if (findViewById.getVisibility() == 8) {
                findViewById.setVisibility(0);
            }
            findViewById.setBackgroundColor(Color.argb(i, 0, 0, 0));
            return;
        }
        viewGroup.addView(m35183c(activity, i));
    }

    /* renamed from: b */
    private static View m35180b(Activity activity, int i) {
        return m35175a(activity, i, 0);
    }

    /* renamed from: a */
    private static View m35175a(Activity activity, int i, int i2) {
        View view = new View(activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, m35174a((Context) activity)));
        view.setBackgroundColor(m35173a(i, i2));
        view.setId(f47262a);
        return view;
    }

    /* renamed from: b */
    private static void m35181b(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                childAt.setFitsSystemWindows(true);
                ((ViewGroup) childAt).setClipToPadding(true);
            }
        }
    }

    /* renamed from: c */
    private static void m35184c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().setStatusBarColor(0);
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
        } else if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().setFlags(View.STATUS_BAR_TRANSIENT, View.STATUS_BAR_TRANSIENT);
        }
    }

    /* renamed from: d */
    private static void m35185d(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().clearFlags(View.STATUS_BAR_TRANSIENT);
            activity.getWindow().addFlags(View.NAVIGATION_BAR_TRANSIENT);
            activity.getWindow().setStatusBarColor(0);
            return;
        }
        activity.getWindow().addFlags(View.STATUS_BAR_TRANSIENT);
    }

    /* renamed from: c */
    private static View m35183c(Activity activity, int i) {
        View view = new View(activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, m35174a((Context) activity)));
        view.setBackgroundColor(Color.argb(i, 0, 0, 0));
        view.setId(f47263b);
        return view;
    }

    /* renamed from: a */
    private static int m35174a(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }
}
