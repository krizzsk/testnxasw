package com.didi.global.fintech.cashier.threeds.spi;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.adyen.checkout.components.ActionComponentData;
import com.adyen.checkout.components.ComponentError;
import com.adyen.checkout.core.exception.CheckoutException;
import com.didi.global.fintech.cashier.core.action.IGlobalCashier3DSActionHandler;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionHandleCallback;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.response.GlobalCashierAdyen3DSModel;
import com.didi.global.fintech.cashier.threeds.ThreeDSDataParser;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.taxis99.R;
import global.didi.pay.threeds.contract.IAdyen3DS;
import global.didi.pay.threeds.method.adyen.IAdyen3DSListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "cashier", value = {IGlobalCashier3DSActionHandler.class})
@Metadata(mo148867d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/threeds/spi/GlobalCashier3DSActionHandler;", "Lcom/didi/global/fintech/cashier/core/action/IGlobalCashier3DSActionHandler;", "Lglobal/didi/pay/threeds/method/adyen/IAdyen3DSListener;", "()V", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "mAction", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "mAdyen3DS", "Lglobal/didi/pay/threeds/contract/IAdyen3DS;", "handle", "", "action", "onCancel", "", "onDestroy", "onFailure", "error", "Lcom/adyen/checkout/components/ComponentError;", "onSuccess", "data", "Lcom/adyen/checkout/components/ActionComponentData;", "cashier_threeds_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashier3DSActionHandler.kt */
public final class GlobalCashier3DSActionHandler implements IGlobalCashier3DSActionHandler, IAdyen3DSListener {

    /* renamed from: a */
    private LifecycleOwner f23582a;

    /* renamed from: b */
    private IAdyen3DS f23583b;

    /* renamed from: c */
    private CashierAction f23584c;

    /* JADX WARNING: Removed duplicated region for block: B:35:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a5 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handle(androidx.lifecycle.LifecycleOwner r10, com.didi.global.fintech.cashier.model.net.request.CashierAction r11) {
        /*
            r9 = this;
            java.lang.String r0 = "lifecycleOwner"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r9.f23582a = r10
            boolean r0 = r10 instanceof androidx.fragment.app.FragmentActivity
            r1 = 0
            if (r0 == 0) goto L_0x0010
            r0 = r10
            androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            r2 = 0
            if (r0 != 0) goto L_0x0028
            boolean r0 = r10 instanceof androidx.fragment.app.Fragment
            if (r0 == 0) goto L_0x001b
            androidx.fragment.app.Fragment r10 = (androidx.fragment.app.Fragment) r10
            goto L_0x001c
        L_0x001b:
            r10 = r1
        L_0x001c:
            if (r10 != 0) goto L_0x0020
            r0 = r1
            goto L_0x0025
        L_0x0020:
            androidx.fragment.app.FragmentActivity r10 = r10.getActivity()
            r0 = r10
        L_0x0025:
            if (r0 != 0) goto L_0x0028
            return r2
        L_0x0028:
            r10 = r9
            com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSActionHandler r10 = (com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSActionHandler) r10
            r10 = 1
            if (r11 != 0) goto L_0x0030
        L_0x002e:
            r3 = 0
            goto L_0x0037
        L_0x0030:
            boolean r3 = r11.threeDS()
            if (r3 != 0) goto L_0x002e
            r3 = 1
        L_0x0037:
            if (r3 != 0) goto L_0x0057
            if (r11 != 0) goto L_0x003d
        L_0x003b:
            r3 = 0
            goto L_0x0052
        L_0x003d:
            com.didi.global.fintech.cashier.model.net.request.CashierActionData r3 = r11.getActionData()
            if (r3 != 0) goto L_0x0044
            goto L_0x003b
        L_0x0044:
            java.util.Map r3 = r3.getAction()
            if (r3 != 0) goto L_0x004b
            goto L_0x003b
        L_0x004b:
            boolean r3 = r3.isEmpty()
            if (r3 != r10) goto L_0x003b
            r3 = 1
        L_0x0052:
            if (r3 == 0) goto L_0x0055
            goto L_0x0057
        L_0x0055:
            r3 = 0
            goto L_0x0058
        L_0x0057:
            r3 = 1
        L_0x0058:
            if (r3 == 0) goto L_0x005c
            r3 = r9
            goto L_0x005d
        L_0x005c:
            r3 = r1
        L_0x005d:
            com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSActionHandler r3 = (com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSActionHandler) r3
            if (r3 != 0) goto L_0x00a5
            r9.f23584c = r11
            global.didi.pay.threeds.contract.IAdyen3DS r2 = r9.f23583b
            if (r2 != 0) goto L_0x0076
            global.didi.pay.threeds.contract.IAdyen3DS r0 = global.didi.pay.threeds.ThreeDSFactory.getAdyen3DS(r0)
            r9.f23583b = r0
            if (r0 != 0) goto L_0x0070
            goto L_0x0076
        L_0x0070:
            r2 = r9
            global.didi.pay.threeds.method.adyen.IAdyen3DSListener r2 = (global.didi.pay.threeds.method.adyen.IAdyen3DSListener) r2
            r0.registerListener(r2)
        L_0x0076:
            global.didi.pay.threeds.contract.IAdyen3DS r0 = r9.f23583b
            java.lang.String r2 = "handle: "
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r0)
            r3 = 4
            r6 = 0
            r8 = 39
            java.lang.String r4 = "Arirus"
            java.lang.String r7 = "com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSActionHandler"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
            global.didi.pay.threeds.contract.IAdyen3DS r0 = r9.f23583b
            if (r0 != 0) goto L_0x008e
            goto L_0x00a4
        L_0x008e:
            org.json.JSONObject r2 = new org.json.JSONObject
            if (r11 != 0) goto L_0x0093
            goto L_0x009e
        L_0x0093:
            com.didi.global.fintech.cashier.model.net.request.CashierActionData r11 = r11.getActionData()
            if (r11 != 0) goto L_0x009a
            goto L_0x009e
        L_0x009a:
            java.util.Map r1 = r11.getAction()
        L_0x009e:
            r2.<init>(r1)
            r0.handleAction((org.json.JSONObject) r2)
        L_0x00a4:
            return r10
        L_0x00a5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSActionHandler.handle(androidx.lifecycle.LifecycleOwner, com.didi.global.fintech.cashier.model.net.request.CashierAction):boolean");
    }

    public void onDestroy() {
        this.f23584c = null;
        IAdyen3DS iAdyen3DS = this.f23583b;
        if (iAdyen3DS != null) {
            iAdyen3DS.unregisterListener();
        }
        this.f23583b = null;
    }

    public void onSuccess(ActionComponentData actionComponentData) {
        SystemUtils.log(4, "Arirus", Intrinsics.stringPlus("onSuccess: ", actionComponentData), (Throwable) null, "com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSActionHandler", 51);
        LifecycleOwner lifecycleOwner = this.f23582a;
        GlobalCashierAdyen3DSModel globalCashierAdyen3DSModel = null;
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = lifecycleOwner instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) lifecycleOwner : null;
        if (iGlobalCashierActionHandleCallback != null) {
            CashierAction cashierAction = this.f23584c;
            if (cashierAction != null) {
                globalCashierAdyen3DSModel = cashierAction.threeDSData();
            }
            iGlobalCashierActionHandleCallback.onAdyenThreeDSSuccess(ThreeDSDataParser.ActionComponentDataToAdyen3DSModel(actionComponentData, globalCashierAdyen3DSModel));
        }
    }

    public void onFailure(ComponentError componentError) {
        String str;
        CheckoutException exception;
        new RuntimeException().printStackTrace();
        if (!(componentError == null || (exception = componentError.getException()) == null)) {
            exception.printStackTrace();
        }
        String str2 = null;
        if (componentError == null) {
            str = null;
        } else {
            str = componentError.getErrorMessage();
        }
        SystemUtils.log(4, "Arirus", Intrinsics.stringPlus("onFailure: ", str), (Throwable) null, "com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSActionHandler", 61);
        LifecycleOwner lifecycleOwner = this.f23582a;
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = lifecycleOwner instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) lifecycleOwner : null;
        if (iGlobalCashierActionHandleCallback != null) {
            if (componentError != null) {
                str2 = componentError.getErrorMessage();
            }
            iGlobalCashierActionHandleCallback.onThreeDSFailed(str2, CashierAction.ACTION_THREE_DS);
        }
    }

    public void onCancel() {
        Context context;
        LifecycleOwner lifecycleOwner = this.f23582a;
        String str = null;
        FragmentActivity fragmentActivity = lifecycleOwner instanceof FragmentActivity ? (FragmentActivity) lifecycleOwner : null;
        if (fragmentActivity == null) {
            LifecycleOwner lifecycleOwner2 = this.f23582a;
            Fragment fragment = lifecycleOwner2 instanceof Fragment ? (Fragment) lifecycleOwner2 : null;
            context = fragment == null ? null : fragment.getContext();
        } else {
            context = fragmentActivity;
        }
        LifecycleOwner lifecycleOwner3 = this.f23582a;
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = lifecycleOwner3 instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) lifecycleOwner3 : null;
        if (iGlobalCashierActionHandleCallback != null) {
            if (context != null) {
                str = context.getString(R.string.threeds_fail_message);
            }
            iGlobalCashierActionHandleCallback.onThreeDSCancel(str, CashierAction.ACTION_THREE_DS);
        }
    }
}
