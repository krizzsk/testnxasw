package com.didi.global.fintech.cashier.core.presenter;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.didi.global.fintech.cashier.core.action.GlobalCashierActionsHandler;
import com.didi.global.fintech.cashier.core.api.ICashier3DSProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierBaseProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierCVVProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierDialogProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierPayInfoProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierPolicyProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierResultProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierSyncStatusProcessor;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionInterceptCallback;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBaseView;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierNetPresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPayPresenter;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierPayView;
import com.didi.global.fintech.cashier.core.interceptor.BaseRouterAdapter;
import com.didi.global.fintech.cashier.core.interceptor.CashierActionInterceptor;
import com.didi.global.fintech.cashier.core.interceptor.PolicyRouterAdapter;
import com.didi.global.fintech.cashier.core.interceptor.RouterOpenInterceptor;
import com.didi.global.fintech.cashier.core.utils.CashierLog;
import com.didi.global.fintech.cashier.core.utils.PayInfoManager;
import com.didi.global.fintech.cashier.model.CashierError;
import com.didi.global.fintech.cashier.model.net.request.AgreePolicyRequest;
import com.didi.global.fintech.cashier.model.net.request.CVVCardInfo;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.request.GetCVVInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.GetPayInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.GetPayStatusRequest;
import com.didi.global.fintech.cashier.model.net.request.GetSuccessInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.PaymentThreeDSDetailsRequest;
import com.didi.global.fintech.cashier.model.net.request.PrepayRequest;
import com.didi.global.fintech.cashier.model.net.response.AgreePolicyResponse;
import com.didi.global.fintech.cashier.model.net.response.BasicPayment;
import com.didi.global.fintech.cashier.model.net.response.CVVInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.FailedInfo;
import com.didi.global.fintech.cashier.model.net.response.GlobalCashierAdyen3DSModel;
import com.didi.global.fintech.cashier.model.net.response.OrderInfo;
import com.didi.global.fintech.cashier.model.net.response.PayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.PayStatusResponse;
import com.didi.global.fintech.cashier.model.net.response.Payment;
import com.didi.global.fintech.cashier.model.net.response.PaymentGroup;
import com.didi.global.fintech.cashier.model.net.response.PaymentThreeDSDetailsResponse;
import com.didi.global.fintech.cashier.model.net.response.PolicyData;
import com.didi.global.fintech.cashier.model.net.response.PrepayResponse;
import com.didi.global.fintech.cashier.model.net.response.PriceAmount;
import com.didi.global.fintech.cashier.model.net.response.PriceInfo;
import com.didi.global.fintech.cashier.model.net.response.SuccessInfoResponse;
import com.didi.global.fintech.cashier.model.strategy.BaseStrategy;
import com.didi.global.fintech.cashier.model.strategy.PayInfoStrategy;
import com.didi.global.fintech.cashier.model.strategy.SyncStatusStrategy;
import com.didi.global.fintech.cashier.network.processor.GlobalCommonParamsProcessor;
import com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierDialogCommonConfig;
import com.didi.global.fintech.cashier.p118ui.omega.CashierOmegaUtils;
import com.didi.global.fintech.cashier.p118ui.omega.PubPageType;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.global.fintech.cashier.user.p119ut.CashierOmegaSDK;
import com.didi.global.fintech.cashier.user.p119ut.CashierUT;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.UiThreadHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.Constants;

