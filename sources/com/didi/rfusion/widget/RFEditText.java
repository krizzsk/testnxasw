package com.didi.rfusion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import com.didi.passenger.C11267R;
import com.didi.rfusion.utils.RFFontUtils;

public class RFEditText extends AppCompatEditText {
    /* access modifiers changed from: protected */
    public boolean useTypeFace() {
        return true;
    }

    public RFEditText(Context context) {
        super(context);
    }

    public RFEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m27167a(context, attributeSet);
    }

    public RFEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m27167a(context, attributeSet);
    }

    /* renamed from: a */
    private void m27167a(Context context, AttributeSet attributeSet) {
        if (useTypeFace()) {
            int i = 0;
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.RFEditText);
                i = obtainStyledAttributes.getInt(0, 0);
                obtainStyledAttributes.recycle();
            }
            RFFontUtils.setTypeFace(this, i);
        }
    }

    public void setTypeface(int i) {
        RFFontUtils.setTypeFace(this, i);
    }
}
