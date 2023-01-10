package com.didi.common.map.model;

import android.graphics.Typeface;
import com.didi.common.map.internal.IMapElementOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions extends IMapElementOptions {

    /* renamed from: a */
    private List<LatLng> f12727a;

    /* renamed from: b */
    private List<List<LatLng>> f12728b;

    /* renamed from: c */
    private float f12729c;

    /* renamed from: d */
    private int f12730d;

    /* renamed from: e */
    private int f12731e;

    /* renamed from: f */
    private boolean f12732f;

    /* renamed from: g */
    private String f12733g;

    /* renamed from: h */
    private int f12734h;

    /* renamed from: i */
    private Typeface f12735i;

    /* renamed from: j */
    private int f12736j;

    /* renamed from: k */
    private int f12737k;

    /* renamed from: l */
    private int f12738l;

    /* renamed from: m */
    private float f12739m;

    /* renamed from: n */
    private float f12740n;

    public static final class PolygonType {
        public static final int POLYGON_PATTERN_DASHED = 1;
        public static final int POLYGON_PATTERN_SOLID = 0;
    }

    public PolygonOptions() {
        this.f12729c = -1.0f;
        this.f12730d = -1;
        this.f12731e = -1;
        this.f12732f = false;
        this.f12733g = null;
        this.f12734h = -16777216;
        this.f12735i = Typeface.DEFAULT;
        this.f12736j = Integer.MAX_VALUE;
        this.f12737k = 1;
        this.f12738l = 0;
        this.f12727a = new ArrayList();
        this.f12728b = new ArrayList();
    }

    public PolygonOptions(List<LatLng> list, List list2, float f, int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.f12729c = -1.0f;
        this.f12730d = -1;
        this.f12731e = -1;
        this.f12732f = false;
        this.f12733g = null;
        this.f12734h = -16777216;
        this.f12735i = Typeface.DEFAULT;
        this.f12736j = Integer.MAX_VALUE;
        this.f12737k = 1;
        this.f12738l = 0;
        this.f12727a = list;
        this.f12728b = list2;
        this.f12729c = f;
        this.f12730d = i;
        this.f12731e = i2;
        this.f12732f = z2;
        zIndex(i3);
        visible(z);
        clickable(z3);
    }

    public PolygonOptions add(LatLng latLng) {
        this.f12727a.add(latLng);
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        this.f12727a.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolygonOptions add(List<LatLng> list) {
        this.f12727a.addAll(list);
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        if (iterable == null) {
            return this;
        }
        for (LatLng next : iterable) {
            if (next != null) {
                this.f12727a.add(next);
            }
        }
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> iterable) {
        ArrayList arrayList = new ArrayList();
        for (LatLng next : iterable) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        this.f12728b.add(arrayList);
        return this;
    }

    public PolygonOptions strokeWidth(float f) {
        this.f12729c = f;
        return this;
    }

    public PolygonOptions strokeColor(int i) {
        this.f12730d = i;
        return this;
    }

    public PolygonOptions fillColor(int i) {
        this.f12731e = i;
        return this;
    }

    public PolygonOptions geodesic(boolean z) {
        this.f12732f = z;
        return this;
    }

    public PolygonOptions text(String str) {
        this.f12733g = str;
        return this;
    }

    public PolygonOptions textColor(int i) {
        this.f12734h = i;
        return this;
    }

    public PolygonOptions textTypeface(Typeface typeface) {
        this.f12735i = typeface;
        return this;
    }

    public PolygonOptions maxTextSize(int i) {
        this.f12736j = i;
        return this;
    }

    public PolygonOptions minTextSize(int i) {
        this.f12737k = i;
        return this;
    }

    public List<LatLng> getPoints() {
        return this.f12727a;
    }

    public List<List<LatLng>> getHoles() {
        return this.f12728b;
    }

    public float getStrokeWidth() {
        return this.f12729c;
    }

    public int getStrokeColor() {
        return this.f12730d;
    }

    public int getFillColor() {
        return this.f12731e;
    }

    public boolean isGeodesic() {
        return this.f12732f;
    }

    public String getText() {
        return this.f12733g;
    }

    public int getTextColor() {
        return this.f12734h;
    }

    public Typeface getTextTypeface() {
        return this.f12735i;
    }

    public int getMaxTextSize() {
        return this.f12736j;
    }

    public int getMinTextSize() {
        return this.f12737k;
    }

    public int getPolygonPatternType() {
        return this.f12738l;
    }

    public void setPolygonPatternType(int i) {
        this.f12738l = i;
    }

    public float getDashLengthPx() {
        return this.f12739m;
    }

    public void setDashLengthPx(int i) {
        this.f12739m = (float) i;
    }

    public float getGapLengthPx() {
        return this.f12740n;
    }

    public void setGapLengthPx(int i) {
        this.f12740n = (float) i;
    }
}
