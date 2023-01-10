package com.didi.map.global.flow.scene.mainpage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.animation.LinearInterpolator;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.departure.DepartureCompParams;
import com.didi.map.global.component.departure.DepartureComponent;
import com.didi.map.global.component.departure.IDepartureCompContract;
import com.didi.map.global.component.departure.model.ApiType;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.model.DepartureFenceOptions;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.global.component.departure.model.PinStyle;
import com.didi.map.global.component.mapviewholder.MapViewHolder;
import com.didi.map.global.component.recmarker.model.RecPointStyle;
import com.didi.map.global.component.slideCars.ISlideCarsCompContract;
import com.didi.map.global.component.slideCars.SlideCarsCompParams;
import com.didi.map.global.component.slideCars.api.CarNavigatorRequest;
import com.didi.map.global.component.slideCars.api.ClientConfigParam;
import com.didi.map.global.component.slideCars.api.NearCarDriver;
import com.didi.map.global.component.slideCars.impl.MultiSlideCarsCompImpl;
import com.didi.map.global.component.slideCars.model.IDriverChangeListener;
import com.didi.map.global.flow.model.Bundle;
import com.didi.map.global.flow.scene.CarSlidingParam;
import com.didi.map.global.flow.scene.IScene;
import com.didi.map.global.flow.scene.PageScene;
import com.didi.map.global.flow.scene.mainpage.ICarMainPageController;
import com.didi.map.global.flow.utils.MapFlowApolloUtils;
import com.didi.map.global.flow.utils.MapFlowOmegaUtil;
import com.didi.map.global.flow.utils.SystemUtil;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.global.model.omega.AppFluentOmega;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;
import com.didichuxing.bigdata.p174dp.locsdk.Utils;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.IPoiBaseApi;
import com.sdk.poibase.PoiBaseApiFactory;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.reverse.ReverseGeoParam;
import com.sdk.poibase.model.reverse.ReverseGeoResult;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

@IScene.Scene(mo80431id = 1001)
public class CarMainPageScene extends PageScene<MainPageSceneParam> implements ICarMainPageController {

    /* renamed from: a */
    private static final String f28826a = "CarMainPageScene|sfs";

    /* renamed from: j */
    private static Padding f28827j;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ISlideCarsCompContract f28828b;

    /* renamed from: c */
    private DIDILocationListener f28829c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public LatLng f28830d;

    /* renamed from: e */
    private IDepartureCompContract f28831e;

    /* renamed from: f */
    private IPoiBaseApi f28832f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f28833g = -1;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f28834h = 10000;

    /* renamed from: i */
    private int f28835i = 0;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ValueAnimator f28836k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public long f28837l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ReverseGeoResult f28838m;

    /* renamed from: n */
    private boolean f28839n = true;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f28840o = true;

    public /* synthetic */ void hideCarSliding() {
        ICarMainPageController.CC.$default$hideCarSliding(this);
    }

    public /* synthetic */ void showCarSliding() {
        ICarMainPageController.CC.$default$showCarSliding(this);
    }

