package com.didi.foundation.sdk.tts;

import android.content.Context;

public class AudioManager extends AbstractAudio {

    /* renamed from: a */
    private final IAudio f23211a = IAudioService.getInstance();

    /* renamed from: b */
    private final IAudio f23212b = new MediaAudio();

    /* renamed from: c */
    private PlayData f23213c;

    /* renamed from: d */
    private IAudio f23214d;

    public void init(IPlayListener iPlayListener, Context context) {
        this.f23211a.init(iPlayListener, context);
        this.f23212b.init(iPlayListener, context);
    }

    public void play(PlayData playData) {
        this.f23213c = playData;
        IAudio iAudio = playData.f23234b ? this.f23211a : this.f23212b;
        this.f23214d = iAudio;
        iAudio.play(playData);
    }

    public void stop() {
        IAudio iAudio = this.f23214d;
        if (iAudio != null) {
            iAudio.stop();
            this.f23213c = null;
            synchronized (this.mMutex) {
                this.mMutex.notifyAll();
            }
        }
    }

    public void release() {
        this.f23211a.release();
        this.f23212b.release();
    }

    public void pause() {
        this.f23214d.pause();
    }

    public void resumeSpeaking() {
        this.f23214d.resumeSpeaking();
    }

    public boolean isPlaying() {
        IAudio iAudio = this.f23214d;
        return iAudio != null && iAudio.isPlaying();
    }

    public void onCompleted() {
        PlayData playData = this.f23213c;
        if (playData == null || playData.getNext() == null) {
            synchronized (this.mMutex) {
                this.mMutex.notifyAll();
            }
            return;
        }
        PlayData next = this.f23213c.getNext();
        this.f23213c = next;
        play(next);
    }
}
