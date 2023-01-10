package com.didichuxing.diface.core;

import android.hardware.Camera;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.didi.sdk.util.UiThreadHandler;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import java.util.Timer;
import java.util.TimerTask;

public class DiFaceVideoManager {

    /* renamed from: a */
    private MediaRecorder f50068a;

    /* renamed from: b */
    private boolean f50069b;

    /* renamed from: c */
    private int f50070c = 1280;

    /* renamed from: d */
    private int f50071d = 720;

    /* renamed from: e */
    private Timer f50072e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f50073f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public MediaPlayer f50074g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f50075h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Timer f50076i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public IVideoProgressListener f50077j;

    public interface ITimerCallback {
        void onTick(int i);
    }

    public interface IVideoProgressListener {
        void onCompletion();

        void onProgress(int i);

        void onStart(int i);

        void onStop();
    }

    /* renamed from: a */
    static /* synthetic */ int m37449a(DiFaceVideoManager diFaceVideoManager) {
        int i = diFaceVideoManager.f50073f;
        diFaceVideoManager.f50073f = i - 1;
        return i;
    }

    public boolean isStartRecord() {
        return this.f50069b;
    }

    public void initRecordParam(int i, int i2) {
        this.f50070c = i;
        this.f50071d = i2;
    }

    public void record(Camera camera, int i, Surface surface, String str) {
        record(camera, i, surface, str, -1, (ITimerCallback) null);
    }

    public void record(Camera camera, int i, Surface surface, String str, int i2, ITimerCallback iTimerCallback) {
        if (!this.f50069b) {
            try {
                if (this.f50068a == null) {
                    this.f50068a = new MediaRecorder();
                }
                camera.unlock();
                this.f50068a.setCamera(camera);
                this.f50068a.setAudioSource(1);
                this.f50068a.setVideoSource(1);
                this.f50068a.setOutputFormat(2);
                this.f50068a.setAudioEncoder(1);
                this.f50068a.setVideoEncoder(2);
                this.f50068a.setVideoSize(this.f50070c, this.f50071d);
                this.f50068a.setVideoFrameRate(30);
                this.f50068a.setVideoEncodingBitRate(3145728);
                this.f50068a.setOrientationHint(i);
                this.f50068a.setPreviewDisplay(surface);
                this.f50068a.setOutputFile(str);
                this.f50068a.prepare();
                this.f50068a.start();
                this.f50069b = true;
                if (i2 != -1) {
                    m37452a(i2, iTimerCallback);
                }
            } catch (Exception e) {
                LogUtils.m37051d("start record failed: " + e.getMessage());
            }
        }
    }

    public void stopRecord() {
        if (this.f50069b) {
            try {
                this.f50068a.stop();
                this.f50068a.reset();
                this.f50068a.release();
                this.f50068a = null;
                this.f50069b = false;
                m37451a();
            } catch (Exception e) {
                LogUtils.m37051d("stop record failed: " + e.getMessage());
            }
        }
    }

    /* renamed from: a */
    private void m37452a(int i, final ITimerCallback iTimerCallback) {
        this.f50073f = i;
        if (this.f50072e == null) {
            this.f50072e = new Timer();
        }
        this.f50072e.schedule(new TimerTask() {
            public void run() {
                DiFaceVideoManager.m37449a(DiFaceVideoManager.this);
                UiThreadHandler.post(new Runnable() {
                    public void run() {
                        if (iTimerCallback != null) {
                            iTimerCallback.onTick(DiFaceVideoManager.this.f50073f);
                        }
                        if (DiFaceVideoManager.this.f50073f == 0) {
                            DiFaceVideoManager.this.stopRecord();
                        }
                    }
                });
            }
        }, 1000, 1000);
    }

    /* renamed from: a */
    private synchronized void m37451a() {
        if (this.f50072e != null) {
            this.f50072e.cancel();
            this.f50072e.purge();
            this.f50072e = null;
        }
    }

    public void startPlay(String str, SurfaceHolder surfaceHolder) {
        startPlay(str, surfaceHolder, true, (IVideoProgressListener) null);
    }

    public void startPlay(String str, SurfaceHolder surfaceHolder, final boolean z, IVideoProgressListener iVideoProgressListener) {
        if (!this.f50075h) {
            this.f50077j = iVideoProgressListener;
            try {
                if (this.f50074g == null) {
                    this.f50074g = new MediaPlayer();
                }
                this.f50074g.setDataSource(str);
                this.f50074g.setDisplay(surfaceHolder);
                this.f50074g.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        if (DiFaceVideoManager.this.f50077j != null) {
                            DiFaceVideoManager.this.f50077j.onCompletion();
                        }
                        if (z) {
                            DiFaceVideoManager.this.f50074g.seekTo(0);
                            DiFaceVideoManager.this.f50074g.start();
                            return;
                        }
                        DiFaceVideoManager.this.stopPlay();
                    }
                });
                this.f50074g.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        if (DiFaceVideoManager.this.f50077j != null) {
                            DiFaceVideoManager.this.f50077j.onStart(DiFaceVideoManager.this.f50074g.getDuration());
                        }
                        mediaPlayer.start();
                        boolean unused = DiFaceVideoManager.this.f50075h = true;
                        if (DiFaceVideoManager.this.f50076i == null) {
                            Timer unused2 = DiFaceVideoManager.this.f50076i = new Timer();
                            DiFaceVideoManager.this.f50076i.schedule(new TimerTask() {
                                public void run() {
                                    UiThreadHandler.post(new Runnable() {
                                        public void run() {
                                            if (DiFaceVideoManager.this.f50077j != null && DiFaceVideoManager.this.f50074g != null) {
                                                DiFaceVideoManager.this.f50077j.onProgress(DiFaceVideoManager.this.f50074g.getCurrentPosition());
                                            }
                                        }
                                    });
                                }
                            }, 0, 1000);
                        }
                    }
                });
                this.f50074g.prepareAsync();
            } catch (Exception e) {
                LogUtils.m37051d("play video error: " + e.getMessage());
            }
        }
    }

    public void stopPlay() {
        if (this.f50075h) {
            IVideoProgressListener iVideoProgressListener = this.f50077j;
            if (iVideoProgressListener != null) {
                iVideoProgressListener.onStop();
            }
            this.f50076i.cancel();
            this.f50076i.purge();
            this.f50076i = null;
            this.f50074g.stop();
            this.f50074g.release();
            this.f50074g = null;
            this.f50075h = false;
        }
    }
}
