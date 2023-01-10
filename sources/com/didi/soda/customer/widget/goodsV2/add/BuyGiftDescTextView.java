package com.didi.soda.customer.widget.goodsV2.add;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.text.CustomerSkinTextView;
import com.taxis99.R;

public class BuyGiftDescTextView extends CustomerSkinTextView {
    public static final float RIGHT_OVERRIDING_SIZE = 0.5f;

    /* renamed from: a */
    private Paint f44507a;

    /* renamed from: b */
    private Path f44508b = new Path();

    /* renamed from: c */
    private int f44509c;

    /* renamed from: d */
    private int f44510d;

    /* renamed from: e */
    private int f44511e;

    public BuyGiftDescTextView(Context context) {
        super(context);
        m33035b();
    }

    public BuyGiftDescTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33035b();
    }

    public BuyGiftDescTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33035b();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        m33034a();
        this.f44508b.reset();
        this.f44508b.moveTo((float) (getRight() - DisplayUtils.dip2px(getContext(), 0.5f)), 0.0f);
        this.f44508b.lineTo((float) (getRight() - DisplayUtils.dip2px(getContext(), 10.0f)), (float) getBottom());
        this.f44508b.lineTo((float) getRight(), (float) getBottom());
        this.f44508b.close();
        canvas.drawPath(this.f44508b, this.f44507a);
        super.onDraw(canvas);
    }

    /* renamed from: a */
    private void m33034a() {
        if (isPressed() && isEnabled()) {
            this.f44507a.setColor(this.f44509c);
        } else if (isEnabled()) {
            this.f44507a.setColor(this.f44510d);
        } else {
            this.f44507a.setColor(this.f44511e);
        }
    }

    /* renamed from: b */
    private void m33035b() {
        setBackgroundResource(R.drawable.customer_skin_selector_buy_gift_desc);
        setGravity(16);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this, IToolsService.FontType.MEDIUM);
        int dip2px = DisplayUtils.dip2px(getContext(), 19.0f);
        setPadding(dip2px, 0, dip2px, 0);
        this.f44511e = getContext().getResources().getColor(R.color.rf_color_gery_4_80_CCCCCC);
        this.f44510d = getContext().getResources().getColor(R.color.rf_color_jianbian_1);
        this.f44509c = getContext().getResources().getColor(R.color.rf_color_press_2_96);
        Paint paint = new Paint();
        this.f44507a = paint;
        paint.setAntiAlias(true);
        this.f44507a.setColor(this.f44510d);
        this.f44507a.setStyle(Paint.Style.FILL);
    }
}
