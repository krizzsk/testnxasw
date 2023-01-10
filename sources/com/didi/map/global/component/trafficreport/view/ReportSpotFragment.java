package com.didi.map.global.component.trafficreport.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.didi.common.map.Map;
import com.didi.common.map.MapView;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.departure.DepartureCompParams;
import com.didi.map.global.component.departure.DepartureComponent;
import com.didi.map.global.component.departure.IDepartureCompContract;
import com.didi.map.global.component.departure.model.ApiType;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.global.component.departure.model.PinStyle;
import com.didi.map.global.component.trafficreport.map.ReportLocMapView;
import com.didi.map.global.component.trafficreport.model.ReportViewModel;
import com.didi.map.global.component.trafficreport.util.DisplayUtil;
import com.didi.map.global.component.trafficreport.util.LocUtils;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.sdk.poibase.CallFrom;
import com.taxis99.R;

public class ReportSpotFragment extends BaseFragment {

    /* renamed from: a */
    private static final String f28708a = "ReportSpotFragment";

    /* renamed from: s */
    private static final float f28709s = 18.0f;

    /* renamed from: b */
    private Context f28710b;

    /* renamed from: c */
    private FrameLayout f28711c;

    /* renamed from: d */
    private View f28712d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f28713e;

    /* renamed from: f */
    private View f28714f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public FrameLayout f28715g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public View f28716h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View f28717i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ReportSpotCardView f28718j;

    /* renamed from: k */
    private boolean f28719k = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Map f28720l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Padding f28721m = new Padding();

    /* renamed from: n */
    private ReportViewModel f28722n;

    /* renamed from: o */
    private Address f28723o;

    /* renamed from: p */
    private Address f28724p;

    /* renamed from: q */
    private Handler f28725q = new Handler(Looper.myLooper());
    /* access modifiers changed from: private */

    /* renamed from: r */
    public IDepartureCompContract f28726r;

    /* renamed from: t */
    private boolean f28727t = true;

    /* renamed from: u */
    private Runnable f28728u = new Runnable() {
        public void run() {
            if (ReportSpotFragment.this.f28726r != null) {
                ReportSpotFragment.this.f28726r.setPadding(ReportSpotFragment.this.f28721m);
            }
        }
    };

    /* renamed from: v */
    private IDepartureCompContract.IDepartureComponentCallback f28729v = new IDepartureCompContract.IDepartureComponentCallback() {
        public /* synthetic */ void onBroadOtherMapCallback(int i) {
            IDepartureCompContract.IDepartureComponentCallback.CC.$default$onBroadOtherMapCallback(this, i);
        }

        public /* synthetic */ void onClickBroadOtherInStationCard(DepartureAddress departureAddress) {
            IDepartureCompContract.IDepartureComponentCallback.CC.$default$onClickBroadOtherInStationCard(this, departureAddress);
        }

        public void onClickBubble() {
        }

        public void onConfirmPickup(DepartureAddress departureAddress) {
        }

        public /* synthetic */ void onDragging(int i) {
            IDepartureCompContract.IDepartureComponentCallback.CC.$default$onDragging(this, i);
        }

        public /* synthetic */ void onStartDragging() {
            IDepartureCompContract.IDepartureComponentCallback.CC.$default$onStartDragging(this);
        }

        public void onStartSugPage(DepartureAddress departureAddress) {
        }

        public /* synthetic */ void onStartTerminalWindow(DepartureAddress departureAddress) {
            IDepartureCompContract.IDepartureComponentCallback.CC.$default$onStartTerminalWindow(this, departureAddress);
        }

        public /* synthetic */ void onUp() {
            IDepartureCompContract.IDepartureComponentCallback.CC.$default$onUp(this);
        }

        public void onDepartureLoading(LatLng latLng) {
            ReportSpotFragment.this.m22363f();
        }

        public void onDepartureAddressChanged(DepartureAddress departureAddress) {
            ReportSpotFragment.this.m22346a(departureAddress);
        }

        public void onFetchAddressFail(LatLng latLng) {
            if (LatLngUtils.locateCorrect(latLng)) {
                DepartureAddress departureAddress = new DepartureAddress();
                Address address = new Address();
                address.latitude = latLng.latitude;
                address.longitude = latLng.longitude;
                address.displayName = ReportSpotFragment.this.getContext().getResources().getString(R.string.GRider_Sug_2020_currentLoc);
                address.fullName = ReportSpotFragment.this.getContext().getResources().getString(R.string.GRider_Sug_2020_currentLoc);
                departureAddress.setAddress(address);
                ReportSpotFragment.this.m22346a(departureAddress);
            }
        }
    };

    /* renamed from: w */
    private OnMapGestureListener f28730w = new OnMapGestureListener() {
        public boolean onDoubleTap(float f, float f2) {
            return false;
        }

        public boolean onFling(float f, float f2) {
            return false;
        }

        public boolean onLongPress(float f, float f2) {
            return false;
        }

        public void onMapStable() {
        }

        public boolean onScroll(float f, float f2) {
            return false;
        }

        public boolean onSingleTap(float f, float f2) {
            return false;
        }

        public boolean onUp(float f, float f2) {
            return false;
        }

        public boolean onDown(float f, float f2) {
            if (ReportSpotFragment.this.f28713e != null) {
                ReportSpotFragment.this.f28713e.setVisibility(0);
            }
            return false;
        }
    };

