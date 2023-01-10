package com.didi.addressnew.framework.fragmentmarket.map;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.didi.address.FromType;
import com.didi.address.SugBuild;
import com.didi.addressnew.framework.fragmentmarket.FragmentFactory;
import com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl;
import com.didi.addressnew.framework.mapholder.SugSharedMapView;
import com.didi.addressnew.framework.switcher.result.AddressResultEnhancer;
import com.didi.addressnew.util.AddressConvertUtil;
import com.didi.addressnew.util.AddressTrack;
import com.didi.addressnew.util.ViewFastDoubleClickInterceptor;
import com.didi.common.map.Map;
import com.didi.common.map.MapView;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.departure.DepartureCompParams;
import com.didi.map.global.component.departure.DepartureComponent;
import com.didi.map.global.component.departure.IDepartureCompContract;
import com.didi.map.global.component.departure.model.AddressExtendInfo;
import com.didi.map.global.component.departure.model.AddressWalkGuide;
import com.didi.map.global.component.departure.model.ApiType;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.model.DepartureFenceOptions;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.global.component.departure.model.PinStyle;
import com.didi.map.global.component.departure.view.DepartureSetPickupSpotCardView;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.global.model.omega.AppFluentOmega;
import com.didi.map.global.model.omega.GlobalOmegaTracker;
import com.didi.sdk.address.address.entity.Address;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.sdk.poibase.CallFrom;
import com.taxis99.R;
import java.util.HashMap;

public class SugMapPoiSelectFragment extends SugMapBaseFragment {

    /* renamed from: n */
    private static final int f4467n = 1;

    /* renamed from: o */
    private static final int f4468o = 2;

    /* renamed from: a */
    private View f4469a;

    /* renamed from: b */
    private View f4470b;

    /* renamed from: c */
    private View f4471c;

    /* renamed from: d */
    private ImageView f4472d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FrameLayout f4473e;

    /* renamed from: f */
    private FrameLayout f4474f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public View f4475g;

    /* renamed from: h */
    private int f4476h = 1;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public IDepartureCompContract f4477i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public DepartureSetPickupSpotCardView f4478j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public DepartureAddress f4479k;

    /* renamed from: l */
    private String f4480l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public View f4481m;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public Map f4482p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Padding f4483q = new Padding();

    /* renamed from: r */
    private Handler f4484r = new Handler(Looper.getMainLooper());

    /* renamed from: s */
    private Runnable f4485s = new Runnable() {
        public void run() {
            if (SugMapPoiSelectFragment.this.f4477i != null) {
                SugMapPoiSelectFragment.this.f4477i.setPadding(SugMapPoiSelectFragment.this.f4483q);
            }
        }
    };

