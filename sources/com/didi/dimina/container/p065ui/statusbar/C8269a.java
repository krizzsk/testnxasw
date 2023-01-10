package com.didi.dimina.container.p065ui.statusbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import com.taxis99.R;

/* renamed from: com.didi.dimina.container.ui.statusbar.a */
/* compiled from: BarConfig */
class C8269a {

    /* renamed from: a */
    private final int f19623a;

    /* renamed from: b */
    private final int f19624b;

    /* renamed from: c */
    private final boolean f19625c;

    /* renamed from: d */
    private final int f19626d;

    /* renamed from: e */
    private final int f19627e;

    /* renamed from: f */
    private final boolean f19628f;

    /* renamed from: g */
    private final float f19629g;

    C8269a(Activity activity) {
        boolean z = false;
        this.f19628f = activity.getResources().getConfiguration().orientation == 1;
        this.f19629g = m16694c(activity);
        this.f19623a = m16691a(activity, "status_bar_height");
        this.f19624b = m16689a(activity);
        this.f19626d = m16690a((Context) activity);
        this.f19627e = m16692b((Context) activity);
        this.f19625c = this.f19626d > 0 ? true : z;
    }

    /* renamed from: a */
    private int m16689a(Activity activity) {
        int i = 0;
        if (Build.VERSION.SDK_INT < 14) {
            return 0;
        }
        View findViewById = activity.getWindow().findViewById(R.id.action_bar_container);
        if (findViewById != null) {
            i = findViewById.getMeasuredHeight();
        }
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(16843499, typedValue, true);
        return TypedValue.complexToDimensionPixelSize(typedValue.data, activity.getResources().getDisplayMetrics());
    }

    /* renamed from: a */
    private int m16690a(Context context) {
        if (Build.VERSION.SDK_INT < 14 || !m16693b((Activity) context)) {
            return 0;
        }
        return m16691a(context, this.f19628f ? "navigation_bar_height" : "navigation_bar_height_landscape");
    }

    /* renamed from: b */
    private int m16692b(Context context) {
        if (Build.VERSION.SDK_INT < 14 || !m16693b((Activity) context)) {
            return 0;
        }
        return m16691a(context, "navigation_bar_width");
    }

    /* renamed from: b */
    private boolean m16693b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17) {
            if (Settings.Global.getInt(activity.getContentResolver(), "force_fsg_nav_bar", 0) != 0) {
                return false;
            }
            if (OSUtils.isEMUI()) {
                if (OSUtils.isEMUI3_x() || Build.VERSION.SDK_INT < 21) {
                    if (Settings.System.getInt(activity.getContentResolver(), "navigationbar_is_min", 0) != 0) {
                        return false;
                    }
                } else if (Settings.Global.getInt(activity.getContentResolver(), "navigationbar_is_min", 0) != 0) {
                    return false;
                }
            }
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        }
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        int i3 = displayMetrics2.heightPixels;
        if (i2 - displayMetrics2.widthPixels > 0 || i - i3 > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private int m16691a(Context context, String str) {
        try {
            int identifier = Resources.getSystem().getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                int dimensionPixelSize2 = Resources.getSystem().getDimensionPixelSize(identifier);
                if (dimensionPixelSize2 >= dimensionPixelSize) {
                    return dimensionPixelSize2;
                }
                float f = (((float) dimensionPixelSize) * Resources.getSystem().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density;
                return (int) (f >= 0.0f ? f + 0.5f : f - 0.5f);
            }
        } catch (Resources.NotFoundException unused) {
        }
        return 0;
    }

    /* renamed from: c */
    private float m16694c(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 16) {
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        }
        return Math.min(((float) displayMetrics.widthPixels) / displayMetrics.density, ((float) displayMetrics.heightPixels) / displayMetrics.density);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo61635a() {
        return this.f19629g >= 600.0f || this.f19628f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo61636b() {
        return this.f19623a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo61637c() {
        return this.f19624b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo61638d() {
        return this.f19625c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo61639e() {
        return this.f19626d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo61640f() {
        return this.f19627e;
    }
}
