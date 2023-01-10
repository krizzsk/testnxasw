package com.didi.soda.customer.widget.map;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.taxis99.R;

public class BusinessMarkerView extends RelativeLayout {

    /* renamed from: a */
    private ImageView f44678a;

    public BusinessMarkerView(Context context) {
        super(context);
        m33165a();
    }

    public ImageView getBusinessImageView() {
        return this.f44678a;
    }

    public ImageView getBusinessLogoIv() {
        return this.f44678a;
    }

    public void setBusinessLogo(Drawable drawable) {
        this.f44678a.setBackgroundDrawable(drawable);
    }

    /* renamed from: a */
    private void m33165a() {
        inflate(getContext(), R.layout.customer_widget_marker_business, this);
        this.f44678a = (ImageView) findViewById(R.id.customer_iv_business_marker);
    }
}
