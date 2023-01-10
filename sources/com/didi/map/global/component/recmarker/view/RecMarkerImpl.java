package com.didi.map.global.component.recmarker.view;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.markers.IMarkersCompContract;
import com.didi.map.global.component.markers.MarkersCompParams;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.OnMarkerCompClickListener;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.global.component.recmarker.model.RecMarkerParam;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecMarkerImpl implements IRecMarker {

    /* renamed from: a */
    private Context f28378a;

    /* renamed from: b */
    private Map f28379b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f28380c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public RecMarkerParam f28381d;

    /* renamed from: e */
    private SensingCircles f28382e;

    /* renamed from: f */
    private boolean f28383f = false;

    /* renamed from: g */
    private boolean f28384g = false;

    /* renamed from: h */
    private boolean f28385h = false;

    /* renamed from: i */
    private OnMarkerCompClickListener f28386i = new OnMarkerCompClickListener() {
        public boolean onClick(String str) {
            if (!RecMarkerImpl.this.f28380c.equalsIgnoreCase(str) || RecMarkerImpl.this.f28381d == null || RecMarkerImpl.this.f28381d.listener == null) {
                return false;
            }
            RecMarkerImpl.this.f28381d.listener.onClick(RecMarkerImpl.this);
            return false;
        }
    };
    public boolean isPined;
    protected IMarkersCompContract mMarkerComp;

    public void onMapVisible(boolean z) {
    }

    public void create(Context context, Map map) {
        this.f28378a = context.getApplicationContext();
        this.f28379b = map;
        this.f28380c = "id-" + hashCode();
    }

    public void destroy() {
        remove();
        this.f28379b = null;
        this.f28378a = null;
    }

    public void setConfigParam(RecMarkerParam recMarkerParam) {
        this.f28381d = recMarkerParam;
    }

    public void add() {
        RecMarkerParam recMarkerParam;
        Map map = this.f28379b;
        if (map != null && map.getProjection() != null && (recMarkerParam = this.f28381d) != null && recMarkerParam.point != null && this.f28381d.point.location != null) {
            IMarkersCompContract iMarkersCompContract = this.mMarkerComp;
            if (iMarkersCompContract == null) {
                m22209a();
            } else {
                iMarkersCompContract.updatePosition(this.f28380c, this.f28381d.point.location);
            }
        }
    }

    public void setPined(boolean z) {
        this.isPined = z;
    }

    public String getId() {
        return this.f28380c;
    }

    public void setLabelDirect(int i) {
        IMarkersCompContract iMarkersCompContract = this.mMarkerComp;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.updateMarkerLabelDirect(this.f28380c, i);
        }
    }

    public void remove() {
        if (this.mMarkerComp != null) {
            hideCircles();
            this.mMarkerComp.destroy();
            this.mMarkerComp = null;
        }
    }

    public void visible(boolean z) {
        IMarkersCompContract iMarkersCompContract = this.mMarkerComp;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.setAllMarkersVisible(z);
        }
        m22213c();
    }

    public boolean isVisible() {
        IMarkersCompContract iMarkersCompContract = this.mMarkerComp;
        if (iMarkersCompContract == null) {
            return false;
        }
        List<Marker> markers = iMarkersCompContract.getMarkers();
        if (CollectionUtil.isEmpty((Collection<?>) markers)) {
            return false;
        }
        return markers.get(0).isVisible();
    }

    /* renamed from: a */
    private void m22209a() {
        RecMarkerParam recMarkerParam;
        if (this.f28379b != null && (recMarkerParam = this.f28381d) != null && recMarkerParam.icon != null && this.f28381d.selectedIcon != null && this.f28381d.point != null && this.f28381d.point.location != null) {
            this.mMarkerComp = new MarkersComponent();
            MarkersCompParams.Builder builder = new MarkersCompParams.Builder();
            ArrayList arrayList = new ArrayList();
            MarkerModel markerModel = new MarkerModel();
            markerModel.setMarkerIcon(this.f28381d.icon);
            markerModel.setClickable(true);
            markerModel.setId(this.f28380c);
            markerModel.setAnchorU(0.5f);
            markerModel.setAnchorV(0.5f);
            markerModel.setPoint(this.f28381d.point.location);
            markerModel.setZOrder(99);
            if (this.f28381d.isShowLabel) {
                markerModel.setLabelDirection(this.f28381d.labelDirection);
                markerModel.setAddressName(this.f28381d.point.addrName);
                markerModel.setLabelZIndex(99);
                markerModel.setLabelView(this.f28381d.labelView);
            }
            markerModel.setStrategy(this.f28381d.strategy);
            arrayList.add(markerModel);
            builder.markerModels(arrayList);
            this.mMarkerComp.setConfigParam(builder.build());
            this.mMarkerComp.create(this.f28378a, this.f28379b);
            this.mMarkerComp.setOnClickListener(this.f28386i);
            m22212b();
        }
    }

    /* renamed from: b */
    private void m22212b() {
        boolean isInCenter = isInCenter();
        if (isInCenter) {
            m22214d();
            m22217g();
        } else {
            m22215e();
            m22216f();
        }
        m22210a(isInCenter);
    }

    public void showCircles() {
        RecMarkerParam recMarkerParam;
        hideCircles();
        if (this.f28379b != null && this.f28378a != null && (recMarkerParam = this.f28381d) != null && recMarkerParam.point != null && this.f28381d.point.location != null) {
            SensingCircles sensingCircles = new SensingCircles(this.f28378a, this.f28379b);
            this.f28382e = sensingCircles;
            sensingCircles.show(this.f28381d.point.location);
        }
    }

    public void hideCircles() {
        SensingCircles sensingCircles = this.f28382e;
        if (sensingCircles != null && sensingCircles.isShow()) {
            this.f28382e.hide();
        }
        this.f28382e = null;
    }

    public void showTransientCircles() {
        RecMarkerParam recMarkerParam;
        if (this.f28379b != null && this.f28378a != null && this.mMarkerComp != null && (recMarkerParam = this.f28381d) != null && recMarkerParam.point != null && this.f28381d.point.location != null) {
            this.mMarkerComp.setAllMarkersVisible(true);
            new SensingCircles(this.f28378a, this.f28379b, (int) R.color.map_departure_sensing_circle, SensingCircles.TIME_TRANSIEN_PERIOD, 48.0f).showTransientCircles(this.f28381d.point.location);
        }
    }

    public LatLng getLocation() {
        RecMarkerParam recMarkerParam = this.f28381d;
        if (recMarkerParam == null || recMarkerParam.point == null) {
            return null;
        }
        return this.f28381d.point.location;
    }

    public float getAlpha() {
        IMarkersCompContract iMarkersCompContract = this.mMarkerComp;
        if (iMarkersCompContract != null) {
            return iMarkersCompContract.getAlpha(this.f28380c);
        }
        return 0.0f;
    }

    public void setAlpha(float f) {
        IMarkersCompContract iMarkersCompContract = this.mMarkerComp;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.setAlpha(this.f28380c, f);
        }
    }

    public boolean isInCenter() {
        if (this.f28379b == null || this.f28381d.point == null) {
            return false;
        }
        if (this.isPined || LatLngUtils.isSameLatLng(this.f28379b.getCameraPosition().target, this.f28381d.point.location)) {
            return true;
        }
        return false;
    }

    public void onMapStable() {
        m22213c();
        this.f28385h = false;
    }

    public void setNeedShowInfoWindow(boolean z) {
        this.f28383f = z;
    }

    public void onMapScroll() {
        this.f28385h = true;
    }

    /* renamed from: c */
    private void m22213c() {
        boolean isInCenter = isInCenter();
        if (isInCenter && !this.f28384g) {
            this.f28384g = true;
            m22214d();
            m22217g();
            m22210a(this.f28384g);
            RecMarkerParam recMarkerParam = this.f28381d;
            if (recMarkerParam != null && recMarkerParam.markerCallback != null) {
                this.f28381d.markerCallback.onRecMarkerShow(this.f28381d.point, this.f28385h);
            }
        } else if (!isInCenter && this.f28384g) {
            this.f28384g = false;
            m22215e();
            m22216f();
            m22210a(this.f28384g);
        } else if (isInCenter && this.f28384g) {
            m22214d();
            m22217g();
            m22210a(this.f28384g);
        }
    }

    /* renamed from: d */
    private void m22214d() {
        if (this.mMarkerComp != null && this.f28379b != null && this.f28378a != null && this.f28381d != null && this.f28383f && isVisible() && !TextUtils.isEmpty(this.f28381d.point.addrName)) {
            this.mMarkerComp.showMarkerInfoWindow(this.f28380c, SingleRecMarkerBubble.getInstance().getView(this.f28378a, this.f28381d.point.addrName), InfoWindow.Position.BOTTOM);
        }
    }

    /* renamed from: e */
    private void m22215e() {
        IMarkersCompContract iMarkersCompContract = this.mMarkerComp;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.hideMarkerInfoWindow(this.f28380c);
        }
    }

    /* renamed from: f */
    private void m22216f() {
        IMarkersCompContract iMarkersCompContract = this.mMarkerComp;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.setLabelVisible(this.f28380c, true);
        }
    }

    /* renamed from: g */
    private void m22217g() {
        IMarkersCompContract iMarkersCompContract = this.mMarkerComp;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.setLabelVisible(this.f28380c, false);
        }
    }

    /* renamed from: a */
    private void m22210a(boolean z) {
        RecMarkerParam recMarkerParam;
        if (this.mMarkerComp != null && (recMarkerParam = this.f28381d) != null) {
            this.mMarkerComp.updateMarkerIcon(this.f28380c, z ? recMarkerParam.selectedIcon : recMarkerParam.icon);
            int i = 100;
            this.mMarkerComp.updateMarkerZindex(this.f28380c, z ? 100 : 90);
            IMarkersCompContract iMarkersCompContract = this.mMarkerComp;
            String str = this.f28380c;
            if (!z) {
                i = 90;
            }
            iMarkersCompContract.updateLabelZindex(str, i);
        }
    }
}
