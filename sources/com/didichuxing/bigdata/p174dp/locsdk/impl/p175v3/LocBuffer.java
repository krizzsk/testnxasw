package com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3;

import com.didichuxing.bigdata.p174dp.locsdk.EvilTransform;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocBuffer */
public class LocBuffer {

    /* renamed from: a */
    private long f48508a;

    /* renamed from: b */
    private Queue<LonLat> f48509b;

    /* renamed from: c */
    private final long f48510c = 60000;

    /* renamed from: d */
    private final long f48511d = 10000;

    /* renamed from: e */
    private final int f48512e = 10;

    public LocBuffer() {
        LinkedList linkedList = new LinkedList();
        this.f48509b = linkedList;
        linkedList.clear();
        this.f48508a = 0;
    }

    public void clear() {
        this.f48509b.clear();
        this.f48508a = 0;
    }

    public boolean isCompatible(LocationServiceResponse locationServiceResponse) {
        LocationServiceResponse locationServiceResponse2 = locationServiceResponse;
        if (locationServiceResponse2 == null || locationServiceResponse2.locations.size() <= 0) {
            return false;
        }
        LonLat a = m36368a(locationServiceResponse);
        if (this.f48509b.size() <= 0) {
            this.f48508a = System.currentTimeMillis();
            this.f48509b.add(a);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f48508a > 60000) {
            this.f48509b.clear();
            this.f48509b.add(a);
            this.f48508a = currentTimeMillis;
            return true;
        }
        Iterator it = this.f48509b.iterator();
        int i = 0;
        while (it.hasNext()) {
            LonLat lonLat = (LonLat) it.next();
            Iterator it2 = it;
            if (EvilTransform.calcdistance(a.lon, a.lat, lonLat.lon, lonLat.lat) > 10000.0d) {
                i++;
            }
            it = it2;
        }
        if (i <= 0) {
            m36369a(a);
            this.f48508a = currentTimeMillis;
            return true;
        } else if (i == this.f48509b.size()) {
            return false;
        } else {
            this.f48509b.clear();
            this.f48509b.add(a);
            this.f48508a = currentTimeMillis;
            return true;
        }
    }

    /* renamed from: a */
    private void m36369a(LonLat lonLat) {
        if (this.f48509b.size() >= 10) {
            this.f48509b.poll();
        }
        this.f48509b.add(lonLat);
    }

    /* renamed from: a */
    private LonLat m36368a(LocationServiceResponse locationServiceResponse) {
        List<location_info_t> list = locationServiceResponse.locations;
        location_info_t location_info_t = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).confidence > location_info_t.confidence) {
                location_info_t = list.get(i);
            }
        }
        return new LonLat(location_info_t.lon_gcj, location_info_t.lat_gcj);
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocBuffer$LonLat */
    class LonLat {
        double lat;
        double lon;

        public LonLat(double d, double d2) {
            this.lon = d;
            this.lat = d2;
        }
    }
}
