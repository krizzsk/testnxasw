package com.didi.soda.cart.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.soda.cart.binder.CustomerCartPresentMenuBinder;
import com.didi.soda.cart.binder.CustomerTyingCartBinder;
import com.didi.soda.cart.component.Contract;
import com.didi.soda.cart.model.CartInfoModel;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.ClickUtils;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.CustomerCartDiscountParentView;
import com.didi.soda.customer.widget.MaxHeightNovaRecyclerView;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 U2\u00020\u0001:\u0002TUB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u00105\u001a\u000206H\u0014J\u0006\u00107\u001a\u000208J\u0018\u00109\u001a\u0002032\u0006\u0010:\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u0014H\u0002J\b\u0010<\u001a\u00020\u0014H\u0002J\b\u0010=\u001a\u000203H\u0016J\b\u0010>\u001a\u000203H\u0016J\b\u0010?\u001a\u000203H\u0002J\b\u0010@\u001a\u000203H\u0016J\u0018\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0014J\b\u0010F\u001a\u000203H\u0014J\u0006\u0010G\u001a\u00020\u0014J\b\u0010H\u001a\u000203H\u0016J\u000e\u0010I\u001a\u0002032\u0006\u0010J\u001a\u00020\u0014J\u0010\u0010K\u001a\u0002032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010L\u001a\u000203H\u0016J\u0010\u0010M\u001a\u0002032\u0006\u0010;\u001a\u00020\u0014H\u0016J\b\u0010N\u001a\u000203H\u0016J\b\u0010O\u001a\u000203H\u0016J\u0018\u0010P\u001a\u0002032\u0006\u00104\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020\u0014H\u0016J\u0010\u0010R\u001a\u0002032\u0006\u0010S\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000¨\u0006V"}, mo148868d2 = {"Lcom/didi/soda/cart/component/CustomerFloatingCartView;", "Lcom/didi/soda/cart/component/Contract$AbsFloatingCartView;", "()V", "actionBarCloseView", "Landroid/view/View;", "actionBarView", "animationHelper", "Lcom/didi/soda/cart/component/FloatingCartAnimationHelper;", "businessStatus", "", "cartInfoModel", "Lcom/didi/soda/cart/model/CartInfoModel;", "cartParentClickView", "cartParentView", "cartSplitLine", "cartTotalAmountView", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "cartViewShadow", "checkoutView", "deleteSkuFlag", "", "discountCloseView", "discountContentView", "Lcom/didi/soda/customer/widget/text/RichTextView;", "discountParentView", "Lcom/didi/soda/customer/widget/CustomerCartDiscountParentView;", "discountRootView", "discountShadow", "hideCartMenuClickListener", "Landroid/view/View$OnClickListener;", "lastFavorTip", "", "loadingView", "Lcom/didi/soda/customer/widget/loading/LottieLoadingView;", "mCartMenuBgView", "mCartRootBgView", "originPriceView", "parentBackGroundView", "priceParentView", "recyclerView", "Lcom/didi/soda/customer/widget/MaxHeightNovaRecyclerView;", "rootView", "rvChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "rvParentView", "rvScrollShadow", "shoppingCartImage", "Landroid/widget/ImageView;", "topBarParentView", "totalPriceView", "discountReplaceActionBar", "", "model", "generateNovaRecyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/INovaRecyclerView;", "getShoppingCartPosition", "", "handleCartRootBg", "isMenuOpen", "isForce", "hasDiscount", "hideAllCartView", "hideCartMenu", "hideDiscountAndCartBgView", "hidePriceLoading", "inflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initItemBinders", "isFloatingCartExpand", "onCreate", "playAddToCartAnimation", "isOpen", "setBusinessStatus", "setSkuDeleteFlag", "showBottomCartCard", "showCartMenu", "showPriceLoading", "updateCartInfo", "firstLoadPage", "updateCartTotalAmount", "amount", "AnimationEndListener", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CustomerFloatingCartView.kt */
public final class CustomerFloatingCartView extends Contract.AbsFloatingCartView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "CustomerFloatingCartView";
    /* access modifiers changed from: private */

    /* renamed from: A */
    public CartInfoModel f42489A;

    /* renamed from: B */
    private String f42490B;

    /* renamed from: C */
    private boolean f42491C;

    /* renamed from: D */
    private int f42492D = 1;

    /* renamed from: E */
    private FloatingCartAnimationHelper f42493E;

    /* renamed from: F */
    private final View.OnClickListener f42494F = new View.OnClickListener() {
        public final void onClick(View view) {
            CustomerFloatingCartView.m31952a(CustomerFloatingCartView.this, view);
        }
    };

    /* renamed from: G */
    private final View.OnLayoutChangeListener f42495G = new View.OnLayoutChangeListener() {
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            CustomerFloatingCartView.m31953a(CustomerFloatingCartView.this, view, i, i2, i3, i4, i5, i6, i7, i8);
        }
    };

    /* renamed from: a */
    private View f42496a;

    /* renamed from: b */
    private View f42497b;

    /* renamed from: c */
    private View f42498c;

    /* renamed from: d */
    private CustomerCartDiscountParentView f42499d;

    /* renamed from: e */
    private View f42500e;

    /* renamed from: f */
    private View f42501f;

    /* renamed from: g */
    private View f42502g;

    /* renamed from: h */
    private View f42503h;

    /* renamed from: i */
    private View f42504i;

    /* renamed from: j */
    private View f42505j;

    /* renamed from: k */
    private RichTextView f42506k;

    /* renamed from: l */
    private ImageView f42507l;

    /* renamed from: m */
    private MaxHeightNovaRecyclerView f42508m;

    /* renamed from: n */
    private CustomerAppCompatTextView f42509n;

    /* renamed from: o */
    private RichTextView f42510o;

    /* renamed from: p */
    private CustomerAppCompatTextView f42511p;

    /* renamed from: q */
    private View f42512q;

    /* renamed from: r */
    private View f42513r;

    /* renamed from: s */
    private CustomerAppCompatTextView f42514s;

    /* renamed from: t */
    private LottieLoadingView f42515t;

    /* renamed from: u */
    private View f42516u;

    /* renamed from: v */
    private View f42517v;

    /* renamed from: w */
    private View f42518w;

    /* renamed from: x */
    private View f42519x;

    /* renamed from: y */
    private View f42520y;

    /* renamed from: z */
    private View f42521z;

    @Metadata(mo148867d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo148868d2 = {"Lcom/didi/soda/cart/component/CustomerFloatingCartView$AnimationEndListener;", "", "onClearData", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: CustomerFloatingCartView.kt */
    public interface AnimationEndListener {
        void onClearData();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31950a(View view) {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m31956b(View view) {
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m31959c(View view) {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31952a(CustomerFloatingCartView customerFloatingCartView, View view) {
        Intrinsics.checkNotNullParameter(customerFloatingCartView, "this$0");
        if (!ClickUtils.isFastClick()) {
            customerFloatingCartView.hideCartMenu();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31953a(CustomerFloatingCartView customerFloatingCartView, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(customerFloatingCartView, "this$0");
        if (!(i6 == 0 || i6 == i2 || !customerFloatingCartView.f42491C)) {
            View view2 = customerFloatingCartView.f42513r;
            View view3 = null;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topBarParentView");
                view2 = null;
            }
            float translationY = view2.getTranslationY();
            View view4 = customerFloatingCartView.f42513r;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topBarParentView");
            } else {
                view3 = view4;
            }
            view3.setTranslationY((translationY + ((float) i2)) - ((float) i6));
        }
        customerFloatingCartView.f42491C = false;
    }

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lcom/didi/soda/cart/component/CustomerFloatingCartView$Companion;", "", "()V", "TAG", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: CustomerFloatingCartView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_floating_cart_view, viewGroup);
        View findViewById = inflate.findViewById(R.id.customer_rl_root_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "viewRoot.findViewById(R.id.customer_rl_root_view)");
        this.f42497b = findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_view_bg);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "viewRoot.findViewById(R.id.customer_view_bg)");
        this.f42496a = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_custom_discount_close_cart);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "viewRoot.findViewById(R.…stom_discount_close_cart)");
        this.f42500e = findViewById3;
        View findViewById4 = inflate.findViewById(R.id.customer_custom_actionbar_close_cart);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "viewRoot.findViewById(R.…tom_actionbar_close_cart)");
        this.f42501f = findViewById4;
        View findViewById5 = inflate.findViewById(R.id.customer_rl_actionbar);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "viewRoot.findViewById(R.id.customer_rl_actionbar)");
        this.f42502g = findViewById5;
        View findViewById6 = inflate.findViewById(R.id.customer_fl_offer_pass_parent);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "viewRoot.findViewById(R.…mer_fl_offer_pass_parent)");
        this.f42498c = findViewById6;
        View findViewById7 = inflate.findViewById(R.id.customer_ll_discount_parent);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "viewRoot.findViewById(R.…tomer_ll_discount_parent)");
        this.f42499d = (CustomerCartDiscountParentView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.customer_custom_offer_pass);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "viewRoot.findViewById(R.…stomer_custom_offer_pass)");
        this.f42506k = (RichTextView) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.customer_custom_cart_menu);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "viewRoot.findViewById(R.…ustomer_custom_cart_menu)");
        this.f42508m = (MaxHeightNovaRecyclerView) findViewById9;
        View findViewById10 = inflate.findViewById(R.id.customer_iv_shopping_cart);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "viewRoot.findViewById(R.…ustomer_iv_shopping_cart)");
        this.f42507l = (ImageView) findViewById10;
        View findViewById11 = inflate.findViewById(R.id.customer_fl_cart_root);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "viewRoot.findViewById(R.id.customer_fl_cart_root)");
        this.f42503h = findViewById11;
        View findViewById12 = inflate.findViewById(R.id.customer_fl_cart_root_click_area);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "viewRoot.findViewById(R.…_fl_cart_root_click_area)");
        this.f42504i = findViewById12;
        View findViewById13 = inflate.findViewById(R.id.customer_view_split_line);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "viewRoot.findViewById(R.…customer_view_split_line)");
        this.f42505j = findViewById13;
        View findViewById14 = inflate.findViewById(R.id.customer_custom_loading_view);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "viewRoot.findViewById(R.…omer_custom_loading_view)");
        this.f42515t = (LottieLoadingView) findViewById14;
        View findViewById15 = inflate.findViewById(R.id.customer_custom_cart_total_amount);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "viewRoot.findViewById(R.…custom_cart_total_amount)");
        this.f42511p = (CustomerAppCompatTextView) findViewById15;
        View findViewById16 = inflate.findViewById(R.id.customer_fl_top_bar_parent);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "viewRoot.findViewById(R.…stomer_fl_top_bar_parent)");
        this.f42513r = findViewById16;
        View findViewById17 = inflate.findViewById(R.id.customer_cart_shadow);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "viewRoot.findViewById(R.id.customer_cart_shadow)");
        this.f42516u = findViewById17;
        View findViewById18 = inflate.findViewById(R.id.customer_discount_shadow);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "viewRoot.findViewById(R.…customer_discount_shadow)");
        this.f42517v = findViewById18;
        View findViewById19 = inflate.findViewById(R.id.customer_iv_rv_scroll_shadow);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "viewRoot.findViewById(R.…omer_iv_rv_scroll_shadow)");
        this.f42518w = findViewById19;
        View findViewById20 = inflate.findViewById(R.id.customer_fl_rv_parent);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "viewRoot.findViewById(R.id.customer_fl_rv_parent)");
        this.f42519x = findViewById20;
        View findViewById21 = inflate.findViewById(R.id.customer_ll_price_parent);
        Intrinsics.checkNotNullExpressionValue(findViewById21, "viewRoot.findViewById(R.…customer_ll_price_parent)");
        this.f42512q = findViewById21;
        View findViewById22 = inflate.findViewById(R.id.customer_custom_total_price);
        Intrinsics.checkNotNullExpressionValue(findViewById22, "viewRoot.findViewById(R.…tomer_custom_total_price)");
        this.f42509n = (CustomerAppCompatTextView) findViewById22;
        View findViewById23 = inflate.findViewById(R.id.customer_custom_origin_price);
        Intrinsics.checkNotNullExpressionValue(findViewById23, "viewRoot.findViewById(R.…omer_custom_origin_price)");
        this.f42510o = (RichTextView) findViewById23;
        View findViewById24 = inflate.findViewById(R.id.customer_custom_bt_check_out);
        Intrinsics.checkNotNullExpressionValue(findViewById24, "viewRoot.findViewById(R.…omer_custom_bt_check_out)");
        this.f42514s = (CustomerAppCompatTextView) findViewById24;
        View findViewById25 = inflate.findViewById(R.id.customer_cart_root_bg_view);
        Intrinsics.checkNotNullExpressionValue(findViewById25, "viewRoot.findViewById(R.…stomer_cart_root_bg_view)");
        this.f42520y = findViewById25;
        View findViewById26 = inflate.findViewById(R.id.customer_cart_menu_bg_view);
        Intrinsics.checkNotNullExpressionValue(findViewById26, "viewRoot.findViewById(R.…stomer_cart_menu_bg_view)");
        this.f42521z = findViewById26;
        Intrinsics.checkNotNullExpressionValue(inflate, "viewRoot");
        return inflate;
    }

    public void onCreate() {
        View view;
        View view2;
        View view3;
        View view4;
        CustomerCartDiscountParentView customerCartDiscountParentView;
        RichTextView richTextView;
        View view5;
        View view6;
        View view7;
        View view8;
        ImageView imageView;
        View view9;
        View view10;
        View view11;
        super.onCreate();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        View view12 = this.f42497b;
        if (view12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            view = null;
        } else {
            view = view12;
        }
        View view13 = this.f42496a;
        if (view13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentBackGroundView");
            view2 = null;
        } else {
            view2 = view13;
        }
        View view14 = this.f42513r;
        if (view14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topBarParentView");
            view3 = null;
        } else {
            view3 = view14;
        }
        View view15 = this.f42498c;
        if (view15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discountRootView");
            view4 = null;
        } else {
            view4 = view15;
        }
        CustomerCartDiscountParentView customerCartDiscountParentView2 = this.f42499d;
        if (customerCartDiscountParentView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discountParentView");
            customerCartDiscountParentView = null;
        } else {
            customerCartDiscountParentView = customerCartDiscountParentView2;
        }
        RichTextView richTextView2 = this.f42506k;
        if (richTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discountContentView");
            richTextView = null;
        } else {
            richTextView = richTextView2;
        }
        View view16 = this.f42502g;
        if (view16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBarView");
            view5 = null;
        } else {
            view5 = view16;
        }
        View view17 = this.f42500e;
        if (view17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discountCloseView");
            view6 = null;
        } else {
            view6 = view17;
        }
        View view18 = this.f42503h;
        if (view18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartParentView");
            view7 = null;
        } else {
            view7 = view18;
        }
        View view19 = this.f42505j;
        if (view19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartSplitLine");
            view8 = null;
        } else {
            view8 = view19;
        }
        ImageView imageView2 = this.f42507l;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shoppingCartImage");
            imageView = null;
        } else {
            imageView = imageView2;
        }
        View view20 = this.f42519x;
        if (view20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvParentView");
            view9 = null;
        } else {
            view9 = view20;
        }
        View view21 = this.f42516u;
        if (view21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartViewShadow");
            view10 = null;
        } else {
            view10 = view21;
        }
        View view22 = this.f42517v;
        if (view22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discountShadow");
            view11 = null;
        } else {
            view11 = view22;
        }
        FloatingCartAnimationHelper floatingCartAnimationHelper = r1;
        FloatingCartAnimationHelper floatingCartAnimationHelper2 = new FloatingCartAnimationHelper(context, view, view2, view3, view4, customerCartDiscountParentView, richTextView, view5, view6, view7, view8, imageView, view9, view10, view11);
        this.f42493E = floatingCartAnimationHelper;
        CustomerAppCompatTextView customerAppCompatTextView = this.f42514s;
        if (customerAppCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkoutView");
            customerAppCompatTextView = null;
        }
        customerAppCompatTextView.setText(ResourceHelper.getString(R.string.customer_global_cart_item_check_out));
        View view23 = this.f42504i;
        if (view23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartParentClickView");
            view23 = null;
        }
        view23.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomerFloatingCartView.m31957b(CustomerFloatingCartView.this, view);
            }
        });
        CustomerCartDiscountParentView customerCartDiscountParentView3 = this.f42499d;
        if (customerCartDiscountParentView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discountParentView");
            customerCartDiscountParentView3 = null;
        }
        customerCartDiscountParentView3.setOnClickListener($$Lambda$CustomerFloatingCartView$h_Zjz9GkdSrb_LTCWoMX8yFwx5A.INSTANCE);
        View view24 = this.f42503h;
        if (view24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartParentView");
            view24 = null;
        }
        view24.setOnClickListener($$Lambda$CustomerFloatingCartView$zw6oF21YzZHwibxyepWkL5qEmzM.INSTANCE);
        View view25 = this.f42502g;
        if (view25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBarView");
            view25 = null;
        }
        view25.setOnClickListener($$Lambda$CustomerFloatingCartView$ApIcVGnpkvrwWTGD12kyAIzy3to.INSTANCE);
        View view26 = this.f42500e;
        if (view26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discountCloseView");
            view26 = null;
        }
        view26.setOnClickListener(this.f42494F);
        View view27 = this.f42496a;
        if (view27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentBackGroundView");
            view27 = null;
        }
        view27.setOnClickListener(this.f42494F);
        View view28 = this.f42501f;
        if (view28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBarCloseView");
            view28 = null;
        }
        view28.setOnClickListener(this.f42494F);
        View view29 = this.f42519x;
        if (view29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvParentView");
            view29 = null;
        }
        view29.addOnLayoutChangeListener(this.f42495G);
        CustomerAppCompatTextView customerAppCompatTextView2 = this.f42514s;
        if (customerAppCompatTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkoutView");
            customerAppCompatTextView2 = null;
        }
        customerAppCompatTextView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomerFloatingCartView.m31960c(CustomerFloatingCartView.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m31957b(CustomerFloatingCartView customerFloatingCartView, View view) {
        Intrinsics.checkNotNullParameter(customerFloatingCartView, "this$0");
        CartInfoModel cartInfoModel = customerFloatingCartView.f42489A;
        if (cartInfoModel != null) {
            Intrinsics.checkNotNull(cartInfoModel);
            Collection cartItems = cartInfoModel.getCartItems();
            if (!(cartItems == null || cartItems.isEmpty())) {
                if (ClickUtils.isFastClick()) {
                    LogUtil.m32588i(TAG, "shopping cart quick click blocked");
                } else if (customerFloatingCartView.f42489A != null) {
                    if (customerFloatingCartView.isFloatingCartExpand()) {
                        customerFloatingCartView.hideCartMenu();
                        return;
                    }
                    LottieLoadingView lottieLoadingView = customerFloatingCartView.f42515t;
                    if (lottieLoadingView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                        lottieLoadingView = null;
                    }
                    if (!lottieLoadingView.isRunning()) {
                        customerFloatingCartView.showCartMenu();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m31960c(CustomerFloatingCartView customerFloatingCartView, View view) {
        Intrinsics.checkNotNullParameter(customerFloatingCartView, "this$0");
        if (!ClickUtils.isFastClick()) {
            if (!LoginUtil.isLogin()) {
                LoginUtil.loginActivityAndTrack(customerFloatingCartView.getContext(), 9);
                return;
            }
            ((Contract.AbsFloatingCartPresenter) customerFloatingCartView.getPresenter()).toBillPage();
            if (customerFloatingCartView.isFloatingCartExpand()) {
                customerFloatingCartView.hideCartMenu();
            }
        }
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        MaxHeightNovaRecyclerView maxHeightNovaRecyclerView = this.f42508m;
        if (maxHeightNovaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            maxHeightNovaRecyclerView = null;
        }
        return maxHeightNovaRecyclerView;
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        registerBinder(new CustomerCartPresentMenuBinder());
        registerBinder(new CustomerFloatingCartView$initItemBinders$1(this, getScopeContext()));
        CustomerTyingCartBinder customerTyingCartBinder = new CustomerTyingCartBinder();
        customerTyingCartBinder.setOnItemClickListener(new CustomerFloatingCartView$initItemBinders$2$1(this));
        Unit unit = Unit.INSTANCE;
        registerBinder(customerTyingCartBinder);
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x022c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0122  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateCartInfo(com.didi.soda.cart.model.CartInfoModel r11, boolean r12) {
        /*
            r10 = this;
            java.lang.String r0 = "model"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 0
            r1 = 1
            r2 = 0
            if (r12 != 0) goto L_0x006b
            com.didi.soda.cart.model.CartInfoModel r3 = r10.f42489A
            if (r3 != 0) goto L_0x0010
            r3 = r0
            goto L_0x0014
        L_0x0010:
            java.util.ArrayList r3 = r3.getCartItems()
        L_0x0014:
            java.util.Collection r3 = (java.util.Collection) r3
            if (r3 == 0) goto L_0x0021
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r3 = 0
            goto L_0x0022
        L_0x0021:
            r3 = 1
        L_0x0022:
            if (r3 == 0) goto L_0x003a
            java.util.ArrayList r3 = r11.getCartItems()
            java.util.Collection r3 = (java.util.Collection) r3
            if (r3 == 0) goto L_0x0035
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r3 = 0
            goto L_0x0036
        L_0x0035:
            r3 = 1
        L_0x0036:
            if (r3 != 0) goto L_0x003a
            r3 = 1
            goto L_0x003b
        L_0x003a:
            r3 = 0
        L_0x003b:
            com.didi.soda.cart.model.CartInfoModel r4 = r10.f42489A
            if (r4 != 0) goto L_0x0041
            r4 = r0
            goto L_0x0045
        L_0x0041:
            java.util.ArrayList r4 = r4.getCartItems()
        L_0x0045:
            java.util.Collection r4 = (java.util.Collection) r4
            if (r4 == 0) goto L_0x0052
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r4 = 0
            goto L_0x0053
        L_0x0052:
            r4 = 1
        L_0x0053:
            if (r4 != 0) goto L_0x006c
            java.util.ArrayList r4 = r11.getCartItems()
            java.util.Collection r4 = (java.util.Collection) r4
            if (r4 == 0) goto L_0x0066
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            r4 = 0
            goto L_0x0067
        L_0x0066:
            r4 = 1
        L_0x0067:
            if (r4 == 0) goto L_0x006c
            r4 = 1
            goto L_0x006d
        L_0x006b:
            r3 = 0
        L_0x006c:
            r4 = 0
        L_0x006d:
            r10.f42489A = r11
            com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoPriceEntity r5 = r11.getPrices()
            r6 = 8
            if (r5 != 0) goto L_0x0079
            goto L_0x00f6
        L_0x0079:
            java.lang.String r7 = r5.getCartPriceDesc()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x008a
            int r7 = r7.length()
            if (r7 != 0) goto L_0x0088
            goto L_0x008a
        L_0x0088:
            r7 = 0
            goto L_0x008b
        L_0x008a:
            r7 = 1
        L_0x008b:
            java.lang.String r8 = "originPriceView"
            if (r7 == 0) goto L_0x009b
            com.didi.soda.customer.widget.text.RichTextView r7 = r10.f42510o
            if (r7 != 0) goto L_0x0097
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r7 = r0
        L_0x0097:
            r7.setVisibility(r6)
            goto L_0x00b7
        L_0x009b:
            com.didi.soda.customer.widget.text.RichTextView r7 = r10.f42510o
            if (r7 != 0) goto L_0x00a3
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r7 = r0
        L_0x00a3:
            r7.setVisibility(r2)
            com.didi.soda.customer.widget.text.RichTextView r7 = r10.f42510o
            if (r7 != 0) goto L_0x00ae
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r7 = r0
        L_0x00ae:
            java.lang.String r8 = r5.getCartPriceDesc()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r7.setText(r8)
        L_0x00b7:
            java.lang.String r7 = r5.getCartFavorPriceDisplay()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x00c8
            int r7 = r7.length()
            if (r7 != 0) goto L_0x00c6
            goto L_0x00c8
        L_0x00c6:
            r7 = 0
            goto L_0x00c9
        L_0x00c8:
            r7 = 1
        L_0x00c9:
            java.lang.String r8 = "totalPriceView"
            if (r7 == 0) goto L_0x00da
            com.didi.soda.customer.widget.support.CustomerAppCompatTextView r5 = r10.f42509n
            if (r5 != 0) goto L_0x00d6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r5 = r0
        L_0x00d6:
            r5.setVisibility(r6)
            goto L_0x00f6
        L_0x00da:
            com.didi.soda.customer.widget.support.CustomerAppCompatTextView r7 = r10.f42509n
            if (r7 != 0) goto L_0x00e2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r7 = r0
        L_0x00e2:
            r7.setVisibility(r2)
            com.didi.soda.customer.widget.support.CustomerAppCompatTextView r7 = r10.f42509n
            if (r7 != 0) goto L_0x00ed
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r7 = r0
        L_0x00ed:
            java.lang.String r5 = r5.getCartFavorPriceDisplay()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r7.setText(r5)
        L_0x00f6:
            java.lang.String r5 = r11.getFavorTip()
            java.lang.String r7 = r10.f42490B
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r7)
            if (r5 != 0) goto L_0x010a
            java.lang.String r5 = r11.getFavorTip()
            r10.f42490B = r5
            r5 = 1
            goto L_0x010b
        L_0x010a:
            r5 = 0
        L_0x010b:
            java.lang.String r7 = r11.getFavorTip()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x011c
            int r7 = r7.length()
            if (r7 != 0) goto L_0x011a
            goto L_0x011c
        L_0x011a:
            r7 = 0
            goto L_0x011d
        L_0x011c:
            r7 = 1
        L_0x011d:
            java.lang.String r8 = "rvScrollShadow"
            if (r7 != 0) goto L_0x0141
            com.didi.soda.customer.widget.text.RichTextView r7 = r10.f42506k
            if (r7 != 0) goto L_0x012c
            java.lang.String r7 = "discountContentView"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r7 = r0
        L_0x012c:
            java.lang.String r9 = r11.getFavorTip()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r7.setText(r9)
            android.view.View r7 = r10.f42518w
            if (r7 != 0) goto L_0x013d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r7 = r0
        L_0x013d:
            r7.setVisibility(r2)
            goto L_0x014c
        L_0x0141:
            android.view.View r7 = r10.f42518w
            if (r7 != 0) goto L_0x0149
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r7 = r0
        L_0x0149:
            r7.setVisibility(r6)
        L_0x014c:
            boolean r7 = r10.isFloatingCartExpand()
            r10.m31955a((boolean) r7, (boolean) r2)
            if (r12 == 0) goto L_0x01f4
            java.lang.String r12 = r11.getFavorTip()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            if (r12 == 0) goto L_0x0166
            int r12 = r12.length()
            if (r12 != 0) goto L_0x0164
            goto L_0x0166
        L_0x0164:
            r12 = 0
            goto L_0x0167
        L_0x0166:
            r12 = 1
        L_0x0167:
            java.lang.String r3 = "animationHelper"
            if (r12 != 0) goto L_0x018c
            java.util.ArrayList r12 = r11.getCartItems()
            java.util.Collection r12 = (java.util.Collection) r12
            if (r12 == 0) goto L_0x017c
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L_0x017a
            goto L_0x017c
        L_0x017a:
            r12 = 0
            goto L_0x017d
        L_0x017c:
            r12 = 1
        L_0x017d:
            if (r12 == 0) goto L_0x018c
            com.didi.soda.cart.component.FloatingCartAnimationHelper r12 = r10.f42493E
            if (r12 != 0) goto L_0x0187
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r12 = r0
        L_0x0187:
            r12.showDiscountTip()
            goto L_0x0204
        L_0x018c:
            java.lang.String r12 = r11.getFavorTip()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            if (r12 == 0) goto L_0x019d
            int r12 = r12.length()
            if (r12 != 0) goto L_0x019b
            goto L_0x019d
        L_0x019b:
            r12 = 0
            goto L_0x019e
        L_0x019d:
            r12 = 1
        L_0x019e:
            if (r12 == 0) goto L_0x01c0
            java.util.ArrayList r12 = r11.getCartItems()
            java.util.Collection r12 = (java.util.Collection) r12
            if (r12 == 0) goto L_0x01b1
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L_0x01af
            goto L_0x01b1
        L_0x01af:
            r12 = 0
            goto L_0x01b2
        L_0x01b1:
            r12 = 1
        L_0x01b2:
            if (r12 != 0) goto L_0x01c0
            com.didi.soda.cart.component.FloatingCartAnimationHelper r12 = r10.f42493E
            if (r12 != 0) goto L_0x01bc
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r12 = r0
        L_0x01bc:
            r12.showCartNoDiscountTip()
            goto L_0x0204
        L_0x01c0:
            java.lang.String r12 = r11.getFavorTip()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            if (r12 == 0) goto L_0x01d1
            int r12 = r12.length()
            if (r12 != 0) goto L_0x01cf
            goto L_0x01d1
        L_0x01cf:
            r12 = 0
            goto L_0x01d2
        L_0x01d1:
            r12 = 1
        L_0x01d2:
            if (r12 != 0) goto L_0x0204
            java.util.ArrayList r12 = r11.getCartItems()
            java.util.Collection r12 = (java.util.Collection) r12
            if (r12 == 0) goto L_0x01e5
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L_0x01e3
            goto L_0x01e5
        L_0x01e3:
            r12 = 0
            goto L_0x01e6
        L_0x01e5:
            r12 = 1
        L_0x01e6:
            if (r12 != 0) goto L_0x0204
            com.didi.soda.cart.component.FloatingCartAnimationHelper r12 = r10.f42493E
            if (r12 != 0) goto L_0x01f0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r12 = r0
        L_0x01f0:
            r12.showDiscountTipAndCart()
            goto L_0x0204
        L_0x01f4:
            if (r3 == 0) goto L_0x01f9
            r10.showBottomCartCard(r1)
        L_0x01f9:
            if (r4 == 0) goto L_0x01fe
            r10.hideAllCartView()
        L_0x01fe:
            if (r5 != 0) goto L_0x0201
            return
        L_0x0201:
            r10.m31954a((com.didi.soda.cart.model.CartInfoModel) r11)
        L_0x0204:
            com.didi.soda.cart.model.CartTyingModel r11 = r11.getCartTyingModel()
            if (r11 != 0) goto L_0x020c
        L_0x020a:
            r1 = 0
            goto L_0x021b
        L_0x020c:
            java.util.ArrayList r11 = r11.getCartItems()
            if (r11 != 0) goto L_0x0213
            goto L_0x020a
        L_0x0213:
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r11 = r11.isEmpty()
            if (r11 != r1) goto L_0x020a
        L_0x021b:
            java.lang.String r11 = "cartSplitLine"
            if (r1 == 0) goto L_0x022c
            android.view.View r12 = r10.f42505j
            if (r12 != 0) goto L_0x0227
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            goto L_0x0228
        L_0x0227:
            r0 = r12
        L_0x0228:
            r0.setVisibility(r2)
            goto L_0x0238
        L_0x022c:
            android.view.View r12 = r10.f42505j
            if (r12 != 0) goto L_0x0234
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            goto L_0x0235
        L_0x0234:
            r0 = r12
        L_0x0235:
            r0.setVisibility(r6)
        L_0x0238:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.cart.component.CustomerFloatingCartView.updateCartInfo(com.didi.soda.cart.model.CartInfoModel, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31955a(boolean z, boolean z2) {
        int i = R.drawable.customer_skin_shape_cart_discount_fill_bg;
        boolean z3 = true;
        int i2 = 8;
        View view = null;
        if (z2) {
            View view2 = this.f42521z;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCartMenuBgView");
                view2 = null;
            }
            view2.setVisibility(8);
            CartInfoModel cartInfoModel = this.f42489A;
            CharSequence favorTip = cartInfoModel == null ? null : cartInfoModel.getFavorTip();
            if (!(favorTip == null || favorTip.length() == 0)) {
                z3 = false;
            }
            if (!z3) {
                View view3 = this.f42520y;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartRootBgView");
                    view3 = null;
                }
                view3.setBackgroundResource(R.drawable.customer_skin_shape_cart_discount_fill_bg);
                View view4 = this.f42520y;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartRootBgView");
                } else {
                    view = view4;
                }
                view.setVisibility(0);
                return;
            }
            View view5 = this.f42520y;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCartRootBgView");
            } else {
                view = view5;
            }
            view.setVisibility(8);
            return;
        }
        CartInfoModel cartInfoModel2 = this.f42489A;
        CharSequence favorTip2 = cartInfoModel2 == null ? null : cartInfoModel2.getFavorTip();
        if (!(favorTip2 == null || favorTip2.length() == 0)) {
            CartInfoModel cartInfoModel3 = this.f42489A;
            Collection cartItems = cartInfoModel3 == null ? null : cartInfoModel3.getCartItems();
            if (cartItems == null || cartItems.isEmpty()) {
                View view6 = this.f42520y;
                if (view6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartRootBgView");
                    view6 = null;
                }
                view6.setVisibility(8);
                View view7 = this.f42521z;
                if (view7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartMenuBgView");
                } else {
                    view = view7;
                }
                view.setVisibility(8);
                return;
            }
        }
        CartInfoModel cartInfoModel4 = this.f42489A;
        CharSequence favorTip3 = cartInfoModel4 == null ? null : cartInfoModel4.getFavorTip();
        if (favorTip3 == null || favorTip3.length() == 0) {
            CartInfoModel cartInfoModel5 = this.f42489A;
            Collection cartItems2 = cartInfoModel5 == null ? null : cartInfoModel5.getCartItems();
            if (!(cartItems2 == null || cartItems2.isEmpty())) {
                View view8 = this.f42521z;
                if (view8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartMenuBgView");
                    view8 = null;
                }
                view8.setBackgroundResource(R.color.rf_color_white_100_FFFFFF);
                View view9 = this.f42521z;
                if (view9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartMenuBgView");
                    view9 = null;
                }
                view9.setVisibility(z ? 0 : 8);
                View view10 = this.f42520y;
                if (view10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartRootBgView");
                    view10 = null;
                }
                view10.setBackgroundResource(R.color.rf_color_white_100_FFFFFF);
                View view11 = this.f42520y;
                if (view11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartRootBgView");
                } else {
                    view = view11;
                }
                if (z) {
                    i2 = 0;
                }
                view.setVisibility(i2);
                return;
            }
        }
        CartInfoModel cartInfoModel6 = this.f42489A;
        CharSequence favorTip4 = cartInfoModel6 == null ? null : cartInfoModel6.getFavorTip();
        if (!(favorTip4 == null || favorTip4.length() == 0)) {
            CartInfoModel cartInfoModel7 = this.f42489A;
            Collection cartItems3 = cartInfoModel7 == null ? null : cartInfoModel7.getCartItems();
            if (cartItems3 != null && !cartItems3.isEmpty()) {
                z3 = false;
            }
            if (!z3) {
                View view12 = this.f42521z;
                if (view12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartMenuBgView");
                    view12 = null;
                }
                view12.setBackgroundResource(R.drawable.customer_skin_shape_cart_discount_fill_bg);
                View view13 = this.f42521z;
                if (view13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartMenuBgView");
                    view13 = null;
                }
                if (z) {
                    i2 = 0;
                }
                view13.setVisibility(i2);
                View view14 = this.f42520y;
                if (view14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartRootBgView");
                    view14 = null;
                }
                if (z) {
                    i = R.color.rf_color_white_100_FFFFFF;
                }
                view14.setBackgroundResource(i);
                View view15 = this.f42520y;
                if (view15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCartRootBgView");
                } else {
                    view = view15;
                }
                view.setVisibility(0);
                return;
            }
        }
        m31949a();
    }

    /* renamed from: a */
    private final void m31949a() {
        View view = this.f42521z;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCartMenuBgView");
            view = null;
        }
        view.setVisibility(8);
        View view3 = this.f42520y;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCartRootBgView");
        } else {
            view2 = view3;
        }
        view2.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31954a(CartInfoModel cartInfoModel) {
        View view = null;
        CharSequence favorTip = cartInfoModel == null ? null : cartInfoModel.getFavorTip();
        if (!(favorTip == null || favorTip.length() == 0)) {
            View view2 = this.f42498c;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("discountRootView");
            } else {
                view = view2;
            }
            view.post(new Runnable() {
                public final void run() {
                    CustomerFloatingCartView.m31951a(CustomerFloatingCartView.this);
                }
            });
            return;
        }
        View view3 = this.f42518w;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvScrollShadow");
            view3 = null;
        }
        view3.setVisibility(8);
        View view4 = this.f42498c;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discountRootView");
            view4 = null;
        }
        view4.setVisibility(8);
        if (isFloatingCartExpand()) {
            View view5 = this.f42502g;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBarView");
                view5 = null;
            }
            view5.setVisibility(0);
            View view6 = this.f42516u;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cartViewShadow");
            } else {
                view = view6;
            }
            view.setVisibility(8);
            return;
        }
        View view7 = this.f42503h;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartParentView");
            view7 = null;
        }
        if (view7.getVisibility() == 0) {
            View view8 = this.f42502g;
            if (view8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBarView");
                view8 = null;
            }
            view8.setVisibility(8);
            View view9 = this.f42516u;
            if (view9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cartViewShadow");
            } else {
                view = view9;
            }
            view.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31951a(CustomerFloatingCartView customerFloatingCartView) {
        Intrinsics.checkNotNullParameter(customerFloatingCartView, "this$0");
        View view = customerFloatingCartView.f42513r;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topBarParentView");
            view = null;
        }
        view.setVisibility(0);
        View view3 = customerFloatingCartView.f42498c;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discountRootView");
            view3 = null;
        }
        view3.setVisibility(0);
        View view4 = customerFloatingCartView.f42502g;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBarView");
            view4 = null;
        }
        view4.setVisibility(8);
        View view5 = customerFloatingCartView.f42516u;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartViewShadow");
            view5 = null;
        }
        view5.setVisibility(8);
        if (customerFloatingCartView.isFloatingCartExpand()) {
            View view6 = customerFloatingCartView.f42517v;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("discountShadow");
                view6 = null;
            }
            view6.setAlpha(0.0f);
        } else {
            View view7 = customerFloatingCartView.f42517v;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("discountShadow");
                view7 = null;
            }
            view7.setVisibility(0);
            View view8 = customerFloatingCartView.f42517v;
            if (view8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("discountShadow");
                view8 = null;
            }
            view8.setAlpha(1.0f);
        }
        View view9 = customerFloatingCartView.f42503h;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartParentView");
            view9 = null;
        }
        if (view9.getVisibility() != 0 || customerFloatingCartView.isFloatingCartExpand()) {
            View view10 = customerFloatingCartView.f42503h;
            if (view10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cartParentView");
                view10 = null;
            }
            if (view10.getVisibility() == 8) {
                CustomerCartDiscountParentView customerCartDiscountParentView = customerFloatingCartView.f42499d;
                if (customerCartDiscountParentView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("discountParentView");
                    customerCartDiscountParentView = null;
                }
                CustomerCartDiscountParentView customerCartDiscountParentView2 = customerFloatingCartView.f42499d;
                if (customerCartDiscountParentView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("discountParentView");
                    customerCartDiscountParentView2 = null;
                }
                int paddingLeft = customerCartDiscountParentView2.getPaddingLeft();
                int dimensionPixelSize = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_24);
                CustomerCartDiscountParentView customerCartDiscountParentView3 = customerFloatingCartView.f42499d;
                if (customerCartDiscountParentView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("discountParentView");
                    customerCartDiscountParentView3 = null;
                }
                customerCartDiscountParentView.setPadding(paddingLeft, dimensionPixelSize, customerCartDiscountParentView3.getPaddingRight(), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_24));
            }
        } else {
            View view11 = customerFloatingCartView.f42513r;
            if (view11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topBarParentView");
                view11 = null;
            }
            view11.setTranslationY(0.0f);
            CustomerCartDiscountParentView customerCartDiscountParentView4 = customerFloatingCartView.f42499d;
            if (customerCartDiscountParentView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("discountParentView");
                customerCartDiscountParentView4 = null;
            }
            CustomerCartDiscountParentView customerCartDiscountParentView5 = customerFloatingCartView.f42499d;
            if (customerCartDiscountParentView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("discountParentView");
                customerCartDiscountParentView5 = null;
            }
            int paddingLeft2 = customerCartDiscountParentView5.getPaddingLeft();
            int dimensionPixelSize2 = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_24);
            CustomerCartDiscountParentView customerCartDiscountParentView6 = customerFloatingCartView.f42499d;
            if (customerCartDiscountParentView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("discountParentView");
                customerCartDiscountParentView6 = null;
            }
            customerCartDiscountParentView4.setPadding(paddingLeft2, dimensionPixelSize2, customerCartDiscountParentView6.getPaddingRight(), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_24));
        }
        View view12 = customerFloatingCartView.f42518w;
        if (view12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvScrollShadow");
        } else {
            view2 = view12;
        }
        view2.setVisibility(0);
    }

    public void showCartMenu() {
        LogUtil.m32588i(TAG, "shopping cart click: showCartMenu");
        ((Contract.AbsFloatingCartPresenter) getPresenter()).openCartTracker();
        FloatingCartAnimationHelper floatingCartAnimationHelper = this.f42493E;
        if (floatingCartAnimationHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationHelper");
            floatingCartAnimationHelper = null;
        }
        floatingCartAnimationHelper.showCartMenu(m31958b());
        m31955a(true, false);
    }

    public void hideCartMenu() {
        LogUtil.m32588i(TAG, "shopping cart click: hideCartMenu");
        FloatingCartAnimationHelper floatingCartAnimationHelper = this.f42493E;
        if (floatingCartAnimationHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationHelper");
            floatingCartAnimationHelper = null;
        }
        floatingCartAnimationHelper.hideCartMenu(m31958b(), new CustomerFloatingCartView$hideCartMenu$1(this));
    }

    public final void playAddToCartAnimation(boolean z) {
        FloatingCartAnimationHelper floatingCartAnimationHelper = this.f42493E;
        if (floatingCartAnimationHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationHelper");
            floatingCartAnimationHelper = null;
        }
        floatingCartAnimationHelper.playAddToCartAnimation(z);
    }

    /* renamed from: b */
    private final boolean m31958b() {
        CartInfoModel cartInfoModel = this.f42489A;
        CharSequence favorTip = cartInfoModel == null ? null : cartInfoModel.getFavorTip();
        return !(favorTip == null || favorTip.length() == 0);
    }

    public void showPriceLoading() {
        LottieLoadingView lottieLoadingView = this.f42515t;
        View view = null;
        if (lottieLoadingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            lottieLoadingView = null;
        }
        if (!lottieLoadingView.isRunning()) {
            LottieLoadingView lottieLoadingView2 = this.f42515t;
            if (lottieLoadingView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                lottieLoadingView2 = null;
            }
            lottieLoadingView2.show();
        }
        CustomerAppCompatTextView customerAppCompatTextView = this.f42514s;
        if (customerAppCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkoutView");
            customerAppCompatTextView = null;
        }
        customerAppCompatTextView.setEnabled(false);
        View view2 = this.f42512q;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("priceParentView");
        } else {
            view = view2;
        }
        view.setVisibility(8);
    }

    public void hidePriceLoading() {
        LottieLoadingView lottieLoadingView = this.f42515t;
        View view = null;
        if (lottieLoadingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            lottieLoadingView = null;
        }
        lottieLoadingView.hide();
        CustomerAppCompatTextView customerAppCompatTextView = this.f42514s;
        if (customerAppCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkoutView");
            customerAppCompatTextView = null;
        }
        boolean z = true;
        if (this.f42492D != 1) {
            z = false;
        }
        customerAppCompatTextView.setEnabled(z);
        View view2 = this.f42512q;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("priceParentView");
        } else {
            view = view2;
        }
        view.setVisibility(0);
    }

    public void updateCartTotalAmount(int i) {
        CustomerAppCompatTextView customerAppCompatTextView = this.f42511p;
        if (customerAppCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartTotalAmountView");
            customerAppCompatTextView = null;
        }
        customerAppCompatTextView.setText(String.valueOf(i));
    }

    public void setBusinessStatus(int i) {
        this.f42492D = i;
        CustomerAppCompatTextView customerAppCompatTextView = this.f42514s;
        if (customerAppCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkoutView");
            customerAppCompatTextView = null;
        }
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        customerAppCompatTextView.setEnabled(z);
    }

    public void showBottomCartCard(boolean z) {
        FloatingCartAnimationHelper floatingCartAnimationHelper = null;
        if (z) {
            View view = this.f42503h;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cartParentView");
                view = null;
            }
            if (view.getVisibility() == 0) {
                return;
            }
        }
        boolean z2 = true;
        if (!z) {
            m31955a(isFloatingCartExpand(), true);
        }
        CartInfoModel cartInfoModel = this.f42489A;
        CharSequence favorTip = cartInfoModel == null ? null : cartInfoModel.getFavorTip();
        if (!(favorTip == null || favorTip.length() == 0)) {
            z2 = false;
        }
        if (!z2) {
            View view2 = this.f42498c;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("discountRootView");
                view2 = null;
            }
            if (view2.getVisibility() == 8) {
                FloatingCartAnimationHelper floatingCartAnimationHelper2 = this.f42493E;
                if (floatingCartAnimationHelper2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("animationHelper");
                } else {
                    floatingCartAnimationHelper = floatingCartAnimationHelper2;
                }
                floatingCartAnimationHelper.showDiscountTipAndCart();
                return;
            }
            FloatingCartAnimationHelper floatingCartAnimationHelper3 = this.f42493E;
            if (floatingCartAnimationHelper3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animationHelper");
            } else {
                floatingCartAnimationHelper = floatingCartAnimationHelper3;
            }
            floatingCartAnimationHelper.showBottomCart();
            return;
        }
        FloatingCartAnimationHelper floatingCartAnimationHelper4 = this.f42493E;
        if (floatingCartAnimationHelper4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animationHelper");
        } else {
            floatingCartAnimationHelper = floatingCartAnimationHelper4;
        }
        floatingCartAnimationHelper.showCartNoDiscountTip();
    }

    public void setSkuDeleteFlag() {
        this.f42491C = true;
    }

    public void hideAllCartView() {
        LogUtil.m32588i(TAG, "hide all cart view");
        View view = this.f42503h;
        FloatingCartAnimationHelper floatingCartAnimationHelper = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartParentView");
            view = null;
        }
        if (view.getVisibility() == 0) {
            m31949a();
            FloatingCartAnimationHelper floatingCartAnimationHelper2 = this.f42493E;
            if (floatingCartAnimationHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animationHelper");
            } else {
                floatingCartAnimationHelper = floatingCartAnimationHelper2;
            }
            floatingCartAnimationHelper.hideAllView(m31958b(), new CustomerFloatingCartView$hideAllCartView$1(this));
        }
    }

    public final int[] getShoppingCartPosition() {
        return new int[]{ResourceHelper.getDimensionPixelSize(R.dimen.customer_44px), CustomerSystemUtil.getScreenHeight(getContext()) - ResourceHelper.getDimensionPixelSize(R.dimen.customer_94px)};
    }

    public final boolean isFloatingCartExpand() {
        View view = this.f42519x;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvParentView");
            view = null;
        }
        return view.getVisibility() == 0;
    }
}
