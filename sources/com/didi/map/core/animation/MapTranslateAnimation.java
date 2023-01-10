package com.didi.map.core.animation;

import android.view.animation.Interpolator;
import com.didi.map.core.point.GeoPoint;

public class MapTranslateAnimation extends MapAnimation {

    /* renamed from: a */
    private GeoPoint f26974a = null;

    /* renamed from: b */
    private GeoPoint f26975b = null;

    /* renamed from: c */
    private boolean f26976c = false;

    public MapTranslateAnimation(GeoPoint geoPoint) {
        if (geoPoint != null) {
            this.f26975b = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
            this.f26976c = true;
        }
    }

    /* access modifiers changed from: protected */
    public void performAnimation(float f, Interpolator interpolator) {
        GeoPoint geoPoint = this.f26975b;
        if (geoPoint != null && this.f26974a != null) {
            int latitudeE6 = geoPoint.getLatitudeE6() - this.f26974a.getLatitudeE6();
            float interpolation = interpolator.getInterpolation(f);
            int latitudeE62 = this.f26974a.getLatitudeE6() + ((int) (((float) latitudeE6) * interpolation));
            int longitudeE6 = this.f26974a.getLongitudeE6() + ((int) (((float) (this.f26975b.getLongitudeE6() - this.f26974a.getLongitudeE6())) * interpolation));
            if (this.animationProperty != null) {
                this.animationProperty.setPosition(latitudeE62, longitudeE6);
            }
        }
    }

    public boolean startAnimation(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (!super.startAnimation((GeoPoint) null, (GeoPoint) null)) {
            return false;
        }
        if (geoPoint != null) {
            this.f26974a = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
        }
        if (this.f26976c || geoPoint2 == null) {
            return true;
        }
        this.f26975b = new GeoPoint(geoPoint2.getLatitudeE6(), geoPoint2.getLongitudeE6());
        return true;
    }
}
