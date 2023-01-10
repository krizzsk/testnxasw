package com.didi.soda.business.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.didi.soda.business.listener.BusinessSelectedCallback;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import com.didi.soda.business.model.BusinessHeaderRvModel;
import com.didi.soda.business.widget.BusinessDyHomeHeaderView;
import com.didi.soda.customer.widget.headerview.CustomerTabLayout;
import com.didi.soda.customer.widget.headerview.OnMoreCategoryListener;
import com.didi.soda.customer.widget.headerview.OnTabExposureListener;
import com.didi.soda.customer.widget.headerview.OnTabSelectedListener;
import com.didi.soda.customer.widget.headerview.TabAdapter;
import com.didi.soda.customer.widget.headerview.tabitem.ITab;
import com.didi.soda.customer.widget.headerview.tabitem.p166dy.BusinessDyClassifyTab;
import com.taxis99.R;
import java.util.List;

public class BusinessDyClassifyBLayout extends ConstraintLayout {

    /* renamed from: a */
    private static final String f42372a = "BusinessDyClassifyBLayout";

    /* renamed from: b */
    private BusinessDyHomeHeaderView.OnBusinessTabItemListener f42373b;

    /* renamed from: c */
    private OnMoreCategoryListener f42374c;
    public BusinessCategoryRvModel currentCategoryRvModel;
    @BindView(17916)
    CustomerTabLayout mClassifyTab;
    @BindView(18138)
    public View mMenuContainer;

    public BusinessDyClassifyBLayout(Context context) {
        super(context);
        m31882b();
    }

    public BusinessDyClassifyBLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m31882b();
    }

    public BusinessDyClassifyBLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m31882b();
    }

    public void setCategoryClickListener(OnMoreCategoryListener onMoreCategoryListener) {
        this.f42374c = onMoreCategoryListener;
    }

    public void setTabItemListener(BusinessDyHomeHeaderView.OnBusinessTabItemListener onBusinessTabItemListener) {
        this.f42373b = onBusinessTabItemListener;
    }

    public void setOnCategoryTouchListener(View.OnTouchListener onTouchListener) {
        this.mClassifyTab.setOnTouchListener(onTouchListener);
    }

    public void setOnCategoryScrollListener(CustomerTabLayout.OnScollChangedListener onScollChangedListener) {
        this.mClassifyTab.setCustomerOnScrollChanedListener(onScollChangedListener);
    }

    public void updateBusinessCategoryData(BusinessHeaderRvModel businessHeaderRvModel) {
        setVisibility(0);
        m31879a(businessHeaderRvModel);
    }

    public void selectTab(int i) {
        CustomerTabLayout customerTabLayout = this.mClassifyTab;
        if (customerTabLayout != null) {
            customerTabLayout.selectTab(i);
        }
    }

    public void selectTab(int i, boolean z) {
        CustomerTabLayout customerTabLayout = this.mClassifyTab;
        if (customerTabLayout != null) {
            customerTabLayout.selectTab(i, z);
        }
    }

    /* renamed from: a */
    private void m31876a(int i, BusinessCategoryRvModel businessCategoryRvModel) {
        BusinessDyHomeHeaderView.OnBusinessTabItemListener onBusinessTabItemListener = this.f42373b;
        if (onBusinessTabItemListener != null) {
            onBusinessTabItemListener.onTabItemExposure(i, businessCategoryRvModel);
        }
    }

    /* renamed from: a */
    private void m31877a(int i, BusinessCategoryRvModel businessCategoryRvModel, boolean z, boolean z2) {
        BusinessDyHomeHeaderView.OnBusinessTabItemListener onBusinessTabItemListener = this.f42373b;
        if (onBusinessTabItemListener != null) {
            onBusinessTabItemListener.onTabItemSelected(i, businessCategoryRvModel, z, z2);
        }
    }

    public void showClassifyTabSelectedColor(boolean z) {
        this.mClassifyTab.setShowSelectedItemColor(z);
    }

    /* renamed from: a */
    private void m31879a(final BusinessHeaderRvModel businessHeaderRvModel) {
        if (businessHeaderRvModel.mCategoryList == null || businessHeaderRvModel.mCategoryList.isEmpty()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.mClassifyTab.setTabAdapter(new TabAdapter<BusinessCategoryRvModel>() {
            public ITab<BusinessCategoryRvModel> getItemView(int i) {
                return new BusinessDyClassifyTab(BusinessDyClassifyBLayout.this.getContext());
            }

            public int getItemCount() {
                if (businessHeaderRvModel.mCategoryList == null) {
                    return 0;
                }
                return businessHeaderRvModel.mCategoryList.size();
            }

            public List<BusinessCategoryRvModel> getData() {
                return businessHeaderRvModel.mCategoryList;
            }
        });
        this.mClassifyTab.setOnTabSelectedListener(new OnTabSelectedListener(businessHeaderRvModel) {
            public final /* synthetic */ BusinessHeaderRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onTabSelected(int i, boolean z, boolean z2) {
                BusinessDyClassifyBLayout.this.m31881a(this.f$1, i, z, z2);
            }
        });
        this.mClassifyTab.setOnTabExposureListener(new OnTabExposureListener(businessHeaderRvModel) {
            public final /* synthetic */ BusinessHeaderRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onTabItemExposure(int i) {
                BusinessDyClassifyBLayout.this.m31880a(this.f$1, i);
            }
        });
        if (businessHeaderRvModel.mCategoryList.size() >= 4) {
            this.mMenuContainer.setVisibility(0);
            this.mMenuContainer.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    BusinessDyClassifyBLayout.this.m31878a(view);
                }
            });
            m31874a();
            return;
        }
        this.mMenuContainer.setVisibility(8);
        this.mMenuContainer.setOnClickListener((View.OnClickListener) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31881a(BusinessHeaderRvModel businessHeaderRvModel, int i, boolean z, boolean z2) {
        if (i >= 0 && i < businessHeaderRvModel.mCategoryList.size() && businessHeaderRvModel.mCategoryList.get(i) != null) {
            this.currentCategoryRvModel = businessHeaderRvModel.mCategoryList.get(i);
            m31877a(i, businessHeaderRvModel.mCategoryList.get(i), z, z2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31880a(BusinessHeaderRvModel businessHeaderRvModel, int i) {
        if (i >= 0 && i < businessHeaderRvModel.mCategoryList.size() && businessHeaderRvModel.mCategoryList.get(i) != null) {
            m31876a(i, businessHeaderRvModel.mCategoryList.get(i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31878a(View view) {
        if (this.f42374c != null) {
            this.f42374c.onClickMoreCategoryListener(new BusinessSelectedCallback() {
                public final void onSelectedCategory(int i) {
                    BusinessDyClassifyBLayout.this.m31875a(i);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31875a(int i) {
        this.mClassifyTab.selectTab(i, false);
    }

    /* renamed from: a */
    private void m31874a() {
        BusinessDyHomeHeaderView.OnBusinessTabItemListener onBusinessTabItemListener = this.f42373b;
        if (onBusinessTabItemListener != null) {
            onBusinessTabItemListener.onMoreTabExposure();
        }
    }

    /* renamed from: b */
    private void m31882b() {
        ButterKnife.bind((Object) this, LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_dy_business_classify_b, this, true));
        setClickable(false);
    }
}
