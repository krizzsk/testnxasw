package com.github.mikephil.charting.components;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointF;
import java.lang.ref.WeakReference;

public class MarkerImage implements IMarker {

    /* renamed from: a */
    private Context f54863a;

    /* renamed from: b */
    private Drawable f54864b;

    /* renamed from: c */
    private MPPointF f54865c = new MPPointF();

    /* renamed from: d */
    private MPPointF f54866d = new MPPointF();

    /* renamed from: e */
    private WeakReference<Chart> f54867e;

    /* renamed from: f */
    private FSize f54868f = new FSize();

    /* renamed from: g */
    private Rect f54869g = new Rect();

    public void refreshContent(Entry entry, Highlight highlight) {
    }

    public MarkerImage(Context context, int i) {
        this.f54863a = context;
        if (Build.VERSION.SDK_INT >= 21) {
            this.f54864b = this.f54863a.getResources().getDrawable(i, (Resources.Theme) null);
        } else {
            this.f54864b = this.f54863a.getResources().getDrawable(i);
        }
    }

    public void setOffset(MPPointF mPPointF) {
        this.f54865c = mPPointF;
        if (mPPointF == null) {
            this.f54865c = new MPPointF();
        }
    }

    public void setOffset(float f, float f2) {
        this.f54865c.f55042x = f;
        this.f54865c.f55043y = f2;
    }

    public MPPointF getOffset() {
        return this.f54865c;
    }

    public void setSize(FSize fSize) {
        this.f54868f = fSize;
        if (fSize == null) {
            this.f54868f = new FSize();
        }
    }

    public FSize getSize() {
        return this.f54868f;
    }

    public void setChartView(Chart chart) {
        this.f54867e = new WeakReference<>(chart);
    }

    public Chart getChartView() {
        WeakReference<Chart> weakReference = this.f54867e;
        if (weakReference == null) {
            return null;
        }
        return (Chart) weakReference.get();
    }

    public MPPointF getOffsetForDrawingAtPoint(float f, float f2) {
        Drawable drawable;
        Drawable drawable2;
        MPPointF offset = getOffset();
        this.f54866d.f55042x = offset.f55042x;
        this.f54866d.f55043y = offset.f55043y;
        Chart chartView = getChartView();
        float f3 = this.f54868f.width;
        float f4 = this.f54868f.height;
        if (f3 == 0.0f && (drawable2 = this.f54864b) != null) {
            f3 = (float) drawable2.getIntrinsicWidth();
        }
        if (f4 == 0.0f && (drawable = this.f54864b) != null) {
            f4 = (float) drawable.getIntrinsicHeight();
        }
        if (this.f54866d.f55042x + f < 0.0f) {
            this.f54866d.f55042x = -f;
        } else if (chartView != null && f + f3 + this.f54866d.f55042x > ((float) chartView.getWidth())) {
            this.f54866d.f55042x = (((float) chartView.getWidth()) - f) - f3;
        }
        if (this.f54866d.f55043y + f2 < 0.0f) {
            this.f54866d.f55043y = -f2;
        } else if (chartView != null && f2 + f4 + this.f54866d.f55043y > ((float) chartView.getHeight())) {
            this.f54866d.f55043y = (((float) chartView.getHeight()) - f2) - f4;
        }
        return this.f54866d;
    }

    public void draw(Canvas canvas, float f, float f2) {
        if (this.f54864b != null) {
            MPPointF offsetForDrawingAtPoint = getOffsetForDrawingAtPoint(f, f2);
            float f3 = this.f54868f.width;
            float f4 = this.f54868f.height;
            if (f3 == 0.0f) {
                f3 = (float) this.f54864b.getIntrinsicWidth();
            }
            if (f4 == 0.0f) {
                f4 = (float) this.f54864b.getIntrinsicHeight();
            }
            this.f54864b.copyBounds(this.f54869g);
            this.f54864b.setBounds(this.f54869g.left, this.f54869g.top, this.f54869g.left + ((int) f3), this.f54869g.top + ((int) f4));
            int save = canvas.save();
            canvas.translate(f + offsetForDrawingAtPoint.f55042x, f2 + offsetForDrawingAtPoint.f55043y);
            this.f54864b.draw(canvas);
            canvas.restoreToCount(save);
            this.f54864b.setBounds(this.f54869g);
        }
    }
}
