package com.didi.map.sdk.nav.line;

import android.graphics.Color;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import java.util.ArrayList;
import java.util.List;

public class MultiLine {

    /* renamed from: a */
    private static final String f30927a = "SctxLine";

    /* renamed from: b */
    private LineOptions f30928b;

    /* renamed from: c */
    private LineOptions f30929c;

    /* renamed from: d */
    private LineOptions f30930d;

    /* renamed from: e */
    private boolean f30931e;

    /* renamed from: f */
    private Map f30932f;

    /* renamed from: g */
    private List<LatLng> f30933g;

    /* renamed from: h */
    private int f30934h;
    public Line mFirstLine;
    public Line mFirstLine_Ex;
    public Line mSecondLine;

    public MultiLine(Map map) {
        this.f30932f = map;
        LineOptions width = new LineOptions().color(Color.rgb(23, 131, 242)).width(30.0d);
        this.f30929c = width;
        width.clickable(false);
        this.f30929c.visible(true);
        LineOptions width2 = new LineOptions().color(Color.rgb(23, 131, 242)).width(30.0d);
        this.f30928b = width2;
        width2.clickable(false);
        this.f30928b.visible(true);
        LineOptions width3 = new LineOptions().color(Color.rgb(162, 174, 187)).width(30.0d);
        this.f30930d = width3;
        width3.clickable(false);
        this.f30930d.visible(true);
    }

    public boolean isVisible() {
        return this.f30931e;
    }

    public void setVisible(boolean z) {
        this.f30931e = z;
        LineOptions lineOptions = this.f30929c;
        if (lineOptions != null) {
            lineOptions.visible(z);
        }
        LineOptions lineOptions2 = this.f30928b;
        if (lineOptions2 != null) {
            lineOptions2.visible(z);
        }
        LineOptions lineOptions3 = this.f30930d;
        if (lineOptions3 != null) {
            lineOptions3.visible(z);
        }
        Line line = this.mFirstLine;
        if (line != null) {
            line.setVisible(z);
        }
        Line line2 = this.mFirstLine_Ex;
        if (line2 != null) {
            line2.setVisible(z);
        }
        Line line3 = this.mSecondLine;
        if (line3 != null) {
            line3.setVisible(z);
        }
    }

    public void remove() {
        Map map = this.f30932f;
        if (map != null) {
            Line line = this.mFirstLine;
            if (line != null) {
                map.remove(line);
                this.mFirstLine = null;
            }
            Line line2 = this.mFirstLine_Ex;
            if (line2 != null) {
                this.f30932f.remove(line2);
                this.mFirstLine_Ex = null;
            }
            Line line3 = this.mSecondLine;
            if (line3 != null) {
                this.f30932f.remove(line3);
                this.mSecondLine = null;
            }
        }
    }

    public void init(int i) {
        if (this.f30932f != null) {
            remove();
            this.f30934h = i;
            if (i >= 0) {
                LineOptions lineOptions = this.f30930d;
                List<LatLng> list = this.f30933g;
                lineOptions.setPoints(list.subList(i, list.size()));
                this.f30930d.visible(this.f30931e);
                this.f30930d.zIndex(this.f30929c.getZIndex() - 1);
                this.mSecondLine = this.f30932f.addLine(this.f30930d);
                this.f30929c.setPoints(this.f30933g.subList(0, this.f30934h + 1));
                this.f30929c.visible(this.f30931e);
                this.mFirstLine = this.f30932f.addLine(this.f30929c);
                this.f30928b.setPoints(this.f30933g.subList(0, 1));
                this.f30928b.visible(this.f30931e);
                this.mFirstLine_Ex = this.f30932f.addLine(this.f30928b);
                return;
            }
            this.f30929c.setPoints(this.f30933g);
            this.f30929c.visible(this.f30931e);
            this.mFirstLine = this.f30932f.addLine(this.f30929c);
            LineOptions lineOptions2 = this.f30928b;
            List<LatLng> list2 = this.f30933g;
            lineOptions2.setPoints(list2.subList(list2.size() - 1, this.f30933g.size()));
            this.f30928b.visible(this.f30931e);
            this.mFirstLine_Ex = this.f30932f.addLine(this.f30928b);
            this.mSecondLine = null;
        }
    }

    public void onArrived() {
        List<LatLng> bounderPoints;
        List<LatLng> bounderPoints2;
        Line line = this.mFirstLine;
        if (!(line == null || (bounderPoints2 = line.getBounderPoints()) == null || bounderPoints2.size() <= 0)) {
            this.mFirstLine.setPoints(bounderPoints2.subList(0, 1));
        }
        Line line2 = this.mFirstLine_Ex;
        if (line2 != null && (bounderPoints = line2.getBounderPoints()) != null && bounderPoints.size() > 0) {
            this.mFirstLine_Ex.setPoints(bounderPoints.subList(0, 1));
        }
    }

    public void updateFirstLineEX(List<LatLng> list) {
        Line line;
        if (list != null && list.size() != 0 && (line = this.mFirstLine_Ex) != null) {
            line.setPoints(list);
        }
    }

