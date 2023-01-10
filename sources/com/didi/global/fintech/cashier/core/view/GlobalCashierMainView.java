package com.didi.global.fintech.cashier.core.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierView;
import com.didi.global.fintech.cashier.core.contract.IGlobalMainCashierPresenter;
import com.didi.global.fintech.cashier.core.contract.IPresenter;
import com.didi.global.fintech.cashier.core.contract.IView;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.p118ui.IGlobalCashierCardChannelViewHolder;
import com.didi.global.fintech.cashier.p118ui.IGlobalCashierFeeViewHolder;
import com.didi.global.fintech.cashier.p118ui.IGlobalCashierHeaderViewHolder;
import com.didi.global.fintech.cashier.p118ui.IGlobalCashierPayBtnViewHolder;
import com.didi.global.fintech.cashier.p118ui.IGlobalCashierThirdChannelViewHolder;
import com.taxis99.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010/\u001a\u0002002\u000e\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020302H\u0016J\b\u00104\u001a\u00020\fH\u0016J\b\u00105\u001a\u00020\u0014H\u0016J\b\u00106\u001a\u00020\u001aH\u0016J\b\u00107\u001a\u00020\u001fH\u0016J\u0010\u00108\u001a\u0002002\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u0002002\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u000200H\u0016J\b\u0010?\u001a\u00020(H\u0016R\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\n \n*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \n*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\n \n*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b \u0010!R\u0016\u0010#\u001a\n \n*\u0004\u0018\u00010$0$X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n \n*\u0004\u0018\u00010&0&X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010'\u001a\u00020(8BX\u0002¢\u0006\f\n\u0004\b+\u0010\u0010\u001a\u0004\b)\u0010*R\u0016\u0010,\u001a\u0004\u0018\u00010$8VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u0006@"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/core/view/GlobalCashierMainView;", "Lcom/didi/global/fintech/cashier/core/view/GlobalCashierBaseView;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalMainCashierPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierView;", "mContext", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "mBottomView", "kotlin.jvm.PlatformType", "mCardChannelViewHolder", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCardChannelViewHolder;", "getMCardChannelViewHolder", "()Lcom/didi/global/fintech/cashier/ui/IGlobalCashierCardChannelViewHolder;", "mCardChannelViewHolder$delegate", "Lkotlin/Lazy;", "mCenterView", "mFeeView", "mFeeViewHolder", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierFeeViewHolder;", "getMFeeViewHolder", "()Lcom/didi/global/fintech/cashier/ui/IGlobalCashierFeeViewHolder;", "mFeeViewHolder$delegate", "mHeaderView", "mHeaderViewHolder", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierHeaderViewHolder;", "getMHeaderViewHolder", "()Lcom/didi/global/fintech/cashier/ui/IGlobalCashierHeaderViewHolder;", "mHeaderViewHolder$delegate", "mPayBtnViewHolder", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierPayBtnViewHolder;", "getMPayBtnViewHolder", "()Lcom/didi/global/fintech/cashier/ui/IGlobalCashierPayBtnViewHolder;", "mPayBtnViewHolder$delegate", "mRootView", "Landroid/view/View;", "mScrollView", "Landroidx/core/widget/NestedScrollView;", "mThirdChannelViewHolder", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierThirdChannelViewHolder;", "getMThirdChannelViewHolder", "()Lcom/didi/global/fintech/cashier/ui/IGlobalCashierThirdChannelViewHolder;", "mThirdChannelViewHolder$delegate", "view", "getView", "()Landroid/view/View;", "bindPresenter", "", "presenter", "Lcom/didi/global/fintech/cashier/core/contract/IPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IView;", "cardChannelView", "feeView", "headerView", "payBtnView", "scrollTo", "index", "", "setupView", "payInfoResponse", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "showLogoView", "thirdChannelView", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierMainView.kt */
public final class GlobalCashierMainView extends GlobalCashierBaseView<IGlobalMainCashierPresenter> implements IGlobalCashierView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f23364a;

    /* renamed from: b */
    private final View f23365b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final ViewGroup f23366c;

    /* renamed from: d */
    private final NestedScrollView f23367d = ((NestedScrollView) this.f23365b.findViewById(R.id.layout_nsv_container));
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final ViewGroup f23368e = ((ViewGroup) this.f23365b.findViewById(R.id.layout_fee_container));
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final ViewGroup f23369f = ((ViewGroup) this.f23365b.findViewById(R.id.fl_nsv_center));
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final ViewGroup f23370g = ((ViewGroup) this.f23365b.findViewById(R.id.layout_bottom_container));

    /* renamed from: h */
    private final Lazy f23371h = LazyKt.lazy(new GlobalCashierMainView$mHeaderViewHolder$2(this));

    /* renamed from: i */
    private final Lazy f23372i = LazyKt.lazy(new GlobalCashierMainView$mFeeViewHolder$2(this));

    /* renamed from: j */
    private final Lazy f23373j = LazyKt.lazy(new GlobalCashierMainView$mCardChannelViewHolder$2(this));

    /* renamed from: k */
    private final Lazy f23374k = LazyKt.lazy(new GlobalCashierMainView$mThirdChannelViewHolder$2(this));

    /* renamed from: l */
    private final Lazy f23375l = LazyKt.lazy(new GlobalCashierMainView$mPayBtnViewHolder$2(this));

    public void setupView(PayInfoResponse payInfoResponse) {
        Intrinsics.checkNotNullParameter(payInfoResponse, "payInfoResponse");
    }

    public GlobalCashierMainView(Context context, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        this.f23364a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_global_cashier, viewGroup);
        this.f23365b = inflate;
        this.f23366c = (ViewGroup) inflate.findViewById(R.id.layout_header_container);
    }

    /* renamed from: a */
    private final IGlobalCashierHeaderViewHolder m19173a() {
        return (IGlobalCashierHeaderViewHolder) this.f23371h.getValue();
    }

    /* renamed from: b */
    private final IGlobalCashierFeeViewHolder m19175b() {
        return (IGlobalCashierFeeViewHolder) this.f23372i.getValue();
    }

    /* renamed from: c */
    private final IGlobalCashierCardChannelViewHolder m19176c() {
        return (IGlobalCashierCardChannelViewHolder) this.f23373j.getValue();
    }

    /* renamed from: d */
    private final IGlobalCashierThirdChannelViewHolder m19177d() {
        return (IGlobalCashierThirdChannelViewHolder) this.f23374k.getValue();
    }

    /* renamed from: e */
    private final IGlobalCashierPayBtnViewHolder m19178e() {
        return (IGlobalCashierPayBtnViewHolder) this.f23375l.getValue();
    }

    public IGlobalCashierHeaderViewHolder headerView() {
        return m19173a();
    }

    public IGlobalCashierFeeViewHolder feeView() {
        return m19175b();
    }

    public IGlobalCashierCardChannelViewHolder cardChannelView() {
        return m19176c();
    }

    public IGlobalCashierThirdChannelViewHolder thirdChannelView() {
        return m19177d();
    }

    public IGlobalCashierPayBtnViewHolder payBtnView() {
        return m19178e();
    }

    public void bindPresenter(IPresenter<? extends IView> iPresenter) {
        Intrinsics.checkNotNullParameter(iPresenter, "presenter");
        super.bindPresenter(iPresenter);
        this.f23367d.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                GlobalCashierMainView.m19174a(GlobalCashierMainView.this, nestedScrollView, i, i2, i3, i4);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m19174a(GlobalCashierMainView globalCashierMainView, NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(globalCashierMainView, "this$0");
        globalCashierMainView.m19175b().updateElevation(i2);
    }

    public void scrollTo(int i) {
        this.f23367d.smoothScrollTo(0, 0, 1000);
    }

    public void showLogoView() {
        LayoutInflater from = LayoutInflater.from(this.f23364a);
        View view = this.f23365b;
        if (view != null) {
            from.inflate(R.layout.viewholder_global_cashier_logo, (ViewGroup) view);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public View getView() {
        return this.f23365b;
    }
}
