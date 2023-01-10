package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.soda.customer.foundation.rpc.entity.ImageBottomTagEntity;
import com.didi.soda.customer.foundation.util.ExtentionsKt;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010'\u001a\u00020\u000bH\u0016J\u000e\u0010(\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/HomeTopicShopItemViewV2;", "Lcom/didi/soda/home/topgun/widget/HomeTopicBaseView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "appearListener", "Lkotlin/Function0;", "", "getAppearListener", "()Lkotlin/jvm/functions/Function0;", "setAppearListener", "(Lkotlin/jvm/functions/Function0;)V", "divider", "Landroid/view/View;", "fulfillmentLayout", "Lcom/didi/soda/home/topgun/widget/HomeBusinessGrid;", "honorImg", "Landroid/widget/ImageView;", "image", "logo", "lottieBanner", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieText", "Landroid/widget/TextView;", "mCornerType", "Lcom/didi/app/nova/skeleton/image/RoundedCornersTransformation$CornerType;", "model", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "nameTv", "ratingLayout", "recLayout", "recParent", "Landroid/widget/LinearLayout;", "rootView", "Landroid/view/ViewGroup;", "onAppear", "setData", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeTopicShopItemViewV2.kt */
public final class HomeTopicShopItemViewV2 extends HomeTopicBaseView {

    /* renamed from: a */
    private ImageView f45699a;

    /* renamed from: b */
    private TextView f45700b;

    /* renamed from: c */
    private ImageView f45701c;

    /* renamed from: d */
    private ImageView f45702d;

    /* renamed from: e */
    private ViewGroup f45703e;

    /* renamed from: f */
    private HomeBusinessGrid f45704f;

    /* renamed from: g */
    private HomeBusinessGrid f45705g;

    /* renamed from: h */
    private LinearLayout f45706h;

    /* renamed from: i */
    private View f45707i;

    /* renamed from: j */
    private HomeBusinessGrid f45708j;

    /* renamed from: k */
    private RoundedCornersTransformation.CornerType f45709k;

    /* renamed from: l */
    private TextView f45710l;

    /* renamed from: m */
    private LottieAnimationView f45711m;

    /* renamed from: n */
    private HomeBusinessInfoRvModel f45712n;

