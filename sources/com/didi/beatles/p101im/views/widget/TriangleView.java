package com.didi.beatles.p101im.views.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.passenger.C11267R;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.widget.TriangleView */
public class TriangleView extends View {

    /* renamed from: a */
    private static final Direction f12340a = Direction.LEFT;

    /* renamed from: b */
    private static final int f12341b = IMResource.getColor(R.color.im_color_guide_view_bg);

    /* renamed from: c */
    private Paint f12342c;

    /* renamed from: d */
    private Path f12343d;

    /* renamed from: e */
    private Direction f12344e;

    /* renamed from: f */
    private int f12345f;

    /* renamed from: com.didi.beatles.im.views.widget.TriangleView$Direction */
    public enum Direction {
        LEFT,
        UP,
        RIGHT,
        DOWN
    }

    public TriangleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TriangleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TriangleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10525a(attributeSet);
    }

    /* renamed from: a */
    private void m10525a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C11267R.styleable.TriangleView);
            int i = obtainStyledAttributes.getInt(1, 0);
            if (i == 0) {
                this.f12344e = Direction.LEFT;
            } else if (i == 1) {
                this.f12344e = Direction.UP;
            } else if (i != 2) {
                this.f12344e = Direction.DOWN;
            } else {
                this.f12344e = Direction.RIGHT;
            }
            this.f12345f = obtainStyledAttributes.getColor(0, f12341b);
            obtainStyledAttributes.recycle();
        } else {
            this.f12344e = f12340a;
            this.f12345f = f12341b;
        }
        Paint paint = new Paint();
        this.f12342c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f12342c.setColor(this.f12345f);
        this.f12342c.setAntiAlias(true);
    }

    public void setColor(int i) {
        if (this.f12345f != i) {
            this.f12345f = i;
            Paint paint = this.f12342c;
            if (paint != null) {
                paint.setColor(i);
            }
            this.f12343d = null;
            invalidate();
        }
    }

    public void setDirection(Direction direction) {
        if (direction != this.f12344e) {
            this.f12344e = direction;
            this.f12343d = null;
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(getTrianglePath(), this.f12342c);
    }

    private Path getTrianglePath() {
        Point point;
        Point point2;
        Point point3;
        if (this.f12343d == null) {
            this.f12343d = new Path();
            int width = getWidth();
            int height = getHeight();
            int i = C49521.f12346xeb30cb29[this.f12344e.ordinal()];
            if (i == 1) {
                point3 = new Point(width, 0);
                point2 = new Point(width, height);
                point = new Point(0, height / 2);
            } else if (i == 2) {
                point3 = new Point(0, height);
                point2 = new Point(width, height);
                point = new Point(width / 2, 0);
            } else if (i != 3) {
                point3 = new Point(0, 0);
                point2 = new Point(width, 0);
                point = new Point(width / 2, height);
            } else {
                point3 = new Point(0, 0);
                point2 = new Point(0, height);
                point = new Point(width, height / 2);
            }
            this.f12343d.moveTo((float) point3.x, (float) point3.y);
            this.f12343d.lineTo((float) point2.x, (float) point2.y);
            this.f12343d.lineTo((float) point.x, (float) point.y);
        }
        return this.f12343d;
    }

    /* renamed from: com.didi.beatles.im.views.widget.TriangleView$1 */
    static /* synthetic */ class C49521 {

        /* renamed from: $SwitchMap$com$didi$beatles$im$views$widget$TriangleView$Direction */
        static final /* synthetic */ int[] f12346xeb30cb29;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.beatles.im.views.widget.TriangleView$Direction[] r0 = com.didi.beatles.p101im.views.widget.TriangleView.Direction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12346xeb30cb29 = r0
                com.didi.beatles.im.views.widget.TriangleView$Direction r1 = com.didi.beatles.p101im.views.widget.TriangleView.Direction.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f12346xeb30cb29     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.beatles.im.views.widget.TriangleView$Direction r1 = com.didi.beatles.p101im.views.widget.TriangleView.Direction.UP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f12346xeb30cb29     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.beatles.im.views.widget.TriangleView$Direction r1 = com.didi.beatles.p101im.views.widget.TriangleView.Direction.RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f12346xeb30cb29     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.beatles.im.views.widget.TriangleView$Direction r1 = com.didi.beatles.p101im.views.widget.TriangleView.Direction.DOWN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p101im.views.widget.TriangleView.C49521.<clinit>():void");
        }
    }
}
