package com.didi.map.global.flow.scene.order.serving.scene.sctx;

import android.util.Log;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.departure.DepartureCompParams;
import com.didi.map.global.component.departure.DepartureComponent;
import com.didi.map.global.component.departure.IDepartureCompContract;
import com.didi.map.global.component.departure.circle.ZoneCircleOption;
import com.didi.map.global.component.departure.model.ApiType;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.global.component.departure.model.PinStyle;
import com.didi.map.global.flow.scene.order.serving.ILocationCallback;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.sdk.env.CacheKey;
import com.didi.map.sdk.env.Page;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.env.PointType;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.CallFrom;

public class ModifyPickupPointPage {

    /* renamed from: a */
    private static final String f29453a = "WaitingForDrivingPage";

    /* renamed from: b */
    private WaitingForDrivingPage f29454b;

    /* renamed from: c */
    private DepartureComponent f29455c;

    public ModifyPickupPointPage(WaitingForDrivingPage waitingForDrivingPage) {
        this.f29454b = waitingForDrivingPage;
    }

    /* access modifiers changed from: protected */
    public void doSceneBestView(Padding padding, boolean z) {
        if (this.f29454b != null) {
            DepartureComponent departureComponent = this.f29455c;
            if (departureComponent != null) {
                departureComponent.setPadding(padding);
            }
            this.f29454b.mScene.hideResetView();
        }
    }

    public void startModifyPickupLocation(Address address, Address address2, float f, final ILocationCallback iLocationCallback) {
        WaitingForDrivingPage waitingForDrivingPage = this.f29454b;
        if (waitingForDrivingPage != null) {
            if (waitingForDrivingPage.mPassengerSctx != null) {
                this.f29454b.mPassengerSctx.showRecommendPickupPoint(false);
            }
            DLog.m10773d("GuideXXX", "modifyPickUp: \n" + Log.getStackTraceString(new Throwable()), new Object[0]);
            PaxEnvironment.getInstance().setPointType(PointType.START);
            PaxEnvironment.getInstance().setCache(CacheKey.CLICK_POSITION, Page.PICKUP_PAGE.toString());
            DepartureComponent departureComponent = this.f29455c;
            if (departureComponent != null) {
                departureComponent.destroy();
                this.f29455c = null;
            }
            DepartureComponent departureComponent2 = new DepartureComponent();
            this.f29455c = departureComponent2;
            departureComponent2.setConfigParam(m22808a(address, address2, f));
            this.f29455c.create(this.f29454b.getContext(), this.f29454b.getMap());
            this.f29455c.registerCallback(new IDepartureCompContract.IDepartureComponentCallback() {
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
                    DLog.m10773d(ModifyPickupPointPage.f29453a, "onDepartureAddressChanged", new Object[0]);
                    ILocationCallback iLocationCallback = iLocationCallback;
                    if (iLocationCallback != null) {
                        iLocationCallback.onUpdateLocation(departureAddress);
                    }
                }

                public void onStartDragging() {
                    DLog.m10773d(ModifyPickupPointPage.f29453a, "onStartDragging", new Object[0]);
                }

                public void onDragging(int i) {
                    DLog.m10773d(ModifyPickupPointPage.f29453a, "onDragging", new Object[0]);
                    ILocationCallback iLocationCallback = iLocationCallback;
                    if (iLocationCallback != null) {
                        iLocationCallback.onDragging(i);
                    }
                }

                public void onDepartureLoading(LatLng latLng) {
                    DLog.m10773d(ModifyPickupPointPage.f29453a, "onDepartureLoading", new Object[0]);
                    ILocationCallback iLocationCallback = iLocationCallback;
                    if (iLocationCallback != null) {
                        iLocationCallback.onDepartureLoading(latLng);
                    }
                }

                public void onFetchAddressFail(LatLng latLng) {
                    DLog.m10773d(ModifyPickupPointPage.f29453a, "onFetchAddressFail", new Object[0]);
                    ILocationCallback iLocationCallback = iLocationCallback;
                    if (iLocationCallback != null) {
                        iLocationCallback.onFail(latLng);
                    }
                }
            });
            this.f29455c.start();
            if (this.f29454b.mapAutoBestViewLooper != null) {
                this.f29454b.mapAutoBestViewLooper.onMapVisible(false);
            }
            if (this.f29454b.mWalkingLine != null) {
                this.f29454b.mWalkingLine.setVisible(false);
            }
            if (this.f29454b.guideEntranceMarker != null) {
                this.f29454b.guideEntranceMarker.setVisible(false);
            }
        }
    }

    public void stopModifyPickupLocation(LatLng latLng) {
        if (this.f29454b != null) {
            DepartureComponent departureComponent = this.f29455c;
            if (departureComponent != null) {
                departureComponent.destroy();
                this.f29455c = null;
            }
            if (this.f29454b.mapAutoBestViewLooper != null) {
                this.f29454b.mapAutoBestViewLooper.onMapVisible(true);
            }
            if (this.f29454b.mWalkingLine != null) {
                this.f29454b.mWalkingLine.setVisible(true);
            }
            if (this.f29454b.guideEntranceMarker != null) {
                this.f29454b.guideEntranceMarker.setVisible(true);
            }
        }
    }

    /* renamed from: a */
    private DepartureCompParams m22808a(Address address, Address address2, float f) {
        PinStyle pinStyle = new PinStyle();
        pinStyle.rectVisible = true;
        pinStyle.bigCircleColor = -11908005;
        pinStyle.smallCircleColor = -16725849;
        pinStyle.rectColor = -11908005;
        pinStyle.shadowColor = -11908005;
        if (address == null) {
            return null;
        }
        LatLng latLng = new LatLng(address.latitude, address.longitude);
        DepartureLocationInfo departureLocationInfo = new DepartureLocationInfo(latLng, address, "wgs84");
        LatLng point = this.f29454b.mMarkerManager.getPoint(MapElementId.ID_MARKER_START);
        ZoneCircleOption allowDragToOuter = new ZoneCircleOption(point, f).stroke(4, -16724822).fillColor(436260010).allowDragToOuter(false);
        DLog.m10773d("startModifyPickupLocation", "circleCenter->" + point.toString() + "--->startAddress" + latLng, new Object[0]);
        return new DepartureCompParams.Builder().departureTime(0).pinStyle(pinStyle).isPinVisible(true).isBubbleVisible(true).isGuideLineVisible(true).isRecPointVisible(false).locationInfo(departureLocationInfo).requireByDrag(true).zoom(16.0f).setEndPoint(address2).callFrom(CallFrom.ALTER_PICKUP_PAGE).zoneCircleOptions(allowDragToOuter).apiType(ApiType.DEPARTURE_POI_INFO).build();
    }
}
