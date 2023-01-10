package com.didi.common.map.model;

import android.content.Context;
import android.os.Bundle;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.internal.IMarkerDelegate;
import com.didi.common.map.internal.MapExceptionHandler;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.animation.Animation;
import com.didi.common.map.model.animation.AnimationListener;
import com.didi.common.map.model.infowindow.InfoWindowFactory;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import java.util.List;

public class Marker implements IMapElement {

    /* renamed from: a */
    MarkerSize f12696a = new MarkerSize();

    /* renamed from: b */
    private IMarkerDelegate f12697b;

    /* renamed from: c */
    private InfoWindow f12698c;

    /* renamed from: d */
    private boolean f12699d = false;

    /* renamed from: e */
    private float f12700e = 0.0f;

    /* renamed from: f */
    private Bundle f12701f;

    /* renamed from: g */
    private Object f12702g;

    public Marker(IMarkerDelegate iMarkerDelegate) {
        this.f12697b = iMarkerDelegate;
    }

    public void setEnableTopHeightInterval(boolean z) {
        this.f12699d = z;
    }

    public boolean getEnableTopHeightInterval() {
        return this.f12699d;
    }

    public void setTopHeightInterval(float f) {
        this.f12700e = f;
    }

    public float getTopHeightInterval() {
        return this.f12700e;
    }

    public boolean isDraggable() {
        IMarkerDelegate iMarkerDelegate = this.f12697b;
        if (iMarkerDelegate == null) {
            return false;
        }
        return iMarkerDelegate.isDraggable();
    }

