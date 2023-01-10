package com.didi.soda.order.flutterpage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.LiveHandler;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.beatles.p101im.module.IMSessionUnreadCallback;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didi.rlab.uni_customer_business.UniAPI;
import com.didi.rlab.uni_customer_business.order_service.OrderService;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.biz.popdialog.natived.PopDialogComponent;
import com.didi.soda.customer.biz.popdialog.natived.PopDialogHelper;
import com.didi.soda.customer.component.flutterordermap.OrderMapComponent;
import com.didi.soda.customer.component.flutterordermap.data.OrderMapStatusModel;
import com.didi.soda.customer.component.flutterordermap.data.OrderMapStatusRepo;
import com.didi.soda.customer.flutter.CustomerFlutterPage;
import com.didi.soda.customer.flutter.plugin.listener.OnCallPluginListener;
import com.didi.soda.customer.flutter.plugin.listener.OnPluginResultListener;
import com.didi.soda.customer.foundation.p164im.ImMessageHelper;
import com.didi.soda.customer.foundation.rpc.entity.CardData;
import com.didi.soda.customer.foundation.rpc.entity.NAPopUpParamsEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderCard;
import com.didi.soda.customer.foundation.rpc.entity.OrderData;
import com.didi.soda.customer.foundation.rpc.entity.OrderLayout;
import com.didi.soda.customer.foundation.rpc.entity.OrderLayoutEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderServerSubject;
import com.didi.soda.customer.foundation.rpc.entity.ServerSubject;
import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.storage.model.AppConfig;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.widget.xpanel.XPanelFrameTouchLayout;
import com.didi.soda.customer.widget.xpanel.XPanelPlugin;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerCartManager;
import com.didi.soda.manager.base.ICustomerOrderManager;
import com.didi.soda.order.flutterpage.OrderServiceRepo;
import com.didi.soda.order.manager.AppRateCompact;
import com.didi.soda.order.manager.BatchOrderLayoutListener;
import com.didi.soda.order.omega.OrderOmegaHelper;
import com.didi.soda.router.HubTable;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;
import global.didi.pay.presenter.GlobalBubbleShowHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p218io.flutter.embedding.engine.FlutterEngine;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;
import p218io.flutter.embedding.engine.plugins.PluginRegistry;

