package com.didi.soda.home.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.app.GlobalContext;

public class HeaderEmbedPlaceView extends View {

    /* renamed from: a */
    private int f45820a = getPlaceHeight();

    public HeaderEmbedPlaceView(Context context) {
        super(context);
        m33974a();
    }

    public HeaderEmbedPlaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33974a();
    }

    public HeaderEmbedPlaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33974a();
    }

    public void setPlaceHeight(int i) {
        this.f45820a = i;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), this.f45820a);
    }

    /* renamed from: a */
    private void m33974a() {
        if (GlobalContext.isEmbed()) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    private int getPlaceHeight() {
        if (!GlobalContext.isEmbed()) {
            return 0;
        }
        return DisplayUtils.dip2px(getContext(), 6.0f);
    }
}
