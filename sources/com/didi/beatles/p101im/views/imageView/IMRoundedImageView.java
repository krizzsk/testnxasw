package com.didi.beatles.p101im.views.imageView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.didi.passenger.C11267R;
import com.didi.sdk.apm.SystemUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.didi.beatles.im.views.imageView.IMRoundedImageView */
public class IMRoundedImageView extends ImageView {
    public static final int TYPE_FOUR_CORNER = 0;
    public static final int TYPE_TWO_BOTTOM_CORNER = 2;
    public static final int TYPE_TWO_TOP_CORNER = 1;

    /* renamed from: a */
    private final RectF f12126a = new RectF();

    /* renamed from: b */
    private float f12127b;

    /* renamed from: c */
    private final Paint f12128c = new Paint();

    /* renamed from: d */
    private final Paint f12129d = new Paint();

    /* renamed from: e */
    private int f12130e;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.views.imageView.IMRoundedImageView$IMCornerType */
    public @interface IMCornerType {
    }

    public IMRoundedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.IMRoundedImageView);
        this.f12127b = obtainStyledAttributes.getDimension(0, 4.0f);
        obtainStyledAttributes.recycle();
        m10410a();
    }

    public IMRoundedImageView(Context context) {
        super(context);
        m10410a();
    }

    /* renamed from: a */
    private void m10410a() {
        this.f12128c.setAntiAlias(true);
        this.f12128c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f12129d.setAntiAlias(true);
        this.f12129d.setColor(-1);
    }

    public void setCornerType(int i) {
        this.f12130e = i;
        invalidate();
    }

    public void setRectAdius(float f) {
        this.f12127b = f;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f12126a.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
    }

    public void draw(Canvas canvas) {
        SystemUtils.saveLayer(canvas, this.f12126a, this.f12129d, 31);
        RectF rectF = this.f12126a;
        float f = this.f12127b;
        canvas.drawRoundRect(rectF, f, f, this.f12129d);
        int i = this.f12130e;
        if (i == 1) {
            canvas.drawRect(0.0f, this.f12127b, (float) getWidth(), (float) getHeight(), this.f12129d);
        } else if (i == 2) {
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), ((float) getHeight()) - this.f12127b, this.f12129d);
        }
        SystemUtils.saveLayer(canvas, this.f12126a, this.f12128c, 31);
        super.draw(canvas);
        canvas.restore();
    }
}
