package com.didi.soda.customer.widget.search;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;

public class SearchBusinessExceptionStatusView extends ConstraintLayout {

    /* renamed from: a */
    private static String f44732a;

    /* renamed from: b */
    private static String f44733b;

    /* renamed from: c */
    private static String f44734c;

    /* renamed from: d */
    private TextView f44735d;

    /* renamed from: e */
    private TextView f44736e;

    public SearchBusinessExceptionStatusView(Context context) {
        super(context);
        m33193d();
    }

    public SearchBusinessExceptionStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33193d();
    }

    public SearchBusinessExceptionStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33193d();
    }

    public void updateExceptionStatus(int i, String str) {
        int businessExceptionShowStyle = BusinessDataHelper.getBusinessExceptionShowStyle(i, str);
        if (businessExceptionShowStyle == 0) {
            m33192c();
        } else if (businessExceptionShowStyle != 2) {
            m33191b();
        } else {
            m33190a(str);
        }
    }

    /* renamed from: a */
    private void m33189a() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f44735d.setLetterSpacing(0.1f);
            f44732a = getContext().getString(R.string.customer_business_status_closed_no_gap);
        } else {
            f44732a = getContext().getString(R.string.customer_business_status_closed);
        }
        f44733b = getContext().getString(R.string.customer_business_status_open_soon_no_folding);
        f44734c = getContext().getString(R.string.customer_business_status_out_of_delivery_no_folding);
    }

    /* renamed from: b */
    private void m33191b() {
        this.f44736e.setText(f44733b);
        this.f44736e.setBackgroundResource(R.drawable.customer_shape_bg_search_business_exception_tip);
        this.f44735d.setText(f44732a);
        this.f44735d.setVisibility(0);
    }

    /* renamed from: c */
    private void m33192c() {
        this.f44735d.setVisibility(8);
        this.f44736e.setText(f44734c);
        this.f44736e.setBackgroundResource(R.drawable.customer_shape_bg_search_business_exception_out_delivery);
    }

    /* renamed from: a */
    private void m33190a(String str) {
        this.f44736e.setText(getContext().getString(R.string.customer_business_status_next_open_time_no_folding, new Object[]{str}));
        this.f44736e.setBackgroundResource(R.drawable.customer_shape_bg_search_business_exception_tip);
        this.f44735d.setText(f44732a);
        this.f44735d.setVisibility(0);
    }

    /* renamed from: d */
    private void m33193d() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_search_business_exception_status_view, this);
        this.f44735d = (TextView) findViewById(R.id.customer_tv_status);
        this.f44736e = (TextView) findViewById(R.id.customer_tv_tips);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44735d, IToolsService.FontType.BOLD);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f44736e, IToolsService.FontType.BOLD);
        m33189a();
    }
}
