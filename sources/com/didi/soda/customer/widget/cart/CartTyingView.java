package com.didi.soda.customer.widget.cart;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.soda.cart.binder.CustomerTyingItemAdapter;
import com.didi.soda.cart.model.CartTyingModel;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.home.topgun.widget.HorizontalRecyclerView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u00107\u001a\u0002082\u0006\u0010\u0002\u001a\u00020\u0003J\b\u00109\u001a\u000208H\u0002J\u0010\u0010:\u001a\u0002082\b\u0010;\u001a\u0004\u0018\u00010<J\u001c\u0010=\u001a\u0002082\b\u0010>\u001a\u0004\u0018\u00010?2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010AR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010&\"\u0004\b6\u0010(¨\u0006B"}, mo148868d2 = {"Lcom/didi/soda/customer/widget/cart/CartTyingView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgImageView", "Landroid/widget/ImageView;", "getBgImageView", "()Landroid/widget/ImageView;", "setBgImageView", "(Landroid/widget/ImageView;)V", "mItemAdapter", "Lcom/didi/soda/cart/binder/CustomerTyingItemAdapter;", "getMItemAdapter", "()Lcom/didi/soda/cart/binder/CustomerTyingItemAdapter;", "setMItemAdapter", "(Lcom/didi/soda/cart/binder/CustomerTyingItemAdapter;)V", "mRv", "Lcom/didi/soda/home/topgun/widget/HorizontalRecyclerView;", "getMRv", "()Lcom/didi/soda/home/topgun/widget/HorizontalRecyclerView;", "setMRv", "(Lcom/didi/soda/home/topgun/widget/HorizontalRecyclerView;)V", "needMask", "", "getNeedMask", "()Z", "setNeedMask", "(Z)V", "rootFl", "Landroid/view/View;", "getRootFl", "()Landroid/view/View;", "setRootFl", "(Landroid/view/View;)V", "shopStatus", "getShopStatus", "()I", "setShopStatus", "(I)V", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "setTvTitle", "(Landroid/widget/TextView;)V", "vFore", "getVFore", "setVFore", "initView", "", "setItemClickByMask", "setOnItemClickListener", "onItemClickListener", "Lcom/didi/soda/cart/binder/CustomerTyingItemAdapter$OnItemClickListener;", "updateView", "item", "Lcom/didi/soda/cart/model/CartTyingModel;", "cornerType", "Lcom/didi/app/nova/skeleton/image/RoundedCornersTransformation$CornerType;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CartTyingView.kt */
public final class CartTyingView extends ConstraintLayout {

    /* renamed from: a */
    private HorizontalRecyclerView f44272a;

    /* renamed from: b */
    private CustomerTyingItemAdapter f44273b;

    /* renamed from: c */
    private View f44274c;

    /* renamed from: d */
    private TextView f44275d;

    /* renamed from: e */
    private View f44276e;

    /* renamed from: f */
    private ImageView f44277f;

    /* renamed from: g */
    private boolean f44278g;

    /* renamed from: h */
    private int f44279h;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m32932a(View view) {
    }

    /* access modifiers changed from: private */
    /* renamed from: setItemClickByMask$lambda-1  reason: not valid java name */
    public static final void m47384setItemClickByMask$lambda1(View view) {
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final HorizontalRecyclerView getMRv() {
        return this.f44272a;
    }

    public final void setMRv(HorizontalRecyclerView horizontalRecyclerView) {
        this.f44272a = horizontalRecyclerView;
    }

    public final CustomerTyingItemAdapter getMItemAdapter() {
        return this.f44273b;
    }

    public final void setMItemAdapter(CustomerTyingItemAdapter customerTyingItemAdapter) {
        this.f44273b = customerTyingItemAdapter;
    }

    public final View getRootFl() {
        return this.f44274c;
    }

    public final void setRootFl(View view) {
        this.f44274c = view;
    }

    public final TextView getTvTitle() {
        return this.f44275d;
    }

    public final void setTvTitle(TextView textView) {
        this.f44275d = textView;
    }

    public final View getVFore() {
        return this.f44276e;
    }

    public final void setVFore(View view) {
        this.f44276e = view;
    }

    public final ImageView getBgImageView() {
        return this.f44277f;
    }

    public final void setBgImageView(ImageView imageView) {
        this.f44277f = imageView;
    }

    public final boolean getNeedMask() {
        return this.f44278g;
    }

    public final void setNeedMask(boolean z) {
        this.f44278g = z;
    }

    public final int getShopStatus() {
        return this.f44279h;
    }

    public final void setShopStatus(int i) {
        this.f44279h = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CartTyingView(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CartTyingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartTyingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f44278g = true;
        this.f44279h = 1;
        initView(context);
    }

    public final void initView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.customer_widget_tying_cart_view, this);
        this.f44273b = new CustomerTyingItemAdapter();
        this.f44272a = (HorizontalRecyclerView) findViewById(R.id.customer_rv_scroll);
        this.f44274c = findViewById(R.id.fl_root);
        this.f44275d = (TextView) findViewById(R.id.tv_title);
        View findViewById = findViewById(R.id.v_fore);
        this.f44276e = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener($$Lambda$CartTyingView$rw8zrjpthk_5ePtGEEy65YraQuU.INSTANCE);
        }
        this.f44277f = (ImageView) findViewById(R.id.customer_bg_image);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        HorizontalRecyclerView horizontalRecyclerView = this.f44272a;
        if (horizontalRecyclerView != null) {
            horizontalRecyclerView.setLayoutManager(linearLayoutManager);
        }
        HorizontalRecyclerView horizontalRecyclerView2 = this.f44272a;
        if (horizontalRecyclerView2 != null) {
            horizontalRecyclerView2.setAdapter(this.f44273b);
        }
        HorizontalRecyclerView horizontalRecyclerView3 = this.f44272a;
        if (horizontalRecyclerView3 != null) {
            horizontalRecyclerView3.setHasFixedSize(true);
        }
        HorizontalRecyclerView horizontalRecyclerView4 = this.f44272a;
        if (horizontalRecyclerView4 != null) {
            horizontalRecyclerView4.setNestedScrollingEnabled(false);
        }
    }

    public final void setOnItemClickListener(CustomerTyingItemAdapter.OnItemClickListener onItemClickListener) {
        CustomerTyingItemAdapter customerTyingItemAdapter = this.f44273b;
        if (customerTyingItemAdapter != null) {
            customerTyingItemAdapter.setOnItemClickListener(onItemClickListener);
        }
        m32931a();
    }

    public static /* synthetic */ void updateView$default(CartTyingView cartTyingView, CartTyingModel cartTyingModel, RoundedCornersTransformation.CornerType cornerType, int i, Object obj) {
        if ((i & 2) != 0) {
            cornerType = null;
        }
        cartTyingView.updateView(cartTyingModel, cornerType);
    }

    public final void updateView(CartTyingModel cartTyingModel, RoundedCornersTransformation.CornerType cornerType) {
        if (cartTyingModel != null) {
            CustomerTyingItemAdapter customerTyingItemAdapter = this.f44273b;
            if (customerTyingItemAdapter != null) {
                customerTyingItemAdapter.setCartItemModels(cartTyingModel.getCartItems());
            }
            TextView textView = this.f44275d;
            if (textView != null) {
                textView.setText(cartTyingModel.getTitle());
            }
            CharSequence backgroundImg = cartTyingModel.getBackgroundImg();
            if (!(backgroundImg == null || backgroundImg.length() == 0) && (Intrinsics.areEqual((Object) backgroundImg, (Object) "null") ^ true)) {
                ImageView imageView = this.f44277f;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                FlyImageLoader.ImageRequestWrapper loadImageUnspecified = FlyImageLoader.loadImageUnspecified(getContext(), cartTyingModel.getBackgroundImg());
                loadImageUnspecified.centerCrop();
                if (cornerType != null) {
                    loadImageUnspecified.transform(new RoundedCornersTransformation(getContext(), CustomerExtentionKt.getPx(R.dimen.rf_dimen_40), 0, cornerType, true));
                }
                loadImageUnspecified.into(this.f44277f);
            } else {
                ImageView imageView2 = this.f44277f;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
            }
            this.f44279h = cartTyingModel.getShopStatus();
            if (cartTyingModel.getShopStatus() != 1) {
                View view = this.f44276e;
                if (view != null) {
                    view.setVisibility(0);
                }
            } else {
                View view2 = this.f44276e;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
            m32931a();
        }
    }

    /* renamed from: a */
    private final void m32931a() {
        if (this.f44278g) {
            View view = this.f44276e;
            boolean z = false;
            if (view != null && view.getVisibility() == 0) {
                z = true;
            }
            if (z) {
                View view2 = this.f44276e;
                if (view2 != null) {
                    view2.setOnClickListener($$Lambda$CartTyingView$4O1t7wTqxfUG8223YJuicxZqY4.INSTANCE);
                    return;
                }
                return;
            }
        }
        View view3 = this.f44276e;
        if (view3 != null) {
            view3.setOnClickListener((View.OnClickListener) null);
        }
    }
}
