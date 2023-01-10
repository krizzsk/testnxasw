package com.didi.safety.god.util;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import com.didichuxing.dfbasesdk.AppContextHolder;

public class IMediaPlayer {

    /* renamed from: c */
    private static IMediaPlayer f37604c;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MediaPlayer f37605a = new MediaPlayer();

    /* renamed from: b */
    private int f37606b;

    public static IMediaPlayer getInstance() {
        if (f37604c == null) {
            f37604c = new IMediaPlayer();
        }
        return f37604c;
    }

    private IMediaPlayer() {
    }

    public void release() {
        MediaPlayer mediaPlayer = this.f37605a;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.f37605a.release();
            this.f37605a = null;
        }
        f37604c = null;
    }

    public void reset() {
        MediaPlayer mediaPlayer = this.f37605a;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
    }

    public void doPlay(int i) {
        Context appContext;
        if (this.f37605a != null && (appContext = AppContextHolder.getAppContext()) != null && i != 0) {
            if (this.f37606b == i) {
                LogUtils.m28307d("ignore the same sound!!!");
                return;
            }
            this.f37606b = i;
            this.f37605a.reset();
            try {
                AssetFileDescriptor openRawResourceFd = appContext.getResources().openRawResourceFd(i);
                this.f37605a.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                this.f37605a.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        try {
                            IMediaPlayer.this.f37605a.start();
                        } catch (IllegalStateException e) {
                            LogUtils.logStackTrace(e);
                        }
                    }
                });
                this.f37605a.prepareAsync();
            } catch (Exception e) {
                LogUtils.logStackTrace(e);
            }
        }
    }
}