    /* renamed from: t */
    private ViewTreeObserver.OnGlobalLayoutListener f4486t = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            int height;
            if (!(SugMapPoiSelectFragment.this.f4483q == null || SugMapPoiSelectFragment.this.f4478j == null || SugMapPoiSelectFragment.this.f4483q.bottom == (height = SugMapPoiSelectFragment.this.f4478j.getHeight() + DisplayUtils.dp2px(SugMapPoiSelectFragment.this.getActivity(), 10.0f)))) {
                SugMapPoiSelectFragment.this.f4483q.bottom = height;
                SugMapPoiSelectFragment.this.m2837a();
            }
            if (SugMapPoiSelectFragment.this.f4475g != null && SugMapPoiSelectFragment.this.f4473e != null) {
                ViewGroup.LayoutParams layoutParams = SugMapPoiSelectFragment.this.f4475g.getLayoutParams();
                if (layoutParams.height != SugMapPoiSelectFragment.this.f4473e.getHeight()) {
                    layoutParams.height = SugMapPoiSelectFragment.this.f4473e.getHeight();
                    SugMapPoiSelectFragment.this.f4475g.setLayoutParams(layoutParams);
                }
            }
        }
    };

    /* renamed from: u */
    private IDepartureCompContract.IDepartureComponentCallback f4487u = new IDepartureCompContract.IDepartureComponentCallback() {
        public /* synthetic */ void onBroadOtherMapCallback(int i) {
            IDepartureCompContract.IDepartureComponentCallback.CC.$default$onBroadOtherMapCallback(this, i);
        }

        public /* synthetic */ void onClickBroadOtherInStationCard(DepartureAddress departureAddress) {
            IDepartureCompContract.IDepartureComponentCallback.CC.$default$onClickBroadOtherInStationCard(this, departureAddress);
        }

        public /* synthetic */ void onDragging(int i) {
            IDepartureCompContract.IDepartureComponentCallback.CC.$default$onDragging(this, i);
        }

        public /* synthetic */ void onStartDragging() {
            IDepartureCompContract.IDepartureComponentCallback.CC.$default$onStartDragging(this);
        }

        public /* synthetic */ void onStartTerminalWindow(DepartureAddress departureAddress) {
            IDepartureCompContract.IDepartureComponentCallback.CC.$default$onStartTerminalWindow(this, departureAddress);
        }

        public /* synthetic */ void onUp() {
            IDepartureCompContract.IDepartureComponentCallback.CC.$default$onUp(this);
        }

        public void onDepartureLoading(LatLng latLng) {
            SugMapPoiSelectFragment.this.m2868k();
        }

        public void onDepartureAddressChanged(DepartureAddress departureAddress) {
            SugMapPoiSelectFragment.this.m2848b(departureAddress);
            AppFluentOmega.getInstance().stopCalculateTime(SugMapPoiSelectFragment.this.getContext(), (Map) null, 8, (HashMap<String, Object>) null);
        }

        public void onConfirmPickup(DepartureAddress departureAddress) {
            if (departureAddress != null) {
                SugMapPoiSelectFragment.this.m2842a(departureAddress.getAddress());
                SugMapPoiSelectFragment.this.m2849b(departureAddress.getAddress());
            }
        }

        public void onFetchAddressFail(LatLng latLng) {
            if (LatLngUtils.locateCorrect(latLng)) {
                DepartureAddress departureAddress = new DepartureAddress();
                Address address = new Address();
                address.latitude = latLng.latitude;
                address.longitude = latLng.longitude;
                address.displayName = SugMapPoiSelectFragment.this.getContext().getResources().getString(R.string.GRider_Sug_2020_currentLoc);
                address.fullName = SugMapPoiSelectFragment.this.getContext().getResources().getString(R.string.GRider_Sug_2020_currentLoc);
                departureAddress.setAddress(address);
                SugMapPoiSelectFragment.this.m2848b(departureAddress);
            }
        }

        public void onStartSugPage(DepartureAddress departureAddress) {
            if (!(SugMapPoiSelectFragment.this.f4479k == null || SugMapPoiSelectFragment.this.f4479k.getAddress() == null)) {
                SugMapPoiSelectFragment.this.getmResult().setResult(SugMapPoiSelectFragment.this.mCurrAddressType, SugMapPoiSelectFragment.this.f4479k.getAddress());
            }
            SugMapPoiSelectFragment sugMapPoiSelectFragment = SugMapPoiSelectFragment.this;
            sugMapPoiSelectFragment.switchBack(sugMapPoiSelectFragment.getmParam(), SugMapPoiSelectFragment.this.getmResult());
        }

        public void onClickBubble() {
            AddressExtendInfo extendInfo;
            if (SugMapPoiSelectFragment.this.getSugCallback() != null && SugMapPoiSelectFragment.this.f4479k != null && (extendInfo = SugMapPoiSelectFragment.this.f4479k.getExtendInfo()) != null) {
                SugMapPoiSelectFragment sugMapPoiSelectFragment = SugMapPoiSelectFragment.this;
                sugMapPoiSelectFragment.logWriter("mDepartureCompCallback onClickBubble extendInfo=" + extendInfo);
                AddressWalkGuide walkGuide = extendInfo.getWalkGuide();
                if (walkGuide != null && !TextUtils.isEmpty(walkGuide.getGuidePhotoH5())) {
                    SugMapPoiSelectFragment.this.getSugCallback().onOpenWebUrl(walkGuide.getGuidePhotoH5());
                }
            }
        }
    };

    public boolean getDragHandlerEnable() {
        return false;
    }

    public View getFallbackView() {
        return null;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.map_poi_select_fragment_layout;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2837a() {
        Handler handler = this.f4484r;
        if (handler != null) {
            handler.removeCallbacks(this.f4485s);
            this.f4484r.postDelayed(this.f4485s, 300);
        }
    }

    /* access modifiers changed from: protected */
    public void onInit(View view) {
        AppFluentOmega.getInstance().startCalculateTime(8);
        this.f4469a = view;
        this.f4470b = view.findViewById(R.id.map_mask);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_reset_map);
        this.f4472d = imageView;
        imageView.setContentDescription(getContext().getResources().getString(R.string.global_sug_contentdiscription_reset_click));
        this.f4472d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SugMapPoiSelectFragment.this.m2854d(view);
            }
        });
        View findViewById = view.findViewById(R.id.btnNavBack);
        this.f4471c = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SugMapPoiSelectFragment.this.m2852c(view);
            }
        });
        this.f4474f = (FrameLayout) view.findViewById(R.id.mapContainer);
        DepartureSetPickupSpotCardView departureSetPickupSpotCardView = new DepartureSetPickupSpotCardView(getActivity());
        this.f4478j = departureSetPickupSpotCardView;
        departureSetPickupSpotCardView.setButtonOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SugMapPoiSelectFragment.this.m2846b(view);
            }
        });
        this.f4478j.setSearchOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SugMapPoiSelectFragment.this.m2838a(view);
            }
        });
        if (getSugCallback() != null) {
            SugBuild sugBuild = getSugCallback().getSugBuild();
            StringBuilder sb = new StringBuilder();
            sb.append("onInit sugBuild = ");
            sb.append(sugBuild == null ? "null" : Integer.valueOf(sugBuild.getVersion()));
            logWriter(sb.toString());
            if (sugBuild != null) {
                this.f4476h = sugBuild.getVersion();
            }
        }
        m2860g();
        this.f4481m = view.findViewById(R.id.mapViewOverLayer);
        this.f4473e = (FrameLayout) view.findViewById(R.id.cardViewContainer);
        this.f4475g = view.findViewById(R.id.card_mask_bg);
        this.f4473e.addView(this.f4478j);
        this.f4469a.getViewTreeObserver().addOnGlobalLayoutListener(this.f4486t);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m2854d(View view) {
        m2845b();
        this.f4472d.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m2852c(View view) {
        onCancel(getmParam(), getmResult());
        switchBack(getmParam(), getmResult());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m2846b(View view) {
        logWriter("PickupSpotButton Click...");
        if (!ViewFastDoubleClickInterceptor.isFastClick()) {
            m2871l();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m2838a(View view) {
        logWriter("Search Click...");
        DepartureAddress departureAddress = this.f4479k;
        if (!(departureAddress == null || departureAddress.getAddress() == null)) {
            getmResult().setResult(this.mCurrAddressType, this.f4479k.getAddress());
        }
        getmResult().setMapSelectOperType(AddressResultEnhancer.MapSelectOper.Edit);
        AddressTrack.trackMapPoiSelectEditCK(getmParam().addressParam, this.mCurrAddressType);
        onConfirm(getmParam(), getmResult());
        switchBack(getmParam(), getmResult());
    }

    /* renamed from: b */
    private void m2845b() {
        IDepartureCompContract iDepartureCompContract;
        LatLng m = m2872m();
        if (m != null && (iDepartureCompContract = this.f4477i) != null) {
            DepartureLocationInfo locationInfo = iDepartureCompContract.getLocationInfo();
            locationInfo.latLng = m;
            this.f4477i.updateDepartureLocation(locationInfo);
        }
    }

    /* access modifiers changed from: protected */
    public void onShowMapReset() {
        ImageView imageView = this.f4472d;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m2851c() {
        m2874o();
        m2853d();
    }

    /* renamed from: d */
    private void m2853d() {
        DepartureComponent departureComponent = new DepartureComponent();
        this.f4477i = departureComponent;
        departureComponent.setConfigParam(m2857e());
        this.f4477i.create(getContext(), this.f4482p);
        this.f4477i.registerCallback(this.f4487u);
        this.f4477i.start();
    }

    /* renamed from: e */
    private DepartureCompParams m2857e() {
        CallFrom callFrom = CallFrom.UNKNOWN;
        if (getmParam() != null) {
            if (getmParam().fromType == FromType.HOME || getmParam().fromType == FromType.FROM_HOME_ROUTE_EDITOR) {
                if (m2859f()) {
                    callFrom = CallFrom.GLOBAL_FROMHOME_STARTSUG_DRAG;
                } else {
                    callFrom = CallFrom.GLOBAL_FROMHOME_ENDSUG_DRAG;
                }
            } else if (getmParam().fromType == FromType.CONFIRM || getmParam().fromType == FromType.CONFIRM_NEW || getmParam().fromType == FromType.FROM_CONFIRM_ROUTE_EDITOR) {
                if (m2859f()) {
                    callFrom = CallFrom.GLOBAL_FROMBUBBLE_STARTSUG_DRAG;
                } else {
                    callFrom = CallFrom.GLOBAL_FROMBUBBLE_ENDSUG_DRAG;
                }
            } else if (m2859f()) {
                callFrom = CallFrom.GLOBAL_STARTSUG_DRAG;
            } else {
                callFrom = CallFrom.GLOBAL_ENDSUG_DRAG;
            }
        }
        if (!m2859f() || this.f4476h != 1) {
            return m2844b(callFrom);
        }
        return m2835a(callFrom);
    }

    /* renamed from: f */
    private boolean m2859f() {
        return this.mCurrAddressType == 1 || this.mCurrAddressType == 3 || this.mCurrAddressType == 4 || this.mCurrAddressType == 5;
    }

    /* renamed from: g */
    private void m2860g() {
        if (this.f4478j != null) {
            int i = this.mCurrAddressType;
            if (i == 1) {
                this.f4478j.requestPoiSelectCardFeature(1);
                this.f4480l = "origin";
            } else if (i == 2) {
                this.f4478j.requestPoiSelectCardFeature(2);
                this.f4480l = "destination";
            } else if (i == 3) {
                this.f4478j.requestPoiSelectCardFeature(5);
                this.f4480l = "home";
            } else if (i == 4) {
                this.f4478j.requestPoiSelectCardFeature(6);
                this.f4480l = "work";
            } else if (i == 5) {
                this.f4478j.requestPoiSelectCardFeature(7);
                this.f4480l = "favorite";
            } else if (i == 101) {
                this.f4478j.requestPoiSelectCardFeature(3);
                this.f4480l = "editroute";
            } else if (i == 102) {
                this.f4478j.requestPoiSelectCardFeature(4);
                this.f4480l = "editroute";
            }
        }
    }

    /* renamed from: h */
    private PinStyle m2863h() {
        PinStyle pinStyle = new PinStyle();
        if (this.mCurrAddressType == 1 || this.mCurrAddressType == 3 || this.mCurrAddressType == 4 || this.mCurrAddressType == 5) {
            pinStyle.rectVisible = false;
            pinStyle.pinNormalColor = Color.parseColor("#00ccaa");
        } else {
            pinStyle.rectVisible = false;
            pinStyle.pinNormalColor = Color.parseColor("#ff8903");
        }
        return pinStyle;
    }

    /* renamed from: i */
    private int m2864i() {
        Bundle arguments = getArguments();
        return (arguments == null || !arguments.getBoolean(FragmentImpl.KEY_MAPSELECT_PIN_TYPE)) ? 2 : 1;
    }

    /* renamed from: a */
    private DepartureCompParams m2835a(CallFrom callFrom) {
        if (this.f4482p == null || getmParam() == null) {
            return null;
        }
        DepartureFenceOptions departureFenceOptions = new DepartureFenceOptions();
        departureFenceOptions.cardWizardStart = m2864i() == 1 ? 1 : 3;
        logWriter("getDepartureCompParamsByStart wizardStart=" + departureFenceOptions.cardWizardStart);
        return new DepartureCompParams.Builder().requireByDrag(true).isPinVisible(true).isBubbleVisible(true).isFenceVisible(true).isRecPointVisible(true).isGuideLineVisible(true).pinStyle(m2863h()).fenceOptions(departureFenceOptions).locationInfo(m2873n()).callFrom(callFrom).apiType(ApiType.DEPARTURE_POI_INFO).zoom(18.0f).build();
    }

    /* renamed from: b */
    private DepartureCompParams m2844b(CallFrom callFrom) {
        if (this.f4482p == null || getmParam() == null) {
            return null;
        }
        return new DepartureCompParams.Builder().requireByDrag(true).isPinVisible(true).isBubbleVisible(true).isFenceVisible(false).isRecPointVisible(false).isGuideLineVisible(true).locationInfo(m2873n()).pinStyle(m2863h()).callFrom(callFrom).apiType(ApiType.DEPARTURE_REVERSE_GEO).zoom(18.0f).build();
    }

    /* renamed from: j */
    private void m2867j() {
        DepartureAddress departureAddress = this.f4479k;
        if (departureAddress == null || departureAddress.getAddress() == null) {
            switchBack(getmParam(), getmResult());
            return;
        }
        getmResult().setMapSelectOperType(AddressResultEnhancer.MapSelectOper.Edit);
        m2849b(this.f4479k.getAddress());
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m2868k() {
        DepartureSetPickupSpotCardView departureSetPickupSpotCardView = this.f4478j;
        if (departureSetPickupSpotCardView != null) {
            departureSetPickupSpotCardView.showLoadding();
        }
        this.f4473e.removeAllViews();
        this.f4473e.addView(this.f4478j);
    }

    /* renamed from: a */
    private void m2841a(DepartureAddress departureAddress) {
        Map map = this.f4482p;
        LatLng latLng = (map == null || map.getCameraPosition() == null) ? null : this.f4482p.getCameraPosition().target;
        if (departureAddress != null && latLng != null) {
            if (LatLngUtils.locateCorrect(latLng.altitude, latLng.longitude) && departureAddress.getAddress() != null) {
                departureAddress.getAddress().latitude = latLng.latitude;
                departureAddress.getAddress().longitude = latLng.longitude;
            }
            DLog.m10773d("SugMapPoiSelectFragment", "reverseGeo response, index " + Integer.toHexString(latLng.hashCode()) + "; use reverse lat&lng result  : " + departureAddress.toString(), new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2848b(DepartureAddress departureAddress) {
        View departureCardView;
        if (!this.mDestroyed && departureAddress != null && departureAddress.getAddress() != null) {
            m2841a(departureAddress);
            departureAddress.getAddress().operationType = 1;
            this.f4479k = departureAddress;
            IDepartureCompContract iDepartureCompContract = this.f4477i;
            if (iDepartureCompContract == null || (departureCardView = iDepartureCompContract.getDepartureCardView()) == null) {
                this.f4473e.removeAllViews();
                this.f4473e.addView(this.f4478j);
                String string = getContext().getResources().getString(R.string.GRider_Sug_2020_currentLoc);
                String str = "";
                if (!(departureAddress == null || departureAddress.getAddress() == null)) {
                    if (!TextUtils.isEmpty(departureAddress.getAddress().getDisplayName())) {
                        string = departureAddress.getAddress().getDisplayName();
                    } else {
                        departureAddress.getAddress().displayName = string;
                    }
                    String subNoticeTitle = (departureAddress.getExtendInfo() == null || TextUtils.isEmpty(departureAddress.getExtendInfo().getSubNoticeTitle())) ? str : departureAddress.getExtendInfo().getSubNoticeTitle();
                    IDepartureCompContract iDepartureCompContract2 = this.f4477i;
                    if (iDepartureCompContract2 != null && iDepartureCompContract2.isShowTerminalViewOnSetPickupSpotAfter()) {
                        logWriter("show isShowTerminalViewOnSetPickupSpotAfter.");
                        if (departureAddress.getFenceInfo() != null && !TextUtils.isEmpty(departureAddress.getFenceInfo().fenceName)) {
                            string = departureAddress.getFenceInfo().fenceName;
                        }
                    }
                    str = subNoticeTitle;
                }
                this.f4478j.setAddress(string);
                this.f4478j.setSubTitle(str);
                return;
            }
            this.f4473e.removeAllViews();
            this.f4473e.addView(departureCardView);
            ImageView imageView = this.f4472d;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: l */
    private void m2871l() {
        IDepartureCompContract iDepartureCompContract = this.f4477i;
        if (iDepartureCompContract == null) {
            return;
        }
        if (iDepartureCompContract.isShowTerminalViewOnSetPickupSpotAfter()) {
            logWriter("onPickupSpotClick startTerminalSelect...");
            this.f4477i.startTerminalSelect();
        } else if (this.f4479k != null) {
            logWriter("onPickupSpotClick selectAddress...");
            getmResult().setMapSelectOperType(AddressResultEnhancer.MapSelectOper.Chose);
            m2849b(this.f4479k.getAddress());
            m2842a(this.f4479k.getAddress());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2842a(Address address) {
        if (address != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("point_name", address.displayName);
            hashMap.put("point_lat", Double.valueOf(address.latitude));
            hashMap.put("point_lng", Double.valueOf(address.longitude));
            hashMap.put("entrance", this.f4480l);
            GlobalOmegaTracker.trackEvent("ibt_gp_sug_selectaddrinmap_confirm_ck", hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2849b(Address address) {
        if (!this.mDestroyed) {
            if (this.mCurrAddressType == 5) {
                getmParam().addressParam.targetAddress = address;
                getmResult().setCommonAddress(AddressConvertUtil.addressToRpcCommonPoi(address, getmResult().getCommonAddress()));
                onConfirm(getmParam(), getmResult());
                switchEditFavorite(getmParam(), getmResult());
                return;
            }
            getmResult().setResult(this.mCurrAddressType, address);
            onConfirm(getmParam(), getmResult());
            switchBack(getmParam(), getmResult());
        }
    }

    /* renamed from: m */
    private LatLng m2872m() {
        DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(getActivity());
        if (lastKnownLocation != null) {
            return new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
        }
        return null;
    }

    /* renamed from: n */
    private DepartureLocationInfo m2873n() {
        Map map;
        LatLng m = m2872m();
        if (this.mCurrentAddress != null) {
            m = new LatLng(this.mCurrentAddress.getLatitude(), this.mCurrentAddress.getLongitude());
        }
        if (!(m != null || (map = this.f4482p) == null || map.getCameraPosition() == null)) {
            m = this.f4482p.getCameraPosition().target;
        }
        if (m != null) {
            return new DepartureLocationInfo(m, this.mCurrentAddress, "wgs84");
        }
        return null;
    }

    public boolean onBackPressed() {
        logWriter("onBackPressed...");
        return super.onBackPressed();
    }

    public void onPageEnter() {
        logWriter("onPageEnter...");
        super.onPageEnter();
        getmResult().setMapSelectOperType(AddressResultEnhancer.MapSelectOper.Other);
        if (getView() != null) {
            getView().requestFocus();
        }
        SugSharedMapView.getInstance(getActivity()).onAdd(this.f4474f);
        SugSharedMapView.getInstance(getActivity()).onResume();
        View view = this.f4470b;
        if (view != null) {
            view.setVisibility(8);
        }
        final MapView mapView = SugSharedMapView.getInstance(getActivity()).getMapView();
        if (mapView != null) {
            mapView.getMapAsync(new OnMapReadyCallBack() {
                public void onMapReady(Map map) {
                    Map unused = SugMapPoiSelectFragment.this.f4482p = map;
                    SugMapPoiSelectFragment.this.m2851c();
                    SugMapPoiSelectFragment sugMapPoiSelectFragment = SugMapPoiSelectFragment.this;
                    sugMapPoiSelectFragment.playAnimationMapLayer(sugMapPoiSelectFragment.f4481m);
                    SugMapPoiSelectFragment.this.addOnMapGestureListener(map);
                    mapView.sendAccessibilityEvent(8);
                }
            });
        }
    }

    public void onPageExit() {
        logWriter("onPageExit...");
        removeOnMapGestureListener(this.f4482p);
        m2874o();
        View view = this.f4470b;
        if (view != null) {
            view.setVisibility(0);
        }
        this.f4482p = null;
        super.onPageExit();
    }

    public FragmentFactory.FragmentType getType() {
        return FragmentFactory.FragmentType.MAPSELECT;
    }

    /* renamed from: o */
    private void m2874o() {
        IDepartureCompContract iDepartureCompContract = this.f4477i;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.destroy();
            this.f4477i = null;
        }
    }

    public void onStop() {
        super.onStop();
    }

    public void onResume() {
        super.onResume();
        IDepartureCompContract iDepartureCompContract = this.f4477i;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.onMapVisible(true);
        }
    }

    public void onPause() {
        super.onPause();
        IDepartureCompContract iDepartureCompContract = this.f4477i;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.onMapVisible(false);
        }
    }

    public void onDestroyView() {
        removeOnMapGestureListener(this.f4482p);
        m2874o();
        Handler handler = this.f4484r;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        View view = this.f4469a;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f4486t);
        }
        SugSharedMapView.getInstance(getActivity()).onRemove(this.f4474f);
        AppFluentOmega.getInstance().removeOmega(8);
        super.onDestroyView();
    }
}
