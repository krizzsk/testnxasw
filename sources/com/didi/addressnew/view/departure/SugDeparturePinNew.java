package com.didi.addressnew.view.departure;

import android.content.Context;
import com.didi.addressnew.util.ApolloUtil;
import com.didi.addressnew.view.departure.BaseDeparture;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.departure.DepartureCompParams;
import com.didi.map.global.component.departure.DepartureComponent;
import com.didi.map.global.component.departure.IDepartureCompContract;
import com.didi.map.global.component.departure.model.ApiType;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.global.component.departure.model.PinStyle;
import com.didi.map.global.component.recmarker.model.RecPointStyle;
import com.didi.map.global.model.location.NLPRegisterParam;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.RpcPoi;

public class SugDeparturePinNew extends BaseDeparture {

    /* renamed from: a */
    private static final String f9420a = "SugDeparturePin";

    /* renamed from: b */
    private IDepartureCompContract f9421b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DepartureCompParams f9422c;

    /* renamed from: d */
    private IDepartureCompContract.IDepartureComponentCallback f9423d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public BaseDeparture.FetchStartPoiInfoCallback f9424e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f9425f = false;

    public void start(Context context, AddressParam addressParam, BaseDeparture.FetchStartPoiInfoCallback fetchStartPoiInfoCallback) {
        if (this.f9425f) {
            stop();
        }
        this.f9424e = fetchStartPoiInfoCallback;
        this.f9421b = new DepartureComponent();
        DepartureCompParams a = m8195a(addressParam.currentAddress, addressParam.targetAddress);
        this.f9422c = a;
        if (a != null) {
            this.f9421b.setConfigParam(a);
            this.f9421b.create(context, (Map) null);
            this.f9421b.registerCallback(m8196a());
            this.f9421b.start();
        }
    }

    /* renamed from: a */
    private void m8197a(Context context, DepartureCompParams departureCompParams, BaseDeparture.FetchStartPoiInfoCallback fetchStartPoiInfoCallback) {
        if (this.f9425f) {
            stop();
        }
        this.f9424e = fetchStartPoiInfoCallback;
        DepartureComponent departureComponent = new DepartureComponent();
        this.f9421b = departureComponent;
        if (departureCompParams == null) {
            departureCompParams = this.f9422c;
        }
        departureComponent.setConfigParam(departureCompParams);
        this.f9421b.create(context, (Map) null);
        this.f9421b.registerCallback(m8196a());
        this.f9421b.start();
    }

    public void startVerifyStationAddress(Context context, AddressParam addressParam, BaseDeparture.FetchStartPoiInfoCallback fetchStartPoiInfoCallback, RpcPoi rpcPoi) {
        DepartureCompParams a = m8195a(addressParam.currentAddress, addressParam.targetAddress);
        this.f9422c = a;
        if (a != null) {
            m8197a(context, a, fetchStartPoiInfoCallback);
        }
    }

    /* renamed from: a */
    private DepartureCompParams m8195a(Address address, Address address2) {
        if (address == null) {
            return null;
        }
        return new DepartureCompParams.Builder().callFrom(CallFrom.SUG_PACKING_PROMPT).departureTime(0).isPinVisible(false).isRecPointVisible(false).isFenceVisible(false).locationInfo(new DepartureLocationInfo(new LatLng(address.latitude, address.longitude), (Address) null, "wgs84")).pinStyle((PinStyle) null).recStyle((RecPointStyle) null).requireByDrag(false).zoom(18.0f).apiType(ApiType.DEPARTURE_POI_INFO).setNlpRegisterParam(ApolloUtil.sugStartPoiUseNLP(PaxEnvironment.getInstance().getCountryCode()) ? new NLPRegisterParam(CallFrom.SUG_PACKING_PROMPT.toString(), ApolloUtil.getNLPTimeOut(PaxEnvironment.getInstance().getCountryCode()), 0) : null).build();
    }

    /* renamed from: a */
    private IDepartureCompContract.IDepartureComponentCallback m8196a() {
        if (this.f9423d == null) {
            this.f9423d = new IDepartureCompContract.IDepartureComponentCallback() {
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

                public /* synthetic */ void onDragging(int i) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onDragging(this, i);
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

                public void onStartDragging() {
                    SystemUtils.log(3, SugDeparturePinNew.f9420a, "onStartDragging()", (Throwable) null, "com.didi.addressnew.view.departure.SugDeparturePinNew$1", 120);
                    boolean unused = SugDeparturePinNew.this.f9425f = true;
                    if (SugDeparturePinNew.this.f9424e != null) {
                        SugDeparturePinNew.this.f9424e.onFetchStart();
                    }
                }

                public void onDepartureLoading(LatLng latLng) {
                    SystemUtils.log(3, SugDeparturePinNew.f9420a, "onDepartureLoading() latLng:" + latLng, (Throwable) null, "com.didi.addressnew.view.departure.SugDeparturePinNew$1", 129);
                    boolean unused = SugDeparturePinNew.this.f9425f = true;
                }

                public void onDepartureAddressChanged(DepartureAddress departureAddress) {
                    SystemUtils.log(3, SugDeparturePinNew.f9420a, "onDepartureAddressChanged() departureAddress:" + departureAddress, (Throwable) null, "com.didi.addressnew.view.departure.SugDeparturePinNew$1", 135);
                    boolean unused = SugDeparturePinNew.this.f9425f = false;
                    if (SugDeparturePinNew.this.f9424e == null) {
                        return;
                    }
                    if (departureAddress == null || departureAddress.getAddress() == null) {
                        LatLng latLng = null;
                        if (!(SugDeparturePinNew.this.f9422c == null || SugDeparturePinNew.this.f9422c.getLocationInfo() == null)) {
                            latLng = SugDeparturePinNew.this.f9422c.getLocationInfo().latLng;
                        }
                        SugDeparturePinNew.this.f9424e.onFetchFailed(latLng);
                        return;
                    }
                    SugDeparturePinNew.this.f9424e.onFetchSuccess(departureAddress);
                }

                public void onFetchAddressFail(LatLng latLng) {
                    boolean unused = SugDeparturePinNew.this.f9425f = false;
                    if (SugDeparturePinNew.this.f9424e != null) {
                        SugDeparturePinNew.this.f9424e.onFetchFailed(latLng);
                    }
                }
            };
        }
        return this.f9423d;
    }

    public void stop() {
        this.f9424e = null;
        this.f9423d = null;
        this.f9422c = null;
        IDepartureCompContract iDepartureCompContract = this.f9421b;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.destroy();
            this.f9421b = null;
        }
    }
}
