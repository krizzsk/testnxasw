package com.didi.hawaii.p120ar.core.p121zg;

import android.content.Context;
import android.view.ViewGroup;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.hawaii.p120ar.core.CreateDiARNavViewException;
import com.didi.hawaii.p120ar.jni.AREngineJNI;
import com.didi.hawaii.p120ar.jni.DARCGPSData;
import com.didi.hawaii.p120ar.jni.DARCGeoPoint;
import com.didi.hawaii.p120ar.jni.DARCHTTPRequest;
import com.didi.hawaii.p120ar.jni.DARCMatrix4F;
import com.didi.hawaii.p120ar.jni.DARCNAVEDShowAlert;
import com.didi.hawaii.p120ar.jni.DARCNAVEDStatusChange;
import com.didi.hawaii.p120ar.jni.DARCNAVEvent;
import com.didi.hawaii.p120ar.jni.DARCPoint4F;
import com.didi.hawaii.p120ar.jni.DARCZGNavCreateData;
import com.didi.hawaii.p120ar.jni.DARCZGNavDistanceEvent;
import com.didi.hawaii.p120ar.jni.DARCZGNavEDDistanceChange;
import com.didi.hawaii.p120ar.jni.DARCZGNavEDGPSFusion;
import com.didi.hawaii.p120ar.jni.DARCZGNavEDGPSWeakChange;
import com.didi.hawaii.p120ar.jni.DARCZGNavEDStatusChange;
import com.didi.hawaii.p120ar.jni.DARCZGNavEvent;
import com.didi.hawaii.p120ar.jni.DARCZGNavStatus;
import com.didi.hawaii.p120ar.jni.DARCZGNavUpdateData;
import com.didi.hawaii.p120ar.jni.SwigARCallback;
import com.didi.hawaii.p120ar.utils.ARAPollo;
import com.didi.hawaii.p120ar.utils.ARCoreCheckerAndGenerator;
import com.didi.hawaii.p120ar.utils.AROmega;
import com.didi.hawaii.p120ar.utils.LocationUtil;
import com.didi.hawaii.p120ar.utils.SensorUtil;

/* renamed from: com.didi.hawaii.ar.core.zg.DiARZGNavController */
public class DiARZGNavController extends SwigARCallback implements LocationUtil.NotifyLocationListener, SensorUtil.SensorUtilListener {

    /* renamed from: e */
    private static final int f25371e = ARAPollo.getARNavVersion();

    /* renamed from: f */
    private static final boolean f25372f = ARAPollo.getZGUsePDR();

    /* renamed from: g */
    private static final int f25373g = ARAPollo.getDistanceArrived();

    /* renamed from: h */
    private static boolean f25374h = false;

    /* renamed from: i */
    private static final float f25375i = 45.0f;

    /* renamed from: j */
    private static final float f25376j = 0.1f;

    /* renamed from: k */
    private static final float f25377k = 1000.0f;

    /* renamed from: l */
    private static final int f25378l = 25;

    /* renamed from: m */
    private static final int f25379m = 6000;

    /* renamed from: n */
    private static final int f25380n = 30000;

    /* renamed from: o */
    private static final long f25381o = 30;

    /* renamed from: p */
    private static long f25382p = 0;

    /* renamed from: a */
    boolean f25383a = false;

    /* renamed from: b */
    int f25384b = -1;

    /* renamed from: c */
    boolean f25385c = false;

    /* renamed from: d */
    boolean f25386d = false;

    /* renamed from: q */
    private boolean f25387q = false;

    /* renamed from: r */
    private ZGGlobalUIManager f25388r = null;

    /* renamed from: s */
    private ZGGlobalMapManager f25389s = null;

    /* renamed from: t */
    private DARCMatrix4F f25390t = null;

    /* renamed from: u */
    private DiARZGEngineImpl f25391u = null;

    /* renamed from: v */
    private DARCGPSData f25392v = null;

    /* renamed from: w */
    private DARCZGNavUpdateData f25393w = null;

    /* renamed from: x */
    private DARCPoint4F f25394x = null;

    /* renamed from: y */
    private LatLng f25395y = null;

    /* renamed from: z */
    private boolean f25396z = false;

