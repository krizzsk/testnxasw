package com.didichuxing.cardscan.p176a;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.hardware.Camera;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import p218io.card.payment.CardScanner;

/* renamed from: com.didichuxing.cardscan.a.d */
public class C16000d {

    /* renamed from: a */
    private static final String f48848a = C16000d.class.getSimpleName();

    /* renamed from: b */
    private static final boolean f48849b = Build.MODEL.equals("DROID2");

    /* renamed from: c */
    private static Boolean f48850c;

    /* renamed from: a */
    public static Rect m36657a(Point point, int i, int i2) {
        int i3 = i / 2;
        int i4 = i2 / 2;
        return new Rect(point.x - i3, point.y - i4, point.x + i3, point.y + i4);
    }

    /* renamed from: a */
    public static void m36658a(Paint paint) {
        paint.setColor(-1);
        paint.setStyle(Paint.Style.FILL);
        paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
        paint.setAntiAlias(true);
        paint.setShadowLayer(1.5f, 0.5f, 0.0f, Color.HSVToColor(200, new float[]{0.0f, 0.0f, 0.0f}));
    }

    /* renamed from: a */
    public static boolean m36659a() {
        if (f48850c == null) {
            f48850c = Boolean.valueOf(m36660b());
        }
        return f48850c.booleanValue();
    }

    /* renamed from: b */
    private static boolean m36660b() {
        if (!CardScanner.processorSupported()) {
            SystemUtils.log(5, "card.io", "- Processor type is not supported", (Throwable) null, "com.didichuxing.cardscan.a.d", -1);
            return false;
        }
        try {
            Camera open = Camera.open();
            if (open == null) {
                SystemUtils.log(5, "card.io", "- No camera found", (Throwable) null, "com.didichuxing.cardscan.a.d", -1);
                return false;
            }
            open.release();
            return true;
        } catch (RuntimeException e) {
            if (Build.VERSION.SDK_INT >= 23) {
                return true;
            }
            SystemUtils.log(5, "card.io", "- Error opening camera: " + e, (Throwable) null, "com.didichuxing.cardscan.a.d", -1);
            return false;
        }
    }
}
