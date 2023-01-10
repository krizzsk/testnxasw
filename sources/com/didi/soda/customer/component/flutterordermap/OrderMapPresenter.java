package com.didi.soda.customer.component.flutterordermap;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.app.nova.skeleton.tools.Cancelable;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.common.map.BestViewer;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.global.map.animation.transition.SodaAnimLatLng;
import com.didi.global.map.animation.transition.util.FramesUtil;
import com.didi.global.map.animation.transition.util.SphericalUtil;
import com.didi.soda.customer.biz.sliding.ISlidingLooperService;
import com.didi.soda.customer.biz.sliding.SlidingLooperService;
import com.didi.soda.customer.component.flutterordermap.Contract;
import com.didi.soda.customer.component.flutterordermap.data.OrderMapStatusModel;
import com.didi.soda.customer.component.flutterordermap.data.OrderMapStatusRepo;
import com.didi.soda.customer.component.flutterordermap.data.OrderMapUtil;
import com.didi.soda.customer.component.flutterordermap.model.AbstractOrderStatus;
import com.didi.soda.customer.component.flutterordermap.model.OrderStatusFactory;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.Bubble;
import com.didi.soda.customer.foundation.rpc.entity.MapData;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.map.MapStateModel;
import com.didi.soda.customer.map.MapStateRepo;
import com.didi.soda.customer.map.model.BestViewModel;
import com.didi.soda.customer.repo.RepoFactory;
import com.didichuxing.carsliding.model.Driver;
import com.didichuxing.carsliding.model.DriverCollection;
import com.didichuxing.carsliding.model.VectorCoordinate;
import com.taxis99.R;

public class OrderMapPresenter extends Contract.AbsMapPresenter {

    /* renamed from: b */
    private static final String f43378b = "OrderMapPresenter";

