package com.didi.entrega.order.page;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.beatles.p101im.module.IMSessionUnreadCallback;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.entrega.customer.flutter.CustomerFlutterPage;
import com.didi.entrega.customer.flutter.plugin.listener.OnCallPluginListener;
import com.didi.entrega.customer.flutter.plugin.listener.OnPluginResultListener;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.p113im.ImMessageHelper;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderData;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderInfoEntity;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderRiderInfo;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.customer.widget.xpanel.XPanelFrameTouchLayout;
import com.didi.entrega.customer.widget.xpanel.XPanelPlugin;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerOrderManager;
import com.didi.entrega.order.component.OrderMapComponent;
import com.didi.entrega.order.contact.IMContactModel;
import com.didi.entrega.order.data.OrderMapStatusRepo;
import com.didi.entrega.order.data.model.OrderMapStatusModel;
import com.didi.entrega.order.manager.BatchOrderListener;
import com.didi.entrega.order.manager.OnceOrderListener;
import com.didi.entrega.order.omega.OrderOmegaHelper;
import com.didi.entrega.order.plugin.OrderServicePlugin;
import com.didi.entrega.router.HubTable;
import com.didi.entrega.router.annotations.Route;
import com.didi.entrega.uni_entrega_business.UniAPI;
import com.didi.entrega.uni_entrega_business.order.GLEUniOrderDataService;
import com.didi.entrega.uni_entrega_business.order.GLEUniOrderService;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p218io.flutter.embedding.engine.FlutterEngine;
import p218io.flutter.embedding.engine.plugins.FlutterPlugin;
import p218io.flutter.embedding.engine.plugins.PluginRegistry;

