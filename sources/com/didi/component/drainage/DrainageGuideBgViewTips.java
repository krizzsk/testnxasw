package com.didi.component.drainage;

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
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.drainage.DrainageGuideView;
import com.didi.drouter.api.DRouter;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.sdk.util.AppUtils;
import com.taxis99.R;

public class DrainageGuideBgViewTips extends RelativeLayout {

    /* renamed from: A */
    private float f14664A;

    /* renamed from: B */
    private float f14665B;

    /* renamed from: C */
    private int f14666C = 40;

    /* renamed from: D */
    private Paint f14667D;

    /* renamed from: E */
    private int f14668E;

    /* renamed from: F */
    private RectF f14669F = new RectF();

    /* renamed from: G */
    private Paint f14670G;

    /* renamed from: H */
    private Paint f14671H;

    /* renamed from: I */
    private Bitmap f14672I;

    /* renamed from: J */
    private Canvas f14673J;

    /* renamed from: K */
    private int f14674K;

    /* renamed from: L */
    private int[] f14675L;

    /* renamed from: M */
    private Rect f14676M;

    /* renamed from: N */
    private int f14677N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public View.OnClickListener f14678O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public View.OnClickListener f14679P;

    /* renamed from: Q */
    private TextView f14680Q;

    /* renamed from: R */
    private float f14681R;

    /* renamed from: S */
    private float f14682S;

    /* renamed from: T */
    private Rect f14683T = new Rect();

    /* renamed from: U */
    private View f14684U;

    /* renamed from: V */
    private View f14685V;

    /* renamed from: W */
    private DrainageGuideView.MyShape f14686W;

    /* renamed from: X */
    private ImageView f14687X;

    /* renamed from: Y */
    private Paint f14688Y;

    /* renamed from: Z */
    private Bitmap f14689Z;

    /* renamed from: a */
    int f14690a = 75;

    /* renamed from: aa */
    private Paint f14691aa;

    /* renamed from: b */
    int f14692b = 125;

    /* renamed from: c */
    int f14693c = UiUtils.dip2px(getContext(), 3.0f);

    /* renamed from: d */
    int f14694d = (-UiUtils.dip2px(getContext(), 9.0f));

    /* renamed from: e */
    int f14695e = UiUtils.dip2px(getContext(), 15.0f);

    /* renamed from: f */
    float f14696f = ((float) UiUtils.dip2px(getContext(), 24.0f));

    /* renamed from: g */
    float f14697g = ((float) UiUtils.dip2px(getContext(), 34.0f));

    /* renamed from: h */
    int f14698h = 51;

    /* renamed from: i */
    int f14699i = 25;

    /* renamed from: j */
    int f14700j = 0;

    /* renamed from: k */
    int f14701k = UiUtils.dip2px(getContext(), 3.0f);

    /* renamed from: l */
    float f14702l = ((float) UiUtils.dip2px(getContext(), 24.0f));

    /* renamed from: m */
    float f14703m = ((float) UiUtils.dip2px(getContext(), 31.0f));

    /* renamed from: n */
    int f14704n = 127;

    /* renamed from: o */
    int f14705o = 102;

    /* renamed from: p */
    int f14706p = 0;

    /* renamed from: q */
    int f14707q;

    /* renamed from: r */
    int f14708r = UiUtils.dip2px(getContext(), 3.0f);

    /* renamed from: s */
    int f14709s = UiUtils.dip2px(getContext(), 11.0f);

    /* renamed from: t */
    float f14710t = 0.33333334f;

    /* renamed from: u */
    int f14711u = UiUtils.dip2px(getContext(), 16.0f);

    /* renamed from: v */
    int f14712v = UiUtils.dip2px(getContext(), 11.0f);

    /* renamed from: w */
    int f14713w = UiUtils.dip2px(getContext(), 20.0f);

    /* renamed from: x */
    int f14714x = UiUtils.dip2px(getContext(), 24.0f);

    /* renamed from: y */
    int f14715y = UiUtils.dip2px(getContext(), 2.0f);

    /* renamed from: z */
    private Paint f14716z;

