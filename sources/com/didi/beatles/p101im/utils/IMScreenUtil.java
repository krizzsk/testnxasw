package com.didi.beatles.p101im.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

/* renamed from: com.didi.beatles.im.utils.IMScreenUtil */
public class IMScreenUtil {

    /* renamed from: b */
    private static IMScreenUtil f11624b;

    /* renamed from: a */
    private Context f11625a;

    public static IMScreenUtil instance(Context context) {
        if (f11624b == null) {
            f11624b = new IMScreenUtil(context);
        }
        return f11624b;
    }

    public static void expandViewTouchDelegate(View view, int i, int i2, int i3, int i4) {
        final View view2 = view;
        final int i5 = i;
        final int i6 = i2;
        final int i7 = i3;
        final int i8 = i4;
        ((View) view.getParent()).post(new Runnable() {
            public void run() {
                Rect rect = new Rect();
                view2.setEnabled(true);
                view2.getHitRect(rect);
                rect.top -= i5;
                rect.bottom += i6;
                rect.left -= i7;
                rect.right += i8;
                TouchDelegate touchDelegate = new TouchDelegate(rect, view2);
                if (View.class.isInstance(view2.getParent())) {
                    ((View) view2.getParent()).setTouchDelegate(touchDelegate);
                }
            }
        });
    }

    private IMScreenUtil(Context context) {
        this.f11625a = context.getApplicationContext();
    }

    public int getScreenWidth() {
        return this.f11625a.getResources().getDisplayMetrics().widthPixels;
    }

    public int px2dip(int i) {
        return (int) ((((double) i) - 0.5d) / ((double) m10032a(this.f11625a)));
    }

    /* renamed from: a */
    private float m10032a(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public int getScal() {
        return (getScreenWidth() * 100) / 480;
    }

    public int get480Height(int i) {
        return (i * getScreenWidth()) / 480;
    }

    public int getStatusBarHeight() {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return this.f11625a.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getScreenHeight() {
        return this.f11625a.getResources().getDisplayMetrics().heightPixels;
    }
}
