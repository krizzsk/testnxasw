package com.didi.beatles.p101im.views.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.didi.beatles.p101im.resource.IMResource;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.widget.IMLoadingView */
public class IMLoadingView extends View {

    /* renamed from: a */
    Runnable f12311a = new Runnable() {
        public void run() {
            IMLoadingView iMLoadingView = IMLoadingView.this;
            iMLoadingView.updateStepView(iMLoadingView.f12312b);
            IMLoadingView.m10504b(IMLoadingView.this);
            if (IMLoadingView.this.f12312b >= 4) {
                int unused = IMLoadingView.this.f12312b = 1;
            }
            IMLoadingView.this.f12317g.postDelayed(IMLoadingView.this.f12311a, 200);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f12312b = 0;

    /* renamed from: c */
    private Paint f12313c;

    /* renamed from: d */
    private Paint f12314d;

    /* renamed from: e */
    private float f12315e = 8.0f;

    /* renamed from: f */
    private float f12316f = 12.0f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f12317g = new Handler();

    /* renamed from: h */
    private final int f12318h = 120;

    /* renamed from: i */
    private final int f12319i = 40;

    /* renamed from: j */
    private int f12320j;

    /* renamed from: k */
    private int f12321k;

    /* renamed from: l */
    private int f12322l;

    /* renamed from: m */
    private int f12323m;

    /* renamed from: b */
    static /* synthetic */ int m10504b(IMLoadingView iMLoadingView) {
        int i = iMLoadingView.f12312b;
        iMLoadingView.f12312b = i + 1;
        return i;
    }

    public IMLoadingView(Context context) {
        super(context);
        m10503a();
    }

    public IMLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10503a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(120, 40);
    }

    public IMLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10503a();
    }

    /* renamed from: a */
    private void m10503a() {
        Paint paint = new Paint();
        this.f12313c = paint;
        paint.setColor(IMResource.getColor(R.color.title_bar_line_bg));
        this.f12313c.setAntiAlias(true);
        this.f12313c.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f12314d = paint2;
        paint2.setColor(IMResource.getColor(R.color.title_bar_line_bg));
        this.f12314d.setStyle(Paint.Style.FILL);
        this.f12321k = 20;
        this.f12322l = 60;
        this.f12323m = 100;
        this.f12320j = 20;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.drawColor(IMResource.getColor(R.color.white));
        int i = this.f12312b;
        if (i == 0) {
            canvas.drawCircle((float) this.f12321k, (float) this.f12320j, this.f12315e, this.f12313c);
            canvas.drawCircle((float) this.f12322l, (float) this.f12320j, this.f12315e, this.f12313c);
            canvas.drawCircle((float) this.f12323m, (float) this.f12320j, this.f12315e, this.f12313c);
        } else if (i == 1) {
            canvas.drawCircle((float) this.f12321k, (float) this.f12320j, this.f12316f, this.f12314d);
            canvas.drawCircle((float) this.f12322l, (float) this.f12320j, this.f12315e, this.f12313c);
            canvas.drawCircle((float) this.f12323m, (float) this.f12320j, this.f12315e, this.f12313c);
        } else if (i == 2) {
            canvas.drawCircle((float) this.f12321k, (float) this.f12320j, this.f12315e, this.f12313c);
            canvas.drawCircle((float) this.f12322l, (float) this.f12320j, this.f12316f, this.f12314d);
            canvas.drawCircle((float) this.f12323m, (float) this.f12320j, this.f12315e, this.f12313c);
        } else if (i == 3) {
            canvas.drawCircle((float) this.f12321k, (float) this.f12320j, this.f12315e, this.f12313c);
            canvas.drawCircle((float) this.f12322l, (float) this.f12320j, this.f12315e, this.f12313c);
            canvas.drawCircle((float) this.f12323m, (float) this.f12320j, this.f12316f, this.f12314d);
        }
    }

    public void updateStepView(int i) {
        this.f12312b = i;
        invalidate();
    }

    public void startLoading() {
        this.f12312b = 0;
        this.f12317g.removeCallbacks(this.f12311a);
        this.f12317g.post(this.f12311a);
    }

    public void stopLoading() {
        this.f12312b = 0;
        this.f12317g.removeCallbacks(this.f12311a);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Handler handler = this.f12317g;
        if (handler != null) {
            handler.removeCallbacks(this.f12311a);
        }
    }
}
