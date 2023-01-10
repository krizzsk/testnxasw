package com.didiglobal.p205sa.biz.component.drainageguide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.sdk.util.AppUtils;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideBgViewTips */
public class SADrainageGuideBgViewTips extends RelativeLayout {

    /* renamed from: A */
    int f53359A = UiUtils.dip2px(getContext(), 2.0f);

    /* renamed from: B */
    private Paint f53360B;

    /* renamed from: C */
    private Bitmap f53361C;

    /* renamed from: D */
    private Paint f53362D;

    /* renamed from: E */
    private Paint f53363E;

    /* renamed from: F */
    private float f53364F;

    /* renamed from: G */
    private float f53365G;

    /* renamed from: H */
    private int f53366H = 45;

    /* renamed from: I */
    private Paint f53367I;

    /* renamed from: J */
    private int f53368J;

    /* renamed from: K */
    private RectF f53369K = new RectF();

    /* renamed from: L */
    private Paint f53370L;

    /* renamed from: M */
    private Paint f53371M;

    /* renamed from: N */
    private Bitmap f53372N;

    /* renamed from: O */
    private Canvas f53373O;

    /* renamed from: P */
    private int f53374P;

    /* renamed from: Q */
    private int[] f53375Q;

    /* renamed from: R */
    private Rect f53376R;

    /* renamed from: S */
    private int f53377S;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public View.OnClickListener f53378T;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public View.OnClickListener f53379U;

    /* renamed from: V */
    private TextView f53380V;

    /* renamed from: W */
    private float f53381W;

    /* renamed from: X */
    private float f53382X;

    /* renamed from: Y */
    private Rect f53383Y = new Rect();

    /* renamed from: Z */
    private View f53384Z;

    /* renamed from: a */
    int f53385a = 75;

    /* renamed from: aa */
    private View f53386aa;

    /* renamed from: ab */
    private ImageView f53387ab;

    /* renamed from: b */
    int f53388b = 125;

    /* renamed from: c */
    int f53389c = UiUtils.dip2px(getContext(), 3.0f);

    /* renamed from: d */
    int f53390d = (-UiUtils.dip2px(getContext(), 9.0f));

    /* renamed from: e */
    int f53391e = UiUtils.dip2px(getContext(), 15.0f);

    /* renamed from: f */
    float f53392f = ((float) UiUtils.dip2px(getContext(), 24.0f));

    /* renamed from: g */
    float f53393g = ((float) UiUtils.dip2px(getContext(), 34.0f));

    /* renamed from: h */
    int f53394h = 51;

    /* renamed from: i */
    int f53395i = 25;

    /* renamed from: j */
    int f53396j = 0;

    /* renamed from: k */
    int f53397k;

    /* renamed from: l */
    int f53398l = UiUtils.dip2px(getContext(), 3.0f);

    /* renamed from: m */
    int f53399m = UiUtils.dip2px(getContext(), 3.0f);

    /* renamed from: n */
    float f53400n = ((float) UiUtils.dip2px(getContext(), 24.0f));

    /* renamed from: o */
    float f53401o = ((float) UiUtils.dip2px(getContext(), 31.0f));

    /* renamed from: p */
    int f53402p = 127;

    /* renamed from: q */
    int f53403q = 102;

    /* renamed from: r */
    int f53404r = 0;

    /* renamed from: s */
    int f53405s;

    /* renamed from: t */
    int f53406t = UiUtils.dip2px(getContext(), 3.0f);

    /* renamed from: u */
    int f53407u = UiUtils.dip2px(getContext(), 11.0f);

    /* renamed from: v */
    float f53408v = 0.33333334f;

    /* renamed from: w */
    int f53409w = UiUtils.dip2px(getContext(), 16.0f);

    /* renamed from: x */
    int f53410x = UiUtils.dip2px(getContext(), 11.0f);

    /* renamed from: y */
    int f53411y = UiUtils.dip2px(getContext(), 20.0f);

    /* renamed from: z */
    int f53412z = UiUtils.dip2px(getContext(), 24.0f);

    /* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideBgViewTips$TipType */
    public @interface TipType {
        public static final int Tip_bottom = 1;
        public static final int Tip_top = 0;
    }

    public void setVisiblePaddings(Rect rect) {
        this.f53383Y = rect;
    }

