package com.didi.common.map.adapter.googlemapadapter;

import com.didi.common.map.adapter.googlemapadapter.converter.Converter;
import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.internal.IPolygonDelegate;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.PolygonOptions;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.google.android.gms.maps.model.Polygon;
import java.util.List;

public class PolygonDelegate implements IPolygonDelegate {

    /* renamed from: a */
    private Polygon f12609a;

    /* renamed from: b */
    private PolygonOptions f12610b;

    public PolygonDelegate(Polygon polygon, PolygonOptions polygonOptions) {
        if (polygon != null) {
            this.f12609a = polygon;
            this.f12610b = polygonOptions;
        }
    }

    public void setFillColor(int i) throws MapNotExistApiException {
        Polygon polygon = this.f12609a;
        if (polygon != null) {
            polygon.setFillColor(i);
            PolygonOptions polygonOptions = this.f12610b;
            if (polygonOptions != null) {
                polygonOptions.fillColor(i);
            }
        }
    }

    public void setStrokeColor(int i) throws MapNotExistApiException {
        Polygon polygon = this.f12609a;
        if (polygon != null) {
            polygon.setStrokeColor(i);
            PolygonOptions polygonOptions = this.f12610b;
            if (polygonOptions != null) {
                polygonOptions.strokeColor(i);
            }
        }
    }

    public void setStrokeWidth(int i) throws MapNotExistApiException {
        Polygon polygon = this.f12609a;
        if (polygon != null) {
            float f = (float) i;
            polygon.setStrokeWidth(f);
            PolygonOptions polygonOptions = this.f12610b;
            if (polygonOptions != null) {
                polygonOptions.strokeWidth(f);
            }
        }
    }

    public List<LatLng> getBounderPoints() throws MapNotExistApiException {
        Polygon polygon = this.f12609a;
        if (polygon != null) {
            return Converter.convertFromGoogleLatLngs(polygon.getPoints());
        }
        return null;
    }

    public String getId() throws MapNotExistApiException {
        Polygon polygon = this.f12609a;
        if (polygon == null) {
            return null;
        }
        return polygon.getId();
    }

    public void remove() throws MapNotExistApiException {
        Polygon polygon = this.f12609a;
        if (polygon != null) {
            polygon.remove();
            this.f12609a = null;
        }
    }

    public void setZIndex(int i) throws MapNotExistApiException {
        Polygon polygon = this.f12609a;
        if (polygon != null) {
            polygon.setZIndex((float) i);
            PolygonOptions polygonOptions = this.f12610b;
            if (polygonOptions != null) {
                polygonOptions.zIndex(i);
            }
        }
    }

    public int getZIndex() throws MapNotExistApiException {
        Polygon polygon = this.f12609a;
        if (polygon == null) {
            return 0;
        }
        return (int) polygon.getZIndex();
    }

    public void setVisible(boolean z) throws MapNotExistApiException {
        Polygon polygon = this.f12609a;
        if (polygon != null) {
            polygon.setVisible(z);
            PolygonOptions polygonOptions = this.f12610b;
            if (polygonOptions != null) {
                polygonOptions.visible(z);
            }
        }
    }

    public boolean isVisible() throws MapNotExistApiException {
        Polygon polygon = this.f12609a;
        if (polygon == null) {
            return false;
        }
        return polygon.isVisible();
    }

    public boolean isClickable() throws MapNotExistApiException {
        Polygon polygon = this.f12609a;
        if (polygon == null) {
            return false;
        }
        return polygon.isClickable();
    }

    public void setClickable(boolean z) {
        Polygon polygon = this.f12609a;
        if (polygon != null) {
            polygon.setClickable(z);
            PolygonOptions polygonOptions = this.f12610b;
            if (polygonOptions != null) {
                polygonOptions.clickable(z);
            }
        }
    }

    public Object getElement() {
        return this.f12609a;
    }

    public int getFillColor() {
        Polygon polygon = this.f12609a;
        if (polygon != null) {
            return polygon.getFillColor();
        }
        return 0;
    }

    public int getStrokeColor() {
        Polygon polygon = this.f12609a;
        if (polygon != null) {
            return polygon.getStrokeColor();
        }
        return 0;
    }

    public int getStrokeWidth() {
        Polygon polygon = this.f12609a;
        if (polygon != null) {
            return (int) polygon.getStrokeWidth();
        }
        return 0;
    }

    public void setOptions(IMapElementOptions iMapElementOptions) {
        if (iMapElementOptions != null && (iMapElementOptions instanceof PolygonOptions)) {
            PolygonOptions polygonOptions = (PolygonOptions) iMapElementOptions;
            this.f12610b = polygonOptions;
            com.google.android.gms.maps.model.PolygonOptions convertToGooglePolygonOptions = Converter.convertToGooglePolygonOptions(polygonOptions);
            this.f12609a.setFillColor(convertToGooglePolygonOptions.getFillColor());
            this.f12609a.setClickable(convertToGooglePolygonOptions.isClickable());
            this.f12609a.setHoles(convertToGooglePolygonOptions.getHoles());
            this.f12609a.setGeodesic(convertToGooglePolygonOptions.isGeodesic());
            this.f12609a.setStrokeWidth(convertToGooglePolygonOptions.getStrokeWidth());
            this.f12609a.setStrokeColor(convertToGooglePolygonOptions.getStrokeColor());
            this.f12609a.setPoints(convertToGooglePolygonOptions.getPoints());
            this.f12609a.setStrokeJointType(convertToGooglePolygonOptions.getStrokeJointType());
            this.f12609a.setStrokePattern(convertToGooglePolygonOptions.getStrokePattern());
            this.f12609a.setVisible(convertToGooglePolygonOptions.isVisible());
            this.f12609a.setZIndex(convertToGooglePolygonOptions.getZIndex());
        }
    }

    public IMapElementOptions getOptions() {
        return this.f12610b;
    }
}
