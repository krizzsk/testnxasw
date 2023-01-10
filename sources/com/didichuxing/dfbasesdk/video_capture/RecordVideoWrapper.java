package com.didichuxing.dfbasesdk.video_capture;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build;
import com.didichuxing.dfbasesdk.camera.ICameraInterface;
import com.didichuxing.dfbasesdk.utils.LogUtils;

public class RecordVideoWrapper implements IRecordVideo {

    /* renamed from: a */
    private IRecordVideo f49510a;

    /* renamed from: b */
    private Context f49511b;

    /* renamed from: c */
    private ICameraInterface f49512c;

    /* renamed from: d */
    private IErrorListener f49513d;

    public RecordVideoWrapper(Context context, boolean z, GLSurfaceView gLSurfaceView, ICameraInterface iCameraInterface, float f, int i) {
        this.f49511b = context.getApplicationContext();
        this.f49512c = iCameraInterface;
        if (Build.VERSION.SDK_INT < 18) {
            this.f49510a = new MediaRecorderRecord(context, iCameraInterface);
        } else {
            this.f49510a = new FacePlusRecordVideo(context, iCameraInterface, z, gLSurfaceView, f, i);
        }
    }

    public void start(int i) {
        try {
            this.f49510a.start(i);
        } catch (Throwable th) {
            m37109a();
            LogUtils.logStackTrace(th);
        }
    }

    public void start(int i, String str) {
        try {
            this.f49510a.start(i, str);
        } catch (Throwable th) {
            m37109a();
            LogUtils.logStackTrace(th);
        }
    }

    public void stop() {
        try {
            this.f49510a.stop();
        } catch (Throwable th) {
            LogUtils.logStackTrace(th);
        }
    }

    public String getVideoPath() {
        try {
            return this.f49510a.getVideoPath();
        } catch (Throwable th) {
            LogUtils.logStackTrace(th);
            return "";
        }
    }

    public void setErrorListener(final IErrorListener iErrorListener) {
        this.f49513d = iErrorListener;
        IRecordVideo iRecordVideo = this.f49510a;
        if (iRecordVideo != null) {
            iRecordVideo.setErrorListener(new IErrorListener() {
                public void onError(String str) {
                    IErrorListener iErrorListener = iErrorListener;
                    if (iErrorListener != null) {
                        iErrorListener.onError(str);
                    }
                }

                public void onStartError(String str) {
                    IErrorListener iErrorListener = iErrorListener;
                    if (iErrorListener != null) {
                        iErrorListener.onStartError(str);
                    }
                    RecordVideoWrapper.this.m37109a();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37109a() {
        IRecordVideo iRecordVideo = this.f49510a;
        if (iRecordVideo == null || !(iRecordVideo instanceof FacePlusRecordVideo)) {
            IErrorListener iErrorListener = this.f49513d;
            if (iErrorListener != null) {
                iErrorListener.onError("尝试使用MediaRecord录制一次失败");
                return;
            }
            return;
        }
        try {
            MediaRecorderRecord mediaRecorderRecord = new MediaRecorderRecord(this.f49511b, this.f49512c);
            this.f49510a = mediaRecorderRecord;
            mediaRecorderRecord.start(0);
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
            IErrorListener iErrorListener2 = this.f49513d;
            if (iErrorListener2 != null) {
                iErrorListener2.onError("尝试使用MediaRecord录制一次失败，" + e.getMessage());
            }
        }
    }

    public void frameAvailable(float[] fArr) {
        IRecordVideo iRecordVideo = this.f49510a;
        if (iRecordVideo != null) {
            try {
                iRecordVideo.frameAvailable(fArr);
            } catch (Throwable th) {
                LogUtils.logStackTrace(th);
            }
        }
    }

    public boolean recording() {
        IRecordVideo iRecordVideo = this.f49510a;
        if (iRecordVideo != null) {
            return iRecordVideo.recording();
        }
        return false;
    }
}
