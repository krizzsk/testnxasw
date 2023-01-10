package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.rpc.entity.PromptEntity;
import com.didi.soda.customer.foundation.util.BitmapUtil;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.widget.business.HomeBusinessTagView;
import com.didi.soda.customer.widget.extra.CustomerShadowConstraintLayout;
import com.didi.soda.home.topgun.binder.HomeBusinessItemBinderNewLogic;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.didi.soda.home.topgun.manager.HomeFeedbackConfigHelper;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didi.soda.home.topgun.model.HomeFeedbackButtonModel;
import com.didi.soda.home.topgun.model.HomeFeedbackModel;
import com.didi.soda.home.topgun.widget.HomeFeedbackGridLayout;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+J\b\u0010,\u001a\u00020\u0007H\u0002J\u0010\u0010-\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u000e\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\u001fJ\u0010\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020\u001fH\u0002J\u0018\u00102\u001a\u00020'2\b\b\u0001\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u000205J&\u00106\u001a\u00020'2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/HomeBusinessItemNewView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBgImgIv", "Landroid/widget/ImageView;", "mBusinessExceptionStatusView", "Lcom/didi/soda/home/topgun/widget/HomeShopStatusExceptionMaskView;", "mCornerType", "Lcom/didi/app/nova/skeleton/image/RoundedCornersTransformation$CornerType;", "mFeedBackClose", "Landroid/view/View;", "mFeedBackContainer", "mFeedBackGridLayout", "Lcom/didi/soda/home/topgun/widget/HomeFeedbackGridLayout;", "mFeedBackImgIv", "mImageRadius", "mInfoViewContainer", "Lcom/didi/soda/home/topgun/widget/HomeBusinessItemInfoView;", "mItemMaskContainer", "mItemMaskDispatcher", "Lcom/didi/soda/home/topgun/widget/HomeItemMaskContainerView;", "mLogoImgIv", "mPlaceHolderDrawable", "Landroid/graphics/drawable/Drawable;", "mReplaceShopImgByLogo", "", "mRoot", "mShadowContainer", "Lcom/didi/soda/customer/widget/extra/CustomerShadowConstraintLayout;", "mShopImageExceptedWidth", "mShopTagTv", "Lcom/didi/soda/customer/widget/business/HomeBusinessTagView;", "bindData", "", "rvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "logicInterface", "Lcom/didi/soda/home/topgun/binder/HomeBusinessItemBinderNewLogic;", "getViewWidth", "handleFeedback", "replaceShopImageByLogo", "replace", "setFeedbackLayoutVisibility", "visibility", "setShopImageExceptedWidth", "exceptedWidth", "ratioType", "Lcom/didi/soda/home/topgun/widget/ShopImageWHRatioType;", "setShopStatusViewConfig", "horizontalMargin", "verticalMargin", "horizontalPadding", "verticalPadding", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeBusinessItemNewView.kt */
public final class HomeBusinessItemNewView extends ConstraintLayout {

    /* renamed from: a */
    private ImageView f45609a;

    /* renamed from: b */
    private ImageView f45610b;

    /* renamed from: c */
    private View f45611c;

    /* renamed from: d */
    private HomeShopStatusExceptionMaskView f45612d;

    /* renamed from: e */
    private ConstraintLayout f45613e;

    /* renamed from: f */
    private HomeBusinessTagView f45614f;

    /* renamed from: g */
    private CustomerShadowConstraintLayout f45615g;

    /* renamed from: h */
    private HomeBusinessItemInfoView f45616h;

    /* renamed from: i */
    private Drawable f45617i;

    /* renamed from: j */
    private View f45618j;

    /* renamed from: k */
    private HomeFeedbackGridLayout f45619k;

    /* renamed from: l */
    private View f45620l;

    /* renamed from: m */
    private View f45621m;

    /* renamed from: n */
    private HomeItemMaskContainerView f45622n;

    /* renamed from: o */
    private int f45623o;

    /* renamed from: p */
    private RoundedCornersTransformation.CornerType f45624p;

    /* renamed from: q */
    private int f45625q;

