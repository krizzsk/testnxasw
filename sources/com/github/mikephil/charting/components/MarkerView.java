package com.github.mikephil.charting.components;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import java.lang.ref.WeakReference;

public class MarkerView extends RelativeLayout implements IMarker {

    /* renamed from: a */
    private MPPointF f54870a = new MPPointF();

    /* renamed from: b */
    private MPPointF f54871b = new MPPointF();

    /* renamed from: c */
    private WeakReference<Chart> f54872c;

    public MarkerView(Context context, int i) {
        super(context);
        setupLayoutResource(i);
    }

    private void setupLayoutResource(int i) {
        View inflate = LayoutInflater.from(getContext()).inflate(i, this);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
    }

    public void setOffset(MPPointF mPPointF) {
        this.f54870a = mPPointF;
        if (mPPointF == null) {
            this.f54870a = new MPPointF();
        }
    }

    public void setOffset(float f, float f2) {
        this.f54870a.f55042x = f;
        this.f54870a.f55043y = f2;
    }

    public MPPointF getOffset() {
        return this.f54870a;
    }

    public void setChartView(Chart chart) {
        this.f54872c = new WeakReference<>(chart);
    }

    public Chart getChartView() {
        WeakReference<Chart> weakReference = this.f54872c;
        if (weakReference == null) {
            return null;
        }
        return (Chart) weakReference.get();
    }

    public MPPointF getOffsetForDrawingAtPoint(float f, float f2) {
        MPPointF offset = getOffset();
        this.f54871b.f55042x = offset.f55042x;
        this.f54871b.f55043y = offset.f55043y;
        Chart chartView = getChartView();
        float width = (float) getWidth();
        float height = (float) getHeight();
        if (this.f54871b.f55042x + f < 0.0f) {
            this.f54871b.f55042x = -f;
        } else if (chartView != null && f + width + this.f54871b.f55042x > ((float) chartView.getWidth())) {
            this.f54871b.f55042x = (((float) chartView.getWidth()) - f) - width;
        }
        if (this.f54871b.f55043y + f2 < 0.0f) {
            this.f54871b.f55043y = -f2;
        } else if (chartView != null && f2 + height + this.f54871b.f55043y > ((float) chartView.getHeight())) {
            this.f54871b.f55043y = (((float) chartView.getHeight()) - f2) - height;
        }
        return this.f54871b;
    }

    public void refreshContent(Entry entry, Highlight highlight) {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    public void draw(Canvas canvas, float f, float f2) {
        MPPointF offsetForDrawingAtPoint = getOffsetForDrawingAtPoint(f, f2);
        int save = canvas.save();
        canvas.translate(f + offsetForDrawingAtPoint.f55042x, f2 + offsetForDrawingAtPoint.f55043y);
        draw(canvas);
        canvas.restoreToCount(save);
    }
}
