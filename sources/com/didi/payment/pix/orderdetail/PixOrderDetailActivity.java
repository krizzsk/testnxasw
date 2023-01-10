package com.didi.payment.pix.orderdetail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.payment.base.finResource.CommonResourceState;
import com.didi.payment.base.finResource.FinResUtils;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.FileUtil;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.base.view.PayRichInfo;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.p130ui.WBaseActivity;
import com.didi.payment.commonsdk.p130ui.WBaseViewModel;
import com.didi.payment.commonsdk.p130ui.helper.NViewHelper;
import com.didi.payment.commonsdk.utils.NCommonShareManager;
import com.didi.payment.commonsdk.utils.NViewUtils;
import com.didi.payment.pix.constant.PixRouter;
import com.didi.payment.pix.net.response.PixOrderDetailResp;
import com.didi.payment.pix.orderdetail.p137vm.PixOrderDetailVM;
import com.didi.payment.pix.orderdetail.widget.SectionSepretorLine;
import com.didi.payment.pix.qrpayee.widget.OrderDetail4ShareView;
import com.didi.payment.wallet.global.utils.WalletSecuritySPUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.taxis99.R;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u001fH\u0002J\u0012\u0010\"\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020\u001fH\u0014J\b\u0010&\u001a\u00020\u0018H\u0016J\b\u0010'\u001a\u00020\u001fH\u0002J\b\u0010(\u001a\u00020\u001fH\u0002J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\tH\u0002J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\tH\u0002J\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\tH\u0002J\u0010\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000¨\u00061"}, mo148868d2 = {"Lcom/didi/payment/pix/orderdetail/PixOrderDetailActivity;", "Lcom/didi/payment/commonsdk/ui/WBaseActivity;", "Lcom/didi/payment/pix/orderdetail/vm/PixOrderDetailVM;", "()V", "bottomFloatingBtn", "Landroid/widget/TextView;", "contentViewGroup", "Landroid/view/View;", "mOrderDetail", "Lcom/didi/payment/pix/net/response/PixOrderDetailResp$OrderDetail;", "mOrderIdPassIn", "", "mTitlebar", "Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "mainTitleTv", "pixOrderDetailPassIn", "sectionContainer", "Landroid/widget/LinearLayout;", "shareView", "Lcom/didi/payment/pix/qrpayee/widget/OrderDetail4ShareView;", "statusImg", "Landroid/widget/ImageView;", "statusImgMap", "", "", "titleDescTv", "tvLimitInfo", "viewInflater", "Landroid/view/LayoutInflater;", "getTitleBarView", "initContentView", "", "initTitleBar", "initVMObserver", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInflateContentLayout", "parseIntent", "performShareAction", "prepareView4Share", "detail", "renderPageUI", "orderDetai", "resetPadding", "od", "showFinSysPopUpDlgIfNeed", "orderDetail", "wallet-service-pix_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PixOrderDetailActivity.kt */
public final class PixOrderDetailActivity extends WBaseActivity<PixOrderDetailVM> {

    /* renamed from: a */
    private TextView f33629a;

    /* renamed from: b */
    private TextView f33630b;

    /* renamed from: c */
    private View f33631c;

    /* renamed from: d */
    private CommonTitleBar f33632d;

    /* renamed from: e */
    private PixOrderDetailResp.OrderDetail f33633e;

    /* renamed from: f */
    private LayoutInflater f33634f;

    /* renamed from: g */
    private TextView f33635g;

    /* renamed from: h */
    private TextView f33636h;

    /* renamed from: i */
    private ImageView f33637i;

    /* renamed from: j */
    private LinearLayout f33638j;

    /* renamed from: k */
    private OrderDetail4ShareView f33639k;

    /* renamed from: l */
    private String f33640l = "";

    /* renamed from: m */
    private PixOrderDetailResp.OrderDetail f33641m;

    /* renamed from: n */
    private Map<Integer, Integer> f33642n = MapsKt.mapOf(TuplesKt.m41339to(Integer.valueOf(PixOrderDetailResp.Companion.getORDER_STATUS_SUCCESS()), Integer.valueOf(R.drawable.pix_transfer_icon_success)), TuplesKt.m41339to(Integer.valueOf(PixOrderDetailResp.Companion.getORDER_STATUS_FAIL()), Integer.valueOf(R.drawable.pix_transfer_icon_failed)), TuplesKt.m41339to(Integer.valueOf(PixOrderDetailResp.Companion.getORDER_STATUS_PENDING()), Integer.valueOf(R.drawable.pix_transfer_icon_processing)));

    public int onInflateContentLayout() {
        return R.layout.pix_order_detail_activity;
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return this.f33632d;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        m25548c();
        m25544b();
    }

    public void initContentView() {
        View findViewById = findViewById(R.id.order_detail_scroll_layout);
        this.f33631c = findViewById;
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        this.f33629a = (TextView) findViewById(R.id.btn_refund_retry);
        View findViewById2 = findViewById(R.id.tv_limit_info);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_limit_info)");
        this.f33630b = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.pix_order_status_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.pix_order_status_tv)");
        this.f33635g = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.pix_order_amount_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.pix_order_amount_tv)");
        this.f33636h = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.order_status_icon_img);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.order_status_icon_img)");
        this.f33637i = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.section_container_Ll);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.section_container_Ll)");
        this.f33638j = (LinearLayout) findViewById6;
        LayoutInflater from = LayoutInflater.from(this);
        Intrinsics.checkNotNullExpressionValue(from, "from(this)");
        this.f33634f = from;
    }

    public void initTitleBar() {
        CommonTitleBar commonTitleBar = (CommonTitleBar) findViewById(R.id.pix_order_detail_titlebar);
        this.f33632d = commonTitleBar;
        if (commonTitleBar != null) {
            decoretaTitlebar(commonTitleBar);
            View findViewById = commonTitleBar.findViewById(R.id.title_bar_layout_above);
            if (findViewById != null) {
                findViewById.setBackgroundColor(0);
            }
        }
        CommonTitleBar commonTitleBar2 = this.f33632d;
        if (commonTitleBar2 != null) {
            ImageView imageView = (ImageView) commonTitleBar2.findViewById(R.id.img_web_title_more);
            if (imageView != null) {
                imageView.setImageResource(R.drawable.w_common_icon_share);
            }
            int dip2px = UIUtil.dip2px(this, -3.0f);
            NViewUtils nViewUtils = NViewUtils.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(imageView, "more2ShareImg");
            nViewUtils.incrementWidthHeight(imageView, dip2px, dip2px);
            commonTitleBar2.getLeftImgView().setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    PixOrderDetailActivity.m25539a(PixOrderDetailActivity.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25539a(PixOrderDetailActivity pixOrderDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(pixOrderDetailActivity, "this$0");
        pixOrderDetailActivity.finish();
    }

    /* renamed from: a */
    private final void m25537a(PixOrderDetailResp.OrderDetail orderDetail) {
        if (this.f33639k == null) {
            this.f33639k = new OrderDetail4ShareView(this);
        }
        OrderDetail4ShareView orderDetail4ShareView = this.f33639k;
        if (orderDetail4ShareView != null) {
            orderDetail4ShareView.renderPageUI(orderDetail);
        }
    }

    /* renamed from: a */
    private final void m25536a() {
        OrderDetail4ShareView orderDetail4ShareView = this.f33639k;
        if (orderDetail4ShareView != null) {
            showLoading();
            Executors.newSingleThreadExecutor().submit(new Runnable(orderDetail4ShareView) {
                public final /* synthetic */ OrderDetail4ShareView f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    PixOrderDetailActivity.m25542a(PixOrderDetailActivity.this, this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25542a(PixOrderDetailActivity pixOrderDetailActivity, OrderDetail4ShareView orderDetail4ShareView) {
        Intrinsics.checkNotNullParameter(pixOrderDetailActivity, "this$0");
        Context context = pixOrderDetailActivity;
        Bitmap genBitmap = NViewHelper.Companion.genBitmap(context, orderDetail4ShareView, true);
        new Handler(Looper.getMainLooper()).post(new Runnable(FileUtil.saveFile(context, genBitmap, Intrinsics.stringPlus(UUID.randomUUID().toString(), "_share_pic.png"), true), pixOrderDetailActivity, genBitmap) {
            public final /* synthetic */ String f$0;
            public final /* synthetic */ PixOrderDetailActivity f$1;
            public final /* synthetic */ Bitmap f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                PixOrderDetailActivity.m25543a(this.f$0, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25543a(String str, PixOrderDetailActivity pixOrderDetailActivity, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(pixOrderDetailActivity, "this$0");
        if (TextUtil.isEmpty(str)) {
            pixOrderDetailActivity.hideLoading();
        }
        NCommonShareManager.showCommonShareWindow(pixOrderDetailActivity, "", "https://rebrand.ly/99pay", str, new PixOrderDetailActivity$performShareAction$1$task$1$1$1(bitmap, pixOrderDetailActivity, str));
        pixOrderDetailActivity.hideLoading();
    }

    /* renamed from: b */
    private final void m25544b() {
        ViewModel viewModel = new ViewModelProvider(this).get(PixOrderDetailVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…rderDetailVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        subscribeUi(getVm());
        LifecycleOwner lifecycleOwner = this;
        ((PixOrderDetailVM) getVm()).getErrObj().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PixOrderDetailActivity.m25540a(PixOrderDetailActivity.this, (WBaseResp) obj);
            }
        });
        ((PixOrderDetailVM) getVm()).getDetailSections().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PixOrderDetailActivity.m25541a(PixOrderDetailActivity.this, (PixOrderDetailResp.OrderDetail) obj);
            }
        });
        ((PixOrderDetailVM) getVm()).loadDataByOid(this.f33640l);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25540a(PixOrderDetailActivity pixOrderDetailActivity, WBaseResp wBaseResp) {
        Intrinsics.checkNotNullParameter(pixOrderDetailActivity, "this$0");
        if (pixOrderDetailActivity.f33633e == null) {
            if (wBaseResp.errno == -900) {
                pixOrderDetailActivity.displayError();
                return;
            }
            TextView textView = pixOrderDetailActivity.f33629a;
            if (!(textView != null && textView.getVisibility() == 0)) {
                TextView textView2 = pixOrderDetailActivity.f33629a;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                TextView textView3 = pixOrderDetailActivity.f33629a;
                if (textView3 != null) {
                    textView3.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            PixOrderDetailActivity.m25547b(PixOrderDetailActivity.this, view);
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m25547b(PixOrderDetailActivity pixOrderDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(pixOrderDetailActivity, "this$0");
        ((PixOrderDetailVM) pixOrderDetailActivity.getVm()).loadDataByOid(pixOrderDetailActivity.f33640l);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25541a(PixOrderDetailActivity pixOrderDetailActivity, PixOrderDetailResp.OrderDetail orderDetail) {
        Intrinsics.checkNotNullParameter(pixOrderDetailActivity, "this$0");
        if (orderDetail != null) {
            Map hashMap = new HashMap();
            hashMap.put("pix_order_status", orderDetail.getStatus() == 1 ? "success" : orderDetail.getStatus() == 2 ? "fail" : "pending");
            hashMap.put("order_id", !TextUtil.isEmpty(pixOrderDetailActivity.f33640l) ? pixOrderDetailActivity.f33640l : orderDetail.getOrderId());
            FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_status_sw", hashMap);
            pixOrderDetailActivity.f33633e = orderDetail;
            pixOrderDetailActivity.m25549c(orderDetail);
            pixOrderDetailActivity.m25537a(orderDetail);
            pixOrderDetailActivity.m25545b(orderDetail);
        }
    }

    /* renamed from: b */
    private final void m25545b(PixOrderDetailResp.OrderDetail orderDetail) {
        CommonResourceState commonResourceState = orderDetail.getCommonResourceState();
        if (commonResourceState != null) {
            FinResUtils.INSTANCE.showFinSysPopUpDlg(this, commonResourceState.getPopUpState());
        }
    }

    /* renamed from: c */
    private final void m25549c(PixOrderDetailResp.OrderDetail orderDetail) {
        PixOrderDetailResp.OrderDetail orderDetail2 = orderDetail;
        View view = this.f33631c;
        int i = 0;
        if (view != null) {
            view.setVisibility(0);
        }
        int i2 = 1;
        TextView textView = null;
        if (orderDetail.canShare()) {
            CommonTitleBar commonTitleBar = this.f33632d;
            ImageView imageView = commonTitleBar == null ? null : (ImageView) commonTitleBar.findViewById(R.id.img_web_title_more);
            if (imageView != null) {
                Map hashMap = new HashMap();
                hashMap.put("pix_order_status", orderDetail.getStatus() == 1 ? "success" : orderDetail.getStatus() == 2 ? "fail" : "pending");
                hashMap.put("order_id", !TextUtil.isEmpty(this.f33640l) ? this.f33640l : orderDetail.getOrderId());
                FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_status_share_ck", hashMap);
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.w_common_icon_share);
                imageView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        PixOrderDetailActivity.m25550c(PixOrderDetailActivity.this, view);
                    }
                });
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
        }
        TextView textView2 = this.f33635g;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTitleTv");
            textView2 = null;
        }
        textView2.setText(orderDetail.getTitle());
        TextView textView3 = this.f33636h;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleDescTv");
            textView3 = null;
        }
        int indexOf$default = StringsKt.indexOf$default((CharSequence) orderDetail.getAmount(), "R$", 0, false, 6, (Object) null);
        textView3.setText(orderDetail.getAmount());
        ImageView imageView2 = this.f33637i;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusImg");
            imageView2 = null;
        }
        imageView2.setImageResource(R.drawable.pix_transfer_icon_processing);
        int color = orderDetail.getStatus() == PixOrderDetailResp.Companion.getORDER_STATUS_SUCCESS() ? getResources().getColor(R.color.oc_color_00ccaa) : -16777216;
        TextView textView4 = this.f33636h;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleDescTv");
            textView4 = null;
        }
        textView4.setTextColor(color);
        Integer num = this.f33642n.get(Integer.valueOf(orderDetail.getStatus()));
        if (num != null) {
            int intValue = num.intValue();
            ImageView imageView3 = this.f33637i;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusImg");
                imageView3 = null;
            }
            imageView3.setImageResource(intValue);
            Unit unit3 = Unit.INSTANCE;
            Unit unit4 = Unit.INSTANCE;
        }
        List<PixOrderDetailResp.SectionEntry> entryList = orderDetail.getEntryList();
        LinearLayout linearLayout = this.f33638j;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sectionContainer");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        int size = entryList.size() - 1;
        if (size >= 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                PixOrderDetailResp.SectionEntry sectionEntry = orderDetail.getEntryList().get(i3);
                CollectionUtil.isEmpty((Collection<?>) sectionEntry.getItems());
                Context context = this;
                LinearLayout linearLayout2 = new LinearLayout(context);
                linearLayout2.setOrientation(i2);
                int dip2px = UIUtil.dip2px(context, 20.0f);
                int dip2px2 = UIUtil.dip2px(context, 6.0f);
                if (i3 == 0) {
                    linearLayout2.setPadding(dip2px, dip2px2, dip2px, i);
                } else {
                    linearLayout2.setPadding(dip2px, i, dip2px, i);
                }
                LayoutInflater layoutInflater = this.f33634f;
                if (layoutInflater == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewInflater");
                    layoutInflater = null;
                }
                View inflate = layoutInflater.inflate(R.layout.pix_order_detail_section_title, (ViewGroup) null);
                if (inflate != null) {
                    TextView textView5 = (TextView) inflate;
                    textView5.setText(sectionEntry.getTitle());
                    linearLayout2.addView(textView5);
                    for (PixOrderDetailResp.NameValuePair next : sectionEntry.getItems()) {
                        LayoutInflater layoutInflater2 = this.f33634f;
                        if (layoutInflater2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewInflater");
                            layoutInflater2 = null;
                        }
                        View inflate2 = layoutInflater2.inflate(R.layout.pix_order_detail_item, (ViewGroup) null);
                        TextView textView6 = (TextView) inflate2.findViewById(R.id.left_key_tv);
                        TextView textView7 = (TextView) inflate2.findViewById(R.id.right_value_tv);
                        if (next.getRichValue() != null) {
                            PayRichInfo richKey = next.getRichKey();
                            if (richKey != null) {
                                richKey.bindTextView(textView6, (PayRichInfo.ISpannableString) null);
                                Unit unit5 = Unit.INSTANCE;
                            }
                        } else {
                            textView6.setText(next.getKey());
                        }
                        if (next.getRichValue() != null) {
                            PayRichInfo richValue = next.getRichValue();
                            if (richValue != null) {
                                richValue.bindTextView(textView7, (PayRichInfo.ISpannableString) null);
                                Unit unit6 = Unit.INSTANCE;
                            }
                        } else {
                            textView7.setText(next.getValue());
                        }
                        linearLayout2.addView(inflate2);
                    }
                    LinearLayout linearLayout3 = this.f33638j;
                    if (linearLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sectionContainer");
                        linearLayout3 = null;
                    }
                    linearLayout3.addView(linearLayout2);
                    if (i3 < orderDetail.getEntryList().size() - 1) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                        int dip2px3 = UIUtil.dip2px(context, 5.0f);
                        layoutParams.topMargin = dip2px3;
                        layoutParams.bottomMargin = dip2px3;
                        LinearLayout linearLayout4 = this.f33638j;
                        if (linearLayout4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("sectionContainer");
                            linearLayout4 = null;
                        }
                        linearLayout4.addView(new SectionSepretorLine(context));
                    }
                    if (i4 > size) {
                        break;
                    }
                    i3 = i4;
                    i = 0;
                    i2 = 1;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
                }
            }
        }
        Unit unit7 = Unit.INSTANCE;
        int i5 = 8;
        if (orderDetail.canRefund()) {
            TextView textView8 = this.f33629a;
            if (textView8 != null) {
                textView8.setVisibility(0);
            }
            TextView textView9 = this.f33629a;
            if (textView9 != null) {
                textView9.setText(getString(R.string.GRider_payment_Refund_CjZI));
            }
            TextView textView10 = this.f33629a;
            if (textView10 != null) {
                textView10.setEnabled(true);
            }
            TextView textView11 = this.f33629a;
            if (textView11 != null) {
                textView11.setOnClickListener(new View.OnClickListener(this) {
                    public final /* synthetic */ PixOrderDetailActivity f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        PixOrderDetailActivity.m25538a(PixOrderDetailResp.OrderDetail.this, this.f$1, view);
                    }
                });
                Unit unit8 = Unit.INSTANCE;
            }
        } else if (orderDetail.canRetry()) {
            TextView textView12 = this.f33629a;
            if (textView12 != null) {
                textView12.setVisibility(0);
            }
            TextView textView13 = this.f33629a;
            if (textView13 != null) {
                textView13.setText(getString(R.string.GRider_payment_Try_again_BEvR));
            }
            TextView textView14 = this.f33629a;
            if (textView14 != null) {
                textView14.setEnabled(true);
            }
            TextView textView15 = this.f33629a;
            if (textView15 != null) {
                textView15.setOnClickListener(new View.OnClickListener(this) {
                    public final /* synthetic */ PixOrderDetailActivity f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        PixOrderDetailActivity.m25546b(PixOrderDetailResp.OrderDetail.this, this.f$1, view);
                    }
                });
                Unit unit9 = Unit.INSTANCE;
            }
        } else {
            TextView textView16 = this.f33629a;
            if (textView16 != null) {
                textView16.setVisibility(8);
            }
            m25551d(orderDetail);
        }
        PixOrderDetailResp.RuleLimitDetailVo ruleLimitDetail = orderDetail.getRuleLimitDetail();
        if (ruleLimitDetail != null) {
            TextView textView17 = this.f33630b;
            if (textView17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvLimitInfo");
                textView17 = null;
            }
            textView17.setText(ruleLimitDetail.getText());
            TextView textView18 = this.f33630b;
            if (textView18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvLimitInfo");
                textView18 = null;
            }
            View view2 = textView18;
            CharSequence text = ruleLimitDetail.getText();
            if (!(text == null || text.length() == 0)) {
                i5 = 0;
            }
            view2.setVisibility(i5);
            TextView textView19 = this.f33630b;
            if (textView19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvLimitInfo");
                textView19 = null;
            }
            if (textView19.getVisibility() == 0) {
                Map hashMap2 = new HashMap();
                hashMap2.put("pub_page", "order_finish");
                hashMap2.put("pub_target", "text");
                hashMap2.put("pub_biz", "fintech");
                hashMap2.put("product_line", 99996);
                hashMap2.put("text_theme", LoginOmegaUtil.NEED_VERIFY_EMAIL);
                hashMap2.put("kyc_tag", Integer.valueOf(WalletSecuritySPUtils.getKycTag()));
                PayTracker.trackEvent("ibt_fintech_passenger_text_sw", hashMap2);
            }
            TextView textView20 = this.f33630b;
            if (textView20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvLimitInfo");
            } else {
                textView = textView20;
            }
            textView.setOnClickListener(new PixOrderDetailActivity$renderPageUI$1$6(ruleLimitDetail, this));
        } else {
            TextView textView21 = this.f33630b;
            if (textView21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvLimitInfo");
            } else {
                textView = textView21;
            }
            textView.setVisibility(8);
        }
        Unit unit10 = Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m25550c(PixOrderDetailActivity pixOrderDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(pixOrderDetailActivity, "this$0");
        pixOrderDetailActivity.m25536a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m25538a(PixOrderDetailResp.OrderDetail orderDetail, PixOrderDetailActivity pixOrderDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(orderDetail, "$orderDetai");
        Intrinsics.checkNotNullParameter(pixOrderDetailActivity, "this$0");
        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_success_refund_ck", "order_id", orderDetail.getOrderId());
        ((Request) DRouter.build(PixRouter.build("/pix_order_refund")).putExtra("order_id", pixOrderDetailActivity.f33640l)).start(pixOrderDetailActivity);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m25546b(PixOrderDetailResp.OrderDetail orderDetail, PixOrderDetailActivity pixOrderDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(orderDetail, "$it");
        Intrinsics.checkNotNullParameter(pixOrderDetailActivity, "this$0");
        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_pending_retry_ck", "order_id", orderDetail.getOrderId());
        ((PixOrderDetailVM) pixOrderDetailActivity.getVm()).orderRetry(!TextUtil.isEmpty(pixOrderDetailActivity.f33640l) ? pixOrderDetailActivity.f33640l : orderDetail.getOrderId());
    }

    /* renamed from: d */
    private final void m25551d(PixOrderDetailResp.OrderDetail orderDetail) {
        View view;
        if (!orderDetail.canRefund() && !orderDetail.canRetry() && (view = this.f33631c) != null) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), 0);
        }
    }

    /* renamed from: c */
    private final void m25548c() {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("order_id");
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.f33640l = stringExtra;
            Serializable serializableExtra = intent.getSerializableExtra("order_detail");
            if (serializableExtra != null) {
                PixOrderDetailResp.OrderDetail orderDetail = (PixOrderDetailResp.OrderDetail) serializableExtra;
                this.f33641m = orderDetail;
                if (orderDetail != null) {
                    this.f33640l = orderDetail.getOrderId();
                    m25549c(orderDetail);
                }
            }
        }
    }
}
