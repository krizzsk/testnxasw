package com.didi.foundation.sdk.tts;

import com.didi.foundation.sdk.log.LogService;
import com.didi.sdk.logging.Logger;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TtsDeque {

    /* renamed from: a */
    private Logger f23239a = LogService.getLogger(TtsDeque.class.getSimpleName());

    /* renamed from: b */
    private Lock f23240b;

    /* renamed from: c */
    private final Condition f23241c;

    /* renamed from: d */
    private LinkedBlockingDeque<PlayData> f23242d;

    /* renamed from: e */
    private LinkedBlockingDeque<PlayData> f23243e;

    /* renamed from: f */
    private LinkedBlockingDeque<PlayData> f23244f;

    public TtsDeque() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f23240b = reentrantLock;
        this.f23241c = reentrantLock.newCondition();
        this.f23242d = new LinkedBlockingDeque<>();
        this.f23243e = new LinkedBlockingDeque<>();
        this.f23244f = new LinkedBlockingDeque<>();
    }

    public void add(PlayData playData) {
        this.f23240b.lock();
        try {
            int i = C89911.$SwitchMap$com$didi$foundation$sdk$tts$PlayData$TtsPriority[playData.f23233a.ordinal()];
            if (i == 1) {
                this.f23242d.add(playData);
                Logger logger = this.f23239a;
                logger.debug("TTS queue add high: " + playData.getTts(), new Object[0]);
            } else if (i == 2) {
                this.f23243e.add(playData);
                Logger logger2 = this.f23239a;
                logger2.debug("TTS queue add  middle: " + playData.getTts(), new Object[0]);
            } else if (i == 3) {
                this.f23244f.add(playData);
                Logger logger3 = this.f23239a;
                logger3.debug("TTS queue add  normal: " + playData.getTts(), new Object[0]);
            }
            this.f23241c.signal();
        } finally {
            this.f23240b.unlock();
        }
    }

    /* renamed from: com.didi.foundation.sdk.tts.TtsDeque$1 */
    static /* synthetic */ class C89911 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$foundation$sdk$tts$PlayData$TtsPriority;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.foundation.sdk.tts.PlayData$TtsPriority[] r0 = com.didi.foundation.sdk.tts.PlayData.TtsPriority.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$foundation$sdk$tts$PlayData$TtsPriority = r0
                com.didi.foundation.sdk.tts.PlayData$TtsPriority r1 = com.didi.foundation.sdk.tts.PlayData.TtsPriority.HIGH_PRIORITY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$foundation$sdk$tts$PlayData$TtsPriority     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.foundation.sdk.tts.PlayData$TtsPriority r1 = com.didi.foundation.sdk.tts.PlayData.TtsPriority.MIDDLE_PRIORITY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$foundation$sdk$tts$PlayData$TtsPriority     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.foundation.sdk.tts.PlayData$TtsPriority r1 = com.didi.foundation.sdk.tts.PlayData.TtsPriority.NORMAL_PRIORITY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.foundation.sdk.tts.TtsDeque.C89911.<clinit>():void");
        }
    }

    public PlayData get() throws InterruptedException {
        this.f23240b.lock();
        while (true) {
            try {
                PlayData tts = getTts();
                if (tts == null) {
                    this.f23239a.debug("TTS queue no data to play ", new Object[0]);
                    this.f23241c.await();
                } else {
                    Logger logger = this.f23239a;
                    logger.debug("TTS queue  will play is" + tts.getTts() + " rawId " + tts.getRawId(), new Object[0]);
                    return tts;
                }
            } finally {
                this.f23240b.unlock();
            }
        }
    }

    public PlayData getTts() {
        PlayData poll = this.f23242d.poll();
        if (poll == null) {
            poll = this.f23243e.poll();
        }
        if (poll == null) {
            poll = this.f23244f.poll();
        }
        Logger logger = this.f23239a;
        logger.debug("TTS queue get data is " + poll, new Object[0]);
        return poll;
    }

    public void clear() {
        this.f23242d.clear();
        this.f23243e.clear();
        this.f23244f.clear();
    }
}
