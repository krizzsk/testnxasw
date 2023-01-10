package com.didi.beatles.p101im.views.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.beatles.im.views.widget.WaterMarkBg */
public class WaterMarkBg extends Drawable {

    /* renamed from: a */
    private Paint f12348a = new Paint();

    /* renamed from: b */
    private List<String> f12349b;

    /* renamed from: c */
    private Context f12350c;

    /* renamed from: d */
    private int f12351d;

    /* renamed from: e */
    private int f12352e;

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public WaterMarkBg(Context context, List<String> list, int i, int i2) {
        this.f12349b = list;
        this.f12350c = context;
        this.f12351d = i;
        this.f12352e = i2;
    }

    public void draw(Canvas canvas) {
        int i = getBounds().right;
        int i2 = getBounds().bottom;
        this.f12348a.setColor(this.f12350c.getResources().getColor(R.color.im_color_water_mark_color));
        this.f12348a.setAntiAlias(true);
        this.f12348a.setTextSize((float) sp2px(this.f12350c, (float) this.f12352e));
        canvas.save();
        canvas.rotate((float) this.f12351d);
        float measureText = this.f12348a.measureText(this.f12349b.get(0));
        int i3 = i2 / 10;
        int i4 = i3;
        int i5 = 0;
        while (i4 <= i2) {
            float f = (float) (-i);
            int i6 = i5 + 1;
            float f2 = (float) (i5 % 2);
            while (true) {
                f += f2 * measureText;
                if (f >= ((float) i)) {
                    break;
                }
                int i7 = 0;
                for (String drawText : this.f12349b) {
                    canvas.drawText(drawText, f, (float) (i4 + i7), this.f12348a);
                    i7 += 50;
                }
                f2 = 2.0f;
            }
            i4 += i3 + 80;
            i5 = i6;
        }
        canvas.restore();
    }

    public static int sp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
