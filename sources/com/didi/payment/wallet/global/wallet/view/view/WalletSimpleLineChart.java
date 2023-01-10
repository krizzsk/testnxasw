package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.unifiedPay.util.UIUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WalletSimpleLineChart extends View {

    /* renamed from: a */
    private static final float f35051a = 0.25f;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public OperationListener f35052A;

    /* renamed from: B */
    private GestureDetector f35053B;

    /* renamed from: C */
    private GestureDetector.SimpleOnGestureListener f35054C;

    /* renamed from: b */
    private int f35055b;

    /* renamed from: c */
    private int f35056c;

    /* renamed from: d */
    private int f35057d;

    /* renamed from: e */
    private int f35058e;

    /* renamed from: f */
    private int f35059f;

    /* renamed from: g */
    private int f35060g;

    /* renamed from: h */
    private RectF f35061h;

    /* renamed from: i */
    private int f35062i;

    /* renamed from: j */
    private int f35063j;

    /* renamed from: k */
    private int f35064k;

    /* renamed from: l */
    private int f35065l;

    /* renamed from: m */
    private Path f35066m;

    /* renamed from: n */
    private Paint f35067n;

    /* renamed from: o */
    private Paint f35068o;

    /* renamed from: p */
    private Paint f35069p;

    /* renamed from: q */
    private Paint f35070q;

    /* renamed from: r */
    private Paint f35071r;

    /* renamed from: s */
    private Paint f35072s;

    /* renamed from: t */
    private Paint f35073t;

    /* renamed from: u */
    private PointF[] f35074u;

    /* renamed from: v */
    private List<PointF> f35075v;

    /* renamed from: w */
    private float[] f35076w;

    /* renamed from: x */
    private String[] f35077x;

    /* renamed from: y */
    private int f35078y;

    /* renamed from: z */
    private OnSelectedListener f35079z;

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

    public WalletSimpleLineChart(Context context) {
        this(context, (AttributeSet) null);
    }

    public WalletSimpleLineChart(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WalletSimpleLineChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f35054C = new GestureDetector.SimpleOnGestureListener() {
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (Math.abs(f2) <= Math.abs(f) + 30.0f || WalletSimpleLineChart.this.f35052A == null) {
                    return false;
                }
                WalletSimpleLineChart.this.f35052A.onOperationVerticalScroll();
                return false;
            }

            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (Math.abs(f2) <= Math.abs(f) || WalletSimpleLineChart.this.f35052A == null) {
                    return false;
                }
                WalletSimpleLineChart.this.f35052A.onOperationVerticalScroll();
                return false;
            }
        };
        m26726a(attributeSet);
    }

    /* renamed from: a */
    private void m26726a(AttributeSet attributeSet) {
        setLayerType(2, (Paint) null);
        this.f35059f = UIUtils.dip2px(getContext(), 1.0f);
        this.f35060g = UIUtils.dip2px(getContext(), 30.0f);
        Paint paint = new Paint(1);
        this.f35067n = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f35067n.setColor(-13421773);
        Paint paint2 = new Paint(1);
        this.f35073t = paint2;
        paint2.setAlpha(255);
        this.f35073t.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.f35072s = paint3;
        paint3.setStrokeCap(Paint.Cap.ROUND);
        this.f35072s.setStyle(Paint.Style.STROKE);
        this.f35072s.setStrokeWidth((float) UIUtils.dip2px(getContext(), 2.0f));
        this.f35072s.setColor(-16320);
        this.f35066m = new Path();
        Paint paint4 = new Paint(1);
        this.f35069p = paint4;
        paint4.setStyle(Paint.Style.FILL);
        this.f35069p.setColor(-12037798);
        Paint paint5 = new Paint(1);
        this.f35070q = paint5;
        paint5.setStyle(Paint.Style.FILL);
        this.f35070q.setColor(-12037798);
        Paint paint6 = new Paint(1);
        this.f35071r = paint6;
        paint6.setStyle(Paint.Style.FILL);
        this.f35071r.setColor(-1);
        Paint paint7 = new Paint(1);
        this.f35068o = paint7;
        paint7.setTextSize((float) UIUtils.dip2px(getContext(), 12.0f));
        this.f35068o.setColor(-7829368);
        this.f35062i = UIUtils.dip2px(getContext(), 4.5f);
        this.f35063j = UIUtils.dip2px(getContext(), 12.0f);
        this.f35064k = UIUtils.dip2px(getContext(), 2.0f);
        int dip2px = UIUtils.dip2px(getContext(), 10.0f);
        this.f35058e = dip2px;
        this.f35057d = dip2px;
        this.f35065l = UIUtils.dip2px(getContext(), 4.0f);
        this.f35075v = new ArrayList();
        this.f35053B = new GestureDetector(getContext(), this.f35054C);
    }

    public void setOnSelectedListener(OnSelectedListener onSelectedListener) {
        this.f35079z = onSelectedListener;
    }

    public void setOperationListener(OperationListener operationListener) {
        this.f35052A = operationListener;
    }

    public void setDataList(float[] fArr, String[] strArr) {
        if (!CollectionUtil.isEmpty(fArr) && !CollectionUtil.isEmpty((Object[]) strArr)) {
            m26723a();
            this.f35076w = fArr;
            this.f35077x = strArr;
            m26728b();
            postInvalidate();
        }
    }

    /* renamed from: a */
    private void m26723a() {
        this.f35078y = 0;
    }

    /* renamed from: b */
    private void m26728b() {
        if (!CollectionUtil.isEmpty(this.f35076w) && this.f35055b != 0 && this.f35056c != 0) {
            int i = this.f35056c;
            int i2 = this.f35060g;
            this.f35061h = new RectF((float) this.f35057d, (float) ((i - i2) - this.f35059f), (float) (this.f35055b - this.f35058e), (float) (i - i2));
            float f = 0.0f;
            this.f35073t.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.f35061h.top, new int[]{603963456, 16760896}, (float[]) null, Shader.TileMode.CLAMP));
            float[] fArr = this.f35076w;
            float f2 = 0.0f;
            for (float f3 : fArr) {
                if (f2 < f3) {
                    f2 = f3;
                }
            }
            int length = fArr.length;
            this.f35074u = new PointF[length];
            int i3 = length - 1;
            if (i3 > 0) {
                f = ((float) ((this.f35055b - this.f35057d) - this.f35058e)) / ((float) i3);
            } else if (length == 1) {
                f = (float) ((this.f35055b - this.f35057d) - this.f35058e);
            }
            float f4 = (float) (this.f35057d + (this.f35064k / 2));
            float f5 = f2 * 100.0f;
            float f6 = (float) (((this.f35056c - this.f35059f) - this.f35060g) - this.f35063j);
            for (int i4 = 0; i4 < length; i4++) {
                float f7 = (((float) this.f35063j) + f6) - (((fArr[i4] * 100.0f) * f6) / f5);
                if (f7 > this.f35061h.top) {
                    f7 = this.f35061h.top;
                }
                this.f35074u[i4] = new PointF(f4, f7);
                f4 += f;
            }
            m26727a(this.f35074u);
            this.f35078y = i3;
        }
    }

    /* renamed from: a */
    private void m26727a(PointF[] pointFArr) {
        this.f35075v.clear();
        if (!CollectionUtil.isEmpty((Object[]) pointFArr) && pointFArr.length > 1) {
            for (int i = 0; i < pointFArr.length; i++) {
                PointF pointF = pointFArr[i];
                if (i == 0) {
                    PointF pointF2 = pointFArr[i + 1];
                    this.f35075v.add(new PointF(pointF.x + ((pointF2.x - pointF.x) * f35051a), pointF.y));
                } else if (i == pointFArr.length - 1) {
                    PointF pointF3 = pointFArr[i - 1];
                    this.f35075v.add(new PointF(pointF.x - ((pointF.x - pointF3.x) * f35051a), pointF.y));
                } else {
                    PointF pointF4 = pointFArr[i - 1];
                    PointF pointF5 = pointFArr[i + 1];
                    float f = (pointF5.y - pointF4.y) / (pointF5.x - pointF4.x);
                    float f2 = pointF.y - (pointF.x * f);
                    float f3 = pointF.x - ((pointF.x - pointF4.x) * f35051a);
                    this.f35075v.add(new PointF(f3, (f * f3) + f2));
                    float f4 = pointF.x + ((pointF5.x - pointF.x) * f35051a);
                    this.f35075v.add(new PointF(f4, (f * f4) + f2));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f35055b = getMeasuredWidth();
        this.f35056c = getMeasuredHeight();
        m26728b();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0 || action == 2) {
            m26724a(motionEvent.getX());
        }
        if (this.f35052A != null) {
            if (motionEvent.getAction() == 0) {
                this.f35052A.onOperationStart();
            } else if (motionEvent.getAction() == 1) {
                this.f35052A.onOperationEnd();
            }
        }
        this.f35053B.onTouchEvent(motionEvent);
        return true;
    }

    /* renamed from: a */
    private void m26724a(float f) {
        if (!CollectionUtil.isEmpty((Object[]) this.f35074u)) {
            int i = 0;
            int i2 = 0;
            while (true) {
                PointF[] pointFArr = this.f35074u;
                if (i2 >= pointFArr.length) {
                    i = -1;
                    break;
                }
                PointF pointF = pointFArr[i2];
                if (f > pointF.x) {
                    i2++;
                } else if (i2 != 0) {
                    int i3 = i2 - 1;
                    i = Math.abs(f - pointF.x) > Math.abs(f - this.f35074u[i3].x) ? i3 : i2;
                }
            }
            if (i == -1) {
                i = this.f35074u.length - 1;
            }
            if (this.f35078y != i) {
                this.f35078y = i;
                postInvalidate();
                OnSelectedListener onSelectedListener = this.f35079z;
                if (onSelectedListener != null) {
                    onSelectedListener.onSelectedListener(this.f35078y);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!CollectionUtil.isEmpty((Object[]) this.f35074u) && this.f35061h != null) {
            canvas.save();
            canvas.clipRect(0.0f, 0.0f, (float) getWidth(), this.f35061h.top);
            m26729b(canvas);
            canvas.restore();
            m26725a(canvas);
            m26731d(canvas);
            m26730c(canvas);
        }
    }

    /* renamed from: a */
    private void m26725a(Canvas canvas) {
        canvas.drawRect(this.f35061h, this.f35067n);
    }

    /* renamed from: b */
    private void m26729b(Canvas canvas) {
        this.f35066m.reset();
        PointF pointF = this.f35074u[0];
        this.f35066m.moveTo(pointF.x, pointF.y);
        if (!CollectionUtil.isEmpty((Collection<?>) this.f35075v)) {
            for (int i = 0; i < (this.f35074u.length - 1) * 2; i += 2) {
                PointF pointF2 = this.f35075v.get(i);
                PointF pointF3 = this.f35075v.get(i + 1);
                PointF pointF4 = this.f35074u[(i / 2) + 1];
                this.f35066m.cubicTo(pointF2.x, pointF2.y, pointF3.x, pointF3.y, pointF4.x, pointF4.y);
            }
        }
        PointF[] pointFArr = this.f35074u;
        PointF pointF5 = pointFArr[pointFArr.length - 1];
        Path path = new Path(this.f35066m);
        path.lineTo(pointF5.x, this.f35061h.top);
        path.lineTo(pointF.x, this.f35061h.top);
        path.lineTo(pointF.x, pointF.y);
        canvas.drawPath(path, this.f35073t);
        canvas.drawPath(this.f35066m, this.f35072s);
    }

    /* renamed from: c */
    private void m26730c(Canvas canvas) {
        PointF pointF = this.f35074u[this.f35078y];
        float f = pointF.x;
        float f2 = pointF.x;
        float f3 = this.f35061h.top;
        this.f35069p.setStrokeWidth((float) this.f35064k);
        canvas.drawLine(f, 0.0f, f2, f3, this.f35069p);
        canvas.drawCircle(pointF.x, pointF.y, (float) this.f35062i, this.f35070q);
        canvas.drawCircle(pointF.x, pointF.y, (float) (this.f35062i / 2), this.f35071r);
    }

    /* renamed from: d */
    private void m26731d(Canvas canvas) {
        String[] strArr = this.f35077x;
        String str = strArr[0];
        String str2 = strArr[strArr.length - 1];
        float abs = this.f35061h.bottom + ((float) this.f35065l) + Math.abs(this.f35068o.getFontMetrics().ascent);
        this.f35068o.setTextAlign(Paint.Align.LEFT);
        canvas.drawText(str, this.f35061h.left, abs, this.f35068o);
        this.f35068o.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText(str2, this.f35061h.right, abs, this.f35068o);
    }
}
