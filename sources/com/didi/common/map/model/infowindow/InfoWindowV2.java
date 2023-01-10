package com.didi.common.map.model.infowindow;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.didi.common.map.Map;
import com.didi.common.map.listener.OnInfoWindowClickListener;
import com.didi.common.map.listener.OnMarkerClickListener;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.common.map.util.MapUtils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;

public final class InfoWindowV2 implements InfoWindow {
    public static final String MARKER_INFOWINDOW_TAG = "infoWindow_tag";

    /* renamed from: a */
    private InfoWindow.Position f12768a;

    /* renamed from: b */
    private Context f12769b;

    /* renamed from: c */
    private Map f12770c;

    /* renamed from: d */
    private Marker f12771d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Marker f12772e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public OnInfoWindowClickListener f12773f;

    /* renamed from: g */
    private OnMarkerClickListener f12774g = new OnMarkerClickListener() {
        public boolean onMarkerClick(Marker marker) {
            if (marker == null || !marker.equals(InfoWindowV2.this.f12772e) || InfoWindowV2.this.f12773f == null) {
                return false;
            }
            InfoWindowV2.this.f12773f.onInfoWindowClick(marker);
            return false;
        }
    };

    public InfoWindowV2(Map map, Context context, Marker marker) {
        this.f12770c = map;
        this.f12769b = context.getApplicationContext();
        this.f12771d = marker;
        m10767e();
        this.f12768a = InfoWindow.Position.TOP;
    }

    public InfoWindowV2(Map map, Context context, InfoWindow.Position position, Marker marker) {
        this.f12770c = map;
        this.f12768a = position;
        this.f12771d = marker;
        this.f12769b = context.getApplicationContext();
        m10767e();
    }

    public void setPosition(InfoWindow.Position position) {
        this.f12768a = position;
    }

    public void showInfoWindow(View view) {
        if (view != null && this.f12771d != null) {
            if (this.f12772e == null) {
                this.f12772e = this.f12770c.addMarker(m10761a(view));
                return;
            }
            try {
                Bitmap viewBitmap = MapUtils.getViewBitmap(view);
                this.f12772e.setVisible(true);
                this.f12772e.setAnchor(m10757a(viewBitmap), m10762b(viewBitmap));
                this.f12772e.setPosition(m10759a(this.f12771d));
                this.f12772e.setIcon(this.f12769b, BitmapDescriptorFactory.fromBitmap(viewBitmap));
            } catch (Exception e) {
                HashMap hashMap = new HashMap();
                hashMap.put("status", "-1");
                hashMap.put("message", "mInfoWindowMarker" + this.f12772e + "--->errorMessage" + e.getMessage());
                OmegaSDKAdapter.trackEvent("tech_marker_set_icon_status", "-1", hashMap);
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(e.getMessage());
                DLog.m10773d("infoWindow_tag", sb.toString(), new Object[0]);
            }
        }
    }

    /* renamed from: a */
    private float m10757a(Bitmap bitmap) {
        Marker marker = this.f12771d;
        if (marker == null || bitmap == null || marker.getOptions() == null || this.f12768a == null) {
            return 0.5f;
        }
        float anchorU = this.f12771d.getOptions().getAnchorU();
        if (this.f12768a == InfoWindow.Position.TOP || this.f12768a == InfoWindow.Position.BOTTOM) {
            return anchorU;
        }
        if (this.f12768a == InfoWindow.Position.LEFT || this.f12768a == InfoWindow.Position.LEFT_TOP || this.f12768a == InfoWindow.Position.LEFT_BOTTOM) {
            return ((m10765c() * anchorU) / ((float) bitmap.getWidth())) + 1.0f;
        } else if (this.f12768a != InfoWindow.Position.RIGHT && this.f12768a != InfoWindow.Position.RIGHT_TOP && this.f12768a != InfoWindow.Position.RIGHT_BOTTOM) {
            return 0.5f;
        } else {
            float c = m10765c();
            return -((c - (anchorU * c)) / ((float) bitmap.getWidth()));
        }
    }

