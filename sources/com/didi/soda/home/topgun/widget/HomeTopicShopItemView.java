package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.soda.customer.foundation.rpc.entity.ImageBottomTagEntity;
import com.didi.soda.customer.foundation.rpc.entity.PromptEntity;
import com.didi.soda.customer.foundation.util.ExtentionsKt;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.CouponTagFlowLayoutViewV2;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010!\u001a\u00020\u000bH\u0016J\u000e\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/HomeTopicShopItemView;", "Lcom/didi/soda/home/topgun/widget/HomeTopicBaseView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "appearListener", "Lkotlin/Function0;", "", "getAppearListener", "()Lkotlin/jvm/functions/Function0;", "setAppearListener", "(Lkotlin/jvm/functions/Function0;)V", "image", "Landroid/widget/ImageView;", "logo", "lottieBanner", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieText", "Landroid/widget/TextView;", "model", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "msgLayout", "Lcom/didi/soda/home/topgun/widget/HomeBusinessGrid;", "nameTv", "rootView", "Landroid/view/ViewGroup;", "shopTag", "tipsLayout", "Lcom/didi/soda/customer/widget/CouponTagFlowLayoutViewV2;", "onAppear", "setData", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeTopicShopItemView.kt */
public final class HomeTopicShopItemView extends HomeTopicBaseView {

    /* renamed from: a */
    private ImageView f45688a;

    /* renamed from: b */
    private TextView f45689b;

    /* renamed from: c */
    private ImageView f45690c;

    /* renamed from: d */
    private ViewGroup f45691d;

    /* renamed from: e */
    private HomeBusinessGrid f45692e;

    /* renamed from: f */
    private CouponTagFlowLayoutViewV2 f45693f;

    /* renamed from: g */
    private TextView f45694g;

    /* renamed from: h */
    private TextView f45695h;

    /* renamed from: i */
    private LottieAnimationView f45696i;

    /* renamed from: j */
    private HomeBusinessInfoRvModel f45697j;

