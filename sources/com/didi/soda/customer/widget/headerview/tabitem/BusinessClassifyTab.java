package com.didi.soda.customer.widget.headerview.tabitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import com.taxis99.R;

public class BusinessClassifyTab extends ConstraintLayout implements ITab<BusinessCategoryRvModel> {

    /* renamed from: a */
    private TextView f44579a;

    /* renamed from: b */
    private CharSequence f44580b;

    /* renamed from: c */
    private CharSequence f44581c;

    public BusinessClassifyTab(Context context) {
        super(context);
        m33103a();
    }

    public BusinessClassifyTab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33103a();
    }

    public BusinessClassifyTab(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33103a();
    }

    public void setSelectedState(boolean z, boolean z2) {
        if (z) {
            this.f44579a.setSelected(true);
            this.f44579a.setText(this.f44580b);
            return;
        }
        this.f44579a.setSelected(false);
        this.f44579a.setText(this.f44581c);
    }

    public void updateTabView(BusinessCategoryRvModel businessCategoryRvModel, int i, int i2) {
        this.f44580b = businessCategoryRvModel.mSelectedCateName;
        this.f44581c = businessCategoryRvModel.mUnSelectedCateName;
        if (i == 0) {
            setPadding(DisplayUtils.dip2px(getContext(), 16.0f), 0, DisplayUtils.dip2px(getContext(), 12.0f), 0);
        } else if (i == i2) {
            setPadding(DisplayUtils.dip2px(getContext(), 12.0f), 0, DisplayUtils.dip2px(getContext(), 20.0f), 0);
        } else {
            setPadding(DisplayUtils.dip2px(getContext(), 12.0f), 0, DisplayUtils.dip2px(getContext(), 12.0f), 0);
        }
    }

    /* renamed from: a */
    private void m33103a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_item_business_classify_tab, this);
        this.f44579a = (TextView) findViewById(R.id.customer_tv_business_classify_name);
    }
}
