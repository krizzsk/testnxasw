package com.didi.component.base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

public class XRay {

    /* renamed from: a */
    private static final XRay f12820a = new XRay();

    /* renamed from: b */
    private static final int f12821b = 50;

    /* renamed from: c */
    private static final float f12822c = 0.9f;

    /* renamed from: d */
    private static final int f12823d = 30;

    /* renamed from: e */
    private static final int f12824e = -65536;

    /* renamed from: f */
    private boolean f12825f;

    /* renamed from: g */
    private Paint f12826g;

    private XRay() {
        Paint paint = new Paint();
        this.f12826g = paint;
        paint.setTextSize(30.0f);
        this.f12826g.setColor(-65536);
    }

    public static void toggle() {
        XRay xRay = f12820a;
        xRay.f12825f = !xRay.f12825f;
    }

    /* renamed from: a */
    static boolean m10815a() {
        return f12820a.f12825f;
    }

    /* renamed from: a */
    static void m10814a(BaseComponent baseComponent) {
        Bitmap bitmap;
        if (Build.VERSION.SDK_INT >= 16) {
            View view = baseComponent.getView() != null ? baseComponent.getView().getView() : null;
            if (view != null) {
                String b = m10816b(baseComponent);
                int a = f12820a.m10811a(b);
                Drawable background = view.getBackground();
                if (background != null) {
                    bitmap = m10812a(background, a);
                } else {
                    bitmap = Bitmap.createBitmap(a, 50, Bitmap.Config.ARGB_8888);
                }
                f12820a.m10813a(bitmap, b);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(view.getContext().getResources(), bitmap);
                bitmapDrawable.setGravity(17);
                view.setBackground(bitmapDrawable);
                view.setAlpha(f12822c);
            }
        }
    }

    /* renamed from: a */
    private static Bitmap m10812a(Drawable drawable, int i) {
        Bitmap bitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(i, 50, Bitmap.Config.ARGB_8888);
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }
        drawable.draw(new Canvas(bitmap));
        return bitmap;
    }

    /* renamed from: b */
    private static String m10816b(BaseComponent baseComponent) {
        String str = (String) baseComponent.getExtra("BUNDLE_KEY_TYPE");
        return str != null ? str : "";
    }

    /* renamed from: a */
    private void m10813a(Bitmap bitmap, String str) {
        new Canvas(bitmap).drawText(str, (((float) bitmap.getWidth()) - this.f12826g.measureText(str)) / 2.0f, ((float) bitmap.getHeight()) / 2.0f, this.f12826g);
    }

    /* renamed from: a */
    private int m10811a(String str) {
        return ((int) this.f12826g.measureText(str)) + 1;
    }
}
