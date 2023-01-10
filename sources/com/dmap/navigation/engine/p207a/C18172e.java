package com.dmap.navigation.engine.p207a;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.api.route.IMarkerSection;
import com.dmap.navigation.jni.swig.MarkerSection;
import com.dmap.navigation.simple.SimpleLatlng;

/* renamed from: com.dmap.navigation.engine.a.e */
/* compiled from: SimpleMarkerSection */
final class C18172e implements IMarkerSection {

    /* renamed from: a */
    private final int f54309a;

    /* renamed from: b */
    private final int f54310b;

    /* renamed from: c */
    private final LatLng f54311c;

    /* renamed from: d */
    private final LatLng f54312d;

    public C18172e(MarkerSection markerSection) {
        this.f54309a = markerSection.getStartNum();
        this.f54310b = markerSection.getEndNum();
        this.f54311c = new SimpleLatlng(markerSection.getStartPoint().getLat(), markerSection.getStartPoint().getLng());
        this.f54312d = new SimpleLatlng(markerSection.getEndPoint().getLat(), markerSection.getEndPoint().getLng());
    }

    public final int getStartIndex() {
        return this.f54309a;
    }

    public final int getEndIndex() {
        return this.f54310b;
    }

    public final LatLng getStart() {
        return this.f54311c;
    }

    public final LatLng getEnd() {
        return this.f54312d;
    }
}
