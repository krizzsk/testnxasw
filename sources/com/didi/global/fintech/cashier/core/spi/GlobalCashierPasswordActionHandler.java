package com.didi.global.fintech.cashier.core.spi;

import androidx.lifecycle.LifecycleOwner;
import com.didi.global.fintech.cashier.core.action.IGlobalCashierPasswordActionHandler;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionHandleCallback;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;

@ServiceProvider(alias = "cashier_password", value = {IGlobalCashierPasswordActionHandler.class})
@Metadata(mo148867d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000fH\u0002¨\u0006\u0013"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/core/spi/GlobalCashierPasswordActionHandler;", "Lcom/didi/global/fintech/cashier/core/action/IGlobalCashierPasswordActionHandler;", "()V", "handle", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "param", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "onDestroy", "", "onPasswordFailed", "status", "", "desc", "onPasswordSuccess", "token", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierPasswordActionHandler.kt */
public final class GlobalCashierPasswordActionHandler implements IGlobalCashierPasswordActionHandler {
    public void onDestroy() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: android.content.Context} */
    /* JADX WARNING: type inference failed for: r3v6, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handle(androidx.lifecycle.LifecycleOwner r12, com.didi.global.fintech.cashier.model.net.request.CashierAction r13, com.didi.global.fintech.cashier.user.model.CashierParam r14) {
        /*
            r11 = this;
            java.lang.String r0 = "lifecycleOwner"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = r11
            com.didi.global.fintech.cashier.core.spi.GlobalCashierPasswordActionHandler r0 = (com.didi.global.fintech.cashier.core.spi.GlobalCashierPasswordActionHandler) r0
            r0 = 1
            r1 = 0
            if (r13 != 0) goto L_0x000e
        L_0x000c:
            r2 = 0
            goto L_0x0015
        L_0x000e:
            boolean r2 = r13.password()
            if (r2 != r0) goto L_0x000c
            r2 = 1
        L_0x0015:
            if (r2 == 0) goto L_0x001f
            com.didi.global.fintech.cashier.model.net.request.CashierActionData r2 = r13.getActionData()
            if (r2 == 0) goto L_0x001f
            r2 = 1
            goto L_0x0020
        L_0x001f:
            r2 = 0
        L_0x0020:
            r3 = 0
            if (r2 == 0) goto L_0x0025
            r2 = r11
            goto L_0x0026
        L_0x0025:
            r2 = r3
        L_0x0026:
            com.didi.global.fintech.cashier.core.spi.GlobalCashierPasswordActionHandler r2 = (com.didi.global.fintech.cashier.core.spi.GlobalCashierPasswordActionHandler) r2
            if (r2 != 0) goto L_0x002b
            return r1
        L_0x002b:
            if (r13 != 0) goto L_0x002f
            r13 = r3
            goto L_0x0033
        L_0x002f:
            com.didi.global.fintech.cashier.model.net.request.CashierActionData r13 = r13.getActionData()
        L_0x0033:
            java.lang.Class<com.didiglobal.pay.paysecure.OpenCertificationListener> r4 = com.didiglobal.pay.paysecure.OpenCertificationListener.class
            com.didichuxing.foundation.spi.ServiceLoader r4 = com.didichuxing.foundation.spi.ServiceLoader.load(r4)
            java.lang.String r5 = "load(OpenCertificationListener::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r5 = r4.iterator()
            boolean r5 = r5.hasNext()
            if (r5 != 0) goto L_0x004b
            return r1
        L_0x004b:
            java.util.Iterator r4 = r4.iterator()
            java.lang.Object r4 = r4.next()
            r10 = r4
            com.didiglobal.pay.paysecure.OpenCertificationListener r10 = (com.didiglobal.pay.paysecure.OpenCertificationListener) r10
            if (r13 != 0) goto L_0x005a
            goto L_0x012d
        L_0x005a:
            java.lang.Integer r4 = r13.isSet()
            if (r4 == 0) goto L_0x00a4
            java.lang.Integer r4 = r13.isSet()
            if (r4 != 0) goto L_0x0067
            goto L_0x00a4
        L_0x0067:
            int r4 = r4.intValue()
            if (r4 != r0) goto L_0x00a4
            java.lang.String r1 = r13.getPaySessionId()
            java.lang.String r4 = ""
            if (r1 == 0) goto L_0x0077
            r7 = r1
            goto L_0x0078
        L_0x0077:
            r7 = r4
        L_0x0078:
            java.lang.String r1 = r13.getScene()
            if (r1 == 0) goto L_0x0080
            r6 = r1
            goto L_0x0081
        L_0x0080:
            r6 = r4
        L_0x0081:
            if (r14 != 0) goto L_0x0084
            goto L_0x0088
        L_0x0084:
            java.lang.String r3 = r14.getNeedPayFeeTextDisplay()
        L_0x0088:
            if (r3 != 0) goto L_0x0094
            java.lang.String r13 = r13.getBrandName()
            if (r13 == 0) goto L_0x0092
            r8 = r13
            goto L_0x0095
        L_0x0092:
            r8 = r4
            goto L_0x0095
        L_0x0094:
            r8 = r3
        L_0x0095:
            com.didiglobal.pay.paysecure.PaySecure r5 = com.didiglobal.pay.paysecure.PaySecure.INSTANCE
            com.didi.global.fintech.cashier.core.spi.GlobalCashierPasswordActionHandler$handle$2$1$1 r13 = new com.didi.global.fintech.cashier.core.spi.GlobalCashierPasswordActionHandler$handle$2$1$1
            r13.<init>(r2, r12)
            r9 = r13
            com.didiglobal.pay.paysecure.PayPwdResultListener r9 = (com.didiglobal.pay.paysecure.PayPwdResultListener) r9
            r5.verifyPayPassword(r6, r7, r8, r9, r10)
            goto L_0x012d
        L_0x00a4:
            java.lang.Integer r14 = r13.isSet()
            if (r14 == 0) goto L_0x012d
            java.lang.Integer r13 = r13.isSet()
            if (r13 != 0) goto L_0x00b2
            goto L_0x012d
        L_0x00b2:
            int r13 = r13.intValue()
            if (r13 != 0) goto L_0x012d
            boolean r13 = r12 instanceof com.didi.global.fintech.cashier.core.GlobalCashierMainActivity
            if (r13 == 0) goto L_0x00c0
            r13 = r12
            com.didi.global.fintech.cashier.core.GlobalCashierMainActivity r13 = (com.didi.global.fintech.cashier.core.GlobalCashierMainActivity) r13
            goto L_0x00c1
        L_0x00c0:
            r13 = r3
        L_0x00c1:
            if (r13 != 0) goto L_0x00c4
            goto L_0x00ce
        L_0x00c4:
            com.didi.global.fintech.cashier.core.contract.IGlobalMainCashierPresenter r13 = r13.getPresenter()
            if (r13 != 0) goto L_0x00cb
            goto L_0x00ce
        L_0x00cb:
            r13.omegaPasswordPopupSw()
        L_0x00ce:
            boolean r13 = r12 instanceof androidx.fragment.app.FragmentActivity
            if (r13 == 0) goto L_0x00d6
            r13 = r12
            androidx.fragment.app.FragmentActivity r13 = (androidx.fragment.app.FragmentActivity) r13
            goto L_0x00d7
        L_0x00d6:
            r13 = r3
        L_0x00d7:
            if (r13 != 0) goto L_0x00ea
            boolean r13 = r12 instanceof androidx.fragment.app.Fragment
            if (r13 == 0) goto L_0x00e1
            r13 = r12
            androidx.fragment.app.Fragment r13 = (androidx.fragment.app.Fragment) r13
            goto L_0x00e2
        L_0x00e1:
            r13 = r3
        L_0x00e2:
            if (r13 != 0) goto L_0x00e5
            goto L_0x00ed
        L_0x00e5:
            android.content.Context r3 = r13.getContext()
            goto L_0x00ed
        L_0x00ea:
            r3 = r13
            android.content.Context r3 = (android.content.Context) r3
        L_0x00ed:
            if (r3 != 0) goto L_0x00f0
            return r1
        L_0x00f0:
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogFactory r13 = com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierDialogFactory.INSTANCE
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogFactory$TYPE r14 = com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierDialogFactory.TYPE.BOTTOM
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogCommonConfig$Companion r4 = com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierDialogCommonConfig.Companion
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogCommonConfig$Companion r5 = com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierDialogCommonConfig.Companion
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogCommonConfig r5 = r5.getPASSWORD_GUIDE()
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogCommonConfig r4 = r4.newIns(r5)
            com.didi.global.fintech.cashier.user.facade.CashierFacade$Companion r5 = com.didi.global.fintech.cashier.user.facade.CashierFacade.Companion
            com.didi.global.fintech.cashier.user.facade.CashierFacade r5 = r5.getInstance()
            com.didi.global.fintech.cashier.user.theme.ThemeType r5 = r5.getTheme()
            boolean r5 = r5.latour()
            r4.setHorizontal(r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogBaseConfig r4 = (com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierDialogBaseConfig) r4
            r5 = 2
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogCallback[] r5 = new com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierDialogCallback[r5]
            com.didi.global.fintech.cashier.core.spi.GlobalCashierPasswordActionHandler$handle$2$1$3 r6 = new com.didi.global.fintech.cashier.core.spi.GlobalCashierPasswordActionHandler$handle$2$1$3
            r6.<init>(r12, r10, r2)
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogCallback r6 = (com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierDialogCallback) r6
            r5[r1] = r6
            com.didi.global.fintech.cashier.core.spi.GlobalCashierPasswordActionHandler$handle$2$1$4 r12 = new com.didi.global.fintech.cashier.core.spi.GlobalCashierPasswordActionHandler$handle$2$1$4
            r12.<init>()
            com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDialogCallback r12 = (com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierDialogCallback) r12
            r5[r0] = r12
            r13.showDialog(r3, r14, r4, r5)
        L_0x012d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.spi.GlobalCashierPasswordActionHandler.handle(androidx.lifecycle.LifecycleOwner, com.didi.global.fintech.cashier.model.net.request.CashierAction, com.didi.global.fintech.cashier.user.model.CashierParam):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m19157a(LifecycleOwner lifecycleOwner, String str) {
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = lifecycleOwner instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) lifecycleOwner : null;
        if (iGlobalCashierActionHandleCallback != null) {
            iGlobalCashierActionHandleCallback.onPasswordSuccess(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m19158a(LifecycleOwner lifecycleOwner, String str, String str2) {
        IGlobalCashierActionHandleCallback iGlobalCashierActionHandleCallback = lifecycleOwner instanceof IGlobalCashierActionHandleCallback ? (IGlobalCashierActionHandleCallback) lifecycleOwner : null;
        if (iGlobalCashierActionHandleCallback != null) {
            if (str2 == null) {
                str2 = "";
            }
            iGlobalCashierActionHandleCallback.onPasswordFailed(str, str2);
        }
    }
}
