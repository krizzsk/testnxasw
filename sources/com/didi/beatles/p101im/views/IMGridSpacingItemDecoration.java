package com.didi.beatles.p101im.views;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: com.didi.beatles.im.views.IMGridSpacingItemDecoration */
public class IMGridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private int f11718a;

    /* renamed from: b */
    private int f11719b;

    /* renamed from: c */
    private boolean f11720c;

    public IMGridSpacingItemDecoration(int i, int i2, boolean z) {
        this.f11718a = i;
        this.f11719b = i2;
        this.f11720c = z;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = this.f11718a;
        int i2 = childAdapterPosition % i;
        if (this.f11720c) {
            int i3 = this.f11719b;
            rect.left = i3 - ((i2 * i3) / i);
            rect.right = ((i2 + 1) * this.f11719b) / this.f11718a;
            if (childAdapterPosition < this.f11718a) {
                rect.top = this.f11719b;
            }
            rect.bottom = this.f11719b;
            return;
        }
        rect.left = (this.f11719b * i2) / i;
        int i4 = this.f11719b;
        rect.right = i4 - (((i2 + 1) * i4) / this.f11718a);
        if (childAdapterPosition < this.f11718a) {
            rect.top = this.f11719b;
        }
        rect.bottom = this.f11719b;
    }
}
