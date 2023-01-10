package com.didi.common.map.adapter.googlemapadapter;

import com.didi.common.map.adapter.googlemapadapter.converter.Converter;
import com.didi.common.map.internal.ICircleDelegate;
import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.model.CircleOptions;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.didi.common.map.util.DDSphericalUtil;
import com.google.android.gms.maps.model.Circle;
import java.util.ArrayList;
import java.util.List;

public class CircleDelegate implements ICircleDelegate {

    /* renamed from: a */
    private Circle f12577a;

    /* renamed from: b */
    private CircleOptions f12578b;

    public CircleDelegate(Circle circle, CircleOptions circleOptions) {
        this.f12577a = circle;
        this.f12578b = circleOptions;
    }

    public LatLng getCenter() throws MapNotExistApiException {
        Circle circle = this.f12577a;
        if (circle != null) {
            return Converter.convertFromGoogleLatLng(circle.getCenter());
        }
        return null;
    }

    public int getFillColor() throws MapNotExistApiException {
        Circle circle = this.f12577a;
        if (circle != null) {
            return circle.getFillColor();
        }
        return 0;
    }

    public double getRadius() throws MapNotExistApiException {
        Circle circle = this.f12577a;
        if (circle != null) {
            return circle.getRadius();
        }
        return 0.0d;
    }

    public int getStrokeColor() throws MapNotExistApiException {
        Circle circle = this.f12577a;
        if (circle != null) {
            return circle.getStrokeColor();
        }
        return 0;
    }

    public float getStrokeWidth() throws MapNotExistApiException {
        Circle circle = this.f12577a;
        if (circle != null) {
            return circle.getStrokeWidth();
        }
        return 0.0f;
    }

    public void setCenter(LatLng latLng) throws MapNotExistApiException {
        Circle circle = this.f12577a;
        if (circle != null) {
            circle.setCenter(Converter.convertToGoogleLatLng(latLng));
            CircleOptions circleOptions = this.f12578b;
            if (circleOptions != null) {
                circleOptions.center(latLng);
            }
        }
    }

    public void setFillColor(int i) throws MapNotExistApiException {
        Circle circle = this.f12577a;
        if (circle != null) {
            circle.setFillColor(i);
            CircleOptions circleOptions = this.f12578b;
            if (circleOptions != null) {
                circleOptions.fillColor(i);
            }
        }
    }

    public void setRadius(double d) throws MapNotExistApiException {
        Circle circle = this.f12577a;
        if (circle != null) {
            circle.setRadius(d);
            CircleOptions circleOptions = this.f12578b;
            if (circleOptions != null) {
                circleOptions.radius(d);
            }
        }
    }

    public void setStrokeColor(int i) throws MapNotExistApiException {
        Circle circle = this.f12577a;
        if (circle != null) {
            circle.setStrokeColor(i);
            CircleOptions circleOptions = this.f12578b;
            if (circleOptions != null) {
                circleOptions.strokeColor(i);
            }
        }
    }

    public void setStrokeWidth(float f) throws MapNotExistApiException {
        Circle circle = this.f12577a;
        if (circle != null) {
            circle.setStrokeWidth(f);
            CircleOptions circleOptions = this.f12578b;
            if (circleOptions != null) {
                circleOptions.strokeWidth(f);
            }
        }
    }

    public List<LatLng> getBounderPoints() {
        ArrayList arrayList = new ArrayList();
        Circle circle = this.f12577a;
        if (!(circle == null || circle.getCenter() == null || this.f12577a.getRadius() <= 0.0d)) {
            LatLng computeOffset = DDSphericalUtil.computeOffset(Converter.convertFromGoogleLatLng(this.f12577a.getCenter()), this.f12577a.getRadius(), 0.0d);
            LatLng computeOffset2 = DDSphericalUtil.computeOffset(Converter.convertFromGoogleLatLng(this.f12577a.getCenter()), this.f12577a.getRadius(), 90.0d);
            LatLng computeOffset3 = DDSphericalUtil.computeOffset(Converter.convertFromGoogleLatLng(this.f12577a.getCenter()), this.f12577a.getRadius(), 180.0d);
            LatLng computeOffset4 = DDSphericalUtil.computeOffset(Converter.convertFromGoogleLatLng(this.f12577a.getCenter()), this.f12577a.getRadius(), 270.0d);
            arrayList.add(computeOffset);
            arrayList.add(computeOffset2);
            arrayList.add(computeOffset3);
            arrayList.add(computeOffset4);
        }
        return arrayList;
    }

