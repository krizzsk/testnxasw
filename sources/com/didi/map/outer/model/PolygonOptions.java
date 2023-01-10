package com.didi.map.outer.model;

import android.graphics.Typeface;
import com.didi.map.alpha.adapt.MapUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolygonOptions {

    /* renamed from: a */
    private final List<LatLng> f30458a = new ArrayList();

    /* renamed from: b */
    private float f30459b = 1.0f;

    /* renamed from: c */
    private int f30460c = -16777216;

    /* renamed from: d */
    private int f30461d = MapUtil.COLOR_DEFAULT_POLYLINE;

    /* renamed from: e */
    private float f30462e = 0.0f;

    /* renamed from: f */
    private boolean f30463f = true;

    /* renamed from: g */
    private boolean f30464g = false;

    /* renamed from: h */
    private String f30465h = "";

    /* renamed from: i */
    private int f30466i = -16777216;

    /* renamed from: j */
    private Typeface f30467j = Typeface.DEFAULT;

    /* renamed from: k */
    private int f30468k = Integer.MAX_VALUE;

    /* renamed from: l */
    private int f30469l = 1;

    /* renamed from: m */
    private int f30470m = -1;

    /* renamed from: n */
    private boolean f30471n = false;

    /* renamed from: o */
    private boolean f30472o = false;

    /* renamed from: p */
    private boolean f30473p = false;

    public PolygonOptions setForceLoad(boolean z) {
        this.f30471n = z;
        return this;
    }

    public boolean getIsForceLoad() {
        return this.f30471n;
    }

    public void setPoints(Iterable<LatLng> iterable) {
        List<LatLng> list = this.f30458a;
        if (list != null) {
            list.clear();
            if (iterable != null) {
                addAll(iterable);
            }
        }
    }

    public PolygonOptions add(LatLng latLng) {
        this.f30458a.add(latLng);
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        this.f30458a.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolygonOptions add(List<LatLng> list) {
        this.f30458a.addAll(list);
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.f30458a.add(add);
        }
        return this;
    }

    public PolygonOptions strokeWidth(float f) {
        this.f30459b = f;
        return this;
    }

    public PolygonOptions strokeColor(int i) {
        this.f30460c = i;
        return this;
    }

    public PolygonOptions fillColor(int i) {
        this.f30461d = i;
        return this;
    }

    public PolygonOptions zIndex(float f) {
        this.f30462e = f;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.f30463f = z;
        return this;
    }

    public PolygonOptions geodesic(boolean z) {
        this.f30464g = z;
        return this;
    }

    public List<LatLng> getPoints() {
        return this.f30458a;
    }

    public float getStrokeWidth() {
        return this.f30459b;
    }

    public int getStrokeColor() {
        return this.f30460c;
    }

    public int getFillColor() {
        return this.f30461d;
    }

    public float getZIndex() {
        return this.f30462e;
    }

    public boolean isVisible() {
        return this.f30463f;
    }

    public boolean isGeodesic() {
        return this.f30464g;
    }

    public PolygonOptions text(String str) {
        this.f30465h = str;
        return this;
    }

    public String getText() {
        return this.f30465h;
    }

    public PolygonOptions textColor(int i) {
        this.f30466i = i;
        return this;
    }

    public int getTextColor() {
        return this.f30466i;
    }

    public PolygonOptions textTypeface(Typeface typeface) {
        this.f30467j = typeface;
        return this;
    }

    public PolygonOptions bellowRoute(boolean z) {
        this.f30472o = z;
        return this;
    }

    public boolean getIsBellowRoute() {
        return this.f30472o;
    }

    public Typeface getTypeface() {
        return this.f30467j;
    }

    public PolygonOptions maxTextSize(int i) {
        this.f30468k = i;
        return this;
    }

    public int getMaxTextSize() {
        return this.f30468k;
    }

    public PolygonOptions minTextSize(int i) {
        this.f30469l = i;
        return this;
    }

    public int getMinTextSize() {
        return this.f30469l;
    }

    /* renamed from: a */
    private PolygonOptions m23554a(int i) {
        this.f30470m = i;
        return this;
    }

    /* renamed from: a */
    private int m23553a() {
        return this.f30470m;
    }

    public boolean isClickable() {
        return this.f30473p;
    }

    public PolygonOptions setClickable(boolean z) {
        this.f30473p = z;
        return this;
    }
}
