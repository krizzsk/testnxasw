package com.didi.soda.customer.component.flutterordermap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.LatLng;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.didi.global.map.animation.transition.SodaAnimEngine;
import com.didi.global.map.animation.transition.SodaAnimLatLng;
import com.didi.global.map.animation.transition.callback.OnTranslateAnimEndCallback;
import com.didi.soda.customer.component.flutterordermap.Contract;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.Bubble;
import com.didi.soda.customer.map.listener.MapGestureListener;
import com.didi.soda.customer.map.marker.AbsMarker;
import com.didi.soda.customer.map.marker.BusinessMarker;
import com.didi.soda.customer.map.marker.DestAddressMarker;
import com.didi.soda.customer.map.marker.LineCenterLocationMarker;
import com.didi.soda.customer.map.marker.RiderMarker;
import com.didi.soda.customer.map.model.BestViewModel;
import com.didi.soda.customer.widget.map.SodaMapView;
import com.taxis99.R;

public class OrderMapView extends Contract.AbsMapView {

    /* renamed from: a */
    private static final String f43390a = "OrderMapView";

    /* renamed from: b */
    private BusinessMarker f43391b;

    /* renamed from: c */
    private RiderMarker f43392c;

    /* renamed from: d */
    private DestAddressMarker f43393d;

    /* renamed from: e */
    private LineCenterLocationMarker f43394e;

    /* renamed from: f */
    private SodaMapView f43395f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SodaAnimEngine f43396g;

    /* renamed from: h */
    private ViewGroup f43397h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f43398i = true;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f43399j = false;

    /* renamed from: k */
    private DefaultMapGestureListener f43400k;

    public void onCreate() {
        super.onCreate();
        SodaAnimEngine sodaAnimEngine = new SodaAnimEngine(getContext());
        this.f43396g = sodaAnimEngine;
        sodaAnimEngine.setTranslateIntervalTime((long) ((Contract.AbsMapPresenter) getPresenter()).getAnimIntervalTime());
        this.f43396g.setOnTranslateAnimEndCallback(new OnTranslateAnimEndCallback() {
            public void onTranslateAnimEnd() {
                LogUtil.m32584d(OrderMapView.f43390a, "onTranslateAnimEnd start--------");
                if (OrderMapView.this.getScopeContext().getLiveHandler().isActive()) {
                    if (((Contract.AbsMapPresenter) OrderMapView.this.getPresenter()).needShowRiderForBusinessPrepare()) {
                        OrderMapView orderMapView = OrderMapView.this;
                        orderMapView.m32464a((BestViewer.IBestViewListener) null, orderMapView.m32472c(), OrderMapView.this.m32477e());
                    } else {
                        OrderMapView orderMapView2 = OrderMapView.this;
                        orderMapView2.m32464a((BestViewer.IBestViewListener) null, orderMapView2.m32474d(), OrderMapView.this.m32477e());
                    }
                }
                LogUtil.m32584d(OrderMapView.f43390a, "onTranslateAnimEnd end--------");
            }
        });
        this.f43395f.getSodaMapAsync(new OnMapReadyCallBack() {
            public final void onMapReady(Map map) {
                OrderMapView.this.m32465a(map);
            }
        });
        LogUtil.m32588i(f43390a, NachoLifecycleManager.LIFECYCLE_ON_CREATE);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m32465a(Map map) {
        this.f43395f.removeTopView();
        if (this.f43395f.getMapImpl() != null) {
            m32472c().updateMapView(this.f43395f.getMapImpl());
            m32474d().updateMapView(this.f43395f.getMapImpl());
            m32477e().updateMapView(this.f43395f.getMapImpl());
            m32479f().updateMapView(this.f43395f.getMapImpl());
            this.f43400k = new DefaultMapGestureListener();
            this.f43395f.getMapImpl().addOnMapGestureListener(this.f43400k);
        }
    }

    public void onStart() {
        super.onStart();
        this.f43395f.onResume();
        LogUtil.m32588i(f43390a, "onStart");
        this.f43396g.onResume();
    }

    public void onStop() {
        super.onStop();
        LogUtil.m32588i(f43390a, "onStop");
        this.f43396g.onPause();
        this.f43395f.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        m32470b();
        if (this.f43395f.getMapImpl() != null) {
            this.f43395f.getMapImpl().removeOnMapGestureListener(this.f43400k);
        }
        this.f43395f.onDestroy();
        this.f43396g.onDestroy();
        LogUtil.m32588i(f43390a, NachoLifecycleManager.LIFECYCLE_ON_DESTROY);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        LogUtil.m32588i(f43390a, "onResume");
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        LogUtil.m32588i(f43390a, "onPause");
        m32472c().removeLine();
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.customer_page_order_map, viewGroup);
        this.f43397h = viewGroup2;
        this.f43395f = (SodaMapView) viewGroup2.findViewById(R.id.customer_custom_map_view);
        return this.f43397h;
    }

