package com.didiglobal.mew.framework.widget.p201ff;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: com.didiglobal.mew.framework.widget.ff.MSpaceItemDecoration */
public class MSpaceItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private int f52787a;

    /* renamed from: b */
    private int f52788b;

    /* renamed from: c */
    private int f52789c;

    /* renamed from: d */
    private int f52790d;

    /* renamed from: e */
    private Context f52791e;

    public MSpaceItemDecoration(int i, Context context) {
        this.f52787a = i;
        this.f52788b = i;
        this.f52789c = i;
        this.f52790d = i;
        this.f52791e = context;
    }

    public MSpaceItemDecoration(int i, int i2, int i3, int i4, Context context) {
        this.f52787a = i;
        this.f52788b = i2;
        this.f52789c = i3;
        this.f52790d = i4;
        this.f52791e = context;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.left = this.f52787a;
        rect.top = this.f52788b;
        rect.right = this.f52789c;
        rect.bottom = this.f52790d;
    }
}
