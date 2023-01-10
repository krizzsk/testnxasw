package com.didi.map.global.component.line.pax.walkanddropoff.newversion;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.LatLngUtils;
import com.didi.common.sensor.OrientationListener;
import com.didi.common.sensor.OrientationManager;
import com.didi.map.global.component.myLocation.view.LocationAccuracyCircleOptions;
import com.didi.map.global.component.myLocation.view.MyLocationMarker;
import com.didi.map.global.component.myLocation.view.MyLocationMarkerOptions;
import java.util.ArrayList;
import java.util.List;

public class PsgLocationMarker {

    /* renamed from: a */
    private String f28226a = "PsgLocationMarker";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public MyLocationMarker f28227b;

    /* renamed from: c */
    private Context f28228c;

    /* renamed from: d */
    private Map f28229d;

    /* renamed from: e */
    private OrientationListener f28230e;

    public PsgLocationMarker(Context context, Map map) {
        this.f28228c = context;
        this.f28229d = map;
        MyLocationMarker myLocationMarker = new MyLocationMarker(new MyLocationMarkerOptions.Builder().accuracyCircleOptions((LocationAccuracyCircleOptions) null).zIndex(1).map(this.f28229d).build());
        this.f28227b = myLocationMarker;
        myLocationMarker.addSelf();
        this.f28227b.setVisible(true);
        m22144a();
    }

    public void updatePosition(LatLng latLng) {
        MyLocationMarker myLocationMarker;
        if (LatLngUtils.locateCorrect(latLng) && (myLocationMarker = this.f28227b) != null) {
            myLocationMarker.updatePosition(latLng);
        }
    }

    public void destroy() {
        MyLocationMarker myLocationMarker = this.f28227b;
        if (myLocationMarker != null) {
            myLocationMarker.removeSelf(false, 0);
            this.f28227b = null;
        }
        if (this.f28230e != null) {
            OrientationManager.getInstance(this.f28228c).removeOrientationListener(this.f28230e);
            this.f28230e = null;
        }
    }

    /* renamed from: a */
    private void m22144a() {
        if (this.f28228c != null && this.f28229d != null) {
            this.f28230e = new OrientationListener() {
                public void onOrientationChanged(float f, float f2, float f3) {
                    if (PsgLocationMarker.this.f28227b != null) {
                        PsgLocationMarker.this.f28227b.updateArrowRotateAngle(f);
                    }
                }
            };
            OrientationManager.getInstance(this.f28228c).addOrientationListener(this.f28230e);
        }
    }

    public List<IMapElement> getBestViewElements() {
        MyLocationMarker myLocationMarker = this.f28227b;
        if (myLocationMarker != null) {
            return myLocationMarker.getMarkers();
        }
        return new ArrayList();
    }
}
