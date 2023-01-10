package com.didi.addressnew.view.shadow;

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
import com.didi.addressnew.util.ViewUtils;
import com.didi.passenger.C11267R;
import rui.config.RConfigConstants;

public class ShadowLayout extends FrameLayout {

    /* renamed from: A */
    private float f9438A;

    /* renamed from: B */
    private float f9439B;

    /* renamed from: C */
    private float f9440C;

    /* renamed from: D */
    private float f9441D;

    /* renamed from: E */
    private Paint f9442E;

    /* renamed from: F */
    private float f9443F;

    /* renamed from: G */
    private int f9444G;

    /* renamed from: H */
    private int f9445H;

    /* renamed from: I */
    private boolean f9446I;

    /* renamed from: a */
    private Drawable f9447a;

    /* renamed from: b */
    private int f9448b;

    /* renamed from: c */
    private Drawable f9449c;

    /* renamed from: d */
    private Drawable f9450d;

    /* renamed from: e */
    private View f9451e;

    /* renamed from: f */
    private int f9452f;

    /* renamed from: g */
    private int f9453g;

    /* renamed from: h */
    private int f9454h;

    /* renamed from: i */
    private float f9455i;

    /* renamed from: j */
    private float f9456j;

    /* renamed from: k */
    private float f9457k;

    /* renamed from: l */
    private float f9458l;

    /* renamed from: m */
    private boolean f9459m;

    /* renamed from: n */
    private boolean f9460n;

    /* renamed from: o */
    private boolean f9461o;

    /* renamed from: p */
    private boolean f9462p;

    /* renamed from: q */
    private Paint f9463q;

    /* renamed from: r */
    private Paint f9464r;

    /* renamed from: s */
    private int f9465s;

    /* renamed from: t */
    private int f9466t;

    /* renamed from: u */
    private int f9467u;

    /* renamed from: v */
    private int f9468v;

    /* renamed from: w */
    private RectF f9469w;

    /* renamed from: x */
    private int f9470x;

    /* renamed from: y */
    private boolean f9471y;

    /* renamed from: z */
    private boolean f9472z;

