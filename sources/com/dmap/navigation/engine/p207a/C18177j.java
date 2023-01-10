package com.dmap.navigation.engine.p207a;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.api.core.INaviTrafficUpdater;
import com.dmap.navigation.jni.swig.IntList;
import com.dmap.navigation.jni.swig.NaviLatLng;
import com.dmap.navigation.jni.swig.NaviLatLngList;
import com.dmap.navigation.jni.swig.TrafficResponse;
import com.dmap.navigation.simple.SimpleLatlng;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: com.dmap.navigation.engine.a.j */
/* compiled from: SimpleTrafficResponse */
public final class C18177j implements INaviTrafficUpdater.ITrafficResponse {

    /* renamed from: a */
    private final int f54356a;

    /* renamed from: b */
    private final long f54357b;

    /* renamed from: c */
    private final byte[] f54358c;

    /* renamed from: d */
    private final byte[] f54359d;

    /* renamed from: e */
    private final byte[] f54360e;

    /* renamed from: f */
    private final ArrayList<Integer> f54361f;

    /* renamed from: g */
    private final ArrayList<Integer> f54362g;

    /* renamed from: h */
    private final ArrayList<LatLng> f54363h;

    public C18177j(TrafficResponse trafficResponse) {
        int expireTime = trafficResponse.getExpireTime();
        if (expireTime <= 5000) {
            this.f54356a = INaviTrafficUpdater.PUSH_RECONNECT_TIME;
        } else {
            this.f54356a = expireTime;
        }
        this.f54357b = trafficResponse.getServerTimestamp().longValue();
        this.f54358c = C18180m.m40466a(trafficResponse.getTrafficEvent(), trafficResponse.getTrafficEventSize());
        this.f54359d = C18180m.m40466a(trafficResponse.getExtendData(), trafficResponse.getExtendDataSize());
        this.f54360e = C18180m.m40466a(trafficResponse.getNaviEvents(), trafficResponse.getNaviEventsSize());
        IntList trafficIndexs = trafficResponse.getTrafficIndexs();
        this.f54361f = new ArrayList<>((int) trafficIndexs.size());
        for (int i = 0; ((long) i) < trafficIndexs.size(); i++) {
            this.f54361f.add(Integer.valueOf(trafficIndexs.get(i)));
        }
        NaviLatLngList trafficPoints = trafficResponse.getTrafficPoints();
        this.f54363h = new ArrayList<>((int) trafficPoints.size());
        for (int i2 = 0; ((long) i2) < trafficPoints.size(); i2++) {
            NaviLatLng naviLatLng = trafficPoints.get(i2);
            this.f54363h.add(new SimpleLatlng(naviLatLng.getLat(), naviLatLng.getLng()));
        }
        IntList etas = trafficResponse.getEtas();
        this.f54362g = new ArrayList<>((int) etas.size());
        for (int i3 = 0; ((long) i3) < etas.size(); i3++) {
            this.f54362g.add(Integer.valueOf(etas.get(i3)));
        }
    }

    public final String toString() {
        return "SimpleTrafficResponse{expireTime=" + this.f54356a + ", serverTimestamp=" + this.f54357b + ", trafficEvent=" + Arrays.toString(this.f54358c) + ", extendData=" + Arrays.toString(this.f54359d) + ", naviEvents=" + Arrays.toString(this.f54360e) + ", trafficIndex=" + this.f54361f + ", etas=" + this.f54362g + ", trafficInsertPoint=" + this.f54363h + '}';
    }

    public final int getExpireTime() {
        return this.f54356a;
    }

    public final long getServerTimestamp() {
        return this.f54357b;
    }

    public final byte[] getTrafficEvent() {
        return this.f54358c;
    }

    public final byte[] getExtendData() {
        return this.f54359d;
    }

    public final byte[] getNaviEvents() {
        return this.f54360e;
    }

    public final ArrayList<Integer> getTrafficIndex() {
        return this.f54361f;
    }

    public final ArrayList<LatLng> getTrafficInsertPoint() {
        return this.f54363h;
    }

    public final ArrayList<Integer> getEtas() {
        return this.f54362g;
    }
}
