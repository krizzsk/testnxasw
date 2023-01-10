package com.didi.foundation.sdk.tts;

import com.didi.foundation.sdk.log.LogService;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;

public class AudioTaskDispatcher implements IPlayListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Logger f23215a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TtsDeque f23216b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public PlayData f23217c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AbstractAudio f23218d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f23219e;

    /* renamed from: f */
    private Thread f23220f;

    private static class Holder {
        /* access modifiers changed from: private */
        public static final AudioTaskDispatcher INSTANCE = new AudioTaskDispatcher();

        private Holder() {
        }
    }

    private AudioTaskDispatcher() {
        this.f23215a = LogService.getLogger(AudioTaskDispatcher.class.getSimpleName());
        this.f23219e = true;
    }

    public static AudioTaskDispatcher getInstance() {
        return Holder.INSTANCE;
    }

    public void onCompleted() {
        this.f23218d.onCompleted();
    }

    public void initialize(final AudioManager audioManager) {
        this.f23218d = audioManager;
        this.f23216b = new TtsDeque();
        this.f23219e = true;
        this.f23215a.debug("AudioTaskDispatcher initialize: ", new Object[0]);
        C89871 r0 = new Thread() {
            public void run() {
                SystemUtils.setProcessThreadPriority(-16);
                while (AudioTaskDispatcher.this.f23219e) {
                    try {
                        AudioTaskDispatcher.this.f23215a.debug("AudioTaskDispatcher is running ", new Object[0]);
                        PlayData unused = AudioTaskDispatcher.this.f23217c = AudioTaskDispatcher.this.f23216b.get();
                        AudioTaskDispatcher.this.f23218d.play(AudioTaskDispatcher.this.f23217c);
                        synchronized (audioManager.mMutex) {
                            Logger b = AudioTaskDispatcher.this.f23215a;
                            b.debug("AudioTaskDispatcher is wait  " + AudioTaskDispatcher.this.f23217c.getTts(), new Object[0]);
                            audioManager.mMutex.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        };
        this.f23220f = r0;
        r0.start();
    }

    public void addTask(PlayData playData) {
        if (playData != null) {
            if (this.f23217c != null && playData.f23233a.ordinal() > this.f23217c.f23233a.ordinal()) {
                this.f23218d.stop();
            }
            Logger logger = this.f23215a;
            logger.debug("AudioTaskDispatcher data: " + playData.getTts() + playData.f23233a, new Object[0]);
            this.f23216b.add(playData);
        }
    }

    public void release() {
        this.f23219e = false;
        this.f23216b.clear();
        this.f23220f.interrupt();
    }
}
