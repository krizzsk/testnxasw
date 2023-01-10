package rui.internal.loopview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.didi.passenger.C11267R;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import rui.debug.RUIDebugControl;

public class LoopView extends View {

    /* renamed from: q */
    private static final float f8604q = 1.25f;

    /* renamed from: r */
    private static final int f8605r = 9;

    /* renamed from: A */
    private int[] f8606A;

    /* renamed from: B */
    private float f8607B;

    /* renamed from: C */
    private float f8608C;

    /* renamed from: D */
    private float f8609D;

    /* renamed from: E */
    private long f8610E;

    /* renamed from: F */
    private Rect f8611F;

    /* renamed from: G */
    private GestureDetector f8612G;

    /* renamed from: H */
    private ScheduledExecutorService f8613H;

    /* renamed from: I */
    private ScheduledFuture<?> f8614I;

    /* renamed from: J */
    private Paint f8615J;

    /* renamed from: K */
    private Paint f8616K;

    /* renamed from: L */
    private Paint f8617L;

    /* renamed from: M */
    private DecoratorLineLocationListener f8618M;

    /* renamed from: a */
    boolean f8619a;

    /* renamed from: b */
    int f8620b;

    /* renamed from: c */
    int f8621c;

    /* renamed from: d */
    int f8622d;

    /* renamed from: e */
    int f8623e;

    /* renamed from: f */
    int f8624f;

    /* renamed from: g */
    int f8625g;

    /* renamed from: h */
    int f8626h;

    /* renamed from: i */
    int f8627i;

    /* renamed from: j */
    int f8628j;

    /* renamed from: k */
    int f8629k;

    /* renamed from: l */
    float f8630l;

    /* renamed from: m */
    SparseArray<IndexString> f8631m;

    /* renamed from: n */
    Handler f8632n;

    /* renamed from: o */
    OnItemSelectedListener f8633o;

    /* renamed from: p */
    List<IndexString> f8634p;

    /* renamed from: s */
    private int f8635s;

    /* renamed from: t */
    private int f8636t;

    /* renamed from: u */
    private int f8637u;

    /* renamed from: v */
    private int f8638v;

    /* renamed from: w */
    private int f8639w;

    /* renamed from: x */
    private int f8640x;

    /* renamed from: y */
    private int f8641y;

    /* renamed from: z */
    private int f8642z;

    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    public interface DecoratorLineLocationListener {
        void onLineLocationChange(int i, int i2);
    }

    public LoopView(Context context) {
        this(context, (AttributeSet) null);
    }

