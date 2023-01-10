package com.didiglobal.p205sa.biz.component.guide.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.guide.view.GuideBgViewTips */
public class GuideBgViewTips extends RelativeLayout implements IGuideInterface {

    /* renamed from: a */
    private int f53469a;

    /* renamed from: b */
    private RectF f53470b = new RectF();

    /* renamed from: c */
    private Paint f53471c;

    /* renamed from: d */
    private Paint f53472d;

    /* renamed from: e */
    private Bitmap f53473e;

    /* renamed from: f */
    private Canvas f53474f;

    /* renamed from: g */
    private int f53475g;

    /* renamed from: h */
    private int[] f53476h;

    /* renamed from: i */
    private Rect f53477i;

    /* renamed from: j */
    private int f53478j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View.OnClickListener f53479k;

    /* renamed from: l */
    private TextView f53480l;

    /* renamed from: m */
    private Button f53481m;

    /* renamed from: n */
    private float f53482n;

    /* renamed from: o */
    private float f53483o;

    /* renamed from: p */
    private Rect f53484p = new Rect();

    /* renamed from: q */
    private View f53485q;

    /* renamed from: com.didiglobal.sa.biz.component.guide.view.GuideBgViewTips$TipType */
    public @interface TipType {
        public static final int Tip_bottom = 1;
        public static final int Tip_top = 0;
    }

    public void setVisiblePaddings(Rect rect) {
        this.f53484p = rect;
    }

    public GuideBgViewTips(Context context, int i) {
        super(context);
        this.f53469a = i;
        m39936a();
    }

