package com.didi.soda.home.topgun.widget.dish;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.rpc.entity.PromptEntity;
import com.didi.soda.customer.foundation.util.BitmapUtil;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.CouponTagFlowLayoutViewV2;
import com.didi.soda.customer.widget.CustomerFixLineHeightTextView;
import com.didi.soda.customer.widget.business.HomeBusinessTagView;
import com.didi.soda.customer.widget.extra.CustomerShadowConstraintLayout;
import com.didi.soda.customer.widget.search.SearchFoodItemView;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.didi.soda.home.topgun.widget.HomeBusinessGrid;
import com.didi.soda.home.topgun.widget.HorizontalRecyclerView;
import com.didi.soda.home.topgun.widget.dish.BusinessDishItemAdapter;
import com.didi.soda.search.component.result.binder.HomeBusinessWithDishBinder;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(J\b\u0010)\u001a\u00020\u0007H\u0002J\u001a\u0010*\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u0010\u0010+\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u001a\u0010,\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u0010\u0010-\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u001a\u0010.\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/dish/HomeBusinessWithDishNewItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mActTipNfl", "Lcom/didi/soda/customer/widget/CouponTagFlowLayoutViewV2;", "mBgImgIv", "Landroid/widget/ImageView;", "mBusinessDishItemAdapter", "Lcom/didi/soda/home/topgun/widget/dish/BusinessDishItemAdapter;", "mBusinessDishRv", "Lcom/didi/soda/home/topgun/widget/HorizontalRecyclerView;", "mBusinessRootCl", "Landroid/view/View;", "mCateInfoContainer", "Lcom/didi/soda/home/topgun/widget/HomeBusinessGrid;", "mCornerType", "Lcom/didi/app/nova/skeleton/image/RoundedCornersTransformation$CornerType;", "mHonorImgIv", "mImageRadius", "mNameTv", "Lcom/didi/soda/customer/widget/CustomerFixLineHeightTextView;", "mPlaceHolderDrawable", "Landroid/graphics/drawable/Drawable;", "mRankDescContainer", "mRecommendDescDivider", "mShadowContainer", "Lcom/didi/soda/customer/widget/extra/CustomerShadowConstraintLayout;", "mShopTagTv", "Lcom/didi/soda/customer/widget/business/HomeBusinessTagView;", "bindData", "", "rvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "logicInterface", "Lcom/didi/soda/search/component/result/binder/HomeBusinessWithDishBinder$HomeBusinessDishItemBinderLogic;", "getViewWidth", "handCateInfoAndDelivery", "handPromoteInfo", "handleBusinessDishs", "handleBusinessName", "handleRankingInfo", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeBusinessWithDishNewItemView.kt */
public final class HomeBusinessWithDishNewItemView extends ConstraintLayout {

    /* renamed from: a */
    private ImageView f45774a;

    /* renamed from: b */
    private CustomerFixLineHeightTextView f45775b;

    /* renamed from: c */
    private HomeBusinessGrid f45776c;

    /* renamed from: d */
    private CouponTagFlowLayoutViewV2 f45777d;

    /* renamed from: e */
    private ImageView f45778e;

    /* renamed from: f */
    private View f45779f;

    /* renamed from: g */
    private HomeBusinessGrid f45780g;

    /* renamed from: h */
    private HomeBusinessTagView f45781h;

    /* renamed from: i */
    private CustomerShadowConstraintLayout f45782i;

    /* renamed from: j */
    private HorizontalRecyclerView f45783j;

    /* renamed from: k */
    private View f45784k;

    /* renamed from: l */
    private Drawable f45785l;

    /* renamed from: m */
    private int f45786m;

    /* renamed from: n */
    private RoundedCornersTransformation.CornerType f45787n;

