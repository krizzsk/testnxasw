package com.didi.soda.bill.manager;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didi.soda.bill.BillEventToJS;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.biz.popdialog.natived.PopDialogHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.NAPopUpParamsEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.SceneParamsEntity;
import com.didi.soda.customer.foundation.storage.ServerConfigStorage;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerCartManager;
import com.didi.soda.manager.base.ICustomerPayManager;
import com.didi.soda.order.flutterpage.OrderPage;
import com.didi.soda.order.manager.OrderStatusHandleRepo;
import com.didi.soda.router.DiRouter;
import com.didi.trackupload.sdk.Constants;
import com.didi.universal.pay.biz.model.PayStatusModel;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p218io.flutter.embedding.android.BaseNachoSkeletonPage;
import p218io.flutter.embedding.android.registry.NFlutterContainerRegistry;

@Metadata(mo148867d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u00012\u00020\u0002:\u000201B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0002J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000bH\u0002J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J\u0012\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001c\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001e\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001f\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J*\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J4\u0010%\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u00122\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\u001e\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00162\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00100,H\u0016J\b\u0010-\u001a\u00020\u0010H\u0016J\u0012\u0010.\u001a\u00020\u00102\b\u0010/\u001a\u0004\u0018\u00010\u0012H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u00062"}, mo148868d2 = {"Lcom/didi/soda/bill/manager/CreateOrderPayHandler;", "Lcom/didi/soda/bill/manager/AbsCreateOrderPayHandler;", "Lcom/didi/app/nova/skeleton/IScopeLifecycle;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "mOrderEnity", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderInfoEntity;", "paypayCheckRunnable", "Ljava/lang/Runnable;", "thirdPayIng", "", "timeOutRunnable", "getTimeout", "", "goOrderPage", "", "orderId", "", "isPaying", "goPay", "outerState", "Lcom/didi/soda/bill/manager/CreateOrderState;", "order", "onCreate", "live", "Lcom/didi/app/nova/skeleton/ILive;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "payButtonFail", "businessId", "code", "msg", "payButtonSuccess", "payFailed", "statusModel", "Lcom/didi/universal/pay/biz/model/PayStatusModel;", "paySuccess", "startPayTimeout", "state", "timeout", "Lkotlin/Function0;", "stopPayTimeout", "syncCart", "shopId", "Companion", "InnerPayCallback", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CreateOrderPayHandler.kt */
public final class CreateOrderPayHandler extends AbsCreateOrderPayHandler implements IScopeLifecycle {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int PAY_INOF = 0;
    public static final int PRE_PAY = 1;
    public static final String TAG = "CreateOrderPayHandler";

    /* renamed from: a */
    private Runnable f41730a;

    /* renamed from: b */
    private Runnable f41731b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f41732c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OrderInfoEntity f41733d;

    public /* synthetic */ CreateOrderPayHandler(ScopeContext scopeContext, DefaultConstructorMarker defaultConstructorMarker) {
        this(scopeContext);
    }

    public void onCreate(ILive iLive) {
    }

    public void onStart(ILive iLive) {
    }

    public void onStop(ILive iLive) {
    }

    private CreateOrderPayHandler(ScopeContext scopeContext) {
        super(scopeContext);
        getMScopeContext().addObserver(this);
    }

    @Metadata(mo148867d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J$\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo148868d2 = {"Lcom/didi/soda/bill/manager/CreateOrderPayHandler$InnerPayCallback;", "Lcom/didi/soda/manager/base/ICustomerPayManager$PayCallback;", "type", "", "payParamEntity", "Lcom/didi/soda/manager/base/ICustomerPayManager$PayParamEntity;", "outerState", "Lcom/didi/soda/bill/manager/CreateOrderState;", "(Lcom/didi/soda/bill/manager/CreateOrderPayHandler;ILcom/didi/soda/manager/base/ICustomerPayManager$PayParamEntity;Lcom/didi/soda/bill/manager/CreateOrderState;)V", "callbackType", "orderState", "payParam", "onThirdPayStart", "", "channelId", "payFail", "code", "msg", "", "statusModel", "Lcom/didi/universal/pay/biz/model/PayStatusModel;", "paySucceed", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: CreateOrderPayHandler.kt */
    public final class InnerPayCallback implements ICustomerPayManager.PayCallback {
        private final int callbackType;
        private final CreateOrderState orderState;
        private final ICustomerPayManager.PayParamEntity payParam;
        final /* synthetic */ CreateOrderPayHandler this$0;

        public InnerPayCallback(CreateOrderPayHandler createOrderPayHandler, int i, ICustomerPayManager.PayParamEntity payParamEntity, CreateOrderState createOrderState) {
            Intrinsics.checkNotNullParameter(createOrderPayHandler, "this$0");
            Intrinsics.checkNotNullParameter(payParamEntity, "payParamEntity");
            Intrinsics.checkNotNullParameter(createOrderState, "outerState");
            this.this$0 = createOrderPayHandler;
            this.callbackType = i;
            this.payParam = payParamEntity;
            this.orderState = createOrderState;
        }

        public void payFail(int i, String str, PayStatusModel payStatusModel) {
            CreateOrderPayHandler createOrderPayHandler = this.this$0;
            CreateOrderState createOrderState = this.orderState;
            OrderInfoEntity access$getMOrderEnity$p = createOrderPayHandler.f41733d;
            if (access$getMOrderEnity$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOrderEnity");
                access$getMOrderEnity$p = null;
            }
            createOrderPayHandler.m31406a(createOrderState, access$getMOrderEnity$p, i, str, payStatusModel);
            if (this.callbackType == 1) {
                this.this$0.f41732c = false;
            }
        }

        public void onThirdPayStart(int i) {
            this.this$0.f41732c = true;
        }

        public void paySucceed() {
            if (this.callbackType == 1) {
                this.this$0.f41732c = false;
            }
            CreateOrderPayHandler createOrderPayHandler = this.this$0;
            OrderInfoEntity access$getMOrderEnity$p = createOrderPayHandler.f41733d;
            if (access$getMOrderEnity$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOrderEnity");
                access$getMOrderEnity$p = null;
            }
            createOrderPayHandler.m31407a(access$getMOrderEnity$p);
        }
    }

    public void goPay(CreateOrderState createOrderState, OrderInfoEntity orderInfoEntity) {
        Intrinsics.checkNotNullParameter(createOrderState, "outerState");
        Intrinsics.checkNotNullParameter(orderInfoEntity, "order");
        this.f41733d = orderInfoEntity;
        if (orderInfoEntity.isAutoPay == 1) {
            m31407a(orderInfoEntity);
            NAPopUpParamsEntity nAPopUpParamsEntity = new NAPopUpParamsEntity();
            nAPopUpParamsEntity.position = 2;
            nAPopUpParamsEntity.popUpExtEntity.orderId = orderInfoEntity.orderId;
            PopDialogHelper.triggerNAPopFetch(nAPopUpParamsEntity);
            LogUtil.m32588i(TAG, "goPay -> order.isAutoPay");
            return;
        }
        BillOmegaHelper.Companion.traceBillSDKPay();
        LogUtil.m32588i(TAG, "goPay -> getPayStatus");
        ICustomerPayManager.PayParamEntity payParamEntity = new ICustomerPayManager.PayParamEntity();
        payParamEntity.token = LoginUtil.getToken();
        payParamEntity.transId = orderInfoEntity.transId;
        payParamEntity.setOrderId(orderInfoEntity.orderId);
        ICustomerPayManager iCustomerPayManager = (ICustomerPayManager) CustomerManagerLoader.loadManager(ICustomerPayManager.class);
        Context context = GlobalContext.getContext();
        if (context != null) {
            iCustomerPayManager.getPayStatus((Activity) context, getMScopeContext(), payParamEntity, new InnerPayCallback(this, 0, payParamEntity, createOrderState));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31407a(OrderInfoEntity orderInfoEntity) {
        LogUtil.m32588i(TAG, Intrinsics.stringPlus("paySuccess -> orderId: ", orderInfoEntity.orderId));
        String str = orderInfoEntity.shopId;
        Intrinsics.checkNotNullExpressionValue(str, "order.shopId");
        String str2 = orderInfoEntity.orderId;
        Intrinsics.checkNotNullExpressionValue(str2, "order.orderId");
        m31410a(str, str2);
        BillEventToJS.triggerEvent$default(BillEventToJS.INSTANCE, 6, (Integer) null, (String) null, (IEntity) null, 14, (Object) null);
        String str3 = orderInfoEntity.orderId;
        Intrinsics.checkNotNullExpressionValue(str3, "order.orderId");
        m31404a(this, str3, false, 2, (Object) null);
        getMScopeContext().getNavigator().finish();
        Runnable runnable = this.f41730a;
        if (runnable != null) {
            UiHandlerUtil.removeCallbacks(runnable);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m31404a(CreateOrderPayHandler createOrderPayHandler, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        createOrderPayHandler.m31411a(str, z);
    }

    /* renamed from: a */
    private final void m31411a(String str, boolean z) {
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
    public final void m31406a(CreateOrderState createOrderState, OrderInfoEntity orderInfoEntity, int i, String str, PayStatusModel payStatusModel) {
        CreateOrderState createOrderState2 = createOrderState;
        OrderInfoEntity orderInfoEntity2 = orderInfoEntity;
        int i2 = i;
        String str2 = str;
        PayStatusModel payStatusModel2 = payStatusModel;
        Runnable runnable = this.f41730a;
        if (runnable != null) {
            UiHandlerUtil.removeCallbacks(runnable);
        }
        if (i2 != 100) {
            String str3 = orderInfoEntity2.shopId;
            Intrinsics.checkNotNullExpressionValue(str3, "order.shopId");
            String str4 = orderInfoEntity2.orderId;
            Intrinsics.checkNotNullExpressionValue(str4, "order.orderId");
            m31409a(str3, i2, str2, str4);
        }
        ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_M_CART_PAY_ERROR_CALLBACK).addErrorType(String.valueOf(i)).addModuleName(ErrorConst.ModuleName.CART).addErrorMsg(str2 != null ? str2 : "").build().trackError();
        LogUtil.m32588i(TAG, "payFailed -> errorCode: " + i2 + " orderId: " + orderInfoEntity2.orderId);
        int i3 = -1;
        if (i2 == -1 || i2 == 2) {
            String string = i2 == 2 ? GlobalContext.getContext().getResources().getString(R.string.customer_target_app_uninstall) : str2;
            ScopeContext mScopeContext = getMScopeContext();
            if (TextUtils.isEmpty(string)) {
                string = GlobalContext.getContext().getResources().getString(R.string.customer_pay_internal_error);
            }
            DialogUtil.showPayFailDialog(mScopeContext, string, new RFDialogInterface.OnClickListener(orderInfoEntity2, i2, str2) {
                public final /* synthetic */ OrderInfoEntity f$1;
                public final /* synthetic */ int f$2;
                public final /* synthetic */ String f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void onClick(RFDialog rFDialog) {
                    CreateOrderPayHandler.m31403a(CreateOrderPayHandler.this, this.f$1, this.f$2, this.f$3, rFDialog);
                }
            });
        } else if (i2 != 100) {
            SceneParamsEntity sceneParamsEntity = new SceneParamsEntity();
            if (payStatusModel2 != null) {
                i3 = payStatusModel2.payStatusDetail;
            }
            sceneParamsEntity.setCode(i3);
            sceneParamsEntity.setCardSuffix(orderInfoEntity2.cardSuffix);
            new OrderStatusHandleRepo().cancelOrder(orderInfoEntity2.orderId, String.valueOf(i), new CreateOrderPayHandler$payFailed$2(this, createOrderState2, orderInfoEntity2, sceneParamsEntity));
        } else {
            ICustomerPayManager.PayParamEntity payParamEntity = new ICustomerPayManager.PayParamEntity();
            payParamEntity.token = LoginUtil.getToken();
            payParamEntity.transId = orderInfoEntity2.transId;
            payParamEntity.setOrderId(orderInfoEntity2.orderId);
            ((ICustomerPayManager) CustomerManagerLoader.loadManager(ICustomerPayManager.class)).pay(getMScopeContext(), (Activity) GlobalContext.getContext(), payParamEntity, new InnerPayCallback(this, 1, payParamEntity, createOrderState2));
        }
        BillOmegaHelper.Companion.showPayFail(orderInfoEntity2.shopId, orderInfoEntity2.orderId, Integer.valueOf(i), str, 1);
        BillEventToJS.triggerEvent$default(BillEventToJS.INSTANCE, 7, (Integer) null, (String) null, (IEntity) null, 14, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31403a(CreateOrderPayHandler createOrderPayHandler, OrderInfoEntity orderInfoEntity, int i, String str, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(createOrderPayHandler, "this$0");
        Intrinsics.checkNotNullParameter(orderInfoEntity, "$order");
        String str2 = orderInfoEntity.orderId;
        Intrinsics.checkNotNullExpressionValue(str2, "order.orderId");
        m31404a(createOrderPayHandler, str2, false, 2, (Object) null);
        createOrderPayHandler.getMScopeContext().getNavigator().finish();
        BillOmegaHelper.Companion.confirmPayFail(i, str, orderInfoEntity.orderId, 1);
    }

    public void startPayTimeout(CreateOrderState createOrderState, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(createOrderState, "state");
        Intrinsics.checkNotNullParameter(function0, "timeout");
        Runnable runnable = this.f41730a;
        if (runnable != null) {
            UiHandlerUtil.removeCallbacks(runnable);
        }
        this.f41730a = new Runnable(this, function0) {
            public final /* synthetic */ CreateOrderPayHandler f$1;
            public final /* synthetic */ Function0 f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                CreateOrderPayHandler.m31405a(CreateOrderState.this, this.f$1, this.f$2);
            }
        };
        UiHandlerUtil.postDelayed(this.f41730a, (long) m31401a());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31405a(CreateOrderState createOrderState, CreateOrderPayHandler createOrderPayHandler, Function0 function0) {
        Intrinsics.checkNotNullParameter(createOrderState, "$state");
        Intrinsics.checkNotNullParameter(createOrderPayHandler, "this$0");
        Intrinsics.checkNotNullParameter(function0, "$timeout");
        OrderInfoEntity order = createOrderState.getOrder();
        String preOrderId = createOrderState.getPreOrderId();
        if (order == null || TextUtils.isEmpty(order.orderId)) {
            BillOmegaHelper.Companion.orderTimeoutTech(1);
        } else {
            preOrderId = order.orderId;
            BillOmegaHelper.Companion.orderTimeoutTech(2);
        }
        Object object = createOrderPayHandler.getMScopeContext().getObject("pay_callback");
        if (object != null) {
            ((ICustomerPayManager.CartPayButtonCallback) object).hideLoading();
            CharSequence charSequence = preOrderId;
            if (!(charSequence == null || charSequence.length() == 0)) {
                createOrderPayHandler.m31411a(preOrderId, true);
                function0.invoke();
            }
            createOrderPayHandler.getMScopeContext().getNavigator().finish();
            ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_CART_PAY_TIMEOUT).addModuleName(ErrorConst.ModuleName.CART).build().trackError();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.manager.base.ICustomerPayManager.CartPayButtonCallback");
    }

    public void stopPayTimeout() {
        Runnable runnable = this.f41730a;
        if (runnable != null) {
            UiHandlerUtil.removeCallbacks(runnable);
        }
    }

    /* renamed from: a */
    private final int m31401a() {
        int i = ((ServerConfigStorage) SingletonFactory.get(ServerConfigStorage.class)).getData() != null ? ((ServerConfigStorage) SingletonFactory.get(ServerConfigStorage.class)).getData().payTimeout : 0;
        if (i <= 0) {
            i = 7;
        }
        return i * 1000;
    }

    /* renamed from: a */
    private final void m31410a(String str, String str2) {
        Object object = getMScopeContext().getObject("pay_callback");
        if (object != null) {
            ((ICustomerPayManager.CartPayButtonCallback) object).success(str);
            BillOmegaHelper.Companion.uploadPayCallback(1, 0, "", str2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.manager.base.ICustomerPayManager.CartPayButtonCallback");
    }

    /* renamed from: a */
    private final void m31409a(String str, int i, String str2, String str3) {
        Object object = getMScopeContext().getObject("pay_callback");
        if (object != null) {
            ((ICustomerPayManager.CartPayButtonCallback) object).fail(str);
            BillOmegaHelper.Companion.uploadPayCallback(0, i, str2, str3);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.manager.base.ICustomerPayManager.CartPayButtonCallback");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m31408a(String str) {
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).fetchCartInfo(str);
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).triggerRefreshGlobalCartList();
    }

    @Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo148868d2 = {"Lcom/didi/soda/bill/manager/CreateOrderPayHandler$Companion;", "", "()V", "PAY_INOF", "", "PRE_PAY", "TAG", "", "assemble", "Lcom/didi/soda/bill/manager/CreateOrderPayHandler;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: CreateOrderPayHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CreateOrderPayHandler assemble(ScopeContext scopeContext) {
            Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
            return new CreateOrderPayHandler(scopeContext, (DefaultConstructorMarker) null);
        }
    }

    public void onResume(ILive iLive) {
        LogUtil.m32588i(TAG, Intrinsics.stringPlus("onResume thirdPayIng = ", Boolean.valueOf(this.f41732c)));
        $$Lambda$CreateOrderPayHandler$hcL73HMYjy36TYNfS8kTbKhunDY r3 = new Runnable() {
            public final void run() {
                CreateOrderPayHandler.m31402a(CreateOrderPayHandler.this);
            }
        };
        this.f41731b = r3;
        UiHandlerUtil.postDelayed(r3, Constants.SUBTITUDE_LOC_EFFECTIVE_TIME);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m31402a(CreateOrderPayHandler createOrderPayHandler) {
        Intrinsics.checkNotNullParameter(createOrderPayHandler, "this$0");
        if (createOrderPayHandler.f41732c) {
            Object object = createOrderPayHandler.getMScopeContext().getObject("pay_callback");
            if (object != null) {
                ((ICustomerPayManager.CartPayButtonCallback) object).fail("");
                OrderInfoEntity orderInfoEntity = createOrderPayHandler.f41733d;
                if (orderInfoEntity == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mOrderEnity");
                    orderInfoEntity = null;
                }
                String str = orderInfoEntity.orderId;
                Intrinsics.checkNotNullExpressionValue(str, "mOrderEnity.orderId");
                m31404a(createOrderPayHandler, str, false, 2, (Object) null);
                createOrderPayHandler.getMScopeContext().getNavigator().finish();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.manager.base.ICustomerPayManager.CartPayButtonCallback");
            }
        }
        createOrderPayHandler.f41732c = false;
    }

    public void onPause(ILive iLive) {
        UiHandlerUtil.removeCallbacks(this.f41731b);
        Object object = getMScopeContext().getObject("pay_callback");
        if (object != null) {
            ((ICustomerPayManager.CartPayButtonCallback) object).fail("");
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.manager.base.ICustomerPayManager.CartPayButtonCallback");
    }

    public void onDestroy(ILive iLive) {
        getMScopeContext().removeObserver(this);
    }
}
