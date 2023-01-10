package com.didi.hawaii.p120ar.core.p121zg;

import android.content.Context;
import com.didi.hawaii.p120ar.core.DiAREngine;
import com.didi.hawaii.p120ar.jni.AREngineJNI;
import com.didi.hawaii.p120ar.jni.DARCGPSData;
import com.didi.hawaii.p120ar.jni.DARCHTTPResponse;
import com.didi.hawaii.p120ar.jni.DARCLocationInScene;
import com.didi.hawaii.p120ar.jni.DARCNAVCreateData;
import com.didi.hawaii.p120ar.jni.DARCNAVEDShowAlert;
import com.didi.hawaii.p120ar.jni.DARCNAVStatus;
import com.didi.hawaii.p120ar.jni.DARCNAVUpdateData;
import com.didi.hawaii.p120ar.jni.DARCNetworkStatus;
import com.didi.hawaii.p120ar.jni.DARCPointF;
import com.didi.hawaii.p120ar.jni.DARCRectF;
import com.didi.hawaii.p120ar.jni.DARCZGNavCreateData;
import com.didi.hawaii.p120ar.jni.DARCZGNavUpdateData;
import com.didi.hawaii.p120ar.jni.SwigARCallback;

/* renamed from: com.didi.hawaii.ar.core.zg.DiARZGEngineImpl */
public class DiARZGEngineImpl implements DiAREngine {
    public static final int DO_FAILED = 0;
    public static final int DO_SUCCESS = 1;

    /* renamed from: a */
    private long f25358a = -1;

    /* renamed from: b */
    private long f25359b = -1;

    /* renamed from: c */
    private boolean f25360c = false;

    /* renamed from: d */
    private boolean f25361d = false;

    public int AREngineCreate(DARCNAVCreateData dARCNAVCreateData, Context context) {
        return -1;
    }

    public void AREngineDestory() {
    }

    public void AREngineSetCallbacks(SwigARCallback swigARCallback) {
    }

    public void currentLocation(DARCLocationInScene dARCLocationInScene) {
    }

    public double currentTime() {
        return 0.0d;
    }

    public float distanceOfEnd() {
        return 0.0f;
    }

    public void errorAppear() {
    }

    public void errorDisappear() {
    }

    public void eventShowAlertReply(DARCNAVEDShowAlert dARCNAVEDShowAlert, int i) {
    }

    public void getGuidePosInScreen(DARCPointF dARCPointF) {
    }

    public void networkStatusChanged(DARCNetworkStatus dARCNetworkStatus) {
    }

    public void pause() {
    }

    public void recvHTTPResponse(DARCHTTPResponse dARCHTTPResponse) {
    }

    public void renderUpdate() {
    }

    public void resume() {
    }

    public void setCorrectNodeVisible(boolean z) {
    }

    public void start() {
    }

    public DARCNAVStatus status() {
        return null;
    }

    public void stop() {
    }

    public void update(DARCNAVUpdateData dARCNAVUpdateData) {
    }

    public DiARZGEngineImpl() {
        createEngineContext();
    }

    public int getDiARNavKitVersion() {
        return AREngineJNI.DiARNavKitGetVersion();
    }

    public int createEngineContext() {
        this.f25358a = AREngineJNI.createJNIContext();
        this.f25360c = true;
        return 1;
    }

    public void destroyEngineContext() {
        if (m20269a()) {
            ARZGEngineDestory();
            this.f25359b = -1;
        }
        AREngineJNI.destroyJNIContext(this.f25358a);
        this.f25360c = false;
    }

    public int ARZGEngineCreate(DARCZGNavCreateData dARCZGNavCreateData, Context context) {
        this.f25359b = AREngineJNI.ARZGCreate(this.f25358a, dARCZGNavCreateData, DiARZGEngineImpl.class.getClassLoader(), context);
        this.f25361d = true;
        return 1;
    }

    public void ARZGEngineDestory() {
        if (m20269a()) {
            AREngineJNI.ARZGDestory(this.f25359b, this.f25358a);
            this.f25361d = false;
            this.f25359b = -1;
        }
    }

    public void ARZGEngineSetCallbacks(SwigARCallback swigARCallback) {
        if (m20269a()) {
            AREngineJNI.ARZGSetCallbacks(this.f25359b, this.f25358a, swigARCallback);
        }
    }

    public void updateZG(DARCZGNavUpdateData dARCZGNavUpdateData) {
        if (m20269a()) {
            AREngineJNI.updateZG(this.f25359b, dARCZGNavUpdateData);
        }
    }

    public void activeZG() {
        if (m20269a()) {
            AREngineJNI.resumeZG(this.f25359b);
        }
    }

    public void inactiveZG() {
        if (m20269a()) {
            AREngineJNI.pauseZG(this.f25359b);
        }
    }

    public void setZGEffectiveRect(DARCRectF dARCRectF) {
        if (m20269a()) {
            AREngineJNI.setZGEffectiveRect(this.f25359b, dARCRectF);
        }
    }

    public void updateZGGPS(DARCGPSData dARCGPSData) {
        if (m20269a()) {
            AREngineJNI.updateZGGPS(this.f25359b, dARCGPSData);
        }
    }

    public boolean isShowEndGuidNode() {
        if (m20269a()) {
            return AREngineJNI.isShowEndGuidNode(this.f25359b);
        }
        return false;
    }

    public boolean isGPSWeak() {
        if (m20269a()) {
            return AREngineJNI.isGPSWeak(this.f25359b);
        }
        return false;
    }

    public boolean needShowBehindTips() {
        if (m20269a()) {
            return AREngineJNI.needShowBehindTips(this.f25359b);
        }
        return false;
    }

    /* renamed from: a */
    private synchronized boolean m20269a() {
        return this.f25360c && this.f25361d;
    }
}
