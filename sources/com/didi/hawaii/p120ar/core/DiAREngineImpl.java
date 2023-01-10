package com.didi.hawaii.p120ar.core;

import android.content.Context;
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
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.didi.hawaii.ar.core.DiAREngineImpl */
public class DiAREngineImpl implements DiAREngine {
    public static final int DO_FAILED = 0;
    public static final int DO_SUCCESS = 1;
    public static final int NOSTATUS = 0;
    public static final int PAUSE = 1;
    public static final int RESUME = 2;

    /* renamed from: a */
    private int f25267a = 0;

    /* renamed from: b */
    private long f25268b = -1;

    /* renamed from: c */
    private long f25269c = -1;

    /* renamed from: d */
    private boolean f25270d = false;

    /* renamed from: e */
    private boolean f25271e = false;

    /* renamed from: f */
    private boolean f25272f = false;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.hawaii.ar.core.DiAREngineImpl$status */
    public @interface C9618status {
    }

    public int ARZGEngineCreate(DARCZGNavCreateData dARCZGNavCreateData, Context context) {
        return 0;
    }

    public void ARZGEngineDestory() {
    }

    public void ARZGEngineSetCallbacks(SwigARCallback swigARCallback) {
    }

    public void activeZG() {
    }

    public void inactiveZG() {
    }

    public boolean isGPSWeak() {
        return false;
    }

    public boolean isShowEndGuidNode() {
        return false;
    }

    public boolean needShowBehindTips() {
        return false;
    }

    public void setZGEffectiveRect(DARCRectF dARCRectF) {
    }

    public void updateZG(DARCZGNavUpdateData dARCZGNavUpdateData) {
    }

    public void updateZGGPS(DARCGPSData dARCGPSData) {
    }

    DiAREngineImpl() {
        createEngineContext();
    }

    public int getDiARNavKitVersion() {
        return AREngineJNI.DiARNavKitGetVersion();
    }

    public int createEngineContext() {
        this.f25268b = AREngineJNI.createJNIContext();
        this.f25270d = true;
        return 1;
    }

    public void destroyEngineContext() {
        if (m20234a()) {
            AREngineDestory();
            this.f25269c = -1;
        }
        AREngineJNI.destroyJNIContext(this.f25268b);
        this.f25270d = false;
    }

    public int AREngineCreate(DARCNAVCreateData dARCNAVCreateData, Context context) {
        this.f25269c = AREngineJNI.ARCreate(this.f25268b, dARCNAVCreateData, DiAREngineImpl.class.getClassLoader(), context);
        this.f25271e = true;
        return 1;
    }

    public void AREngineDestory() {
        if (m20234a()) {
            AREngineJNI.ARDestory(this.f25269c, this.f25268b);
            this.f25271e = false;
            this.f25269c = -1;
        }
    }

    public void AREngineSetCallbacks(SwigARCallback swigARCallback) {
        if (m20234a()) {
            AREngineJNI.ARSetCallbacks(this.f25269c, this.f25268b, swigARCallback);
        }
    }

    public void start() {
        if (m20234a()) {
            AREngineJNI.start(this.f25269c);
            this.f25272f = true;
        }
    }

    public void pause() {
        if (m20234a() && this.f25272f && this.f25267a != 1) {
            AREngineJNI.pause(this.f25269c);
            this.f25267a = 1;
        }
    }

    public void resume() {
        if (m20234a() && this.f25272f && this.f25267a != 2) {
            AREngineJNI.resume(this.f25269c);
            this.f25267a = 2;
        }
    }

    public void stop() {
        if (m20234a()) {
            AREngineJNI.stop(this.f25269c);
        }
    }

    public void update(DARCNAVUpdateData dARCNAVUpdateData) {
        if (m20234a()) {
            AREngineJNI.update(this.f25269c, dARCNAVUpdateData);
        }
    }

    public void renderUpdate() {
        if (m20234a()) {
            AREngineJNI.renderUpdate(this.f25269c);
        }
    }

    public void setCorrectNodeVisible(boolean z) {
        if (m20234a()) {
            AREngineJNI.setCorrectNodeVisible(this.f25269c, z);
        }
    }

    public void recvHTTPResponse(DARCHTTPResponse dARCHTTPResponse) {
        if (m20234a()) {
            AREngineJNI.recvHTTPResponse(this.f25269c, dARCHTTPResponse);
        }
    }

    public void networkStatusChanged(DARCNetworkStatus dARCNetworkStatus) {
        if (m20234a()) {
            AREngineJNI.networkStatusChanged(this.f25269c, dARCNetworkStatus);
        }
    }

    public void eventShowAlertReply(DARCNAVEDShowAlert dARCNAVEDShowAlert, int i) {
        if (m20234a()) {
            AREngineJNI.eventShowAlertReply(this.f25269c, dARCNAVEDShowAlert, i);
        }
    }

    public DARCNAVStatus status() {
        if (m20234a()) {
            return AREngineJNI.status(this.f25269c);
        }
        return null;
    }

    public double currentTime() {
        if (m20234a()) {
            return AREngineJNI.currentTime(this.f25269c);
        }
        return 0.0d;
    }

    public void currentLocation(DARCLocationInScene dARCLocationInScene) {
        if (m20234a()) {
            AREngineJNI.currentLocation(this.f25269c, dARCLocationInScene);
        }
    }

    public void getGuidePosInScreen(DARCPointF dARCPointF) {
        if (m20234a()) {
            AREngineJNI.getGuidePosInScreen(this.f25269c, dARCPointF);
        }
    }

    public float distanceOfEnd() {
        if (m20234a()) {
            return AREngineJNI.distanceOfEnd(this.f25269c);
        }
        return 0.0f;
    }

    public void errorAppear() {
        if (m20234a()) {
            AREngineJNI.errorAppear(this.f25269c);
        }
    }

    public void errorDisappear() {
        if (m20234a()) {
            AREngineJNI.errorDisappear(this.f25269c);
        }
    }

    /* renamed from: a */
    private synchronized boolean m20234a() {
        return this.f25270d && this.f25271e;
    }
}
