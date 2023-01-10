package com.didi.safety.god.p145ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RelativeLayout;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.safety.god.http.SafetyTraceEventHandler;
import com.didi.safety.god.manager.GodManager;
import com.didi.safety.god.mediacodec.MediaHelper;
import com.didi.safety.god.p145ui.ImageDetector;
import com.didi.safety.god.util.CameraMatrix;
import com.didi.safety.god.util.FileUtils;
import com.didi.safety.god.util.ICamera;
import com.didi.safety.god.util.ImageUtils;
import com.didi.safety.god.util.LogUtils;
import com.didi.sdk.util.ToastHelper;
import com.didi.sec.algo.RawDetectInfo;
import com.didichuxing.dfbasesdk.utils.OpenGLUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.didi.safety.god.ui.GLSurfaceRecorder */
public class GLSurfaceRecorder implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer, MediaHelper.OnVideoRecordListener, ImageDetector.DetectionListener {
    public static final int FRAME_PRE_SECOND = 25;

    /* renamed from: w */
    private static final int f37494w = 3;

    /* renamed from: a */
    VideoInfo f37495a;
    protected Activity activity;

    /* renamed from: b */
    private final float[] f37496b = new float[16];

    /* renamed from: c */
    private final float[] f37497c = new float[16];
    protected volatile boolean captureOnce;

    /* renamed from: d */
    private final float[] f37498d = new float[16];

    /* renamed from: e */
    private SurfaceTexture f37499e;

    /* renamed from: f */
    private CameraMatrix f37500f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public MediaHelper f37501g;

    /* renamed from: h */
    private int f37502h;
    protected int height;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public volatile boolean f37503i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public PicInfo f37504j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ImageDetector f37505k;

    /* renamed from: l */
    private long f37506l;

    /* renamed from: m */
    private Handler f37507m = new Handler(Looper.myLooper());
    protected GLSurfaceView mGLCameraview;
    protected ICamera mICamera;
    protected int mTextureID = 0;
    protected volatile boolean manualCapture;

    /* renamed from: n */
    private String f37508n;

    /* renamed from: o */
    private AtomicInteger f37509o = new AtomicInteger();

    /* renamed from: p */
    private long f37510p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f37511q;

    /* renamed from: r */
    private byte[] f37512r;
    protected RecordListener recordListener;

    /* renamed from: s */
    private long f37513s = 0;
    protected boolean systemRecord;

    /* renamed from: t */
    private RawDetectInfo f37514t;
    protected int timeoutSec;

    /* renamed from: u */
    private int f37515u;

    /* renamed from: v */
    private RawDetectInfo[] f37516v;
    protected int videoLength;
    protected int width;

    /* renamed from: com.didi.safety.god.ui.GLSurfaceRecorder$RecordListener */
    public interface RecordListener {
        void onCaptureFinished(PicInfo picInfo);

        void onDetectNoGoodQuality(int i);

        void onDetectNothing();

        void onDetectPosSizeInfo(PosSizeInfo posSizeInfo);

        void onDetectTimeout(File file);

        void onDetectWrongLabel();

        void onFinalInfoWithWrongPosSize(int i, boolean z);

        void onLightnessChecked(float f);

        void onRecordFinish(PicInfo picInfo, VideoInfo videoInfo, ImageDetector.DetectionResult detectionResult, boolean z);

        void onRecordVideoStart(VideoInfo videoInfo);

        void onTimeoutRecord();
    }

    public GLSurfaceRecorder(Activity activity2, GLSurfaceView gLSurfaceView) {
        if (gLSurfaceView != null) {
            this.activity = activity2;
            this.mGLCameraview = gLSurfaceView;
            this.mICamera = new ICamera();
            this.mGLCameraview.setVisibility(0);
            this.mGLCameraview.setEGLContextClientVersion(2);
            this.mGLCameraview.setRenderer(this);
            this.mGLCameraview.setRenderMode(0);
        }
    }

    public void setVideoLength(int i) {
        this.videoLength = i;
    }

    public void setTimeoutSec(int i) {
        this.timeoutSec = i;
    }