    /* renamed from: k */
    private Function0<Unit> f45698k;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeTopicShopItemView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeTopicShopItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeTopicShopItemView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeTopicShopItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout.inflate(context, R.layout.customer_home_item_topic_shop_item, this);
        View findViewById = findViewById(R.id.customer_iv_efo_dish_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_iv_efo_dish_image)");
        this.f45688a = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.customer_iv_home_efo_logo);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_iv_home_efo_logo)");
        this.f45690c = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.customer_tv_home_efo_dish_name);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_tv_home_efo_dish_name)");
        this.f45689b = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.customer_cl_efo_item_root);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.customer_cl_efo_item_root)");
        this.f45691d = (ViewGroup) findViewById4;
        View findViewById5 = findViewById(R.id.customer_topic_tv_shop_rich_desc_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.custom…tv_shop_rich_desc_layout)");
        this.f45692e = (HomeBusinessGrid) findViewById5;
        View findViewById6 = findViewById(R.id.customer_topic_tv_shop_tips);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.customer_topic_tv_shop_tips)");
        this.f45693f = (CouponTagFlowLayoutViewV2) findViewById6;
        View findViewById7 = findViewById(R.id.customer_home_topic_shop_tag);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.customer_home_topic_shop_tag)");
        this.f45694g = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.customer_tv_home_efo_label);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.customer_tv_home_efo_label)");
        this.f45695h = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.customer_tv_home_efo_lottie);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.customer_tv_home_efo_lottie)");
        this.f45696i = (LottieAnimationView) findViewById9;
        this.f45691d.getLayoutParams().height = -1;
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
    }

    public final Function0<Unit> getAppearListener() {
        return this.f45698k;
    }

    public final void setAppearListener(Function0<Unit> function0) {
        this.f45698k = function0;
    }

    public final void setData(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "model");
        this.f45697j = homeBusinessInfoRvModel;
        boolean z = true;
        FlyImageLoader.loadImageUnspecified(getContext(), homeBusinessInfoRvModel.mShopImg).error((int) R.drawable.customer_skin_img_topgun_placeholder_business_item).placeholder((int) R.drawable.customer_skin_img_topgun_placeholder_business_item).transform(new RoundedCornersTransformation(getContext(), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_40), 0, RoundedCornersTransformation.CornerType.TOP, true)).into(this.f45688a);
        FlyImageLoader.loadImage1x1(getContext(), homeBusinessInfoRvModel.mLogo).centerCrop().transform(new RoundedCornersTransformation(getContext(), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_18), 0, RoundedCornersTransformation.CornerType.ALL, true)).into(this.f45690c);
        this.f45689b.setText(homeBusinessInfoRvModel.mShopName);
        ImageBottomTagEntity imageBottomTagEntity = homeBusinessInfoRvModel.mBottomTagEntity;
        String str = null;
        CharSequence content = imageBottomTagEntity == null ? null : imageBottomTagEntity.getContent();
        if (!(content == null || content.length() == 0)) {
            TextView textView = this.f45695h;
            ImageBottomTagEntity imageBottomTagEntity2 = homeBusinessInfoRvModel.mBottomTagEntity;
            textView.setText(imageBottomTagEntity2 == null ? null : imageBottomTagEntity2.getContent());
            this.f45695h.setVisibility(0);
            this.f45696i.setVisibility(0);
            List<String> color = homeBusinessInfoRvModel.mBottomTagEntity.getColor();
            if (color != null) {
                LottieAnimationView lottieAnimationView = this.f45696i;
                GradientDrawable gradientDrawable = new GradientDrawable();
                try {
                    int[] iArr = new int[color.size()];
                    int i = 0;
                    for (Object next : color) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        iArr[i] = Color.parseColor((String) next);
                        i = i2;
                    }
                    gradientDrawable.setColors(iArr);
                } catch (Exception unused) {
                }
                ImageBottomTagEntity imageBottomTagEntity3 = homeBusinessInfoRvModel.mBottomTagEntity;
                gradientDrawable.setOrientation(ExtentionsKt.updateAngle(gradientDrawable, imageBottomTagEntity3 == null ? null : Integer.valueOf(imageBottomTagEntity3.getAngle())));
                Unit unit = Unit.INSTANCE;
                lottieAnimationView.setBackground(gradientDrawable);
            }
        } else {
            this.f45695h.setVisibility(8);
            this.f45696i.setVisibility(8);
        }
        PromptEntity promptEntity = homeBusinessInfoRvModel.mShopTag;
        CharSequence charSequence = promptEntity == null ? null : promptEntity.content;
        if (!(charSequence == null || charSequence.length() == 0)) {
            z = false;
        }
        if (!z) {
            this.f45694g.setVisibility(0);
            TextView textView2 = this.f45694g;
            PromptEntity promptEntity2 = homeBusinessInfoRvModel.mShopTag;
            if (promptEntity2 != null) {
                str = promptEntity2.content;
            }
            textView2.setText(str);
        } else {
            this.f45694g.setVisibility(8);
        }
        ArrayList arrayList = new ArrayList();
        if (homeBusinessInfoRvModel.mRecInfoList != null) {
            arrayList.addAll(homeBusinessInfoRvModel.mRecInfoList);
        }
        if (homeBusinessInfoRvModel.mRating != null) {
            arrayList.addAll(homeBusinessInfoRvModel.mRating);
        }
        if (homeBusinessInfoRvModel.mFulfillment != null) {
            arrayList.addAll(homeBusinessInfoRvModel.mFulfillment);
        }
        int i3 = this.f45688a.getLayoutParams().width;
        if (this.f45692e.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.LayoutParams layoutParams = this.f45692e.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                i3 = (i3 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        }
        this.f45692e.setDivider("dot");
        this.f45692e.setItemSpace(Float.valueOf(8.0f));
        this.f45692e.setLineSpace(Float.valueOf(0.0f));
        this.f45692e.setData(arrayList, i3);
        if (homeBusinessInfoRvModel.mTags != null) {
            CouponTagFlowLayoutViewV2 couponTagFlowLayoutViewV2 = this.f45693f;
            List<PromptEntity> list = homeBusinessInfoRvModel.mTags;
            Intrinsics.checkNotNullExpressionValue(list, "model.mTags");
            couponTagFlowLayoutViewV2.setData((List<? extends PromptEntity>) list, Integer.MAX_VALUE);
            this.f45693f.setVisibility(0);
            return;
        }
        this.f45693f.setVisibility(8);
    }

    public void onAppear() {
        HomeBusinessInfoRvModel homeBusinessInfoRvModel = this.f45697j;
        boolean z = false;
        if (homeBusinessInfoRvModel != null && homeBusinessInfoRvModel.isShowed) {
            z = true;
        }
        if (!z) {
            HomeBusinessInfoRvModel homeBusinessInfoRvModel2 = this.f45697j;
            if (homeBusinessInfoRvModel2 != null) {
                homeBusinessInfoRvModel2.isShowed = true;
            }
            Function0<Unit> function0 = this.f45698k;
            if (function0 != null) {
                function0.invoke();
            }
            if (!this.f45696i.isAnimating() && this.f45696i.getVisibility() == 0) {
                this.f45696i.playAnimation();
            }
        }
    }
}
