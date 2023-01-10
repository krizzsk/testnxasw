package com.didi.common.map.model;

import android.os.Bundle;
import com.didi.common.map.internal.IGroundOverlayDelegate;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.internal.MapExceptionHandler;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import java.util.List;

public class GroundOverlay implements IMapElement {

    /* renamed from: a */
    private IGroundOverlayDelegate f12651a;

    /* renamed from: b */
    private Bundle f12652b;

    /* renamed from: c */
    private Object f12653c;

    public GroundOverlay(IGroundOverlayDelegate iGroundOverlayDelegate) {
        this.f12651a = iGroundOverlayDelegate;
    }

    public void remove() {
        IGroundOverlayDelegate iGroundOverlayDelegate = this.f12651a;
        if (iGroundOverlayDelegate != null) {
            iGroundOverlayDelegate.remove();
            this.f12651a = null;
        }
    }

    public void setBundle(Bundle bundle) {
        this.f12652b = bundle;
    }

    public Bundle getBundle() {
        return this.f12652b;
    }

    public void setData(Object obj) {
        this.f12653c = obj;
    }

    public Object getData() {
        return this.f12653c;
    }

    public void setOptions(IMapElementOptions iMapElementOptions) {
        try {
            if (this.f12651a != null) {
                this.f12651a.setOptions(iMapElementOptions);
            }
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.printMapNotExistApiException(e);
        }
    }

    public IMapElementOptions getOptions() {
        IGroundOverlayDelegate iGroundOverlayDelegate = this.f12651a;
        if (iGroundOverlayDelegate == null) {
            return null;
        }
        return iGroundOverlayDelegate.getOptions();
    }

    public String getId() {
        IGroundOverlayDelegate iGroundOverlayDelegate = this.f12651a;
        if (iGroundOverlayDelegate == null) {
            return null;
        }
        return iGroundOverlayDelegate.getId();
    }

    public void setZIndex(int i) {
        IGroundOverlayDelegate iGroundOverlayDelegate = this.f12651a;
        if (iGroundOverlayDelegate != null) {
            iGroundOverlayDelegate.setZIndex(i);
        }
    }

    public int getZIndex() {
        IGroundOverlayDelegate iGroundOverlayDelegate = this.f12651a;
        if (iGroundOverlayDelegate == null) {
            return 0;
        }
        return iGroundOverlayDelegate.getZIndex();
    }

    public void setVisible(boolean z) {
        IGroundOverlayDelegate iGroundOverlayDelegate = this.f12651a;
        if (iGroundOverlayDelegate != null) {
            iGroundOverlayDelegate.setVisible(z);
        }
    }

    public void setClickable(boolean z) {
        IGroundOverlayDelegate iGroundOverlayDelegate = this.f12651a;
        if (iGroundOverlayDelegate != null) {
            iGroundOverlayDelegate.setClickable(z);
        }
    }

    public boolean isVisible() {
        IGroundOverlayDelegate iGroundOverlayDelegate = this.f12651a;
        if (iGroundOverlayDelegate == null) {
            return false;
        }
        return iGroundOverlayDelegate.isVisible();
    }

    public boolean isClickable() {
        IGroundOverlayDelegate iGroundOverlayDelegate = this.f12651a;
        if (iGroundOverlayDelegate == null) {
            return false;
        }
        return iGroundOverlayDelegate.isClickable();
    }

    public List<LatLng> getBounderPoints() {
        IGroundOverlayDelegate iGroundOverlayDelegate = this.f12651a;
        if (iGroundOverlayDelegate == null) {
            return null;
        }
        return iGroundOverlayDelegate.getBounderPoints();
    }

    public Object getElement() {
        IGroundOverlayDelegate iGroundOverlayDelegate = this.f12651a;
        if (iGroundOverlayDelegate == null) {
            return null;
        }
        return iGroundOverlayDelegate.getElement();
    }
}
