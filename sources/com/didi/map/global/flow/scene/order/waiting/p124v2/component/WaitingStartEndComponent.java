package com.didi.map.global.flow.scene.order.waiting.p124v2.component;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineExParam;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.component.OnLineDrawStatusListener;
import com.didi.map.global.component.line.pax.commonline.CommonLineManager;
import com.didi.map.global.component.line.pax.commonline.CommonLineParam;
import com.didi.map.global.component.markers.MarkersCompParams;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.view.BreathAnimMarker;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.global.flow.scene.order.waiting.p124v2.WaitingStartEndParam;
import com.didi.map.sdk.component.IBaseComponent;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.map.global.flow.scene.order.waiting.v2.component.WaitingStartEndComponent */
public class WaitingStartEndComponent implements IBaseComponent<WaitingStartEndParam> {

    /* renamed from: a */
    private static final String f29525a = "WaitingSceneStartEndComponent";

    /* renamed from: b */
    private Context f29526b;

    /* renamed from: c */
    private Map f29527c;

    /* renamed from: d */
    private CommonLineManager f29528d;

    /* renamed from: e */
    private ICompLineContract f29529e;

    /* renamed from: f */
    private BreathAnimMarker f29530f;

    /* renamed from: g */
    private MarkerModel f29531g;

    /* renamed from: h */
    private MarkerModel f29532h;

    /* renamed from: i */
    private List<MarkerModel> f29533i;

    /* renamed from: j */
    private WaitingStartEndParam.WaitingStartEndLineParam f29534j;

    /* renamed from: k */
    private MarkersComponent f29535k;

    public void create(Context context, Map map) {
        this.f29526b = context;
        this.f29527c = map;
    }

    public void destroy() {
        removeLine();
        m22865a();
        this.f29526b = null;
        this.f29527c = null;
    }

    /* renamed from: a */
    private void m22865a() {
        MarkersComponent markersComponent = this.f29535k;
        if (markersComponent != null) {
            markersComponent.destroy();
            this.f29535k = null;
        }
        BreathAnimMarker breathAnimMarker = this.f29530f;
        if (breathAnimMarker != null) {
            breathAnimMarker.destroy();
            this.f29530f = null;
        }
        this.f29531g = null;
        this.f29532h = null;
    }