    public void LogHandler(String str) {
    }

    public void navigatorEvent(DARCNAVEvent dARCNAVEvent, DARCNAVEDShowAlert dARCNAVEDShowAlert) {
    }

    public void navigatorEvent(DARCNAVEvent dARCNAVEvent, DARCNAVEDStatusChange dARCNAVEDStatusChange) {
    }

    public void navigatorSendHTTPRequest(DARCHTTPRequest dARCHTTPRequest) {
    }

    public DiARZGNavController(Context context, ViewGroup viewGroup) throws CreateDiARNavViewException {
        DARCZGNavCreateData a = m20278a(viewGroup);
        if (a != null) {
            DiARZGEngineImpl diARZGEngineImpl = new DiARZGEngineImpl();
            this.f25391u = diARZGEngineImpl;
            diARZGEngineImpl.ARZGEngineCreate(a, context.getApplicationContext());
            this.f25391u.ARZGEngineSetCallbacks(this);
            DLog.m10773d("AR-ZG", "ARZGEngineCreate", new Object[0]);
        }
        this.f25393w = new DARCZGNavUpdateData();
        this.f25394x = new DARCPoint4F();
        ZGGlobalUIManager zGGlobalUIManager = new ZGGlobalUIManager(context, viewGroup, this.f25391u);
        this.f25388r = zGGlobalUIManager;
        ZGGlobalMapManager zGGlobalMapManager = new ZGGlobalMapManager(context, zGGlobalUIManager.getArcLayout(), !ArcLayout.disableclippath);
        this.f25389s = zGGlobalMapManager;
        LatLng latLng = this.f25395y;
        if (latLng != null) {
            zGGlobalMapManager.setDestLocation(new LatLng(latLng.latitude, this.f25395y.longitude));
        }
        this.f25390t = AREngineJNI.perspectiveFov((float) Math.toRadians(45.0d), this.f25388r.getWindowWidthDP(), this.f25388r.getWindowHeightDP(), 0.1f, f25377k);
    }

    /* renamed from: a */
    private DARCZGNavCreateData m20278a(ViewGroup viewGroup) throws CreateDiARNavViewException {
        try {
            if (ARCoreCheckerAndGenerator.cacheResponseData.getArRequestOption() == null) {
                return null;
            }
            DARCZGNavCreateData alloc = DARCZGNavCreateData.alloc();
            AREngineJNI.DARCZGNavCreateData_containerView_set(alloc, viewGroup);
            this.f25395y = new LatLng(ARCoreCheckerAndGenerator.cacheResponseData.getArRequestOption().getDestLocation().latitude, ARCoreCheckerAndGenerator.cacheResponseData.getArRequestOption().getDestLocation().longitude);
            DARCGeoPoint dARCGeoPoint = new DARCGeoPoint();
            dARCGeoPoint.setLat(this.f25395y.latitude);
            dARCGeoPoint.setLon(this.f25395y.longitude);
            alloc.setTrackSupport(false);
            alloc.setUsePDR(f25372f);
            alloc.setTargetPoint(dARCGeoPoint);
            alloc.setDistanceArrived(f25373g);
            return alloc;
        } catch (Exception e) {
            DLog.m10773d("buildZGNavCreateData", e.toString(), new Object[0]);
            throw new CreateDiARNavViewException();
        }
    }

    public void setUiManagerListener(ZGUIListener zGUIListener) {
        ZGGlobalUIManager zGGlobalUIManager = this.f25388r;
        if (zGGlobalUIManager != null) {
            zGGlobalUIManager.setListener(zGUIListener);
        }
    }

    public void checkInitialDistanceReachEnd() {
        int i;
        if (this.f25385c && (i = this.f25384b) >= 0 && !this.f25386d) {
            if (i > 25) {
                this.f25388r.onReachEnd(0);
            } else {
                this.f25388r.onReachEnd(6000);
            }
            this.f25386d = true;
            AROmega.zgMapARNavDirectArrive();
        }
    }

    public void onDriverArrived(String str) {
        ZGGlobalUIManager zGGlobalUIManager = this.f25388r;
        if (zGGlobalUIManager != null) {
            zGGlobalUIManager.onDriverArrived(str);
        }
    }

