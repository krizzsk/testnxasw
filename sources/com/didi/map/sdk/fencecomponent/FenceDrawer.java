package com.didi.map.sdk.fencecomponent;

import android.content.Context;
import android.util.SparseIntArray;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnMarkerClickListener;
import com.didi.common.map.listener.OnPolygonClickListener;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.model.Polygon;
import com.didi.common.map.model.PolygonOptions;
import com.didi.common.map.util.CollectionUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class FenceDrawer implements IFenceDrawer {

    /* renamed from: a */
    private static final String f30729a = "FenceDrawer";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Map f30730b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FenceComponentParam f30731c;

    /* renamed from: d */
    private boolean f30732d = true;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public double f30733e = 0.0d;

    /* renamed from: f */
    private String f30734f = "global_fences";
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SparseIntArray f30735g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SparseIntArray f30736h;

    /* renamed from: i */
    private OnCameraChangeListener f30737i = new OnCameraChangeListener() {
        public void onCameraChange(CameraPosition cameraPosition) {
            if (FenceDrawer.this.f30730b != null && FenceDrawer.this.f30731c.limitZoom >= 0.0d) {
                if (FenceDrawer.this.f30733e >= FenceDrawer.this.f30731c.limitZoom && FenceDrawer.this.f30730b.getCameraPosition().zoom < FenceDrawer.this.f30731c.limitZoom) {
                    FenceDrawer.this.visible(false);
                } else if (FenceDrawer.this.f30733e < FenceDrawer.this.f30731c.limitZoom && FenceDrawer.this.f30730b.getCameraPosition().zoom >= FenceDrawer.this.f30731c.limitZoom) {
                    FenceDrawer.this.visible(true);
                }
                FenceDrawer fenceDrawer = FenceDrawer.this;
                double unused = fenceDrawer.f30733e = fenceDrawer.f30730b.getCameraPosition().zoom;
            }
        }
    };

    /* renamed from: j */
    private OnPolygonClickListener f30738j = new OnPolygonClickListener() {
        public void onPolygonClick(Polygon polygon) {
            if (FenceDrawer.this.f30731c != null && FenceDrawer.this.f30731c.onFenceChangeListener != null && polygon != null) {
                int i = 0;
                if (FenceDrawer.this.f30735g != null) {
                    i = FenceDrawer.this.f30735g.get(polygon.hashCode());
                }
                FenceDrawer.this.f30731c.onFenceChangeListener.onClickFencePolygon(i);
            }
        }
    };

    /* renamed from: k */
    private OnMarkerClickListener f30739k = new OnMarkerClickListener() {
        public boolean onMarkerClick(Marker marker) {
            if (!(FenceDrawer.this.f30731c == null || FenceDrawer.this.f30731c.onFenceChangeListener == null || marker == null)) {
                FenceDrawer.this.f30731c.onFenceChangeListener.onClickFenceMarker(FenceDrawer.this.f30736h != null ? FenceDrawer.this.f30736h.get(marker.hashCode()) : 0);
            }
            return false;
        }
    };

    public void onMapVisible(boolean z) {
    }

    public FenceDrawer() {
        this.f30734f += hashCode();
        this.f30735g = new SparseIntArray();
        this.f30736h = new SparseIntArray();
    }

    public void create(Context context, Map map) {
        if (map != null) {
            this.f30730b = map;
            this.f30733e = map.getCameraPosition().zoom;
            this.f30730b.addOnMarkerClickListener(this.f30739k);
            return;
        }
        throw new IllegalArgumentException("map is null");
    }

    public void destroy() {
        remove();
        Map map = this.f30730b;
        if (map != null) {
            map.removeOnMarkerClickListener(this.f30739k);
            this.f30730b = null;
        }
        this.f30731c = null;
    }

    public void setConfigParam(FenceComponentParam fenceComponentParam) {
        this.f30731c = fenceComponentParam;
    }

    public void add() {
        FenceComponentParam fenceComponentParam = this.f30731c;
        if (fenceComponentParam != null && this.f30730b != null && !CollectionUtil.isEmpty((Collection<?>) fenceComponentParam.fences)) {
            m23669a(this.f30731c.fences);
            if (this.f30731c.limitZoom > -1.0d) {
                this.f30730b.addOnCameraChangeListener(this.f30737i);
            }
            if (this.f30731c.onFenceChangeListener != null) {
                this.f30730b.addOnPolygonClickListener(this.f30738j);
            }
        }
    }

    /* renamed from: a */
    private void m23669a(List<FencePolygon> list) {
        SparseIntArray sparseIntArray;
        SparseIntArray sparseIntArray2;
        if (this.f30730b != null && !CollectionUtil.isEmpty((Collection<?>) list)) {
            remove();
            for (FencePolygon next : list) {
                if (!CollectionUtil.isEmpty((Collection<?>) next.polygon)) {
                    PolygonOptions polygonOptions = new PolygonOptions();
                    for (LatLng next2 : next.polygon) {
                        polygonOptions.add(new LatLng(next2.latitude, next2.longitude));
                    }
                    polygonOptions.fillColor(this.f30731c.fillColor).strokeColor(this.f30731c.strokeColor).strokeWidth(this.f30731c.strokeWidth).zIndex(this.f30731c.polygonZIndex).visible(this.f30732d).clickable(true);
                    Polygon addPolygon = this.f30730b.addPolygon(this.f30734f, polygonOptions);
                    if (!(addPolygon == null || (sparseIntArray2 = this.f30735g) == null)) {
                        sparseIntArray2.put(addPolygon.hashCode(), next.f30740id);
                    }
                }
                if (!(next.marker == null || next.icon == null)) {
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(next.marker).icon(next.icon).zIndex(this.f30731c.markerZIndex).visible(this.f30732d);
                    Marker addMarker = this.f30730b.addMarker(this.f30734f, markerOptions);
                    if (!(addMarker == null || (sparseIntArray = this.f30736h) == null)) {
                        sparseIntArray.put(addMarker.hashCode(), next.f30740id);
                    }
                }
            }
        }
    }

    public void remove() {
        Map map = this.f30730b;
        if (map != null) {
            map.removeElementGroupByTag(this.f30734f);
            this.f30730b.removeOnCameraChangeListener(this.f30737i);
            this.f30730b.removeOnPolygonClickListener(this.f30738j);
            this.f30730b.removeOnMarkerClickListener(this.f30739k);
            this.f30735g.clear();
            this.f30736h.clear();
        }
    }

    public void visible(boolean z) {
        Map map;
        if (this.f30732d != z && (map = this.f30730b) != null) {
            this.f30732d = z;
            ArrayList<IMapElement> elementGroup = map.getElementGroup(this.f30734f);
            if (!CollectionUtil.isEmpty((Collection<?>) elementGroup)) {
                Iterator<IMapElement> it = elementGroup.iterator();
                while (it.hasNext()) {
                    it.next().setVisible(this.f30732d);
                }
            }
        }
    }

    public boolean isVisible() {
        return this.f30732d;
    }
}