@Metadata(mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u001eH\u0002J\b\u0010$\u001a\u00020\u001eH\u0002J\b\u0010%\u001a\u00020\u001eH\u0002J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0015H\u0016J\b\u0010(\u001a\u00020\u001eH\u0016J\u0018\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\bH\u0016J\b\u0010-\u001a\u00020\u001eH\u0016J\u0012\u0010.\u001a\u00020\u001e2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0012\u00101\u001a\u00020\u001e2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0012\u00104\u001a\u00020\u001e2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0012\u00105\u001a\u00020\u001e2\b\u00106\u001a\u0004\u0018\u000107H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u00069"}, mo148868d2 = {"Lcom/didi/entrega/order/page/OrderPage;", "Lcom/didi/entrega/customer/flutter/CustomerFlutterPage;", "()V", "isSetImRiderCallback", "", "mBatchOrderListener", "Lcom/didi/entrega/order/manager/BatchOrderListener;", "mapViewContainer", "Landroid/widget/FrameLayout;", "newOrderServiceListener", "Lcom/didi/entrega/customer/flutter/plugin/listener/OnCallPluginListener;", "orderFlutterView", "Lcom/didi/entrega/customer/widget/xpanel/XPanelFrameTouchLayout;", "orderId", "", "orderManager", "Lcom/didi/entrega/manager/base/ICustomerOrderManager;", "kotlin.jvm.PlatformType", "orderServicePlugin", "Lcom/didi/entrega/order/plugin/OrderServicePlugin;", "pageContainerView", "Landroid/view/View;", "rideUid", "riderUnreadCallback", "Lcom/didi/beatles/im/module/IMSessionUnreadCallback;", "xPanelPlugin", "Lcom/didi/entrega/customer/widget/xpanel/XPanelPlugin;", "xPanelPluginListener", "alias", "configureFlutterEngine", "", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "getPushHandler", "Lcom/didi/app/nova/skeleton/conductor/ControllerChangeHandler;", "handleDestroy", "initData", "initView", "onCreate", "view", "onFinalize", "onInflateFlutterLayout", "inflater", "Landroid/view/LayoutInflater;", "container", "onResume", "refreshOrderInfoByFlutter", "resultListener", "Lcom/didi/entrega/customer/flutter/plugin/listener/OnPluginResultListener;", "setIMMessageListener", "orderInfo", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderInfoEntity;", "updateInfoByData", "updateMapByData", "orderData", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderData;", "Companion", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@Route(interceptors = {OrderPageInterceptor.class}, value = {"orderPage"})
/* compiled from: OrderPage.kt */
public final class OrderPage extends CustomerFlutterPage {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: n */
    private static final String f22749n = "EntregaOrderPage";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f22750a;

    /* renamed from: b */
    private FrameLayout f22751b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public XPanelFrameTouchLayout f22752c;

    /* renamed from: d */
    private View f22753d;

    /* renamed from: e */
    private XPanelPlugin f22754e;

    /* renamed from: f */
    private OrderServicePlugin f22755f;

    /* renamed from: g */
    private boolean f22756g;

    /* renamed from: h */
    private String f22757h = "";
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final ICustomerOrderManager f22758i = ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class));

    /* renamed from: j */
    private OnCallPluginListener f22759j = new OrderPage$xPanelPluginListener$1(this);

    /* renamed from: k */
    private OnCallPluginListener f22760k = new OrderPage$newOrderServiceListener$1(this);

    /* renamed from: l */
    private IMSessionUnreadCallback f22761l = new IMSessionUnreadCallback() {
        public final void unReadCount(int i) {
            OrderPage.m18745a(OrderPage.this, i);
        }
    };

    /* renamed from: m */
    private final BatchOrderListener f22762m = new OrderPage$mBatchOrderListener$1(this);

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m18747a(Void voidR) {
    }

    public ControllerChangeHandler getPushHandler() {
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m18745a(OrderPage orderPage, int i) {
        Intrinsics.checkNotNullParameter(orderPage, "this$0");
        GLEUniOrderDataService gLEUniOrderDataService = (GLEUniOrderDataService) UniAPI.get(GLEUniOrderDataService.class);
        Pair[] pairArr = new Pair[2];
        String str = orderPage.f22750a;
        if (str == null) {
            str = "";
        }
        pairArr[0] = TuplesKt.m41339to("orderId", str);
        pairArr[1] = TuplesKt.m41339to(Const.PageParams.COUNT, String.valueOf(i));
        gLEUniOrderDataService.updateUnreadCount(MapsKt.mutableMapOf(pairArr), $$Lambda$OrderPage$0Pm_zCmJybSjgnLx9PZ0c4liqgg.INSTANCE);
    }

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCreate(view);
        m18750c();
        GlobalContext.getTitleAndBizBarManager().hideTitleBarAndBizBar();
        if (!TextUtils.isEmpty(this.f22750a)) {
            m18748b();
            this.f22758i.registerBatchOrderListener(this.f22762m);
            OrderInfoEntity orderInfoById = this.f22758i.getOrderInfoById(this.f22750a);
            if (orderInfoById != null) {
                m18749b(orderInfoById);
            }
        }
    }

    public void onResume() {
        super.onResume();
        NotificationDialog.Companion.showNotificationSetting(this, getScopeContext());
        if (!TextUtils.isEmpty(this.f22757h)) {
            ImMessageHelper.getInstance().getUnreadMessageCount(this.f22757h, "rider", this.f22761l);
        }
    }

    public View onInflateFlutterLayout(LayoutInflater layoutInflater, FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(frameLayout, "container");
        View inflate = layoutInflater.inflate(R.layout.entrega_order_page, frameLayout, false);
        View findViewById = inflate.findViewById(R.id.customer_fl_order_root_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "orderRootView.findViewBy…_fl_order_root_container)");
        this.f22753d = findViewById;
        View findViewById2 = inflate.findViewById(R.id.order_flutter_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "orderRootView.findViewBy….order_flutter_container)");
        this.f22752c = (XPanelFrameTouchLayout) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_fl_map_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "orderRootView.findViewBy…ustomer_fl_map_container)");
        this.f22751b = (FrameLayout) findViewById3;
        XPanelFrameTouchLayout xPanelFrameTouchLayout = this.f22752c;
        XPanelFrameTouchLayout xPanelFrameTouchLayout2 = null;
        if (xPanelFrameTouchLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderFlutterView");
            xPanelFrameTouchLayout = null;
        }
        xPanelFrameTouchLayout.addView(createFlutterView(getContext()));
        XPanelFrameTouchLayout xPanelFrameTouchLayout3 = this.f22752c;
        if (xPanelFrameTouchLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderFlutterView");
            xPanelFrameTouchLayout3 = null;
        }
        FrameLayout frameLayout2 = this.f22751b;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapViewContainer");
            frameLayout2 = null;
        }
        xPanelFrameTouchLayout3.setSodaMapView(frameLayout2);
        XPanelFrameTouchLayout xPanelFrameTouchLayout4 = this.f22752c;
        if (xPanelFrameTouchLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderFlutterView");
        } else {
            xPanelFrameTouchLayout2 = xPanelFrameTouchLayout4;
        }
        xPanelFrameTouchLayout2.setAlpha(0.995f);
        Intrinsics.checkNotNullExpressionValue(inflate, "orderRootView");
        return inflate;
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        super.configureFlutterEngine(flutterEngine);
        PluginRegistry plugins = flutterEngine.getPlugins();
        Intrinsics.checkNotNullExpressionValue(plugins, "flutterEngine.plugins");
        FlutterPlugin flutterPlugin = plugins.get(XPanelPlugin.class);
        OrderServicePlugin orderServicePlugin = null;
        if (flutterPlugin instanceof XPanelPlugin) {
            XPanelPlugin xPanelPlugin = (XPanelPlugin) flutterPlugin;
            this.f22754e = xPanelPlugin;
            if (xPanelPlugin == null) {
                Intrinsics.throwUninitializedPropertyAccessException("xPanelPlugin");
                xPanelPlugin = null;
            }
            xPanelPlugin.addCallPluginListener(this.f22759j);
        } else {
            LogUtil.m18185i(f22749n, "Unable get XPanelPlugin");
            OrderOmegaHelper.INSTANCE.orderChannelError("XPanelPlugin");
        }
        GLEUniOrderService gLEUniOrderService = (GLEUniOrderService) UniAPI.get(GLEUniOrderService.class);
        if (gLEUniOrderService instanceof OrderServicePlugin) {
            OrderServicePlugin orderServicePlugin2 = (OrderServicePlugin) gLEUniOrderService;
            this.f22755f = orderServicePlugin2;
            if (orderServicePlugin2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("orderServicePlugin");
            } else {
                orderServicePlugin = orderServicePlugin2;
            }
            orderServicePlugin.addCallPluginListener(this.f22760k);
            return;
        }
        LogUtil.m18185i(f22749n, "Unable get GLEUniOrderService");
        OrderOmegaHelper.INSTANCE.orderChannelError("GLEUniOrderService");
    }

    public String alias() {
        String pageId = HubTable.getPageId(getClass());
        Intrinsics.checkNotNullExpressionValue(pageId, "getPageId(this.javaClass)");
        return pageId;
    }

    public void onFinalize() {
        m18741a();
        super.onFinalize();
    }

    /* renamed from: a */
    private final void m18741a() {
        if (!TextUtils.isEmpty(this.f22750a)) {
            XPanelPlugin xPanelPlugin = this.f22754e;
            if (xPanelPlugin == null) {
                Intrinsics.throwUninitializedPropertyAccessException("xPanelPlugin");
                xPanelPlugin = null;
            }
            xPanelPlugin.removeCallPluginListener(this.f22759j);
            OrderServicePlugin orderServicePlugin = this.f22755f;
            if (orderServicePlugin == null) {
                Intrinsics.throwUninitializedPropertyAccessException("orderServicePlugin");
                orderServicePlugin = null;
            }
            orderServicePlugin.removeCallPluginListener(this.f22760k);
            this.f22758i.unregisterBatchOrderListener(this.f22762m);
            this.f22761l = null;
        }
    }

    /* renamed from: a */
    private final void m18744a(OrderInfoEntity orderInfoEntity) {
        OrderRiderInfo rideInfo;
        IMContactModel assemble = IMContactModel.Companion.assemble(orderInfoEntity);
        if (assemble != null && (rideInfo = assemble.getRideInfo()) != null && rideInfo.isOpenIm() == 1) {
            CharSequence riderUid = rideInfo.getRiderUid();
            if (!(riderUid == null || riderUid.length() == 0)) {
                this.f22757h = rideInfo.getRiderUid();
                this.f22756g = true;
                ImMessageHelper.getInstance().setRiderMessageUnreadCountListener(rideInfo.getRiderUid(), "rider", this.f22761l);
            }
        }
    }

    /* renamed from: b */
    private final void m18748b() {
        FrameLayout frameLayout = this.f22751b;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapViewContainer");
            frameLayout = null;
        }
        addComponent(new OrderMapComponent(frameLayout));
    }

    /* renamed from: c */
    private final void m18750c() {
        if (getScopeContext() != null) {
            ScopeContext scopeContext = getScopeContext();
            Bundle bundle = null;
            if ((scopeContext == null ? null : scopeContext.getBundle()) != null) {
                ScopeContext scopeContext2 = getScopeContext();
                if (scopeContext2 != null) {
                    bundle = scopeContext2.getBundle();
                }
                if (bundle != null) {
                    String string = bundle.getString("orderId");
                    this.f22750a = string;
                    LogUtil.m18185i(f22749n, Intrinsics.stringPlus("order is ", string));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m18749b(OrderInfoEntity orderInfoEntity) {
        if (orderInfoEntity != null) {
            m18743a(orderInfoEntity.getOrderData());
            m18744a(orderInfoEntity);
        }
    }

    /* renamed from: a */
    private final void m18743a(OrderData orderData) {
        OrderMapStatusModel orderMapStatusModel;
        if (orderData == null) {
            orderMapStatusModel = null;
        } else {
            this.f22750a = orderData.getOrderId();
            orderMapStatusModel = new OrderMapStatusModel(orderData.getOrderId(), orderData.getStatus(), orderData.isShowMap(), orderData.getMapData(), false);
        }
        LogUtil.m18185i(f22749n, "update map data");
        ((OrderMapStatusRepo) RepoFactory.getRepo(OrderMapStatusRepo.class)).setValue(orderMapStatusModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m18742a(OnPluginResultListener onPluginResultListener) {
        this.f22758i.requestOrderInfoById(getScopeContext(), this.f22750a, 5, new OnceOrderListener(onPluginResultListener) {
            public final /* synthetic */ OnPluginResultListener f$1;

            {
                this.f$1 = r2;
            }

            public final void onOnceOrderListener(OrderInfoEntity orderInfoEntity, int i) {
                OrderPage.m18746a(OrderPage.this, this.f$1, orderInfoEntity, i);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m18746a(OrderPage orderPage, OnPluginResultListener onPluginResultListener, OrderInfoEntity orderInfoEntity, int i) {
        Intrinsics.checkNotNullParameter(orderPage, "this$0");
        LogUtil.m18185i(f22749n, "Flutter request order info");
        orderPage.m18749b(orderInfoEntity);
        if (onPluginResultListener != null) {
            onPluginResultListener.onResult(orderInfoEntity);
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lcom/didi/entrega/order/page/OrderPage$Companion;", "", "()V", "TAG", "", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: OrderPage.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
