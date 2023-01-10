package com.didi.soda.bill.manager;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.global.fintech.cashier.soda.utils.SodaConsts;
import com.didi.global.fintech.cashier.user.facade.SodaPayResult;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.global.fintech.cashier.user.model.GPayMethodItem;
import com.didi.soda.bill.BillEventToJS;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.fintech.BillFintechHelper;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.biz.popdialog.natived.PopDialogHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.NAPopUpParamsEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.PayBizParamEntity;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.SceneParamsEntity;
import com.didi.soda.customer.foundation.storage.ServerConfigStorage;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerCartManager;
import com.didi.soda.manager.base.ICustomerOrderManager;
import com.didi.soda.manager.base.ICustomerPayManager;
import com.didi.soda.order.flutterpage.OrderPage;
import com.didi.soda.order.manager.OrderStatusHandleRepo;
import com.didi.soda.router.DiRouter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p218io.flutter.embedding.android.BaseNachoSkeletonPage;
import p218io.flutter.embedding.android.registry.NFlutterContainerRegistry;

@Metadata(mo148867d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0002J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010 \u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010!\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\"\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010#\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u0016H\u0002J*\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010+\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010,\u001a\u00020\u000f2\b\u0010-\u001a\u0004\u0018\u00010\u0011H\u0002R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006."}, mo148868d2 = {"Lcom/didi/soda/bill/manager/CreateOrderPayHandlerV2;", "Lcom/didi/soda/bill/manager/AbsCreateOrderPayHandler;", "Lcom/didi/app/nova/skeleton/IScopeLifecycle;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "receiver", "Landroid/content/BroadcastReceiver;", "getReceiver", "()Landroid/content/BroadcastReceiver;", "setReceiver", "(Landroid/content/BroadcastReceiver;)V", "getTimeout", "", "goOrderPage", "", "orderId", "", "isPaying", "", "goPay", "outerState", "Lcom/didi/soda/bill/manager/CreateOrderState;", "order", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderInfoEntity;", "onCreate", "live", "Lcom/didi/app/nova/skeleton/ILive;", "onDestroy", "onFailed", "payResult", "Lcom/didi/global/fintech/cashier/user/facade/SodaPayResult;", "onPause", "onResume", "onStart", "onStop", "onSuccess", "onTimeout", "state", "payButtonFail", "businessId", "code", "msg", "payButtonSuccess", "syncCart", "shopId", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CreateOrderPayHandlerV2.kt */
public final class CreateOrderPayHandlerV2 extends AbsCreateOrderPayHandler implements IScopeLifecycle {

    /* renamed from: a */
    private BroadcastReceiver f41734a;

    public void onCreate(ILive iLive) {
    }

    public void onPause(ILive iLive) {
    }

    public void onResume(ILive iLive) {
    }

    public void onStart(ILive iLive) {
    }

    public void onStop(ILive iLive) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CreateOrderPayHandlerV2(ScopeContext scopeContext) {
        super(scopeContext);
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        getMScopeContext().addObserver(this);
    }

    public final BroadcastReceiver getReceiver() {
        return this.f41734a;
    }

    public final void setReceiver(BroadcastReceiver broadcastReceiver) {
        this.f41734a = broadcastReceiver;
    }

    public void goPay(CreateOrderState createOrderState, OrderInfoEntity orderInfoEntity) {
        Intrinsics.checkNotNullParameter(createOrderState, "outerState");
        Intrinsics.checkNotNullParameter(orderInfoEntity, "order");
        if (orderInfoEntity.isAutoPay == 1) {
            m31416a(orderInfoEntity);
            NAPopUpParamsEntity nAPopUpParamsEntity = new NAPopUpParamsEntity();
            nAPopUpParamsEntity.position = 2;
            nAPopUpParamsEntity.popUpExtEntity.orderId = orderInfoEntity.orderId;
            PopDialogHelper.triggerNAPopFetch(nAPopUpParamsEntity);
            LogUtil.m32588i(CreateOrderPayHandler.TAG, "goPay -> order.isAutoPay");
            return;
        }
        BillOmegaHelper.Companion.traceBillSDKPay();
        BillOmegaHelper.Companion.traceBillSDKPayV2();
        LogUtil.m32588i(CreateOrderPayHandler.TAG, "goPay -> getPayStatus");
        CashierParam.Companion companion = CashierParam.Companion;
        String str = orderInfoEntity.transId;
        if (str == null) {
            str = "";
        }
        List<GPayMethodItem> list = null;
        CashierParam build$default = CashierParam.Companion.build$default(companion, str, (Function1) null, 2, (Object) null);
        build$default.setMaxPayWaitTime(Integer.valueOf(m31412a()));
        build$default.setSelectedItems(new ArrayList());
        List<GPayMethodItem> selectedItems = build$default.getSelectedItems();
        if (selectedItems != null) {
            PayChannelEntity payChannelEntity = orderInfoEntity.payChannel;
            if (payChannelEntity != null) {
                list = payChannelEntity.userSelect;
            }
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            selectedItems.addAll(list);
        }
        build$default.setBizDeviceInfo(GsonUtil.toJson(PayBizParamEntity.Companion.createEntity()));
        build$default.setProductId("601");
        build$default.setAppId("50032");
        build$default.getOmegaAttrs().put("resource_id", BillFintechHelper.Companion.getPayResource());
        build$default.setUseSodaRandomVerify(true);
        BillFintechHelper.Companion.doPay(104, build$default);
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(GlobalContext.getContext());
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(GlobalContext.getContext())");
        BroadcastReceiver broadcastReceiver = this.f41734a;
        if (broadcastReceiver != null) {
            instance.unregisterReceiver(broadcastReceiver);
        }
        BroadcastReceiver createOrderPayHandlerV2$goPay$2 = new CreateOrderPayHandlerV2$goPay$2(instance, this, orderInfoEntity, createOrderState);
        this.f41734a = createOrderPayHandlerV2$goPay$2;
        if (createOrderPayHandlerV2$goPay$2 != null) {
            instance.registerReceiver(createOrderPayHandlerV2$goPay$2, new IntentFilter(SodaConsts.ACTION_CASHIER_PAY_RESULT));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31416a(OrderInfoEntity orderInfoEntity) {
        ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).requestOrderLayoutById(getMScopeContext(), orderInfoEntity.orderId, 0, new CreateOrderPayHandlerV2$onSuccess$1(orderInfoEntity, this));
    }

    /* renamed from: a */
    private final int m31412a() {
        int i = ((ServerConfigStorage) SingletonFactory.get(ServerConfigStorage.class)).getData() != null ? ((ServerConfigStorage) SingletonFactory.get(ServerConfigStorage.class)).getData().payTimeout : 0;
        if (i <= 0) {
            return 7;
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31413a(SodaPayResult sodaPayResult, OrderInfoEntity orderInfoEntity) {
        OrderInfoEntity orderInfoEntity2 = orderInfoEntity;
        int errCode = sodaPayResult.getErrCode();
        String errMsg = sodaPayResult.getErrMsg();
        String str = orderInfoEntity2.shopId;
        Intrinsics.checkNotNullExpressionValue(str, "order.shopId");
        String str2 = orderInfoEntity2.orderId;
        Intrinsics.checkNotNullExpressionValue(str2, "order.orderId");
        m31418a(str, errCode, errMsg, str2);
        ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_CART_PAY_ERROR).addErrorType(String.valueOf(errCode)).addModuleName(ErrorConst.ModuleName.CART).addErrorMsg(sodaPayResult.getSystem()).build().trackError();
        ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_CART_PAY_ERROR_V2).addErrorType(String.valueOf(errCode)).addModuleName(ErrorConst.ModuleName.CART).addErrorMsg(sodaPayResult.getSystem()).build().trackError();
        ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_M_CART_PAY_ERROR_CALLBACK).addErrorType(String.valueOf(errCode)).addModuleName(ErrorConst.ModuleName.CART).addErrorMsg(sodaPayResult.getSystem()).build().trackError();
        LogUtil.m32588i(CreateOrderPayHandler.TAG, "payFailed -> errorCode: " + errCode + " orderId: " + orderInfoEntity2.orderId);
        SceneParamsEntity sceneParamsEntity = new SceneParamsEntity();
        sceneParamsEntity.setCode(sodaPayResult.getErrCode());
        sceneParamsEntity.setSystem(sodaPayResult.getSystem());
        sceneParamsEntity.setCardSuffix(orderInfoEntity2.cardSuffix);
        new OrderStatusHandleRepo().cancelOrder(orderInfoEntity2.orderId, String.valueOf(errCode), new CreateOrderPayHandlerV2$onFailed$1(this, orderInfoEntity2, sceneParamsEntity));
        BillOmegaHelper.Companion.showPayFail(orderInfoEntity2.shopId, orderInfoEntity2.orderId, Integer.valueOf(errCode), errMsg, 1);
        BillEventToJS.triggerEvent$default(BillEventToJS.INSTANCE, 7, (Integer) null, (String) null, (IEntity) null, 14, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31415a(CreateOrderState createOrderState) {
        OrderInfoEntity order = createOrderState.getOrder();
        String preOrderId = createOrderState.getPreOrderId();
        if (order == null || TextUtils.isEmpty(order.orderId)) {
            BillOmegaHelper.Companion.orderTimeoutTech(1);
        } else {
            preOrderId = order.orderId;
            BillOmegaHelper.Companion.orderTimeoutTech(2);
        }
        Object object = getMScopeContext().getObject("pay_callback");
        if (object != null) {
            ((ICustomerPayManager.CartPayButtonCallback) object).hideLoading();
            CharSequence charSequence = preOrderId;
            if (!(charSequence == null || charSequence.length() == 0)) {
                m31420a(preOrderId, true);
            }
            getMScopeContext().getNavigator().finish();
            ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_CART_PAY_TIMEOUT).addModuleName(ErrorConst.ModuleName.CART).build().trackError();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.manager.base.ICustomerPayManager.CartPayButtonCallback");
    }

    /* renamed from: a */
    static /* synthetic */ void m31414a(CreateOrderPayHandlerV2 createOrderPayHandlerV2, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        createOrderPayHandlerV2.m31420a(str, z);
    }

    /* renamed from: a */
    private final void m31420a(String str, boolean z) {
        Map<String, WeakReference<BaseNachoSkeletonPage>> pageRegistry = NFlutterContainerRegistry.getPageRegistry();
        if (pageRegistry != null) {
            for (Map.Entry next : pageRegistry.entrySet()) {
                if (((WeakReference) next.getValue()).get() instanceof OrderPage) {
                    Object obj = ((WeakReference) next.getValue()).get();
                    if (obj != null) {
                        ((OrderPage) obj).hideOrderContainer();
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.order.flutterpage.OrderPage");
                    }
                }
            }
        }
        DiRouter.request().path("orderPage").putString("orderid", str).putInt("from", 2).putString("path", "/order_page").putBoolean("orderpaying", z).open();
        if (!TextUtils.isEmpty(str)) {
            NAPopUpParamsEntity nAPopUpParamsEntity = new NAPopUpParamsEntity();
            nAPopUpParamsEntity.position = 2;
            nAPopUpParamsEntity.popUpExtEntity.orderId = str;
            PopDialogHelper.triggerNAPopFetch(nAPopUpParamsEntity);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31417a(String str) {
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).fetchCartInfo(str);
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).triggerRefreshGlobalCartList();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31419a(String str, String str2) {
        Object object = getMScopeContext().getObject("pay_callback");
        if (object != null) {
            ((ICustomerPayManager.CartPayButtonCallback) object).success(str);
            BillOmegaHelper.Companion.uploadPayCallback(1, 0, "", str2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.manager.base.ICustomerPayManager.CartPayButtonCallback");
    }

    /* renamed from: a */
    private final void m31418a(String str, int i, String str2, String str3) {
        Object object = getMScopeContext().getObject("pay_callback");
        if (object != null) {
            ((ICustomerPayManager.CartPayButtonCallback) object).fail(str);
            BillOmegaHelper.Companion.uploadPayCallback(0, i, str2, str3);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.manager.base.ICustomerPayManager.CartPayButtonCallback");
    }

    public void onDestroy(ILive iLive) {
        BroadcastReceiver broadcastReceiver = this.f41734a;
        if (broadcastReceiver != null) {
            LocalBroadcastManager instance = LocalBroadcastManager.getInstance(GlobalContext.getContext());
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance(GlobalContext.getContext())");
            instance.unregisterReceiver(broadcastReceiver);
            setReceiver((BroadcastReceiver) null);
        }
    }
}
