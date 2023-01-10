package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.WalletHomeHolderData;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.resp.IData;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/WalletHomeEmptyHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/IHomeViewHolder;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/IData;", "itemView", "Landroid/view/View;", "listener", "Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;", "(Landroid/view/View;Lcom/didi/payment/wallet/global/wallet/contract/WalletHomeContract$V2Listener;)V", "(Landroid/view/View;)V", "lister", "tvError", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getViewType", "", "onBindViewHolder", "", "info", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeHolderData;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.WalletHomeEmptyHolder */
/* compiled from: WalletHomeEmptyHolder.kt */
public final class WalletHomeEmptyHolder extends RecyclerView.ViewHolder implements IHomeViewHolder<IData> {

    /* renamed from: a */
    private WalletHomeContract.V2Listener f35305a;

    /* renamed from: b */
    private final TextView f35306b;

    public int getViewType() {
        return 7;
    }

    public void onCreateViewHolder(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletHomeEmptyHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        this.f35306b = (TextView) view.findViewById(R.id.tv_agent_retry);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletHomeEmptyHolder(View view, WalletHomeContract.V2Listener v2Listener) {
        this(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        this.f35305a = v2Listener;
    }

    public void onBindViewHolder(WalletHomeHolderData<IData> walletHomeHolderData) {
        Intrinsics.checkNotNullParameter(walletHomeHolderData, "info");
        this.f35306b.setText(walletHomeHolderData.getTitle());
        this.f35306b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                WalletHomeEmptyHolder.m26829a(WalletHomeEmptyHolder.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26829a(WalletHomeEmptyHolder walletHomeEmptyHolder, View view) {
        Intrinsics.checkNotNullParameter(walletHomeEmptyHolder, "this$0");
        WalletHomeContract.V2Listener v2Listener = walletHomeEmptyHolder.f35305a;
        if (v2Listener != null) {
            v2Listener.onRefreshPage();
        }
    }
}
