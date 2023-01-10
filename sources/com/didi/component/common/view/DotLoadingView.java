package com.didi.component.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.didi.sdk.util.ResourcesHelper;

public class DotLoadingView extends View {
    public static final int COLOR_LOADING_DEFAULT_NORMAL = 2131101828;

    /* renamed from: a */
    Runnable f13654a = new Runnable() {
        public void run() {
            DotLoadingView dotLoadingView = DotLoadingView.this;
            dotLoadingView.updateStepView(dotLoadingView.f13655b);
            DotLoadingView.m11400b(DotLoadingView.this);
            if (DotLoadingView.this.f13655b >= 4) {
                int unused = DotLoadingView.this.f13655b = 1;
            }
            DotLoadingView.this.f13660g.postDelayed(DotLoadingView.this.f13654a, 200);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f13655b = 0;

    /* renamed from: c */
    private Paint f13656c;

    /* renamed from: d */
    private Paint f13657d;

    /* renamed from: e */
    private float f13658e = 8.0f;

    /* renamed from: f */
    private float f13659f = 12.0f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f13660g = new Handler();

    /* renamed from: h */
    private final int f13661h = 120;

    /* renamed from: i */
    private final int f13662i = 40;

    /* renamed from: j */
    private int f13663j;

    /* renamed from: k */
    private int f13664k;

    /* renamed from: l */
    private int f13665l;

    /* renamed from: m */
    private int f13666m;

    /* renamed from: b */
    static /* synthetic */ int m11400b(DotLoadingView dotLoadingView) {
        int i = dotLoadingView.f13655b;
        dotLoadingView.f13655b = i + 1;
        return i;
    }

    public DotLoadingView(Context context) {
        super(context);
        m11399a();
    }

    public DotLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11399a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(120, 40);
    }

    public DotLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11399a();
    }

    /* renamed from: a */
    private void m11399a() {
        Paint paint = new Paint();
        this.f13656c = paint;
        paint.setColor(ResourcesHelper.getColor(getContext(), COLOR_LOADING_DEFAULT_NORMAL));
        this.f13656c.setAntiAlias(true);
        this.f13656c.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f13657d = paint2;
        paint2.setColor(ResourcesHelper.getColor(getContext(), COLOR_LOADING_DEFAULT_NORMAL));
        this.f13657d.setStyle(Paint.Style.FILL);
        this.f13664k = 20;
        this.f13665l = 60;
        this.f13666m = 100;
        this.f13663j = 20;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i = this.f13655b;
        if (i == 0) {
            canvas.drawCircle((float) this.f13664k, (float) this.f13663j, this.f13658e, this.f13656c);
            canvas.drawCircle((float) this.f13665l, (float) this.f13663j, this.f13658e, this.f13656c);
            canvas.drawCircle((float) this.f13666m, (float) this.f13663j, this.f13658e, this.f13656c);
        } else if (i == 1) {
            canvas.drawCircle((float) this.f13664k, (float) this.f13663j, this.f13659f, this.f13657d);
            canvas.drawCircle((float) this.f13665l, (float) this.f13663j, this.f13658e, this.f13656c);
            canvas.drawCircle((float) this.f13666m, (float) this.f13663j, this.f13658e, this.f13656c);
        } else if (i == 2) {
            canvas.drawCircle((float) this.f13664k, (float) this.f13663j, this.f13658e, this.f13656c);
            canvas.drawCircle((float) this.f13665l, (float) this.f13663j, this.f13659f, this.f13657d);
            canvas.drawCircle((float) this.f13666m, (float) this.f13663j, this.f13658e, this.f13656c);
        } else if (i == 3) {
            canvas.drawCircle((float) this.f13664k, (float) this.f13663j, this.f13658e, this.f13656c);
            canvas.drawCircle((float) this.f13665l, (float) this.f13663j, this.f13658e, this.f13656c);
            canvas.drawCircle((float) this.f13666m, (float) this.f13663j, this.f13659f, this.f13657d);
        }
    }

    public void updateStepView(int i) {
        this.f13655b = i;
        invalidate();
    }

    public void startLoading() {
        this.f13655b = 0;
        this.f13660g.removeCallbacks(this.f13654a);
        this.f13660g.post(this.f13654a);
    }

    public void stopLoading() {
        this.f13655b = 0;
        this.f13660g.removeCallbacks(this.f13654a);
    }

    public void resetLoadingBarColor(int i, int i2) {
        this.f13656c.setColor(ResourcesHelper.getColor(getContext(), i));
        this.f13657d.setColor(ResourcesHelper.getColor(getContext(), i2));
    }
}
