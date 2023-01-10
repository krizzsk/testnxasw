package com.didi.component.expectation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taxis99.R;

public class AnyCarBubbleTipLayout extends LinearLayout {

    /* renamed from: a */
    private Context f15516a;

    /* renamed from: b */
    private int f15517b;

    /* renamed from: c */
    private int f15518c;

    /* renamed from: d */
    private Point f15519d;

    /* renamed from: e */
    private int f15520e;

    /* renamed from: f */
    private int f15521f;

    /* renamed from: g */
    private Paint f15522g;

    /* renamed from: h */
    private Path f15523h;

    /* renamed from: i */
    private RectF f15524i;

    /* renamed from: j */
    private TextView f15525j;

    public AnyCarBubbleTipLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public AnyCarBubbleTipLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnyCarBubbleTipLayout(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public AnyCarBubbleTipLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f15516a = context;
        this.f15517b = context.getResources().getDimensionPixelOffset(R.dimen.lego_bubble_default_offset);
        this.f15520e = context.getResources().getDimensionPixelOffset(R.dimen.lego_bubble_triangle_width);
        this.f15521f = context.getResources().getDimensionPixelOffset(R.dimen.lego_bubble_triangle_height);
        this.f15518c = context.getResources().getDimensionPixelOffset(R.dimen.lego_bubble_default_radius);
        m12808a();
    }

    /* renamed from: a */
    private void m12808a() {
        Paint paint = new Paint();
        this.f15522g = paint;
        paint.setAntiAlias(true);
        this.f15523h = new Path();
        this.f15524i = new RectF();
        this.f15519d = new Point();
        setWillNotDraw(false);
        inflate(this.f15516a, R.layout.anycar_bubble_tip_layout, this);
        this.f15525j = (TextView) findViewById(R.id.center_text);
    }

    /* access modifiers changed from: package-private */
    public void setText(String str) {
        this.f15525j.setText(str);
    }

    /* access modifiers changed from: package-private */
    public void setTypeface(int i) {
        this.f15525j.setTypeface(Typeface.SANS_SERIF, i);
    }

    /* access modifiers changed from: package-private */
    public void setMaxLines(int i) {
        this.f15525j.setMaxLines(i);
        this.f15525j.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
    }

    public void setBubbleBackgroundColor(int i) {
        this.f15522g.setColor(i);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.f15519d.x > 0 && this.f15519d.y > 0) {
            m12809a(canvas);
        }
        super.dispatchDraw(canvas);
    }

    /* renamed from: a */
    private void m12809a(Canvas canvas) {
        Path path = this.f15523h;
        RectF rectF = this.f15524i;
        int i = this.f15518c;
        path.addRoundRect(rectF, (float) i, (float) i, Path.Direction.CCW);
        this.f15523h.moveTo(((float) this.f15519d.x) + (((float) this.f15521f) / 2.0f), (float) this.f15519d.y);
        this.f15523h.lineTo((float) this.f15519d.x, ((float) this.f15519d.y) + (((float) this.f15520e) / 2.0f));
        this.f15523h.lineTo(((float) this.f15519d.x) - (((float) this.f15521f) / 2.0f), (float) this.f15519d.y);
        this.f15523h.close();
        canvas.drawPath(this.f15523h, this.f15522g);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f15524i.left = (float) getPaddingLeft();
        this.f15524i.top = (float) getPaddingTop();
        this.f15524i.right = (float) (i - getPaddingRight());
        this.f15524i.bottom = (float) (i2 - getPaddingBottom());
        this.f15519d.x = this.f15517b;
        this.f15519d.y = i2 - getPaddingBottom();
    }
}
