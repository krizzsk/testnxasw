package com.didi.soda.order.component.refund;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingIconAttr;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.rfusion.widget.floating.RFFloatingTextAttr;
import com.didi.soda.customer.foundation.rpc.entity.AbnormalItemInfoEntity;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalView;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.order.component.refund.Contract;
import com.didi.soda.order.model.AbnormalItemsInfoModel;
import com.didi.soda.order.view.RefundAbnormalItemView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(mo148867d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010!\u001a\u00020\u0016H\u0016J\u0018\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0014H\u0014J\b\u0010&\u001a\u00020\u0016H\u0002J\b\u0010'\u001a\u00020\u0016H\u0016J\u0012\u0010(\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001c\u0010)\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010*\u001a\u0004\u0018\u00010 H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000¨\u0006+"}, mo148868d2 = {"Lcom/didi/soda/order/component/refund/RefundDetailView;", "Lcom/didi/soda/order/component/refund/Contract$AbsRefundDetailView;", "Lcom/didi/rfusion/widget/floating/IRFFloatingExpand;", "()V", "abnormalInfoLayout", "Landroid/widget/LinearLayout;", "abnormalView", "Lcom/didi/soda/customer/widget/abnormal/topgun/TopGunAbnormalView;", "payMethodLayout", "Landroid/widget/RelativeLayout;", "paymentIcon", "Landroid/widget/ImageView;", "paymentValue", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "refundTotalDisplayTv", "refundTotalIcon", "Landroid/view/View;", "refundTotalLayout", "refundTotalTv", "rootView", "Landroid/view/ViewGroup;", "bindAbnormalItems", "", "abnormalItemsInfoModel", "Lcom/didi/soda/order/model/AbnormalItemsInfoModel;", "bindPayMethod", "payChannel", "Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;", "bindRefundTotal", "createAbnormalViewModel", "Lcom/didi/soda/customer/widget/abnormal/topgun/TopGunAbnormalViewModel;", "errorMsg", "", "hideAbnormalView", "inflateView", "inflater", "Landroid/view/LayoutInflater;", "container", "initNavBar", "onCreate", "showAbnormalView", "updateUI", "orderId", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: RefundDetailView.kt */
public final class RefundDetailView extends Contract.AbsRefundDetailView implements IRFFloatingExpand {

    /* renamed from: a */
    private LinearLayout f46018a;

    /* renamed from: b */
    private RelativeLayout f46019b;

    /* renamed from: c */
    private RelativeLayout f46020c;

    /* renamed from: d */
    private ImageView f46021d;

    /* renamed from: e */
    private CustomerAppCompatTextView f46022e;

    /* renamed from: f */
    private CustomerAppCompatTextView f46023f;

    /* renamed from: g */
    private CustomerAppCompatTextView f46024g;

    /* renamed from: h */
    private TopGunAbnormalView f46025h;

    /* renamed from: i */
    private ViewGroup f46026i;

    /* renamed from: j */
    private View f46027j;

    public /* synthetic */ void dismiss(ScopeContext scopeContext) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext);
    }

    public /* synthetic */ void dismiss(ScopeContext scopeContext, Bundle bundle) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext, bundle);
    }

    public /* synthetic */ Bundle getFloatingArgs(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getFloatingArgs(this, scopeContext);
    }

    public /* synthetic */ RFFloatingNavBar getNavBar(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getNavBar(this, scopeContext);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, page);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Dialog dialog, String str) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, dialog, str);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page, int i) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page, i);
    }

    public /* synthetic */ void setGestureEnable(ScopeContext scopeContext, boolean z) {
        IRFFloatingExpand.CC.$default$setGestureEnable(this, scopeContext, z);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_component_refund_detail, viewGroup, true);
        View findViewById = inflate.findViewById(R.id.customer_ll_abnormal_info);
        Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.customer_ll_abnormal_info)");
        this.f46018a = (LinearLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_rl_payment);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.customer_rl_payment)");
        this.f46019b = (RelativeLayout) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_rl_refund_total);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.customer_rl_refund_total)");
        this.f46020c = (RelativeLayout) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.customer_iv_payment_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "it.findViewById(R.id.customer_iv_payment_icon)");
        this.f46021d = (ImageView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.customer_tv_payment_value);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "it.findViewById(R.id.customer_tv_payment_value)");
        this.f46022e = (CustomerAppCompatTextView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.customer_refund_total_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "it.findViewById(R.id.customer_refund_total_tv)");
        this.f46023f = (CustomerAppCompatTextView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.customer_refund_total_display_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "it.findViewById(R.id.cus…_refund_total_display_tv)");
        this.f46024g = (CustomerAppCompatTextView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.customer_refund_abnormal_view);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "it.findViewById(R.id.cus…mer_refund_abnormal_view)");
        this.f46025h = (TopGunAbnormalView) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.customer_refund_detail_info);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "it.findViewById(R.id.customer_refund_detail_info)");
        this.f46026i = (ViewGroup) findViewById9;
        View findViewById10 = inflate.findViewById(R.id.customer_tv_refund_tip_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "it.findViewById(R.id.customer_tv_refund_tip_icon)");
        this.f46027j = findViewById10;
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…tv_refund_tip_icon)\n    }");
        return inflate;
    }

    public void onCreate() {
        super.onCreate();
        m34168a();
    }

    /* renamed from: a */
    private final void m34168a() {
        RFFloatingNavBar navBar = getNavBar(getScopeContext());
        if (navBar != null) {
            navBar.setLeftIcon(new RFFloatingIconAttr.Builder(1).click(new View.OnClickListener() {
                public final void onClick(View view) {
                    RefundDetailView.m34170a(RefundDetailView.this, view);
                }
            }).build());
            navBar.setTitle(new RFFloatingTextAttr.Builder(ResourceHelper.getString(R.string.FoodC_details_Details_of_DdYI)).build());
            navBar.setBackground(ResourceHelper.getColor(R.color.rf_color_gery_7_97_F5F5F7));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m34170a(RefundDetailView refundDetailView, View view) {
        Intrinsics.checkNotNullParameter(refundDetailView, "this$0");
        ((Contract.AbsRefundDetailPresenter) refundDetailView.getPresenter()).finish();
    }

    public void updateUI(AbnormalItemsInfoModel abnormalItemsInfoModel, String str) {
        if (abnormalItemsInfoModel != null) {
            m34172a(abnormalItemsInfoModel);
            m34169a(abnormalItemsInfoModel.getPayChannel());
            m34174b(abnormalItemsInfoModel);
            ((Contract.AbsRefundDetailPresenter) getPresenter()).onRefundDetailSw();
        }
    }

    public void showAbnormalView(String str) {
        TopGunAbnormalView topGunAbnormalView = this.f46025h;
        ViewGroup viewGroup = null;
        if (topGunAbnormalView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
            topGunAbnormalView = null;
        }
        topGunAbnormalView.setVisibility(0);
        TopGunAbnormalView topGunAbnormalView2 = this.f46025h;
        if (topGunAbnormalView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
            topGunAbnormalView2 = null;
        }
        topGunAbnormalView2.show(m34167a(str));
        ViewGroup viewGroup2 = this.f46026i;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        } else {
            viewGroup = viewGroup2;
        }
        viewGroup.setVisibility(4);
    }

    public void hideAbnormalView() {
        TopGunAbnormalView topGunAbnormalView = this.f46025h;
        ViewGroup viewGroup = null;
        if (topGunAbnormalView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
            topGunAbnormalView = null;
        }
        topGunAbnormalView.setVisibility(8);
        ViewGroup viewGroup2 = this.f46026i;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        } else {
            viewGroup = viewGroup2;
        }
        viewGroup.setVisibility(0);
    }

    /* renamed from: a */
    private final TopGunAbnormalViewModel m34167a(String str) {
        $$Lambda$RefundDetailView$2U3SLd4Pg3tPetTduUBDuq_MP5E r0 = new View.OnClickListener() {
            public final void onClick(View view) {
                RefundDetailView.m34173b(RefundDetailView.this, view);
            }
        };
        if (!NetWorkUtils.isNetworkConnected(getContext())) {
            TopGunAbnormalViewModel buildNoNetwork = TopGunAbnormalFactory.buildNoNetwork(r0);
            Intrinsics.checkNotNullExpressionValue(buildNoNetwork, "{\n            TopGunAbno…twork(listener)\n        }");
            return buildNoNetwork;
        }
        TopGunAbnormalViewModel buildHomeNoService = TopGunAbnormalFactory.buildHomeNoService(str, r0);
        Intrinsics.checkNotNullExpressionValue(buildHomeNoService, "{\n            TopGunAbno…rMsg, listener)\n        }");
        return buildHomeNoService;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m34173b(RefundDetailView refundDetailView, View view) {
        Intrinsics.checkNotNullParameter(refundDetailView, "this$0");
        ((Contract.AbsRefundDetailPresenter) refundDetailView.getPresenter()).retryRequest();
    }

    /* renamed from: a */
    private final void m34172a(AbnormalItemsInfoModel abnormalItemsInfoModel) {
        IntRange indices;
        ArrayList<AbnormalItemInfoEntity> items = abnormalItemsInfoModel == null ? null : abnormalItemsInfoModel.getItems();
        if (items != null && (indices = CollectionsKt.getIndices(items)) != null) {
            Iterator it = indices.iterator();
            while (it.hasNext()) {
                AbnormalItemInfoEntity abnormalItemInfoEntity = items.get(((IntIterator) it).nextInt());
                Intrinsics.checkNotNullExpressionValue(abnormalItemInfoEntity, "abnormalItems[index]");
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                RefundAbnormalItemView refundAbnormalItemView = new RefundAbnormalItemView(context);
                refundAbnormalItemView.bindData(abnormalItemInfoEntity);
                LinearLayout linearLayout = this.f46018a;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("abnormalInfoLayout");
                    linearLayout = null;
                }
                linearLayout.addView(refundAbnormalItemView);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.widget.RelativeLayout] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [android.widget.ImageView] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5, types: [android.widget.ImageView] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m34169a(com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity r7) {
        /*
            r6 = this;
            r0 = 8
            r1 = 0
            if (r7 == 0) goto L_0x0070
            int r2 = r7.channelId
            java.lang.String r3 = r7.channelName
            java.lang.String r4 = r7.cardSuffix
            r5 = 0
            java.lang.String r2 = com.didi.soda.customer.foundation.rpc.entity.cart.PayMethodListInfoEntity.getPayMethodChannelName(r2, r3, r4, r5)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r4 = "paymentValue"
            if (r3 != 0) goto L_0x0026
            com.didi.soda.customer.widget.support.CustomerAppCompatTextView r3 = r6.f46022e
            if (r3 != 0) goto L_0x0022
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r3 = r1
        L_0x0022:
            r3.setText(r2)
            goto L_0x0031
        L_0x0026:
            com.didi.soda.customer.widget.support.CustomerAppCompatTextView r2 = r6.f46022e
            if (r2 != 0) goto L_0x002e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r2 = r1
        L_0x002e:
            r2.setVisibility(r0)
        L_0x0031:
            java.lang.String r2 = r7.cardOrg
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r3 = "paymentIcon"
            if (r2 != 0) goto L_0x0063
            android.content.Context r0 = r6.getContext()
            java.lang.String r7 = r7.cardOrg
            com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r7 = com.didi.soda.customer.foundation.util.FlyImageLoader.loadImageUnspecified((android.content.Context) r0, (java.lang.String) r7)
            com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r7 = r7.centerCrop()
            android.widget.ImageView r0 = r6.f46021d
            if (r0 != 0) goto L_0x0053
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r1
        L_0x0053:
            r7.into((android.widget.ImageView) r0)
            android.widget.ImageView r7 = r6.f46021d
            if (r7 != 0) goto L_0x005e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x005f
        L_0x005e:
            r1 = r7
        L_0x005f:
            r1.setVisibility(r5)
            goto L_0x007e
        L_0x0063:
            android.widget.ImageView r7 = r6.f46021d
            if (r7 != 0) goto L_0x006b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x006c
        L_0x006b:
            r1 = r7
        L_0x006c:
            r1.setVisibility(r0)
            goto L_0x007e
        L_0x0070:
            android.widget.RelativeLayout r7 = r6.f46019b
            if (r7 != 0) goto L_0x007a
            java.lang.String r7 = "payMethodLayout"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            goto L_0x007b
        L_0x007a:
            r1 = r7
        L_0x007b:
            r1.setVisibility(r0)
        L_0x007e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.order.component.refund.RefundDetailView.m34169a(com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v41, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v46, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r7v1, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r1v13, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m34174b(com.didi.soda.order.model.AbnormalItemsInfoModel r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 != 0) goto L_0x0005
            r1 = r0
            goto L_0x0009
        L_0x0005:
            java.lang.String r1 = r7.getTotalName()
        L_0x0009:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0018
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r1 = 0
            goto L_0x0019
        L_0x0018:
            r1 = 1
        L_0x0019:
            r4 = 8
            java.lang.String r5 = "refundTotalLayout"
            if (r1 == 0) goto L_0x0045
            if (r7 != 0) goto L_0x0023
            r1 = r0
            goto L_0x0027
        L_0x0023:
            java.lang.String r1 = r7.getTotalDisplay()
        L_0x0027:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0034
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r1 = 0
            goto L_0x0035
        L_0x0034:
            r1 = 1
        L_0x0035:
            if (r1 == 0) goto L_0x0045
            android.widget.RelativeLayout r7 = r6.f46020c
            if (r7 != 0) goto L_0x003f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            goto L_0x0040
        L_0x003f:
            r0 = r7
        L_0x0040:
            r0.setVisibility(r4)
            goto L_0x00e1
        L_0x0045:
            android.widget.RelativeLayout r1 = r6.f46020c
            if (r1 != 0) goto L_0x004d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r1 = r0
        L_0x004d:
            r1.setVisibility(r3)
            if (r7 != 0) goto L_0x0054
            r1 = r0
            goto L_0x0058
        L_0x0054:
            java.lang.String r1 = r7.getTotalName()
        L_0x0058:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0065
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0063
            goto L_0x0065
        L_0x0063:
            r1 = 0
            goto L_0x0066
        L_0x0065:
            r1 = 1
        L_0x0066:
            if (r1 != 0) goto L_0x007f
            com.didi.soda.customer.widget.support.CustomerAppCompatTextView r1 = r6.f46023f
            if (r1 != 0) goto L_0x0072
            java.lang.String r1 = "refundTotalTv"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = r0
        L_0x0072:
            if (r7 != 0) goto L_0x0076
            r5 = r0
            goto L_0x007a
        L_0x0076:
            java.lang.String r5 = r7.getTotalName()
        L_0x007a:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
        L_0x007f:
            if (r7 != 0) goto L_0x0083
            r1 = r0
            goto L_0x0087
        L_0x0083:
            java.lang.String r1 = r7.getTotalDisplay()
        L_0x0087:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0093
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            r2 = 0
        L_0x0093:
            if (r2 != 0) goto L_0x00ac
            com.didi.soda.customer.widget.support.CustomerAppCompatTextView r1 = r6.f46024g
            if (r1 != 0) goto L_0x009f
            java.lang.String r1 = "refundTotalDisplayTv"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = r0
        L_0x009f:
            if (r7 != 0) goto L_0x00a3
            r2 = r0
            goto L_0x00a7
        L_0x00a3:
            java.lang.String r2 = r7.getTotalDisplay()
        L_0x00a7:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
        L_0x00ac:
            if (r7 != 0) goto L_0x00b0
            r1 = r0
            goto L_0x00b4
        L_0x00b0:
            com.didi.soda.customer.foundation.rpc.entity.bill.RuleDescEntity r1 = r7.getRuleDesc()
        L_0x00b4:
            java.lang.String r2 = "refundTotalIcon"
            if (r1 == 0) goto L_0x00d5
            android.view.View r1 = r6.f46027j
            if (r1 != 0) goto L_0x00c0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = r0
        L_0x00c0:
            r1.setVisibility(r3)
            android.view.View r1 = r6.f46027j
            if (r1 != 0) goto L_0x00cb
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x00cc
        L_0x00cb:
            r0 = r1
        L_0x00cc:
            com.didi.soda.order.component.refund.-$$Lambda$RefundDetailView$IY7WoW9pYzb6XuOx7LAvsgaUcjc r1 = new com.didi.soda.order.component.refund.-$$Lambda$RefundDetailView$IY7WoW9pYzb6XuOx7LAvsgaUcjc
            r1.<init>(r7)
            r0.setOnClickListener(r1)
            goto L_0x00e1
        L_0x00d5:
            android.view.View r7 = r6.f46027j
            if (r7 != 0) goto L_0x00dd
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x00de
        L_0x00dd:
            r0 = r7
        L_0x00de:
            r0.setVisibility(r4)
        L_0x00e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.order.component.refund.RefundDetailView.m34174b(com.didi.soda.order.model.AbnormalItemsInfoModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m34171a(RefundDetailView refundDetailView, AbnormalItemsInfoModel abnormalItemsInfoModel, View view) {
        Intrinsics.checkNotNullParameter(refundDetailView, "this$0");
        ((Contract.AbsRefundDetailPresenter) refundDetailView.getPresenter()).onTotalTipsCk(abnormalItemsInfoModel.getRuleDesc());
    }
}
