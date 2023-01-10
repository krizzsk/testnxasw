package com.didichuxing.dfbasesdk.video_capture;

import android.content.Context;
import android.media.MediaRecorder;
import android.text.TextUtils;
import com.didichuxing.dfbasesdk.camera.ICameraInterface;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class MediaRecorderRecord implements IRecordVideo {

    /* renamed from: a */
    private MediaRecorder f49496a;

    /* renamed from: b */
    private final ICameraInterface f49497b;

    /* renamed from: c */
    private final Context f49498c;

    /* renamed from: d */
    private String f49499d;

    /* renamed from: e */
    private AtomicBoolean f49500e = new AtomicBoolean(false);

    public void frameAvailable(float[] fArr) {
    }

    @Deprecated
    public void start(int i, String str) {
    }

    public MediaRecorderRecord(Context context, ICameraInterface iCameraInterface) {
        this.f49498c = context.getApplicationContext();
        this.f49497b = iCameraInterface;
    }

    public void start(int i) {
        stop();
        this.f49499d = PathUtils.getCaptureFile(this.f49498c, "_m.mp4").toString();
        if (this.f49497b.getCamera() != null) {
            this.f49496a = new MediaRecorder();
            this.f49497b.getCamera().unlock();
            this.f49496a.setCamera(this.f49497b.getCamera());
            this.f49496a.setAudioSource(0);
            this.f49496a.setVideoSource(1);
            this.f49496a.setOrientationHint(90);
            this.f49496a.setOutputFormat(2);
            this.f49496a.setAudioEncoder(1);
            this.f49496a.setVideoEncoder(2);
            this.f49496a.setVideoEncodingBitRate(1556480);
            this.f49496a.setVideoSize(this.f49497b.getPreviewWidth(), this.f49497b.getPreviewHeight());
            this.f49496a.setOutputFile(this.f49499d);
            try {
                this.f49496a.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.f49496a.start();
        }
        this.f49500e.set(true);
    }

    public void stop() {
        if (this.f49500e.get()) {
            this.f49500e.set(false);
            MediaRecorder mediaRecorder = this.f49496a;
            if (mediaRecorder != null) {
                mediaRecorder.stop();
                this.f49496a.reset();
                this.f49496a.release();
            }
        }
    }

    public String getVideoPath() {
        if (TextUtils.isEmpty(this.f49499d)) {
            return null;
        }
        String str = this.f49499d;
        this.f49499d = null;
        return str;
    }

    public void setErrorListener(final IErrorListener iErrorListener) {
        MediaRecorder mediaRecorder = this.f49496a;
        if (mediaRecorder != null) {
            mediaRecorder.setOnErrorListener(new MediaRecorder.OnErrorListener() {
                public void onError(MediaRecorder mediaRecorder, int i, int i2) {
                    IErrorListener iErrorListener = iErrorListener;
                    if (iErrorListener != null) {
                        iErrorListener.onError("MediaRecorder onError : what : " + i + "  extra : " + i2);
                    }
                }
            });
        }
    }

    public boolean recording() {
        return this.f49500e.get();
    }
}
