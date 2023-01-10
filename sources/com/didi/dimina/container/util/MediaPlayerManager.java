package com.didi.dimina.container.util;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import com.didi.dimina.container.util.MediaPlayerManager;
import java.io.IOException;

public class MediaPlayerManager {
    public static final int MEDIA_STATUS_PAUSE = 1;
    public static final int MEDIA_STATUS_PLAY = 0;
    public static final int MEDIA_STATUS_STOP = 2;

    /* renamed from: a */
    private static final String f19817a = "MediaPlayerManager";

    /* renamed from: c */
    private static final int f19818c = 1000;
    public int MEDIA_STATUS = 2;

    /* renamed from: b */
    private MediaPlayer f19819b = new MediaPlayer();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OnMusicProgressListener f19820d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Handler f19821e = new Handler(new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1000 || MediaPlayerManager.this.f19820d == null) {
                return false;
            }
            int currentPosition = MediaPlayerManager.this.getCurrentPosition();
            MediaPlayerManager.this.f19820d.OnProgress(currentPosition, (int) ((((float) currentPosition) / ((float) MediaPlayerManager.this.getDuration())) * 100.0f));
            MediaPlayerManager.this.f19821e.sendEmptyMessageDelayed(1000, 1000);
            return false;
        }
    });

    public interface OnMusicProgressListener {
        void OnProgress(int i, int i2);
    }

    public interface OnMusicStartPlayListener {
        void onStartPlay();
    }

    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.f19819b;
        if (mediaPlayer == null) {
            return false;
        }
        try {
            return mediaPlayer.isPlaying();
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.eRelease(f19817a, "isPlaying()发生异常 + " + e.toString());
            return false;
        }
    }

    public void startPlay(AssetFileDescriptor assetFileDescriptor) {
        MediaPlayer mediaPlayer = this.f19819b;
        if (mediaPlayer == null) {
            LogUtil.iRelease(f19817a, "can't startPlay, mMediaPlayer is null");
            return;
        }
        try {
            mediaPlayer.reset();
            this.f19819b.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            this.f19819b.prepareAsync();
            this.f19819b.setOnPreparedListener($$Lambda$jX_tASEdjv03obJy5rjdfXVUzvw.INSTANCE);
            this.MEDIA_STATUS = 0;
            this.f19821e.sendEmptyMessage(1000);
        } catch (IOException e) {
            LogUtil.eRelease(f19817a, "startPlay error: " + e.toString());
            e.printStackTrace();
        }
    }

    public void startPlay(String str, OnMusicStartPlayListener onMusicStartPlayListener) {
        if (this.f19819b == null) {
            LogUtil.iRelease(f19817a, "can't startPlay, mMediaPlayer is null, path: " + str);
            return;
        }
        try {
            LogUtil.iRelease(f19817a, "startPlay " + str);
            this.f19819b.reset();
            this.f19819b.setDataSource(str);
            this.f19819b.prepareAsync();
            this.f19819b.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public final void onPrepared(MediaPlayer mediaPlayer) {
                    MediaPlayerManager.m16847a(MediaPlayerManager.OnMusicStartPlayListener.this, mediaPlayer);
                }
            });
            this.MEDIA_STATUS = 0;
            this.f19821e.sendEmptyMessage(1000);
        } catch (IOException e) {
            LogUtil.eRelease(f19817a, "startPlay error: " + e.toString());
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m16847a(OnMusicStartPlayListener onMusicStartPlayListener, MediaPlayer mediaPlayer) {
        mediaPlayer.start();
        onMusicStartPlayListener.onStartPlay();
    }

    public void pausePlay() {
        if (isPlaying()) {
            this.f19819b.pause();
            this.MEDIA_STATUS = 1;
            removeHandler();
        }
    }

    public void continuePlay() {
        MediaPlayer mediaPlayer = this.f19819b;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            this.MEDIA_STATUS = 0;
            this.f19821e.sendEmptyMessage(1000);
        }
    }

    public void stopPlay() {
        MediaPlayer mediaPlayer = this.f19819b;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.f19819b.stop();
            this.MEDIA_STATUS = 2;
            removeHandler();
        }
    }

    public void setVolume(float f, float f2) {
        MediaPlayer mediaPlayer = this.f19819b;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f, f2);
        }
    }

    public void release() {
        MediaPlayer mediaPlayer = this.f19819b;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f19819b = null;
        }
    }

    public int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.f19819b;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getCurrentPosition();
    }

    public int getDuration() {
        MediaPlayer mediaPlayer = this.f19819b;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getDuration();
    }

    public void setLooping(boolean z) {
        MediaPlayer mediaPlayer = this.f19819b;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z);
        }
    }

    public void seekTo(int i) {
        MediaPlayer mediaPlayer = this.f19819b;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(i);
        }
    }

    public void removeHandler() {
        this.f19821e.removeMessages(1000);
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        MediaPlayer mediaPlayer = this.f19819b;
        if (mediaPlayer != null) {
            mediaPlayer.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        MediaPlayer mediaPlayer = this.f19819b;
        if (mediaPlayer != null) {
            mediaPlayer.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnProgressListener(OnMusicProgressListener onMusicProgressListener) {
        this.f19820d = onMusicProgressListener;
    }
}
