package com.didi.safety.god.mediacodec;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import com.didi.beatles.p101im.picture.utils.IMPictureFileUtils;
import com.didi.safety.god.mediacodec.MediaEncoder;
import java.io.IOException;

public class MediaHelper {

    /* renamed from: a */
    private final float[] f37415a = new float[16];

    /* renamed from: b */
    private MediaMuxerWrapper f37416b;

    /* renamed from: c */
    private int f37417c;

    /* renamed from: d */
    private int f37418d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public GLSurfaceView f37419e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f37420f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public MediaVideoEncoder f37421g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public OnVideoRecordListener f37422h;

    /* renamed from: i */
    private final MediaEncoder.MediaEncoderListener f37423i = new MediaEncoder.MediaEncoderListener() {
        public void onPrepared(MediaEncoder mediaEncoder) {
            if (mediaEncoder instanceof MediaVideoEncoder) {
                MediaHelper.this.m28209a((MediaVideoEncoder) mediaEncoder);
            }
        }

        public void onStopped(MediaEncoder mediaEncoder) {
            if (mediaEncoder instanceof MediaVideoEncoder) {
                MediaHelper.this.m28209a((MediaVideoEncoder) null);
            }
        }

        public void onException(MediaEncoder mediaEncoder, Exception exc) {
            if (MediaHelper.this.f37422h != null) {
                MediaHelper.this.f37422h.onRecordException(exc);
            }
        }

        public void onVideoReady(MediaEncoder mediaEncoder) {
            if (MediaHelper.this.f37422h != null) {
                MediaHelper.this.f37422h.onVideoReady();
            }
        }
    };

    public interface OnVideoRecordListener {
        void onRecordException(Exception exc);

        void onVideoReady();
    }

    public void setOnVideoRecordListener(OnVideoRecordListener onVideoRecordListener) {
        this.f37422h = onVideoRecordListener;
    }

    public MediaHelper(int i, int i2, boolean z, GLSurfaceView gLSurfaceView) {
        if (z) {
            this.f37417c = i;
            this.f37418d = i2;
        } else {
            this.f37417c = i2;
            this.f37418d = i;
        }
        this.f37419e = gLSurfaceView;
        Matrix.setIdentityM(this.f37415a, 0);
        Matrix.rotateM(this.f37415a, 0, 0.0f, 0.0f, 0.0f, 1.0f);
    }

    public void startRecording(Context context, int i) {
        this.f37420f = i;
        try {
            MediaMuxerWrapper mediaMuxerWrapper = new MediaMuxerWrapper(context, IMPictureFileUtils.POST_VIDEO);
            this.f37416b = mediaMuxerWrapper;
            new MediaVideoEncoder(mediaMuxerWrapper, this.f37423i, this.f37417c, this.f37418d);
            this.f37416b.prepare();
            this.f37416b.startRecording();
        } catch (IOException unused) {
        }
    }

    public void startRecording(Context context, int i, String str, double d) {
        this.f37420f = i;
        try {
            MediaMuxerWrapper mediaMuxerWrapper = new MediaMuxerWrapper(context, str, ".log");
            this.f37416b = mediaMuxerWrapper;
            if (d <= 0.0d || d >= 1.0d) {
                new MediaVideoEncoder(this.f37416b, this.f37423i, this.f37417c, this.f37418d);
            } else {
                new MediaVideoEncoder(mediaMuxerWrapper, this.f37423i, (int) (((double) this.f37417c) * d), (int) (((double) this.f37418d) * d));
            }
            this.f37416b.prepare();
            this.f37416b.startRecording();
        } catch (IOException unused) {
        }
    }

    public void stopRecording() {
        MediaMuxerWrapper mediaMuxerWrapper = this.f37416b;
        if (mediaMuxerWrapper != null) {
            mediaMuxerWrapper.stopRecording();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28209a(final MediaVideoEncoder mediaVideoEncoder) {
        this.f37419e.queueEvent(new Runnable() {
            public void run() {
                synchronized (MediaHelper.this.f37419e) {
                    if (mediaVideoEncoder != null) {
                        mediaVideoEncoder.setEglContext(EGL14.eglGetCurrentContext(), MediaHelper.this.f37420f);
                        MediaVideoEncoder unused = MediaHelper.this.f37421g = mediaVideoEncoder;
                    }
                }
            }
        });
    }

    public void frameAvailable(float[] fArr, float[] fArr2) {
        MediaVideoEncoder mediaVideoEncoder = this.f37421g;
        if (mediaVideoEncoder != null) {
            mediaVideoEncoder.frameAvailableSoon(fArr, fArr2);
        }
    }

    public void frameAvailable(float[] fArr) {
        MediaVideoEncoder mediaVideoEncoder = this.f37421g;
        if (mediaVideoEncoder != null) {
            mediaVideoEncoder.frameAvailableSoon(fArr, this.f37415a);
        }
    }

    public void frameAvailable() {
        MediaVideoEncoder mediaVideoEncoder = this.f37421g;
        if (mediaVideoEncoder != null) {
            mediaVideoEncoder.frameAvailableSoon();
        }
    }

    public String getVideoPath() {
        MediaMuxerWrapper mediaMuxerWrapper = this.f37416b;
        if (mediaMuxerWrapper == null) {
            return null;
        }
        String outputPath = mediaMuxerWrapper.getOutputPath();
        this.f37416b = null;
        return outputPath;
    }
}
