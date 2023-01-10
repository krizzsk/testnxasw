package com.didi.map.sdk.sharetrack.entity;

import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import java.util.List;

public class GuideRouteLine {

    /* renamed from: a */
    private Map f31097a;

    /* renamed from: b */
    private LineOptions f31098b;

    /* renamed from: c */
    private Line f31099c;

    public GuideRouteLine(Map map) {
        this.f31097a = map;
        this.f31098b = new LineOptions().color(-12430085).width(16.0d).type(2);
    }

    public GuideRouteLine(Map map, LineOptions lineOptions) {
        this.f31097a = map;
        this.f31098b = lineOptions;
    }

    public void setLineOpt(LineOptions lineOptions) {
        this.f31098b = lineOptions;
    }

    public Line add(List<LatLng> list) {
        if (this.f31099c != null) {
            remove();
        }
        this.f31098b.setPoints(list);
        Line addLine = this.f31097a.addLine(this.f31098b);
        this.f31099c = addLine;
        return addLine;
    }

    public void setVisible(boolean z) {
        LineOptions lineOptions = this.f31098b;
        if (lineOptions != null) {
            lineOptions.visible(z);
        }
        Line line = this.f31099c;
        if (line != null) {
            line.setVisible(z);
        }
    }

    public boolean isVisible() {
        Line line = this.f31099c;
        return line != null && line.isVisible();
    }

    public void remove() {
        Line line;
        Map map = this.f31097a;
        if (map != null && (line = this.f31099c) != null) {
            map.remove(line);
            this.f31099c = null;
        }
    }
}
