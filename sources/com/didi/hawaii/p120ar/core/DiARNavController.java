package com.didi.hawaii.p120ar.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.didi.hawaii.p120ar.core.AlertUiManager;
import com.didi.hawaii.p120ar.jni.AREngineJNI;
import com.didi.hawaii.p120ar.jni.DARCAlert;
import com.didi.hawaii.p120ar.jni.DARCHTTPRequest;
import com.didi.hawaii.p120ar.jni.DARCHTTPResponse;
import com.didi.hawaii.p120ar.jni.DARCLocationInScene;
import com.didi.hawaii.p120ar.jni.DARCNAVCreateData;
import com.didi.hawaii.p120ar.jni.DARCNAVEDShowAlert;
import com.didi.hawaii.p120ar.jni.DARCNAVEDStatusChange;
import com.didi.hawaii.p120ar.jni.DARCNAVEvent;
import com.didi.hawaii.p120ar.jni.DARCNAVStatus;
import com.didi.hawaii.p120ar.jni.DARCObject;
import com.didi.hawaii.p120ar.jni.DARCPointF;
import com.didi.hawaii.p120ar.jni.SwigARCallback;
import com.didi.hawaii.p120ar.utils.ARNavGlobal;
import com.didi.hawaii.p120ar.utils.AROmega;
import com.didi.hawaii.p120ar.utils.ARRequestUtil;
import com.didi.hawaii.p120ar.view.ARGlView;
import java.util.HashMap;

/* renamed from: com.didi.hawaii.ar.core.DiARNavController */
public class DiARNavController extends SwigARCallback implements ARGlView.LifeCycleCallback {

    /* renamed from: a */
    private static final String f25273a = DiARNavController.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Handler f25274b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private DiARNavManager f25275c = null;

    /* renamed from: d */
    private NetWorkerManager f25276d = null;

    /* renamed from: e */
    private ScenceManager f25277e = null;

    /* renamed from: f */
    private RenderManager f25278f = null;

    /* renamed from: g */
    private AlertUiManager f25279g = null;

    /* renamed from: h */
    private Context f25280h;

    /* renamed from: i */
    private DARCNAVStatus f25281i = DARCNAVStatus.DARCNAVStatus_Init;

    /* renamed from: j */
    private long f25282j = 0;

    /* access modifiers changed from: protected */
    public void LogHandler(String str) {
    }

    public DiARNavController(DARCNAVCreateData dARCNAVCreateData, Context context, ViewGroup viewGroup) {
        this.f25280h = context;
        DiAREngineImpl diAREngineImpl = new DiAREngineImpl();
        diAREngineImpl.AREngineCreate(dARCNAVCreateData, this.f25280h.getApplicationContext());
        diAREngineImpl.AREngineSetCallbacks(this);
        this.f25275c = new DiARNavManager(diAREngineImpl);
        this.f25276d = new NetWorkerManager(diAREngineImpl);
        this.f25277e = new ScenceManager(diAREngineImpl);
        this.f25278f = new RenderManager(this.f25280h, diAREngineImpl);
        this.f25279g = new AlertUiManager(this.f25280h, viewGroup, diAREngineImpl);
        AROmega.arStart();
    }

    public void onHostCreated() {
        this.f25278f.createRender(this.f25280h);
    }

    public void onHostDestroy() {
        this.f25275c.destroy();
        this.f25275c.release();
        this.f25276d.release();
        this.f25277e.release();
        this.f25278f.release();
        this.f25279g.release();
    }

    public void onHostDetached() {
        this.f25275c.stop();
    }

    public void onHostResume() {
        this.f25275c.resume();
        this.f25278f.resume();
    }

    public void onHostPause() {
        this.f25275c.pause();
        this.f25278f.pause();
    }

    public void onHostSizeChanged(int i, int i2) {
        this.f25278f.onSizeChange(i, i2);
    }

    public void drawFrame() {
        int[] iArr = new int[3];
        this.f25278f.drawRender(iArr, this.f25281i);
        boolean z = false;
        this.f25279g.hintForExcessiveMotion(iArr[0] == 2);
        this.f25279g.checkPitchForNavigation(iArr[1] != 6);
        AlertUiManager alertUiManager = this.f25279g;
        if (iArr[2] == 4) {
            z = true;
        }
        alertUiManager.dissMissHintForNavigation(z);
    }

    public DARCNAVStatus status() {
        return this.f25277e.status();
    }

    public double currentTime() {
        return this.f25277e.currentTime();
    }

    public float[] currentLocation() {
        DARCLocationInScene dARCLocationInScene = new DARCLocationInScene();
        this.f25277e.currentLocation(dARCLocationInScene);
        return new float[]{(float) dARCLocationInScene.getIndex(), dARCLocationInScene.getPos().getX(), dARCLocationInScene.getPos().getY(), dARCLocationInScene.getPos().getZ()};
    }

