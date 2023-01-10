package com.didi.map.sdk.nav.car;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.internal.IMapElementOptions;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.sdk.nav.util.ApolloToggleUtils;
import java.util.List;

public class CarMarker implements IMapElement {

    /* renamed from: a */
    private static final String f30833a = "CarMarker";

    /* renamed from: b */
    private Context f30834b;

    /* renamed from: c */
    private Marker f30835c;

    /* renamed from: d */
    private boolean f30836d;

    /* renamed from: e */
    private int f30837e;

    /* renamed from: f */
    private float f30838f;

    /* renamed from: g */
    private BitmapDescriptor f30839g;

    /* renamed from: h */
    private BitmapDescriptor f30840h;

    public CarMarker(Context context, Marker marker) {
        this.f30834b = context;
        this.f30835c = marker;
    }

    public Marker getMarker() {
        return this.f30835c;
    }

    public void set3DCarEnabled(boolean z) {
        this.f30836d = z;
        m23719a();
        CarIconsPreloader.getInstance().set3DCarEnabled(z);
    }

    /* renamed from: a */
    private void m23719a() {
        Marker marker = this.f30835c;
        if (marker == null || this.f30834b == null) {
            DLog.m10773d("3dcar", "resizeFromMarkerToInfoWindowInterval() return", new Object[0]);
            return;
        }
        marker.setEnableTopHeightInterval(true);
        int dp2px = DisplayUtils.dp2px(this.f30834b, (float) ApolloToggleUtils.get3DCarHeightInterval());
        this.f30835c.setTopHeightInterval((float) dp2px);
        DLog.m10773d("3dcar", "resizeFromMarkerToInfoWindowInterval() topHeightInterval:" + dp2px, new Object[0]);
    }

    public void setOptions(IMapElementOptions iMapElementOptions) {
        Marker marker = this.f30835c;
        if (marker != null) {
            marker.setOptions(iMapElementOptions);
        }
    }

    public IMapElementOptions getOptions() {
        Marker marker = this.f30835c;
        if (marker != null) {
            return marker.getOptions();
        }
        return null;
    }

    public String getId() {
        Marker marker = this.f30835c;
        return marker != null ? marker.getId() : "null";
    }

    public void setZIndex(int i) {
        Marker marker = this.f30835c;
        if (marker != null) {
            marker.setZIndex(i);
        }
    }

    public int getZIndex() {
        Marker marker = this.f30835c;
        if (marker != null) {
            return marker.getZIndex();
        }
        return 0;
    }

    public void setVisible(boolean z) {
        Marker marker = this.f30835c;
        if (marker != null) {
            marker.setVisible(z);
        }
    }

    public boolean isVisible() {
        Marker marker = this.f30835c;
        if (marker != null) {
            return marker.isVisible();
        }
        return false;
    }

    public boolean isClickable() {
        Marker marker = this.f30835c;
        if (marker != null) {
            return marker.isClickable();
        }
        return false;
    }

    public List<LatLng> getBounderPoints() {
        Marker marker = this.f30835c;
        if (marker != null) {
            return marker.getBounderPoints();
        }
        return null;
    }

    public Object getElement() {
        Marker marker = this.f30835c;
        if (marker != null) {
            return marker.getElement();
        }
        return null;
    }

    public void remove() {
        destroy();
    }

    public void setBundle(Bundle bundle) {
        Marker marker = this.f30835c;
        if (marker != null) {
            marker.setBundle(bundle);
        }
    }

    public Bundle getBundle() {
        Marker marker = this.f30835c;
        if (marker != null) {
            return marker.getBundle();
        }
        return null;
    }

    public void setData(Object obj) {
        Marker marker = this.f30835c;
        if (marker != null) {
            marker.setData(obj);
        }
    }

    public Object getData() {
        Marker marker = this.f30835c;
        if (marker != null) {
            return marker.getData();
        }
        return null;
    }

    public void setIcon(Context context, BitmapDescriptor bitmapDescriptor) {
        Marker marker = this.f30835c;
        if (marker != null) {
            marker.setIcon(context, bitmapDescriptor);
        }
    }

    public BitmapDescriptor getIcon() {
        Marker marker = this.f30835c;
        if (marker != null) {
            return marker.getIcon();
        }
        return null;
    }

