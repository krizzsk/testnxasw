package com.didi.map.sdk.departure.internal.rec;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.didi.common.map.Map;
import com.didi.common.map.listener.OnMarkerClickListener;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.map.sdk.departure.internal.sensing.SensingCircles;
import com.didi.map.sdk.departure.internal.util.LatLngUtil;
import com.didi.map.sdk.departure.internal.util.OmegaUtil;
import com.didi.map.sdk.departure.internal.util.ZIndexUtil;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class RecMarkerImpl implements IRecMarker {

    /* renamed from: a */
    private static final String f30662a = "RecMarkerImpl";

    /* renamed from: b */
    private Context f30663b;

    /* renamed from: c */
    private Map f30664c;

    /* renamed from: d */
    private float f30665d = 0.0f;

    /* renamed from: e */
    private float f30666e = 0.0f;

    /* renamed from: f */
    private int f30667f = 1;

    /* renamed from: g */
    private int f30668g = 1;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public RecMarkerParam f30669h;

    /* renamed from: i */
    private SensingCircles f30670i;

    /* renamed from: j */
    private boolean f30671j = false;

    /* renamed from: k */
    private boolean f30672k = false;

    /* renamed from: l */
    private boolean f30673l = false;

    /* renamed from: m */
    private OnMarkerClickListener f30674m = new OnMarkerClickListener() {
        public boolean onMarkerClick(Marker marker) {
            if (RecMarkerImpl.this.f30669h == null || marker != RecMarkerImpl.this.mMarker) {
                return false;
            }
            OmegaUtil.trackRecMarkerClick(RecMarkerImpl.this.f30669h.point);
            if (RecMarkerImpl.this.f30669h.listener == null) {
                return true;
            }
            RecMarkerImpl.this.f30669h.listener.onClick(RecMarkerImpl.this);
            return true;
        }
    };
    protected Marker mMarker;

    public void onMapVisible(boolean z) {
    }

    public void create(Context context, Map map) {
        this.f30663b = context.getApplicationContext();
        this.f30664c = map;
        map.addOnMarkerClickListener(this.f30674m);
    }

    public void destroy() {
        remove();
        this.f30664c = null;
        this.f30663b = null;
    }

    public void setConfigParam(RecMarkerParam recMarkerParam) {
        this.f30669h = recMarkerParam;
    }

    public void add() {
        RecMarkerParam recMarkerParam;
        Map map = this.f30664c;
        if (map != null && map.getProjection() != null && (recMarkerParam = this.f30669h) != null && recMarkerParam.point != null && this.f30669h.point.location != null) {
            Marker marker = this.mMarker;
            if (marker == null) {
                m23643a();
            } else {
                marker.setPosition(this.f30669h.point.location);
            }
        }
    }

    public void remove() {
        if (this.mMarker != null) {
            hideCircles();
            Map map = this.f30664c;
            if (map != null) {
                map.remove(this.mMarker);
            }
            this.mMarker = null;
        }
    }

    public void visible(boolean z) {
        Marker marker = this.mMarker;
        if (marker != null && marker.isVisible() != z) {
            this.mMarker.setVisible(z);
        }
    }

    public boolean isVisible() {
        Marker marker = this.mMarker;
        if (marker != null) {
            return marker.isVisible();
        }
        return false;
    }

    /* renamed from: a */
    private void m23643a() {
        RecMarkerParam recMarkerParam;
        if (this.f30664c != null && (recMarkerParam = this.f30669h) != null && recMarkerParam.icon != null && this.f30669h.selectedIcon != null && this.f30669h.point != null && this.f30669h.point.location != null) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.zIndex(ZIndexUtil.getZIndex(6));
            markerOptions.position(this.f30669h.point.location);
            Bitmap bitmap = this.f30669h.icon;
            this.f30665d = (float) bitmap.getWidth();
            this.f30666e = (float) bitmap.getHeight();
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(bitmap));
            markerOptions.anchor(0.5f, 0.5f);
            markerOptions.clickable(this.f30669h.isClickEnable);
            markerOptions.visible(true);
            this.f30668g = this.f30667f;
            Marker addMarker = this.f30664c.addMarker(markerOptions);
            this.mMarker = addMarker;
            if (addMarker != null) {
                m23645b();
            }
        }
    }

    /* renamed from: a */
    private static Bitmap m23641a(View view) {
        if (view == null) {
            return null;
        }
        view.setDrawingCacheEnabled(true);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getResources().getDisplayMetrics().widthPixels / 2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(view.getResources().getDisplayMetrics().heightPixels / 2, Integer.MIN_VALUE));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    public double getX() {
        Map map = this.f30664c;
        if (map == null || map.getProjection() == null || this.mMarker == null) {
            return 0.0d;
        }
        return (double) (this.f30664c.getProjection().toScreenLocation(this.mMarker.getPosition()).x - (this.mMarker.getOptions().getAnchorU() * this.f30665d));
    }

    public double getY() {
        Map map = this.f30664c;
        if (map == null || map.getProjection() == null || this.mMarker == null) {
            return 0.0d;
        }
        return (double) (this.f30664c.getProjection().toScreenLocation(this.mMarker.getPosition()).y - (this.mMarker.getOptions().getAnchorV() * this.f30666e));
    }

    public float getWidth() {
        return this.f30665d;
    }

    public float getHeight() {
        return this.f30666e;
    }

    public void handler(int i) {
        this.f30667f = i;
    }

    public void apply() {
        if (this.f30668g != this.f30667f) {
            remove();
            add();
        }
    }

    public int getDirection() {
        return this.f30667f;
    }

    public void setDirection(int i) {
        if (this.f30667f != i) {
            this.f30667f = i;
            remove();
            add();
        }
    }

    public int compareTo(Square square) {
        if (this == square || !(square instanceof RecMarkerImpl)) {
            return 0;
        }
        return getX() > square.getX() ? 1 : -1;
    }

    public void showCircles() {
        Context context;
        hideCircles();
        Map map = this.f30664c;
        if (map != null && (context = this.f30663b) != null && this.mMarker != null) {
            SensingCircles sensingCircles = new SensingCircles(context, map);
            this.f30670i = sensingCircles;
            sensingCircles.show(this.mMarker.getPosition());
        }
    }

    public void hideCircles() {
        SensingCircles sensingCircles = this.f30670i;
        if (sensingCircles != null && sensingCircles.isShow()) {
            this.f30670i.hide();
        }
        this.f30670i = null;
    }

    public void showTransientCircles() {
        Marker marker;
        if (this.f30664c != null && this.f30663b != null && (marker = this.mMarker) != null && marker.getPosition() != null) {
            this.mMarker.setVisible(true);
            new SensingCircles(this.f30663b, this.f30664c, (int) R.color.mappoiselect_departure_sensing_circle, SensingCircles.TIME_TRANSIEN_PERIOD, 48.0f).showTransientCircles(this.mMarker.getPosition());
        }
    }

    public LatLng getLocation() {
        if (this.mMarker == null) {
            return null;
        }
        RecMarkerParam recMarkerParam = this.f30669h;
        return (recMarkerParam == null || recMarkerParam.point == null) ? this.mMarker.getPosition() : this.f30669h.point.location;
    }

    public float getAlpha() {
        Marker marker = this.mMarker;
        if (marker != null) {
            return marker.getAlpha();
        }
        return 0.0f;
    }

    public void setAlpha(float f) {
        Marker marker = this.mMarker;
        if (marker != null) {
            marker.setAlpha(f);
        }
    }

    public boolean isInCenter() {
        if (this.f30664c == null || this.f30669h.point == null) {
            return false;
        }
        return LatLngUtil.isSameLatLng(this.f30664c.getCameraPosition().target, this.f30669h.point.location);
    }

    public void onMapStable() {
        m23645b();
    }

    public void setNeedShowInfoWindow(boolean z) {
        this.f30671j = z;
    }

    /* renamed from: b */
    private void m23645b() {
        boolean isInCenter = isInCenter();
        if (isInCenter && !this.f30673l) {
            this.f30673l = true;
            m23646c();
            m23644a(this.f30673l);
        } else if (!isInCenter && this.f30673l) {
            this.f30673l = false;
            m23647d();
            m23644a(this.f30673l);
        }
    }

    /* renamed from: c */
    private void m23646c() {
        if (this.mMarker != null && this.f30664c != null && this.f30663b != null && this.f30669h != null) {
            SystemUtils.log(6, "ccc", "showInfoWindowInternal , isShowInfoWindow= " + this.f30671j, (Throwable) null, "com.didi.map.sdk.departure.internal.rec.RecMarkerImpl", 339);
            if (!this.f30672k && this.f30671j) {
                this.f30672k = true;
                this.mMarker.buildInfoWindow(this.f30664c, this.f30663b, InfoWindow.Position.BOTTOM).showInfoWindow(LayoutInflater.from(this.f30663b).inflate(R.layout.layout_map_departure_recommend_departure_bubble, (ViewGroup) null));
                SystemUtils.log(6, "ccc", "showInfoWindowInternal ok", (Throwable) null, "com.didi.map.sdk.departure.internal.rec.RecMarkerImpl", 345);
            }
        }
    }

    /* renamed from: d */
    private void m23647d() {
        if (this.mMarker != null) {
            SystemUtils.log(6, "ccc", "hideInfoWindowInternal", (Throwable) null, "com.didi.map.sdk.departure.internal.rec.RecMarkerImpl", 353);
            if (this.f30672k) {
                this.f30672k = false;
                this.mMarker.hideInfoWindow();
                SystemUtils.log(6, "ccc", "hideInfoWindowInternal:ok ", (Throwable) null, "com.didi.map.sdk.departure.internal.rec.RecMarkerImpl", 357);
            }
        }
    }

    /* renamed from: a */
    private void m23644a(boolean z) {
        RecMarkerParam recMarkerParam;
        SystemUtils.log(6, "ccc", "updateIcon:" + z, (Throwable) null, "com.didi.map.sdk.departure.internal.rec.RecMarkerImpl", 362);
        if (this.mMarker != null && this.f30663b != null && (recMarkerParam = this.f30669h) != null) {
            Bitmap bitmap = z ? recMarkerParam.selectedIcon : recMarkerParam.icon;
            this.f30665d = (float) bitmap.getWidth();
            this.f30666e = (float) bitmap.getHeight();
            this.mMarker.setIcon(this.f30663b, BitmapDescriptorFactory.fromBitmap(bitmap));
            SystemUtils.log(6, "ccc", "updateIcon:ok：mWidth=" + this.f30665d + ",mHeight=" + this.f30666e, (Throwable) null, "com.didi.map.sdk.departure.internal.rec.RecMarkerImpl", 368);
        }
    }
}
