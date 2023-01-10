package com.didi.sdk.global.indexbar.Decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.sdk.global.indexbar.utils.ViewUtil;
import java.util.List;

@Deprecated
public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private static final int f38930a = 1;

    /* renamed from: b */
    private static final int f38931b = -1710619;

    /* renamed from: c */
    private Context f38932c;

    /* renamed from: d */
    private List<String> f38933d;

    /* renamed from: e */
    private Paint f38934e;

    /* renamed from: f */
    private int f38935f;

    /* renamed from: g */
    private int f38936g;

    public DividerItemDecoration(Context context) {
        this.f38932c = context;
        this.f38935f = ViewUtil.dip2px(context, 18.0f);
        this.f38936g = 0;
        Paint paint = new Paint();
        this.f38934e = paint;
        paint.setAntiAlias(true);
        this.f38934e.setColor(f38931b);
    }

    public DividerItemDecoration(Context context, List<String> list) {
        this(context);
        this.f38933d = list;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager) || 1 == ((LinearLayoutManager) layoutManager).getOrientation()) {
            List<String> list = this.f38933d;
            if (list == null || list.isEmpty()) {
                rect.set(0, 0, 0, 1);
                return;
            }
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int i = childAdapterPosition + 1;
            if (i < this.f38933d.size() && this.f38933d.get(childAdapterPosition).equals(this.f38933d.get(i))) {
                rect.set(0, 0, 0, 1);
            }
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager) || 1 == ((LinearLayoutManager) layoutManager).getOrientation()) {
            for (int i = 0; i < recyclerView.getChildCount(); i++) {
                View childAt = recyclerView.getChildAt(i);
                List<String> list = this.f38933d;
                if (list == null || list.isEmpty()) {
                    m29280a(canvas, recyclerView, childAt);
                } else {
                    int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
                    int i2 = childAdapterPosition + 1;
                    if (i2 < this.f38933d.size() && this.f38933d.get(childAdapterPosition).equals(this.f38933d.get(i2))) {
                        m29280a(canvas, recyclerView, childAt);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m29280a(Canvas canvas, RecyclerView recyclerView, View view) {
        int paddingLeft = this.f38935f + recyclerView.getPaddingLeft();
        int bottom = view.getBottom() + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
        canvas.drawRect((float) paddingLeft, (float) bottom, (float) (recyclerView.getWidth() - this.f38936g), (float) (bottom + 1), this.f38934e);
    }

    public DividerItemDecoration setDevideColor(int i) {
        this.f38934e.setColor(i);
        return this;
    }
}
