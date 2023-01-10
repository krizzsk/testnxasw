package com.didi.soda.cart.component;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.didi.soda.cart.component.CustomerFloatingCartView;
import com.didi.soda.customer.animation.CustomerInterpolator;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.CustomerCartDiscountParentView;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo148867d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001cH\u0002J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001cH\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001cH\u0002J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001cH\u0002J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001cH\u0002J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001cH\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020\u001cH\u0002J\b\u0010(\u001a\u00020)H\u0002J\u0018\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020-H\u0016J\u001e\u0010.\u001a\u00020)2\u0006\u0010+\u001a\u00020\u001c2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020)00H\u0016J\u0010\u00101\u001a\u00020)2\u0006\u00102\u001a\u00020\u001cH\u0016J\u0010\u00103\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001cH\u0002J\u0018\u00104\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001cH\u0002J\b\u00105\u001a\u00020)H\u0016J\u0010\u00106\u001a\u00020)2\u0006\u0010+\u001a\u00020\u001cH\u0016J\b\u00107\u001a\u00020)H\u0016J\b\u00108\u001a\u00020)H\u0016J\b\u00109\u001a\u00020)H\u0016J\u0018\u0010:\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001cH\u0002R\u000e\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0018XD¢\u0006\u0002\n\u0000¨\u0006;"}, mo148868d2 = {"Lcom/didi/soda/cart/component/FloatingCartAnimationHelper;", "", "context", "Landroid/content/Context;", "rootView", "Landroid/view/View;", "parentBackGroundView", "topBarParentView", "discountRootView", "discountParentView", "Lcom/didi/soda/customer/widget/CustomerCartDiscountParentView;", "discountTextView", "Lcom/didi/soda/customer/widget/text/RichTextView;", "actionBarView", "closeView", "cartParentView", "cartSplitLine", "shoppingCartImage", "Landroid/widget/ImageView;", "recyclerView", "cartViewShadow", "discountShadow", "(Landroid/content/Context;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Lcom/didi/soda/customer/widget/CustomerCartDiscountParentView;Lcom/didi/soda/customer/widget/text/RichTextView;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/widget/ImageView;Landroid/view/View;Landroid/view/View;Landroid/view/View;)V", "alpha", "", "expandAnimatorSet", "Landroid/animation/AnimatorSet;", "shoppingCartExpanded", "", "translationY", "backgroundAnimator", "Landroid/animation/Animator;", "isExpand", "cartShadowAnimation", "cartSplitLineAnimator", "closeAnimator", "discountHorizontalAnimation", "discountShadowAnimation", "discountVerticalAnimator", "Landroid/animation/ValueAnimator;", "endLastAnimation", "", "hideAllView", "hasDiscount", "animationEndListener", "Lcom/didi/soda/cart/component/CustomerFloatingCartView$AnimationEndListener;", "hideCartMenu", "hideCartAnimationEnd", "Lkotlin/Function0;", "playAddToCartAnimation", "isOpen", "radiusAnimator", "recyclerTranslationY", "showBottomCart", "showCartMenu", "showCartNoDiscountTip", "showDiscountTip", "showDiscountTipAndCart", "topBarTranslationY", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FloatingCartAnimationHelper.kt */
public class FloatingCartAnimationHelper {

    /* renamed from: a */
    private Context f42522a;

    /* renamed from: b */
    private View f42523b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f42524c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View f42525d;

    /* renamed from: e */
    private View f42526e;

    /* renamed from: f */
    private CustomerCartDiscountParentView f42527f;

    /* renamed from: g */
    private RichTextView f42528g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public View f42529h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View f42530i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View f42531j;

    /* renamed from: k */
    private View f42532k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public ImageView f42533l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public View f42534m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public View f42535n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public View f42536o;

    /* renamed from: p */
    private final String f42537p = "translationY";

    /* renamed from: q */
    private final String f42538q = "alpha";

    /* renamed from: r */
    private boolean f42539r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public AnimatorSet f42540s;

