package com.didi.soda.address;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;

public class CustomerSimpleDecorator implements ItemDecorator {

    /* renamed from: a */
    private static final int f41362a = Color.rgb(100, 100, 100);

    /* renamed from: b */
    private static final int f41363b = 5;

    /* renamed from: c */
    private final Rect f41364c = new Rect();

    /* renamed from: d */
    private int f41365d = 5;

    /* renamed from: e */
    private Paint f41366e = new Paint();

    /* renamed from: f */
    private int f41367f = 0;

    /* renamed from: g */
    private int f41368g = 0;

    /* renamed from: h */
    private boolean f41369h = false;

    public CustomerSimpleDecorator() {
        setDecoratorColor(f41362a);
    }

    public CustomerSimpleDecorator(int i, int i2) {
        setDecoratorColor(i);
        setDecoratorHeight(i2);
    }

    public void enablePositionTopDecorator() {
        this.f41369h = true;
    }

    public void getItemOffsets(Rect rect, int i, int i2) {
        if (!this.f41369h || (i2 & 2) == 0) {
            rect.set(0, 0, 0, this.f41365d);
            return;
        }
        int i3 = this.f41365d;
        rect.set(0, i3, 0, i3);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, int i, int i2) {
        if (recyclerView.getLayoutManager() != null) {
            m31030a(canvas, recyclerView, view, i2);
        }
    }

    public void setDecoratorColor(int i) {
        this.f41366e.setColor(i);
    }

    public void setDecoratorHeight(int i) {
        this.f41365d = i;
    }

    public void setDecoratorPadding(int i, int i2) {
        this.f41367f = i;
        this.f41368g = i2;
    }

    /* renamed from: a */
    private void m31030a(Canvas canvas, RecyclerView recyclerView, View view, int i) {
        int i2;
        int i3;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i3 = recyclerView.getPaddingLeft() + this.f41367f;
            i2 = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - this.f41368g;
            Canvas canvas2 = canvas;
            canvas.clipRect(i3, recyclerView.getPaddingTop(), i2, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            Canvas canvas3 = canvas;
            i3 = this.f41367f;
            i2 = recyclerView.getWidth() - this.f41368g;
        }
        RecyclerView recyclerView2 = recyclerView;
        recyclerView.getDecoratedBoundsWithMargins(view, this.f41364c);
        int round = this.f41364c.bottom + Math.round(ViewCompat.getTranslationY(view));
        int i4 = round - this.f41365d;
        if (this.f41369h && (i & 2) != 0) {
            int round2 = this.f41364c.top + Math.round(ViewCompat.getTranslationY(view));
            canvas.drawRect((float) i3, (float) round2, (float) i2, (float) (this.f41365d + round2), this.f41366e);
        }
        canvas.drawRect((float) i3, (float) i4, (float) i2, (float) round, this.f41366e);
        canvas.restore();
    }
}