    public void setPosition(LatLng latLng) {
        Marker marker = this.f30835c;
        if (marker != null) {
            marker.setPosition(latLng);
        }
    }

    public LatLng getPosition() {
        Marker marker = this.f30835c;
        if (marker != null) {
            return marker.getPosition();
        }
        return null;
    }

    public int getLastIndex() {
        return this.f30837e;
    }

    public void setRotation(float f) {
        float f2 = f % 360.0f;
        if (f2 < 0.0f) {
            f2 += 360.0f;
        }
        this.f30838f = f2;
        if (this.f30836d) {
            int indexByAngle = CarAngleUtil.getIndexByAngle(f2);
            if (this.f30837e != indexByAngle) {
                this.f30837e = indexByAngle;
                BitmapDescriptor carBitmapDescriptor = CarAngleUtil.getCarBitmapDescriptor(this.f30834b, indexByAngle);
                if (carBitmapDescriptor != null) {
                    setIcon(this.f30834b, carBitmapDescriptor);
                } else {
                    DLog.m10773d(f30833a, "setRotation bitmapDescriptor = null", new Object[0]);
                }
            }
        } else {
            Marker marker = this.f30835c;
            if (marker != null) {
                marker.setRotation(f2);
            }
        }
    }

    public float getRotation() {
        if (this.f30836d) {
            return this.f30838f;
        }
        Marker marker = this.f30835c;
        if (marker != null) {
            return marker.getRotation();
        }
        return 0.0f;
    }

    public void setFlat(boolean z) {
        Marker marker = this.f30835c;
        if (marker != null) {
            marker.setFlat(z);
        }
    }

    public boolean isFlat() {
        Marker marker = this.f30835c;
        if (marker != null) {
            return marker.isFlat();
        }
        return false;
    }

    public InfoWindow buildInfoWindow(Map map, Context context) {
        Marker marker = this.f30835c;
        if (marker != null) {
            return marker.buildInfoWindow(map, context);
        }
        return null;
    }

    public InfoWindow buildInfoWindow(Map map, Context context, InfoWindow.Position position) {
        Marker marker = this.f30835c;
        if (marker != null) {
            return marker.buildInfoWindow(map, context, position);
        }
        return null;
    }

    public InfoWindow getInfoWindow() {
        Marker marker = this.f30835c;
        if (marker != null) {
            return marker.getInfoWindow();
        }
        return null;
    }

    public void destroy() {
        this.f30835c = null;
        this.f30839g = null;
        this.f30840h = null;
    }

    public void updateOriginIcon(BitmapDescriptor bitmapDescriptor) {
        if (DriverCarNewAnimApollo.getInstance().enable() && bitmapDescriptor != null && bitmapDescriptor.getBitmap() != null) {
            this.f30839g = bitmapDescriptor;
            this.f30840h = m23718a(bitmapDescriptor.getBitmap(), DriverCarNewAnimApollo.getInstance().getCarZoomRatio());
        }
    }

    /* renamed from: a */
    private BitmapDescriptor m23718a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        if (f == 1.0f) {
            try {
                return BitmapDescriptorFactory.fromBitmap(bitmap);
            } catch (Exception e) {
                DLog.m10773d(f30833a, "DriverCarAnim except: " + e.getMessage(), new Object[0]);
            }
        } else {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.preScale(f, f);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
            if (createBitmap != null) {
                return BitmapDescriptorFactory.fromBitmap(createBitmap);
            }
            return null;
        }
    }

    public void enlargeMarkerIcon() {
        Marker marker;
        BitmapDescriptor bitmapDescriptor;
        if (DriverCarNewAnimApollo.getInstance().enable() && (marker = this.f30835c) != null && marker.getIcon() != null && this.f30840h != null && this.f30835c.getIcon() != (bitmapDescriptor = this.f30840h)) {
            this.f30835c.setIcon(this.f30834b, bitmapDescriptor);
        }
    }

    public void restoreMarkerIcon() {
        Marker marker;
        BitmapDescriptor bitmapDescriptor;
        if (DriverCarNewAnimApollo.getInstance().enable() && (marker = this.f30835c) != null && marker.getIcon() != null && this.f30839g != null && this.f30835c.getIcon() != (bitmapDescriptor = this.f30839g)) {
            this.f30835c.setIcon(this.f30834b, bitmapDescriptor);
        }
    }
}
