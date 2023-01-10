package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.didi.component.confirmbroadingpoint.impl.view.DotLoadingView;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class WalletSimpleBarChart extends View {

    /* renamed from: A */
    private OnSelectedListener f35021A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public OperationListener f35022B;

    /* renamed from: C */
    private GestureDetector f35023C;

    /* renamed from: D */
    private GestureDetector.SimpleOnGestureListener f35024D;

    /* renamed from: a */
    private int f35025a;

    /* renamed from: b */
    private int f35026b;

    /* renamed from: c */
    private int f35027c;

    /* renamed from: d */
    private int f35028d;

    /* renamed from: e */
    private RectF f35029e;

    /* renamed from: f */
    private int f35030f;

    /* renamed from: g */
    private int f35031g;

    /* renamed from: h */
    private int f35032h;

    /* renamed from: i */
    private int f35033i;

    /* renamed from: j */
    private int f35034j;

    /* renamed from: k */
    private int f35035k;

    /* renamed from: l */
    private int[] f35036l;

    /* renamed from: m */
    private float f35037m;

    /* renamed from: n */
    private Paint f35038n;

    /* renamed from: o */
    private Paint f35039o;

    /* renamed from: p */
    private Paint f35040p;

    /* renamed from: q */
    private Paint f35041q;

    /* renamed from: r */
    private Paint f35042r;

    /* renamed from: s */
    private Paint f35043s;

    /* renamed from: t */
    private RectF[] f35044t;

    /* renamed from: u */
    private Map<Integer, RectF> f35045u;

    /* renamed from: v */
    private Map<Integer, LinearGradient> f35046v;

    /* renamed from: w */
    private float[] f35047w;

    /* renamed from: x */
    private String[] f35048x;

    /* renamed from: y */
    private int f35049y;

    /* renamed from: z */
    private int f35050z;

    public interface OnSelectedListener {
        void onSelectedListener(int i);
    }

    public interface OperationListener {
        void onOperationEnd();

        void onOperationStart();

        void onOperationVerticalScroll();
    }

    public boolean canScrollHorizontally(int i) {
        return false;
    }

    public WalletSimpleBarChart(Context context) {
        this(context, (AttributeSet) null);
    }

    public WalletSimpleBarChart(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WalletSimpleBarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f35024D = new GestureDetector.SimpleOnGestureListener() {
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (Math.abs(f2) <= Math.abs(f) + 30.0f || WalletSimpleBarChart.this.f35022B == null) {
                    return false;
                }
                WalletSimpleBarChart.this.f35022B.onOperationVerticalScroll();
                return false;
            }

            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (Math.abs(f2) <= Math.abs(f) || WalletSimpleBarChart.this.f35022B == null) {
                    return false;
                }
                WalletSimpleBarChart.this.f35022B.onOperationVerticalScroll();
                return false;
            }
        };
        m26715a(attributeSet);
    }

    /* renamed from: a */
    private void m26715a(AttributeSet attributeSet) {
        setLayerType(2, (Paint) null);
        this.f35027c = UIUtils.dip2px(getContext(), 1.0f);
        this.f35028d = UIUtils.dip2px(getContext(), 30.0f);
        Paint paint = new Paint(1);
        this.f35038n = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f35038n.setColor(DotLoadingView.COLOR_LOADING_DEFAULT_NORMAL);
        this.f35036l = new int[]{-79616, -79616};
        Paint paint2 = new Paint(1);
        this.f35039o = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f35039o.setAntiAlias(true);
        Paint paint3 = new Paint(1);
        this.f35041q = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.f35041q.setColor(-12037798);
        Paint paint4 = new Paint(1);
        this.f35042r = paint4;
        paint4.setStyle(Paint.Style.FILL);
        this.f35042r.setColor(-12037798);
        Paint paint5 = new Paint(1);
        this.f35043s = paint5;
        paint5.setStyle(Paint.Style.FILL);
        this.f35043s.setColor(-1);
        Paint paint6 = new Paint(1);
        this.f35040p = paint6;
        paint6.setTextSize((float) UIUtils.dip2px(getContext(), 12.0f));
        this.f35040p.setColor(-7829368);
        this.f35050z = ResourcesHelper.getColor(getContext(), R.color.wallet_color_3FC790);
        this.f35030f = UIUtils.dip2px(getContext(), 20.0f);
        this.f35034j = UIUtils.dip2px(getContext(), 4.0f);
        this.f35031g = UIUtils.dip2px(getContext(), 6.0f);
        this.f35032h = UIUtils.dip2px(getContext(), 12.0f);
        this.f35033i = 2;
        this.f35035k = UIUtils.dip2px(getContext(), 4.5f);
        this.f35045u = new HashMap();
        this.f35046v = new HashMap();
        this.f35023C = new GestureDetector(getContext(), this.f35024D);
    }

    public void setOnSelectedListener(OnSelectedListener onSelectedListener) {
        this.f35021A = onSelectedListener;
    }

    public void setOperationListener(OperationListener operationListener) {
        this.f35022B = operationListener;
    }

    public void setDataList(float[] fArr, String[] strArr) {
        if (!CollectionUtil.isEmpty(fArr) && !CollectionUtil.isEmpty((Object[]) strArr)) {
            m26712a();
            this.f35047w = fArr;
            this.f35048x = strArr;
            m26717b();
            m26719c();
            postInvalidate();
        }
    }

    /* renamed from: a */
    private void m26712a() {
        this.f35030f = UIUtils.dip2px(getContext(), 15.0f);
        this.f35049y = 0;
    }

    /* renamed from: b */
    private void m26717b() {
        int i;
        if (!CollectionUtil.isEmpty(this.f35047w) && this.f35025a != 0 && this.f35026b != 0) {
            int i2 = this.f35026b;
            int i3 = this.f35028d;
            float f = 0.0f;
            this.f35029e = new RectF(0.0f, (float) ((i2 - i3) - this.f35027c), (float) this.f35025a, (float) (i2 - i3));
            float[] fArr = this.f35047w;
            int i4 = 0;
            float f2 = 0.0f;
            for (float f3 : fArr) {
                if (f2 < f3) {
                    f2 = f3;
                }
            }
            int length = fArr.length;
            this.f35044t = new RectF[length];
            int i5 = length > 1 ? (this.f35025a - (this.f35030f * length)) / (length - 1) : 0;
            if (length > 1 && i5 < (i = this.f35034j)) {
                this.f35030f = (this.f35025a - ((length - 1) * i)) / length;
                i5 = i;
            }
            float f4 = f2 * 100.0f;
            int i6 = this.f35026b;
            int i7 = this.f35027c;
            int i8 = this.f35028d;
            float f5 = (float) (((i6 - i7) - i8) - this.f35032h);
            float f6 = (float) ((i6 - i7) - i8);
            float f7 = 0.0f;
            while (i4 < length) {
                float f8 = (((float) this.f35032h) + f5) - (f4 == f ? 0.0f : ((fArr[i4] * 100.0f) * f5) / f4);
                float f9 = ((float) this.f35030f) + f7;
                int i9 = this.f35033i;
                if (f6 - f8 < ((float) i9)) {
                    f8 = f6 - ((float) i9);
                }
                this.f35044t[i4] = new RectF(f7, f8, f9, f6);
                f7 = f7 + ((float) this.f35030f) + ((float) i5);
                i4++;
                f = 0.0f;
            }
            this.f35049y = length - 1;
        }
    }

    /* renamed from: c */
    private void m26719c() {
        float f = 0.0f;
        for (String measureText : this.f35048x) {
            f = Math.max(this.f35040p.measureText(measureText), f);
        }
        this.f35037m = f;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f35025a = getMeasuredWidth();
        this.f35026b = getMeasuredHeight();
        m26717b();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0 || action == 2) {
            m26713a(motionEvent.getX());
        }
        if (this.f35022B != null) {
            if (motionEvent.getAction() == 0) {
                this.f35022B.onOperationStart();
            } else if (motionEvent.getAction() == 1) {
                this.f35022B.onOperationEnd();
            }
        }
        this.f35023C.onTouchEvent(motionEvent);
        return true;
    }

    /* renamed from: a */
    private void m26713a(float f) {
        if (!CollectionUtil.isEmpty((Object[]) this.f35044t)) {
            int i = 0;
            int i2 = 0;
            while (true) {
                RectF[] rectFArr = this.f35044t;
                if (i2 >= rectFArr.length) {
                    i = -1;
                    break;
                }
                RectF rectF = rectFArr[i2];
                if (f > rectF.centerX()) {
                    i2++;
                } else if (i2 != 0) {
                    int i3 = i2 - 1;
                    i = Math.abs(f - rectF.centerX()) > Math.abs(f - this.f35044t[i3].centerX()) ? i3 : i2;
                }
            }
            if (i == -1) {
                i = this.f35044t.length - 1;
            }
            if (this.f35049y != i) {
                this.f35049y = i;
                postInvalidate();
                OnSelectedListener onSelectedListener = this.f35021A;
                if (onSelectedListener != null) {
                    onSelectedListener.onSelectedListener(this.f35049y);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!CollectionUtil.isEmpty((Object[]) this.f35044t)) {
            m26714a(canvas);
            m26718b(canvas);
            m26721d(canvas);
            m26720c(canvas);
        }
    }

    /* renamed from: a */
    private void m26714a(Canvas canvas) {
        canvas.drawRect(this.f35029e, this.f35038n);
    }

    /* renamed from: b */
    private void m26718b(Canvas canvas) {
        for (RectF rectF : this.f35044t) {
            this.f35039o.setShader(m26710a(rectF));
            if (((float) (this.f35031g + 10)) < rectF.height()) {
                int i = this.f35031g;
                canvas.drawRoundRect(rectF, (float) i, (float) i, this.f35039o);
                canvas.drawRect(m26716b(rectF), this.f35039o);
            } else {
                canvas.drawRect(rectF, this.f35039o);
            }
        }
    }

    /* renamed from: a */
    private LinearGradient m26710a(RectF rectF) {
        if (rectF == null || this.f35036l == null) {
            return null;
        }
        Integer valueOf = Integer.valueOf(rectF.hashCode());
        if (this.f35046v.containsKey(valueOf)) {
            return this.f35046v.get(valueOf);
        }
        LinearGradient linearGradient = new LinearGradient(rectF.left, rectF.top, rectF.left, rectF.bottom, this.f35036l, (float[]) null, Shader.TileMode.CLAMP);
        this.f35046v.put(valueOf, linearGradient);
        return linearGradient;
    }

    /* renamed from: b */
    private RectF m26716b(RectF rectF) {
        if (rectF == null) {
            return new RectF();
        }
        Integer valueOf = Integer.valueOf(rectF.hashCode());
        if (this.f35045u.containsKey(valueOf)) {
            return this.f35045u.get(valueOf);
        }
        RectF rectF2 = new RectF(rectF.left, rectF.bottom - ((float) this.f35031g), rectF.right, rectF.bottom);
        this.f35045u.put(valueOf, rectF2);
        return rectF2;
    }

    /* renamed from: c */
    private void m26720c(Canvas canvas) {
        RectF rectF = this.f35044t[this.f35049y];
        float centerX = rectF.centerX();
        float centerX2 = rectF.centerX();
        float f = rectF.bottom;
        float width = rectF.width() / 6.0f;
        if (width < 1.0f) {
            width = 1.0f;
        }
        this.f35041q.setStrokeWidth(width);
        canvas.drawLine(centerX, 0.0f, centerX2, f, this.f35041q);
        canvas.drawCircle(rectF.centerX(), rectF.top, (float) (this.f35030f / 2), this.f35042r);
        canvas.drawCircle(rectF.centerX(), rectF.top, (float) (this.f35030f / 5), this.f35043s);
    }

    /* renamed from: d */
    private void m26721d(Canvas canvas) {
        if (this.f35029e != null && !CollectionUtil.isEmpty((Object[]) this.f35048x)) {
            String[] strArr = this.f35048x;
            int i = 0;
            if (strArr.length < 3) {
                this.f35040p.setColor(-7829368);
                String[] strArr2 = this.f35048x;
                String str = strArr2[0];
                String str2 = strArr2[strArr2.length - 1];
                float abs = this.f35029e.bottom + ((float) this.f35035k) + Math.abs(this.f35040p.getFontMetrics().ascent);
                this.f35040p.setTextAlign(Paint.Align.LEFT);
                canvas.drawText(str, this.f35029e.left, abs, this.f35040p);
                this.f35040p.setTextAlign(Paint.Align.RIGHT);
                canvas.drawText(str2, this.f35029e.right, abs, this.f35040p);
            } else if (strArr.length == this.f35044t.length) {
                canvas.rotate(-90.0f);
                this.f35040p.setTextAlign(Paint.Align.LEFT);
                Paint.FontMetrics fontMetrics = this.f35040p.getFontMetrics();
                float f = ((fontMetrics.descent - fontMetrics.ascent) / 2.0f) - fontMetrics.descent;
                float f2 = this.f35029e.bottom + ((float) this.f35035k) + this.f35037m;
                while (true) {
                    RectF[] rectFArr = this.f35044t;
                    if (i < rectFArr.length) {
                        RectF rectF = rectFArr[i];
                        if (i == this.f35049y) {
                            this.f35040p.setTypeface(Typeface.DEFAULT_BOLD);
                            this.f35040p.setColor(this.f35050z);
                        } else {
                            this.f35040p.setTypeface(Typeface.DEFAULT);
                            this.f35040p.setColor(-7829368);
                        }
                        canvas.drawText(this.f35048x[i], -f2, rectF.centerX() + f, this.f35040p);
                        i++;
                    } else {
                        canvas.rotate(90.0f);
                        return;
                    }
                }
            }
        }
    }
}
