package com.didi.map.global.component.markers;

import com.didi.map.global.component.markers.view.MarkerModel;
import java.util.ArrayList;
import java.util.List;

public class MarkersCompParams {

    /* renamed from: a */
    private List<MarkerModel> f28245a = new ArrayList();

    public List<MarkerModel> getMarkerModels() {
        return this.f28245a;
    }

    public MarkersCompParams(Builder builder) {
        this.f28245a = builder.markerModels;
    }

    public static class Builder {
        public List<MarkerModel> markerModels = new ArrayList();

        public MarkersCompParams build() {
            return new MarkersCompParams(this);
        }

        public Builder markerModels(List<MarkerModel> list) {
            this.markerModels = list;
            return this;
        }
    }
}
