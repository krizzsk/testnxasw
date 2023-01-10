package com.didi.beatles.p101im.common;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import com.didi.beatles.p101im.IMCommonContextInfoHelper;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.security.wireless.ISecurityConf;

/* renamed from: com.didi.beatles.im.common.IMBtsAudioPlayer */
public class IMBtsAudioPlayer {

    /* renamed from: a */
    private static final String f10970a = IMBtsAudioPlayer.class.getSimpleName();

    /* renamed from: b */
    private static MediaPlayer f10971b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static OnAudioPlayingListener f10972c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static AudioManager f10973d;

    /* renamed from: e */
    private static SensorManager f10974e;

    /* renamed from: f */
    private static Sensor f10975f;

    /* renamed from: g */
    private static SensorEventListener f10976g;

    /* renamed from: h */
    private static String f10977h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static int f10978i = -1;

    /* renamed from: j */
    private static boolean f10979j;

    /* renamed from: com.didi.beatles.im.common.IMBtsAudioPlayer$OnAudioPlayingListener */
    public interface OnAudioPlayingListener {
        void onCompletion();

        void onError(String str);

        void onStarted();

        void onStop();
    }

    /* renamed from: com.didi.beatles.im.common.IMBtsAudioPlayer$onVoiceChannelChangeListener */
    public interface onVoiceChannelChangeListener {
        void onVoiceChannelChanged(int i);
    }

