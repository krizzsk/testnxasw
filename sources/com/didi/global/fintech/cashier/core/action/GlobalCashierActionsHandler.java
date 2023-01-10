package com.didi.global.fintech.cashier.core.action;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.p118ui.omega.CashierOmegaUtils;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J'\u0010\u0013\u001a\u0004\u0018\u0001H\u0014\"\b\b\u0000\u0010\u0014*\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0005H\u0002¢\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\u0018R$\u0010\u0003\u001a\u0018\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/core/action/GlobalCashierActionsHandler;", "", "()V", "handlers", "", "Ljava/lang/Class;", "Lcom/didi/global/fintech/cashier/core/action/IGlobalCashierBaseActionHandler;", "handleAction", "", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "cashierParam", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "uniqueId", "", "handler", "T", "clazz", "(Ljava/lang/Class;)Lcom/didi/global/fintech/cashier/core/action/IGlobalCashierBaseActionHandler;", "onDestroy", "", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierActionsHandler.kt */
public final class GlobalCashierActionsHandler {
    public static final GlobalCashierActionsHandler INSTANCE = new GlobalCashierActionsHandler();

    /* renamed from: a */
    private static final Map<Class<? extends IGlobalCashierBaseActionHandler>, IGlobalCashierBaseActionHandler> f23283a;

    private GlobalCashierActionsHandler() {
    }

    static {
        Map<Class<? extends IGlobalCashierBaseActionHandler>, IGlobalCashierBaseActionHandler> linkedHashMap = new LinkedHashMap<>();
        f23283a = linkedHashMap;
        linkedHashMap.put(IGlobalCashierPixActionHandler.class, ServiceLoader.load(IGlobalCashierPixActionHandler.class).get());
        f23283a.put(IGlobalCashier3DSActionHandler.class, ServiceLoader.load(IGlobalCashier3DSActionHandler.class).get());
        f23283a.put(IGlobalCashier3DSV2ActionHandler.class, ServiceLoader.load(IGlobalCashier3DSV2ActionHandler.class).get());
        f23283a.put(IGlobalCashierRandomVerifyActionHandler.class, ServiceLoader.load(IGlobalCashierRandomVerifyActionHandler.class).get());
        f23283a.put(IGlobalCashierUpdateCardInfoActionHandler.class, ServiceLoader.load(IGlobalCashierUpdateCardInfoActionHandler.class).get());
        f23283a.put(IGlobalCashierPasswordActionHandler.class, ServiceLoader.load(IGlobalCashierPasswordActionHandler.class).get());
        f23283a.put(IGlobalCashierTopUpActionHandler.class, ServiceLoader.load(IGlobalCashierTopUpActionHandler.class).get());
        f23283a.put(IGlobalCashierSignUpActionHandler.class, ServiceLoader.load(IGlobalCashierSignUpActionHandler.class).get());
        f23283a.put(IGlobalCashierAddCardActionHandler.class, ServiceLoader.load(IGlobalCashierAddCardActionHandler.class).get());
        f23283a.put(IGlobalCashierConfirmPayActionHandler.class, ServiceLoader.load(IGlobalCashierConfirmPayActionHandler.class).get());
        f23283a.put(IGlobalCashierOpenUrlActionHandler.class, ServiceLoader.load(IGlobalCashierOpenUrlActionHandler.class).get());
        f23283a.put(IGlobalCashierCloseCashierActionHandler.class, ServiceLoader.load(IGlobalCashierCloseCashierActionHandler.class).get());
    }

    /* renamed from: a */
    private final <T extends IGlobalCashierBaseActionHandler> T m19137a(Class<T> cls) {
        T t = f23283a.get(cls);
        if (t instanceof IGlobalCashierBaseActionHandler) {
            return (IGlobalCashierBaseActionHandler) t;
        }
        return null;
    }

    public final void onDestroy() {
        for (IGlobalCashierBaseActionHandler iGlobalCashierBaseActionHandler : f23283a.values()) {
            if (iGlobalCashierBaseActionHandler != null) {
                iGlobalCashierBaseActionHandler.onDestroy();
            }
        }
    }

