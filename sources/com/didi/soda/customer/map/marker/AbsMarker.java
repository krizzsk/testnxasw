package com.didi.soda.customer.map.marker;

import android.content.Context;
import android.graphics.Color;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.CollectionUtil;
import com.didi.foundation.sdk.map.IMapView;
import com.didi.global.map.animation.transition.util.AngleUtil;
import com.didi.map.global.component.line.component.ArcLineComponent;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.soda.customer.component.flutterordermap.data.OrderMapUtil;
import com.didi.soda.customer.map.InfoWindowOptions;
import com.didi.soda.customer.map.MapInfoWindowManager;
import java.util.Collection;
import java.util.List;

public abstract class AbsMarker {

    /* renamed from: d */
    private static final int f43965d = 4;

    /* renamed from: e */
    private static final String f43966e = "#ADE3CC";

    /* renamed from: a */
    private Marker f43967a;

    /* renamed from: b */
    private IMapView f43968b;

    /* renamed from: c */
    private ICompLineContract f43969c;

    /* renamed from: f */
    private boolean f43970f = false;
    protected Context mContext;
    protected InfoWindow mInfoWindow;

    public void attachToMap(LatLng latLng) {
    }

    public abstract String getTag();

    public void onAdd() {
    }

    public abstract void show(LatLng latLng);

    AbsMarker(Context context, IMapView iMapView) {
        this.mContext = context;
        this.f43968b = iMapView;
    }

    public void updateMapView(IMapView iMapView) {
        if (this.f43968b == null) {
            this.f43968b = iMapView;
        }
    }

    public Marker getMarker() {
        return this.f43967a;
    }

    public void setVisible(boolean z) {
        Marker marker = this.f43967a;
        if (marker != null) {
            marker.setVisible(z);
        }
    }

    public boolean isVisible() {
        try {
            if (this.f43967a == null) {
                return false;
            }
            return this.f43967a.isVisible();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isExist() {
        return this.f43970f;
    }

    public void removeLine() {
        ICompLineContract iCompLineContract = this.f43969c;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f43969c = null;
        }
    }

    public void setLineVisible(boolean z) {
        ICompLineContract iCompLineContract = this.f43969c;
        if (iCompLineContract != null) {
            iCompLineContract.setLineVisible(z);
        }
    }

    /* access modifiers changed from: protected */
    public void draw(MarkerOptions markerOptions) {
        if (this.f43970f) {
            remove();
        }
        IMapView iMapView = this.f43968b;
        if (iMapView != null) {
            this.f43967a = iMapView.addMarker(getTag(), markerOptions);
            this.f43970f = true;
            onAdd();
        }
    }

    /* access modifiers changed from: protected */
    public void draw(MarkerOptions markerOptions, List<LatLng> list) {
        if (this.f43970f) {
            remove();
        }
        if (this.f43968b != null) {
            if (list != null && list.size() == 2) {
                LineParams lineParams = new LineParams(list, Color.parseColor(f43966e), 4);
                lineParams.setEnableEarthWormLine(false);
                lineParams.setZIndex(10);
                lineParams.setLinePoints(list);
                lineParams.setEnableDirArrow(false);
                if (m32799a(list.get(0), list.get(1))) {
                    this.f43969c = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_ARC, this.f43968b.getDidiCommonMap(), this.mContext, lineParams);
                } else {
                    this.f43969c = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_COMMON, this.f43968b.getDidiCommonMap(), this.mContext, lineParams);
                }
                this.f43969c.start();
                this.f43969c.setLineVisible(false);
            }
            this.f43967a = this.f43968b.addMarker(getTag(), markerOptions);
            this.f43970f = true;
            onAdd();
        }
    }

    public void remove() {
        removeInfoWindow();
        IMapView iMapView = this.f43968b;
        if (iMapView != null) {
            iMapView.removeElement(getTag());
        }
        ICompLineContract iCompLineContract = this.f43969c;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
        }
        this.mInfoWindow = null;
        this.f43970f = false;
    }

    public void onDestroy() {
        removeInfoWindow();
        IMapView iMapView = this.f43968b;
        if (iMapView != null) {
            iMapView.removeElement(getTag());
        }
        ICompLineContract iCompLineContract = this.f43969c;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f43969c = null;
        }
        this.f43967a = null;
        this.mInfoWindow = null;
        this.f43970f = false;
    }

    public void hideInfoWindow() {
        m32798a(false);
    }

    /* renamed from: a */
    private void m32798a(boolean z) {
        MapInfoWindowManager.Companion.getInstance().setInfoWindowVisible(this.f43967a, z);
    }

    public void removeInfoWindow() {
        MapInfoWindowManager.Companion.getInstance().removeInfoWindow(this.f43967a);
    }

    public void showInfoWindow() {
        m32798a(true);
    }

    public InfoWindow buildInfoWindow(Context context, InfoWindowOptions infoWindowOptions) {
        return MapInfoWindowManager.Companion.getInstance().createInfoWindow(this.f43967a, this.f43968b, infoWindowOptions, context);
    }

    public LatLng getLineCenter() {
        ICompLineContract iCompLineContract = this.f43969c;
        if (iCompLineContract == null) {
            return null;
        }
        List<LatLng> allLinePoints = iCompLineContract.getAllLinePoints();
        if (CollectionUtil.isEmpty((Collection<?>) allLinePoints)) {
            return null;
        }
        if (!(this.f43969c instanceof ArcLineComponent) || allLinePoints.size() <= 2) {
            return OrderMapUtil.getLineCenter(allLinePoints.get(0), allLinePoints.get(allLinePoints.size() - 1));
        }
        return allLinePoints.get(allLinePoints.size() / 2);
    }

    /* renamed from: a */
    private boolean m32799a(LatLng latLng, LatLng latLng2) {
        double angle = (double) AngleUtil.getAngle(latLng, latLng2);
        return Math.abs(angle) % 90.0d > 15.0d && Math.abs(angle) % 90.0d < 90.0d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.f43967a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isRealExistInMapView() {
        /*
            r1 = this;
            boolean r0 = r1.isExist()
            if (r0 == 0) goto L_0x0012
            com.didi.common.map.model.Marker r0 = r1.f43967a
            if (r0 == 0) goto L_0x0012
            com.didi.common.map.model.MarkerOptions r0 = r0.getOptions()
            if (r0 == 0) goto L_0x0012
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.map.marker.AbsMarker.isRealExistInMapView():boolean");
    }
}
