package com.didi.map.global.flow.scene.vamos.components.departure;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.sdk.departure.DepartureAddress;
import com.didi.map.sdk.departure.DepartureFactory;
import com.didi.map.sdk.departure.IDepartureCompContract;
import com.didi.map.sdk.departure.internal.bubble.DepartureBubble;
import com.didi.map.sdk.departure.param.DepartureCompParam;
import com.didi.map.sdk.departure.param.DepartureLocationInfo;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.sdk.poibase.model.RpcPoi;

public class VamosDeparturePin {

    /* renamed from: a */
    private static final String f29584a = "VamosDeparturePin";

    /* renamed from: b */
    private Context f29585b;

    /* renamed from: c */
    private Map f29586c;

    /* renamed from: d */
    private IDepartureCompContract f29587d;

    /* renamed from: e */
    private IDepartureCompContract.IDepartueCompCallback f29588e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f29589f;

    public VamosDeparturePin(Context context, Map map) {
        this.f29585b = context;
        this.f29586c = map;
    }

    public void start(DepartureCompParam departureCompParam) {
        if (departureCompParam != null) {
            departureCompParam.listener = m22936a(departureCompParam.listener);
            IDepartureCompContract createCoreManager = DepartureFactory.createCoreManager();
            this.f29587d = createCoreManager;
            createCoreManager.create(this.f29585b, this.f29586c);
            this.f29587d.setConfigParam(departureCompParam);
            this.f29587d.start();
        }
    }

    /* renamed from: a */
    private IDepartureCompContract.IDepartueCompCallback m22936a(final IDepartureCompContract.IDepartueCompCallback iDepartueCompCallback) {
        if (this.f29588e == null) {
            this.f29588e = new IDepartureCompContract.IDepartueCompCallback() {
                public void onStartDragging() {
                    SystemUtils.log(3, VamosDeparturePin.f29584a, "onStartDragging", (Throwable) null, "com.didi.map.global.flow.scene.vamos.components.departure.VamosDeparturePin$1", 60);
                    VamosDeparturePin.this.removeDepartureBubble(true);
                    IDepartureCompContract.IDepartueCompCallback iDepartueCompCallback = iDepartueCompCallback;
                    if (iDepartueCompCallback != null) {
                        iDepartueCompCallback.onStartDragging();
                    }
                }

                public void onDepartureLoading(LatLng latLng) {
                    SystemUtils.log(3, VamosDeparturePin.f29584a, "onDepartureLoading latLng:" + latLng, (Throwable) null, "com.didi.map.global.flow.scene.vamos.components.departure.VamosDeparturePin$1", 69);
                    IDepartureCompContract.IDepartueCompCallback iDepartueCompCallback = iDepartueCompCallback;
                    if (iDepartueCompCallback != null) {
                        iDepartueCompCallback.onDepartureLoading(latLng);
                    }
                }

                public void onDepartureAddressChanged(DepartureAddress departureAddress) {
                    SystemUtils.log(3, VamosDeparturePin.f29584a, "onDepartureAddressChanged departureAddress:" + departureAddress, (Throwable) null, "com.didi.map.global.flow.scene.vamos.components.departure.VamosDeparturePin$1", 77);
                    boolean unused = VamosDeparturePin.this.f29589f = departureAddress != null && departureAddress.hasSpecialPois();
                    if (departureAddress != null) {
                        VamosDeparturePin.this.m22938a(departureAddress);
                    }
                    IDepartureCompContract.IDepartueCompCallback iDepartueCompCallback = iDepartueCompCallback;
                    if (iDepartueCompCallback != null) {
                        iDepartueCompCallback.onDepartureAddressChanged(departureAddress);
                    }
                }

                public void onFetchAddressFailed(LatLng latLng) {
                    SystemUtils.log(6, VamosDeparturePin.f29584a, "onFetchAddressFailed latLng:" + latLng, (Throwable) null, "com.didi.map.global.flow.scene.vamos.components.departure.VamosDeparturePin$1", 89);
                    IDepartureCompContract.IDepartueCompCallback iDepartueCompCallback = iDepartueCompCallback;
                    if (iDepartueCompCallback != null) {
                        iDepartueCompCallback.onFetchAddressFailed(latLng);
                    }
                }
            };
        }
        return this.f29588e;
    }

    public void updateLocation(DepartureLocationInfo departureLocationInfo, boolean z) {
        IDepartureCompContract iDepartureCompContract = this.f29587d;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.updateDepartureLocation(departureLocationInfo, z);
        }
    }

    public <T extends DepartureBubble> T createDepartureBubble(Class<T> cls) {
        SystemUtils.log(3, f29584a, "createDepartureBubble() clazz: " + cls, (Throwable) null, "com.didi.map.global.flow.scene.vamos.components.departure.VamosDeparturePin", 106);
        IDepartureCompContract iDepartureCompContract = this.f29587d;
        if (iDepartureCompContract != null) {
            return iDepartureCompContract.createDepartureBubble(cls);
        }
        return null;
    }

    public void removeDepartureBubble(boolean z) {
        SystemUtils.log(3, f29584a, "removeDepartureBubble() animate: " + z, (Throwable) null, "com.didi.map.global.flow.scene.vamos.components.departure.VamosDeparturePin", 114);
        IDepartureCompContract iDepartureCompContract = this.f29587d;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.removeDepartureBubble(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22938a(DepartureAddress departureAddress) {
        VamosSingleLineDepartureBubble vamosSingleLineDepartureBubble;
        if (!m22940b(departureAddress)) {
            SystemUtils.log(5, f29584a, "DepartureAddress bubbleDesc is empty", (Throwable) null, "com.didi.map.global.flow.scene.vamos.components.departure.VamosDeparturePin", 122);
            return;
        }
        RpcPoi address = departureAddress.getAddress();
        boolean z = TextUtil.isEmpty(address.extend_info.startParkingProperty) || !address.extend_info.startParkingProperty.equals(DepartureConstants.PARKING_VIOLATION);
        SystemUtils.log(3, f29584a, "isRecommendPoi: " + departureAddress.isRecommendPoi() + ", isParking " + z + ", startParkingProperty: " + address.extend_info.startParkingProperty + ", bubbleDesc: " + address.extend_info.bubbleDesc, (Throwable) null, "com.didi.map.global.flow.scene.vamos.components.departure.VamosDeparturePin", 130);
        if (!z) {
            VamosPicSingleLineDepartureBubble vamosPicSingleLineDepartureBubble = (VamosPicSingleLineDepartureBubble) createDepartureBubble(VamosPicSingleLineDepartureBubble.class);
            if (vamosPicSingleLineDepartureBubble != null) {
                vamosPicSingleLineDepartureBubble.setText(address.extend_info.bubbleDesc).show();
            }
        } else if (departureAddress.isRecommendPoi() && (vamosSingleLineDepartureBubble = (VamosSingleLineDepartureBubble) createDepartureBubble(VamosSingleLineDepartureBubble.class)) != null) {
            vamosSingleLineDepartureBubble.setText(address.extend_info.bubbleDesc).show();
        }
    }

    public boolean isAirPortPickUpPoint() {
        return this.f29589f;
    }

    /* renamed from: b */
    private boolean m22940b(DepartureAddress departureAddress) {
        return (departureAddress == null || departureAddress.getAddress() == null || departureAddress.getAddress().extend_info == null || TextUtils.isEmpty(departureAddress.getAddress().extend_info.bubbleDesc)) ? false : true;
    }

    public void destroy() {
        this.f29588e = null;
        IDepartureCompContract iDepartureCompContract = this.f29587d;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.destroy();
            this.f29587d = null;
        }
    }
}
