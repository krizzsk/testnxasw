package com.didi.safety.god.p145ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;

/* renamed from: com.didi.safety.god.ui.DetectionRectBgDrawables */
public class DetectionRectBgDrawables {

    /* renamed from: a */
    private static SparseArray<Drawable> f37493a;

    public static void setBg(View view, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setBackgroundResource(i);
        } else {
            view.setBackgroundDrawable(m28245a(view.getContext(), i));
        }
    }

    /* renamed from: a */
    private static Drawable m28245a(Context context, int i) {
        if (f37493a == null) {
            f37493a = new SparseArray<>();
        }
        Drawable drawable = f37493a.get(i);
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = context.getResources().getDrawable(i);
        f37493a.put(i, drawable2);
        return drawable2;
    }

    public static void clearDrawables() {
        SparseArray<Drawable> sparseArray;
        if (Build.VERSION.SDK_INT < 26 && (sparseArray = f37493a) != null) {
            sparseArray.clear();
            f37493a = null;
        }
    }
}
