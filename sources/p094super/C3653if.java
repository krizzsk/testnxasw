package p094super;

import android.graphics.Bitmap;
import android.graphics.Color;

/* renamed from: super.if */
/* compiled from: Histogram */
public class C3653if {

    /* renamed from: a */
    private final int[] f8719a = new int[256];

    /* renamed from: b */
    private final int f8720b;

    public C3653if(Bitmap bitmap) {
        int width = bitmap.getWidth() * bitmap.getHeight();
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        for (int i = 0; i < width; i++) {
            int i2 = iArr[i];
            int[] iArr2 = this.f8719a;
            int blue = Color.blue(i2);
            iArr2[blue] = iArr2[blue] + 1;
        }
        this.f8720b = width;
    }

    /* renamed from: do */
    public int mo43471do(double d) {
        int i = (int) (((double) this.f8720b) * d);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = this.f8719a;
            if (i2 >= iArr.length) {
                return -1;
            }
            i3 += iArr[i2];
            if (i3 > i) {
                return i2;
            }
            i2++;
        }
    }
}
