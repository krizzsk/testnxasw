package com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.filter;

import android.content.Context;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;
import com.didichuxing.bigdata.p174dp.locsdk.OSLocationWrapper;
import com.didichuxing.bigdata.p174dp.locsdk.trace.data.ETraceSource;
import com.didichuxing.bigdata.p174dp.locsdk.utils.Utils;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.filter.AccTimeFilter */
public class AccTimeFilter {

    /* renamed from: a */
    private static final String f48594a = "AccTimeFilter| ";

    /* renamed from: A */
    private float f48595A = 1.0f;

    /* renamed from: b */
    private IAccTimeTracker f48596b;

    /* renamed from: c */
    private String f48597c = "";

    /* renamed from: d */
    private DIDILocation f48598d;

    /* renamed from: e */
    private DIDILocation f48599e;

    /* renamed from: f */
    private DIDILocation f48600f;

    /* renamed from: g */
    private OSLocationWrapper f48601g;

    /* renamed from: h */
    private DIDILocation f48602h;

    /* renamed from: i */
    private float f48603i = 0.0f;

    /* renamed from: j */
    private float f48604j = 0.0f;

    /* renamed from: k */
    private float f48605k = 0.0f;

    /* renamed from: l */
    private float f48606l = 0.0f;

    /* renamed from: m */
    private float f48607m = 0.0f;

    /* renamed from: n */
    private float f48608n = 0.0f;

    /* renamed from: o */
    private float f48609o = 0.0f;

    /* renamed from: p */
    private float f48610p = 0.0f;

    /* renamed from: q */
    private float f48611q = 0.0f;

    /* renamed from: r */
    private float f48612r = 0.0f;

    /* renamed from: s */
    private float f48613s = 0.0f;

    /* renamed from: t */
    private float f48614t = 0.0f;

    /* renamed from: u */
    private float f48615u = 0.0f;

    /* renamed from: v */
    private float f48616v = 0.0f;

    /* renamed from: w */
    private long f48617w = 1;

    /* renamed from: x */
    private boolean f48618x = false;

    /* renamed from: y */
    private float f48619y = 0.0f;

    /* renamed from: z */
    private float f48620z = 1.0f;

    /* renamed from: a */
    private long m36475a(long j, long j2) {
        int i;
        if (j == 0 || j2 == 0 || j < j2) {
            return -1;
        }
        if (i == 0) {
            return 1;
        }
        return j - j2;
    }

    /* renamed from: a */
    private String m36477a(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "unknown" : "lastgps" : "nlp" : "gps" : "flp";
    }

    public AccTimeFilter(Context context) {
        this.f48596b = new AccTimeTracker(context);
    }

    public DIDILocation getTargetLocation(DIDILocation dIDILocation, OSLocationWrapper oSLocationWrapper, DIDILocation dIDILocation2, DIDILocation dIDILocation3) {
        try {
            this.f48599e = dIDILocation;
            this.f48601g = oSLocationWrapper;
            this.f48600f = dIDILocation2;
            this.f48602h = dIDILocation3;
            this.f48597c = "unknown";
            this.f48598d = m36476a();
            if (this.f48596b != null) {
                this.f48596b.startTracking();
                this.f48596b.updateNotifiedLocation(this.f48598d, this.f48597c);
            }
            return this.f48598d;
        } catch (Exception e) {
            DLog.m36225d("AccTimeFilter| exp: " + e.getLocalizedMessage());
            return null;
        }
    }

    /* renamed from: a */
    private DIDILocation m36476a() {
        m36478b();
        m36479c();
        m36480d();
        m36481e();
        m36482f();
        return m36483g();
    }

    /* renamed from: b */
    private void m36478b() {
        this.f48605k = AccTimeFilterHelper.getInstance().f48622a;
        this.f48606l = AccTimeFilterHelper.getInstance().f48623b;
        this.f48607m = AccTimeFilterHelper.getInstance().f48624c;
        this.f48608n = AccTimeFilterHelper.getInstance().f48625d;
        this.f48619y = AccTimeFilterHelper.getInstance().f48628g;
        this.f48620z = AccTimeFilterHelper.getInstance().f48626e;
        this.f48595A = AccTimeFilterHelper.getInstance().f48627f;
        this.f48603i = 0.0f;
        this.f48604j = 0.0f;
        this.f48609o = 0.0f;
        this.f48610p = 0.0f;
        this.f48611q = 0.0f;
        this.f48612r = 0.0f;
        this.f48613s = 0.0f;
        this.f48614t = 0.0f;
        this.f48615u = 0.0f;
        this.f48616v = 0.0f;
        this.f48618x = false;
    }

