package com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.locator;

import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;
import com.didichuxing.bigdata.p174dp.locsdk.OSLocationWrapper;
import com.didichuxing.bigdata.p174dp.locsdk.trace.data.ETraceSource;
import com.didichuxing.bigdata.p174dp.locsdk.utils.ApolloProxy;
import com.didichuxing.bigdata.p174dp.locsdk.utils.Utils;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.locator.GoogleFusionFilter */
public class GoogleFusionFilter {

    /* renamed from: a */
    DIDILocation f48646a;

    /* renamed from: b */
    OSLocationWrapper f48647b;

    /* renamed from: c */
    DIDILocation f48648c;

    /* renamed from: d */
    DIDILocation f48649d;

    /* renamed from: e */
    private int f48650e = ApolloProxy.getInstance().getDataSourceFilterType();

    /* renamed from: f */
    private DIDILocation f48651f;

    public GoogleFusionFilter() {
        DLog.m36225d("fusion filter type = " + this.f48650e);
    }

    public DIDILocation getTargetLocation(DIDILocation dIDILocation, OSLocationWrapper oSLocationWrapper, DIDILocation dIDILocation2, DIDILocation dIDILocation3) {
        DIDILocation dIDILocation4;
        this.f48646a = dIDILocation;
        this.f48647b = oSLocationWrapper;
        this.f48648c = dIDILocation2;
        this.f48649d = dIDILocation3;
        int i = this.f48650e;
        if (i == 1) {
            dIDILocation4 = m36495b();
        } else if (i != 2) {
            dIDILocation4 = m36493a();
        } else {
            dIDILocation4 = m36496c();
        }
        this.f48651f = dIDILocation4;
        return dIDILocation4;
    }

    public void destroy() {
        this.f48650e = 0;
        this.f48651f = null;
        this.f48646a = null;
        this.f48647b = null;
        this.f48648c = null;
        this.f48649d = null;
    }

    /* renamed from: a */
    private DIDILocation m36493a() {
        DIDILocation dIDILocation = this.f48646a;
        if (dIDILocation != null) {
            return dIDILocation;
        }
        OSLocationWrapper oSLocationWrapper = this.f48647b;
        if (oSLocationWrapper != null) {
            return DIDILocation.loadFromSystemLoc(oSLocationWrapper, ETraceSource.nlp, Utils.getCoordinateType());
        }
        DIDILocation dIDILocation2 = this.f48648c;
        if (dIDILocation2 != null) {
            return dIDILocation2;
        }
        DIDILocation dIDILocation3 = this.f48649d;
        if (dIDILocation3 != null) {
            return dIDILocation3;
        }
        return null;
    }

    /* renamed from: b */
    private DIDILocation m36495b() {
        DIDILocation dIDILocation = this.f48646a;
        if (dIDILocation != null) {
            return dIDILocation;
        }
        DIDILocation dIDILocation2 = this.f48648c;
        if (dIDILocation2 != null) {
            return dIDILocation2;
        }
        OSLocationWrapper oSLocationWrapper = this.f48647b;
        if (oSLocationWrapper != null) {
            return DIDILocation.loadFromSystemLoc(oSLocationWrapper, ETraceSource.nlp, Utils.getCoordinateType());
        }
        DIDILocation dIDILocation3 = this.f48649d;
        if (dIDILocation3 != null) {
            return dIDILocation3;
        }
        return null;
    }

    /* renamed from: c */
    private DIDILocation m36496c() {
        if (this.f48646a != null) {
            return m36497d();
        }
        DIDILocation dIDILocation = this.f48648c;
        if (dIDILocation != null) {
            return dIDILocation;
        }
        OSLocationWrapper oSLocationWrapper = this.f48647b;
        if (oSLocationWrapper != null) {
            return DIDILocation.loadFromSystemLoc(oSLocationWrapper, ETraceSource.nlp, Utils.getCoordinateType());
        }
        DIDILocation dIDILocation2 = this.f48649d;
        if (dIDILocation2 != null) {
            return dIDILocation2;
        }
        return null;
    }

    /* renamed from: d */
    private DIDILocation m36497d() {
        DIDILocation dIDILocation;
        DIDILocation dIDILocation2 = this.f48646a;
        DLog.m36225d("try to replace cur gps = " + this.f48648c);
        DLog.m36225d("try last location = " + this.f48651f);
        if (this.f48651f == null || !ETraceSource.googleflp.toString().equals(this.f48651f.getSource()) || !m36494a(dIDILocation2, this.f48651f) || (dIDILocation = this.f48648c) == null || m36494a(dIDILocation2, dIDILocation)) {
            return dIDILocation2;
        }
        DLog.m36225d("replace googleFLP = " + dIDILocation2 + " gps = " + this.f48648c);
        return this.f48648c;
    }

    /* renamed from: a */
    private boolean m36494a(DIDILocation dIDILocation, DIDILocation dIDILocation2) {
        if (dIDILocation != null && dIDILocation2 != null && dIDILocation.getLatitude() == dIDILocation2.getLatitude() && dIDILocation.getLongitude() == dIDILocation2.getLongitude() && dIDILocation.getTime() == dIDILocation2.getTime()) {
            return true;
        }
        return false;
    }
}
