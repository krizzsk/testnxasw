package com.didi.soda.customer.widget.support;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import com.didi.app.nova.support.view.edittext.EditTextCompat;
import com.didi.passenger.C11267R;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;

public class CustomerEditTextCompat extends EditTextCompat {
    public CustomerEditTextCompat(Context context) {
        super(new ContextThemeWrapper(context, R.style.SodaCustomerAppTheme));
        m33196a(context, (AttributeSet) null);
    }

    public CustomerEditTextCompat(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, R.style.SodaCustomerAppTheme), attributeSet);
        m33196a(context, attributeSet);
    }

    public CustomerEditTextCompat(Context context, AttributeSet attributeSet, int i) {
        super(new ContextThemeWrapper(context, R.style.SodaCustomerAppTheme), attributeSet, i);
        m33196a(context, attributeSet);
    }

    /* renamed from: a */
    private void m33196a(Context context, AttributeSet attributeSet) {
        int i = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.CustomerAppCompatTextView);
            i = obtainStyledAttributes.getInt(0, -1);
            obtainStyledAttributes.recycle();
        }
        if (i == 0) {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this, IToolsService.FontType.NORMAL);
        } else if (i == 1) {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this, IToolsService.FontType.MEDIUM);
        } else if (i == 2) {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this, IToolsService.FontType.BOLD);
        } else if (i != 3) {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this, IToolsService.FontType.NORMAL);
        } else {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this, IToolsService.FontType.LIGHT);
        }
    }
}