    /* access modifiers changed from: package-private */
    public void centerBestView(BestViewer.IBestViewListener iBestViewListener) {
        LogUtil.m32588i(f43390a, "centerBestView start");
        m32464a(iBestViewListener, m32472c(), m32474d(), m32477e(), m32479f());
        LogUtil.m32588i(f43390a, "centerBestView end");
    }

    /* access modifiers changed from: package-private */
    public void slidingRider(SodaAnimLatLng sodaAnimLatLng) {
        if (!this.f43396g.isDeliverTranslateAnimRunning()) {
            this.f43396g.onLocationChanged(sodaAnimLatLng);
        }
    }

    /* access modifiers changed from: package-private */
    public void showBusinessAndUserMarker() {
        m32472c().attachToMap(getBusinessLatLng());
        m32474d().attachToMap(getCustomerLatLng());
        m32464a((BestViewer.IBestViewListener) new BestViewer.IBestViewListener() {
            public void onFinished() {
                if (OrderMapView.this.getScopeContext().getLiveHandler().isActive()) {
                    LogUtil.m32588i(OrderMapView.f43390a, "showBusinessAndUserMarker onFinished start");
                    if (OrderMapView.this.m32472c().isExist()) {
                        OrderMapView.this.m32472c().setVisible(true);
                    }
                    if (OrderMapView.this.m32474d().isExist()) {
                        OrderMapView.this.m32474d().setVisible(true);
                    }
                    LogUtil.m32588i(OrderMapView.f43390a, "showBusinessAndUserMarker onFinished end");
                }
            }
        }, m32472c(), m32474d());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32464a(BestViewer.IBestViewListener iBestViewListener, AbsMarker... absMarkerArr) {
        BestViewModel bestViewModel = ((Contract.AbsMapPresenter) getPresenter()).getBestViewModel();
        if (absMarkerArr != null && absMarkerArr.length > 0) {
            for (AbsMarker absMarker : absMarkerArr) {
                if (absMarker != null && absMarker.isRealExistInMapView()) {
                    bestViewModel.mapElements.add(absMarker.getMarker());
                    bestViewModel.mIncludes.add(absMarker.getMarker().getPosition());
                }
            }
        }
        this.f43395f.centerBestViewWithMapElement(bestViewModel, iBestViewListener);
    }

    /* access modifiers changed from: package-private */
    public void clearMapWithEmpty() {
        m32474d().remove();
        m32472c().remove();
        m32477e().remove();
        m32479f().remove();
    }

    /* access modifiers changed from: package-private */
    public void clearMapWithRider() {
        m32474d().remove();
        m32472c().remove();
        m32479f().remove();
        m32479f().removeInfoWindow();
        m32477e().setVisible(false);
        m32477e().hideInfoWindow();
    }

    /* access modifiers changed from: package-private */
    public void updateBubbleContent(Bubble bubble, boolean z) {
        if (z) {
            m32479f().updateInfoWindow(bubble, (OnInfoWindowClickListener) null);
            m32479f().showInfoWindow();
            return;
        }
        m32477e().updateInfoWindow(bubble, (OnInfoWindowClickListener) null);
        m32477e().showInfoWindow();
    }

    /* access modifiers changed from: package-private */
    public void showMapWithBusinessPrepare() {
        m32477e().remove();
        m32474d().attachToMap(getCustomerLatLng());
        if (!this.f43399j) {
            m32472c().attachToMapWithAnim(getBusinessLatLng());
        } else {
            m32472c().attachToMap(getBusinessLatLng());
        }
        this.f43396g.setCustomerMarker(m32474d().getMarker());
        this.f43396g.setBusinessMarker(m32472c().getMarker());
        m32464a((BestViewer.IBestViewListener) new BestViewer.IBestViewListener() {
            public void onFinished() {
                if (OrderMapView.this.getScopeContext().getLiveHandler().isActive()) {
                    LogUtil.m32588i(OrderMapView.f43390a, "showMapWithBusinessPrepare onFinished start");
                    if (OrderMapView.this.m32472c().isExist()) {
                        OrderMapView.this.m32472c().setVisible(true);
                        if (!OrderMapView.this.f43399j) {
                            boolean unused = OrderMapView.this.f43399j = true;
                            OrderMapView.this.f43396g.doBusinessAnim(true);
                        }
                    }
                    if (OrderMapView.this.m32474d().isExist()) {
                        OrderMapView.this.m32474d().setVisible(true);
                    }
                    LogUtil.m32588i(OrderMapView.f43390a, "showMapWithBusinessPrepare onFinished end");
                }
            }
        }, m32472c(), m32474d());
    }

    /* access modifiers changed from: package-private */
    public void showRiderForBusinessPrepare(Bubble bubble) {
        m32474d().remove();
        m32477e().attachToMap(getDeliveryLatLng());
        m32477e().updateInfoWindow(bubble, (OnInfoWindowClickListener) null);
        m32472c().attachToMap(getBusinessLatLng());
        this.f43396g.setDeliveryMarker(m32477e().getMarker());
        this.f43396g.setBusinessMarker(m32472c().getMarker());
        this.f43396g.setAnimState(1);
        m32464a((BestViewer.IBestViewListener) new BestViewer.IBestViewListener() {
            public void onFinished() {
                if (OrderMapView.this.getScopeContext().getLiveHandler().isActive()) {
                    LogUtil.m32588i(OrderMapView.f43390a, "showMapWithRiderGoToBusiness onFinished start");
                    if (OrderMapView.this.m32472c().isExist()) {
                        OrderMapView.this.m32472c().setVisible(true);
                    }
                    if (OrderMapView.this.m32477e().isExist()) {
                        OrderMapView.this.m32477e().setVisible(true);
                        OrderMapView.this.m32477e().showInfoWindow();
                    }
                    LogUtil.m32588i(OrderMapView.f43390a, "showMapWithRiderGoToBusiness onFinished end");
                }
            }
        }, m32472c(), m32477e());
    }

    /* access modifiers changed from: package-private */
    public void showMapRiderToken(final boolean z, Bubble bubble, boolean z2) {
        if (!this.f43396g.isDeliverTranslateAnimRunning() || z2 || m32467a()) {
            m32472c().remove();
            m32474d().attachToMap(getCustomerLatLng());
            m32477e().attachToMap(getDeliveryLatLng());
            m32477e().updateInfoWindow(bubble, (OnInfoWindowClickListener) null);
            this.f43396g.setCustomerMarker(m32474d().getMarker());
            this.f43396g.setDeliveryMarker(m32477e().getMarker());
            m32464a((BestViewer.IBestViewListener) new BestViewer.IBestViewListener() {
                public void onFinished() {
                    if (OrderMapView.this.getScopeContext().getLiveHandler().isActive()) {
                        LogUtil.m32588i(OrderMapView.f43390a, "showMapRiderToken onFinished start");
                        if (OrderMapView.this.m32474d().isExist()) {
                            OrderMapView.this.m32474d().setVisible(true);
                        }
                        if (OrderMapView.this.m32477e().isExist()) {
                            OrderMapView.this.m32477e().setVisible(true);
                            if (OrderMapView.this.f43398i && !OrderMapView.this.f43396g.doBoxAnim() && z) {
                                OrderMapView.this.f43396g.setAnimState(2);
                                OrderMapView.this.f43396g.doBoxAnim();
                                boolean unused = OrderMapView.this.f43398i = false;
                            }
                            OrderMapView.this.m32477e().showInfoWindow();
                            OrderMapView.this.f43396g.setAnimState(3);
                        }
                        LogUtil.m32588i(OrderMapView.f43390a, "showMapRiderToken onFinished end");
                    }
                }
            }, m32474d(), m32477e());
        }
    }

    /* renamed from: a */
    private boolean m32467a() {
        return !m32477e().isRealExistInMapView() || !m32474d().isRealExistInMapView();
    }

    /* access modifiers changed from: package-private */
    public void showMapRiderArrive(Bubble bubble, boolean z) {
        if (!this.f43396g.isDeliverTranslateAnimRunning() || z || m32467a()) {
            m32472c().remove();
            m32474d().attachToMap(getCustomerLatLng());
            m32477e().attachToMap(getDeliveryLatLng());
            m32477e().updateInfoWindow(bubble, (OnInfoWindowClickListener) null);
            this.f43396g.setCustomerMarker(m32474d().getMarker());
            this.f43396g.setDeliveryMarker(m32477e().getMarker());
            this.f43396g.setAnimState(4);
            m32464a((BestViewer.IBestViewListener) new BestViewer.IBestViewListener() {
                public void onFinished() {
                    if (OrderMapView.this.getScopeContext().getLiveHandler().isActive()) {
                        LogUtil.m32588i(OrderMapView.f43390a, "showMapWithBusinessPrepare onFinished start");
                        if (OrderMapView.this.m32474d().isExist()) {
                            OrderMapView.this.m32474d().setVisible(true);
                        }
                        if (OrderMapView.this.m32477e().isExist()) {
                            OrderMapView.this.m32477e().setVisible(true);
                            if (OrderMapView.this.f43398i && !OrderMapView.this.f43396g.doBoxAnim()) {
                                OrderMapView.this.f43396g.doBoxAnim();
                            }
                            OrderMapView.this.m32477e().showInfoWindow();
                        }
                        LogUtil.m32588i(OrderMapView.f43390a, "showMapWithBusinessPrepare onFinished end");
                    }
                }
            }, m32477e(), m32474d());
        }
    }

    /* access modifiers changed from: package-private */
    public void showMapWithBusinessDelivery(Bubble bubble) {
        m32472c().attachToMap(getBusinessLatLng(), getCustomerLatLng());
        m32474d().attachToMap(getCustomerLatLng());
        m32479f().attachToMap(m32472c().getLineCenter());
        m32479f().updateInfoWindow(bubble, (OnInfoWindowClickListener) null);
        m32464a((BestViewer.IBestViewListener) new BestViewer.IBestViewListener() {
            public void onFinished() {
                if (OrderMapView.this.getScopeContext().getLiveHandler().isActive()) {
                    LogUtil.m32588i(OrderMapView.f43390a, "showMapWithBusinessDelivery onFinished start");
                    if (OrderMapView.this.m32474d().isExist()) {
                        OrderMapView.this.m32474d().setVisible(true);
                    }
                    if (OrderMapView.this.m32472c().isExist()) {
                        OrderMapView.this.m32472c().setVisible(true);
                        OrderMapView.this.m32472c().setLineVisible(true);
                    }
                    if (OrderMapView.this.m32479f().isExist()) {
                        OrderMapView.this.m32479f().setVisible(true);
                        OrderMapView.this.m32479f().showInfoWindow();
                    }
                    LogUtil.m32588i(OrderMapView.f43390a, "showMapWithBusinessDelivery onFinished end");
                }
            }
        }, m32472c(), m32474d());
    }

    /* renamed from: b */
    private void m32470b() {
        BusinessMarker businessMarker = this.f43391b;
        if (businessMarker != null) {
            businessMarker.onDestroy();
            this.f43391b = null;
        }
        DestAddressMarker destAddressMarker = this.f43393d;
        if (destAddressMarker != null) {
            destAddressMarker.onDestroy();
            this.f43393d = null;
        }
        RiderMarker riderMarker = this.f43392c;
        if (riderMarker != null) {
            riderMarker.onDestroy();
            this.f43392c = null;
        }
        LineCenterLocationMarker lineCenterLocationMarker = this.f43394e;
        if (lineCenterLocationMarker != null) {
            lineCenterLocationMarker.onDestroy();
            this.f43394e = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public BusinessMarker m32472c() {
        if (this.f43391b == null) {
            this.f43391b = new BusinessMarker(getContext(), this.f43395f.getMapImpl());
        }
        return this.f43391b;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public DestAddressMarker m32474d() {
        if (this.f43393d == null) {
            this.f43393d = new DestAddressMarker(getContext(), this.f43395f.getMapImpl());
        }
        return this.f43393d;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public RiderMarker m32477e() {
        if (this.f43392c == null) {
            this.f43392c = new RiderMarker(getContext(), this.f43395f.getMapImpl());
        }
        return this.f43392c;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public LineCenterLocationMarker m32479f() {
        if (this.f43394e == null) {
            this.f43394e = new LineCenterLocationMarker(getContext(), this.f43395f.getMapImpl());
        }
        return this.f43394e;
    }

    public LatLng getBusinessLatLng() {
        return ((Contract.AbsMapPresenter) getPresenter()).getBusinessLatLng();
    }

    public LatLng getCustomerLatLng() {
        return ((Contract.AbsMapPresenter) getPresenter()).getCustomerLatLng();
    }

    public LatLng getDeliveryLatLng() {
        return ((Contract.AbsMapPresenter) getPresenter()).getDeliveryLatLng();
    }

    private class DefaultMapGestureListener extends MapGestureListener {
        float mDownX;
        float mDownY;

        private DefaultMapGestureListener() {
        }

        public boolean onScroll(float f, float f2) {
            ((Contract.AbsMapPresenter) OrderMapView.this.getPresenter()).setDraggedMap(true);
            return super.onScroll(f, f2);
        }

        public boolean onDown(float f, float f2) {
            this.mDownX = f;
            this.mDownY = f2;
            return super.onDown(f, f2);
        }

        public boolean onUp(float f, float f2) {
            if (Math.abs(f - this.mDownX) > 0.0f || Math.abs(f2 - this.mDownY) > 0.0f) {
                ((Contract.AbsMapPresenter) OrderMapView.this.getPresenter()).setDraggedMap(true);
            }
            return super.onUp(f, f2);
        }
    }
}
