package com.didi.soda.home.topgun.widget.brand;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.rpc.entity.PromptEntity;
import com.didi.soda.customer.foundation.util.BitmapUtil;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.business.HomeBusinessTagView;
import com.didi.soda.customer.widget.extra.CustomerShadowConstraintLayout;
import com.didi.soda.home.topgun.binder.HomeBusinessItemBinderNewLogic;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.didi.soda.home.topgun.widget.HomeBusinessItemInfoView;
import com.didi.soda.home.topgun.widget.HomeShopStatusExceptionMaskView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#J\b\u0010$\u001a\u00020\u0007H\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/brand/BusinessBrandHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBgImgIv", "Landroid/widget/ImageView;", "mBusinessExceptionStatusView", "Lcom/didi/soda/home/topgun/widget/HomeShopStatusExceptionMaskView;", "mCornerType", "Lcom/didi/app/nova/skeleton/image/RoundedCornersTransformation$CornerType;", "mHonorImgIv", "mImageRadius", "mInfoViewContainer", "Lcom/didi/soda/home/topgun/widget/HomeBusinessItemInfoView;", "mItemMaskContainer", "Landroid/view/View;", "mPlaceHolderDrawable", "Landroid/graphics/drawable/Drawable;", "mShadowContainer", "Lcom/didi/soda/customer/widget/extra/CustomerShadowConstraintLayout;", "mShopTagTv", "Lcom/didi/soda/customer/widget/business/HomeBusinessTagView;", "mTopBgImgIv", "mTopImageRadius", "mTopPlaceHolderDrawable", "bindData", "", "rvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "logicInterface", "Lcom/didi/soda/home/topgun/binder/HomeBusinessItemBinderNewLogic;", "getViewWidth", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BusinessBrandHeaderView.kt */
public final class BusinessBrandHeaderView extends ConstraintLayout {

    /* renamed from: a */
    private ImageView f45755a;

    /* renamed from: b */
    private ImageView f45756b;

    /* renamed from: c */
    private ImageView f45757c;

    /* renamed from: d */
    private HomeBusinessTagView f45758d;

    /* renamed from: e */
    private CustomerShadowConstraintLayout f45759e;

    /* renamed from: f */
    private HomeBusinessItemInfoView f45760f;

    /* renamed from: g */
    private HomeShopStatusExceptionMaskView f45761g;

    /* renamed from: h */
    private View f45762h;

    /* renamed from: i */
    private Drawable f45763i;

    /* renamed from: j */
    private Drawable f45764j;

    /* renamed from: k */
    private int f45765k;

    /* renamed from: l */
    private int f45766l;

