package com.didi.entrega.order.component;

import com.didi.app.nova.skeleton.LiveHandler;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.app.nova.skeleton.tools.Cancelable;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.common.map.BestViewer;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.entrega.customer.biz.sliding.ISlidingLooperService;
import com.didi.entrega.customer.biz.sliding.SlidingLooperService;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.entity.order.MapData;
import com.didi.entrega.customer.foundation.rpc.entity.order.Tip;
import com.didi.entrega.customer.foundation.util.CustomerApolloUtil;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.UiHandlerUtil;
import com.didi.entrega.customer.map.MapStateModel;
import com.didi.entrega.customer.map.MapStateRepo;
import com.didi.entrega.customer.map.model.BestViewModel;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.order.component.Contract;
import com.didi.entrega.order.data.OrderMapStatusRepo;
import com.didi.entrega.order.data.OrderStatusFactory;
import com.didi.entrega.order.data.model.AbstractOrderStatus;
import com.didi.entrega.order.data.model.OrderMapStatusModel;
import com.didi.entrega.order.utils.OrderMapUtil;
import com.didi.entrega.order.widgets.SpreadView;
import com.didi.global.map.animation.SodaAnimEngine;
import com.didi.global.map.animation.SodaAnimLatLng;
import com.didi.global.map.animation.util.FramesUtil;
import com.didi.global.map.animation.util.SphericalUtil;
import com.didi.raven.config.RavenKey;
import com.didichuxing.carsliding.model.Driver;
import com.didichuxing.carsliding.model.DriverCollection;
import com.didichuxing.carsliding.model.VectorCoordinate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(mo148867d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 J2\u00020\u0001:\u0002JKB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0006H\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0006H\u0002J\u0018\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000bH\u0002J\u0010\u0010'\u001a\u00020!2\u0006\u0010&\u001a\u00020\u000bH\u0002J\u0010\u0010(\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0006H\u0002J\u0010\u0010)\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0006H\u0002J\b\u0010*\u001a\u00020\u0004H\u0014J\n\u0010+\u001a\u0004\u0018\u00010\u000fH\u0014J\n\u0010,\u001a\u0004\u0018\u00010\u000fH\u0014J\n\u0010-\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020\u0006H\u0002J\b\u00100\u001a\u00020!H\u0002J\b\u00101\u001a\u00020!H\u0002J\b\u00102\u001a\u00020\u0006H\u0002J\b\u00103\u001a\u00020!H\u0014J\b\u00104\u001a\u00020!H\u0014J\b\u00105\u001a\u00020!H\u0014J\b\u00106\u001a\u00020!H\u0014J\b\u00107\u001a\u00020!H\u0014J\u0012\u00108\u001a\u00020!2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J$\u0010;\u001a\u00020!2\u0010\u0010<\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\u0010\u0010@\u001a\u00020!2\u0006\u0010A\u001a\u00020\u0006H\u0016J\b\u0010B\u001a\u00020!H\u0002J\b\u0010C\u001a\u00020!H\u0002J\b\u0010D\u001a\u00020!H\u0002J\b\u0010E\u001a\u00020!H\u0002J\b\u0010F\u001a\u00020!H\u0002J\u0010\u0010G\u001a\u00020!2\u0006\u0010/\u001a\u00020\u0006H\u0002J\u001a\u0010H\u001a\u00020!2\b\u0010I\u001a\u0004\u0018\u00010\u000b2\u0006\u0010&\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R*\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f8B@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u000f8BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0018\u00010\u001eR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, mo148868d2 = {"Lcom/didi/entrega/order/component/OrderMapPresenter;", "Lcom/didi/entrega/order/component/Contract$AbsMapPresenter;", "()V", "mDefaultPadding", "", "mIsDraggedMap", "", "mIsFirstEnter", "mIsFirstSliding", "mIsSlidingAnimRunning", "mMapStatusModel", "Lcom/didi/entrega/order/data/model/OrderMapStatusModel;", "mOrderStatus", "Lcom/didi/entrega/order/data/model/AbstractOrderStatus;", "mReceiverLatLng", "Lcom/didi/common/map/model/LatLng;", "getMReceiverLatLng", "()Lcom/didi/common/map/model/LatLng;", "value", "mRiderLatLng", "getMRiderLatLng", "setMRiderLatLng", "(Lcom/didi/common/map/model/LatLng;)V", "mSenderLatLng", "getMSenderLatLng", "mSlidingListener", "Lcom/didi/entrega/customer/biz/sliding/SlidingLooperService$DriverSlidingListener;", "mSlidingService", "Lcom/didi/entrega/customer/biz/sliding/ISlidingLooperService;", "mSlidingTask", "Lcom/didi/entrega/order/component/OrderMapPresenter$SlidingTask;", "mStatus", "checkBestViewBeforeRiderComing", "", "arrived", "checkBestViewBeforeRiderDelivering", "checkSlidingAnim", "tempLatLng", "orderMapStatusModel", "dispatchRiderSlidling", "doComingWithRiderStatus", "doDeliveringByRiderStatus", "getAnimIntervalTime", "getReceiverLatLng", "getRiderLatLng", "getSenderLatLng", "hideMapTipInfo", "showAnim", "initParams", "initSlidingService", "needSetMapBestViewDirectly", "onCreate", "onDestroy", "onResume", "onStart", "onStop", "riderAndDestBestView", "drivers", "Lcom/didichuxing/carsliding/model/DriverCollection;", "setBestView", "latLngs", "", "bestViewListener", "Lcom/didi/common/map/BestViewer$IBestViewListener;", "setDraggedMap", "isDraggedMap", "showBestView", "showRiderSpreedView", "subscribeOrderMapChange", "subscribeOrderMapReady", "updateMapElementsByOrderStatus", "updateMapTipInfo", "updateMarkerAndTipInfo", "oldData", "Companion", "SlidingTask", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OrderMapPresenter.kt */
public final class OrderMapPresenter extends Contract.AbsMapPresenter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: o */
    private static final String f22683o = "OrderMapPresenter";

    /* renamed from: a */
    private OrderMapStatusModel f22684a;

    /* renamed from: b */
    private SlidingTask f22685b;

    /* renamed from: c */
    private LatLng f22686c;

    /* renamed from: d */
    private LatLng f22687d;

    /* renamed from: e */
    private LatLng f22688e;

    /* renamed from: f */
    private int f22689f;

    /* renamed from: g */
    private boolean f22690g;

    /* renamed from: h */
    private ISlidingLooperService f22691h;

    /* renamed from: i */
    private int f22692i = Const.OrderStatus.DEFAULT;

    /* renamed from: j */
    private AbstractOrderStatus f22693j;

    /* renamed from: k */
    private boolean f22694k = true;

    /* renamed from: l */
    private boolean f22695l = true;

    /* renamed from: m */
    private boolean f22696m;

    /* renamed from: n */
    private SlidingLooperService.DriverSlidingListener f22697n = new SlidingLooperService.DriverSlidingListener() {
        public final void onDriverSlidingChange(DriverCollection driverCollection) {
            OrderMapPresenter.m18659a(OrderMapPresenter.this, driverCollection);
        }
    };

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lcom/didi/entrega/order/component/OrderMapPresenter$Companion;", "", "()V", "TAG", "", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: OrderMapPresenter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: a */
    private final LatLng m18652a() {
        OrderMapStatusModel orderMapStatusModel;
        MapData mapData;
        if (!(this.f22686c != null || (orderMapStatusModel = this.f22684a) == null || (mapData = orderMapStatusModel.getMapData()) == null)) {
            boolean z = true;
            if (!(mapData.getSenderLng() == 0.0d)) {
                if (mapData.getSenderLat() != 0.0d) {
                    z = false;
                }
                if (!z) {
                    this.f22686c = new LatLng(mapData.getSenderLat(), mapData.getSenderLng());
                }
            }
        }
        return this.f22686c;
    }

    /* renamed from: b */
    private final LatLng m18666b() {
        OrderMapStatusModel orderMapStatusModel;
        MapData mapData;
        if (!(this.f22687d != null || (orderMapStatusModel = this.f22684a) == null || (mapData = orderMapStatusModel.getMapData()) == null)) {
            boolean z = true;
            if (!(mapData.getReceiverLat() == 0.0d)) {
                if (mapData.getReceiverLng() != 0.0d) {
                    z = false;
                }
                if (!z) {
                    this.f22687d = new LatLng(mapData.getReceiverLat(), mapData.getReceiverLng());
                }
            }
        }
        return this.f22687d;
    }

    /* renamed from: c */
    private final LatLng m18670c() {
        OrderMapStatusModel orderMapStatusModel;
        MapData mapData;
        if (!(this.f22688e != null || (orderMapStatusModel = this.f22684a) == null || (mapData = orderMapStatusModel.getMapData()) == null)) {
            boolean z = true;
            if (!(mapData.getRiderLat() == 0.0d)) {
                if (mapData.getRiderLng() != 0.0d) {
                    z = false;
                }
                if (!z) {
                    this.f22688e = new LatLng(mapData.getRiderLat(), mapData.getRiderLng());
                }
            }
        }
        return this.f22688e;
    }

    /* renamed from: a */
    private final void m18653a(LatLng latLng) {
        this.f22688e = latLng;
        if (latLng != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(latLng.latitude);
            sb.append('-');
            sb.append(latLng.longitude);
            LogUtil.m18185i("OrderMapPresenter getRiderLatLng", sb.toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m18659a(OrderMapPresenter orderMapPresenter, DriverCollection driverCollection) {
        LatLng c;
        OrderMapStatusModel orderMapStatusModel;
        Intrinsics.checkNotNullParameter(orderMapPresenter, "this$0");
        AbstractOrderStatus abstractOrderStatus = orderMapPresenter.f22693j;
        if (abstractOrderStatus == null || !abstractOrderStatus.isSupportSliding() || orderMapPresenter.f22696m) {
            return;
        }
        if (driverCollection != null) {
            orderMapPresenter.m18663a(driverCollection);
        } else if (orderMapPresenter.f22695l && (c = orderMapPresenter.m18670c()) != null && (orderMapStatusModel = orderMapPresenter.f22684a) != null) {
            orderMapPresenter.m18654a(c, orderMapStatusModel);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        m18679h();
        m18678g();
        m18674e();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        AbstractOrderStatus abstractOrderStatus = this.f22693j;
        if (abstractOrderStatus != null && abstractOrderStatus.isSupportSliding()) {
            ISlidingLooperService iSlidingLooperService = this.f22691h;
            if (iSlidingLooperService == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSlidingService");
                iSlidingLooperService = null;
            }
            iSlidingLooperService.start(this.f22684a);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        m18672d();
        if (this.f22694k) {
            this.f22694k = false;
            return;
        }
        LogUtil.m18185i(f22683o, "onResume showBestView");
        m18682k();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        ISlidingLooperService iSlidingLooperService = this.f22691h;
        if (iSlidingLooperService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSlidingService");
            iSlidingLooperService = null;
        }
        iSlidingLooperService.stop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        SlidingTask slidingTask = this.f22685b;
        if (slidingTask != null) {
            UiHandlerUtil.removeCallbacks(slidingTask);
        }
    }

    /* access modifiers changed from: protected */
    public int getAnimIntervalTime() {
        return CustomerApolloUtil.getPollingDuration() * 1000;
    }

    public void setDraggedMap(boolean z) {
        this.f22690g = z;
    }

    /* access modifiers changed from: protected */
    public LatLng getReceiverLatLng() {
        return m18666b();
    }

    /* access modifiers changed from: protected */
    public LatLng getSenderLatLng() {
        return m18652a();
    }

    /* access modifiers changed from: protected */
    public LatLng getRiderLatLng() {
        return m18670c();
    }

    /* renamed from: d */
    private final void m18672d() {
        if (!((MapStateRepo) RepoFactory.getRepo(MapStateRepo.class)).mapReady()) {
            LogUtil.m18185i(f22683o, "Map not ready when init order.");
            ((MapStateRepo) RepoFactory.getRepo(MapStateRepo.class)).subscribe(getScopeContext(), new Action2() {
                public final void call(Object obj, Subscription subscription) {
                    OrderMapPresenter.m18656a(OrderMapPresenter.this, (MapStateModel) obj, subscription);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m18656a(OrderMapPresenter orderMapPresenter, MapStateModel mapStateModel, Subscription subscription) {
        Intrinsics.checkNotNullParameter(orderMapPresenter, "this$0");
        Intrinsics.checkNotNullParameter(subscription, RavenKey.STACK);
        if (mapStateModel != null && mapStateModel.mapReady) {
            LogUtil.m18185i(f22683o, "Order refresh after mMap ready showBestView");
            orderMapPresenter.m18682k();
            subscription.unsubscribe();
        }
    }

    /* renamed from: e */
    private final void m18674e() {
        ((OrderMapStatusRepo) RepoFactory.getRepo(OrderMapStatusRepo.class)).subscribe(getScopeContext(), new Action1() {
            public final void call(Object obj) {
                OrderMapPresenter.m18657a(OrderMapPresenter.this, (OrderMapStatusModel) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m18657a(OrderMapPresenter orderMapPresenter, OrderMapStatusModel orderMapStatusModel) {
        Intrinsics.checkNotNullParameter(orderMapPresenter, "this$0");
        LogUtil.m18185i(f22683o, Intrinsics.stringPlus("set OrderMapStatusModel showBestView:", orderMapStatusModel));
        if (orderMapStatusModel != null) {
            orderMapPresenter.setDraggedMap(false);
            OrderMapStatusModel orderMapStatusModel2 = orderMapPresenter.f22684a;
            orderMapPresenter.f22684a = orderMapStatusModel;
            int orderStatus = orderMapStatusModel.getOrderStatus();
            orderMapPresenter.f22692i = orderStatus;
            AbstractOrderStatus orderStatus2 = OrderStatusFactory.getOrderStatus(orderStatus);
            orderMapPresenter.f22693j = orderStatus2;
            if (orderStatus2 != null) {
                orderStatus2.setLocation(orderMapPresenter.m18652a(), orderMapPresenter.m18666b(), orderMapPresenter.m18670c());
            }
            if (OrderMapUtil.isOrderStatusChange(orderMapStatusModel2, orderMapStatusModel)) {
                ((Contract.AbsMapView) orderMapPresenter.getLogicView()).clearMapExceptRider();
                orderMapPresenter.m18669b(true);
                orderMapPresenter.f22695l = true;
            }
            if (OrderMapUtil.hasNoOrderTip(orderMapStatusModel)) {
                LogUtil.m18185i(f22683o, "hideMapTipInfo anim ");
                orderMapPresenter.m18669b(true);
            }
            AbstractOrderStatus abstractOrderStatus = orderMapPresenter.f22693j;
            if (abstractOrderStatus != null && !abstractOrderStatus.needShowSpread()) {
                ((Contract.AbsMapView) orderMapPresenter.getLogicView()).hideSpreadView();
            }
            if (orderMapPresenter.m18677f()) {
                AbstractOrderStatus abstractOrderStatus2 = orderMapPresenter.f22693j;
                if (abstractOrderStatus2 != null) {
                    orderMapPresenter.m18664a(abstractOrderStatus2.getBestViewLocation(), (BestViewer.IBestViewListener) new BestViewer.IBestViewListener(orderMapStatusModel2, orderMapStatusModel) {
                        public final /* synthetic */ OrderMapStatusModel f$1;
                        public final /* synthetic */ OrderMapStatusModel f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void onFinished() {
                            OrderMapPresenter.m18658a(OrderMapPresenter.this, this.f$1, this.f$2);
                        }
                    });
                    return;
                }
                return;
            }
            orderMapPresenter.m18662a(orderMapStatusModel2, orderMapStatusModel);
            return;
        }
        orderMapPresenter.m18669b(false);
        ((Contract.AbsMapView) orderMapPresenter.getLogicView()).hideSpreadView();
        ((Contract.AbsMapView) orderMapPresenter.getLogicView()).clearAllMapElement();
        orderMapPresenter.m18664a((List<LatLng>) null, (BestViewer.IBestViewListener) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m18658a(OrderMapPresenter orderMapPresenter, OrderMapStatusModel orderMapStatusModel, OrderMapStatusModel orderMapStatusModel2) {
        LiveHandler liveHandler;
        Intrinsics.checkNotNullParameter(orderMapPresenter, "this$0");
        ScopeContext scopeContext = orderMapPresenter.getScopeContext();
        boolean z = true;
        if (scopeContext == null || (liveHandler = scopeContext.getLiveHandler()) == null || !liveHandler.isActive()) {
            z = false;
        }
        if (z) {
            Intrinsics.checkNotNullExpressionValue(orderMapStatusModel2, "orderMapStatusModel");
            orderMapPresenter.m18662a(orderMapStatusModel, orderMapStatusModel2);
        }
    }

    /* renamed from: f */
    private final boolean m18677f() {
        if (1100 != this.f22692i) {
            OrderMapStatusModel orderMapStatusModel = this.f22684a;
            return orderMapStatusModel == null ? false : orderMapStatusModel.isManualRefresh();
        }
    }

    /* renamed from: a */
    private final void m18662a(OrderMapStatusModel orderMapStatusModel, OrderMapStatusModel orderMapStatusModel2) {
        if (OrderMapUtil.isOrderStatusChange(orderMapStatusModel, orderMapStatusModel2)) {
            m18680i();
        }
        AbstractOrderStatus abstractOrderStatus = this.f22693j;
        if (abstractOrderStatus == null || abstractOrderStatus.isSupportSliding()) {
            return;
        }
        if (OrderMapUtil.isOrderTipStatusChange(orderMapStatusModel, orderMapStatusModel2)) {
            m18665a(true);
        } else if (OrderMapUtil.isOrderTipContentChange(orderMapStatusModel, orderMapStatusModel2)) {
            m18665a(false);
        }
    }

    /* renamed from: a */
    private final void m18663a(DriverCollection driverCollection) {
        Driver driver;
        if (driverCollection != null && driverCollection.size() > 0 && (driver = (Driver) driverCollection.get(0)) != null && driver.getVectorCoordinateList() != null && driver.getVectorCoordinateList().size() > 0) {
            VectorCoordinate vectorCoordinate = (VectorCoordinate) driver.getVectorCoordinateList().get(0);
            double lat = vectorCoordinate.getLat();
            double lng = vectorCoordinate.getLng();
            LatLng latLng = new LatLng(lat, lng);
            SodaAnimLatLng sodaAnimLatLng = new SodaAnimLatLng(new LatLng(lat, lng), vectorCoordinate.getTimeStamp(), vectorCoordinate.getAngle());
            OrderMapStatusModel orderMapStatusModel = this.f22684a;
            if (orderMapStatusModel != null) {
                ((Contract.AbsMapView) getLogicView()).doSlidingRiderAnim(sodaAnimLatLng);
                m18654a(latLng, orderMapStatusModel);
            }
        }
    }

    /* renamed from: g */
    private final void m18678g() {
        ISlidingLooperService slidingLooperService = new SlidingLooperService(getAnimIntervalTime());
        this.f22691h = slidingLooperService;
        if (slidingLooperService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSlidingService");
            slidingLooperService = null;
        }
        slidingLooperService.addDriverSlidingListener(this.f22697n);
        getScopeContext().getLiveHandler().bind(new Cancelable() {
            public final void cancel() {
                OrderMapPresenter.m18655a(OrderMapPresenter.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m18655a(OrderMapPresenter orderMapPresenter) {
        Intrinsics.checkNotNullParameter(orderMapPresenter, "this$0");
        ISlidingLooperService iSlidingLooperService = orderMapPresenter.f22691h;
        ISlidingLooperService iSlidingLooperService2 = null;
        if (iSlidingLooperService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSlidingService");
            iSlidingLooperService = null;
        }
        iSlidingLooperService.removeDriverSlidingListener(orderMapPresenter.f22697n);
        ISlidingLooperService iSlidingLooperService3 = orderMapPresenter.f22691h;
        if (iSlidingLooperService3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSlidingService");
        } else {
            iSlidingLooperService2 = iSlidingLooperService3;
        }
        iSlidingLooperService2.stop();
    }

    /* renamed from: a */
    private final void m18654a(LatLng latLng, OrderMapStatusModel orderMapStatusModel) {
        LogUtil.m18185i(f22683o, "checkSlidingAnim--lastLatLng=" + m18670c() + "===curLatLng=" + latLng);
        if (this.f22695l || m18670c() == null) {
            m18653a(latLng);
            this.f22696m = true;
            this.f22695l = false;
            m18661a(orderMapStatusModel);
            return;
        }
        double computeDistanceBetween = SphericalUtil.computeDistanceBetween(m18670c(), latLng);
        LogUtil.m18185i(f22683o, Intrinsics.stringPlus("checkSlidingAnim--distance==", Double.valueOf(computeDistanceBetween)));
        m18653a(latLng);
        if (computeDistanceBetween > SodaAnimEngine.DistanceThreshold) {
            this.f22696m = true;
            this.f22695l = false;
            m18661a(orderMapStatusModel);
        } else if (computeDistanceBetween > 0.0d) {
            this.f22696m = true;
            this.f22695l = false;
            long roundToLong = MathKt.roundToLong(((float) getAnimIntervalTime()) * 1.3f);
            SlidingTask slidingTask = new SlidingTask(this, orderMapStatusModel);
            this.f22685b = slidingTask;
            UiHandlerUtil.postDelayed(slidingTask, roundToLong);
        } else {
            m18665a(false);
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, mo148868d2 = {"Lcom/didi/entrega/order/component/OrderMapPresenter$SlidingTask;", "Ljava/lang/Runnable;", "orderMapStatusModel", "Lcom/didi/entrega/order/data/model/OrderMapStatusModel;", "(Lcom/didi/entrega/order/component/OrderMapPresenter;Lcom/didi/entrega/order/data/model/OrderMapStatusModel;)V", "getOrderMapStatusModel", "()Lcom/didi/entrega/order/data/model/OrderMapStatusModel;", "run", "", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: OrderMapPresenter.kt */
    private final class SlidingTask implements Runnable {
        private final OrderMapStatusModel orderMapStatusModel;
        final /* synthetic */ OrderMapPresenter this$0;

        public SlidingTask(OrderMapPresenter orderMapPresenter, OrderMapStatusModel orderMapStatusModel2) {
            Intrinsics.checkNotNullParameter(orderMapPresenter, "this$0");
            Intrinsics.checkNotNullParameter(orderMapStatusModel2, "orderMapStatusModel");
            this.this$0 = orderMapPresenter;
            this.orderMapStatusModel = orderMapStatusModel2;
        }

        public final OrderMapStatusModel getOrderMapStatusModel() {
            return this.orderMapStatusModel;
        }

        public void run() {
            LogUtil.m18185i(OrderMapPresenter.f22683o, "SlidingTask--------------start");
            this.this$0.m18661a(this.orderMapStatusModel);
            LogUtil.m18185i(OrderMapPresenter.f22683o, "SlidingTask--------------end");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m18661a(OrderMapStatusModel orderMapStatusModel) {
        if (1200 == orderMapStatusModel.getOrderStatus()) {
            m18671c(false);
        } else if (1300 == orderMapStatusModel.getOrderStatus()) {
            m18671c(true);
        } else if (1400 == orderMapStatusModel.getOrderStatus()) {
            m18675e(false);
        } else if (1500 == orderMapStatusModel.getOrderStatus()) {
            m18675e(true);
        } else if (1600 == orderMapStatusModel.getOrderStatus() && 1 == orderMapStatusModel.getIsShowMap()) {
            m18671c(false);
        }
    }

    /* renamed from: h */
    private final void m18679h() {
        this.f22689f = DisplayUtils.dip2px(((Contract.AbsMapView) getLogicView()).getContext(), 20.0f);
    }

    /* renamed from: i */
    private final void m18680i() {
        if (isActive()) {
            int i = this.f22692i;
            if (i != 1100) {
                ISlidingLooperService iSlidingLooperService = null;
                if (i == 1200 || i == 1300 || i == 1400 || i == 1500) {
                    OrderMapStatusModel orderMapStatusModel = this.f22684a;
                    if (orderMapStatusModel != null) {
                        ISlidingLooperService iSlidingLooperService2 = this.f22691h;
                        if (iSlidingLooperService2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mSlidingService");
                        } else {
                            iSlidingLooperService = iSlidingLooperService2;
                        }
                        iSlidingLooperService.start(orderMapStatusModel);
                    }
                } else if (i != 1600) {
                    ISlidingLooperService iSlidingLooperService3 = this.f22691h;
                    if (iSlidingLooperService3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSlidingService");
                        iSlidingLooperService3 = null;
                    }
                    iSlidingLooperService3.stop();
                    ((Contract.AbsMapView) getLogicView()).doSlidingRiderAnim((SodaAnimLatLng) null);
                    ((Contract.AbsMapView) getLogicView()).clearAllMapElement();
                } else {
                    OrderMapStatusModel orderMapStatusModel2 = this.f22684a;
                    if (orderMapStatusModel2 != null) {
                        if (1 == orderMapStatusModel2.getIsShowMap()) {
                            ISlidingLooperService iSlidingLooperService4 = this.f22691h;
                            if (iSlidingLooperService4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mSlidingService");
                            } else {
                                iSlidingLooperService = iSlidingLooperService4;
                            }
                            iSlidingLooperService.start(orderMapStatusModel2);
                            return;
                        }
                        ISlidingLooperService iSlidingLooperService5 = this.f22691h;
                        if (iSlidingLooperService5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mSlidingService");
                            iSlidingLooperService5 = null;
                        }
                        iSlidingLooperService5.stop();
                        ((Contract.AbsMapView) getLogicView()).doSlidingRiderAnim((SodaAnimLatLng) null);
                        ((Contract.AbsMapView) getLogicView()).clearAllMapElement();
                    }
                }
            } else {
                m18681j();
            }
        }
    }

    /* renamed from: a */
    private final void m18665a(boolean z) {
        AbstractOrderStatus abstractOrderStatus;
        OrderMapStatusModel orderMapStatusModel = this.f22684a;
        if (orderMapStatusModel != null) {
            if (OrderMapUtil.hasNoOrderTip(orderMapStatusModel)) {
                m18669b(false);
                return;
            }
            LogUtil.m18185i(f22683o, Intrinsics.stringPlus("updateMapTipInfo  hasAnim=", Boolean.valueOf(z)));
            Tip tip = orderMapStatusModel.getMapData().getTip();
            if (tip != null && (abstractOrderStatus = this.f22693j) != null) {
                ((Contract.AbsMapView) getLogicView()).showInfoWindow(abstractOrderStatus.isMarkerInfoWindowTip(), tip, abstractOrderStatus.getTipLocation(), z, orderMapStatusModel.getOrderStatus(), abstractOrderStatus.needShowSpread());
            }
        }
    }

    /* renamed from: b */
    private final void m18669b(boolean z) {
        ((Contract.AbsMapView) getLogicView()).hideInfoWindow(z);
    }

    /* renamed from: j */
    private final void m18681j() {
        ((Contract.AbsMapView) getLogicView()).showSpreadView(m18652a(), SpreadView.SpreadViewType.SENDER_CENTER);
    }

    /* renamed from: c */
    private final void m18671c(boolean z) {
        if (m18670c() != null && m18652a() != null) {
            if (!this.f22690g) {
                List arrayList = new ArrayList();
                arrayList.add(m18670c());
                arrayList.add(m18652a());
                m18664a((List<LatLng>) arrayList, (BestViewer.IBestViewListener) new BestViewer.IBestViewListener(z) {
                    public final /* synthetic */ boolean f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onFinished() {
                        OrderMapPresenter.m18660a(OrderMapPresenter.this, this.f$1);
                    }
                });
                return;
            }
            m18673d(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m18660a(OrderMapPresenter orderMapPresenter, boolean z) {
        LiveHandler liveHandler;
        Intrinsics.checkNotNullParameter(orderMapPresenter, "this$0");
        ScopeContext scopeContext = orderMapPresenter.getScopeContext();
        boolean z2 = true;
        if (scopeContext == null || (liveHandler = scopeContext.getLiveHandler()) == null || !liveHandler.isActive()) {
            z2 = false;
        }
        if (z2) {
            orderMapPresenter.m18673d(z);
        }
    }

    /* renamed from: d */
    private final void m18673d(boolean z) {
        FramesUtil.initDefaultAngle(m18670c(), m18652a());
        if (!z) {
            ((Contract.AbsMapView) getLogicView()).showMapWithRiderComing();
        } else {
            ((Contract.AbsMapView) getLogicView()).showMapWithRiderArrivedSender();
        }
        m18665a(false);
        this.f22696m = false;
    }

    /* renamed from: e */
    private final void m18675e(boolean z) {
        if (m18666b() != null && m18670c() != null) {
            if (!this.f22690g) {
                List arrayList = new ArrayList();
                arrayList.add(m18670c());
                arrayList.add(m18666b());
                m18664a((List<LatLng>) arrayList, (BestViewer.IBestViewListener) new BestViewer.IBestViewListener(z) {
                    public final /* synthetic */ boolean f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onFinished() {
                        OrderMapPresenter.m18668b(OrderMapPresenter.this, this.f$1);
                    }
                });
                return;
            }
            m18676f(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m18668b(OrderMapPresenter orderMapPresenter, boolean z) {
        LiveHandler liveHandler;
        Intrinsics.checkNotNullParameter(orderMapPresenter, "this$0");
        ScopeContext scopeContext = orderMapPresenter.getScopeContext();
        boolean z2 = true;
        if (scopeContext == null || (liveHandler = scopeContext.getLiveHandler()) == null || !liveHandler.isActive()) {
            z2 = false;
        }
        if (z2) {
            orderMapPresenter.m18676f(z);
        }
    }

    /* renamed from: f */
    private final void m18676f(boolean z) {
        FramesUtil.initDefaultAngle(m18670c(), m18666b());
        if (!z) {
            ((Contract.AbsMapView) getLogicView()).showMapWithRiderToDelivering(SphericalUtil.computeDistanceBetween(m18666b(), m18670c()) < ((double) CustomerApolloUtil.getPollingBDDistance()));
        } else {
            ((Contract.AbsMapView) getLogicView()).showMapWithRiderArriveReceiver();
        }
        m18665a(false);
        this.f22696m = false;
    }

    /* renamed from: k */
    private final void m18682k() {
        if (this.f22693j != null && this.f22684a != null) {
            if (m18677f()) {
                AbstractOrderStatus abstractOrderStatus = this.f22693j;
                m18664a(abstractOrderStatus == null ? null : abstractOrderStatus.getBestViewLocation(), (BestViewer.IBestViewListener) new BestViewer.IBestViewListener() {
                    public final void onFinished() {
                        OrderMapPresenter.m18667b(OrderMapPresenter.this);
                    }
                });
                return;
            }
            LogUtil.m18185i(f22683o, "onResume  showBestView");
            m18680i();
            m18665a(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m18667b(OrderMapPresenter orderMapPresenter) {
        LiveHandler liveHandler;
        Intrinsics.checkNotNullParameter(orderMapPresenter, "this$0");
        ScopeContext scopeContext = orderMapPresenter.getScopeContext();
        boolean z = true;
        if (scopeContext == null || (liveHandler = scopeContext.getLiveHandler()) == null || !liveHandler.isActive()) {
            z = false;
        }
        if (z) {
            LogUtil.m18185i(f22683o, "onResume  showBestView");
            orderMapPresenter.m18680i();
            orderMapPresenter.m18665a(false);
        }
    }

    /* renamed from: a */
    private final void m18664a(List<LatLng> list, BestViewer.IBestViewListener iBestViewListener) {
        int i = this.f22689f;
        Padding padding = new Padding(i * 2, (i * 6) + CustomerSystemUtil.getImmersiveStatusBarHeight(getContext()), this.f22689f * 2, DisplayUtils.dip2px(getContext(), 315.0f));
        LogUtil.m18181d("OrderCardView", Intrinsics.stringPlus("padding:", padding));
        BestViewModel bestViewModel = new BestViewModel();
        bestViewModel.mPadding = padding;
        if (list != null) {
            for (LatLng next : list) {
                if (next != null) {
                    bestViewModel.mIncludes.add(next);
                }
            }
        }
        if (bestViewModel.mIncludes.size() > 0) {
            ((Contract.AbsMapView) getLogicView()).centerBestView(bestViewModel, iBestViewListener);
        }
    }
}
