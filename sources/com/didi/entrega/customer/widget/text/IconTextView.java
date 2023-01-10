package com.didi.entrega.customer.widget.text;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.entrega.customer.foundation.util.FontUtils;

public class IconTextView extends AppCompatTextView {
    public IconTextView(Context context) {
        super(context);
        m18488a();
    }

    public IconTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18488a();
    }

    public IconTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18488a();
    }

    /* renamed from: a */
    private void m18488a() {
        super.setTypeface(FontUtils.getIconTypeface());
    }
}
