package com.didi.soda.home.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.home.topgun.manager.HomeUpdateHeaderInfoHelper;
import com.taxis99.R;

public class HeaderInfoLayout extends ConstraintLayout {

    /* renamed from: a */
    private ImageView f45821a;

    /* renamed from: b */
    private TextView f45822b;

    /* renamed from: c */
    private View f45823c;

    public HeaderInfoLayout(Context context) {
        super(context);
        m33975a();
    }

    public HeaderInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33975a();
    }

    public HeaderInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33975a();
    }

    public void updateHeaderInfo(ScopeContext scopeContext) {
        HomeUpdateHeaderInfoHelper.updateAddressInfo(this.f45822b, scopeContext, 0);
    }

    /* renamed from: a */
    private void m33975a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_home_head_info, this);
        this.f45821a = (ImageView) findViewById(R.id.customer_iv_feed_header);
        this.f45823c = findViewById(R.id.customer_vm_red_dot);
        this.f45822b = (TextView) findViewById(R.id.customer_tv_home_address);
    }
}
