package com.didichuxing.diface.biz.bioassay.video_capture;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import com.didi.beatles.p101im.picture.utils.IMPictureFileUtils;
import com.didichuxing.diface.biz.bioassay.video_capture.MediaEncoder;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DiFaceVideoCaptureManager {
    public static float BPP = 0.25f;
    public static int FRAME_RATE = 20;

    /* renamed from: a */
    private static final String f49951a = "bioassayVideo";

    /* renamed from: b */
    private static final SimpleDateFormat f49952b = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);

    /* renamed from: c */
    private final float[] f49953c = new float[16];

    /* renamed from: d */
    private MediaMuxerWrapper f49954d;

    /* renamed from: e */
    private int f49955e;

    /* renamed from: f */
    private int f49956f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public GLSurfaceView f49957g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f49958h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public MediaVideoEncoder f49959i;

    /* renamed from: j */
    private final MediaEncoder.MediaEncoderListener f49960j = new MediaEncoder.MediaEncoderListener() {
        public void onPrepared(MediaEncoder mediaEncoder) {
            if (mediaEncoder instanceof MediaVideoEncoder) {
                DiFaceVideoCaptureManager.this.m37387a((MediaVideoEncoder) mediaEncoder);
            }
        }

        public void onStopped(MediaEncoder mediaEncoder) {
            if (mediaEncoder instanceof MediaVideoEncoder) {
                DiFaceVideoCaptureManager.this.m37387a((MediaVideoEncoder) null);
            }
        }
    };

    /* renamed from: k */
    private boolean f49961k = false;

    public DiFaceVideoCaptureManager(int i, int i2, boolean z, GLSurfaceView gLSurfaceView, float f, int i3) {
        if (!z) {
            this.f49955e = i;
            this.f49956f = i2;
        } else {
            this.f49955e = i2;
            this.f49956f = i;
        }
        this.f49957g = gLSurfaceView;
        Matrix.setIdentityM(this.f49953c, 0);
        Matrix.rotateM(this.f49953c, 0, 270.0f, 0.0f, 0.0f, 1.0f);
        BPP = f;
        FRAME_RATE = i3;
    }

    public boolean isRecording() {
        return this.f49961k;
    }

    public void startRecording(Context context, int i) {
        this.f49958h = i;
        try {
            MediaMuxerWrapper mediaMuxerWrapper = new MediaMuxerWrapper(context, IMPictureFileUtils.POST_VIDEO);
            this.f49954d = mediaMuxerWrapper;
            new MediaVideoEncoder(mediaMuxerWrapper, this.f49960j, this.f49955e, this.f49956f);
            this.f49954d.prepare();
            this.f49954d.startRecording();
            this.f49961k = true;
        } catch (Exception unused) {
        }
    }

    public void stopRecording() {
        MediaMuxerWrapper mediaMuxerWrapper = this.f49954d;
        if (mediaMuxerWrapper != null) {
            this.f49961k = false;
            mediaMuxerWrapper.stopRecording();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37387a(final MediaVideoEncoder mediaVideoEncoder) {
        this.f49957g.queueEvent(new Runnable() {
            public void run() {
                synchronized (DiFaceVideoCaptureManager.this.f49957g) {
                    if (mediaVideoEncoder != null) {
                        mediaVideoEncoder.setEglContext(EGL14.eglGetCurrentContext(), DiFaceVideoCaptureManager.this.f49958h);
                        MediaVideoEncoder unused = DiFaceVideoCaptureManager.this.f49959i = mediaVideoEncoder;
                    }
                }
            }
        });
    }

    public void frameAvailable(float[] fArr, float[] fArr2) {
        MediaVideoEncoder mediaVideoEncoder = this.f49959i;
        if (mediaVideoEncoder != null) {
            mediaVideoEncoder.frameAvailableSoon(fArr, fArr2);
        }
    }

    public void frameAvailable(float[] fArr) {
        MediaVideoEncoder mediaVideoEncoder = this.f49959i;
        if (mediaVideoEncoder != null) {
            mediaVideoEncoder.frameAvailableSoon(fArr, this.f49953c);
        }
    }

    public void frameAvailable() {
        MediaVideoEncoder mediaVideoEncoder = this.f49959i;
        if (mediaVideoEncoder != null) {
            mediaVideoEncoder.frameAvailableSoon();
        }
    }

    public String getVideoPath() {
        MediaMuxerWrapper mediaMuxerWrapper = this.f49954d;
        if (mediaMuxerWrapper == null) {
            return null;
        }
        String outputPath = mediaMuxerWrapper.getOutputPath();
        this.f49954d = null;
        return outputPath;
    }

    public static final File getCaptureFile(Context context, String str) {
        if (context == null) {
            return null;
        }
        File externalFilesDir = context.getExternalFilesDir(f49951a);
        externalFilesDir.mkdirs();
        if (!externalFilesDir.canWrite()) {
            return null;
        }
        return new File(externalFilesDir, m37385a() + str);
    }

    /* renamed from: a */
    private static final String m37385a() {
        return f49952b.format(new GregorianCalendar().getTime());
    }
}