    public CarMainPageScene(final MainPageSceneParam mainPageSceneParam, MapViewHolder mapViewHolder) {
        super(mainPageSceneParam, mapViewHolder);
        if (getAppFluentOmega() != null) {
            getAppFluentOmega().startCalculateTime(1, 3);
        }
        this.f28829c = new DIDILocationListener() {
            public void onStatusUpdate(String str, int i, String str2) {
            }

            public void onLocationChanged(DIDILocation dIDILocation) {
                int locMode = getLocMode();
                if (CarMainPageScene.this.f28833g != locMode) {
                    int unused = CarMainPageScene.this.f28833g = locMode;
                    MapFlowOmegaUtil.onLocateStatusChange(CarMainPageScene.this.f28833g);
                }
                if (dIDILocation != null && CarMainPageScene.this.isSceneValid) {
                    LatLng latLng = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
                    if (LatLngUtils.locateCorrect(latLng)) {
                        if (CarMainPageScene.this.getAppFluentOmega() != null) {
                            CarMainPageScene.this.getAppFluentOmega().stopCalculateTime(CarMainPageScene.this.getContext(), CarMainPageScene.this.getMap(), 3, (HashMap<String, Object>) null);
                        }
                        CarMainPageScene.this.m22437b();
                        if (CarMainPageScene.this.mParam != null && ((MainPageSceneParam) CarMainPageScene.this.mParam).isSuperAppScene()) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (CarMainPageScene.this.f28837l == 0 || Math.abs(currentTimeMillis - CarMainPageScene.this.f28837l) >= ((long) CarMainPageScene.this.f28834h)) {
                                CarMainPageScene carMainPageScene = CarMainPageScene.this;
                                carMainPageScene.m22432a(carMainPageScene.mPadding, true);
                                long unused2 = CarMainPageScene.this.f28837l = currentTimeMillis;
                            }
                        }
                        if (CarMainPageScene.this.f28830d == null && CarMainPageScene.this.getMap() != null) {
                            CarMainPageScene.this.m22438b(latLng);
                            if (CarMainPageScene.this.mParam != null && !((MainPageSceneParam) CarMainPageScene.this.mParam).isSuperAppScene()) {
                                BestViewer.doBestView(CarMainPageScene.this.getMap(), false, Float.valueOf(18.0f), latLng, CarMainPageScene.this.getMap().getPadding(), (BestViewer.IBestViewListener) new BestViewer.IBestViewListener() {
                                    public void onFinished() {
                                        if (mainPageSceneParam.getMapLocationLoadedCallback() != null) {
                                            mainPageSceneParam.getMapLocationLoadedCallback().loaded();
                                        }
                                    }
                                });
                            }
                        } else if (DDSphericalUtil.computeDistanceBetween(CarMainPageScene.this.f28830d, latLng) < 35.0d) {
                            return;
                        }
                        CarMainPageScene.this.m22430a(latLng);
                        LatLng unused3 = CarMainPageScene.this.f28830d = latLng;
                        if (CarMainPageScene.this.f28828b != null) {
                            CarMainPageScene.this.f28828b.updateLocationPosition(latLng);
                        }
                    }
                }
            }

            public void onLocationError(int i, ErrInfo errInfo) {
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = (errInfo == null || errInfo.getErrMessage() == null) ? "" : errInfo.getErrMessage();
                DLog.m10773d("CarMainPageScene", "CarMainPageScene, onLocationErr:%d, errInfo:%s", objArr);
            }

            private int getLocMode() {
                if (CarMainPageScene.this.getContext() != null) {
                    return Utils.getLocationSwitchLevel(CarMainPageScene.this.getContext());
                }
                return -1;
            }
        };
        m22448e();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22430a(LatLng latLng) {
        if (getContext() == null || getMap() == null || latLng == null || this.mParam == null || ((MainPageSceneParam) this.mParam).getAddressParam() == null) {
            SystemUtils.log(5, f28826a, "handlerPoiCache() mParam == null || getAddressParam == null", (Throwable) null, "com.didi.map.global.flow.scene.mainpage.CarMainPageScene", 189);
            return;
        }
        AddressParam addressParam = ((MainPageSceneParam) this.mParam).getAddressParam();
        if (addressParam.currentAddress != null) {
            addressParam.currentAddress.latitude = latLng.latitude;
            addressParam.currentAddress.longitude = latLng.longitude;
        }
        if (addressParam.targetAddress != null) {
            addressParam.targetAddress.latitude = latLng.latitude;
            addressParam.targetAddress.longitude = latLng.longitude;
        }
        if (this.f28832f == null) {
            this.f28832f = PoiBaseApiFactory.createDidiApi(getContext());
        }
        String mapVendor = (getMap() == null || getMap().getMapVendor() == null) ? "gmap" : getMap().getMapVendor().toString();
        ReverseGeoParam reverseGeoParam = new ReverseGeoParam();
        reverseGeoParam.mapType = mapVendor;
        reverseGeoParam.select_lat = addressParam.currentAddress.latitude;
        reverseGeoParam.select_lng = addressParam.currentAddress.longitude;
        reverseGeoParam.user_loc_lat = addressParam.currentAddress.latitude;
        reverseGeoParam.user_loc_lng = addressParam.currentAddress.longitude;
        reverseGeoParam.accuracy = addressParam.currentAddress.accuracy;
        reverseGeoParam.provider = addressParam.currentAddress.provider;
        reverseGeoParam.callFrom = CallFrom.HOME_PAGE_DRAG;
        reverseGeoParam.uid = PaxEnvironment.getInstance().getUid();
        reverseGeoParam.appVersion = PaxEnvironment.getInstance().getAppVersion();
        reverseGeoParam.phone = PaxEnvironment.getInstance().getPhoneNumber();
        reverseGeoParam.productId = PaxEnvironment.getInstance().getProductId();
        reverseGeoParam.token = PaxEnvironment.getInstance().getToken();
        reverseGeoParam.cityId = PaxEnvironment.getInstance().getCityId();
        reverseGeoParam.countryId = PaxEnvironment.getInstance().getCountryCode();
        reverseGeoParam.lang = LocaleCodeHolder.getInstance().getCurrentLang();
        DLog.m10773d(f28826a, "reverseGeo: param = " + reverseGeoParam, new Object[0]);
        this.f28832f.reverseGeo(reverseGeoParam, new IHttpListener<ReverseGeoResult>() {
            public void onSuccess(ReverseGeoResult reverseGeoResult) {
                DLog.m10773d(CarMainPageScene.f28826a, "storeLocationReverseInfo onSuccess...", new Object[0]);
                if (!CarMainPageScene.this.isSceneValid) {
                    DLog.m10773d(CarMainPageScene.f28826a, "storeLocationReverseInfo isSceneValid = false", new Object[0]);
                    return;
                }
                ReverseGeoResult unused = CarMainPageScene.this.f28838m = reverseGeoResult;
                if (CarMainPageScene.this.mParam != null && ((MainPageSceneParam) CarMainPageScene.this.mParam).getReverseGeoListener() != null) {
                    ((MainPageSceneParam) CarMainPageScene.this.mParam).getReverseGeoListener().onSuccess(reverseGeoResult);
                }
            }

            public void onFail(IOException iOException) {
                DLog.m10773d(CarMainPageScene.f28826a, "storeLocationReverseInfo fail...", new Object[0]);
                if (CarMainPageScene.this.mParam != null && ((MainPageSceneParam) CarMainPageScene.this.mParam).getReverseGeoListener() != null) {
                    ((MainPageSceneParam) CarMainPageScene.this.mParam).getReverseGeoListener().onFail(iOException);
                }
            }
        });
    }

