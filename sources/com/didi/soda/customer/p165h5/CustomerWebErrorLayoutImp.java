package com.didi.soda.customer.p165h5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalView;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.didi.soda.web.p168ui.IErrorLayout;
import com.didi.soda.web.widgets.WebPageTitleBar;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0002J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\rH\u0002J$\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\rJ,\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010 \u001a\u00020\rH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, mo148868d2 = {"Lcom/didi/soda/customer/h5/CustomerWebErrorLayoutImp;", "Lcom/didi/soda/web/ui/IErrorLayout;", "webPage", "Lcom/didi/soda/customer/h5/CustomerWebPage;", "errorCallback", "Lcom/didi/soda/customer/h5/ErrorCallback;", "hasNav", "", "(Lcom/didi/soda/customer/h5/CustomerWebPage;Lcom/didi/soda/customer/h5/ErrorCallback;Z)V", "abnormalView", "Lcom/didi/soda/customer/widget/abnormal/topgun/TopGunAbnormalView;", "isStatusBarShow", "adjustErrorLayoutParams", "", "parent", "Landroid/view/ViewGroup;", "backNeedHideIt", "hideStatusBar", "inflateErrorLayout", "context", "Landroid/content/Context;", "noNetWork", "onHideEvent", "isUseNativeTitltBar", "webPageTitleBar", "Lcom/didi/soda/web/widgets/WebPageTitleBar;", "navLineView", "Landroid/view/View;", "onStart", "showCustomerErrorView", "errorCode", "", "showStatusBar", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.soda.customer.h5.CustomerWebErrorLayoutImp */
/* compiled from: CustomerWebErrorLayoutImp.kt */
public final class CustomerWebErrorLayoutImp implements IErrorLayout {

    /* renamed from: a */
    private final CustomerWebPage f43880a;

    /* renamed from: b */
    private final ErrorCallback f43881b;

    /* renamed from: c */
    private final boolean f43882c;

    /* renamed from: d */
    private TopGunAbnormalView f43883d;

    /* renamed from: e */
    private boolean f43884e;

    public boolean backNeedHideIt() {
        return false;
    }

    public CustomerWebErrorLayoutImp(CustomerWebPage customerWebPage, ErrorCallback errorCallback, boolean z) {
        Intrinsics.checkNotNullParameter(customerWebPage, "webPage");
        this.f43880a = customerWebPage;
        this.f43881b = errorCallback;
        this.f43882c = z;
        this.f43884e = true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomerWebErrorLayoutImp(CustomerWebPage customerWebPage, ErrorCallback errorCallback, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(customerWebPage, (i & 2) != 0 ? null : errorCallback, (i & 4) != 0 ? false : z);
    }

    public void inflateErrorLayout(Context context, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        this.f43883d = (TopGunAbnormalView) LayoutInflater.from(context).inflate(R.layout.customer_view_web_error_layout, viewGroup).findViewById(R.id.customer_web_error_view);
        if (this.f43882c) {
            m32726a(viewGroup);
        }
    }

    public final void onStart() {
        if (!this.f43884e) {
            m32725a();
        }
    }

    /* renamed from: a */
    private final void m32725a() {
        this.f43884e = false;
        View pageRootView = this.f43880a.getPageRootView();
        if (pageRootView != null) {
            pageRootView.setPadding(pageRootView.getPaddingLeft(), 0, pageRootView.getPaddingRight(), pageRootView.getPaddingBottom());
        }
    }

    /* renamed from: b */
    private final void m32728b() {
        this.f43884e = true;
        View pageRootView = this.f43880a.getPageRootView();
        if (pageRootView != null) {
            pageRootView.setPadding(pageRootView.getPaddingLeft(), this.f43880a.getStatusBarHeight(), pageRootView.getPaddingRight(), pageRootView.getPaddingBottom());
        }
    }

    /* renamed from: a */
    private final void m32726a(ViewGroup viewGroup) {
        ViewParent parent = viewGroup.getParent();
        ViewGroup.LayoutParams layoutParams = null;
        LinearLayout linearLayout = parent instanceof LinearLayout ? (LinearLayout) parent : null;
        if (linearLayout != null) {
            layoutParams = linearLayout.getLayoutParams();
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).removeRule(3);
        }
    }

    public void showCustomerErrorView(int i, boolean z, WebPageTitleBar webPageTitleBar, View view) {
        ErrorCallback errorCallback = this.f43881b;
        if (errorCallback != null) {
            errorCallback.onShowError();
        }
        if (z) {
            if (view != null) {
                view.setVisibility(4);
            }
            m32725a();
        }
        if (i == -12) {
            m32729c();
        } else if (i == -8) {
            m32729c();
        } else if (i == -2 || i == -6 || i == -5) {
            m32729c();
        } else {
            m32729c();
        }
    }

    public void onHideEvent(boolean z, WebPageTitleBar webPageTitleBar, View view) {
        if (z) {
            if (view != null) {
                view.setVisibility(0);
            }
            m32728b();
        }
    }

    /* renamed from: c */
    private final void m32729c() {
        TopGunAbnormalViewModel buildNoNetwork = TopGunAbnormalFactory.buildNoNetwork(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomerWebErrorLayoutImp.m32727a(CustomerWebErrorLayoutImp.this, view);
            }
        });
        TopGunAbnormalView topGunAbnormalView = this.f43883d;
        if (topGunAbnormalView != null) {
            topGunAbnormalView.show(buildNoNetwork);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m32727a(CustomerWebErrorLayoutImp customerWebErrorLayoutImp, View view) {
        Intrinsics.checkNotNullParameter(customerWebErrorLayoutImp, "this$0");
        ErrorCallback errorCallback = customerWebErrorLayoutImp.f43881b;
        if (errorCallback != null) {
            errorCallback.onRetryEvent();
        }
        customerWebErrorLayoutImp.f43880a.reLoadSelf();
    }
}
