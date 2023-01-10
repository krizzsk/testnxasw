package com.didi.safety.god.p145ui;

import android.app.Activity;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.safety.god.http.SafetyTraceEventHandler;
import com.didi.safety.god.p145ui.GLSurfaceRecorder;
import com.didi.safety.god.util.LogUtils;
import java.io.File;
import java.util.HashMap;

/* renamed from: com.didi.safety.god.ui.GLSurfaceRecorder2 */
public class GLSurfaceRecorder2 extends GLSurfaceRecorder {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public volatile MediaRecorder f37521b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Handler f37522c;

    /* renamed from: d */
    private HandlerThread f37523d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public volatile boolean f37524e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Runnable f37525f = new Runnable() {
        public void run() {
            if (!GLSurfaceRecorder2.this.f37524e) {
                boolean unused = GLSurfaceRecorder2.this.f37524e = true;
                try {
                    GLSurfaceRecorder2.this.f37521b.stop();
                    GLSurfaceRecorder2.this.f37521b.reset();
                    GLSurfaceRecorder2.this.f37521b.release();
                    MediaRecorder unused2 = GLSurfaceRecorder2.this.f37521b = null;
                } catch (Exception e) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("cmd", "RECORDVID");
                    hashMap.put("code", 6);
                    hashMap.put(DMWebSocketListener.KEY_ERR_MSG, "停止录制视频出现异常,e = " + e.getMessage());
                    SafetyTraceEventHandler.trace(hashMap, GLSurfaceRecorder2.this.activity);
                    LogUtils.m28309e("stop recording exception, e = " + e.getMessage());
                } catch (Throwable th) {
                    LogUtils.m28307d("real stop video done===");
                    GLSurfaceRecorder2.this.mo96331b();
                    throw th;
                }
                LogUtils.m28307d("real stop video done===");
                GLSurfaceRecorder2.this.mo96331b();
            }
        }
    };

    public GLSurfaceRecorder2(Activity activity, GLSurfaceView gLSurfaceView) {
        super(activity, gLSurfaceView);
    }

    /* renamed from: d */
    private boolean m28278d() {
        return Build.VERSION.SDK_INT >= 18;
    }

    public void beginRecord() {
        if (m28278d()) {
            super.beginRecord();
            return;
        }
        if (this.f37523d == null) {
            HandlerThread handlerThread = new HandlerThread("god_camera");
            this.f37523d = handlerThread;
            handlerThread.start();
            this.f37522c = new Handler(this.f37523d.getLooper());
        }
        this.f37524e = false;
        this.systemRecord = true;
        this.f37522c.post(new Runnable() {
            public void run() {
                if (GLSurfaceRecorder2.this.captureOnce) {
                    LogUtils.m28307d("........ capturing now,wait to next frame.....");
                    GLSurfaceRecorder2.this.f37522c.postDelayed(this, 25);
                    return;
                }
                File c = GLSurfaceRecorder2.this.mo96333c();
                GLSurfaceRecorder2.this.f37495a = new GLSurfaceRecorder.VideoInfo(c);
                String str = c.getAbsolutePath() + ".log";
                Camera camera = GLSurfaceRecorder2.this.mICamera.getCamera();
                try {
                    camera.unlock();
                    MediaRecorder unused = GLSurfaceRecorder2.this.f37521b = new MediaRecorder();
                    GLSurfaceRecorder2.this.f37521b.setCamera(camera);
                    GLSurfaceRecorder2.this.f37521b.setAudioSource(0);
                    GLSurfaceRecorder2.this.f37521b.setVideoSource(1);
                    GLSurfaceRecorder2.this.f37521b.setOutputFormat(2);
                    GLSurfaceRecorder2.this.f37521b.setAudioEncoder(1);
                    GLSurfaceRecorder2.this.f37521b.setVideoEncoder(2);
                    GLSurfaceRecorder2.this.f37521b.setVideoEncodingBitRate(1556480);
                    GLSurfaceRecorder2.this.f37521b.setVideoSize(GLSurfaceRecorder2.this.mICamera.cameraWidth, GLSurfaceRecorder2.this.mICamera.cameraHeight);
                    GLSurfaceRecorder2.this.f37521b.setOutputFile(str);
                    GLSurfaceRecorder2.this.f37521b.prepare();
                    GLSurfaceRecorder2.this.f37521b.start();
                    GLSurfaceRecorder2.this.f37522c.removeCallbacks(GLSurfaceRecorder2.this.f37525f);
                    GLSurfaceRecorder2.this.f37522c.postDelayed(GLSurfaceRecorder2.this.f37525f, (long) ((GLSurfaceRecorder2.this.videoLength + 1) * 1000));
                    LogUtils.m28307d("begin system video record, path = " + str);
                    GLSurfaceRecorder2.this.mo96330a();
                } catch (Exception e) {
                    LogUtils.m28309e("system video record start error, msg===" + e.getMessage());
                    try {
                        GLSurfaceRecorder2.this.f37521b.release();
                    } catch (Exception e2) {
                        LogUtils.logStackTrace(e2);
                    }
                    MediaRecorder unused2 = GLSurfaceRecorder2.this.f37521b = null;
                    HashMap hashMap = new HashMap();
                    hashMap.put("cmd", "RECORDVID");
                    hashMap.put("code", 5);
                    hashMap.put(DMWebSocketListener.KEY_ERR_MSG, "打开系统Recorder失败, msg===" + e.getMessage());
                    SafetyTraceEventHandler.trace(hashMap, GLSurfaceRecorder2.this.activity);
                }
            }
        });
    }

    /* renamed from: a */
    private void m28272a(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "VIDCODEC");
        StringBuilder sb = new StringBuilder("(");
        sb.append(i);
        try {
            CamcorderProfile camcorderProfile = CamcorderProfile.get(0);
            CamcorderProfile camcorderProfile2 = CamcorderProfile.get(1);
            int i2 = -1;
            int i3 = camcorderProfile != null ? camcorderProfile.videoCodec : -1;
            if (camcorderProfile2 != null) {
                i2 = camcorderProfile2.videoCodec;
            }
            sb.append(", ");
            sb.append(i3);
            sb.append(", ");
            sb.append(i2);
        } catch (Throwable th) {
            hashMap.put(DMWebSocketListener.KEY_ERR_MSG, th.getMessage());
        }
        sb.append(")");
        hashMap.put("info", sb.toString());
        SafetyTraceEventHandler.trace(hashMap);
    }

    public void cleanup() {
        super.cleanup();
        if (this.f37521b != null && !this.f37524e) {
            LogUtils.m28307d("stop video unexpected===");
            Handler handler = this.f37522c;
            if (handler != null) {
                handler.removeCallbacks(this.f37525f);
                this.f37522c.postAtFrontOfQueue(this.f37525f);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f37523d == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            this.f37523d.quitSafely();
        } else {
            this.f37523d.quit();
        }
    }
}
