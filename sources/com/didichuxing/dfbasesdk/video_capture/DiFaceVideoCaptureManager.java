package com.didichuxing.dfbasesdk.video_capture;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.Log;
import com.didi.beatles.p101im.picture.utils.IMPictureFileUtils;
import com.didichuxing.dfbasesdk.video_capture.MediaEncoder;

public class DiFaceVideoCaptureManager {
    public static float BPP = 0.25f;
    public static int FRAME_RATE = 20;

    /* renamed from: a */
    private final float[] f49438a = new float[16];

    /* renamed from: b */
    private MediaMuxerWrapper f49439b;

    /* renamed from: c */
    private int f49440c;

    /* renamed from: d */
    private int f49441d;

    /* renamed from: e */
    private boolean f49442e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public GLSurfaceView f49443f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f49444g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public MediaVideoEncoder f49445h;

    /* renamed from: i */
    private final MediaEncoder.MediaEncoderListener f49446i = new MediaEncoder.MediaEncoderListener() {
        public void onPrepared(MediaEncoder mediaEncoder) {
            if (mediaEncoder instanceof MediaVideoEncoder) {
                DiFaceVideoCaptureManager.this.m37078a((MediaVideoEncoder) mediaEncoder);
            }
        }

        public void onStopped(MediaEncoder mediaEncoder) {
            if (mediaEncoder instanceof MediaVideoEncoder) {
                DiFaceVideoCaptureManager.this.m37078a((MediaVideoEncoder) null);
            }
        }

        public void onError(String str) {
            if (DiFaceVideoCaptureManager.this.listener != null) {
                DiFaceVideoCaptureManager.this.listener.onError(str);
            }
        }
    };

    /* renamed from: j */
    private boolean f49447j = false;
    public IErrorListener listener;

    public DiFaceVideoCaptureManager(int i, int i2, boolean z, GLSurfaceView gLSurfaceView, float f, int i3) {
        this.f49442e = z;
        if (!z) {
            this.f49440c = i;
            this.f49441d = i2;
        } else {
            this.f49440c = i2;
            this.f49441d = i;
        }
        this.f49443f = gLSurfaceView;
        Matrix.setIdentityM(this.f49438a, 0);
        Matrix.rotateM(this.f49438a, 0, 270.0f, 0.0f, 0.0f, 1.0f);
        BPP = f;
        FRAME_RATE = i3;
    }

    public void setCameraWidthAndHeight(int i, int i2) {
        if (!this.f49442e) {
            this.f49440c = i;
            this.f49441d = i2;
            return;
        }
        this.f49440c = i2;
        this.f49441d = i;
    }

    public boolean isRecording() {
        return this.f49447j;
    }

    public void startRecording(Context context, int i) {
        this.f49444g = i;
        try {
            MediaMuxerWrapper mediaMuxerWrapper = new MediaMuxerWrapper(context, IMPictureFileUtils.POST_VIDEO);
            this.f49439b = mediaMuxerWrapper;
            new MediaVideoEncoder(mediaMuxerWrapper, this.f49446i, this.f49440c, this.f49441d);
            this.f49439b.prepare();
            this.f49439b.startRecording();
            this.f49447j = true;
        } catch (Exception e) {
            IErrorListener iErrorListener = this.listener;
            if (iErrorListener != null) {
                iErrorListener.onStartError("startRecording failed , " + Log.getStackTraceString(e));
            }
            MediaEncoder.MediaEncoderListener mediaEncoderListener = this.f49446i;
            if (mediaEncoderListener != null) {
                mediaEncoderListener.onError("startRecording failed , " + Log.getStackTraceString(e));
            }
        }
    }

    public void startRecording(Context context, int i, String str) {
        this.f49444g = i;
        try {
            MediaMuxerWrapper mediaMuxerWrapper = new MediaMuxerWrapper(context, IMPictureFileUtils.POST_VIDEO, str);
            this.f49439b = mediaMuxerWrapper;
            new MediaVideoEncoder(mediaMuxerWrapper, this.f49446i, this.f49440c, this.f49441d);
            this.f49439b.prepare();
            this.f49439b.startRecording();
            this.f49447j = true;
        } catch (Exception e) {
            IErrorListener iErrorListener = this.listener;
            if (iErrorListener != null) {
                iErrorListener.onStartError("startRecording failed , " + Log.getStackTraceString(e));
            }
            MediaEncoder.MediaEncoderListener mediaEncoderListener = this.f49446i;
            if (mediaEncoderListener != null) {
                mediaEncoderListener.onError("startRecording failed , " + Log.getStackTraceString(e));
            }
        }
    }

    public void stopRecording() {
        MediaMuxerWrapper mediaMuxerWrapper = this.f49439b;
        if (mediaMuxerWrapper != null) {
            this.f49447j = false;
            mediaMuxerWrapper.stopRecording();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37078a(final MediaVideoEncoder mediaVideoEncoder) {
        this.f49443f.queueEvent(new Runnable() {
            public void run() {
                synchronized (DiFaceVideoCaptureManager.this.f49443f) {
                    if (mediaVideoEncoder != null) {
                        mediaVideoEncoder.setEglContext(EGL14.eglGetCurrentContext(), DiFaceVideoCaptureManager.this.f49444g);
                        MediaVideoEncoder unused = DiFaceVideoCaptureManager.this.f49445h = mediaVideoEncoder;
                    }
                }
            }
        });
    }

    public void frameAvailable(float[] fArr, float[] fArr2) {
        MediaVideoEncoder mediaVideoEncoder = this.f49445h;
        if (mediaVideoEncoder != null) {
            mediaVideoEncoder.frameAvailableSoon(fArr, fArr2);
        }
    }

    public void frameAvailable(float[] fArr) {
        MediaVideoEncoder mediaVideoEncoder = this.f49445h;
        if (mediaVideoEncoder != null) {
            mediaVideoEncoder.frameAvailableSoon(fArr, this.f49438a);
        }
    }

    public void frameAvailable() {
        MediaVideoEncoder mediaVideoEncoder = this.f49445h;
        if (mediaVideoEncoder != null) {
            mediaVideoEncoder.frameAvailableSoon();
        }
    }

    public String getVideoPath() {
        MediaMuxerWrapper mediaMuxerWrapper = this.f49439b;
        if (mediaMuxerWrapper == null) {
            return null;
        }
        String outputPath = mediaMuxerWrapper.getOutputPath();
        this.f49439b = null;
        return outputPath;
    }

    public IErrorListener getListener() {
        return this.listener;
    }

    public void setListener(IErrorListener iErrorListener) {
        this.listener = iErrorListener;
    }
}