    public FloatingCartAnimationHelper(Context context, View view, View view2, View view3, View view4, CustomerCartDiscountParentView customerCartDiscountParentView, RichTextView richTextView, View view5, View view6, View view7, View view8, ImageView imageView, View view9, View view10, View view11) {
        Context context2 = context;
        View view12 = view;
        View view13 = view2;
        View view14 = view3;
        View view15 = view4;
        CustomerCartDiscountParentView customerCartDiscountParentView2 = customerCartDiscountParentView;
        RichTextView richTextView2 = richTextView;
        View view16 = view5;
        View view17 = view6;
        View view18 = view7;
        View view19 = view8;
        ImageView imageView2 = imageView;
        View view20 = view9;
        View view21 = view10;
        View view22 = view11;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(view12, "rootView");
        Intrinsics.checkNotNullParameter(view13, "parentBackGroundView");
        Intrinsics.checkNotNullParameter(view14, "topBarParentView");
        Intrinsics.checkNotNullParameter(view15, "discountRootView");
        Intrinsics.checkNotNullParameter(customerCartDiscountParentView2, "discountParentView");
        Intrinsics.checkNotNullParameter(richTextView2, "discountTextView");
        Intrinsics.checkNotNullParameter(view16, "actionBarView");
        Intrinsics.checkNotNullParameter(view17, "closeView");
        Intrinsics.checkNotNullParameter(view18, "cartParentView");
        Intrinsics.checkNotNullParameter(view19, "cartSplitLine");
        Intrinsics.checkNotNullParameter(imageView2, "shoppingCartImage");
        Intrinsics.checkNotNullParameter(view20, "recyclerView");
        Intrinsics.checkNotNullParameter(view21, "cartViewShadow");
        Intrinsics.checkNotNullParameter(view22, "discountShadow");
        this.f42522a = context2;
        this.f42523b = view12;
        this.f42524c = view13;
        this.f42525d = view14;
        this.f42526e = view15;
        this.f42527f = customerCartDiscountParentView2;
        this.f42528g = richTextView2;
        this.f42529h = view16;
        this.f42530i = view17;
        this.f42531j = view18;
        this.f42532k = view19;
        this.f42533l = imageView2;
        this.f42534m = view20;
        this.f42535n = view21;
        this.f42536o = view22;
    }

    public void showDiscountTip() {
        m31963a();
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(300);
        translateAnimation.setInterpolator(CustomerInterpolator.newInstance());
        this.f42525d.startAnimation(translateAnimation);
        this.f42526e.setVisibility(0);
        this.f42525d.setVisibility(0);
    }

