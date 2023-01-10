package com.didi.soda.address;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.taxis99.R;

public class AddressTipsView extends RelativeLayout {

    /* renamed from: a */
    private Context f41342a;

    /* renamed from: b */
    private View f41343b;

    /* renamed from: c */
    private ImageView f41344c;

    /* renamed from: d */
    private TextView f41345d;

    public AddressTipsView(Context context) {
        super(context);
        this.f41342a = context;
        m31022a();
    }

    public AddressTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41342a = context;
        m31022a();
    }

    public void setContent(String str) {
        this.f41345d.setText(str);
        if (TextUtils.isEmpty(str)) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    /* renamed from: a */
    private void m31022a() {
        View inflate = LayoutInflater.from(this.f41342a).inflate(R.layout.customer_component_address_tips, this);
        this.f41343b = inflate;
        this.f41344c = (ImageView) inflate.findViewById(R.id.customer_iv_tips_close);
        this.f41345d = (TextView) this.f41343b.findViewById(R.id.customer_tv_address_tips_content);
        this.f41344c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AddressTipsView.this.setVisibility(8);
            }
        });
    }
}