    /* renamed from: b */
    private float m10762b(Bitmap bitmap) {
        Marker marker = this.f12771d;
        if (marker == null || bitmap == null || marker.getOptions() == null || this.f12768a == null) {
            return 1.0f;
        }
        float anchorV = this.f12771d.getOptions().getAnchorV();
        if (this.f12768a == InfoWindow.Position.LEFT || this.f12768a == InfoWindow.Position.RIGHT) {
            return anchorV;
        }
        if (this.f12768a == InfoWindow.Position.TOP || this.f12768a == InfoWindow.Position.LEFT_TOP || this.f12768a == InfoWindow.Position.RIGHT_TOP) {
            return ((m10766d() * anchorV) / ((float) bitmap.getHeight())) + 1.0f;
        } else if (this.f12768a != InfoWindow.Position.BOTTOM && this.f12768a != InfoWindow.Position.LEFT_BOTTOM && this.f12768a != InfoWindow.Position.RIGHT_BOTTOM) {
            return 1.0f;
        } else {
            float d = m10766d();
            return (-(d - (anchorV * d))) / ((float) bitmap.getHeight());
        }
    }

    /* renamed from: a */
    private MarkerOptions m10761a(View view) {
        if (this.f12771d == null) {
            return null;
        }
        Bitmap viewBitmap = MapUtils.getViewBitmap(view);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(this.f12771d.getPosition());
        markerOptions.anchor(m10757a(viewBitmap), m10762b(viewBitmap));
        markerOptions.flat(this.f12771d.isFlat());
        markerOptions.zIndex(this.f12771d.getZIndex());
        markerOptions.clickable(true);
        markerOptions.visible(true);
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(viewBitmap));
        return markerOptions;
    }

    /* renamed from: a */
    private LatLng m10759a(Marker marker) {
        if (marker == null) {
            return null;
        }
        return marker.getPosition();
    }

    /* renamed from: a */
    private int m10758a() {
        Marker marker = this.f12771d;
        if (marker == null || marker.getIcon() == null || this.f12771d.getIcon().getBitmap() == null || this.f12771d.getOptions() == null) {
            return 0;
        }
        return this.f12771d.getIcon().getBitmap().getWidth();
    }

    /* renamed from: b */
    private int m10763b() {
        Marker marker = this.f12771d;
        if (marker == null || marker.getIcon() == null || this.f12771d.getIcon().getBitmap() == null || this.f12771d.getOptions() == null) {
            return 0;
        }
        return this.f12771d.getIcon().getBitmap().getHeight();
    }

    /* renamed from: c */
    private float m10765c() {
        return (float) m10758a();
    }

    /* renamed from: d */
    private float m10766d() {
        Marker marker = this.f12771d;
        if (marker == null || !marker.getEnableTopHeightInterval()) {
            return (float) m10763b();
        }
        return this.f12771d.getTopHeightInterval();
    }

    public void setPosition(LatLng latLng) {
        if (this.f12772e != null && LatLngUtils.locateCorrect(latLng)) {
            this.f12772e.setPosition(latLng);
        }
    }

    public void hideInfoWindow() {
        Marker marker = this.f12772e;
        if (marker != null) {
            marker.setVisible(false);
        }
    }

    public Marker getInfoWindowMarker() {
        return this.f12772e;
    }

    public boolean isInfoWindowShown() {
        Marker marker = this.f12772e;
        return marker != null && marker.isVisible();
    }

    public void updateAnchor() {
        Marker marker = this.f12772e;
        if (marker != null && marker.getIcon() != null) {
            this.f12772e.setAnchor(m10757a(this.f12772e.getIcon().getBitmap()), m10762b(this.f12772e.getIcon().getBitmap()));
        }
    }

    /* renamed from: e */
    private void m10767e() {
        Map map = this.f12770c;
        if (map != null) {
            map.addOnMarkerClickListener(this.f12774g);
        }
    }

    /* renamed from: f */
    private void m10768f() {
        Map map = this.f12770c;
        if (map != null) {
            map.removeOnMarkerClickListener(this.f12774g);
        }
    }

    public void addOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        if (this.f12770c != null && onInfoWindowClickListener != null) {
            this.f12773f = onInfoWindowClickListener;
        }
    }

    public void removeOnInfoWindowClickListener() {
        this.f12773f = null;
    }

    public void destroy() {
        Marker marker;
        Map map = this.f12770c;
        if (!(map == null || (marker = this.f12772e) == null)) {
            map.remove(marker);
            this.f12772e = null;
        }
        removeOnInfoWindowClickListener();
        this.f12774g = null;
        m10768f();
        this.f12770c = null;
        this.f12769b = null;
    }
}
