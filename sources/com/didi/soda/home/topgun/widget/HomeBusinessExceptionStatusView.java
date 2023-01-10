package com.didi.soda.home.topgun.widget;

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

public class HomeBusinessExceptionStatusView extends ConstraintLayout {

    /* renamed from: a */
    private static String f45586a;

    /* renamed from: b */
    private static String f45587b;

    /* renamed from: c */
    private static String f45588c;

    /* renamed from: d */
    private static String f45589d;

    /* renamed from: e */
    private TextView f45590e;

    /* renamed from: f */
    private TextView f45591f;

    public HomeBusinessExceptionStatusView(Context context) {
        super(context);
        m33873e();
    }

    public HomeBusinessExceptionStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33873e();
    }

    public HomeBusinessExceptionStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33873e();
    }

    public void updateExceptionStatus(int i, String str) {
        int businessExceptionShowStyle = BusinessDataHelper.getBusinessExceptionShowStyle(i, str);
        if (businessExceptionShowStyle == 0) {
            m33871c();
        } else if (businessExceptionShowStyle == 2) {
            m33869a(str);
        } else if (businessExceptionShowStyle != 3) {
            m33870b();
        } else {
            m33872d();
        }
    }

    /* renamed from: a */
    private void m33868a() {
        f45586a = getContext().getString(R.string.customer_business_status_closed);
        f45587b = getContext().getString(R.string.customer_business_status_closed_no_gap);
        f45588c = getContext().getString(R.string.customer_business_status_out_of_delivery);
        f45589d = getContext().getString(R.string.customer_business_detail_temporarily_unavailable);
    }

    /* renamed from: b */
    private void m33870b() {
        this.f45590e.setTextSize(1, 14.0f);
        this.f45590e.setMaxLines(1);
        m33874f();
        this.f45591f.setVisibility(8);
    }

    /* renamed from: c */
    private void m33871c() {
        m33875g();
        this.f45590e.setTextSize(1, 14.0f);
        this.f45591f.setVisibility(8);
        this.f45590e.setMaxLines(3);
        this.f45590e.setText(f45588c);
    }

    /* renamed from: a */
    private void m33869a(String str) {
        this.f45590e.setTextSize(1, 14.0f);
        this.f45590e.setMaxLines(1);
        m33874f();
        this.f45591f.setVisibility(0);
        this.f45591f.setText(getContext().getString(R.string.customer_business_status_next_open_time, new Object[]{str}));
    }

    /* renamed from: d */
    private void m33872d() {
        m33875g();
        this.f45590e.setTextSize(1, 14.0f);
        this.f45591f.setVisibility(8);
        this.f45590e.setMaxLines(2);
        this.f45590e.setText(f45589d);
    }

    /* renamed from: e */
    private void m33873e() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_home_business_exception_status_view, this);
        this.f45590e = (TextView) findViewById(R.id.customer_tv_status);
        this.f45591f = (TextView) findViewById(R.id.customer_tv_tips);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f45590e, IToolsService.FontType.MEDIUM);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f45591f, IToolsService.FontType.MEDIUM);
        m33868a();
    }

    /* renamed from: f */
    private void m33874f() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f45590e.setLetterSpacing(0.15f);
            this.f45590e.setText(f45587b);
            return;
        }
        this.f45590e.setText(f45586a);
    }

    /* renamed from: g */
    private void m33875g() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f45590e.setLetterSpacing(0.0f);
        }
    }
}
