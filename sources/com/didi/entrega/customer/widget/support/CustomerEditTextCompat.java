package com.didi.entrega.customer.widget.support;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import com.didi.app.nova.support.view.edittext.EditTextCompat;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.IToolsService;
import com.didi.passenger.C11267R;
import com.taxis99.R;

public class CustomerEditTextCompat extends EditTextCompat {
    public CustomerEditTextCompat(Context context) {
        super(new ContextThemeWrapper(context, R.style.EntregaCustomerAppTheme));
        m18485a(context, (AttributeSet) null);
    }

    public CustomerEditTextCompat(Context context, AttributeSet attributeSet) {
        super(new ContextThemeWrapper(context, R.style.EntregaCustomerAppTheme), attributeSet);
        m18485a(context, attributeSet);
    }

    public CustomerEditTextCompat(Context context, AttributeSet attributeSet, int i) {
        super(new ContextThemeWrapper(context, R.style.EntregaCustomerAppTheme), attributeSet, i);
        m18485a(context, attributeSet);
    }

    /* renamed from: a */
    private void m18485a(Context context, AttributeSet attributeSet) {
        int i = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.EntregaAppCompatTextView);
            i = obtainStyledAttributes.getInt(0, -1);
            obtainStyledAttributes.recycle();
        }
        if (i == 1) {
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