    public ShadowLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ShadowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9448b = -101;
        this.f9453g = -101;
        this.f9469w = new RectF();
        this.f9470x = 1;
        this.f9471y = true;
        m8214a(context, attributeSet);
    }

    /* renamed from: a */
    private void m8214a(Context context, AttributeSet attributeSet) {
        m8216a(attributeSet);
        Paint paint = new Paint();
        this.f9463q = paint;
        paint.setAntiAlias(true);
        this.f9463q.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f9442E = paint2;
        paint2.setAntiAlias(true);
        this.f9442E.setStyle(Paint.Style.STROKE);
        this.f9442E.setStrokeWidth(this.f9443F);
        int i = this.f9444G;
        if (i != -101) {
            this.f9442E.setColor(i);
        }
        Paint paint3 = new Paint(1);
        this.f9464r = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.f9464r.setColor(this.f9452f);
        setPadding();
    }

    /* renamed from: a */
    private void m8216a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C11267R.styleable.ShadowLayout);
        if (obtainStyledAttributes != null) {
            try {
                this.f9471y = !obtainStyledAttributes.getBoolean(44, false);
                this.f9459m = !obtainStyledAttributes.getBoolean(46, false);
                this.f9460n = !obtainStyledAttributes.getBoolean(47, false);
                this.f9462p = !obtainStyledAttributes.getBoolean(45, false);
                this.f9461o = !obtainStyledAttributes.getBoolean(48, false);
                this.f9456j = obtainStyledAttributes.getDimension(3, 0.0f);
                this.f9438A = obtainStyledAttributes.getDimension(5, -1.0f);
                this.f9440C = obtainStyledAttributes.getDimension(4, -1.0f);
                this.f9439B = obtainStyledAttributes.getDimension(7, -1.0f);
                this.f9441D = obtainStyledAttributes.getDimension(6, -1.0f);
                float dimension = obtainStyledAttributes.getDimension(49, 0.0f);
                this.f9455i = dimension;
                if (dimension == 0.0f) {
                    this.f9471y = false;
                }
                this.f9457k = obtainStyledAttributes.getDimension(50, 0.0f);
                this.f9458l = obtainStyledAttributes.getDimension(51, 0.0f);
                this.f9454h = obtainStyledAttributes.getColor(43, Color.parseColor("#2a000000"));
                this.f9470x = obtainStyledAttributes.getInt(54, 1);
                this.f9472z = obtainStyledAttributes.getBoolean(53, true);
                this.f9452f = -1;
                Drawable drawable = obtainStyledAttributes.getDrawable(40);
                if (drawable != null) {
                    if (drawable instanceof ColorDrawable) {
                        this.f9452f = ((ColorDrawable) drawable).getColor();
                    } else {
                        this.f9449c = drawable;
                    }
                }
                Drawable drawable2 = obtainStyledAttributes.getDrawable(42);
                if (drawable2 != null) {
                    if (drawable2 instanceof ColorDrawable) {
                        this.f9453g = ((ColorDrawable) drawable2).getColor();
                    } else {
                        this.f9450d = drawable2;
                    }
                }
                if (this.f9453g != -101) {
                    if (this.f9449c != null) {
                        throw new UnsupportedOperationException("使用了ShadowLayout_layoutBackground_true属性，必须先设置ShadowLayout_layoutBackground属性。且设置颜色时，必须保持都为颜色");
                    }
                }
                if (this.f9449c == null) {
                    if (this.f9450d != null) {
                        throw new UnsupportedOperationException("使用了ShadowLayout_layoutBackground_true属性，必须先设置ShadowLayout_layoutBackground属性。且设置图片时，必须保持都为图片");
                    }
                }
                this.f9444G = obtainStyledAttributes.getColor(55, -101);
                int color = obtainStyledAttributes.getColor(56, -101);
                this.f9445H = color;
                if (this.f9444G == -101) {
                    if (color != -101) {
                        throw new UnsupportedOperationException("使用了ShadowLayout_strokeColor_true属性，必须先设置ShadowLayout_strokeColor属性");
                    }
                }
                float dimension2 = obtainStyledAttributes.getDimension(57, (float) ViewUtils.dip2px(getContext(), 1.0f));
                this.f9443F = dimension2;
                if (dimension2 > ((float) ViewUtils.dip2px(getContext(), 7.0f))) {
                    this.f9443F = (float) ViewUtils.dip2px(getContext(), 5.0f);
                }
                Drawable drawable3 = obtainStyledAttributes.getDrawable(41);
                if (drawable3 != null) {
                    if (drawable3 instanceof ColorDrawable) {
                        this.f9448b = ((ColorDrawable) drawable3).getColor();
                    } else {
                        this.f9447a = drawable3;
                    }
                }
                boolean z = obtainStyledAttributes.getBoolean(2, true);
                this.f9446I = z;
                setClickable(z);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        this.f9446I = z;
        changeSwitchClickable();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.f9446I) {
            super.setOnClickListener(onClickListener);
        }
    }

    public void changeSwitchClickable() {
        View view;
        if (this.f9470x == 1 && (view = this.f9451e) != null) {
            if (this.f9446I) {
                Drawable drawable = this.f9449c;
                if (drawable != null) {
                    setBackGround(drawable);
                } else if (view.getBackground() != null) {
                    this.f9451e.getBackground().setAlpha(0);
                }
                this.f9464r.setColor(this.f9452f);
                postInvalidate();
            } else if (this.f9448b != -101) {
                if (this.f9449c != null) {
                    view.getBackground().setAlpha(0);
                }
                this.f9464r.setColor(this.f9448b);
                postInvalidate();
            } else {
                Drawable drawable2 = this.f9447a;
                if (drawable2 != null) {
                    setBackGround(drawable2);
                    this.f9464r.setColor(Color.parseColor("#00000000"));
                    postInvalidate();
                }
            }
        }
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.f9470x == 2) {
            if (z) {
                int i = this.f9453g;
                if (i != -101) {
                    this.f9464r.setColor(i);
                }
                int i2 = this.f9445H;
                if (i2 != -101) {
                    this.f9442E.setColor(i2);
                }
                Drawable drawable = this.f9450d;
                if (drawable != null) {
                    setBackGround(drawable);
                }
            } else {
                this.f9464r.setColor(this.f9452f);
                int i3 = this.f9444G;
                if (i3 != -101) {
                    this.f9442E.setColor(i3);
                }
                Drawable drawable2 = this.f9449c;
                if (drawable2 != null) {
                    setBackGround(drawable2);
                }
            }
            postInvalidate();
        }
    }

    public void setShowShadow(boolean z) {
        this.f9471y = z;
        if (getWidth() != 0 && getHeight() != 0) {
            m8213a(getWidth(), getHeight());
        }
    }

    public void setXOffset(float f) {
        float abs = Math.abs(f);
        float f2 = this.f9455i;
        if (abs <= f2) {
            this.f9457k = f;
        } else if (f > 0.0f) {
            this.f9457k = f2;
        } else {
            this.f9457k = -f2;
        }
        setPadding();
    }

    public void setYOffset(float f) {
        float abs = Math.abs(f);
        float f2 = this.f9455i;
        if (abs <= f2) {
            this.f9458l = f;
        } else if (f > 0.0f) {
            this.f9458l = f2;
        } else {
            this.f9458l = -f2;
        }
        setPadding();
    }

    public void setCornerRadius(int i) {
        this.f9456j = (float) i;
        if (getWidth() != 0 && getHeight() != 0) {
            m8213a(getWidth(), getHeight());
        }
    }

    public void setShadowSpreed(int i) {
        this.f9455i = (float) i;
        setPadding();
    }

    public void setShadowColor(int i) {
        this.f9454h = i;
        if (getWidth() != 0 && getHeight() != 0) {
            m8213a(getWidth(), getHeight());
        }
    }

    public void setIsShowLeftShadow(boolean z) {
        this.f9459m = z;
        setPadding();
    }

    public void setIsShowRightShadow(boolean z) {
        this.f9460n = z;
        setPadding();
    }

    public void setIsShowTopShadow(boolean z) {
        this.f9461o = z;
        setPadding();
    }

    public void setIsShowBottomShadow(boolean z) {
        this.f9462p = z;
        setPadding();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        View childAt = getChildAt(0);
        this.f9451e = childAt;
        if (childAt == null) {
            this.f9451e = this;
        }
        if (this.f9451e == null) {
            return;
        }
        if (this.f9470x == 2) {
            if (isSelected()) {
                setBackGround(this.f9450d);
            } else {
                setBackGround(this.f9449c);
            }
        } else if (this.f9446I) {
            setBackGround(this.f9449c);
        } else {
            setBackGround(this.f9447a);
            int i = this.f9448b;
            if (i != -101) {
                this.f9464r.setColor(i);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            m8213a(i, i2);
        }
    }

    public void setPadding() {
        if (this.f9471y) {
            float f = this.f9455i;
            if (f > 0.0f) {
                int i = 0;
                if (this.f9472z) {
                    int abs = (int) (f + Math.abs(this.f9457k));
                    int abs2 = (int) (this.f9455i + Math.abs(this.f9458l));
                    this.f9465s = this.f9459m ? abs : 0;
                    if (!this.f9460n) {
                        abs = 0;
                    }
                    this.f9467u = abs;
                    this.f9466t = this.f9461o ? abs2 : 0;
                    if (this.f9462p) {
                        i = abs2;
                    }
                    this.f9468v = i;
                } else {
                    float abs3 = Math.abs(this.f9458l);
                    float f2 = this.f9455i;
                    if (abs3 > f2) {
                        if (this.f9458l <= 0.0f) {
                            f2 = -f2;
                        }
                        this.f9458l = f2;
                    }
                    float abs4 = Math.abs(this.f9457k);
                    float f3 = this.f9455i;
                    if (abs4 > f3) {
                        if (this.f9457k <= 0.0f) {
                            f3 = -f3;
                        }
                        this.f9457k = f3;
                    }
                    this.f9466t = this.f9461o ? (int) (this.f9455i - this.f9458l) : 0;
                    this.f9467u = this.f9460n ? (int) (this.f9455i - this.f9457k) : 0;
                    this.f9468v = this.f9462p ? (int) (this.f9455i + this.f9458l) : 0;
                    if (this.f9459m) {
                        i = (int) (this.f9455i + this.f9457k);
                    }
                    this.f9465s = i;
                }
                setPadding(this.f9465s, this.f9466t, this.f9467u, this.f9468v);
            }
        }
    }

    /* renamed from: a */
    private void m8213a(int i, int i2) {
        if (this.f9471y) {
            isAddAlpha(this.f9454h);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(m8212a(i, i2, this.f9456j, this.f9455i, this.f9457k, this.f9458l, this.f9454h, 0));
            if (Build.VERSION.SDK_INT <= 16) {
                setBackgroundDrawable(bitmapDrawable);
            } else {
                setBackground(bitmapDrawable);
            }
        } else if (getChildAt(0) == null) {
            Drawable drawable = this.f9449c;
            if (drawable != null) {
                this.f9451e = this;
                if (this.f9446I) {
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
    private Bitmap m8212a(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4) {
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
        if (this.f9472z) {
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
        this.f9463q.setColor(i4);
        if (!isInEditMode()) {
            this.f9463q.setShadowLayer(f10, f7, f8, i3);
        }
        if (this.f9440C == -1.0f && this.f9438A == -1.0f && this.f9439B == -1.0f && this.f9441D == -1.0f) {
            canvas.drawRoundRect(rectF, f9, f9, this.f9463q);
        } else {
            this.f9469w.left = (float) this.f9465s;
            this.f9469w.top = (float) this.f9466t;
            this.f9469w.right = (float) (getWidth() - this.f9467u);
            this.f9469w.bottom = (float) (getHeight() - this.f9468v);
            this.f9463q.setAntiAlias(true);
            float f11 = this.f9438A;
            if (f11 == -1.0f) {
                f11 = this.f9456j;
            }
            int i7 = ((int) f11) / 4;
            float f12 = this.f9440C;
            if (f12 == -1.0f) {
                f12 = this.f9456j;
            }
            int i8 = ((int) f12) / 4;
            float f13 = this.f9439B;
            if (f13 == -1.0f) {
                f13 = this.f9456j;
            }
            int i9 = ((int) f13) / 4;
            float f14 = this.f9441D;
            float f15 = (float) i7;
            float f16 = (float) i9;
            float f17 = (float) ((f14 == -1.0f ? (int) this.f9456j : (int) f14) / 4);
            float f18 = (float) i8;
            float[] fArr = {f15, f15, f16, f16, f17, f17, f18, f18};
            Path path = new Path();
            path.addRoundRect(rectF, fArr, Path.Direction.CW);
            canvas.drawPath(path, this.f9463q);
        }
        return createBitmap;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f9469w.left = (float) this.f9465s;
        this.f9469w.top = (float) this.f9466t;
        this.f9469w.right = (float) (getWidth() - this.f9467u);
        this.f9469w.bottom = (float) (getHeight() - this.f9468v);
        int i = (int) (this.f9469w.bottom - this.f9469w.top);
        if (getChildAt(0) == null) {
            return;
        }
        if (this.f9438A == -1.0f && this.f9440C == -1.0f && this.f9439B == -1.0f && this.f9441D == -1.0f) {
            float f = this.f9456j;
            float f2 = (float) (i / 2);
            if (f > f2) {
                canvas.drawRoundRect(this.f9469w, f2, f2, this.f9464r);
                if (this.f9444G != -101) {
                    canvas.drawRoundRect(new RectF(this.f9469w.left + (this.f9443F / 2.0f), this.f9469w.top + (this.f9443F / 2.0f), this.f9469w.right - (this.f9443F / 2.0f), this.f9469w.bottom - (this.f9443F / 2.0f)), f2, f2, this.f9442E);
                    return;
                }
                return;
            }
            canvas.drawRoundRect(this.f9469w, f, f, this.f9464r);
            if (this.f9444G != -101) {
                RectF rectF = new RectF(this.f9469w.left + (this.f9443F / 2.0f), this.f9469w.top + (this.f9443F / 2.0f), this.f9469w.right - (this.f9443F / 2.0f), this.f9469w.bottom - (this.f9443F / 2.0f));
                float f3 = this.f9456j;
                canvas.drawRoundRect(rectF, f3, f3, this.f9442E);
                return;
            }
            return;
        }
        m8215a(canvas, i);
    }

    /* renamed from: a */
    private void m8215a(Canvas canvas, int i) {
        float f = this.f9438A;
        if (f == -1.0f) {
            f = this.f9456j;
        }
        int i2 = (int) f;
        int i3 = i / 2;
        if (i2 > i3) {
            i2 = i3;
        }
        float f2 = this.f9439B;
        if (f2 == -1.0f) {
            f2 = this.f9456j;
        }
        int i4 = (int) f2;
        if (i4 > i3) {
            i4 = i3;
        }
        float f3 = this.f9441D;
        if (f3 == -1.0f) {
            f3 = this.f9456j;
        }
        int i5 = (int) f3;
        if (i5 > i3) {
            i5 = i3;
        }
        float f4 = this.f9440C;
        int i6 = f4 == -1.0f ? (int) this.f9456j : (int) f4;
        if (i6 <= i3) {
            i3 = i6;
        }
        float f5 = (float) i2;
        float f6 = (float) i4;
        float f7 = (float) i5;
        float f8 = (float) i3;
        float[] fArr = {f5, f5, f6, f6, f7, f7, f8, f8};
        if (this.f9444G != -101) {
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, (RectF) null, (float[]) null));
            shapeDrawable.getPaint().setColor(this.f9464r.getColor());
            shapeDrawable.setBounds(this.f9465s, this.f9466t, getWidth() - this.f9467u, getHeight() - this.f9468v);
            shapeDrawable.draw(canvas);
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new RoundRectShape(fArr, (RectF) null, (float[]) null));
            shapeDrawable2.getPaint().setColor(this.f9442E.getColor());
            shapeDrawable2.getPaint().setStyle(Paint.Style.STROKE);
            shapeDrawable2.getPaint().setStrokeWidth(this.f9443F);
            float f9 = this.f9443F;
            shapeDrawable2.setBounds((int) (((float) this.f9465s) + (f9 / 2.0f)), (int) (((float) this.f9466t) + (f9 / 2.0f)), (int) (((float) (getWidth() - this.f9467u)) - (this.f9443F / 2.0f)), (int) (((float) (getHeight() - this.f9468v)) - (this.f9443F / 2.0f)));
            shapeDrawable2.draw(canvas);
            return;
        }
        ShapeDrawable shapeDrawable3 = new ShapeDrawable(new RoundRectShape(fArr, (RectF) null, (float[]) null));
        shapeDrawable3.getPaint().setColor(this.f9464r.getColor());
        shapeDrawable3.setBounds(this.f9465s, this.f9466t, getWidth() - this.f9467u, getHeight() - this.f9468v);
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
            this.f9454h = convertToColorInt("#2a" + hexString + hexString2 + hexString3);
        }
    }

    public static int convertToColorInt(String str) throws IllegalArgumentException {
        if (!str.startsWith(RConfigConstants.KEYWORD_COLOR_SIGN)) {
            str = RConfigConstants.KEYWORD_COLOR_SIGN + str;
        }
        return Color.parseColor(str);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!(this.f9453g == -101 && this.f9445H == -101 && this.f9450d == null) && this.f9446I) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if ((action == 1 || action == 3) && this.f9470x == 1) {
                    this.f9464r.setColor(this.f9452f);
                    int i = this.f9444G;
                    if (i != -101) {
                        this.f9442E.setColor(i);
                    }
                    Drawable drawable = this.f9449c;
                    if (drawable != null) {
                        setBackGround(drawable);
                    }
                    postInvalidate();
                }
            } else if (this.f9470x == 1) {
                int i2 = this.f9453g;
                if (i2 != -101) {
                    this.f9464r.setColor(i2);
                }
                int i3 = this.f9445H;
                if (i3 != -101) {
                    this.f9442E.setColor(i3);
                }
                Drawable drawable2 = this.f9450d;
                if (drawable2 != null) {
                    setBackGround(drawable2);
                }
                postInvalidate();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBackGround(Drawable drawable) {
        if (this.f9451e != null && drawable != null) {
            if (this.f9438A != -1.0f || this.f9440C != -1.0f || this.f9439B != -1.0f || this.f9441D != -1.0f) {
                int i = (this.f9438A > -1.0f ? 1 : (this.f9438A == -1.0f ? 0 : -1));
                int i2 = (this.f9440C > -1.0f ? 1 : (this.f9440C == -1.0f ? 0 : -1));
                int i3 = (this.f9439B > -1.0f ? 1 : (this.f9439B == -1.0f ? 0 : -1));
                int i4 = (this.f9441D > -1.0f ? 1 : (this.f9441D == -1.0f ? 0 : -1));
            }
        }
    }
}