    /* renamed from: a */
    SlidingLooperService.DriverSlidingListener f43379a = new SlidingLooperService.DriverSlidingListener() {
        public void onDriverSlidingChange(DriverCollection driverCollection) {
            if (OrderMapPresenter.this.f43388k != null && OrderMapPresenter.this.f43388k.isSupportSliding() && OrderMapPresenter.this.getScopeContext().getLiveHandler().isActive()) {
                OrderMapPresenter.this.m32448a(driverCollection);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OrderMapStatusModel f43380c;

    /* renamed from: d */
    private LatLng f43381d;

    /* renamed from: e */
    private LatLng f43382e;

    /* renamed from: f */
    private LatLng f43383f;

    /* renamed from: g */
    private int f43384g;

    /* renamed from: h */
    private boolean f43385h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ISlidingLooperService f43386i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f43387j = 0;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public AbstractOrderStatus f43388k;

    /* renamed from: l */
    private boolean f43389l = true;

    public void onCreate() {
        super.onCreate();
        m32442a();
        m32457d();
        m32454c();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        m32458e();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        m32451b();
        if (this.f43389l) {
            this.f43389l = false;
            return;
        }
        LogUtil.m32588i(f43378b, "onResume showBestView");
        m32462i();
    }

    /* renamed from: a */
    private void m32442a() {
        this.f43384g = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_10);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.f43386i.stop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: package-private */
    public void setDraggedMap(boolean z) {
        this.f43385h = z;
    }

    /* renamed from: b */
    private void m32451b() {
        if (!((MapStateRepo) RepoFactory.getRepo(MapStateRepo.class)).mapReady()) {
            LogUtil.m32588i(f43378b, "Map not ready when init order.");
            ((MapStateRepo) RepoFactory.getRepo(MapStateRepo.class)).subscribe(getScopeContext(), new Action2() {
                public final void call(Object obj, Subscription subscription) {
                    OrderMapPresenter.this.m32447a((MapStateModel) obj, subscription);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m32447a(MapStateModel mapStateModel, Subscription subscription) {
        if (mapStateModel.mapReady) {
            LogUtil.m32588i(f43378b, "Order refresh after mMap ready showBestView");
            m32462i();
            subscription.unsubscribe();
        }
    }

    /* renamed from: c */
    private void m32454c() {
        ((OrderMapStatusRepo) RepoFactory.getRepo(OrderMapStatusRepo.class)).subscribe(getScopeContext(), new Action1<OrderMapStatusModel>() {
            public void call(OrderMapStatusModel orderMapStatusModel) {
                LogUtil.m32588i(OrderMapPresenter.f43378b, "set OrderMapStatusModel showBestView:" + orderMapStatusModel);
                if (orderMapStatusModel != null) {
                    OrderMapPresenter.this.setDraggedMap(false);
                    OrderMapStatusModel b = OrderMapPresenter.this.f43380c;
                    OrderMapStatusModel unused = OrderMapPresenter.this.f43380c = orderMapStatusModel;
                    int unused2 = OrderMapPresenter.this.f43387j = orderMapStatusModel.getOrderStatus();
                    OrderMapPresenter orderMapPresenter = OrderMapPresenter.this;
                    AbstractOrderStatus unused3 = orderMapPresenter.f43388k = OrderStatusFactory.getOrderStatus(orderMapPresenter.f43387j);
                    OrderMapPresenter.this.f43388k.updateOrderData(orderMapStatusModel);
                    OrderMapPresenter.this.f43388k.setLocation(OrderMapPresenter.this.getBusinessLatLng(), OrderMapPresenter.this.getCustomerLatLng(), OrderMapPresenter.this.getDeliveryLatLng());
                    if (OrderMapUtil.isOrderIdChange(b, orderMapStatusModel)) {
                        ((Contract.AbsMapView) OrderMapPresenter.this.getLogicView()).clearMapWithRider();
                    }
                    OrderMapPresenter.this.m32446a(b, orderMapStatusModel);
                    return;
                }
                ((Contract.AbsMapView) OrderMapPresenter.this.getLogicView()).clearMapWithRider();
                ((Contract.AbsMapView) OrderMapPresenter.this.getLogicView()).centerBestView((BestViewer.IBestViewListener) null);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32446a(OrderMapStatusModel orderMapStatusModel, OrderMapStatusModel orderMapStatusModel2) {
        if (OrderMapUtil.isOrderStatusChange(orderMapStatusModel, orderMapStatusModel2) || OrderMapUtil.isDeliveryStatusChange(orderMapStatusModel, orderMapStatusModel2)) {
            m32449a(true);
            return;
        }
        if (OrderMapUtil.isOrderBubbleContentChange(orderMapStatusModel, orderMapStatusModel2)) {
            ((Contract.AbsMapView) getLogicView()).updateBubbleContent(m32460g(), isSelfDelivery());
        }
        if (orderMapStatusModel2.manualMapRest && this.f43388k != null) {
            ((Contract.AbsMapView) getLogicView()).centerBestView((BestViewer.IBestViewListener) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32448a(DriverCollection driverCollection) {
        Driver driver;
        if (driverCollection != null && driverCollection.size() > 0 && (driver = (Driver) driverCollection.get(0)) != null && driver.getVectorCoordinateList() != null && driver.getVectorCoordinateList().size() > 0) {
            VectorCoordinate vectorCoordinate = (VectorCoordinate) driver.getVectorCoordinateList().get(0);
            double lat = vectorCoordinate.getLat();
            double lng = vectorCoordinate.getLng();
            SodaAnimLatLng sodaAnimLatLng = new SodaAnimLatLng(new LatLng(lat, lng), vectorCoordinate.getTimeStamp(), vectorCoordinate.getAngle());
            m32443a(lat, lng);
            ((Contract.AbsMapView) getLogicView()).slidingRider(sodaAnimLatLng);
            OmegaTracker.Builder.create(EventConst.Trace.SAILING_C_K_SYSTEM_ORDER_SLIDING).addEventParam("driver", GsonUtil.toJson(vectorCoordinate)).build().track();
        }
    }

    /* renamed from: d */
    private void m32457d() {
        SlidingLooperService slidingLooperService = new SlidingLooperService(getAnimIntervalTime());
        this.f43386i = slidingLooperService;
        slidingLooperService.addDriverSlidingListener(this.f43379a);
        getScopeContext().getLiveHandler().bind(new Cancelable() {
            public void cancel() {
                OrderMapPresenter.this.f43386i.removeDriverSlidingListener(OrderMapPresenter.this.f43379a);
                OrderMapPresenter.this.f43386i.stop();
            }
        });
    }

    /* renamed from: a */
    private void m32449a(boolean z) {
        if (isActive()) {
            int i = this.f43387j;
            if (i == 0) {
                ((Contract.AbsMapView) getLogicView()).clearMapWithEmpty();
            } else if (i == 100 || i == 120 || i == 140) {
                ((Contract.AbsMapView) getLogicView()).showBusinessAndUserMarker();
            } else if (i == 200 || i == 300) {
                m32459f();
            } else if (i != 400) {
                if (i != 500) {
                    ((Contract.AbsMapView) getLogicView()).slidingRider((SodaAnimLatLng) null);
                    ((Contract.AbsMapView) getLogicView()).clearMapWithEmpty();
                } else if (this.f43380c.mDeliveryType == 2) {
                    m32461h();
                } else if (this.f43380c.mDeliveryType == 1) {
                    m32455c(z);
                }
            } else if (this.f43380c.mDeliveryType == 2) {
                m32461h();
            } else if (this.f43380c.mDeliveryType == 1) {
                m32452b(z);
            }
            m32458e();
        }
    }

    /* renamed from: e */
    private void m32458e() {
        OrderMapStatusModel orderMapStatusModel;
        this.f43386i.stop();
        AbstractOrderStatus abstractOrderStatus = this.f43388k;
        if (abstractOrderStatus != null && abstractOrderStatus.isSupportSliding() && (orderMapStatusModel = this.f43380c) != null && orderMapStatusModel.mDeliveryType == 1) {
            int i = this.f43387j;
            if (i == 400 || i == 500 || OrderMapUtil.needShowRiderForBusinessPrepare(this.f43380c)) {
                this.f43386i.start(this.f43380c);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean needShowRiderForBusinessPrepare() {
        return OrderMapUtil.needShowRiderForBusinessPrepare(this.f43380c);
    }

    /* renamed from: f */
    private void m32459f() {
        if (this.f43380c.mDeliveryType == 2) {
            ((Contract.AbsMapView) getLogicView()).showMapWithBusinessPrepare();
        } else if (this.f43380c.mDeliveryType != 1) {
        } else {
            if (needShowRiderForBusinessPrepare()) {
                ((Contract.AbsMapView) getLogicView()).showRiderForBusinessPrepare(m32460g());
            } else {
                ((Contract.AbsMapView) getLogicView()).showMapWithBusinessPrepare();
            }
        }
    }

    /* renamed from: b */
    private void m32452b(boolean z) {
        FramesUtil.initDefaultAngle(getDeliveryLatLng(), getBusinessLatLng());
        boolean z2 = true;
        if (getBusinessLatLng() == null || getDeliveryLatLng() == null) {
            ((Contract.AbsMapView) getLogicView()).showMapRiderToken(true, m32460g(), z);
            return;
        }
        Contract.AbsMapView absMapView = (Contract.AbsMapView) getLogicView();
        if (SphericalUtil.computeDistanceBetween(getBusinessLatLng(), getDeliveryLatLng()) >= ((double) CustomerApolloUtil.getPollingBDDistance())) {
            z2 = false;
        }
        absMapView.showMapRiderToken(z2, m32460g(), z);
    }

    /* renamed from: g */
    private Bubble m32460g() {
        OrderMapStatusModel orderMapStatusModel = this.f43380c;
        if (orderMapStatusModel == null || orderMapStatusModel.mMapData == null) {
            return null;
        }
        return this.f43380c.mMapData.getBubble();
    }

    /* renamed from: h */
    private void m32461h() {
        if (this.f43380c.mMapData != null) {
            ((Contract.AbsMapView) getLogicView()).showMapWithBusinessDelivery(this.f43380c.mMapData.getBubble());
        }
    }

    /* renamed from: c */
    private void m32455c(boolean z) {
        FramesUtil.initDefaultAngle(getDeliveryLatLng(), getCustomerLatLng());
        ((Contract.AbsMapView) getLogicView()).showMapRiderArrive(m32460g(), z);
    }

    /* renamed from: i */
    private void m32462i() {
        if (this.f43388k != null && this.f43380c != null) {
            m32449a(false);
        }
    }

    /* access modifiers changed from: package-private */
    public BestViewModel getBestViewModel() {
        Padding padding = new Padding(ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_32), this.f43384g * 12, ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_32), (CustomerSystemUtil.getScreenHeight(getContext()) - DisplayUtils.getScreenWidth(getContext())) + ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_180));
        LogUtil.m32584d("OrderCardView", "padding:" + padding);
        BestViewModel bestViewModel = new BestViewModel();
        bestViewModel.mPadding = padding;
        return bestViewModel;
    }

    public int getAnimIntervalTime() {
        return CustomerApolloUtil.getPollingDuration() * 1000;
    }

    /* access modifiers changed from: package-private */
    public boolean isSelfDelivery() {
        OrderMapStatusModel orderMapStatusModel = this.f43380c;
        return orderMapStatusModel != null && orderMapStatusModel.mDeliveryType == 2;
    }

    public LatLng getBusinessLatLng() {
        OrderMapStatusModel orderMapStatusModel;
        if (!(this.f43381d != null || (orderMapStatusModel = this.f43380c) == null || orderMapStatusModel.mMapData == null || this.f43380c.mMapData.getShopLat() == 0.0d || this.f43380c.mMapData.getShopLng() == 0.0d)) {
            MapData mapData = this.f43380c.mMapData;
            this.f43381d = new LatLng(mapData.getShopLat(), mapData.getShopLng());
        }
        return this.f43381d;
    }

    public LatLng getCustomerLatLng() {
        OrderMapStatusModel orderMapStatusModel;
        if (!(this.f43382e != null || (orderMapStatusModel = this.f43380c) == null || orderMapStatusModel.mMapData == null || this.f43380c.mMapData.getUserLat() == 0.0d || this.f43380c.mMapData.getUserLng() == 0.0d)) {
            MapData mapData = this.f43380c.mMapData;
            this.f43382e = new LatLng(mapData.getUserLat(), mapData.getUserLng());
        }
        return this.f43382e;
    }

    public LatLng getDeliveryLatLng() {
        OrderMapStatusModel orderMapStatusModel;
        if (!(this.f43383f != null || (orderMapStatusModel = this.f43380c) == null || orderMapStatusModel.mMapData == null || this.f43380c.mMapData.getRiderLng() == 0.0d || this.f43380c.mMapData.getRiderLat() == 0.0d)) {
            MapData mapData = this.f43380c.mMapData;
            this.f43383f = new LatLng(mapData.getRiderLat(), mapData.getRiderLng());
        }
        return this.f43383f;
    }

    /* renamed from: a */
    private void m32443a(double d, double d2) {
        String str;
        LatLng latLng = new LatLng(d, d2);
        this.f43383f = latLng;
        if (latLng != null) {
            str = this.f43383f.latitude + "-" + this.f43383f.longitude;
        } else {
            str = "";
        }
        LogUtil.m32588i("OrderMapPresenter getDeliveryLatLng", str);
    }
}
