package com.didi.soda.customer.widget.loading;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.didi.foundation.sdk.log.LogService;
import com.didi.passenger.C11267R;
import com.didi.sdk.logging.Logger;
import com.didi.soda.andy.tools.LogUtils;
import com.taxis99.R;

public class SodaLoadingView extends RelativeLayout {

    /* renamed from: a */
    private Logger f44647a;

    /* renamed from: b */
    private LottieLoadingView f44648b;

    public SodaLoadingView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SodaLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SodaLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f44647a = LogService.getLogger("SodaLoadingView");
        m33151a(context, attributeSet, i);
    }

    public void show() {
        this.f44648b.show();
    }

    public void hide() {
        this.f44648b.hide();
    }

    public boolean isRunning() {
        return getVisibility() == 0 && this.f44648b.isRunning();
    }

    public void start() {
        this.f44648b.start();
    }

    public void stop() {
        this.f44648b.stop();
    }

    /* renamed from: a */
    private void m33151a(Context context, AttributeSet attributeSet, int i) {
        String string;
        inflate(getContext(), R.layout.customer_layout_loading, this);
        this.f44648b = (LottieLoadingView) findViewById(R.id.customer_custom_lottie_loading_view);
        try {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.LottieAnimationView);
            boolean hasValue = obtainStyledAttributes.hasValue(9);
            boolean hasValue2 = obtainStyledAttributes.hasValue(5);
            if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(9, 0);
                if (resourceId != 0) {
                    this.f44648b.setAnimation(resourceId);
                }
            } else if (hasValue2 && (string = obtainStyledAttributes.getString(5)) != null) {
                this.f44648b.setAnimation(string);
            }
            obtainStyledAttributes.recycle();
        } catch (Exception e) {
            Logger logger = this.f44647a;
            logger.info(LogUtils.getLineText("⚠️ init() called with error : " + e.getMessage()), new Object[0]);
        }
    }
}