    /* renamed from: a */
    private void m39936a() {
        setBackgroundResource(R.color.transparent);
        this.f53475g = (int) getContext().getResources().getDimension(R.dimen.view_radius);
        int dimension = (int) getContext().getResources().getDimension(R.dimen.view_bg_radius);
        this.f53478j = dimension;
        int i = dimension * 2;
        this.f53476h = new int[]{i, i, i, i};
        getContext().getResources().getDimension(R.dimen.view_bg_content);
        this.f53485q = LayoutInflater.from(getContext()).inflate(R.layout.sa_guide_text, (ViewGroup) null);
        addView(this.f53485q, new RelativeLayout.LayoutParams(-1, -2));
        Button button = (Button) findViewById(R.id.guide_get);
        this.f53481m = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (GuideBgViewTips.this.f53479k != null) {
                    GuideBgViewTips.this.f53479k.onClick(view);
                }
            }
        });
        this.f53480l = (TextView) findViewById(R.id.guide_tip);
    }

    public void setOnGetClickListener(View.OnClickListener onClickListener) {
        this.f53479k = onClickListener;
    }

    public void setmAllBgDiameter(int[] iArr) {
        this.f53476h = iArr;
    }

    public int getmTipType() {
        return this.f53469a;
    }

    public void setGuideTips(String str) {
        TextView textView = this.f53480l;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setBtnText(String str) {
        Button button = this.f53481m;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setHightLightPos(RectF rectF) {
        this.f53470b = rectF;
        this.f53482n = rectF.bottom - rectF.top;
        this.f53483o = rectF.right - rectF.left;
        View view = this.f53485q;
        if (view != null && view.getLayoutParams() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f53485q.getLayoutParams();
            int i = this.f53469a;
            if (i == 1) {
                layoutParams.setMargins(0, ((((int) this.f53482n) - this.f53484p.top) - this.f53484p.bottom) + this.f53477i.top, 0, 0);
            } else if (i == 0) {
                layoutParams.addRule(10);
            }
        }
    }

    public void setMargin(Rect rect) {
        this.f53477i = rect;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m39937a(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) ((((this.f53482n + ((float) this.f53477i.bottom)) + ((float) this.f53485q.getMeasuredHeight())) - ((float) this.f53484p.top)) - ((float) this.f53484p.bottom)));
    }

    /* renamed from: a */
    private void m39937a(Canvas canvas) {
        if (this.f53471c == null) {
            this.f53471c = new Paint();
            this.f53471c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
            this.f53471c.setAntiAlias(true);
        }
        if (canvas.getWidth() > 0 && canvas.getHeight() > 0) {
            if (this.f53473e == null) {
                this.f53473e = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
                this.f53474f = new Canvas(this.f53473e);
            }
            if (this.f53472d == null) {
                Paint paint = new Paint();
                this.f53472d = paint;
                paint.setShader(new LinearGradient(0.0f, 0.0f, (float) canvas.getWidth(), 0.0f, Color.parseColor("#FF8F40"), Color.parseColor("#FF7040"), Shader.TileMode.CLAMP));
                this.f53472d.setStyle(Paint.Style.FILL_AND_STROKE);
                this.f53472d.setStrokeWidth(1.0f);
            }
            m39938b();
            int i = this.f53469a;
            if (i == 1) {
                this.f53470b.left = (float) this.f53477i.left;
                RectF rectF = this.f53470b;
                rectF.right = ((rectF.left + this.f53483o) - ((float) this.f53484p.left)) - ((float) this.f53484p.right);
                this.f53470b.top = (float) this.f53477i.top;
                this.f53470b.bottom = ((this.f53482n + ((float) this.f53477i.top)) - ((float) this.f53484p.top)) - ((float) this.f53484p.bottom);
            } else if (i == 0) {
                this.f53470b.left = (float) this.f53477i.left;
                RectF rectF2 = this.f53470b;
                rectF2.right = ((rectF2.left + this.f53483o) - ((float) this.f53484p.left)) - ((float) this.f53484p.right);
                this.f53470b.top = (((float) (getHeight() - this.f53477i.bottom)) - this.f53482n) + ((float) this.f53484p.top) + ((float) this.f53484p.bottom);
                this.f53470b.bottom = (float) (getHeight() - this.f53477i.bottom);
            }
            Canvas canvas2 = this.f53474f;
            RectF rectF3 = this.f53470b;
            int i2 = this.f53475g;
            canvas2.drawRoundRect(rectF3, (float) i2, (float) i2, this.f53471c);
            canvas.drawBitmap(this.f53473e, 0.0f, 0.0f, this.f53472d);
        }
    }

    /* renamed from: b */
    private void m39938b() {
        int[] iArr = this.f53476h;
        if (iArr != null && iArr.length >= 4) {
            Path path = new Path();
            path.moveTo((float) this.f53476h[0], 0.0f);
            path.lineTo((float) (this.f53474f.getWidth() - this.f53476h[1]), 0.0f);
            path.arcTo(new RectF((float) (this.f53474f.getWidth() - this.f53476h[1]), 0.0f, (float) this.f53474f.getWidth(), (float) this.f53476h[1]), -90.0f, 90.0f);
            path.lineTo((float) this.f53474f.getWidth(), (float) (getHeight() - this.f53476h[2]));
            path.arcTo(new RectF((float) (this.f53474f.getWidth() - this.f53476h[2]), (float) (getHeight() - this.f53476h[2]), (float) this.f53474f.getWidth(), (float) getHeight()), 0.0f, 90.0f);
            path.lineTo((float) this.f53476h[3], (float) getHeight());
            int height = getHeight();
            int[] iArr2 = this.f53476h;
            path.arcTo(new RectF(0.0f, (float) (height - iArr2[3]), (float) iArr2[3], (float) getHeight()), 90.0f, 90.0f);
            path.lineTo(0.0f, (float) this.f53476h[0]);
            int[] iArr3 = this.f53476h;
            path.arcTo(new RectF(0.0f, 0.0f, (float) iArr3[0], (float) iArr3[0]), 180.0f, 90.0f);
            path.close();
            this.f53474f.drawPath(path, this.f53472d);
        }
    }
}