    /* renamed from: c */
    private void m36479c() {
        this.f48617w = System.currentTimeMillis();
        DIDILocation dIDILocation = this.f48599e;
        if (dIDILocation != null) {
            if (dIDILocation.getAccuracy() > 0.0f) {
                this.f48603i += 1.0f / this.f48599e.getAccuracy();
            }
            long a = m36475a(this.f48617w, this.f48599e.getLocalTime());
            if (a > 0) {
                this.f48604j += 1.0f / ((float) a);
            }
        }
        DIDILocation dIDILocation2 = this.f48600f;
        if (dIDILocation2 != null) {
            if (dIDILocation2.getAccuracy() > 0.0f) {
                this.f48603i += 1.0f / this.f48600f.getAccuracy();
            }
            long a2 = m36475a(this.f48617w, this.f48600f.getLocalTime());
            if (a2 > 0) {
                this.f48604j += 1.0f / ((float) a2);
            }
        }
        OSLocationWrapper oSLocationWrapper = this.f48601g;
        if (!(oSLocationWrapper == null || oSLocationWrapper.getLocation() == null)) {
            if (this.f48601g.getLocation().getAccuracy() > 0.0f) {
                this.f48603i += 1.0f / this.f48601g.getLocation().getAccuracy();
            }
            long a3 = m36475a(this.f48617w, this.f48601g.getLocalTime());
            if (a3 > 0) {
                this.f48604j += 1.0f / ((float) a3);
            }
        }
        DIDILocation dIDILocation3 = this.f48602h;
        if (dIDILocation3 != null) {
            if (dIDILocation3.getAccuracy() > 0.0f) {
                this.f48603i += 1.0f / this.f48602h.getAccuracy();
            }
            long a4 = m36475a(this.f48617w, this.f48602h.getLocalTime());
            if (a4 > 0) {
                this.f48604j += 1.0f / ((float) a4);
            }
        }
    }

    /* renamed from: d */
    private void m36480d() {
        if (this.f48604j != 0.0f) {
            DIDILocation dIDILocation = this.f48599e;
            if (dIDILocation != null && dIDILocation.getAccuracy() > 0.0f) {
                this.f48609o = (1.0f / this.f48599e.getAccuracy()) / this.f48603i;
            }
            DIDILocation dIDILocation2 = this.f48600f;
            if (dIDILocation2 != null && dIDILocation2.getAccuracy() > 0.0f) {
                this.f48610p = (1.0f / this.f48600f.getAccuracy()) / this.f48603i;
            }
            OSLocationWrapper oSLocationWrapper = this.f48601g;
            if (!(oSLocationWrapper == null || oSLocationWrapper.getLocation() == null || this.f48601g.getLocation().getAccuracy() <= 0.0f)) {
                this.f48611q = (1.0f / this.f48601g.getLocation().getAccuracy()) / this.f48603i;
            }
            DIDILocation dIDILocation3 = this.f48602h;
            if (dIDILocation3 != null && dIDILocation3.getAccuracy() > 0.0f) {
                this.f48612r = (1.0f / this.f48602h.getAccuracy()) / this.f48603i;
            }
        }
    }

    /* renamed from: e */
    private void m36481e() {
        if (this.f48604j != 0.0f) {
            DIDILocation dIDILocation = this.f48599e;
            if (dIDILocation != null) {
                long a = m36475a(this.f48617w, dIDILocation.getLocalTime());
                if (a > 0) {
                    this.f48613s = (1.0f / ((float) a)) / this.f48604j;
                }
            }
            DIDILocation dIDILocation2 = this.f48600f;
            if (dIDILocation2 != null) {
                long a2 = m36475a(this.f48617w, dIDILocation2.getLocalTime());
                if (a2 > 0) {
                    this.f48614t = (1.0f / ((float) a2)) / this.f48604j;
                }
            }
            OSLocationWrapper oSLocationWrapper = this.f48601g;
            if (oSLocationWrapper != null) {
                long a3 = m36475a(this.f48617w, oSLocationWrapper.getLocalTime());
                if (a3 > 0) {
                    this.f48615u = (1.0f / ((float) a3)) / this.f48604j;
                }
            }
            DIDILocation dIDILocation3 = this.f48602h;
            if (dIDILocation3 != null) {
                long a4 = m36475a(this.f48617w, dIDILocation3.getLocalTime());
                if (a4 > 0) {
                    this.f48616v = (1.0f / ((float) a4)) / this.f48604j;
                }
            }
        }
    }

    /* renamed from: f */
    private void m36482f() {
        this.f48618x = AccTimeFilterHelper.getInstance().isFewSatellite();
    }

