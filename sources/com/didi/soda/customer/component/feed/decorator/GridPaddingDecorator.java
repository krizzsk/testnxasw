package com.didi.soda.customer.component.feed.decorator;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;

public class GridPaddingDecorator implements ItemDecorator {

    /* renamed from: a */
    private int f43371a = 0;

    /* renamed from: b */
    private int f43372b = 0;

    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, int i, int i2) {
    }

    public void getItemOffsets(Rect rect, int i, int i2) {
        if ((i2 & 1) != 0) {
            rect.set(this.f43371a, 0, this.f43372b, 0);
        } else if ((i2 & 4) != 0) {
            rect.set(this.f43372b, 0, this.f43371a, 0);
        }
    }

    public void setBoundMarginPx(int i) {
        this.f43371a = i;
    }

    public void setMiddleMarginPx(int i) {
        this.f43372b = i;
    }
}