    public void updateFirstLineAll(List<LatLng> list, int i) {
        if (list == null) {
            Line line = this.mFirstLine_Ex;
            if (line != null && this.mFirstLine != null) {
                line.setPoints(this.f30933g.subList(0, 1));
                this.mFirstLine.setPoints(this.f30933g.subList(0, 1));
            }
        } else if (this.mFirstLine_Ex != null && this.mFirstLine != null) {
            int i2 = i + 1;
            if (list.size() == i2) {
                this.mFirstLine_Ex.setPoints(list.subList(0, i2));
                this.mFirstLine.setPoints(list.subList(i, list.size()));
                return;
            }
            this.mFirstLine_Ex.setPoints(list.subList(0, i + 2));
            this.mFirstLine.setPoints(list.subList(i2, list.size()));
        }
    }

    public void updateFirstLineAll(List<LatLng> list, List<LatLng> list2) {
        Line line;
        if (this.f30932f != null) {
            if (!(list == null || list.size() <= 0 || (line = this.mFirstLine_Ex) == null)) {
                line.setPoints(list);
            }
            if (list2 != null && list2.size() > 0) {
                if (this.f30932f.getMapVendor() == MapVendor.DIDI && list2.size() == 1) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(list2.get(0));
                    arrayList.add(list2.get(0));
                    Line line2 = this.mFirstLine;
                    if (line2 != null) {
                        line2.setPoints(arrayList);
                        return;
                    }
                    return;
                }
                Line line3 = this.mFirstLine;
                if (line3 != null) {
                    line3.setPoints(list2);
                }
            }
        }
    }

    public void setPoints(List<LatLng> list) {
        if (list != null && list.size() != 0) {
            this.f30933g = list;
            Line line = this.mFirstLine;
            if (line != null && this.mFirstLine_Ex != null) {
                Line line2 = this.mSecondLine;
                if (line2 == null) {
                    line.setPoints(list);
                    this.mFirstLine_Ex.setPoints(this.f30933g.subList(0, 1));
                    return;
                }
                List<LatLng> bounderPoints = line2.getBounderPoints();
                if (bounderPoints == null || bounderPoints.size() > list.size()) {
                    this.mFirstLine.setPoints(list.subList(0, 1));
                    this.mFirstLine_Ex.setPoints(this.f30933g.subList(0, 1));
                    return;
                }
                this.mFirstLine.setPoints(list.subList(0, (list.size() - bounderPoints.size()) + 1));
                this.mFirstLine_Ex.setPoints(this.f30933g.subList(0, 1));
            }
        }
    }

    public void setOptions(LineOptions lineOptions, LineOptions lineOptions2) {
        LineOptions lineOptions3 = this.f30929c;
        if (!(lineOptions3 == null || lineOptions == null)) {
            lineOptions3.color(lineOptions.getColor());
            this.f30929c.visible(lineOptions.isVisible());
            this.f30929c.width(lineOptions.getWidth());
            this.f30929c.zIndex(lineOptions.getZIndex());
            Line line = this.mFirstLine;
            if (line != null) {
                line.setColor(this.f30929c.getColor());
                this.mFirstLine.setVisible(this.f30929c.isVisible());
                this.mFirstLine.setWidth(this.f30929c.getWidth());
                this.mFirstLine.setZIndex(this.f30929c.getZIndex());
            }
        }
        LineOptions lineOptions4 = this.f30928b;
        if (!(lineOptions4 == null || lineOptions == null)) {
            lineOptions4.color(lineOptions.getColor());
            this.f30928b.visible(lineOptions.isVisible());
            this.f30928b.width(lineOptions.getWidth());
            this.f30928b.zIndex(lineOptions.getZIndex());
            Line line2 = this.mFirstLine_Ex;
            if (line2 != null) {
                line2.setColor(this.f30928b.getColor());
                this.mFirstLine_Ex.setVisible(this.f30928b.isVisible());
                this.mFirstLine_Ex.setWidth(this.f30928b.getWidth());
                this.mFirstLine_Ex.setZIndex(this.f30928b.getZIndex());
            }
        }
        LineOptions lineOptions5 = this.f30930d;
        if (!(lineOptions5 == null || lineOptions2 == null)) {
            lineOptions5.color(lineOptions2.getColor());
            this.f30930d.visible(lineOptions2.isVisible());
            this.f30930d.width(lineOptions2.getWidth());
            this.f30930d.zIndex(lineOptions2.getZIndex());
            Line line3 = this.mSecondLine;
            if (line3 != null) {
                line3.setColor(this.f30930d.getColor());
                this.mSecondLine.setVisible(this.f30930d.isVisible());
                this.mSecondLine.setWidth(this.f30930d.getWidth());
                this.mSecondLine.setZIndex(this.f30930d.getZIndex());
            }
        }
        boolean z = false;
        if (lineOptions != null) {
            this.f30931e = this.f30931e || lineOptions.isVisible();
        }
        if (lineOptions2 != null) {
            if (this.f30931e || lineOptions2.isVisible()) {
                z = true;
            }
            this.f30931e = z;
        }
    }
}
