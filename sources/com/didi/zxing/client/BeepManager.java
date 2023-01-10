package com.didi.zxing.client;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.SystemClock;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.io.IOException;

public final class BeepManager {

    /* renamed from: a */
    private static final String f48118a = "BeepManager";

    /* renamed from: b */
    private static final float f48119b = 0.1f;

    /* renamed from: c */
    private static final long f48120c = 200;

    /* renamed from: d */
    private static final int f48121d = 2000;

    /* renamed from: e */
    private final Context f48122e;

    /* renamed from: f */
    private boolean f48123f = true;

    /* renamed from: g */
    private boolean f48124g = false;

    /* renamed from: h */
    private long f48125h;

    public BeepManager(Context context) {
        this.f48122e = context.getApplicationContext();
    }

    public boolean isBeepEnabled() {
        return this.f48123f;
    }

    public void setBeepEnabled(boolean z) {
        this.f48123f = z;
    }

    public boolean isVibrateEnabled() {
        return this.f48124g;
    }

    public void setVibrateEnabled(boolean z) {
        this.f48124g = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void playBeepSoundAndVibrate() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.m36098a()     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r3)
            return
        L_0x0009:
            boolean r0 = r3.f48123f     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0010
            r3.playBeepSound()     // Catch:{ all -> 0x0025 }
        L_0x0010:
            boolean r0 = r3.f48124g     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0023
            android.content.Context r0 = r3.f48122e     // Catch:{ all -> 0x0025 }
            java.lang.String r1 = "vibrator"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch:{ all -> 0x0025 }
            android.os.Vibrator r0 = (android.os.Vibrator) r0     // Catch:{ all -> 0x0025 }
            r1 = 200(0xc8, double:9.9E-322)
            r0.vibrate(r1)     // Catch:{ all -> 0x0025 }
        L_0x0023:
            monitor-exit(r3)
            return
        L_0x0025:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.zxing.client.BeepManager.playBeepSoundAndVibrate():void");
    }

    /* renamed from: a */
    private boolean m36098a() {
        if (SystemClock.elapsedRealtime() - this.f48125h < 2000) {
            return false;
        }
        this.f48125h = SystemClock.elapsedRealtime();
        return true;
    }

    public MediaPlayer playBeepSound() {
        AssetFileDescriptor openRawResourceFd;
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(3);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                SystemUtils.log(5, BeepManager.f48118a, "Failed to beep " + i + ", " + i2, (Throwable) null, "com.didi.zxing.client.BeepManager$2", 116);
                mediaPlayer.stop();
                mediaPlayer.release();
                return true;
            }
        });
        try {
            openRawResourceFd = this.f48122e.getResources().openRawResourceFd(R.raw.zxing_beep);
            mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
            openRawResourceFd.close();
            mediaPlayer.setVolume(0.1f, 0.1f);
            mediaPlayer.prepare();
            mediaPlayer.start();
            return mediaPlayer;
        } catch (IOException e) {
            Log.w(f48118a, e);
            mediaPlayer.release();
            return null;
        } catch (Throwable th) {
            openRawResourceFd.close();
            throw th;
        }
    }
}
