package com.didi.sdk.audiorecorder.helper.recorder.modules;

import com.didi.sdk.audiorecorder.helper.recorder.AudioProcessModule;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class SilenceDetector extends AudioProcessModule implements Supporter.Pcm8kConsumer, Runnable {

    /* renamed from: a */
    private static final String f38163a = "SilenceDetector -> ";

    /* renamed from: b */
    private static final int f38164b = 3;

    /* renamed from: c */
    private static final int f38165c = 50;

    /* renamed from: d */
    private static final int f38166d = -1;

    /* renamed from: e */
    private static final int f38167e = 0;

    /* renamed from: f */
    private static final int f38168f = 0;

    /* renamed from: g */
    private static final int f38169g = 1;

    /* renamed from: h */
    private static final int f38170h = -1;

    /* renamed from: i */
    private ExecutorService f38171i = Executors.newSingleThreadExecutor(new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "didi-recorder-processor-silence_detector");
        }
    });

    /* renamed from: j */
    private final byte[] f38172j = new byte[48000];

    /* renamed from: k */
    private int f38173k;

    /* renamed from: l */
    private int f38174l;

    /* renamed from: m */
    private Supporter.Pcm8kProvider f38175m;

    private native int detect(byte[] bArr, int i);

    private native int init();

    private native int release();

    private native int reset();

    static {
        try {
            System.loadLibrary("c++_shared");
            System.loadLibrary("sd");
            System.loadLibrary("native_silence_detect");
        } catch (Throwable unused) {
        }
    }

    public void setPcm8kProvider(Supporter.Pcm8kProvider pcm8kProvider) {
        this.f38175m = pcm8kProvider;
    }

    /* access modifiers changed from: protected */
    public synchronized boolean performStart() {
        this.f38175m.addPcm8kConsumer(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public void performStop() {
        this.f38175m.removePcm8kConsumer(this);
        this.f38173k = 0;
        this.f38174l = 0;
        Arrays.fill(this.f38172j, (byte) 0);
    }

    public void onPcm8kFeed(byte[] bArr, int i) {
        int i2;
        if (isStarted()) {
            int i3 = this.f38174l;
            int i4 = i3 + 1;
            this.f38174l = i4;
            if (i3 > 50 && (i2 = this.f38173k) >= 0) {
                int i5 = i2 + i;
                byte[] bArr2 = this.f38172j;
                if (i5 <= bArr2.length) {
                    this.f38174l = i4 + 1;
                    System.arraycopy(bArr, 0, bArr2, i2, i);
                    int i6 = this.f38173k + i;
                    this.f38173k = i6;
                    if (i6 >= this.f38172j.length) {
                        this.f38173k = -1;
                        this.f38171i.execute(this);
                    }
                }
            }
        }
    }

    public void run() {
        if (isStarted()) {
            try {
                if (init() == 0) {
                    int reset = reset();
                    LogUtil.log(f38163a, "reset " + reset);
                    if (reset == 0) {
                        int detect = detect(this.f38172j, this.f38172j.length);
                        LogUtil.log(f38163a, "detect " + detect);
                        if (isStarted() && detect == 1) {
                            notifyError(16);
                        }
                    }
                }
                release();
            } catch (Exception e) {
                LogUtil.log("SilenceDetector -> detect fail. ", e);
            }
            stop();
        }
    }
}