    public SADrainageGuideBgViewTips(Context context, int i) {
        super(context);
        this.f53368J = i;
        m39909a();
    }

    /* renamed from: a */
    private void m39909a() {
        setBackgroundResource(R.color.transparent);
        this.f53374P = (int) getContext().getResources().getDimension(R.dimen.view_radius);
        int dimension = (int) getContext().getResources().getDimension(R.dimen.view_bg_radius);
        this.f53377S = dimension;
        int i = dimension * 2;
        this.f53375Q = new int[]{i, i, i, i};
        m39914c();
        this.f53384Z = LayoutInflater.from(getContext()).inflate(R.layout.sa_drainage_guide_view, (ViewGroup) null);
        addView(this.f53384Z, new RelativeLayout.LayoutParams(-2, -2));
        View findViewById = findViewById(R.id.close);
        this.f53386aa = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SADrainageGuideBgViewTips.this.f53378T != null) {
                    SADrainageGuideBgViewTips.this.f53378T.onClick(view);
                }
            }
        });
        this.f53387ab = (ImageView) findViewById(R.id.img);
        this.f53380V = (TextView) findViewById(R.id.drainage_tips);
    }

    public void setOnGetClickListener(View.OnClickListener onClickListener) {
        this.f53378T = onClickListener;
    }

    public void setmGuideViewListener(View.OnClickListener onClickListener) {
        this.f53379U = onClickListener;
    }

    public void setmAllBgDiameter(int[] iArr) {
        this.f53375Q = iArr;
    }

    public void setHightLightPos(RectF rectF) {
        this.f53369K = rectF;
        this.f53381W = rectF.bottom - rectF.top;
        this.f53382X = rectF.right - rectF.left;
        this.f53364F = rectF.left + (this.f53382X / 2.0f);
        this.f53365G = (this.f53381W / 2.0f) + rectF.top;
        this.f53385a = ((int) (this.f53381W / 2.0f)) - this.f53383Y.top;
        this.f53388b = ((int) (this.f53382X / 2.0f)) - this.f53383Y.left;
    }

    public void setMargin(Rect rect) {
        this.f53376R = rect;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m39910a(canvas);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            super.onMeasure(r7, r8)
            android.view.View r7 = r6.f53384Z
            if (r7 == 0) goto L_0x00c5
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            if (r7 == 0) goto L_0x00c5
            android.view.View r7 = r6.f53384Z
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r7 = (android.widget.RelativeLayout.LayoutParams) r7
            android.graphics.RectF r8 = r6.f53369K
            float r8 = r8.right
            android.graphics.RectF r0 = r6.f53369K
            float r0 = r0.left
            float r8 = r8 + r0
            r0 = 1073741824(0x40000000, float:2.0)
            float r8 = r8 / r0
            int r1 = r6.getMeasuredWidth()
            float r1 = (float) r1
            float r1 = r1 / r0
            r2 = 1101004800(0x41a00000, float:20.0)
            float r1 = r1 - r2
            r3 = 0
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x0040
            int r1 = r6.getMeasuredWidth()
            float r1 = (float) r1
            float r1 = r1 / r0
            float r1 = r1 + r2
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0040
            r8 = 14
            r7.addRule(r8)
            goto L_0x0074
        L_0x0040:
            int r1 = r6.getMeasuredWidth()
            float r1 = (float) r1
            float r1 = r1 / r0
            r2 = 1098907648(0x41800000, float:16.0)
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x005c
            r8 = 11
            r7.addRule(r8)
            android.content.Context r8 = r6.getContext()
            int r8 = com.didi.global.globaluikit.utils.UiUtils.dip2px(r8, r2)
            r0 = r8
            r8 = 0
            goto L_0x0076
        L_0x005c:
            int r1 = r6.getMeasuredWidth()
            float r1 = (float) r1
            float r1 = r1 / r0
            int r8 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r8 >= 0) goto L_0x0074
            r8 = 9
            r7.addRule(r8)
            android.content.Context r8 = r6.getContext()
            int r8 = com.didi.global.globaluikit.utils.UiUtils.dip2px(r8, r2)
            goto L_0x0075
        L_0x0074:
            r8 = 0
        L_0x0075:
            r0 = 0
        L_0x0076:
            int r1 = r6.f53368J
            r2 = 1
            r4 = 10
            if (r1 != r2) goto L_0x009d
            r7.addRule(r4)
            float r1 = r6.f53365G
            int r2 = r6.f53385a
            float r2 = (float) r2
            float r1 = r1 + r2
            int r2 = r6.f53410x
            float r2 = (float) r2
            float r1 = r1 + r2
            android.graphics.Bitmap r2 = r6.f53361C
            int r2 = r2.getHeight()
            float r2 = (float) r2
            float r1 = r1 + r2
            int r2 = r6.f53359A
            int r2 = r2 * 10
            float r2 = (float) r2
            float r1 = r1 + r2
            int r1 = (int) r1
            r7.setMargins(r8, r1, r0, r3)
            goto L_0x00c5
        L_0x009d:
            if (r1 != 0) goto L_0x00c5
            r1 = 12
            r7.addRule(r1)
            int r1 = r6.getMeasuredHeight()
            float r2 = r6.f53365G
            int r5 = r6.f53385a
            float r5 = (float) r5
            float r2 = r2 - r5
            int r5 = r6.f53410x
            float r5 = (float) r5
            float r2 = r2 - r5
            android.graphics.Bitmap r5 = r6.f53361C
            int r5 = r5.getHeight()
            float r5 = (float) r5
            float r2 = r2 - r5
            int r5 = r6.f53359A
            int r5 = r5 * 10
            float r4 = (float) r5
            float r2 = r2 - r4
            int r2 = (int) r2
            int r1 = r1 - r2
            r7.setMargins(r8, r3, r0, r1)
        L_0x00c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideBgViewTips.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    /* renamed from: a */
    private void m39910a(Canvas canvas) {
        if (this.f53370L == null) {
            this.f53370L = new Paint();
            this.f53370L.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
            this.f53370L.setAntiAlias(true);
        }
        if (canvas.getWidth() > 0 && canvas.getHeight() > 0) {
            if (this.f53372N == null) {
                this.f53372N = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
                this.f53373O = new Canvas(this.f53372N);
            }
            if (this.f53371M == null) {
                Paint paint = new Paint();
                this.f53371M = paint;
                paint.setColor(Color.parseColor("#FF8040"));
                this.f53371M.setStyle(Paint.Style.STROKE);
                this.f53371M.setAntiAlias(true);
                this.f53371M.setStrokeWidth((float) UiUtils.dip2px(getContext(), 6.0f));
            }
            this.f53373O.drawRoundRect((this.f53369K.left + ((float) this.f53383Y.left)) - ((float) (this.f53376R.left / 2)), (this.f53369K.top + ((float) this.f53383Y.top)) - ((float) (this.f53376R.top / 2)), (this.f53369K.right - ((float) this.f53383Y.right)) + ((float) (this.f53376R.right / 2)), (this.f53369K.bottom - ((float) this.f53383Y.bottom)) + ((float) (this.f53376R.bottom / 2)), (float) UiUtils.dip2px(getContext(), 24.0f), (float) UiUtils.dip2px(getContext(), 24.0f), this.f53371M);
            canvas.drawBitmap(this.f53372N, 0.0f, 0.0f, this.f53371M);
            m39913b(canvas);
        }
    }

    /* renamed from: b */
    private void m39912b() {
        int[] iArr = this.f53375Q;
        if (iArr != null && iArr.length >= 4) {
            Path path = new Path();
            path.moveTo((this.f53369K.left + ((float) this.f53375Q[0])) - ((float) this.f53376R.left), this.f53369K.top - ((float) this.f53376R.top));
            path.lineTo((this.f53369K.right - ((float) this.f53375Q[1])) + ((float) this.f53376R.right), this.f53369K.top - ((float) this.f53376R.top));
            path.arcTo(new RectF((this.f53369K.right - ((float) this.f53375Q[1])) + ((float) this.f53376R.right), this.f53369K.top - ((float) this.f53376R.top), this.f53369K.right + ((float) this.f53376R.right), (this.f53369K.top - ((float) this.f53376R.top)) + ((float) this.f53375Q[1])), -90.0f, 90.0f);
            path.lineTo(this.f53369K.right + ((float) this.f53376R.right), (this.f53369K.bottom + ((float) this.f53376R.bottom)) - ((float) this.f53375Q[2]));
            path.arcTo(new RectF((this.f53369K.right + ((float) this.f53376R.right)) - ((float) this.f53375Q[2]), (this.f53369K.bottom + ((float) this.f53376R.bottom)) - ((float) this.f53375Q[2]), this.f53369K.right + ((float) this.f53376R.right), this.f53369K.bottom + ((float) this.f53376R.bottom)), 0.0f, 90.0f);
            path.lineTo((this.f53369K.left - ((float) this.f53376R.left)) + ((float) this.f53375Q[3]), this.f53369K.bottom + ((float) this.f53376R.bottom));
            path.arcTo(new RectF(this.f53369K.left - ((float) this.f53376R.left), (this.f53369K.bottom + ((float) this.f53376R.bottom)) - ((float) this.f53375Q[3]), (this.f53369K.left - ((float) this.f53376R.left)) + ((float) this.f53375Q[3]), this.f53369K.bottom + ((float) this.f53376R.bottom)), 90.0f, 90.0f);
            path.lineTo(this.f53369K.left - ((float) this.f53376R.left), (this.f53369K.top - ((float) this.f53376R.top)) + ((float) this.f53375Q[0]));
            path.arcTo(new RectF(this.f53369K.left - ((float) this.f53376R.left), this.f53369K.top - ((float) this.f53376R.top), (this.f53369K.left - ((float) this.f53376R.left)) + ((float) this.f53375Q[0]), (this.f53369K.top - ((float) this.f53376R.top)) + ((float) this.f53375Q[0])), 180.0f, 90.0f);
            path.close();
            this.f53373O.drawPath(path, this.f53371M);
        }
    }

    public void setData(final SADrainageModel sADrainageModel) {
        if (!(this.f53380V == null || sADrainageModel.getTips() == null)) {
            this.f53380V.setText(getSpanWithLabel(sADrainageModel.getTips(), ContextCompat.getDrawable(getContext(), R.drawable.drainage_icon_more)));
        }
        int i = R.drawable.drainage_didi_placehold;
        if (AppUtils.isBrazilApp(getContext())) {
            i = R.drawable.drainage_99_placehold;
        }
        ((RequestBuilder) ((RequestBuilder) Glide.with(getContext()).load(sADrainageModel.getImage()).placeholder(i)).error(i)).into(this.f53387ab);
        if (!TextUtils.isEmpty(sADrainageModel.getTips_action())) {
            this.f53384Z.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (SADrainageGuideBgViewTips.this.f53379U != null) {
                        SADrainageGuideBgViewTips.this.f53379U.onClick(view);
                    }
                    DRouter.build(sADrainageModel.getTips_action()).start();
                }
            });
        }
    }

    public SpannableStringBuilder getSpanWithLabel(String str, Drawable drawable) {
        drawable.setBounds(0, 0, UiUtils.dip2px(getContext(), 12.0f), UiUtils.dip2px(getContext(), 12.0f));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + "  ");
        spannableStringBuilder.setSpan(new SAVerticalImageSpan(drawable), spannableStringBuilder.length() + -1, spannableStringBuilder.length(), 18);
        return spannableStringBuilder;
    }

    /* renamed from: c */
    private void m39914c() {
        int parseColor = Color.parseColor("#FF8040");
        int parseColor2 = Color.parseColor("#FF8040");
        Paint paint = new Paint();
        this.f53362D = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f53362D.setColor(parseColor);
        this.f53362D.setStrokeWidth(12.0f);
        this.f53362D.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f53363E = paint2;
        paint2.setAntiAlias(true);
        this.f53363E.setStyle(Paint.Style.STROKE);
        this.f53363E.setStrokeWidth(6.0f);
        this.f53363E.setAlpha(255);
        this.f53363E.setColor(parseColor2);
        Paint paint3 = new Paint();
        this.f53360B = paint3;
        paint3.setAntiAlias(true);
        this.f53360B.setStyle(Paint.Style.STROKE);
        this.f53360B.setStrokeWidth(6.0f);
        this.f53360B.setAlpha(51);
        this.f53360B.setColor(parseColor2);
        Bitmap copy = BitmapFactory.decodeResource(getResources(), R.drawable.arrow).copy(Bitmap.Config.ARGB_8888, true);
        int width = copy.getWidth();
        int height = copy.getHeight();
        float f = ((float) this.f53411y) / ((float) width);
        float f2 = ((float) this.f53412z) / ((float) height);
        Matrix matrix = new Matrix();
        if (this.f53368J == 1) {
            matrix.setRotate(180.0f);
        }
        matrix.postScale(f, f2);
        this.f53361C = Bitmap.createBitmap(copy, 0, 0, width, height, matrix, true);
        Paint paint4 = new Paint();
        this.f53367I = paint4;
        paint4.setColor(parseColor2);
        this.f53367I.setStyle(Paint.Style.FILL);
    }

    /* renamed from: b */
    private void m39913b(Canvas canvas) {
        float f;
        float f2;
        int i = this.f53390d;
        int i2 = this.f53389c;
        float f3 = (((float) (i - i2)) * 1.0f) / ((float) (this.f53391e - i2));
        int i3 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
        if (i3 > 0 && f3 <= 1.0f) {
            float f4 = this.f53392f;
            float f5 = f4 + ((this.f53393g - f4) * f3);
            int i4 = this.f53394h;
            float f6 = ((float) i4) + (((float) (this.f53395i - i4)) * f3);
            this.f53360B.setStrokeWidth((float) i);
            this.f53360B.setAlpha((int) f6);
            float f7 = this.f53364F;
            int i5 = this.f53388b;
            int i6 = this.f53390d;
            float f8 = this.f53365G;
            int i7 = this.f53385a;
            canvas.drawRoundRect(new RectF((f7 - ((float) i5)) - ((float) (i6 / 2)), (f8 - ((float) i7)) - ((float) (i6 / 2)), f7 + ((float) i5) + ((float) (i6 / 2)), f8 + ((float) i7) + ((float) (i6 / 2))), f5, f5, this.f53360B);
        } else if (f3 >= 1.0f) {
            float f9 = this.f53408v;
            if (f3 <= f9 + 1.0f) {
                float f10 = (f3 - 1.0f) / f9;
                int i8 = this.f53395i;
                this.f53360B.setAlpha((int) (((float) i8) + (((float) (this.f53396j - i8)) * f10)));
                float f11 = this.f53364F;
                int i9 = this.f53388b;
                int i10 = this.f53390d;
                float f12 = this.f53365G;
                int i11 = this.f53385a;
                RectF rectF = new RectF((f11 - ((float) i9)) - ((float) (i10 / 2)), (f12 - ((float) i11)) - ((float) (i10 / 2)), f11 + ((float) i9) + ((float) (i10 / 2)), f12 + ((float) i11) + ((float) (i10 / 2)));
                float f13 = this.f53393g;
                canvas.drawRoundRect(rectF, f13, f13, this.f53360B);
            }
        }
        float f14 = this.f53408v;
        if (f3 <= f14 || f3 >= f14 + 1.0f) {
            float f15 = this.f53408v;
            if (f3 >= f15 + 1.0f && f3 <= (f15 * 2.0f) + 1.0f) {
                float f16 = ((f3 - 1.0f) - f15) / f15;
                int i12 = this.f53403q;
                this.f53363E.setAlpha((int) (((float) i12) + (((float) (this.f53404r - i12)) * f16)));
                RectF rectF2 = new RectF(((this.f53364F - ((float) this.f53388b)) - ((float) ((this.f53390d - UiUtils.dip2px(getContext(), 4.0f)) / 2))) - ((float) (this.f53398l / 2)), ((this.f53365G - ((float) this.f53385a)) - ((float) ((this.f53390d - UiUtils.dip2px(getContext(), 4.0f)) / 2))) - ((float) (this.f53398l / 2)), this.f53364F + ((float) this.f53388b) + ((float) ((this.f53390d - UiUtils.dip2px(getContext(), 4.0f)) / 2)) + ((float) (this.f53398l / 2)), this.f53365G + ((float) this.f53385a) + ((float) ((this.f53390d - UiUtils.dip2px(getContext(), 4.0f)) / 2)) + ((float) (this.f53398l / 2)));
                float f17 = this.f53401o;
                canvas.drawRoundRect(rectF2, f17, f17, this.f53363E);
            }
        } else {
            float f18 = f3 - f14;
            int i13 = this.f53402p;
            float f19 = ((float) i13) + (((float) (this.f53403q - i13)) * f18);
            float f20 = this.f53400n;
            float f21 = f20 + ((this.f53401o - f20) * f18);
            this.f53363E.setStrokeWidth((float) this.f53398l);
            this.f53363E.setAlpha((int) f19);
            canvas.drawRoundRect(new RectF(((this.f53364F - ((float) this.f53388b)) - ((float) ((this.f53390d - UiUtils.dip2px(getContext(), 4.0f)) / 2))) - ((float) (this.f53398l / 2)), ((this.f53365G - ((float) this.f53385a)) - ((float) ((this.f53390d - UiUtils.dip2px(getContext(), 4.0f)) / 2))) - ((float) (this.f53398l / 2)), this.f53364F + ((float) this.f53388b) + ((float) ((this.f53390d - UiUtils.dip2px(getContext(), 4.0f)) / 2)) + ((float) (this.f53398l / 2)), this.f53365G + ((float) this.f53385a) + ((float) ((this.f53390d - UiUtils.dip2px(getContext(), 4.0f)) / 2)) + ((float) (this.f53398l / 2))), f21, f21, this.f53363E);
        }
        if (f3 <= 0.0f) {
            int i14 = this.f53410x;
            int i15 = this.f53409w;
            float f22 = (((float) (i14 - i15)) * ((f3 + 1.0f) / 1.0f)) + ((float) i15);
            if (this.f53368J == 1) {
                f2 = this.f53365G + ((float) this.f53385a) + f22;
            } else {
                f2 = ((this.f53365G - ((float) this.f53385a)) - f22) - ((float) this.f53361C.getHeight());
            }
            canvas.drawBitmap(this.f53361C, this.f53364F - ((float) (this.f53411y / 2)), f2, new Paint());
        } else if (i3 > 0) {
            int i16 = this.f53409w;
            int i17 = this.f53410x;
            float f23 = (((float) (i16 - i17)) * (f3 / ((this.f53408v * 2.0f) + 1.0f))) + ((float) i17);
            if (this.f53368J == 1) {
                f = this.f53365G + ((float) this.f53385a) + f23;
            } else {
                f = ((this.f53365G - ((float) this.f53385a)) - f23) - ((float) this.f53361C.getHeight());
            }
            canvas.drawBitmap(this.f53361C, this.f53364F - ((float) (this.f53411y / 2)), f, new Paint());
        }
        if (this.f53368J == 1) {
            float f24 = this.f53364F;
            float height = this.f53365G + ((float) this.f53385a) + ((float) this.f53410x) + ((float) this.f53361C.getHeight());
            int i18 = this.f53359A;
            canvas.drawCircle(f24, height + ((float) (i18 * 2)), (float) i18, this.f53367I);
            float f25 = this.f53364F;
            float height2 = this.f53365G + ((float) this.f53385a) + ((float) this.f53410x) + ((float) this.f53361C.getHeight());
            int i19 = this.f53359A;
            canvas.drawCircle(f25, height2 + ((float) (i19 * 5)), (float) i19, this.f53367I);
            float f26 = this.f53364F;
            float height3 = this.f53365G + ((float) this.f53385a) + ((float) this.f53410x) + ((float) this.f53361C.getHeight());
            int i20 = this.f53359A;
            canvas.drawCircle(f26, height3 + ((float) (i20 * 8)), (float) i20, this.f53367I);
        } else {
            float f27 = this.f53364F;
            float height4 = ((this.f53365G - ((float) this.f53385a)) - ((float) this.f53410x)) - ((float) this.f53361C.getHeight());
            int i21 = this.f53359A;
            canvas.drawCircle(f27, height4 - ((float) (i21 * 2)), (float) i21, this.f53367I);
            float f28 = this.f53364F;
            float height5 = ((this.f53365G - ((float) this.f53385a)) - ((float) this.f53410x)) - ((float) this.f53361C.getHeight());
            int i22 = this.f53359A;
            canvas.drawCircle(f28, height5 - ((float) (i22 * 5)), (float) i22, this.f53367I);
            float f29 = this.f53364F;
            float height6 = ((this.f53365G - ((float) this.f53385a)) - ((float) this.f53410x)) - ((float) this.f53361C.getHeight());
            int i23 = this.f53359A;
            canvas.drawCircle(f29, height6 - ((float) (i23 * 8)), (float) i23, this.f53367I);
        }
        this.f53390d += UiUtils.dip2px(getContext(), 1.0f);
        if (f3 > (this.f53408v * 2.0f) + 1.0f) {
            this.f53390d = -UiUtils.dip2px(getContext(), 9.0f);
        }
        postInvalidateDelayed((long) this.f53366H);
    }
}
