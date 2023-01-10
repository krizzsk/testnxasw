package com.didi.foundation.sdk.service;

import android.content.Context;
import com.didi.foundation.sdk.log.LogService;
import com.didi.foundation.sdk.service.LocaleServiceProvider;
import com.didi.foundation.sdk.tts.AudioManager;
import com.didi.foundation.sdk.tts.AudioTaskDispatcher;
import com.didi.foundation.sdk.tts.IAudio;
import com.didi.foundation.sdk.tts.PlayData;
import com.didi.sdk.logging.Logger;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.Locale;

@ServiceProvider({AudioServiceProvider.class})
public class AudioServiceImpl implements AudioServiceProvider, LocaleServiceProvider.OnLocaleChangedListener {

    /* renamed from: a */
    private Logger f23158a = LogService.getLogger("AudioServiceImpl");

    /* renamed from: b */
    private IAudio f23159b;

    /* renamed from: c */
    private AudioTaskDispatcher f23160c = AudioTaskDispatcher.getInstance();

    /* renamed from: d */
    private boolean f23161d = false;

    /* renamed from: e */
    private Context f23162e;

    public void init(Context context) {
        AudioManager audioManager = new AudioManager();
        this.f23159b = audioManager;
        audioManager.init(this.f23160c, context);
        this.f23160c.initialize((AudioManager) this.f23159b);
        this.f23162e = context;
        this.f23161d = true;
        LocaleService.getInstance().removeOnLocaleChangedListener(this);
        LocaleService.getInstance().addOnLocaleChangedListener(this);
    }

    public boolean isInit() {
        return this.f23161d;
    }

    public void onLocaleChanged(Locale locale, Locale locale2) {
        this.f23159b.release();
        this.f23160c.release();
        this.f23160c.initialize((AudioManager) this.f23159b);
        this.f23159b.init(this.f23160c, this.f23162e);
        this.f23161d = true;
    }

    public void stop() {
        if (this.f23161d) {
            this.f23159b.stop();
        }
    }

    public void pause() {
        if (this.f23161d) {
            this.f23159b.pause();
        }
    }

    public void resume() {
        if (this.f23161d) {
            this.f23159b.resumeSpeaking();
        }
    }

    public void release() {
        this.f23159b.release();
        this.f23160c.release();
        this.f23161d = false;
    }

    public boolean isPlaying() {
        return this.f23161d && this.f23159b.isPlaying();
    }

    public void play(PlayData playData) {
        if (playData != null) {
            if (!this.f23161d) {
                this.f23158a.debug("audio not init!", new Object[0]);
            } else {
                this.f23160c.addTask(playData);
            }
        }
    }

    public void playTts(String str) {
        play(new PlayData.Builder().tts(str).build());
    }

    public void playAudioResource(int i) {
        play(new PlayData.Builder().rawId(i).build());
    }
}
