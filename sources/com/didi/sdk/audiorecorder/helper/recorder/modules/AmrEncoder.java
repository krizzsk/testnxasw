package com.didi.sdk.audiorecorder.helper.recorder.modules;

import com.didi.sdk.audiorecorder.helper.recorder.AudioProcessModule;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.helper.recorder.modules.fixed.AmrHelperFactory;
import com.didi.sdk.audiorecorder.helper.recorder.modules.fixed.IAmrHelper;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;

public class AmrEncoder extends AudioProcessModule implements Supporter.AmrConsumer, Supporter.AmrProvider, Supporter.Pcm8kConsumer, Runnable {

    /* renamed from: a */
    private static final String f38128a = "AmrEncoder -> ";

    /* renamed from: b */
    private final LinkedBlockingQueue<byte[]> f38129b = new LinkedBlockingQueue<>();

    /* renamed from: c */
    private ExecutorService f38130c = Executors.newSingleThreadExecutor(new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "didi-recorder-processor-amr_encoder");
        }
    });

    /* renamed from: d */
    private IAmrHelper f38131d;

    /* renamed from: e */
    private Supporter.AmrConsumer f38132e;

    /* renamed from: f */
    private int f38133f;

    /* renamed from: g */
    private int f38134g;

    public void setConfig(int i, int i2) {
        this.f38133f = i;
        this.f38134g = i2;
    }

    /* access modifiers changed from: protected */
    public boolean performStart() {
        IAmrHelper create = AmrHelperFactory.create(this.f38133f, this.f38134g);
        this.f38131d = create;
        create.setAmrConsumer(this);
        this.f38131d.start();
        this.f38129b.clear();
        this.f38130c.execute(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public void performStop() {
        try {
            this.f38131d.close();
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f38131d = null;
            throw th;
        }
        this.f38131d = null;
        this.f38129b.clear();
    }

    /* renamed from: a */
    private void m28790a(byte[] bArr) {
        IAmrHelper iAmrHelper = this.f38131d;
        if (iAmrHelper != null) {
            iAmrHelper.handleFrame(bArr);
        }
    }

    public void onPcm8kFeed(byte[] bArr, int i) {
        this.f38129b.add(bArr);
    }

    public void setAmrConsumer(Supporter.AmrConsumer amrConsumer) {
        this.f38132e = amrConsumer;
    }

    public void run() {
        while (isStarted()) {
            try {
                m28790a(this.f38129b.take());
            } catch (Exception unused) {
                LogUtil.log(f38128a, "failed to take frame");
            }
        }
    }

    public void onAmrFeed(byte[] bArr, int i) {
        Supporter.AmrConsumer amrConsumer;
        if (bArr != null && i > 0 && (amrConsumer = this.f38132e) != null) {
            amrConsumer.onAmrFeed(bArr, i);
        }
    }
}
