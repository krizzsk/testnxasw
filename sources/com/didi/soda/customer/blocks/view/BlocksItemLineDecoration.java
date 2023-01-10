package com.didi.soda.customer.blocks.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J2\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\t¨\u0006\u001f"}, mo148868d2 = {"Lcom/didi/soda/customer/blocks/view/BlocksItemLineDecoration;", "Lcom/didi/app/nova/support/view/recyclerview/decorator/ItemDecorator;", "color", "", "height", "leftMargin", "rightMargin", "(IIII)V", "getColor", "()I", "setColor", "(I)V", "getHeight", "setHeight", "getLeftMargin", "mPaint", "Landroid/graphics/Paint;", "getRightMargin", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "position", "positionType", "onDraw", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "child", "Landroid/view/View;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BlocksItemLineDecoration.kt */
public final class BlocksItemLineDecoration implements ItemDecorator {

    /* renamed from: a */
    private int f43248a;

    /* renamed from: b */
    private int f43249b;

    /* renamed from: c */
    private final int f43250c;

    /* renamed from: d */
    private final int f43251d;

    /* renamed from: e */
    private Paint f43252e;

    public BlocksItemLineDecoration(int i, int i2, int i3, int i4) {
        this.f43248a = i;
        this.f43249b = i2;
        this.f43250c = i3;
        this.f43251d = i4;
        Paint paint = new Paint();
        this.f43252e = paint;
        paint.setColor(this.f43248a);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BlocksItemLineDecoration(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, (i5 & 8) != 0 ? i3 : i4);
    }

    public final int getColor() {
        return this.f43248a;
    }

    public final int getHeight() {
        return this.f43249b;
    }

    public final int getLeftMargin() {
        return this.f43250c;
    }

    public final int getRightMargin() {
        return this.f43251d;
    }

    public final void setColor(int i) {
        this.f43248a = i;
    }

    public final void setHeight(int i) {
        this.f43249b = i;
    }

    public void getItemOffsets(Rect rect, int i, int i2) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        rect.bottom = this.f43249b;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(view, "child");
        if (recyclerView != null) {
            int width = recyclerView.getWidth() - this.f43251d;
            Canvas canvas2 = canvas;
            canvas2.drawRect((float) this.f43250c, (float) view.getBottom(), (float) width, ((float) view.getBottom()) + ((float) this.f43249b), this.f43252e);
        }
    }
}
