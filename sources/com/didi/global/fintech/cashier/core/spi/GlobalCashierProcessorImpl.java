package com.didi.global.fintech.cashier.core.spi;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.api.Extend;
import com.didi.drouter.router.Request;
import com.didi.global.fintech.cashier.core.GlobalCashierMainActivity;
import com.didi.global.fintech.cashier.core.base.BaseCashierActivity;
import com.didi.global.fintech.cashier.core.utils.UniqueIdManager;
import com.didi.global.fintech.cashier.model.net.request.CanChangeNewVersionRequest;
import com.didi.global.fintech.cashier.network.CashierNetwork;
import com.didi.global.fintech.cashier.network.processor.GlobalCommonParamsProcessor;
import com.didi.global.fintech.cashier.p118ui.omega.CashierOmegaUtils;
import com.didi.global.fintech.cashier.p118ui.widget.GlobalCashierLoadingView;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.facade.CashierResultListener;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.global.fintech.cashier.user.spi.IGlobalCashierProcessor;
import com.didi.sdk.util.UiThreadHandler;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "cashier", value = {IGlobalCashierProcessor.class})
@Metadata(mo148867d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J1\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010\u0014J1\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010\u0017J\"\u0010\u0018\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\"\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006!"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/core/spi/GlobalCashierProcessorImpl;", "Lcom/didi/global/fintech/cashier/user/spi/IGlobalCashierProcessor;", "()V", "loadingView", "Lcom/didi/global/fintech/cashier/ui/widget/GlobalCashierLoadingView;", "getLoadingView", "()Lcom/didi/global/fintech/cashier/ui/widget/GlobalCashierLoadingView;", "setLoadingView", "(Lcom/didi/global/fintech/cashier/ui/widget/GlobalCashierLoadingView;)V", "dismissLoading", "", "launch", "activity", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "requestCode", "", "param", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/Integer;Lcom/didi/global/fintech/cashier/user/model/CashierParam;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Landroid/content/Intent;Ljava/lang/Integer;Lcom/didi/global/fintech/cashier/user/model/CashierParam;)V", "launchForResult", "listener", "Lcom/didi/global/fintech/cashier/user/facade/CashierResultListener;", "newVersionCheck", "callback", "Lcom/didi/global/fintech/cashier/user/spi/IGlobalCashierProcessor$Callback;", "showLoading", "context", "Landroid/content/Context;", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierProcessorImpl.kt */
public final class GlobalCashierProcessorImpl implements IGlobalCashierProcessor {

    /* renamed from: a */
    private GlobalCashierLoadingView f23351a;

    public void launchForResult(Fragment fragment, CashierParam cashierParam, CashierResultListener cashierResultListener) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(cashierParam, "param");
    }

    public final GlobalCashierLoadingView getLoadingView() {
        return this.f23351a;
    }

    public final void setLoadingView(GlobalCashierLoadingView globalCashierLoadingView) {
        this.f23351a = globalCashierLoadingView;
    }

    public void newVersionCheck(CashierParam cashierParam, IGlobalCashierProcessor.Callback callback) {
        Intrinsics.checkNotNullParameter(cashierParam, "param");
        Intrinsics.checkNotNullParameter(callback, "callback");
        CashierNetwork cashierNetwork = (CashierNetwork) CashierNetwork.Companion.getInstance(CashierFacade.Companion.getInstance().getApplication());
        CanChangeNewVersionRequest canChangeNewVersionRequest = new CanChangeNewVersionRequest((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        String outTradeId = cashierParam.getOutTradeId();
        String str = "";
        if (outTradeId == null) {
            outTradeId = str;
        }
        canChangeNewVersionRequest.setOut_trade_id(outTradeId);
        String bizContent = cashierParam.getBizContent();
        if (bizContent != null) {
            str = bizContent;
        }
        canChangeNewVersionRequest.setBiz_content(str);
        Unit unit = Unit.INSTANCE;
        cashierNetwork.canChangeNewVersion(canChangeNewVersionRequest, new GlobalCashierProcessorImpl$newVersionCheck$2(callback), new GlobalCashierProcessorImpl$newVersionCheck$3(new GlobalCommonParamsProcessor((String) null, (String) cashierParam.getExtraParams().get(CashierParam.PARAM_FROM_TYPE), 1, (DefaultConstructorMarker) null)));
    }

    public void showLoading(Context context) {
        UiThreadHandler.post(new Runnable(context) {
            public final /* synthetic */ Context f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                GlobalCashierProcessorImpl.m19160a(GlobalCashierProcessorImpl.this, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m19160a(GlobalCashierProcessorImpl globalCashierProcessorImpl, Context context) {
        FragmentManager supportFragmentManager;
        GlobalCashierLoadingView loadingView;
        Intrinsics.checkNotNullParameter(globalCashierProcessorImpl, "this$0");
        boolean z = true;
        GlobalCashierProcessorImpl globalCashierProcessorImpl2 = globalCashierProcessorImpl.getLoadingView() == null ? globalCashierProcessorImpl : null;
        if (globalCashierProcessorImpl2 != null) {
            globalCashierProcessorImpl2.setLoadingView(GlobalCashierLoadingView.Companion.newInstance$default(GlobalCashierLoadingView.Companion, false, 1, (Object) null));
        }
        GlobalCashierLoadingView loadingView2 = globalCashierProcessorImpl.getLoadingView();
        if (loadingView2 == null || !loadingView2.isVisible()) {
            z = false;
        }
        if (z) {
            globalCashierProcessorImpl = null;
        }
        if (globalCashierProcessorImpl != null) {
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
            if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null && (loadingView = globalCashierProcessorImpl.getLoadingView()) != null) {
                loadingView.setCancelable(false);
                loadingView.show(supportFragmentManager, (String) null);
            }
        }
    }

    public void dismissLoading() {
        UiThreadHandler.post(new Runnable() {
            public final void run() {
                GlobalCashierProcessorImpl.m19159a(GlobalCashierProcessorImpl.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m19159a(GlobalCashierProcessorImpl globalCashierProcessorImpl) {
        Intrinsics.checkNotNullParameter(globalCashierProcessorImpl, "this$0");
        GlobalCashierLoadingView loadingView = globalCashierProcessorImpl.getLoadingView();
        if (loadingView != null) {
            loadingView.dismissAllowingStateLoss();
        }
    }

    public void launch(Activity activity, Intent intent, Integer num, CashierParam cashierParam) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(cashierParam, "param");
        CashierOmegaUtils.Companion.setPubFromPage(activity.getComponentName().getClassName());
        if (intent == null && num == null) {
            Intent intent2 = new Intent(activity, GlobalCashierMainActivity.class);
            intent2.putExtra("args_param", cashierParam);
            intent2.putExtra(BaseCashierActivity.ARGS_UNIQUE_ID, UniqueIdManager.INSTANCE.genUniqueId());
            Unit unit = Unit.INSTANCE;
            activity.startActivity(intent2);
        } else if (intent == null && num != null) {
            Intent intent3 = new Intent(activity, GlobalCashierMainActivity.class);
            intent3.putExtra("args_param", cashierParam);
            intent3.putExtra(BaseCashierActivity.ARGS_UNIQUE_ID, UniqueIdManager.INSTANCE.genUniqueId());
            Unit unit2 = Unit.INSTANCE;
            activity.startActivityForResult(intent3, num.intValue());
        } else if (intent != null && num == null) {
            intent.putExtra("args_param", cashierParam);
            intent.putExtra(BaseCashierActivity.ARGS_UNIQUE_ID, UniqueIdManager.INSTANCE.genUniqueId());
            Unit unit3 = Unit.INSTANCE;
            activity.startActivity(intent);
        } else if (intent != null && num != null) {
            intent.putExtra("args_param", cashierParam);
            intent.putExtra(BaseCashierActivity.ARGS_UNIQUE_ID, UniqueIdManager.INSTANCE.genUniqueId());
            Unit unit4 = Unit.INSTANCE;
            activity.startActivityForResult(intent, num.intValue());
        }
    }

    public void launch(Fragment fragment, Intent intent, Integer num, CashierParam cashierParam) {
        ComponentName componentName;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(cashierParam, "param");
        CashierOmegaUtils.Companion companion = CashierOmegaUtils.Companion;
        FragmentActivity activity = fragment.getActivity();
        String str = null;
        if (!(activity == null || (componentName = activity.getComponentName()) == null)) {
            str = componentName.getClassName();
        }
        companion.setPubFromPage(str);
        if (intent == null && num == null) {
            Intent intent2 = new Intent(fragment.getContext(), GlobalCashierMainActivity.class);
            intent2.putExtra("args_param", cashierParam);
            intent2.putExtra(BaseCashierActivity.ARGS_UNIQUE_ID, UniqueIdManager.INSTANCE.genUniqueId());
            Unit unit = Unit.INSTANCE;
            fragment.startActivity(intent2);
        } else if (intent == null && num != null) {
            Intent intent3 = new Intent(fragment.getContext(), GlobalCashierMainActivity.class);
            intent3.putExtra("args_param", cashierParam);
            intent3.putExtra(BaseCashierActivity.ARGS_UNIQUE_ID, UniqueIdManager.INSTANCE.genUniqueId());
            Unit unit2 = Unit.INSTANCE;
            fragment.startActivityForResult(intent3, num.intValue());
        } else if (intent != null && num == null) {
            intent.putExtra("args_param", cashierParam);
            intent.putExtra(BaseCashierActivity.ARGS_UNIQUE_ID, UniqueIdManager.INSTANCE.genUniqueId());
            Unit unit3 = Unit.INSTANCE;
            fragment.startActivity(intent);
        } else if (intent != null && num != null) {
            intent.putExtra("args_param", cashierParam);
            intent.putExtra(BaseCashierActivity.ARGS_UNIQUE_ID, UniqueIdManager.INSTANCE.genUniqueId());
            Unit unit4 = Unit.INSTANCE;
            fragment.startActivityForResult(intent, num.intValue());
        }
    }

    public void launchForResult(Activity activity, CashierParam cashierParam, CashierResultListener cashierResultListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(cashierParam, "param");
        Request build = DRouter.build("");
        Context context = activity;
        Intent intent = new Intent(context, GlobalCashierMainActivity.class);
        intent.putExtra("args_param", cashierParam);
        intent.putExtra(BaseCashierActivity.ARGS_UNIQUE_ID, UniqueIdManager.INSTANCE.genUniqueId());
        Unit unit = Unit.INSTANCE;
        ((Request) ((Request) build.putExtra(Extend.START_ACTIVITY_VIA_INTENT, (Parcelable) intent)).putExtra(Extend.START_ACTIVITY_REQUEST_CODE, 69)).start(context, new GlobalCashierProcessorImpl$launchForResult$2(cashierResultListener));
    }
}