    public void enter(Bundle bundle) {
        super.enter(bundle);
        if (!(getContext() == null || getMap() == null)) {
            LocationHelper.registerListener(getContext(), DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY, this.f28829c);
        }
        if (AppFluentOmega.getInstance() != null) {
            AppFluentOmega.getInstance().startCalculateTime(2);
        }
        m22427a();
    }

    /* renamed from: a */
    private void m22427a() {
        if (MapFlowApolloUtils.getIsEnableTrackPermissionState() && getContext() != null && getContext().getApplicationInfo() != null && getContext().getApplicationInfo().targetSdkVersion >= 31 && Build.VERSION.SDK_INT >= 31) {
            if (SystemUtil.checkSystemPermission(getContext(), Permission.ACCESS_COARSE_LOCATION) == 0 && SystemUtil.checkSystemPermission(getContext(), Permission.ACCESS_FINE_LOCATION) == 0) {
                MapFlowOmegaUtil.trackLocationPermissionState(2);
            } else if (SystemUtil.checkSystemPermission(getContext(), Permission.ACCESS_COARSE_LOCATION) == 0) {
                MapFlowOmegaUtil.trackLocationPermissionState(0);
            } else if (SystemUtil.checkSystemPermission(getContext(), Permission.ACCESS_FINE_LOCATION) == 0) {
                MapFlowOmegaUtil.trackLocationPermissionState(1);
            } else {
                MapFlowOmegaUtil.trackLocationPermissionState(3);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m22437b() {
        if (this.mParam != null && getMap() != null && getContext() != null && this.f28828b == null) {
            this.f28828b = new MultiSlideCarsCompImpl();
            SlideCarsCompParams slideCarsCompParams = new SlideCarsCompParams();
            if (((MainPageSceneParam) this.mParam).getSlidingParam() != null) {
                slideCarsCompParams.setCarSlidingRequestParam(m22425a(((MainPageSceneParam) this.mParam).getSlidingParam()));
                slideCarsCompParams.setBitmapGetter(((MainPageSceneParam) this.mParam).getSlidingParam().getBitmap());
            }
            slideCarsCompParams.setPullIntervalMs(this.f28834h);
            slideCarsCompParams.setShowSlidingCar(true);
            this.f28828b.setConfigParam(slideCarsCompParams);
            this.f28828b.create(getContext(), getMap());
            this.f28828b.setListener(new IDriverChangeListener() {
                public void onGetResultSuccess(NearCarDriver nearCarDriver) {
                    if (!(CarMainPageScene.this.mParam == null || ((MainPageSceneParam) CarMainPageScene.this.mParam).getCarSlidingChangeListener() == null)) {
                        if (CarMainPageScene.this.getAppFluentOmega() != null) {
                            CarMainPageScene.this.getAppFluentOmega().stopCalculateTime(CarMainPageScene.this.getContext(), CarMainPageScene.this.getMap(), 1, (HashMap<String, Object>) null);
                        }
                        ((MainPageSceneParam) CarMainPageScene.this.mParam).getCarSlidingChangeListener().onGetResultSuccess(nearCarDriver);
                    }
                    if (!(CarMainPageScene.this.mPadding == null || CarMainPageScene.this.mParam == null || ((MainPageSceneParam) CarMainPageScene.this.mParam).isSuperAppScene())) {
                        CarMainPageScene carMainPageScene = CarMainPageScene.this;
                        carMainPageScene.doBestView(carMainPageScene.mPadding);
                    }
                    if (CarMainPageScene.this.mParam != null && ((MainPageSceneParam) CarMainPageScene.this.mParam).isSuperAppScene() && CarMainPageScene.this.f28840o && CarMainPageScene.this.f28828b != null && !CollectionUtil.isEmpty((Collection<?>) CarMainPageScene.this.f28828b.getDriverPoints())) {
                        boolean unused = CarMainPageScene.this.f28840o = false;
                        MapFlowOmegaUtil.reportOmegaSACarShow();
                    }
                }

                public void onGetResultError(String str) {
                    if (CarMainPageScene.this.mParam != null && ((MainPageSceneParam) CarMainPageScene.this.mParam).getCarSlidingChangeListener() != null) {
                        ((MainPageSceneParam) CarMainPageScene.this.mParam).getCarSlidingChangeListener().onGetResultError(str);
                    }
                }
            });
            this.f28828b.start();
        }
    }

    /* renamed from: a */
    private CarNavigatorRequest m22425a(CarSlidingParam carSlidingParam) {
        String str = null;
        if (getContext() != null) {
            DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(getContext());
            LatLng latLng = lastKnownLocation != null ? new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()) : null;
            if (carSlidingParam != null) {
                if (!(getMap() == null || getMap().getMapVendor() == null)) {
                    str = getMap().getMapVendor().toString();
                }
                String productId = PaxEnvironment.getInstance().getProductId();
                if (str == null) {
                    str = "gmap";
                }
                CarNavigatorRequest carNavigatorRequest = new CarNavigatorRequest(productId, str, new ClientConfigParam(LocaleCodeHolder.getInstance().getCurrentLang(), "wgs84", carSlidingParam.getIdfa(), carSlidingParam.getOriginId(), carSlidingParam.getMixFlag(), carSlidingParam.getA3Token()), latLng, carSlidingParam.getType(), carSlidingParam.getOrderState());
                carNavigatorRequest.setPid(carSlidingParam.getPid());
                carNavigatorRequest.setCarLevel(carSlidingParam.getCarLevel());
                carNavigatorRequest.setType(carSlidingParam.getType());
                carNavigatorRequest.setOrderState(carSlidingParam.getOrderState());
                if (carSlidingParam.getEndLatLng() != null) {
                    carNavigatorRequest.setEndPosition(carSlidingParam.getEndLatLng());
                }
                if (carSlidingParam.getXtags() != null) {
                    carNavigatorRequest.setXtags(carSlidingParam.getXtags());
                }
                if (carSlidingParam.getExtra() != null) {
                    carNavigatorRequest.setExtra(carSlidingParam.getExtra());
                }
                if (carSlidingParam.getBubbleId() != null) {
                    carNavigatorRequest.setBubbleId(carSlidingParam.getBubbleId());
                }
                if (carSlidingParam.getOrderTab() != 0) {
                    carNavigatorRequest.setOrderTab(carSlidingParam.getOrderTab());
                }
                return carNavigatorRequest;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m22438b(LatLng latLng) {
        if (this.mParam != null && getMap() != null && latLng != null && this.mMapView != null && this.f28831e == null) {
            this.f28831e = new DepartureComponent();
            DepartureLocationInfo departureLocationInfo = new DepartureLocationInfo(latLng, (Address) null, "wgs84");
            DepartureFenceOptions departureFenceOptions = new DepartureFenceOptions();
            DepartureCompParams.Builder builder = new DepartureCompParams.Builder();
            builder.departureTime(0).pinStyle((PinStyle) null).isPinVisible(false).isRecPointVisible(false).isBubbleVisible(false).locationInfo(departureLocationInfo).requireByDrag(false).isFenceVisible(true).recStyle((RecPointStyle) null).zoom(((MainPageSceneParam) this.mParam).isSuperAppScene() ? m22445d() : 18.0f).callFrom(CallFrom.GLOBAL_HOMEPAGE_STATION).apiType(ApiType.DEPARTURE_POI_INFO).fenceOptions(departureFenceOptions);
            this.f28831e.setConfigParam(builder.build());
            this.f28831e.create(getContext(), getMap());
            this.f28831e.registerCallback(new IDepartureCompContract.IDepartureComponentCallback() {
                public /* synthetic */ void onBroadOtherMapCallback(int i) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onBroadOtherMapCallback(this, i);
                }

                public /* synthetic */ void onClickBroadOtherInStationCard(DepartureAddress departureAddress) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onClickBroadOtherInStationCard(this, departureAddress);
                }

                public /* synthetic */ void onClickBubble() {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onClickBubble(this);
                }

                public /* synthetic */ void onConfirmPickup(DepartureAddress departureAddress) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onConfirmPickup(this, departureAddress);
                }

                public /* synthetic */ void onDepartureLoading(LatLng latLng) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onDepartureLoading(this, latLng);
                }

                public /* synthetic */ void onDragging(int i) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onDragging(this, i);
                }

                public /* synthetic */ void onFetchAddressFail(LatLng latLng) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onFetchAddressFail(this, latLng);
                }

                public /* synthetic */ void onStartDragging() {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onStartDragging(this);
                }

                public /* synthetic */ void onStartSugPage(DepartureAddress departureAddress) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onStartSugPage(this, departureAddress);
                }

                public /* synthetic */ void onStartTerminalWindow(DepartureAddress departureAddress) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onStartTerminalWindow(this, departureAddress);
                }

                public /* synthetic */ void onUp() {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onUp(this);
                }

                public void onDepartureAddressChanged(DepartureAddress departureAddress) {
                    if (CarMainPageScene.this.mParam != null && departureAddress != null && departureAddress.getFenceInfo() != null) {
                        if (((MainPageSceneParam) CarMainPageScene.this.mParam).getFenceChangeListener() != null) {
                            ((MainPageSceneParam) CarMainPageScene.this.mParam).getFenceChangeListener().onChange(departureAddress.getFenceInfo());
                        }
                        if (((MainPageSceneParam) CarMainPageScene.this.mParam).isSuperAppScene()) {
                            MapFlowOmegaUtil.reportOmegaSAFenceShow();
                        }
                    }
                }
            });
            this.f28831e.start();
        }
    }

    public void leave() {
        super.leave();
        this.f28830d = null;
        if (getContext() != null) {
            LocationHelper.unRegisterListener(getContext(), this.f28829c);
        }
        ISlideCarsCompContract iSlideCarsCompContract = this.f28828b;
        if (iSlideCarsCompContract != null) {
            iSlideCarsCompContract.destroy();
            this.f28828b = null;
        }
        IDepartureCompContract iDepartureCompContract = this.f28831e;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.destroy();
            this.f28831e = null;
        }
        if (getAppFluentOmega() != null) {
            getAppFluentOmega().removeOmega(1, 3);
        }
        if (((MainPageSceneParam) this.mParam).getMapClickListener() != null) {
            m22450f();
        }
        if (this.f28835i != 0) {
            m22428a(0);
        }
    }

    public void onResume() {
        super.onResume();
        if (getContext() != null) {
            LocationHelper.registerListener(getContext(), DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY, this.f28829c);
        }
        ISlideCarsCompContract iSlideCarsCompContract = this.f28828b;
        if (iSlideCarsCompContract != null) {
            iSlideCarsCompContract.onMapVisible(true);
        }
    }

    public void onPause() {
        super.onPause();
        if (getContext() != null) {
            LocationHelper.unRegisterListener(getContext(), this.f28829c);
        }
        ISlideCarsCompContract iSlideCarsCompContract = this.f28828b;
        if (iSlideCarsCompContract != null) {
            iSlideCarsCompContract.onMapVisible(false);
        }
    }

    public void doBestView(Padding padding) {
        if (padding != null) {
            if (this.mParam == null || !((MainPageSceneParam) this.mParam).isSuperAppScene()) {
                super.doBestView(padding);
                if (this.isSceneValid && getMap() != null) {
                    hideResetView();
                    ISlideCarsCompContract iSlideCarsCompContract = this.f28828b;
                    if (iSlideCarsCompContract != null && !CollectionUtil.isEmpty((Collection<?>) iSlideCarsCompContract.getDriverPoints())) {
                        DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(getContext());
                        LatLng latLng = null;
                        if (lastKnownLocation != null) {
                            latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
                        }
                        BestViewer.doBestView(getMap(), true, latLng, this.f28828b.getDriverPoints(), padding, (Padding) null);
                    } else if (this.mMapView != null) {
                        BestViewer.doBestView(getMap(), true, this.mMapView.getMyLocationMarkers(), padding, (Padding) null, (BestViewer.IBestViewListener) null);
                    }
                }
            } else {
                m22431a(padding);
            }
        }
    }

    public void updateCarIcon() {
        ISlideCarsCompContract iSlideCarsCompContract;
        if (this.isSceneValid && (iSlideCarsCompContract = this.f28828b) != null) {
            iSlideCarsCompContract.refreshCarIcon();
        }
    }

    public boolean onDomainChanged() {
        if (this.mMapView == null || getContext() == null || !this.isSceneValid) {
            SystemUtils.log(6, f28826a, "onDomainChanged() mMapView == null || getContext() == null || !isSceneValid", (Throwable) null, "com.didi.map.global.flow.scene.mainpage.CarMainPageScene", 542);
            return false;
        }
        LatLng latLng = this.f28830d;
        if (latLng == null) {
            SystemUtils.log(6, f28826a, "onDomainChanged() lastLocation == null", (Throwable) null, "com.didi.map.global.flow.scene.mainpage.CarMainPageScene", 547);
            return false;
        }
        IDepartureCompContract iDepartureCompContract = this.f28831e;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.updateDepartureLocation(new DepartureLocationInfo(latLng, (Address) null, "wgs84"));
        }
        m22430a(this.f28830d);
        if (this.f28828b == null || this.mParam == null) {
            return true;
        }
        this.f28828b.reStart(m22425a(((MainPageSceneParam) this.mParam).getSlidingParam()));
        return true;
    }

    public void leaveSaPage(int i) {
        if (this.isSceneValid && getMap() != null) {
            DLog.m10773d(f28826a, "leaveSaPage", new Object[0]);
            m22443c();
            m22450f();
            ValueAnimator b = m22436b(i);
            this.f28836k = b;
            if (b != null) {
                b.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        ValueAnimator unused = CarMainPageScene.this.f28836k = null;
                        CarMainPageScene.this.m22432a(new Padding(), false);
                    }
                });
                this.f28836k.start();
                return;
            }
            m22432a(new Padding(), false);
        }
    }

    public void saCarMainToSAPage(Padding padding) {
        if (this.isSceneValid && getMap() != null) {
            DLog.m10773d(f28826a, "saCarMainToSAPage", new Object[0]);
            m22431a(padding);
        }
    }

    /* renamed from: a */
    private void m22431a(Padding padding) {
        if (padding == null) {
            m22432a(new Padding(), true);
        } else if (padding.bottom == 0 && padding.top == 0) {
            m22432a(padding, true);
        } else {
            if (f28827j != null) {
                m22428a(padding.bottom - f28827j.bottom);
            } else {
                f28827j = padding;
            }
            if (this.f28839n) {
                this.f28839n = false;
                m22432a(f28827j, true);
            }
        }
    }

    /* renamed from: c */
    private void m22443c() {
        ValueAnimator valueAnimator = this.f28836k;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f28836k.cancel();
            this.f28836k = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22428a(int i) {
        if (this.mMapView != null && this.mMapView.getMapView() != null && this.f28835i != i) {
            this.f28835i = i;
            this.mMapView.getMapView().scrollTo(0, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22432a(Padding padding, boolean z) {
        super.doBestView(padding);
        if (this.isSceneValid && getMap() != null) {
            hideResetView();
            DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(getContext());
            LatLng latLng = null;
            if (lastKnownLocation != null) {
                latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            }
            if (!z) {
                ISlideCarsCompContract iSlideCarsCompContract = this.f28828b;
                if (iSlideCarsCompContract != null && !CollectionUtil.isEmpty((Collection<?>) iSlideCarsCompContract.getDriverPoints()) && latLng != null) {
                    BestViewer.doBestView(getMap(), true, latLng, this.f28828b.getDriverPoints(), padding, (Padding) null, (BestViewer.IBestViewListener) null);
                } else if (this.mMapView != null) {
                    BestViewer.doBestView(getMap(), true, this.mMapView.getMyLocationMarkers(), padding, (Padding) null, (BestViewer.IBestViewListener) null);
                }
            } else if (latLng != null) {
                BestViewer.doBestView(getMap(), true, Float.valueOf(m22445d()), latLng, padding, (BestViewer.IBestViewListener) null);
            }
        }
    }

    /* renamed from: d */
    private float m22445d() {
        if (getMap() == null) {
            return MapFlowApolloUtils.getSAZoomLevelParam(0);
        }
        if (getMap().getMapVendor() == MapVendor.DIDI) {
            return MapFlowApolloUtils.getSAZoomLevelParam(1);
        }
        return MapFlowApolloUtils.getSAZoomLevelParam(0);
    }

    /* renamed from: b */
    private ValueAnimator m22436b(int i) {
        int i2 = this.f28835i;
        if (i2 == 0) {
            DLog.m10773d(f28826a, "getResetScrollMapAnimator return; mScrollY = 0", new Object[0]);
            return null;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i2, 0});
        ofInt.setDuration((long) i);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CarMainPageScene.this.m22429a(valueAnimator);
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                CarMainPageScene.this.m22428a(0);
                DLog.m10773d(CarMainPageScene.f28826a, "saResetScrollMap end", new Object[0]);
            }
        });
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22429a(ValueAnimator valueAnimator) {
        Integer num = (Integer) valueAnimator.getAnimatedValue();
        if (num != null) {
            m22428a(num.intValue());
        }
    }

    /* renamed from: e */
    private void m22448e() {
        if (this.mMapView != null && this.mMapView.getMapView() != null && this.mMapView.getMapView().getMap() != null && this.mParam != null && ((MainPageSceneParam) this.mParam).getMapClickListener() != null) {
            Map map = this.mMapView.getMapView().getMap();
            DLog.m10773d(f28826a, "registerListener: ", new Object[0]);
            map.addOnCameraChangeListener(((MainPageSceneParam) this.mParam).getMapClickListener());
            map.addOnMapGestureListener(((MainPageSceneParam) this.mParam).getMapClickListener());
        }
    }

    /* renamed from: f */
    private void m22450f() {
        if (this.mMapView != null && this.mMapView.getMapView() != null && this.mMapView.getMapView().getMap() != null && this.mParam != null && ((MainPageSceneParam) this.mParam).getMapClickListener() != null) {
            Map map = this.mMapView.getMapView().getMap();
            DLog.m10773d(f28826a, "unRegisterListener: ", new Object[0]);
            map.removeOnCameraChangeListener(((MainPageSceneParam) this.mParam).getMapClickListener());
            map.removeOnMapGestureListener(((MainPageSceneParam) this.mParam).getMapClickListener());
        }
    }

    public void saUpdatePageSceneParam(MainPageSceneParam mainPageSceneParam) {
        if (mainPageSceneParam != null) {
            DLog.m10773d(f28826a, "saUpdatePageSceneParam; isSuperAppScene = " + mainPageSceneParam.isSuperAppScene(), new Object[0]);
            m22450f();
            this.mParam = mainPageSceneParam;
            this.f28840o = true;
            this.f28839n = true;
            this.mMapChangeListener = mainPageSceneParam.getMapChangeListener();
            if (mainPageSceneParam.getMapClickListener() != null) {
                m22448e();
            }
            if (mainPageSceneParam.getReverseGeoListener() != null && this.f28838m != null) {
                mainPageSceneParam.getReverseGeoListener().onSuccess(this.f28838m);
            }
        }
    }
}
