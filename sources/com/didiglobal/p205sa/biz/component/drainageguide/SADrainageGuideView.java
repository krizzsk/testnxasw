package com.didiglobal.p205sa.biz.component.drainageguide;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didiglobal.p205sa.biz.component.guide.view.GuideBgArrow;
import com.didiglobal.p205sa.biz.component.guide.view.GuideBgViewTips;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView */
public class SADrainageGuideView extends RelativeLayout implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: g */
    private static final String f53417g = "show_guide_on_view_";

    /* renamed from: A */
    private int f53418A;

    /* renamed from: B */
    private int f53419B;

    /* renamed from: C */
    private Rect f53420C = new Rect();

    /* renamed from: a */
    boolean f53421a = true;

    /* renamed from: b */
    boolean f53422b = true;

    /* renamed from: c */
    private final String f53423c = getClass().getSimpleName();

    /* renamed from: d */
    private Context f53424d;

    /* renamed from: e */
    private List<View> f53425e;

    /* renamed from: f */
    private boolean f53426f = true;

    /* renamed from: h */
    private int f53427h;

    /* renamed from: i */
    private View f53428i;

    /* renamed from: j */
    private View f53429j;

    /* renamed from: k */
    private Paint f53430k;

    /* renamed from: l */
    private Paint f53431l;

    /* renamed from: m */
    private boolean f53432m;

    /* renamed from: n */
    private int[] f53433n;

    /* renamed from: o */
    private PorterDuffXfermode f53434o;

    /* renamed from: p */
    private Bitmap f53435p;

    /* renamed from: q */
    private int f53436q;

    /* renamed from: r */
    private Canvas f53437r;

    /* renamed from: s */
    private Direction f53438s;

    /* renamed from: t */
    private MyShape f53439t;

    /* renamed from: u */
    private int[] f53440u;

    /* renamed from: v */
    private boolean f53441v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public OnClickCallback f53442w;

    /* renamed from: x */
    private DrainageClickListener f53443x;

    /* renamed from: y */
    private boolean f53444y = false;

    /* renamed from: z */
    private int f53445z;

    /* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$Direction */
    public enum Direction {
        CENTER_TIPS_BOTTOM,
        CENTER_TIPS_TOP,
        BOTTOM_ARROW,
        TOP_ARROW,
        ANIMATION_TIPS_BOTTOM,
        ANIMATION_TIPS_TOP
    }

    /* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$DrainageClickListener */
    public interface DrainageClickListener {
        void onClickDrainage(boolean z);
    }

    /* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$MyShape */
    public enum MyShape {
        RECTANGULAR
    }

    /* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$OnClickCallback */
    public interface OnClickCallback {
        void onClickedGuideView();
    }

    public void restoreState() {
        SystemUtils.log(2, this.f53423c, "restoreState", (Throwable) null, "com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView", 102);
        this.f53427h = 0;
        this.f53430k = null;
        this.f53431l = null;
        this.f53432m = false;
        this.f53433n = null;
        this.f53434o = null;
        this.f53435p = null;
        this.f53421a = true;
        this.f53437r = null;
    }

    public int[] getLocation() {
        return this.f53440u;
    }

    public void setLocation(int[] iArr) {
        this.f53440u = iArr;
    }

    public SADrainageGuideView(Context context) {
        super(context);
        this.f53424d = context;
        m39917a();
    }

    public void setDirection(Direction direction) {
        this.f53438s = direction;
    }

    public void setShape(MyShape myShape) {
        this.f53439t = myShape;
    }

    public void setCustomGuideView(View view) {
        this.f53429j = view;
        if (!this.f53426f) {
            restoreState();
        }
    }

    public void setBgColor(int i) {
        this.f53436q = i;
    }

    public View getTargetView() {
        return this.f53428i;
    }

    public void setTargetView(View view) {
        this.f53428i = view;
    }

    /* renamed from: a */
    private void m39917a() {
        this.f53445z = (int) getContext().getResources().getDimension(R.dimen.view_padding_by_bg);
        this.f53418A = (int) getContext().getResources().getDimension(R.dimen.view_padding);
        this.f53419B = (int) getContext().getResources().getDimension(R.dimen.view_radius);
    }

    public int[] getCenter() {
        return this.f53433n;
    }

    public void setCenter(int[] iArr) {
        this.f53433n = iArr;
    }

    public void hide() {
        SystemUtils.log(2, this.f53423c, LoginOmegaUtil.ACTIONID_HIDE, (Throwable) null, "com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView", 179);
        if (this.f53428i != null) {
            removeAllViews();
            this.f53428i.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ((FrameLayout) ((Activity) this.f53424d).getWindow().getDecorView()).removeView(this);
            restoreState();
            this.f53444y = false;
        }
    }

    public void show() {
        SystemUtils.log(2, this.f53423c, "show", (Throwable) null, "com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView", 192);
        if (!this.f53444y) {
            View view = this.f53428i;
            if (view != null) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(this);
            }
            View view2 = this.f53428i;
            if (view2 != null && view2.getLocalVisibleRect(new Rect())) {
                setBackgroundResource(R.color.transparent);
                ((FrameLayout) ((Activity) this.f53424d).getWindow().getDecorView()).addView(this);
                this.f53444y = true;
                this.f53426f = false;
            }
        }
    }

    public void setVisiblePaddings(Rect rect) {
        this.f53420C = rect;
    }

    public int getTargetViewpadding() {
        return this.f53418A;
    }

    public void setTargetViewpadding(int i) {
        this.f53418A = i;
    }

    public int getBgmargin() {
        return this.f53445z;
    }

    public void setBgmargin(int i) {
        this.f53445z = i;
    }

    public int getBgradius() {
        return this.f53419B;
    }

    public void setBgradius(int i) {
        this.f53419B = i;
    }

    /* renamed from: b */
    private void m39919b() {
        SystemUtils.log(2, this.f53423c, "createGuideView", (Throwable) null, "com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView", 267);
        if (this.f53429j != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.f53438s != null) {
                int dip2px = UiUtils.dip2px(getContext(), 7.0f);
                switch (C178892.f53446x5cdeb3fe[this.f53438s.ordinal()]) {
                    case 1:
                        layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                        layoutParams.setMargins(this.f53418A, ((this.f53440u[1] + this.f53428i.getHeight()) + dip2px) - this.f53428i.getPaddingBottom(), this.f53418A, 0);
                        View view = this.f53429j;
                        if (view instanceof GuideBgArrow) {
                            ((GuideBgArrow) view).setArrowPos(((this.f53440u[0] + this.f53428i.getPaddingLeft()) + (((this.f53428i.getWidth() - this.f53428i.getPaddingLeft()) - this.f53428i.getPaddingRight()) / 2)) - this.f53418A);
                            break;
                        }
                        break;
                    case 2:
                        layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                        layoutParams.addRule(12);
                        int i = this.f53418A;
                        layoutParams.setMargins(i, 0, i, ((getHeight() - this.f53440u[1]) - this.f53428i.getPaddingTop()) + dip2px);
                        View view2 = this.f53429j;
                        if (view2 instanceof GuideBgArrow) {
                            ((GuideBgArrow) view2).setArrowPos(((this.f53440u[0] + this.f53428i.getPaddingLeft()) + (((this.f53428i.getWidth() - this.f53428i.getPaddingLeft()) - this.f53428i.getPaddingRight()) / 2)) - this.f53418A);
                            break;
                        }
                        break;
                    case 3:
                        layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                        ((GuideBgViewTips) this.f53429j).setVisiblePaddings(this.f53420C);
                        int i2 = this.f53445z;
                        ((GuideBgViewTips) this.f53429j).setMargin(new Rect(i2, i2, i2, i2));
                        int[] iArr = this.f53440u;
                        ((GuideBgViewTips) this.f53429j).setHightLightPos(new RectF((float) iArr[0], (float) iArr[1], (float) (iArr[0] + this.f53428i.getWidth()), (float) (this.f53440u[1] + this.f53428i.getHeight())));
                        int i3 = this.f53418A;
                        int i4 = this.f53445z;
                        layoutParams.setMargins(i3 - i4, (this.f53440u[1] - i4) + this.f53420C.top, this.f53418A - this.f53445z, 0);
                        break;
                    case 4:
                        layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                        layoutParams.addRule(12);
                        ((GuideBgViewTips) this.f53429j).setVisiblePaddings(this.f53420C);
                        int i5 = this.f53445z;
                        ((GuideBgViewTips) this.f53429j).setMargin(new Rect(i5, i5, i5, i5));
                        int[] iArr2 = this.f53440u;
                        ((GuideBgViewTips) this.f53429j).setHightLightPos(new RectF((float) iArr2[0], (float) iArr2[1], (float) (iArr2[0] + this.f53428i.getWidth()), (float) (this.f53440u[1] + this.f53428i.getHeight())));
                        int i6 = this.f53418A;
                        int i7 = this.f53445z;
                        layoutParams.setMargins(i6 - i7, 0, i6 - i7, (((getHeight() - this.f53440u[1]) - this.f53428i.getHeight()) + this.f53420C.bottom) - this.f53445z);
                        break;
                    case 5:
                    case 6:
                        layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        ((SADrainageGuideBgViewTips) this.f53429j).setVisiblePaddings(this.f53420C);
                        ((SADrainageGuideBgViewTips) this.f53429j).setMargin(new Rect(UiUtils.dip2px(getContext(), 6.0f), UiUtils.dip2px(getContext(), 6.0f), UiUtils.dip2px(getContext(), 6.0f), UiUtils.dip2px(getContext(), 6.0f)));
                        ((SADrainageGuideBgViewTips) this.f53429j).setHightLightPos(new RectF((float) (this.f53440u[0] + this.f53428i.getPaddingLeft()), (float) (this.f53440u[1] + this.f53428i.getPaddingTop()), (float) ((this.f53440u[0] + this.f53428i.getWidth()) - this.f53428i.getPaddingRight()), (float) ((this.f53440u[1] + this.f53428i.getHeight()) - this.f53428i.getPaddingBottom())));
                        break;
                }
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (this.f53429j.getParent() != null && (this.f53429j.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f53429j.getParent()).removeView(this.f53429j);
            }
            addView(this.f53429j, layoutParams);
        }
    }

    private int[] getTargetViewSize() {
        int[] iArr = {-1, -1};
        if (this.f53432m) {
            iArr[0] = this.f53428i.getWidth();
            iArr[1] = this.f53428i.getHeight();
        }
        return iArr;
    }

    private int getTargetViewRadius() {
        if (!this.f53432m) {
            return -1;
        }
        int[] targetViewSize = getTargetViewSize();
        int i = targetViewSize[0];
        int i2 = targetViewSize[1];
        return (int) (Math.sqrt((double) ((i * i) + (i2 * i2))) / 2.0d);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        SystemUtils.log(2, this.f53423c, "onDraw", (Throwable) null, "com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView", 398);
        if (this.f53432m && this.f53428i != null) {
            m39918a(canvas);
        }
    }

    /* renamed from: a */
    private void m39918a(Canvas canvas) {
        SystemUtils.log(2, this.f53423c, "drawBackground", (Throwable) null, "com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView", 413);
        this.f53421a = false;
        this.f53435p = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        this.f53437r = new Canvas(this.f53435p);
        Paint paint = new Paint();
        int i = this.f53436q;
        if (i != 0) {
            paint.setColor(i);
        }
        Canvas canvas2 = this.f53437r;
        canvas2.drawRect(0.0f, 0.0f, (float) canvas2.getWidth(), (float) this.f53437r.getHeight(), paint);
        if (this.f53430k == null) {
            this.f53430k = new Paint();
        }
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        this.f53434o = porterDuffXfermode;
        this.f53430k.setXfermode(porterDuffXfermode);
        this.f53430k.setAntiAlias(true);
        if (this.f53439t != null) {
            RectF rectF = new RectF();
            if (C178892.f53447xe3f1bd94[this.f53439t.ordinal()] == 1) {
                rectF.left = (float) (this.f53440u[0] + this.f53420C.left + this.f53428i.getPaddingLeft());
                rectF.top = (float) (this.f53440u[1] + this.f53428i.getPaddingTop() + this.f53420C.top);
                rectF.right = (float) (((this.f53440u[0] + this.f53428i.getWidth()) - this.f53420C.right) - this.f53428i.getPaddingRight());
                rectF.bottom = (float) (((this.f53440u[1] + this.f53428i.getHeight()) - this.f53428i.getPaddingBottom()) - this.f53420C.bottom);
                this.f53430k.setColor(0);
                Canvas canvas3 = this.f53437r;
                int i2 = this.f53419B;
                canvas3.drawRoundRect(rectF, (float) i2, (float) i2, this.f53430k);
            }
        } else {
            Canvas canvas4 = this.f53437r;
            int[] iArr = this.f53433n;
            canvas4.drawCircle((float) iArr[0], (float) iArr[1], (float) this.f53427h, this.f53430k);
        }
        canvas.drawBitmap(this.f53435p, 0.0f, 0.0f, paint);
        this.f53435p.recycle();
    }

    /* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$2 */
    static /* synthetic */ class C178892 {

        /* renamed from: $SwitchMap$com$didiglobal$sa$biz$component$drainageguide$SADrainageGuideView$Direction */
        static final /* synthetic */ int[] f53446x5cdeb3fe;

        /* renamed from: $SwitchMap$com$didiglobal$sa$biz$component$drainageguide$SADrainageGuideView$MyShape */
        static final /* synthetic */ int[] f53447xe3f1bd94;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0023 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002e */
        static {
            /*
                com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$MyShape[] r0 = com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideView.MyShape.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f53447xe3f1bd94 = r0
                r1 = 1
                com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$MyShape r2 = com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideView.MyShape.RECTANGULAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$Direction[] r0 = com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideView.Direction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f53446x5cdeb3fe = r0
                com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$Direction r2 = com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideView.Direction.BOTTOM_ARROW     // Catch:{ NoSuchFieldError -> 0x0023 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0023 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                int[] r0 = f53446x5cdeb3fe     // Catch:{ NoSuchFieldError -> 0x002e }
                com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$Direction r1 = com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideView.Direction.TOP_ARROW     // Catch:{ NoSuchFieldError -> 0x002e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r0 = f53446x5cdeb3fe     // Catch:{ NoSuchFieldError -> 0x0039 }
                com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$Direction r1 = com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideView.Direction.CENTER_TIPS_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r0 = f53446x5cdeb3fe     // Catch:{ NoSuchFieldError -> 0x0044 }
                com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$Direction r1 = com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideView.Direction.CENTER_TIPS_TOP     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r0 = f53446x5cdeb3fe     // Catch:{ NoSuchFieldError -> 0x004f }
                com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$Direction r1 = com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideView.Direction.ANIMATION_TIPS_BOTTOM     // Catch:{ NoSuchFieldError -> 0x004f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r0 = f53446x5cdeb3fe     // Catch:{ NoSuchFieldError -> 0x005a }
                com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$Direction r1 = com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideView.Direction.ANIMATION_TIPS_TOP     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideView.C178892.<clinit>():void");
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f53422b && motionEvent.getAction() == 0) {
            RectF rectF = new RectF();
            rectF.left = (float) (this.f53440u[0] + this.f53420C.left + this.f53428i.getPaddingLeft());
            rectF.top = (float) (this.f53440u[1] + this.f53428i.getPaddingTop() + this.f53420C.top);
            rectF.right = (float) (((this.f53440u[0] + this.f53428i.getWidth()) - this.f53420C.right) - this.f53428i.getPaddingRight());
            rectF.bottom = (float) (((this.f53440u[1] + this.f53428i.getHeight()) - this.f53428i.getPaddingBottom()) - this.f53420C.bottom);
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (x <= rectF.left || x >= rectF.right || y <= rectF.top || y >= rectF.bottom) {
                DrainageClickListener drainageClickListener = this.f53443x;
                if (drainageClickListener != null) {
                    drainageClickListener.onClickDrainage(false);
                }
            } else {
                hide();
                DrainageClickListener drainageClickListener2 = this.f53443x;
                if (drainageClickListener2 != null) {
                    drainageClickListener2.onClickDrainage(true);
                }
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnTouchOutListener(DrainageClickListener drainageClickListener) {
        this.f53443x = drainageClickListener;
    }

    public void setOnClickExit(boolean z) {
        this.f53441v = z;
    }

    public void setOnclickListener(OnClickCallback onClickCallback) {
        this.f53442w = onClickCallback;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m39921c() {
        final boolean z = this.f53441v;
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SADrainageGuideView.this.f53442w != null) {
                    SADrainageGuideView.this.f53442w.onClickedGuideView();
                }
                if (z) {
                    SADrainageGuideView.this.hide();
                }
            }
        });
    }

    public void onGlobalLayout() {
        if (!this.f53432m) {
            if (this.f53428i.getHeight() > 0 || this.f53428i.getWidth() > 0) {
                this.f53432m = true;
            }
            if (this.f53433n == null) {
                int[] iArr = new int[2];
                this.f53440u = iArr;
                this.f53428i.getLocationInWindow(iArr);
                int[] iArr2 = new int[2];
                this.f53433n = iArr2;
                iArr2[0] = this.f53440u[0] + (this.f53428i.getWidth() / 2);
                this.f53433n[1] = this.f53440u[1] + (this.f53428i.getHeight() / 2);
            }
            if (this.f53427h == 0) {
                this.f53427h = getTargetViewRadius();
            }
            m39919b();
        }
    }

    /* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuideView$Builder */
    public static class Builder {
        static SADrainageGuideView guiderView;
        static Builder instance = new Builder();
        Context mContext;

        private Builder() {
        }

        public Builder(Context context) {
            this.mContext = context;
        }

        public static Builder newInstance(Context context) {
            guiderView = new SADrainageGuideView(context);
            return instance;
        }

        public Builder setTargetView(View view) {
            guiderView.setTargetView(view);
            return instance;
        }

        public Builder setBgColor(int i) {
            guiderView.setBgColor(i);
            return instance;
        }

        public Builder setBgRadius(int i) {
            guiderView.setBgradius(i);
            return instance;
        }

        public Builder setBgMargin(int i) {
            guiderView.setBgmargin(i);
            return instance;
        }

        public Builder setTargetViewpadding(int i) {
            guiderView.setTargetViewpadding(i);
            return instance;
        }

        public Builder setDirction(Direction direction) {
            guiderView.setDirection(direction);
            return instance;
        }

        public Builder setShape(MyShape myShape) {
            guiderView.setShape(myShape);
            return instance;
        }

        public Builder setCustomGuideView(View view) {
            guiderView.setCustomGuideView(view);
            return instance;
        }

        public SADrainageGuideView build() {
            guiderView.m39921c();
            return guiderView;
        }

        public Builder setOnclickExit(boolean z) {
            guiderView.setOnClickExit(z);
            return instance;
        }

        public Builder setOnclickListener(OnClickCallback onClickCallback) {
            guiderView.setOnclickListener(onClickCallback);
            return instance;
        }
    }
}