    public void getGuidePosInScreen(DARCPointF dARCPointF) {
        this.f25277e.getGuidePosInScreen(dARCPointF);
    }

    public float distanceOfEnd() {
        return this.f25277e.distanceOfEnd();
    }

    public int getCurARStatus() {
        return this.f25279g.getCurARStatus();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20237a(DARCHTTPResponse dARCHTTPResponse) {
        this.f25276d.recvHTTPResponse(dARCHTTPResponse);
    }

    /* access modifiers changed from: protected */
    public void navigatorSendHTTPRequest(final DARCHTTPRequest dARCHTTPRequest) {
        ARRequestUtil.doAsyncHttpTask(ARRequestUtil.convertDARCHTTPRequest2ARRequest(dARCHTTPRequest), new ARRequestUtil.Callback() {
            public void onSuccess(byte[] bArr) {
                final DARCHTTPResponse convertData2DARCHttpResponse = ARRequestUtil.convertData2DARCHttpResponse(bArr, dARCHTTPRequest);
                DiARNavController.this.f25274b.post(new Runnable() {
                    public void run() {
                        if (convertData2DARCHttpResponse != null) {
                            DiARNavController.this.m20237a(convertData2DARCHttpResponse);
                        }
                    }
                });
            }

            public void onFailed(int i, Exception exc) {
                final DARCHTTPResponse convertData2DARCHttpResponse = ARRequestUtil.convertData2DARCHttpResponse((byte[]) null, dARCHTTPRequest);
                DiARNavController.this.f25274b.post(new Runnable() {
                    public void run() {
                        if (convertData2DARCHttpResponse != null) {
                            DiARNavController.this.m20237a(convertData2DARCHttpResponse);
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: protected */
    public void navigatorEvent(DARCNAVEvent dARCNAVEvent, DARCNAVEDShowAlert dARCNAVEDShowAlert) {
        if (dARCNAVEvent == DARCNAVEvent.DARCNAVEvent_ShowAlert) {
            DARCAlert alert = dARCNAVEDShowAlert.getAlert();
            DARCObject.gretain(alert);
            String title = alert.getTitle();
            String content = alert.getContent();
            HashMap hashMap = new HashMap();
            AREngineJNI.GetDARCAlertButtonList_Wrap(alert, hashMap);
            this.f25279g.onALertFromSDK(dARCNAVEDShowAlert, title, content, hashMap);
        }
    }

    /* access modifiers changed from: protected */
    public void navigatorEvent(DARCNAVEvent dARCNAVEvent, DARCNAVEDStatusChange dARCNAVEDStatusChange) {
        if (dARCNAVEvent != DARCNAVEvent.DARCNAVEvent_StatusChanged) {
            DARCNAVEvent dARCNAVEvent2 = DARCNAVEvent.DARCNAVEvent_ResetARSession;
        } else if (dARCNAVEDStatusChange.getStatusTo() == DARCNAVStatus.DARCNAVStatus_LocStart) {
            this.f25281i = DARCNAVStatus.DARCNAVStatus_LocStart;
            this.f25279g.refeshStatus(0);
            this.f25282j = System.currentTimeMillis();
            AROmega.arNavLocationView();
        } else if (dARCNAVEDStatusChange.getStatusTo() == DARCNAVStatus.DARCNAVStatus_LocEnd) {
            this.f25281i = DARCNAVStatus.DARCNAVStatus_LocEnd;
            this.f25279g.refeshStatus(1);
            AROmega.arNavLocationTime(((float) (System.currentTimeMillis() - this.f25282j)) / 1000.0f);
            if (ARNavGlobal.firstLocationSuccessTime == 0) {
                ARNavGlobal.firstLocationSuccessTime = System.currentTimeMillis();
            }
        } else if (dARCNAVEDStatusChange.getStatusTo() == DARCNAVStatus.DARCNAVStatus_Running) {
            this.f25278f.updateNavHintData();
            this.f25279g.refeshStatus(2);
            this.f25281i = DARCNAVStatus.DARCNAVStatus_Running;
        } else if (dARCNAVEDStatusChange.getStatusTo() == DARCNAVStatus.DARCNAVStatus_ReachEnd) {
            this.f25281i = DARCNAVStatus.DARCNAVStatus_ReachEnd;
            this.f25279g.alertReachDestination(dARCNAVEDStatusChange.getStringObj());
        }
    }

    public void setUiManagerListener(AlertUiManager.UIListener uIListener) {
        this.f25279g.setUIListener(uIListener);
    }

    public void start() {
        this.f25275c.start();
        this.f25279g.start();
        this.f25278f.start();
    }

    public void recoveryARUI() {
        this.f25279g.recoveryUI();
    }

    public void exitOfOrderCancell() {
        this.f25279g.exitOfOrderCancell();
    }

    public void hideARNavUI() {
        this.f25279g.hideARNavUI();
    }
}
