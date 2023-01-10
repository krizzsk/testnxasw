package com.didi.map.global.component.departure.fence;

import android.util.SparseIntArray;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.internal.IMapElementOptions;
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

public class Fence implements IFence {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Map f27391a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public FenceOptions f27392b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public double f27393c = 0.0d;

    /* renamed from: d */
    private boolean f27394d = true;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f27395e = true;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SparseIntArray f27396f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SparseIntArray f27397g;

    /* renamed from: h */
    private String f27398h;

    /* renamed from: i */
    private OnCameraChangeListener f27399i = new OnCameraChangeListener() {
        public void onCameraChange(CameraPosition cameraPosition) {
            if (Fence.this.f27391a != null && Fence.this.f27392b != null && Fence.this.f27392b.getLimitZoom() >= 0.0d) {
                if (Fence.this.f27395e) {
                    if (Fence.this.f27393c >= Fence.this.f27392b.getLimitZoom() && Fence.this.f27391a.getCameraPosition().zoom < Fence.this.f27392b.getLimitZoom()) {
                        Fence.this.setVisible(false);
                    } else if (Fence.this.f27393c < Fence.this.f27392b.getLimitZoom() && Fence.this.f27391a.getCameraPosition().zoom >= Fence.this.f27392b.getLimitZoom()) {
                        Fence.this.setVisible(true);
                    }
                }
                Fence fence = Fence.this;
                double unused = fence.f27393c = fence.f27391a.getCameraPosition().zoom;
            }
        }
    };

    /* renamed from: j */
    private OnMarkerClickListener f27400j = new OnMarkerClickListener() {
        public boolean onMarkerClick(Marker marker) {
            if (!(Fence.this.f27392b == null || Fence.this.f27392b.getFenceListener() == null || marker == null)) {
                Fence.this.f27392b.getFenceListener().onClickFenceMarker(Fence.this.f27397g != null ? Fence.this.f27397g.get(marker.hashCode()) : 0);
            }
            return false;
        }
    };

    /* renamed from: k */
    private OnPolygonClickListener f27401k = new OnPolygonClickListener() {
        public void onPolygonClick(Polygon polygon) {
            if (Fence.this.f27392b != null && Fence.this.f27392b.getFenceListener() != null && polygon != null) {
                Fence.this.f27392b.getFenceListener().onClickFencePolygon(Fence.this.f27396f != null ? Fence.this.f27396f.get(polygon.hashCode()) : 0);
            }
        }
    };

    public Fence(FenceOptions fenceOptions, String str) {
        this.f27392b = fenceOptions;
        this.f27398h = str;
    }

    public void addToMap(Map map) {
        if (map != null && this.f27392b != null && this.f27391a == null) {
            this.f27391a = map;
            m21736a();
            m21739b();
        }
    }

    /* renamed from: a */
    private void m21736a() {
        this.f27396f = new SparseIntArray();
        this.f27397g = new SparseIntArray();
    }

    public void updateFences(List<FencePolygon> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            FenceOptions fenceOptions = this.f27392b;
            if (fenceOptions != null) {
                fenceOptions.setFences(list);
            }
            if (this.f27391a != null) {
                m21739b();
            }
        }
    }

    /* renamed from: b */
    private void m21739b() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f27392b.getFences())) {
            m21737a(this.f27392b.getFences());
            m21740c();
        }
    }

    /* renamed from: c */
    private void m21740c() {
        Map map = this.f27391a;
        if (map != null) {
            this.f27393c = map.getCameraPosition().zoom;
            this.f27391a.addOnMarkerClickListener(this.f27400j);
            if (this.f27392b.getLimitZoom() > -1.0d) {
                this.f27391a.addOnCameraChangeListener(this.f27399i);
            }
            if (this.f27392b.getFenceListener() != null) {
                this.f27391a.addOnPolygonClickListener(this.f27401k);
            }
        }
    }

    /* renamed from: a */
    private void m21737a(List<FencePolygon> list) {
        if (this.f27391a != null && !CollectionUtil.isEmpty((Collection<?>) list)) {
            m21743d();
            for (FencePolygon next : list) {
                boolean z = false;
                if (!CollectionUtil.isEmpty((Collection<?>) next.polygon)) {
                    PolygonOptions polygonOptions = new PolygonOptions();
                    for (LatLng next2 : next.polygon) {
                        polygonOptions.add(new LatLng(next2.latitude, next2.longitude));
                    }
                    polygonOptions.fillColor(this.f27392b.getFillColor()).strokeColor(this.f27392b.getStrokeColor()).strokeWidth(this.f27392b.getStrokeWidth()).zIndex(this.f27392b.getPolygonZIndex()).visible(this.f27394d && this.f27395e).clickable(true);
                    Polygon addPolygon = this.f27391a.addPolygon(this.f27398h, polygonOptions);
                    SparseIntArray sparseIntArray = this.f27396f;
                    if (!(sparseIntArray == null || addPolygon == null)) {
                        sparseIntArray.put(addPolygon.hashCode(), next.f27421id);
                    }
                }
                if (!(next.marker == null || next.icon == null)) {
                    MarkerOptions markerOptions = new MarkerOptions();
                    IMapElementOptions zIndex = markerOptions.position(next.marker).icon(next.icon).zIndex(this.f27392b.getMarkerZIndex());
                    if (this.f27394d && this.f27395e) {
                        z = true;
                    }
                    zIndex.visible(z);
                    Marker addMarker = this.f27391a.addMarker(this.f27398h, markerOptions);
                    SparseIntArray sparseIntArray2 = this.f27397g;
                    if (!(sparseIntArray2 == null || addMarker == null)) {
                        sparseIntArray2.put(addMarker.hashCode(), next.f27421id);
                    }
                }
            }
        }
    }

    public void setFenceVisible(boolean z) {
        this.f27395e = z;
        if (!z) {
            setVisible(false);
        } else if (this.f27392b.getLimitZoom() < 0.0d) {
            setVisible(false);
        } else if (this.f27393c < this.f27392b.getLimitZoom()) {
            setVisible(false);
        } else if (this.f27393c >= this.f27392b.getLimitZoom()) {
            setVisible(true);
        }
    }

    public void setVisible(boolean z) {
        Map map;
        if (this.f27394d != z && (map = this.f27391a) != null) {
            this.f27394d = z;
            ArrayList<IMapElement> elementGroup = map.getElementGroup(this.f27398h);
            if (!CollectionUtil.isEmpty((Collection<?>) elementGroup)) {
                Iterator<IMapElement> it = elementGroup.iterator();
                while (it.hasNext()) {
                    it.next().setVisible(this.f27394d);
                }
            }
        }
    }

    /* renamed from: d */
    private void m21743d() {
        Map map = this.f27391a;
        if (map != null) {
            map.removeOnCameraChangeListener(this.f27399i);
            this.f27391a.removeOnPolygonClickListener(this.f27401k);
            this.f27391a.removeOnMarkerClickListener(this.f27400j);
            this.f27391a.removeElementGroupByTag(this.f27398h);
        }
        SparseIntArray sparseIntArray = this.f27396f;
        if (sparseIntArray != null) {
            sparseIntArray.clear();
        }
        SparseIntArray sparseIntArray2 = this.f27397g;
        if (sparseIntArray2 != null) {
            sparseIntArray2.clear();
        }
    }

    public void remove() {
        m21743d();
        this.f27392b = null;
        this.f27391a = null;
    }
}
