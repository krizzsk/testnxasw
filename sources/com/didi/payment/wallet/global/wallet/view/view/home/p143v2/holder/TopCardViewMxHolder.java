package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.WalletHomeHolderData;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.Data;
import com.taxis99.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\u001c\u001a\u00020\u000fH\u0016J\u0016\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0016J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$H\u0016R\u001b\u0010\b\u001a\u00020\t8FX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u0019\u0010\u001a¨\u0006%"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/TopCardViewMxHolder;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/TopCardVH;", "itemView", "Landroid/view/View;", "lister", "Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;", "(Landroid/view/View;Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;)V", "(Landroid/view/View;)V", "layerPix", "", "getLayerPix", "()F", "layerPix$delegate", "Lkotlin/Lazy;", "middle", "", "getMiddle", "()I", "middle$delegate", "rvTopCard", "Landroidx/recyclerview/widget/RecyclerView;", "snap", "Landroidx/recyclerview/widget/LinearSnapHelper;", "topCardViewHolder", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/TopCardViewMxItemHolder;", "getTopCardViewHolder", "()Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/TopCardViewMxItemHolder;", "topCardViewHolder$delegate", "getViewType", "onBindViewHolder", "", "info", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeHolderData;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/Data;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewMxHolder */
/* compiled from: TopCardViewMxHolder.kt */
public final class TopCardViewMxHolder extends TopCardVH {

    /* renamed from: a */
    private final Lazy f35283a;

    /* renamed from: b */
    private final Lazy f35284b;

    /* renamed from: c */
    private final Lazy f35285c;

    /* renamed from: d */
    private final LinearSnapHelper f35286d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final RecyclerView f35287e;

    public int getViewType() {
        return 9;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopCardViewMxHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        this.f35283a = LazyKt.lazy(TopCardViewMxHolder$middle$2.INSTANCE);
        this.f35284b = LazyKt.lazy(TopCardViewMxHolder$layerPix$2.INSTANCE);
        this.f35285c = LazyKt.lazy(new TopCardViewMxHolder$topCardViewHolder$2(this));
        this.f35286d = new LinearSnapHelper();
        View findViewById = view.findViewById(R.id.rv_topCardViewMx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.rv_topCardViewMx)");
        this.f35287e = (RecyclerView) findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TopCardViewMxHolder(View view, WalletHomeContract.V2Listener v2Listener) {
        this(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        setLister(v2Listener);
    }

    public final int getMiddle() {
        return ((Number) this.f35283a.getValue()).intValue();
    }

    public final float getLayerPix() {
        return ((Number) this.f35284b.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final TopCardViewMxItemHolder m26816a() {
        return (TopCardViewMxItemHolder) this.f35285c.getValue();
    }

    public void onCreateViewHolder(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        this.f35287e.setVisibility(0);
    }

    public void onBindViewHolder(WalletHomeHolderData<Data> walletHomeHolderData) {
        Intrinsics.checkNotNullParameter(walletHomeHolderData, "info");
        this.f35287e.setAdapter(m26816a());
        this.f35286d.attachToRecyclerView(this.f35287e);
        this.f35287e.addOnScrollListener(new TopCardViewMxHolder$onBindViewHolder$1(this));
        m26816a().addLayerOnClick(new TopCardViewMxHolder$onBindViewHolder$2(this));
        m26816a().update(walletHomeHolderData.getContentObj());
    }
}
