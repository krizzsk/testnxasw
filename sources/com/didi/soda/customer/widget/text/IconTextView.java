package com.didi.soda.customer.widget.text;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.soda.customer.foundation.util.FontUtils;

public class IconTextView extends AppCompatTextView {
    public IconTextView(Context context) {
        super(context);
        m33226a();
    }

    public IconTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33226a();
    }

    public IconTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33226a();
    }

    /* renamed from: a */
    private void m33226a() {
        super.setTypeface(FontUtils.getIconTypeface());
    }
}
