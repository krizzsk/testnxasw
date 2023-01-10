package com.didi.unifiedPay.component.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.taxis99.R;

public class TotalPayAreaView extends RelativeLayout {

    /* renamed from: a */
    private TextView f47102a;

    /* renamed from: b */
    private TextView f47103b;

    /* renamed from: c */
    private TextView f47104c;

    public TotalPayAreaView(Context context) {
        super(context);
        m35049a();
    }

    public TotalPayAreaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m35049a();
    }

    /* renamed from: a */
    private void m35049a() {
        LayoutInflater.from(getContext()).inflate(R.layout.total_pay_area, this);
        this.f47102a = (TextView) findViewById(R.id.total_pay_area_label);
        this.f47103b = (TextView) findViewById(R.id.total_pay_area_value);
        this.f47104c = (TextView) findViewById(R.id.total_pay_area_desc);
    }

    public void refresh(String str, String str2, String str3) {
        m35050a(this.f47102a, str);
        m35050a(this.f47103b, str2);
        m35050a(this.f47104c, str3);
    }

    /* renamed from: a */
    private void m35050a(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(str);
    }
}
