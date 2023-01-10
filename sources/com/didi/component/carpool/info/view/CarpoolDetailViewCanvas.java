package com.didi.component.carpool.info.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.didi.component.carpool.info.model.CarpoolInfoItem;
import com.taxis99.R;
import java.util.List;

public class CarpoolDetailViewCanvas extends View {
    public static final int ITEM_STATUS_CURRENT = 0;
    public static final int ITEM_STATUS_HISTORY = 1;
    public static final int ITEM_STATUS_NORMAL = 2;
    public static final int ITEM_TYPE_END_POINT = 3;
    public static final int ITEM_TYPE_PICKUP_POINT = 1;
    public static final int ITEM_TYPE_START_POINT = 0;
    public static final int ITEM_TYPE_VIA_POINT = 2;

    /* renamed from: m */
    private static final int f13280m = Color.parseColor("#33BBFF");

    /* renamed from: n */
    private static final int f13281n = Color.parseColor("#919599");

    /* renamed from: o */
    private static final int f13282o = Color.parseColor("#D4D7D9");

    /* renamed from: p */
    private static final float f13283p = 37.0f;

    /* renamed from: q */
    private static final float f13284q = 31.0f;

    /* renamed from: r */
    private static final float f13285r = 23.0f;

    /* renamed from: s */
    private static final float f13286s = 31.0f;

    /* renamed from: a */
    private Context f13287a;

    /* renamed from: b */
    private int f13288b;

    /* renamed from: c */
    private List<CarpoolInfoItem> f13289c;

    /* renamed from: d */
    private boolean f13290d;

    /* renamed from: e */
    private boolean f13291e = false;

    /* renamed from: f */
    private int f13292f;

    /* renamed from: g */
    private int f13293g;

    /* renamed from: h */
    private int f13294h;

    /* renamed from: i */
    private Paint f13295i = new Paint(1);

    /* renamed from: j */
    private Paint f13296j;

    /* renamed from: k */
    private Paint f13297k;

    /* renamed from: l */
    private Paint f13298l;

    public CarpoolDetailViewCanvas(Context context) {
        super(context);
        m11140a();
    }

    public CarpoolDetailViewCanvas(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11140a();
    }

    public CarpoolDetailViewCanvas(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11140a();
    }

    /* renamed from: a */
    private void m11140a() {
        this.f13287a = getContext();
        this.f13292f = m11139a(20.0f);
        this.f13293g = m11139a(53.0f);
        this.f13294h = m11139a(27.0f);
        Paint paint = new Paint(1);
        this.f13296j = paint;
        paint.setColor(-3355444);
        Paint paint2 = new Paint(1);
        this.f13297k = paint2;
        paint2.setStrokeWidth((float) m11139a(2.0f));
        int a = m11139a(3.5f);
        Paint paint3 = new Paint(1);
        this.f13298l = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.f13298l.setStrokeWidth((float) a);
        this.f13298l.setColor(f13280m);
        float a2 = (float) m11139a(6.0f);
        this.f13298l.setPathEffect(new DashPathEffect(new float[]{1.0f, a2, 1.0f, a2}, 0.0f));
        this.f13298l.setStrokeCap(Paint.Cap.ROUND);
    }

    public void setTravelDetailData(List<CarpoolInfoItem> list, int i) {
        this.f13289c = list;
        this.f13288b = i;
        this.f13291e = false;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f13290d = false;
        for (int i = 0; i < this.f13289c.size(); i++) {
            CarpoolInfoItem carpoolInfoItem = this.f13289c.get(i);
            int a = m11139a(f13283p) * i;
            int a2 = m11139a(31.0f) + a;
            int a3 = a + m11139a(f13285r);
            if (i == 0) {
                int i2 = this.f13288b;
                if (i2 == 1 || i2 == 2) {
                    this.f13290d = true;
                    this.f13291e = true;
                    m11141a(canvas, carpoolInfoItem.status, this.f13292f, a2);
                } else if (i2 == 1 || i2 == 3) {
                    this.f13291e = true;
                    m11143b(canvas, carpoolInfoItem.status, this.f13292f, (m11139a(f13283p) * i) + m11139a(31.0f));
                }
            }
            if (i == 1 && this.f13290d) {
                m11143b(canvas, carpoolInfoItem.status, this.f13292f, (m11139a(f13283p) * i) + m11139a(31.0f) + m11139a(15.5f));
            }
            if (carpoolInfoItem.viewType == 0 && carpoolInfoItem.showDotLine == 1) {
                m11145d(canvas, carpoolInfoItem.status, a3, m11139a(f13283p));
            } else if (carpoolInfoItem.viewType != 3) {
                int a4 = m11139a(f13283p);
                if (i == 1 && this.f13290d) {
                    a4 += m11139a(31.0f);
                }
                if (this.f13290d) {
                    a3 = (int) (((float) a3) + 31.0f);
                }
                m11144c(canvas, carpoolInfoItem.status, a3, a4);
            }
        }
    }

    /* renamed from: a */
    private void m11141a(Canvas canvas, int i, int i2, int i3) {
        Bitmap bitmap;
        if (i == 1) {
            bitmap = BitmapFactory.decodeResource(this.f13287a.getResources(), R.drawable.global_travel_detail_people_dis);
        } else {
            bitmap = BitmapFactory.decodeResource(this.f13287a.getResources(), R.drawable.global_travel_detail_people_nor);
        }
        canvas.drawBitmap(bitmap, (float) i2, (float) i3, this.f13295i);
        bitmap.recycle();
    }

    /* renamed from: b */
    private void m11143b(Canvas canvas, int i, int i2, int i3) {
        Bitmap bitmap;
        if (i == 1) {
            bitmap = BitmapFactory.decodeResource(this.f13287a.getResources(), R.drawable.global_travel_detail_car_icon_dis);
        } else {
            bitmap = BitmapFactory.decodeResource(this.f13287a.getResources(), R.drawable.global_travel_detail_car_icon_nor);
        }
        canvas.drawBitmap(bitmap, (float) i2, (float) i3, this.f13295i);
        bitmap.recycle();
    }

    /* renamed from: c */
    private void m11144c(Canvas canvas, int i, int i2, int i3) {
        if (i == 1) {
            this.f13297k.setColor(f13282o);
        } else {
            this.f13297k.setColor(f13281n);
        }
        canvas.drawLine((float) getLineStartX(), (float) i2, (float) getLineStartX(), (float) (i2 + i3), this.f13297k);
    }

    /* renamed from: d */
    private void m11145d(Canvas canvas, int i, int i2, int i3) {
        Path path = new Path();
        path.moveTo((float) getLineStartX(), (float) i2);
        path.lineTo((float) getLineStartX(), (float) (i2 + i3));
        m11142a(canvas, i == 1 ? f13282o : f13280m, path);
    }

    /* renamed from: a */
    private void m11142a(Canvas canvas, int i, Path path) {
        this.f13298l.setColor(i);
        canvas.drawPath(path, this.f13298l);
    }

    /* renamed from: a */
    private int m11139a(float f) {
        return (int) ((f * this.f13287a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private int getLineStartX() {
        return !this.f13291e ? this.f13294h : this.f13293g + m11139a(0.5f);
    }
}
