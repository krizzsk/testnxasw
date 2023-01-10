package com.didi.soda.business.component.dynamic.guide;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;

public class BusinessGuideWidget extends ConstraintLayout {

    /* renamed from: a */
    private static final String f42162a = "BusinessGuideWidget";

    /* renamed from: b */
    private CustomerAppCompatTextView f42163b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnDismissListener f42164c;

    public interface OnDismissListener {
        void onDismiss();
    }

    public BusinessGuideWidget(Context context) {
        this(context, (AttributeSet) null);
    }

    public BusinessGuideWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BusinessGuideWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m31661a();
    }

    /* renamed from: a */
    private void m31661a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_business_guide_view, this, true);
        this.f42163b = (CustomerAppCompatTextView) findViewById(R.id.customer_tv_content_guide);
        findViewById(R.id.customer_tv_guide_confirm).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BusinessGuideWidget.this.setVisibility(8);
                if (BusinessGuideWidget.this.f42164c != null) {
                    BusinessGuideWidget.this.f42164c.onDismiss();
                }
            }
        });
        findViewById(R.id.customer_business_guide_root_container).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BusinessGuideWidget.this.setVisibility(8);
                if (BusinessGuideWidget.this.f42164c != null) {
                    BusinessGuideWidget.this.f42164c.onDismiss();
                }
            }
        });
    }

    public void setVisibility(int i) {
        if (getVisibility() != i) {
            super.setVisibility(i);
        }
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f42164c = onDismissListener;
    }
}
