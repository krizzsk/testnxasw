package com.didi.map.global.flow.scene.order.waiting.p124v2;

import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didichuxing.routesearchsdk.CallFrom;
import java.util.List;

/* renamed from: com.didi.map.global.flow.scene.order.waiting.v2.WaitingStartEndParam */
public class WaitingStartEndParam {

    /* renamed from: a */
    private MarkerModel f29509a;

    /* renamed from: b */
    private MarkerModel f29510b;

    /* renamed from: c */
    private WaitingStartEndLineParam f29511c;

    /* renamed from: d */
    private List<MarkerModel> f29512d;

    public WaitingStartEndParam(MarkerModel markerModel, MarkerModel markerModel2, WaitingStartEndLineParam waitingStartEndLineParam) {
        this.f29509a = markerModel;
        this.f29510b = markerModel2;
        this.f29511c = waitingStartEndLineParam;
    }

    public WaitingStartEndParam(MarkerModel markerModel, MarkerModel markerModel2, WaitingStartEndLineParam waitingStartEndLineParam, List<MarkerModel> list) {
        this.f29509a = markerModel;
        this.f29510b = markerModel2;
        this.f29511c = waitingStartEndLineParam;
        this.f29512d = list;
    }

    public MarkerModel getStartMarkerModel() {
        return this.f29509a;
    }

    public void setStartMarkerModel(MarkerModel markerModel) {
        this.f29509a = markerModel;
    }

    public MarkerModel getEndMarkerModel() {
        return this.f29510b;
    }

    public void setEndMarkerModel(MarkerModel markerModel) {
        this.f29510b = markerModel;
    }

    public WaitingStartEndLineParam getLineCompParams() {
        return this.f29511c;
    }

    public void setLineCompParams(WaitingStartEndLineParam waitingStartEndLineParam) {
        this.f29511c = waitingStartEndLineParam;
    }

    public List<MarkerModel> getWayPointsModels() {
        return this.f29512d;
    }

    public void setWayPointsModels(List<MarkerModel> list) {
        this.f29512d = list;
    }

    /* renamed from: com.didi.map.global.flow.scene.order.waiting.v2.WaitingStartEndParam$WaitingStartEndLineParam */
    public static class WaitingStartEndLineParam {
        private CallFrom caller = null;
        private int color = 0;
        private LatLng endPos = null;
        private int lineExtensionAnimDuration = 1500;
        private int lineWidth = 0;
        private int pulseAnimDuration = 1500;
        private LatLng startPos = null;
        private List<LatLng> wayPoints = null;

        public LatLng getStartPos() {
            return this.startPos;
        }

        public void setStartPos(LatLng latLng) {
            this.startPos = latLng;
        }

        public LatLng getEndPos() {
            return this.endPos;
        }

        public void setEndPos(LatLng latLng) {
            this.endPos = latLng;
        }

        public List<LatLng> getWayPoints() {
            return this.wayPoints;
        }

        public void setWayPoints(List<LatLng> list) {
            this.wayPoints = list;
        }

        public CallFrom getCaller() {
            return this.caller;
        }

        public void setCaller(CallFrom callFrom) {
            this.caller = callFrom;
        }

        public int getColor() {
            return this.color;
        }

        public void setColor(int i) {
            this.color = i;
        }

        public int getLineWidth() {
            return this.lineWidth;
        }

        public void setLineWidth(int i) {
            this.lineWidth = i;
        }

        public int getPulseAnimDuration() {
            return this.pulseAnimDuration;
        }

        public void setPulseAnimDuration(int i) {
            this.pulseAnimDuration = i;
        }

        public int getLineExtensionAnimDuration() {
            return this.lineExtensionAnimDuration;
        }

        public void setLineExtensionAnimDuration(int i) {
            this.lineExtensionAnimDuration = i;
        }
    }
}
