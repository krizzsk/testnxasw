package com.didi.map.global.flow.scene.order.waiting.temp;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.didi.common.map.MapView;
import com.didi.common.map.Projection;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.listener.OnMarkerClickListener;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.DisplayUtils;
import com.didi.common.map.util.MapUtils;
import com.didi.map.global.flow.model.StartEndMarkerModel;
import com.didi.map.global.flow.widget.AddressNameMarkerWrapper;
import com.didichuxing.omega.sdk.Omega;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class StartEndMarker {

    /* renamed from: a */
    private MapView f29487a;

    /* renamed from: b */
    private Marker f29488b;

    /* renamed from: c */
    private Marker f29489c;

    /* renamed from: d */
    private boolean f29490d = false;

    /* renamed from: e */
    private AddressNameMarkerWrapper f29491e;

    /* renamed from: f */
    private AddressNameMarkerWrapper f29492f;

    /* renamed from: g */
    private StartEndMarkerModel f29493g = new StartEndMarkerModel();

    public StartEndMarker(MapView mapView) {
        this.f29487a = mapView;
    }

    public List<IMapElement> getStartMapElements() {
        ArrayList arrayList = new ArrayList();
        Marker marker = this.f29488b;
        if (marker != null) {
            arrayList.add(marker);
        }
        AddressNameMarkerWrapper addressNameMarkerWrapper = this.f29491e;
        if (addressNameMarkerWrapper != null) {
            arrayList.addAll(addressNameMarkerWrapper.getMapElements());
        }
        return arrayList;
    }

    public List<IMapElement> getEndMapElements() {
        ArrayList arrayList = new ArrayList();
        Marker marker = this.f29489c;
        if (marker != null) {
            arrayList.add(marker);
        }
        AddressNameMarkerWrapper addressNameMarkerWrapper = this.f29492f;
        if (addressNameMarkerWrapper != null) {
            arrayList.addAll(addressNameMarkerWrapper.getMapElements());
        }
        return arrayList;
    }

    public void update(StartEndMarkerModel startEndMarkerModel) {
        if (this.f29487a != null && startEndMarkerModel != null) {
            m22847a();
            updateStartMarker(startEndMarkerModel.start, startEndMarkerModel.startAddressName, startEndMarkerModel.startIcon, startEndMarkerModel.sAnchorU, startEndMarkerModel.sAnchorV);
            updateEndMarker(startEndMarkerModel.end, startEndMarkerModel.endAddressName, startEndMarkerModel.endIcon, startEndMarkerModel.eAnchorU, startEndMarkerModel.eAnchorV);
            this.f29493g = startEndMarkerModel;
            this.f29490d = false;
        }
    }

    public void destroy() {
        m22847a();
    }

    public void updateStartMarker(LatLng latLng, String str, Bitmap bitmap, float f, float f2) {
        StartEndMarkerModel startEndMarkerModel;
        StartEndMarkerModel startEndMarkerModel2;
        if (latLng != null && bitmap != null) {
            if (this.f29488b == null || (startEndMarkerModel2 = this.f29493g) == null) {
                if (this.f29488b != null) {
                    this.f29487a.getMap().remove(this.f29488b);
                }
                this.f29488b = this.f29487a.getMap().addMarker(m22846a(latLng, bitmap, 102, f, f2));
            } else if (startEndMarkerModel2.startIcon != bitmap || !latLng.equals(this.f29493g.start)) {
                this.f29488b.setPosition(latLng);
                this.f29488b.setIcon(this.f29487a.getContext(), BitmapDescriptorFactory.fromBitmap(bitmap));
            }
            if (this.f29491e == null || (startEndMarkerModel = this.f29493g) == null) {
                AddressNameMarkerWrapper addressNameMarkerWrapper = this.f29491e;
                if (addressNameMarkerWrapper != null) {
                    addressNameMarkerWrapper.removeFromMap(this.f29487a.getMap());
                }
                if (!TextUtils.isEmpty(str)) {
                    AddressNameMarkerWrapper addressNameMarkerWrapper2 = new AddressNameMarkerWrapper(this.f29487a.getContext(), latLng, str);
                    this.f29491e = addressNameMarkerWrapper2;
                    addressNameMarkerWrapper2.addToMap(this.f29487a.getMap());
                }
            } else if (!TextUtils.equals(str, startEndMarkerModel.startAddressName) || !latLng.equals(this.f29493g.start)) {
                this.f29491e.removeFromMap(this.f29487a.getMap());
                if (!TextUtils.isEmpty(str)) {
                    AddressNameMarkerWrapper addressNameMarkerWrapper3 = new AddressNameMarkerWrapper(this.f29487a.getContext(), latLng, str);
                    this.f29491e = addressNameMarkerWrapper3;
                    addressNameMarkerWrapper3.addToMap(this.f29487a.getMap());
                }
            }
            this.f29493g.start = latLng;
            this.f29493g.startAddressName = str;
            this.f29493g.startIcon = bitmap;
        }
    }

    public boolean updateEndMarker(LatLng latLng, String str, Bitmap bitmap, float f, float f2) {
        StartEndMarkerModel startEndMarkerModel;
        StartEndMarkerModel startEndMarkerModel2;
        if (latLng == null || bitmap == null) {
            return false;
        }
        if (this.f29489c == null || (startEndMarkerModel2 = this.f29493g) == null) {
            if (this.f29489c != null) {
                this.f29487a.getMap().remove(this.f29489c);
            }
            this.f29489c = this.f29487a.getMap().addMarker(m22846a(latLng, bitmap, 100, f, f2));
        } else if (startEndMarkerModel2.endIcon != bitmap || !latLng.equals(this.f29493g.end)) {
            this.f29489c.setPosition(latLng);
            this.f29489c.setIcon(this.f29487a.getContext(), BitmapDescriptorFactory.fromBitmap(bitmap));
        }
        if (this.f29492f == null || (startEndMarkerModel = this.f29493g) == null) {
            AddressNameMarkerWrapper addressNameMarkerWrapper = this.f29492f;
            if (addressNameMarkerWrapper != null) {
                addressNameMarkerWrapper.removeFromMap(this.f29487a.getMap());
            }
            if (!TextUtils.isEmpty(str)) {
                AddressNameMarkerWrapper addressNameMarkerWrapper2 = new AddressNameMarkerWrapper(this.f29487a.getContext(), latLng, str);
                this.f29492f = addressNameMarkerWrapper2;
                addressNameMarkerWrapper2.addToMap(this.f29487a.getMap());
            }
        } else if (!TextUtils.equals(str, startEndMarkerModel.endAddressName) || !latLng.equals(this.f29493g.end)) {
            this.f29492f.removeFromMap(this.f29487a.getMap());
            if (!TextUtils.isEmpty(str)) {
                AddressNameMarkerWrapper addressNameMarkerWrapper3 = new AddressNameMarkerWrapper(this.f29487a.getContext(), latLng, str);
                this.f29492f = addressNameMarkerWrapper3;
                addressNameMarkerWrapper3.addToMap(this.f29487a.getMap());
            }
        }
        this.f29493g.end = latLng;
        this.f29493g.endAddressName = str;
        this.f29493g.endIcon = bitmap;
        return true;
    }

    public boolean showStartMarkerInfoWindow(View view, InfoWindow.Position position) {
        MapView mapView;
        if (this.f29488b == null || view == null || (mapView = this.f29487a) == null || mapView.getMap() == null) {
            return false;
        }
        if (this.f29488b.getId() == null) {
            return true;
        }
        InfoWindow buildInfoWindow = this.f29488b.buildInfoWindow(this.f29487a.getMap(), this.f29487a.getContext().getApplicationContext());
        if (position != null) {
            buildInfoWindow.setPosition(position);
        }
        buildInfoWindow.showInfoWindow(view);
        if (buildInfoWindow.getInfoWindowMarker() == null || TextUtils.isEmpty(buildInfoWindow.getInfoWindowMarker().getId())) {
            return true;
        }
        buildInfoWindow.getInfoWindowMarker().setZIndex(106);
        return true;
    }

    public void setOnStartMarkerClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        Marker marker;
        if (onInfoWindowClickListener != null && (marker = this.f29488b) != null && marker.getInfoWindow() != null) {
            this.f29488b.getInfoWindow().addOnInfoWindowClickListener(onInfoWindowClickListener);
        }
    }

    public void hideStartMarkerInfoWindow() {
        Marker marker = this.f29488b;
        if (marker != null && marker.getInfoWindow() != null) {
            this.f29488b.getInfoWindow().removeOnInfoWindowClickListener();
            this.f29488b.hideInfoWindow();
        }
    }

    public boolean showEndMarkerInfoWindow(View view, InfoWindow.Position position) {
        Marker marker;
        if (this.f29487a == null || (marker = this.f29489c) == null || view == null) {
            return false;
        }
        if (marker.getId() != null) {
            InfoWindow buildInfoWindow = this.f29489c.buildInfoWindow(this.f29487a.getMap(), this.f29487a.getContext().getApplicationContext());
            if (position != null) {
                buildInfoWindow.setPosition(position);
            }
            buildInfoWindow.showInfoWindow(view);
            if (buildInfoWindow.getInfoWindowMarker() == null || TextUtils.isEmpty(buildInfoWindow.getInfoWindowMarker().getId())) {
                Omega.trackError("nullWorn", "403", "end infoWindow is null");
            } else {
                buildInfoWindow.getInfoWindowMarker().setZIndex(104);
            }
        }
        this.f29490d = true;
        return true;
    }

    public void setOnEndMarkerClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        Marker marker;
        if (onInfoWindowClickListener != null && (marker = this.f29489c) != null && marker.getInfoWindow() != null) {
            this.f29489c.getInfoWindow().addOnInfoWindowClickListener(onInfoWindowClickListener);
        }
    }

    public void hideEndMarkerInfoWindow() {
        Marker marker;
        if (this.f29487a != null && (marker = this.f29489c) != null && this.f29490d) {
            if (!(marker == null || marker.getInfoWindow() == null)) {
                this.f29489c.getInfoWindow().removeOnInfoWindowClickListener();
                this.f29489c.hideInfoWindow();
            }
            this.f29490d = false;
        }
    }

    /* renamed from: a */
    private void m22847a() {
        MapView mapView = this.f29487a;
        if (mapView != null) {
            if (this.f29488b != null) {
                mapView.getMap().remove(this.f29488b);
                this.f29488b = null;
            }
            if (this.f29489c != null) {
                this.f29487a.getMap().remove(this.f29489c);
                this.f29489c = null;
            }
            AddressNameMarkerWrapper addressNameMarkerWrapper = this.f29491e;
            if (addressNameMarkerWrapper != null) {
                addressNameMarkerWrapper.removeFromMap(this.f29487a.getMap());
                this.f29491e = null;
            }
            AddressNameMarkerWrapper addressNameMarkerWrapper2 = this.f29492f;
            if (addressNameMarkerWrapper2 != null) {
                addressNameMarkerWrapper2.removeFromMap(this.f29487a.getMap());
                this.f29492f = null;
            }
        }
    }

    /* renamed from: a */
    private MarkerOptions m22846a(LatLng latLng, Bitmap bitmap, int i, float f, float f2) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng).anchor(f, f2).icon(BitmapDescriptorFactory.fromBitmap(bitmap)).draggable(false).zIndex(i);
        return markerOptions;
    }

    /* renamed from: a */
    private static Bitmap m22845a(Context context, View view, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.mfv_marker_info_window, (ViewGroup) null);
        ((ImageView) inflate.findViewById(R.id.mfv_info_window)).setImageBitmap(MapUtils.getViewBitmap(view));
        ((ImageView) inflate.findViewById(R.id.mfv_marker)).setImageBitmap(BitmapDescriptorFactory.fromResource(context, i).getBitmap());
        return MapUtils.getViewBitmap(inflate);
    }

    public void setMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        MapView mapView = this.f29487a;
        if (mapView != null) {
            mapView.getMap().addOnMarkerClickListener(onMarkerClickListener);
        }
    }

    /* renamed from: b */
    private boolean m22849b() {
        if (this.f29488b == null || this.f29489c == null) {
            return false;
        }
        Projection projection = this.f29487a.getMap().getProjection();
        if (projection.toScreenLocation(this.f29488b.getPosition()).x < projection.toScreenLocation(this.f29489c.getPosition()).x) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    private boolean m22850c() {
        if (this.f29488b == null || this.f29489c == null) {
            return false;
        }
        Projection projection = this.f29487a.getMap().getProjection();
        if (projection.toScreenLocation(this.f29488b.getPosition()).y < projection.toScreenLocation(this.f29489c.getPosition()).y) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private int m22843a(Marker marker) {
        int i = marker.getMarkerSize().height + 0;
        InfoWindow infoWindow = marker.getInfoWindow();
        return infoWindow != null ? i + infoWindow.getInfoWindowMarker().getMarkerSize().height : i;
    }

    /* renamed from: b */
    private int m22848b(Marker marker) {
        int i = marker.getMarkerSize().width;
        InfoWindow infoWindow = marker.getInfoWindow();
        if (infoWindow != null) {
            i = infoWindow.getInfoWindowMarker().getMarkerSize().width;
        }
        return i / 2;
    }

    /* renamed from: a */
    private int m22844a(Marker marker, AddressNameMarkerWrapper addressNameMarkerWrapper) {
        int i = marker.getMarkerSize().width / 2;
        InfoWindow infoWindow = marker.getInfoWindow();
        if (infoWindow == null) {
            return addressNameMarkerWrapper != null ? Math.max(i, addressNameMarkerWrapper.getTextWidth()) : i;
        }
        int i2 = infoWindow.getInfoWindowMarker().getMarkerSize().width / 2;
        if (addressNameMarkerWrapper != null) {
            i2 = Math.max(i2, addressNameMarkerWrapper.getTextWidth());
        }
        return i2;
    }

    public Bounds getStartEndMarkerBounds() {
        Bounds bounds = new Bounds();
        bounds.left = DisplayUtils.dp2px(this.f29487a.getContext(), 10.0f);
        bounds.right = bounds.left;
        bounds.top = bounds.left;
        bounds.bottom = bounds.left;
        if (m22849b()) {
            bounds.left += m22848b(this.f29488b);
            bounds.right += m22844a(this.f29489c, this.f29492f);
        } else {
            bounds.left += m22848b(this.f29489c);
            bounds.right += m22844a(this.f29488b, this.f29491e);
        }
        if (m22850c()) {
            bounds.top = m22843a(this.f29488b);
        } else {
            bounds.top = m22843a(this.f29489c);
        }
        return bounds;
    }

    public List<Marker> getMarkers() {
        ArrayList arrayList = new ArrayList();
        Marker marker = this.f29488b;
        if (marker != null) {
            arrayList.add(marker);
            if (this.f29488b.getInfoWindow() != null) {
                arrayList.add(this.f29488b.getInfoWindow().getInfoWindowMarker());
            }
        }
        AddressNameMarkerWrapper addressNameMarkerWrapper = this.f29491e;
        if (addressNameMarkerWrapper != null) {
            arrayList.add(addressNameMarkerWrapper.getMarker());
        }
        Marker marker2 = this.f29489c;
        if (marker2 != null) {
            arrayList.add(marker2);
            if (this.f29489c.getInfoWindow() != null) {
                arrayList.add(this.f29489c.getInfoWindow().getInfoWindowMarker());
            }
        }
        AddressNameMarkerWrapper addressNameMarkerWrapper2 = this.f29492f;
        if (addressNameMarkerWrapper2 != null) {
            arrayList.add(addressNameMarkerWrapper2.getMarker());
        }
        return arrayList;
    }

    public LatLng getStartMarkerPosition() {
        Marker marker = this.f29488b;
        if (marker != null) {
            return marker.getPosition();
        }
        return new LatLng(0.0d, 0.0d);
    }

    public void hideEndMarker() {
        Marker marker = this.f29489c;
        if (marker != null) {
            marker.setVisible(false);
        }
    }

    public void showEndMarker() {
        Marker marker = this.f29489c;
        if (marker != null) {
            marker.setVisible(true);
        }
    }

    public class Bounds {
        public int bottom;
        public int left;
        public int right;
        public int top;

        public Bounds() {
        }
    }

    public Marker getStartIconMarker() {
        return this.f29488b;
    }
}
