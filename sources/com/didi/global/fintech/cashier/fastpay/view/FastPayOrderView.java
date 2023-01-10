package com.didi.global.fintech.cashier.fastpay.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.global.fintech.cashier.core.view.GlobalCashierBaseView;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayOrderPresenter;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayOrderView;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayOrderResponse;
import com.didi.global.fintech.cashier.p118ui.IFastPayHeaderViewHolder;
import com.didi.global.fintech.cashier.p118ui.IFastPayMainBtnViewHolder;
import com.didi.global.fintech.cashier.p118ui.IFastPayOrderContentViewHolder;
import com.taxis99.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\"\u001a\u00020\rH\u0016J\b\u0010#\u001a\u00020\u0014H\u0016J\b\u0010$\u001a\u00020\u0019H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016R\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \n*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\n \n*\u0004\u0018\u00010\u001e0\u001eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001e8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006)"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/fastpay/view/FastPayOrderView;", "Lcom/didi/global/fintech/cashier/core/view/GlobalCashierBaseView;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayOrderPresenter;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayOrderView;", "mContext", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "mBottomView", "kotlin.jvm.PlatformType", "mContentView", "mContentViewHolder", "Lcom/didi/global/fintech/cashier/ui/IFastPayOrderContentViewHolder;", "getMContentViewHolder", "()Lcom/didi/global/fintech/cashier/ui/IFastPayOrderContentViewHolder;", "mContentViewHolder$delegate", "Lkotlin/Lazy;", "mHeaderView", "mHeaderViewHolder", "Lcom/didi/global/fintech/cashier/ui/IFastPayHeaderViewHolder;", "getMHeaderViewHolder", "()Lcom/didi/global/fintech/cashier/ui/IFastPayHeaderViewHolder;", "mHeaderViewHolder$delegate", "mPayBtnViewHolder", "Lcom/didi/global/fintech/cashier/ui/IFastPayMainBtnViewHolder;", "getMPayBtnViewHolder", "()Lcom/didi/global/fintech/cashier/ui/IFastPayMainBtnViewHolder;", "mPayBtnViewHolder$delegate", "mRootView", "Landroid/view/View;", "view", "getView", "()Landroid/view/View;", "contentView", "headerView", "payBtnView", "setupView", "", "data", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayOrderResponse;", "cashier_fastpay_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FastPayOrderView.kt */
public final class FastPayOrderView extends GlobalCashierBaseView<IFastPayOrderPresenter> implements IFastPayOrderView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f23454a;

    /* renamed from: b */
    private final View f23455b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final ViewGroup f23456c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final ViewGroup f23457d = ((ViewGroup) this.f23455b.findViewById(R.id.layout_content_container));
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final ViewGroup f23458e = ((ViewGroup) this.f23455b.findViewById(R.id.layout_bottom_container));

    /* renamed from: f */
    private final Lazy f23459f = LazyKt.lazy(new FastPayOrderView$mHeaderViewHolder$2(this));

    /* renamed from: g */
    private final Lazy f23460g = LazyKt.lazy(new FastPayOrderView$mContentViewHolder$2(this));

    /* renamed from: h */
    private final Lazy f23461h = LazyKt.lazy(new FastPayOrderView$mPayBtnViewHolder$2(this));

    public void setupView(FastPayOrderResponse fastPayOrderResponse) {
        Intrinsics.checkNotNullParameter(fastPayOrderResponse, "data");
    }

    public FastPayOrderView(Context context, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        this.f23454a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_fast_pay_setting, viewGroup);
        this.f23455b = inflate;
        this.f23456c = (ViewGroup) inflate.findViewById(R.id.layout_header_container);
    }

    public View getView() {
        return this.f23455b;
    }

    /* renamed from: a */
    private final IFastPayHeaderViewHolder m19205a() {
        return (IFastPayHeaderViewHolder) this.f23459f.getValue();
    }

    /* renamed from: b */
    private final IFastPayOrderContentViewHolder m19206b() {
        return (IFastPayOrderContentViewHolder) this.f23460g.getValue();
    }

    /* renamed from: c */
    private final IFastPayMainBtnViewHolder m19207c() {
        return (IFastPayMainBtnViewHolder) this.f23461h.getValue();
    }

    public IFastPayHeaderViewHolder headerView() {
        return m19205a();
    }

    public IFastPayOrderContentViewHolder contentView() {
        return m19206b();
    }

    public IFastPayMainBtnViewHolder payBtnView() {
        return m19207c();
    }
}