    public void showCartNoDiscountTip() {
        m31963a();
        this.f42531j.setVisibility(0);
        this.f42535n.setVisibility(0);
        this.f42529h.setVisibility(8);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f42540s = animatorSet;
        AnimatorSet animatorSet2 = null;
        if (animatorSet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
            animatorSet = null;
        }
        animatorSet.setInterpolator(CustomerInterpolator.newInstance());
        AnimatorSet animatorSet3 = this.f42540s;
        if (animatorSet3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
            animatorSet3 = null;
        }
        animatorSet3.setDuration(300);
        float dimensionPixelSize = (float) ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_156);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f42531j, this.f42537p, new float[]{dimensionPixelSize, 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f42535n, this.f42537p, new float[]{dimensionPixelSize + ((float) ResourceHelper.getDimensionPixelSize(R.dimen.customer_47px)), 0.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f42535n, this.f42538q, new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet4 = this.f42540s;
        if (animatorSet4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
            animatorSet4 = null;
        }
        animatorSet4.play(ofFloat).with(ofFloat2).with(ofFloat3);
        AnimatorSet animatorSet5 = this.f42540s;
        if (animatorSet5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
        } else {
            animatorSet2 = animatorSet5;
        }
        animatorSet2.start();
    }

    public void showDiscountTipAndCart() {
        m31963a();
        CustomerCartDiscountParentView customerCartDiscountParentView = this.f42527f;
        customerCartDiscountParentView.setPadding(customerCartDiscountParentView.getPaddingLeft(), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_24), this.f42527f.getPaddingRight(), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_24));
        this.f42525d.setVisibility(4);
        this.f42531j.setVisibility(4);
        this.f42525d.post(new Runnable() {
            public final void run() {
                FloatingCartAnimationHelper.m31965a(FloatingCartAnimationHelper.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31965a(FloatingCartAnimationHelper floatingCartAnimationHelper) {
        Intrinsics.checkNotNullParameter(floatingCartAnimationHelper, "this$0");
        float dimensionPixelSize = (float) (ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_156) + floatingCartAnimationHelper.f42525d.getHeight());
        floatingCartAnimationHelper.f42531j.setTranslationY(dimensionPixelSize);
        floatingCartAnimationHelper.f42531j.setVisibility(0);
        floatingCartAnimationHelper.f42525d.setTranslationY(dimensionPixelSize);
        floatingCartAnimationHelper.f42525d.setVisibility(0);
        floatingCartAnimationHelper.f42526e.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(floatingCartAnimationHelper.f42531j, floatingCartAnimationHelper.f42537p, new float[]{dimensionPixelSize, 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(floatingCartAnimationHelper.f42525d, floatingCartAnimationHelper.f42537p, new float[]{dimensionPixelSize, 0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setInterpolator(CustomerInterpolator.newInstance());
        animatorSet.setDuration(300);
        animatorSet.start();
    }

    public void showBottomCart() {
        int dimensionPixelSize = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_24);
        int dimensionPixelSize2 = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_24);
        float dimensionPixelSize3 = (float) ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_156);
        m31963a();
        this.f42531j.setVisibility(0);
        this.f42523b.setTranslationY(dimensionPixelSize3);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f42523b, this.f42537p, new float[]{dimensionPixelSize3, 0.0f});
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{dimensionPixelSize, dimensionPixelSize2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FloatingCartAnimationHelper.m31966a(FloatingCartAnimationHelper.this, valueAnimator);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.f42540s = animatorSet;
        AnimatorSet animatorSet2 = null;
        if (animatorSet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
            animatorSet = null;
        }
        animatorSet.setDuration(250);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        arrayList.add(ofInt);
        AnimatorSet animatorSet3 = this.f42540s;
        if (animatorSet3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
            animatorSet3 = null;
        }
        animatorSet3.setInterpolator(CustomerInterpolator.newInstance());
        AnimatorSet animatorSet4 = this.f42540s;
        if (animatorSet4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
            animatorSet4 = null;
        }
        animatorSet4.playTogether(arrayList);
        AnimatorSet animatorSet5 = this.f42540s;
        if (animatorSet5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
        } else {
            animatorSet2 = animatorSet5;
        }
        animatorSet2.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31966a(FloatingCartAnimationHelper floatingCartAnimationHelper, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(floatingCartAnimationHelper, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            int intValue = ((Integer) animatedValue).intValue();
            CustomerCartDiscountParentView customerCartDiscountParentView = floatingCartAnimationHelper.f42527f;
            customerCartDiscountParentView.setPadding(customerCartDiscountParentView.getPaddingLeft(), floatingCartAnimationHelper.f42527f.getPaddingTop(), floatingCartAnimationHelper.f42527f.getPaddingRight(), intValue);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public void showCartMenu(boolean z) {
        m31963a();
        this.f42539r = true;
        AnimatorSet animatorSet = new AnimatorSet();
        this.f42540s = animatorSet;
        if (animatorSet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
            animatorSet = null;
        }
        animatorSet.setDuration(300);
        ArrayList arrayList = new ArrayList();
        arrayList.add(m31977f(true));
        arrayList.add(m31978g(true));
        arrayList.add(m31979h(true));
        if (z) {
            arrayList.add(m31971b(true));
        } else {
            arrayList.add(m31961a(true));
        }
        this.f42534m.setVisibility(4);
        this.f42534m.post(new Runnable(arrayList, this, z) {
            public final /* synthetic */ ArrayList f$0;
            public final /* synthetic */ FloatingCartAnimationHelper f$1;
            public final /* synthetic */ boolean f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                FloatingCartAnimationHelper.m31968a(this.f$0, this.f$1, this.f$2);
            }
        });
        this.f42533l.setImageResource(R.drawable.customer_frame_anim_ic_shopping_bag_open);
        ((AnimationDrawable) this.f42533l.getDrawable().mutate()).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31968a(ArrayList arrayList, FloatingCartAnimationHelper floatingCartAnimationHelper, boolean z) {
        Intrinsics.checkNotNullParameter(arrayList, "$animatorList");
        Intrinsics.checkNotNullParameter(floatingCartAnimationHelper, "this$0");
        arrayList.add(floatingCartAnimationHelper.m31976e(true));
        arrayList.add(floatingCartAnimationHelper.m31972b(true, z));
        arrayList.add(floatingCartAnimationHelper.m31962a(true, z));
        AnimatorSet animatorSet = floatingCartAnimationHelper.f42540s;
        AnimatorSet animatorSet2 = null;
        if (animatorSet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
            animatorSet = null;
        }
        animatorSet.setInterpolator(CustomerInterpolator.newInstance());
        AnimatorSet animatorSet3 = floatingCartAnimationHelper.f42540s;
        if (animatorSet3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
            animatorSet3 = null;
        }
        animatorSet3.playTogether(arrayList);
        AnimatorSet animatorSet4 = floatingCartAnimationHelper.f42540s;
        if (animatorSet4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
        } else {
            animatorSet2 = animatorSet4;
        }
        animatorSet2.start();
    }

    public void hideCartMenu(boolean z, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "hideCartAnimationEnd");
        m31963a();
        this.f42539r = false;
        AnimatorSet animatorSet = new AnimatorSet();
        this.f42540s = animatorSet;
        if (animatorSet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
            animatorSet = null;
        }
        animatorSet.setDuration(300);
        ArrayList arrayList = new ArrayList();
        arrayList.add(m31977f(false));
        arrayList.add(m31978g(false));
        arrayList.add(m31979h(false));
        if (z) {
            arrayList.add(m31971b(false));
        } else {
            arrayList.add(m31961a(false));
        }
        this.f42534m.post(new Runnable(arrayList, this, z, function0) {
            public final /* synthetic */ ArrayList f$0;
            public final /* synthetic */ FloatingCartAnimationHelper f$1;
            public final /* synthetic */ boolean f$2;
            public final /* synthetic */ Function0 f$3;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void run() {
                FloatingCartAnimationHelper.m31969a(this.f$0, this.f$1, this.f$2, this.f$3);
            }
        });
        this.f42533l.setImageResource(R.drawable.customer_frame_anim_ic_shopping_bag_close);
        ((AnimationDrawable) this.f42533l.getDrawable().mutate()).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31969a(ArrayList arrayList, FloatingCartAnimationHelper floatingCartAnimationHelper, boolean z, Function0 function0) {
        Intrinsics.checkNotNullParameter(arrayList, "$animatorList");
        Intrinsics.checkNotNullParameter(floatingCartAnimationHelper, "this$0");
        Intrinsics.checkNotNullParameter(function0, "$hideCartAnimationEnd");
        arrayList.add(floatingCartAnimationHelper.m31976e(false));
        arrayList.add(floatingCartAnimationHelper.m31972b(false, z));
        arrayList.add(floatingCartAnimationHelper.m31962a(false, z));
        AnimatorSet animatorSet = floatingCartAnimationHelper.f42540s;
        AnimatorSet animatorSet2 = null;
        if (animatorSet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
            animatorSet = null;
        }
        animatorSet.setInterpolator(CustomerInterpolator.newInstance());
        AnimatorSet animatorSet3 = floatingCartAnimationHelper.f42540s;
        if (animatorSet3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
            animatorSet3 = null;
        }
        animatorSet3.playTogether(arrayList);
        AnimatorSet animatorSet4 = floatingCartAnimationHelper.f42540s;
        if (animatorSet4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
            animatorSet4 = null;
        }
        animatorSet4.addListener(new FloatingCartAnimationHelper$hideCartMenu$1$1(function0, floatingCartAnimationHelper));
        AnimatorSet animatorSet5 = floatingCartAnimationHelper.f42540s;
        if (animatorSet5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
        } else {
            animatorSet2 = animatorSet5;
        }
        animatorSet2.start();
    }

    public void playAddToCartAnimation(boolean z) {
        if (z) {
            this.f42533l.setImageResource(R.drawable.customer_frame_anim_ic_shopping_bag_open);
            ((AnimationDrawable) this.f42533l.getDrawable().mutate()).start();
            return;
        }
        this.f42533l.setImageResource(R.drawable.customer_frame_anim_ic_shopping_bag_close);
        ((AnimationDrawable) this.f42533l.getDrawable().mutate()).start();
    }

    /* renamed from: a */
    private final Animator m31961a(boolean z) {
        float f = 1.0f;
        float f2 = 0.0f;
        if (!z) {
            f = 0.0f;
            f2 = 1.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f42535n, this.f42538q, new float[]{f, f2});
        if (!z) {
            ofFloat.addListener(new FloatingCartAnimationHelper$cartShadowAnimation$1(this));
        }
        Intrinsics.checkNotNullExpressionValue(ofFloat, "animation");
        return ofFloat;
    }

    /* renamed from: b */
    private final Animator m31971b(boolean z) {
        float f = 1.0f;
        float f2 = 0.0f;
        if (!z) {
            f = 0.0f;
            f2 = 1.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f42536o, this.f42538q, new float[]{f, f2});
        if (!z) {
            ofFloat.addListener(new FloatingCartAnimationHelper$discountShadowAnimation$1(this));
        }
        Intrinsics.checkNotNullExpressionValue(ofFloat, "animation");
        return ofFloat;
    }

    /* renamed from: c */
    private final Animator m31974c(boolean z) {
        int i;
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        int dimensionPixelSize = ResourceHelper.getDimensionPixelSize(R.dimen.customer_120px);
        if (!z) {
            i = ResourceHelper.getDimensionPixelSize(R.dimen.customer_40px);
        } else if (this.f42528g.getLineCount() > 1 || this.f42528g.getLineCount() == 0) {
            i = dimensionPixelSize;
        } else {
            booleanRef.element = true;
            i = Math.max(((((CustomerSystemUtil.getScreenWidth(this.f42522a) - (dimensionPixelSize * 2)) - ResourceHelper.getDimensionPixelSize(R.dimen.customer_50px)) - this.f42528g.getWidth()) / 2) + dimensionPixelSize, dimensionPixelSize);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f42527f.getPaddingLeft(), i});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(z, booleanRef, dimensionPixelSize) {
            public final /* synthetic */ boolean f$1;
            public final /* synthetic */ Ref.BooleanRef f$2;
            public final /* synthetic */ int f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FloatingCartAnimationHelper.m31967a(FloatingCartAnimationHelper.this, this.f$1, this.f$2, this.f$3, valueAnimator);
            }
        });
        Intrinsics.checkNotNullExpressionValue(ofInt, "discountRightAnimation");
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31967a(FloatingCartAnimationHelper floatingCartAnimationHelper, boolean z, Ref.BooleanRef booleanRef, int i, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(floatingCartAnimationHelper, "this$0");
        Intrinsics.checkNotNullParameter(booleanRef, "$defaultOneLine");
        if (floatingCartAnimationHelper.f42528g.getLineCount() <= 1 || !z || !booleanRef.element) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                int intValue = ((Integer) animatedValue).intValue();
                CustomerCartDiscountParentView customerCartDiscountParentView = floatingCartAnimationHelper.f42527f;
                customerCartDiscountParentView.setPadding(intValue, customerCartDiscountParentView.getPaddingTop(), intValue, floatingCartAnimationHelper.f42527f.getPaddingBottom());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        CustomerCartDiscountParentView customerCartDiscountParentView2 = floatingCartAnimationHelper.f42527f;
        customerCartDiscountParentView2.setPadding(i, customerCartDiscountParentView2.getPaddingTop(), i, floatingCartAnimationHelper.f42527f.getPaddingBottom());
    }

    /* renamed from: d */
    private final ValueAnimator m31975d(boolean z) {
        int i;
        int i2;
        int dimensionPixelSize = ResourceHelper.getDimensionPixelSize(R.dimen.customer_112px);
        if (z) {
            i2 = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_24);
            i = dimensionPixelSize;
        } else {
            int paddingTop = this.f42527f.getPaddingTop();
            i = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_24);
            i2 = paddingTop;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i2, i});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(z, this, dimensionPixelSize) {
            public final /* synthetic */ boolean f$0;
            public final /* synthetic */ FloatingCartAnimationHelper f$1;
            public final /* synthetic */ int f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FloatingCartAnimationHelper.m31970a(this.f$0, this.f$1, this.f$2, valueAnimator);
            }
        });
        Intrinsics.checkNotNullExpressionValue(ofInt, "discountVerticalAnimation");
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31970a(boolean z, FloatingCartAnimationHelper floatingCartAnimationHelper, int i, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(floatingCartAnimationHelper, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            int intValue = ((Integer) animatedValue).intValue();
            if (z) {
                int height = (floatingCartAnimationHelper.f42527f.getHeight() - floatingCartAnimationHelper.f42527f.getPaddingBottom()) - floatingCartAnimationHelper.f42527f.getPaddingTop();
                if ((intValue * 2) + height > i) {
                    int i2 = (i - height) / 2;
                    CustomerCartDiscountParentView customerCartDiscountParentView = floatingCartAnimationHelper.f42527f;
                    customerCartDiscountParentView.setPadding(customerCartDiscountParentView.getPaddingLeft(), i2, floatingCartAnimationHelper.f42527f.getPaddingRight(), i2);
                    return;
                }
                CustomerCartDiscountParentView customerCartDiscountParentView2 = floatingCartAnimationHelper.f42527f;
                customerCartDiscountParentView2.setPadding(customerCartDiscountParentView2.getPaddingLeft(), intValue, floatingCartAnimationHelper.f42527f.getPaddingRight(), intValue);
                return;
            }
            CustomerCartDiscountParentView customerCartDiscountParentView3 = floatingCartAnimationHelper.f42527f;
            customerCartDiscountParentView3.setPadding(customerCartDiscountParentView3.getPaddingLeft(), intValue, floatingCartAnimationHelper.f42527f.getPaddingRight(), intValue);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    /* renamed from: e */
    private final Animator m31976e(boolean z) {
        int dimensionPixelSize = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_40);
        int dimensionPixelSize2 = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_40);
        if (!z) {
            int i = dimensionPixelSize;
            dimensionPixelSize = dimensionPixelSize2;
            dimensionPixelSize2 = i;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) dimensionPixelSize, (float) dimensionPixelSize2});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener((GradientDrawable) this.f42527f.getBackground().mutate()) {
            public final /* synthetic */ GradientDrawable f$0;

            {
                this.f$0 = r1;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FloatingCartAnimationHelper.m31964a(this.f$0, valueAnimator);
            }
        });
        Intrinsics.checkNotNullExpressionValue(ofFloat, "radiusAnimator");
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31964a(GradientDrawable gradientDrawable, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(gradientDrawable, "$gradientDrawable");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            float floatValue = ((Float) animatedValue).floatValue();
            gradientDrawable.setCornerRadii(new float[]{floatValue, floatValue, floatValue, floatValue, 0.0f, 0.0f, 0.0f, 0.0f});
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004d A[ADDED_TO_REGION] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.animation.Animator m31962a(boolean r7, boolean r8) {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            if (r8 == 0) goto L_0x001d
            if (r7 == 0) goto L_0x0012
            android.view.View r2 = r6.f42525d
            r2.setVisibility(r1)
            android.view.View r2 = r6.f42534m
            int r2 = r2.getHeight()
            goto L_0x003b
        L_0x0012:
            android.view.View r2 = r6.f42534m
            int r2 = r2.getHeight()
            float r2 = (float) r2
            float r2 = -r2
            r0 = r2
            r2 = 0
            goto L_0x0049
        L_0x001d:
            android.view.View r0 = r6.f42525d
            int r0 = r0.getHeight()
            float r0 = (float) r0
            if (r7 == 0) goto L_0x003e
            android.view.View r2 = r6.f42525d
            r2.setTranslationY(r0)
            android.view.View r2 = r6.f42525d
            r2.setVisibility(r1)
            android.view.View r2 = r6.f42529h
            r2.setVisibility(r1)
            android.view.View r2 = r6.f42534m
            int r2 = r2.getHeight()
        L_0x003b:
            float r2 = (float) r2
            float r2 = -r2
            goto L_0x0049
        L_0x003e:
            android.view.View r2 = r6.f42534m
            int r2 = r2.getHeight()
            float r2 = (float) r2
            float r2 = -r2
            r5 = r2
            r2 = r0
            r0 = r5
        L_0x0049:
            r3 = 1
            r4 = 2
            if (r7 != 0) goto L_0x006f
            if (r8 != 0) goto L_0x006f
            android.view.View r7 = r6.f42525d
            java.lang.String r8 = r6.f42537p
            float[] r4 = new float[r4]
            r4[r1] = r0
            r4[r3] = r2
            android.animation.ObjectAnimator r7 = android.animation.ObjectAnimator.ofFloat(r7, r8, r4)
            com.didi.soda.cart.component.FloatingCartAnimationHelper$topBarTranslationY$1 r8 = new com.didi.soda.cart.component.FloatingCartAnimationHelper$topBarTranslationY$1
            r8.<init>(r6)
            android.animation.Animator$AnimatorListener r8 = (android.animation.Animator.AnimatorListener) r8
            r7.addListener(r8)
            java.lang.String r8 = "expandAnimation"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            android.animation.Animator r7 = (android.animation.Animator) r7
            return r7
        L_0x006f:
            android.view.View r7 = r6.f42525d
            java.lang.String r8 = r6.f42537p
            float[] r4 = new float[r4]
            r4[r1] = r0
            r4[r3] = r2
            android.animation.ObjectAnimator r7 = android.animation.ObjectAnimator.ofFloat(r7, r8, r4)
            java.lang.String r8 = "ofFloat(topBarParentView…nY, startValue, endValue)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            android.animation.Animator r7 = (android.animation.Animator) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.cart.component.FloatingCartAnimationHelper.m31962a(boolean, boolean):android.animation.Animator");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0046  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.animation.Animator m31972b(boolean r6, boolean r7) {
        /*
            r5 = this;
            android.view.View r0 = r5.f42534m
            int r0 = r0.getHeight()
            float r0 = (float) r0
            android.view.View r1 = r5.f42525d
            int r1 = r1.getHeight()
            float r1 = (float) r1
            r2 = 0
            if (r7 == 0) goto L_0x0019
            if (r6 == 0) goto L_0x0023
            android.view.View r7 = r5.f42534m
            r7.setTranslationY(r0)
            goto L_0x0025
        L_0x0019:
            if (r6 == 0) goto L_0x0022
            android.view.View r7 = r5.f42534m
            float r0 = r0 + r1
            r7.setTranslationY(r0)
            goto L_0x0025
        L_0x0022:
            float r0 = r0 + r1
        L_0x0023:
            r2 = r0
            r0 = 0
        L_0x0025:
            r7 = 1
            r1 = 2
            r3 = 0
            if (r6 == 0) goto L_0x0046
            android.view.View r6 = r5.f42534m
            r6.setVisibility(r3)
            android.view.View r6 = r5.f42534m
            java.lang.String r4 = r5.f42537p
            float[] r1 = new float[r1]
            r1[r3] = r0
            r1[r7] = r2
            android.animation.ObjectAnimator r6 = android.animation.ObjectAnimator.ofFloat(r6, r4, r1)
            java.lang.String r7 = "{\n            recyclerVi…alue, endValue)\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            android.animation.Animator r6 = (android.animation.Animator) r6
            goto L_0x0066
        L_0x0046:
            android.view.View r6 = r5.f42534m
            java.lang.String r4 = r5.f42537p
            float[] r1 = new float[r1]
            r1[r3] = r0
            r1[r7] = r2
            android.animation.ObjectAnimator r6 = android.animation.ObjectAnimator.ofFloat(r6, r4, r1)
            com.didi.soda.cart.component.FloatingCartAnimationHelper$recyclerTranslationY$1 r7 = new com.didi.soda.cart.component.FloatingCartAnimationHelper$recyclerTranslationY$1
            r7.<init>(r5)
            android.animation.Animator$AnimatorListener r7 = (android.animation.Animator.AnimatorListener) r7
            r6.addListener(r7)
            java.lang.String r7 = "private fun recyclerTran…Animation\n        }\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            android.animation.Animator r6 = (android.animation.Animator) r6
        L_0x0066:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.cart.component.FloatingCartAnimationHelper.m31972b(boolean, boolean):android.animation.Animator");
    }

    /* renamed from: f */
    private final Animator m31977f(boolean z) {
        float f = 0.0f;
        float f2 = 1.0f;
        if (!z) {
            f = 1.0f;
            f2 = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f42530i, this.f42538q, new float[]{f, f2});
        if (!z) {
            ofFloat.addListener(new FloatingCartAnimationHelper$closeAnimator$1(this));
        } else {
            this.f42530i.setVisibility(0);
            ofFloat.setStartDelay(100);
        }
        Intrinsics.checkNotNullExpressionValue(ofFloat, "closeAlphaAnimation");
        return ofFloat;
    }

    /* renamed from: g */
    private final Animator m31978g(boolean z) {
        float f = 0.0f;
        float f2 = 1.0f;
        if (!z) {
            f = 1.0f;
            f2 = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f42532k, this.f42538q, new float[]{f, f2});
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(cartSplitLine, a…ha, startValue, endValue)");
        return ofFloat;
    }

    /* renamed from: h */
    private final Animator m31979h(boolean z) {
        if (z) {
            this.f42524c.setAlpha(0.0f);
            this.f42524c.setVisibility(0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f42524c, this.f42538q, new float[]{0.0f, 0.5f});
            Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(parentBackGroundView, alpha, 0f, 0.5f)");
            return ofFloat;
        }
        View view = this.f42524c;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, this.f42538q, new float[]{view.getAlpha(), 0.0f});
        ofFloat2.addListener(new FloatingCartAnimationHelper$backgroundAnimator$1(this));
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "bgAnimator");
        return ofFloat2;
    }

    /* renamed from: a */
    private final void m31963a() {
        this.f42527f.setActionBarStyle(false);
        AnimatorSet animatorSet = this.f42540s;
        if (animatorSet != null) {
            if (animatorSet == null) {
                Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
                animatorSet = null;
            }
            animatorSet.end();
        }
    }

    public void hideAllView(boolean z, CustomerFloatingCartView.AnimationEndListener animationEndListener) {
        int i;
        Animator animator;
        Intrinsics.checkNotNullParameter(animationEndListener, "animationEndListener");
        m31963a();
        int dimensionPixelSize = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_24);
        int dimensionPixelSize2 = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_24);
        AnimatorSet animatorSet = null;
        if (z) {
            i = this.f42534m.getHeight() + ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_156);
            animator = ValueAnimator.ofInt(new int[]{dimensionPixelSize, dimensionPixelSize2});
            ((ValueAnimator) animator).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FloatingCartAnimationHelper.m31973b(FloatingCartAnimationHelper.this, valueAnimator);
                }
            });
        } else {
            i = this.f42534m.getHeight() + ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_156) + ResourceHelper.getDimensionPixelSize(R.dimen.customer_112px);
            animator = null;
        }
        View view = this.f42534m;
        float f = (float) i;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, this.f42537p, new float[]{view.getTranslationY(), f});
        View view2 = this.f42531j;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, this.f42537p, new float[]{view2.getTranslationY(), f});
        float height = (float) this.f42531j.getHeight();
        if (!z) {
            height += (float) this.f42525d.getHeight();
        }
        View view3 = this.f42525d;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view3, this.f42537p, new float[]{view3.getTranslationY(), height});
        ArrayList arrayList = new ArrayList();
        arrayList.add(m31977f(false));
        arrayList.add(m31978g(false));
        arrayList.add(m31976e(false));
        arrayList.add(ofFloat3);
        arrayList.add(m31979h(false));
        arrayList.add(m31971b(false));
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        if (animator != null) {
            arrayList.add(animator);
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f42540s = animatorSet2;
        if (animatorSet2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
            animatorSet2 = null;
        }
        animatorSet2.setDuration(300);
        AnimatorSet animatorSet3 = this.f42540s;
        if (animatorSet3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
            animatorSet3 = null;
        }
        animatorSet3.setInterpolator(CustomerInterpolator.newInstance());
        AnimatorSet animatorSet4 = this.f42540s;
        if (animatorSet4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
            animatorSet4 = null;
        }
        animatorSet4.playTogether(arrayList);
        AnimatorSet animatorSet5 = this.f42540s;
        if (animatorSet5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
            animatorSet5 = null;
        }
        animatorSet5.addListener(new FloatingCartAnimationHelper$hideAllView$3(this, z, animationEndListener));
        AnimatorSet animatorSet6 = this.f42540s;
        if (animatorSet6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandAnimatorSet");
        } else {
            animatorSet = animatorSet6;
        }
        animatorSet.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m31973b(FloatingCartAnimationHelper floatingCartAnimationHelper, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(floatingCartAnimationHelper, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            int intValue = ((Integer) animatedValue).intValue();
            CustomerCartDiscountParentView customerCartDiscountParentView = floatingCartAnimationHelper.f42527f;
            customerCartDiscountParentView.setPadding(customerCartDiscountParentView.getPaddingLeft(), floatingCartAnimationHelper.f42527f.getPaddingTop(), floatingCartAnimationHelper.f42527f.getPaddingRight(), intValue);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