@Metadata(mo148867d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\n\u0010{\u001a\u0004\u0018\u00010|H\u0016J\u0013\u0010}\u001a\u00020~2\t\u0010\u001a\u0005\u0018\u00010\u0001H\u0016J\u0015\u0010\u0001\u001a\u00020~2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\"\u0010\u0001\u001a\u0005\u0018\u0001H\u0001\"\u0005\b\u0000\u0010\u00012\u0007\u0010\u0001\u001a\u00020\u001aH\u0004¢\u0006\u0003\u0010\u0001J@\u0010\u0001\u001a\u00020~2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020c092\u001a\u0010\u0001\u001a\u0015\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020\u00130\u0001H\u0004J\t\u0010\u0001\u001a\u00020~H\u0016J-\u0010\u0001\u001a\u0005\u0018\u0001H\u0001\"\t\b\u0000\u0010\u0001*\u00020t2\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u0003H\u00010sH\u0004¢\u0006\u0003\u0010\u0001J\u0014\u0010\u0001\u001a\u00020~2\t\u0010\u0001\u001a\u0004\u0018\u00010&H\u0016J\t\u0010\u0001\u001a\u00020~H\u0016J\u0013\u0010\u0001\u001a\u00020~2\b\u0010\u0001\u001a\u00030\u0001H\u0004J\u0013\u0010\u0001\u001a\u00020~2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\t\u0010\u0001\u001a\u00020~H\u0016J\u0013\u0010\u0001\u001a\u00020~2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u001d\u0010\u0001\u001a\u00020~2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010\u0001\u001a\u00020~2\b\u0010\u0001\u001a\u00030 \u0001H\u0016J\u0013\u0010¡\u0001\u001a\u00020~2\b\u0010\u0001\u001a\u00030¢\u0001H\u0016J\u001d\u0010£\u0001\u001a\u00020~2\b\u0010¤\u0001\u001a\u00030\u00012\b\u0010¥\u0001\u001a\u00030¦\u0001H\u0016J\u0013\u0010§\u0001\u001a\u00020~2\b\u0010\u0001\u001a\u00030¨\u0001H\u0016J\u0013\u0010©\u0001\u001a\u00020~2\b\u0010\u0001\u001a\u00030ª\u0001H\u0016J\u0019\u0010«\u0001\u001a\u00020~2\u000e\u0010¬\u0001\u001a\t\u0012\u0004\u0012\u00020:0­\u0001H\u0016J#\u0010®\u0001\u001a\u00020~2\u0007\u0010¯\u0001\u001a\u00020t2\u000f\u0010\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020t0sH\u0004J\u0013\u0010°\u0001\u001a\u00020~2\b\u0010±\u0001\u001a\u00030²\u0001H\u0016J\u0015\u0010³\u0001\u001a\u00020~2\n\u0010´\u0001\u001a\u0005\u0018\u00010µ\u0001H\u0016J\u0013\u0010¶\u0001\u001a\u00020~2\b\u0010·\u0001\u001a\u00030¸\u0001H\u0016J\u0012\u0010¹\u0001\u001a\u00020~2\u0007\u0010º\u0001\u001a\u00020ZH\u0016J\t\u0010»\u0001\u001a\u00020~H\u0016J\u0012\u0010¼\u0001\u001a\u00020~2\u0007\u0010º\u0001\u001a\u00020gH\u0016J\t\u0010½\u0001\u001a\u00020~H\u0016J\t\u0010¾\u0001\u001a\u00020\u001aH\u0016J\t\u0010¿\u0001\u001a\u00020~H\u0016J\t\u0010À\u0001\u001a\u00020~H\u0016J\u001f\u0010Á\u0001\u001a\u00020~2\t\u0010±\u0001\u001a\u0004\u0018\u00010m2\t\u0010Â\u0001\u001a\u0004\u0018\u00010\u001aH\u0016J\u0014\u0010Ã\u0001\u001a\u00020~2\t\u0010Ä\u0001\u001a\u0004\u0018\u00010\u001aH\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001eR\u001c\u0010.\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001eR&\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020302X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R \u00108\u001a\b\u0012\u0004\u0012\u00020:09X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001e\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u0010\n\u0002\u0010E\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u000e\u0010F\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010G\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\bH\u0010!\"\u0004\bI\u0010#R&\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020302X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u00105\"\u0004\bL\u00107R\u001c\u0010M\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u001c\"\u0004\bO\u0010\u001eR\u001c\u0010P\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u001c\"\u0004\bR\u0010\u001eR\u001c\u0010S\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u001c\"\u0004\bU\u0010\u001eR\u001c\u0010V\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u001c\"\u0004\bX\u0010\u001eR\u001a\u0010Y\u001a\u00020ZX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001c\u0010_\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u001c\"\u0004\ba\u0010\u001eR \u0010b\u001a\b\u0012\u0004\u0012\u00020c09X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010<\"\u0004\be\u0010>R\u001a\u0010f\u001a\u00020gX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u001c\u0010l\u001a\u0004\u0018\u00010mX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\"\u0010r\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020t0s\u0012\u0004\u0012\u00020t02X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010u\u001a\u0004\u0018\u00010vX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010z¨\u0006Å\u0001"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierPayPresenter;", "Lcom/didi/global/fintech/cashier/core/presenter/GlobalCashierNetPresenter;", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPayPresenter;", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "actionInterceptHandler", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionInterceptCallback;", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionInterceptCallback;)V", "getActionInterceptHandler", "()Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierActionInterceptCallback;", "actionInterceptor", "Lcom/didi/global/fintech/cashier/core/interceptor/CashierActionInterceptor;", "getActionInterceptor", "()Lcom/didi/global/fintech/cashier/core/interceptor/CashierActionInterceptor;", "setActionInterceptor", "(Lcom/didi/global/fintech/cashier/core/interceptor/CashierActionInterceptor;)V", "isBalanceSwitcher", "", "()Z", "setBalanceSwitcher", "(Z)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "mAppId", "", "getMAppId", "()Ljava/lang/String;", "setMAppId", "(Ljava/lang/String;)V", "mBoletoConfirm", "getMBoletoConfirm", "()Ljava/lang/Boolean;", "setMBoletoConfirm", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mCashierParam", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "getMCashierParam", "()Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "setMCashierParam", "(Lcom/didi/global/fintech/cashier/user/model/CashierParam;)V", "mCurrentCardIndex", "getMCurrentCardIndex", "setMCurrentCardIndex", "mCvv", "getMCvv", "setMCvv", "mExtraParams", "", "", "getMExtraParams", "()Ljava/util/Map;", "setMExtraParams", "(Ljava/util/Map;)V", "mExtraPayments", "", "Lcom/didi/global/fintech/cashier/model/net/response/BasicPayment;", "getMExtraPayments", "()Ljava/util/List;", "setMExtraPayments", "(Ljava/util/List;)V", "mInstallmentPlan", "", "getMInstallmentPlan", "()Ljava/lang/Integer;", "setMInstallmentPlan", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mIsDestroyed", "mIsInstallment", "getMIsInstallment", "setMIsInstallment", "mOmegaAttrs", "getMOmegaAttrs", "setMOmegaAttrs", "mOrderId", "getMOrderId", "setMOrderId", "mOutTradeId", "getMOutTradeId", "setMOutTradeId", "mPasswordToken", "getMPasswordToken", "setMPasswordToken", "mPayFeeTextDisplay", "getMPayFeeTextDisplay", "setMPayFeeTextDisplay", "mPayInfoStrategy", "Lcom/didi/global/fintech/cashier/model/strategy/PayInfoStrategy;", "getMPayInfoStrategy", "()Lcom/didi/global/fintech/cashier/model/strategy/PayInfoStrategy;", "setMPayInfoStrategy", "(Lcom/didi/global/fintech/cashier/model/strategy/PayInfoStrategy;)V", "mProductId", "getMProductId", "setMProductId", "mSelectPayments", "Lcom/didi/global/fintech/cashier/model/net/response/Payment;", "getMSelectPayments", "setMSelectPayments", "mSyncStatusStrategy", "Lcom/didi/global/fintech/cashier/model/strategy/SyncStatusStrategy;", "getMSyncStatusStrategy", "()Lcom/didi/global/fintech/cashier/model/strategy/SyncStatusStrategy;", "setMSyncStatusStrategy", "(Lcom/didi/global/fintech/cashier/model/strategy/SyncStatusStrategy;)V", "mThreeDSV2", "Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2;", "getMThreeDSV2", "()Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2;", "setMThreeDSV2", "(Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2;)V", "processors", "Ljava/lang/Class;", "Lcom/didi/global/fintech/cashier/core/api/ICashierBaseProcessor;", "routerInterceptor", "Lcom/didi/global/fintech/cashier/core/interceptor/RouterOpenInterceptor;", "getRouterInterceptor", "()Lcom/didi/global/fintech/cashier/core/interceptor/RouterOpenInterceptor;", "setRouterInterceptor", "(Lcom/didi/global/fintech/cashier/core/interceptor/RouterOpenInterceptor;)V", "IView", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierPayView;", "bindView", "", "view", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseView;", "doPay", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "getParamByName", "T", "name", "(Ljava/lang/String;)Ljava/lang/Object;", "getPaymentsFromPayInfo", "src", "Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "dst", "filter", "Lkotlin/Function2;", "getPolicy", "getProcessor", "clazz", "(Ljava/lang/Class;)Lcom/didi/global/fintech/cashier/core/api/ICashierBaseProcessor;", "init", "param", "initNet", "interceptPayInfo", "response", "onAgreePolicyResponse", "Lcom/didi/global/fintech/cashier/model/net/response/AgreePolicyResponse;", "onBind", "onCVVInfoResponse", "Lcom/didi/global/fintech/cashier/model/net/response/CVVInfoResponse;", "onPayInfoResponse", "API", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierNetPresenter$API;", "onPayStatusResponse", "Lcom/didi/global/fintech/cashier/model/net/response/PayStatusResponse;", "onPrePayResponse", "Lcom/didi/global/fintech/cashier/model/net/response/PrepayResponse;", "onRequestFailed", "api", "error", "Lcom/didi/global/fintech/cashier/model/CashierError;", "onSuccessInfoResponse", "Lcom/didi/global/fintech/cashier/model/net/response/SuccessInfoResponse;", "onThreeDSDetailsResponse", "Lcom/didi/global/fintech/cashier/model/net/response/PaymentThreeDSDetailsResponse;", "refreshPayInfo", "afterSelectPayment", "", "registerProcessor", "processor", "request3DSDetails", "data", "Lcom/didi/global/fintech/cashier/model/net/response/GlobalCashierAdyen3DSModel;", "requestCVVInfo", "cardInfo", "Lcom/didi/global/fintech/cashier/model/net/request/CVVCardInfo;", "requestConfirmPolicy", "agreePolicy", "Lcom/didi/global/fintech/cashier/model/net/response/PolicyData;", "requestPayInfo", "strategy", "requestSuccessInfo", "startSyncPayResult", "stopSyncPayResult", "syncStatusScene", "unBind", "updateBoletoConfirm", "updateCybs3DS", "cvv", "updatePasswordToken", "token", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierPayPresenter.kt */
public abstract class GlobalCashierPayPresenter extends GlobalCashierNetPresenter implements IGlobalCashierPayPresenter {

    /* renamed from: a */
    private final LifecycleOwner f23321a;

    /* renamed from: b */
    private final IGlobalCashierActionInterceptCallback f23322b;

    /* renamed from: c */
    private CashierActionInterceptor f23323c;

    /* renamed from: d */
    private RouterOpenInterceptor f23324d;

    /* renamed from: e */
    private PayInfoStrategy f23325e = new PayInfoStrategy(0, PayInfoStrategy.Companion.getNormal(), 1, (DefaultConstructorMarker) null);

    /* renamed from: f */
    private SyncStatusStrategy f23326f = new SyncStatusStrategy(0, 0, SyncStatusStrategy.Companion.getNormal(), 3, (DefaultConstructorMarker) null);

    /* renamed from: g */
    private String f23327g;

    /* renamed from: h */
    private String f23328h;

    /* renamed from: i */
    private Map<String, Object> f23329i = new LinkedHashMap();

    /* renamed from: j */
    private String f23330j;

    /* renamed from: k */
    private String f23331k;

    /* renamed from: l */
    private String f23332l;

    /* renamed from: m */
    private PrepayRequest.ThreeDSV2 f23333m;

    /* renamed from: n */
    private String f23334n;

    /* renamed from: o */
    private Boolean f23335o;

    /* renamed from: p */
    private List<Payment> f23336p = new ArrayList();

    /* renamed from: q */
    private List<BasicPayment> f23337q = new ArrayList();

    /* renamed from: r */
    private boolean f23338r;

    /* renamed from: s */
    private String f23339s;

    /* renamed from: t */
    private CashierParam f23340t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f23341u;

    /* renamed from: v */
    private Boolean f23342v;

    /* renamed from: w */
    private Integer f23343w;

    /* renamed from: x */
    private Map<String, Object> f23344x = new LinkedHashMap();

    /* renamed from: y */
    private String f23345y;

    /* renamed from: z */
    private Map<Class<? extends ICashierBaseProcessor>, ICashierBaseProcessor> f23346z = new LinkedHashMap();

    @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: GlobalCashierPayPresenter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BaseStrategy.Result.values().length];
            iArr[BaseStrategy.Result.SUCCESS.ordinal()] = 1;
            iArr[BaseStrategy.Result.CONTINUE.ordinal()] = 2;
            iArr[BaseStrategy.Result.FAILED.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: protected */
    public final LifecycleOwner getLifecycleOwner() {
        return this.f23321a;
    }

    /* access modifiers changed from: protected */
    public final IGlobalCashierActionInterceptCallback getActionInterceptHandler() {
        return this.f23322b;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalCashierPayPresenter(Context context, LifecycleOwner lifecycleOwner, IGlobalCashierActionInterceptCallback iGlobalCashierActionInterceptCallback) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.f23321a = lifecycleOwner;
        this.f23322b = iGlobalCashierActionInterceptCallback;
    }

    public String syncStatusScene() {
        return IGlobalCashierPayPresenter.SyncStatusScene.PAY.name();
    }

    /* access modifiers changed from: protected */
    public final CashierActionInterceptor getActionInterceptor() {
        return this.f23323c;
    }

    /* access modifiers changed from: protected */
    public final void setActionInterceptor(CashierActionInterceptor cashierActionInterceptor) {
        this.f23323c = cashierActionInterceptor;
    }

    /* access modifiers changed from: protected */
    public final RouterOpenInterceptor getRouterInterceptor() {
        return this.f23324d;
    }

    /* access modifiers changed from: protected */
    public final void setRouterInterceptor(RouterOpenInterceptor routerOpenInterceptor) {
        this.f23324d = routerOpenInterceptor;
    }

    /* access modifiers changed from: protected */
    public final PayInfoStrategy getMPayInfoStrategy() {
        return this.f23325e;
    }

    /* access modifiers changed from: protected */
    public final void setMPayInfoStrategy(PayInfoStrategy payInfoStrategy) {
        Intrinsics.checkNotNullParameter(payInfoStrategy, "<set-?>");
        this.f23325e = payInfoStrategy;
    }

    /* access modifiers changed from: protected */
    public final SyncStatusStrategy getMSyncStatusStrategy() {
        return this.f23326f;
    }

    /* access modifiers changed from: protected */
    public final void setMSyncStatusStrategy(SyncStatusStrategy syncStatusStrategy) {
        Intrinsics.checkNotNullParameter(syncStatusStrategy, "<set-?>");
        this.f23326f = syncStatusStrategy;
    }

    /* access modifiers changed from: protected */
    public final String getMOutTradeId() {
        return this.f23327g;
    }

    /* access modifiers changed from: protected */
    public final void setMOutTradeId(String str) {
        this.f23327g = str;
    }

    /* access modifiers changed from: protected */
    public final String getMAppId() {
        return this.f23328h;
    }

    /* access modifiers changed from: protected */
    public final void setMAppId(String str) {
        this.f23328h = str;
    }

    /* access modifiers changed from: protected */
    public final Map<String, Object> getMExtraParams() {
        return this.f23329i;
    }

    /* access modifiers changed from: protected */
    public final void setMExtraParams(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.f23329i = map;
    }

    /* access modifiers changed from: protected */
    public final String getMProductId() {
        return this.f23330j;
    }

    /* access modifiers changed from: protected */
    public final void setMProductId(String str) {
        this.f23330j = str;
    }

    /* access modifiers changed from: protected */
    public final String getMOrderId() {
        return this.f23331k;
    }

    /* access modifiers changed from: protected */
    public final void setMOrderId(String str) {
        this.f23331k = str;
    }

    /* access modifiers changed from: protected */
    public final String getMPasswordToken() {
        return this.f23332l;
    }

    /* access modifiers changed from: protected */
    public final void setMPasswordToken(String str) {
        this.f23332l = str;
    }

    /* access modifiers changed from: protected */
    public final PrepayRequest.ThreeDSV2 getMThreeDSV2() {
        return this.f23333m;
    }

    /* access modifiers changed from: protected */
    public final void setMThreeDSV2(PrepayRequest.ThreeDSV2 threeDSV2) {
        this.f23333m = threeDSV2;
    }

    /* access modifiers changed from: protected */
    public final String getMCvv() {
        return this.f23334n;
    }

    /* access modifiers changed from: protected */
    public final void setMCvv(String str) {
        this.f23334n = str;
    }

    /* access modifiers changed from: protected */
    public final Boolean getMBoletoConfirm() {
        return this.f23335o;
    }

    /* access modifiers changed from: protected */
    public final void setMBoletoConfirm(Boolean bool) {
        this.f23335o = bool;
    }

    /* access modifiers changed from: protected */
    public final List<Payment> getMSelectPayments() {
        return this.f23336p;
    }

    /* access modifiers changed from: protected */
    public final void setMSelectPayments(List<Payment> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f23336p = list;
    }

    /* access modifiers changed from: protected */
    public final List<BasicPayment> getMExtraPayments() {
        return this.f23337q;
    }

    /* access modifiers changed from: protected */
    public final void setMExtraPayments(List<BasicPayment> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f23337q = list;
    }

    /* access modifiers changed from: protected */
    public final boolean isBalanceSwitcher() {
        return this.f23338r;
    }

    /* access modifiers changed from: protected */
    public final void setBalanceSwitcher(boolean z) {
        this.f23338r = z;
    }

    /* access modifiers changed from: protected */
    public final String getMPayFeeTextDisplay() {
        return this.f23339s;
    }

    /* access modifiers changed from: protected */
    public final void setMPayFeeTextDisplay(String str) {
        this.f23339s = str;
    }

    /* access modifiers changed from: protected */
    public final CashierParam getMCashierParam() {
        return this.f23340t;
    }

    /* access modifiers changed from: protected */
    public final void setMCashierParam(CashierParam cashierParam) {
        this.f23340t = cashierParam;
    }

    /* access modifiers changed from: protected */
    public final Boolean getMIsInstallment() {
        return this.f23342v;
    }

    /* access modifiers changed from: protected */
    public final void setMIsInstallment(Boolean bool) {
        this.f23342v = bool;
    }

    /* access modifiers changed from: protected */
    public final Integer getMInstallmentPlan() {
        return this.f23343w;
    }

    /* access modifiers changed from: protected */
    public final void setMInstallmentPlan(Integer num) {
        this.f23343w = num;
    }

    /* access modifiers changed from: protected */
    public final Map<String, Object> getMOmegaAttrs() {
        return this.f23344x;
    }

    /* access modifiers changed from: protected */
    public final void setMOmegaAttrs(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.f23344x = map;
    }

    /* access modifiers changed from: protected */
    public final String getMCurrentCardIndex() {
        return this.f23345y;
    }

    /* access modifiers changed from: protected */
    public final void setMCurrentCardIndex(String str) {
        this.f23345y = str;
    }

    /* access modifiers changed from: protected */
    public final void registerProcessor(ICashierBaseProcessor iCashierBaseProcessor, Class<? extends ICashierBaseProcessor> cls) {
        Intrinsics.checkNotNullParameter(iCashierBaseProcessor, Constants.BUNDLE_NATIVECODE_PROCESSOR);
        Intrinsics.checkNotNullParameter(cls, "clazz");
        this.f23346z.put(cls, iCashierBaseProcessor);
    }

    /* access modifiers changed from: protected */
    public final <T extends ICashierBaseProcessor> T getProcessor(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        T t = this.f23346z.get(cls);
        if (t instanceof ICashierBaseProcessor) {
            return (ICashierBaseProcessor) t;
        }
        return null;
    }

    public void init(CashierParam cashierParam) {
        Map<String, Object> omegaAttrs;
        Map<String, Object> extraParams;
        String str = null;
        this.f23327g = cashierParam == null ? null : cashierParam.getOutTradeId();
        this.f23340t = cashierParam;
        if (cashierParam != null) {
            str = cashierParam.getAppId();
        }
        this.f23328h = str;
        if (!(cashierParam == null || (extraParams = cashierParam.getExtraParams()) == null)) {
            getMExtraParams().putAll(extraParams);
        }
        if (!(cashierParam == null || (omegaAttrs = cashierParam.getOmegaAttrs()) == null)) {
            getMOmegaAttrs().putAll(omegaAttrs);
        }
        initNet();
        CashierOmegaUtils.Companion.setOutTradeId(this.f23327g);
        CashierOmegaUtils.Companion.setUid(CashierFacade.Companion.getInstance().getInitConfig().getUid());
        CashierOmegaUtils.Companion.setPubPage(PubPageType.CHECKOUT.getType());
        this.f23321a.getLifecycle().addObserver(new GlobalCashierPayPresenter$init$3(this));
    }

    public void initNet() {
        setParamsProcessor(new GlobalCommonParamsProcessor(getUniqueId(), getFromType()));
    }

    public void onBind() {
        this.f23323c = new CashierActionInterceptor(getUniqueId());
        this.f23324d = new RouterOpenInterceptor(getUniqueId());
    }

    /* access modifiers changed from: protected */
    public final <T> T getParamByName(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        try {
            Map<String, Object> map = this.f23329i;
            if (map == null) {
                return null;
            }
            return map.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public void unBind() {
        super.unBind();
        GlobalCashierActionsHandler.INSTANCE.onDestroy();
    }

    public void updatePasswordToken(String str) {
        this.f23332l = str;
        doPay((CashierAction) null);
    }

    public void updateBoletoConfirm() {
        this.f23335o = true;
        doPay((CashierAction) null);
    }

    public void updateCybs3DS(PrepayRequest.ThreeDSV2 threeDSV2, String str) {
        this.f23333m = threeDSV2;
        this.f23334n = str;
        doPay((CashierAction) null);
    }

    public void bindView(IGlobalCashierBaseView iGlobalCashierBaseView) {
        super.bindView(iGlobalCashierBaseView);
        SystemUtils.log(4, "Arirus", "GlobalCashierPayPresenter bindView: ", (Throwable) null, "com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter", 159);
    }

    public void requestPayInfo(PayInfoStrategy payInfoStrategy) {
        Intrinsics.checkNotNullParameter(payInfoStrategy, "strategy");
        this.f23325e = payInfoStrategy;
        GetPayInfoRequest getPayInfoRequest = new GetPayInfoRequest((String) null, (String) null, (String) null, (String) null, (List) null, (String) null, 63, (DefaultConstructorMarker) null);
        getPayInfoRequest.setOut_trade_id(getMOutTradeId());
        CashierParam mCashierParam = getMCashierParam();
        String str = null;
        getPayInfoRequest.setSign(mCashierParam == null ? null : mCashierParam.getSign());
        CashierParam mCashierParam2 = getMCashierParam();
        getPayInfoRequest.setSign_type(mCashierParam2 == null ? null : mCashierParam2.getSignType());
        CashierParam mCashierParam3 = getMCashierParam();
        if (mCashierParam3 != null) {
            str = mCashierParam3.getBizContent();
        }
        getPayInfoRequest.setBiz_content(str);
        Unit unit = Unit.INSTANCE;
        getPayInfo(getPayInfoRequest);
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) getProcessor(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            ICashierOperateProcessor.DefaultImpls.loading$default(iCashierOperateProcessor, false, 0, 2, (Object) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void refreshPayInfo(java.util.List<? extends com.didi.global.fintech.cashier.model.net.response.BasicPayment> r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "afterSelectPayment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            java.util.List<com.didi.global.fintech.cashier.model.net.response.Payment> r3 = r0.f23336p
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x0018:
            boolean r4 = r3.hasNext()
            r5 = 0
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r3.next()
            com.didi.global.fintech.cashier.model.net.response.Payment r4 = (com.didi.global.fintech.cashier.model.net.response.Payment) r4
            com.didi.global.fintech.cashier.model.net.response.Payment$InstallmentVo r6 = r4.getInstallment()
            if (r6 != 0) goto L_0x002d
        L_0x002b:
            r6 = r5
            goto L_0x0061
        L_0x002d:
            java.util.List r6 = r6.getSuggestPlans()
            if (r6 != 0) goto L_0x0034
            goto L_0x002b
        L_0x0034:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L_0x003a:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0057
            java.lang.Object r7 = r6.next()
            r8 = r7
            com.didi.global.fintech.cashier.model.net.response.Payment$InstallmentVo$PlansVo r8 = (com.didi.global.fintech.cashier.model.net.response.Payment.InstallmentVo.PlansVo) r8
            java.lang.Boolean r8 = r8.getSelected()
            r9 = 1
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 == 0) goto L_0x003a
            goto L_0x0058
        L_0x0057:
            r7 = r5
        L_0x0058:
            com.didi.global.fintech.cashier.model.net.response.Payment$InstallmentVo$PlansVo r7 = (com.didi.global.fintech.cashier.model.net.response.Payment.InstallmentVo.PlansVo) r7
            if (r7 != 0) goto L_0x005d
            goto L_0x002b
        L_0x005d:
            java.lang.Integer r6 = r7.getNumber()
        L_0x0061:
            java.lang.Integer r7 = r4.getChannelId()
            if (r6 == 0) goto L_0x0081
            com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo r8 = new com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo
            r9 = 3
            r8.<init>(r5, r5, r9, r5)
            com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo r4 = r4.getExtraInfo()
            if (r4 != 0) goto L_0x0074
            goto L_0x0078
        L_0x0074:
            java.lang.String r5 = r4.getCardIndex()
        L_0x0078:
            r8.setCardIndex(r5)
            r8.setInstallmentNumber(r6)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L_0x0085
        L_0x0081:
            com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo r8 = r4.getExtraInfo()
        L_0x0085:
            com.didi.global.fintech.cashier.model.net.response.BasicPayment r4 = new com.didi.global.fintech.cashier.model.net.response.BasicPayment
            r4.<init>(r7, r8)
            r2.add(r4)
            goto L_0x0018
        L_0x008e:
            java.util.List<com.didi.global.fintech.cashier.model.net.response.BasicPayment> r3 = r0.f23337q
            java.util.Collection r3 = (java.util.Collection) r3
            r2.addAll(r3)
            com.didi.global.fintech.cashier.model.net.request.ChangePayInfoRequest r3 = new com.didi.global.fintech.cashier.model.net.request.ChangePayInfoRequest
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 255(0xff, float:3.57E-43)
            r16 = 0
            r6 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            java.lang.String r4 = r17.getMOutTradeId()
            if (r4 != 0) goto L_0x00af
            java.lang.String r4 = ""
        L_0x00af:
            r3.setOut_trade_id(r4)
            java.util.List r4 = r3.getFrom_select()
            java.util.Collection r2 = (java.util.Collection) r2
            r4.addAll(r2)
            java.util.List r2 = r3.getTo_select()
            java.util.Collection r1 = (java.util.Collection) r1
            r2.addAll(r1)
            com.didi.global.fintech.cashier.model.strategy.PayInfoStrategy r1 = r17.getMPayInfoStrategy()
            kotlin.jvm.functions.Function2 r1 = r1.getAction()
            com.didi.global.fintech.cashier.model.strategy.PayInfoStrategy$Companion r2 = com.didi.global.fintech.cashier.model.strategy.PayInfoStrategy.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getDoPay()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x00db
            java.lang.String r5 = "pay_with_channel"
        L_0x00db:
            r3.setSelect_trigger(r5)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r0.changePayInfo(r3)
            java.lang.Class<com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor> r1 = com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor.class
            com.didi.global.fintech.cashier.core.api.ICashierBaseProcessor r1 = r0.getProcessor(r1)
            r2 = r1
            com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor r2 = (com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor) r2
            if (r2 != 0) goto L_0x00ef
            goto L_0x00f7
        L_0x00ef:
            r3 = 0
            r4 = 0
            r6 = 2
            r7 = 0
            com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor.DefaultImpls.loading$default(r2, r3, r4, r6, r7)
        L_0x00f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter.refreshPayInfo(java.util.List):void");
    }

    public void doPay(CashierAction cashierAction) {
        if (this.f23341u) {
            CashierLog.INSTANCE.mo68928i("GlobalCashierPayPresenter - cancel doPay because activity/fragment is destroyed");
            return;
        }
        CashierActionInterceptor cashierActionInterceptor = this.f23323c;
        if (cashierActionInterceptor != null) {
            CashierParam cashierParam = new CashierParam((String) null, (String) null, (String) null, (String) null, (Map) null, (Map) null, (String) null, 127, (DefaultConstructorMarker) null);
            cashierParam.setOutTradeId(getMOutTradeId());
            cashierParam.setNeedPayFeeTextDisplay(getMPayFeeTextDisplay());
            cashierParam.getOmegaAttrs().putAll(getMOmegaAttrs());
            cashierParam.setAppId(getMAppId());
            Unit unit = Unit.INSTANCE;
            cashierActionInterceptor.setCashierParam(cashierParam);
        }
        CashierActionInterceptor cashierActionInterceptor2 = this.f23323c;
        if (cashierActionInterceptor2 != null) {
            cashierActionInterceptor2.intercept(getContext(), this.f23321a, cashierAction, new GlobalCashierPayPresenter$doPay$2(this, cashierAction), new GlobalCashierPayPresenter$doPay$3(this));
        }
    }

    public void startSyncPayResult(SyncStatusStrategy syncStatusStrategy) {
        Intrinsics.checkNotNullParameter(syncStatusStrategy, "strategy");
        if (this.f23341u) {
            CashierLog.INSTANCE.mo68928i("GlobalCashierPayPresenter - cancel startSyncPayResult because activity/fragment is destroyed");
            return;
        }
        this.f23326f = syncStatusStrategy;
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) getProcessor(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            ICashierOperateProcessor.DefaultImpls.loading$default(iCashierOperateProcessor, false, 0, 2, (Object) null);
        }
        UiThreadHandler.postDelayed(new Runnable(syncStatusStrategy) {
            public final /* synthetic */ SyncStatusStrategy f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                GlobalCashierPayPresenter.m19153a(GlobalCashierPayPresenter.this, this.f$1);
            }
        }, ((long) this.f23326f.getInterval()) * 1000);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m19153a(GlobalCashierPayPresenter globalCashierPayPresenter, SyncStatusStrategy syncStatusStrategy) {
        Intrinsics.checkNotNullParameter(globalCashierPayPresenter, "this$0");
        Intrinsics.checkNotNullParameter(syncStatusStrategy, "$strategy");
        GetPayStatusRequest getPayStatusRequest = new GetPayStatusRequest(false, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
        getPayStatusRequest.setScene(globalCashierPayPresenter.syncStatusScene());
        String mOutTradeId = globalCashierPayPresenter.getMOutTradeId();
        if (mOutTradeId == null) {
            mOutTradeId = "";
        }
        getPayStatusRequest.setOut_trade_id(mOutTradeId);
        getPayStatusRequest.setFirst_polling(Intrinsics.areEqual((Object) syncStatusStrategy.getAction(), (Object) SyncStatusStrategy.Companion.getFastPay()));
        CashierParam mCashierParam = globalCashierPayPresenter.getMCashierParam();
        getPayStatusRequest.setBiz_device_info(mCashierParam == null ? null : mCashierParam.getBizDeviceInfo());
        Unit unit = Unit.INSTANCE;
        globalCashierPayPresenter.getPayStatus(getPayStatusRequest);
    }

    public void stopSyncPayResult() {
        this.f23326f.setSyncTimes(0);
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) getProcessor(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            iCashierOperateProcessor.dismissLoading();
        }
    }

    public void requestSuccessInfo() {
        GetSuccessInfoRequest getSuccessInfoRequest = new GetSuccessInfoRequest((String) null, 1, (DefaultConstructorMarker) null);
        String mOutTradeId = getMOutTradeId();
        if (mOutTradeId == null) {
            mOutTradeId = "";
        }
        getSuccessInfoRequest.setOut_trade_id(mOutTradeId);
        Unit unit = Unit.INSTANCE;
        getSuccessInfo(getSuccessInfoRequest);
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) getProcessor(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            ICashierOperateProcessor.DefaultImpls.loading$default(iCashierOperateProcessor, false, 0, 2, (Object) null);
        }
    }

    public void request3DSDetails(GlobalCashierAdyen3DSModel globalCashierAdyen3DSModel) {
        Intrinsics.checkNotNullParameter(globalCashierAdyen3DSModel, "data");
        PaymentThreeDSDetailsRequest paymentThreeDSDetailsRequest = new PaymentThreeDSDetailsRequest((String) null, 0, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
        paymentThreeDSDetailsRequest.setReference(globalCashierAdyen3DSModel.getReference());
        Integer channelId = globalCashierAdyen3DSModel.getChannelId();
        paymentThreeDSDetailsRequest.setChannel_id(channelId == null ? 150 : channelId.intValue());
        paymentThreeDSDetailsRequest.setVendor(globalCashierAdyen3DSModel.getVendor());
        paymentThreeDSDetailsRequest.setShopper(globalCashierAdyen3DSModel.getShopper());
        paymentThreeDSDetailsRequest.setAuth_details(globalCashierAdyen3DSModel.getAuth_details());
        Unit unit = Unit.INSTANCE;
        payment3DSDetails(paymentThreeDSDetailsRequest);
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) getProcessor(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            ICashierOperateProcessor.DefaultImpls.loading$default(iCashierOperateProcessor, false, 0, 2, (Object) null);
        }
    }

    public void requestCVVInfo(CVVCardInfo cVVCardInfo) {
        GetCVVInfoRequest getCVVInfoRequest = new GetCVVInfoRequest((String) null, (CVVCardInfo) null, 3, (DefaultConstructorMarker) null);
        getCVVInfoRequest.setOut_trade_id(getMOutTradeId());
        getCVVInfoRequest.setExtra_info(cVVCardInfo);
        Unit unit = Unit.INSTANCE;
        getCvvInfo(getCVVInfoRequest);
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) getProcessor(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            ICashierOperateProcessor.DefaultImpls.loading$default(iCashierOperateProcessor, false, 0, 2, (Object) null);
        }
    }

    public void getPolicy() {
        PayInfoResponse payInfo = PayInfoManager.getInstance().getPayInfo(getUniqueId());
        if (payInfo != null) {
            interceptPayInfo(payInfo);
        }
        ICashierPolicyProcessor iCashierPolicyProcessor = (ICashierPolicyProcessor) getProcessor(ICashierPolicyProcessor.class);
        if (iCashierPolicyProcessor != null) {
            iCashierPolicyProcessor.onShowPrivacyPolicy(payInfo);
        }
    }

    public void requestConfirmPolicy(PolicyData policyData) {
        Intrinsics.checkNotNullParameter(policyData, "agreePolicy");
        AgreePolicyRequest agreePolicyRequest = new AgreePolicyRequest((String) null, (Boolean) null, (PolicyData) null, 7, (DefaultConstructorMarker) null);
        agreePolicyRequest.setOut_trade_id(getMOutTradeId());
        agreePolicyRequest.setAgree(true);
        agreePolicyRequest.setPolicy_info(policyData);
        Unit unit = Unit.INSTANCE;
        agreePolicy(agreePolicyRequest);
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) getProcessor(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            ICashierOperateProcessor.DefaultImpls.loading$default(iCashierOperateProcessor, false, 0, 2, (Object) null);
        }
    }

    public void onAgreePolicyResponse(AgreePolicyResponse agreePolicyResponse) {
        Intrinsics.checkNotNullParameter(agreePolicyResponse, "response");
        ICashierPolicyProcessor iCashierPolicyProcessor = (ICashierPolicyProcessor) getProcessor(ICashierPolicyProcessor.class);
        if (iCashierPolicyProcessor != null) {
            iCashierPolicyProcessor.onPolicyProcess(agreePolicyResponse);
        }
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) getProcessor(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            iCashierOperateProcessor.dismissLoading();
        }
    }

    public void onPayInfoResponse(PayInfoResponse payInfoResponse, IGlobalCashierNetPresenter.API api) {
        Intrinsics.checkNotNullParameter(payInfoResponse, "response");
        Intrinsics.checkNotNullParameter(api, "API");
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) getProcessor(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            iCashierOperateProcessor.dismissLoading();
        }
        if (payInfoResponse.success()) {
            PayInfoManager.getInstance().setPayInfo(getUniqueId(), payInfoResponse);
            interceptPayInfo(payInfoResponse);
            RouterOpenInterceptor routerOpenInterceptor = this.f23324d;
            if (routerOpenInterceptor != null) {
                routerOpenInterceptor.intercept(getContext(), (BaseRouterAdapter<?>) new PolicyRouterAdapter(payInfoResponse.getPolicyInfo()), (Function0<Unit>[]) new Function0[]{new GlobalCashierPayPresenter$onPayInfoResponse$1(this), new GlobalCashierPayPresenter$onPayInfoResponse$2(this, payInfoResponse, api)});
                return;
            }
            return;
        }
        Integer failedType = payInfoResponse.getFailedType();
        if (failedType != null && failedType.intValue() == 2) {
            ICashierDialogProcessor iCashierDialogProcessor = (ICashierDialogProcessor) getProcessor(ICashierDialogProcessor.class);
            if (iCashierDialogProcessor != null) {
                iCashierDialogProcessor.appUpgrade();
                return;
            }
            return;
        }
        Integer failedType2 = payInfoResponse.getFailedType();
        if (failedType2 != null && failedType2.intValue() == 1) {
            ICashierDialogProcessor iCashierDialogProcessor2 = (ICashierDialogProcessor) getProcessor(ICashierDialogProcessor.class);
            if (iCashierDialogProcessor2 != null) {
                GlobalCashierDialogCommonConfig newIns = GlobalCashierDialogCommonConfig.Companion.newIns(GlobalCashierDialogCommonConfig.Companion.getCUSTOM_ERROR());
                newIns.setTitle(payInfoResponse.getFailedTitle());
                newIns.setSubTitle(payInfoResponse.getFailedReason());
                Unit unit = Unit.INSTANCE;
                iCashierDialogProcessor2.customError(newIns, api);
                return;
            }
            return;
        }
        ICashierDialogProcessor iCashierDialogProcessor3 = (ICashierDialogProcessor) getProcessor(ICashierDialogProcessor.class);
        if (iCashierDialogProcessor3 != null) {
            GlobalCashierDialogCommonConfig newIns2 = GlobalCashierDialogCommonConfig.Companion.newIns(GlobalCashierDialogCommonConfig.Companion.getCUSTOM_ERROR());
            newIns2.setTitle("当前错误未指定");
            newIns2.setSubTitle("当前错误未指定 这里需要翻译资源");
            Unit unit2 = Unit.INSTANCE;
            iCashierDialogProcessor3.customError(newIns2, api);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m19152a(GlobalCashierPayPresenter globalCashierPayPresenter, PayInfoResponse payInfoResponse, IGlobalCashierNetPresenter.API api) {
        ICashierPayInfoProcessor iCashierPayInfoProcessor = (ICashierPayInfoProcessor) globalCashierPayPresenter.getProcessor(ICashierPayInfoProcessor.class);
        if (iCashierPayInfoProcessor != null) {
            iCashierPayInfoProcessor.onPayInfoSuccess(globalCashierPayPresenter.f23325e, payInfoResponse, api);
        }
        CashierActionInterceptor cashierActionInterceptor = globalCashierPayPresenter.f23323c;
        if (cashierActionInterceptor != null) {
            CashierParam cashierParam = new CashierParam((String) null, (String) null, (String) null, (String) null, (Map) null, (Map) null, (String) null, 127, (DefaultConstructorMarker) null);
            cashierParam.setOutTradeId(globalCashierPayPresenter.getMOutTradeId());
            cashierParam.setNeedPayFeeTextDisplay(globalCashierPayPresenter.getMPayFeeTextDisplay());
            cashierParam.getOmegaAttrs().putAll(globalCashierPayPresenter.getMOmegaAttrs());
            cashierParam.setAppId(globalCashierPayPresenter.getMAppId());
            Unit unit = Unit.INSTANCE;
            cashierActionInterceptor.setCashierParam(cashierParam);
        }
        CashierActionInterceptor cashierActionInterceptor2 = globalCashierPayPresenter.f23323c;
        if (cashierActionInterceptor2 != null) {
            cashierActionInterceptor2.intercept(globalCashierPayPresenter.getContext(), globalCashierPayPresenter.f23321a, payInfoResponse.getInitAction(), new Function0[0]);
        }
        if (!Intrinsics.areEqual((Object) globalCashierPayPresenter.getMPayInfoStrategy().getAction(), (Object) PayInfoStrategy.Companion.getDoPay())) {
            globalCashierPayPresenter = null;
        }
        if (globalCashierPayPresenter != null) {
            globalCashierPayPresenter.setMPayInfoStrategy(new PayInfoStrategy(0, PayInfoStrategy.Companion.getNormal(), 1, (DefaultConstructorMarker) null));
            globalCashierPayPresenter.doPay((CashierAction) null);
        }
    }

    /* access modifiers changed from: protected */
    public final void interceptPayInfo(PayInfoResponse payInfoResponse) {
        List<Payment.InstallmentVo.PlansVo> suggestPlans;
        PriceAmount actualAmount;
        Intrinsics.checkNotNullParameter(payInfoResponse, "response");
        OrderInfo orderInfo = payInfoResponse.getOrderInfo();
        this.f23327g = orderInfo == null ? null : orderInfo.getOutTradeId();
        String str = this.f23328h;
        if (str == null) {
            OrderInfo orderInfo2 = payInfoResponse.getOrderInfo();
            str = orderInfo2 == null ? null : orderInfo2.getAppId();
        }
        this.f23328h = str;
        OrderInfo orderInfo3 = payInfoResponse.getOrderInfo();
        this.f23330j = orderInfo3 == null ? null : orderInfo3.getProductId();
        OrderInfo orderInfo4 = payInfoResponse.getOrderInfo();
        this.f23331k = orderInfo4 == null ? null : orderInfo4.getOrderId();
        PriceInfo priceInfo = payInfoResponse.getPriceInfo();
        this.f23339s = (priceInfo == null || (actualAmount = priceInfo.getActualAmount()) == null) ? null : actualAmount.getDisplay();
        CashierOmegaSDK.INSTANCE.updateGlobalAttrsFromApi(this.f23330j, this.f23331k, this.f23327g);
        CashierOmegaUtils.Companion companion = CashierOmegaUtils.Companion;
        String str2 = this.f23330j;
        String str3 = "";
        if (str2 == null) {
            str2 = str3;
        }
        companion.setProductId(str2);
        CashierOmegaUtils.Companion companion2 = CashierOmegaUtils.Companion;
        String str4 = this.f23328h;
        if (str4 == null) {
            str4 = str3;
        }
        companion2.setAppId(str4);
        CashierOmegaUtils.Companion companion3 = CashierOmegaUtils.Companion;
        String str5 = this.f23331k;
        if (str5 == null) {
            str5 = str3;
        }
        companion3.setOid(str5);
        CashierOmegaUtils.Companion companion4 = CashierOmegaUtils.Companion;
        String str6 = this.f23327g;
        if (str6 != null) {
            str3 = str6;
        }
        companion4.setOutTradeId(str3);
        CashierOmegaUtils.Companion companion5 = CashierOmegaUtils.Companion;
        OrderInfo orderInfo5 = payInfoResponse.getOrderInfo();
        companion5.setSequenceId(orderInfo5 == null ? null : orderInfo5.getSequenceId());
        RouterOpenInterceptor routerOpenInterceptor = this.f23324d;
        if (routerOpenInterceptor != null) {
            CashierParam insByOutTradeId = CashierParam.Companion.insByOutTradeId(this.f23327g);
            insByOutTradeId.getExtraParams().putAll(getMExtraParams());
            insByOutTradeId.getOmegaAttrs().putAll(getMOmegaAttrs());
            Unit unit = Unit.INSTANCE;
            routerOpenInterceptor.setCashierParam(insByOutTradeId);
        }
        CashierActionInterceptor cashierActionInterceptor = this.f23323c;
        if (cashierActionInterceptor != null) {
            CashierParam insByOutTradeId2 = CashierParam.Companion.insByOutTradeId(this.f23327g);
            insByOutTradeId2.getExtraParams().putAll(getMExtraParams());
            insByOutTradeId2.getOmegaAttrs().putAll(getMOmegaAttrs());
            insByOutTradeId2.setAppId(getMAppId());
            Unit unit2 = Unit.INSTANCE;
            cashierActionInterceptor.setCashierParam(insByOutTradeId2);
        }
        this.f23336p.clear();
        getPaymentsFromPayInfo(payInfoResponse, this.f23336p, new GlobalCashierPayPresenter$interceptPayInfo$3(this));
        Collection arrayList = new ArrayList();
        Iterator it = this.f23336p.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Payment payment = (Payment) next;
            Integer channelId = payment.getChannelId();
            if (channelId != null && channelId.intValue() == 150) {
                Payment.ExtraInfo extraInfo = payment.getExtraInfo();
                setMCurrentCardIndex(extraInfo == null ? null : extraInfo.getCardIndex());
            }
            Integer channelId2 = payment.getChannelId();
            if (channelId2 != null && channelId2.intValue() == 150) {
                Payment.InstallmentVo installment = payment.getInstallment();
                if (installment == null ? false : Intrinsics.areEqual((Object) installment.getSupport(), (Object) true)) {
                    z = true;
                }
            }
            if (z) {
                arrayList.add(next);
            }
        }
        List<Payment> list = (List) arrayList;
        if (!list.isEmpty()) {
            for (Payment payment2 : list) {
                Payment.InstallmentVo installment2 = payment2.getInstallment();
                setMIsInstallment(Boolean.valueOf(installment2 == null ? false : Intrinsics.areEqual((Object) installment2.getSupport(), (Object) true)));
                Payment.InstallmentVo installment3 = payment2.getInstallment();
                if (!(installment3 == null || (suggestPlans = installment3.getSuggestPlans()) == null)) {
                    for (Payment.InstallmentVo.PlansVo plansVo : suggestPlans) {
                        if (plansVo.isSelected()) {
                            setMInstallmentPlan(plansVo.getNumber());
                        }
                    }
                }
            }
        } else {
            this.f23342v = null;
            this.f23343w = null;
            this.f23345y = null;
        }
        this.f23337q.clear();
        List<BasicPayment> extraPayChannels = payInfoResponse.getExtraPayChannels();
        if (extraPayChannels != null) {
            getMExtraPayments().addAll(extraPayChannels);
        }
    }

    /* access modifiers changed from: protected */
    public final void getPaymentsFromPayInfo(PayInfoResponse payInfoResponse, List<Payment> list, Function2<? super Integer, ? super Payment, Boolean> function2) {
        List<PaymentGroup> paymentGroups;
        Intrinsics.checkNotNullParameter(list, "dst");
        Intrinsics.checkNotNullParameter(function2, "filter");
        if (payInfoResponse != null && (paymentGroups = payInfoResponse.getPaymentGroups()) != null) {
            for (PaymentGroup payments : paymentGroups) {
                List<Payment> payments2 = payments.getPayments();
                if (payments2 != null) {
                    int i = 0;
                    for (Object next : payments2) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (function2.invoke(Integer.valueOf(i), (Payment) next).booleanValue()) {
                            list.add(next);
                        }
                        i = i2;
                    }
                    List list2 = list;
                }
            }
        }
    }

    public void onPrePayResponse(PrepayResponse prepayResponse) {
        String productId;
        Intrinsics.checkNotNullParameter(prepayResponse, "response");
        CashierActionInterceptor cashierActionInterceptor = this.f23323c;
        if (cashierActionInterceptor != null) {
            CashierParam cashierParam = new CashierParam((String) null, (String) null, (String) null, (String) null, (Map) null, (Map) null, (String) null, 127, (DefaultConstructorMarker) null);
            cashierParam.setOutTradeId(getMOutTradeId());
            cashierParam.setNeedPayFeeTextDisplay(getMPayFeeTextDisplay());
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
            cashierActionInterceptor.setCashierParam(cashierParam);
        }
        CashierActionInterceptor cashierActionInterceptor2 = this.f23323c;
        if (cashierActionInterceptor2 != null) {
            cashierActionInterceptor2.intercept(getContext(), this.f23321a, prepayResponse.getNextStep(), new GlobalCashierPayPresenter$onPrePayResponse$2(this, prepayResponse), new GlobalCashierPayPresenter$onPrePayResponse$3(this, prepayResponse));
        }
    }

    public void onPayStatusResponse(PayStatusResponse payStatusResponse) {
        Intrinsics.checkNotNullParameter(payStatusResponse, "response");
        int i = WhenMappings.$EnumSwitchMapping$0[this.f23326f.handle(payStatusResponse).ordinal()];
        String str = null;
        if (i == 1) {
            PayInfoManager.getInstance().setPayStatus(getUniqueId(), payStatusResponse);
            ICashierSyncStatusProcessor iCashierSyncStatusProcessor = (ICashierSyncStatusProcessor) getProcessor(ICashierSyncStatusProcessor.class);
            if (iCashierSyncStatusProcessor != null) {
                iCashierSyncStatusProcessor.onSyncSuccess(payStatusResponse);
            }
            CashierUT cashierUT = CashierUT.INSTANCE;
            String payStatus = payStatusResponse.getPayStatus();
            FailedInfo failedInfo = payStatusResponse.getFailedInfo();
            Integer code = failedInfo == null ? null : failedInfo.getCode();
            FailedInfo failedInfo2 = payStatusResponse.getFailedInfo();
            if (failedInfo2 != null) {
                str = failedInfo2.getMessage();
            }
            cashierUT.trackPayStatusApiResultEn(payStatus, code, str);
        } else if (i == 2) {
            CashierActionInterceptor cashierActionInterceptor = this.f23323c;
            if (cashierActionInterceptor != null) {
                cashierActionInterceptor.intercept(getContext(), this.f23321a, payStatusResponse.getNextStep(), new GlobalCashierPayPresenter$onPayStatusResponse$1(this, payStatusResponse), new GlobalCashierPayPresenter$onPayStatusResponse$2(this));
            }
        } else if (i == 3) {
            ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) getProcessor(ICashierOperateProcessor.class);
            if (iCashierOperateProcessor != null) {
                iCashierOperateProcessor.dismissLoading();
            }
            ICashierSyncStatusProcessor iCashierSyncStatusProcessor2 = (ICashierSyncStatusProcessor) getProcessor(ICashierSyncStatusProcessor.class);
            if (iCashierSyncStatusProcessor2 != null) {
                iCashierSyncStatusProcessor2.onSyncFail(payStatusResponse);
            }
            CashierUT cashierUT2 = CashierUT.INSTANCE;
            String payStatus2 = payStatusResponse.getPayStatus();
            FailedInfo failedInfo3 = payStatusResponse.getFailedInfo();
            Integer code2 = failedInfo3 == null ? null : failedInfo3.getCode();
            FailedInfo failedInfo4 = payStatusResponse.getFailedInfo();
            if (failedInfo4 != null) {
                str = failedInfo4.getMessage();
            }
            cashierUT2.trackPayStatusApiResultEn(payStatus2, code2, str);
        }
    }

    public void onSuccessInfoResponse(SuccessInfoResponse successInfoResponse) {
        Intrinsics.checkNotNullParameter(successInfoResponse, "response");
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) getProcessor(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            iCashierOperateProcessor.dismissLoading();
        }
        ICashierResultProcessor iCashierResultProcessor = (ICashierResultProcessor) getProcessor(ICashierResultProcessor.class);
        if (iCashierResultProcessor != null) {
            iCashierResultProcessor.successInfoProcess(successInfoResponse);
        }
    }

    public void onThreeDSDetailsResponse(PaymentThreeDSDetailsResponse paymentThreeDSDetailsResponse) {
        Intrinsics.checkNotNullParameter(paymentThreeDSDetailsResponse, "response");
        ICashier3DSProcessor iCashier3DSProcessor = (ICashier3DSProcessor) getProcessor(ICashier3DSProcessor.class);
        if (iCashier3DSProcessor != null) {
            iCashier3DSProcessor.payment3DSDetailProcess(paymentThreeDSDetailsResponse);
        }
        CashierAction nextStep = paymentThreeDSDetailsResponse.getNextStep();
        GlobalCashierPayPresenter globalCashierPayPresenter = null;
        Integer threeDSResult = nextStep == null ? null : nextStep.threeDSResult();
        if (threeDSResult != null && threeDSResult.intValue() == 2) {
            CashierActionInterceptor cashierActionInterceptor = this.f23323c;
            if (cashierActionInterceptor != null) {
                cashierActionInterceptor.intercept(getContext(), this.f23321a, paymentThreeDSDetailsResponse.getNextStep(), new GlobalCashierPayPresenter$onThreeDSDetailsResponse$1(this));
            }
        } else if (threeDSResult != null && threeDSResult.intValue() == 1) {
            GlobalCashierPayPresenter globalCashierPayPresenter2 = this;
            if (Intrinsics.areEqual((Object) paymentThreeDSDetailsResponse.getNeedPollingResult(), (Object) true)) {
                globalCashierPayPresenter = this;
            }
            GlobalCashierPayPresenter globalCashierPayPresenter3 = globalCashierPayPresenter;
            if (globalCashierPayPresenter3 != null) {
                Integer pollingTimes = paymentThreeDSDetailsResponse.getPollingTimes();
                int intValue = pollingTimes == null ? 10 : pollingTimes.intValue();
                Integer pollingFrequency = paymentThreeDSDetailsResponse.getPollingFrequency();
                globalCashierPayPresenter3.startSyncPayResult(new SyncStatusStrategy(intValue, pollingFrequency == null ? 3 : pollingFrequency.intValue(), SyncStatusStrategy.Companion.getNormal()));
            }
        } else {
            ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) getProcessor(ICashierOperateProcessor.class);
            if (iCashierOperateProcessor != null) {
                iCashierOperateProcessor.dismissLoading();
            }
        }
    }

    public void onCVVInfoResponse(CVVInfoResponse cVVInfoResponse) {
        Intrinsics.checkNotNullParameter(cVVInfoResponse, "response");
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) getProcessor(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            iCashierOperateProcessor.dismissLoading();
        }
        ICashierCVVProcessor iCashierCVVProcessor = (ICashierCVVProcessor) getProcessor(ICashierCVVProcessor.class);
        if (iCashierCVVProcessor != null) {
            iCashierCVVProcessor.onCvvInfoSuccess(cVVInfoResponse);
        }
    }

    public void onRequestFailed(IGlobalCashierNetPresenter.API api, CashierError cashierError) {
        ICashier3DSProcessor iCashier3DSProcessor;
        IGlobalCashierNetPresenter.API api2 = api;
        CashierError cashierError2 = cashierError;
        Intrinsics.checkNotNullParameter(api2, "api");
        Intrinsics.checkNotNullParameter(cashierError2, "error");
        ICashierOperateProcessor iCashierOperateProcessor = (ICashierOperateProcessor) getProcessor(ICashierOperateProcessor.class);
        if (iCashierOperateProcessor != null) {
            iCashierOperateProcessor.dismissLoading();
        }
        ICashierDialogProcessor iCashierDialogProcessor = (ICashierDialogProcessor) getProcessor(ICashierDialogProcessor.class);
        if (iCashierDialogProcessor != null) {
            iCashierDialogProcessor.netError(cashierError2, api2);
        }
        GlobalCashierPayPresenter globalCashierPayPresenter = this;
        GlobalCashierPayPresenter globalCashierPayPresenter2 = api2 == IGlobalCashierNetPresenter.API.PAYMENT_3DS_DETAILS ? this : null;
        if (!(globalCashierPayPresenter2 == null || (iCashier3DSProcessor = (ICashier3DSProcessor) globalCashierPayPresenter2.getProcessor(ICashier3DSProcessor.class)) == null)) {
            iCashier3DSProcessor.payment3DSDetailProcess(new PaymentThreeDSDetailsResponse((Boolean) null, (Integer) null, (Integer) null, (CashierAction) null, 15, (DefaultConstructorMarker) null));
        }
        CashierUT.trackNetError$default(CashierUT.INSTANCE, api.name(), Integer.valueOf(cashierError.getCode()), cashierError.getMessage(), 0, 8, (Object) null);
    }

    public IGlobalCashierPayView IView() {
        IGlobalCashierBaseView mView = getMView();
        if (mView instanceof IGlobalCashierPayView) {
            return (IGlobalCashierPayView) mView;
        }
        return null;
    }
}
