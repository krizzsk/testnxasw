package com.didi.component.traveldetail;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.common.util.UIUtils;
import com.didichuxing.drtl.tookit.DRtlToolkit;

public class CommonTravelDetailItemDecorationV2 extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private int f18031a;

    /* renamed from: b */
    private int f18032b;

    /* renamed from: c */
    private int f18033c;

    /* renamed from: d */
    private int f18034d = 0;

    /* renamed from: e */
    private Paint f18035e;

    /* renamed from: f */
    private Paint f18036f;

    public CommonTravelDetailItemDecorationV2(Context context) {
        this.f18032b = UIUtils.dip2pxInt(context, 5.0f);
        this.f18033c = UIUtils.dip2pxInt(context, 2.0f);
        this.f18031a = UIUtils.dip2pxInt(context, 28.0f);
        Paint paint = new Paint();
        this.f18035e = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f18036f = paint2;
        paint2.setColor(Color.parseColor("#D4D7D9"));
        this.f18036f.setAntiAlias(true);
        this.f18036f.setStyle(Paint.Style.STROKE);
        this.f18036f.setStrokeWidth((float) this.f18033c);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.bottom = this.f18032b;
        rect.top = this.f18032b;
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            rect.top = 0;
        } else if (recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getItemCount() - 1) {
            rect.bottom = 0;
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int i;
        int childCount = recyclerView.getChildCount();
        if (childCount != 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                if (DRtlToolkit.rtl()) {
                    i = childAt.getRight() - (this.f18031a / 2);
                } else {
                    i = childAt.getLeft() + (this.f18031a / 2);
                }
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                int measuredHeight = (childAt.getMeasuredHeight() / 2) + top;
                int i3 = i + this.f18034d;
                Path path = new Path();
                if (i2 != 0) {
                    float f = (float) i3;
                    path.moveTo(f, (float) (top - this.f18032b));
                    path.lineTo(f, (float) (measuredHeight - this.f18034d));
                    canvas.drawPath(path, this.f18036f);
                }
                if (i2 != childCount - 1) {
                    path.reset();
                    float f2 = (float) i3;
                    path.moveTo(f2, (float) (measuredHeight + this.f18034d));
                    path.lineTo(f2, (float) (bottom + this.f18032b));
                    canvas.drawPath(path, this.f18036f);
                }
            }
        }
    }
}