    /* renamed from: o */
    private Function0<Unit> f45713o;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeTopicShopItemViewV2(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeTopicShopItemViewV2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeTopicShopItemViewV2(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeTopicShopItemViewV2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f45709k = RoundedCornersTransformation.CornerType.ALL;
        FrameLayout.inflate(context, R.layout.customer_home_item_topic_shop_item_v2, this);
        View findViewById = findViewById(R.id.customer_iv_efo_dish_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_iv_efo_dish_image)");
        this.f45699a = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.customer_iv_home_efo_logo);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_iv_home_efo_logo)");
        this.f45701c = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.customer_tv_home_efo_dish_name);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_tv_home_efo_dish_name)");
        this.f45700b = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.customer_iv_home_topic_business_honor_img);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.custom…topic_business_honor_img)");
        this.f45702d = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.customer_cl_efo_item_root);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.customer_cl_efo_item_root)");
        this.f45703e = (ViewGroup) findViewById5;
        View findViewById6 = findViewById(R.id.customer_topic_tv_shop_rating_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.custom…ic_tv_shop_rating_layout)");
        this.f45704f = (HomeBusinessGrid) findViewById6;
        View findViewById7 = findViewById(R.id.customer_topic_tv_shop_fulfillment_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.custom…_shop_fulfillment_layout)");
        this.f45705g = (HomeBusinessGrid) findViewById7;
        View findViewById8 = findViewById(R.id.customer_topic_v_shop_divider);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.customer_topic_v_shop_divider)");
        this.f45707i = findViewById8;
        View findViewById9 = findViewById(R.id.customer_topic_tv_shop_rec_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.custom…topic_tv_shop_rec_layout)");
        this.f45708j = (HomeBusinessGrid) findViewById9;
        View findViewById10 = findViewById(R.id.customer_topic_ll_shop_rec);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.customer_topic_ll_shop_rec)");
        this.f45706h = (LinearLayout) findViewById10;
        View findViewById11 = findViewById(R.id.customer_tv_home_efo_label);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.customer_tv_home_efo_label)");
        this.f45710l = (TextView) findViewById11;
        View findViewById12 = findViewById(R.id.customer_tv_home_efo_lottie);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.customer_tv_home_efo_lottie)");
        this.f45711m = (LottieAnimationView) findViewById12;
        this.f45703e.getLayoutParams().height = -1;
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
    }

    public final Function0<Unit> getAppearListener() {
        return this.f45713o;
    }

    public final void setAppearListener(Function0<Unit> function0) {
        this.f45713o = function0;
    }

    public final void setData(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "model");
        this.f45712n = homeBusinessInfoRvModel;
        FlyImageLoader.loadImage4x3(getContext(), homeBusinessInfoRvModel.mShopImg).error((int) R.drawable.customer_skin_img_topgun_placeholder_business_item).placeholder((int) R.drawable.customer_skin_img_topgun_placeholder_business_item).transform(new RoundedCornersTransformation(getContext(), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_40), 0, RoundedCornersTransformation.CornerType.TOP, true)).into(this.f45699a);
        FlyImageLoader.loadImage1x1(getContext(), homeBusinessInfoRvModel.mLogo).centerCrop().transform(new RoundedCornersTransformation(getContext(), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_20), 0, RoundedCornersTransformation.CornerType.ALL, true)).into(this.f45701c);
        this.f45700b.setText(homeBusinessInfoRvModel.mShopName);
        CharSequence charSequence = homeBusinessInfoRvModel.mHonorIconUrl;
        if (charSequence == null || charSequence.length() == 0) {
            this.f45702d.setVisibility(8);
        } else {
            this.f45702d.setVisibility(0);
            FlyImageLoader.loadImage1x1(getContext(), homeBusinessInfoRvModel.mHonorIconUrl).transform(new RoundedCornersTransformation(getContext(), 0, 0, this.f45709k, true)).into(this.f45702d);
        }
        ImageBottomTagEntity imageBottomTagEntity = homeBusinessInfoRvModel.mBottomTagEntity;
        Integer num = null;
        CharSequence content = imageBottomTagEntity == null ? null : imageBottomTagEntity.getContent();
        if (!(content == null || content.length() == 0)) {
            TextView textView = this.f45710l;
            ImageBottomTagEntity imageBottomTagEntity2 = homeBusinessInfoRvModel.mBottomTagEntity;
            textView.setText(imageBottomTagEntity2 == null ? null : imageBottomTagEntity2.getContent());
            this.f45710l.setVisibility(0);
            this.f45711m.setVisibility(0);
            List<String> color = homeBusinessInfoRvModel.mBottomTagEntity.getColor();
            if (color != null) {
                LottieAnimationView lottieAnimationView = this.f45711m;
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
                if (imageBottomTagEntity3 != null) {
                    num = Integer.valueOf(imageBottomTagEntity3.getAngle());
                }
                gradientDrawable.setOrientation(ExtentionsKt.updateAngle(gradientDrawable, num));
                Unit unit = Unit.INSTANCE;
                lottieAnimationView.setBackground(gradientDrawable);
            }
        } else {
            this.f45710l.setVisibility(8);
            this.f45711m.setVisibility(8);
        }
        int dimensionPixelSize = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_288) - ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_48);
        Collection collection = homeBusinessInfoRvModel.mRating;
        if (!(collection == null || collection.isEmpty())) {
            this.f45704f.setVisibility(0);
            this.f45704f.setItemSpace(Float.valueOf(20.0f));
            this.f45704f.setLineSpace(Float.valueOf(0.0f));
            this.f45704f.setExactlyHeight(true);
            this.f45704f.setData(homeBusinessInfoRvModel.mRating, dimensionPixelSize);
        } else if (homeBusinessInfoRvModel.linesVisibleModel.isHasRatingLine()) {
            this.f45704f.setVisibility(4);
        } else {
            this.f45704f.setVisibility(8);
        }
        Collection collection2 = homeBusinessInfoRvModel.mFulfillment;
        if (!(collection2 == null || collection2.isEmpty())) {
            this.f45705g.setVisibility(0);
            this.f45705g.setDivider("dot");
            this.f45705g.setItemSpace(Float.valueOf(8.0f));
            this.f45705g.setExactlyHeight(true);
            this.f45705g.setData(homeBusinessInfoRvModel.mFulfillment, dimensionPixelSize);
        } else if (homeBusinessInfoRvModel.linesVisibleModel.isHasFulfillmentLine()) {
            this.f45705g.setVisibility(4);
        } else {
            this.f45705g.setVisibility(8);
        }
        if (homeBusinessInfoRvModel.mRecInfo != null) {
            CharSequence charSequence2 = homeBusinessInfoRvModel.mRecInfo.content;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                this.f45706h.setVisibility(0);
                this.f45708j.setExactlyHeight(true);
                this.f45708j.setData(CollectionsKt.mutableListOf(homeBusinessInfoRvModel.mRecInfo), dimensionPixelSize);
                return;
            }
        }
        if (homeBusinessInfoRvModel.linesVisibleModel.isHasRecLine()) {
            this.f45706h.setVisibility(4);
        } else {
            this.f45706h.setVisibility(8);
        }
    }

    public void onAppear() {
        HomeBusinessInfoRvModel homeBusinessInfoRvModel = this.f45712n;
        boolean z = false;
        if (homeBusinessInfoRvModel != null && homeBusinessInfoRvModel.isShowed) {
            z = true;
        }
        if (!z) {
            HomeBusinessInfoRvModel homeBusinessInfoRvModel2 = this.f45712n;
            if (homeBusinessInfoRvModel2 != null) {
                homeBusinessInfoRvModel2.isShowed = true;
            }
            Function0<Unit> function0 = this.f45713o;
            if (function0 != null) {
                function0.invoke();
            }
            if (!this.f45711m.isAnimating() && this.f45711m.getVisibility() == 0) {
                this.f45711m.playAnimation();
            }
        }
    }
}
