package com.didi.global.fintech.cashier.core.presenter;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.didi.global.fintech.cashier.core.contract.IGlobalBinderCashierPresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionInterceptCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBaseViewBinder;
import com.didi.global.fintech.cashier.p118ui.IGlobalCashierBaseViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B7\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u001e\u0010\u0014\u001a\u00020\u00152\u0014\u0010\u0016\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0011\u0012\u0004\u0012\u00028\u00000\u0010H\u0016J*\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\u0018\b\u0001\u0010\u0018\u0018\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00020\u0011\u0012\u0004\u0012\u00028\u00000\u0010H\b¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0016R(\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\b\u0001\u0012\u00020\u0011\u0012\u0004\u0012\u00028\u00000\u00100\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierBinderPresenter;", "D", "Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierBizPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalBinderCashierPresenter;", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "uniqueId", "", "fromType", "actionInterceptCallback", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionInterceptCallback;", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;Ljava/lang/String;Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionInterceptCallback;)V", "viewBinders", "", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseViewBinder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "getViewBinders", "()Ljava/util/List;", "addViewBinder", "", "binder", "getViewBinder", "T", "()Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseViewBinder;", "onBackPressed", "", "type", "unBind", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierBinderPresenter.kt */
public abstract class GlobalCashierBinderPresenter<D> extends GlobalCashierBizPresenter implements IGlobalBinderCashierPresenter<D> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final List<IGlobalCashierBaseViewBinder<? extends IGlobalCashierBaseViewHolder, D>> f23302a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobalCashierBinderPresenter(Context context, LifecycleOwner lifecycleOwner, String str, String str2, IGlobalCashierActionInterceptCallback iGlobalCashierActionInterceptCallback, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, lifecycleOwner, str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : iGlobalCashierActionInterceptCallback);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierBinderPresenter(Context context, LifecycleOwner lifecycleOwner, String str, String str2, IGlobalCashierActionInterceptCallback iGlobalCashierActionInterceptCallback) {
        super(context, lifecycleOwner, str, str2, iGlobalCashierActionInterceptCallback);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.f23302a = new ArrayList();
    }

    /* access modifiers changed from: protected */
    public final List<IGlobalCashierBaseViewBinder<? extends IGlobalCashierBaseViewHolder, D>> getViewBinders() {
        return this.f23302a;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ <T extends IGlobalCashierBaseViewBinder<? extends IGlobalCashierBaseViewHolder, D>> T getViewBinder() {
        T t;
        Iterator it = this.f23302a.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            Intrinsics.reifiedOperationMarker(3, "T");
            if (((IGlobalCashierBaseViewBinder) t) instanceof IGlobalCashierBaseViewBinder) {
                break;
            }
        }
        Intrinsics.reifiedOperationMarker(2, "T");
        return (IGlobalCashierBaseViewBinder) t;
    }

    public boolean addViewBinder(IGlobalCashierBaseViewBinder<? extends IGlobalCashierBaseViewHolder, D> iGlobalCashierBaseViewBinder) {
        Intrinsics.checkNotNullParameter(iGlobalCashierBaseViewBinder, "binder");
        return this.f23302a.add(iGlobalCashierBaseViewBinder);
    }

    public void unBind() {
        super.unBind();
        this.f23302a.clear();
    }

    public void onBackPressed(String str) {
        throw new NotImplementedError("An operation is not implemented: " + "onBackPressed Not yet implemented");
    }
}
