package com.didichuxing.bigdata.p174dp.locsdk.once;

import android.content.Context;
import android.os.SystemClock;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;
import com.didichuxing.bigdata.p174dp.locsdk.EvilTransform;
import com.didichuxing.bigdata.p174dp.locsdk.LocData;
import com.didichuxing.bigdata.p174dp.locsdk.once.LocDataDef;
import com.didichuxing.bigdata.p174dp.locsdk.once.util.ApolloProxy;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.DIDINetworkLocateProxy */
public class DIDINetworkLocateProxy {

    /* renamed from: a */
    static final String f48752a = "-DIDINetworkLocateProxy-";

    /* renamed from: b */
    private final Context f48753b;

    /* renamed from: c */
    private LocData f48754c = null;

    /* renamed from: d */
    private LocationServiceRequest f48755d = null;

    /* renamed from: e */
    private boolean f48756e = false;

    /* renamed from: f */
    private DIDILocation f48757f = null;

    /* renamed from: g */
    private String f48758g = null;

    /* renamed from: h */
    private int f48759h = 0;

    /* renamed from: i */
    private LocBuffer f48760i = new LocBuffer();

    /* renamed from: j */
    private boolean f48761j;

    DIDINetworkLocateProxy(Context context) {
        this.f48753b = context;
    }