    public static boolean isPlaying() {
        MediaPlayer mediaPlayer = f10971b;
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    public static void initSensor(final onVoiceChannelChangeListener onvoicechannelchangelistener) {
        if (IMCommonContextInfoHelper.getContext() != null) {
            f10973d = (AudioManager) IMCommonContextInfoHelper.getContext().getSystemService("audio");
            if (IMCommonContextInfoHelper.getAudioConfig().useSensor()) {
                SensorManager sensorManager = (SensorManager) IMCommonContextInfoHelper.getContext().getSystemService(ISecurityConf.KEY_SENSOR);
                f10974e = sensorManager;
                if (sensorManager != null) {
                    f10975f = sensorManager.getDefaultSensor(8);
                    f10976g = new SensorEventListener() {
                        public void onAccuracyChanged(Sensor sensor, int i) {
                        }

                        public void onSensorChanged(SensorEvent sensorEvent) {
                            if (IMBtsAudioPlayer.f10973d != null) {
                                if (sensorEvent.values[0] > 0.0f) {
                                    IMBtsAudioPlayer.f10973d.setSpeakerphoneOn(true);
                                    IMBtsAudioPlayer.f10973d.setMode(0);
                                    if (IMBtsAudioPlayer.f10978i != 0) {
                                        int unused = IMBtsAudioPlayer.f10978i = 0;
                                        onVoiceChannelChangeListener onvoicechannelchangelistener = onvoicechannelchangelistener;
                                        if (onvoicechannelchangelistener != null) {
                                            onvoicechannelchangelistener.onVoiceChannelChanged(IMBtsAudioPlayer.f10978i);
                                        }
                                    }
                                } else {
                                    IMBtsAudioPlayer.f10973d.setSpeakerphoneOn(false);
                                    if (Build.VERSION.SDK_INT >= 11) {
                                        IMBtsAudioPlayer.f10973d.setMode(3);
                                    } else {
                                        IMBtsAudioPlayer.f10973d.setMode(2);
                                    }
                                    if (IMBtsAudioPlayer.f10978i != 1) {
                                        int unused2 = IMBtsAudioPlayer.f10978i = 1;
                                        onVoiceChannelChangeListener onvoicechannelchangelistener2 = onvoicechannelchangelistener;
                                        if (onvoicechannelchangelistener2 != null) {
                                            onvoicechannelchangelistener2.onVoiceChannelChanged(IMBtsAudioPlayer.f10978i);
                                        }
                                    }
                                }
                                try {
                                    IMBtsAudioPlayer.m9589b(IMBtsAudioPlayer.f10972c, IMCommonContextInfoHelper.getAudioConfig().getStreamType());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    };
                }
            }
        }
    }

    public static void releaseSensor() {
        if (f10973d != null) {
            f10973d = null;
        }
        if (f10976g != null) {
            f10976g = null;
        }
        if (f10974e != null) {
            f10974e = null;
        }
        if (f10975f != null) {
            f10975f = null;
        }
    }

    public static void play(String str, OnAudioPlayingListener onAudioPlayingListener, boolean z) throws Exception {
        AudioManager audioManager = f10973d;
        if (audioManager == null) {
            IMLog.m10021e(f10970a, C4786I.m9980t(" [play] with null audio manager"));
            return;
        }
        f10977h = str;
        f10972c = onAudioPlayingListener;
        int i = f10978i;
        if (i == 0) {
            audioManager.setSpeakerphoneOn(true);
            f10973d.setMode(0);
        } else if (i == 1) {
            audioManager.setSpeakerphoneOn(false);
            if (Build.VERSION.SDK_INT >= 11) {
                f10973d.setMode(3);
            } else {
                f10973d.setMode(2);
            }
        } else {
            audioManager.setSpeakerphoneOn(true);
            f10973d.setMode(0);
        }
        if (z || f10975f == null || f10974e == null || !IMCommonContextInfoHelper.getAudioConfig().useSensor()) {
            m9589b(f10972c, IMCommonContextInfoHelper.getAudioConfig().getStreamType());
            return;
        }
        f10974e.registerListener(f10976g, f10975f, 3);
        f10979j = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m9589b(OnAudioPlayingListener onAudioPlayingListener, int i) throws Exception {
        MediaPlayer mediaPlayer = f10971b;
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
            f10971b = mediaPlayer;
        }
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            onAudioPlayingListener.onStop();
            mediaPlayer.reset();
        }
        AudioManager audioManager = f10973d;
        if (audioManager != null) {
            audioManager.requestAudioFocus((AudioManager.OnAudioFocusChangeListener) null, i, 2);
        }
        mediaPlayer.setDataSource(f10977h);
        mediaPlayer.setAudioStreamType(i);
        m9586a(mediaPlayer, onAudioPlayingListener);
        mediaPlayer.prepareAsync();
    }

    /* renamed from: a */
    private static void m9586a(MediaPlayer mediaPlayer, final OnAudioPlayingListener onAudioPlayingListener) {
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                OnAudioPlayingListener onAudioPlayingListener = onAudioPlayingListener;
                if (onAudioPlayingListener != null) {
                    onAudioPlayingListener.onStarted();
                }
                mediaPlayer.start();
            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                IMBtsAudioPlayer.release();
                OnAudioPlayingListener onAudioPlayingListener = onAudioPlayingListener;
                if (onAudioPlayingListener != null) {
                    onAudioPlayingListener.onCompletion();
                    if (IMBtsAudioPlayer.f10973d != null) {
                        IMBtsAudioPlayer.f10973d.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
                    }
                }
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                OnAudioPlayingListener onAudioPlayingListener = onAudioPlayingListener;
                onAudioPlayingListener.onError("[player#onError] errorType=" + i + " |errorCode=" + i2);
                return false;
            }
        });
    }

    public static void release() {
        SensorEventListener sensorEventListener;
        SensorManager sensorManager = f10974e;
        if (!(sensorManager == null || (sensorEventListener = f10976g) == null || !f10979j)) {
            sensorManager.unregisterListener(sensorEventListener);
            f10979j = false;
        }
        MediaPlayer mediaPlayer = f10971b;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                f10971b.stop();
            }
            OnAudioPlayingListener onAudioPlayingListener = f10972c;
            if (onAudioPlayingListener != null) {
                onAudioPlayingListener.onStop();
            }
            f10971b.release();
            f10971b = null;
            AudioManager audioManager = f10973d;
            if (audioManager != null) {
                audioManager.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
            }
            f10972c = null;
        }
    }
}
