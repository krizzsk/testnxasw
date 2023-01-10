package com.didi.component.confirmbroadingpoint.impl.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.didi.component.common.util.UIUtils;
import com.didi.sdk.util.ResourcesHelper;

public class DotLoadingView extends View {
    public static final int COLOR_LOADING_DEFAULT_NORMAL = 419430400;
    public static final int COlor_LOADING_DEFAULT_PUSH = 2131101828;

    /* renamed from: a */
    Runnable f14515a = new Runnable() {
        public void run() {
            DotLoadingView dotLoadingView = DotLoadingView.this;
            dotLoadingView.updateStepView(dotLoadingView.f14516b);
            DotLoadingView.m12017b(DotLoadingView.this);
            if (DotLoadingView.this.f14516b >= 4) {
                int unused = DotLoadingView.this.f14516b = 1;
            }
            DotLoadingView.this.f14521g.postDelayed(DotLoadingView.this.f14515a, 200);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f14516b = 0;

    /* renamed from: c */
    private Paint f14517c;

    /* renamed from: d */
    private Paint f14518d;

    /* renamed from: e */
    private float f14519e = 8.0f;

    /* renamed from: f */
    private float f14520f = 12.0f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f14521g = new Handler();

    /* renamed from: h */
    private final int f14522h = UIUtils.dip2pxInt(getContext(), 47.0f);

    /* renamed from: i */
    private final int f14523i = UIUtils.dip2pxInt(getContext(), 15.0f);

    /* renamed from: j */
    private int f14524j;

    /* renamed from: k */
    private int f14525k;

    /* renamed from: l */
    private int f14526l;

    /* renamed from: m */
    private int f14527m;

    /* renamed from: b */
    static /* synthetic */ int m12017b(DotLoadingView dotLoadingView) {
        int i = dotLoadingView.f14516b;
        dotLoadingView.f14516b = i + 1;
        return i;
    }

    public DotLoadingView(Context context) {
        super(context);
        m12016a();
    }

    public DotLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12016a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.f14522h, this.f14523i);
    }

    public DotLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12016a();
    }

    /* renamed from: a */
    private void m12016a() {
        Paint paint = new Paint();
        this.f14517c = paint;
        paint.setColor(COLOR_LOADING_DEFAULT_NORMAL);
        this.f14517c.setAntiAlias(true);
        this.f14517c.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f14518d = paint2;
        paint2.setColor(838860800);
        this.f14518d.setStyle(Paint.Style.FILL);
        int i = this.f14522h;
        this.f14525k = i / 6;
        this.f14526l = i / 2;
        this.f14527m = (i / 6) * 5;
        this.f14524j = this.f14523i / 2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i = this.f14516b;
        if (i == 0) {
            canvas.drawCircle((float) this.f14525k, (float) this.f14524j, this.f14519e, this.f14517c);
            canvas.drawCircle((float) this.f14526l, (float) this.f14524j, this.f14519e, this.f14517c);
            canvas.drawCircle((float) this.f14527m, (float) this.f14524j, this.f14519e, this.f14517c);
        } else if (i == 1) {
            canvas.drawCircle((float) this.f14525k, (float) this.f14524j, this.f14520f, this.f14518d);
            canvas.drawCircle((float) this.f14526l, (float) this.f14524j, this.f14519e, this.f14517c);
            canvas.drawCircle((float) this.f14527m, (float) this.f14524j, this.f14519e, this.f14517c);
        } else if (i == 2) {
            canvas.drawCircle((float) this.f14525k, (float) this.f14524j, this.f14519e, this.f14517c);
            canvas.drawCircle((float) this.f14526l, (float) this.f14524j, this.f14520f, this.f14518d);
            canvas.drawCircle((float) this.f14527m, (float) this.f14524j, this.f14519e, this.f14517c);
        } else if (i == 3) {
            canvas.drawCircle((float) this.f14525k, (float) this.f14524j, this.f14519e, this.f14517c);
            canvas.drawCircle((float) this.f14526l, (float) this.f14524j, this.f14519e, this.f14517c);
            canvas.drawCircle((float) this.f14527m, (float) this.f14524j, this.f14520f, this.f14518d);
        }
    }

    public void updateStepView(int i) {
        this.f14516b = i;
        invalidate();
    }

    public void startLoading() {
        this.f14516b = 0;
        this.f14521g.removeCallbacks(this.f14515a);
        this.f14521g.post(this.f14515a);
    }

    public void stopLoading() {
        this.f14516b = 0;
        this.f14521g.removeCallbacks(this.f14515a);
    }

    public void resetLoadingBarColor(int i, int i2) {
        this.f14517c.setColor(ResourcesHelper.getColor(getContext(), i));
        this.f14518d.setColor(ResourcesHelper.getColor(getContext(), i2));
    }
}
