package com.didi.global.fintech.cashier.soda.presenter;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.didi.global.fintech.cashier.core.api.ICashierDialogProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierSyncStatusProcessor;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionHandleCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionInterceptCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierRandomVerifyActionCallBack;
import com.didi.global.fintech.cashier.core.presenter.GlobalCashierBizPresenter;
import com.didi.global.fintech.cashier.core.utils.CashierLog;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.request.GetPayStatusRequest;
import com.didi.global.fintech.cashier.model.net.request.PrepayRequest;
import com.didi.global.fintech.cashier.model.net.response.GlobalCashierAdyen3DSModel;
import com.didi.global.fintech.cashier.p118ui.omega.CashierOmegaUtils;
import com.didi.global.fintech.cashier.soda.contract.ISodaPaySyncPresenter;
import com.didi.global.fintech.cashier.soda.contract.ISodaSyncUICallback;
import com.didi.global.fintech.cashier.soda.processor.SodaPayWaitTimeOutProcessor;
import com.didi.global.fintech.cashier.soda.processor.SodaSyncApiErrProcessor;
import com.didi.global.fintech.cashier.soda.processor.SodaSyncLoadingProcessor;
import com.didi.global.fintech.cashier.soda.processor.SodaSyncStatusProcessor;
import com.didi.global.fintech.cashier.soda.utils.DataTransformer;
import com.didi.global.fintech.cashier.user.facade.SodaPayResult;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.global.fintech.cashier.user.model.GPayMethodItem;
import com.didi.soda.customer.foundation.rpc.ParamsHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B/\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010\nJ\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0019H\u0016J\u0012\u0010&\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010(\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u0019H\u0002J\u001a\u0010-\u001a\u00020\u00192\u0006\u0010#\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\nH\u0016J\u0010\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020\nH\u0016J\b\u00105\u001a\u00020\u0019H\u0016J\u001a\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u00020+2\b\u00108\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u00109\u001a\u00020\u00192\b\u0010:\u001a\u0004\u0018\u00010\n2\u0006\u0010;\u001a\u00020\nH\u0016J\u001a\u0010<\u001a\u00020\u00192\b\u0010:\u001a\u0004\u0018\u00010\n2\u0006\u0010;\u001a\u00020\nH\u0016J\b\u0010=\u001a\u00020\u0019H\u0016J\u0010\u0010>\u001a\u00020\u00192\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020\u0019H\u0016R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/presenter/SodaPaySyncPresenter;", "Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierBizPresenter;", "Lcom/didi/global/fintech/cashier/soda/contract/ISodaPaySyncPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionHandleCallback;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierRandomVerifyActionCallBack;", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "uniqueId", "", "actionInterceptCallback", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionInterceptCallback;", "uiCallback", "Lcom/didi/global/fintech/cashier/soda/contract/ISodaSyncUICallback;", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionInterceptCallback;Lcom/didi/global/fintech/cashier/soda/contract/ISodaSyncUICallback;)V", "apiErrProcessor", "Lcom/didi/global/fintech/cashier/soda/processor/SodaSyncApiErrProcessor;", "loadingProcessor", "Lcom/didi/global/fintech/cashier/soda/processor/SodaSyncLoadingProcessor;", "payStatusProcessor", "Lcom/didi/global/fintech/cashier/soda/processor/SodaSyncStatusProcessor;", "payWaitTimeOutProcessor", "Lcom/didi/global/fintech/cashier/soda/processor/SodaPayWaitTimeOutProcessor;", "dismissLoading", "", "getPayStatus", "getPayStatusRequest", "Lcom/didi/global/fintech/cashier/model/net/request/GetPayStatusRequest;", "init", "param", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "onActionIntercept", "action", "onAdyenThreeDSSuccess", "data", "Lcom/didi/global/fintech/cashier/model/net/response/GlobalCashierAdyen3DSModel;", "onBind", "onCardBind", "cardIndex", "onCardVerify", "onCashierClose", "payResult", "", "onClose", "onCybsThreeDSSuccess", "Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2;", "cvv", "onPasswordFailed", "status", "desc", "onPasswordSuccess", "token", "onPixPaid", "onRandomVerifyResult", "code", "msg", "onThreeDSCancel", "error", "type", "onThreeDSFailed", "onTopUp", "prePay", "Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest;", "unBind", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SodaPaySyncPresenter.kt */
public final class SodaPaySyncPresenter extends GlobalCashierBizPresenter implements IGlobalCashierActionHandleCallback, IGlobalCashierRandomVerifyActionCallBack, ISodaPaySyncPresenter {

    /* renamed from: a */
    private final ISodaSyncUICallback f23536a;

    /* renamed from: b */
    private final SodaSyncLoadingProcessor f23537b;

    /* renamed from: c */
    private final SodaSyncApiErrProcessor f23538c = new SodaSyncApiErrProcessor(this.f23536a);

    /* renamed from: d */
    private final SodaSyncStatusProcessor f23539d = new SodaSyncStatusProcessor(this.f23536a);

    /* renamed from: e */
    private SodaPayWaitTimeOutProcessor f23540e;

    /* renamed from: a */
    private final void m19221a() {
    }

    public void onCardBind(String str) {
    }

    public void onCashierClose(int i) {
    }

    public void onTopUp() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SodaPaySyncPresenter(Context context, LifecycleOwner lifecycleOwner, String str, IGlobalCashierActionInterceptCallback iGlobalCashierActionInterceptCallback, ISodaSyncUICallback iSodaSyncUICallback) {
        super(context, lifecycleOwner, str, ParamsHelper.NATIVE, iGlobalCashierActionInterceptCallback);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(iGlobalCashierActionInterceptCallback, "actionInterceptCallback");
        Intrinsics.checkNotNullParameter(iSodaSyncUICallback, "uiCallback");
        this.f23536a = iSodaSyncUICallback;
        this.f23537b = new SodaSyncLoadingProcessor(context, lifecycleOwner);
    }

    public void init(CashierParam cashierParam) {
        List<GPayMethodItem> selectedItems;
        super.init(cashierParam);
        if (!(cashierParam == null || (selectedItems = cashierParam.getSelectedItems()) == null)) {
            for (GPayMethodItem transform : selectedItems) {
                getMSelectPayments().add(DataTransformer.INSTANCE.transform(transform));
            }
        }
        this.f23540e = new SodaPayWaitTimeOutProcessor(cashierParam == null ? null : cashierParam.getMaxPayWaitTime(), this.f23536a);
    }

    public void onBind() {
        super.onBind();
        registerProcessor(this.f23537b, ICashierOperateProcessor.class);
        registerProcessor(this.f23538c, ICashierDialogProcessor.class);
        registerProcessor(this.f23539d, ICashierSyncStatusProcessor.class);
        doPay((CashierAction) null);
    }

    public void unBind() {
        super.unBind();
        SodaPayWaitTimeOutProcessor sodaPayWaitTimeOutProcessor = this.f23540e;
        if (sodaPayWaitTimeOutProcessor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payWaitTimeOutProcessor");
            sodaPayWaitTimeOutProcessor = null;
        }
        sodaPayWaitTimeOutProcessor.onDestroy();
    }

    public final void dismissLoading() {
        this.f23537b.dismissLoading();
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004e A[EDGE_INSN: B:26:0x004e->B:19:0x004e ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCardVerify(java.lang.String r9) {
        /*
            r8 = this;
            com.didi.global.fintech.cashier.core.utils.CashierLog r0 = com.didi.global.fintech.cashier.core.utils.CashierLog.INSTANCE
            java.lang.String r1 = "SodaPaySyncPresenter onCardVerify: "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r9)
            r0.mo68926e(r1)
            r0 = 0
            if (r9 != 0) goto L_0x000f
            goto L_0x005d
        L_0x000f:
            java.util.List r1 = r8.getMSelectPayments()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0019:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x004d
            java.lang.Object r2 = r1.next()
            r3 = r2
            com.didi.global.fintech.cashier.model.net.response.Payment r3 = (com.didi.global.fintech.cashier.model.net.response.Payment) r3
            java.lang.Integer r4 = r3.getChannelId()
            r5 = 150(0x96, float:2.1E-43)
            r6 = 1
            r7 = 0
            if (r4 != 0) goto L_0x0031
            goto L_0x0049
        L_0x0031:
            int r4 = r4.intValue()
            if (r4 != r5) goto L_0x0049
            com.didi.global.fintech.cashier.model.net.request.CashierAction r3 = r3.getSelectAction()
            if (r3 != 0) goto L_0x003f
        L_0x003d:
            r3 = 0
            goto L_0x0046
        L_0x003f:
            boolean r3 = r3.updateCardInfo()
            if (r3 != r6) goto L_0x003d
            r3 = 1
        L_0x0046:
            if (r3 == 0) goto L_0x0049
            goto L_0x004a
        L_0x0049:
            r6 = 0
        L_0x004a:
            if (r6 == 0) goto L_0x0019
            goto L_0x004e
        L_0x004d:
            r2 = r0
        L_0x004e:
            com.didi.global.fintech.cashier.model.net.response.Payment r2 = (com.didi.global.fintech.cashier.model.net.response.Payment) r2
            if (r2 != 0) goto L_0x0053
            goto L_0x005d
        L_0x0053:
            com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo r1 = r2.getExtraInfo()
            if (r1 != 0) goto L_0x005a
            goto L_0x005d
        L_0x005a:
            r1.setCardIndex(r9)
        L_0x005d:
            r8.doPay(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.soda.presenter.SodaPaySyncPresenter.onCardVerify(java.lang.String):void");
    }

    public void onPixPaid() {
        CashierLog.INSTANCE.mo68926e("SodaPaySyncPresenter onPixPaid");
        this.f23536a.onFinish(SodaPayResult.Companion.newSuccessResult());
    }

    public void onAdyenThreeDSSuccess(GlobalCashierAdyen3DSModel globalCashierAdyen3DSModel) {
        Intrinsics.checkNotNullParameter(globalCashierAdyen3DSModel, "data");
        CashierLog.INSTANCE.mo68926e("SodaPaySyncPresenter onAdyenThreeDSSuccess");
        request3DSDetails(globalCashierAdyen3DSModel);
        omega3dsVerifyResultSt(getMOrderId(), CashierOmegaUtils.Companion.getUid(), globalCashierAdyen3DSModel.getAuth_details(), "", "", 0);
    }

    public void onCybsThreeDSSuccess(PrepayRequest.ThreeDSV2 threeDSV2, String str) {
        Intrinsics.checkNotNullParameter(threeDSV2, "data");
        CashierLog.INSTANCE.mo68926e("SodaPaySyncPresenter onCybsThreeDSSuccess");
        updateCybs3DS(threeDSV2, str);
    }

    public void onThreeDSFailed(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "type");
        CashierLog cashierLog = CashierLog.INSTANCE;
        cashierLog.mo68926e("SodaPaySyncPresenter onThreeDSFailed: " + str + ' ' + str2);
        dismissLoading();
        SodaPaySyncPresenter sodaPaySyncPresenter = this;
        SodaPaySyncPresenter sodaPaySyncPresenter2 = Intrinsics.areEqual((Object) str2, (Object) CashierAction.ACTION_THREE_DS) ? this : null;
        if (sodaPaySyncPresenter2 != null) {
            sodaPaySyncPresenter2.omega3dsVerifyResultSt(sodaPaySyncPresenter2.getMOrderId(), CashierOmegaUtils.Companion.getUid(), "", str, str, 0);
        }
        this.f23536a.onFinish(SodaPayResult.Companion.new3DSFailResult());
    }

    public void onThreeDSCancel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "type");
        CashierLog cashierLog = CashierLog.INSTANCE;
        cashierLog.mo68926e("SodaPaySyncPresenter onThreeDSCancel: " + str + ' ' + str2);
        dismissLoading();
        SodaPaySyncPresenter sodaPaySyncPresenter = this;
        SodaPaySyncPresenter sodaPaySyncPresenter2 = Intrinsics.areEqual((Object) str2, (Object) CashierAction.ACTION_THREE_DS) ? this : null;
        if (sodaPaySyncPresenter2 != null) {
            sodaPaySyncPresenter2.omega3dsVerifyResultSt(sodaPaySyncPresenter2.getMOrderId(), CashierOmegaUtils.Companion.getUid(), "", "", "", 1);
        }
        this.f23536a.onFinish(SodaPayResult.Companion.new3DSFailResult());
    }

    public void onPasswordSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        CashierLog.INSTANCE.mo68926e("SodaPaySyncPresenter onPasswordSuccess");
        updatePasswordToken(str);
    }

    public void onPasswordFailed(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "status");
        Intrinsics.checkNotNullParameter(str2, "desc");
        CashierLog cashierLog = CashierLog.INSTANCE;
        cashierLog.mo68926e("SodaPaySyncPresenter onPasswordFailed: " + str + ' ' + str2);
        this.f23536a.onFinish((SodaPayResult) null);
    }

    public void prePay(PrepayRequest prepayRequest) {
        Intrinsics.checkNotNullParameter(prepayRequest, "prePay");
        super.prePay(prepayRequest);
        SodaPayWaitTimeOutProcessor sodaPayWaitTimeOutProcessor = this.f23540e;
        if (sodaPayWaitTimeOutProcessor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payWaitTimeOutProcessor");
            sodaPayWaitTimeOutProcessor = null;
        }
        sodaPayWaitTimeOutProcessor.startTimer();
    }

    public void getPayStatus(GetPayStatusRequest getPayStatusRequest) {
        Intrinsics.checkNotNullParameter(getPayStatusRequest, "getPayStatusRequest");
        super.getPayStatus(getPayStatusRequest);
        SodaPayWaitTimeOutProcessor sodaPayWaitTimeOutProcessor = this.f23540e;
        if (sodaPayWaitTimeOutProcessor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payWaitTimeOutProcessor");
            sodaPayWaitTimeOutProcessor = null;
        }
        sodaPayWaitTimeOutProcessor.startTimer();
    }

    public final void onActionIntercept(String str) {
        SodaPayWaitTimeOutProcessor sodaPayWaitTimeOutProcessor = this.f23540e;
        if (sodaPayWaitTimeOutProcessor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payWaitTimeOutProcessor");
            sodaPayWaitTimeOutProcessor = null;
        }
        sodaPayWaitTimeOutProcessor.onActionIntercept(str);
    }

    public void onRandomVerifyResult(int i, String str) {
        if (i == 0) {
            doPay((CashierAction) null);
        } else {
            this.f23536a.onFinish(SodaPayResult.Companion.newRandomVerifyFailResult(i, str));
        }
    }
}
