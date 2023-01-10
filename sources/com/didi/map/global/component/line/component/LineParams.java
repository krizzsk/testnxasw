package com.didi.map.global.component.line.component;

import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.line.component.traffic.TrafficData;
import java.util.List;

public class LineParams {

    /* renamed from: a */
    private int f27950a;

    /* renamed from: b */
    private int f27951b = -1;

    /* renamed from: c */
    private int f27952c;

    /* renamed from: d */
    private int f27953d;

    /* renamed from: e */
    private List<LatLng> f27954e;

    /* renamed from: f */
    private int f27955f;

    /* renamed from: g */
    private List<TrafficData> f27956g;

    /* renamed from: h */
    private LineExParam f27957h;

    /* renamed from: i */
    private float f27958i;

    /* renamed from: j */
    private boolean f27959j;

    /* renamed from: k */
    private boolean f27960k;

    /* renamed from: l */
    private boolean f27961l = true;

    public LineParams(List<LatLng> list, int i, int i2) {
        this.f27950a = i;
        this.f27953d = i2;
        this.f27954e = list;
    }

    public LineParams(List<TrafficData> list, List<LatLng> list2, int i, int i2) {
        this.f27950a = i;
        this.f27953d = i2;
        this.f27956g = list;
        this.f27954e = list2;
    }

    public int getLineColorWithArgb() {
        return this.f27950a;
    }

    public void setLineColorWithArgb(int i) {
        this.f27950a = i;
    }

    public int getDidiColor() {
        return this.f27951b;
    }

    public void setDidiColor(int i) {
        this.f27951b = i;
    }

    public int getLineWidth() {
        return this.f27953d;
    }

    public void setLineWidth(int i) {
        this.f27953d = i;
    }

    public List<LatLng> getLinePoints() {
        return this.f27954e;
    }

    public void setLinePoints(List<LatLng> list) {
        this.f27954e = list;
    }

    public int getZIndex() {
        return this.f27955f;
    }

    public void setZIndex(int i) {
        this.f27955f = i;
    }

    public List<TrafficData> getTrafficData() {
        return this.f27956g;
    }

    public void setTrafficData(List<TrafficData> list) {
        this.f27956g = list;
    }

    public LineExParam getExParam() {
        return this.f27957h;
    }

    public int getDottedIconRes() {
        return this.f27952c;
    }

    public void setDottedIconRes(int i) {
        this.f27952c = i;
    }

    public float getDotSpace() {
        return this.f27958i;
    }

    public void setDotSpace(float f) {
        this.f27958i = f;
    }

    public void setExParam(LineExParam lineExParam) {
        this.f27957h = lineExParam;
    }

    public boolean isEnableEarthWormLine() {
        return this.f27959j;
    }

    public void setEnableEarthWormLine(boolean z) {
        this.f27959j = z;
    }

    public boolean isClickable() {
        return this.f27960k;
    }

    public void setClickable(boolean z) {
        this.f27960k = z;
    }

    public void setEnableDirArrow(boolean z) {
        this.f27961l = z;
    }

    public boolean isEnableDirArrow() {
        return this.f27961l;
    }
}
