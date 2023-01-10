package com.didi.soda.business.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.business.model.BusinessHeaderRvModel;
import com.didi.soda.customer.listener.OnBackListener;
import com.taxis99.R;

public class BusinessDyStickyNavigationView extends ConstraintLayout {

    /* renamed from: a */
    private static final String f42404a = "BusinessDyStickyNavigationView";
    @BindView(18370)
    RFIconView mCloseIcon;
    @BindView(17859)
    public ConstraintLayout mSearchDescContainer;
    @BindView(18372)
    RFIconView mSearchIcon;
    @BindView(17857)
    ConstraintLayout mTitleContainer;

    public BusinessDyStickyNavigationView(Context context) {
        super(context);
        m31905a();
    }

    public BusinessDyStickyNavigationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m31905a();
    }

    public BusinessDyStickyNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m31905a();
    }

    public int getNavigationTitleHeight() {
        return this.mTitleContainer.getHeight();
    }

    public void setOnBackListener(OnBackListener onBackListener) {
        this.mCloseIcon.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OnBackListener.this.onBack(0);
            }
        });
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.mSearchDescContainer.setOnClickListener(onClickListener);
        this.mSearchIcon.setOnClickListener(onClickListener);
    }

    public void updateBusinessHeaderView(BusinessHeaderRvModel businessHeaderRvModel) {
        m31906a(businessHeaderRvModel);
        setVisibility(0);
    }

    /* renamed from: a */
    private void m31906a(BusinessHeaderRvModel businessHeaderRvModel) {
        ConstraintLayout constraintLayout = this.mTitleContainer;
        constraintLayout.setPadding(constraintLayout.getPaddingLeft(), businessHeaderRvModel.mDynamicPadding + DisplayUtils.dip2px(getContext(), 12.0f), this.mTitleContainer.getPaddingRight(), this.mTitleContainer.getPaddingBottom() + DisplayUtils.dip2px(getContext(), 7.0f));
    }

    /* renamed from: a */
    private void m31905a() {
        ButterKnife.bind((Object) this, LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_dy_business_sticky_navigation, this, true));
        setClickable(false);
    }
}
