package com.didi.map.global.sdk.movement.ble;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.common.sensor.OrientationListener;
import com.didi.common.sensor.OrientationManager;
import com.didi.map.global.sdk.movement.apollo.ApolloParamRssi2Distance;
import com.didi.map.global.sdk.movement.apollo.MovementApolloUtil;
import com.didi.map.global.sdk.movement.omega.MovementOmegaUtil;
import com.didi.map.global.sdk.movement.sensor.DidiMovementManager;
import com.didi.map.global.sdk.movement.sensor.Movement;
import com.didi.map.global.sdk.movement.sensor.PdrPoint;
import com.didi.map.global.sdk.movement.sensor.SMAHandler;
import com.didi.map.global.sdk.movement.sensor.WorkThread;
import com.didi.map.global.sdk.movement.sensor.onDidiMovementListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BlueToothEngine implements OrientationListener, iBluetoothNav {
    public static final int STATUS_ARRIVED = 12;
    public static final int STATUS_TOWARDS = 11;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final float f30166a = MovementApolloUtil.getEngineValidAcc();

    /* renamed from: b */
    private static final String f30167b = "BlueToothEngine";

    /* renamed from: c */
    private Context f30168c;

    /* renamed from: d */
    private onBleNavListener f30169d;

    /* renamed from: e */
    private WorkThread f30170e;

    /* renamed from: f */
    private long f30171f;

    /* renamed from: g */
    private float f30172g = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public PdrPoint f30173h;

    /* renamed from: i */
    private List<BluetoothPoint> f30174i;

    /* renamed from: j */
    private LocationInfo f30175j;

    /* renamed from: k */
    private LocationInfo f30176k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public PdrPoint[] f30177l;

    /* renamed from: m */
    private List<BluetoothPoint> f30178m;

    /* renamed from: n */
    private long f30179n;

    /* renamed from: o */
    private SMAHandler f30180o = new SMAHandler(5);

    /* renamed from: p */
    private CacheNavInfo f30181p;

    /* renamed from: q */
    private volatile int f30182q = 11;

    /* renamed from: r */
    private int f30183r;

    /* renamed from: s */
    private final String f30184s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public final Handler f30185t = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                BlueToothEngine.this.m23470a((CacheNavInfo) message.obj);
            }
        }
    };

    public static class CacheNavInfo {
        public BleNavGuide gps;
        public BleNavGuide normal;
        public BleNavGuide pdr;
        public boolean strong;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public float m23464a(double d) {
        return (float) ((d + 360.0d) % 360.0d);
    }

    public BlueToothEngine(Context context, String str) {
        DLog.m10773d(f30167b, "构造函数", new Object[0]);
        this.f30168c = context;
        this.f30184s = str;
        this.f30170e = new WorkThread();
        DidiMovementManager.getInstance(context).start(new onDidiMovementListener() {
            public void onMovementChanged(Movement movement) {
            }

            public void onNewStep(int i) {
            }

            public void onPrintLog(String str) {
            }

            public void onShowLine(float f) {
            }

            public void onPdrPointChanged(PdrPoint pdrPoint) {
                PdrPoint unused = BlueToothEngine.this.f30173h = pdrPoint;
            }
        });
        OrientationManager.getInstance(context).addOrientationListener(this);
    }

    public void onOrientationChanged(float f, float f2, float f3) {
        this.f30172g = m23464a((double) f);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23470a(CacheNavInfo cacheNavInfo) {
        if (cacheNavInfo == null) {
            return;
        }
        if (this.f30182q == 12) {
            DLog.m10773d(f30167b, "onNewBleNavGuide: 到达后直接返回", new Object[0]);
            return;
        }
        BleNavGuide bleNavGuide = null;
        if (cacheNavInfo.gps != null) {
            this.f30169d.onBleNavGuide(cacheNavInfo.gps);
            MovementOmegaUtil.reportOmegaBTNav(this.f30184s, cacheNavInfo, 0);
            BleNavGuide bleNavGuide2 = cacheNavInfo.gps;
            this.f30181p = null;
            DLog.m10773d(f30167b, "onNewBleNavGuide: 使用gps结果 " + cacheNavInfo.gps, new Object[0]);
            bleNavGuide = bleNavGuide2;
        } else if (cacheNavInfo.pdr != null) {
            this.f30169d.onBleNavGuide(cacheNavInfo.pdr);
            MovementOmegaUtil.reportOmegaBTNav(this.f30184s, cacheNavInfo, 1);
            this.f30181p = null;
            bleNavGuide = cacheNavInfo.pdr;
            DLog.m10773d(f30167b, "onNewBleNavGuide: 使用pdr结果 " + cacheNavInfo.pdr, new Object[0]);
        } else if (cacheNavInfo.normal != null) {
            CacheNavInfo cacheNavInfo2 = this.f30181p;
            if (!(cacheNavInfo2 == null || cacheNavInfo2.normal == null)) {
                double a = m23462a((double) cacheNavInfo.normal.direct_pax_toDriver, (double) this.f30181p.normal.direct_pax_toDriver);
                DLog.m10773d(f30167b, "onNewBleNavGuide: 判断是否使用结果diff：" + a, new Object[0]);
                if (a < 30.0d) {
                    BleNavGuide bleNavGuide3 = cacheNavInfo.normal;
                    this.f30169d.onBleNavGuide(cacheNavInfo.normal);
                    MovementOmegaUtil.reportOmegaBTNav(this.f30184s, cacheNavInfo, 2);
                    bleNavGuide = bleNavGuide3;
                }
            }
            this.f30181p = cacheNavInfo;
        }
        if (bleNavGuide != null) {
            if (bleNavGuide.eda < 5.0d) {
                this.f30183r++;
            } else {
                this.f30183r = 0;
            }
        }
        if (this.f30183r > 2 && bleNavGuide != null) {
            this.f30182q = 12;
            DLog.m10773d(f30167b, "onNewBleNavGuide: 已到达", new Object[0]);
            onBleNavListener onblenavlistener = this.f30169d;
            if (onblenavlistener != null) {
                onblenavlistener.onNavArrived((int) bleNavGuide.eda);
            }
        }
    }

    public void setOnBleNavListener(onBleNavListener onblenavlistener) {
        this.f30169d = onblenavlistener;
    }

    public void onReceiveDriverLocation(LocationInfo locationInfo) {
        this.f30175j = locationInfo;
    }

    public void onReceivePaxLocation(LocationInfo locationInfo) {
        this.f30176k = locationInfo;
    }

    public void onReceiveRssi(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f30174i == null || this.f30178m == null) {
            this.f30174i = new ArrayList();
            this.f30178m = new ArrayList();
        }
        this.f30178m.add(new BluetoothPoint(i, this.f30172g, currentTimeMillis, this.f30175j, this.f30176k, this.f30173h));
        if (currentTimeMillis - this.f30179n > 1000) {
            this.f30179n = currentTimeMillis;
            this.f30174i.addAll(m23469a(this.f30178m));
            this.f30178m.clear();
            if (this.f30174i.size() > 30) {
                List<BluetoothPoint> list = this.f30174i;
                list.subList(0, list.size() - 30).clear();
            }
        }
        if (currentTimeMillis - this.f30171f > 3000) {
            this.f30171f = currentTimeMillis;
            this.f30170e.executeTask(new NavTask(this.f30174i));
        }
    }

    public void onDestroy() {
        DLog.m10773d(f30167b, "onDestroy ", new Object[0]);
        Context context = this.f30168c;
        if (context != null) {
            DidiMovementManager.getInstance(context).stop();
            OrientationManager.getInstance(this.f30168c).removeOrientationListener(this);
            this.f30168c = null;
        }
        WorkThread workThread = this.f30170e;
        if (workThread != null) {
            workThread.destroy();
            this.f30170e = null;
        }
        SMAHandler sMAHandler = this.f30180o;
        if (sMAHandler != null) {
            sMAHandler.destroy();
            this.f30180o = null;
        }
    }

    public class NavTask implements Runnable {
        private final List<BluetoothPoint> list;

        public NavTask(List<BluetoothPoint> list2) {
            this.list = new ArrayList(list2);
        }

        public void run() {
            PdrPoint[] driverPoint;
            DLog.m10773d(BlueToothEngine.f30167b, "NavTask run!!!!!    " + hashCode(), new Object[0]);
            if (this.list.size() >= 2) {
                LocationInfo locationInfo = null;
                LocationInfo locationInfo2 = null;
                BluetoothPoint bluetoothPoint = null;
                BluetoothPoint bluetoothPoint2 = null;
                for (int size = this.list.size() - 1; size > 0; size--) {
                    BluetoothPoint bluetoothPoint3 = this.list.get(size);
                    if (!(bluetoothPoint3 == null || bluetoothPoint3.point == null)) {
                        if (bluetoothPoint == null || bluetoothPoint2 == null) {
                            bluetoothPoint = bluetoothPoint3;
                            bluetoothPoint2 = bluetoothPoint;
                        } else {
                            if (bluetoothPoint3.rssi > bluetoothPoint2.rssi) {
                                bluetoothPoint2 = bluetoothPoint3;
                            }
                            if (bluetoothPoint3.rssi < bluetoothPoint.rssi) {
                                bluetoothPoint = bluetoothPoint3;
                            }
                        }
                    }
                    if (bluetoothPoint3 != null && locationInfo == null && bluetoothPoint3.driverLoc != null && bluetoothPoint3.driverLoc.isAvailable()) {
                        locationInfo = bluetoothPoint3.driverLoc;
                    }
                    if (bluetoothPoint3 != null && locationInfo2 == null && bluetoothPoint3.paxLoc != null && bluetoothPoint3.paxLoc.isAvailable()) {
                        locationInfo2 = bluetoothPoint3.paxLoc;
                    }
                }
                CacheNavInfo cacheNavInfo = new CacheNavInfo();
                if (locationInfo != null && locationInfo.isAvailable() && locationInfo2 != null && locationInfo2.isAvailable()) {
                    BleNavGuide bleNavGuide = new BleNavGuide();
                    bleNavGuide.eda = DDSphericalUtil.computeDistanceBetween(locationInfo2.pos, locationInfo.pos);
                    bleNavGuide.direct_pax_toDriver = BlueToothEngine.this.m23464a(DDSphericalUtil.computeHeading(locationInfo2.pos, locationInfo.pos));
                    bleNavGuide.type = 0;
                    cacheNavInfo.gps = bleNavGuide;
                }
                if (!(bluetoothPoint2 == null || bluetoothPoint == null || Math.abs(bluetoothPoint2.rssi - bluetoothPoint.rssi) <= 0)) {
                    double a = (double) BlueToothEngine.this.m23464a((double) PdrPoint.getDirectBetweenPoints(bluetoothPoint.point, bluetoothPoint2.point));
                    double distanceBetweenPoints = (double) PdrPoint.getDistanceBetweenPoints(bluetoothPoint2.point, bluetoothPoint.point);
                    if (bluetoothPoint2.paxLoc != null && bluetoothPoint2.paxLoc.isAvailable() && bluetoothPoint.paxLoc != null && bluetoothPoint.paxLoc.isAvailable()) {
                        a = DDSphericalUtil.computeHeading(bluetoothPoint.paxLoc.pos, bluetoothPoint.paxLoc.pos);
                        distanceBetweenPoints = DDSphericalUtil.computeDistanceBetween(bluetoothPoint.paxLoc.pos, bluetoothPoint.paxLoc.pos);
                    }
                    double d = distanceBetweenPoints;
                    double d2 = a;
                    boolean z = bluetoothPoint2.time > bluetoothPoint.time || bluetoothPoint.time <= bluetoothPoint2.time;
                    cacheNavInfo.strong = z;
                    boolean z2 = !Double.isNaN(d) && d > 0.001d && !Double.isNaN(d2);
                    if (z2) {
                        BleNavGuide bleNavGuide2 = new BleNavGuide();
                        bleNavGuide2.direct_pax_toDriver = BlueToothEngine.this.m23464a(d2);
                        bleNavGuide2.eda = (double) BlueToothEngine.this.m23465a(z ? bluetoothPoint2.rssi : bluetoothPoint.rssi);
                        bleNavGuide2.type = 2;
                        cacheNavInfo.normal = bleNavGuide2;
                    }
                    if (z2 && (driverPoint = getDriverPoint(bluetoothPoint2.point, BlueToothEngine.this.m23465a(bluetoothPoint.rssi), BlueToothEngine.this.m23465a(bluetoothPoint2.rssi), d, d2)) != null) {
                        PdrPoint mergeNavInfo = mergeNavInfo(BlueToothEngine.this.f30177l, driverPoint);
                        PdrPoint[] unused = BlueToothEngine.this.f30177l = driverPoint;
                        if (mergeNavInfo != null) {
                            float directBetweenPoints = PdrPoint.getDirectBetweenPoints(bluetoothPoint2.point, mergeNavInfo);
                            BleNavGuide bleNavGuide3 = new BleNavGuide();
                            bleNavGuide3.direct_pax_toDriver = BlueToothEngine.this.m23464a((double) directBetweenPoints);
                            bleNavGuide3.eda = (double) BlueToothEngine.this.m23465a(z ? bluetoothPoint2.rssi : bluetoothPoint.rssi);
                            bleNavGuide3.type = 1;
                            cacheNavInfo.pdr = bleNavGuide3;
                        }
                    }
                }
                callBack(cacheNavInfo);
            }
        }

        private PdrPoint mergeNavInfo(PdrPoint[] pdrPointArr, PdrPoint[] pdrPointArr2) {
            if (pdrPointArr == null || pdrPointArr2 == null || pdrPointArr.length != 2 || pdrPointArr2.length != 2) {
                return null;
            }
            float distanceBetweenPoints = PdrPoint.getDistanceBetweenPoints(pdrPointArr[0], pdrPointArr2[0]);
            float distanceBetweenPoints2 = PdrPoint.getDistanceBetweenPoints(pdrPointArr[0], pdrPointArr2[1]);
            float distanceBetweenPoints3 = PdrPoint.getDistanceBetweenPoints(pdrPointArr[1], pdrPointArr2[0]);
            float distanceBetweenPoints4 = PdrPoint.getDistanceBetweenPoints(pdrPointArr[1], pdrPointArr2[1]);
            float min = Math.min(Math.min(Math.min(distanceBetweenPoints, distanceBetweenPoints2), distanceBetweenPoints3), distanceBetweenPoints4);
            if (min >= 20.0f) {
                return null;
            }
            if (min == distanceBetweenPoints || min == distanceBetweenPoints3) {
                return pdrPointArr2[0];
            }
            if (min == distanceBetweenPoints2 || min == distanceBetweenPoints4) {
                return pdrPointArr2[1];
            }
            return null;
        }

        private PdrPoint[] getDriverPoint(PdrPoint pdrPoint, float f, float f2, double d, double d2) {
            if (!BlueToothEngine.this.m23472a((double) f, (double) f2, d)) {
                return null;
            }
            double d3 = ((((double) (f * f)) + (d * d)) - ((double) (f2 * f2))) / (((double) (2.0f * f)) * d);
            if (d3 < -1.0d || d3 > 1.0d) {
                return null;
            }
            double degrees = (double) ((float) Math.toDegrees(Math.acos(d3)));
            return new PdrPoint[]{PdrPoint.getNextPoint(pdrPoint, f, BlueToothEngine.this.m23464a((d2 + 180.0d) - degrees)), PdrPoint.getNextPoint(pdrPoint, f, BlueToothEngine.this.m23464a((d2 - 180.0d) + degrees))};
        }

        private void callBack(CacheNavInfo cacheNavInfo) {
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.obj = cacheNavInfo;
            BlueToothEngine.this.f30185t.sendMessage(obtain);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public float m23465a(int i) {
        int abs = Math.abs(i);
        ApolloParamRssi2Distance apolloParamRssi2Distance = MovementApolloUtil.getApolloParamRssi2Distance();
        return (float) Math.pow(10.0d, (((double) abs) - apolloParamRssi2Distance.A_Value) / (apolloParamRssi2Distance.n_Value * 10.0d));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m23472a(double d, double d2, double d3) {
        return !Double.isNaN(d) && !Double.isNaN(d2) && !Double.isNaN(d3) && d + d2 > d3 && d + d3 > d2 && d2 + d3 > d;
    }

    /* renamed from: a */
    private double m23462a(double d, double d2) {
        double abs = Math.abs(d - d2);
        return abs > 180.0d ? 360.0d - abs : abs;
    }

    public static class LocationInfo {
        public float acc;
        public LatLng pos;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LocationInfo :");
            LatLng latLng = this.pos;
            sb.append(latLng == null ? "pos= null" : latLng.toString());
            sb.append(", acc =");
            sb.append(this.acc);
            return sb.toString();
        }

        public boolean isAvailable() {
            return LatLngUtils.locateCorrect(this.pos) && this.acc <= BlueToothEngine.f30166a;
        }
    }

    /* renamed from: a */
    private List<BluetoothPoint> m23469a(List<BluetoothPoint> list) {
        if (CollectionUtil.isEmpty((Collection<?>) list) || list.size() < 2) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        double b = (double) m23476b(list);
        double d = 0.0d;
        for (BluetoothPoint next : list) {
            if (next != null) {
                d += (((double) next.rssi) - b) * (((double) next.rssi) - b);
            }
        }
        double sqrt = Math.sqrt(d / ((double) (list.size() - 1)));
        for (BluetoothPoint next2 : list) {
            if (this.f30180o != null && next2 != null && ((double) next2.rssi) <= b + sqrt && ((double) next2.rssi) >= b - sqrt) {
                next2.rssi = (int) this.f30180o.handleValues((float) next2.rssi);
                arrayList.add(next2);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private int m23476b(List<BluetoothPoint> list) {
        int i = 0;
        for (BluetoothPoint bluetoothPoint : list) {
            i += bluetoothPoint.rssi;
        }
        return i / list.size();
    }
}
