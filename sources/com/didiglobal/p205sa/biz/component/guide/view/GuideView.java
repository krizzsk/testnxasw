package com.didiglobal.p205sa.biz.component.guide.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.sdk.alphaface.utils.UIHandler;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.guide.view.GuideView */
public class GuideView extends RelativeLayout implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: f */
    private static final String f53486f = "show_guide_on_view_";

    /* renamed from: A */
    private Rect f53487A = new Rect();

    /* renamed from: a */
    boolean f53488a = true;

    /* renamed from: b */
    private final String f53489b = getClass().getSimpleName();

    /* renamed from: c */
    private Context f53490c;

    /* renamed from: d */
    private List<View> f53491d;

    /* renamed from: e */
    private boolean f53492e = true;

    /* renamed from: g */
    private int f53493g;

    /* renamed from: h */
    private View f53494h;

    /* renamed from: i */
    private View f53495i;

    /* renamed from: j */
    private Paint f53496j;

    /* renamed from: k */
    private Paint f53497k;

    /* renamed from: l */
    private boolean f53498l;

    /* renamed from: m */
    private int[] f53499m;

    /* renamed from: n */
    private PorterDuffXfermode f53500n;

    /* renamed from: o */
    private Bitmap f53501o;

    /* renamed from: p */
    private int f53502p;

    /* renamed from: q */
    private Canvas f53503q;

    /* renamed from: r */
    private Direction f53504r;

    /* renamed from: s */
    private MyShape f53505s;

    /* renamed from: t */
    private int[] f53506t;

    /* renamed from: u */
    private boolean f53507u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public OnClickCallback f53508v;

    /* renamed from: w */
    private boolean f53509w = false;

    /* renamed from: x */
    private int f53510x;

    /* renamed from: y */
    private int f53511y;

    /* renamed from: z */
    private int f53512z;

    /* renamed from: com.didiglobal.sa.biz.component.guide.view.GuideView$Direction */
    public enum Direction {
        CENTER_TIPS_BOTTOM,
        CENTER_TIPS_TOP,
        BOTTOM_ARROW,
        TOP_ARROW
    }

    /* renamed from: com.didiglobal.sa.biz.component.guide.view.GuideView$MyShape */
    public enum MyShape {
        RECTANGULAR
    }

    /* renamed from: com.didiglobal.sa.biz.component.guide.view.GuideView$OnClickCallback */
    public interface OnClickCallback {
        void onClickedGuideView();
    }

    public void restoreState() {
        SystemUtils.log(2, this.f53489b, "restoreState", (Throwable) null, "com.didiglobal.sa.biz.component.guide.view.GuideView", 103);
        this.f53493g = 0;
        this.f53496j = null;
        this.f53497k = null;
        this.f53498l = false;
        this.f53499m = null;
        this.f53500n = null;
        this.f53501o = null;
        this.f53488a = true;
        this.f53503q = null;
    }

    public int[] getLocation() {
        return this.f53506t;
    }

    public void setLocation(int[] iArr) {
        this.f53506t = iArr;
    }

    public GuideView(Context context) {
        super(context);
        this.f53490c = context;
        m39940a();
    }

    public void setDirection(Direction direction) {
        this.f53504r = direction;
    }

    public void setShape(MyShape myShape) {
        this.f53505s = myShape;
    }

    public void setCustomGuideView(View view) {
        this.f53495i = view;
        if (!this.f53492e) {
            restoreState();
        }
    }

    public void setBgColor(int i) {
        this.f53502p = i;
    }

    public View getTargetView() {
        return this.f53494h;
    }

    public void setTargetView(View view) {
        this.f53494h = view;
    }

    /* renamed from: a */
    private void m39940a() {
        this.f53510x = (int) getContext().getResources().getDimension(R.dimen.view_padding_by_bg);
        this.f53511y = (int) getContext().getResources().getDimension(R.dimen.view_padding);
        this.f53512z = (int) getContext().getResources().getDimension(R.dimen.view_radius);
    }

    public int[] getCenter() {
        return this.f53499m;
    }

    public void setCenter(int[] iArr) {
        this.f53499m = iArr;
    }

    public void hide() {
        SystemUtils.log(2, this.f53489b, LoginOmegaUtil.ACTIONID_HIDE, (Throwable) null, "com.didiglobal.sa.biz.component.guide.view.GuideView", 180);
        if (this.f53494h != null) {
            removeAllViews();
            this.f53494h.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ((FrameLayout) ((Activity) this.f53490c).getWindow().getDecorView()).removeView(this);
            restoreState();
            this.f53509w = false;
        }
    }

    public void show() {
        SystemUtils.log(2, this.f53489b, "show", (Throwable) null, "com.didiglobal.sa.biz.component.guide.view.GuideView", 193);
        if (!this.f53509w) {
            View view = this.f53494h;
            if (view != null) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(this);
            }
            setBackgroundResource(R.color.transparent);
            ((FrameLayout) ((Activity) this.f53490c).getWindow().getDecorView()).addView(this);
            this.f53509w = true;
            this.f53492e = false;
        }
    }

    public void setVisiblePaddings(Rect rect) {
        this.f53487A = rect;
    }

    public int getTargetViewpadding() {
        return this.f53511y;
    }

    public void setTargetViewpadding(int i) {
        this.f53511y = i;
    }

    public int getBgmargin() {
        return this.f53510x;
    }

    public void setBgmargin(int i) {
        this.f53510x = i;
    }

    public int getBgradius() {
        return this.f53512z;
    }

    public void setBgradius(int i) {
        this.f53512z = i;
    }

    /* renamed from: b */
    private void m39942b() {
        SystemUtils.log(2, this.f53489b, "createGuideView", (Throwable) null, "com.didiglobal.sa.biz.component.guide.view.GuideView", 265);
        if (this.f53495i != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.f53504r != null) {
                int dip2px = UiUtils.dip2px(getContext(), 7.0f);
                int i = C178993.f53513x5ebae6ff[this.f53504r.ordinal()];
                if (i == 1) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.setMargins(this.f53511y, ((this.f53506t[1] + this.f53494h.getHeight()) + dip2px) - this.f53494h.getPaddingBottom(), this.f53511y, 0);
                    View view = this.f53495i;
                    if (view instanceof GuideBgArrow) {
                        ((GuideBgArrow) view).setArrowPos(((this.f53506t[0] + this.f53494h.getPaddingLeft()) + (((this.f53494h.getWidth() - this.f53494h.getPaddingLeft()) - this.f53494h.getPaddingRight()) / 2)) - this.f53511y);
                    }
                } else if (i == 2) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(12);
                    int i2 = this.f53511y;
                    layoutParams.setMargins(i2, 0, i2, ((getHeight() - this.f53506t[1]) - this.f53494h.getPaddingTop()) + dip2px);
                    View view2 = this.f53495i;
                    if (view2 instanceof GuideBgArrow) {
                        ((GuideBgArrow) view2).setArrowPos(((this.f53506t[0] + this.f53494h.getPaddingLeft()) + (((this.f53494h.getWidth() - this.f53494h.getPaddingLeft()) - this.f53494h.getPaddingRight()) / 2)) - this.f53511y);
                    }
                } else if (i == 3) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    ((GuideBgViewTips) this.f53495i).setVisiblePaddings(this.f53487A);
                    int i3 = this.f53510x;
                    ((GuideBgViewTips) this.f53495i).setMargin(new Rect(i3, i3, i3, i3));
                    int[] iArr = this.f53506t;
                    ((GuideBgViewTips) this.f53495i).setHightLightPos(new RectF((float) iArr[0], (float) iArr[1], (float) (iArr[0] + this.f53494h.getWidth()), (float) (this.f53506t[1] + this.f53494h.getHeight())));
                    int i4 = this.f53511y;
                    int i5 = this.f53510x;
                    layoutParams.setMargins(i4 - i5, (this.f53506t[1] - i5) + this.f53487A.top, this.f53511y - this.f53510x, 0);
                } else if (i == 4) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(12);
                    ((GuideBgViewTips) this.f53495i).setVisiblePaddings(this.f53487A);
                    int i6 = this.f53510x;
                    ((GuideBgViewTips) this.f53495i).setMargin(new Rect(i6, i6, i6, i6));
                    int[] iArr2 = this.f53506t;
                    ((GuideBgViewTips) this.f53495i).setHightLightPos(new RectF((float) iArr2[0], (float) iArr2[1], (float) (iArr2[0] + this.f53494h.getWidth()), (float) (this.f53506t[1] + this.f53494h.getHeight())));
                    int i7 = this.f53511y;
                    int i8 = this.f53510x;
                    layoutParams.setMargins(i7 - i8, 0, i7 - i8, (((getHeight() - this.f53506t[1]) - this.f53494h.getHeight()) + this.f53487A.bottom) - this.f53510x);
                }
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            if (this.f53495i.getParent() != null && (this.f53495i.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f53495i.getParent()).removeView(this.f53495i);
            }
            addView(this.f53495i, layoutParams);
        }
    }

    private int[] getTargetViewSize() {
        int[] iArr = {-1, -1};
        if (this.f53498l) {
            iArr[0] = this.f53494h.getWidth();
            iArr[1] = this.f53494h.getHeight();
        }
        return iArr;
    }

    private int getTargetViewRadius() {
        if (!this.f53498l) {
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
        SystemUtils.log(2, this.f53489b, "onDraw", (Throwable) null, "com.didiglobal.sa.biz.component.guide.view.GuideView", 380);
        if (this.f53498l && this.f53494h != null) {
            m39941a(canvas);
        }
    }

    /* renamed from: a */
    private void m39941a(Canvas canvas) {
        SystemUtils.log(2, this.f53489b, "drawBackground", (Throwable) null, "com.didiglobal.sa.biz.component.guide.view.GuideView", 395);
        this.f53488a = false;
        this.f53501o = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        this.f53503q = new Canvas(this.f53501o);
        Paint paint = new Paint();
        int i = this.f53502p;
        if (i != 0) {
            paint.setColor(i);
        }
        Canvas canvas2 = this.f53503q;
        canvas2.drawRect(0.0f, 0.0f, (float) canvas2.getWidth(), (float) this.f53503q.getHeight(), paint);
        if (this.f53496j == null) {
            this.f53496j = new Paint();
        }
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        this.f53500n = porterDuffXfermode;
        this.f53496j.setXfermode(porterDuffXfermode);
        this.f53496j.setAntiAlias(true);
        if (this.f53505s != null) {
            RectF rectF = new RectF();
            if (C178993.f53514xd190bcd5[this.f53505s.ordinal()] == 1) {
                rectF.left = (float) (this.f53506t[0] + this.f53487A.left + this.f53494h.getPaddingLeft());
                rectF.top = (float) (this.f53506t[1] + this.f53494h.getPaddingTop() + this.f53487A.top);
                rectF.right = (float) (((this.f53506t[0] + this.f53494h.getWidth()) - this.f53487A.right) - this.f53494h.getPaddingRight());
                rectF.bottom = (float) (((this.f53506t[1] + this.f53494h.getHeight()) - this.f53494h.getPaddingBottom()) - this.f53487A.bottom);
                this.f53496j.setColor(0);
                Canvas canvas3 = this.f53503q;
                int i2 = this.f53512z;
                canvas3.drawRoundRect(rectF, (float) i2, (float) i2, this.f53496j);
            }
        } else {
            Canvas canvas4 = this.f53503q;
            int[] iArr = this.f53499m;
            canvas4.drawCircle((float) iArr[0], (float) iArr[1], (float) this.f53493g, this.f53496j);
        }
        canvas.drawBitmap(this.f53501o, 0.0f, 0.0f, paint);
        this.f53501o.recycle();
    }

    /* renamed from: com.didiglobal.sa.biz.component.guide.view.GuideView$3 */
    static /* synthetic */ class C178993 {

        /* renamed from: $SwitchMap$com$didiglobal$sa$biz$component$guide$view$GuideView$Direction */
        static final /* synthetic */ int[] f53513x5ebae6ff;

        /* renamed from: $SwitchMap$com$didiglobal$sa$biz$component$guide$view$GuideView$MyShape */
        static final /* synthetic */ int[] f53514xd190bcd5;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|(2:1|2)|3|5|6|7|8|9|10|(3:11|12|14)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0023 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002e */
        static {
            /*
                com.didiglobal.sa.biz.component.guide.view.GuideView$MyShape[] r0 = com.didiglobal.p205sa.biz.component.guide.view.GuideView.MyShape.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f53514xd190bcd5 = r0
                r1 = 1
                com.didiglobal.sa.biz.component.guide.view.GuideView$MyShape r2 = com.didiglobal.p205sa.biz.component.guide.view.GuideView.MyShape.RECTANGULAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                com.didiglobal.sa.biz.component.guide.view.GuideView$Direction[] r0 = com.didiglobal.p205sa.biz.component.guide.view.GuideView.Direction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f53513x5ebae6ff = r0
                com.didiglobal.sa.biz.component.guide.view.GuideView$Direction r2 = com.didiglobal.p205sa.biz.component.guide.view.GuideView.Direction.BOTTOM_ARROW     // Catch:{ NoSuchFieldError -> 0x0023 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0023 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                int[] r0 = f53513x5ebae6ff     // Catch:{ NoSuchFieldError -> 0x002e }
                com.didiglobal.sa.biz.component.guide.view.GuideView$Direction r1 = com.didiglobal.p205sa.biz.component.guide.view.GuideView.Direction.TOP_ARROW     // Catch:{ NoSuchFieldError -> 0x002e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r0 = f53513x5ebae6ff     // Catch:{ NoSuchFieldError -> 0x0039 }
                com.didiglobal.sa.biz.component.guide.view.GuideView$Direction r1 = com.didiglobal.p205sa.biz.component.guide.view.GuideView.Direction.CENTER_TIPS_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r0 = f53513x5ebae6ff     // Catch:{ NoSuchFieldError -> 0x0044 }
                com.didiglobal.sa.biz.component.guide.view.GuideView$Direction r1 = com.didiglobal.p205sa.biz.component.guide.view.GuideView.Direction.CENTER_TIPS_TOP     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.component.guide.view.GuideView.C178993.<clinit>():void");
        }
    }

    public void setOnClickExit(boolean z) {
        this.f53507u = z;
    }

    public void setOnclickListener(OnClickCallback onClickCallback) {
        this.f53508v = onClickCallback;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m39944c() {
        final boolean z = this.f53507u;
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (GuideView.this.f53508v != null) {
                    GuideView.this.f53508v.onClickedGuideView();
                }
                if (z) {
                    GuideView.this.hide();
                }
            }
        });
    }

    public void onGlobalLayout() {
        if (!this.f53498l) {
            if (this.f53494h.getHeight() > 0 || this.f53494h.getWidth() > 0) {
                this.f53498l = true;
            }
            if (this.f53499m == null) {
                int[] iArr = new int[2];
                this.f53506t = iArr;
                this.f53494h.getLocationInWindow(iArr);
                int[] iArr2 = new int[2];
                this.f53499m = iArr2;
                iArr2[0] = this.f53506t[0] + (this.f53494h.getWidth() / 2);
                this.f53499m[1] = this.f53506t[1] + (this.f53494h.getHeight() / 2);
            }
            if (this.f53493g == 0) {
                this.f53493g = getTargetViewRadius();
            }
            m39942b();
            UIHandler.post(new Runnable() {
                public void run() {
                    GuideView.this.m39946d();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m39946d() {
        try {
            int childCount = getChildCount();
            HashMap hashMap = new HashMap();
            hashMap.put("childcount", Integer.valueOf(childCount));
            if (childCount == 0) {
                OmegaSDKAdapter.trackEvent("tech_sa_pax_event_guide_show", (Map<String, Object>) hashMap);
            } else if (childCount == 1) {
                hashMap.put("visible", Boolean.valueOf(getChildAt(0).getLocalVisibleRect(new Rect())));
                OmegaSDKAdapter.trackEvent("tech_sa_pax_event_guide_show", (Map<String, Object>) hashMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: com.didiglobal.sa.biz.component.guide.view.GuideView$Builder */
    public static class Builder {
        static GuideView guiderView;
        static Builder instance = new Builder();
        Context mContext;

        private Builder() {
        }

        public Builder(Context context) {
            this.mContext = context;
        }

        public static Builder newInstance(Context context) {
            guiderView = new GuideView(context);
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

        public GuideView build() {
            guiderView.m39944c();
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
