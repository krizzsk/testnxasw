package com.didi.soda.home.component.policy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.home.component.policy.Contract;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo148868d2 = {"Lcom/didi/soda/home/component/policy/PolicyUpdateView;", "Lcom/didi/soda/home/component/policy/Contract$AbsPolicyUpdateView;", "Lcom/didi/rfusion/widget/floating/IRFFloatingExpand;", "()V", "mClPolicyUpdateBottom", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mSvPolicyUpdateContainer", "Landroid/widget/ScrollView;", "mTvPolicyUpdateContent", "Landroid/widget/TextView;", "inflateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onCreate", "", "setPolicyContentMaxHeight", "updatePolicyContent", "content", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PolicyUpdateView.kt */
public final class PolicyUpdateView extends Contract.AbsPolicyUpdateView implements IRFFloatingExpand {

    /* renamed from: a */
    private TextView f45097a;

    /* renamed from: b */
    private ConstraintLayout f45098b;

    /* renamed from: c */
    private ScrollView f45099c;

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

    public void updatePolicyContent(String str) {
        if (str != null) {
            TextView textView = this.f45097a;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvPolicyUpdateContent");
                textView = null;
            }
            textView.setText(str);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        m33479a();
    }

    /* renamed from: a */
    private final void m33479a() {
        ConstraintLayout constraintLayout = this.f45098b;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mClPolicyUpdateBottom");
            constraintLayout = null;
        }
        constraintLayout.post(new Runnable() {
            public final void run() {
                PolicyUpdateView.m33480a(PolicyUpdateView.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33480a(PolicyUpdateView policyUpdateView) {
        Intrinsics.checkNotNullParameter(policyUpdateView, "this$0");
        ScrollView scrollView = policyUpdateView.f45099c;
        ScrollView scrollView2 = null;
        if (scrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSvPolicyUpdateContainer");
            scrollView = null;
        }
        ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            int screenHeight = (DisplayUtils.getScreenHeight(policyUpdateView.getContext()) - ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_20)) - ResourceHelper.getDimensionPixelSize(R.dimen.rf_floating_nav_bar_height);
            ConstraintLayout constraintLayout = policyUpdateView.f45098b;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mClPolicyUpdateBottom");
                constraintLayout = null;
            }
            layoutParams2.matchConstraintMaxHeight = (screenHeight - constraintLayout.getMeasuredHeight()) - ResourceHelper.getDimensionPixelSize(R.dimen.customer_32px);
            ScrollView scrollView3 = policyUpdateView.f45099c;
            if (scrollView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSvPolicyUpdateContainer");
            } else {
                scrollView2 = scrollView3;
            }
            scrollView2.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_component_policy_update, viewGroup, true);
        View findViewById = inflate.findViewById(R.id.customer_tv_policy_update_content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "this.findViewById<TextVi…tv_policy_update_content)");
        this.f45097a = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_cl_policy_update_bottom);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "this.findViewById<Constr…_cl_policy_update_bottom)");
        this.f45098b = (ConstraintLayout) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_sv_policy_update_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "this.findViewById<Scroll…_policy_update_container)");
        this.f45099c = (ScrollView) findViewById3;
        ((RFMainButton) inflate.findViewById(R.id.customer_btn_policy_update_ok)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PolicyUpdateView.m33481a(PolicyUpdateView.this, view);
            }
        });
        ((TextView) inflate.findViewById(R.id.customer_tv_policy_update_link)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PolicyUpdateView.m33482b(PolicyUpdateView.this, view);
            }
        });
        ((TextView) inflate.findViewById(R.id.customer_icon_policy_update_arrow)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PolicyUpdateView.m33483c(PolicyUpdateView.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…              }\n        }");
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33481a(PolicyUpdateView policyUpdateView, View view) {
        Intrinsics.checkNotNullParameter(policyUpdateView, "this$0");
        ((Contract.AbsPolicyUpdatePresenter) policyUpdateView.getPresenter()).confirmPolicy();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m33482b(PolicyUpdateView policyUpdateView, View view) {
        Intrinsics.checkNotNullParameter(policyUpdateView, "this$0");
        ((Contract.AbsPolicyUpdatePresenter) policyUpdateView.getPresenter()).showPolicyDetail();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m33483c(PolicyUpdateView policyUpdateView, View view) {
        Intrinsics.checkNotNullParameter(policyUpdateView, "this$0");
        ((Contract.AbsPolicyUpdatePresenter) policyUpdateView.getPresenter()).showPolicyDetail();
    }
}
