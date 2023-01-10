package com.didi.map.global.component.trafficreport.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.passenger.C11267R;
import rui.config.RConfigConstants;

public class ReportShadowLayout extends FrameLayout {

    /* renamed from: A */
    private float f28668A;

    /* renamed from: B */
    private float f28669B;

    /* renamed from: C */
    private float f28670C;

    /* renamed from: D */
    private float f28671D;

    /* renamed from: E */
    private Paint f28672E;

    /* renamed from: F */
    private float f28673F;

    /* renamed from: G */
    private int f28674G;

    /* renamed from: H */
    private int f28675H;

    /* renamed from: I */
    private boolean f28676I;

    /* renamed from: a */
    private Drawable f28677a;

    /* renamed from: b */
    private int f28678b;

    /* renamed from: c */
    private Drawable f28679c;

    /* renamed from: d */
    private Drawable f28680d;

    /* renamed from: e */
    private View f28681e;

    /* renamed from: f */
    private int f28682f;

    /* renamed from: g */
    private int f28683g;

    /* renamed from: h */
    private int f28684h;

    /* renamed from: i */
    private float f28685i;

    /* renamed from: j */
    private float f28686j;

    /* renamed from: k */
    private float f28687k;

    /* renamed from: l */
    private float f28688l;

    /* renamed from: m */
    private boolean f28689m;

    /* renamed from: n */
    private boolean f28690n;

    /* renamed from: o */
    private boolean f28691o;

    /* renamed from: p */
    private boolean f28692p;

    /* renamed from: q */
    private Paint f28693q;

    /* renamed from: r */
    private Paint f28694r;

    /* renamed from: s */
    private int f28695s;

    /* renamed from: t */
    private int f28696t;

    /* renamed from: u */
    private int f28697u;

    /* renamed from: v */
    private int f28698v;

    /* renamed from: w */
    private RectF f28699w;

    /* renamed from: x */
    private int f28700x;

    /* renamed from: y */
    private boolean f28701y;

    /* renamed from: z */
    private boolean f28702z;

