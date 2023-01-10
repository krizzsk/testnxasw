package com.didi.global.fintech.cashier.fastpay.presenter;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionHandleCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierNetPresenter;
import com.didi.global.fintech.cashier.fastpay.api.IFastPayBaseProcessor;
import com.didi.global.fintech.cashier.fastpay.api.IFastPayDialogProcessor;
import com.didi.global.fintech.cashier.fastpay.api.IFastPayOperateProcessor;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayBasePresenter;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayBaseViewBinder;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayNetPresenter;
import com.didi.global.fintech.cashier.model.CashierError;
import com.didi.global.fintech.cashier.model.net.request.PrepayRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPayInfoRequest;
import com.didi.global.fintech.cashier.model.net.response.GlobalCashierAdyen3DSModel;
import com.didi.global.fintech.cashier.p118ui.IGlobalCashierBaseViewHolder;
import com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierDialogCallback;
import com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierDialogCommonConfig;
import com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierDialogFactory;
import com.didi.global.fintech.cashier.p118ui.widget.GlobalCashierLoadingView;
import com.didi.global.fintech.cashier.user.model.FastPayParam;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.sdk.util.UiThreadHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006B\u0015\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u0014\u001a\u00020\u00152\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\b\u0001\u0010\u001b\u001a\u00020\u001cH\u0016J*\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\u0018\b\u0001\u0010\u001e\u0018\u0001*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010H\b¢\u0006\u0002\u0010\u001fJ\u0018\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\u0018\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\u0018H\u0016J\u0012\u0010.\u001a\u00020\u00182\b\u0010/\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u00100\u001a\u00020\u00182\b\u0010/\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u001cH\u0016J\u001a\u00103\u001a\u00020\u00182\u0006\u0010+\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u001aH\u0016J\u0018\u00106\u001a\u00020\u00182\u0006\u00107\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u001aH\u0016J\u0010\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\u001aH\u0016J\b\u0010;\u001a\u00020\u0018H\u0016J\u001a\u0010<\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010\u001a2\u0006\u0010=\u001a\u00020\u001aH\u0016J\u001a\u0010>\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010\u001a2\u0006\u0010=\u001a\u00020\u001aH\u0016J\b\u0010?\u001a\u00020\u0018H\u0016J\u0018\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020\u0015H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R(\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00020\u00110\u00100\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006C"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/fastpay/presenter/FastPayBasePresenter;", "D", "Lcom/didi/global/fintech/cashier/fastpay/presenter/FastPayCorePresenter;", "Lcom/didi/global/fintech/cashier/fastpay/api/IFastPayOperateProcessor;", "Lcom/didi/global/fintech/cashier/fastpay/api/IFastPayDialogProcessor;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionHandleCallback;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayBasePresenter;", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;)V", "loadingView", "Lcom/didi/global/fintech/cashier/ui/widget/GlobalCashierLoadingView;", "viewBinders", "", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayBaseViewBinder;", "Lcom/didi/global/fintech/cashier/ui/IGlobalCashierBaseViewHolder;", "getViewBinders", "()Ljava/util/List;", "addViewBinder", "", "binder", "dismissLoading", "", "getString", "", "id", "", "getViewBinder", "T", "()Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayBaseViewBinder;", "loading", "cancelable", "duration", "", "netError", "error", "Lcom/didi/global/fintech/cashier/model/CashierError;", "api", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierNetPresenter$API;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayNetPresenter$API;", "onAdyenThreeDSSuccess", "data", "Lcom/didi/global/fintech/cashier/model/net/response/GlobalCashierAdyen3DSModel;", "onBind", "onCardBind", "cardIndex", "onCardVerify", "onCashierClose", "payResult", "onCybsThreeDSSuccess", "Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2;", "cvv", "onPasswordFailed", "status", "desc", "onPasswordSuccess", "token", "onPixPaid", "onThreeDSCancel", "type", "onThreeDSFailed", "onTopUp", "toast", "message", "success", "cashier_fastpay_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FastPayBasePresenter.kt */
public abstract class FastPayBasePresenter<D> extends FastPayCorePresenter implements IGlobalCashierActionHandleCallback, IFastPayDialogProcessor, IFastPayOperateProcessor, IFastPayBasePresenter<D> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final List<IFastPayBaseViewBinder<D, ? extends IGlobalCashierBaseViewHolder>> f23430a = new ArrayList();

    /* renamed from: b */
    private final GlobalCashierLoadingView f23431b = GlobalCashierLoadingView.Companion.newInstance(false);

    public void onPasswordFailed(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "status");
        Intrinsics.checkNotNullParameter(str2, "desc");
    }

    public void onPasswordSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastPayBasePresenter(Context context, LifecycleOwner lifecycleOwner) {
        super(context, lifecycleOwner);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
    }

    /* access modifiers changed from: protected */
    public final List<IFastPayBaseViewBinder<D, ? extends IGlobalCashierBaseViewHolder>> getViewBinders() {
        return this.f23430a;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ <T extends IFastPayBaseViewBinder<D, ? extends IGlobalCashierBaseViewHolder>> T getViewBinder() {
        T t;
        Iterator it = this.f23430a.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            Intrinsics.reifiedOperationMarker(3, "T");
            if (((IFastPayBaseViewBinder) t) instanceof IFastPayBaseViewBinder) {
                break;
            }
        }
        Intrinsics.reifiedOperationMarker(2, "T");
        return (IFastPayBaseViewBinder) t;
    }

    public boolean addViewBinder(IFastPayBaseViewBinder<D, ? extends IGlobalCashierBaseViewHolder> iFastPayBaseViewBinder) {
        Intrinsics.checkNotNullParameter(iFastPayBaseViewBinder, "binder");
        return this.f23430a.add(iFastPayBaseViewBinder);
    }

    public void onBind() {
        super.onBind();
        IFastPayBaseProcessor iFastPayBaseProcessor = this;
        registerProcessor(iFastPayBaseProcessor, IFastPayOperateProcessor.class);
        registerProcessor(iFastPayBaseProcessor, IFastPayDialogProcessor.class);
    }

    public void loading(boolean z, long j) {
        UiThreadHandler.post(new Runnable(z, j) {
            public final /* synthetic */ boolean f$1;
            public final /* synthetic */ long f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                FastPayBasePresenter.m19194a(FastPayBasePresenter.this, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m19194a(FastPayBasePresenter fastPayBasePresenter, boolean z, long j) {
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(fastPayBasePresenter, "this$0");
        if (fastPayBasePresenter.f23431b.isVisible()) {
            fastPayBasePresenter = null;
        }
        if (fastPayBasePresenter != null) {
            Context context = fastPayBasePresenter.getContext();
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
            if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null) {
                GlobalCashierLoadingView globalCashierLoadingView = fastPayBasePresenter.f23431b;
                globalCashierLoadingView.setCancelable(z);
                GlobalCashierLoadingView globalCashierLoadingView2 = (j > 0 ? 1 : (j == 0 ? 0 : -1)) == 0 ? globalCashierLoadingView : null;
                if (globalCashierLoadingView2 == null) {
                    globalCashierLoadingView2 = null;
                } else {
                    globalCashierLoadingView2.show(supportFragmentManager, (String) null);
                }
                if (globalCashierLoadingView2 == null) {
                    globalCashierLoadingView.showDuration(j, supportFragmentManager, (String) null);
                }
            }
        }
    }

    public void dismissLoading() {
        this.f23431b.dismissAllowingStateLoss();
    }

    public String getString(int i) {
        String string = getContext().getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(id)");
        return string;
    }

    public void toast(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "message");
        FastPayBasePresenter fastPayBasePresenter = this;
        Unit unit = null;
        if ((z ? this : null) != null) {
            WalletToastNew.showSuccessMsg(getContext(), str);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            WalletToastNew.showFailedMsg(fastPayBasePresenter.getContext(), str);
        }
    }

    public void netError(CashierError cashierError, IGlobalCashierNetPresenter.API api) {
        Intrinsics.checkNotNullParameter(cashierError, "error");
        Intrinsics.checkNotNullParameter(api, "api");
        GlobalCashierDialogFactory.INSTANCE.showDialog(getContext(), GlobalCashierDialogFactory.TYPE.CENTER, GlobalCashierDialogCommonConfig.Companion.newIns(GlobalCashierDialogCommonConfig.Companion.getNET_ERROR()), new GlobalCashierDialogCallback[0]);
    }

    public void netError(CashierError cashierError, IFastPayNetPresenter.API api) {
        Intrinsics.checkNotNullParameter(cashierError, "error");
        Intrinsics.checkNotNullParameter(api, "api");
        GlobalCashierDialogFactory.INSTANCE.showDialog(getContext(), GlobalCashierDialogFactory.TYPE.CENTER, GlobalCashierDialogCommonConfig.Companion.newIns(GlobalCashierDialogCommonConfig.Companion.getNET_ERROR()), new GlobalCashierDialogCallback[0]);
    }

    public void onCardBind(String str) {
        String str2 = null;
        FastPayInfoRequest fastPayInfoRequest = new FastPayInfoRequest((String) null, 1, (DefaultConstructorMarker) null);
        FastPayParam fastPayParam = getFastPayParam();
        if (fastPayParam != null) {
            str2 = fastPayParam.getProductId();
        }
        fastPayInfoRequest.setProduct_id(str2);
        Unit unit = Unit.INSTANCE;
        requestFastPayOrder(fastPayInfoRequest);
    }

    public void onCardVerify(String str) {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void onTopUp() {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void onPixPaid() {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void onAdyenThreeDSSuccess(GlobalCashierAdyen3DSModel globalCashierAdyen3DSModel) {
        Intrinsics.checkNotNullParameter(globalCashierAdyen3DSModel, "data");
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void onCybsThreeDSSuccess(PrepayRequest.ThreeDSV2 threeDSV2, String str) {
        Intrinsics.checkNotNullParameter(threeDSV2, "data");
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void onThreeDSFailed(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "type");
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void onThreeDSCancel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "type");
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void onCashierClose(int i) {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }
}
