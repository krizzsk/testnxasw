package com.didi.soda.customer.widget.headerview.tabitem.p166dy;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import com.didi.soda.customer.widget.headerview.tabitem.ITab;
import com.taxis99.R;

/* renamed from: com.didi.soda.customer.widget.headerview.tabitem.dy.BusinessDyClassifyTab */
public class BusinessDyClassifyTab extends ConstraintLayout implements ITab<BusinessCategoryRvModel> {

    /* renamed from: a */
    private TextView f44582a;

    /* renamed from: b */
    private CharSequence f44583b;

    /* renamed from: c */
    private CharSequence f44584c;

    public BusinessDyClassifyTab(Context context) {
        super(context);
        m33105a();
    }

    public BusinessDyClassifyTab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33105a();
    }

    public BusinessDyClassifyTab(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33105a();
    }

    public void setSelectedState(boolean z, boolean z2) {
        if (!z || !z2) {
            this.f44582a.setSelected(false);
            this.f44582a.setText(this.f44584c);
            return;
        }
        this.f44582a.setSelected(true);
        this.f44582a.setText(this.f44583b);
    }

    public void updateTabView(BusinessCategoryRvModel businessCategoryRvModel, int i, int i2) {
        this.f44583b = businessCategoryRvModel.mSelectedCateName;
        this.f44584c = businessCategoryRvModel.mUnSelectedCateName;
        if (i == 0) {
            setPadding(DisplayUtils.dip2px(getContext(), 0.0f), 0, DisplayUtils.dip2px(getContext(), 0.0f), 0);
        } else if (i == i2 - 1) {
            setPadding(DisplayUtils.dip2px(getContext(), 0.0f), 0, DisplayUtils.dip2px(getContext(), 10.0f), 0);
        } else {
            setPadding(DisplayUtils.dip2px(getContext(), 0.0f), 0, DisplayUtils.dip2px(getContext(), 0.0f), 0);
        }
    }

    /* renamed from: a */
    private void m33105a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_item_business_dy_classify_tab, this);
        this.f44582a = (TextView) findViewById(R.id.customer_tv_business_classify_name);
    }
}
