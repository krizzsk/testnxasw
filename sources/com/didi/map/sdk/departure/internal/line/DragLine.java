package com.didi.map.sdk.departure.internal.line;

import android.content.Context;
import android.graphics.Color;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import com.didi.map.sdk.departure.internal.util.DimenUtil;
import com.didi.map.sdk.departure.internal.util.LatLngUtil;
import java.util.ArrayList;
import java.util.List;

public class DragLine implements IDragLine {

    /* renamed from: a */
    private Map f30614a;

    /* renamed from: b */
    private DragLineParam f30615b;

    /* renamed from: c */
    private Line f30616c;

    public void onMapVisible(boolean z) {
    }

    public void create(Context context, Map map) {
        this.f30614a = map;
    }

    public void destroy() {
        remove();
        this.f30614a = null;
        this.f30615b = null;
    }

    public void setConfigParam(DragLineParam dragLineParam) {
        this.f30615b = dragLineParam;
    }

    public void add() {
        DragLineParam dragLineParam;
        int dip2px;
        if (this.f30614a != null && (dragLineParam = this.f30615b) != null && dragLineParam.start != null && this.f30615b.end != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f30615b.start);
            arrayList.add(this.f30615b.end);
            double distance = LatLngUtil.getDistance(this.f30615b.start.longitude, this.f30615b.start.latitude, this.f30615b.end.longitude, this.f30615b.end.latitude);
            if (distance > 120.0d) {
                dip2px = DimenUtil.dip2px(this.f30614a.getContext(), 0.5f);
            } else if (distance < 80.0d) {
                dip2px = DimenUtil.dip2px(this.f30614a.getContext(), 2.0f);
            } else {
                dip2px = DimenUtil.dip2px(this.f30614a.getContext(), 2.0f - ((float) (((distance - 80.0d) * 1.5d) / 40.0d)));
            }
            double d = (double) dip2px;
            Line line = this.f30616c;
            if (line == null) {
                LineOptions lineOptions = new LineOptions();
                lineOptions.type(4);
                lineOptions.color(Color.parseColor("#3CBCA3"));
                lineOptions.add((List<LatLng>) arrayList);
                lineOptions.width(d);
                this.f30616c = this.f30614a.addLine(lineOptions);
                return;
            }
            line.setWidth(d);
            this.f30616c.setPoints(arrayList);
        }
    }

    public void remove() {
        Map map;
        Line line = this.f30616c;
        if (line != null && (map = this.f30614a) != null) {
            if (map != null) {
                map.remove(line);
            }
            this.f30616c = null;
        }
    }

    public void visible(boolean z) {
        Line line = this.f30616c;
        if (line != null) {
            line.setVisible(z);
        }
    }

    public boolean isVisible() {
        Line line = this.f30616c;
        if (line != null) {
            return line.isVisible();
        }
        return false;
    }

    public void update(DragLineParam dragLineParam) {
        this.f30615b = dragLineParam;
        add();
    }
}
