package com.rider.rlab_im_map_plugin.map;

import android.content.Context;
import com.didi.common.map.model.LatLng;
import com.didi.common.sensor.OrientationListener;
import com.didi.common.sensor.OrientationManager;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;
import com.rider.rlab_im_map_plugin.channel.MapIMPluginHelper;
import com.rider.rlab_im_map_plugin.engine.ImMapConfig;
import com.rider.rlab_im_map_plugin.marker.MyLocationMarker;

public class MyLocationListener implements OrientationListener {

    /* renamed from: a */
    private final Logger f58673a = LoggerFactory.getLogger("MapViewMyLocationListener");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f58674b;

    /* renamed from: c */
    private boolean f58675c = false;

    /* renamed from: d */
    private final ImLocationListener f58676d = new ImLocationListener();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public MyLocationMarker f58677e;

    /* renamed from: f */
    private final DIDILocationUpdateOption f58678f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LatLng f58679g;

    /* renamed from: h */
    private int f58680h = 0;

    public MyLocationListener(Context context) {
        this.f58674b = context;
        DIDILocationUpdateOption defaultLocationUpdateOption = DIDILocationManager.getInstance(context).getDefaultLocationUpdateOption();
        this.f58678f = defaultLocationUpdateOption;
        defaultLocationUpdateOption.setInterval(DIDILocationUpdateOption.IntervalMode.NORMAL);
        this.f58678f.setModuleKey(context.getPackageName());
    }

    public void onOrientationChanged(float f, float f2, float f3) {
        MyLocationMarker myLocationMarker = this.f58677e;
        if (myLocationMarker != null) {
            myLocationMarker.updateArrowRotateAngle(f);
        }
    }

    public void startLocation() {
        Context context = this.f58674b;
        if (context != null && !this.f58675c) {
            DIDILocationManager.getInstance(context).requestLocationUpdates(this.f58676d, this.f58678f);
            OrientationManager.getInstance(this.f58674b).addOrientationListener(this);
            this.f58675c = true;
        }
    }

    public void stopLocation() {
        Context context = this.f58674b;
        if (context != null) {
            OrientationManager.getInstance(context).removeOrientationListener(this);
            DIDILocationManager.getInstance(this.f58674b).removeLocationUpdates(this.f58676d);
            this.f58675c = false;
        }
    }

    public void setMarker(MyLocationMarker myLocationMarker) {
        this.f58677e = myLocationMarker;
    }

    public LatLng getLatLng() {
        return this.f58679g;
    }

    public class ImLocationListener implements DIDILocationListener {
        public void onStatusUpdate(String str, int i, String str2) {
        }

        public ImLocationListener() {
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            if (MyLocationListener.this.f58677e != null && dIDILocation != null) {
                LatLng latLng = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
                LatLng mockLatLng = ImMapConfig.getInstance().getMockLatLng();
                if (mockLatLng != null) {
                    MyLocationListener.this.f58677e.updatePosition(mockLatLng);
                    LatLng unused = MyLocationListener.this.f58679g = mockLatLng;
                } else {
                    MyLocationListener.this.f58677e.updatePosition(latLng);
                    LatLng unused2 = MyLocationListener.this.f58679g = latLng;
                }
                MapIMPluginHelper.setLocationInfo(MyLocationListener.this.f58679g.latitude, MyLocationListener.this.f58679g.longitude);
            }
        }

        public void onLocationError(int i, ErrInfo errInfo) {
            DIDILocation lastKnownLocation;
            if (MyLocationListener.this.f58677e != null && (lastKnownLocation = DIDILocationManager.getInstance(MyLocationListener.this.f58674b).getLastKnownLocation()) != null) {
                MyLocationListener.this.f58677e.updatePosition(new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()));
            }
        }
    }
}
