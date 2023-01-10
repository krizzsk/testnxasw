package p230const;

import android.graphics.Color;
import com.iproov.sdk.cameray.C20776try;
import com.iproov.sdk.cameray.Orientation;
import p241goto.C21997if;

/* renamed from: const.for */
/* compiled from: RendererUtils */
public class C21728for {
    /* renamed from: do */
    public static float[] m44663do(int i) {
        return new float[]{((float) Color.red(i)) / 255.0f, ((float) Color.green(i)) / 255.0f, ((float) Color.blue(i)) / 255.0f};
    }

    /* renamed from: if */
    public static int m44664if(int i) {
        return Color.rgb((Color.red(i) + 153) % 255, (Color.green(i) + 153) % 255, (Color.blue(i) + 153) % 255);
    }

    /* renamed from: do */
    public static C21997if m44662do(C20776try tryR, int i, int i2, Orientation orientation) {
        int i3;
        int i4;
        int i5;
        if (orientation.isPortrait()) {
            i3 = tryR.m48075new().mo171312if().mo180435if();
            i4 = tryR.m48075new().mo171312if().mo180432do();
        } else {
            i3 = tryR.m48075new().mo171312if().mo180432do();
            i4 = tryR.m48075new().mo171312if().mo180435if();
        }
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        double d = ((double) i4) / ((double) i3);
        int i6 = (int) (((double) abs) * d);
        if (abs2 > i6) {
            i5 = abs;
        } else {
            i5 = (int) (((double) abs2) / d);
            i6 = abs2;
        }
        return new C21997if(i5, i6, (abs - i5) / 2, (abs2 - i6) / 2);
    }
}
