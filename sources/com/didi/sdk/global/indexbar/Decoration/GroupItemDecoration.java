package com.didi.sdk.global.indexbar.Decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.sdk.global.indexbar.utils.ViewUtil;
import java.util.List;

@Deprecated
public class GroupItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private static final int f38937a = -789259;

    /* renamed from: b */
    private static final int f38938b = -16777216;

    /* renamed from: c */
    private int f38939c;

    /* renamed from: d */
    private int f38940d;

    /* renamed from: e */
    private Paint f38941e;

    /* renamed from: f */
    private TextPaint f38942f;

    /* renamed from: g */
    private Context f38943g;

    /* renamed from: h */
    private List<String> f38944h;

    public GroupItemDecoration(Context context, List<String> list) {
        this.f38943g = context;
        this.f38944h = list;
        this.f38939c = ViewUtil.dip2px(context, 28.0f);
        this.f38940d = ViewUtil.dip2px(context, 18.0f);
        Paint paint = new Paint();
        this.f38941e = paint;
        paint.setAntiAlias(true);
        this.f38941e.setColor(f38937a);
        TextPaint textPaint = new TextPaint();
        this.f38942f = textPaint;
        textPaint.setAntiAlias(true);
        this.f38942f.setColor(-16777216);
        this.f38942f.setTextSize((float) ViewUtil.sp2px(context, 14.0f));
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        List<String> list = this.f38944h;
        if (list != null && !list.isEmpty()) {
            if (!(recyclerView.getLayoutManager() instanceof LinearLayoutManager) || ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation() == 1) {
                int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                if (childAdapterPosition == 0 || !this.f38944h.get(childAdapterPosition).equals(this.f38944h.get(childAdapterPosition - 1))) {
                    rect.set(0, this.f38939c, 0, 0);
                }
            }
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        List<String> list = this.f38944h;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < recyclerView.getChildCount(); i++) {
                View childAt = recyclerView.getChildAt(i);
                int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
                String str = this.f38944h.get(childAdapterPosition);
                if (childAdapterPosition == 0 || !str.equals(this.f38944h.get(childAdapterPosition - 1))) {
                    m29284a(canvas, recyclerView, childAt, str);
                }
            }
        }
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDrawOver(canvas, recyclerView, state);
        List<String> list = this.f38944h;
        if (list != null && !list.isEmpty()) {
            int findFirstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            View view = recyclerView.findViewHolderForAdapterPosition(findFirstVisibleItemPosition).itemView;
            String str = this.f38944h.get(findFirstVisibleItemPosition);
            boolean z = false;
            int i = findFirstVisibleItemPosition + 1;
            if (i < this.f38944h.size() && !str.equals(this.f38944h.get(i)) && view.getBottom() <= this.f38939c) {
                canvas.save();
                canvas.translate(0.0f, (float) ((view.getHeight() + view.getTop()) - this.f38939c));
                z = true;
            }
            m29285a(canvas, recyclerView, str);
            if (z) {
                canvas.restore();
            }
        }
    }

    /* renamed from: a */
    private void m29284a(Canvas canvas, RecyclerView recyclerView, View view, String str) {
        m29283a(canvas, m29282a(recyclerView, view), str);
    }

    /* renamed from: a */
    private void m29285a(Canvas canvas, RecyclerView recyclerView, String str) {
        m29283a(canvas, m29281a(recyclerView), str);
    }

    /* renamed from: a */
    private void m29283a(Canvas canvas, Rect rect, String str) {
        canvas.drawRect(rect, this.f38941e);
        canvas.drawText(str, (float) (rect.left + this.f38940d), (float) (rect.top + ((this.f38939c + ViewUtil.getTextHeight(this.f38942f, str)) / 2)), this.f38942f);
    }

    /* renamed from: a */
    private Rect m29282a(RecyclerView recyclerView, View view) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int top = view.getTop() - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
        return new Rect(paddingLeft, top - this.f38939c, width, top);
    }

    /* renamed from: a */
    private Rect m29281a(RecyclerView recyclerView) {
        return new Rect(recyclerView.getPaddingLeft(), 0, recyclerView.getWidth() - recyclerView.getPaddingRight(), this.f38939c);
    }
}