    public LoopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8619a = true;
        this.f8626h = 0;
        this.f8627i = 0;
        this.f8636t = 9;
        this.f8637u = 0;
        this.f8641y = 0;
        this.f8630l = 0.0f;
        this.f8607B = 1.05f;
        this.f8609D = f8604q;
        this.f8610E = 0;
        this.f8611F = new Rect();
        this.f8613H = Executors.newSingleThreadScheduledExecutor();
        m7242a(context, attributeSet);
    }

    public LoopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8619a = true;
        this.f8626h = 0;
        this.f8627i = 0;
        this.f8636t = 9;
        this.f8637u = 0;
        this.f8641y = 0;
        this.f8630l = 0.0f;
        this.f8607B = 1.05f;
        this.f8609D = f8604q;
        this.f8610E = 0;
        this.f8611F = new Rect();
        this.f8613H = Executors.newSingleThreadScheduledExecutor();
        m7242a(context, attributeSet);
    }

    /* renamed from: a */
    private void m7242a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            m7244b(context, attributeSet);
        }
        this.f8632n = new C3571c(this);
        GestureDetector gestureDetector = new GestureDetector(context, new C3570b(this));
        this.f8612G = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        int i = this.f8636t;
        if (i % 2 == 0) {
            this.f8636t = 9;
        } else {
            this.f8637u = i / 2;
        }
        this.f8631m = new SparseArray<>();
        m7241a();
    }

    /* renamed from: b */
    private void m7244b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.RUILoopView);
        this.f8630l = obtainStyledAttributes.getDimension(8, this.f8630l);
        this.f8609D = obtainStyledAttributes.getFloat(5, this.f8609D);
        this.f8622d = obtainStyledAttributes.getInteger(0, this.f8622d);
        this.f8621c = obtainStyledAttributes.getInteger(6, this.f8621c);
        this.f8623e = obtainStyledAttributes.getInteger(1, this.f8623e);
        this.f8636t = obtainStyledAttributes.getInteger(4, this.f8636t);
        this.f8619a = obtainStyledAttributes.getBoolean(3, this.f8619a);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m7241a() {
        Paint paint = new Paint();
        this.f8616K = paint;
        paint.setColor(this.f8621c);
        this.f8616K.setAntiAlias(true);
        this.f8616K.setTextSize(this.f8630l);
        Paint paint2 = new Paint();
        this.f8615J = paint2;
        paint2.setColor(this.f8622d);
        this.f8615J.setAntiAlias(true);
        this.f8615J.setTextScaleX(this.f8607B);
        this.f8615J.setTextSize(this.f8630l);
        Paint paint3 = new Paint();
        this.f8617L = paint3;
        paint3.setColor(this.f8623e);
        this.f8617L.setAntiAlias(true);
    }

    public void setCenterTextColor(int i) {
        this.f8615J.setColor(i);
    }

    public void setOuterTextColor(int[] iArr) {
        if (iArr.length != 0) {
            if (iArr.length == 1) {
                this.f8616K.setColor(iArr[0]);
            } else {
                this.f8606A = iArr;
            }
        }
    }

    public void setDividerColor(int i) {
        this.f8617L.setColor(i);
    }

    public void setItemsVisibleCount(int i) {
        if (i % 2 != 0 && i != this.f8636t) {
            this.f8636t = i;
            this.f8637u = i / 2;
            this.f8631m.clear();
        }
    }

    /* renamed from: b */
    private int m7243b() {
        Paint.FontMetrics fontMetrics = this.f8615J.getFontMetrics();
        return (int) Math.abs(fontMetrics.bottom - fontMetrics.top);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f8642z = getPaddingLeft();
        int b = m7243b();
        this.f8620b = b;
        int i3 = (int) (((double) (((float) b) * this.f8609D)) + 0.5d);
        this.f8629k = i3;
        int i4 = this.f8636t * i3;
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), i4);
        int measuredWidth = getMeasuredWidth();
        this.f8638v = measuredWidth;
        this.f8638v = measuredWidth - getPaddingRight();
        this.f8639w = i4;
        this.f8640x = i4 / 2;
        List<IndexString> list = this.f8634p;
        if (list != null) {
            int i5 = this.f8629k;
            this.f8624f = ((i4 - i5) / 2) - 1;
            this.f8625g = ((i4 + i5) / 2) + 1;
            if (this.f8627i == -1) {
                if (this.f8619a) {
                    this.f8627i = (list.size() + 1) / 2;
                } else {
                    this.f8627i = 0;
                }
            }
            this.f8628j = this.f8627i;
            DecoratorLineLocationListener decoratorLineLocationListener = this.f8618M;
            if (decoratorLineLocationListener != null) {
                decoratorLineLocationListener.onLineLocationChange(this.f8624f, this.f8625g);
            }
        }
    }

    public void setDecoratorLineLocationListener(DecoratorLineLocationListener decoratorLineLocationListener) {
        this.f8618M = decoratorLineLocationListener;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.f8612G.onTouchEvent(motionEvent);
        float f = this.f8609D * ((float) this.f8620b);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f8610E = System.currentTimeMillis();
            cancelFuture();
            this.f8608C = motionEvent.getRawY();
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else if (action != 2) {
            if (!onTouchEvent) {
                float y = motionEvent.getY();
                int i = this.f8640x;
                this.f8641y = (int) ((((float) (((int) (((Math.acos((double) ((((float) i) - y) / ((float) i))) * ((double) this.f8640x)) + ((double) (f / 2.0f))) / ((double) f))) - this.f8637u)) * f) - (((((float) this.f8626h) % f) + f) % f));
                if (System.currentTimeMillis() - this.f8610E > 120) {
                    mo43346a(ACTION.DAGGLE);
                }
            }
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        } else {
            this.f8608C = motionEvent.getRawY();
            this.f8626h = (int) (((float) this.f8626h) + (this.f8608C - motionEvent.getRawY()));
            if (!this.f8619a) {
                float f2 = ((float) (-this.f8627i)) * f;
                float size = ((float) ((this.f8634p.size() - 1) - this.f8627i)) * f;
                int i2 = this.f8626h;
                if (((float) i2) < f2) {
                    this.f8626h = (int) f2;
                } else if (((float) i2) > size) {
                    this.f8626h = (int) size;
                }
            }
        }
        invalidate();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        List<IndexString> list = this.f8634p;
        if (list != null) {
            int i = this.f8626h;
            int i2 = this.f8629k;
            int i3 = i / i2;
            int i4 = i % i2;
            int size = this.f8627i + (i3 % list.size());
            this.f8628j = size;
            if (!this.f8619a) {
                if (size < 0) {
                    this.f8628j = 0;
                }
                if (this.f8628j > this.f8634p.size() - 1) {
                    this.f8628j = this.f8634p.size() - 1;
                }
            } else {
                if (size < 0) {
                    this.f8628j = this.f8634p.size() + this.f8628j;
                }
                if (this.f8628j > this.f8634p.size() - 1) {
                    this.f8628j -= this.f8634p.size();
                }
            }
            for (int i5 = 0; i5 < this.f8636t; i5++) {
                int i6 = (this.f8628j + i5) - this.f8637u;
                if (this.f8619a) {
                    while (i6 < 0) {
                        i6 += this.f8634p.size();
                    }
                    while (i6 > this.f8634p.size() - 1) {
                        i6 -= this.f8634p.size();
                    }
                    this.f8631m.put(i5, this.f8634p.get(i6));
                } else if (i6 < 0) {
                    this.f8631m.put(i5, IndexString.EMPTY);
                } else if (i6 > this.f8634p.size() - 1) {
                    this.f8631m.put(i5, IndexString.EMPTY);
                } else {
                    this.f8631m.put(i5, this.f8634p.get(i6));
                }
            }
            float f = (float) this.f8642z;
            int i7 = this.f8624f;
            Canvas canvas2 = canvas;
            canvas2.drawLine(f, (float) i7, (float) this.f8638v, (float) i7, this.f8617L);
            float f2 = (float) this.f8642z;
            int i8 = this.f8625g;
            canvas2.drawLine(f2, (float) i8, (float) this.f8638v, (float) i8, this.f8617L);
            for (int i9 = 0; i9 < this.f8636t; i9++) {
                canvas.save();
                double d = ((((double) ((((float) i9) / ((float) (this.f8636t - 1))) - (((float) i4) / ((float) this.f8639w)))) * 0.55d) + 0.225d) * 3.141592653589793d;
                if (d >= 3.141592653589793d || d <= 0.0d) {
                    canvas.restore();
                } else {
                    int cos = (int) ((((double) this.f8640x) * (1.0d - Math.cos(d))) - ((Math.sin(d) * ((double) this.f8629k)) / 2.0d));
                    canvas.translate(0.0f, (float) cos);
                    canvas.scale(1.0f, (float) Math.sin(d));
                    int i10 = this.f8620b + cos;
                    if (cos < this.f8624f || i10 > this.f8625g) {
                        int i11 = this.f8624f;
                        if (cos > i11 || i10 < i11) {
                            int i12 = this.f8625g;
                            if (cos > i12 || i10 < i12) {
                                if (this.f8606A != null) {
                                    int abs = Math.abs(this.f8637u - i9);
                                    int length = this.f8606A.length;
                                    if (abs > length) {
                                        abs = length;
                                    }
                                    if (abs < 1) {
                                        abs = 1;
                                    }
                                    this.f8616K.setColor(this.f8606A[abs - 1]);
                                }
                                canvas.clipRect(0, 0, this.f8638v, this.f8629k);
                                canvas.drawText(this.f8631m.get(i9).string, (float) m7240a(this.f8631m.get(i9).string, this.f8616K, this.f8611F), (float) this.f8620b, this.f8616K);
                            } else {
                                int[] iArr = this.f8606A;
                                if (iArr != null) {
                                    this.f8616K.setColor(iArr[0]);
                                }
                                canvas.save();
                                canvas.clipRect(0, 0, this.f8638v, this.f8625g - cos);
                                canvas.drawText(this.f8631m.get(i9).string, (float) m7240a(this.f8631m.get(i9).string, this.f8615J, this.f8611F), (float) this.f8620b, this.f8615J);
                                canvas.restore();
                                canvas.save();
                                canvas.clipRect(0, this.f8625g - cos, this.f8638v, this.f8629k);
                                canvas.drawText(this.f8631m.get(i9).string, (float) m7240a(this.f8631m.get(i9).string, this.f8616K, this.f8611F), (float) this.f8620b, this.f8616K);
                                canvas.restore();
                            }
                        } else {
                            int[] iArr2 = this.f8606A;
                            if (iArr2 != null) {
                                this.f8616K.setColor(iArr2[0]);
                            }
                            canvas.save();
                            canvas.clipRect(0, 0, this.f8638v, this.f8624f - cos);
                            canvas.drawText(this.f8631m.get(i9).string, (float) m7240a(this.f8631m.get(i9).string, this.f8616K, this.f8611F), (float) this.f8620b, this.f8616K);
                            canvas.restore();
                            canvas.save();
                            canvas.clipRect(0, this.f8624f - cos, this.f8638v, this.f8629k);
                            canvas.drawText(this.f8631m.get(i9).string, (float) m7240a(this.f8631m.get(i9).string, this.f8615J, this.f8611F), (float) this.f8620b, this.f8615J);
                            canvas.restore();
                        }
                    } else {
                        canvas.clipRect(0, 0, this.f8638v, this.f8629k);
                        canvas.drawText(this.f8631m.get(i9).string, (float) m7240a(this.f8631m.get(i9).string, this.f8615J, this.f8611F), (float) this.f8620b, this.f8615J);
                        this.f8635s = this.f8634p.indexOf(this.f8631m.get(i9));
                    }
                    canvas.restore();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo43346a(ACTION action) {
        cancelFuture();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f = (float) this.f8629k;
            int i = (int) (((((float) this.f8626h) % f) + f) % f);
            this.f8641y = i;
            if (((float) i) > f / 2.0f) {
                this.f8641y = (int) (f - ((float) i));
            } else {
                this.f8641y = -i;
            }
        }
        this.f8614I = this.f8613H.scheduleWithFixedDelay(new C3573e(this, this.f8641y), 0, 10, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: protected */
    public final void scrollBy(float f) {
        cancelFuture();
        this.f8614I = this.f8613H.scheduleWithFixedDelay(new C3569a(this, f), 0, (long) 10, TimeUnit.MILLISECONDS);
    }

    public void cancelFuture() {
        ScheduledFuture<?> scheduledFuture = this.f8614I;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.f8614I.cancel(true);
            this.f8614I = null;
        }
    }

    public void setNotLoop() {
        this.f8619a = false;
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.f8630l = f;
            this.f8616K.setTextSize(f);
            this.f8615J.setTextSize(this.f8630l);
            requestLayout();
        }
    }

    public final void setListener(OnItemSelectedListener onItemSelectedListener) {
        this.f8633o = onItemSelectedListener;
    }

    public final void setItems(List<String> list) {
        if ((list == null || list.size() == 0) && RUIDebugControl.isDebug()) {
            throw new IllegalStateException("items must have item");
        }
        this.f8634p = convertData(list);
        requestLayout();
    }

    public List<IndexString> convertData(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new IndexString(i, list.get(i)));
        }
        return arrayList;
    }

    public final int getSelectedItemPosition() {
        return this.f8635s;
    }

    /* access modifiers changed from: protected */
    public final void onItemSelected() {
        if (this.f8633o != null) {
            postDelayed(new C3572d(this), 200);
        }
    }

    public void setScaleX(float f) {
        this.f8607B = f;
    }

    public void setCurrentPosition(int i) {
        List<IndexString> list = this.f8634p;
        if (list != null && !list.isEmpty()) {
            int size = this.f8634p.size();
            if (i >= 0 && i < size && i != this.f8635s) {
                this.f8627i = i;
                this.f8626h = 0;
                this.f8641y = 0;
                invalidate();
            }
        }
    }

    /* renamed from: a */
    private int m7240a(String str, Paint paint, Rect rect) {
        paint.getTextBounds(str, 0, str.length(), rect);
        int i = this.f8638v;
        int i2 = this.f8642z;
        return (((i - i2) - ((int) (((float) rect.width()) * this.f8607B))) / 2) + i2;
    }

    static class IndexString {
        public static IndexString EMPTY = new IndexString();
        private int index;
        /* access modifiers changed from: private */
        public String string;

        public IndexString() {
            this.string = "";
        }

        public IndexString(int i, String str) {
            this.index = i;
            this.string = str;
        }
    }
}
