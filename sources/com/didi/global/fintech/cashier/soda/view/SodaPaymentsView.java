package com.didi.global.fintech.cashier.soda.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import com.didi.global.fintech.cashier.core.contract.IGlobalMainCashierPresenter;
import com.didi.global.fintech.cashier.core.view.GlobalCashierBaseView;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.p118ui.IGlobalCashierCardChannelViewHolder;
import com.didi.global.fintech.cashier.p118ui.IGlobalCashierPayBtnViewHolder;
import com.didi.global.fintech.cashier.p118ui.IGlobalCashierThirdChannelViewHolder;
import com.didi.global.fintech.cashier.soda.contract.ISodaHeaderViewHolder;
import com.didi.global.fintech.cashier.soda.contract.ISodaPaymentsView;
import com.taxis99.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010)\u001a\u00020\fH\u0016J\b\u0010*\u001a\u00020\u0014H\u0016J\b\u0010+\u001a\u00020\u0019H\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020-2\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020-H\u0016J\b\u00104\u001a\u00020\"H\u0016R\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\n \n*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \n*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\n \n*\u0004\u0018\u00010\u001e0\u001eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n \n*\u0004\u0018\u00010 0 X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b#\u0010$R\u0016\u0010&\u001a\u0004\u0018\u00010\u001e8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u00065"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/view/SodaPaymentsView;", "Lcom/didi/global/fintech/cashier/core/view/GlobalCashierBaseView;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalMainCashierPresenter;", "Lcom/didi/global/fintech/cashier/soda/contract/ISodaPaymentsView;", "mContext", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "mBottomView", "kotlin.jvm.PlatformType", "mCardChannelViewHolder", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCardChannelViewHolder;", "getMCardChannelViewHolder", "()Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCardChannelViewHolder;", "mCardChannelViewHolder$delegate", "Lkotlin/Lazy;", "mCenterView", "mHeaderView", "mHeaderViewHolder", "Lcom/didi/global/fintech/cashier/soda/contract/ISodaHeaderViewHolder;", "getMHeaderViewHolder", "()Lcom/didi/global/fintech/cashier/soda/contract/ISodaHeaderViewHolder;", "mHeaderViewHolder$delegate", "mPayBtnViewHolder", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierPayBtnViewHolder;", "getMPayBtnViewHolder", "()Lcom/didi/global/fintech/cashier/ui/IGlobalCashierPayBtnViewHolder;", "mPayBtnViewHolder$delegate", "mRootView", "Landroid/view/View;", "mScrollView", "Landroidx/core/widget/NestedScrollView;", "mThirdChannelViewHolder", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierThirdChannelViewHolder;", "getMThirdChannelViewHolder", "()Lcom/didi/global/fintech/cashier/ui/IGlobalCashierThirdChannelViewHolder;", "mThirdChannelViewHolder$delegate", "view", "getView", "()Landroid/view/View;", "cardChannelView", "headerView", "payBtnView", "scrollTo", "", "index", "", "setupView", "payInfoResponse", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "showLogoView", "thirdChannelView", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SodaPaymentsView.kt */
public final class SodaPaymentsView extends GlobalCashierBaseView<IGlobalMainCashierPresenter> implements ISodaPaymentsView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f23557a;

    /* renamed from: b */
    private final View f23558b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final ViewGroup f23559c;

    /* renamed from: d */
    private final NestedScrollView f23560d = ((NestedScrollView) this.f23558b.findViewById(R.id.layout_nsv_container));
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final ViewGroup f23561e = ((ViewGroup) this.f23558b.findViewById(R.id.fl_nsv_center));
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final ViewGroup f23562f = ((ViewGroup) this.f23558b.findViewById(R.id.layout_bottom_container));

    /* renamed from: g */
    private final Lazy f23563g = LazyKt.lazy(new SodaPaymentsView$mHeaderViewHolder$2(this));

    /* renamed from: h */
    private final Lazy f23564h = LazyKt.lazy(new SodaPaymentsView$mCardChannelViewHolder$2(this));

    /* renamed from: i */
    private final Lazy f23565i = LazyKt.lazy(new SodaPaymentsView$mThirdChannelViewHolder$2(this));

    /* renamed from: j */
    private final Lazy f23566j = LazyKt.lazy(new SodaPaymentsView$mPayBtnViewHolder$2(this));

    public void setupView(PayInfoResponse payInfoResponse) {
        Intrinsics.checkNotNullParameter(payInfoResponse, "payInfoResponse");
    }

    public SodaPaymentsView(Context context, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        this.f23557a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_soda_payments, viewGroup);
        this.f23558b = inflate;
        this.f23559c = (ViewGroup) inflate.findViewById(R.id.layout_header_container);
    }

    /* renamed from: a */
    private final ISodaHeaderViewHolder m19226a() {
        return (ISodaHeaderViewHolder) this.f23563g.getValue();
    }

    /* renamed from: b */
    private final IGlobalCashierCardChannelViewHolder m19227b() {
        return (IGlobalCashierCardChannelViewHolder) this.f23564h.getValue();
    }

    /* renamed from: c */
    private final IGlobalCashierThirdChannelViewHolder m19228c() {
        return (IGlobalCashierThirdChannelViewHolder) this.f23565i.getValue();
    }

    /* renamed from: d */
    private final IGlobalCashierPayBtnViewHolder m19229d() {
        return (IGlobalCashierPayBtnViewHolder) this.f23566j.getValue();
    }

    public ISodaHeaderViewHolder headerView() {
        return m19226a();
    }

    public IGlobalCashierCardChannelViewHolder cardChannelView() {
        return m19227b();
    }

    public IGlobalCashierThirdChannelViewHolder thirdChannelView() {
        return m19228c();
    }

    public IGlobalCashierPayBtnViewHolder payBtnView() {
        return m19229d();
    }

    public void scrollTo(int i) {
        this.f23560d.smoothScrollTo(0, 0, 1000);
    }

    public void showLogoView() {
        LayoutInflater from = LayoutInflater.from(this.f23557a);
        View view = this.f23558b;
        if (view != null) {
            from.inflate(R.layout.viewholder_global_cashier_logo, (ViewGroup) view);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public View getView() {
        return this.f23558b;
    }
}
