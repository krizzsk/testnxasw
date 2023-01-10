package com.didi.component.drainage;

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
import com.taxis99.R;
import java.util.List;

public class DrainageGuideView extends RelativeLayout implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: g */
    private static final String f14717g = "show_guide_on_view_";

    /* renamed from: A */
    private int f14718A;

    /* renamed from: B */
    private int f14719B;

    /* renamed from: C */
    private Rect f14720C = new Rect();

    /* renamed from: a */
    boolean f14721a = true;

    /* renamed from: b */
    boolean f14722b = true;

    /* renamed from: c */
    private final String f14723c = getClass().getSimpleName();

    /* renamed from: d */
    private Context f14724d;

    /* renamed from: e */
    private List<View> f14725e;

    /* renamed from: f */
    private boolean f14726f = true;

    /* renamed from: h */
    private int f14727h;

    /* renamed from: i */
    private View f14728i;

    /* renamed from: j */
    private View f14729j;

    /* renamed from: k */
    private Paint f14730k;

    /* renamed from: l */
    private Paint f14731l;

    /* renamed from: m */
    private boolean f14732m;

    /* renamed from: n */
    private int[] f14733n;

    /* renamed from: o */
    private PorterDuffXfermode f14734o;

    /* renamed from: p */
    private Bitmap f14735p;

    /* renamed from: q */
    private int f14736q;

    /* renamed from: r */
    private Canvas f14737r;

    /* renamed from: s */
    private Direction f14738s;

    /* renamed from: t */
    private MyShape f14739t;

    /* renamed from: u */
    private int[] f14740u;

    /* renamed from: v */
    private boolean f14741v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public OnClickCallback f14742w;

    /* renamed from: x */
    private DrainageClickListener f14743x;

    /* renamed from: y */
    private boolean f14744y = false;

    /* renamed from: z */
    private int f14745z;

    public enum Direction {
        CENTER_TIPS_BOTTOM,
        CENTER_TIPS_TOP,
        BOTTOM_ARROW,
        TOP_ARROW,
        ANIMATION_TIPS_BOTTOM,
        ANIMATION_TIPS_TOP
    }

    public interface DrainageClickListener {
        void onClickDrainage(boolean z);
    }

    public enum MyShape {
        RECTANGULAR,
        CIRCLE
    }

    public interface OnClickCallback {
        void onClickedGuideView();
    }

    public void restoreState() {
        SystemUtils.log(2, this.f14723c, "restoreState", (Throwable) null, "com.didi.component.drainage.DrainageGuideView", 100);
        this.f14727h = 0;
        this.f14730k = null;
        this.f14731l = null;
        this.f14732m = false;
        this.f14733n = null;
        this.f14734o = null;
        this.f14735p = null;
        this.f14721a = true;
        this.f14737r = null;
    }

    public int[] getLocation() {
        return this.f14740u;
    }

    public void setLocation(int[] iArr) {
        this.f14740u = iArr;
    }

    public DrainageGuideView(Context context) {
        super(context);
        this.f14724d = context;
        m12159a();
    }

    public void setDirection(Direction direction) {
        this.f14738s = direction;
    }

    public void setShape(MyShape myShape) {
        this.f14739t = myShape;
    }

    public void setCustomGuideView(View view) {
        this.f14729j = view;
        if (!this.f14726f) {
            restoreState();
        }
    }

    public void setBgColor(int i) {
        this.f14736q = i;
    }

    public View getTargetView() {
        return this.f14728i;
    }

    public void setTargetView(View view) {
        this.f14728i = view;
    }

    /* renamed from: a */
    private void m12159a() {
        this.f14745z = UiUtils.dip2px(getContext(), 10.0f);
        this.f14718A = UiUtils.dip2px(getContext(), 16.0f);
        this.f14719B = UiUtils.dip2px(getContext(), 20.0f);
    }

    public int[] getCenter() {
        return this.f14733n;
    }

    public void setCenter(int[] iArr) {
        this.f14733n = iArr;
    }

    public void hide() {
        SystemUtils.log(2, this.f14723c, LoginOmegaUtil.ACTIONID_HIDE, (Throwable) null, "com.didi.component.drainage.DrainageGuideView", 177);
        if (this.f14728i != null) {
            removeAllViews();
            this.f14728i.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ((FrameLayout) ((Activity) this.f14724d).getWindow().getDecorView()).removeView(this);
            restoreState();
            this.f14744y = false;
        }
    }

    public void show() {
        SystemUtils.log(2, this.f14723c, "show", (Throwable) null, "com.didi.component.drainage.DrainageGuideView", 190);
        if (!this.f14744y) {
            View view = this.f14728i;
            if (view != null) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(this);
            }
            View view2 = this.f14728i;
            if (view2 != null && view2.getLocalVisibleRect(new Rect())) {
                setBackgroundResource(R.color.transparent);
                ((FrameLayout) ((Activity) this.f14724d).getWindow().getDecorView()).addView(this);
                this.f14744y = true;
                this.f14726f = false;
            }
        }
    }

    public void setVisiblePaddings(Rect rect) {
        this.f14720C = rect;
    }

    public int getTargetViewpadding() {
        return this.f14718A;
    }

    public void setTargetViewpadding(int i) {
        this.f14718A = i;
    }

    public int getBgmargin() {
        return this.f14745z;
    }

    public void setBgmargin(int i) {
        this.f14745z = i;
    }

    public int getBgradius() {
        return this.f14719B;
    }

    public void setBgradius(int i) {
        this.f14719B = i;
    }

    /* renamed from: b */
    private void m12161b() {
        SystemUtils.log(2, this.f14723c, "createGuideView", (Throwable) null, "com.didi.component.drainage.DrainageGuideView", 265);
        if (this.f14729j != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.f14738s != null) {
                UiUtils.dip2px(getContext(), 7.0f);
                int i = C59532.f14746x1fa8456[this.f14738s.ordinal()];
                if (i == 1 || i == 2) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    ((DrainageGuideBgViewTips) this.f14729j).setVisiblePaddings(this.f14720C);
                    ((DrainageGuideBgViewTips) this.f14729j).setMargin(new Rect(UiUtils.dip2px(getContext(), 6.0f), UiUtils.dip2px(getContext(), 6.0f), UiUtils.dip2px(getContext(), 6.0f), UiUtils.dip2px(getContext(), 6.0f)));
                    ((DrainageGuideBgViewTips) this.f14729j).setHightLightPos(new RectF((float) (this.f14740u[0] + this.f14728i.getPaddingLeft()), (float) (this.f14740u[1] + this.f14728i.getPaddingTop()), (float) ((this.f14740u[0] + this.f14728i.getWidth()) - this.f14728i.getPaddingRight()), (float) ((this.f14740u[1] + this.f14728i.getHeight()) - this.f14728i.getPaddingBottom())));
                }
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (this.f14729j.getParent() != null && (this.f14729j.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f14729j.getParent()).removeView(this.f14729j);
            }
            addView(this.f14729j, layoutParams);
        }
    }

    private int[] getTargetViewSize() {
        int[] iArr = {-1, -1};
        if (this.f14732m) {
            iArr[0] = this.f14728i.getWidth();
            iArr[1] = this.f14728i.getHeight();
        }
        return iArr;
    }

    private int getTargetViewRadius() {
        if (!this.f14732m) {
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
        SystemUtils.log(2, this.f14723c, "onDraw", (Throwable) null, "com.didi.component.drainage.DrainageGuideView", 339);
        if (this.f14732m && this.f14728i != null) {
            m12160a(canvas);
        }
    }

    /* renamed from: a */
    private void m12160a(Canvas canvas) {
        SystemUtils.log(2, this.f14723c, "drawBackground", (Throwable) null, "com.didi.component.drainage.DrainageGuideView", 354);
        this.f14721a = false;
        this.f14735p = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        this.f14737r = new Canvas(this.f14735p);
        Paint paint = new Paint();
        int i = this.f14736q;
        if (i != 0) {
            paint.setColor(i);
        }
        Canvas canvas2 = this.f14737r;
        canvas2.drawRect(0.0f, 0.0f, (float) canvas2.getWidth(), (float) this.f14737r.getHeight(), paint);
        if (this.f14730k == null) {
            this.f14730k = new Paint();
        }
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        this.f14734o = porterDuffXfermode;
        this.f14730k.setXfermode(porterDuffXfermode);
        this.f14730k.setAntiAlias(true);
        if (this.f14739t != null) {
            RectF rectF = new RectF();
            int i2 = C59532.$SwitchMap$com$didi$component$drainage$DrainageGuideView$MyShape[this.f14739t.ordinal()];
            if (i2 == 1) {
                rectF.left = (float) (this.f14740u[0] + this.f14720C.left + this.f14728i.getPaddingLeft());
                rectF.top = (float) (this.f14740u[1] + this.f14728i.getPaddingTop() + this.f14720C.top);
                rectF.right = (float) (((this.f14740u[0] + this.f14728i.getWidth()) - this.f14720C.right) - this.f14728i.getPaddingRight());
                rectF.bottom = (float) (((this.f14740u[1] + this.f14728i.getHeight()) - this.f14728i.getPaddingBottom()) - this.f14720C.bottom);
                this.f14730k.setColor(0);
                Canvas canvas3 = this.f14737r;
                int i3 = this.f14719B;
                canvas3.drawRoundRect(rectF, (float) i3, (float) i3, this.f14730k);
            } else if (i2 == 2) {
                this.f14730k.setColor(0);
                Canvas canvas4 = this.f14737r;
                int[] iArr = this.f14733n;
                canvas4.drawCircle((float) iArr[0], (float) iArr[1], (float) (this.f14728i.getWidth() / 2), this.f14730k);
            }
        } else {
            Canvas canvas5 = this.f14737r;
            int[] iArr2 = this.f14733n;
            canvas5.drawCircle((float) iArr2[0], (float) iArr2[1], (float) (this.f14728i.getWidth() / 2), this.f14730k);
        }
        canvas.drawBitmap(this.f14735p, 0.0f, 0.0f, paint);
        this.f14735p.recycle();
    }

    /* renamed from: com.didi.component.drainage.DrainageGuideView$2 */
    static /* synthetic */ class C59532 {

        /* renamed from: $SwitchMap$com$didi$component$drainage$DrainageGuideView$Direction */
        static final /* synthetic */ int[] f14746x1fa8456;
        static final /* synthetic */ int[] $SwitchMap$com$didi$component$drainage$DrainageGuideView$MyShape;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        static {
            /*
                com.didi.component.drainage.DrainageGuideView$MyShape[] r0 = com.didi.component.drainage.DrainageGuideView.MyShape.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$component$drainage$DrainageGuideView$MyShape = r0
                r1 = 1
                com.didi.component.drainage.DrainageGuideView$MyShape r2 = com.didi.component.drainage.DrainageGuideView.MyShape.RECTANGULAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$didi$component$drainage$DrainageGuideView$MyShape     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.component.drainage.DrainageGuideView$MyShape r3 = com.didi.component.drainage.DrainageGuideView.MyShape.CIRCLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.didi.component.drainage.DrainageGuideView$Direction[] r2 = com.didi.component.drainage.DrainageGuideView.Direction.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f14746x1fa8456 = r2
                com.didi.component.drainage.DrainageGuideView$Direction r3 = com.didi.component.drainage.DrainageGuideView.Direction.ANIMATION_TIPS_BOTTOM     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = f14746x1fa8456     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.didi.component.drainage.DrainageGuideView$Direction r2 = com.didi.component.drainage.DrainageGuideView.Direction.ANIMATION_TIPS_TOP     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.component.drainage.DrainageGuideView.C59532.<clinit>():void");
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f14722b && motionEvent.getAction() == 0) {
            RectF rectF = new RectF();
            rectF.left = (float) (this.f14740u[0] + this.f14720C.left + this.f14728i.getPaddingLeft());
            rectF.top = (float) (this.f14740u[1] + this.f14728i.getPaddingTop() + this.f14720C.top);
            rectF.right = (float) (((this.f14740u[0] + this.f14728i.getWidth()) - this.f14720C.right) - this.f14728i.getPaddingRight());
            rectF.bottom = (float) (((this.f14740u[1] + this.f14728i.getHeight()) - this.f14728i.getPaddingBottom()) - this.f14720C.bottom);
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (x <= rectF.left || x >= rectF.right || y <= rectF.top || y >= rectF.bottom) {
                DrainageClickListener drainageClickListener = this.f14743x;
                if (drainageClickListener != null) {
                    drainageClickListener.onClickDrainage(false);
                }
            } else {
                hide();
                DrainageClickListener drainageClickListener2 = this.f14743x;
                if (drainageClickListener2 != null) {
                    drainageClickListener2.onClickDrainage(true);
                }
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnTouchOutListener(DrainageClickListener drainageClickListener) {
        this.f14743x = drainageClickListener;
    }

    public void setOnClickExit(boolean z) {
        this.f14741v = z;
    }

    public void setOnclickListener(OnClickCallback onClickCallback) {
        this.f14742w = onClickCallback;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m12163c() {
        final boolean z = this.f14741v;
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (DrainageGuideView.this.f14742w != null) {
                    DrainageGuideView.this.f14742w.onClickedGuideView();
                }
                if (z) {
                    DrainageGuideView.this.hide();
                }
            }
        });
    }

    public void onGlobalLayout() {
        if (!this.f14732m) {
            if (this.f14728i.getHeight() > 0 || this.f14728i.getWidth() > 0) {
                this.f14732m = true;
            }
            if (this.f14733n == null) {
                int[] iArr = new int[2];
                this.f14740u = iArr;
                this.f14728i.getLocationInWindow(iArr);
                int[] iArr2 = new int[2];
                this.f14733n = iArr2;
                iArr2[0] = this.f14740u[0] + (this.f14728i.getWidth() / 2);
                this.f14733n[1] = this.f14740u[1] + (this.f14728i.getHeight() / 2);
            }
            if (this.f14727h == 0) {
                this.f14727h = getTargetViewRadius();
            }
            m12161b();
        }
    }

    public static class Builder {
        static DrainageGuideView guiderView;
        static Builder instance = new Builder();
        Context mContext;

        private Builder() {
        }

        public Builder(Context context) {
            this.mContext = context;
        }

        public static Builder newInstance(Context context) {
            guiderView = new DrainageGuideView(context);
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

        public DrainageGuideView build() {
            guiderView.m12163c();
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
