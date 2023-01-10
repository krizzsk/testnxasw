package com.didi.soda.order.component.evaluate;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.address.AndroidBug5497Workaround;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationItemsListEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationResultEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.RiderEvaluationEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.ShopEvaluationEntity;
import com.didi.soda.customer.foundation.util.ClickUtils;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalView;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.didi.soda.order.component.evaluate.Contract;
import com.didi.soda.order.omega.EvaluateOmegaHelper;
import com.didi.soda.order.view.OrderEvaluateBusinessItemView;
import com.didi.soda.order.view.OrderEvaluateCommentTagView;
import com.didi.soda.order.view.OrderEvaluateFaceView;
import com.didi.soda.order.view.OrderEvaluateHeaderInfoView;
import com.didi.soda.order.view.OrderEvaluateScoreView;
import com.didi.soda.order.view.upload.pic.ImageUploadFlowLayout;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class OrderEvaluateView extends Contract.AbsOrderEvaluatingView {

    /* renamed from: a */
    private static final String f45944a = "OrderEvaluateView";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public OrderEvaluationEntity f45945b;

    /* renamed from: c */
    private View f45946c;

    /* renamed from: d */
    private int f45947d = -1;

    /* renamed from: e */
    private int f45948e;

    /* renamed from: f */
    private boolean f45949f = true;

    /* renamed from: g */
    private int f45950g = 0;
    @BindView(17816)
    LinearLayout itemEvaluateLinear;
    @BindView(17984)
    TopGunAbnormalView mAbnormalView;
    @BindView(18464)
    View mBackView;
    @BindView(17804)
    OrderEvaluateCommentTagView mBusinessCommentTagView;
    @BindView(17813)
    OrderEvaluateHeaderInfoView mBusinessHeaderInfoView;
    @BindView(17822)
    OrderEvaluateScoreView mBusinessScoreView;
    @BindView(17802)
    TextView mBusinessSupplementTip;
    @BindView(18147)
    View mButtonContainer;
    @BindView(18730)
    ScrollView mContentContainer;
    @BindView(18640)
    OrderEvaluateCommentTagView mRiderCommentTagView;
    @BindView(18643)
    OrderEvaluateFaceView mRiderFaceView;
    @BindView(18644)
    OrderEvaluateHeaderInfoView mRiderHeaderInfoView;
    @BindView(18639)
    TextView mRiderSupplementTip;
    @BindView(18575)
    View mRootContainer;
    @BindView(17792)
    RFMainButton mSubmitBtn;

    public void initEvaluationView(int i, OrderEvaluationEntity orderEvaluationEntity) {
        if (orderEvaluationEntity != null) {
            if ((orderEvaluationEntity.rider != null && orderEvaluationEntity.rider.hasEval) || (orderEvaluationEntity.shop != null && orderEvaluationEntity.shop.hasEval)) {
                this.f45950g = 1;
            }
            this.f45945b = orderEvaluationEntity;
            this.mButtonContainer.setVisibility(0);
            this.mContentContainer.setVisibility(0);
            m34090a(i, orderEvaluationEntity);
            m34092a(orderEvaluationEntity);
            m34089a();
            this.mSubmitBtn.setText(getResources().getString(R.string.customer_order_evaluated_submit));
        }
    }

    /* renamed from: a */
    private void m34090a(int i, OrderEvaluationEntity orderEvaluationEntity) {
        final ShopEvaluationEntity shopEvaluationEntity = orderEvaluationEntity.shop;
        if (!CollectionsUtil.isEmpty(this.f45945b.items)) {
            this.itemEvaluateLinear.removeAllViews();
            for (OrderEvaluationItemsListEntity next : this.f45945b.items) {
                final OrderEvaluateBusinessItemView orderEvaluateBusinessItemView = new OrderEvaluateBusinessItemView(this.itemEvaluateLinear.getContext(), next.getItemId(), next.getItemName(), next.getItemImg());
                orderEvaluateBusinessItemView.setEvaluateclickLisener(new OrderEvaluateBusinessItemView.itemEvaluateClickLisener() {
                    public void clickPraise() {
                        orderEvaluateBusinessItemView.setPraiseFilled();
                        EvaluateOmegaHelper.Companion.trackEvaluatePageLikeCk(0, 10);
                    }

                    public void clickPoor() {
                        orderEvaluateBusinessItemView.setPoorFilled();
                        EvaluateOmegaHelper.Companion.trackEvaluatePageLikeCk(0, 2);
                    }
                });
                this.itemEvaluateLinear.addView(orderEvaluateBusinessItemView);
            }
        }
        if (shopEvaluationEntity != null) {
            this.mBusinessHeaderInfoView.setHeaderTitle(ResourceHelper.getString(R.string.customer_order_no_evaluation_business_title));
            this.mBusinessHeaderInfoView.setEvaluateHeaderImage(shopEvaluationEntity.shopImg, R.drawable.customer_img_default_shop);
            this.mBusinessHeaderInfoView.setNameImage(shopEvaluationEntity.shopName, 2);
            this.mBusinessCommentTagView.setCommentHint(shopEvaluationEntity.defaultContent);
            int i2 = shopEvaluationEntity.hasEvalScore;
            if (i2 == 100) {
                i = 1;
            } else if (i2 == 200) {
                i = 2;
            } else if (i2 == 300) {
                i = 3;
            } else if (i2 == 400) {
                i = 4;
            } else if (i2 == 500) {
                i = 5;
            }
            this.mBusinessScoreView.setScoreInfo(i, shopEvaluationEntity.scoreInfo);
            if (i > 0) {
                this.mBusinessScoreView.setOnInterceptClickListener(new OrderEvaluateScoreView.OnInterceptClickListener() {
                    public boolean onInterceptTouch() {
                        if (shopEvaluationEntity.hasEvalScore <= 0) {
                            return false;
                        }
                        ToastUtil.showCustomerToast(OrderEvaluateView.this.getScopeContext(), OrderEvaluateView.this.getString(R.string.FoodC_improve__SrXh));
                        return true;
                    }
                });
                int i3 = i - 1;
                this.f45947d = i3;
                if (i3 >= 3) {
                    this.mBusinessCommentTagView.setTagList((List<Integer>) null, shopEvaluationEntity.goodTag);
                    this.mBusinessSupplementTip.setText(shopEvaluationEntity.defaultGoodTagContent);
                    if (this.f45947d == 4 && !CollectionsUtil.isEmpty(this.f45945b.items)) {
                        int childCount = this.itemEvaluateLinear.getChildCount();
                        for (int i4 = 0; i4 < childCount; i4++) {
                            ((OrderEvaluateBusinessItemView) this.itemEvaluateLinear.getChildAt(i4)).setPraiseFilled();
                        }
                    }
                } else {
                    this.mBusinessCommentTagView.setTagList((List<Integer>) null, shopEvaluationEntity.badTag);
                    this.mBusinessSupplementTip.setText(shopEvaluationEntity.defaultBadTagContent);
                }
                if (!TextUtils.isEmpty(this.mBusinessSupplementTip.getText())) {
                    this.mBusinessSupplementTip.setVisibility(0);
                } else {
                    this.mBusinessSupplementTip.setVisibility(8);
                }
                this.mBusinessCommentTagView.setVisibility(0);
                if (!CollectionsUtil.isEmpty(this.f45945b.items)) {
                    this.itemEvaluateLinear.setVisibility(0);
                }
                this.mBusinessCommentTagView.setRootVisible();
            }
        }
    }

    /* renamed from: a */
    private void m34092a(OrderEvaluationEntity orderEvaluationEntity) {
        RiderEvaluationEntity riderEvaluationEntity = orderEvaluationEntity.rider;
        if (riderEvaluationEntity != null) {
            this.mRiderHeaderInfoView.setHeaderTitle(ResourceHelper.getString(R.string.customer_order_no_evaluation_rider_title));
            this.mRiderHeaderInfoView.setEvaluateHeaderImage(riderEvaluationEntity.riderImg, R.drawable.customer_img_default_rider);
            this.mRiderHeaderInfoView.setNameImage(riderEvaluationEntity.riderName, 1);
            this.mRiderHeaderInfoView.setContentText(riderEvaluationEntity.orderFinishTime);
            this.mRiderCommentTagView.setCommentHint(riderEvaluationEntity.defaultContent);
            this.mRiderFaceView.setScoreInfo(riderEvaluationEntity.hasEvalScore, riderEvaluationEntity.scoreInfo);
            if (riderEvaluationEntity.hasEvalScore > 0) {
                if (riderEvaluationEntity.hasEvalScore == 10) {
                    this.f45948e = 1;
                } else {
                    this.f45948e = 0;
                }
                this.mRiderCommentTagView.setVisibility(0);
                this.mRiderCommentTagView.setOnInterceptClickListener(new OrderEvaluateScoreView.OnInterceptClickListener() {
                    public boolean onInterceptTouch() {
                        if (CollectionsUtil.isEmpty(OrderEvaluateView.this.f45945b.rider.hasEvalTags)) {
                            return false;
                        }
                        ToastUtil.showCustomerToast(OrderEvaluateView.this.getScopeContext(), OrderEvaluateView.this.getString(R.string.FoodC_improve__SrXh));
                        return true;
                    }
                });
                if (this.f45948e == 0) {
                    this.mRiderCommentTagView.setTagList(riderEvaluationEntity.hasEvalTags, riderEvaluationEntity.badTag);
                    this.mRiderSupplementTip.setText(riderEvaluationEntity.defaultBadTagContent);
                } else {
                    this.mRiderCommentTagView.setTagList(riderEvaluationEntity.hasEvalTags, riderEvaluationEntity.goodTag);
                    this.mRiderSupplementTip.setText(riderEvaluationEntity.defaultGoodTagContent);
                }
                if (!TextUtils.isEmpty(this.mRiderSupplementTip.getText())) {
                    this.mRiderSupplementTip.setVisibility(0);
                } else {
                    this.mRiderSupplementTip.setVisibility(8);
                }
                this.mRiderCommentTagView.setRootVisible();
            }
        }
    }

    public void addUploadImageView(String str, String str2) {
        this.mBusinessCommentTagView.addUploadImageView(str, str2);
    }

    public void showErrorNetView(String str) {
        this.mAbnormalView.setVisibility(0);
        this.mAbnormalView.show(m34088a(str));
    }

    public void hideAbnormalView() {
        this.mAbnormalView.setVisibility(8);
    }

    public void submitSuccess(OrderEvaluationResultEntity orderEvaluationResultEntity) {
        this.mBackView.setClickable(false);
        this.mSubmitBtn.setLoading(false);
        this.mSubmitBtn.setText("");
        this.mSubmitBtn.setLeftIcon(getDrawable(R.drawable.customer_icon_loading_success));
        ((Contract.AbsOrderEvaluatingPresenter) getPresenter()).closePage(true, orderEvaluationResultEntity);
    }

    public void submitError() {
        this.mSubmitBtn.setLoading(false);
        this.mSubmitBtn.setLeftIcon((Drawable) null);
        this.mSubmitBtn.setText(getResources().getString(R.string.customer_order_evaluated_submit));
    }

    public boolean isEditEvaluation() {
        return this.mRiderFaceView.getScore() > 0 || this.mBusinessScoreView.getScore() > 0;
    }

    public ShopEvaluationEntity getShopEvaluationEntity() {
        ShopEvaluationEntity shopEvaluationEntity = new ShopEvaluationEntity();
        shopEvaluationEntity.score = this.mBusinessScoreView.getScore();
        shopEvaluationEntity.content = this.mBusinessCommentTagView.getCommentContent();
        shopEvaluationEntity.tagIds = this.mBusinessCommentTagView.getChoiceTags();
        shopEvaluationEntity.imgs = this.mBusinessCommentTagView.getImageList();
        return shopEvaluationEntity;
    }

    public RiderEvaluationEntity getRiderEvaluationEntity() {
        RiderEvaluationEntity riderEvaluationEntity = new RiderEvaluationEntity();
        riderEvaluationEntity.content = this.mRiderCommentTagView.getCommentContent();
        riderEvaluationEntity.score = this.mRiderFaceView.getScore();
        riderEvaluationEntity.tagIds = this.mRiderCommentTagView.getChoiceTags();
        return riderEvaluationEntity;
    }

    public List<OrderEvaluationItemsListEntity> getGoodsEvaluationEntity() {
        ArrayList arrayList = new ArrayList();
        int childCount = this.itemEvaluateLinear.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                OrderEvaluationItemsListEntity orderEvaluationItemsListEntity = new OrderEvaluationItemsListEntity();
                orderEvaluationItemsListEntity.setItemId(((OrderEvaluateBusinessItemView) this.itemEvaluateLinear.getChildAt(i)).getItemId());
                orderEvaluationItemsListEntity.setScore(((OrderEvaluateBusinessItemView) this.itemEvaluateLinear.getChildAt(i)).getScore());
                arrayList.add(orderEvaluationItemsListEntity);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        this.mSubmitBtn.setEnabled(false);
        this.mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OrderEvaluateView.this.m34105e(view);
            }
        });
        this.mSubmitBtn.setOnDisableClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OrderEvaluateView.this.m34103d(view);
            }
        });
        this.mBusinessCommentTagView.setPhotoLayoutVisible(0);
        this.mBusinessCommentTagView.setPhotoLayoutListener(new ImageUploadFlowLayout.Companion.FlowLayoutListener() {
            public final void onAddBtnClick() {
                OrderEvaluateView.this.m34109i();
            }
        });
        this.mBusinessCommentTagView.setOnStatusChangeListener(new OrderEvaluateCommentTagView.OnSubmitStatusListener() {
            public final void onStatusChange() {
                OrderEvaluateView.this.m34089a();
            }
        });
        this.mRiderCommentTagView.setOnStatusChangeListener(new OrderEvaluateCommentTagView.OnSubmitStatusListener() {
            public final void onStatusChange() {
                OrderEvaluateView.this.m34089a();
            }
        });
        this.mBackView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OrderEvaluateView.this.m34101c(view);
            }
        });
        this.mRiderCommentTagView.setOnClickTagListener(new OrderEvaluateCommentTagView.OnClickTaglListener() {
            public void onClickTag(int i) {
                EvaluateOmegaHelper.Companion.trackEvaluatePageTagCk(1);
            }
        });
        this.mBusinessCommentTagView.setOnClickTagListener(new OrderEvaluateCommentTagView.OnClickTaglListener() {
            public void onClickTag(int i) {
                OrderEvaluateView.this.mContentContainer.smoothScrollTo(0, OrderEvaluateView.this.mBusinessCommentTagView.getTop() + ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_100));
                EvaluateOmegaHelper.Companion.trackEvaluatePageTagCk(0);
            }
        });
        this.mBusinessCommentTagView.getCommentView().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                EvaluateOmegaHelper.Companion.trackEvaluatePageTextCk(0);
            }
        });
        this.mRiderCommentTagView.getCommentView().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                EvaluateOmegaHelper.Companion.trackEvaluatePageTextCk(1);
            }
        });
        this.mBusinessScoreView.setOnStarClickListener(new OrderEvaluateScoreView.OnStarClickListener() {
            public final void onStarClick(int i) {
                OrderEvaluateView.this.m34097b(i);
            }
        });
        this.mRiderFaceView.setOnFaceClickListener(new OrderEvaluateFaceView.OnFaceClickListener() {
            public final boolean onFaceClick(int i) {
                return OrderEvaluateView.this.m34094a(i);
            }
        });
        m34100c();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m34105e(View view) {
        KeyboardUtils.hideSoftInput(getContext(), view);
        m34096b();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m34103d(View view) {
        KeyboardUtils.hideSoftInput(getContext(), view);
        m34091a(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void m34109i() {
        ((Contract.AbsOrderEvaluatingPresenter) getPresenter()).onUploadAddBtnClk();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m34101c(View view) {
        KeyboardUtils.hideSoftInput(getContext(), view);
        if (!ClickUtils.isFastClick()) {
            ((Contract.AbsOrderEvaluatingPresenter) getPresenter()).closePage(false, (OrderEvaluationResultEntity) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m34097b(int i) {
        EvaluateOmegaHelper.Companion.trackEvaluatePageRatingCk();
        if (this.f45947d != i) {
            this.f45947d = i;
            KeyboardUtils.hideSoftInput(getContext(), (View) null);
            if (i >= 3) {
                OrderEvaluationEntity orderEvaluationEntity = this.f45945b;
                if (!(orderEvaluationEntity == null || orderEvaluationEntity.shop == null)) {
                    ShopEvaluationEntity shopEvaluationEntity = this.f45945b.shop;
                    this.mBusinessCommentTagView.setTagList((List<Integer>) null, shopEvaluationEntity.goodTag);
                    this.mBusinessSupplementTip.setText(shopEvaluationEntity.defaultGoodTagContent);
                    if (i == 4 && !CollectionsUtil.isEmpty(this.f45945b.items) && this.f45949f) {
                        int childCount = this.itemEvaluateLinear.getChildCount();
                        for (int i2 = 0; i2 < childCount; i2++) {
                            ((OrderEvaluateBusinessItemView) this.itemEvaluateLinear.getChildAt(i2)).setPraiseFilled();
                        }
                        ToastUtil.showCustomerToast(getScopeContext(), ResourceHelper.getString(R.string.FoodC_improve__chkD));
                        this.f45949f = false;
                    }
                }
            } else {
                OrderEvaluationEntity orderEvaluationEntity2 = this.f45945b;
                if (!(orderEvaluationEntity2 == null || orderEvaluationEntity2.shop == null)) {
                    ShopEvaluationEntity shopEvaluationEntity2 = this.f45945b.shop;
                    this.mBusinessCommentTagView.setTagList((List<Integer>) null, shopEvaluationEntity2.badTag);
                    this.mBusinessSupplementTip.setText(shopEvaluationEntity2.defaultBadTagContent);
                }
            }
            if (!TextUtils.isEmpty(this.mBusinessSupplementTip.getText())) {
                this.mBusinessSupplementTip.setVisibility(0);
            } else {
                this.mBusinessSupplementTip.setVisibility(8);
            }
            this.mBusinessCommentTagView.setVisibility(0);
            this.mBusinessCommentTagView.setRootVisible();
            if (!CollectionsUtil.isEmpty(this.f45945b.items)) {
                this.itemEvaluateLinear.setVisibility(0);
            }
            UiHandlerUtil.postDelayed(new Runnable() {
                public final void run() {
                    OrderEvaluateView.this.m34108h();
                }
            }, 100);
            this.f45949f = false;
            m34089a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void m34108h() {
        this.mContentContainer.smoothScrollTo(0, this.mBusinessScoreView.getTop());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ boolean m34094a(int i) {
        OrderEvaluationEntity orderEvaluationEntity = this.f45945b;
        if (orderEvaluationEntity == null || orderEvaluationEntity.rider == null || this.f45945b.rider.hasEvalScore <= 0) {
            this.f45948e = i;
            KeyboardUtils.hideSoftInput(getContext(), (View) null);
            if (!this.mRiderCommentTagView.updateRiderScore(i)) {
                return false;
            }
            this.mRiderCommentTagView.setVisibility(0);
            if (i == 0) {
                OrderEvaluationEntity orderEvaluationEntity2 = this.f45945b;
                if (!(orderEvaluationEntity2 == null || orderEvaluationEntity2.rider == null)) {
                    RiderEvaluationEntity riderEvaluationEntity = this.f45945b.rider;
                    this.mRiderCommentTagView.setTagList((List<Integer>) null, riderEvaluationEntity.badTag);
                    this.mRiderSupplementTip.setText(riderEvaluationEntity.defaultBadTagContent);
                }
            } else {
                OrderEvaluationEntity orderEvaluationEntity3 = this.f45945b;
                if (!(orderEvaluationEntity3 == null || orderEvaluationEntity3.rider == null)) {
                    RiderEvaluationEntity riderEvaluationEntity2 = this.f45945b.rider;
                    this.mRiderCommentTagView.setTagList((List<Integer>) null, riderEvaluationEntity2.goodTag);
                    this.mRiderSupplementTip.setText(riderEvaluationEntity2.defaultGoodTagContent);
                }
            }
            if (!TextUtils.isEmpty(this.mRiderSupplementTip.getText())) {
                this.mRiderSupplementTip.setVisibility(0);
            } else {
                this.mRiderSupplementTip.setVisibility(8);
            }
            this.mRiderCommentTagView.setRootVisible();
            m34089a();
            EvaluateOmegaHelper.Companion.trackEvaluatePageLikeCk(1, i == 0 ? 2 : 10);
            return false;
        }
        ToastUtil.showCustomerToast(getScopeContext(), getString(R.string.FoodC_improve__SrXh));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34089a() {
        if (this.mBusinessScoreView.getScore() > 0 || this.mRiderFaceView.getScore() > 0) {
            if (CustomerApolloUtil.isSelectReason()) {
                if (this.f45947d <= 1 && TextUtils.isEmpty(this.mBusinessCommentTagView.getCommentContent()) && CollectionsUtil.isEmpty(this.mBusinessCommentTagView.getChoiceTags())) {
                    this.mSubmitBtn.setEnabled(false);
                    return;
                } else if (this.f45948e <= 0 && TextUtils.isEmpty(this.mRiderCommentTagView.getCommentContent()) && CollectionsUtil.isEmpty(this.mRiderCommentTagView.getChoiceTags())) {
                    this.mSubmitBtn.setEnabled(false);
                    return;
                }
            }
            this.mSubmitBtn.setEnabled(true);
            return;
        }
        this.mSubmitBtn.setEnabled(false);
    }

    /* renamed from: a */
    private void m34091a(View view) {
        EvaluateOmegaHelper.Companion.trackEvaluatePageCompleteCk(0, this.f45950g, 0, 0, this.mBusinessCommentTagView.getChoiceTags(), this.mRiderCommentTagView.getChoiceTags(), this.mBusinessCommentTagView.getCommentContent(), this.mRiderCommentTagView.getCommentContent(), this.mBusinessScoreView.getScore(), getGoodsEvaluationEntity(), this.mRiderFaceView.getScore());
        if (this.mBusinessScoreView.getScore() <= 0) {
            this.mContentContainer.scrollTo(0, 0);
            ToastUtil.showCustomerToast(getScopeContext(), ResourceHelper.getString(R.string.FoodC_comment_Please_evaluate_BHXx));
        } else if (this.mRiderFaceView.getScore() <= 0) {
            this.mContentContainer.post(new Runnable() {
                public final void run() {
                    OrderEvaluateView.this.m34107g();
                }
            });
            ToastUtil.showCustomerToast(getScopeContext(), ResourceHelper.getString(R.string.FoodC_comment_Please_evaluate_BHXx));
        } else if (!CustomerApolloUtil.isSelectReason()) {
        } else {
            if (this.f45947d <= 1 && TextUtils.isEmpty(this.mBusinessCommentTagView.getCommentContent()) && CollectionsUtil.isEmpty(this.mBusinessCommentTagView.getChoiceTags())) {
                ToastUtil.showCustomerToast(getScopeContext(), ResourceHelper.getString(R.string.FoodC_label_Please_select_chki));
                this.mContentContainer.scrollTo(0, 0);
            } else if (this.f45948e <= 0 && TextUtils.isEmpty(this.mRiderCommentTagView.getCommentContent()) && CollectionsUtil.isEmpty(this.mRiderCommentTagView.getChoiceTags())) {
                this.mContentContainer.post(new Runnable() {
                    public final void run() {
                        OrderEvaluateView.this.m34106f();
                    }
                });
                ToastUtil.showCustomerToast(getScopeContext(), ResourceHelper.getString(R.string.FoodC_label_Please_select_chki));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m34107g() {
        this.mContentContainer.fullScroll(130);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m34106f() {
        this.mContentContainer.fullScroll(130);
    }

    /* renamed from: b */
    private void m34096b() {
        this.mSubmitBtn.setLoading(true);
        ShopEvaluationEntity shopEvaluationEntity = new ShopEvaluationEntity();
        shopEvaluationEntity.score = this.mBusinessScoreView.getScore();
        shopEvaluationEntity.content = this.mBusinessCommentTagView.getCommentContent();
        shopEvaluationEntity.tagIds = this.mBusinessCommentTagView.getChoiceTags();
        shopEvaluationEntity.imgs = this.mBusinessCommentTagView.getImageList();
        RiderEvaluationEntity riderEvaluationEntity = new RiderEvaluationEntity();
        riderEvaluationEntity.content = this.mRiderCommentTagView.getCommentContent();
        riderEvaluationEntity.score = this.mRiderFaceView.getScore();
        riderEvaluationEntity.tagIds = this.mRiderCommentTagView.getChoiceTags();
        EvaluateOmegaHelper.Companion.trackEvaluatePageCompleteCk(0, this.f45950g, 1, 1, this.mBusinessCommentTagView.getChoiceTags(), this.mRiderCommentTagView.getChoiceTags(), this.mBusinessCommentTagView.getCommentContent(), this.mRiderCommentTagView.getCommentContent(), this.mBusinessScoreView.getScore(), getGoodsEvaluationEntity(), this.mRiderFaceView.getScore());
        ((Contract.AbsOrderEvaluatingPresenter) getPresenter()).saveEvaluationInfo(shopEvaluationEntity, riderEvaluationEntity, getGoodsEvaluationEntity(), 2);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mRiderCommentTagView.clearFocus();
        this.mBusinessCommentTagView.clearFocus();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        KeyboardUtils.hideSoftInput(getContext(), getView());
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_component_order_evaluating, viewGroup, true);
    }

    /* renamed from: c */
    private void m34100c() {
        AndroidBug5497Workaround instance = AndroidBug5497Workaround.getInstance((Activity) getContext());
        instance.setOnSoftInputVisibilityListener(getScopeContext(), new AndroidBug5497Workaround.OnSoftInputVisibilityListener() {
            public final void onVisibility(boolean z) {
                OrderEvaluateView.this.m34093a(z);
            }
        });
        instance.assistComponent(getScopeContext(), getView());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m34093a(boolean z) {
        if (z) {
            View currentFocus = ((Activity) getContext()).getCurrentFocus();
            if (currentFocus != null && currentFocus.equals(this.mBusinessCommentTagView.getCommentView())) {
                this.f45946c = this.mBusinessCommentTagView.getCommentView();
                this.mContentContainer.scrollTo(0, this.mBusinessHeaderInfoView.getMeasuredHeight() + this.mBusinessCommentTagView.getMeasuredHeight());
            } else if (currentFocus != null && currentFocus.equals(this.mRiderCommentTagView.getCommentView())) {
                this.f45946c = this.mRiderCommentTagView.getCommentView();
                this.mRootContainer.setPadding(0, 0, 0, ResourceHelper.getDimensionPixelSize(R.dimen.customer_220px));
                this.mContentContainer.post(new Runnable() {
                    public final void run() {
                        OrderEvaluateView.this.m34104e();
                    }
                });
            }
        } else {
            View view = this.f45946c;
            if (view == null || !view.equals(this.mBusinessCommentTagView.getCommentView())) {
                View view2 = this.f45946c;
                if (view2 != null && view2.equals(this.mRiderCommentTagView.getCommentView())) {
                    this.f45946c = null;
                    this.mRootContainer.setPadding(0, 0, 0, ResourceHelper.getDimensionPixelSize(R.dimen.customer_158px));
                    this.mContentContainer.post(new Runnable() {
                        public final void run() {
                            OrderEvaluateView.this.m34102d();
                        }
                    });
                    return;
                }
                return;
            }
            this.f45946c = null;
            this.mContentContainer.scrollTo(0, 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m34104e() {
        this.mContentContainer.fullScroll(130);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m34102d() {
        this.mContentContainer.fullScroll(130);
    }

    /* renamed from: a */
    private TopGunAbnormalViewModel m34088a(String str) {
        $$Lambda$OrderEvaluateView$39nDaWtr0Oq8liiowwJM4Qo23Nw r0 = new View.OnClickListener() {
            public final void onClick(View view) {
                OrderEvaluateView.this.m34098b(view);
            }
        };
        if (!NetWorkUtils.isNetworkConnected(getContext())) {
            return TopGunAbnormalFactory.buildNoNetwork(r0);
        }
        return TopGunAbnormalFactory.buildHomeNoService(str, r0);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m34098b(View view) {
        hideAbnormalView();
        ((Contract.AbsOrderEvaluatingPresenter) getPresenter()).retryRequest();
    }
}
