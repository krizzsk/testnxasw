package com.didi.beatles.p101im.views.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.passenger.C11267R;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.widget.IMForkView */
public class IMForkView extends View {

    /* renamed from: a */
    private int f12296a;

    /* renamed from: b */
    private int f12297b;

    /* renamed from: c */
    private Paint f12298c;

    public IMForkView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public IMForkView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMForkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10499a();
    }

    public void setViewColor(int i) {
        this.f12296a = i;
    }

    /* renamed from: a */
    private void m10499a() {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(C11267R.styleable.IMForkView);
        if (obtainStyledAttributes != null) {
            this.f12296a = obtainStyledAttributes.getColor(0, IMResource.getColor(R.color.white));
            this.f12297b = obtainStyledAttributes.getInteger(1, 3);
            obtainStyledAttributes.recycle();
            Paint paint = new Paint();
            this.f12298c = paint;
            paint.setStrokeWidth((float) IMViewUtil.dp2px(getContext(), 1.0f));
            this.f12298c.setAntiAlias(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f12298c.setColor(this.f12296a);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        IMLog.m10020d("IMForkView", "paddingleft = " + getPaddingLeft() + "  padingRight = " + getPaddingRight() + " width = " + getMeasuredWidth() + "  height = " + getMeasuredHeight());
        Canvas canvas2 = canvas;
        canvas2.drawLine((float) getPaddingLeft(), (float) getPaddingTop(), (float) (measuredWidth - getPaddingRight()), (float) (measuredHeight - getPaddingBottom()), this.f12298c);
        canvas2.drawLine((float) getPaddingLeft(), (float) (measuredHeight - getPaddingBottom()), (float) (measuredWidth - getPaddingRight()), (float) getPaddingTop(), this.f12298c);
    }
}
