package com.didi.map.outer.model;

import com.didi.map.alpha.maps.internal.HeatOverlayControl;
import java.util.List;

public class HeatOverlay {

    /* renamed from: a */
    private String f30384a;

    /* renamed from: b */
    private final HeatOverlayControl f30385b;

    /* renamed from: c */
    private HeatOverlayOptions f30386c;

    public HeatOverlay(HeatOverlayControl heatOverlayControl, String str, HeatOverlayOptions heatOverlayOptions) {
        this.f30385b = heatOverlayControl;
        this.f30384a = str;
        this.f30386c = heatOverlayOptions;
    }

    public void updateData(List<HeatDataNode> list) {
        this.f30385b.updateData(this.f30384a, list);
    }

    public void remove() {
        this.f30385b.remove(this.f30384a);
    }

    public String getId() {
        return this.f30384a;
    }
}