    public final boolean handleAction(Context context, LifecycleOwner lifecycleOwner, CashierAction cashierAction, CashierParam cashierParam, String str) {
        IGlobalCashierAddCardActionHandler iGlobalCashierAddCardActionHandler;
        IGlobalCashierTopUpActionHandler iGlobalCashierTopUpActionHandler;
        IGlobalCashierUpdateCardInfoActionHandler iGlobalCashierUpdateCardInfoActionHandler;
        IGlobalCashierOpenUrlActionHandler iGlobalCashierOpenUrlActionHandler;
        IGlobalCashierCloseCashierActionHandler iGlobalCashierCloseCashierActionHandler;
        IGlobalCashierPixActionHandler iGlobalCashierPixActionHandler;
        IGlobalCashierConfirmPayActionHandler iGlobalCashierConfirmPayActionHandler;
        IGlobalCashier3DSV2ActionHandler iGlobalCashier3DSV2ActionHandler;
        IGlobalCashierPasswordActionHandler iGlobalCashierPasswordActionHandler;
        IGlobalCashier3DSActionHandler iGlobalCashier3DSActionHandler;
        IGlobalCashierSignUpActionHandler iGlobalCashierSignUpActionHandler;
        IGlobalCashierRandomVerifyActionHandler iGlobalCashierRandomVerifyActionHandler;
        String appId;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        String str2 = null;
        Fragment fragment = lifecycleOwner instanceof Fragment ? (Fragment) lifecycleOwner : null;
        if (fragment != null && (fragment.isRemoving() || fragment.isDetached())) {
            return false;
        }
        if (cashierAction != null) {
            str2 = cashierAction.getAction();
        }
        if (str2 == null) {
            return false;
        }
        CashierOmegaUtils addParam = new CashierOmegaUtils("ibt_checkout_action_en").addParam("action", str2);
        String str3 = "";
        if (!(cashierParam == null || (appId = cashierParam.getAppId()) == null)) {
            str3 = appId;
        }
        addParam.addParam("appid", str3).send();
        switch (str2.hashCode()) {
            case -1236338706:
                if (str2.equals("add_card") && (iGlobalCashierAddCardActionHandler = (IGlobalCashierAddCardActionHandler) m19137a(IGlobalCashierAddCardActionHandler.class)) != null) {
                    return iGlobalCashierAddCardActionHandler.handle((FragmentActivity) context, cashierAction, cashierParam);
                }
                return false;
            case -868043323:
                if (str2.equals(CashierAction.ACTION_TOP_UP) && (iGlobalCashierTopUpActionHandler = (IGlobalCashierTopUpActionHandler) m19137a(IGlobalCashierTopUpActionHandler.class)) != null) {
                    return iGlobalCashierTopUpActionHandler.handle((FragmentActivity) context, cashierAction);
                }
                return false;
            case -716466041:
                if (str2.equals(CashierAction.ACTION_UPDATE_CARD_INFO) && (iGlobalCashierUpdateCardInfoActionHandler = (IGlobalCashierUpdateCardInfoActionHandler) m19137a(IGlobalCashierUpdateCardInfoActionHandler.class)) != null) {
                    return iGlobalCashierUpdateCardInfoActionHandler.handle(lifecycleOwner, cashierAction);
                }
                return false;
            case -504306182:
                if (str2.equals(CashierAction.ACTION_OPEN_URL) && (iGlobalCashierOpenUrlActionHandler = (IGlobalCashierOpenUrlActionHandler) m19137a(IGlobalCashierOpenUrlActionHandler.class)) != null) {
                    return iGlobalCashierOpenUrlActionHandler.handle(lifecycleOwner, cashierAction);
                }
                return false;
            case -194480260:
                if (str2.equals(CashierAction.ACTION_CLOSE_CASHIER) && (iGlobalCashierCloseCashierActionHandler = (IGlobalCashierCloseCashierActionHandler) m19137a(IGlobalCashierCloseCashierActionHandler.class)) != null) {
                    return iGlobalCashierCloseCashierActionHandler.handle((FragmentActivity) context, cashierAction);
                }
                return false;
            case -148840307:
                if (str2.equals(CashierAction.ACTION_PIX_CODE) && (iGlobalCashierPixActionHandler = (IGlobalCashierPixActionHandler) m19137a(IGlobalCashierPixActionHandler.class)) != null) {
                    return iGlobalCashierPixActionHandler.handle(lifecycleOwner, cashierAction, cashierParam, str);
                }
                return false;
            case 344745641:
                if (str2.equals(CashierAction.ACTION_CONFIRM_PAY) && (iGlobalCashierConfirmPayActionHandler = (IGlobalCashierConfirmPayActionHandler) m19137a(IGlobalCashierConfirmPayActionHandler.class)) != null) {
                    return iGlobalCashierConfirmPayActionHandler.handle(lifecycleOwner, cashierAction, cashierParam, str);
                }
                return false;
            case 1047511627:
                if (str2.equals(CashierAction.ACTION_THREE_DS_V2) && (iGlobalCashier3DSV2ActionHandler = (IGlobalCashier3DSV2ActionHandler) m19137a(IGlobalCashier3DSV2ActionHandler.class)) != null) {
                    return iGlobalCashier3DSV2ActionHandler.handle(lifecycleOwner, cashierAction, cashierParam, str);
                }
                return false;
            case 1216985755:
                if (str2.equals(CashierAction.ACTION_PASSWORD) && (iGlobalCashierPasswordActionHandler = (IGlobalCashierPasswordActionHandler) m19137a(IGlobalCashierPasswordActionHandler.class)) != null) {
                    return iGlobalCashierPasswordActionHandler.handle(lifecycleOwner, cashierAction, cashierParam);
                }
                return false;
            case 1473740496:
                if (str2.equals(CashierAction.ACTION_THREE_DS) && (iGlobalCashier3DSActionHandler = (IGlobalCashier3DSActionHandler) m19137a(IGlobalCashier3DSActionHandler.class)) != null) {
                    return iGlobalCashier3DSActionHandler.handle(lifecycleOwner, cashierAction);
                }
                return false;
            case 2088263773:
                if (str2.equals("sign_up") && (iGlobalCashierSignUpActionHandler = (IGlobalCashierSignUpActionHandler) m19137a(IGlobalCashierSignUpActionHandler.class)) != null) {
                    return iGlobalCashierSignUpActionHandler.handle((FragmentActivity) context, cashierAction);
                }
                return false;
            case 2092584821:
                if (str2.equals(CashierAction.ACTION_RANDOM_VERIFY) && (iGlobalCashierRandomVerifyActionHandler = (IGlobalCashierRandomVerifyActionHandler) m19137a(IGlobalCashierRandomVerifyActionHandler.class)) != null) {
                    return iGlobalCashierRandomVerifyActionHandler.handle(lifecycleOwner, cashierAction, cashierParam);
                }
                return false;
            default:
                return false;
        }
    }
}