    public void removeLine() {
        CommonLineManager commonLineManager = this.f29528d;
        if (commonLineManager != null) {
            commonLineManager.destroy();
            this.f29528d = null;
        }
        ICompLineContract iCompLineContract = this.f29529e;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f29529e = null;
        }
    }

    public void setConfigParam(WaitingStartEndParam waitingStartEndParam) {
        if (waitingStartEndParam != null) {
            this.f29531g = waitingStartEndParam.getStartMarkerModel();
            this.f29532h = waitingStartEndParam.getEndMarkerModel();
            this.f29534j = waitingStartEndParam.getLineCompParams();
            this.f29533i = waitingStartEndParam.getWayPointsModels();
        }
    }

    public void onMapVisible(boolean z) {
        CommonLineManager commonLineManager = this.f29528d;
        if (commonLineManager != null) {
            commonLineManager.setLineVisible(z);
        }
        ICompLineContract iCompLineContract = this.f29529e;
        if (iCompLineContract != null) {
            iCompLineContract.onMapVisible(z);
        }
    }

    public void start() {
        if (this.f29526b != null && this.f29527c != null) {
            ArrayList arrayList = new ArrayList();
            MarkerModel markerModel = this.f29531g;
            if (markerModel != null) {
                if (this.f29530f == null && markerModel.getPoint() != null) {
                    this.f29530f = new BreathAnimMarker();
                    this.f29530f.setConfigParam(new BreathAnimMarker.BreathMarkerParam(this.f29531g, 1000, 1.0f, 1.2f));
                    this.f29530f.create(this.f29526b, this.f29527c);
                    DLog.m10773d(f29525a, "startPoint--->lat" + this.f29531g.getPoint().latitude + "long" + this.f29531g.getPoint().longitude, new Object[0]);
                }
                startPointAnimControl(true);
            }
            MarkerModel markerModel2 = this.f29532h;
            if (!(markerModel2 == null || markerModel2.getPoint() == null)) {
                this.f29532h.setAddressName("");
                DLog.m10773d(f29525a, "endPoint--->lat" + this.f29532h.getPoint().latitude + "long" + this.f29532h.getPoint().longitude, new Object[0]);
                arrayList.add(this.f29532h);
            }
            m22866b();
            List<MarkerModel> list = this.f29533i;
            if (list != null) {
                for (MarkerModel next : list) {
                    next.setZOrder(next.getZOrder());
                    if (!(next == null || next.getPoint() == null)) {
                        DLog.m10773d(f29525a, "wayPoint--->lat" + next.getPoint().latitude + "long" + next.getPoint().longitude, new Object[0]);
                        next.setAddressName("");
                        arrayList.add(next);
                    }
                }
            }
            this.f29535k = new MarkersComponent();
            this.f29535k.setConfigParam(new MarkersCompParams.Builder().markerModels(arrayList).build());
            this.f29535k.create(this.f29526b, this.f29527c);
        }
    }

    public void startPointAnimControl(boolean z) {
        BreathAnimMarker breathAnimMarker = this.f29530f;
        if (breathAnimMarker != null) {
            breathAnimMarker.playAnimation(z);
        }
    }

    /* renamed from: b */
    private void m22866b() {
        if (this.f29531g != null && this.f29532h != null && this.f29534j != null && this.f29526b != null && this.f29527c != null) {
            CommonLineManager commonLineManager = this.f29528d;
            if (commonLineManager != null) {
                commonLineManager.destroy();
                this.f29528d = null;
            }
            ArrayList arrayList = new ArrayList();
            List<MarkerModel> list = this.f29533i;
            if (list != null && !list.isEmpty()) {
                for (MarkerModel point : this.f29533i) {
                    arrayList.add(point.getPoint());
                }
            }
            LineParams lineParams = new LineParams((List<LatLng>) null, this.f29534j.getColor(), this.f29534j.getLineWidth());
            lineParams.setZIndex(116);
            LineExParam lineExParam = new LineExParam();
            lineExParam.setHasPulseAnim(true);
            lineExParam.setPulseAnimDuration(this.f29534j.getPulseAnimDuration());
            lineExParam.setHasLineExtensionAnim(false);
            lineExParam.setLineExtensionAnimDuration(this.f29534j.getLineExtensionAnimDuration());
            lineParams.setExParam(lineExParam);
            CommonLineParam commonLineParam = new CommonLineParam();
            commonLineParam.setLineParam(lineParams);
            commonLineParam.setStartPos(this.f29534j.getStartPos());
            commonLineParam.setEndPos(this.f29534j.getEndPos());
            commonLineParam.setCaller(this.f29534j.getCaller());
            commonLineParam.setWayPoints(arrayList);
            CommonLineManager commonLineManager2 = new CommonLineManager(this.f29526b, this.f29527c, commonLineParam);
            this.f29528d = commonLineManager2;
            commonLineManager2.setListener(new OnLineDrawStatusListener() {
                public /* synthetic */ void onLineDrawStart() {
                    OnLineDrawStatusListener.CC.$default$onLineDrawStart(this);
                }

                public void onLineDrawFinished() {
                    DLog.m10773d(WaitingStartEndComponent.f29525a, "起终点连线成功", new Object[0]);
                }
            });
            this.f29528d.create();
        }
    }

    public void stopPulseAnim() {
        CommonLineManager commonLineManager = this.f29528d;
        if (commonLineManager != null) {
            commonLineManager.destroy();
            this.f29528d = null;
        }
        ICompLineContract iCompLineContract = this.f29529e;
        if (iCompLineContract != null) {
            iCompLineContract.stop();
            this.f29529e.destroy();
        }
    }

    public List<IMapElement> getAllMarkerElement() {
        ArrayList arrayList = new ArrayList();
        MarkersComponent markersComponent = this.f29535k;
        if (!(markersComponent == null || markersComponent.getMarkers() == null)) {
            arrayList.addAll(this.f29535k.getMarkers());
        }
        BreathAnimMarker breathAnimMarker = this.f29530f;
        if (!(breathAnimMarker == null || breathAnimMarker.getMarker() == null)) {
            arrayList.add(this.f29530f.getMarker());
        }
        CommonLineManager commonLineManager = this.f29528d;
        if (!(commonLineManager == null || commonLineManager.getBestViewElements() == null)) {
            arrayList.addAll(this.f29528d.getBestViewElements());
        }
        ICompLineContract iCompLineContract = this.f29529e;
        if (!(iCompLineContract == null || iCompLineContract.getBestViewElements() == null)) {
            arrayList.addAll(this.f29529e.getBestViewElements());
        }
        return arrayList;
    }

    public IMapElement getStartMarkerElement() {
        BreathAnimMarker breathAnimMarker = this.f29530f;
        if (breathAnimMarker != null) {
            return breathAnimMarker.getMarker();
        }
        return null;
    }
}
