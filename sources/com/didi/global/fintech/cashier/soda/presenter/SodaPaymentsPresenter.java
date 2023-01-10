package com.didi.global.fintech.cashier.soda.presenter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.didi.global.fintech.cashier.core.GlobalCashierPlansInfoActivity;
import com.didi.global.fintech.cashier.core.api.ICashierBaseProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierDialogProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierPayInfoProcessor;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionHandleCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionInterceptCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBaseView;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBaseViewBinder;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierCardChannelViewBinder;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierNetPresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPayBtnViewBinder;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierRandomVerifyActionCallBack;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierThirdChannelViewBinder;
import com.didi.global.fintech.cashier.core.contract.IGlobalMainCashierPresenter;
import com.didi.global.fintech.cashier.core.interceptor.CashierActionInterceptor;
import com.didi.global.fintech.cashier.core.presenter.GlobalCashierBinderPresenter;
import com.didi.global.fintech.cashier.core.presenter.GlobalCashierBizPresenter;
import com.didi.global.fintech.cashier.core.utils.CashierAppUtils;
import com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierCardChannelViewBinder;
import com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierPayBtnViewBinder;
import com.didi.global.fintech.cashier.core.viewbinder.GlobalCashierThirdChannelViewBinder;
import com.didi.global.fintech.cashier.model.CashierError;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.request.ChangePayInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.GetPayInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.PrepayRequest;
import com.didi.global.fintech.cashier.model.net.response.BasicPayment;
import com.didi.global.fintech.cashier.model.net.response.GlobalCashierAdyen3DSModel;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.Payment;
import com.didi.global.fintech.cashier.model.net.response.ShowInfo;
import com.didi.global.fintech.cashier.model.strategy.PayInfoStrategy;
import com.didi.global.fintech.cashier.p118ui.IGlobalCashierPayBtnViewHolder;
import com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierDialogBaseConfig;
import com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierDialogCallback;
import com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierDialogCommonConfig;
import com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierDialogFactory;
import com.didi.global.fintech.cashier.p118ui.kts.JsonKtxKt;
import com.didi.global.fintech.cashier.p118ui.omega.CashierOmegaUtils;
import com.didi.global.fintech.cashier.p118ui.viewholder.FeeHelpInfo;
import com.didi.global.fintech.cashier.p118ui.viewholder.item.ChannelItemViewHolderData;
import com.didi.global.fintech.cashier.p118ui.viewholder.item.InstallmentVo;
import com.didi.global.fintech.cashier.p118ui.widget.GlobalCashierLoadingView;
import com.didi.global.fintech.cashier.soda.contract.ISodaCashierCallback;
import com.didi.global.fintech.cashier.soda.contract.ISodaPayPresenter;
import com.didi.global.fintech.cashier.soda.contract.ISodaPaymentsPresenter;
import com.didi.global.fintech.cashier.soda.contract.ISodaPaymentsView;
import com.didi.global.fintech.cashier.soda.viewbinder.SodaHeaderViewBinder;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.global.fintech.cashier.user.model.GPayMethodItem;
import com.didi.sdk.util.UiThreadHandler;
import com.taxis99.R;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\b\u0012\u0004\u0012\u00020\n0\t:\u0002qrB/\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0018\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u001eH\u0016J \u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0019H\u0002J\u0012\u0010-\u001a\u00020\u001e2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0018\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020*2\u0006\u00102\u001a\u000203H\u0016J\u0018\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u0002062\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020\u001eH\u0016J\u0012\u0010;\u001a\u00020\u001e2\b\u0010<\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010=\u001a\u00020\u001eH\u0016J\b\u0010>\u001a\u00020\u001eH\u0016J\u0012\u0010?\u001a\u00020\u001e2\b\u0010@\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010A\u001a\u00020\u001e2\b\u0010@\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010B\u001a\u00020\u001e2\u0006\u0010C\u001a\u00020DH\u0016J\u0012\u0010E\u001a\u00020\u001e2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u001a\u0010H\u001a\u00020\u001e2\u0006\u00108\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010K\u001a\u00020\u001eH\u0016J\b\u0010L\u001a\u00020\u001eH\u0016J\u0012\u0010M\u001a\u00020\u001e2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J!\u0010P\u001a\u00020\u001e2\b\u0010@\u001a\u0004\u0018\u00010\u00102\b\u0010Q\u001a\u0004\u0018\u00010DH\u0016¢\u0006\u0002\u0010RJ\u0018\u0010S\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u00102\u0006\u0010U\u001a\u00020\u0010H\u0016J\u0010\u0010V\u001a\u00020\u001e2\u0006\u0010W\u001a\u00020\u0010H\u0016J\b\u0010X\u001a\u00020\u001eH\u0016J\u0010\u0010Y\u001a\u00020\u001e2\u0006\u0010Z\u001a\u00020[H\u0016J \u0010\\\u001a\u00020\u001e2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\n2\u0006\u0010`\u001a\u00020&H\u0016J\b\u0010a\u001a\u00020\u001eH\u0016J\u001a\u0010b\u001a\u00020\u001e2\b\u0010@\u001a\u0004\u0018\u00010\u00102\u0006\u0010c\u001a\u00020dH\u0016J\u001a\u0010e\u001a\u00020\u001e2\u0006\u0010f\u001a\u00020D2\b\u0010g\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010h\u001a\u00020\u001e2\b\u00105\u001a\u0004\u0018\u00010\u00102\u0006\u0010<\u001a\u00020\u0010H\u0016J\u001a\u0010i\u001a\u00020\u001e2\b\u00105\u001a\u0004\u0018\u00010\u00102\u0006\u0010<\u001a\u00020\u0010H\u0016J\b\u0010j\u001a\u00020\u001eH\u0016J\u0016\u0010k\u001a\u00020\u001e2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020,0mH\u0016J \u0010n\u001a\u00020\u001e2\u0006\u0010]\u001a\u00020^2\u000e\u0010o\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0016J\b\u0010p\u001a\u00020\u001eH\u0016R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006s"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/presenter/SodaPaymentsPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalMainCashierPresenter;", "Lcom/didi/global/fintech/cashier/soda/contract/ISodaPaymentsPresenter;", "Lcom/didi/global/fintech/cashier/core/api/ICashierOperateProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashierPayInfoProcessor;", "Lcom/didi/global/fintech/cashier/soda/contract/ISodaPayPresenter;", "Lcom/didi/global/fintech/cashier/core/api/ICashierDialogProcessor;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionHandleCallback;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierRandomVerifyActionCallBack;", "Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierBinderPresenter;", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "uniqueId", "", "actionInterceptCallback", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionInterceptCallback;", "callback", "Lcom/didi/global/fintech/cashier/soda/contract/ISodaCashierCallback;", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionInterceptCallback;Lcom/didi/global/fintech/cashier/soda/contract/ISodaCashierCallback;)V", "loadingView", "Lcom/didi/global/fintech/cashier/ui/widget/GlobalCashierLoadingView;", "mUserSelect", "", "Lcom/didi/global/fintech/cashier/user/model/GPayMethodItem;", "IView", "Lcom/didi/global/fintech/cashier/soda/contract/ISodaPaymentsView;", "appUpgrade", "", "bindView", "view", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseView;", "customError", "config", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogCommonConfig;", "api", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierNetPresenter$API;", "dismissLoading", "doClose", "isClickConfirmBtn", "", "selectPayments", "Lcom/didi/global/fintech/cashier/model/net/response/BasicPayment;", "init", "param", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "loading", "cancelable", "duration", "", "netError", "error", "Lcom/didi/global/fintech/cashier/model/CashierError;", "onAdyenThreeDSSuccess", "data", "Lcom/didi/global/fintech/cashier/model/net/response/GlobalCashierAdyen3DSModel;", "onBackClicked", "onBackPressed", "type", "onBind", "onBindCardClick", "onCardBind", "cardIndex", "onCardVerify", "onCashierClose", "payResult", "", "onConfirmBtnClick", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "onCybsThreeDSSuccess", "Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2;", "cvv", "onGoSignUp", "onGoTopUp", "onHelpIconClick", "helpInfo", "Lcom/didi/global/fintech/cashier/ui/viewholder/FeeHelpInfo;", "onInstallmentClick", "number", "(Ljava/lang/String;Ljava/lang/Integer;)V", "onPasswordFailed", "status", "desc", "onPasswordSuccess", "token", "onPayBtnClick", "onPayChannelClick", "d", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/ChannelItemViewHolderData;", "onPayInfoSuccess", "strategy", "Lcom/didi/global/fintech/cashier/model/strategy/PayInfoStrategy;", "response", "API", "onPixPaid", "onPlansClick", "vo", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/InstallmentVo;", "onRandomVerifyResult", "code", "msg", "onThreeDSCancel", "onThreeDSFailed", "onTopUp", "refreshPayMethodInfo", "afterSelectPayment", "", "requestPayMethodInfo", "payMethodItem", "unBind", "GlobalCashierDialogType", "GlobalCashierDialogTypeCallback", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SodaPaymentsPresenter.kt */
public class SodaPaymentsPresenter extends GlobalCashierBinderPresenter<PayInfoResponse> implements ICashierDialogProcessor, ICashierOperateProcessor, ICashierPayInfoProcessor, IGlobalCashierActionHandleCallback, IGlobalCashierRandomVerifyActionCallBack, IGlobalMainCashierPresenter, ISodaPayPresenter, ISodaPaymentsPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final ISodaCashierCallback f23541a;

    /* renamed from: b */
    private List<GPayMethodItem> f23542b;

    /* renamed from: c */
    private final GlobalCashierLoadingView f23543c = GlobalCashierLoadingView.Companion.newInstance$default(GlobalCashierLoadingView.Companion, false, 1, (Object) null);

    @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SodaPaymentsPresenter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IGlobalCashierNetPresenter.API.values().length];
            iArr[IGlobalCashierNetPresenter.API.GET_PAY_INFO.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void onCashierClose(int i) {
    }

    public void onHelpIconClick(FeeHelpInfo feeHelpInfo) {
    }

    public void onPasswordFailed(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "status");
        Intrinsics.checkNotNullParameter(str2, "desc");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SodaPaymentsPresenter(Context context, LifecycleOwner lifecycleOwner, String str, IGlobalCashierActionInterceptCallback iGlobalCashierActionInterceptCallback, ISodaCashierCallback iSodaCashierCallback) {
        super(context, lifecycleOwner, str, (String) null, iGlobalCashierActionInterceptCallback);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(iGlobalCashierActionInterceptCallback, "actionInterceptCallback");
        Intrinsics.checkNotNullParameter(iSodaCashierCallback, "callback");
        this.f23541a = iSodaCashierCallback;
    }

    public void init(CashierParam cashierParam) {
        List<GPayMethodItem> list;
        super.init(cashierParam);
        if (cashierParam == null) {
            list = null;
        } else {
            list = cashierParam.getSelectedItems();
        }
        this.f23542b = list;
    }

    public void bindView(IGlobalCashierBaseView iGlobalCashierBaseView) {
        super.bindView(iGlobalCashierBaseView);
        IGlobalMainCashierPresenter iGlobalMainCashierPresenter = this;
        SodaHeaderViewBinder sodaHeaderViewBinder = new SodaHeaderViewBinder(iGlobalMainCashierPresenter);
        ISodaPaymentsView IView = IView();
        IGlobalCashierPayBtnViewHolder iGlobalCashierPayBtnViewHolder = null;
        sodaHeaderViewBinder.viewBind(IView == null ? null : IView.headerView());
        GlobalCashierCardChannelViewBinder globalCashierCardChannelViewBinder = new GlobalCashierCardChannelViewBinder(iGlobalMainCashierPresenter, true);
        ISodaPaymentsView IView2 = IView();
        globalCashierCardChannelViewBinder.viewBind(IView2 == null ? null : IView2.cardChannelView());
        GlobalCashierThirdChannelViewBinder globalCashierThirdChannelViewBinder = new GlobalCashierThirdChannelViewBinder(iGlobalMainCashierPresenter, true);
        ISodaPaymentsView IView3 = IView();
        globalCashierThirdChannelViewBinder.viewBind(IView3 == null ? null : IView3.thirdChannelView());
        GlobalCashierPayBtnViewBinder globalCashierPayBtnViewBinder = new GlobalCashierPayBtnViewBinder(iGlobalMainCashierPresenter);
        ISodaPaymentsView IView4 = IView();
        if (IView4 != null) {
            iGlobalCashierPayBtnViewHolder = IView4.payBtnView();
        }
        globalCashierPayBtnViewBinder.viewBind(iGlobalCashierPayBtnViewHolder);
    }

    public void onBind() {
        super.onBind();
        ICashierBaseProcessor iCashierBaseProcessor = this;
        registerProcessor(iCashierBaseProcessor, ICashierOperateProcessor.class);
        registerProcessor(iCashierBaseProcessor, ICashierPayInfoProcessor.class);
        registerProcessor(iCashierBaseProcessor, ICashierDialogProcessor.class);
        requestPayMethodInfo(new PayInfoStrategy(0, PayInfoStrategy.Companion.getNormal(), 1, (DefaultConstructorMarker) null), this.f23542b);
    }

    public void requestPayMethodInfo(PayInfoStrategy payInfoStrategy, List<GPayMethodItem> list) {
        Intrinsics.checkNotNullParameter(payInfoStrategy, "strategy");
        setMPayInfoStrategy(payInfoStrategy);
        List arrayList = new ArrayList();
        String str = null;
        if (list != null) {
            for (GPayMethodItem gPayMethodItem : list) {
                BasicPayment basicPayment = new BasicPayment((Integer) null, (Payment.ExtraInfo) null, 3, (DefaultConstructorMarker) null);
                basicPayment.setChannelId(gPayMethodItem.getChannelId());
                Payment.ExtraInfo extraInfo = new Payment.ExtraInfo((String) null, (Integer) null, 3, (DefaultConstructorMarker) null);
                GPayMethodItem.ExtraInfo extraInfo2 = gPayMethodItem.getExtraInfo();
                extraInfo.setCardIndex(extraInfo2 == null ? null : extraInfo2.getCardIndex());
                GPayMethodItem.ExtraInfo extraInfo3 = gPayMethodItem.getExtraInfo();
                extraInfo.setInstallmentNumber(extraInfo3 == null ? null : extraInfo3.getInstallmentNumber());
                Unit unit = Unit.INSTANCE;
                basicPayment.setExtraInfo(extraInfo);
                Unit unit2 = Unit.INSTANCE;
                arrayList.add(basicPayment);
            }
        }
        GetPayInfoRequest getPayInfoRequest = new GetPayInfoRequest((String) null, (String) null, (String) null, (String) null, (List) null, (String) null, 63, (DefaultConstructorMarker) null);
        getPayInfoRequest.setOut_trade_id(getMOutTradeId());
        CashierParam mCashierParam = getMCashierParam();
        getPayInfoRequest.setSign(mCashierParam == null ? null : mCashierParam.getSign());
        CashierParam mCashierParam2 = getMCashierParam();
        getPayInfoRequest.setSign_type(mCashierParam2 == null ? null : mCashierParam2.getSignType());
        CashierParam mCashierParam3 = getMCashierParam();
        getPayInfoRequest.setBiz_content(mCashierParam3 == null ? null : mCashierParam3.getBizContent());
        getPayInfoRequest.setUser_select(arrayList);
        CashierParam mCashierParam4 = getMCashierParam();
        if (mCashierParam4 != null) {
            str = mCashierParam4.getBizDeviceInfo();
        }
        getPayInfoRequest.setBiz_device_info(str);
        Unit unit3 = Unit.INSTANCE;
        getPayMethodInfo(getPayInfoRequest);
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) getProcessor(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            ICashierOperateProcessor.DefaultImpls.loading$default(iCashierOperateProcessor, false, 0, 2, (Object) null);
        }
    }

    public void refreshPayMethodInfo(List<? extends BasicPayment> list) {
        Intrinsics.checkNotNullParameter(list, "afterSelectPayment");
        List arrayList = new ArrayList();
        for (Payment payment : getMSelectPayments()) {
            arrayList.add(new BasicPayment(payment.getChannelId(), payment.getExtraInfo()));
        }
        arrayList.addAll(getMExtraPayments());
        ChangePayInfoRequest changePayInfoRequest = new ChangePayInfoRequest((String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (List) null, (String) null, 255, (DefaultConstructorMarker) null);
        String mOutTradeId = getMOutTradeId();
        if (mOutTradeId == null) {
            mOutTradeId = "";
        }
        changePayInfoRequest.setOut_trade_id(mOutTradeId);
        CashierParam mCashierParam = getMCashierParam();
        String str = null;
        changePayInfoRequest.setSign(mCashierParam == null ? null : mCashierParam.getSign());
        CashierParam mCashierParam2 = getMCashierParam();
        changePayInfoRequest.setSign_type(mCashierParam2 == null ? null : mCashierParam2.getSignType());
        CashierParam mCashierParam3 = getMCashierParam();
        changePayInfoRequest.setBiz_content(mCashierParam3 == null ? null : mCashierParam3.getBizContent());
        CashierParam mCashierParam4 = getMCashierParam();
        if (mCashierParam4 != null) {
            str = mCashierParam4.getBizDeviceInfo();
        }
        changePayInfoRequest.setBiz_device_info(str);
        changePayInfoRequest.getFrom_select().addAll(arrayList);
        changePayInfoRequest.getTo_select().addAll(list);
        Unit unit = Unit.INSTANCE;
        changePayMethodInfo(changePayInfoRequest);
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) getProcessor(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            ICashierOperateProcessor.DefaultImpls.loading$default(iCashierOperateProcessor, false, 0, 2, (Object) null);
        }
    }

    public void onPayInfoSuccess(PayInfoStrategy payInfoStrategy, PayInfoResponse payInfoResponse, IGlobalCashierNetPresenter.API api) {
        Intrinsics.checkNotNullParameter(payInfoStrategy, "strategy");
        Intrinsics.checkNotNullParameter(payInfoResponse, "response");
        Intrinsics.checkNotNullParameter(api, "API");
        for (IGlobalCashierBaseViewBinder iGlobalCashierBaseViewBinder : getViewBinders()) {
            iGlobalCashierBaseViewBinder.setupView(payInfoResponse);
        }
        ISodaPaymentsView IView = IView();
        if (IView != null) {
            IView.setupView(payInfoResponse);
        }
        SodaPaymentsPresenter sodaPaymentsPresenter = this;
        SodaPaymentsPresenter sodaPaymentsPresenter2 = api == IGlobalCashierNetPresenter.API.GET_PAY_INFO ? this : null;
        if (sodaPaymentsPresenter2 != null) {
            ShowInfo showInfo = payInfoResponse.getShowInfo();
            sodaPaymentsPresenter2.omegaCheckoutSw(showInfo == null ? null : showInfo.getPayButtonEnable(), sodaPaymentsPresenter2.getMAppId(), JsonKtxKt.toJson$default(payInfoResponse, (Type) null, 1, (Object) null), true);
            for (Payment omegaPayMethodCk : sodaPaymentsPresenter2.getMSelectPayments()) {
                sodaPaymentsPresenter2.omegaPayMethodCk(omegaPayMethodCk, 1);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: com.didi.global.fintech.cashier.model.net.response.Payment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.didi.global.fintech.cashier.model.net.response.Payment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.didi.global.fintech.cashier.model.net.response.Payment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.didi.global.fintech.cashier.model.net.response.Payment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.didi.global.fintech.cashier.model.net.response.Payment} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPayChannelClick(com.didi.global.fintech.cashier.p118ui.viewholder.item.ChannelItemViewHolderData r10) {
        /*
            r9 = this;
            java.lang.String r0 = "d"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            boolean r0 = r10.getSelected()
            if (r0 == 0) goto L_0x0014
            com.didi.global.fintech.cashier.ui.viewholder.item.ChannelItemViewHolderData$Operation r0 = r10.getOperatorType()
            com.didi.global.fintech.cashier.ui.viewholder.item.ChannelItemViewHolderData$Operation r1 = com.didi.global.fintech.cashier.p118ui.viewholder.item.ChannelItemViewHolderData.Operation.OPERATION_SWITCH
            if (r0 == r1) goto L_0x0014
            return
        L_0x0014:
            com.didi.global.fintech.cashier.core.utils.PayInfoManager r0 = com.didi.global.fintech.cashier.core.utils.PayInfoManager.getInstance()
            java.lang.String r1 = r9.getUniqueId()
            com.didi.global.fintech.cashier.model.net.response.PayInfoResponse r0 = r0.getPayInfo(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r1 = (java.util.List) r1
            r2 = 0
            if (r0 != 0) goto L_0x002b
            goto L_0x007d
        L_0x002b:
            java.util.List r3 = r0.getPaymentGroups()
            if (r3 != 0) goto L_0x0032
            goto L_0x007d
        L_0x0032:
            r4 = 0
            java.lang.Object r3 = kotlin.collections.CollectionsKt.getOrNull(r3, r4)
            com.didi.global.fintech.cashier.model.net.response.PaymentGroup r3 = (com.didi.global.fintech.cashier.model.net.response.PaymentGroup) r3
            if (r3 != 0) goto L_0x003c
            goto L_0x007d
        L_0x003c:
            java.util.List r3 = r3.getPayments()
            if (r3 != 0) goto L_0x0043
            goto L_0x007d
        L_0x0043:
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x0049:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x007b
            java.lang.Object r5 = r3.next()
            r6 = r5
            com.didi.global.fintech.cashier.model.net.response.Payment r6 = (com.didi.global.fintech.cashier.model.net.response.Payment) r6
            java.lang.Integer r7 = r6.getChannelId()
            r8 = 120(0x78, float:1.68E-43)
            if (r7 != 0) goto L_0x005f
            goto L_0x0065
        L_0x005f:
            int r7 = r7.intValue()
            if (r7 == r8) goto L_0x0077
        L_0x0065:
            java.lang.Integer r6 = r6.getChannelId()
            r7 = 190(0xbe, float:2.66E-43)
            if (r6 != 0) goto L_0x006e
            goto L_0x0075
        L_0x006e:
            int r6 = r6.intValue()
            if (r6 != r7) goto L_0x0075
            goto L_0x0077
        L_0x0075:
            r6 = 0
            goto L_0x0078
        L_0x0077:
            r6 = 1
        L_0x0078:
            if (r6 == 0) goto L_0x0049
            r2 = r5
        L_0x007b:
            com.didi.global.fintech.cashier.model.net.response.Payment r2 = (com.didi.global.fintech.cashier.model.net.response.Payment) r2
        L_0x007d:
            com.didi.global.fintech.cashier.soda.presenter.SodaPaymentsPresenter$onPayChannelClick$1 r3 = new com.didi.global.fintech.cashier.soda.presenter.SodaPaymentsPresenter$onPayChannelClick$1
            r3.<init>(r10, r9, r2)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r9.getPaymentsFromPayInfo(r0, r1, r3)
            boolean r10 = r1.isEmpty()
            if (r10 == 0) goto L_0x008e
            return
        L_0x008e:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List r10 = (java.util.List) r10
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r0 = r1.iterator()
        L_0x009b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00b8
            java.lang.Object r1 = r0.next()
            com.didi.global.fintech.cashier.model.net.response.Payment r1 = (com.didi.global.fintech.cashier.model.net.response.Payment) r1
            com.didi.global.fintech.cashier.model.net.response.BasicPayment r2 = new com.didi.global.fintech.cashier.model.net.response.BasicPayment
            java.lang.Integer r3 = r1.getChannelId()
            com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo r1 = r1.getExtraInfo()
            r2.<init>(r3, r1)
            r10.add(r2)
            goto L_0x009b
        L_0x00b8:
            r9.refreshPayMethodInfo(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.soda.presenter.SodaPaymentsPresenter.onPayChannelClick(com.didi.global.fintech.cashier.ui.viewholder.item.ChannelItemViewHolderData):void");
    }

    public void onBindCardClick() {
        CashierActionInterceptor actionInterceptor = getActionInterceptor();
        if (actionInterceptor != null) {
            actionInterceptor.intercept(getContext(), getLifecycleOwner(), CashierAction.Companion.insAddCard(getMProductId(), getMAppId()), new SodaPaymentsPresenter$onBindCardClick$1(this));
        }
        omegaAddCardCk(getMProductId(), getMAppId(), (String) getMOmegaAttrs().get("resource_id"));
    }

    public void onGoTopUp() {
        CashierActionInterceptor actionInterceptor = getActionInterceptor();
        if (actionInterceptor != null) {
            actionInterceptor.intercept(getContext(), getLifecycleOwner(), CashierAction.Companion.insTopUp(getOmegaAttr(GlobalCashierBizPresenter.OMEGA_ATTR_PUB_SOURCE)), new SodaPaymentsPresenter$onGoTopUp$1(this));
        }
        omegaCheckoutTopUpCk();
    }

    public void onGoSignUp() {
        CashierActionInterceptor actionInterceptor = getActionInterceptor();
        if (actionInterceptor != null) {
            actionInterceptor.intercept(getContext(), getLifecycleOwner(), CashierAction.Companion.insSignUp(), new SodaPaymentsPresenter$onGoSignUp$1(this));
        }
        omegaCheckoutTopUpCk();
    }

    public void onPayBtnClick() {
        CashierAction cashierAction;
        Object obj;
        boolean z;
        omegaPayCk(getMSelectPayments());
        Iterator it = getMSelectPayments().iterator();
        while (true) {
            cashierAction = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Payment) obj).getSelectAction() != null) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        Payment payment = (Payment) obj;
        if (payment != null) {
            cashierAction = payment.getSelectAction();
        }
        onConfirmBtnClick(cashierAction);
    }

    public void onConfirmBtnClick(CashierAction cashierAction) {
        String productId;
        CashierActionInterceptor actionInterceptor = getActionInterceptor();
        if (actionInterceptor != null) {
            CashierParam cashierParam = new CashierParam((String) null, (String) null, (String) null, (String) null, (Map) null, (Map) null, (String) null, 127, (DefaultConstructorMarker) null);
            cashierParam.setOutTradeId(getMOutTradeId());
            CashierParam mCashierParam = getMCashierParam();
            cashierParam.setUseSodaRandomVerify(mCashierParam == null ? false : mCashierParam.getUseSodaRandomVerify());
            CashierParam mCashierParam2 = getMCashierParam();
            String str = "";
            if (!(mCashierParam2 == null || (productId = mCashierParam2.getProductId()) == null)) {
                str = productId;
            }
            cashierParam.setProductId(str);
            cashierParam.getOmegaAttrs().putAll(getMOmegaAttrs());
            cashierParam.setAppId(getMAppId());
            Unit unit = Unit.INSTANCE;
            actionInterceptor.setCashierParam(cashierParam);
        }
        CashierActionInterceptor actionInterceptor2 = getActionInterceptor();
        if (actionInterceptor2 != null) {
            actionInterceptor2.intercept(getContext(), getLifecycleOwner(), cashierAction, new SodaPaymentsPresenter$onConfirmBtnClick$2(this, cashierAction), new SodaPaymentsPresenter$onConfirmBtnClick$3(this));
        }
    }

    public void onCardBind(String str) {
        List arrayList = new ArrayList();
        Payment.ExtraInfo extraInfo = new Payment.ExtraInfo((String) null, (Integer) null, 3, (DefaultConstructorMarker) null);
        extraInfo.setCardIndex(str);
        Unit unit = Unit.INSTANCE;
        arrayList.add(new BasicPayment(150, extraInfo));
        Unit unit2 = Unit.INSTANCE;
        refreshPayMethodInfo(arrayList);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0043 A[EDGE_INSN: B:27:0x0043->B:19:0x0043 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCardVerify(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L_0x0004
            goto L_0x0052
        L_0x0004:
            java.util.List r1 = r8.getMSelectPayments()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x000e:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0042
            java.lang.Object r2 = r1.next()
            r3 = r2
            com.didi.global.fintech.cashier.model.net.response.Payment r3 = (com.didi.global.fintech.cashier.model.net.response.Payment) r3
            java.lang.Integer r4 = r3.getChannelId()
            r5 = 150(0x96, float:2.1E-43)
            r6 = 1
            r7 = 0
            if (r4 != 0) goto L_0x0026
            goto L_0x003e
        L_0x0026:
            int r4 = r4.intValue()
            if (r4 != r5) goto L_0x003e
            com.didi.global.fintech.cashier.model.net.request.CashierAction r3 = r3.getSelectAction()
            if (r3 != 0) goto L_0x0034
        L_0x0032:
            r3 = 0
            goto L_0x003b
        L_0x0034:
            boolean r3 = r3.updateCardInfo()
            if (r3 != r6) goto L_0x0032
            r3 = 1
        L_0x003b:
            if (r3 == 0) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            r6 = 0
        L_0x003f:
            if (r6 == 0) goto L_0x000e
            goto L_0x0043
        L_0x0042:
            r2 = r0
        L_0x0043:
            com.didi.global.fintech.cashier.model.net.response.Payment r2 = (com.didi.global.fintech.cashier.model.net.response.Payment) r2
            if (r2 != 0) goto L_0x0048
            goto L_0x0052
        L_0x0048:
            com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo r1 = r2.getExtraInfo()
            if (r1 != 0) goto L_0x004f
            goto L_0x0052
        L_0x004f:
            r1.setCardIndex(r9)
        L_0x0052:
            r8.onConfirmBtnClick(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.soda.presenter.SodaPaymentsPresenter.onCardVerify(java.lang.String):void");
    }

    public void onTopUp() {
        List arrayList = new ArrayList();
        if (CashierFacade.Companion.getInstance().getTheme().global()) {
            arrayList.add(new BasicPayment(120, (Payment.ExtraInfo) null, 2, (DefaultConstructorMarker) null));
        } else if (CashierFacade.Companion.getInstance().getTheme().brazil()) {
            arrayList.add(new BasicPayment(190, (Payment.ExtraInfo) null, 2, (DefaultConstructorMarker) null));
        } else {
            arrayList.add(new BasicPayment(190, (Payment.ExtraInfo) null, 2, (DefaultConstructorMarker) null));
        }
        Unit unit = Unit.INSTANCE;
        refreshPayMethodInfo(arrayList);
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
                SodaPaymentsPresenter.m19222a(SodaPaymentsPresenter.this, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m19222a(SodaPaymentsPresenter sodaPaymentsPresenter, boolean z, long j) {
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(sodaPaymentsPresenter, "this$0");
        if (sodaPaymentsPresenter.f23543c.isVisible()) {
            sodaPaymentsPresenter = null;
        }
        if (sodaPaymentsPresenter != null) {
            Context context = sodaPaymentsPresenter.getContext();
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
            if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null) {
                GlobalCashierLoadingView globalCashierLoadingView = sodaPaymentsPresenter.f23543c;
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
        this.f23543c.dismissAllowingStateLoss();
    }

    public void unBind() {
        super.unBind();
        getViewBinders().clear();
    }

    public void onBackClicked() {
        onBackPressed("key");
    }

    public void onBackPressed(String str) {
        omegaCheckoutReturnCk();
        m19223a(false, (List<BasicPayment>) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m19223a(boolean z, List<BasicPayment> list) {
        GPayMethodItem.ExtraInfo extraInfo;
        GPayMethodItem.ExtraInfo extraInfo2;
        ArrayList arrayList = new ArrayList();
        if (z) {
            if (list != null) {
                for (BasicPayment basicPayment : list) {
                    GPayMethodItem gPayMethodItem = new GPayMethodItem((Integer) null, (GPayMethodItem.ExtraInfo) null, 3, (DefaultConstructorMarker) null);
                    gPayMethodItem.setChannelId(basicPayment.getChannelId());
                    if (basicPayment.getExtraInfo() == null) {
                        extraInfo2 = null;
                    } else {
                        extraInfo2 = new GPayMethodItem.ExtraInfo((String) null, (Integer) null, 3, (DefaultConstructorMarker) null);
                        Payment.ExtraInfo extraInfo3 = basicPayment.getExtraInfo();
                        extraInfo2.setCardIndex(extraInfo3 == null ? null : extraInfo3.getCardIndex());
                        Payment.ExtraInfo extraInfo4 = basicPayment.getExtraInfo();
                        extraInfo2.setInstallmentNumber(extraInfo4 == null ? null : extraInfo4.getInstallmentNumber());
                        Unit unit = Unit.INSTANCE;
                    }
                    gPayMethodItem.setExtraInfo(extraInfo2);
                    Unit unit2 = Unit.INSTANCE;
                    arrayList.add(gPayMethodItem);
                }
            }
            int size = arrayList.size();
            List<GPayMethodItem> list2 = this.f23542b;
            boolean z2 = !(list2 != null && size == list2.size());
            if (!z2) {
                Collection arrayList2 = new ArrayList();
                for (Object next : arrayList) {
                    GPayMethodItem gPayMethodItem2 = (GPayMethodItem) next;
                    List<GPayMethodItem> list3 = this.f23542b;
                    if (!(list3 != null && list3.contains(gPayMethodItem2))) {
                        arrayList2.add(next);
                    }
                }
                z2 = !((List) arrayList2).isEmpty();
            }
            this.f23541a.onCashierClose(z, z2, arrayList);
            return;
        }
        List<GPayMethodItem> list4 = this.f23542b;
        if (list4 != null) {
            for (GPayMethodItem gPayMethodItem3 : list4) {
                GPayMethodItem gPayMethodItem4 = new GPayMethodItem((Integer) null, (GPayMethodItem.ExtraInfo) null, 3, (DefaultConstructorMarker) null);
                gPayMethodItem4.setChannelId(gPayMethodItem3.getChannelId());
                if (gPayMethodItem3.getExtraInfo() == null) {
                    extraInfo = null;
                } else {
                    extraInfo = new GPayMethodItem.ExtraInfo((String) null, (Integer) null, 3, (DefaultConstructorMarker) null);
                    GPayMethodItem.ExtraInfo extraInfo5 = gPayMethodItem3.getExtraInfo();
                    extraInfo.setCardIndex(extraInfo5 == null ? null : extraInfo5.getCardIndex());
                    GPayMethodItem.ExtraInfo extraInfo6 = gPayMethodItem3.getExtraInfo();
                    extraInfo.setInstallmentNumber(extraInfo6 == null ? null : extraInfo6.getInstallmentNumber());
                    Unit unit3 = Unit.INSTANCE;
                }
                gPayMethodItem4.setExtraInfo(extraInfo);
                Unit unit4 = Unit.INSTANCE;
                arrayList.add(gPayMethodItem4);
            }
        }
        this.f23541a.onCashierClose(z, false, arrayList);
    }

    public ISodaPaymentsView IView() {
        IGlobalCashierBaseView mView = getMView();
        if (mView instanceof ISodaPaymentsView) {
            return (ISodaPaymentsView) mView;
        }
        return null;
    }

    public void netError(CashierError cashierError, IGlobalCashierNetPresenter.API api) {
        GlobalCashierDialogFactory.TYPE type;
        ISodaPaymentsView IView;
        IGlobalCashierNetPresenter.API api2 = api;
        Intrinsics.checkNotNullParameter(cashierError, "error");
        Intrinsics.checkNotNullParameter(api2, "api");
        new RuntimeException().printStackTrace();
        SodaPaymentsPresenter sodaPaymentsPresenter = this;
        GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig = null;
        if (!((api2 == IGlobalCashierNetPresenter.API.GET_PAY_INFO ? this : null) == null || (IView = IView()) == null)) {
            IView.showLogoView();
        }
        GlobalCashierDialogFactory globalCashierDialogFactory = GlobalCashierDialogFactory.INSTANCE;
        Context context = getContext();
        if (WhenMappings.$EnumSwitchMapping$0[api.ordinal()] == 1) {
            type = GlobalCashierDialogFactory.TYPE.BOTTOM;
        } else {
            type = GlobalCashierDialogFactory.TYPE.CENTER;
        }
        GlobalCashierDialogFactory.TYPE type2 = type;
        GlobalCashierDialogCommonConfig newIns = GlobalCashierDialogCommonConfig.Companion.newIns(GlobalCashierDialogCommonConfig.Companion.getNET_ERROR());
        if (cashierError.getMessage().length() > 0) {
            globalCashierDialogCommonConfig = newIns;
        }
        if (globalCashierDialogCommonConfig != null) {
            globalCashierDialogCommonConfig.setSubTitle(cashierError.getMessage());
            globalCashierDialogCommonConfig.setTitle(cashierError.getTitle());
        }
        Unit unit = Unit.INSTANCE;
        GlobalCashierDialogBaseConfig globalCashierDialogBaseConfig = newIns;
        GlobalCashierDialogCallback[] globalCashierDialogCallbackArr = new GlobalCashierDialogCallback[1];
        globalCashierDialogCallbackArr[0] = new GlobalCashierDialogTypeCallback(GlobalCashierDialogType.ConfirmClose, 3, api2 == IGlobalCashierNetPresenter.API.GET_PAY_INFO, (Function0) null, 8, (DefaultConstructorMarker) null);
        globalCashierDialogFactory.showDialog(context, type2, globalCashierDialogBaseConfig, globalCashierDialogCallbackArr);
        omegaNetworkErrorSw(String.valueOf(cashierError.getCode()));
    }

    public void customError(GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig, IGlobalCashierNetPresenter.API api) {
        GlobalCashierDialogFactory.TYPE type;
        ISodaPaymentsView IView;
        GlobalCashierDialogCommonConfig globalCashierDialogCommonConfig2 = globalCashierDialogCommonConfig;
        IGlobalCashierNetPresenter.API api2 = api;
        Intrinsics.checkNotNullParameter(globalCashierDialogCommonConfig2, "config");
        Intrinsics.checkNotNullParameter(api2, "api");
        SodaPaymentsPresenter sodaPaymentsPresenter = this;
        boolean z = true;
        GlobalCashierDialogTypeCallback globalCashierDialogTypeCallback = null;
        if (!((api2 == IGlobalCashierNetPresenter.API.GET_PAY_INFO ? this : null) == null || (IView = IView()) == null)) {
            IView.showLogoView();
        }
        GlobalCashierDialogFactory globalCashierDialogFactory = GlobalCashierDialogFactory.INSTANCE;
        Context context = getContext();
        if ((api2 == IGlobalCashierNetPresenter.API.GET_PAY_INFO ? this : null) == null) {
            type = null;
        } else {
            type = GlobalCashierDialogFactory.TYPE.BOTTOM;
        }
        if (type == null) {
            type = GlobalCashierDialogFactory.TYPE.CENTER;
        }
        GlobalCashierDialogFactory.TYPE type2 = type;
        GlobalCashierDialogBaseConfig globalCashierDialogBaseConfig = globalCashierDialogCommonConfig2;
        GlobalCashierDialogCallback[] globalCashierDialogCallbackArr = new GlobalCashierDialogCallback[1];
        if (api2 != IGlobalCashierNetPresenter.API.GET_PAY_INFO) {
            z = false;
        }
        SodaPaymentsPresenter sodaPaymentsPresenter2 = z ? this : null;
        if (sodaPaymentsPresenter2 != null) {
            globalCashierDialogTypeCallback = new GlobalCashierDialogTypeCallback(GlobalCashierDialogType.ConfirmClose, 3, false, (Function0) null, 12, (DefaultConstructorMarker) null);
        }
        if (globalCashierDialogTypeCallback == null) {
            globalCashierDialogTypeCallback = new GlobalCashierDialogTypeCallback((GlobalCashierDialogType) null, (Object) null, false, (Function0) null, 14, (DefaultConstructorMarker) null);
        }
        globalCashierDialogCallbackArr[0] = globalCashierDialogTypeCallback;
        globalCashierDialogFactory.showDialog(context, type2, globalCashierDialogBaseConfig, globalCashierDialogCallbackArr);
    }

    public void onPlansClick(String str, InstallmentVo installmentVo) {
        Intrinsics.checkNotNullParameter(installmentVo, "vo");
        omegaAllInstallmentCk();
        ISodaCashierCallback iSodaCashierCallback = this.f23541a;
        Intent intent = new Intent(getContext(), GlobalCashierPlansInfoActivity.class);
        intent.putExtra("card_index", str);
        intent.putExtra(GlobalCashierPlansInfoActivity.PARAM_INSTALLMENT_PLANS, installmentVo);
        Unit unit = Unit.INSTANCE;
        iSodaCashierCallback.onCallStartActivityForResult(intent, 300);
    }

    public void onInstallmentClick(String str, Integer num) {
        omegaChangeInstallmentCk(num);
        List arrayList = new ArrayList();
        BasicPayment basicPayment = new BasicPayment((Integer) null, (Payment.ExtraInfo) null, 3, (DefaultConstructorMarker) null);
        basicPayment.setChannelId(150);
        Payment.ExtraInfo extraInfo = new Payment.ExtraInfo((String) null, (Integer) null, 3, (DefaultConstructorMarker) null);
        extraInfo.setCardIndex(str);
        extraInfo.setInstallmentNumber(num);
        Unit unit = Unit.INSTANCE;
        basicPayment.setExtraInfo(extraInfo);
        Unit unit2 = Unit.INSTANCE;
        arrayList.add(basicPayment);
        Unit unit3 = Unit.INSTANCE;
        refreshPayMethodInfo(arrayList);
    }

    public void onPixPaid() {
        requestSuccessInfo();
    }

    public void onAdyenThreeDSSuccess(GlobalCashierAdyen3DSModel globalCashierAdyen3DSModel) {
        Intrinsics.checkNotNullParameter(globalCashierAdyen3DSModel, "data");
        request3DSDetails(globalCashierAdyen3DSModel);
        omega3dsVerifyResultSt(getMOrderId(), CashierOmegaUtils.Companion.getUid(), globalCashierAdyen3DSModel.getAuth_details(), "", "", 0);
    }

    public void onCybsThreeDSSuccess(PrepayRequest.ThreeDSV2 threeDSV2, String str) {
        Intrinsics.checkNotNullParameter(threeDSV2, "data");
        updateCybs3DS(threeDSV2, str);
    }

    public void onRandomVerifyResult(int i, String str) {
        if (i == 0) {
            onConfirmBtnClick((CashierAction) null);
        }
    }

    public void onThreeDSFailed(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "type");
        dismissLoading();
        GlobalCashierDialogFactory globalCashierDialogFactory = GlobalCashierDialogFactory.INSTANCE;
        Context context = getContext();
        GlobalCashierDialogFactory.TYPE type = GlobalCashierDialogFactory.TYPE.CENTER;
        GlobalCashierDialogCommonConfig newIns = GlobalCashierDialogCommonConfig.Companion.newIns(GlobalCashierDialogCommonConfig.Companion.getPAYMENT_FAILED());
        newIns.setSubTitle(str);
        Unit unit = Unit.INSTANCE;
        globalCashierDialogFactory.showDialog(context, type, newIns, new GlobalCashierDialogCallback[0]);
        SodaPaymentsPresenter sodaPaymentsPresenter = this;
        SodaPaymentsPresenter sodaPaymentsPresenter2 = Intrinsics.areEqual((Object) str2, (Object) CashierAction.ACTION_THREE_DS) ? this : null;
        if (sodaPaymentsPresenter2 != null) {
            sodaPaymentsPresenter2.omega3dsVerifyResultSt(sodaPaymentsPresenter2.getMOrderId(), CashierOmegaUtils.Companion.getUid(), "", str, str, 0);
        }
    }

    public void onThreeDSCancel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "type");
        dismissLoading();
        GlobalCashierDialogFactory globalCashierDialogFactory = GlobalCashierDialogFactory.INSTANCE;
        Context context = getContext();
        GlobalCashierDialogFactory.TYPE type = GlobalCashierDialogFactory.TYPE.CENTER;
        GlobalCashierDialogCommonConfig newIns = GlobalCashierDialogCommonConfig.Companion.newIns(GlobalCashierDialogCommonConfig.Companion.getPAYMENT_FAILED());
        newIns.setSubTitle(str);
        Unit unit = Unit.INSTANCE;
        globalCashierDialogFactory.showDialog(context, type, newIns, new GlobalCashierDialogCallback[0]);
        SodaPaymentsPresenter sodaPaymentsPresenter = this;
        SodaPaymentsPresenter sodaPaymentsPresenter2 = Intrinsics.areEqual((Object) str2, (Object) CashierAction.ACTION_THREE_DS) ? this : null;
        if (sodaPaymentsPresenter2 != null) {
            sodaPaymentsPresenter2.omega3dsVerifyResultSt(sodaPaymentsPresenter2.getMOrderId(), CashierOmegaUtils.Companion.getUid(), "", "", "", 1);
        }
    }

    public void onPasswordSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        updatePasswordToken(str);
    }

    public void appUpgrade() {
        ISodaPaymentsView IView = IView();
        if (IView != null) {
            IView.showLogoView();
        }
        GlobalCashierDialogFactory globalCashierDialogFactory = GlobalCashierDialogFactory.INSTANCE;
        Context context = getContext();
        GlobalCashierDialogFactory.TYPE type = GlobalCashierDialogFactory.TYPE.BOTTOM;
        GlobalCashierDialogCommonConfig newIns = GlobalCashierDialogCommonConfig.Companion.newIns(GlobalCashierDialogCommonConfig.Companion.getAPP_UPGRADE());
        newIns.setSubTitle(getContext().getString(R.string.Wallet_App_V2_Please_click_TnDn, new Object[]{CashierAppUtils.INSTANCE.getAppName(getContext())}));
        Unit unit = Unit.INSTANCE;
        globalCashierDialogFactory.showDialog(context, type, newIns, new GlobalCashierDialogTypeCallback(GlobalCashierDialogType.JumpStore, (Object) null, false, new SodaPaymentsPresenter$appUpgrade$2(this), 6, (DefaultConstructorMarker) null), new GlobalCashierDialogTypeCallback(GlobalCashierDialogType.ConfirmClose, 2, false, new SodaPaymentsPresenter$appUpgrade$3(this), 4, (DefaultConstructorMarker) null));
        omegaVersionUpdateSw();
    }

    @Metadata(mo148867d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/presenter/SodaPaymentsPresenter$GlobalCashierDialogType;", "", "(Ljava/lang/String;I)V", "ConfirmClose", "JumpStore", "ChangeToChannel", "BindCard", "BackToHomepage", "Companion", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SodaPaymentsPresenter.kt */
    private enum GlobalCashierDialogType {
        ConfirmClose,
        JumpStore,
        ChangeToChannel,
        BindCard,
        BackToHomepage;
        
        public static final Companion Companion = null;

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(mo148867d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0005¨\u0006\u0006"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/presenter/SodaPaymentsPresenter$GlobalCashierDialogType$Companion;", "", "()V", "value", "Lcom/didi/global/fintech/cashier/soda/presenter/SodaPaymentsPresenter$GlobalCashierDialogType;", "", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
        /* compiled from: SodaPaymentsPresenter.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final GlobalCashierDialogType value(String str) {
                if (str == null) {
                    return null;
                }
                Pattern compile = Pattern.compile("_");
                Intrinsics.checkNotNullExpressionValue(compile, "compile(\"_\")");
                List<CharSequence> split$default = StringsKt.split$default(str, compile, 0, 2, (Object) null);
                StringBuilder sb = new StringBuilder();
                for (CharSequence charSequence : split$default) {
                    Collection arrayList = new ArrayList(charSequence.length());
                    int i = 0;
                    int i2 = 0;
                    while (i < charSequence.length()) {
                        char charAt = charSequence.charAt(i);
                        int i3 = i2 + 1;
                        if (i2 == 0) {
                            charAt = Character.toUpperCase(charAt);
                        }
                        arrayList.add(Character.valueOf(charAt));
                        i++;
                        i2 = i3;
                    }
                    for (Character charValue : (List) arrayList) {
                        sb.append(charValue.charValue());
                    }
                }
                try {
                    String sb2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
                    return GlobalCashierDialogType.valueOf(sb2);
                } catch (Exception unused) {
                    return null;
                }
            }
        }
    }

    @Metadata(mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0014\u001a\u00020\nH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/presenter/SodaPaymentsPresenter$GlobalCashierDialogTypeCallback;", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDialogCallback;", "type", "Lcom/didi/global/fintech/cashier/soda/presenter/SodaPaymentsPresenter$GlobalCashierDialogType;", "data", "", "condition", "", "omega", "Lkotlin/Function0;", "", "(Lcom/didi/global/fintech/cashier/soda/presenter/SodaPaymentsPresenter;Lcom/didi/global/fintech/cashier/soda/presenter/SodaPaymentsPresenter$GlobalCashierDialogType;Ljava/lang/Object;ZLkotlin/jvm/functions/Function0;)V", "getCondition", "()Z", "getData", "()Ljava/lang/Object;", "getOmega", "()Lkotlin/jvm/functions/Function0;", "getType", "()Lcom/didi/global/fintech/cashier/soda/presenter/SodaPaymentsPresenter$GlobalCashierDialogType;", "onBtnClick", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SodaPaymentsPresenter.kt */
    private final class GlobalCashierDialogTypeCallback implements GlobalCashierDialogCallback {
        private final boolean condition;
        private final Object data;
        private final Function0<Unit> omega;
        private final GlobalCashierDialogType type;

        @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
        /* compiled from: SodaPaymentsPresenter.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[GlobalCashierDialogType.values().length];
                iArr[GlobalCashierDialogType.ConfirmClose.ordinal()] = 1;
                iArr[GlobalCashierDialogType.JumpStore.ordinal()] = 2;
                iArr[GlobalCashierDialogType.ChangeToChannel.ordinal()] = 3;
                iArr[GlobalCashierDialogType.BindCard.ordinal()] = 4;
                iArr[GlobalCashierDialogType.BackToHomepage.ordinal()] = 5;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public GlobalCashierDialogTypeCallback(SodaPaymentsPresenter sodaPaymentsPresenter, GlobalCashierDialogType globalCashierDialogType, Object obj, boolean z, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(sodaPaymentsPresenter, "this$0");
            SodaPaymentsPresenter.this = sodaPaymentsPresenter;
            this.type = globalCashierDialogType;
            this.data = obj;
            this.condition = z;
            this.omega = function0;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ GlobalCashierDialogTypeCallback(GlobalCashierDialogType globalCashierDialogType, Object obj, boolean z, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(SodaPaymentsPresenter.this, globalCashierDialogType, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? true : z, (i & 8) != 0 ? null : function0);
        }

        public final GlobalCashierDialogType getType() {
            return this.type;
        }

        public final Object getData() {
            return this.data;
        }

        public final boolean getCondition() {
            return this.condition;
        }

        public final Function0<Unit> getOmega() {
            return this.omega;
        }

        public void onBtnClick() {
            Object obj;
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            Function0<Unit> function0 = this.omega;
            if (function0 != null) {
                function0.invoke();
            }
            if (this.condition) {
                GlobalCashierDialogType globalCashierDialogType = this.type;
                int i = globalCashierDialogType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[globalCashierDialogType.ordinal()];
                boolean z = true;
                IGlobalCashierThirdChannelViewBinder iGlobalCashierThirdChannelViewBinder = null;
                if (i == 1) {
                    SodaPaymentsPresenter.this.m19223a(false, (List<BasicPayment>) null);
                } else if (i == 2) {
                    try {
                        SodaPaymentsPresenter.this.f23541a.onCallStartActivity(new Intent("android.intent.action.VIEW", Uri.parse(Intrinsics.stringPlus("market://details?id=", SodaPaymentsPresenter.this.getContext().getPackageName()))));
                    } catch (ActivityNotFoundException unused) {
                        SodaPaymentsPresenter.this.f23541a.onCallStartActivity(new Intent("android.intent.action.VIEW", Uri.parse(Intrinsics.stringPlus("http://play.google.com/store/apps/details?id=", SodaPaymentsPresenter.this.getContext().getPackageName()))));
                    }
                } else if (i == 3) {
                    GlobalCashierDialogTypeCallback globalCashierDialogTypeCallback = this;
                    if (!(getData() instanceof List) || !(!((Collection) getData()).isEmpty()) || !(CollectionsKt.firstOrNull((List) getData()) instanceof BasicPayment)) {
                        z = false;
                    }
                    GlobalCashierDialogTypeCallback globalCashierDialogTypeCallback2 = z ? this : null;
                    if (globalCashierDialogTypeCallback2 != null) {
                        SodaPaymentsPresenter sodaPaymentsPresenter = SodaPaymentsPresenter.this;
                        ISodaPaymentsView IView = sodaPaymentsPresenter.IView();
                        if (IView != null) {
                            IView.scrollTo(0);
                        }
                        Iterator it = sodaPaymentsPresenter.f23302a.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it.next();
                            if (((IGlobalCashierBaseViewBinder) obj) instanceof IGlobalCashierCardChannelViewBinder) {
                                break;
                            }
                        }
                        IGlobalCashierBaseViewBinder iGlobalCashierBaseViewBinder = (IGlobalCashierBaseViewBinder) obj;
                        if (iGlobalCashierBaseViewBinder instanceof IGlobalCashierCardChannelViewBinder) {
                            iGlobalCashierThirdChannelViewBinder = iGlobalCashierBaseViewBinder;
                        }
                        IGlobalCashierCardChannelViewBinder iGlobalCashierCardChannelViewBinder = iGlobalCashierThirdChannelViewBinder;
                        if (iGlobalCashierCardChannelViewBinder != null) {
                            Object data2 = globalCashierDialogTypeCallback2.getData();
                            if (data2 != null) {
                                iGlobalCashierCardChannelViewBinder.topMethod((List) data2);
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.didi.global.fintech.cashier.model.net.response.BasicPayment>");
                            }
                        }
                        Object data3 = globalCashierDialogTypeCallback2.getData();
                        if (data3 != null) {
                            sodaPaymentsPresenter.refreshPayMethodInfo((List) data3);
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.didi.global.fintech.cashier.model.net.response.BasicPayment>");
                    }
                } else if (i == 4) {
                    SodaPaymentsPresenter.this.onBindCardClick();
                } else if (i == 5) {
                    Iterator it2 = SodaPaymentsPresenter.this.f23302a.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it2.next();
                        if (((IGlobalCashierBaseViewBinder) obj2) instanceof IGlobalCashierCardChannelViewBinder) {
                            break;
                        }
                    }
                    IGlobalCashierBaseViewBinder iGlobalCashierBaseViewBinder2 = (IGlobalCashierBaseViewBinder) obj2;
                    if (!(iGlobalCashierBaseViewBinder2 instanceof IGlobalCashierCardChannelViewBinder)) {
                        iGlobalCashierBaseViewBinder2 = null;
                    }
                    IGlobalCashierCardChannelViewBinder iGlobalCashierCardChannelViewBinder2 = (IGlobalCashierCardChannelViewBinder) iGlobalCashierBaseViewBinder2;
                    if (iGlobalCashierCardChannelViewBinder2 != null) {
                        iGlobalCashierCardChannelViewBinder2.onSpreadClick((ChannelItemViewHolderData) null);
                    }
                    Iterator it3 = SodaPaymentsPresenter.this.f23302a.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            obj3 = null;
                            break;
                        }
                        obj3 = it3.next();
                        if (((IGlobalCashierBaseViewBinder) obj3) instanceof IGlobalCashierPayBtnViewBinder) {
                            break;
                        }
                    }
                    IGlobalCashierBaseViewBinder iGlobalCashierBaseViewBinder3 = (IGlobalCashierBaseViewBinder) obj3;
                    if (!(iGlobalCashierBaseViewBinder3 instanceof IGlobalCashierPayBtnViewBinder)) {
                        iGlobalCashierBaseViewBinder3 = null;
                    }
                    IGlobalCashierPayBtnViewBinder iGlobalCashierPayBtnViewBinder = (IGlobalCashierPayBtnViewBinder) iGlobalCashierBaseViewBinder3;
                    if (iGlobalCashierPayBtnViewBinder != null) {
                        iGlobalCashierPayBtnViewBinder.disableBtn();
                    }
                    Iterator it4 = SodaPaymentsPresenter.this.f23302a.iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            obj4 = null;
                            break;
                        }
                        obj4 = it4.next();
                        if (((IGlobalCashierBaseViewBinder) obj4) instanceof IGlobalCashierCardChannelViewBinder) {
                            break;
                        }
                    }
                    IGlobalCashierBaseViewBinder iGlobalCashierBaseViewBinder4 = (IGlobalCashierBaseViewBinder) obj4;
                    if (!(iGlobalCashierBaseViewBinder4 instanceof IGlobalCashierCardChannelViewBinder)) {
                        iGlobalCashierBaseViewBinder4 = null;
                    }
                    IGlobalCashierCardChannelViewBinder iGlobalCashierCardChannelViewBinder3 = (IGlobalCashierCardChannelViewBinder) iGlobalCashierBaseViewBinder4;
                    if (iGlobalCashierCardChannelViewBinder3 != null) {
                        iGlobalCashierCardChannelViewBinder3.removeAllMethodSelect();
                    }
                    Iterator it5 = SodaPaymentsPresenter.this.f23302a.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            obj5 = null;
                            break;
                        }
                        obj5 = it5.next();
                        if (((IGlobalCashierBaseViewBinder) obj5) instanceof IGlobalCashierThirdChannelViewBinder) {
                            break;
                        }
                    }
                    IGlobalCashierBaseViewBinder iGlobalCashierBaseViewBinder5 = (IGlobalCashierBaseViewBinder) obj5;
                    if (iGlobalCashierBaseViewBinder5 instanceof IGlobalCashierThirdChannelViewBinder) {
                        iGlobalCashierThirdChannelViewBinder = iGlobalCashierBaseViewBinder5;
                    }
                    IGlobalCashierThirdChannelViewBinder iGlobalCashierThirdChannelViewBinder2 = iGlobalCashierThirdChannelViewBinder;
                    if (iGlobalCashierThirdChannelViewBinder2 != null) {
                        iGlobalCashierThirdChannelViewBinder2.removeAllMethodSelect();
                    }
                    SodaPaymentsPresenter.this.refreshPayMethodInfo(new ArrayList());
                }
            }
        }
    }
}