    /* renamed from: m */
    private RoundedCornersTransformation.CornerType f45767m;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BusinessBrandHeaderView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BusinessBrandHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BusinessBrandHeaderView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BusinessBrandHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f45767m = RoundedCornersTransformation.CornerType.ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        View inflate = LayoutInflater.from(context).inflate(R.layout.customer_view_business_brand_header, this, true);
        View findViewById = inflate.findViewById(R.id.customer_iv_home_business_bg_img);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ImageView>(…_iv_home_business_bg_img)");
        this.f45755a = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_iv_home_business_top_img);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<ImageView>(…iv_home_business_top_img)");
        this.f45756b = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_iv_business_brand_honor_img);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<ImageView>(…business_brand_honor_img)");
        this.f45757c = (ImageView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.customer_tv_home_business_tag);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<HomeBusines…mer_tv_home_business_tag)");
        this.f45758d = (HomeBusinessTagView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.customer_business_shadow_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById<CustomerSha…usiness_shadow_container)");
        this.f45759e = (CustomerShadowConstraintLayout) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.customer_business_info_container);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById<HomeBusines…_business_info_container)");
        this.f45760f = (HomeBusinessItemInfoView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.customer_view_layout_mark);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById<View>(R.id.customer_view_layout_mark)");
        this.f45762h = findViewById7;
        View findViewById8 = inflate.findViewById(R.id.customer_custom_home_business_exception_status);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById<HomeShopSta…usiness_exception_status)");
        this.f45761g = (HomeShopStatusExceptionMaskView) findViewById8;
        this.f45765k = DisplayUtils.dip2px(getContext(), 15.0f);
        this.f45766l = DisplayUtils.dip2px(getContext(), 20.0f);
        this.f45763i = BitmapUtil.getRoundedDrawable(getContext(), R.drawable.customer_skin_img_business_goods_item_x11, this.f45765k);
        this.f45764j = getResources().getDrawable(R.drawable.customer_skin_img_brand_placeholder_business_item);
    }

    private final int getViewWidth() {
        return (((CustomerSystemUtil.getScreenWidth(getContext()) - CustomerExtentionKt.getPx(R.dimen.rf_dimen_158)) - (CustomerExtentionKt.getPx(R.dimen.rf_dimen_24) * 3)) - (CustomerExtentionKt.getPx(R.dimen.rf_dimen_32) * 2)) - (((int) this.f45759e.getmInsetPaddingOffset()) * 2);
    }

    public final void bindData(HomeBusinessInfoRvModel homeBusinessInfoRvModel, HomeBusinessItemBinderNewLogic homeBusinessItemBinderNewLogic) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "rvModel");
        if (homeBusinessInfoRvModel.mMask) {
            this.f45761g.setLayoutMarginAndPadding(16, 0, 12, 8);
            this.f45761g.setData(homeBusinessInfoRvModel.mBizTimeDesc, homeBusinessInfoRvModel.statusDesc);
        } else {
            this.f45761g.setVisibility(8);
        }
        FlyImageLoader.loadImageUnspecified(getContext(), homeBusinessInfoRvModel.mLogo).placeholder(this.f45763i).error(this.f45763i).transform(new RoundedCornersTransformation(getContext(), this.f45765k, 0, RoundedCornersTransformation.CornerType.ALL, true)).into(this.f45755a);
        FlyImageLoader.loadImageUnspecified(getContext(), homeBusinessInfoRvModel.mShopImg).placeholder(this.f45764j).error(this.f45764j).transform(new RoundedCornersTransformation(getContext(), this.f45766l, 0, RoundedCornersTransformation.CornerType.TOP, true)).into(this.f45756b);
        CharSequence charSequence = homeBusinessInfoRvModel.mHonorIconUrl;
        if (charSequence == null || charSequence.length() == 0) {
            this.f45757c.setVisibility(8);
            this.f45760f.setShopNameRightMargin(0);
        } else {
            this.f45757c.setVisibility(0);
            FlyImageLoader.loadImage1x1(getContext(), homeBusinessInfoRvModel.mHonorIconUrl).transform(new RoundedCornersTransformation(getContext(), 0, 0, this.f45767m, true)).into(this.f45757c);
            this.f45760f.setShopNameRightMargin(ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_64));
        }
        this.f45760f.setHonorIconVisible(false);
        this.f45760f.setShopNameMaxLine(1);
        this.f45760f.setShopNameTextColor(getResources().getColor(R.color.rf_color_white_100));
        this.f45760f.setViewWidth(getViewWidth());
        String str = null;
        this.f45760f.bindData(homeBusinessInfoRvModel, (HomeBusinessItemBinderNewLogic) null);
        this.f45758d.setLimitMaxWidth(ResourceHelper.getDimensionPixelSize(R.dimen.customer_124px));
        HomeBusinessTagView homeBusinessTagView = this.f45758d;
        PromptEntity promptEntity = homeBusinessInfoRvModel.mShopTag;
        String str2 = promptEntity == null ? null : promptEntity.fontColor;
        PromptEntity promptEntity2 = homeBusinessInfoRvModel.mShopTag;
        String str3 = promptEntity2 == null ? null : promptEntity2.backColor;
        PromptEntity promptEntity3 = homeBusinessInfoRvModel.mShopTag;
        if (promptEntity3 != null) {
            str = promptEntity3.content;
        }
        homeBusinessTagView.setData(str2, str3, str, R.drawable.customer_skin_shape_tag_shop_gradient);
        this.f45762h.setOnClickListener(new View.OnClickListener(homeBusinessInfoRvModel) {
            public final /* synthetic */ HomeBusinessInfoRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                BusinessBrandHeaderView.m33929a(HomeBusinessItemBinderNewLogic.this, this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33929a(HomeBusinessItemBinderNewLogic homeBusinessItemBinderNewLogic, HomeBusinessInfoRvModel homeBusinessInfoRvModel, View view) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "$rvModel");
        if (homeBusinessItemBinderNewLogic != null) {
            homeBusinessItemBinderNewLogic.onItemClick(homeBusinessInfoRvModel);
        }
    }
}
