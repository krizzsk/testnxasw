package com.didi.soda.customer.widget.cart;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;

public class CartBusinessExceptionStatusView extends LinearLayout {

    /* renamed from: a */
    private static String f44264a;

    /* renamed from: b */
    private static String f44265b;

    /* renamed from: c */
    private static String f44266c;

    /* renamed from: d */
    private static String f44267d;

    /* renamed from: e */
    private TextView f44268e;

    /* renamed from: f */
    private TextView f44269f;

    /* renamed from: g */
    private TextView f44270g;

    /* renamed from: h */
    private ViewGroup f44271h;

    public CartBusinessExceptionStatusView(Context context) {
        super(context);
        m32930e();
    }

    public CartBusinessExceptionStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m32930e();
    }

    public CartBusinessExceptionStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m32930e();
    }

    public void updateExceptionStatus(int i, String str) {
        int businessExceptionShowStyle = BusinessDataHelper.getBusinessExceptionShowStyle(i, str);
        if (businessExceptionShowStyle == 0) {
            m32927b();
        } else if (businessExceptionShowStyle == 2) {
            m32926a(str);
        } else if (businessExceptionShowStyle != 3) {
            m32925a();
        } else {
            m32928c();
        }
    }

    /* renamed from: a */
    private void m32925a() {
        this.f44268e.setText(f44264a);
        this.f44269f.setText(f44265b);
        this.f44268e.setVisibility(0);
        this.f44269f.setVisibility(0);
        this.f44270g.setVisibility(8);
    }

    /* renamed from: b */
    private void m32927b() {
        this.f44268e.setVisibility(8);
        this.f44269f.setVisibility(8);
        this.f44270g.setVisibility(0);
        this.f44270g.setText(f44266c);
    }

    /* renamed from: a */
    private void m32926a(String str) {
        this.f44268e.setText(f44264a);
        this.f44269f.setText(getContext().getString(R.string.customer_business_status_next_open_time_no_folding, new Object[]{str}));
        this.f44268e.setVisibility(0);
        this.f44269f.setVisibility(0);
        this.f44270g.setVisibility(8);
    }

    /* renamed from: c */
    private void m32928c() {
        this.f44268e.setVisibility(8);
        this.f44269f.setVisibility(8);
        this.f44270g.setVisibility(0);
        this.f44270g.setText(f44267d);
    }

    /* renamed from: d */
    private void m32929d() {
        f44264a = getContext().getString(R.string.customer_business_status_closed);
        f44265b = getContext().getString(R.string.customer_business_status_open_soon_no_folding);
        f44266c = getContext().getString(R.string.customer_business_status_out_of_delivery_no_folding);
        f44267d = getContext().getString(R.string.customer_business_detail_temporarily_unavailable);
    }

    /* renamed from: e */
    private void m32930e() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_cart_business_exception_status_view, this);
        this.f44268e = (TextView) findViewById(R.id.customer_tv_status);
        this.f44269f = (TextView) findViewById(R.id.customer_tv_tips);
        this.f44271h = (ViewGroup) findViewById(R.id.customer_ll_status_container);
        this.f44270g = (TextView) findViewById(R.id.customer_tv_out_of_delivery);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44268e, IToolsService.FontType.MEDIUM);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44269f, IToolsService.FontType.MEDIUM);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44270g, IToolsService.FontType.MEDIUM);
        m32929d();
    }
}