    public boolean openCamera() {
        if (this.mICamera.openCamera(this.activity, 0) == null) {
            return false;
        }
        RelativeLayout.LayoutParams layoutParam = this.mICamera.getLayoutParam();
        this.mGLCameraview.setLayoutParams(layoutParam);
        LogUtils.m28307d("GLCameraView layout params w=" + layoutParam.width + ", h=" + layoutParam.height);
        MediaHelper mediaHelper = new MediaHelper(this.mICamera.cameraWidth, this.mICamera.cameraHeight, true, this.mGLCameraview);
        this.f37501g = mediaHelper;
        mediaHelper.setOnVideoRecordListener(this);
        this.mGLCameraview.onResume();
        return true;
    }

    public boolean startDetection(int i, String str, int i2) {
        boolean openCamera = openCamera();
        if (openCamera) {
            m28266i();
            m28263f();
            this.f37505k = new ImageDetector(this, i, i2, this.timeoutSec);
        }
        String str2 = this.f37508n;
        if (str2 != null && !str2.equals(str)) {
            m28252a(this.f37508n, str);
        }
        this.f37508n = str;
        return openCamera;
    }

    /* renamed from: a */
    private void m28252a(String str, String str2) {
        LogUtils.m28307d("onLabelSwitch, old===" + str + ", new=" + str2);
        this.f37515u = 0;
        this.f37516v = null;
    }

    public void restart(int i, String str, int i2) {
        m28263f();
        this.f37505k = new ImageDetector(this, i, i2, this.timeoutSec);
    }

    public void closeCamera() {
        this.mICamera.closeCamera();
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.mGLCameraview.requestRender();
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        System.out.println("onSurfaceCreated===");
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        m28260d();
    }