@Metadata(mo148867d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010.\u001a\u00020\u001aH\u0016J\u0010\u0010/\u001a\u0002002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\n\u00101\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u00102\u001a\u000203H\u0002J\n\u00104\u001a\u0004\u0018\u000105H\u0016J\u0006\u00106\u001a\u000200J\b\u00107\u001a\u000200H\u0002J\u0006\u00108\u001a\u000200J\b\u00109\u001a\u000200H\u0002J\b\u0010:\u001a\u000200H\u0002J\u0010\u0010;\u001a\u0002002\u0006\u0010<\u001a\u00020\"H\u0016J\b\u0010=\u001a\u000200H\u0017J\b\u0010>\u001a\u000200H\u0016J\u0018\u0010?\u001a\u00020\"2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0010H\u0016J\b\u0010C\u001a\u000200H\u0016J\b\u0010D\u001a\u000200H\u0002J\b\u0010E\u001a\u000200H\u0002J\u0012\u0010F\u001a\u0002002\b\u0010G\u001a\u0004\u0018\u00010HH\u0002J\b\u0010I\u001a\u000200H\u0002J\b\u0010J\u001a\u000200H\u0002J\u0012\u0010K\u001a\u0002002\b\u0010L\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010M\u001a\u0002002\b\u0010G\u001a\u0004\u0018\u00010HH\u0002J\u0012\u0010N\u001a\u0002002\b\u0010O\u001a\u0004\u0018\u00010PH\u0002J\u0012\u0010Q\u001a\u0002002\b\u0010R\u001a\u0004\u0018\u00010SH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, mo148868d2 = {"Lcom/didi/soda/order/flutterpage/OrderPage;", "Lcom/didi/soda/customer/flutter/CustomerFlutterPage;", "()V", "businessUnreadCallback", "Lcom/didi/beatles/im/module/IMSessionUnreadCallback;", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "isPaying", "", "isSetImBusinessCallback", "isSetImRiderCallback", "mBatchOrderListener", "Lcom/didi/soda/order/manager/BatchOrderLayoutListener;", "mapComponent", "Lcom/didi/soda/customer/component/flutterordermap/OrderMapComponent;", "mapViewContainer", "Landroid/widget/FrameLayout;", "needEvaluateSchema", "", "newOrderServiceListener", "Lcom/didi/soda/customer/flutter/plugin/listener/OnCallPluginListener;", "newOrderServicePlugin", "Lcom/didi/soda/order/flutterpage/NewOrderServicePlugin;", "orderFlutterView", "Lcom/didi/soda/customer/widget/xpanel/XPanelFrameTouchLayout;", "orderId", "", "orderOmegaHelper", "Lcom/didi/soda/order/omega/OrderOmegaHelper;", "orderServicePlugin", "Lcom/didi/soda/order/flutterpage/OrderServicePlugin;", "orderServicePluginListener", "orderStatus", "pageContainerView", "Landroid/view/View;", "popContainer", "popDialogComponent", "Lcom/didi/soda/customer/biz/popdialog/natived/PopDialogComponent;", "rideUid", "riderUnreadCallback", "shopUid", "subScribe", "Lcom/didi/app/nova/skeleton/repo/Subscription;", "xPanelPlugin", "Lcom/didi/soda/customer/widget/xpanel/XPanelPlugin;", "xpanelPluginListener", "alias", "configureFlutterEngine", "", "getOrderOmegaHelper", "getPopUpDialogParams", "Lcom/didi/soda/customer/foundation/rpc/entity/NAPopUpParamsEntity;", "getPushHandler", "Lcom/didi/app/nova/skeleton/conductor/ControllerChangeHandler;", "goAppStoreRate", "handleDestroy", "hideOrderContainer", "initData", "initView", "onCreate", "view", "onDestroy", "onFinalize", "onInflateFlutterLayout", "inflater", "Landroid/view/LayoutInflater;", "container", "onResume", "refreshUnreadMessageCount", "requestShareDialog", "setIMMessageListener", "orderInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderLayoutEntity;", "showNotificationSetting", "subscribeServiceRepo", "syncCart", "shopId", "updateInfoByData", "updateMapByData", "orderData", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderData;", "updateOrderInfo", "resultListener", "Lcom/didi/soda/customer/flutter/plugin/listener/OnPluginResultListener;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@Route(interceptors = {OrderPageInterceptor.class}, value = {"orderPage"})
/* compiled from: OrderPage.kt */
public final class OrderPage extends CustomerFlutterPage {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f46034a;

    /* renamed from: b */
    private int f46035b = -200;

    /* renamed from: c */
    private FrameLayout f46036c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FrameLayout f46037d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public XPanelFrameTouchLayout f46038e;

    /* renamed from: f */
    private View f46039f;

    /* renamed from: g */
    private FlutterEngine f46040g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Subscription f46041h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public PopDialogComponent f46042i;

    /* renamed from: j */
    private OrderMapComponent f46043j;

    /* renamed from: k */
    private XPanelPlugin f46044k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public OrderServicePlugin f46045l;

    /* renamed from: m */
    private NewOrderServicePlugin f46046m;

    /* renamed from: n */
    private OrderOmegaHelper f46047n;

    /* renamed from: o */
    private boolean f46048o;

    /* renamed from: p */
    private boolean f46049p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f46050q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f46051r;

    /* renamed from: s */
    private String f46052s = "";

    /* renamed from: t */
    private String f46053t = "";

    /* renamed from: u */
    private OnCallPluginListener f46054u = new OrderPage$xpanelPluginListener$1(this);

    /* renamed from: v */
    private OnCallPluginListener f46055v = new OrderPage$newOrderServiceListener$1(this);

    /* renamed from: w */
    private OnCallPluginListener f46056w = new OrderPage$orderServicePluginListener$1(this);

    /* renamed from: x */
    private IMSessionUnreadCallback f46057x = new IMSessionUnreadCallback() {
        public final void unReadCount(int i) {
            OrderPage.m34195a(OrderPage.this, i);
        }
    };

    /* renamed from: y */
    private IMSessionUnreadCallback f46058y = new IMSessionUnreadCallback() {
        public final void unReadCount(int i) {
            OrderPage.m34201b(OrderPage.this, i);
        }
    };

    /* renamed from: z */
    private final BatchOrderLayoutListener f46059z = new OrderPage$mBatchOrderListener$1(this);

    @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: OrderPage.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OrderServiceRepo.OrderServiceType.values().length];
            iArr[OrderServiceRepo.OrderServiceType.NONE.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ControllerChangeHandler getPushHandler() {
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m34195a(OrderPage orderPage, int i) {
        Intrinsics.checkNotNullParameter(orderPage, "this$0");
        OrderServicePlugin orderServicePlugin = orderPage.f46045l;
        if (orderServicePlugin != null) {
            orderServicePlugin.queryUnreadCount(1, orderPage.f46034a, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m34201b(OrderPage orderPage, int i) {
        Intrinsics.checkNotNullParameter(orderPage, "this$0");
        OrderServicePlugin orderServicePlugin = orderPage.f46045l;
        if (orderServicePlugin != null) {
            orderServicePlugin.queryUnreadCount(2, orderPage.f46034a, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m34198a(String str) {
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).fetchCartInfo(str);
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).triggerRefreshGlobalCartList();
    }

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCreate(view);
        m34208h();
        m34207g();
        m34190a();
        ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).registerBatchOrderLayoutListener(this.f46059z);
        m34200b(((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).getOrderLayoutById(this.f46034a));
        GlobalContext.getTitleAndBizBarManager().hideTitleBarAndBizBar();
    }

    /* renamed from: a */
    private final void m34190a() {
        ((OrderServiceRepo) RepoFactory.getRepo(OrderServiceRepo.class)).subscribe(getScopeContext(), $$Lambda$OrderPage$aKt8z5dsc5JBaOK0vb51vJ0iQA.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m34197a(OrderServiceRepo.OrderServiceType orderServiceType) {
        if (orderServiceType != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[orderServiceType.ordinal()];
        }
    }

    public View onInflateFlutterLayout(LayoutInflater layoutInflater, FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(frameLayout, "container");
        View inflate = layoutInflater.inflate(R.layout.customer_page_flutter_order, frameLayout, false);
        this.f46039f = inflate.findViewById(R.id.customer_fl_order_root_container);
        this.f46038e = (XPanelFrameTouchLayout) inflate.findViewById(R.id.order_flutter_container);
        this.f46036c = (FrameLayout) inflate.findViewById(R.id.customer_fl_map_container);
        this.f46037d = (FrameLayout) inflate.findViewById(R.id.customer_fl_pop_container);
        XPanelFrameTouchLayout xPanelFrameTouchLayout = this.f46038e;
        if (xPanelFrameTouchLayout != null) {
            xPanelFrameTouchLayout.addView(createFlutterView(getContext()));
        }
        XPanelFrameTouchLayout xPanelFrameTouchLayout2 = this.f46038e;
        if (xPanelFrameTouchLayout2 != null) {
            xPanelFrameTouchLayout2.setSodaMapView(this.f46036c);
        }
        XPanelFrameTouchLayout xPanelFrameTouchLayout3 = this.f46038e;
        if (xPanelFrameTouchLayout3 != null) {
            xPanelFrameTouchLayout3.setAlpha(0.995f);
        }
        Intrinsics.checkNotNullExpressionValue(inflate, "orderRootView");
        return inflate;
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        super.configureFlutterEngine(flutterEngine);
        this.f46040g = flutterEngine;
        PluginRegistry plugins = flutterEngine.getPlugins();
        Intrinsics.checkNotNullExpressionValue(plugins, "flutterEngine.plugins");
        FlutterPlugin flutterPlugin = plugins.get(OrderServicePlugin.class);
        if (flutterPlugin instanceof OrderServicePlugin) {
            OrderServicePlugin orderServicePlugin = (OrderServicePlugin) flutterPlugin;
            this.f46045l = orderServicePlugin;
            if (orderServicePlugin != null) {
                orderServicePlugin.addCallPluginListener(this.f46056w);
            }
        } else {
            OrderOmegaHelper e = m34205e();
            if (e != null) {
                e.trackGetOrderPluginError("OrderServicePlugin not found");
            }
        }
        FlutterPlugin flutterPlugin2 = plugins.get(XPanelPlugin.class);
        if (flutterPlugin2 instanceof XPanelPlugin) {
            XPanelPlugin xPanelPlugin = (XPanelPlugin) flutterPlugin2;
            this.f46044k = xPanelPlugin;
            if (xPanelPlugin != null) {
                xPanelPlugin.addCallPluginListener(this.f46054u);
            }
        } else {
            OrderOmegaHelper e2 = m34205e();
            if (e2 != null) {
                e2.trackGetOrderPluginError("XPanelPlugin not found");
            }
        }
        OrderService orderService = (OrderService) UniAPI.get(OrderService.class);
        if (orderService instanceof NewOrderServicePlugin) {
            NewOrderServicePlugin newOrderServicePlugin = (NewOrderServicePlugin) orderService;
            this.f46046m = newOrderServicePlugin;
            if (newOrderServicePlugin != null) {
                newOrderServicePlugin.addCallPluginListener(this.f46055v);
                return;
            }
            return;
        }
        OrderOmegaHelper e3 = m34205e();
        if (e3 != null) {
            e3.trackGetOrderPluginError("UniApi plugin not found");
        }
    }

    public void onResume() {
        super.onResume();
        m34204d();
        m34199b();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m34199b() {
        if (!TextUtils.isEmpty(this.f46052s)) {
            ImMessageHelper.getInstance().getUnreadMessageCount(this.f46052s, "rider", this.f46058y);
        }
        if (!TextUtils.isEmpty(this.f46053t)) {
            ImMessageHelper.getInstance().getUnreadMessageCount(this.f46053t, "merchant", this.f46057x);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* renamed from: c */
    private final void m34203c() {
        OrderServicePlugin orderServicePlugin = this.f46045l;
        if (orderServicePlugin != null) {
            orderServicePlugin.removeCallPluginListener(this.f46056w);
        }
        XPanelPlugin xPanelPlugin = this.f46044k;
        if (xPanelPlugin != null) {
            xPanelPlugin.removeCallPluginListener(this.f46054u);
        }
        NewOrderServicePlugin newOrderServicePlugin = this.f46046m;
        if (newOrderServicePlugin != null) {
            newOrderServicePlugin.removeCallPluginListener(this.f46055v);
        }
        ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).unregisterBatchOrderLayoutListener(this.f46059z);
        Subscription subscription = this.f46041h;
        if (subscription != null) {
            Intrinsics.checkNotNull(subscription);
            subscription.unsubscribe();
            this.f46041h = null;
        }
        this.f46058y = null;
        this.f46057x = null;
    }

    public void onFinalize() {
        m34203c();
        super.onFinalize();
    }

    /* renamed from: a */
    private final void m34193a(OrderLayoutEntity orderLayoutEntity) {
        OrderServerSubject orderServerSubject;
        List<ServerSubject> serverSubject;
        List<ServerSubject> filterNotNull;
        if ((orderLayoutEntity == null ? null : orderLayoutEntity.getLayouts()) != null) {
            for (OrderLayout next : orderLayoutEntity.getLayouts()) {
                if (next.getCards() != null) {
                    Iterator<OrderCard> it = next.getCards().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            OrderCard next2 = it.next();
                            if (Intrinsics.areEqual((Object) "Tem-OrderServerSubject", (Object) next2.getTemplate())) {
                                CardData data = next2.getData();
                                if (data != null && (orderServerSubject = data.getOrderServerSubject()) != null && (serverSubject = orderServerSubject.getServerSubject()) != null && (filterNotNull = CollectionsKt.filterNotNull(serverSubject)) != null) {
                                    for (ServerSubject serverSubject2 : filterNotNull) {
                                        if (serverSubject2.isOpenIm() == 1) {
                                            CharSequence uid = serverSubject2.getUid();
                                            if (!(uid == null || uid.length() == 0)) {
                                                if (serverSubject2.getType() == 1 && !this.f46048o) {
                                                    this.f46053t = serverSubject2.getUid();
                                                    this.f46048o = true;
                                                    ImMessageHelper.getInstance().setMerchantMessageUnreadCountListener(serverSubject2.getUid(), "merchant", this.f46057x);
                                                }
                                                if (serverSubject2.getType() == 2 && !this.f46049p) {
                                                    this.f46052s = serverSubject2.getUid();
                                                    this.f46049p = true;
                                                    ImMessageHelper.getInstance().setRiderMessageUnreadCountListener(serverSubject2.getUid(), "rider", this.f46058y);
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: d */
    private final void m34204d() {
        if (!CustomerSystemUtil.areNotificationsEnabled(getContext())) {
            AppConfigStorage appConfigStorage = (AppConfigStorage) SingletonFactory.get(AppConfigStorage.class);
            AppConfig data = appConfigStorage.getData();
            long j = data.mNotificationRemindShowTime;
            if ((j <= 0 || System.currentTimeMillis() - j >= GlobalBubbleShowHelper.ONE_WEEK) && getScopeContext() != null) {
                ScopeContext scopeContext = getScopeContext();
                Intrinsics.checkNotNull(scopeContext);
                DialogUtil.showNotificationRemindDialog(scopeContext.getNavigator(), new RFDialogInterface.OnClickListener() {
                    public final void onClick(RFDialog rFDialog) {
                        OrderPage.m34196a(OrderPage.this, rFDialog);
                    }
                }, new RFDialogInterface.OnClickListener() {
                    public final void onClick(RFDialog rFDialog) {
                        OrderPage.m34202b(OrderPage.this, rFDialog);
                    }
                });
                data.mNotificationRemindShowTime = System.currentTimeMillis();
                appConfigStorage.setData(data);
                OrderOmegaHelper e = m34205e();
                if (e != null) {
                    e.trackPushSetShow();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m34196a(OrderPage orderPage, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(orderPage, "this$0");
        OrderOmegaHelper e = orderPage.m34205e();
        if (e != null) {
            e.trackPushSetClick(1);
        }
        CustomerSystemUtil.goNotificationSetting(GlobalContext.getContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m34202b(OrderPage orderPage, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(orderPage, "this$0");
        OrderOmegaHelper e = orderPage.m34205e();
        if (e != null) {
            e.trackPushSetClick(0);
        }
    }

    /* renamed from: e */
    private final OrderOmegaHelper m34205e() {
        OrderOmegaHelper orderOmegaHelper = this.f46047n;
        if (orderOmegaHelper == null) {
            this.f46047n = new OrderOmegaHelper(getScopeContext(), this.f46034a, this.f46035b);
        } else if (orderOmegaHelper != null) {
            orderOmegaHelper.setOrderStatus(this.f46034a, this.f46035b);
        }
        return this.f46047n;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public final NAPopUpParamsEntity m34206f() {
        NAPopUpParamsEntity nAPopUpParamsEntity = new NAPopUpParamsEntity();
        nAPopUpParamsEntity.reciveTriggerSet.add(2);
        if (getScopeContext() != null) {
            ScopeContext scopeContext = getScopeContext();
            Intrinsics.checkNotNull(scopeContext);
            Intrinsics.checkNotNullExpressionValue(scopeContext.getBundle(), "scopeContext!!.bundle");
            nAPopUpParamsEntity.popUpExtEntity.orderId = this.f46034a;
        }
        return nAPopUpParamsEntity;
    }

    /* renamed from: g */
    private final void m34207g() {
        OrderMapComponent orderMapComponent = new OrderMapComponent(this.f46036c);
        this.f46043j = orderMapComponent;
        Intrinsics.checkNotNull(orderMapComponent);
        addComponent(orderMapComponent);
    }

    /* renamed from: h */
    private final void m34208h() {
        if (getScopeContext() != null) {
            ScopeContext scopeContext = getScopeContext();
            Bundle bundle = null;
            if ((scopeContext == null ? null : scopeContext.getBundle()) != null) {
                ScopeContext scopeContext2 = getScopeContext();
                if (scopeContext2 != null) {
                    bundle = scopeContext2.getBundle();
                }
                if (bundle != null) {
                    this.f46034a = bundle.getString("orderid");
                    this.f46050q = bundle.getBoolean("orderpaying", false);
                    this.f46051r = Intrinsics.areEqual((Object) bundle.getString("source"), (Object) "push") ? 1 : 0;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m34200b(OrderLayoutEntity orderLayoutEntity) {
        m34192a(orderLayoutEntity == null ? null : orderLayoutEntity.getOrderData());
        m34193a(orderLayoutEntity);
    }

    /* renamed from: a */
    private final void m34192a(OrderData orderData) {
        OrderMapStatusModel orderMapStatusModel;
        LiveHandler liveHandler;
        if (orderData == null) {
            orderMapStatusModel = null;
        } else {
            this.f46034a = orderData.getOrderId();
            this.f46035b = orderData.getStatus();
            orderMapStatusModel = new OrderMapStatusModel(orderData.getOrderId(), orderData.getStatus(), orderData.getDeliveryType(), orderData.getBusinessMode(), orderData.getMapData(), orderData.getCeta21AB(), orderData.getShowDeliveryStatus(), orderData.getShopPrepareStatus());
        }
        ScopeContext scopeContext = getScopeContext();
        boolean z = true;
        if (scopeContext == null || (liveHandler = scopeContext.getLiveHandler()) == null || !liveHandler.isActive()) {
            z = false;
        }
        if (z) {
            ((OrderMapStatusRepo) RepoFactory.getRepo(OrderMapStatusRepo.class)).setValue(orderMapStatusModel);
        }
    }

    public final void goAppStoreRate() {
        if (!GlobalContext.isEmbed() && GlobalContext.isGmsChannel()) {
            AppConfigStorage appConfigStorage = (AppConfigStorage) SingletonFactory.get(AppConfigStorage.class);
            AppConfig data = appConfigStorage.getData();
            if (!data.mHasGotoRate && CustomerApolloUtil.getRateDialogShowInterval() != 0 && System.currentTimeMillis() - data.mRateDialogShowTime > ((long) (CustomerApolloUtil.getRateDialogShowInterval() * 86400 * 1000))) {
                data.mRateDialogShowTime = System.currentTimeMillis();
                appConfigStorage.setData(data);
                OrderOmegaHelper e = m34205e();
                if (e != null) {
                    e.trackRateShow(alias());
                }
                if (getScopeContext() != null) {
                    Context context = GlobalContext.getContext();
                    ScopeContext scopeContext = getScopeContext();
                    Intrinsics.checkNotNull(scopeContext);
                    DialogUtil.showRateDialog(context, scopeContext.getNavigator(), new View.OnClickListener(appConfigStorage, this) {
                        public final /* synthetic */ AppConfigStorage f$1;
                        public final /* synthetic */ OrderPage f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void onClick(View view) {
                            OrderPage.m34194a(AppConfig.this, this.f$1, this.f$2, view);
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m34194a(AppConfig appConfig, AppConfigStorage appConfigStorage, OrderPage orderPage, View view) {
        Intrinsics.checkNotNullParameter(orderPage, "this$0");
        appConfig.mHasGotoRate = true;
        appConfigStorage.setData(appConfig);
        AppRateCompact appRateCompact = AppRateCompact.INSTANCE;
        Context context = GlobalContext.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        appRateCompact.goToRate(context);
        OrderOmegaHelper e = orderPage.m34205e();
        if (e != null) {
            e.trackRateClick(orderPage.alias());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public final void m34209i() {
        NAPopUpParamsEntity nAPopUpParamsEntity = new NAPopUpParamsEntity();
        nAPopUpParamsEntity.position = 2;
        nAPopUpParamsEntity.popUpExtEntity.orderId = this.f46034a;
        PopDialogHelper.triggerNAPopFetch(nAPopUpParamsEntity);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m34191a(OnPluginResultListener onPluginResultListener) {
        ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).requestOrderLayoutById(getScopeContext(), this.f46034a, this.f46051r, new OrderPage$updateOrderInfo$1(onPluginResultListener, this));
    }

    public String alias() {
        String pageId = HubTable.getPageId(getClass());
        Intrinsics.checkNotNullExpressionValue(pageId, "getPageId(this.javaClass)");
        return pageId;
    }

    public final void hideOrderContainer() {
        View view = this.f46039f;
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
