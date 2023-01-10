package com.didi.soda.customer.widget.business;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;

public class BusinessExceptionStatusView extends ConstraintLayout {

    /* renamed from: a */
    private static String f44253a;

    /* renamed from: b */
    private static String f44254b;

    /* renamed from: c */
    private static String f44255c;

    /* renamed from: d */
    private TextView f44256d;

    /* renamed from: e */
    private TextView f44257e;

    /* renamed from: f */
    private ConstraintLayout f44258f;

    public BusinessExceptionStatusView(Context context) {
        super(context);
        m32919d();
    }

    public BusinessExceptionStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m32919d();
    }

    public BusinessExceptionStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m32919d();
    }

    public void updateExceptionStatus(int i, String str) {
        int businessExceptionShowStyle = BusinessDataHelper.getBusinessExceptionShowStyle(i, str);
        if (businessExceptionShowStyle == 0) {
            m32918c();
        } else if (businessExceptionShowStyle != 2) {
            m32917b();
        } else {
            m32916a(str);
        }
    }

    /* renamed from: a */
    private void m32915a() {
        f44253a = getContext().getString(R.string.customer_business_status_closed);
        f44254b = getContext().getString(R.string.customer_business_status_open_soon);
        f44255c = getContext().getString(R.string.customer_business_status_out_of_delivery);
    }

    /* renamed from: b */
    private void m32917b() {
        this.f44256d.setText(f44253a);
        this.f44257e.setText(f44254b);
        this.f44257e.setMaxLines(2);
        this.f44258f.setBackgroundResource(R.drawable.customer_bg_business_exception_status_container);
        this.f44256d.setVisibility(0);
    }

    /* renamed from: c */
    private void m32918c() {
        this.f44256d.setVisibility(8);
        this.f44257e.setMaxLines(3);
        this.f44257e.setText(f44255c);
        this.f44258f.setBackgroundResource(R.drawable.customer_shape_bg_business_out_delivery_tips);
    }

    /* renamed from: a */
    private void m32916a(String str) {
        this.f44256d.setText(f44253a);
        this.f44257e.setMaxLines(2);
        this.f44257e.setText(getContext().getString(R.string.customer_business_status_next_open_time, new Object[]{str}));
        this.f44258f.setBackgroundResource(R.drawable.customer_bg_business_exception_status_container);
        this.f44256d.setVisibility(0);
    }

    /* renamed from: d */
    private void m32919d() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_business_exception_status_view, this);
        this.f44256d = (TextView) findViewById(R.id.customer_tv_status);
        this.f44257e = (TextView) findViewById(R.id.customer_tv_tips);
        this.f44258f = (ConstraintLayout) findViewById(R.id.customer_cl_container);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44256d, IToolsService.FontType.BOLD);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44257e, IToolsService.FontType.BOLD);
        m32915a();
    }
}