    /* renamed from: d */
    private void m28260d() {
        this.mTextureID = OpenGLUtil.createTextureID();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureID);
        this.f37499e = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.f37500f = new CameraMatrix(this.mTextureID);
        startPreview();
    }

    public void startPreview() {
        this.mICamera.startPreview(this.f37499e);
        this.mICamera.setPreviewCallback(this);
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        System.out.println("onSurfaceChanged===");
        GLES20.glViewport(0, 0, i, i2);
        Matrix.frustumM(this.f37497c, 0, -1.0f, 1.0f, -1.0f, 1.0f, 3.0f, 7.0f);
    }

    public void startAutoFocus(int i) {
        this.mICamera.autoFocus(i);
    }

    public void refocus() {
        this.mICamera.refocus(GodManager.getInstance().getConfig().delayedFocusTime);
    }

    public void onDrawFrame(GL10 gl10) {
        try {
            GLES20.glClear(16640);
            Matrix.setLookAtM(this.f37498d, 0, 0.0f, 0.0f, -3.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
            Matrix.multiplyMM(this.f37496b, 0, this.f37497c, 0, this.f37498d, 0);
            this.f37499e.updateTexImage();
            float[] fArr = new float[16];
            this.f37499e.getTransformMatrix(fArr);
            this.f37500f.draw(fArr);
            this.f37499e.updateTexImage();
            synchronized (this) {
                if (this.f37503i && this.mICamera.hasFocus) {
                    if (this.f37502h == 0) {
                        this.f37506l = System.currentTimeMillis();
                    } else if (System.currentTimeMillis() - this.f37506l <= ((long) ((int) (((float) (this.videoLength * 1000)) * 1.2f)))) {
                        this.f37501g.frameAvailable(fArr);
                    } else {
                        mo96331b();
                    }
                    this.f37502h++;
                }
            }
        } catch (Throwable th) {
            LogUtils.logStackTrace(th);
        }
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (bArr == null || bArr.length == 0) {
            LogUtils.m28307d("ignore invalid preview callback data...");
            return;
        }
        if (this.f37510p == 0) {
            this.f37513s = System.currentTimeMillis();
        }
        if (GodManager.getInstance().getManualState()) {
            this.f37510p++;
            if (this.height == 0 || this.width == 0) {
                m28262e();
            }
            this.recordListener.onLightnessChecked(System.currentTimeMillis() - this.f37513s < GodManager.getInstance().getConfig().timeOutSec ? GodManager.getInstance().calculateLightness(bArr, this.width, this.height) : 801.0f);
            if (this.manualCapture) {
                this.manualCapture = false;
                m28255b(bArr);
            }
            if (this.f37510p == Long.MAX_VALUE) {
                this.f37510p = 0;
            }
        } else if (this.mICamera.hasFocus) {
            this.f37512r = bArr;
            ImageDetector imageDetector = this.f37505k;
            if (imageDetector != null && !imageDetector.isQuit()) {
                if (this.height == 0 || this.width == 0) {
                    m28262e();
                }
                long j = this.f37510p;
                this.f37510p = 1 + j;
                if (j % 5 == 0) {
                    this.f37505k.pushData(bArr, this.width, this.height);
                }
            }
            if (this.captureOnce) {
                this.captureOnce = false;
                if (this.height == 0 || this.width == 0) {
                    m28262e();
                }
                m28253a(bArr);
            }
            if (this.f37510p == Long.MAX_VALUE) {
                this.f37510p = 0;
            }
        }
    }

    /* renamed from: e */
    private void m28262e() {
        Camera.Size previewSize = this.mICamera.getPreviewSize();
        if (previewSize == null) {
            RelativeLayout.LayoutParams layoutParam = this.mICamera.getLayoutParam();
            this.width = layoutParam.width;
            this.height = layoutParam.height;
            return;
        }
        this.width = previewSize.width;
        this.height = previewSize.height;
    }

    /* renamed from: a */
    private void m28253a(byte[] bArr) {
        File g = m28264g();
        ImageUtils.saveImageData(bArr, this.width, this.height, g);
        m28251a(g, this.f37514t);
        LogUtils.m28313i("save pic info, picInfo = " + this.f37504j);
        RecordListener recordListener2 = this.recordListener;
        if (recordListener2 != null) {
            recordListener2.onRecordFinish(this.f37504j, (VideoInfo) null, ImageDetector.DetectionResult.SUCCESS, false);
        }
    }

    public void startCapture() {
        this.manualCapture = true;
    }

    /* renamed from: b */
    private void m28255b(byte[] bArr) {
        File g = m28264g();
        ImageUtils.saveImageData(bArr, this.width, this.height, g);
        PicInfo a = m28247a(g);
        LogUtils.m28313i("save pic info, picInfo = " + a);
        closeCamera();
        RecordListener recordListener2 = this.recordListener;
        if (recordListener2 != null) {
            recordListener2.onCaptureFinished(a);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28251a(File file, RawDetectInfo rawDetectInfo) {
        PicInfo picInfo = new PicInfo(file, rawDetectInfo == null ? -1.0f : rawDetectInfo.score, rawDetectInfo == null ? -1 : rawDetectInfo.time);
        this.f37504j = picInfo;
        if (rawDetectInfo != null) {
            picInfo.type = rawDetectInfo.label;
            this.f37504j.quality = rawDetectInfo.qScore;
            this.f37504j.bscore = rawDetectInfo.bScore;
            this.f37504j.rscore = rawDetectInfo.rScore;
            this.f37504j.f37517x1 = rawDetectInfo.f41227x1;
            this.f37504j.f37519y1 = rawDetectInfo.f41229y1;
            this.f37504j.f37518x2 = rawDetectInfo.f41228x2;
            this.f37504j.f37520y2 = rawDetectInfo.f41230y2;
        }
    }

    /* renamed from: a */
    private PicInfo m28247a(File file) {
        return new PicInfo(file, -1.0f, -1);
    }

    public void setRecordListener(RecordListener recordListener2) {
        this.recordListener = recordListener2;
    }

    public PicInfo newPicInfo(RawDetectInfo rawDetectInfo, Bitmap bitmap) {
        File g = m28264g();
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(g);
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, new FileOutputStream(g));
                FileUtils.closeQuietly(fileOutputStream2);
            } catch (Exception e) {
                e = e;
                fileOutputStream = fileOutputStream2;
                try {
                    LogUtils.logStackTrace(e);
                    FileUtils.closeQuietly(fileOutputStream);
                    PicInfo picInfo = new PicInfo(g, rawDetectInfo.score, rawDetectInfo.time);
                    picInfo.type = rawDetectInfo.label;
                    picInfo.quality = rawDetectInfo.qScore;
                    picInfo.bscore = rawDetectInfo.bScore;
                    picInfo.rscore = rawDetectInfo.rScore;
                    picInfo.f37517x1 = rawDetectInfo.f41227x1;
                    picInfo.f37519y1 = rawDetectInfo.f41229y1;
                    picInfo.f37518x2 = rawDetectInfo.f41228x2;
                    picInfo.f37520y2 = rawDetectInfo.f41230y2;
                    return picInfo;
                } catch (Throwable th) {
                    th = th;
                    FileUtils.closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                FileUtils.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            LogUtils.logStackTrace(e);
            FileUtils.closeQuietly(fileOutputStream);
            PicInfo picInfo2 = new PicInfo(g, rawDetectInfo.score, rawDetectInfo.time);
            picInfo2.type = rawDetectInfo.label;
            picInfo2.quality = rawDetectInfo.qScore;
            picInfo2.bscore = rawDetectInfo.bScore;
            picInfo2.rscore = rawDetectInfo.rScore;
            picInfo2.f37517x1 = rawDetectInfo.f41227x1;
            picInfo2.f37519y1 = rawDetectInfo.f41229y1;
            picInfo2.f37518x2 = rawDetectInfo.f41228x2;
            picInfo2.f37520y2 = rawDetectInfo.f41230y2;
            return picInfo2;
        }
        PicInfo picInfo22 = new PicInfo(g, rawDetectInfo.score, rawDetectInfo.time);
        picInfo22.type = rawDetectInfo.label;
        picInfo22.quality = rawDetectInfo.qScore;
        picInfo22.bscore = rawDetectInfo.bScore;
        picInfo22.rscore = rawDetectInfo.rScore;
        picInfo22.f37517x1 = rawDetectInfo.f41227x1;
        picInfo22.f37519y1 = rawDetectInfo.f41229y1;
        picInfo22.f37518x2 = rawDetectInfo.f41228x2;
        picInfo22.f37520y2 = rawDetectInfo.f41230y2;
        return picInfo22;
    }

    public void beginRecord() {
        final File c = mo96333c();
        this.f37495a = new VideoInfo(c);
        new Thread(new Runnable() {
            public void run() {
                HashMap hashMap = new HashMap();
                try {
                    hashMap.put("cmd", "FPPVID");
                    hashMap.put("code", 1);
                    GLSurfaceRecorder.this.f37501g.startRecording(GLSurfaceRecorder.this.activity.getApplicationContext(), GLSurfaceRecorder.this.mTextureID, c.getAbsolutePath(), 1.0d);
                    GLSurfaceRecorder.this.mo96330a();
                    boolean unused = GLSurfaceRecorder.this.f37503i = true;
                } catch (Exception e) {
                    hashMap.put("code", 2);
                    hashMap.put(DMWebSocketListener.KEY_ERR_MSG, "face++录制异常，msg===" + e.getMessage());
                    LogUtils.m28309e("mMediaHelper.startRecording exception, msg===" + e.getMessage());
                }
                SafetyTraceEventHandler.trace(hashMap);
            }
        }).start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo96330a() {
        this.f37507m.post(new Runnable() {
            public void run() {
                if (GLSurfaceRecorder.this.recordListener != null) {
                    GLSurfaceRecorder.this.recordListener.onRecordVideoStart(GLSurfaceRecorder.this.f37495a);
                }
            }
        });
    }

    public void recordAndCapture() {
        this.captureOnce = true;
        LogUtils.m28313i("recordAndCapture.......captureOnce = " + this.captureOnce);
        this.f37511q = true;
        beginRecord();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo96331b() {
        LogUtils.m28307d("video record finish...");
        this.f37503i = false;
        this.f37501g.stopRecording();
    }

    /* renamed from: f */
    private void m28263f() {
        LogUtils.m28307d("reset recorder data..............");
        this.f37503i = false;
        this.f37502h = 0;
        this.f37509o.getAndAdd(0);
        this.width = 0;
        this.height = 0;
        this.f37495a = null;
        this.f37504j = null;
        this.f37514t = null;
        this.f37510p = 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public File m28264g() {
        String str;
        if (!TextUtils.isEmpty(this.f37508n)) {
            str = this.f37508n;
        } else {
            str = System.currentTimeMillis() + "" + new Random().nextInt(100);
        }
        return new File(this.activity.getCacheDir(), str + ".jpg");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public File mo96333c() {
        File file = new File(ImageUtils.getVideoCacheDir(this.activity), "log");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, System.currentTimeMillis() + "" + new Random().nextInt(100));
    }

    public void cleanup() {
        LogUtils.m28313i("GLSurfaceRecorder cleanup.....");
        this.mGLCameraview.onPause();
        ICamera iCamera = this.mICamera;
        if (iCamera != null) {
            iCamera.closeCamera();
        }
        ImageDetector imageDetector = this.f37505k;
        if (imageDetector != null) {
            imageDetector.quit();
        }
    }

    public void onDestroy() {
        DetectCoreThread.m28224a().mo96325j();
    }

    public void onDetectLabelDone(boolean z, PosSizeInfo posSizeInfo) {
        if (z) {
            this.recordListener.onDetectWrongLabel();
            m28267j();
            return;
        }
        this.recordListener.onDetectPosSizeInfo(posSizeInfo);
        if (!posSizeInfo.notOk()) {
            LogUtils.m28307d("detect right label with proper pos/size, begin to record video...");
            this.f37505k.mo96393e();
            this.mICamera.doAutoFocus();
            beginRecord();
        }
    }

    /* renamed from: h */
    private RawDetectInfo m28265h() {
        RawDetectInfo[] rawDetectInfoArr = this.f37516v;
        RawDetectInfo rawDetectInfo = rawDetectInfoArr[0];
        float f = -1.0f;
        for (RawDetectInfo rawDetectInfo2 : rawDetectInfoArr) {
            if (rawDetectInfo2.qScore > f) {
                f = rawDetectInfo2.qScore;
                rawDetectInfo = rawDetectInfo2;
            }
        }
        return rawDetectInfo;
    }

    public void onDetectTimeout() {
        m28267j();
        if (this.f37512r != null) {
            File g = m28264g();
            ImageUtils.saveImageData(this.f37512r, this.width, this.height, g);
            if (g.exists()) {
                this.recordListener.onDetectTimeout(g);
            }
        }
    }

    public void onTimeoutRecord() {
        if (!GodManager.getInstance().getManualState()) {
            m28267j();
            this.recordListener.onTimeoutRecord();
        }
    }

    public void onDetectNothing() {
        this.recordListener.onDetectNothing();
    }

    public void onFinish(ImageDetector.DetectionResult detectionResult, RawDetectInfo rawDetectInfo, boolean z) {
        m28267j();
        this.f37514t = rawDetectInfo;
        if (rawDetectInfo == null) {
            LogUtils.m28309e("invalid case, detect info should not be null here!!!");
        } else if (rawDetectInfo.disState > 0 || rawDetectInfo.notCentered) {
            this.recordListener.onFinalInfoWithWrongPosSize(rawDetectInfo.disState, rawDetectInfo.notCentered);
        } else {
            this.mGLCameraview.onPause();
            if (detectionResult == ImageDetector.DetectionResult.SUCCESS) {
                File g = m28264g();
                ImageUtils.saveImageData(rawDetectInfo.data, this.width, this.height, g);
                m28251a(g, this.f37514t);
                LogUtils.m28313i("save pic info by new video process, picInfo = " + this.f37504j);
                this.recordListener.onRecordFinish(this.f37504j, this.f37495a, ImageDetector.DetectionResult.SUCCESS, z);
                return;
            }
            LogUtils.m28309e("should never get here!!!");
        }
    }

    /* renamed from: i */
    private void m28266i() {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "REALCAPTURE");
        SafetyTraceEventHandler.trace(hashMap);
    }

    /* renamed from: j */
    private void m28267j() {
        this.f37505k.quit();
    }

    public void pauseDetect() {
        ImageDetector imageDetector = this.f37505k;
        if (imageDetector != null) {
            imageDetector.mo96391c();
        }
    }

    public void resumeDetect() {
        ImageDetector imageDetector = this.f37505k;
        if (imageDetector != null) {
            imageDetector.mo96392d();
        }
    }

    public void onVideoReady() {
        HashMap hashMap = new HashMap();
        hashMap.put("videoRecordWay", 1);
        hashMap.put("message", "begin_upload_video");
        hashMap.put("code", 8);
        SafetyTraceEventHandler.trace(hashMap);
        this.f37507m.postDelayed(new Runnable() {
            public void run() {
                if (GLSurfaceRecorder.this.f37511q) {
                    if (GLSurfaceRecorder.this.recordListener != null) {
                        GLSurfaceRecorder.this.recordListener.onRecordFinish(GLSurfaceRecorder.this.f37504j, GLSurfaceRecorder.this.f37495a, ImageDetector.DetectionResult.SUCCESS, false);
                    }
                    boolean unused = GLSurfaceRecorder.this.f37511q = false;
                } else if (GLSurfaceRecorder.this.systemRecord) {
                    if (GLSurfaceRecorder.this.f37504j == null) {
                        File d = GLSurfaceRecorder.this.m28264g();
                        RawDetectInfo b = GLSurfaceRecorder.this.f37505k.mo96390b();
                        ImageUtils.saveImageData(b.data, GLSurfaceRecorder.this.width, GLSurfaceRecorder.this.height, d);
                        GLSurfaceRecorder.this.m28251a(d, b);
                        LogUtils.m28307d("save pic info after system record done.");
                    }
                    if (GLSurfaceRecorder.this.recordListener != null) {
                        GLSurfaceRecorder.this.recordListener.onRecordFinish(GLSurfaceRecorder.this.f37504j, GLSurfaceRecorder.this.f37495a, ImageDetector.DetectionResult.SUCCESS, false);
                    }
                    GLSurfaceRecorder.this.systemRecord = false;
                } else {
                    GLSurfaceRecorder.this.f37505k.mo96394f();
                }
            }
        }, 1000);
    }

    public void onRecordException(Exception exc) {
        mo96331b();
        File videoFile = this.f37495a.getVideoFile();
        if (videoFile != null && videoFile.exists()) {
            videoFile.delete();
        }
        this.f37507m.post(new Runnable() {
            public void run() {
                ToastHelper.showShortInfo((Context) GLSurfaceRecorder.this.activity, "系统异常，拍摄失败");
                GLSurfaceRecorder.this.m28248a(2000);
            }
        });
        HashMap hashMap = new HashMap();
        hashMap.put(DMWebSocketListener.KEY_ERR_MSG, "录制视频异常: " + Log.getStackTraceString(exc));
        hashMap.put("code", 7);
        SafetyTraceEventHandler.trace(hashMap);
    }

    public void torchOn() {
        this.mICamera.torchOn();
    }

    public void torchOff() {
        this.mICamera.torchOff();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28248a(long j) {
        this.f37507m.postDelayed(new Runnable() {
            public void run() {
                GLSurfaceRecorder.this.activity.finish();
            }
        }, j);
    }

    /* renamed from: com.didi.safety.god.ui.GLSurfaceRecorder$PicInfo */
    public static class PicInfo {
        public float bscore;
        public boolean noGoodQ3Times;
        public File path;
        public float quality;
        public float rscore;
        public float score;
        public long time;
        public int type;

        /* renamed from: x1 */
        public int f37517x1;

        /* renamed from: x2 */
        public int f37518x2;

        /* renamed from: y1 */
        public int f37519y1;

        /* renamed from: y2 */
        public int f37520y2;

        private PicInfo(File file, float f, long j) {
            this.quality = -1.0f;
            this.bscore = -1.0f;
            this.rscore = -1.0f;
            this.f37517x1 = -1;
            this.f37519y1 = -1;
            this.f37518x2 = -1;
            this.f37520y2 = -1;
            this.path = file;
            this.time = j;
            this.score = f;
        }

        public boolean isXYValid() {
            return (this.f37517x1 == -1 || this.f37519y1 == -1 || this.f37518x2 == -1 || this.f37520y2 == -1) ? false : true;
        }

        public String toString() {
            return "PicInfo{path=" + this.path + ",score=" + this.score + "}";
        }

        public String getStatsInfo() {
            return this.type + ", " + String.format(Locale.CHINA, "%.6f, %.6f, %.6f, %.6f", new Object[]{Float.valueOf(this.score), Float.valueOf(this.quality), Float.valueOf(this.bscore), Float.valueOf(this.rscore)});
        }
    }

    /* renamed from: com.didi.safety.god.ui.GLSurfaceRecorder$VideoInfo */
    public static class VideoInfo {
        private File videoFile;

        VideoInfo(File file) {
            this.videoFile = file;
        }

        public File getVideoFile() {
            return new File(this.videoFile.getAbsoluteFile() + ".log");
        }

        public String toString() {
            if (this.videoFile == null) {
                return "";
            }
            return this.videoFile.getAbsolutePath() + ".log";
        }
    }
}