    public void navigatorZGEvent(DARCZGNavEvent dARCZGNavEvent, DARCZGNavEDGPSFusion dARCZGNavEDGPSFusion) {
        if (dARCZGNavEvent == DARCZGNavEvent.DARCZGNavEvent_FusionGPSPosUpdate) {
            this.f25392v = dARCZGNavEDGPSFusion.getGpsFusitionData();
        }
    }

    public void navigatorZGEvent(DARCZGNavEvent dARCZGNavEvent, DARCZGNavEDGPSWeakChange dARCZGNavEDGPSWeakChange) {
        if (dARCZGNavEvent == DARCZGNavEvent.DARCZGNavEvent_GPSWeakChanged) {
            this.f25388r.onGpsWeak(dARCZGNavEDGPSWeakChange.getIsWeak());
            if (dARCZGNavEDGPSWeakChange.getIsWeak()) {
                AROmega.zgMapARNavDirectGpsToast(LocationUtil.getCurLocation().latitude, LocationUtil.getCurLocation().longitude);
            }
        }
    }

    public void navigatorZGEvent(DARCZGNavEvent dARCZGNavEvent, DARCZGNavEDStatusChange dARCZGNavEDStatusChange) {
        if (dARCZGNavEvent == DARCZGNavEvent.DARCZGNavEvent_StatusChanged) {
            if (dARCZGNavEDStatusChange.getStatusTo() == DARCZGNavStatus.DARCZGNavStatus_ReachEnd) {
                this.f25385c = true;
                checkInitialDistanceReachEnd();
            }
            if ((dARCZGNavEDStatusChange.getStatusFrom() == DARCZGNavStatus.DARCZGNavStatus_Init && dARCZGNavEDStatusChange.getStatusTo() == DARCZGNavStatus.DARCZGNavStatus_Running) || dARCZGNavEDStatusChange.getStatusTo() == DARCZGNavStatus.DARCZGNavStatus_LocEnd) {
                AROmega.zgMapARNavDirectLocate();
            }
        }
    }

    public void navigatorZGEvent(DARCZGNavEvent dARCZGNavEvent, DARCZGNavEDDistanceChange dARCZGNavEDDistanceChange) {
        if (dARCZGNavEvent == DARCZGNavEvent.DARCZGNavEvent_DistanceEventChanged) {
            DARCZGNavDistanceEvent distanceStatusFrom = dARCZGNavEDDistanceChange.getDistanceStatusFrom();
            DARCZGNavDistanceEvent distanceStatusTo = dARCZGNavEDDistanceChange.getDistanceStatusTo();
            if (DARCZGNavDistanceEvent.DARCZGNavDistanceEvent_Invalid == distanceStatusFrom && DARCZGNavDistanceEvent.DARCZGNavDistanceEvent_InitialDistance == distanceStatusTo) {
                this.f25384b = dARCZGNavEDDistanceChange.getDistanceOfTarget();
                checkInitialDistanceReachEnd();
                AROmega.zgMapARNavDirectDistance((float) dARCZGNavEDDistanceChange.getDistanceOfTarget());
            } else if (DARCZGNavDistanceEvent.DARCZGNavDistanceEvent_MoreThan200Meter == distanceStatusFrom && DARCZGNavDistanceEvent.DARCZGNavDistanceEvent_LessThan200Meter == distanceStatusTo) {
                AROmega.zgMapARNavDirect200Distance();
            } else if (DARCZGNavDistanceEvent.DARCZGNavDistanceEvent_LessThan200Meter == distanceStatusFrom && DARCZGNavDistanceEvent.DARCZGNavDistanceEvent_LessThan100Meter == distanceStatusTo) {
                AROmega.zgMapARNavDirect100Distance();
            }
        }
    }

