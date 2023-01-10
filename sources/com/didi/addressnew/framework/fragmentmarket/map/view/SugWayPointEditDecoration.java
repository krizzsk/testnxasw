package com.didi.addressnew.framework.fragmentmarket.map.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.common.map.util.DisplayUtils;

public class SugWayPointEditDecoration extends RecyclerView.ItemDecoration {
    public static boolean IS_DRAW_DIVIDER = true;

    /* renamed from: a */
    private int f9018a;

    /* renamed from: b */
    private int f9019b;

    /* renamed from: c */
    private float f9020c;

    /* renamed from: d */
    private int f9021d;

    /* renamed from: e */
    private int f9022e;

    /* renamed from: f */
    private Paint f9023f;

    /* renamed from: g */
    private int f9024g;

    /* renamed from: h */
    private Path f9025h = new Path();

    /* renamed from: i */
    private Context f9026i;

    public SugWayPointEditDecoration(Context context) {
        this.f9026i = context;
        this.f9018a = DisplayUtils.dp2px(context, 1.0f);
        this.f9019b = DisplayUtils.dp2px(context, 12.0f);
        this.f9021d = DisplayUtils.dp2px(context, 2.0f);
        this.f9024g = DisplayUtils.dp2px(context, 37.0f);
        this.f9020c = (float) (DisplayUtils.dp2px(context, 36.0f) - this.f9019b);
        this.f9022e = DisplayUtils.dp2px(context, 4.0f);
        Paint paint = new Paint(1);
        this.f9023f = paint;
        paint.setStrokeWidth((float) this.f9018a);
        this.f9023f.setStyle(Paint.Style.STROKE);
        this.f9023f.setPathEffect(new DashPathEffect(new float[]{(float) DisplayUtils.dp2px(context, 4.0f), (float) DisplayUtils.dp2px(context, 4.0f)}, (float) DisplayUtils.dp2px(context, 4.0f)));
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.bottom = this.f9021d;
        rect.left = this.f9019b;
        if (recyclerView.indexOfChild(view) == 0) {
            rect.top = DisplayUtils.dp2px(this.f9026i, 9.0f);
        }
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (IS_DRAW_DIVIDER && recyclerView.getChildCount() > 2) {
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount - 1; i++) {
                View childAt = recyclerView.getChildAt(i);
                float left = ((float) childAt.getLeft()) + this.f9020c;
                float top = (float) (childAt.getTop() + DisplayUtils.dp2px(this.f9026i, 21.0f));
                float f = ((float) this.f9024g) + top;
                this.f9025h.reset();
                this.f9025h.moveTo(left, top);
                this.f9025h.lineTo(left, f);
                canvas.drawPath(this.f9025h, this.f9023f);
            }
        }
    }
}
