package com.didi.addressnew.framework.fragmentmarket.openride;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.address.FromType;
import com.didi.address.model.IWayPointsPostCallback;
import com.didi.address.model.SugMapConstants;
import com.didi.address.model.SugParams;
import com.didi.address.model.WayPoint;
import com.didi.addressnew.framework.fragmentmarket.FragmentFactory;
import com.didi.addressnew.framework.fragmentmarket.base.IFragment;
import com.didi.addressnew.framework.fragmentmarket.map.ISugWayPointPageView;
import com.didi.addressnew.framework.fragmentmarket.map.SugMapBaseFragment;
import com.didi.addressnew.framework.fragmentmarket.map.adapter.SugWayPointListViewAdapter;
import com.didi.addressnew.framework.fragmentmarket.map.mode.SugWayPointItemViewTouchCallback;
import com.didi.addressnew.framework.fragmentmarket.map.presenter.SugMapWayPointPagePresenter;
import com.didi.addressnew.framework.fragmentmarket.map.view.SugWayPointEditView;
import com.didi.addressnew.framework.fragmentmarket.map.view.WayPointRcyViewSpacesItemDecoration;
import com.didi.addressnew.framework.mapholder.SugSharedMapView;
import com.didi.addressnew.framework.switcher.result.AddressResultEnhancer;
import com.didi.addressnew.util.AddressTrack;
import com.didi.addressnew.util.CommonUtils;
import com.didi.addressnew.util.ViewFastDoubleClickInterceptor;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.MapView;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import com.didi.map.global.component.line.pax.commonline.CommonLineManager;
import com.didi.map.global.component.line.pax.commonline.CommonLineParam;
import com.didi.map.global.component.markers.IMarkersCompContract;
import com.didi.map.global.component.markers.MarkersCompParams;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.routesearchsdk.CallFrom;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OpenRideWayPointFragment extends SugMapBaseFragment implements ISugWayPointPageView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f9140a = OpenRideWayPointFragment.class.getSimpleName();

    /* renamed from: b */
    private View f9141b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextView f9142c;

    /* renamed from: d */
    private ImageView f9143d;

    /* renamed from: e */
    private RecyclerView f9144e;

    /* renamed from: f */
    private FrameLayout f9145f;

    /* renamed from: g */
    private SugWayPointListViewAdapter f9146g;

    /* renamed from: h */
    private FrameLayout f9147h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View f9148i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View f9149j;

    /* renamed from: k */
    private CommonLineManager f9150k;

    /* renamed from: l */
    private IMarkersCompContract f9151l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ItemTouchHelper f9152m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public SugMapWayPointPagePresenter f9153n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public List<WayPoint> f9154o = new ArrayList();

    /* renamed from: p */
    private boolean f9155p = false;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Map f9156q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public Padding f9157r = new Padding();

    /* renamed from: s */
    private Handler f9158s = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: t */
    public ArrayList<Boolean> f9159t = new ArrayList<>(4);

    /* renamed from: u */
    private Runnable f9160u = new Runnable() {
        public void run() {
            OpenRideWayPointFragment.this.m7953g();
        }
    };

    /* renamed from: v */
    private ViewTreeObserver.OnGlobalLayoutListener f9161v = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (OpenRideWayPointFragment.this.f9157r != null && OpenRideWayPointFragment.this.f9149j != null && OpenRideWayPointFragment.this.f9142c != null) {
                Padding padding = new Padding(0, OpenRideWayPointFragment.this.f9149j.getHeight(), 0, OpenRideWayPointFragment.this.f9142c.getHeight() + DisplayUtils.dp2px(OpenRideWayPointFragment.this.getActivity(), 20.0f));
                if (!OpenRideWayPointFragment.this.f9157r.equals(padding)) {
                    Padding unused = OpenRideWayPointFragment.this.f9157r = padding;
                    OpenRideWayPointFragment.this.m7940b();
                }
            }
        }
    };

    /* renamed from: w */
    private View.OnClickListener f9162w = new View.OnClickListener() {
        public final void onClick(View view) {
            OpenRideWayPointFragment.this.m7932a(view);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: x */
    public WayPoint f9163x;

    /* renamed from: y */
    private SugWayPointListViewAdapter.WayPointRecyclerAdapterCallback f9164y = new SugWayPointListViewAdapter.WayPointRecyclerAdapterCallback() {
        public void onDragStart(RecyclerView.ViewHolder viewHolder) {
            OpenRideWayPointFragment.this.f9152m.startDrag(viewHolder);
            for (WayPoint draging : OpenRideWayPointFragment.this.f9154o) {
                draging.setDraging(true);
            }
            OpenRideWayPointFragment.this.setSubmitEnable(false);
        }

        public void onDradEnd() {
            for (WayPoint draging : OpenRideWayPointFragment.this.f9154o) {
                draging.setDraging(false);
            }
            if (OpenRideWayPointFragment.this.f9153n != null) {
                OpenRideWayPointFragment.this.f9153n.updateSubmitStatus(OpenRideWayPointFragment.this.f9154o);
            }
            OpenRideWayPointFragment.this.onWayPointsUpdated();
        }

        public void addToStopPoints(WayPoint wayPoint) {
            if (OpenRideWayPointFragment.this.f9153n != null) {
                OpenRideWayPointFragment.this.f9153n.addToStopPoints(wayPoint);
            }
        }

        public void clearStopPoints() {
            if (OpenRideWayPointFragment.this.f9153n != null) {
                OpenRideWayPointFragment.this.f9153n.clearStopPoints();
            }
        }

        public boolean addStopAble() {
            return OpenRideWayPointFragment.this.f9153n.canAddStop();
        }
    };

    /* renamed from: z */
    private SugWayPointEditView.OnActionListener f9165z = new SugWayPointEditView.OnActionListener() {
        public void onSelectAddress(WayPoint wayPoint, int i) {
            if (OpenRideWayPointFragment.this.f9159t == null || i >= OpenRideWayPointFragment.this.f9159t.size() || ((Boolean) OpenRideWayPointFragment.this.f9159t.get(i)).booleanValue()) {
                WayPoint unused = OpenRideWayPointFragment.this.f9163x = wayPoint;
                SugParams clone = OpenRideWayPointFragment.this.getmParam().clone();
                if (OpenRideWayPointFragment.this.getmParam().fromType == FromType.HOME) {
                    clone.fromType = FromType.FROM_HOME_ROUTE_EDITOR;
                } else if (OpenRideWayPointFragment.this.getmParam().fromType == FromType.CONFIRM_NEW || OpenRideWayPointFragment.this.getmParam().fromType == FromType.CONFIRM) {
                    clone.fromType = FromType.FROM_CONFIRM_ROUTE_EDITOR;
                } else {
                    clone.fromType = FromType.ROUTE_EDITOR;
                }
                if (wayPoint.getWayPointType() == 2) {
                    int i2 = i == 1 ? 101 : 102;
                    clone.addressParam.addressType = i2;
                    OpenRideWayPointFragment.this.getmParam().addressParam.addressType = i2;
                    Address address = wayPoint.getAddress();
                    if (TextUtils.isEmpty(address.displayName) || address.getLatitude() == 0.0d || address.getLongitude() == 0.0d) {
                        OpenRideWayPointFragment.this.getmResult().setResultAllowNull(i2, (Address) null);
                    } else {
                        OpenRideWayPointFragment.this.getmResult().setCommon(wayPoint.getAddress());
                    }
                    AddressTrack.trackWayPointViewCK(clone);
                    OpenRideWayPointFragment openRideWayPointFragment = OpenRideWayPointFragment.this;
                    openRideWayPointFragment.onConfirm(clone, openRideWayPointFragment.getmResult());
                    OpenRideWayPointFragment openRideWayPointFragment2 = OpenRideWayPointFragment.this;
                    openRideWayPointFragment2.switchSingle(clone, openRideWayPointFragment2.getmResult(), i2);
                    return;
                }
                Address address2 = wayPoint.getAddress();
                if (wayPoint.getWayPointType() == 1) {
                    clone.addressParam.addressType = 1;
                    OpenRideWayPointFragment.this.getmParam().addressParam.addressType = 1;
                    if (TextUtils.isEmpty(address2.displayName) || address2.getLatitude() == 0.0d || address2.getLongitude() == 0.0d) {
                        OpenRideWayPointFragment.this.getmResult().setResultAllowNull(1, (Address) null);
                    } else {
                        OpenRideWayPointFragment.this.getmResult().setStart(wayPoint.getAddress());
                    }
                    OpenRideWayPointFragment openRideWayPointFragment3 = OpenRideWayPointFragment.this;
                    openRideWayPointFragment3.onConfirm(clone, openRideWayPointFragment3.getmResult());
                } else if (wayPoint.getWayPointType() == 3) {
                    clone.addressParam.addressType = 2;
                    OpenRideWayPointFragment.this.getmParam().addressParam.addressType = 2;
                    if (TextUtils.isEmpty(address2.displayName) || address2.getLatitude() == 0.0d || address2.getLongitude() == 0.0d) {
                        OpenRideWayPointFragment.this.getmResult().setResultAllowNull(2, (Address) null);
                    } else {
                        OpenRideWayPointFragment.this.getmResult().setEnd(wayPoint.getAddress());
                    }
                    OpenRideWayPointFragment openRideWayPointFragment4 = OpenRideWayPointFragment.this;
                    openRideWayPointFragment4.onConfirm(clone, openRideWayPointFragment4.getmResult());
                }
                OpenRideWayPointFragment openRideWayPointFragment5 = OpenRideWayPointFragment.this;
                openRideWayPointFragment5.switchFull(clone, openRideWayPointFragment5.getmResult());
            }
        }

        public void addToChangedWayPoints(WayPoint wayPoint) {
            if (OpenRideWayPointFragment.this.f9153n != null) {
                OpenRideWayPointFragment.this.f9153n.addToChangedWayPoints(wayPoint);
            }
        }
    };

    public boolean getDragHandlerEnable() {
        return true;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.map_waypoint_edit_fragment_layout;
    }

    public void updatePageContent() {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7940b() {
        Handler handler = this.f9158s;
        if (handler != null) {
            handler.removeCallbacks(this.f9160u);
            this.f9158s.postDelayed(this.f9160u, 300);
        }
    }

    /* access modifiers changed from: protected */
    public void onInit(View view) {
        this.f9141b = view;
        this.f9149j = view.findViewById(R.id.cardView);
        this.f9144e = (RecyclerView) view.findViewById(R.id.rvWayPointList);
        this.f9147h = (FrameLayout) view.findViewById(R.id.progressbarView);
        this.f9148i = view.findViewById(R.id.mapViewOverLayer);
        this.f9145f = (FrameLayout) view.findViewById(R.id.mapContainer);
        TextView textView = (TextView) view.findViewById(R.id.tvWayPointSubmit);
        this.f9142c = textView;
        textView.setOnClickListener(this.f9162w);
        ImageView imageView = (ImageView) view.findViewById(R.id.imgMapReset);
        this.f9143d = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OpenRideWayPointFragment.this.m7941b(view);
            }
        });
        try {
            this.f9142c.setTextColor(ContextCompat.getColorStateList(getActivity(), DidiThemeManager.getIns().getResPicker(getActivity()).getResIdByTheme(R.attr.submit_btn_text_color_selector)));
            this.f9142c.setBackground(DidiThemeManager.getIns().getResPicker(getActivity()).getDrawable(R.attr.submit_btn_bg_new_selector));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        m7945c();
        m7947d();
        SugWayPointListViewAdapter sugWayPointListViewAdapter = new SugWayPointListViewAdapter(getContext());
        this.f9146g = sugWayPointListViewAdapter;
        sugWayPointListViewAdapter.setOnActionListener(this.f9165z);
        this.f9146g.setWayPointRecyclerAdapterCallback(this.f9164y);
        this.f9146g.setDataList(this.f9154o);
        this.f9144e.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        this.f9144e.addItemDecoration(new WayPointRcyViewSpacesItemDecoration(DisplayUtils.dp2px(getActivity(), 2.0f)));
        this.f9144e.setAdapter(this.f9146g);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SugWayPointItemViewTouchCallback(this.f9146g));
        this.f9152m = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(this.f9144e);
        SugMapWayPointPagePresenter sugMapWayPointPagePresenter = new SugMapWayPointPagePresenter(this, this.mWayPointParam);
        this.f9153n = sugMapWayPointPagePresenter;
        this.f9146g.setWayPointEditPagePresenter(sugMapWayPointPagePresenter);
        this.f9146g.notifyDataSetChanged();
        this.f9155p = false;
        this.f9141b.getViewTreeObserver().addOnGlobalLayoutListener(this.f9161v);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m7941b(View view) {
        m7940b();
    }

    /* renamed from: c */
    private void m7945c() {
        this.f9159t.clear();
        for (int i = 0; i < 4; i++) {
            this.f9159t.add(i, true);
        }
        this.f9159t.set(0, false);
    }

    /* renamed from: d */
    private void m7947d() {
        List<WayPoint> list = this.f9154o;
        if (list != null) {
            for (WayPoint next : list) {
                if (next != null && next.getWayPointType() == 1) {
                    next.setUIEnable(false);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m7948e() {
        logWriter("refreshComponents start...");
        onWayPointsUpdated();
    }

    /* access modifiers changed from: protected */
    public void onShowMapReset() {
        ImageView imageView = this.f9143d;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public void onPageEnter() {
        super.onPageEnter();
        logWriter("onPageEnter");
        this.f9155p = false;
        SugParams sugParams = getmParam();
        Address result = getmResult().getResult(sugParams.addressParam.addressType);
        if (getView() != null) {
            getView().requestFocus();
        }
        if (!(isFirstEnter() || sugParams.addressParam.addressType == 1 || sugParams.addressParam.addressType == 2)) {
            delSwitcherResultAddress(sugParams.addressParam.addressType);
        }
        boolean z = getmResult().getLastOperType() == AddressResultEnhancer.OperType.Cancel;
        if (!(result == null || this.f9163x == null || z)) {
            logWriter("onPageEnter onAddressResult");
            this.f9153n.onAddressResult(result, this.f9163x);
        }
        AddressTrack.trackWayPointSW(sugParams.wayPointParam);
        if (isFirstEnter()) {
            AddressTrack.trackSugPageSW(1, 1, 0);
        }
        SugSharedMapView.getInstance(getActivity()).onAdd(this.f9145f);
        MapView mapView = SugSharedMapView.getInstance(getActivity()).getMapView();
        if (mapView != null) {
            mapView.getMapAsync(new OnMapReadyCallBack() {
                public void onMapReady(Map map) {
                    Map unused = OpenRideWayPointFragment.this.f9156q = map;
                    OpenRideWayPointFragment.this.addOnMapGestureListener(map);
                    OpenRideWayPointFragment.this.m7948e();
                    OpenRideWayPointFragment openRideWayPointFragment = OpenRideWayPointFragment.this;
                    openRideWayPointFragment.playAnimationMapLayer(openRideWayPointFragment.f9148i);
                    OpenRideWayPointFragment.this.m7940b();
                }
            });
        }
    }

    public void onPageExit() {
        logWriter("onPageExit...");
        this.f9155p = true;
        m7959j();
        m7957i();
        removeOnMapGestureListener(this.f9156q);
        this.f9156q = null;
        super.onPageExit();
    }

    /* renamed from: a */
    private LatLng m7929a(Address address) {
        if (address.getLongitude() == 0.0d || address.getLongitude() == 0.0d) {
            return null;
        }
        return new LatLng(address.getLatitude(), address.getLongitude());
    }

    /* renamed from: f */
    private void m7950f() {
        LatLng latLng;
        logWriter("addLineComponent");
        if (!this.mDestroyed && this.f9156q != null) {
            m7959j();
            m7957i();
            if (this.f9154o.isEmpty()) {
                logWriter("addLineComponent mWayPointList.isEmpty()");
                return;
            }
            ArrayList arrayList = new ArrayList();
            LatLng a = m7929a(this.f9154o.get(0).getAddress());
            if (a != null) {
                arrayList.add(a);
            }
            ArrayList arrayList2 = new ArrayList();
            int size = this.f9154o.size();
            if (size > 1) {
                if (size > 2) {
                    for (int i = 1; i < size - 1; i++) {
                        LatLng a2 = m7929a(this.f9154o.get(i).getAddress());
                        if (a2 != null) {
                            arrayList2.add(a2);
                        }
                    }
                }
                latLng = m7929a(this.f9154o.get(size - 1).getAddress());
            } else {
                latLng = null;
            }
            if (!arrayList2.isEmpty()) {
                arrayList.addAll(arrayList2);
            }
            if (latLng != null) {
                arrayList.add(latLng);
            }
            if (arrayList.size() > 1) {
                LineParams lineParams = new LineParams((List<LatLng>) null, SugMapConstants.DEFAULT_WAYPOINT_MAP_LINE_COLOR, 6);
                CommonLineParam commonLineParam = new CommonLineParam();
                commonLineParam.setLineParam(lineParams);
                commonLineParam.setStartPos(a);
                commonLineParam.setEndPos((LatLng) arrayList.get(arrayList.size() - 1));
                commonLineParam.setCaller(CallFrom.ORDERROUTEAPI_BUBBLE_WAYPOINT);
                commonLineParam.setWayPoints(arrayList2);
                CommonLineManager commonLineManager = new CommonLineManager(getContext(), this.f9156q, commonLineParam);
                this.f9150k = commonLineManager;
                commonLineManager.setListener(new OnLineDrawStatusListener() {
                    public /* synthetic */ void onLineDrawStart() {
                        OnLineDrawStatusListener.CC.$default$onLineDrawStart(this);
                    }

                    public void onLineDrawFinished() {
                        SystemUtils.log(4, OpenRideWayPointFragment.f9140a, "mLineComponent line onRefresh", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideWayPointFragment$4", 336);
                        OpenRideWayPointFragment.this.m7940b();
                    }
                });
                this.f9150k.create();
            }
            m7937a((List<LatLng>) arrayList);
        }
    }

    /* renamed from: a */
    private void m7937a(List<LatLng> list) {
        if (!this.mDestroyed) {
            m7959j();
            int size = this.f9154o.size();
            if (size != 0) {
                ArrayList arrayList = new ArrayList();
                if (size > 0) {
                    m7938a(arrayList, this.f9154o.get(0).getAddress(), "marker_0", R.drawable.waypoint_map_icon_pickup, 10);
                }
                if (size > 2) {
                    for (int i = 1; i < size - 1; i++) {
                        Address address = this.f9154o.get(i).getAddress();
                        m7938a(arrayList, address, "marker_" + i, R.drawable.waypoint_map_icon_stop_point, 8);
                    }
                }
                if (size > 1) {
                    int i2 = size - 1;
                    Address address2 = this.f9154o.get(i2).getAddress();
                    m7938a(arrayList, address2, "marker_" + i2, R.drawable.waypoint_map_icon_dest, 9);
                }
                if (!arrayList.isEmpty()) {
                    MarkersCompParams build = new MarkersCompParams.Builder().markerModels(arrayList).build();
                    MarkersComponent markersComponent = new MarkersComponent();
                    this.f9151l = markersComponent;
                    markersComponent.setConfigParam(build);
                    this.f9151l.create(getActivity(), this.f9156q);
                    if (this.f9154o.size() > 2) {
                        for (int i3 = 1; i3 < this.f9154o.size() - 1; i3++) {
                            m7936a(this.f9154o.get(i3).getAddress(), i3);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m7936a(Address address, int i) {
        if (this.f9151l != null && address != null && m7929a(address) != null) {
            TextView textView = new TextView(getActivity());
            int dp2px = DisplayUtils.dp2px(getActivity(), 5.0f);
            int dp2px2 = DisplayUtils.dp2px(getActivity(), 8.0f);
            textView.setPadding(dp2px2, dp2px, dp2px2, dp2px);
            textView.setBackgroundResource(R.drawable.waypoint_map_bubble_bg_shape);
            String str = "STOP " + i;
            if (i == 1) {
                str = getString(R.string.GRider_Sug_2020_stop1_bubble);
            } else if (i == 2) {
                str = getString(R.string.GRider_Sug_2020_stop2_bubble);
            }
            textView.setText(str);
            textView.setTextColor(-16777216);
            textView.getPaint().setFakeBoldText(true);
            textView.setTextSize(11.0f);
            this.f9151l.showMarkerInfoWindow("marker_" + i, textView);
        }
    }

    /* renamed from: a */
    private void m7938a(List<MarkerModel> list, Address address, String str, int i, int i2) {
        LatLng a = m7929a(address);
        if (a != null) {
            MarkerModel markerModel = new MarkerModel();
            markerModel.setPoint(a);
            markerModel.setId(str);
            markerModel.setMarkerIcon(BitmapFactory.decodeResource(getContext().getResources(), i));
            markerModel.setAnchorV(0.5f);
            markerModel.setAnchorU(0.5f);
            markerModel.setZOrder(i2);
            list.add(markerModel);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m7953g() {
        ImageView imageView;
        if (this.f9156q != null && (imageView = this.f9143d) != null) {
            imageView.setVisibility(8);
            ArrayList arrayList = new ArrayList();
            CommonLineManager commonLineManager = this.f9150k;
            if (!(commonLineManager == null || commonLineManager.getBestViewElements() == null)) {
                arrayList.addAll(this.f9150k.getBestViewElements());
            }
            IMarkersCompContract iMarkersCompContract = this.f9151l;
            if (!(iMarkersCompContract == null || iMarkersCompContract.getMarkers() == null)) {
                arrayList.addAll(this.f9151l.getMarkers());
            }
            if (SugSharedMapView.getInstance(getActivity()).getMyLocationMarkers() != null) {
                arrayList.addAll(SugSharedMapView.getInstance(getActivity()).getMyLocationMarkers());
            }
            if (!CollectionUtil.isEmpty((Collection<?>) arrayList)) {
                BestViewer.doBestView(this.f9156q, true, (List<IMapElement>) arrayList, this.f9157r, new Padding(DisplayUtils.dp2px(getActivity(), 10.0f), DisplayUtils.dp2px(getActivity(), 10.0f), DisplayUtils.dp2px(getActivity(), 10.0f), DisplayUtils.dp2px(getActivity(), 10.0f)), (BestViewer.IBestViewListener) null);
            }
        }
    }

    public void updateAddStopEnterVisible(WayPoint wayPoint, boolean z) {
        if (this.f9154o.contains(wayPoint)) {
            List<WayPoint> list = this.f9154o;
            list.get(list.indexOf(wayPoint)).setCanAdd(z);
            this.f9146g.clearGuideView();
            m7947d();
            this.f9146g.notifyDataSetChanged();
        }
    }

    public void onWayPointsUpdated() {
        logWriter("onWayPointsUpdated start...");
        if (!this.mDestroyed && this.f9156q != null) {
            logWriter("onWayPointsUpdated removeCallbacksAndMessages before");
            this.f9158s.removeCallbacksAndMessages((Object) null);
            logWriter("onWayPointsUpdated removeCallbacksAndMessages after");
            this.f9158s.postDelayed(new Runnable() {
                public final void run() {
                    OpenRideWayPointFragment.this.m7961k();
                }
            }, 300);
            logWriter("onWayPointsUpdated removeCallbacksAndMessages postDelayed after");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void m7961k() {
        logWriter("onWayPointsUpdated size=" + this.f9154o.size());
        if (!this.f9155p) {
            m7955h();
        }
    }

    /* renamed from: h */
    private void m7955h() {
        m7950f();
        m7940b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m7932a(View view) {
        if (view.getId() == this.f9142c.getId() && !ViewFastDoubleClickInterceptor.isFastClick()) {
            FragmentActivity fragmentActivity = getActivity() != null ? (FragmentActivity) getActivity() : null;
            if (getSugCallback() != null) {
                setSubmitEnable(false);
                this.f9153n.sortWayPoints();
                if (CommonUtils.checkDuplicate((ArrayList) this.f9153n.getValidWayPoints())) {
                    CommonUtils.showDuplicateAlert(getContext());
                    this.f9142c.setEnabled(true);
                    return;
                }
                getSugCallback().onSubmitWayPoints(fragmentActivity, this.f9153n.getValidWayPoints(), this.f9153n.getChangedWayPoints(), new IWayPointsPostCallback() {
                    public void onSuccess() {
                        OpenRideWayPointFragment.this.setSubmitEnable(true);
                        OpenRideWayPointFragment.this.closeSessionImediately();
                        OpenRideWayPointFragment.this.logWriter("wayPoint Submit Success");
                    }

                    public void onFailure(String str) {
                        OpenRideWayPointFragment.this.setSubmitEnable(true);
                        OpenRideWayPointFragment.this.logWriter("wayPoint Submit Failure");
                    }
                });
                AddressTrack.trackWayPointConfirmCK(this.f9153n.getValidWayPoints());
            }
        }
    }

    public void setSubmitEnable(boolean z) {
        this.f9142c.setEnabled(z);
    }

    public boolean addWayPoint(WayPoint wayPoint) {
        logWriter("addWayPoint");
        if (wayPoint == null) {
            return false;
        }
        m7947d();
        int a = m7926a(wayPoint);
        if (a >= 0) {
            this.f9146g.setItemAnimFlag(true);
            this.f9146g.notifyItemInserted(a);
        }
        return true;
    }

    public boolean removeWayPoint(WayPoint wayPoint) {
        logWriter("removeWayPoint");
        if (wayPoint == null || !this.f9154o.contains(wayPoint) || !this.f9154o.contains(wayPoint)) {
            return false;
        }
        this.f9154o.remove(wayPoint);
        this.f9146g.setItemAnimFlag(false);
        onWayPointsUpdated();
        return true;
    }

    public void resetWayPointList() {
        this.f9146g.clearGuideView();
        this.f9146g.updateDataType();
    }

    /* renamed from: a */
    private int m7926a(WayPoint wayPoint) {
        int i;
        logWriter("insertWayPoint");
        if (wayPoint != null) {
            boolean z = false;
            boolean z2 = false;
            for (WayPoint next : this.f9154o) {
                if (next.getWayPointType() == 1) {
                    z = true;
                } else if (next.getWayPointType() == 3) {
                    z2 = true;
                }
            }
            int wayPointType = wayPoint.getWayPointType();
            if (wayPointType == 1) {
                if (z) {
                    this.f9154o.remove(0);
                }
                this.f9154o.add(0, wayPoint);
                return 0;
            } else if (wayPointType == 2) {
                if (z2) {
                    i = this.f9154o.size() - 1;
                } else {
                    i = this.f9154o.size();
                }
                this.f9154o.add(i, wayPoint);
                return i;
            } else if (wayPointType == 3) {
                if (z2) {
                    List<WayPoint> list = this.f9154o;
                    list.remove(list.size() - 1);
                }
                int size = this.f9154o.size();
                List<WayPoint> list2 = this.f9154o;
                list2.add(list2.size(), wayPoint);
                return size;
            }
        }
        return -1;
    }

    public boolean updateWayPoint(WayPoint wayPoint) {
        logWriter("updateWayPoint");
        if (wayPoint == null) {
            return false;
        }
        m7947d();
        if (this.f9154o.contains(wayPoint)) {
            if (!CommonUtils.checkDuplicate((ArrayList) this.f9154o)) {
                this.f9146g.clearGuideView();
                this.f9146g.notifyDataSetChanged();
                return true;
            }
            CommonUtils.showDuplicateAlert(getContext());
        }
        return false;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public FragmentFactory.FragmentType getType() {
        return FragmentFactory.FragmentType.WAYPOINT;
    }

    public Context getPageContext() {
        return getActivity();
    }

    public View getFallbackView() {
        return this.f9147h;
    }

    /* renamed from: i */
    private void m7957i() {
        CommonLineManager commonLineManager = this.f9150k;
        if (commonLineManager != null) {
            commonLineManager.destroy();
            this.f9150k = null;
        }
    }

    /* renamed from: j */
    private void m7959j() {
        IMarkersCompContract iMarkersCompContract = this.f9151l;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.destroy();
            this.f9151l = null;
        }
    }

    public void onDestroyView() {
        logWriter("onDestroyView");
        this.f9155p = true;
        Handler handler = this.f9158s;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        SugWayPointListViewAdapter sugWayPointListViewAdapter = this.f9146g;
        if (sugWayPointListViewAdapter != null) {
            sugWayPointListViewAdapter.clearGuideView();
        }
        m7959j();
        m7957i();
        View view = this.f9141b;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f9161v);
        }
        SugSharedMapView.getInstance(getActivity()).onRemove(this.f9145f);
        super.onDestroyView();
    }

    public boolean onBackPressed() {
        if (getActivity().isFinishing()) {
            return false;
        }
        getActivity().finish();
        return false;
    }

    public IFragment.ParentNode getNodeType() {
        return IFragment.ParentNode.WAYPOINT;
    }
}
