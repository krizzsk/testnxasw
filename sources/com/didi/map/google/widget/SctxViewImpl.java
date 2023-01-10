package com.didi.map.google.widget;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.didi.common.map.Map;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.MarkerOptions;
import com.didi.map.global.sctx.SctxService;
import com.didi.map.sdk.nav.car.CarMarker;
import com.didi.map.sdk.nav.car.IMyLocationDelegate;
import com.taxis99.R;
import java.util.List;

public class SctxViewImpl implements ISctxViewDelegate {
    public static final int LINE_COLOR = Color.parseColor("#262B2E");
    public static final int LINE_COLOR_HAS_TRAFFIC = Color.parseColor("#6883F4");
    public static final float MASK_ALPHA = 0.1f;
    public static final int MASK_COLOR = Color.parseColor("#B4E6FF");
    public static final int NEW_LINE_COLOR = Color.parseColor("#33BBFF");

    /* renamed from: e */
    private static final float f30270e = 0.5f;

    /* renamed from: a */
    private final Context f30271a;

    /* renamed from: b */
    private Map f30272b;

    /* renamed from: c */
    private BitmapDescriptor f30273c;

    /* renamed from: d */
    private int f30274d;

    /* renamed from: f */
    private InfoWindow f30275f;

    /* renamed from: g */
    private IMyLocationDelegate f30276g;

    public SctxViewImpl(Context context, Map map, IMyLocationDelegate iMyLocationDelegate) {
        this.f30271a = context;
        this.f30272b = map;
        this.f30276g = iMyLocationDelegate;
    }

    public void setLocationDelegate(IMyLocationDelegate iMyLocationDelegate) {
        this.f30276g = iMyLocationDelegate;
    }

    public void setCarMarkerBitmap(BitmapDescriptor bitmapDescriptor) {
        this.f30273c = bitmapDescriptor;
        IMyLocationDelegate iMyLocationDelegate = this.f30276g;
        if (iMyLocationDelegate != null && iMyLocationDelegate.getCarMarker() != null) {
            this.f30276g.getCarMarker().setIcon(this.f30271a, this.f30273c);
        }
    }

    public void setCarMarkerZIndex(int i) {
        this.f30274d = i;
    }

    public void set3DCarEnabled(boolean z) {
        IMyLocationDelegate iMyLocationDelegate = this.f30276g;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.set3DCarEnabled(z);
        }
    }

    public void set3DCarIcons(List<String> list) {
        IMyLocationDelegate iMyLocationDelegate = this.f30276g;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.set3DCarIcons(list);
        }
    }

    public boolean refresh3DCarIcons(boolean z, List<String> list) {
        IMyLocationDelegate iMyLocationDelegate = this.f30276g;
        if (iMyLocationDelegate != null) {
            return iMyLocationDelegate.refresh3DCarIcons(z, list);
        }
        return false;
    }

    public CarMarker getCarMarker() {
        return this.f30276g.getCarMarker();
    }

    public void removeMarker() {
        IMyLocationDelegate iMyLocationDelegate;
        Map map = this.f30272b;
        if (map != null && (iMyLocationDelegate = this.f30276g) != null) {
            map.remove(iMyLocationDelegate.getCarMarker());
        }
    }

    public void updateCarMarker(LatLng latLng) {
        if (this.f30273c == null) {
            this.f30273c = BitmapDescriptorFactory.fromResource(this.f30271a, R.drawable.gua_sliding_pop);
        }
        IMyLocationDelegate iMyLocationDelegate = this.f30276g;
        if (iMyLocationDelegate == null) {
            return;
        }
        if (iMyLocationDelegate.getCarMarker() == null) {
            this.f30276g.setCarMarkerOptions(SctxService.SctxMapElementTags.CAR_MARKER, new MarkerOptions().icon(this.f30273c).draggable(false).anchor(0.5f, 0.5f).position(latLng));
            if (this.f30274d > 0 && this.f30276g.getCarMarker() != null) {
                this.f30276g.getCarMarker().setZIndex(this.f30274d);
                return;
            }
            return;
        }
        this.f30276g.getCarMarker().setPosition(latLng);
    }

    public void updateCarDirection(float f) {
        IMyLocationDelegate iMyLocationDelegate = this.f30276g;
        if (iMyLocationDelegate != null && iMyLocationDelegate.getCarMarker() != null) {
            this.f30276g.getCarMarker().setRotation(f);
        }
    }

    public void showInfoWindow(Map map, View view) {
        IMyLocationDelegate iMyLocationDelegate;
        if (!(this.f30275f != null || (iMyLocationDelegate = this.f30276g) == null || iMyLocationDelegate.getCarMarker() == null)) {
            this.f30275f = this.f30276g.getCarMarker().buildInfoWindow(map, this.f30271a);
        }
        InfoWindow infoWindow = this.f30275f;
        if (infoWindow != null) {
            infoWindow.showInfoWindow(view);
        }
    }

    public void destroyInfoWindow() {
        InfoWindow infoWindow = this.f30275f;
        if (infoWindow != null) {
            infoWindow.destroy();
            this.f30275f = null;
        }
    }

    public void destroy() {
        IMyLocationDelegate iMyLocationDelegate = this.f30276g;
        if (iMyLocationDelegate != null) {
            iMyLocationDelegate.destroy();
        }
        destroyInfoWindow();
        removeMarker();
    }
}