    /* access modifiers changed from: protected */
    public LocData manage(DIDINLPRequester dIDINLPRequester, ErrInfo errInfo) {
        LocationServiceResponse locationServiceResponse;
        char c;
        LocData locData;
        ErrInfo errInfo2 = errInfo;
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        LocationServiceRequest requestData = dIDINLPRequester.getRequestData();
        this.f48756e = false;
        this.f48761j = false;
        LocData locData2 = this.f48754c;
        if (locData2 == null || this.f48759h == 0) {
            if (ApolloProxy.getInstance().isDidiNlpRequestRertyOptmEnabled()) {
                this.f48761j = m36609a(this.f48755d, requestData);
                DLog.m36225d("requestRertyOptmEnabled needRequest=" + this.f48761j);
            } else {
                this.f48761j = true;
            }
        } else if (locData2.accuracy > 200) {
            this.f48761j = true;
        } else if (m36609a(this.f48755d, requestData)) {
            this.f48761j = true;
        } else {
            DLog.m36225d("use cache");
        }
        if (this.f48761j) {
            if (((int) requestData.valid_flag) != ValidFlagEnum.invalid.ordinal()) {
                DLog.m36225d("req:\n" + requestData.toBamaiLog());
                locationServiceResponse = dIDINLPRequester.requestNetworkLocation(errInfo);
            } else {
                errInfo2.setErrNo(103);
                errInfo2.setErrMessage(ErrInfo.ERROR_MSG_NO_ELEMENT_FOR_LOCATION);
                locationServiceResponse = null;
            }
            if (locationServiceResponse == null || locationServiceResponse.ret_code != 0 || locationServiceResponse.locations == null || locationServiceResponse.locations.size() <= 0) {
                DLog.m36225d("req failed.");
                if (!(locationServiceResponse == null || locationServiceResponse.ret_code == 0)) {
                    OmegaSDKAdapter.trackEvent("locate_fail");
                }
            } else {
                DLog.m36225d("response\n" + locationServiceResponse.toJson());
            }
            LocationServiceResponse locationServiceResponse2 = !this.f48760i.isCompatible(locationServiceResponse) ? null : locationServiceResponse;
            this.f48755d = requestData;
            if (locationServiceResponse2 == null || locationServiceResponse2.ret_code != 0 || locationServiceResponse2.locations == null || locationServiceResponse2.locations.size() <= 0) {
                this.f48759h = 0;
                this.f48756e = true;
            } else {
                this.f48759h = 1;
            }
            ArrayList arrayList = new ArrayList();
            if (!(locationServiceResponse2 == null || locationServiceResponse2.locations == null)) {
                for (location_info_t next : locationServiceResponse2.locations) {
                    double d = next.lon_gcj;
                    double d2 = next.lat_gcj;
                    long j = elapsedRealtime;
                    long j2 = currentTimeMillis;
                    double d3 = next.confidence;
                    int i = (int) next.accuracy;
                    String str = next.confidence <= 1.0d ? DIDILocation.SOURCE_NLP_CELL : DIDILocation.SOURCE_NLP_WIFI;
                    int coordinateType = locationServiceResponse2.getCoordinateType();
                    LocationServiceResponse locationServiceResponse3 = locationServiceResponse2;
                    double d4 = d3;
                    location_info_t location_info_t = next;
                    LocData locData3 = r1;
                    long j3 = j;
                    ArrayList arrayList2 = arrayList;
                    long j4 = j2;
                    LocData locData4 = new LocData(d, d2, i, d4, 0, j2, j2, j3, str, coordinateType);
                    LocData locData5 = locData3;
                    locData5.setProvider(location_info_t.confidence <= 1.0d ? DIDILocation.CELL_PROVIDER : DIDILocation.WIFI_PROVIDER);
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(locData5);
                    elapsedRealtime = j3;
                    arrayList = arrayList3;
                    locationServiceResponse2 = locationServiceResponse3;
                    currentTimeMillis = j4;
                }
            }
            ArrayList arrayList4 = arrayList;
            DIDILocation dIDILocation = this.f48757f;
            char c2 = 2;
            char c3 = 3;
            if (!this.f48756e || dIDILocation == null) {
                c = 0;
            } else {
                LocData fromDIDILocation = LocData.fromDIDILocation(dIDILocation, 0.8d);
                fromDIDILocation.provider = DIDILocation.NLP_PROVIDER;
                arrayList4.add(fromDIDILocation);
                c = 0;
                this.f48758g = String.format(Locale.CHINA, "%.6f %.6f %d", new Object[]{Double.valueOf(dIDILocation.getLongitude()), Double.valueOf(dIDILocation.getLatitude()), Integer.valueOf((int) dIDILocation.getAccuracy())});
            }
            if (arrayList4.isEmpty()) {
                DLog.m36225d("-DIDINetworkLocateProxy-ret- null candidate locs");
                return null;
            }
            if (this.f48754c != null) {
                DLog.m36225d("-DIDINetworkLocateProxy- lastLocData=" + this.f48754c.toJson());
                ArrayList arrayList5 = new ArrayList();
                Iterator it = arrayList4.iterator();
                while (it.hasNext()) {
                    LocData locData6 = (LocData) it.next();
                    if (locData6.accuracy <= this.f48754c.accuracy * 10 || this.f48754c.accuracy <= 25) {
                        ArrayList arrayList6 = arrayList5;
                        double calcdistance = EvilTransform.calcdistance(this.f48754c.lonlat.lon, this.f48754c.lonlat.lat, locData6.lonlat.lon, locData6.lonlat.lat);
                        StringBuilder sb = new StringBuilder();
                        sb.append("-DIDINetworkLocateProxy- [");
                        Locale locale = Locale.CHINA;
                        Object[] objArr = new Object[5];
                        objArr[c] = Double.valueOf(this.f48754c.lonlat.lon);
                        objArr[1] = Double.valueOf(this.f48754c.lonlat.lat);
                        objArr[c2] = Double.valueOf(locData6.lonlat.lon);
                        objArr[c3] = Double.valueOf(locData6.lonlat.lat);
                        objArr[4] = Double.valueOf(calcdistance);
                        sb.append(String.format(locale, "%.6f,%.6f,%.6f,%.6f] dist=%.2f", objArr));
                        DLog.m36225d(sb.toString());
                        double d5 = ((double) (locData6.timestamp - this.f48754c.timestamp)) / 1000.0d;
                        double d6 = 0.0d;
                        if (calcdistance > 0.0d) {
                            d6 = calcdistance;
                        }
                        int i2 = (int) (d6 / d5);
                        double abs = 1.0d / ((double) (Math.abs(i2 - this.f48754c.speed) + 1));
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("-DIDINetworkLocateProxy- ");
                        Locale locale2 = Locale.CHINA;
                        Object[] objArr2 = new Object[5];
                        objArr2[c] = Double.valueOf(calcdistance);
                        objArr2[1] = Double.valueOf(d5);
                        objArr2[2] = Double.valueOf(d6);
                        objArr2[3] = Integer.valueOf(i2);
                        objArr2[4] = Double.valueOf(abs);
                        sb2.append(String.format(locale2, "dist=%.2f, timeinterval=%.1f, dist_fix=%.2f, speed=%d, transprob=%.3f", objArr2));
                        DLog.m36225d(sb2.toString());
                        locData6.speed = i2;
                        locData6.transprob = abs;
                        arrayList5 = arrayList6;
                        it = it;
                        c2 = 2;
                        c3 = 3;
                    } else {
                        arrayList5.add(locData6);
                        DLog.m36225d("-DIDINetworkLocateProxy- remove loc that too large accuracy");
                    }
                }
                arrayList4.removeAll(arrayList5);
            } else {
                DLog.m36225d("-DIDINetworkLocateProxy- lastLocData=null");
            }
            if (arrayList4.size() <= 0) {
                DLog.m36225d("locations is empty after remove.");
                return null;
            } else if (m36610a(arrayList4)) {
                LocData maxConfiLoc = Utils.getMaxConfiLoc(arrayList4);
                if (this.f48754c == null || maxConfiLoc.confidence >= this.f48754c.confidence) {
                    LocData locData7 = r3;
                    LocData locData8 = new LocData(maxConfiLoc.lonlat.lon, maxConfiLoc.lonlat.lat, maxConfiLoc.accuracy, maxConfiLoc.confidence, maxConfiLoc.speed, maxConfiLoc.timestamp, maxConfiLoc.localTime, maxConfiLoc.elapsedRealtime, maxConfiLoc.lonlat.source, maxConfiLoc.coordinateType);
                    LocData locData9 = locData7;
                    this.f48754c = locData9;
                    locData9.setProvider(maxConfiLoc.provider);
                    DLog.m36225d("-DIDINetworkLocateProxy- ret: in low transprob, first loc or cur confidence >= last's : ret=" + maxConfiLoc.toJson());
                    return maxConfiLoc;
                }
                DLog.m36225d("-DIDINetworkLocateProxy- ret: in low transprob, cur confidence < last's");
                LocData locData10 = this.f48754c;
                this.f48754c = null;
                return locData10;
            } else {
                if (this.f48754c == null) {
                    locData = Utils.getMaxConfiLoc(arrayList4);
                } else {
                    locData = Utils.getMaxConfiTransprobLoc(arrayList4);
                }
                double d7 = locData.lonlat.lon;
                LocData locData11 = locData;
                LocData locData12 = r2;
                LocData locData13 = new LocData(d7, locData.lonlat.lat, locData.accuracy, locData.confidence, locData.speed, locData.timestamp, locData.localTime, locData.elapsedRealtime, locData.lonlat.source, locData.coordinateType);
                this.f48754c = locData12;
                LocData locData14 = locData11;
                locData12.setProvider(locData14.provider);
                DLog.m36225d("-DIDINetworkLocateProxy- ret: " + locData14.toJson());
                return locData14;
            }
        } else {
            long j5 = elapsedRealtime;
            long j6 = currentTimeMillis;
            LocData locData15 = this.f48754c;
            if (locData15 == null) {
                return null;
            }
            long j7 = j6;
            locData15.timestamp = j7;
            this.f48754c.localTime = j7;
            this.f48754c.elapsedRealtime = j5;
            this.f48754c.setCache(false);
            return this.f48754c;
        }
    }

