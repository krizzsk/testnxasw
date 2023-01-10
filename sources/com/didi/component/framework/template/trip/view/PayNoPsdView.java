package com.didi.component.framework.template.trip.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;

public class PayNoPsdView extends LinearLayout {

    /* renamed from: a */
    private LinearLayout f15837a;

    /* renamed from: b */
    private Path f15838b;

    /* renamed from: c */
    private int f15839c;

    /* renamed from: d */
    private int f15840d;

    /* renamed from: e */
    private int f15841e;

    /* renamed from: f */
    private int f15842f;

    public PayNoPsdView(Context context) {
        super(context);
        m13153a(context);
    }

    /* renamed from: a */
    private void m13153a(Context context) {
        inflate(context, R.layout.global_pay_no_psd_processing_layout, this);
        this.f15837a = (LinearLayout) findViewById(R.id.pay_no_psd_real_layout);
        this.f15839c = UIUtils.dip2px(context, 25.0f);
    }

    public ViewGroup getInnerLayout() {
        return this.f15837a;
    }

    /* renamed from: a */
    private void m13152a() {
        if (getWidth() != this.f15840d || getHeight() != this.f15841e || this.f15842f != this.f15839c) {
            this.f15840d = getWidth();
            this.f15841e = getHeight();
            this.f15842f = this.f15839c;
            this.f15838b.reset();
            Path path = this.f15838b;
            RectF rectF = new RectF(0.0f, 0.0f, (float) this.f15840d, (float) this.f15841e);
            int i = this.f15839c;
            path.addRoundRect(rectF, new float[]{(float) i, (float) i, (float) i, (float) i, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
        }
    }

    public void draw(Canvas canvas) {
        int save = canvas.save();
        m13152a();
        canvas.clipPath(this.f15838b);
        super.draw(canvas);
        canvas.restoreToCount(save);
    }
}
