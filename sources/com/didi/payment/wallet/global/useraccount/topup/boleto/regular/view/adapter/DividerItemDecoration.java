package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.adapter;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private Drawable f34527a;

    /* renamed from: b */
    private int f34528b;

    public DividerItemDecoration(Drawable drawable) {
        this.f34527a = drawable;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int i = this.f34528b;
        if (i == 0) {
            m26320a(canvas, recyclerView);
        } else if (i == 1) {
            m26321b(canvas, recyclerView);
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (recyclerView.getChildAdapterPosition(view) != 0) {
            int orientation = ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation();
            this.f34528b = orientation;
            if (orientation == 0) {
                rect.left = this.f34527a.getIntrinsicWidth();
            } else if (orientation == 1) {
                rect.top = this.f34527a.getIntrinsicHeight();
            }
        }
    }

    /* renamed from: a */
    private void m26320a(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View childAt = recyclerView.getChildAt(i);
            int right = childAt.getRight() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).rightMargin;
            this.f34527a.setBounds(right, paddingTop, this.f34527a.getIntrinsicWidth() + right, height);
            this.f34527a.draw(canvas);
        }
    }

    /* renamed from: b */
    private void m26321b(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View childAt = recyclerView.getChildAt(i);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            this.f34527a.setBounds(paddingLeft, bottom, width, this.f34527a.getIntrinsicHeight() + bottom);
            this.f34527a.draw(canvas);
        }
    }
}