    /* access modifiers changed from: protected */
    public LocData generateLocCacheFromGps(DIDILocation dIDILocation) {
        double[] transform = EvilTransform.transform(dIDILocation.getLongitude(), dIDILocation.getLatitude());
        LocData locData = r1;
        LocData locData2 = new LocData(transform[0], transform[1], (int) dIDILocation.getAccuracy(), 2.0d, (int) dIDILocation.getSpeed(), dIDILocation.getTime(), dIDILocation.getLocalTime(), dIDILocation.getElapsedRealtime(), dIDILocation.getSource(), dIDILocation.getCoordinateType());
        locData.setProvider("gps");
        return locData;
    }

    /* access modifiers changed from: protected */
    public void cleanHistoryWithGps(DIDILocation dIDILocation) {
        cleanHistory(false);
        LocData generateLocCacheFromGps = generateLocCacheFromGps(dIDILocation);
        this.f48754c = generateLocCacheFromGps;
        generateLocCacheFromGps.setCache(true);
    }

    /* access modifiers changed from: protected */
    public void cleanHistory(boolean z) {
        this.f48754c = null;
        this.f48755d = null;
        if (!z) {
            this.f48760i.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setLastLoc(com.didichuxing.bigdata.p174dp.locsdk.DIDILocation r21) {
        /*
            r20 = this;
            java.lang.String r0 = r21.getProvider()
            int r1 = r0.hashCode()
            r2 = -509470367(0xffffffffe1a21961, float:-3.7377516E20)
            r3 = 1
            if (r1 == r2) goto L_0x001e
            r2 = 102570(0x190aa, float:1.43731E-40)
            if (r1 == r2) goto L_0x0014
            goto L_0x0028
        L_0x0014:
            java.lang.String r1 = "gps"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0028
            r0 = 0
            goto L_0x0029
        L_0x001e:
            java.lang.String r1 = "nlp_network"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0028
            r0 = 1
            goto L_0x0029
        L_0x0028:
            r0 = -1
        L_0x0029:
            r1 = 4605380978949069210(0x3fe999999999999a, double:0.8)
            if (r0 == 0) goto L_0x0043
            if (r0 == r3) goto L_0x0034
        L_0x0032:
            r9 = r1
            goto L_0x0046
        L_0x0034:
            java.lang.String r0 = com.didichuxing.bigdata.p174dp.locsdk.DIDILocation.SOURCE_GOOGLE_FLP
            java.lang.String r3 = r21.getSource()
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0032
            r1 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            goto L_0x0032
        L_0x0043:
            r1 = 4611686018427387904(0x4000000000000000, double:2.0)
            goto L_0x0032
        L_0x0046:
            com.didichuxing.bigdata.dp.locsdk.LocData r0 = new com.didichuxing.bigdata.dp.locsdk.LocData
            r3 = r0
            double r4 = r21.getLongitude()
            double r6 = r21.getLatitude()
            float r1 = r21.getAccuracy()
            int r8 = (int) r1
            float r1 = r21.getSpeed()
            int r11 = (int) r1
            long r12 = r21.getTime()
            long r14 = r21.getLocalTime()
            long r16 = r21.getElapsedRealtime()
            java.lang.String r18 = r21.getSource()
            int r19 = r21.getCoordinateType()
            r3.<init>(r4, r6, r8, r9, r11, r12, r14, r16, r18, r19)
            r1 = r20
            r1.f48754c = r0
            java.lang.String r2 = r21.getProvider()
            r0.setProvider(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.bigdata.p174dp.locsdk.once.DIDINetworkLocateProxy.setLastLoc(com.didichuxing.bigdata.dp.locsdk.DIDILocation):void");
    }

    /* access modifiers changed from: protected */
    public void setNlpLoc(DIDILocation dIDILocation) {
        this.f48757f = dIDILocation;
    }

    /* renamed from: a */
    private boolean m36610a(ArrayList<LocData> arrayList) {
        Iterator<LocData> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().transprob >= 0.02d) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m36609a(LocationServiceRequest locationServiceRequest, LocationServiceRequest locationServiceRequest2) {
        if (locationServiceRequest == null || locationServiceRequest2 == null) {
            return true;
        }
        List<LocDataDef.LocWifiInfo> list = locationServiceRequest.wifis;
        List<LocDataDef.LocWifiInfo> list2 = locationServiceRequest2.wifis;
        if (list == null || list2 == null || list.size() == 0 || list2.size() == 0) {
            return true;
        }
        int a = m36607a(list2, list);
        DLog.m36225d("-DIDINetworkLocateProxy- wifi size: " + list.size() + " -> " + list2.size() + " DIFF(" + a + ")");
        if (a >= 5) {
            return true;
        }
        double d = (double) a;
        if (d > ((double) list.size()) * 0.2d || d > ((double) list2.size()) * 0.2d) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private int m36607a(List<LocDataDef.LocWifiInfo> list, List<LocDataDef.LocWifiInfo> list2) {
        int i = 0;
        for (LocDataDef.LocWifiInfo a : list2) {
            if (m36608a(a, list)) {
                i++;
            }
        }
        return (list.size() + list2.size()) - (i * 2);
    }

    /* renamed from: a */
    private boolean m36608a(LocDataDef.LocWifiInfo locWifiInfo, List<LocDataDef.LocWifiInfo> list) {
        for (int i = 0; i < list.size(); i++) {
            if (locWifiInfo.mac.equals(list.get(i).mac)) {
                return true;
            }
        }
        return false;
    }
}