    /* renamed from: g */
    private DIDILocation m36483g() {
        float f = this.f48605k;
        float f2 = this.f48609o;
        float f3 = this.f48620z;
        float f4 = f + (f2 * f3);
        float f5 = this.f48613s;
        float f6 = this.f48595A;
        this.f48605k = f4 + (f5 * f6);
        this.f48606l = this.f48606l + (this.f48610p * f3) + (this.f48614t * f6);
        this.f48607m = this.f48607m + (this.f48611q * f3) + (this.f48615u * f6);
        this.f48608n = this.f48608n + (this.f48612r * f3) + (this.f48616v * f6);
        float f7 = 0.0f;
        if (this.f48599e == null) {
            this.f48605k = 0.0f;
        }
        if (this.f48600f == null) {
            this.f48606l = 0.0f;
        }
        if (this.f48601g == null) {
            this.f48607m = 0.0f;
        }
        if (this.f48602h == null) {
            this.f48608n = 0.0f;
        }
        float f8 = this.f48605k;
        float f9 = this.f48606l;
        if (f8 == f9) {
            float f10 = this.f48607m;
            if (f9 == f10 && f10 == this.f48608n) {
                DIDILocation dIDILocation = this.f48599e;
                if (dIDILocation != null) {
                    this.f48597c = "flp";
                    return dIDILocation;
                }
                DIDILocation dIDILocation2 = this.f48600f;
                if (dIDILocation2 != null) {
                    this.f48597c = "gps";
                    return dIDILocation2;
                }
                OSLocationWrapper oSLocationWrapper = this.f48601g;
                if (oSLocationWrapper != null) {
                    this.f48597c = "nlp";
                    return DIDILocation.loadFromSystemLoc(oSLocationWrapper, ETraceSource.nlp, Utils.getCoordinateType());
                }
                DIDILocation dIDILocation3 = this.f48602h;
                if (dIDILocation3 != null) {
                    this.f48597c = "lastgps";
                    return dIDILocation3;
                }
                DLog.m36225d("AccTimeFilter| all null");
                return null;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new LocType(1, this.f48605k));
        float f11 = this.f48606l - this.f48619y;
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        if (!this.f48618x) {
            f11 = this.f48606l;
        }
        arrayList.add(new LocType(2, f11));
        arrayList.add(new LocType(3, this.f48607m));
        float f12 = this.f48608n - this.f48619y;
        if (f12 >= 0.0f) {
            f7 = f12;
        }
        if (!this.f48618x) {
            f7 = this.f48608n;
        }
        arrayList.add(new LocType(4, f7));
        Collections.sort(arrayList, $$Lambda$AccTimeFilter$VETMnhGHp2BiRW50ZvNHzCehoAQ.INSTANCE);
        int i = ((LocType) arrayList.get(0)).type;
        this.f48597c = m36477a(i);
        if (i == 1) {
            return this.f48599e;
        }
        if (i == 2) {
            return this.f48600f;
        }
        if (i == 3) {
            return DIDILocation.loadFromSystemLoc(this.f48601g, ETraceSource.nlp, Utils.getCoordinateType());
        }
        if (i != 4) {
            return null;
        }
        return this.f48602h;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ int m36474a(LocType locType, LocType locType2) {
        return (int) ((locType2.score * 100000.0f) - (locType.score * 100000.0f));
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.filter.AccTimeFilter$LocType */
    private static class LocType {
        static final int flp = 1;
        static final int gps = 2;
        static final int last_gps = 4;
        static final int os_nlp = 3;
        float score;
        int type;

        LocType(int i, float f) {
            this.type = i;
            this.score = f;
        }
    }

    /* renamed from: h */
    private void m36484h() {
        DLog.m36225d("AccTimeFilter| 以下为此次参与对比的位置信息");
        if (this.f48599e != null) {
            DLog.m36225d("AccTimeFilter| info flp: " + this.f48599e.toString());
        }
        if (this.f48600f != null) {
            DLog.m36225d("AccTimeFilter| info gps: " + this.f48600f.toString());
        }
        if (this.f48601g != null) {
            DLog.m36225d("AccTimeFilter| info nlp: " + this.f48601g.info());
        }
        if (this.f48602h != null) {
            DLog.m36225d("AccTimeFilter| info last gps: " + this.f48602h.toString());
        }
    }

    public void destroy() {
        this.f48597c = "unknown";
        this.f48598d = null;
        IAccTimeTracker iAccTimeTracker = this.f48596b;
        if (iAccTimeTracker != null) {
            iAccTimeTracker.stopTracking();
        }
    }
}