    public boolean contains(LatLng latLng) {
        return DDSphericalUtil.computeDistanceBetween(latLng, Converter.convertFromGoogleLatLng(this.f12577a.getCenter())) < this.f12577a.getRadius();
    }

    public String getId() throws MapNotExistApiException {
        Circle circle = this.f12577a;
        if (circle == null) {
            return null;
        }
        return circle.getId();
    }

    public void remove() throws MapNotExistApiException {
        Circle circle = this.f12577a;
        if (circle != null) {
            circle.remove();
            this.f12577a = null;
        }
        this.f12578b = null;
    }

    public void setZIndex(int i) throws MapNotExistApiException {
        Circle circle = this.f12577a;
        if (circle != null) {
            circle.setZIndex((float) i);
            CircleOptions circleOptions = this.f12578b;
            if (circleOptions != null) {
                circleOptions.zIndex(i);
            }
        }
    }

    public int getZIndex() throws MapNotExistApiException {
        Circle circle = this.f12577a;
        if (circle == null) {
            return 0;
        }
        return (int) circle.getZIndex();
    }

    public void setVisible(boolean z) throws MapNotExistApiException {
        Circle circle = this.f12577a;
        if (circle != null) {
            circle.setVisible(z);
            CircleOptions circleOptions = this.f12578b;
            if (circleOptions != null) {
                circleOptions.visible(z);
            }
        }
    }

    public boolean isVisible() throws MapNotExistApiException {
        Circle circle = this.f12577a;
        if (circle == null) {
            return false;
        }
        return circle.isVisible();
    }

    public boolean isClickable() throws MapNotExistApiException {
        Circle circle = this.f12577a;
        if (circle == null) {
            return false;
        }
        return circle.isClickable();
    }

    public void setClickable(boolean z) {
        Circle circle = this.f12577a;
        if (circle != null) {
            circle.setClickable(z);
            CircleOptions circleOptions = this.f12578b;
            if (circleOptions != null) {
                circleOptions.clickable(z);
            }
        }
    }

    public Object getElement() {
        return this.f12577a;
    }

    public void setOptions(IMapElementOptions iMapElementOptions) {
        Circle circle = this.f12577a;
        if (circle != null && iMapElementOptions != null && (iMapElementOptions instanceof CircleOptions)) {
            CircleOptions circleOptions = (CircleOptions) iMapElementOptions;
            this.f12578b = circleOptions;
            circle.setClickable(circleOptions.isClickable());
            this.f12577a.setCenter(Converter.convertToGoogleLatLng(this.f12578b.getCenter()));
            this.f12577a.setFillColor(this.f12578b.getFillColor());
            this.f12577a.setStrokeColor(this.f12578b.getStrokeColor());
            this.f12577a.setRadius(this.f12578b.getRadius());
            this.f12577a.setStrokeWidth(this.f12578b.getStrokeWidth());
            this.f12577a.setVisible(this.f12578b.isVisible());
            this.f12577a.setZIndex((float) this.f12578b.getZIndex());
        }
    }

    public IMapElementOptions getOptions() {
        return this.f12578b;
    }

    public LatLng getBottomTangencyPoint() {
        Circle circle = this.f12577a;
        if (circle != null) {
            return DDSphericalUtil.computeOffset(Converter.convertFromGoogleLatLng(circle.getCenter()), this.f12577a.getRadius(), 180.0d);
        }
        return null;
    }
}
