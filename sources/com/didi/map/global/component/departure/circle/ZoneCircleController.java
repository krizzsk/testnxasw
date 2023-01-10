package com.didi.map.global.component.departure.circle;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.LatLng;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ZoneCircleController implements Observer {

    /* renamed from: a */
    private Map f27287a;

    /* renamed from: b */
    private Circle f27288b;

    /* renamed from: c */
    private ZoneCircleOption f27289c;

    /* renamed from: d */
    private Context f27290d;

    /* renamed from: e */
    private boolean f27291e = false;

    public ZoneCircleController(Map map, ZoneCircleOption zoneCircleOption, Context context) {
        this.f27289c = zoneCircleOption;
        this.f27287a = map;
        this.f27290d = context;
        zoneCircleOption.addObserver(this);
    }

    public void showCircle() {
        hideCircle();
        this.f27288b = this.f27287a.addCircle(this.f27289c.getCircleOptions());
    }

    public void hideCircle() {
        Circle circle = this.f27288b;
        if (circle != null) {
            this.f27287a.remove(circle);
            this.f27288b = null;
        }
    }

    public List<LatLng> getBestViewPoints() {
        ArrayList arrayList = new ArrayList();
        Circle circle = this.f27288b;
        if (circle != null) {
            arrayList.addAll(circle.getBounderPoints());
        }
        return arrayList;
    }

    public LatLng getCenter() {
        return this.f27289c.getCenter();
    }

    public boolean allowDragToOuter() {
        ZoneCircleOption zoneCircleOption = this.f27289c;
        if (zoneCircleOption == null) {
            return true;
        }
        return zoneCircleOption.isAllowDragToOuter();
    }

    public boolean isOutside() {
        Map map;
        if (this.f27288b == null || (map = this.f27287a) == null || map.getCameraPosition() == null) {
            return false;
        }
        boolean z = !this.f27288b.contains(this.f27287a.getCameraPosition().target);
        this.f27291e = z;
        return z;
    }

    public boolean handleMapDrag(LatLng latLng) {
        Circle circle;
        if (latLng == null || (circle = this.f27288b) == null) {
            return this.f27291e;
        }
        boolean contains = circle.contains(latLng);
        if (contains) {
            if (this.f27291e) {
                this.f27288b.setStrokeColor(this.f27289c.getStrokeColor());
                this.f27288b.setFillColor(this.f27289c.getFillColor());
            }
        } else if (!this.f27291e) {
            this.f27288b.setStrokeColor(-49056);
            this.f27288b.setFillColor(872366176);
        }
        boolean z = !contains;
        this.f27291e = z;
        return z;
    }

    public void update(Observable observable, Object obj) {
        if (observable instanceof ZoneCircleOption) {
            this.f27289c = (ZoneCircleOption) observable;
            showCircle();
        }
    }

    public Circle getCircle() {
        return this.f27288b;
    }
}