    public @interface TipType {
        public static final int Tip_bottom = 1;
        public static final int Tip_top = 0;
    }

    public void setVisiblePaddings(Rect rect) {
        this.f14683T = rect;
    }

    public DrainageGuideBgViewTips(Context context, int i) {
        super(context);
        this.f14668E = i;
        m12152a();
    }

    /* renamed from: a */
    private void m12152a() {
        setBackgroundResource(R.color.transparent);
        this.f14674K = UiUtils.dip2px(getContext(), 20.0f);
        int dip2px = UiUtils.dip2px(getContext(), 30.0f);
        this.f14677N = dip2px;
        int i = dip2px * 2;
        this.f14675L = new int[]{i, i, i, i};
        m12155b();
        this.f14684U = LayoutInflater.from(getContext()).inflate(R.layout.drainage_guide_view, (ViewGroup) null);
        addView(this.f14684U, new RelativeLayout.LayoutParams(-2, -2));
        View findViewById = findViewById(R.id.close);
        this.f14685V = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (DrainageGuideBgViewTips.this.f14678O != null) {
                    DrainageGuideBgViewTips.this.f14678O.onClick(view);
                }
            }
        });
        this.f14687X = (ImageView) findViewById(R.id.img);
        this.f14684U.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.f14680Q = (TextView) findViewById(R.id.drainage_tips);
    }

    /* renamed from: b */
    private void m12155b() {
        int parseColor = Color.parseColor("#FF8040");
        int parseColor2 = Color.parseColor("#FF8040");
        Paint paint = new Paint();
        this.f14716z = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f14716z.setColor(parseColor);
        this.f14716z.setStrokeWidth(12.0f);
        this.f14716z.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f14691aa = paint2;
        paint2.setAntiAlias(true);
        this.f14691aa.setStyle(Paint.Style.STROKE);
        this.f14691aa.setStrokeWidth(6.0f);
        this.f14691aa.setAlpha(255);
        this.f14691aa.setColor(parseColor2);
        Paint paint3 = new Paint();
        this.f14688Y = paint3;
        paint3.setAntiAlias(true);
        this.f14688Y.setStyle(Paint.Style.STROKE);
        this.f14688Y.setStrokeWidth(6.0f);
        this.f14688Y.setAlpha(51);
        this.f14688Y.setColor(parseColor2);
        Bitmap copy = BitmapFactory.decodeResource(getResources(), R.drawable.arrow).copy(Bitmap.Config.ARGB_8888, true);
        int width = copy.getWidth();
        int height = copy.getHeight();
        float f = ((float) this.f14713w) / ((float) width);
        float f2 = ((float) this.f14714x) / ((float) height);
        Matrix matrix = new Matrix();
        if (this.f14668E == 1) {
            matrix.setRotate(180.0f);
        }
        matrix.postScale(f, f2);
        this.f14689Z = Bitmap.createBitmap(copy, 0, 0, width, height, matrix, true);
        Paint paint4 = new Paint();
        this.f14667D = paint4;
        paint4.setColor(parseColor2);
        this.f14667D.setStyle(Paint.Style.FILL);
    }

    public void setOnGetClickListener(View.OnClickListener onClickListener) {
        this.f14678O = onClickListener;
    }

    public void setmGuideViewListener(View.OnClickListener onClickListener) {
        this.f14679P = onClickListener;
    }

    public void setHightLightPos(RectF rectF) {
        this.f14669F = rectF;
        this.f14681R = rectF.bottom - rectF.top;
        this.f14682S = rectF.right - rectF.left;
        this.f14664A = rectF.left + (this.f14682S / 2.0f);
        this.f14665B = (this.f14681R / 2.0f) + rectF.top;
        this.f14690a = ((int) (this.f14681R / 2.0f)) - this.f14683T.top;
        this.f14692b = ((int) (this.f14682S / 2.0f)) - this.f14683T.left;
    }

    public void setMargin(Rect rect) {
        this.f14676M = rect;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m12153a(canvas);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            super.onMeasure(r6, r7)
            android.view.View r6 = r5.f14684U
            if (r6 == 0) goto L_0x00db
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            if (r6 == 0) goto L_0x00db
            android.view.View r6 = r5.f14684U
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r6 = (android.widget.RelativeLayout.LayoutParams) r6
            android.graphics.RectF r7 = r5.f14669F
            float r7 = r7.right
            android.graphics.RectF r0 = r5.f14669F
            float r0 = r0.left
            float r7 = r7 + r0
            r0 = 1073741824(0x40000000, float:2.0)
            float r7 = r7 / r0
            int r1 = r5.getMeasuredWidth()
            float r1 = (float) r1
            float r1 = r1 / r0
            r2 = 1101004800(0x41a00000, float:20.0)
            float r1 = r1 - r2
            r3 = 0
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x0040
            int r1 = r5.getMeasuredWidth()
            float r1 = (float) r1
            float r1 = r1 / r0
            float r1 = r1 + r2
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0040
            r7 = 14
            r6.addRule(r7)
            goto L_0x008f
        L_0x0040:
            int r1 = r5.getMeasuredWidth()
            float r1 = (float) r1
            float r1 = r1 / r0
            r2 = 1098907648(0x41800000, float:16.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x0077
            r7 = 11
            r6.addRule(r7)
            int r7 = r5.getMeasuredWidth()
            float r7 = (float) r7
            android.graphics.RectF r0 = r5.f14669F
            float r0 = r0.right
            float r7 = r7 - r0
            android.graphics.Rect r0 = r5.f14683T
            int r0 = r0.right
            float r0 = (float) r0
            float r7 = r7 + r0
            int r7 = (int) r7
            android.content.Context r0 = r5.getContext()
            int r0 = com.didi.global.globaluikit.utils.UiUtils.dip2px(r0, r2)
            if (r7 >= r0) goto L_0x0074
            android.content.Context r7 = r5.getContext()
            int r7 = com.didi.global.globaluikit.utils.UiUtils.dip2px(r7, r2)
        L_0x0074:
            r0 = r7
            r7 = 0
            goto L_0x0091
        L_0x0077:
            int r1 = r5.getMeasuredWidth()
            float r1 = (float) r1
            float r1 = r1 / r0
            int r7 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r7 >= 0) goto L_0x008f
            r7 = 9
            r6.addRule(r7)
            android.content.Context r7 = r5.getContext()
            int r7 = com.didi.global.globaluikit.utils.UiUtils.dip2px(r7, r2)
            goto L_0x0090
        L_0x008f:
            r7 = 0
        L_0x0090:
            r0 = 0
        L_0x0091:
            int r1 = r5.f14668E
            r2 = 1
            if (r1 != r2) goto L_0x00b3
            float r1 = r5.f14665B
            int r2 = r5.f14690a
            float r2 = (float) r2
            float r1 = r1 + r2
            int r2 = r5.f14712v
            float r2 = (float) r2
            float r1 = r1 + r2
            android.graphics.Bitmap r2 = r5.f14689Z
            int r2 = r2.getHeight()
            float r2 = (float) r2
            float r1 = r1 + r2
            int r2 = r5.f14715y
            int r2 = r2 * 10
            float r2 = (float) r2
            float r1 = r1 + r2
            int r1 = (int) r1
            r6.setMargins(r7, r1, r0, r3)
            goto L_0x00db
        L_0x00b3:
            if (r1 != 0) goto L_0x00db
            r1 = 12
            r6.addRule(r1)
            int r1 = r5.getMeasuredHeight()
            float r2 = r5.f14665B
            int r4 = r5.f14690a
            float r4 = (float) r4
            float r2 = r2 - r4
            int r4 = r5.f14712v
            float r4 = (float) r4
            float r2 = r2 - r4
            android.graphics.Bitmap r4 = r5.f14689Z
            int r4 = r4.getHeight()
            float r4 = (float) r4
            float r2 = r2 - r4
            int r4 = r5.f14715y
            int r4 = r4 * 10
            float r4 = (float) r4
            float r2 = r2 - r4
            int r2 = (int) r2
            int r1 = r1 - r2
            r6.setMargins(r7, r3, r0, r1)
        L_0x00db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.drainage.DrainageGuideBgViewTips.onMeasure(int, int):void");
    }

    /* renamed from: a */
    private void m12153a(Canvas canvas) {
        if (this.f14670G == null) {
            this.f14670G = new Paint();
            this.f14670G.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
            this.f14670G.setAntiAlias(true);
        }
        if (canvas.getWidth() > 0 && canvas.getHeight() > 0) {
            if (this.f14672I == null) {
                this.f14672I = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
                this.f14673J = new Canvas(this.f14672I);
            }
            if (this.f14671H == null) {
                Paint paint = new Paint();
                this.f14671H = paint;
                paint.setColor(Color.parseColor("#FF8040"));
                this.f14671H.setStyle(Paint.Style.STROKE);
                this.f14671H.setAntiAlias(true);
                this.f14671H.setStrokeWidth((float) UiUtils.dip2px(getContext(), 6.0f));
            }
            if (this.f14686W == DrainageGuideView.MyShape.RECTANGULAR) {
                this.f14673J.drawRoundRect((this.f14669F.left + ((float) this.f14683T.left)) - ((float) (this.f14676M.left / 2)), (this.f14669F.top + ((float) this.f14683T.top)) - ((float) (this.f14676M.top / 2)), (this.f14669F.right - ((float) this.f14683T.right)) + ((float) (this.f14676M.right / 2)), (this.f14669F.bottom - ((float) this.f14683T.bottom)) + ((float) (this.f14676M.bottom / 2)), (float) UiUtils.dip2px(getContext(), 24.0f), (float) UiUtils.dip2px(getContext(), 24.0f), this.f14671H);
            } else if (this.f14686W == DrainageGuideView.MyShape.CIRCLE) {
                this.f14673J.drawCircle(this.f14664A, this.f14665B, (float) (this.f14692b + (this.f14676M.left / 2)), this.f14671H);
            }
            canvas.drawBitmap(this.f14672I, 0.0f, 0.0f, this.f14671H);
            m12156b(canvas);
        }
    }

    /* renamed from: c */
    private void m12157c() {
        int[] iArr = this.f14675L;
        if (iArr != null && iArr.length >= 4) {
            Path path = new Path();
            path.moveTo((this.f14669F.left + ((float) this.f14675L[0])) - ((float) this.f14676M.left), this.f14669F.top - ((float) this.f14676M.top));
            path.lineTo((this.f14669F.right - ((float) this.f14675L[1])) + ((float) this.f14676M.right), this.f14669F.top - ((float) this.f14676M.top));
            path.arcTo(new RectF((this.f14669F.right - ((float) this.f14675L[1])) + ((float) this.f14676M.right), this.f14669F.top - ((float) this.f14676M.top), this.f14669F.right + ((float) this.f14676M.right), (this.f14669F.top - ((float) this.f14676M.top)) + ((float) this.f14675L[1])), -90.0f, 90.0f);
            path.lineTo(this.f14669F.right + ((float) this.f14676M.right), (this.f14669F.bottom + ((float) this.f14676M.bottom)) - ((float) this.f14675L[2]));
            path.arcTo(new RectF((this.f14669F.right + ((float) this.f14676M.right)) - ((float) this.f14675L[2]), (this.f14669F.bottom + ((float) this.f14676M.bottom)) - ((float) this.f14675L[2]), this.f14669F.right + ((float) this.f14676M.right), this.f14669F.bottom + ((float) this.f14676M.bottom)), 0.0f, 90.0f);
            path.lineTo((this.f14669F.left - ((float) this.f14676M.left)) + ((float) this.f14675L[3]), this.f14669F.bottom + ((float) this.f14676M.bottom));
            path.arcTo(new RectF(this.f14669F.left - ((float) this.f14676M.left), (this.f14669F.bottom + ((float) this.f14676M.bottom)) - ((float) this.f14675L[3]), (this.f14669F.left - ((float) this.f14676M.left)) + ((float) this.f14675L[3]), this.f14669F.bottom + ((float) this.f14676M.bottom)), 90.0f, 90.0f);
            path.lineTo(this.f14669F.left - ((float) this.f14676M.left), (this.f14669F.top - ((float) this.f14676M.top)) + ((float) this.f14675L[0]));
            path.arcTo(new RectF(this.f14669F.left - ((float) this.f14676M.left), this.f14669F.top - ((float) this.f14676M.top), (this.f14669F.left - ((float) this.f14676M.left)) + ((float) this.f14675L[0]), (this.f14669F.top - ((float) this.f14676M.top)) + ((float) this.f14675L[0])), 180.0f, 90.0f);
            path.close();
            this.f14673J.drawPath(path, this.f14671H);
        }
    }

    public void setShape(DrainageGuideView.MyShape myShape) {
        this.f14686W = myShape;
    }

    public void setData(final DrainageData drainageData) {
        if (!(this.f14680Q == null || drainageData.getTips() == null)) {
            this.f14680Q.setText(m12150a(drainageData.getTips(), getResources().getDrawable(R.drawable.drainage_icon_more)));
        }
        int i = R.drawable.drainage_didi_placehold;
        if (AppUtils.isBrazilApp(getContext())) {
            i = R.drawable.drainage_99_placehold;
        }
        ((RequestBuilder) ((RequestBuilder) Glide.with(getContext()).load(drainageData.getImage()).placeholder(i)).error(i)).into(this.f14687X);
        if (!TextUtils.isEmpty(drainageData.getTips_action())) {
            this.f14684U.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (DrainageGuideBgViewTips.this.f14679P != null) {
                        DrainageGuideBgViewTips.this.f14679P.onClick(view);
                    }
                    DRouter.build(drainageData.getTips_action()).start();
                }
            });
        }
    }

    /* renamed from: a */
    private SpannableStringBuilder m12150a(String str, Drawable drawable) {
        drawable.setBounds(0, 0, UiUtils.dip2px(getContext(), 12.0f), UiUtils.dip2px(getContext(), 12.0f));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + "  ");
        spannableStringBuilder.setSpan(new VerticalImageSpan(drawable), spannableStringBuilder.length() + -1, spannableStringBuilder.length(), 18);
        return spannableStringBuilder;
    }

    /* renamed from: b */
    private void m12156b(Canvas canvas) {
        float f;
        float f2;
        int i = this.f14694d;
        int i2 = this.f14693c;
        float f3 = (((float) (i - i2)) * 1.0f) / ((float) (this.f14695e - i2));
        int i3 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
        if (i3 > 0 && f3 <= 1.0f) {
            float f4 = this.f14696f;
            float f5 = f4 + ((this.f14697g - f4) * f3);
            int i4 = this.f14698h;
            float f6 = ((float) i4) + (((float) (this.f14699i - i4)) * f3);
            this.f14688Y.setStrokeWidth((float) i);
            this.f14688Y.setAlpha((int) f6);
            if (this.f14686W == DrainageGuideView.MyShape.RECTANGULAR) {
                float f7 = this.f14664A;
                int i5 = this.f14692b;
                int i6 = this.f14694d;
                float f8 = this.f14665B;
                int i7 = this.f14690a;
                canvas.drawRoundRect(new RectF((f7 - ((float) i5)) - ((float) (i6 / 2)), (f8 - ((float) i7)) - ((float) (i6 / 2)), f7 + ((float) i5) + ((float) (i6 / 2)), f8 + ((float) i7) + ((float) (i6 / 2))), f5, f5, this.f14688Y);
            } else if (this.f14686W == DrainageGuideView.MyShape.CIRCLE) {
                canvas.drawCircle(this.f14664A, this.f14665B, (float) (this.f14692b + (this.f14694d / 2)), this.f14688Y);
            }
        } else if (f3 >= 1.0f) {
            float f9 = this.f14710t;
            if (f3 <= f9 + 1.0f) {
                float f10 = (f3 - 1.0f) / f9;
                int i8 = this.f14699i;
                this.f14688Y.setAlpha((int) (((float) i8) + (((float) (this.f14700j - i8)) * f10)));
                if (this.f14686W == DrainageGuideView.MyShape.RECTANGULAR) {
                    float f11 = this.f14664A;
                    int i9 = this.f14692b;
                    int i10 = this.f14694d;
                    float f12 = this.f14665B;
                    int i11 = this.f14690a;
                    RectF rectF = new RectF((f11 - ((float) i9)) - ((float) (i10 / 2)), (f12 - ((float) i11)) - ((float) (i10 / 2)), f11 + ((float) i9) + ((float) (i10 / 2)), f12 + ((float) i11) + ((float) (i10 / 2)));
                    float f13 = this.f14697g;
                    canvas.drawRoundRect(rectF, f13, f13, this.f14688Y);
                } else if (this.f14686W == DrainageGuideView.MyShape.CIRCLE) {
                    canvas.drawCircle(this.f14664A, this.f14665B, (float) (this.f14692b + (this.f14694d / 2)), this.f14688Y);
                }
            }
        }
        float f14 = this.f14710t;
        if (f3 <= f14 || f3 >= f14 + 1.0f) {
            float f15 = this.f14710t;
            if (f3 >= f15 + 1.0f && f3 <= (f15 * 2.0f) + 1.0f) {
                float f16 = ((f3 - 1.0f) - f15) / f15;
                int i12 = this.f14705o;
                this.f14691aa.setAlpha((int) (((float) i12) + (((float) (this.f14706p - i12)) * f16)));
                if (this.f14686W == DrainageGuideView.MyShape.RECTANGULAR) {
                    RectF rectF2 = new RectF(((this.f14664A - ((float) this.f14692b)) - ((float) ((this.f14694d - UiUtils.dip2px(getContext(), 4.0f)) / 2))) - ((float) (this.f14701k / 2)), ((this.f14665B - ((float) this.f14690a)) - ((float) ((this.f14694d - UiUtils.dip2px(getContext(), 4.0f)) / 2))) - ((float) (this.f14701k / 2)), this.f14664A + ((float) this.f14692b) + ((float) ((this.f14694d - UiUtils.dip2px(getContext(), 4.0f)) / 2)) + ((float) (this.f14701k / 2)), this.f14665B + ((float) this.f14690a) + ((float) ((this.f14694d - UiUtils.dip2px(getContext(), 4.0f)) / 2)) + ((float) (this.f14701k / 2)));
                    float f17 = this.f14703m;
                    canvas.drawRoundRect(rectF2, f17, f17, this.f14691aa);
                } else if (this.f14686W == DrainageGuideView.MyShape.CIRCLE) {
                    canvas.drawCircle(this.f14664A, this.f14665B, (float) (this.f14692b + ((this.f14694d - UiUtils.dip2px(getContext(), 4.0f)) / 2) + (this.f14701k / 2)), this.f14691aa);
                }
            }
        } else {
            float f18 = f3 - f14;
            int i13 = this.f14704n;
            float f19 = ((float) i13) + (((float) (this.f14705o - i13)) * f18);
            float f20 = this.f14702l;
            float f21 = f20 + ((this.f14703m - f20) * f18);
            this.f14691aa.setStrokeWidth((float) this.f14701k);
            this.f14691aa.setAlpha((int) f19);
            if (this.f14686W == DrainageGuideView.MyShape.RECTANGULAR) {
                canvas.drawRoundRect(new RectF(((this.f14664A - ((float) this.f14692b)) - ((float) ((this.f14694d - UiUtils.dip2px(getContext(), 4.0f)) / 2))) - ((float) (this.f14701k / 2)), ((this.f14665B - ((float) this.f14690a)) - ((float) ((this.f14694d - UiUtils.dip2px(getContext(), 4.0f)) / 2))) - ((float) (this.f14701k / 2)), this.f14664A + ((float) this.f14692b) + ((float) ((this.f14694d - UiUtils.dip2px(getContext(), 4.0f)) / 2)) + ((float) (this.f14701k / 2)), this.f14665B + ((float) this.f14690a) + ((float) ((this.f14694d - UiUtils.dip2px(getContext(), 4.0f)) / 2)) + ((float) (this.f14701k / 2))), f21, f21, this.f14691aa);
            } else if (this.f14686W == DrainageGuideView.MyShape.CIRCLE) {
                canvas.drawCircle(this.f14664A, this.f14665B, (float) (this.f14692b + ((this.f14694d - UiUtils.dip2px(getContext(), 4.0f)) / 2) + (this.f14701k / 2)), this.f14691aa);
            }
        }
        if (f3 <= 0.0f) {
            int i14 = this.f14712v;
            int i15 = this.f14711u;
            float f22 = (((float) (i14 - i15)) * ((f3 + 1.0f) / 1.0f)) + ((float) i15);
            if (this.f14668E == 1) {
                f2 = this.f14665B + ((float) this.f14690a) + f22;
            } else {
                f2 = ((this.f14665B - ((float) this.f14690a)) - f22) - ((float) this.f14689Z.getHeight());
            }
            canvas.drawBitmap(this.f14689Z, this.f14664A - ((float) (this.f14713w / 2)), f2, new Paint());
        } else if (i3 > 0) {
            int i16 = this.f14711u;
            int i17 = this.f14712v;
            float f23 = (((float) (i16 - i17)) * (f3 / ((this.f14710t * 2.0f) + 1.0f))) + ((float) i17);
            if (this.f14668E == 1) {
                f = this.f14665B + ((float) this.f14690a) + f23;
            } else {
                f = ((this.f14665B - ((float) this.f14690a)) - f23) - ((float) this.f14689Z.getHeight());
            }
            canvas.drawBitmap(this.f14689Z, this.f14664A - ((float) (this.f14713w / 2)), f, new Paint());
        }
        if (this.f14668E == 1) {
            float f24 = this.f14664A;
            float height = this.f14665B + ((float) this.f14690a) + ((float) this.f14712v) + ((float) this.f14689Z.getHeight());
            int i18 = this.f14715y;
            canvas.drawCircle(f24, height + ((float) (i18 * 2)), (float) i18, this.f14667D);
            float f25 = this.f14664A;
            float height2 = this.f14665B + ((float) this.f14690a) + ((float) this.f14712v) + ((float) this.f14689Z.getHeight());
            int i19 = this.f14715y;
            canvas.drawCircle(f25, height2 + ((float) (i19 * 5)), (float) i19, this.f14667D);
            float f26 = this.f14664A;
            float height3 = this.f14665B + ((float) this.f14690a) + ((float) this.f14712v) + ((float) this.f14689Z.getHeight());
            int i20 = this.f14715y;
            canvas.drawCircle(f26, height3 + ((float) (i20 * 8)), (float) i20, this.f14667D);
        } else {
            float f27 = this.f14664A;
            float height4 = ((this.f14665B - ((float) this.f14690a)) - ((float) this.f14712v)) - ((float) this.f14689Z.getHeight());
            int i21 = this.f14715y;
            canvas.drawCircle(f27, height4 - ((float) (i21 * 2)), (float) i21, this.f14667D);
            float f28 = this.f14664A;
            float height5 = ((this.f14665B - ((float) this.f14690a)) - ((float) this.f14712v)) - ((float) this.f14689Z.getHeight());
            int i22 = this.f14715y;
            canvas.drawCircle(f28, height5 - ((float) (i22 * 5)), (float) i22, this.f14667D);
            float f29 = this.f14664A;
            float height6 = ((this.f14665B - ((float) this.f14690a)) - ((float) this.f14712v)) - ((float) this.f14689Z.getHeight());
            int i23 = this.f14715y;
            canvas.drawCircle(f29, height6 - ((float) (i23 * 8)), (float) i23, this.f14667D);
        }
        this.f14694d += UiUtils.dip2px(getContext(), 1.0f);
        if (f3 > (this.f14710t * 2.0f) + 1.0f) {
            this.f14694d = -UiUtils.dip2px(getContext(), 9.0f);
        }
        postInvalidateDelayed((long) this.f14666C);
    }
}