    public void onOrientationChanged(float f, float f2, float f3, float[] fArr) {
        boolean needShowBehindTips;
        ZGGlobalMapManager zGGlobalMapManager = this.f25389s;
        if (zGGlobalMapManager != null) {
            zGGlobalMapManager.onOrientationChanged(f3);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f25382p >= f25381o) {
            f25382p = currentTimeMillis;
            if (this.f25391u != null && this.f25383a) {
                try {
                    this.f25393w.setProjection(this.f25390t);
                    this.f25394x.setX(fArr[0]);
                    this.f25394x.setY(fArr[1]);
                    this.f25394x.setZ(fArr[2]);
                    this.f25394x.setW(fArr[3]);
                    this.f25393w.setArOriginTimeStamp(0.0d);
                    this.f25393w.setRotationVector(this.f25394x);
                    this.f25393w.setGpsData(LocationUtil.getCurLocation2DARCGPSData());
                    this.f25391u.updateZG(this.f25393w);
                    if (!(this.f25388r == null || (needShowBehindTips = this.f25391u.needShowBehindTips()) == this.f25387q)) {
                        this.f25388r.onBehindTipsMsg(needShowBehindTips);
                        this.f25387q = needShowBehindTips;
                    }
                    if (!f25374h) {
                        f25374h = true;
                        AROmega.zgMapARNavDirectEn();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    DLog.m10773d("updateZG", e.toString(), new Object[0]);
                }
            }
        }
    }

    public void activeZGNav() {
        this.f25383a = true;
        DiARZGEngineImpl diARZGEngineImpl = this.f25391u;
        if (diARZGEngineImpl != null) {
            diARZGEngineImpl.activeZG();
        }
        ZGGlobalUIManager zGGlobalUIManager = this.f25388r;
        if (zGGlobalUIManager != null) {
            zGGlobalUIManager.showSafeTips(30000);
        }
    }

    /* renamed from: a */
    private void m20279a() {
        this.f25383a = false;
        DiARZGEngineImpl diARZGEngineImpl = this.f25391u;
        if (diARZGEngineImpl != null) {
            diARZGEngineImpl.inactiveZG();
        }
    }

    public void onStart() {
        ZGGlobalMapManager zGGlobalMapManager = this.f25389s;
        if (zGGlobalMapManager != null) {
            zGGlobalMapManager.onStart();
        }
    }

    public void onRestart() {
        ZGGlobalMapManager zGGlobalMapManager = this.f25389s;
        if (zGGlobalMapManager != null) {
            zGGlobalMapManager.onRestart();
        }
    }

    public void onStop() {
        ZGGlobalMapManager zGGlobalMapManager = this.f25389s;
        if (zGGlobalMapManager != null) {
            zGGlobalMapManager.onStop();
        }
    }

    public void onResume() {
        ZGGlobalMapManager zGGlobalMapManager = this.f25389s;
        if (zGGlobalMapManager != null) {
            zGGlobalMapManager.onResume();
        }
    }

    public void onPause() {
        m20279a();
        ZGGlobalMapManager zGGlobalMapManager = this.f25389s;
        if (zGGlobalMapManager != null) {
            zGGlobalMapManager.onPause();
        }
    }

    public void onDestroy() {
        ZGGlobalUIManager zGGlobalUIManager = this.f25388r;
        if (zGGlobalUIManager != null) {
            zGGlobalUIManager.release();
        }
        DiARZGEngineImpl diARZGEngineImpl = this.f25391u;
        if (diARZGEngineImpl != null) {
            diARZGEngineImpl.destroyEngineContext();
            DLog.m10773d("AR-ZG", "ARZGEngineDestroy", new Object[0]);
        }
        ZGGlobalMapManager zGGlobalMapManager = this.f25389s;
        if (zGGlobalMapManager != null) {
            zGGlobalMapManager.onDestroy();
        }
    }

    public void onLocationChanged(LocationUtil.GpscurLocation gpscurLocation) {
        DiARZGEngineImpl diARZGEngineImpl = this.f25391u;
        if (diARZGEngineImpl != null) {
            diARZGEngineImpl.updateZGGPS(LocationUtil.getCurLocation2DARCGPSData());
        }
        ZGGlobalMapManager zGGlobalMapManager = this.f25389s;
        if (zGGlobalMapManager != null) {
            DARCGPSData dARCGPSData = this.f25392v;
            if (dARCGPSData != null) {
                zGGlobalMapManager.onLocationChanged(LocationUtil.DARCGPSData2Location(dARCGPSData));
            } else {
                zGGlobalMapManager.onLocationChanged(gpscurLocation);
            }
        }
    }
}
