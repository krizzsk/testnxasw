package com.didi.sdk.audiorecorder.helper.recorder.modules.fixed;

import android.media.MediaCodec;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class FixedAmrHelper implements IAmrHelper {

    /* renamed from: b */
    private static final int f38176b = 160;

    /* renamed from: a */
    private final String f38177a = "FixedAmrHelper";

    /* renamed from: c */
    private final byte[] f38178c = new byte[320];
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final byte[] f38179d = new byte[320];
    /* access modifiers changed from: private */

    /* renamed from: e */
    public MediaCodec f38180e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public MediaCodec.BufferInfo f38181f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f38182g = false;

    /* renamed from: h */
    private ExecutorService f38183h = Executors.newSingleThreadExecutor(new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "didi-recorder-processor-amr_by_mediacodec");
        }
    });
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Supporter.AmrConsumer f38184i;

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.didi.sdk.audiorecorder.helper.recorder.modules.fixed.FixedAmrHelper tryNewInstance(int r3) {
        /*
            android.media.MediaFormat r0 = new android.media.MediaFormat
            r0.<init>()
            java.lang.String r1 = "mime"
            java.lang.String r2 = "audio/3gpp"
            r0.setString(r1, r2)
            java.lang.String r1 = "sample-rate"
            r2 = 8000(0x1f40, float:1.121E-41)
            r0.setInteger(r1, r2)
            java.lang.String r1 = "channel-count"
            r2 = 1
            r0.setInteger(r1, r2)
            if (r3 <= 0) goto L_0x001c
            goto L_0x001e
        L_0x001c:
            r3 = 12200(0x2fa8, float:1.7096E-41)
        L_0x001e:
            java.lang.String r1 = "bitrate"
            r0.setInteger(r1, r3)
            android.media.MediaCodecList r3 = new android.media.MediaCodecList
            r1 = 0
            r3.<init>(r1)
            java.lang.String r3 = r3.findEncoderForFormat(r0)
            r1 = 0
            if (r3 == 0) goto L_0x0051
            android.media.MediaCodec r3 = android.media.MediaCodec.createByCodecName(r3)     // Catch:{ Exception -> 0x003d }
            r3.configure(r0, r1, r1, r2)     // Catch:{ Exception -> 0x003b }
            r3.start()     // Catch:{ Exception -> 0x003b }
            goto L_0x0044
        L_0x003b:
            goto L_0x003e
        L_0x003d:
            r3 = r1
        L_0x003e:
            if (r3 == 0) goto L_0x0043
            r3.release()
        L_0x0043:
            r3 = r1
        L_0x0044:
            if (r3 == 0) goto L_0x0051
            com.didi.sdk.audiorecorder.helper.recorder.modules.fixed.FixedAmrHelper r0 = new com.didi.sdk.audiorecorder.helper.recorder.modules.fixed.FixedAmrHelper
            android.media.MediaCodec$BufferInfo r1 = new android.media.MediaCodec$BufferInfo
            r1.<init>()
            r0.<init>(r3, r1)
            return r0
        L_0x0051:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.audiorecorder.helper.recorder.modules.fixed.FixedAmrHelper.tryNewInstance(int):com.didi.sdk.audiorecorder.helper.recorder.modules.fixed.FixedAmrHelper");
    }

    public FixedAmrHelper(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo) {
        this.f38180e = mediaCodec;
        this.f38181f = bufferInfo;
    }

    public void start() {
        this.f38182g = true;
        this.f38183h.execute(new Runnable() {
            public void run() {
                while (FixedAmrHelper.this.f38182g) {
                    try {
                        LogUtil.logD("FixedAmrHelper", "handleFrame dequeueOutputBuffer wait");
                        int dequeueOutputBuffer = FixedAmrHelper.this.f38180e.dequeueOutputBuffer(FixedAmrHelper.this.f38181f, -1);
                        LogUtil.logD("FixedAmrHelper", "handleFrame dequeueOutputBuffer :" + dequeueOutputBuffer);
                        if (dequeueOutputBuffer >= 0) {
                            int i = FixedAmrHelper.this.f38181f.size;
                            if (i > 0) {
                                LogUtil.logD("FixedAmrHelper", "handleFrame amr output:" + i);
                                FixedAmrHelper.this.f38180e.getOutputBuffer(dequeueOutputBuffer).get(FixedAmrHelper.this.f38179d, 0, i);
                                Supporter.AmrConsumer e = FixedAmrHelper.this.f38184i;
                                if (e != null) {
                                    e.onAmrFeed(FixedAmrHelper.this.f38179d, i);
                                }
                            }
                            FixedAmrHelper.this.f38180e.releaseOutputBuffer(dequeueOutputBuffer, false);
                        }
                    } catch (Exception e2) {
                        Exception exc = e2;
                        SystemUtils.log(6, "FixedAmrHelper", "handleFrame amr output : " + FixedAmrHelper.this.f38182g, exc, "com.didi.sdk.audiorecorder.helper.recorder.modules.fixed.FixedAmrHelper$2", 120);
                    }
                }
            }
        });
    }

    public void handleFrame(byte[] bArr) {
        if (this.f38180e != null && bArr != null) {
            if (LogUtil.isDebuggable()) {
                SystemUtils.log(4, "FixedAmrHelper", "handleFrame : " + bArr.length + " " + Arrays.toString(bArr), (Throwable) null, "com.didi.sdk.audiorecorder.helper.recorder.modules.fixed.FixedAmrHelper", 140);
            }
            int length = bArr.length;
            int i = 0;
            while (i < length) {
                try {
                    LogUtil.logD("FixedAmrHelper", "handleFrame dequeueInputBuffer wait");
                    int dequeueInputBuffer = this.f38180e.dequeueInputBuffer(0);
                    LogUtil.logD("FixedAmrHelper", "handleFrame dequeueInputBuffer : " + dequeueInputBuffer);
                    if (dequeueInputBuffer >= 0) {
                        int min = Math.min(this.f38178c.length, length - i);
                        System.arraycopy(bArr, i, this.f38178c, 0, min);
                        this.f38180e.getInputBuffer(dequeueInputBuffer).put(this.f38178c, 0, min);
                        this.f38180e.queueInputBuffer(dequeueInputBuffer, 0, min, 0, 0);
                        i += min;
                    }
                } catch (Exception e) {
                    SystemUtils.log(6, "FixedAmrHelper", "handleFrame amr input", e, "com.didi.sdk.audiorecorder.helper.recorder.modules.fixed.FixedAmrHelper", 166);
                    return;
                }
            }
        }
    }

    public void close() throws IOException {
        this.f38184i = null;
        this.f38182g = false;
        this.f38183h.shutdown();
        MediaCodec mediaCodec = this.f38180e;
        this.f38180e = null;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                mediaCodec.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isClosed() {
        return this.f38180e != null;
    }

    public void setAmrConsumer(Supporter.AmrConsumer amrConsumer) {
        this.f38184i = amrConsumer;
    }
}
