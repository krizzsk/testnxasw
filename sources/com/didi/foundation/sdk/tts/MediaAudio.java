package com.didi.foundation.sdk.tts;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import com.didi.foundation.sdk.log.LogService;
import com.didi.sdk.logging.Logger;

public class MediaAudio extends AbstractAudio {

    /* renamed from: a */
    private IPlayListener f23227a;

    /* renamed from: b */
    private Context f23228b;

    /* renamed from: c */
    private Logger f23229c = LogService.getLogger(MediaAudio.class.getSimpleName());
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MediaPlayer f23230d;

    /* renamed from: e */
    private boolean f23231e = false;

    /* renamed from: f */
    private MediaPlayer.OnCompletionListener f23232f = new MediaPlayer.OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (!(MediaAudio.this.f23230d == null || mediaPlayer == null || MediaAudio.this.f23230d != mediaPlayer)) {
                try {
                    MediaAudio.this.f23230d.stop();
                    MediaAudio.this.f23230d.release();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    MediaPlayer unused = MediaAudio.this.f23230d = null;
                    throw th;
                }
                MediaPlayer unused2 = MediaAudio.this.f23230d = null;
            }
            MediaAudio.this.onCompleted();
        }
    };

    MediaAudio() {
    }

    public void init(IPlayListener iPlayListener, Context context) {
        this.f23227a = iPlayListener;
        this.f23228b = context;
    }

    public void play(PlayData playData) {
        Logger logger = this.f23229c;
        logger.debug("MediaPlay: play resourceId is" + playData.getRawId(), new Object[0]);
        if (playData.getRawId() > 0 && this.f23230d == null) {
            try {
                this.f23230d = new MediaPlayer();
                AssetFileDescriptor openRawResourceFd = this.f23228b.getResources().openRawResourceFd(playData.getRawId());
                this.f23230d.setAudioStreamType(3);
                this.f23230d.setOnCompletionListener(this.f23232f);
                this.f23230d.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                this.f23230d.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        try {
                            MediaAudio.this.f23230d.start();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                this.f23230d.prepare();
            } catch (Throwable th) {
                th.printStackTrace();
                this.f23229c.debug("MediaPlay: play fail", new Object[0]);
                onCompleted();
            }
        }
    }

    public void stop() {
        MediaPlayer mediaPlayer = this.f23230d;
        if (mediaPlayer != null) {
            synchronized (mediaPlayer) {
                try {
                    this.f23230d.stop();
                    this.f23230d.release();
                } catch (IllegalStateException e) {
                    try {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        this.f23230d = null;
                        throw th;
                    }
                }
                this.f23230d = null;
            }
        }
    }

    public void release() {
        MediaPlayer mediaPlayer = this.f23230d;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f23230d = null;
        }
    }

    public void pause() {
        MediaPlayer mediaPlayer = this.f23230d;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f23230d.pause();
            this.f23231e = true;
        }
    }

    public void resumeSpeaking() {
        MediaPlayer mediaPlayer = this.f23230d;
        if (mediaPlayer != null && this.f23231e) {
            mediaPlayer.start();
            this.f23231e = false;
        }
    }

    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.f23230d;
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    public void onCompleted() {
        IPlayListener iPlayListener = this.f23227a;
        if (iPlayListener != null) {
            iPlayListener.onCompleted();
        }
    }
}
