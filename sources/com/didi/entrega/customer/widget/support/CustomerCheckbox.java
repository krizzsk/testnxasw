package com.didi.entrega.customer.widget.support;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatCheckBox;

public class CustomerCheckbox extends AppCompatCheckBox {

    /* renamed from: a */
    private static final int f22462a = 2132017967;

    public CustomerCheckbox(Context context) {
        super(new ContextThemeWrapper(context, f22462a));
    }

    public CustomerCheckbox(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, f22462a), attributeSet);
    }

    public CustomerCheckbox(Context context, AttributeSet attributeSet, int i) {
        super(new ContextThemeWrapper(context, f22462a), attributeSet, i);
    }
}
