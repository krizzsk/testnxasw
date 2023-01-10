package com.didi.global.fintech.cashier.core.interceptor;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.didi.global.fintech.cashier.core.action.GlobalCashierActionsHandler;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004JI\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\"\u0010\u0015\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00170\u0016\"\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/core/interceptor/CashierActionInterceptor;", "", "uniqueId", "", "(Ljava/lang/String;)V", "cashierParam", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "getCashierParam", "()Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "setCashierParam", "(Lcom/didi/global/fintech/cashier/user/model/CashierParam;)V", "getUniqueId", "()Ljava/lang/String;", "intercept", "", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "data", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "interceptCallback", "", "Lkotlin/Function0;", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;[Lkotlin/jvm/functions/Function0;)V", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CashierActionInterceptor.kt */
public final class CashierActionInterceptor {

    /* renamed from: a */
    private final String f23292a;

    /* renamed from: b */
    private CashierParam f23293b;

    public CashierActionInterceptor() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public CashierActionInterceptor(String str) {
        this.f23292a = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CashierActionInterceptor(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getUniqueId() {
        return this.f23292a;
    }

    public final CashierParam getCashierParam() {
        return this.f23293b;
    }

    public final void setCashierParam(CashierParam cashierParam) {
        this.f23293b = cashierParam;
    }

    public final void intercept(Context context, LifecycleOwner lifecycleOwner, CashierAction cashierAction, Function0<Unit>... function0Arr) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(function0Arr, "interceptCallback");
        if (GlobalCashierActionsHandler.INSTANCE.handleAction(context, lifecycleOwner, cashierAction, this.f23293b, this.f23292a)) {
            Function0 function0 = (Function0) ArraysKt.getOrNull((T[]) function0Arr, 0);
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        Function0 function02 = (Function0) ArraysKt.getOrNull((T[]) function0Arr, 1);
        if (function02 != null) {
            function02.invoke();
        }
    }
}
