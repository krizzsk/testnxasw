package com.didichuxing.dfbasesdk.video_capture;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.dfbasesdk.utils.OpenGLUtil;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class RendererDecorate implements GLSurfaceView.Renderer {

    /* renamed from: a */
    private final Context f49528a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final GLSurfaceView f49529b;

    /* renamed from: c */
    private GLSurfaceView.Renderer f49530c;

    /* renamed from: d */
    private DiFaceVideoCaptureManager f49531d;

    /* renamed from: e */
    private CameraMatrix f49532e;

    /* renamed from: f */
    private int f49533f = 0;

    /* renamed from: g */
    private SurfaceTexture f49534g;

    /* renamed from: h */
    private boolean f49535h;

    /* renamed from: i */
    private boolean f49536i;

    /* renamed from: j */
    private final float[] f49537j = new float[16];

    /* renamed from: k */
    private final float[] f49538k = new float[16];

    /* renamed from: l */
    private final float[] f49539l = new float[16];

    /* renamed from: m */
    private IErrorListener f49540m;

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig, SurfaceTexture surfaceTexture) {
    }

    public RendererDecorate(Context context, GLSurfaceView gLSurfaceView) {
        this.f49528a = context;
        this.f49529b = gLSurfaceView;
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        this.f49530c = renderer;
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        if (Build.VERSION.SDK_INT >= 16) {
            m37114a();
        }
        GLSurfaceView.Renderer renderer = this.f49530c;
        if (renderer != null) {
            renderer.onSurfaceCreated(gl10, eGLConfig);
        }
        onSurfaceCreated(gl10, eGLConfig, this.f49534g);
    }

    public boolean setRecordVideo(boolean z, int i, int i2, boolean z2, float f, int i3) {
        this.f49535h = z;
        if (Build.VERSION.SDK_INT < 18) {
            this.f49535h = false;
            return false;
        }
        if (this.f49535h) {
            DiFaceVideoCaptureManager diFaceVideoCaptureManager = new DiFaceVideoCaptureManager(i, i2, z2, this.f49529b, f, i3);
            this.f49531d = diFaceVideoCaptureManager;
            diFaceVideoCaptureManager.setListener(this.f49540m);
        }
        return this.f49535h;
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
        Matrix.frustumM(this.f49538k, 0, -1.0f, 1.0f, -1.0f, 1.0f, 3.0f, 7.0f);
        GLSurfaceView.Renderer renderer = this.f49530c;
        if (renderer != null) {
            renderer.onSurfaceChanged(gl10, i, i2);
        }
    }

    public void onDrawFrame(GL10 gl10) {
        try {
            GLES20.glClear(16640);
            Matrix.setLookAtM(this.f49539l, 0, 0.0f, 0.0f, -3.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
            Matrix.multiplyMM(this.f49537j, 0, this.f49538k, 0, this.f49539l, 0);
            this.f49534g.updateTexImage();
            float[] fArr = new float[16];
            this.f49534g.getTransformMatrix(fArr);
            this.f49532e.draw(fArr);
            this.f49534g.updateTexImage();
            if (this.f49535h && this.f49531d != null) {
                synchronized (this) {
                    this.f49531d.frameAvailable(fArr);
                }
            }
            if (this.f49530c != null) {
                this.f49530c.onDrawFrame(gl10);
            }
        } catch (Throwable th) {
            SystemUtils.log(6, "af_default ", "onDrawFrame: ", th, "com.didichuxing.dfbasesdk.video_capture.RendererDecorate", 116);
        }
    }

    /* renamed from: a */
    private void m37114a() {
        this.f49533f = OpenGLUtil.createTextureID();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f49533f);
        this.f49534g = surfaceTexture;
        this.f49536i = true;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                if (RendererDecorate.this.f49529b != null) {
                    RendererDecorate.this.f49529b.requestRender();
                }
            }
        });
        this.f49532e = new CameraMatrix(this.f49533f);
    }

    public void startRecord() {
        String str;
        StringBuilder sb;
        boolean z;
        DiFaceVideoCaptureManager diFaceVideoCaptureManager;
        if (!this.f49535h || (diFaceVideoCaptureManager = this.f49531d) == null || !this.f49536i) {
            IErrorListener iErrorListener = this.f49540m;
            if (iErrorListener != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("startRecord failed : ");
                if (!this.f49535h) {
                    sb = new StringBuilder();
                    sb.append("isRecordVideo is ");
                    z = this.f49535h;
                } else if (this.f49531d == null) {
                    str = " mediaManager == null ";
                    sb2.append(str);
                    iErrorListener.onError(sb2.toString());
                    return;
                } else {
                    sb = this.f49536i ? new StringBuilder() : new StringBuilder();
                    sb.append(" surfaceCreate is ");
                    z = this.f49536i;
                }
                sb.append(z);
                str = sb.toString();
                sb2.append(str);
                iErrorListener.onError(sb2.toString());
                return;
            }
            return;
        }
        diFaceVideoCaptureManager.startRecording(this.f49528a, this.f49533f);
    }

    public void stopCapture() {
        DiFaceVideoCaptureManager diFaceVideoCaptureManager;
        if (this.f49535h && (diFaceVideoCaptureManager = this.f49531d) != null && diFaceVideoCaptureManager.isRecording()) {
            this.f49531d.stopRecording();
        }
    }

    public String getVideoPath() {
        DiFaceVideoCaptureManager diFaceVideoCaptureManager;
        if (!this.f49535h || (diFaceVideoCaptureManager = this.f49531d) == null || !diFaceVideoCaptureManager.isRecording()) {
            return "";
        }
        this.f49531d.stopRecording();
        return this.f49531d.getVideoPath();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f49531d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isRecordVideo() {
        /*
            r1 = this;
            boolean r0 = r1.f49535h
            if (r0 == 0) goto L_0x0010
            com.didichuxing.dfbasesdk.video_capture.DiFaceVideoCaptureManager r0 = r1.f49531d
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isRecording()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.dfbasesdk.video_capture.RendererDecorate.isRecordVideo():boolean");
    }

    public IErrorListener getListener() {
        return this.f49540m;
    }

    public void setListener(IErrorListener iErrorListener) {
        DiFaceVideoCaptureManager diFaceVideoCaptureManager;
        this.f49540m = iErrorListener;
        if (Build.VERSION.SDK_INT >= 16 && (diFaceVideoCaptureManager = this.f49531d) != null) {
            diFaceVideoCaptureManager.setListener(iErrorListener);
        }
    }
}