    public void setDraggable(boolean z) {
        try {
            if (this.f12697b != null) {
                this.f12697b.setDraggable(z);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public void setAnchor(float f, float f2) {
        try {
            if (this.f12697b != null) {
                this.f12697b.setAnchor(f, f2);
            }
            if (this.f12698c != null) {
                this.f12698c.updateAnchor();
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public boolean isFlat() {
        IMarkerDelegate iMarkerDelegate = this.f12697b;
        return iMarkerDelegate != null && iMarkerDelegate.isFlat();
    }

    public void setFlat(boolean z) {
        try {
            if (this.f12697b != null) {
                this.f12697b.setFlat(z);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public float getRotation() {
        IMarkerDelegate iMarkerDelegate = this.f12697b;
        if (iMarkerDelegate == null) {
            return 0.0f;
        }
        return iMarkerDelegate.getRotation();
    }

    public void setRotation(float f) {
        try {
            if (this.f12697b != null) {
                this.f12697b.setRotation(f);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public LatLng getPosition() {
        IMarkerDelegate iMarkerDelegate = this.f12697b;
        if (iMarkerDelegate == null) {
            return null;
        }
        return iMarkerDelegate.getPosition();
    }

    public void setPosition(LatLng latLng) {
        if (latLng != null) {
            try {
                if (this.f12697b != null) {
                    this.f12697b.setPosition(latLng);
                    if (this.f12698c != null) {
                        this.f12698c.setPosition(latLng);
                    }
                }
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public String getSnippet() {
        IMarkerDelegate iMarkerDelegate = this.f12697b;
        return iMarkerDelegate == null ? "" : iMarkerDelegate.getSnippet();
    }

    public void setSnippet(String str) {
        try {
            if (this.f12697b != null) {
                this.f12697b.setSnippet(str);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public String getTitle() {
        IMarkerDelegate iMarkerDelegate = this.f12697b;
        return iMarkerDelegate == null ? "" : iMarkerDelegate.getTitle();
    }

    public void setTitle(String str) {
        try {
            if (this.f12697b != null) {
                this.f12697b.setTitle(str);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public void hideInfoWindow() {
        try {
            if (this.f12698c != null) {
                this.f12698c.hideInfoWindow();
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public boolean isInfoWindowShown() {
        try {
            if (this.f12698c != null) {
                return this.f12698c.isInfoWindowShown();
            }
            return false;
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return false;
        }
    }

    public BitmapDescriptor getIcon() {
        IMarkerDelegate iMarkerDelegate = this.f12697b;
        if (iMarkerDelegate == null) {
            return null;
        }
        return iMarkerDelegate.getIcon();
    }

    public void setIcon(Context context, BitmapDescriptor bitmapDescriptor) {
        try {
            if (this.f12697b != null) {
                this.f12697b.setIcon(context, bitmapDescriptor);
            }
            if (this.f12698c != null) {
                this.f12698c.updateAnchor();
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public MarkerSize getMarkerSize() {
        BitmapDescriptor icon = getIcon();
        if (!(icon == null || icon.getBitmap() == null)) {
            this.f12696a.width = icon.getBitmap().getWidth();
            this.f12696a.height = icon.getBitmap().getHeight();
        }
        return this.f12696a;
    }

    public float getAlpha() {
        IMarkerDelegate iMarkerDelegate = this.f12697b;
        if (iMarkerDelegate == null) {
            return 0.0f;
        }
        return iMarkerDelegate.getAlpha();
    }

    public void setAlpha(float f) {
        try {
            if (this.f12697b != null) {
                this.f12697b.setAlpha(f);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public void setOptions(IMapElementOptions iMapElementOptions) {
        IMarkerDelegate iMarkerDelegate;
        if (iMapElementOptions != null && (iMarkerDelegate = this.f12697b) != null && (iMapElementOptions instanceof MarkerOptions)) {
            MarkerOptions markerOptions = (MarkerOptions) iMapElementOptions;
            try {
                iMarkerDelegate.setOptions(iMapElementOptions);
                if (this.f12698c != null && markerOptions.getPosition() != null) {
                    this.f12698c.setPosition(markerOptions.getPosition());
                }
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public MarkerOptions getOptions() {
        IMarkerDelegate iMarkerDelegate = this.f12697b;
        if (iMarkerDelegate == null) {
            return null;
        }
        return (MarkerOptions) iMarkerDelegate.getOptions();
    }

    public String getId() {
        try {
            if (this.f12697b != null) {
                return this.f12697b.getId();
            }
            return null;
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return null;
        }
    }

    public void setZIndex(int i) {
        try {
            if (this.f12697b != null) {
                this.f12697b.setZIndex(i);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public int getZIndex() {
        IMarkerDelegate iMarkerDelegate = this.f12697b;
        if (iMarkerDelegate == null) {
            return 0;
        }
        return iMarkerDelegate.getZIndex();
    }

    public void setVisible(boolean z) {
        try {
            if (this.f12697b != null) {
                this.f12697b.setVisible(z);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public boolean isVisible() {
        IMarkerDelegate iMarkerDelegate = this.f12697b;
        if (iMarkerDelegate == null) {
            return false;
        }
        return iMarkerDelegate.isVisible();
    }

    public boolean isClickable() {
        IMarkerDelegate iMarkerDelegate = this.f12697b;
        if (iMarkerDelegate == null) {
            return false;
        }
        return iMarkerDelegate.isClickable();
    }

    public void setAnimationListener(AnimationListener animationListener) {
        try {
            if (this.f12697b != null) {
                this.f12697b.setAnimationListener(animationListener);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public void startAnimation(Animation animation) {
        try {
            if (this.f12697b != null) {
                this.f12697b.startAnimation(animation);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Marker)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        String id = getId();
        if (id == null) {
            return false;
        }
        return id.equals(((Marker) obj).getId());
    }

    public int hashCode() {
        String id = getId();
        if (id == null) {
            return 0;
        }
        return id.hashCode();
    }

    public String toString() {
        return "Marker [position[" + getPosition() + "]] ,id = " + getId();
    }

    public List<LatLng> getBounderPoints() {
        try {
            if (this.f12697b != null) {
                return this.f12697b.getBounderPoints();
            }
            return null;
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return null;
        }
    }

    public Object getElement() {
        IMarkerDelegate iMarkerDelegate = this.f12697b;
        if (iMarkerDelegate == null) {
            return null;
        }
        return iMarkerDelegate.getElement();
    }

    public void remove() {
        destroyInfoWindow();
        IMarkerDelegate iMarkerDelegate = this.f12697b;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.remove();
            this.f12697b = null;
        }
    }

    public void setBundle(Bundle bundle) {
        this.f12701f = bundle;
    }

    public Bundle getBundle() {
        return this.f12701f;
    }

    public void setData(Object obj) {
        this.f12702g = obj;
    }

    public Object getData() {
        return this.f12702g;
    }

    public InfoWindow buildInfoWindow(Map map, Context context) {
        if (map == null || context == null) {
            return null;
        }
        if (this.f12698c == null) {
            this.f12698c = InfoWindowFactory.getInfowindow(map, context, this);
        }
        return this.f12698c;
    }

    public InfoWindow buildInfoWindow(Map map, Context context, InfoWindow.Position position) {
        if (map == null || context == null) {
            return null;
        }
        if (this.f12698c == null) {
            this.f12698c = InfoWindowFactory.getInfowindow(map, context, this);
        }
        return this.f12698c;
    }

    public InfoWindow getInfoWindow() {
        return this.f12698c;
    }

    public void destroyInfoWindow() {
        InfoWindow infoWindow = this.f12698c;
        if (infoWindow != null) {
            infoWindow.destroy();
            this.f12698c = null;
        }
    }

    public static class MarkerSize {
        public int height;
        public int width;

        public boolean isEmpty() {
            return this.width <= 0 || this.height <= 0;
        }
    }
}
