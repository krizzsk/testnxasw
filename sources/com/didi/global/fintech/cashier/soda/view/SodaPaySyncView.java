package com.didi.global.fintech.cashier.soda.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.global.fintech.cashier.core.view.GlobalCashierBaseView;
import com.didi.global.fintech.cashier.soda.contract.ISodaPaySyncView;
import com.didi.global.fintech.cashier.soda.presenter.SodaPaySyncPresenter;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/view/SodaPaySyncView;", "Lcom/didi/global/fintech/cashier/core/view/GlobalCashierBaseView;", "Lcom/didi/global/fintech/cashier/soda/presenter/SodaPaySyncPresenter;", "Lcom/didi/global/fintech/cashier/soda/contract/ISodaPaySyncView;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "mRootView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "view", "getView", "()Landroid/view/View;", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SodaPaySyncView.kt */
public final class SodaPaySyncView extends GlobalCashierBaseView<SodaPaySyncPresenter> implements ISodaPaySyncView {

    /* renamed from: a */
    private final Context f23555a;

    /* renamed from: b */
    private final View f23556b;

    public SodaPaySyncView(Context context, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        this.f23555a = context;
        this.f23556b = LayoutInflater.from(context).inflate(R.layout.view_soda_pay_sync, viewGroup);
    }

    public View getView() {
        return this.f23556b;
    }
}
