package p235do;

import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraCharacteristics;
import p094super.C3641break;

/* renamed from: do.else */
/* compiled from: CameraUtils */
public class C21823else {
    /* renamed from: do */
    public static Float m45134do(CameraCharacteristics cameraCharacteristics) {
        float[] fArr = (float[]) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
        if (fArr == null) {
            return null;
        }
        return Float.valueOf(fArr[0]);
    }

    /* renamed from: do */
    public static Double m45133do(String str) {
        if (str == null) {
            return null;
        }
        if (str.contains("/")) {
            return Double.valueOf(new C3641break().mo43433do(str));
        }
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Exif Value NaN: ");
            sb.append(str);
            return null;
        }
    }

    /* renamed from: do */
    public static Double m45132do(Integer num) {
        if (num == null) {
            return null;
        }
        try {
            return Double.valueOf((double) num.intValue());
        } catch (NumberFormatException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Exif Value NaN: ");
            sb.append(num);
            return null;
        }
    }

    /* renamed from: do */
    public static Double m45131do(Float f) {
        if (f == null) {
            return null;
        }
        try {
            return Double.valueOf((double) f.floatValue());
        } catch (NumberFormatException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Exif Value NaN: ");
            sb.append(f);
            return null;
        }
    }

    /* renamed from: do */
    public static Rect m45129do(Rect rect, Double d) {
        int width = rect.width();
        int doubleValue = (int) (((double) width) / d.doubleValue());
        int height = rect.height();
        int doubleValue2 = (int) (((double) height) / d.doubleValue());
        int i = rect.left + ((width - doubleValue) / 2);
        int i2 = rect.top + ((height - doubleValue2) / 2);
        return new Rect(i, i2, doubleValue + i, doubleValue2 + i2);
    }

    /* renamed from: do */
    public static Rect m45130do(RectF rectF) {
        return new Rect(Math.max(-1000, (int) ((((double) rectF.left) - 0.5d) * 2000.0d)), Math.max(-1000, (int) ((((double) rectF.top) - 0.5d) * 2000.0d)), Math.min(1000, (int) ((((double) rectF.right) - 0.5d) * 2000.0d)), Math.min(1000, (int) ((((double) rectF.bottom) - 0.5d) * 2000.0d)));
    }
}
