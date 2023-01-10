package com.didi.component.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.didi.passenger.C11267R;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class DiffuseView extends View {

    /* renamed from: a */
    private static final int f13846a = 3;

    /* renamed from: b */
    private int f13847b;

    /* renamed from: c */
    private int f13848c;

    /* renamed from: d */
    private Bitmap f13849d;

    /* renamed from: e */
    private int f13850e;

    /* renamed from: f */
    private int f13851f;

    /* renamed from: g */
    private Integer f13852g;

    /* renamed from: h */
    private boolean f13853h;

    /* renamed from: i */
    private List<Integer> f13854i;

    /* renamed from: j */
    private List<Integer> f13855j;

    /* renamed from: k */
    private Paint f13856k;

    /* renamed from: l */
    private int f13857l;

    public DiffuseView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DiffuseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public DiffuseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13847b = getResources().getColor(R.color.colorAccent);
        this.f13848c = getResources().getColor(R.color.colorPrimary);
        this.f13850e = 150;
        this.f13851f = 3;
        this.f13852g = 255;
        this.f13853h = false;
        this.f13854i = new ArrayList();
        this.f13855j = new ArrayList();
        m11490a();
        m11492b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.DiffuseView, i, 0);
        this.f13847b = obtainStyledAttributes.getColor(0, this.f13847b);
        this.f13848c = obtainStyledAttributes.getColor(1, this.f13848c);
        this.f13850e = obtainStyledAttributes.getDimensionPixelSize(3, this.f13850e);
        this.f13851f = obtainStyledAttributes.getInt(5, this.f13851f);
        this.f13852g = Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(4, this.f13852g.intValue()));
        int resourceId = obtainStyledAttributes.getResourceId(2, -1);
        if (resourceId != -1) {
            this.f13849d = BitmapFactory.decodeResource(getResources(), resourceId);
        }
        obtainStyledAttributes.recycle();
        this.f13857l = this.f13852g.intValue() / this.f13851f;
    }

    /* renamed from: a */
    private void m11490a() {
        Paint paint = new Paint();
        this.f13856k = paint;
        paint.setAntiAlias(true);
    }

    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    public void onDraw(Canvas canvas) {
        if (this.f13853h) {
            this.f13856k.setColor(this.f13847b);
            for (int i = 0; i < this.f13854i.size(); i++) {
                Integer num = this.f13854i.get(i);
                this.f13856k.setAlpha(num.intValue());
                Integer num2 = this.f13855j.get(i);
                canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) (this.f13850e + num2.intValue()), this.f13856k);
                if (num.intValue() > 0 && num2.intValue() < this.f13852g.intValue()) {
                    this.f13854i.set(i, Integer.valueOf(num.intValue() - (255 / this.f13857l)));
                    this.f13855j.set(i, Integer.valueOf(num2.intValue() + 1));
                }
            }
            List<Integer> list = this.f13855j;
            if (list.get(list.size() - 1).intValue() == this.f13857l) {
                this.f13854i.add(255);
                this.f13855j.add(0);
            }
            if (this.f13855j.size() >= 3) {
                this.f13855j.remove(0);
                this.f13854i.remove(0);
            }
            m11491a(canvas);
            if (this.f13853h) {
                invalidate();
                return;
            }
            return;
        }
        m11491a(canvas);
    }

    /* renamed from: a */
    private void m11491a(Canvas canvas) {
        this.f13856k.setAlpha(255);
        this.f13856k.setColor(this.f13848c);
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.f13850e, this.f13856k);
        Bitmap bitmap = this.f13849d;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (float) ((getWidth() / 2) - (this.f13849d.getWidth() / 2)), (float) ((getHeight() / 2) - (this.f13849d.getHeight() / 2)), this.f13856k);
        }
    }

    public void start() {
        this.f13853h = true;
        invalidate();
    }

    /* renamed from: b */
    private void m11492b() {
        this.f13854i.clear();
        this.f13855j.clear();
        this.f13854i.add(255);
        this.f13855j.add(0);
    }

    public void clear() {
        stop();
        m11492b();
        invalidate();
    }

    public void stop() {
        this.f13853h = false;
    }

    public boolean isDiffuse() {
        return this.f13853h;
    }

    public void setColor(int i) {
        this.f13847b = i;
    }

    public void setCoreColor(int i) {
        this.f13848c = i;
    }

    public void setCoreImage(int i) {
        this.f13849d = BitmapFactory.decodeResource(getResources(), i);
    }

    public void setCoreRadius(int i) {
        this.f13850e = i;
    }

    public void setDiffuseWidth(int i) {
        this.f13851f = i;
        this.f13857l = this.f13852g.intValue() / this.f13851f;
    }

    public void setMaxWidth(int i) {
        Integer valueOf = Integer.valueOf(i);
        this.f13852g = valueOf;
        this.f13857l = valueOf.intValue() / this.f13851f;
    }
}