    /* renamed from: x */
    private ViewTreeObserver.OnGlobalLayoutListener f28731x = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            int height;
            if (!(ReportSpotFragment.this.f28721m == null || ReportSpotFragment.this.f28718j == null || ReportSpotFragment.this.f28721m.bottom == (height = ReportSpotFragment.this.f28718j.getHeight() + DisplayUtil.dp2px(ReportSpotFragment.this.getActivity(), 10.0f)))) {
                ReportSpotFragment.this.f28721m.bottom = height;
                ReportSpotFragment.this.m22367h();
            }
            if (ReportSpotFragment.this.f28716h != null && ReportSpotFragment.this.f28715g != null) {
                ViewGroup.LayoutParams layoutParams = ReportSpotFragment.this.f28716h.getLayoutParams();
                if (layoutParams.height != ReportSpotFragment.this.f28715g.getHeight()) {
                    layoutParams.height = ReportSpotFragment.this.f28715g.getHeight();
                    ReportSpotFragment.this.f28716h.setLayoutParams(layoutParams);
                }
            }
        }
    };

    public boolean onBackPressed() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f28710b = getActivity();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_report_detail_loc_fragment, (ViewGroup) null);
        m22345a(inflate);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ReportViewModel reportViewModel = (ReportViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity(), (ViewModelProvider.Factory) new ViewModelProvider.NewInstanceFactory()).get(ReportViewModel.class);
        this.f28722n = reportViewModel;
        reportViewModel.getAddress().observe(getActivity(), new Observer() {
            public final void onChanged(Object obj) {
                ReportSpotFragment.this.m22349a((Address) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22349a(Address address) {
        this.f28723o = address;
    }

    public void onResume() {
        super.onResume();
        ReportLocMapView.getInstance(getContext()).onAdd(this.f28711c);
        ReportLocMapView.getInstance(getContext()).onResume();
        ReportLocMapView.getInstance(getContext()).setNeedLocation(true);
        final MapView mapView = ReportLocMapView.getInstance(getActivity()).getMapView();
        if (mapView != null && this.f28727t) {
            mapView.getMapAsync(new OnMapReadyCallBack() {
                public void onMapReady(Map map) {
                    SystemUtils.log(3, ReportSpotFragment.f28708a, "onMapReady: ", (Throwable) null, "com.didi.map.global.component.trafficreport.view.ReportSpotFragment$2", 121);
                    Map unused = ReportSpotFragment.this.f28720l = map;
                    ReportSpotFragment.this.m22344a();
                    ReportSpotFragment reportSpotFragment = ReportSpotFragment.this;
                    reportSpotFragment.m22352b(reportSpotFragment.f28717i);
                    ReportSpotFragment.this.addOnMapGestureListener(map);
                    mapView.sendAccessibilityEvent(8);
                }
            });
        }
        IDepartureCompContract iDepartureCompContract = this.f28726r;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.onMapVisible(true);
        }
    }

    public void onPause() {
        super.onPause();
        IDepartureCompContract iDepartureCompContract = this.f28726r;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.onMapVisible(false);
        }
        this.f28727t = false;
    }

    public void onDestroyView() {
        removeOnMapGestureListener(this.f28720l);
        m22353c();
        Handler handler = this.f28725q;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        View view = this.f28712d;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f28731x);
        }
        Handler handler2 = this.f28725q;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
        }
        ReportLocMapView.getInstance(getContext()).onRemove(this.f28711c);
        super.onDestroyView();
    }

    /* renamed from: a */
    private void m22345a(View view) {
        this.f28712d = view;
        this.f28711c = (FrameLayout) view.findViewById(R.id.mapContainer);
        this.f28713e = view.findViewById(R.id.iv_reset_map);
        this.f28714f = view.findViewById(R.id.img_left_small_container);
        this.f28715g = (FrameLayout) view.findViewById(R.id.cardViewContainer);
        this.f28716h = view.findViewById(R.id.card_mask_bg);
        this.f28717i = view.findViewById(R.id.mapViewOverLayer);
        ((ReportDetailTitle) view.findViewById(R.id.report_detail_title)).setTitle(getResources().getString(R.string.GRider_PassengerReports__YoAe));
        this.f28713e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ReportSpotFragment.this.m22364f(view);
            }
        });
        this.f28714f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ReportSpotFragment.this.m22360e(view);
            }
        });
        ReportSpotCardView reportSpotCardView = new ReportSpotCardView(getActivity());
        this.f28718j = reportSpotCardView;
        reportSpotCardView.requestPoiSelectCardFeature();
        this.f28718j.setConfirmOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ReportSpotFragment.this.m22358d(view);
            }
        });
        this.f28718j.setOnCancelOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ReportSpotFragment.this.m22354c(view);
            }
        });
        this.f28715g.addView(this.f28718j);
        this.f28712d.getViewTreeObserver().addOnGlobalLayoutListener(this.f28731x);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m22364f(View view) {
        m22366g();
        this.f28713e.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m22360e(View view) {
        getActivity().onBackPressed();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m22358d(View view) {
        this.f28722n.setAddress(this.f28724p);
        getActivity().onBackPressed();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m22354c(View view) {
        getActivity().onBackPressed();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22344a() {
        m22353c();
        m22351b();
    }

    /* renamed from: b */
    private void m22351b() {
        DepartureComponent departureComponent = new DepartureComponent();
        this.f28726r = departureComponent;
        departureComponent.setConfigParam(m22357d());
        this.f28726r.create(getContext(), this.f28720l);
        this.f28726r.registerCallback(this.f28729v);
        this.f28726r.start();
    }

    /* renamed from: c */
    private void m22353c() {
        IDepartureCompContract iDepartureCompContract = this.f28726r;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.destroy();
            this.f28726r = null;
        }
    }

    /* renamed from: d */
    private DepartureCompParams m22357d() {
        CallFrom callFrom = CallFrom.PAX_USER_REPORT;
        PinStyle pinStyle = new PinStyle();
        pinStyle.rectVisible = false;
        pinStyle.pinNormalColor = Color.parseColor("#ff8903");
        return new DepartureCompParams.Builder().requireByDrag(true).isPinVisible(true).isBubbleVisible(false).isFenceVisible(false).isRecPointVisible(false).isGuideLineVisible(true).locationInfo(m22359e()).pinStyle(pinStyle).callFrom(callFrom).apiType(ApiType.DEPARTURE_REVERSE_GEO).zoom(18.0f).build();
    }

    /* renamed from: e */
    private DepartureLocationInfo m22359e() {
        Map map;
        LatLng currentLocation = LocUtils.getCurrentLocation(this.f28710b);
        Address address = this.f28723o;
        if (address != null) {
            currentLocation = new LatLng(address.getLatitude(), this.f28723o.getLongitude());
        }
        if (!(currentLocation != null || (map = this.f28720l) == null || map.getCameraPosition() == null)) {
            currentLocation = this.f28720l.getCameraPosition().target;
        }
        if (currentLocation != null) {
            return new DepartureLocationInfo(currentLocation, this.f28723o, "wgs84");
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m22363f() {
        ReportSpotCardView reportSpotCardView = this.f28718j;
        if (reportSpotCardView != null) {
            reportSpotCardView.showLoading();
        }
        this.f28715g.removeAllViews();
        this.f28715g.addView(this.f28718j);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22346a(DepartureAddress departureAddress) {
        View departureCardView;
        if (departureAddress != null && departureAddress.getAddress() != null) {
            this.f28724p = departureAddress.getAddress();
            IDepartureCompContract iDepartureCompContract = this.f28726r;
            if (iDepartureCompContract == null || (departureCardView = iDepartureCompContract.getDepartureCardView()) == null) {
                this.f28715g.removeAllViews();
                this.f28715g.addView(this.f28718j);
                String string = getContext().getResources().getString(R.string.GRider_Sug_2020_currentLoc);
                if (!(departureAddress == null || departureAddress.getAddress() == null)) {
                    if (!TextUtils.isEmpty(departureAddress.getAddress().getDisplayName())) {
                        string = departureAddress.getAddress().getDisplayName();
                    } else {
                        departureAddress.getAddress().displayName = string;
                    }
                }
                this.f28718j.setAddress(string);
                return;
            }
            this.f28715g.removeAllViews();
            this.f28715g.addView(departureCardView);
            View view = this.f28713e;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    /* renamed from: g */
    private void m22366g() {
        IDepartureCompContract iDepartureCompContract;
        LatLng currentLocation = LocUtils.getCurrentLocation(this.f28710b);
        if (currentLocation != null && (iDepartureCompContract = this.f28726r) != null) {
            DepartureLocationInfo locationInfo = iDepartureCompContract.getLocationInfo();
            locationInfo.latLng = currentLocation;
            this.f28726r.updateDepartureLocation(locationInfo);
        }
    }

    /* access modifiers changed from: protected */
    public void addOnMapGestureListener(Map map) {
        if (map != null) {
            map.removeOnMapGestureListener(this.f28730w);
            map.addOnMapGestureListener(this.f28730w);
        }
    }

    /* access modifiers changed from: protected */
    public void removeOnMapGestureListener(Map map) {
        if (map != null) {
            map.removeOnMapGestureListener(this.f28730w);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m22367h() {
        Handler handler = this.f28725q;
        if (handler != null) {
            handler.removeCallbacks(this.f28728u);
            this.f28725q.postDelayed(this.f28728u, 300);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m22352b(View view) {
        if (view != null) {
            ObjectAnimator objectAnimator = new ObjectAnimator();
            objectAnimator.setPropertyName("alpha");
            objectAnimator.setDuration(1000);
            objectAnimator.setFloatValues(new float[]{1.0f, 0.0f});
            objectAnimator.setTarget(view);
            objectAnimator.start();
        }
    }
}
