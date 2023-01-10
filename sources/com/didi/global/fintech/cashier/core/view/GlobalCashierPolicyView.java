package com.didi.global.fintech.cashier.core.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPolicyPresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPolicyView;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.PolicyInfo;
import com.didi.global.fintech.cashier.p118ui.IGlobalCashierHeaderViewHolder;
import com.didi.global.fintech.cashier.p118ui.IGlobalCashierPayBtnViewHolder;
import com.didi.global.fintech.cashier.p118ui.IGlobalCashierPolicyViewHolder;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010$\u001a\u00020\u0014H\u0016J\b\u0010%\u001a\u00020\u000eH\u0016J\b\u0010&\u001a\u00020\u0019H\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020(H\u0016R\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \n*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001d\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\u0004\u0018\u00010!8VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006,"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/core/view/GlobalCashierPolicyView;", "Lcom/didi/global/fintech/cashier/core/view/GlobalCashierBaseView;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPolicyPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPolicyView;", "mContext", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "mBottomView", "kotlin.jvm.PlatformType", "mContentView", "mHeaderView", "mHeaderViewHolder", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierHeaderViewHolder;", "getMHeaderViewHolder", "()Lcom/didi/global/fintech/cashier/ui/IGlobalCashierHeaderViewHolder;", "mHeaderViewHolder$delegate", "Lkotlin/Lazy;", "mPayBtnViewHolder", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierPayBtnViewHolder;", "getMPayBtnViewHolder", "()Lcom/didi/global/fintech/cashier/ui/IGlobalCashierPayBtnViewHolder;", "mPayBtnViewHolder$delegate", "mPolicyViewHolder", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierPolicyViewHolder;", "getMPolicyViewHolder", "()Lcom/didi/global/fintech/cashier/ui/IGlobalCashierPolicyViewHolder;", "mPolicyViewHolder$delegate", "mRootView", "notAgreeTip", "", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "btnView", "headerView", "policyView", "setupView", "", "response", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "showUncheckTip", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierPolicyView.kt */
public final class GlobalCashierPolicyView extends GlobalCashierBaseView<IGlobalCashierPolicyPresenter> implements IGlobalCashierPolicyView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f23376a;

    /* renamed from: b */
    private final ViewGroup f23377b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final ViewGroup f23378c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final ViewGroup f23379d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final ViewGroup f23380e;

    /* renamed from: f */
    private String f23381f;

    /* renamed from: g */
    private final Lazy f23382g;

    /* renamed from: h */
    private final Lazy f23383h;

    /* renamed from: i */
    private final Lazy f23384i;

    public GlobalCashierPolicyView(Context context, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        this.f23376a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_global_cashier_policy, viewGroup);
        if (inflate != null) {
            ViewGroup viewGroup2 = (ViewGroup) inflate;
            this.f23377b = viewGroup2;
            this.f23378c = (ViewGroup) viewGroup2.findViewById(R.id.layout_header_container);
            this.f23379d = (ViewGroup) this.f23377b.findViewById(R.id.fl_nsv_center);
            this.f23380e = (ViewGroup) this.f23377b.findViewById(R.id.layout_bottom_container);
            this.f23382g = LazyKt.lazy(new GlobalCashierPolicyView$mHeaderViewHolder$2(this));
            this.f23383h = LazyKt.lazy(new GlobalCashierPolicyView$mPolicyViewHolder$2(this));
            this.f23384i = LazyKt.lazy(new GlobalCashierPolicyView$mPayBtnViewHolder$2(this));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    /* renamed from: a */
    private final IGlobalCashierHeaderViewHolder m19179a() {
        return (IGlobalCashierHeaderViewHolder) this.f23382g.getValue();
    }

    /* renamed from: b */
    private final IGlobalCashierPolicyViewHolder m19180b() {
        return (IGlobalCashierPolicyViewHolder) this.f23383h.getValue();
    }

    /* renamed from: c */
    private final IGlobalCashierPayBtnViewHolder m19181c() {
        return (IGlobalCashierPayBtnViewHolder) this.f23384i.getValue();
    }

    public void setupView(PayInfoResponse payInfoResponse) {
        Intrinsics.checkNotNullParameter(payInfoResponse, "response");
        PolicyInfo policyInfo = payInfoResponse.getPolicyInfo();
        this.f23381f = policyInfo == null ? null : policyInfo.getNotAgreeTip();
    }

    public IGlobalCashierHeaderViewHolder headerView() {
        return m19179a();
    }

    public IGlobalCashierPolicyViewHolder policyView() {
        return m19180b();
    }

    public IGlobalCashierPayBtnViewHolder btnView() {
        return m19181c();
    }

    public void showUncheckTip() {
        SystemUtils.showToast(Toast.makeText(this.f23376a, this.f23381f, 0));
    }

    public View getView() {
        return this.f23377b;
    }
}
