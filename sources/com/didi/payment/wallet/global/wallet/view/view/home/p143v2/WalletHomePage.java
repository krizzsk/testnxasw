package com.didi.payment.wallet.global.wallet.view.view.home.p143v2;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.dialog.GlobalAlertDialog;
import com.didi.payment.base.finResource.FinResourceRequest;
import com.didi.payment.base.proxy.LoadingProxyHolder;
import com.didi.payment.base.screenshot.ScreenShotListenManager;
import com.didi.payment.base.service.IWalletService;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.FinResOmegaUtils;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.utils.ServiceLoaderUtil;
import com.didi.payment.commonsdk.net.PixQrCodeQueryResp;
import com.didi.payment.commonsdk.p130ui.helper.NQRDetectedDialogHelper;
import com.didi.payment.wallet.global.model.WalletAccountData;
import com.didi.payment.wallet.global.model.resp.WalletPageQueryResp;
import com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp;
import com.didi.payment.wallet.global.utils.WalletSecuritySPUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.entity.WalletSettingPageInfo;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.AccountSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.CommonResourceState;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.Entry;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.HeadSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.IData;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.ResourceStateData;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.WalletHomeModelKt;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.FreezeInterceptor;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeController;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeTrackerManager;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletUriParam;
import com.didi.payment.wallet.password.PasswordScene;
import com.didi.raven.config.RavenKey;
import com.didi.unifiedPay.util.UIUtils;
import com.didiglobal.pay.paysecure.OpenCertificationListener;
import com.didiglobal.pay.paysecure.PaySecure;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB'\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020,H\u0016J&\u0010.\u001a\u00020\b2\u0016\u0010/\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u001c\u0018\u00010\u001b2\u0006\u00100\u001a\u00020\bJ\u0012\u00101\u001a\u00020,2\b\u0010\u0003\u001a\u0004\u0018\u000102H\u0016J\u001c\u00103\u001a\u00020,2\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0002J\u0012\u00108\u001a\u00020,2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u0010\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020,H\u0002J\b\u0010?\u001a\u00020,H\u0016J\u0010\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020BH\u0002J\u0012\u0010C\u001a\u00020,2\b\u0010D\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010E\u001a\u00020,2\b\b\u0002\u0010F\u001a\u00020GJ\u001c\u0010H\u001a\u00020,2\b\b\u0002\u0010I\u001a\u00020=2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010KJ\u0010\u0010L\u001a\u00020,2\u0006\u0010M\u001a\u00020NH\u0002J\b\u0010O\u001a\u00020,H\u0016J\b\u0010P\u001a\u00020,H\u0016J\u0012\u0010Q\u001a\u00020,2\b\u00104\u001a\u0004\u0018\u00010RH\u0016J\u0012\u0010S\u001a\u00020,2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J\u0012\u0010V\u001a\u00020,2\b\u00104\u001a\u0004\u0018\u00010WH\u0016J\u0012\u0010X\u001a\u00020,2\b\u0010Y\u001a\u0004\u0018\u00010UH\u0016J\b\u0010Z\u001a\u00020,H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u001c\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000¨\u0006["}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomePage;", "Landroid/widget/FrameLayout;", "Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "adapter", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeAdapter;", "finRequest", "Lcom/didi/payment/base/finResource/FinResourceRequest;", "getFinRequest", "()Lcom/didi/payment/base/finResource/FinResourceRequest;", "finRequest$delegate", "Lkotlin/Lazy;", "floatCloseBtn", "Landroid/widget/ImageView;", "floatImageView", "floatViewLayout", "mFlBar", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mHomeList", "", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeHolderData;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/IData;", "mListener", "Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;", "mLlBar", "Landroid/widget/LinearLayout;", "mLoadingFallbackView", "Landroid/view/View;", "mLoadingProxy", "Lcom/didi/payment/base/proxy/LoadingProxyHolder$ILoadingProxy;", "mRvContent", "Landroidx/recyclerview/widget/RecyclerView;", "mVBar", "tvWalletTitle", "Landroid/widget/TextView;", "dismissFlowerAnimation", "", "dismissLoadingDialog", "getHomeSpanCount", "list", "position", "initLoadingDialog", "Landroid/app/Activity;", "layoutNavigatorBar", "data", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/HeadSection;", "accountStatus", "Lcom/didi/payment/base/service/IWalletService$AccountInfo;", "onQRCodeDetected", "qrCodeData", "Lcom/didi/payment/commonsdk/net/PixQrCodeQueryResp$QRCodeData;", "onRefreshUI", "isRefreshAll", "", "registerPermissionObserver", "releaseLoadingDialog", "saveAccountData", "section", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/AccountSection;", "setListener", "l", "setPagePaddingBottom", "padding", "", "showBackButton", "flag", "listener", "Landroid/view/View$OnClickListener;", "showFloatView", "resData", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/CommonResourceState;", "showFlowerAnimation", "showLoadingDialog", "showPwdGuideDialog", "Lcom/didi/payment/wallet/global/model/resp/WalletPopUpWindowResp;", "showTitle", "title", "", "updateContent", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/Data;", "updateEmptyView", "message", "updateTitleBar", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomePage */
/* compiled from: WalletHomePage.kt */
public final class WalletHomePage extends FrameLayout implements WalletHomeContract.V2View {

