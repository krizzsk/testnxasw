package com.didichuxing.dfbasesdk.utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import com.didichuxing.dfbasesdk.AppContextHolder;

public class IMediaPlayer {

    /* renamed from: c */
    private static IMediaPlayer f49400c;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MediaPlayer f49401a = new MediaPlayer();

    /* renamed from: b */
    private int f49402b;

    public static IMediaPlayer getInstance() {
        if (f49400c == null) {
            synchronized (IMediaPlayer.class) {
                if (f49400c == null) {
                    f49400c = new IMediaPlayer();
                }
            }
        }
        return f49400c;
    }

    private IMediaPlayer() {
    }

    public void release() {
        synchronized (IMediaPlayer.class) {
            if (this.f49401a != null) {
                this.f49401a.reset();
                this.f49401a.release();
                this.f49401a = null;
            }
            f49400c = null;
        }
    }

    public void reset() {
        MediaPlayer mediaPlayer = this.f49401a;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
    }

    public void doPlay(int i) {
        Context appContext;
        if (this.f49401a != null && (appContext = AppContextHolder.getAppContext()) != null && i != 0) {
            if (this.f49402b == i) {
                LogUtils.m37051d("ignore the same sound!!!");
                return;
            }
            this.f49402b = i;
            this.f49401a.reset();
            try {
                AssetFileDescriptor openRawResourceFd = appContext.getResources().openRawResourceFd(i);
                this.f49401a.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                this.f49401a.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        try {
                            IMediaPlayer.this.f49401a.start();
                        } catch (IllegalStateException e) {
                            LogUtils.logStackTrace(e);
                        }
                    }
                });
                this.f49401a.prepareAsync();
            } catch (Exception e) {
                LogUtils.logStackTrace(e);
            }
        }
    }
}