    /* renamed from: o */
    private BusinessDishItemAdapter f45788o;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeBusinessWithDishNewItemView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeBusinessWithDishNewItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeBusinessWithDishNewItemView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeBusinessWithDishNewItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f45787n = RoundedCornersTransformation.CornerType.ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        View inflate = LayoutInflater.from(context).inflate(R.layout.customer_binder_home_business_dish_new, this, true);
        View findViewById = inflate.findViewById(R.id.customer_iv_home_business_bg_img);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ImageView>(…_iv_home_business_bg_img)");
        this.f45774a = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_tv_home_business_name);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<CustomerFix…er_tv_home_business_name)");
        this.f45775b = (CustomerFixLineHeightTextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_hs_cate_info_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<HomeBusines…r_hs_cate_info_container)");
        this.f45776c = (HomeBusinessGrid) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.customer_nfl_home_business_act_tip);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<CouponTagFl…fl_home_business_act_tip)");
        this.f45777d = (CouponTagFlowLayoutViewV2) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.customer_iv_home_business_honor_img);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById<ImageView>(…_home_business_honor_img)");
        this.f45778e = (ImageView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.customer_delivery_desc_divider);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById<View>(R.id.…er_delivery_desc_divider)");
        this.f45779f = findViewById6;
        View findViewById7 = inflate.findViewById(R.id.customer_hs_rank_container);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById<HomeBusines…stomer_hs_rank_container)");
        this.f45780g = (HomeBusinessGrid) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.customer_tv_home_business_tag);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById<HomeBusines…mer_tv_home_business_tag)");
        this.f45781h = (HomeBusinessTagView) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.customer_business_shadow_container);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById<CustomerSha…usiness_shadow_container)");
        this.f45782i = (CustomerShadowConstraintLayout) findViewById9;
        View findViewById10 = inflate.findViewById(R.id.customer_business_rv_dish_container);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.custom…siness_rv_dish_container)");
        this.f45783j = (HorizontalRecyclerView) findViewById10;
        View findViewById11 = inflate.findViewById(R.id.customer_business_root);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.customer_business_root)");
        this.f45784k = findViewById11;
        this.f45786m = DisplayUtils.dip2px(getContext(), 12.0f);
        this.f45785l = BitmapUtil.getRoundedDrawable(getContext(), R.drawable.customer_skin_img_business_goods_item_x11, this.f45786m);
        HorizontalRecyclerView horizontalRecyclerView = this.f45783j;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        Unit unit = Unit.INSTANCE;
        horizontalRecyclerView.setLayoutManager(linearLayoutManager);
        this.f45783j.addItemDecoration(new BusinessDishItemDecorator());
    }

    /* renamed from: a */
    private final void m33936a(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        this.f45775b.getPaint().setTextSize((float) DisplayUtils.dip2px(getContext(), 18.0f));
        boolean z = true;
        this.f45775b.setTextSize(1, (float) 16);
        this.f45775b.setLineSpacingExtra(DisplayUtils.dip2px(getContext(), 3.0f));
        CharSequence charSequence = homeBusinessInfoRvModel.mShopName;
        if (!(charSequence == null || charSequence.length() == 0)) {
            z = false;
        }
        String str = z ? "" : homeBusinessInfoRvModel.mShopName;
        this.f45775b.setCustomText(str);
        float measureText = this.f45775b.getPaint().measureText(str);
        ViewGroup.LayoutParams layoutParams = this.f45775b.getLayoutParams();
        if (layoutParams != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            if (measureText + ((float) CustomerExtentionKt.getPx(R.dimen.rf_dimen_6)) + ((float) CustomerExtentionKt.getPx(R.dimen.rf_dimen_24)) + ((float) CustomerExtentionKt.getPx(R.dimen.rf_dimen_20)) + ((float) CustomerExtentionKt.getPx(R.dimen.rf_dimen_48)) > ((float) getViewWidth())) {
                layoutParams2.weight = 1.0f;
            } else {
                layoutParams2.weight = 0.0f;
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
    }

    /* renamed from: a */
    private final void m33937a(HomeBusinessInfoRvModel homeBusinessInfoRvModel, HomeBusinessWithDishBinder.HomeBusinessDishItemBinderLogic homeBusinessDishItemBinderLogic) {
        List arrayList = new ArrayList();
        Collection collection = homeBusinessInfoRvModel.mRating;
        boolean z = false;
        if (!(collection == null || collection.isEmpty())) {
            List<PromptEntity> list = homeBusinessInfoRvModel.mRating;
            Intrinsics.checkNotNullExpressionValue(list, "rvModel.mRating");
            arrayList.addAll(list);
        }
        Collection collection2 = homeBusinessInfoRvModel.mFulfillment;
        if (!(collection2 == null || collection2.isEmpty())) {
            List<PromptEntity> list2 = homeBusinessInfoRvModel.mFulfillment;
            Intrinsics.checkNotNullExpressionValue(list2, "rvModel.mFulfillment");
            arrayList.addAll(list2);
        }
        if (!arrayList.isEmpty()) {
            Collection collection3 = homeBusinessInfoRvModel.mRating;
            if (collection3 == null || collection3.isEmpty()) {
                this.f45776c.setDivider("dot");
                this.f45776c.setItemSpace(Float.valueOf(7.5f));
                this.f45776c.setShowDividerIndex(-1);
            } else {
                Collection collection4 = homeBusinessInfoRvModel.mFulfillment;
                if (collection4 == null || collection4.isEmpty()) {
                    z = true;
                }
                if (z) {
                    this.f45776c.setItemSpace(Float.valueOf(20.0f));
                    this.f45776c.setDivider("");
                    this.f45776c.setShowDividerIndex(-1);
                } else {
                    this.f45776c.setDivider(HomeBusinessGrid.DIVIDER_SPACE_DOT);
                    this.f45776c.setItemSpace(Float.valueOf(7.5f));
                    this.f45776c.setShowDividerIndex(homeBusinessInfoRvModel.mRating.size());
                }
            }
            this.f45776c.setData(arrayList, getViewWidth());
            this.f45776c.setOnClickListener(new View.OnClickListener(homeBusinessInfoRvModel) {
                public final /* synthetic */ HomeBusinessInfoRvModel f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    HomeBusinessWithDishNewItemView.m33938a(HomeBusinessWithDishBinder.HomeBusinessDishItemBinderLogic.this, this.f$1, view);
                }
            });
            return;
        }
        this.f45776c.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33938a(HomeBusinessWithDishBinder.HomeBusinessDishItemBinderLogic homeBusinessDishItemBinderLogic, HomeBusinessInfoRvModel homeBusinessInfoRvModel, View view) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "$rvModel");
        if (homeBusinessDishItemBinderLogic != null) {
            homeBusinessDishItemBinderLogic.onShopClick(homeBusinessInfoRvModel);
        }
    }

    /* renamed from: b */
    private final void m33941b(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        if (!CollectionsUtil.isEmpty(homeBusinessInfoRvModel.mTags)) {
            CouponTagFlowLayoutViewV2 couponTagFlowLayoutViewV2 = this.f45777d;
            List<PromptEntity> list = homeBusinessInfoRvModel.mTags;
            Intrinsics.checkNotNullExpressionValue(list, "rvModel.mTags");
            couponTagFlowLayoutViewV2.setData((List<? extends PromptEntity>) list, getViewWidth());
            this.f45777d.setVisibility(0);
            return;
        }
        this.f45777d.setVisibility(8);
    }

    /* renamed from: b */
    private final void m33942b(HomeBusinessInfoRvModel homeBusinessInfoRvModel, HomeBusinessWithDishBinder.HomeBusinessDishItemBinderLogic homeBusinessDishItemBinderLogic) {
        if (homeBusinessInfoRvModel.mRecInfo != null) {
            CharSequence charSequence = homeBusinessInfoRvModel.mRecInfo.content;
            if (!(charSequence == null || charSequence.length() == 0)) {
                this.f45780g.setOnClickListener(new View.OnClickListener(homeBusinessInfoRvModel) {
                    public final /* synthetic */ HomeBusinessInfoRvModel f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        HomeBusinessWithDishNewItemView.m33943b(HomeBusinessWithDishBinder.HomeBusinessDishItemBinderLogic.this, this.f$1, view);
                    }
                });
                this.f45780g.setData(CollectionsKt.mutableListOf(homeBusinessInfoRvModel.mRecInfo), getViewWidth());
                this.f45779f.setVisibility(this.f45780g.getVisibility());
            }
        }
        this.f45780g.setVisibility(8);
        this.f45779f.setVisibility(this.f45780g.getVisibility());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m33943b(HomeBusinessWithDishBinder.HomeBusinessDishItemBinderLogic homeBusinessDishItemBinderLogic, HomeBusinessInfoRvModel homeBusinessInfoRvModel, View view) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "$rvModel");
        if (homeBusinessDishItemBinderLogic != null) {
            homeBusinessDishItemBinderLogic.onShopClick(homeBusinessInfoRvModel);
        }
    }

    private final int getViewWidth() {
        return (((CustomerSystemUtil.getScreenWidth(getContext()) - CustomerExtentionKt.getPx(R.dimen.rf_dimen_90)) - (CustomerExtentionKt.getPx(R.dimen.rf_dimen_24) * 3)) - (CustomerExtentionKt.getPx(R.dimen.rf_dimen_32) * 2)) - (((int) this.f45782i.getmInsetPaddingOffset()) * 2);
    }

    /* renamed from: c */
    private final void m33944c(HomeBusinessInfoRvModel homeBusinessInfoRvModel, HomeBusinessWithDishBinder.HomeBusinessDishItemBinderLogic homeBusinessDishItemBinderLogic) {
        Collection collection = homeBusinessInfoRvModel.mFoodItems;
        if (!(collection == null || collection.isEmpty())) {
            this.f45783j.setVisibility(0);
            BusinessDishItemAdapter businessDishItemAdapter = new BusinessDishItemAdapter();
            businessDishItemAdapter.setData(homeBusinessInfoRvModel.mFoodItems);
            businessDishItemAdapter.setOnItemClickListener(new BusinessDishItemAdapter.OnItemClickListener(homeBusinessInfoRvModel) {
                public final /* synthetic */ HomeBusinessInfoRvModel f$1;

                {
                    this.f$1 = r2;
                }

                public final void onItemClick(SearchFoodItemView.SearchFoodItemModel searchFoodItemModel, int i) {
                    HomeBusinessWithDishNewItemView.m33939a(HomeBusinessWithDishBinder.HomeBusinessDishItemBinderLogic.this, this.f$1, searchFoodItemModel, i);
                }
            });
            businessDishItemAdapter.setOnItemBindListener(new BusinessDishItemAdapter.OnItemBindListener(homeBusinessInfoRvModel) {
                public final /* synthetic */ HomeBusinessInfoRvModel f$1;

                {
                    this.f$1 = r2;
                }

                public final void onItemBind(SearchFoodItemView.SearchFoodItemModel searchFoodItemModel, boolean z) {
                    HomeBusinessWithDishNewItemView.m33940a(HomeBusinessWithDishBinder.HomeBusinessDishItemBinderLogic.this, this.f$1, searchFoodItemModel, z);
                }
            });
            Unit unit = Unit.INSTANCE;
            this.f45788o = businessDishItemAdapter;
            this.f45783j.setAdapter(businessDishItemAdapter);
            return;
        }
        this.f45783j.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33939a(HomeBusinessWithDishBinder.HomeBusinessDishItemBinderLogic homeBusinessDishItemBinderLogic, HomeBusinessInfoRvModel homeBusinessInfoRvModel, SearchFoodItemView.SearchFoodItemModel searchFoodItemModel, int i) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "$rvModel");
        if (homeBusinessDishItemBinderLogic != null) {
            homeBusinessDishItemBinderLogic.onDishImageClick(homeBusinessInfoRvModel, searchFoodItemModel, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33940a(HomeBusinessWithDishBinder.HomeBusinessDishItemBinderLogic homeBusinessDishItemBinderLogic, HomeBusinessInfoRvModel homeBusinessInfoRvModel, SearchFoodItemView.SearchFoodItemModel searchFoodItemModel, boolean z) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "$rvModel");
        if (homeBusinessDishItemBinderLogic != null) {
            homeBusinessDishItemBinderLogic.onDishItemShown(homeBusinessInfoRvModel, searchFoodItemModel, z);
        }
    }

    public final void bindData(HomeBusinessInfoRvModel homeBusinessInfoRvModel, HomeBusinessWithDishBinder.HomeBusinessDishItemBinderLogic homeBusinessDishItemBinderLogic) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "rvModel");
        FlyImageLoader.loadImage4x3(getContext(), homeBusinessInfoRvModel.mLogo).placeholder(this.f45785l).error(this.f45785l).transform(new RoundedCornersTransformation(getContext(), this.f45786m, 0, RoundedCornersTransformation.CornerType.ALL, true)).into(this.f45774a);
        CharSequence charSequence = homeBusinessInfoRvModel.mHonorIconUrl;
        if (charSequence == null || charSequence.length() == 0) {
            this.f45778e.setVisibility(8);
        } else {
            this.f45778e.setVisibility(0);
            FlyImageLoader.loadImage1x1(getContext(), homeBusinessInfoRvModel.mHonorIconUrl).transform(new RoundedCornersTransformation(getContext(), 0, 0, this.f45787n, true)).into(this.f45778e);
        }
        this.f45781h.setLimitMaxWidth(ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_72));
        HomeBusinessTagView homeBusinessTagView = this.f45781h;
        PromptEntity promptEntity = homeBusinessInfoRvModel.mShopTag;
        String str = null;
        String str2 = promptEntity == null ? null : promptEntity.fontColor;
        PromptEntity promptEntity2 = homeBusinessInfoRvModel.mShopTag;
        String str3 = promptEntity2 == null ? null : promptEntity2.backColor;
        PromptEntity promptEntity3 = homeBusinessInfoRvModel.mShopTag;
        if (promptEntity3 != null) {
            str = promptEntity3.content;
        }
        homeBusinessTagView.setData(str2, str3, str, R.drawable.customer_skin_shape_tag_dish_shop_gradient);
        m33936a(homeBusinessInfoRvModel);
        m33937a(homeBusinessInfoRvModel, homeBusinessDishItemBinderLogic);
        m33941b(homeBusinessInfoRvModel);
        m33942b(homeBusinessInfoRvModel, homeBusinessDishItemBinderLogic);
        m33944c(homeBusinessInfoRvModel, homeBusinessDishItemBinderLogic);
        this.f45784k.setOnClickListener(new View.OnClickListener(homeBusinessInfoRvModel) {
            public final /* synthetic */ HomeBusinessInfoRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                HomeBusinessWithDishNewItemView.m33945c(HomeBusinessWithDishBinder.HomeBusinessDishItemBinderLogic.this, this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m33945c(HomeBusinessWithDishBinder.HomeBusinessDishItemBinderLogic homeBusinessDishItemBinderLogic, HomeBusinessInfoRvModel homeBusinessInfoRvModel, View view) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "$rvModel");
        if (homeBusinessDishItemBinderLogic != null) {
            homeBusinessDishItemBinderLogic.onShopClick(homeBusinessInfoRvModel);
        }
    }
}