    /* renamed from: a */
    private TextView f35182a;

    /* renamed from: b */
    private RecyclerView f35183b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f35184c;

    /* renamed from: d */
    private ConstraintLayout f35185d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f35186e;

    /* renamed from: f */
    private LinearLayout f35187f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public List<WalletHomeHolderData<? extends IData>> f35188g;

    /* renamed from: h */
    private WalletHomeAdapter f35189h;

    /* renamed from: i */
    private LoadingProxyHolder.ILoadingProxy f35190i;

    /* renamed from: j */
    private WalletHomeContract.V2Listener f35191j;

    /* renamed from: k */
    private FrameLayout f35192k;

    /* renamed from: l */
    private ImageView f35193l;

    /* renamed from: m */
    private ImageView f35194m;

    /* renamed from: n */
    private final Lazy f35195n;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletHomePage(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletHomePage(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void dismissFlowerAnimation() {
    }

    public void showFlowerAnimation() {
    }

    public void updateTitleBar() {
    }

    public /* synthetic */ void onRefreshUI(Boolean bool) {
        onRefreshUI(bool.booleanValue());
    }

    private final FinResourceRequest getFinRequest() {
        return (FinResourceRequest) this.f35195n.getValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletHomePage(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletHomePage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f35188g = new ArrayList();
        this.f35195n = LazyKt.lazy(new WalletHomePage$finRequest$2(this));
        Context context2 = getContext();
        WalletHomeController.Companion companion = WalletHomeController.Companion;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        LayoutInflater.from(getContext()).cloneInContext(new ContextThemeWrapper(context2, companion.findHomePageTheme(context3))).inflate(R.layout.page_wallet_home, this, true);
        View findViewById = findViewById(R.id.rv_content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.rv_content)");
        this.f35183b = (RecyclerView) findViewById;
        View findViewById2 = findViewById(R.id.v_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.v_bar)");
        this.f35184c = findViewById2;
        View findViewById3 = findViewById(R.id.fl_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.fl_bar)");
        this.f35185d = (ConstraintLayout) findViewById3;
        View findViewById4 = findViewById(R.id.ll_wallet_page_loading);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.ll_wallet_page_loading)");
        this.f35186e = findViewById4;
        View findViewById5 = findViewById(R.id.ll_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.ll_bar)");
        this.f35187f = (LinearLayout) findViewById5;
        View findViewById6 = findViewById(R.id.tv_wallet_title);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.tv_wallet_title)");
        this.f35182a = (TextView) findViewById6;
        this.f35192k = (FrameLayout) findViewById(R.id.float_view);
        this.f35193l = (ImageView) findViewById(R.id.btn_close);
        this.f35194m = (ImageView) findViewById(R.id.float_view_res);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 12);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this) {
            final /* synthetic */ WalletHomePage this$0;

            {
                this.this$0 = r1;
            }

            public int getSpanSize(int i) {
                WalletHomePage walletHomePage = this.this$0;
                return walletHomePage.getHomeSpanCount(walletHomePage.f35188g, i);
            }
        });
        this.f35183b.setLayoutManager(gridLayoutManager);
        WalletHomeAdapter walletHomeAdapter = new WalletHomeAdapter(this.f35188g, this.f35191j);
        this.f35189h = walletHomeAdapter;
        this.f35183b.setAdapter(walletHomeAdapter);
        int dip2px = UIUtils.dip2px(getContext(), 20.0f);
        this.f35183b.addItemDecoration(new WalletHomeDecoration(this.f35188g, dip2px, dip2px, dip2px / 2));
        this.f35183b.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
            private int lastY;
            final /* synthetic */ WalletHomePage this$0;

            {
                this.this$0 = r1;
            }

            public final int getLastY() {
                return this.lastY;
            }

            public final void setLastY(int i) {
                this.lastY = i;
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, i, i2);
                int i3 = this.lastY + i2;
                this.lastY = i3;
                float f = ((float) i3) / ((float) 400);
                View access$getMVBar$p = this.this$0.f35184c;
                if (f >= 1.0f) {
                    f = 1.0f;
                }
                access$getMVBar$p.setAlpha(f);
                this.this$0.f35184c.setVisibility(this.lastY > 0 ? 0 : 8);
            }
        });
        setPagePaddingBottom(70.0f);
        showBackButton$default(this, false, (View.OnClickListener) null, 3, (Object) null);
        m26765a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletHomePage(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
        this.f35188g = new ArrayList();
        this.f35195n = LazyKt.lazy(new WalletHomePage$finRequest$2(this));
        Context context2 = getContext();
        WalletHomeController.Companion companion = WalletHomeController.Companion;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        LayoutInflater.from(getContext()).cloneInContext(new ContextThemeWrapper(context2, companion.findHomePageTheme(context3))).inflate(R.layout.page_wallet_home, this, true);
        View findViewById = findViewById(R.id.rv_content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.rv_content)");
        this.f35183b = (RecyclerView) findViewById;
        View findViewById2 = findViewById(R.id.v_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.v_bar)");
        this.f35184c = findViewById2;
        View findViewById3 = findViewById(R.id.fl_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.fl_bar)");
        this.f35185d = (ConstraintLayout) findViewById3;
        View findViewById4 = findViewById(R.id.ll_wallet_page_loading);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.ll_wallet_page_loading)");
        this.f35186e = findViewById4;
        View findViewById5 = findViewById(R.id.ll_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.ll_bar)");
        this.f35187f = (LinearLayout) findViewById5;
        View findViewById6 = findViewById(R.id.tv_wallet_title);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.tv_wallet_title)");
        this.f35182a = (TextView) findViewById6;
        this.f35192k = (FrameLayout) findViewById(R.id.float_view);
        this.f35193l = (ImageView) findViewById(R.id.btn_close);
        this.f35194m = (ImageView) findViewById(R.id.float_view_res);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 12);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this) {
            final /* synthetic */ WalletHomePage this$0;

            {
                this.this$0 = r1;
            }

            public int getSpanSize(int i) {
                WalletHomePage walletHomePage = this.this$0;
                return walletHomePage.getHomeSpanCount(walletHomePage.f35188g, i);
            }
        });
        this.f35183b.setLayoutManager(gridLayoutManager);
        WalletHomeAdapter walletHomeAdapter = new WalletHomeAdapter(this.f35188g, this.f35191j);
        this.f35189h = walletHomeAdapter;
        this.f35183b.setAdapter(walletHomeAdapter);
        int dip2px = UIUtils.dip2px(getContext(), 20.0f);
        this.f35183b.addItemDecoration(new WalletHomeDecoration(this.f35188g, dip2px, dip2px, dip2px / 2));
        this.f35183b.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
            private int lastY;
            final /* synthetic */ WalletHomePage this$0;

            {
                this.this$0 = r1;
            }

            public final int getLastY() {
                return this.lastY;
            }

            public final void setLastY(int i) {
                this.lastY = i;
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, i, i2);
                int i3 = this.lastY + i2;
                this.lastY = i3;
                float f = ((float) i3) / ((float) 400);
                View access$getMVBar$p = this.this$0.f35184c;
                if (f >= 1.0f) {
                    f = 1.0f;
                }
                access$getMVBar$p.setAlpha(f);
                this.this$0.f35184c.setVisibility(this.lastY > 0 ? 0 : 8);
            }
        });
        setPagePaddingBottom(70.0f);
        showBackButton$default(this, false, (View.OnClickListener) null, 3, (Object) null);
        m26765a();
    }

    /* renamed from: a */
    private final void m26765a() {
        Lifecycle lifecycle;
        Context context = getContext();
        LifecycleOwner lifecycleOwner = context instanceof LifecycleOwner ? (LifecycleOwner) context : null;
        if (lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) {
            ScreenShotListenManager.INSTANCE.checkScreenShotEnable();
        } else {
            lifecycle.addObserver(new WalletHomePage$registerPermissionObserver$1$1());
        }
    }

    public final int getHomeSpanCount(List<WalletHomeHolderData<? extends IData>> list, int i) {
        if (list == null || i >= list.size()) {
            return 12;
        }
        Integer viewType = list.get(i).getViewType();
        if (viewType != null && viewType.intValue() == 1) {
            return 12;
        }
        if (viewType != null && viewType.intValue() == 5) {
            return 12;
        }
        if (viewType != null && viewType.intValue() == 2) {
            return 4;
        }
        if (viewType != null && viewType.intValue() == 3) {
            return 6;
        }
        if (viewType != null && viewType.intValue() == 4) {
            return 12;
        }
        if ((viewType != null && viewType.intValue() == 6) || viewType == null || viewType.intValue() == 8) {
        }
        return 12;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a2, code lost:
        r1 = r6.getAccountSection();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateContent(com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.Data r6) {
        /*
            r5 = this;
            com.didi.payment.base.tracker.FinResOmegaUtils$Companion r0 = com.didi.payment.base.tracker.FinResOmegaUtils.Companion
            android.content.Context r1 = r5.getContext()
            boolean r1 = r1 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0023
            android.content.Context r1 = r5.getContext()
            if (r1 == 0) goto L_0x001b
            android.app.Activity r1 = (android.app.Activity) r1
            android.content.ComponentName r1 = r1.getComponentName()
            java.lang.String r1 = r1.getClassName()
            goto L_0x0025
        L_0x001b:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type android.app.Activity"
            r6.<init>(r0)
            throw r6
        L_0x0023:
            java.lang.String r1 = ""
        L_0x0025:
            r0.setPubFromPage(r1)
            com.didi.payment.base.tracker.FinResOmegaUtils$Companion r0 = com.didi.payment.base.tracker.FinResOmegaUtils.Companion
            android.content.Context r1 = r5.getContext()
            java.lang.String r2 = "uid"
            java.lang.Object r1 = com.didi.payment.base.utils.PayBaseParamUtil.getParam(r1, r2)
            if (r1 == 0) goto L_0x00d6
            java.lang.String r1 = (java.lang.String) r1
            r0.setUid(r1)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeFreeze$Companion r0 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeFreeze.Companion
            androidx.recyclerview.widget.RecyclerView r1 = r5.f35183b
            android.content.Context r1 = r1.getContext()
            java.lang.String r2 = "mRvContent.context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r2 = 0
            if (r6 != 0) goto L_0x004d
        L_0x004b:
            r3 = r2
            goto L_0x005a
        L_0x004d:
            com.didi.payment.commonsdk.basemodel.account.AccountFreezeData r3 = r6.getNewFreezeSection()
            if (r3 != 0) goto L_0x0054
            goto L_0x004b
        L_0x0054:
            int r3 = r3.freezeStatus
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x005a:
            android.view.View r4 = r5.f35184c
            r0.switchWalletHomeNavBackground(r1, r3, r4)
            java.util.List<com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeHolderData<? extends com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.IData>> r0 = r5.f35188g
            if (r0 != 0) goto L_0x0064
            goto L_0x0067
        L_0x0064:
            r0.clear()
        L_0x0067:
            java.util.List<com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeHolderData<? extends com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.IData>> r0 = r5.f35188g
            if (r0 != 0) goto L_0x006c
            goto L_0x0077
        L_0x006c:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeDataConvert$Companion r1 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.WalletHomeDataConvert.Companion
            java.util.List r1 = r1.convertHomeData(r6)
            java.util.Collection r1 = (java.util.Collection) r1
            r0.addAll(r1)
        L_0x0077:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeAdapter r0 = r5.f35189h
            if (r0 != 0) goto L_0x007c
            goto L_0x0081
        L_0x007c:
            com.didi.payment.wallet.global.wallet.contract.WalletHomeContract$V2Listener r1 = r5.f35191j
            r0.setLister(r1)
        L_0x0081:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeAdapter r0 = r5.f35189h
            if (r0 != 0) goto L_0x0086
            goto L_0x0089
        L_0x0086:
            r0.notifyDataSetChanged()
        L_0x0089:
            if (r6 != 0) goto L_0x008c
            goto L_0x0096
        L_0x008c:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r0 = r6.getAccountSection()
            if (r0 != 0) goto L_0x0093
            goto L_0x0096
        L_0x0093:
            r5.m26769a((com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.AccountSection) r0)
        L_0x0096:
            if (r6 != 0) goto L_0x009a
            r0 = r2
            goto L_0x009e
        L_0x009a:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.HeadSection r0 = r6.getHeadSection()
        L_0x009e:
            if (r6 != 0) goto L_0x00a2
        L_0x00a0:
            r1 = r2
            goto L_0x00ad
        L_0x00a2:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.AccountSection r1 = r6.getAccountSection()
            if (r1 != 0) goto L_0x00a9
            goto L_0x00a0
        L_0x00a9:
            com.didi.payment.base.service.IWalletService$AccountInfo r1 = r1.getAccountStatus()
        L_0x00ad:
            r5.m26772a((com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.HeadSection) r0, (com.didi.payment.base.service.IWalletService.AccountInfo) r1)
            com.didi.payment.wallet.global.wallet.view.view.home.v2.tool.WalletHomeTrackerManager$Companion r0 = com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeTrackerManager.Companion
            r0.trackHomeSW()
            if (r6 != 0) goto L_0x00b8
            goto L_0x00bc
        L_0x00b8:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.CommonResourceState r2 = r6.getCommonResourceState()
        L_0x00bc:
            if (r2 != 0) goto L_0x00c8
            android.widget.FrameLayout r0 = r5.f35192k
            if (r0 != 0) goto L_0x00c3
            goto L_0x00c8
        L_0x00c3:
            r1 = 8
            r0.setVisibility(r1)
        L_0x00c8:
            if (r6 != 0) goto L_0x00cb
            goto L_0x00d5
        L_0x00cb:
            com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.CommonResourceState r6 = r6.getCommonResourceState()
            if (r6 != 0) goto L_0x00d2
            goto L_0x00d5
        L_0x00d2:
            r5.m26770a((com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.CommonResourceState) r6)
        L_0x00d5:
            return
        L_0x00d6:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.String"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.view.view.home.p143v2.WalletHomePage.updateContent(com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.Data):void");
    }

    /* renamed from: a */
    private final void m26770a(CommonResourceState commonResourceState) {
        ResourceStateData resourceStateData;
        List<ResourceStateData> suspensionState = commonResourceState.getSuspensionState();
        if (suspensionState != null && (resourceStateData = (ResourceStateData) CollectionsKt.firstOrNull(suspensionState)) != null) {
            FrameLayout frameLayout = this.f35192k;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            ImageView imageView = this.f35193l;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener(resourceStateData) {
                    public final /* synthetic */ ResourceStateData f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        WalletHomePage.m26768a(WalletHomePage.this, this.f$1, view);
                    }
                });
            }
            ImageView imageView2 = this.f35194m;
            if (imageView2 != null) {
                Map linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("activity_id", resourceStateData.getActivityId());
                linkedHashMap.put("resource_id", resourceStateData.getResourceId());
                linkedHashMap.put("plan_id", resourceStateData.getPlanId());
                linkedHashMap.put("pub_page", "wallethome");
                new FinResOmegaUtils("fin_general_float_sw").addParam("action_type", "resource_sw").addParamAll(linkedHashMap).send();
                GlideUtils.with2load2into(getContext(), resourceStateData.getImage(), imageView2);
                imageView2.setOnClickListener(new View.OnClickListener(this, linkedHashMap) {
                    public final /* synthetic */ WalletHomePage f$1;
                    public final /* synthetic */ Map f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        WalletHomePage.m26773a(ResourceStateData.this, this.f$1, this.f$2, view);
                    }
                });
                FinResourceRequest.notifyRecord$default(getFinRequest(), resourceStateData.getResourceId(), resourceStateData.getPlanId(), resourceStateData.getActivityId(), (String) null, new WalletHomePage$showFloatView$1$1$2$2(), 8, (Object) null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26768a(WalletHomePage walletHomePage, ResourceStateData resourceStateData, View view) {
        Intrinsics.checkNotNullParameter(walletHomePage, "this$0");
        Intrinsics.checkNotNullParameter(resourceStateData, "$data");
        FrameLayout frameLayout = walletHomePage.f35192k;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        walletHomePage.getFinRequest().notifyRecord(resourceStateData.getResourceId(), resourceStateData.getPlanId(), resourceStateData.getActivityId(), "close", new WalletHomePage$showFloatView$1$1$1$1());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26773a(ResourceStateData resourceStateData, WalletHomePage walletHomePage, Map map, View view) {
        Intrinsics.checkNotNullParameter(resourceStateData, "$data");
        Intrinsics.checkNotNullParameter(walletHomePage, "this$0");
        Intrinsics.checkNotNullParameter(map, "$omegaMap");
        if (!TextUtils.isEmpty(resourceStateData.getLink())) {
            DRouter.build(resourceStateData.getLink()).start(walletHomePage.getContext());
        }
        new FinResOmegaUtils("fin_general_float_ck").addParam("action_type", "resource_ck").addParamAll(map).send();
    }

    public void setListener(WalletHomeContract.V2Listener v2Listener) {
        this.f35191j = v2Listener;
    }

    public void initLoadingDialog(Activity activity) {
        LoadingProxyHolder.ILoadingProxy walletHomePage$initLoadingDialog$1 = new WalletHomePage$initLoadingDialog$1(activity, this);
        this.f35190i = walletHomePage$initLoadingDialog$1;
        LoadingProxyHolder.setProxy(walletHomePage$initLoadingDialog$1);
    }

    public void showLoadingDialog() {
        LoadingProxyHolder.ILoadingProxy iLoadingProxy = this.f35190i;
        if (iLoadingProxy != null) {
            iLoadingProxy.showLoading();
        }
    }

    public void dismissLoadingDialog() {
        LoadingProxyHolder.ILoadingProxy iLoadingProxy = this.f35190i;
        if (iLoadingProxy != null) {
            iLoadingProxy.dismissLoading();
        }
    }

    public void releaseLoadingDialog() {
        this.f35190i = null;
    }

    public void showTitle(String str) {
        CharSequence charSequence = str;
        this.f35182a.setText(charSequence);
        View view = this.f35182a;
        int i = 0;
        if (!(!(charSequence == null || charSequence.length() == 0))) {
            i = 8;
        }
        view.setVisibility(i);
    }

    public void updateEmptyView(String str) {
        List<WalletHomeHolderData<? extends IData>> list = this.f35188g;
        if (list != null) {
            list.clear();
        }
        WalletHomeHolderData walletHomeHolderData = new WalletHomeHolderData(7, null);
        walletHomeHolderData.setTitle(str);
        List<WalletHomeHolderData<? extends IData>> list2 = this.f35188g;
        if (list2 != null) {
            list2.add(walletHomeHolderData);
        }
        WalletHomeAdapter walletHomeAdapter = this.f35189h;
        if (walletHomeAdapter != null) {
            walletHomeAdapter.setLister(this.f35191j);
        }
        WalletHomeAdapter walletHomeAdapter2 = this.f35189h;
        if (walletHomeAdapter2 != null) {
            walletHomeAdapter2.notifyDataSetChanged();
        }
        m26772a((HeadSection) null, (IWalletService.AccountInfo) null);
    }

    public void onQRCodeDetected(PixQrCodeQueryResp.QRCodeData qRCodeData) {
        NQRDetectedDialogHelper.showDialog(getContext(), qRCodeData);
    }

    public void showPwdGuideDialog(WalletPopUpWindowResp walletPopUpWindowResp) {
        WalletPopUpWindowResp.Data data;
        Integer type;
        if (walletPopUpWindowResp != null && (data = walletPopUpWindowResp.getData()) != null && data.getType() != null && (type = data.getType()) != null && type.intValue() == 2) {
            GlobalAlertDialog globalAlertDialog = new GlobalAlertDialog();
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            arrayList.add(data.getButtonText());
            arrayList2.add(new GlobalAlertDialog.OnBtnClickListener() {
                public final void onBtnClick(DialogFragment dialogFragment, int i) {
                    WalletHomePage.m26767a(GlobalAlertDialog.this, dialogFragment, i);
                }
            });
            arrayList.add(data.getNegativeButtonText());
            arrayList2.add(new GlobalAlertDialog.OnBtnClickListener() {
                public final void onBtnClick(DialogFragment dialogFragment, int i) {
                    WalletHomePage.m26774b(GlobalAlertDialog.this, dialogFragment, i);
                }
            });
            globalAlertDialog.setButtons(arrayList);
            globalAlertDialog.setListeners(arrayList2);
            globalAlertDialog.setTitle(data.getTitle());
            globalAlertDialog.setMsg(data.getSubTitle());
            if (!globalAlertDialog.isVisible()) {
                FinOmegaSDK.trackEvent("ibt_password_popup_sw");
                Context context = getContext();
                if (context != null) {
                    globalAlertDialog.show(((FragmentActivity) context).getSupportFragmentManager(), "pwdDialog");
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26767a(GlobalAlertDialog globalAlertDialog, DialogFragment dialogFragment, int i) {
        Intrinsics.checkNotNullParameter(globalAlertDialog, "$dialog");
        FinOmegaSDK.trackEvent("ibt_password_popup_set_ck");
        OpenCertificationListener openCertificationListener = (OpenCertificationListener) ServiceLoaderUtil.getInstance().load(OpenCertificationListener.class);
        if (openCertificationListener != null) {
            PaySecure.INSTANCE.createPayPassword(PasswordScene.HOME_PAGE.name(), openCertificationListener, new WalletHomePage$showPwdGuideDialog$1$1$1());
        }
        globalAlertDialog.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m26774b(GlobalAlertDialog globalAlertDialog, DialogFragment dialogFragment, int i) {
        Intrinsics.checkNotNullParameter(globalAlertDialog, "$dialog");
        globalAlertDialog.dismiss();
    }

    public void onRefreshUI(boolean z) {
        int itemCount;
        WalletHomeAdapter walletHomeAdapter;
        if (z) {
            WalletHomeAdapter walletHomeAdapter2 = this.f35189h;
            if (walletHomeAdapter2 != null) {
                walletHomeAdapter2.notifyDataSetChanged();
                return;
            }
            return;
        }
        WalletHomeAdapter walletHomeAdapter3 = this.f35189h;
        if (walletHomeAdapter3 != null && (itemCount = walletHomeAdapter3.getItemCount()) > 1 && (walletHomeAdapter = this.f35189h) != null) {
            walletHomeAdapter.notifyItemRangeChanged(1, itemCount - 1);
        }
    }

    /* renamed from: a */
    private final void m26772a(HeadSection headSection, IWalletService.AccountInfo accountInfo) {
        List<Entry> entryList;
        if (headSection != null && (entryList = headSection.getEntryList()) != null) {
            this.f35187f.removeAllViews();
            int i = 0;
            for (Object next : entryList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Entry entry = (Entry) next;
                ImageView imageView = new ImageView(getContext());
                int dip2px = UIUtils.dip2px(getContext(), 20.0f);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dip2px, dip2px);
                int dip2px2 = UIUtils.dip2px(getContext(), 24.0f);
                int dip2px3 = UIUtils.dip2px(getContext(), 30.0f);
                if (i != 0) {
                    dip2px2 = dip2px3;
                }
                layoutParams.rightMargin = dip2px2;
                imageView.setLayoutParams(layoutParams);
                GlideUtils.with2load2into(getContext(), entry.getIconUrl(), imageView);
                imageView.setOnClickListener(new View.OnClickListener(this, accountInfo) {
                    public final /* synthetic */ WalletHomePage f$1;
                    public final /* synthetic */ IWalletService.AccountInfo f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        WalletHomePage.m26771a(Entry.this, this.f$1, this.f$2, view);
                    }
                });
                this.f35187f.addView(imageView);
                i = i2;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26771a(Entry entry, WalletHomePage walletHomePage, IWalletService.AccountInfo accountInfo, View view) {
        Intrinsics.checkNotNullParameter(entry, "$entry");
        Intrinsics.checkNotNullParameter(walletHomePage, "this$0");
        String linkUrl = entry.getLinkUrl();
        boolean z = true;
        if (linkUrl == null || !StringsKt.contains$default((CharSequence) linkUrl, (CharSequence) "/home_more", false, 2, (Object) null)) {
            z = false;
        }
        if (z) {
            Uri parse = Uri.parse(entry.getLinkUrl());
            boolean findUrlBoolParam$default = WalletUriParam.Companion.findUrlBoolParam$default(WalletUriParam.Companion, parse, "supportFullKyc", false, 4, (Object) null);
            int findUrlIntParam = WalletUriParam.Companion.findUrlIntParam(parse, "kycstatus");
            int findUrlIntParam2 = WalletUriParam.Companion.findUrlIntParam(parse, "fullKycStatus");
            WalletSettingPageInfo walletSettingPageInfo = new WalletSettingPageInfo();
            WalletPageQueryResp.AccountSectionItem accountSectionItem = new WalletPageQueryResp.AccountSectionItem();
            accountSectionItem.supportFullKyc = findUrlBoolParam$default;
            accountSectionItem.status = findUrlIntParam;
            accountSectionItem.fullKycStatus = findUrlIntParam2;
            accountSectionItem.accountStatus = accountInfo;
            Unit unit = Unit.INSTANCE;
            walletSettingPageInfo.accountSection = accountSectionItem;
            FreezeInterceptor.onInterceptor$default(FreezeInterceptor.INSTANCE, walletHomePage.getContext(), 2, false, new WalletHomePage$layoutNavigatorBar$1$1$1$2(parse, walletSettingPageInfo, walletHomePage), 4, (Object) null);
        } else {
            DRouter.build(entry.getLinkUrl()).start(walletHomePage.getContext());
        }
        WalletHomeTrackerManager.Companion.trackHomeNavigation(entry.getLinkUrl());
    }

    /* renamed from: a */
    private final void m26769a(AccountSection accountSection) {
        boolean z = false;
        WalletAccountData walletAccountData = new WalletAccountData(0, 0, false, (IWalletService.AccountInfo) null, (String) null, 31, (DefaultConstructorMarker) null);
        String kycStatus = accountSection.getKycStatus();
        walletAccountData.setStatus(kycStatus == null ? 0 : WalletHomeModelKt.toDefaultInt$default(kycStatus, 0, 1, (Object) null));
        String fullKycStatus = accountSection.getFullKycStatus();
        walletAccountData.setFullKycStatus(fullKycStatus == null ? 0 : WalletHomeModelKt.toDefaultInt$default(fullKycStatus, 0, 1, (Object) null));
        Boolean supportFullKyc = accountSection.getSupportFullKyc();
        if (supportFullKyc != null) {
            z = supportFullKyc.booleanValue();
        }
        walletAccountData.setSupportFullKyc(z);
        walletAccountData.setAccountStatus(accountSection.getAccountStatus());
        walletAccountData.setAuthenticationStatus(accountSection.getAuthenticationStatus());
        WalletSecuritySPUtils.setWalletAccountData(walletAccountData);
    }

    public static /* synthetic */ void setPagePaddingBottom$default(WalletHomePage walletHomePage, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        walletHomePage.setPagePaddingBottom(f);
    }

    public final void setPagePaddingBottom(float f) {
        this.f35183b.setPadding(0, 0, 0, UIUtils.dip2px(getContext(), f));
    }

    public static /* synthetic */ void showBackButton$default(WalletHomePage walletHomePage, boolean z, View.OnClickListener onClickListener, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            onClickListener = null;
        }
        walletHomePage.showBackButton(z, onClickListener);
    }

    public final void showBackButton(boolean z, View.OnClickListener onClickListener) {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fl_back);
        frameLayout.setVisibility(z ? 0 : 8);
        frameLayout.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                WalletHomePage.m26766a(View.OnClickListener.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26766a(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
