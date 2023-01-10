package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Guideline;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.bill.widgets.CustomerHorizontalScrollView;
import com.didi.soda.customer.foundation.util.BitmapUtil;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.CouponTagFlowLayoutView;
import com.didi.soda.customer.widget.CustomerFixLineHeightTextView;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.didi.soda.home.topgun.widget.BaseBusinessItemView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class BaseBusinessItemView extends ConstraintLayout {

    /* renamed from: c */
    private static final int f45520c = 1;

    /* renamed from: d */
    private static final int f45521d = 2;

    /* renamed from: e */
    private static final int f45522e = 3;

    /* renamed from: f */
    private static final int f45523f = 4;

    /* renamed from: g */
    private static final int f45524g = 5;

    /* renamed from: h */
    private static final int f45525h = 6;

    /* renamed from: a */
    private Drawable f45526a;

    /* renamed from: b */
    private int f45527b;

    /* renamed from: i */
    private SparseArray<View> f45528i = new SparseArray<>();
    @BindView(18610)
    CouponTagFlowLayoutView mActTipNfl;
    @BindView(18428)
    ImageView mBgImgIv;
    @BindView(17997)
    HomeBusinessExceptionStatusView mBusinessExceptionStatusView;
    @BindView(18993)
    TextView mBuyingAgentTv;
    @BindView(18311)
    CustomerHorizontalScrollView mCateInfoContainerHs;
    @BindView(18994)
    TextView mCateInfoTv;
    @BindView(19217)
    View mCateLeftMaskView;
    @BindView(19218)
    View mCateRightMaskView;
    @BindView(18312)
    CustomerHorizontalScrollView mDeliveryDescContainerHs;
    @BindView(18995)
    TextView mDeliveryInfoTv;
    @BindView(19223)
    View mDeliveryLeftMaskView;
    @BindView(19224)
    View mDeliveryRightMaskView;
    @BindView(19237)
    View mExceptionStatusMask;
    @BindView(18231)
    Guideline mGideLine;
    @BindView(19247)
    View mItemMaskContainer;
    @BindView(17998)
    HomeLogoPromotionView mLogoAndPromContainer;
    @BindView(18996)
    CustomerFixLineHeightTextView mNameTv;
    @BindView(17820)
    ConstraintLayout mRoot;
    @BindView(18997)
    TextView mShopTipTv;

    public interface BusinessItemViewInterface {
        void onItemClick(HomeBusinessInfoRvModel homeBusinessInfoRvModel);
    }

    /* access modifiers changed from: protected */
    public int getResId() {
        return R.layout.customer_binder_home_business;
    }

    public BaseBusinessItemView(Context context) {
        super(context);
        m33820a();
    }

    public BaseBusinessItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33820a();
    }

    public BaseBusinessItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33820a();
    }

    /* access modifiers changed from: protected */
    public void bindData(HomeBusinessInfoRvModel homeBusinessInfoRvModel, BusinessItemViewInterface businessItemViewInterface) {
        m33826b();
        ArrayList arrayList = new ArrayList();
        if (homeBusinessInfoRvModel.mMask) {
            this.mBusinessExceptionStatusView.updateExceptionStatus(homeBusinessInfoRvModel.mShopStatus, homeBusinessInfoRvModel.mBusinessNextOpenTimeDesc);
            this.mExceptionStatusMask.setVisibility(0);
            this.mBusinessExceptionStatusView.setVisibility(0);
        } else {
            this.mExceptionStatusMask.setVisibility(8);
            this.mBusinessExceptionStatusView.setVisibility(8);
        }
        this.mLogoAndPromContainer.bindData(homeBusinessInfoRvModel.mPromotionImg, homeBusinessInfoRvModel.mLogoImg);
        FlyImageLoader.loadImage4x3(getContext(), homeBusinessInfoRvModel.mBgImg).placeholder(this.f45526a).error(this.f45526a).transform(new RoundedCornersTransformation(getContext(), this.f45527b, 0, RoundedCornersTransformation.CornerType.ALL, true)).into(this.mBgImgIv);
        m33823a(homeBusinessInfoRvModel);
        arrayList.add(1);
        this.mItemMaskContainer.setOnClickListener(new View.OnClickListener(homeBusinessInfoRvModel) {
            public final /* synthetic */ HomeBusinessInfoRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                BaseBusinessItemView.BusinessItemViewInterface.this.onItemClick(this.f$1);
            }
        });
        this.mCateInfoTv.setOnClickListener(new View.OnClickListener(homeBusinessInfoRvModel) {
            public final /* synthetic */ HomeBusinessInfoRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                BaseBusinessItemView.BusinessItemViewInterface.this.onItemClick(this.f$1);
            }
        });
        this.mDeliveryInfoTv.setOnClickListener(new View.OnClickListener(homeBusinessInfoRvModel) {
            public final /* synthetic */ HomeBusinessInfoRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                BaseBusinessItemView.BusinessItemViewInterface.this.onItemClick(this.f$1);
            }
        });
        if (!TextUtils.isEmpty(homeBusinessInfoRvModel.mShopCateInfoDesc)) {
            if (this.mCateInfoTv.getPaint().measureText(homeBusinessInfoRvModel.mShopCateInfoDesc.toString()) > ((float) getViewWidth())) {
                this.mCateRightMaskView.setVisibility(0);
            } else {
                this.mCateRightMaskView.setVisibility(8);
            }
            this.mCateInfoContainerHs.setVisibility(0);
            arrayList.add(2);
            this.mCateInfoTv.setText(homeBusinessInfoRvModel.mShopCateInfoDesc);
        } else {
            this.mCateInfoContainerHs.setVisibility(8);
            this.mCateRightMaskView.setVisibility(8);
            this.mCateInfoTv.setText("");
        }
        this.mCateLeftMaskView.setVisibility(8);
        if (!TextUtils.isEmpty(homeBusinessInfoRvModel.mBuyAgentDesc)) {
            arrayList.add(3);
            this.mBuyingAgentTv.setVisibility(0);
            this.mBuyingAgentTv.setText(homeBusinessInfoRvModel.mBuyAgentDesc);
        } else {
            this.mBuyingAgentTv.setVisibility(8);
        }
        if (!TextUtils.isEmpty(homeBusinessInfoRvModel.mDeliveryDesc)) {
            if (this.mDeliveryInfoTv.getPaint().measureText(homeBusinessInfoRvModel.mDeliveryDesc.toString()) > ((float) getViewWidth())) {
                this.mDeliveryRightMaskView.setVisibility(0);
            } else {
                this.mDeliveryRightMaskView.setVisibility(8);
            }
            this.mDeliveryInfoTv.setText(homeBusinessInfoRvModel.mDeliveryDesc);
            this.mDeliveryDescContainerHs.setVisibility(0);
            arrayList.add(4);
        } else {
            this.mDeliveryDescContainerHs.setVisibility(8);
            this.mDeliveryRightMaskView.setVisibility(8);
        }
        this.mDeliveryLeftMaskView.setVisibility(8);
        if (TextUtils.isEmpty(homeBusinessInfoRvModel.mShopTip)) {
            this.mShopTipTv.setVisibility(8);
        } else {
            this.mShopTipTv.setText(homeBusinessInfoRvModel.mShopTip);
            this.mShopTipTv.setVisibility(0);
            arrayList.add(5);
        }
        if (!CollectionsUtil.isEmpty(homeBusinessInfoRvModel.mActEntityList)) {
            this.mActTipNfl.setData(homeBusinessInfoRvModel.mActEntityList, getViewWidth());
            for (int i = 0; i < this.mActTipNfl.getLineCounts(); i++) {
                arrayList.add(6);
            }
            this.mActTipNfl.setVisibility(0);
        } else {
            this.mActTipNfl.setVisibility(8);
        }
        m33825a((List<Integer>) arrayList);
    }

    /* access modifiers changed from: protected */
    public int getViewWidth() {
        return CustomerSystemUtil.getScreenWidth(getContext()) - DisplayUtils.dip2px(getContext(), 180.0f);
    }

    /* renamed from: a */
    private void m33823a(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        this.mNameTv.getPaint().setTextSize((float) DisplayUtils.dip2px(getContext(), 18.0f));
        this.mNameTv.setTextSize(1, (float) 16);
        this.mNameTv.setLineSpacingExtra(DisplayUtils.dip2px(getContext(), 2.5f));
        this.mNameTv.setCustomText(homeBusinessInfoRvModel.mShopName);
    }

    /* renamed from: a */
    private void m33820a() {
        View inflate = LayoutInflater.from(getContext()).inflate(getResId(), this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ButterKnife.bind((Object) this, inflate);
        this.f45528i.put(2, this.mCateInfoContainerHs);
        this.f45528i.put(3, this.mBuyingAgentTv);
        this.f45528i.put(4, this.mDeliveryDescContainerHs);
        this.f45528i.put(5, this.mShopTipTv);
        this.f45528i.put(6, this.mActTipNfl);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mNameTv, IToolsService.FontType.MEDIUM);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mCateInfoTv, IToolsService.FontType.LIGHT);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mDeliveryInfoTv, IToolsService.FontType.LIGHT);
        this.mCateInfoContainerHs.setOnScrollChangeListener(new CustomerHorizontalScrollView.OnScrollChangeListener() {
            public void onScrollStateChanged(HorizontalScrollView horizontalScrollView, int i) {
            }

            public void onScrollChanged(int i, int i2, int i3, int i4) {
                int measuredWidth = BaseBusinessItemView.this.mCateInfoContainerHs.getChildAt(0).getMeasuredWidth() - BaseBusinessItemView.this.mCateInfoContainerHs.getMeasuredWidth();
                if (i == 0) {
                    BaseBusinessItemView.this.mCateLeftMaskView.setVisibility(8);
                } else if (i != measuredWidth) {
                    BaseBusinessItemView.this.mCateLeftMaskView.setVisibility(0);
                    BaseBusinessItemView.this.mCateRightMaskView.setVisibility(0);
                } else if (BaseBusinessItemView.this.mCateRightMaskView.getVisibility() == 0) {
                    BaseBusinessItemView.this.mCateRightMaskView.setVisibility(8);
                }
            }
        });
        this.mDeliveryDescContainerHs.setOnScrollChangeListener(new CustomerHorizontalScrollView.OnScrollChangeListener() {
            public void onScrollStateChanged(HorizontalScrollView horizontalScrollView, int i) {
            }

            public void onScrollChanged(int i, int i2, int i3, int i4) {
                int measuredWidth = BaseBusinessItemView.this.mDeliveryDescContainerHs.getChildAt(0).getMeasuredWidth() - BaseBusinessItemView.this.mDeliveryDescContainerHs.getMeasuredWidth();
                if (i == 0) {
                    BaseBusinessItemView.this.mDeliveryLeftMaskView.setVisibility(8);
                } else if (i != measuredWidth) {
                    BaseBusinessItemView.this.mDeliveryLeftMaskView.setVisibility(0);
                    BaseBusinessItemView.this.mDeliveryRightMaskView.setVisibility(0);
                } else if (BaseBusinessItemView.this.mDeliveryRightMaskView.getVisibility() == 0) {
                    BaseBusinessItemView.this.mDeliveryRightMaskView.setVisibility(8);
                }
            }
        });
        this.f45527b = DisplayUtils.dip2px(getContext(), 4.0f);
        this.f45526a = BitmapUtil.getRoundedDrawable(getContext(), R.drawable.customer_skin_img_topgun_placeholder_business_item, this.f45527b);
    }

    /* renamed from: a */
    private void m33825a(List<Integer> list) {
        int size = list.size();
        if (size > 3) {
            int intValue = list.get(1).intValue();
            if (intValue != 2) {
                m33821a(this.f45528i.get(intValue));
            }
        } else if (size == 3) {
            setAglinToBottom(this.f45528i.get(list.get(2).intValue()));
            if (list.get(1).intValue() != 2 && list.get(1).intValue() != list.get(2).intValue()) {
                m33822a(this.f45528i.get(list.get(1).intValue()), this.f45528i.get(list.get(2).intValue()));
            }
        } else if (size == 2 && list.get(1).intValue() != 2) {
            setAglinToBottom(this.f45528i.get(list.get(1).intValue()));
        }
    }

    /* renamed from: b */
    private void m33826b() {
        m33827b(this.mBuyingAgentTv, this.mCateInfoContainerHs);
        m33827b(this.mDeliveryDescContainerHs, this.mBuyingAgentTv);
        m33827b(this.mShopTipTv, this.mDeliveryDescContainerHs);
        m33827b(this.mActTipNfl, this.mShopTipTv);
    }

    private void setAglinToBottom(View view) {
        int visibility = view.getVisibility();
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.mRoot);
        constraintSet.clear(view.getId());
        constraintSet.constrainHeight(view.getId(), -2);
        constraintSet.connect(view.getId(), 7, 0, 7);
        constraintSet.connect(view.getId(), 6, this.mGideLine.getId(), 7);
        constraintSet.connect(view.getId(), 4, this.mBgImgIv.getId(), 4, getResources().getDimensionPixelSize(R.dimen.customer_6px));
        constraintSet.setVisibility(view.getId(), visibility);
        constraintSet.applyTo(this.mRoot);
        view.setTag(true);
    }

    /* renamed from: a */
    private void m33822a(View view, View view2) {
        int visibility = view.getVisibility();
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.mRoot);
        constraintSet.clear(view.getId());
        constraintSet.constrainHeight(view.getId(), -2);
        constraintSet.connect(view.getId(), 7, 0, 7);
        constraintSet.connect(view.getId(), 6, this.mGideLine.getId(), 7);
        constraintSet.connect(view.getId(), 4, view2.getId(), 3, getResources().getDimensionPixelSize(R.dimen.customer_14px));
        constraintSet.setVisibility(view.getId(), visibility);
        constraintSet.applyTo(this.mRoot);
        view.setTag(true);
    }

    /* renamed from: a */
    private void m33821a(View view) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.mRoot);
        constraintSet.setMargin(view.getId(), 3, getResources().getDimensionPixelSize(R.dimen.customer_20px));
        constraintSet.applyTo(this.mRoot);
        view.setTag(true);
    }

    /* renamed from: b */
    private void m33827b(View view, View view2) {
        if (view.getTag() != null) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this.mRoot);
            constraintSet.clear(view.getId());
            constraintSet.constrainHeight(view.getId(), -2);
            constraintSet.connect(view.getId(), 7, 0, 7);
            constraintSet.connect(view.getId(), 6, this.mGideLine.getId(), 7);
            constraintSet.connect(view.getId(), 3, view2.getId(), 4, getResources().getDimensionPixelSize(R.dimen.customer_14px));
            constraintSet.applyTo(this.mRoot);
            view.setTag((Object) null);
        }
    }
}
