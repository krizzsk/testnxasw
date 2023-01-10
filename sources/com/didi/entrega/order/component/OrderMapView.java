package com.didi.entrega.order.component;

import android.content.Context;
import android.graphics.PointF;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.LatLng;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.entity.order.Tip;
import com.didi.entrega.customer.foundation.util.CustomerApolloUtil;
import com.didi.entrega.customer.map.marker.InfoWindowViewBuildConfig;
import com.didi.entrega.customer.map.marker.ReceiverMarker;
import com.didi.entrega.customer.map.marker.RiderMarker;
import com.didi.entrega.customer.map.marker.SenderMarker;
import com.didi.entrega.customer.map.model.BestViewModel;
import com.didi.entrega.customer.widget.map.SodaMapView;
import com.didi.entrega.order.component.Contract;
import com.didi.entrega.order.widgets.MarkerInfoWindowView;
import com.didi.entrega.order.widgets.SpreadView;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.didi.foundation.sdk.map.MapViewImpl;
import com.didi.global.map.animation.SodaAnimEngine;
import com.didi.global.map.animation.SodaAnimLatLng;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ]2\u00020\u0001:\u0001]B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010,\u001a\u00020-H\u0002J\u001c\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0014J\b\u00103\u001a\u00020-H\u0014J\b\u00104\u001a\u00020-H\u0014J\b\u00105\u001a\u00020-H\u0002J\u0012\u00106\u001a\u00020-2\b\u00107\u001a\u0004\u0018\u000108H\u0014J\u0010\u00109\u001a\u00020-2\u0006\u0010:\u001a\u00020\u0004H\u0014J\b\u0010;\u001a\u00020-H\u0002J\b\u0010<\u001a\u00020-H\u0014J\u0018\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\bH\u0014J\b\u0010B\u001a\u00020-H\u0014J\b\u0010C\u001a\u00020-H\u0014J\b\u0010D\u001a\u00020-H\u0014J\b\u0010E\u001a\u00020-H\u0014J<\u0010F\u001a\u00020-2\u0006\u0010G\u001a\u00020\u00042\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010\f2\u0006\u0010:\u001a\u00020\u00042\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u0004H\u0014J2\u0010N\u001a\u00020-2\u0006\u0010G\u001a\u00020\u00042\u0006\u0010O\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010\f2\u0006\u0010P\u001a\u00020\u00042\u0006\u0010K\u001a\u00020LH\u0002J\b\u0010Q\u001a\u00020-H\u0014J\b\u0010R\u001a\u00020-H\u0014J\b\u0010S\u001a\u00020-H\u0014J\u0010\u0010T\u001a\u00020-2\u0006\u0010U\u001a\u00020\u0004H\u0014J\b\u0010V\u001a\u00020-H\u0002J\u001a\u0010W\u001a\u00020-2\b\u0010X\u001a\u0004\u0018\u00010\f2\u0006\u0010Y\u001a\u00020ZH\u0014J\b\u0010[\u001a\u00020-H\u0002J\b\u0010\\\u001a\u00020-H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u0004\u0018\u00010\f8BX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0015R\u0018\u0010\"\u001a\u0004\u0018\u00010#8BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X.¢\u0006\u0002\n\u0000¨\u0006^"}, mo148868d2 = {"Lcom/didi/entrega/order/component/OrderMapView;", "Lcom/didi/entrega/order/component/Contract$AbsMapView;", "()V", "alreadyShowCompleteAnim", "", "mAnimEngine", "Lcom/didi/global/map/animation/SodaAnimEngine;", "mContainer", "Landroid/view/ViewGroup;", "mCountDownTimer", "Landroid/os/CountDownTimer;", "mInfoWindowCenterLocation", "Lcom/didi/common/map/model/LatLng;", "mInfoWindowView", "Lcom/didi/entrega/order/widgets/MarkerInfoWindowView;", "mMapGestureListener", "Lcom/didi/entrega/order/component/DefaultMapGestureListener;", "mOnCameraChangeListener", "Lcom/didi/common/map/listener/OnCameraChangeListener;", "mReceiverLatLng", "getMReceiverLatLng", "()Lcom/didi/common/map/model/LatLng;", "mReceiverMarker", "Lcom/didi/entrega/customer/map/marker/ReceiverMarker;", "getMReceiverMarker", "()Lcom/didi/entrega/customer/map/marker/ReceiverMarker;", "mRiderLatLng", "getMRiderLatLng", "mRiderMarker", "Lcom/didi/entrega/customer/map/marker/RiderMarker;", "getMRiderMarker", "()Lcom/didi/entrega/customer/map/marker/RiderMarker;", "mSenderLatLng", "getMSenderLatLng", "mSenderMarker", "Lcom/didi/entrega/customer/map/marker/SenderMarker;", "getMSenderMarker", "()Lcom/didi/entrega/customer/map/marker/SenderMarker;", "mSodaMapView", "Lcom/didi/entrega/customer/widget/map/SodaMapView;", "mSpreadBubbleHidden", "mSpreadCenterLocation", "mSpreadView", "Lcom/didi/entrega/order/widgets/SpreadView;", "cancelOldCountDownInfoWindow", "", "centerBestView", "model", "Lcom/didi/entrega/customer/map/model/BestViewModel;", "bestViewListener", "Lcom/didi/common/map/BestViewer$IBestViewListener;", "clearAllMapElement", "clearMapExceptRider", "destroyMarker", "doSlidingRiderAnim", "sodaAnimLatLng", "Lcom/didi/global/map/animation/SodaAnimLatLng;", "hideInfoWindow", "showAnim", "hideNormalInfoWindow", "hideSpreadView", "inflateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "onCreate", "onDestroy", "onStart", "onStop", "showInfoWindow", "isMarkerInfoWindowTip", "originMapTip", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/Tip;", "latLng", "orderStatus", "", "needSpred", "showInfoWindowView", "tip", "hasAnim", "showMapWithRiderArriveReceiver", "showMapWithRiderArrivedSender", "showMapWithRiderComing", "showMapWithRiderToDelivering", "doBoxAnim", "showRiderMaker", "showSpreadView", "location", "type", "Lcom/didi/entrega/order/widgets/SpreadView$SpreadViewType;", "updateInfoWindowLocation", "updateSpreadLocation", "Companion", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OrderMapView.kt */
public final class OrderMapView extends Contract.AbsMapView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: p */
    private static final String f22698p = "OrderMapView";

    /* renamed from: a */
    private SenderMarker f22699a;

    /* renamed from: b */
    private ReceiverMarker f22700b;

    /* renamed from: c */
    private RiderMarker f22701c;

    /* renamed from: d */
    private SodaMapView f22702d;

    /* renamed from: e */
    private MarkerInfoWindowView f22703e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SpreadView f22704f;

    /* renamed from: g */
    private SodaAnimEngine f22705g;

    /* renamed from: h */
    private ViewGroup f22706h;

    /* renamed from: i */
    private LatLng f22707i;

    /* renamed from: j */
    private CountDownTimer f22708j;

    /* renamed from: k */
    private LatLng f22709k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f22710l;

    /* renamed from: m */
    private boolean f22711m;

    /* renamed from: n */
    private DefaultMapGestureListener f22712n;

    /* renamed from: o */
    private final OnCameraChangeListener f22713o = new OnCameraChangeListener() {
        public final void onCameraChange(CameraPosition cameraPosition) {
            OrderMapView.m18685a(OrderMapView.this, cameraPosition);
        }
    };

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lcom/didi/entrega/order/component/OrderMapView$Companion;", "", "()V", "TAG", "", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: OrderMapView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: a */
    private final SenderMarker m18683a() {
        SenderMarker senderMarker = this.f22699a;
        if (senderMarker == null) {
            LogUtil.m18185i(f22698p, Intrinsics.stringPlus("mSenderMarker====Instance ", senderMarker));
            Context context = getContext();
            SodaMapView sodaMapView = this.f22702d;
            if (sodaMapView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
                sodaMapView = null;
            }
            this.f22699a = new SenderMarker(context, sodaMapView.getMapImpl(), 2);
        }
        return this.f22699a;
    }

    /* renamed from: b */
    private final ReceiverMarker m18687b() {
        ReceiverMarker receiverMarker = this.f22700b;
        if (receiverMarker == null) {
            LogUtil.m18185i(f22698p, Intrinsics.stringPlus("mReceiverMarker====Instance ", receiverMarker));
            Context context = getContext();
            SodaMapView sodaMapView = this.f22702d;
            if (sodaMapView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
                sodaMapView = null;
            }
            this.f22700b = new ReceiverMarker(context, sodaMapView.getMapImpl(), 2);
        }
        return this.f22700b;
    }

    /* renamed from: c */
    private final RiderMarker m18688c() {
        RiderMarker riderMarker = this.f22701c;
        if (riderMarker == null) {
            LogUtil.m18185i(f22698p, Intrinsics.stringPlus("mRiderMarker====Instance ", riderMarker));
            Context context = getContext();
            SodaMapView sodaMapView = this.f22702d;
            if (sodaMapView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
                sodaMapView = null;
            }
            this.f22701c = new RiderMarker(context, sodaMapView.getMapImpl());
        }
        return this.f22701c;
    }

    /* renamed from: d */
    private final LatLng m18689d() {
        return ((Contract.AbsMapPresenter) getPresenter()).getSenderLatLng();
    }

    /* renamed from: e */
    private final LatLng m18690e() {
        return ((Contract.AbsMapPresenter) getPresenter()).getReceiverLatLng();
    }

    /* renamed from: f */
    private final LatLng m18691f() {
        return ((Contract.AbsMapPresenter) getPresenter()).getRiderLatLng();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m18685a(OrderMapView orderMapView, CameraPosition cameraPosition) {
        Intrinsics.checkNotNullParameter(orderMapView, "this$0");
        orderMapView.m18694i();
        orderMapView.m18696k();
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        SodaAnimEngine sodaAnimEngine = new SodaAnimEngine(getContext());
        this.f22705g = sodaAnimEngine;
        SodaMapView sodaMapView = null;
        if (sodaAnimEngine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimEngine");
            sodaAnimEngine = null;
        }
        sodaAnimEngine.setTranslateIntervalTime((long) ((Contract.AbsMapPresenter) getPresenter()).getAnimIntervalTime());
        SodaMapView sodaMapView2 = this.f22702d;
        if (sodaMapView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
        } else {
            sodaMapView = sodaMapView2;
        }
        sodaMapView.getSodaMapAsync(new OnMapReadyCallBack() {
            public final void onMapReady(Map map) {
                OrderMapView.m18684a(OrderMapView.this, map);
            }
        });
        this.f22710l = CustomerApolloUtil.isMapBubbleHiddenEnable();
        LogUtil.m18185i(f22698p, NachoLifecycleManager.LIFECYCLE_ON_CREATE);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m18684a(OrderMapView orderMapView, Map map) {
        Intrinsics.checkNotNullParameter(orderMapView, "this$0");
        SodaMapView sodaMapView = orderMapView.f22702d;
        DefaultMapGestureListener defaultMapGestureListener = null;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
            sodaMapView = null;
        }
        sodaMapView.removeAllElement();
        SodaMapView sodaMapView2 = orderMapView.f22702d;
        if (sodaMapView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
            sodaMapView2 = null;
        }
        sodaMapView2.setLogoVisibility(false);
        SodaMapView sodaMapView3 = orderMapView.f22702d;
        if (sodaMapView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
            sodaMapView3 = null;
        }
        MapViewImpl mapImpl = sodaMapView3.getMapImpl();
        if (mapImpl != null) {
            SenderMarker a = orderMapView.m18683a();
            if (a != null) {
                SodaMapView sodaMapView4 = orderMapView.f22702d;
                if (sodaMapView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
                    sodaMapView4 = null;
                }
                a.updateMapView(sodaMapView4.getMapImpl());
            }
            ReceiverMarker b = orderMapView.m18687b();
            if (b != null) {
                SodaMapView sodaMapView5 = orderMapView.f22702d;
                if (sodaMapView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
                    sodaMapView5 = null;
                }
                b.updateMapView(sodaMapView5.getMapImpl());
            }
            RiderMarker c = orderMapView.m18688c();
            if (c != null) {
                SodaMapView sodaMapView6 = orderMapView.f22702d;
                if (sodaMapView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
                    sodaMapView6 = null;
                }
                c.updateMapView(sodaMapView6.getMapImpl());
            }
            IPresenter presenter = orderMapView.getPresenter();
            Intrinsics.checkNotNullExpressionValue(presenter, "this.presenter");
            DefaultMapGestureListener defaultMapGestureListener2 = new DefaultMapGestureListener((Contract.AbsMapPresenter) presenter);
            orderMapView.f22712n = defaultMapGestureListener2;
            if (defaultMapGestureListener2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMapGestureListener");
            } else {
                defaultMapGestureListener = defaultMapGestureListener2;
            }
            mapImpl.addOnMapGestureListener(defaultMapGestureListener);
            mapImpl.addOnCameraChangeListener(orderMapView.f22713o);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        SodaMapView sodaMapView = this.f22702d;
        SodaAnimEngine sodaAnimEngine = null;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
            sodaMapView = null;
        }
        sodaMapView.onResume();
        LogUtil.m18185i(f22698p, "onStart");
        SpreadView spreadView = this.f22704f;
        if (spreadView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
            spreadView = null;
        }
        spreadView.onResume();
        SodaAnimEngine sodaAnimEngine2 = this.f22705g;
        if (sodaAnimEngine2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimEngine");
        } else {
            sodaAnimEngine = sodaAnimEngine2;
        }
        sodaAnimEngine.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        LogUtil.m18185i(f22698p, "onStop");
        SpreadView spreadView = this.f22704f;
        SodaMapView sodaMapView = null;
        if (spreadView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
            spreadView = null;
        }
        spreadView.onPause();
        SodaAnimEngine sodaAnimEngine = this.f22705g;
        if (sodaAnimEngine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimEngine");
            sodaAnimEngine = null;
        }
        sodaAnimEngine.onPause();
        SodaMapView sodaMapView2 = this.f22702d;
        if (sodaMapView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
        } else {
            sodaMapView = sodaMapView2;
        }
        sodaMapView.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        hideInfoWindow(false);
        m18697l();
        SodaMapView sodaMapView = this.f22702d;
        SodaAnimEngine sodaAnimEngine = null;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
            sodaMapView = null;
        }
        MapViewImpl mapImpl = sodaMapView.getMapImpl();
        if (mapImpl != null) {
            mapImpl.removeOnCameraChangeListener(this.f22713o);
            DefaultMapGestureListener defaultMapGestureListener = this.f22712n;
            if (defaultMapGestureListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMapGestureListener");
                defaultMapGestureListener = null;
            }
            mapImpl.removeOnMapGestureListener(defaultMapGestureListener);
        }
        SodaMapView sodaMapView2 = this.f22702d;
        if (sodaMapView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
            sodaMapView2 = null;
        }
        sodaMapView2.setLogoVisibility(true);
        SodaMapView sodaMapView3 = this.f22702d;
        if (sodaMapView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
            sodaMapView3 = null;
        }
        sodaMapView3.onDestroy();
        SpreadView spreadView = this.f22704f;
        if (spreadView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
            spreadView = null;
        }
        spreadView.onDestroy();
        SodaAnimEngine sodaAnimEngine2 = this.f22705g;
        if (sodaAnimEngine2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimEngine");
        } else {
            sodaAnimEngine = sodaAnimEngine2;
        }
        sodaAnimEngine.onDestroy();
        LogUtil.m18185i(f22698p, NachoLifecycleManager.LIFECYCLE_ON_DESTROY);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = layoutInflater.inflate(R.layout.entrega_customer_page_order_map, viewGroup);
        if (inflate != null) {
            ViewGroup viewGroup2 = (ViewGroup) inflate;
            this.f22706h = viewGroup2;
            ViewGroup viewGroup3 = null;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                viewGroup2 = null;
            }
            View findViewById = viewGroup2.findViewById(R.id.customer_custom_map_view);
            Intrinsics.checkNotNullExpressionValue(findViewById, "mContainer.findViewById(…customer_custom_map_view)");
            this.f22702d = (SodaMapView) findViewById;
            ViewGroup viewGroup4 = this.f22706h;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                viewGroup4 = null;
            }
            View findViewById2 = viewGroup4.findViewById(R.id.customer_custom_spreed_view);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "mContainer.findViewById(…tomer_custom_spreed_view)");
            this.f22704f = (SpreadView) findViewById2;
            ViewGroup viewGroup5 = this.f22706h;
            if (viewGroup5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                viewGroup5 = null;
            }
            View findViewById3 = viewGroup5.findViewById(R.id.customer_custom_info_view);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "mContainer.findViewById(…ustomer_custom_info_view)");
            this.f22703e = (MarkerInfoWindowView) findViewById3;
            ViewGroup viewGroup6 = this.f22706h;
            if (viewGroup6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            } else {
                viewGroup3 = viewGroup6;
            }
            return viewGroup3;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    /* access modifiers changed from: protected */
    public void centerBestView(BestViewModel bestViewModel, BestViewer.IBestViewListener iBestViewListener) {
        SodaMapView sodaMapView = this.f22702d;
        if (sodaMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
            sodaMapView = null;
        }
        sodaMapView.centerBestView(bestViewModel, iBestViewListener);
    }

    /* access modifiers changed from: protected */
    public void doSlidingRiderAnim(SodaAnimLatLng sodaAnimLatLng) {
        LogUtil.m18185i(f22698p, "doSlidingRiderAnim");
        SodaAnimEngine sodaAnimEngine = this.f22705g;
        SodaAnimEngine sodaAnimEngine2 = null;
        if (sodaAnimEngine == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimEngine");
            sodaAnimEngine = null;
        }
        sodaAnimEngine.setAnimState(1);
        SodaAnimEngine sodaAnimEngine3 = this.f22705g;
        if (sodaAnimEngine3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimEngine");
            sodaAnimEngine3 = null;
        }
        ReceiverMarker b = m18687b();
        sodaAnimEngine3.setCustomerMarker(b == null ? null : b.getMarker());
        SodaAnimEngine sodaAnimEngine4 = this.f22705g;
        if (sodaAnimEngine4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimEngine");
            sodaAnimEngine4 = null;
        }
        SenderMarker a = m18683a();
        sodaAnimEngine4.setBusinessMarker(a == null ? null : a.getMarker());
        SodaAnimEngine sodaAnimEngine5 = this.f22705g;
        if (sodaAnimEngine5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimEngine");
            sodaAnimEngine5 = null;
        }
        RiderMarker c = m18688c();
        sodaAnimEngine5.setDeliveryMarker(c == null ? null : c.getMarker());
        SodaAnimEngine sodaAnimEngine6 = this.f22705g;
        if (sodaAnimEngine6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimEngine");
        } else {
            sodaAnimEngine2 = sodaAnimEngine6;
        }
        sodaAnimEngine2.onLocationChanged(sodaAnimLatLng);
    }

    /* access modifiers changed from: protected */
    public void showSpreadView(LatLng latLng, SpreadView.SpreadViewType spreadViewType) {
        Intrinsics.checkNotNullParameter(spreadViewType, "type");
        this.f22707i = latLng;
        SpreadView spreadView = this.f22704f;
        SpreadView spreadView2 = null;
        if (spreadView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
            spreadView = null;
        }
        spreadView.setVisibility(0);
        SpreadView spreadView3 = this.f22704f;
        if (spreadView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
            spreadView3 = null;
        }
        if (spreadView3.getSpreadType() == null) {
            SpreadView spreadView4 = this.f22704f;
            if (spreadView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
                spreadView4 = null;
            }
            spreadView4.setSpreadType(spreadViewType);
        } else {
            SpreadView spreadView5 = this.f22704f;
            if (spreadView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
                spreadView5 = null;
            }
            if (spreadView5.getSpreadType() != spreadViewType) {
                SpreadView spreadView6 = this.f22704f;
                if (spreadView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
                    spreadView6 = null;
                }
                spreadView6.setSpreadType(spreadViewType);
            }
        }
        m18694i();
        SpreadView spreadView7 = this.f22704f;
        if (spreadView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
        } else {
            spreadView2 = spreadView7;
        }
        spreadView2.start();
    }

    /* access modifiers changed from: protected */
    public void hideSpreadView() {
        SpreadView spreadView = null;
        this.f22707i = null;
        SpreadView spreadView2 = this.f22704f;
        if (spreadView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
            spreadView2 = null;
        }
        if (spreadView2.isShown()) {
            SpreadView spreadView3 = this.f22704f;
            if (spreadView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
                spreadView3 = null;
            }
            spreadView3.setVisibility(8);
            SpreadView spreadView4 = this.f22704f;
            if (spreadView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
            } else {
                spreadView = spreadView4;
            }
            spreadView.stop();
        }
    }

    /* access modifiers changed from: protected */
    public void showMapWithRiderArrivedSender() {
        SenderMarker a = m18683a();
        if (a != null) {
            a.show(m18689d());
        }
        m18693h();
    }

    /* access modifiers changed from: protected */
    public void showInfoWindow(boolean z, Tip tip, LatLng latLng, boolean z2, int i, boolean z3) {
        if (tip != null) {
            m18695j();
            if (!TextUtils.isEmpty(tip.getStatusDesc())) {
                m18686a(z, tip, latLng, true, i);
            }
            if (!z3 || tip.getCountDown() < 0) {
                hideSpreadView();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long countDown = tip.getCountDown() * ((long) 1000);
            long max = Math.max(0, countDown - currentTimeMillis);
            LogUtil.m18185i(f22698p, countDown + '-' + System.currentTimeMillis() + "= MapTipInfo countdownTime：" + max);
            CountDownTimer orderMapView$showInfoWindow$1$1 = new OrderMapView$showInfoWindow$1$1(z2, this, max);
            this.f22708j = orderMapView$showInfoWindow$1$1;
            if (orderMapView$showInfoWindow$1$1 != null) {
                orderMapView$showInfoWindow$1$1.start();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void hideInfoWindow(boolean z) {
        MarkerInfoWindowView markerInfoWindowView = null;
        this.f22709k = null;
        LogUtil.m18185i(f22698p, "hideInfoWindow ：");
        if (z) {
            MarkerInfoWindowView markerInfoWindowView2 = this.f22703e;
            if (markerInfoWindowView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInfoWindowView");
            } else {
                markerInfoWindowView = markerInfoWindowView2;
            }
            markerInfoWindowView.hideViewWithAnim();
        } else {
            MarkerInfoWindowView markerInfoWindowView3 = this.f22703e;
            if (markerInfoWindowView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInfoWindowView");
            } else {
                markerInfoWindowView = markerInfoWindowView3;
            }
            markerInfoWindowView.hideViewImmediately();
        }
        RiderMarker c = m18688c();
        if (c != null) {
            c.hideInfoWindow();
        }
        m18695j();
    }

    /* renamed from: g */
    private final void m18692g() {
        MarkerInfoWindowView markerInfoWindowView = null;
        this.f22709k = null;
        LogUtil.m18185i(f22698p, "hideInfoWindow ：");
        MarkerInfoWindowView markerInfoWindowView2 = this.f22703e;
        if (markerInfoWindowView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInfoWindowView");
            markerInfoWindowView2 = null;
        }
        if (markerInfoWindowView2.isShown()) {
            MarkerInfoWindowView markerInfoWindowView3 = this.f22703e;
            if (markerInfoWindowView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInfoWindowView");
            } else {
                markerInfoWindowView = markerInfoWindowView3;
            }
            markerInfoWindowView.hideViewImmediately();
        }
    }

    /* access modifiers changed from: protected */
    public void clearAllMapElement() {
        ReceiverMarker b = m18687b();
        if (b != null) {
            b.remove();
        }
        SenderMarker a = m18683a();
        if (a != null) {
            a.remove();
        }
        RiderMarker c = m18688c();
        if (c != null) {
            c.remove();
        }
    }

    /* access modifiers changed from: protected */
    public void clearMapExceptRider() {
        ReceiverMarker b = m18687b();
        if (b != null) {
            b.remove();
        }
        SenderMarker a = m18683a();
        if (a != null) {
            a.remove();
        }
    }

    /* renamed from: h */
    private final void m18693h() {
        RiderMarker c = m18688c();
        if (c != null) {
            if (!c.isExist()) {
                c.show(m18691f());
            } else {
                c.setVisible(true);
                LatLng f = m18691f();
                if (f != null) {
                    c.getMarker().setPosition(f);
                }
            }
            c.updateIcon();
        }
    }

    /* access modifiers changed from: protected */
    public void showMapWithRiderComing() {
        LogUtil.m18185i(f22698p, "showMapWithRiderComing");
        SenderMarker a = m18683a();
        if (a != null) {
            a.show(m18689d(), m18691f());
        }
        m18693h();
    }

    /* access modifiers changed from: protected */
    public void showMapWithRiderToDelivering(boolean z) {
        m18693h();
        ReceiverMarker b = m18687b();
        if (b != null) {
            b.show(m18690e(), m18691f());
        }
    }

    /* access modifiers changed from: protected */
    public void showMapWithRiderArriveReceiver() {
        ReceiverMarker b = m18687b();
        if (b != null) {
            b.show(m18690e());
        }
        m18693h();
    }

    /* renamed from: i */
    private final void m18694i() {
        if (this.f22707i != null) {
            SodaMapView sodaMapView = this.f22702d;
            SpreadView spreadView = null;
            if (sodaMapView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
                sodaMapView = null;
            }
            PointF screenLocation = sodaMapView.getScreenLocation(this.f22707i);
            Intrinsics.checkNotNullExpressionValue(screenLocation, "mSodaMapView.getScreenLo…on(mSpreadCenterLocation)");
            SpreadView spreadView2 = this.f22704f;
            if (spreadView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
            } else {
                spreadView = spreadView2;
            }
            spreadView.updateLocation(screenLocation.x, screenLocation.y);
        }
    }

    /* renamed from: j */
    private final void m18695j() {
        CountDownTimer countDownTimer = this.f22708j;
        if (countDownTimer != null) {
            Intrinsics.checkNotNull(countDownTimer);
            countDownTimer.cancel();
            this.f22708j = null;
        }
    }

    /* renamed from: a */
    private final void m18686a(boolean z, Tip tip, LatLng latLng, boolean z2, int i) {
        String statusDesc = tip.getStatusDesc();
        String subStatusDesc = tip.getSubStatusDesc();
        LogUtil.m18183e("gl--test", Intrinsics.stringPlus(" getSpan", subStatusDesc));
        MarkerInfoWindowView markerInfoWindowView = null;
        if (z) {
            m18692g();
            RiderMarker c = m18688c();
            if (c != null) {
                c.updateInfoWindow(new InfoWindowViewBuildConfig.Builder().setTitle(statusDesc).setCategory(3).setSubDesc(subStatusDesc).setOrderStatus(i).build(), (OnInfoWindowClickListener) null);
                return;
            }
            return;
        }
        this.f22709k = latLng;
        LogUtil.m18185i(f22698p, "showInfoWindowView location：" + this.f22709k + " hasAnim=" + z2);
        if (this.f22709k != null) {
            MarkerInfoWindowView markerInfoWindowView2 = this.f22703e;
            if (markerInfoWindowView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInfoWindowView");
                markerInfoWindowView2 = null;
            }
            markerInfoWindowView2.setMarkInfoWindowRes(i);
            if (z2) {
                MarkerInfoWindowView markerInfoWindowView3 = this.f22703e;
                if (markerInfoWindowView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInfoWindowView");
                } else {
                    markerInfoWindowView = markerInfoWindowView3;
                }
                markerInfoWindowView.showView(statusDesc, subStatusDesc, false);
            } else {
                MarkerInfoWindowView markerInfoWindowView4 = this.f22703e;
                if (markerInfoWindowView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInfoWindowView");
                } else {
                    markerInfoWindowView = markerInfoWindowView4;
                }
                markerInfoWindowView.updateView(statusDesc, subStatusDesc, false);
            }
            m18696k();
        }
    }

    /* renamed from: k */
    private final void m18696k() {
        MarkerInfoWindowView markerInfoWindowView = this.f22703e;
        MarkerInfoWindowView markerInfoWindowView2 = null;
        if (markerInfoWindowView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInfoWindowView");
            markerInfoWindowView = null;
        }
        if (markerInfoWindowView.isShown() && this.f22709k != null) {
            SodaMapView sodaMapView = this.f22702d;
            if (sodaMapView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSodaMapView");
                sodaMapView = null;
            }
            PointF screenLocation = sodaMapView.getScreenLocation(this.f22709k);
            Intrinsics.checkNotNullExpressionValue(screenLocation, "mSodaMapView.getScreenLo…InfoWindowCenterLocation)");
            StringBuilder sb = new StringBuilder();
            sb.append("showInfoWindowView updateInfoWindowLocation：");
            sb.append(screenLocation);
            sb.append("shown=");
            MarkerInfoWindowView markerInfoWindowView3 = this.f22703e;
            if (markerInfoWindowView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInfoWindowView");
                markerInfoWindowView3 = null;
            }
            sb.append(markerInfoWindowView3.isShown());
            LogUtil.m18185i(f22698p, sb.toString());
            MarkerInfoWindowView markerInfoWindowView4 = this.f22703e;
            if (markerInfoWindowView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInfoWindowView");
            } else {
                markerInfoWindowView2 = markerInfoWindowView4;
            }
            markerInfoWindowView2.updateLocation((int) screenLocation.x, (int) screenLocation.y, this.f22710l);
        }
    }

    /* renamed from: l */
    private final void m18697l() {
        LogUtil.m18185i(f22698p, "destroyMarker===start");
        if (m18683a() != null) {
            SenderMarker a = m18683a();
            if (a != null) {
                a.onDestroy();
            }
            this.f22699a = null;
        }
        if (m18687b() != null) {
            ReceiverMarker b = m18687b();
            if (b != null) {
                b.onDestroy();
            }
            this.f22700b = null;
        }
        if (m18688c() != null) {
            RiderMarker c = m18688c();
            if (c != null) {
                c.onDestroy();
            }
            this.f22701c = null;
        }
        LogUtil.m18185i(f22698p, "destroyMarker===end");
    }
}
