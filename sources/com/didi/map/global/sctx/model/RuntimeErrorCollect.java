package com.didi.map.global.sctx.model;

import com.didi.common.map.util.DLog;
import com.didi.map.google.config.Config;
import com.didi.sdk.apm.SystemUtils;

public class RuntimeErrorCollect {
    public static final int BindRoadError = 303;
    public static final int CompleteError = 308;
    public static final int DataHandleError = 206;
    public static final int HttpError = 102;
    public static final int InertialNavError = 305;
    public static final int LineEraseError = 307;
    public static final int MASK = 511;
    public static final int NetworkTimeOut = 103;
    public static final int NoNetWork = 101;
    public static final int NormalNavError = 304;
    public static final int OraErrorCode = 205;
    public static final int OraHasNoDriver = 202;
    public static final int OraHasNoLine = 201;
    public static final int OraIsNull = 207;
    public static final int OraParseError = 204;
    public static final int OrderStageError = 203;
    public static final int Ready = 0;
    public static final int RunFinish = 256;
    public static final int RunToBindRound = 4;
    public static final int RunToDrawLine = 8;
    public static final int RunToEraseLine = 128;
    public static final int RunToHandleOra = 1;
    public static final int RunToInertialNav = 32;
    public static final int RunToNormalNav = 16;
    public static final int RunToUpdateCar = 64;
    public static final int RunToView = 2;
    public static final String TAG = "sctx_error";
    public static final int UpdateCarError = 306;
    public static final int ViewDataListenError = 301;
    public static final int ViewNoDrawLineError = 302;

    /* renamed from: a */
    private String f30101a;

    /* renamed from: b */
    private int f30102b = 0;

    /* renamed from: c */
    private ReportCallback f30103c;

    public interface ReportCallback {
        void reportError(String str);
    }

    public void setReportCallback(ReportCallback reportCallback) {
        this.f30103c = reportCallback;
    }

    public void needRunState(int i) {
        if (Config.DEBUG || !(i == 32 || i == 16)) {
            this.f30102b = i | this.f30102b;
        }
    }

    public void completeRunState(int i) {
        this.f30102b = (i ^ 511) & this.f30102b;
    }

    public void setErrorCode(int i) {
        if (this.f30101a == null) {
            this.f30101a = String.valueOf(i);
        } else {
            this.f30101a += "|" + i;
        }
        DLog.m10773d(TAG, "sctx error:" + i, new Object[0]);
    }

    public String getErrorCode() {
        return this.f30101a;
    }

    public void checkRunStateError() {
        if ((this.f30102b & 1) == 1) {
            setErrorCode(206);
            if (Config.DEBUG) {
                SystemUtils.log(3, Config.DEBUG_TAG, "ora handle error.", (Throwable) null, "com.didi.map.global.sctx.model.RuntimeErrorCollect", 86);
            }
        }
        if ((this.f30102b & 2) == 2) {
            setErrorCode(301);
            if (Config.DEBUG) {
                SystemUtils.log(3, Config.DEBUG_TAG, "view can't receive data.", (Throwable) null, "com.didi.map.global.sctx.model.RuntimeErrorCollect", 92);
            }
        }
        if ((this.f30102b & 4) == 4) {
            setErrorCode(303);
            if (Config.DEBUG) {
                SystemUtils.log(3, Config.DEBUG_TAG, "don't bind road.", (Throwable) null, "com.didi.map.global.sctx.model.RuntimeErrorCollect", 98);
            }
        }
        if ((this.f30102b & 8) == 8) {
            setErrorCode(302);
            if (Config.DEBUG) {
                SystemUtils.log(3, Config.DEBUG_TAG, "has new line, don't draw line.", (Throwable) null, "com.didi.map.global.sctx.model.RuntimeErrorCollect", 104);
            }
        }
        if ((this.f30102b & 16) == 16) {
            setErrorCode(304);
            if (Config.DEBUG) {
                SystemUtils.log(3, Config.DEBUG_TAG, "has new line, don't run normal nav.", (Throwable) null, "com.didi.map.global.sctx.model.RuntimeErrorCollect", 110);
            }
        }
        if ((this.f30102b & 32) == 32) {
            setErrorCode(305);
            if (Config.DEBUG) {
                SystemUtils.log(3, Config.DEBUG_TAG, "has new line, don't run inertial nav.", (Throwable) null, "com.didi.map.global.sctx.model.RuntimeErrorCollect", 116);
            }
        }
        if ((this.f30102b & 64) == 64 && Config.DEBUG) {
            SystemUtils.log(3, Config.DEBUG_TAG, "don't update car position.", (Throwable) null, "com.didi.map.global.sctx.model.RuntimeErrorCollect", 122);
        }
        if ((this.f30102b & 128) == 128 && Config.DEBUG) {
            SystemUtils.log(3, Config.DEBUG_TAG, "has new line, don't erase line.", (Throwable) null, "com.didi.map.global.sctx.model.RuntimeErrorCollect", 128);
        }
        if ((this.f30102b & 256) == 256) {
            setErrorCode(308);
        }
    }

    public void checkAndReport() {
        ReportCallback reportCallback;
        checkRunStateError();
        if (getErrorCode() != null && (reportCallback = this.f30103c) != null) {
            reportCallback.reportError(getErrorCode());
            DLog.m10773d(TAG, "report sctx error:" + getErrorCode(), new Object[0]);
        }
    }

    public void reset() {
        this.f30102b = 0;
        this.f30101a = null;
    }
}
