package com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class PreviewCover extends View {

    /* renamed from: a */
    private int f19131a;

    /* renamed from: b */
    private Bitmap f19132b;

    /* renamed from: c */
    private Rect f19133c;

    public PreviewCover(Context context) {
        super(context);
    }

    public PreviewCover(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PreviewCover(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setContent(int i, int i2) {
        this.f19131a = getResources().getColor(i);
        this.f19132b = BitmapFactory.decodeResource(getResources(), i2);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f19132b == null) {
            super.onDraw(canvas);
            return;
        }
        if (this.f19133c == null) {
            int a = Utils.m16255a(getContext(), 45.0f);
            this.f19133c = new Rect(Utils.m16255a(getContext(), 69.0f), a, canvas.getWidth() - Utils.m16255a(getContext(), 148.0f), canvas.getHeight() - a);
            if (this.f19132b.getHeight() > 0 && this.f19132b.getWidth() > 0 && this.f19133c.height() > 0) {
                float width = (((float) this.f19133c.width()) * 1.0f) / ((float) this.f19133c.height());
                float width2 = (((float) this.f19132b.getWidth()) * 1.0f) / ((float) this.f19132b.getHeight());
                if (width > width2) {
                    float width3 = (((float) this.f19133c.width()) - (((((float) this.f19133c.height()) * 1.0f) / ((float) this.f19132b.getHeight())) * ((float) this.f19132b.getWidth()))) / 2.0f;
                    Rect rect = this.f19133c;
                    rect.left = (int) (((float) rect.left) + width3);
                    Rect rect2 = this.f19133c;
                    rect2.right = (int) (((float) rect2.right) - width3);
                } else if (width < width2) {
                    float height = (((float) this.f19133c.height()) - (((((float) this.f19133c.width()) * 1.0f) / ((float) this.f19132b.getWidth())) * ((float) this.f19132b.getHeight()))) / 2.0f;
                    Rect rect3 = this.f19133c;
                    rect3.top = (int) (((float) rect3.top) + height);
                    Rect rect4 = this.f19133c;
                    rect4.bottom = (int) (((float) rect4.bottom) - height);
                }
            }
        }
        Paint paint = new Paint();
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), paint, 31);
        canvas.drawColor(this.f19131a);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        canvas.drawRect(this.f19133c, paint);
        canvas.restoreToCount(saveLayer);
        canvas.drawBitmap(this.f19132b, (Rect) null, this.f19133c, (Paint) null);
        super.onDraw(canvas);
    }
}
