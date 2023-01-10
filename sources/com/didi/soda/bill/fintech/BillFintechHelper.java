package com.didi.soda.bill.fintech;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.soda.customer.CustomerFragment;
import com.didi.soda.customer.app.GlobalContext;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo148868d2 = {"Lcom/didi/soda/bill/fintech/BillFintechHelper;", "", "()V", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BillFintechHelper.kt */
public final class BillFintechHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\f"}, mo148868d2 = {"Lcom/didi/soda/bill/fintech/BillFintechHelper$Companion;", "", "()V", "doPay", "", "requestCode", "", "cashierParam", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "getPayResource", "", "openSelectPayMethodPage", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: BillFintechHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getPayResource() {
            return "126";
        }

        private Companion() {
        }

        public final void openSelectPayMethodPage(int i, CashierParam cashierParam) {
            Intrinsics.checkNotNullParameter(cashierParam, "cashierParam");
            CashierFacade instance = CashierFacade.Companion.getInstance();
            CustomerFragment fragment = GlobalContext.getFragment();
            Intrinsics.checkNotNullExpressionValue(fragment, "getFragment()");
            instance.go2PayMethodSelPage((Fragment) fragment, i, cashierParam);
        }

        public final void doPay(int i, CashierParam cashierParam) {
            Intrinsics.checkNotNullParameter(cashierParam, "cashierParam");
            CashierFacade instance = CashierFacade.Companion.getInstance();
            Context context = GlobalContext.getContext();
            if (context != null) {
                instance.pay((FragmentActivity) context, cashierParam);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }
}
