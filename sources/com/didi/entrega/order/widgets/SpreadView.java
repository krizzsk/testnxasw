package com.didi.entrega.order.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.didi.common.map.util.DisplayUtils;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.passenger.C11267R;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class SpreadView extends View {

    /* renamed from: w */
    private static final int f22794w = 16;

    /* renamed from: a */
    private Paint f22795a;

    /* renamed from: b */
    private int f22796b;

    /* renamed from: c */
    private float f22797c;

    /* renamed from: d */
    private float f22798d;

    /* renamed from: e */
    private int f22799e;

    /* renamed from: f */
    private int f22800f;

    /* renamed from: g */
    private int f22801g;

    /* renamed from: h */
    private int f22802h;

    /* renamed from: i */
    private int f22803i;

    /* renamed from: j */
    private int f22804j;

    /* renamed from: k */
    private int f22805k;

    /* renamed from: l */
    private List<Integer> f22806l;

    /* renamed from: m */
    private List<Integer> f22807m;

    /* renamed from: n */
    private boolean f22808n;

    /* renamed from: o */
    private boolean f22809o;

    /* renamed from: p */
    private int f22810p;

    /* renamed from: q */
    private Paint f22811q;

    /* renamed from: r */
    private Paint f22812r;

    /* renamed from: s */
    private int f22813s;

    /* renamed from: t */
    private int f22814t;

    /* renamed from: u */
    private Bitmap f22815u;

    /* renamed from: v */
    private SpreadViewType f22816v;

    /* renamed from: x */
    private String f22817x;

    /* renamed from: y */
    private Boolean f22818y;

    /* renamed from: z */
    private PaintFlagsDrawFilter f22819z;

    public enum SpreadViewType {
        SENDER_CENTER
    }

    public void setCountDownTimeStr(String str, Boolean bool) {
        this.f22817x = str;
        this.f22818y = bool;
    }

    public SpreadView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public SpreadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SpreadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22796b = 2;
        this.f22799e = 2;
        this.f22800f = 5;
        this.f22801g = 300;
        this.f22802h = 76;
        this.f22803i = 10;
        this.f22805k = 16;
        this.f22806l = new ArrayList();
        this.f22807m = new ArrayList();
        this.f22808n = false;
        this.f22809o = false;
        this.f22816v = null;
        this.f22817x = "";
        this.f22818y = false;
        this.f22804j = (CustomerSystemUtil.getScreenWidth(context) * 2) / 3;
        this.f22801g = (CustomerSystemUtil.getScreenWidth(context) / 2) - getResources().getDimensionPixelOffset(R.dimen.rf_dimen_140);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.EntregaSpreadView, i, 0);
        obtainStyledAttributes.getColor(2, ContextCompat.getColor(context, R.color.rf_color_white_100_FFFFFF));
        obtainStyledAttributes.getColor(5, ContextCompat.getColor(context, R.color.rf_color_white_100_FFFFFF));
        obtainStyledAttributes.getColor(1, ContextCompat.getColor(context, R.color.rf_color_jianbian_4_31B77E));
        int color = obtainStyledAttributes.getColor(0, ContextCompat.getColor(context, R.color.rf_color_white_100_FFFFFF));
        this.f22800f = obtainStyledAttributes.getInt(4, this.f22800f);
        this.f22810p = getResources().getDimensionPixelOffset(R.dimen.rf_dimen_24);
        this.f22805k = getResources().getDimensionPixelOffset(R.dimen.rf_dimen_10);
        obtainStyledAttributes.recycle();
        this.f22807m.add(Integer.valueOf(this.f22802h));
        this.f22806l.add(0);
        Paint paint = new Paint();
        this.f22795a = paint;
        paint.setAlpha(this.f22802h);
        Paint paint2 = new Paint();
        this.f22812r = paint2;
        paint2.setAntiAlias(true);
        this.f22812r.setStyle(Paint.Style.FILL);
        this.f22812r.setTextSize((float) DisplayUtils.sp2px(context, 16.0f));
        this.f22812r.setColor(color);
        this.f22819z = new PaintFlagsDrawFilter(0, 3);
        Paint paint3 = new Paint();
        this.f22811q = paint3;
        paint3.setAntiAlias(true);
        this.f22811q.setFilterBitmap(true);
    }

    public void onResume() {
        this.f22809o = true;
        invalidate();
    }

    public void onPause() {
        this.f22809o = false;
    }

    public void start() {
        this.f22808n = true;
        invalidate();
    }

    public void stop() {
        this.f22808n = false;
    }

    public void onDestroy() {
        this.f22808n = false;
        this.f22806l.clear();
        this.f22807m.clear();
        Bitmap bitmap = this.f22815u;
        if (bitmap != null) {
            bitmap.recycle();
            this.f22815u = null;
        }
        this.f22806l = null;
        this.f22816v = null;
        this.f22807m = null;
        System.gc();
    }

    public void setSpreadType(SpreadViewType spreadViewType) {
        this.f22816v = spreadViewType;
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.entrega_count_down_bg);
        this.f22815u = decodeResource;
        if (decodeResource != null) {
            this.f22813s = decodeResource.getWidth();
            this.f22814t = this.f22815u.getHeight();
        }
    }

    public SpreadViewType getSpreadType() {
        return this.f22816v;
    }

    public void updateLocation(float f, float f2) {
        this.f22797c = f;
        this.f22798d = f2 - ((float) this.f22810p);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.f22808n && this.f22809o) {
            for (int i2 = 0; i2 < this.f22806l.size(); i2++) {
                int intValue = this.f22807m.get(i2).intValue();
                this.f22795a.setAlpha(intValue);
                int intValue2 = this.f22806l.get(i2).intValue();
                if (intValue2 > 0) {
                    float f = (float) intValue2;
                    float f2 = f;
                    this.f22795a.setShader(new RadialGradient(this.f22797c, this.f22798d, f2, new int[]{-1, ResourceHelper.getColor(R.color.entrega_spread_gradinet_white), ResourceHelper.getColor(R.color.entrega_spread_gradinet_blue)}, new float[]{0.0f, 0.46f, 1.0f}, Shader.TileMode.CLAMP));
                    canvas.drawCircle(this.f22797c, this.f22798d, f, this.f22795a);
                }
                if (intValue > 0 && intValue2 < (i = this.f22804j)) {
                    this.f22807m.set(i2, Integer.valueOf((this.f22802h * (i - intValue2)) / i));
                    this.f22806l.set(i2, Integer.valueOf(intValue2 + this.f22800f));
                }
            }
            List<Integer> list = this.f22806l;
            if (list.get(list.size() - 1).intValue() > this.f22801g) {
                this.f22806l.add(0);
                this.f22807m.add(Integer.valueOf(this.f22802h));
            }
            if (this.f22806l.size() > this.f22799e) {
                this.f22807m.remove(0);
                this.f22806l.remove(0);
            }
            if (this.f22815u != null && !TextUtils.isEmpty(this.f22817x) && !this.f22818y.booleanValue()) {
                float f3 = this.f22797c - (((float) this.f22813s) * 0.5f);
                float f4 = this.f22798d - (((float) this.f22814t) * 0.5f);
                float measureText = this.f22812r.measureText(this.f22817x);
                Paint.FontMetrics fontMetrics = this.f22812r.getFontMetrics();
                float f5 = ((fontMetrics.bottom - fontMetrics.top) * 0.5f) - fontMetrics.bottom;
                float f6 = (((float) this.f22813s) * 0.5f) - (measureText * 0.5f);
                float f7 = ((((float) this.f22814t) * 0.5f) - (f5 * 0.5f)) + ((float) this.f22805k);
                canvas.drawBitmap(this.f22815u, f3, f4, this.f22811q);
                canvas.setDrawFilter(this.f22819z);
                canvas.drawText(this.f22817x, f3 + f6, f4 + f7, this.f22812r);
            }
            postInvalidateDelayed((long) this.f22803i);
        }
    }
}
