package com.didi.common.map.adapter.googlemapadapter;

import com.didi.common.map.adapter.googlemapadapter.converter.Converter;
import com.didi.common.map.internal.IGroundOverlayDelegate;
import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.model.GroundOverlayOptions;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LatLngBounds;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.GroundOverlay;
import java.util.ArrayList;
import java.util.List;

public class GroundOverlayDelegate implements IGroundOverlayDelegate {

    /* renamed from: a */
    private GroundOverlay f12600a;

    /* renamed from: b */
    private GroundOverlayOptions f12601b;

    public GroundOverlayDelegate(GroundOverlay groundOverlay, GroundOverlayOptions groundOverlayOptions) {
        this.f12600a = groundOverlay;
        this.f12601b = groundOverlayOptions;
    }

    public void remove() {
        GroundOverlay groundOverlay = this.f12600a;
        if (groundOverlay != null) {
            groundOverlay.remove();
            this.f12600a = null;
        }
    }

    public void setZIndex(int i) throws MapNotExistApiException {
        GroundOverlay groundOverlay = this.f12600a;
        if (groundOverlay != null) {
            groundOverlay.setZIndex((float) i);
            GroundOverlayOptions groundOverlayOptions = this.f12601b;
            if (groundOverlayOptions != null) {
                groundOverlayOptions.zIndex(i);
            }
        }
    }

    public int getZIndex() throws MapNotExistApiException {
        GroundOverlay groundOverlay = this.f12600a;
        if (groundOverlay == null) {
            return 0;
        }
        return (int) groundOverlay.getZIndex();
    }

    public void setVisible(boolean z) {
        GroundOverlay groundOverlay = this.f12600a;
        if (groundOverlay != null) {
            groundOverlay.setVisible(z);
            GroundOverlayOptions groundOverlayOptions = this.f12601b;
            if (groundOverlayOptions != null) {
                groundOverlayOptions.visible(z);
            }
        }
    }

    public boolean isVisible() throws MapNotExistApiException {
        GroundOverlay groundOverlay = this.f12600a;
        if (groundOverlay == null) {
            return false;
        }
        return groundOverlay.isVisible();
    }

    public boolean isClickable() throws MapNotExistApiException {
        GroundOverlay groundOverlay = this.f12600a;
        if (groundOverlay == null) {
            return false;
        }
        return groundOverlay.isClickable();
    }

    public Object getElement() {
        return this.f12600a;
    }

    public void setOptions(IMapElementOptions iMapElementOptions) {
        GroundOverlay groundOverlay = this.f12600a;
        if (groundOverlay != null && iMapElementOptions != null && (iMapElementOptions instanceof GroundOverlayOptions)) {
            GroundOverlayOptions groundOverlayOptions = (GroundOverlayOptions) iMapElementOptions;
            groundOverlay.setBearing(groundOverlayOptions.getBearing());
            this.f12600a.setClickable(groundOverlayOptions.isClickable());
            BitmapDescriptor convertToGoogleBitmapDescriptor = Converter.convertToGoogleBitmapDescriptor(groundOverlayOptions.getImage());
            if (convertToGoogleBitmapDescriptor != null) {
                this.f12600a.setImage(convertToGoogleBitmapDescriptor);
            }
            if (groundOverlayOptions.getPosition() != null) {
                this.f12600a.setPosition(Converter.convertToGoogleLatLng(groundOverlayOptions.getPosition()));
            }
            if (groundOverlayOptions.getBounds() != null) {
                this.f12600a.setPositionFromBounds(Converter.convertToGoogleLatLngBounds(groundOverlayOptions.getBounds()));
            }
            this.f12600a.setTransparency(groundOverlayOptions.getAlpha());
            this.f12600a.setVisible(groundOverlayOptions.isVisible());
            GroundOverlayOptions groundOverlayOptions2 = this.f12601b;
            if (groundOverlayOptions2 == null) {
                this.f12600a.setZIndex((float) groundOverlayOptions.getZIndex());
            } else if (groundOverlayOptions2.getZIndex() != groundOverlayOptions.getZIndex()) {
                this.f12600a.setZIndex((float) groundOverlayOptions.getZIndex());
            }
            this.f12601b = groundOverlayOptions;
        }
    }

    public IMapElementOptions getOptions() {
        return this.f12601b;
    }

    public void setClickable(boolean z) {
        GroundOverlay groundOverlay = this.f12600a;
        if (groundOverlay != null) {
            groundOverlay.setClickable(z);
            GroundOverlayOptions groundOverlayOptions = this.f12601b;
            if (groundOverlayOptions != null) {
                groundOverlayOptions.clickable(z);
            }
        }
    }

    public void position(LatLng latLng) {
        GroundOverlay groundOverlay;
        if (latLng != null && (groundOverlay = this.f12600a) != null) {
            groundOverlay.setPosition(Converter.convertToGoogleLatLng(latLng));
            GroundOverlayOptions groundOverlayOptions = this.f12601b;
            if (groundOverlayOptions != null) {
                groundOverlayOptions.position(latLng, groundOverlayOptions.getWidth(), this.f12601b.getHeight());
            }
        }
    }

    public void position(LatLngBounds latLngBounds) {
        GroundOverlay groundOverlay;
        if (latLngBounds != null && (groundOverlay = this.f12600a) != null) {
            groundOverlay.setPositionFromBounds(Converter.convertToGoogleLatLngBounds(latLngBounds));
            GroundOverlayOptions groundOverlayOptions = this.f12601b;
            if (groundOverlayOptions != null) {
                groundOverlayOptions.position(latLngBounds);
            }
        }
    }

    public String getId() {
        GroundOverlay groundOverlay = this.f12600a;
        return groundOverlay == null ? "" : groundOverlay.getId();
    }

    public List<LatLng> getBounderPoints() {
        GroundOverlay groundOverlay = this.f12600a;
        if (groundOverlay == null || groundOverlay.getBounds() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Converter.convertFromGoogleLatLng(this.f12600a.getBounds().northeast));
        arrayList.add(Converter.convertFromGoogleLatLng(this.f12600a.getBounds().southwest));
        arrayList.add(Converter.convertFromGoogleLatLng(this.f12600a.getBounds().getCenter()));
        return arrayList;
    }
}