    /* renamed from: r */
    private boolean f45626r;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeBusinessItemNewView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeBusinessItemNewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: private */
    /* renamed from: setFeedbackLayoutVisibility$lambda-5  reason: not valid java name */
    public static final void m47468setFeedbackLayoutVisibility$lambda5(View view) {
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeBusinessItemNewView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeBusinessItemNewView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f45624p = RoundedCornersTransformation.CornerType.ALL;
        this.f45625q = CustomerExtentionKt.getPx(R.dimen.rf_dimen_210);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        View inflate = LayoutInflater.from(context).inflate(R.layout.customer_item_new_feed_business, this, true);
        View findViewById = inflate.findViewById(R.id.customer_iv_home_business_bg_img);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ImageView>(…_iv_home_business_bg_img)");
        this.f45609a = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_iv_custom_shop_logo);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<ImageView>(…omer_iv_custom_shop_logo)");
        this.f45610b = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_view_layout_mark);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<View>(R.id.customer_view_layout_mark)");
        this.f45611c = findViewById3;
        View findViewById4 = inflate.findViewById(R.id.customer_custom_home_business_exception_status);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<HomeShopSta…usiness_exception_status)");
        this.f45612d = (HomeShopStatusExceptionMaskView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.customer_business_root);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById<ConstraintL…d.customer_business_root)");
        this.f45613e = (ConstraintLayout) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.customer_tv_home_business_tag);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById<HomeBusines…mer_tv_home_business_tag)");
        this.f45614f = (HomeBusinessTagView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.customer_business_shadow_container);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById<CustomerSha…usiness_shadow_container)");
        this.f45615g = (CustomerShadowConstraintLayout) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.customer_business_item_right_container);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById<HomeBusines…ess_item_right_container)");
        this.f45616h = (HomeBusinessItemInfoView) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.customer_iv_home_business_feedback_img);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById<View>(R.id.…me_business_feedback_img)");
        this.f45621m = findViewById9;
        View findViewById10 = inflate.findViewById(R.id.customer_business_feedback_container);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById<View>(R.id.…iness_feedback_container)");
        this.f45618j = findViewById10;
        View findViewById11 = inflate.findViewById(R.id.customer_business_feedback_grid_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById<HomeFeedbac…ess_feedback_grid_layout)");
        this.f45619k = (HomeFeedbackGridLayout) findViewById11;
        View findViewById12 = inflate.findViewById(R.id.customer_business_feedback_close);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById<View>(R.id.…_business_feedback_close)");
        this.f45620l = findViewById12;
        View findViewById13 = inflate.findViewById(R.id.customer_view_layout_mark_dispatcher);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById<HomeItemMas…w_layout_mark_dispatcher)");
        this.f45622n = (HomeItemMaskContainerView) findViewById13;
        this.f45623o = DisplayUtils.dip2px(getContext(), 14.0f);
        this.f45617i = BitmapUtil.getRoundedDrawable(getContext(), R.drawable.customer_skin_img_topgun_placeholder_business_item, this.f45623o);
    }

    public final void setShopImageExceptedWidth(int i, ShopImageWHRatioType shopImageWHRatioType) {
        Number number;
        Intrinsics.checkNotNullParameter(shopImageWHRatioType, "ratioType");
        this.f45625q = CustomerExtentionKt.getPx(i);
        ViewGroup.LayoutParams layoutParams = this.f45609a.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.width = CustomerExtentionKt.getPx(i);
            if (shopImageWHRatioType == ShopImageWHRatioType.RATIO_1X1) {
                number = Integer.valueOf(CustomerExtentionKt.getPx(i));
            } else {
                number = Float.valueOf(((float) CustomerExtentionKt.getPx(i)) / ShopImageWHRatioType.RATIO_4X3.getValue());
            }
            layoutParams2.height = number.intValue();
            this.f45609a.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void replaceShopImageByLogo(boolean z) {
        this.f45626r = z;
    }

    private final int getViewWidth() {
        return (((CustomerSystemUtil.getScreenWidth(getContext()) - this.f45625q) - (CustomerExtentionKt.getPx(R.dimen.rf_dimen_24) * 3)) - (CustomerExtentionKt.getPx(R.dimen.rf_dimen_32) * 2)) - (((int) this.f45615g.getmInsetPaddingOffset()) * 2);
    }

    public final void setShopStatusViewConfig(int i, int i2, int i3, int i4) {
        this.f45612d.setLayoutMarginAndPadding(i, i2, i3, i4);
    }

    /* renamed from: a */
    private final void m33888a(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        String str;
        HomeFeedbackModel homeFeedbackConfig = HomeFeedbackConfigHelper.Companion.getInstance().getHomeFeedbackConfig();
        setFeedbackLayoutVisibility(false);
        if (homeFeedbackConfig != null && !CollectionsUtil.isEmpty(homeFeedbackConfig.getBtnList()) && LoginUtil.isLogin()) {
            String str2 = homeBusinessInfoRvModel.mPageId;
            if (str2 == null) {
                str = null;
            } else {
                str = str2.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).toLowerCase()");
            }
            if (Intrinsics.areEqual((Object) "homepage", (Object) str)) {
                this.f45619k.removeAllViews();
                this.f45621m.setVisibility(0);
                this.f45622n.setFeedBackView(this.f45621m);
                this.f45611c.setOnLongClickListener(new View.OnLongClickListener(this) {
                    public final /* synthetic */ HomeBusinessItemNewView f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final boolean onLongClick(View view) {
                        return HomeBusinessItemNewView.m33891a(HomeBusinessInfoRvModel.this, this.f$1, view);
                    }
                });
                this.f45621m.setOnClickListener(new View.OnClickListener(this) {
                    public final /* synthetic */ HomeBusinessItemNewView f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        HomeBusinessItemNewView.m33892b(HomeBusinessInfoRvModel.this, this.f$1, view);
                    }
                });
                this.f45620l.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        HomeBusinessItemNewView.m33890a(HomeBusinessItemNewView.this, view);
                    }
                });
                this.f45619k.setFeedbackItem(homeFeedbackConfig.getBtnList());
                this.f45619k.setOnClickItemListener(new HomeFeedbackGridLayout.OnClickItemListener(this) {
                    public final /* synthetic */ HomeBusinessItemNewView f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onItemClick(HomeFeedbackButtonModel homeFeedbackButtonModel) {
                        HomeBusinessItemNewView.m33889a(HomeBusinessInfoRvModel.this, this.f$1, homeFeedbackButtonModel);
                    }
                });
                return;
            }
        }
        this.f45621m.setVisibility(8);
        this.f45622n.setFeedBackView((View) null);
        this.f45611c.setOnLongClickListener((View.OnLongClickListener) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m33891a(HomeBusinessInfoRvModel homeBusinessInfoRvModel, HomeBusinessItemNewView homeBusinessItemNewView, View view) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "$rvModel");
        Intrinsics.checkNotNullParameter(homeBusinessItemNewView, "this$0");
        HomeOmegaHelper.getInstance().trackFeedbackSW(homeBusinessInfoRvModel);
        homeBusinessItemNewView.setFeedbackLayoutVisibility(true);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m33892b(HomeBusinessInfoRvModel homeBusinessInfoRvModel, HomeBusinessItemNewView homeBusinessItemNewView, View view) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "$rvModel");
        Intrinsics.checkNotNullParameter(homeBusinessItemNewView, "this$0");
        HomeOmegaHelper.getInstance().trackFeedbackSW(homeBusinessInfoRvModel);
        homeBusinessItemNewView.setFeedbackLayoutVisibility(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33890a(HomeBusinessItemNewView homeBusinessItemNewView, View view) {
        Intrinsics.checkNotNullParameter(homeBusinessItemNewView, "this$0");
        homeBusinessItemNewView.setFeedbackLayoutVisibility(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33889a(HomeBusinessInfoRvModel homeBusinessInfoRvModel, HomeBusinessItemNewView homeBusinessItemNewView, HomeFeedbackButtonModel homeFeedbackButtonModel) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "$rvModel");
        Intrinsics.checkNotNullParameter(homeBusinessItemNewView, "this$0");
        HomeOmegaHelper instance = HomeOmegaHelper.getInstance();
        Integer issueNo = homeFeedbackButtonModel.getIssueNo();
        instance.trackFeedbackCK(homeBusinessInfoRvModel, issueNo == null ? 0 : issueNo.intValue());
        homeBusinessItemNewView.setFeedbackLayoutVisibility(false);
        ToastUtil.showCustomerToast((ScopeContext) null, ResourceHelper.getString(R.string.FoodC_feedback_Your_feedback_FuwM));
    }

    private final void setFeedbackLayoutVisibility(boolean z) {
        if (z) {
            this.f45618j.setVisibility(0);
            this.f45620l.setVisibility(0);
            this.f45619k.setVisibility(0);
            this.f45618j.setOnClickListener($$Lambda$HomeBusinessItemNewView$49Qbh7QTJ_M18t_Kzuo07JdeWzk.INSTANCE);
            return;
        }
        this.f45618j.setVisibility(8);
        this.f45620l.setVisibility(8);
        this.f45619k.setVisibility(8);
    }

    public final void bindData(HomeBusinessInfoRvModel homeBusinessInfoRvModel, HomeBusinessItemBinderNewLogic homeBusinessItemBinderNewLogic) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "rvModel");
        if (homeBusinessInfoRvModel.mMask) {
            this.f45612d.setData(homeBusinessInfoRvModel.mBizTimeDesc, homeBusinessInfoRvModel.statusDesc);
        } else {
            this.f45612d.setVisibility(8);
        }
        if (this.f45626r) {
            FlyImageLoader.loadImage1x1(getContext(), homeBusinessInfoRvModel.mLogo).placeholder(this.f45617i).error(this.f45617i).transform(new RoundedCornersTransformation(getContext(), this.f45623o, 0, RoundedCornersTransformation.CornerType.ALL, true)).into(this.f45609a);
        } else {
            FlyImageLoader.loadImage4x3(getContext(), homeBusinessInfoRvModel.mShopImg).placeholder(this.f45617i).error(this.f45617i).transform(new RoundedCornersTransformation(getContext(), this.f45623o, 0, RoundedCornersTransformation.CornerType.ALL, true)).into(this.f45609a);
        }
        CharSequence charSequence = homeBusinessInfoRvModel.mLogo;
        if ((charSequence == null || charSequence.length() == 0) || this.f45626r) {
            this.f45610b.setVisibility(8);
        } else {
            this.f45610b.setVisibility(0);
            FlyImageLoader.loadImage1x1(getContext(), homeBusinessInfoRvModel.mLogo).transform(new RoundedCornersTransformation(getContext(), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_18), 0, this.f45624p, true)).into(this.f45610b);
        }
        this.f45614f.setLimitMaxWidth(ResourceHelper.getDimensionPixelSize(R.dimen.customer_124px));
        HomeBusinessTagView homeBusinessTagView = this.f45614f;
        PromptEntity promptEntity = homeBusinessInfoRvModel.mShopTag;
        String str = null;
        String str2 = promptEntity == null ? null : promptEntity.fontColor;
        PromptEntity promptEntity2 = homeBusinessInfoRvModel.mShopTag;
        String str3 = promptEntity2 == null ? null : promptEntity2.backColor;
        PromptEntity promptEntity3 = homeBusinessInfoRvModel.mShopTag;
        if (promptEntity3 != null) {
            str = promptEntity3.content;
        }
        homeBusinessTagView.setData(str2, str3, str, R.drawable.customer_skin_shape_tag_shop_gradient);
        this.f45616h.setViewWidth(getViewWidth());
        this.f45616h.bindData(homeBusinessInfoRvModel, homeBusinessItemBinderNewLogic);
        this.f45611c.setOnClickListener(new View.OnClickListener(homeBusinessInfoRvModel) {
            public final /* synthetic */ HomeBusinessInfoRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                HomeBusinessItemNewView.m33887a(HomeBusinessItemBinderNewLogic.this, this.f$1, view);
            }
        });
        m33888a(homeBusinessInfoRvModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33887a(HomeBusinessItemBinderNewLogic homeBusinessItemBinderNewLogic, HomeBusinessInfoRvModel homeBusinessInfoRvModel, View view) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "$rvModel");
        if (homeBusinessItemBinderNewLogic != null) {
            homeBusinessItemBinderNewLogic.onItemClick(homeBusinessInfoRvModel);
        }
    }
}
