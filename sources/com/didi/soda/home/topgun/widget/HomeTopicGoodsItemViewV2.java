package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.rpc.entity.ButtonInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.ImageBottomTagEntity;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.ExtentionsKt;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0001.B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010(\u001a\u00020\u000bH\u0016J\u0016\u0010)\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/HomeTopicGoodsItemViewV2;", "Lcom/didi/soda/home/topgun/widget/HomeTopicBaseView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "appearListener", "Lkotlin/Function0;", "", "getAppearListener", "()Lkotlin/jvm/functions/Function0;", "setAppearListener", "(Lkotlin/jvm/functions/Function0;)V", "btn", "Landroid/widget/TextView;", "value", "Landroid/view/View$OnClickListener;", "btnClickListener", "getBtnClickListener", "()Landroid/view/View$OnClickListener;", "setBtnClickListener", "(Landroid/view/View$OnClickListener;)V", "image", "Landroid/widget/ImageView;", "logo", "lottieBanner", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieText", "model", "Lcom/didi/soda/business/model/BusinessGoodsItemRvModel;", "nameTv", "originPriceTv", "priceLayout", "Landroid/widget/LinearLayout;", "priceTv", "rootView", "Landroid/view/ViewGroup;", "onAppear", "setData", "isVertical", "", "setMsgOrientation", "orientation", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeTopicGoodsItemViewV2.kt */
public final class HomeTopicGoodsItemViewV2 extends HomeTopicBaseView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private ImageView f45661a;

    /* renamed from: b */
    private TextView f45662b;

    /* renamed from: c */
    private ImageView f45663c;

    /* renamed from: d */
    private TextView f45664d;

    /* renamed from: e */
    private TextView f45665e;

    /* renamed from: f */
    private TextView f45666f;

    /* renamed from: g */
    private LinearLayout f45667g;

    /* renamed from: h */
    private ViewGroup f45668h;

    /* renamed from: i */
    private TextView f45669i;

    /* renamed from: j */
    private LottieAnimationView f45670j;

    /* renamed from: k */
    private View.OnClickListener f45671k;

    /* renamed from: l */
    private Function0<Unit> f45672l;

    /* renamed from: m */
    private BusinessGoodsItemRvModel f45673m;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeTopicGoodsItemViewV2(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeTopicGoodsItemViewV2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeTopicGoodsItemViewV2(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeTopicGoodsItemViewV2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout.inflate(context, R.layout.customer_home_item_topic_good_item_v2, this);
        View findViewById = findViewById(R.id.customer_iv_efo_dish_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_iv_efo_dish_image)");
        this.f45661a = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.customer_iv_home_efo_logo);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_iv_home_efo_logo)");
        this.f45663c = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.customer_tv_home_efo_dish_name);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_tv_home_efo_dish_name)");
        this.f45662b = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.customer_tv_home_efo_price);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.customer_tv_home_efo_price)");
        this.f45664d = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.customer_tv_home_efo_orign_price);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.custom…_tv_home_efo_orign_price)");
        this.f45665e = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.customer_btn_home_efo_buy);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.customer_btn_home_efo_buy)");
        this.f45666f = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.customer_ll_home_efo_price_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.custom…ll_home_efo_price_layout)");
        this.f45667g = (LinearLayout) findViewById7;
        View findViewById8 = findViewById(R.id.customer_cl_efo_item_root);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.customer_cl_efo_item_root)");
        this.f45668h = (ViewGroup) findViewById8;
        View findViewById9 = findViewById(R.id.customer_tv_home_efo_label);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.customer_tv_home_efo_label)");
        this.f45669i = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.customer_tv_home_efo_lottie);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.customer_tv_home_efo_lottie)");
        this.f45670j = (LottieAnimationView) findViewById10;
        this.f45668h.getLayoutParams().height = -1;
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
    }

    public final View.OnClickListener getBtnClickListener() {
        return this.f45671k;
    }

    public final void setBtnClickListener(View.OnClickListener onClickListener) {
        this.f45666f.setOnClickListener(onClickListener);
    }

    public final Function0<Unit> getAppearListener() {
        return this.f45672l;
    }

    public final void setAppearListener(Function0<Unit> function0) {
        this.f45672l = function0;
    }

    public final void setMsgOrientation(int i) {
        this.f45667g.setOrientation(i);
    }

    public final void setData(BusinessGoodsItemRvModel businessGoodsItemRvModel, boolean z) {
        Intrinsics.checkNotNullParameter(businessGoodsItemRvModel, "model");
        this.f45673m = businessGoodsItemRvModel;
        boolean z2 = true;
        FlyImageLoader.loadImage4x3(getContext(), businessGoodsItemRvModel.mItemImg).error((int) R.drawable.customer_skin_img_topgun_placeholder_business_item).placeholder((int) R.drawable.customer_skin_img_topgun_placeholder_business_item).transform(new RoundedCornersTransformation(getContext(), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_40), 0, RoundedCornersTransformation.CornerType.TOP, true)).into(this.f45661a);
        FlyImageLoader.loadImage1x1(getContext(), businessGoodsItemRvModel.mLogo).centerCrop().transform(new RoundedCornersTransformation(getContext(), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_18), 0, RoundedCornersTransformation.CornerType.ALL, true)).into(this.f45663c);
        this.f45662b.setText(businessGoodsItemRvModel.mGoodsName);
        ImageBottomTagEntity imageBottomTagEntity = businessGoodsItemRvModel.mBottomTagEntity;
        String str = null;
        CharSequence content = imageBottomTagEntity == null ? null : imageBottomTagEntity.getContent();
        if (!(content == null || content.length() == 0)) {
            TextView textView = this.f45669i;
            ImageBottomTagEntity imageBottomTagEntity2 = businessGoodsItemRvModel.mBottomTagEntity;
            textView.setText(imageBottomTagEntity2 == null ? null : imageBottomTagEntity2.getContent());
            this.f45669i.setVisibility(0);
            this.f45670j.setVisibility(0);
            List<String> color = businessGoodsItemRvModel.mBottomTagEntity.getColor();
            if (color != null) {
                LottieAnimationView lottieAnimationView = this.f45670j;
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
                ImageBottomTagEntity imageBottomTagEntity3 = businessGoodsItemRvModel.mBottomTagEntity;
                gradientDrawable.setOrientation(ExtentionsKt.updateAngle(gradientDrawable, imageBottomTagEntity3 == null ? null : Integer.valueOf(imageBottomTagEntity3.getAngle())));
                Unit unit = Unit.INSTANCE;
                lottieAnimationView.setBackground(gradientDrawable);
            }
        } else {
            this.f45669i.setVisibility(8);
            this.f45670j.setVisibility(8);
        }
        this.f45664d.setText(businessGoodsItemRvModel.mPriceDesc);
        this.f45665e.setText(businessGoodsItemRvModel.mOriginalPriceDesc);
        this.f45665e.setVisibility(0);
        ButtonInfoEntity buttonInfoEntity = businessGoodsItemRvModel.mBtnInfo;
        if (buttonInfoEntity != null) {
            str = buttonInfoEntity.getContent();
        }
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            ButtonInfoEntity buttonInfoEntity2 = businessGoodsItemRvModel.mBtnInfo;
            this.f45666f.setText(buttonInfoEntity2.getContent());
            Collection color2 = buttonInfoEntity2.getColor();
            if (color2 != null && !color2.isEmpty()) {
                z2 = false;
            }
            if (!z2) {
                List<String> color3 = buttonInfoEntity2.getColor();
                if (color3 != null) {
                    TextView textView2 = this.f45666f;
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    try {
                        int[] iArr2 = new int[color3.size()];
                        int i3 = 0;
                        for (Object next2 : color3) {
                            int i4 = i3 + 1;
                            if (i3 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            iArr2[i3] = Color.parseColor((String) next2);
                            i3 = i4;
                        }
                        gradientDrawable2.setColors(iArr2);
                    } catch (Exception unused2) {
                    }
                    gradientDrawable2.setOrientation(ExtentionsKt.updateAngle(gradientDrawable2, Integer.valueOf(buttonInfoEntity2.getAngle())));
                    gradientDrawable2.setCornerRadius((float) ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_18));
                    Unit unit2 = Unit.INSTANCE;
                    textView2.setBackground(gradientDrawable2);
                }
            } else {
                this.f45666f.setBackgroundResource(R.drawable.customer_shape_bg_order_list_main_button);
            }
            this.f45666f.setVisibility(0);
        } else {
            this.f45666f.setVisibility(8);
        }
        this.f45667g.setOrientation(z ? 1 : 0);
    }

    public void onAppear() {
        BusinessGoodsItemRvModel businessGoodsItemRvModel = this.f45673m;
        boolean z = false;
        if (businessGoodsItemRvModel != null && businessGoodsItemRvModel.isShowed) {
            z = true;
        }
        if (!z) {
            BusinessGoodsItemRvModel businessGoodsItemRvModel2 = this.f45673m;
            if (businessGoodsItemRvModel2 != null) {
                businessGoodsItemRvModel2.isShowed = true;
            }
            Function0<Unit> function0 = this.f45672l;
            if (function0 != null) {
                function0.invoke();
            }
            if (!this.f45670j.isAnimating() && this.f45670j.getVisibility() == 0) {
                this.f45670j.playAnimation();
            }
        }
    }

    @Metadata(mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\"\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0004¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/HomeTopicGoodsItemViewV2$Companion;", "", "()V", "initLayout", "Landroid/widget/LinearLayout;", "isPriceNeedVertical", "", "priceDesc", "", "originPriceDesc", "layout", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: HomeTopicGoodsItemViewV2.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LinearLayout initLayout() {
            View findViewById = LayoutInflater.from(GlobalContext.getContext()).inflate(R.layout.customer_home_topic_good_price_layout, (ViewGroup) null).findViewById(R.id.customer_ll_home_efo_price);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootLayout.findViewById(…stomer_ll_home_efo_price)");
            LinearLayout linearLayout = (LinearLayout) findViewById;
            linearLayout.setOrientation(0);
            return linearLayout;
        }

        public final boolean isPriceNeedVertical(String str, String str2, LinearLayout linearLayout) {
            Intrinsics.checkNotNullParameter(linearLayout, "layout");
            ((TextView) linearLayout.findViewById(R.id.customer_tv_home_efo_price)).setText(str);
            ((TextView) linearLayout.findViewById(R.id.customer_tv_home_efo_orign_price)).setText(str2);
            linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            if (CustomerExtentionKt.getPx(R.dimen.rf_dimen_197) < linearLayout.getMeasuredWidth()) {
                return true;
            }
            return false;
        }
    }
}
