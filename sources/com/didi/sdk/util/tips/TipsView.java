package com.didi.sdk.util.tips;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class TipsView extends RelativeLayout {

    /* renamed from: A */
    private PorterDuffXfermode f40457A;

    /* renamed from: B */
    private View f40458B;

    /* renamed from: a */
    boolean f40459a;

    /* renamed from: b */
    int f40460b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Point f40461c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f40462d = 0;

    /* renamed from: e */
    private String f40463e;

    /* renamed from: f */
    private String f40464f;

    /* renamed from: g */
    private String f40465g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f40466h;

    /* renamed from: i */
    private boolean f40467i;

    /* renamed from: j */
    private int f40468j = 0;

    /* renamed from: k */
    private int f40469k = 0;

    /* renamed from: l */
    private int f40470l = 10;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public View f40471m;

    /* renamed from: n */
    private int f40472n;

    /* renamed from: o */
    private int f40473o;

    /* renamed from: p */
    private int f40474p;

    /* renamed from: q */
    private int f40475q;

    /* renamed from: r */
    private int f40476r;

    /* renamed from: s */
    private int f40477s;

    /* renamed from: t */
    private StoreUtils f40478t;

    /* renamed from: u */
    private Bitmap f40479u;

    /* renamed from: v */
    private Canvas f40480v;

    /* renamed from: w */
    private Paint f40481w;

    /* renamed from: x */
    private Paint f40482x;

    /* renamed from: y */
    private Paint f40483y;

    /* renamed from: z */
    private Paint f40484z;

    public TipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30418a();
    }

    public TipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30418a();
    }

    public TipsView(Context context) {
        super(context);
        m30418a();
    }

    /* renamed from: a */
    static Point m30415a(View view) {
        Point point = new Point();
        point.x = view.getLeft() + (view.getWidth() / 2);
        point.y = view.getTop() + (view.getHeight() / 2);
        return point;
    }

    public void setShowView(View view) {
        this.f40458B = view;
    }

    /* renamed from: a */
    private void m30418a() {
        setVisibility(8);
        setBackgroundColor(0);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.f40478t = new StoreUtils(getContext());
        this.f40481w = new Paint();
        this.f40482x = new Paint();
        this.f40483y = new Paint();
        this.f40484z = new Paint();
        this.f40457A = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f40472n = i;
        this.f40473o = i2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f40479u == null) {
            this.f40479u = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
            this.f40480v = new Canvas(this.f40479u);
        }
        this.f40480v.drawColor(Color.parseColor("#40000000"));
        int i = this.f40476r;
        if (i != 0) {
            this.f40480v.drawColor(i);
        } else {
            this.f40480v.drawColor(Color.parseColor("#40000000"));
        }
        this.f40481w.setColor(Color.parseColor("#00000000"));
        Canvas canvas2 = this.f40480v;
        canvas2.drawRect(0.0f, 0.0f, (float) canvas2.getWidth(), (float) this.f40480v.getHeight(), this.f40481w);
        this.f40484z.setColor(getResources().getColor(17170445));
        this.f40484z.setXfermode(this.f40457A);
        m30419b();
        canvas.drawBitmap(this.f40479u, 0.0f, 0.0f, this.f40482x);
    }

    /* renamed from: b */
    private void m30419b() {
        View view = this.f40471m;
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            RectF rectF = new RectF((float) iArr[0], (float) iArr[1], (float) (iArr[0] + this.f40471m.getWidth()), (float) (iArr[1] + this.f40471m.getHeight()));
            Canvas canvas = this.f40480v;
            int i = this.f40470l;
            canvas.drawRoundRect(rectF, (float) i, (float) i, this.f40484z);
        }
    }

    public void show(final Activity activity) {
        if (!isDisplayOneTime() || !this.f40478t.mo103574a(getDisplayOneTimeID())) {
            if (isDisplayOneTime()) {
                this.f40478t.mo103575b(getDisplayOneTimeID());
            }
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    ((ViewGroup) activity.getWindow().getDecorView()).addView(TipsView.this);
                    TipsView.this.setVisibility(0);
                    TipsView.this.startAnimation(AnimationUtils.loadAnimation(TipsView.this.getContext(), R.anim.fade_in));
                    TipsView.this.f40471m.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        public void onGlobalLayout() {
                            if (!TipsView.this.f40459a) {
                                if (TipsView.this.f40471m.getHeight() > 0 && TipsView.this.f40471m.getWidth() > 0) {
                                    TipsView.this.f40459a = true;
                                }
                                if (!TipsView.this.f40466h) {
                                    int[] iArr = new int[2];
                                    TipsView.this.f40471m.getLocationInWindow(iArr);
                                    Point unused = TipsView.this.f40461c = new Point(iArr[0] + (TipsView.this.f40471m.getWidth() / 2), iArr[1] + (TipsView.this.f40471m.getHeight() / 2));
                                    int unused2 = TipsView.this.f40462d = TipsView.this.f40471m.getWidth() / 2;
                                } else {
                                    int[] iArr2 = new int[2];
                                    TipsView.this.f40471m.getLocationInWindow(iArr2);
                                    Point unused3 = TipsView.this.f40461c = new Point(iArr2[0] + TipsView.this.f40461c.x, iArr2[1] + TipsView.this.f40461c.y);
                                }
                                TipsView.this.invalidate();
                                TipsView.this.m30422c();
                            }
                        }
                    });
                }
            }, (long) getDelay());
            return;
        }
        setVisibility(8);
        ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).removeView(this);
    }

    private void getStatusBarHeight() {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            this.f40460b = getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m30422c() {
        getStatusBarHeight();
        removeAllViews();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f40460b;
        View view = this.f40458B;
        if (view != null) {
            view.setLayoutParams(layoutParams);
            addView(this.f40458B);
        }
    }

    public String getButtonText() {
        String str = this.f40465g;
        return (str == null || str.equals("")) ? "Got it" : this.f40465g;
    }

    public void setButtonText(String str) {
        this.f40465g = str;
    }

    public void setTarget(View view) {
        this.f40471m = view;
    }

    public void setTarget(View view, int i, int i2, int i3) {
        this.f40466h = true;
        this.f40471m = view;
        this.f40461c = new Point(i, i2);
        this.f40462d = i3;
    }

    public String getTitle() {
        return this.f40463e;
    }

    public void setTitle(String str) {
        this.f40463e = str;
    }

    public String getDescription() {
        return this.f40464f;
    }

    public void setDescription(String str) {
        this.f40464f = str;
    }

    public boolean isDisplayOneTime() {
        return this.f40467i;
    }

    public void setDisplayOneTime(boolean z) {
        this.f40467i = z;
    }

    public int getDelay() {
        return this.f40469k;
    }

    public void setDelay(int i) {
        this.f40469k = i;
    }

    public int getDisplayOneTimeID() {
        return this.f40468j;
    }

    public void setDisplayOneTimeID(int i) {
        this.f40468j = i;
    }

    public int getTitle_color() {
        return this.f40474p;
    }

    public void setTitle_color(int i) {
        this.f40474p = i;
    }

    public int getDescription_color() {
        return this.f40475q;
    }

    public void setDescription_color(int i) {
        this.f40475q = i;
    }

    public int getBackground_color() {
        return this.f40476r;
    }

    public void setBackground_color(int i) {
        this.f40476r = i;
    }

    public int getCircleColor() {
        return this.f40477s;
    }

    public void setCircleColor(int i) {
        this.f40477s = i;
    }

    public void cancel() {
        ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).removeView(this);
        Bitmap bitmap = this.f40479u;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f40479u.recycle();
        }
    }
}
