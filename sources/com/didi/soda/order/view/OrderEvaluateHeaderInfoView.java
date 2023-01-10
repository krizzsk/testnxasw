package com.didi.soda.order.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.widget.CircleImageView;
import com.taxis99.R;

public class OrderEvaluateHeaderInfoView extends FrameLayout {

    /* renamed from: a */
    private TextView f46157a;

    /* renamed from: b */
    private CircleImageView f46158b;

    /* renamed from: c */
    private TextView f46159c;

    /* renamed from: d */
    private TextView f46160d;

    public OrderEvaluateHeaderInfoView(Context context) {
        super(context);
        m34286a();
    }

    public OrderEvaluateHeaderInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m34286a();
    }

    public OrderEvaluateHeaderInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m34286a();
    }

    public void setHeaderTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f46157a.setText(str);
            this.f46157a.setVisibility(0);
            return;
        }
        this.f46157a.setVisibility(8);
    }

    public void setEvaluateHeaderImage(String str, int i) {
        FlyImageLoader.loadImageUnspecified(getContext(), str).placeholder(i).error(i).into((ImageView) this.f46158b);
    }

    public void setNameImage(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.f46159c.setText(str);
            this.f46159c.setVisibility(0);
        } else {
            this.f46159c.setVisibility(8);
        }
        this.f46159c.setMaxLines(i);
    }

    public void setContentText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f46160d.setText(str);
            this.f46160d.setVisibility(0);
            return;
        }
        this.f46160d.setVisibility(8);
    }

    /* renamed from: a */
    private void m34286a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_evaluate_header_info, this, true);
        this.f46157a = (TextView) inflate.findViewById(R.id.customer_tv_title);
        this.f46158b = (CircleImageView) inflate.findViewById(R.id.customer_iv_header_image);
        this.f46159c = (TextView) inflate.findViewById(R.id.customer_tv_name);
        this.f46160d = (TextView) inflate.findViewById(R.id.customer_tv_content);
    }
}