    public ReportShadowLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ReportShadowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ReportShadowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28678b = -101;
        this.f28683g = -101;
        this.f28699w = new RectF();
        this.f28700x = 1;
        this.f28701y = true;
        m22334a(context, attributeSet);
    }

    /* renamed from: a */
    private void m22334a(Context context, AttributeSet attributeSet) {
        m22336a(attributeSet);
        Paint paint = new Paint();
        this.f28693q = paint;
        paint.setAntiAlias(true);
        this.f28693q.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f28672E = paint2;
        paint2.setAntiAlias(true);
        this.f28672E.setStyle(Paint.Style.STROKE);
        this.f28672E.setStrokeWidth(this.f28673F);
        int i = this.f28674G;
        if (i != -101) {
            this.f28672E.setColor(i);
        }
        Paint paint3 = new Paint(1);
        this.f28694r = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.f28694r.setColor(this.f28682f);
        setPadding();
    }

    /* renamed from: a */
    private void m22336a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C11267R.styleable.ShadowLayout);
        if (obtainStyledAttributes != null) {
            try {
                this.f28701y = !obtainStyledAttributes.getBoolean(44, false);
                this.f28689m = !obtainStyledAttributes.getBoolean(46, false);
                this.f28690n = !obtainStyledAttributes.getBoolean(47, false);
                this.f28692p = !obtainStyledAttributes.getBoolean(45, false);
                this.f28691o = !obtainStyledAttributes.getBoolean(48, false);
                this.f28686j = obtainStyledAttributes.getDimension(3, 0.0f);
                this.f28668A = obtainStyledAttributes.getDimension(5, -1.0f);
                this.f28670C = obtainStyledAttributes.getDimension(4, -1.0f);
                this.f28669B = obtainStyledAttributes.getDimension(7, -1.0f);
                this.f28671D = obtainStyledAttributes.getDimension(6, -1.0f);
                float dimension = obtainStyledAttributes.getDimension(49, 0.0f);
                this.f28685i = dimension;
                if (dimension == 0.0f) {
                    this.f28701y = false;
                }
                this.f28687k = obtainStyledAttributes.getDimension(50, 0.0f);
                this.f28688l = obtainStyledAttributes.getDimension(51, 0.0f);
                this.f28684h = obtainStyledAttributes.getColor(43, Color.parseColor("#2a000000"));
                this.f28700x = obtainStyledAttributes.getInt(54, 1);
                this.f28702z = obtainStyledAttributes.getBoolean(53, true);
                this.f28682f = -1;
                Drawable drawable = obtainStyledAttributes.getDrawable(40);
                if (drawable != null) {
                    if (drawable instanceof ColorDrawable) {
                        this.f28682f = ((ColorDrawable) drawable).getColor();
                    } else {
                        this.f28679c = drawable;
                    }
                }
                Drawable drawable2 = obtainStyledAttributes.getDrawable(42);
                if (drawable2 != null) {
                    if (drawable2 instanceof ColorDrawable) {
                        this.f28683g = ((ColorDrawable) drawable2).getColor();
                    } else {
                        this.f28680d = drawable2;
                    }
                }
                if (this.f28683g != -101) {
                    if (this.f28679c != null) {
                        throw new UnsupportedOperationException("使用了ShadowLayout_layoutBackground_true属性，必须先设置ShadowLayout_layoutBackground属性。且设置颜色时，必须保持都为颜色");
                    }
                }
                if (this.f28679c == null) {
                    if (this.f28680d != null) {
                        throw new UnsupportedOperationException("使用了ShadowLayout_layoutBackground_true属性，必须先设置ShadowLayout_layoutBackground属性。且设置图片时，必须保持都为图片");
                    }
                }
                this.f28674G = obtainStyledAttributes.getColor(55, -101);
                int color = obtainStyledAttributes.getColor(56, -101);
                this.f28675H = color;
                if (this.f28674G == -101) {
                    if (color != -101) {
                        throw new UnsupportedOperationException("使用了ShadowLayout_strokeColor_true属性，必须先设置ShadowLayout_strokeColor属性");
                    }
                }
                float dimension2 = obtainStyledAttributes.getDimension(57, (float) dip2px(getContext(), 1.0f));
                this.f28673F = dimension2;
                if (dimension2 > ((float) dip2px(getContext(), 7.0f))) {
                    this.f28673F = (float) dip2px(getContext(), 5.0f);
                }
                Drawable drawable3 = obtainStyledAttributes.getDrawable(41);
                if (drawable3 != null) {
                    if (drawable3 instanceof ColorDrawable) {
                        this.f28678b = ((ColorDrawable) drawable3).getColor();
                    } else {
                        this.f28677a = drawable3;
                    }
                }
                boolean z = obtainStyledAttributes.getBoolean(2, true);
                this.f28676I = z;
                setClickable(z);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        this.f28676I = z;
        changeSwitchClickable();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.f28676I) {
            super.setOnClickListener(onClickListener);
        }
    }

    public void changeSwitchClickable() {
        View view;
        if (this.f28700x == 1 && (view = this.f28681e) != null) {
            if (this.f28676I) {
                Drawable drawable = this.f28679c;
                if (drawable != null) {
                    setBackGround(drawable);
                } else if (view.getBackground() != null) {
                    this.f28681e.getBackground().setAlpha(0);
                }
                this.f28694r.setColor(this.f28682f);
                postInvalidate();
            } else if (this.f28678b != -101) {
                if (this.f28679c != null) {
                    view.getBackground().setAlpha(0);
                }
                this.f28694r.setColor(this.f28678b);
                postInvalidate();
            } else {
                Drawable drawable2 = this.f28677a;
                if (drawable2 != null) {
                    setBackGround(drawable2);
                    this.f28694r.setColor(Color.parseColor("#00000000"));
                    postInvalidate();
                }
            }
        }
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.f28700x == 2) {
            if (z) {
                int i = this.f28683g;
                if (i != -101) {
                    this.f28694r.setColor(i);
                }
                int i2 = this.f28675H;
                if (i2 != -101) {
                    this.f28672E.setColor(i2);
                }
                Drawable drawable = this.f28680d;
                if (drawable != null) {
                    setBackGround(drawable);
                }
            } else {
                this.f28694r.setColor(this.f28682f);
                int i3 = this.f28674G;
                if (i3 != -101) {
                    this.f28672E.setColor(i3);
                }
                Drawable drawable2 = this.f28679c;
                if (drawable2 != null) {
                    setBackGround(drawable2);
                }
            }
            postInvalidate();
        }
    }

    public void setShowShadow(boolean z) {
        this.f28701y = z;
        if (getWidth() != 0 && getHeight() != 0) {
            m22333a(getWidth(), getHeight());
        }
    }

    public void setXOffset(float f) {
        float abs = Math.abs(f);
        float f2 = this.f28685i;
        if (abs <= f2) {
            this.f28687k = f;
        } else if (f > 0.0f) {
            this.f28687k = f2;
        } else {
            this.f28687k = -f2;
        }
        setPadding();
    }

    public void setYOffset(float f) {
        float abs = Math.abs(f);
        float f2 = this.f28685i;
        if (abs <= f2) {
            this.f28688l = f;
        } else if (f > 0.0f) {
            this.f28688l = f2;
        } else {
            this.f28688l = -f2;
        }
        setPadding();
    }

    public void setCornerRadius(int i) {
        this.f28686j = (float) i;
        if (getWidth() != 0 && getHeight() != 0) {
            m22333a(getWidth(), getHeight());
        }
    }

    public void setShadowSpreed(int i) {
        this.f28685i = (float) i;
        setPadding();
    }

    public void setShadowColor(int i) {
        this.f28684h = i;
        if (getWidth() != 0 && getHeight() != 0) {
            m22333a(getWidth(), getHeight());
        }
    }

    public void setIsShowLeftShadow(boolean z) {
        this.f28689m = z;
        setPadding();
    }

    public void setIsShowRightShadow(boolean z) {
        this.f28690n = z;
        setPadding();
    }

    public void setIsShowTopShadow(boolean z) {
        this.f28691o = z;
        setPadding();
    }

    public void setIsShowBottomShadow(boolean z) {
        this.f28692p = z;
        setPadding();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        View childAt = getChildAt(0);
        this.f28681e = childAt;
        if (childAt == null) {
            this.f28681e = this;
        }
        if (this.f28681e == null) {
            return;
        }
        if (this.f28700x == 2) {
            if (isSelected()) {
                setBackGround(this.f28680d);
            } else {
                setBackGround(this.f28679c);
            }
        } else if (this.f28676I) {
            setBackGround(this.f28679c);
        } else {
            setBackGround(this.f28677a);
            int i = this.f28678b;
            if (i != -101) {
                this.f28694r.setColor(i);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            m22333a(i, i2);
        }
    }

    public void setPadding() {
        if (this.f28701y) {
            float f = this.f28685i;
            if (f > 0.0f) {
                int i = 0;
                if (this.f28702z) {
                    int abs = (int) (f + Math.abs(this.f28687k));
                    int abs2 = (int) (this.f28685i + Math.abs(this.f28688l));
                    this.f28695s = this.f28689m ? abs : 0;
                    if (!this.f28690n) {
                        abs = 0;
                    }
                    this.f28697u = abs;
                    this.f28696t = this.f28691o ? abs2 : 0;
                    if (this.f28692p) {
                        i = abs2;
                    }
                    this.f28698v = i;
                } else {
                    float abs3 = Math.abs(this.f28688l);
                    float f2 = this.f28685i;
                    if (abs3 > f2) {
                        if (this.f28688l <= 0.0f) {
                            f2 = -f2;
                        }
                        this.f28688l = f2;
                    }
                    float abs4 = Math.abs(this.f28687k);
                    float f3 = this.f28685i;
                    if (abs4 > f3) {
                        if (this.f28687k <= 0.0f) {
                            f3 = -f3;
                        }
                        this.f28687k = f3;
                    }
                    this.f28696t = this.f28691o ? (int) (this.f28685i - this.f28688l) : 0;
                    this.f28697u = this.f28690n ? (int) (this.f28685i - this.f28687k) : 0;
                    this.f28698v = this.f28692p ? (int) (this.f28685i + this.f28688l) : 0;
                    if (this.f28689m) {
                        i = (int) (this.f28685i + this.f28687k);
                    }
                    this.f28695s = i;
                }
                setPadding(this.f28695s, this.f28696t, this.f28697u, this.f28698v);
            }
        }
    }

    /* renamed from: a */
    private void m22333a(int i, int i2) {
        if (this.f28701y) {
            isAddAlpha(this.f28684h);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(m22332a(i, i2, this.f28686j, this.f28685i, this.f28687k, this.f28688l, this.f28684h, 0));
            if (Build.VERSION.SDK_INT <= 16) {
                setBackgroundDrawable(bitmapDrawable);
            } else {
                setBackground(bitmapDrawable);
            }
        } else if (getChildAt(0) == null) {
            Drawable drawable = this.f28679c;
            if (drawable != null) {
                this.f28681e = this;
                if (this.f28676I) {
                    setBackGround(drawable);
                } else {
                    changeSwitchClickable();
                }
            } else {
                setBackgroundColor(Color.parseColor("#00000000"));
            }
        } else {
            setBackgroundColor(Color.parseColor("#00000000"));
        }
    }

    /* renamed from: a */
    private Bitmap m22332a(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4) {
        float f5;
        float f6;
        float f7 = f3 / 4.0f;
        float f8 = f4 / 4.0f;
        int i5 = i / 4;
        int i6 = i2 / 4;
        float f9 = f / 4.0f;
        float f10 = f2 / 4.0f;
        Bitmap createBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF(f10, f10, ((float) i5) - f10, ((float) i6) - f10);
        if (this.f28702z) {
            if (f8 > 0.0f) {
                f5 = f7;
            } else {
                f5 = Math.abs(f8);
            }
            rectF.top += f5;
            rectF.bottom -= f5;
            if (f7 > 0.0f) {
                f6 = f7;
            } else {
                f6 = Math.abs(f7);
            }
            rectF.left += f6;
            rectF.right -= f6;
        } else {
            rectF.top -= f8;
            rectF.bottom -= f8;
            rectF.right -= f7;
            rectF.left -= f7;
        }
        this.f28693q.setColor(i4);
        if (!isInEditMode()) {
            this.f28693q.setShadowLayer(f10, f7, f8, i3);
        }
        if (this.f28670C == -1.0f && this.f28668A == -1.0f && this.f28669B == -1.0f && this.f28671D == -1.0f) {
            canvas.drawRoundRect(rectF, f9, f9, this.f28693q);
        } else {
            this.f28699w.left = (float) this.f28695s;
            this.f28699w.top = (float) this.f28696t;
            this.f28699w.right = (float) (getWidth() - this.f28697u);
            this.f28699w.bottom = (float) (getHeight() - this.f28698v);
            this.f28693q.setAntiAlias(true);
            float f11 = this.f28668A;
            if (f11 == -1.0f) {
                f11 = this.f28686j;
            }
            int i7 = ((int) f11) / 4;
            float f12 = this.f28670C;
            if (f12 == -1.0f) {
                f12 = this.f28686j;
            }
            int i8 = ((int) f12) / 4;
            float f13 = this.f28669B;
            if (f13 == -1.0f) {
                f13 = this.f28686j;
            }
            int i9 = ((int) f13) / 4;
            float f14 = this.f28671D;
            float f15 = (float) i7;
            float f16 = (float) i9;
            float f17 = (float) ((f14 == -1.0f ? (int) this.f28686j : (int) f14) / 4);
            float f18 = (float) i8;
            float[] fArr = {f15, f15, f16, f16, f17, f17, f18, f18};
            Path path = new Path();
            path.addRoundRect(rectF, fArr, Path.Direction.CW);
            canvas.drawPath(path, this.f28693q);
        }
        return createBitmap;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f28699w.left = (float) this.f28695s;
        this.f28699w.top = (float) this.f28696t;
        this.f28699w.right = (float) (getWidth() - this.f28697u);
        this.f28699w.bottom = (float) (getHeight() - this.f28698v);
        int i = (int) (this.f28699w.bottom - this.f28699w.top);
        if (getChildAt(0) == null) {
            return;
        }
        if (this.f28668A == -1.0f && this.f28670C == -1.0f && this.f28669B == -1.0f && this.f28671D == -1.0f) {
            float f = this.f28686j;
            float f2 = (float) (i / 2);
            if (f > f2) {
                canvas.drawRoundRect(this.f28699w, f2, f2, this.f28694r);
                if (this.f28674G != -101) {
                    canvas.drawRoundRect(new RectF(this.f28699w.left + (this.f28673F / 2.0f), this.f28699w.top + (this.f28673F / 2.0f), this.f28699w.right - (this.f28673F / 2.0f), this.f28699w.bottom - (this.f28673F / 2.0f)), f2, f2, this.f28672E);
                    return;
                }
                return;
            }
            canvas.drawRoundRect(this.f28699w, f, f, this.f28694r);
            if (this.f28674G != -101) {
                RectF rectF = new RectF(this.f28699w.left + (this.f28673F / 2.0f), this.f28699w.top + (this.f28673F / 2.0f), this.f28699w.right - (this.f28673F / 2.0f), this.f28699w.bottom - (this.f28673F / 2.0f));
                float f3 = this.f28686j;
                canvas.drawRoundRect(rectF, f3, f3, this.f28672E);
                return;
            }
            return;
        }
        m22335a(canvas, i);
    }

    /* renamed from: a */
    private void m22335a(Canvas canvas, int i) {
        float f = this.f28668A;
        if (f == -1.0f) {
            f = this.f28686j;
        }
        int i2 = (int) f;
        int i3 = i / 2;
        if (i2 > i3) {
            i2 = i3;
        }
        float f2 = this.f28669B;
        if (f2 == -1.0f) {
            f2 = this.f28686j;
        }
        int i4 = (int) f2;
        if (i4 > i3) {
            i4 = i3;
        }
        float f3 = this.f28671D;
        if (f3 == -1.0f) {
            f3 = this.f28686j;
        }
        int i5 = (int) f3;
        if (i5 > i3) {
            i5 = i3;
        }
        float f4 = this.f28670C;
        int i6 = f4 == -1.0f ? (int) this.f28686j : (int) f4;
        if (i6 <= i3) {
            i3 = i6;
        }
        float f5 = (float) i2;
        float f6 = (float) i4;
        float f7 = (float) i5;
        float f8 = (float) i3;
        float[] fArr = {f5, f5, f6, f6, f7, f7, f8, f8};
        if (this.f28674G != -101) {
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, (RectF) null, (float[]) null));
            shapeDrawable.getPaint().setColor(this.f28694r.getColor());
            shapeDrawable.setBounds(this.f28695s, this.f28696t, getWidth() - this.f28697u, getHeight() - this.f28698v);
            shapeDrawable.draw(canvas);
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new RoundRectShape(fArr, (RectF) null, (float[]) null));
            shapeDrawable2.getPaint().setColor(this.f28672E.getColor());
            shapeDrawable2.getPaint().setStyle(Paint.Style.STROKE);
            shapeDrawable2.getPaint().setStrokeWidth(this.f28673F);
            float f9 = this.f28673F;
            shapeDrawable2.setBounds((int) (((float) this.f28695s) + (f9 / 2.0f)), (int) (((float) this.f28696t) + (f9 / 2.0f)), (int) (((float) (getWidth() - this.f28697u)) - (this.f28673F / 2.0f)), (int) (((float) (getHeight() - this.f28698v)) - (this.f28673F / 2.0f)));
            shapeDrawable2.draw(canvas);
            return;
        }
        ShapeDrawable shapeDrawable3 = new ShapeDrawable(new RoundRectShape(fArr, (RectF) null, (float[]) null));
        shapeDrawable3.getPaint().setColor(this.f28694r.getColor());
        shapeDrawable3.setBounds(this.f28695s, this.f28696t, getWidth() - this.f28697u, getHeight() - this.f28698v);
        shapeDrawable3.draw(canvas);
    }

    public void isAddAlpha(int i) {
        if (Color.alpha(i) == 255) {
            String hexString = Integer.toHexString(Color.red(i));
            String hexString2 = Integer.toHexString(Color.green(i));
            String hexString3 = Integer.toHexString(Color.blue(i));
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            if (hexString2.length() == 1) {
                hexString2 = "0" + hexString2;
            }
            if (hexString3.length() == 1) {
                hexString3 = "0" + hexString3;
            }
            this.f28684h = convertToColorInt("#2a" + hexString + hexString2 + hexString3);
        }
    }

    public static int convertToColorInt(String str) throws IllegalArgumentException {
        if (!str.startsWith(RConfigConstants.KEYWORD_COLOR_SIGN)) {
            str = RConfigConstants.KEYWORD_COLOR_SIGN + str;
        }
        return Color.parseColor(str);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!(this.f28683g == -101 && this.f28675H == -101 && this.f28680d == null) && this.f28676I) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if ((action == 1 || action == 3) && this.f28700x == 1) {
                    this.f28694r.setColor(this.f28682f);
                    int i = this.f28674G;
                    if (i != -101) {
                        this.f28672E.setColor(i);
                    }
                    Drawable drawable = this.f28679c;
                    if (drawable != null) {
                        setBackGround(drawable);
                    }
                    postInvalidate();
                }
            } else if (this.f28700x == 1) {
                int i2 = this.f28683g;
                if (i2 != -101) {
                    this.f28694r.setColor(i2);
                }
                int i3 = this.f28675H;
                if (i3 != -101) {
                    this.f28672E.setColor(i3);
                }
                Drawable drawable2 = this.f28680d;
                if (drawable2 != null) {
                    setBackGround(drawable2);
                }
                postInvalidate();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBackGround(Drawable drawable) {
        if (this.f28681e != null && drawable != null) {
            if (this.f28668A != -1.0f || this.f28670C != -1.0f || this.f28669B != -1.0f || this.f28671D != -1.0f) {
                int i = (this.f28668A > -1.0f ? 1 : (this.f28668A == -1.0f ? 0 : -1));
                int i2 = (this.f28670C > -1.0f ? 1 : (this.f28670C == -1.0f ? 0 : -1));
                int i3 = (this.f28669B > -1.0f ? 1 : (this.f28669B == -1.0f ? 0 : -1));
                int i4 = (this.f28671D > -1.0f ? 1 : (this.f28671D == -1.0f ? 0 : -1));
            }
        }
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
