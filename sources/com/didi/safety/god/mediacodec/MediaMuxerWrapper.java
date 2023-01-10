package com.didi.safety.god.mediacodec;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.text.TextUtils;
import com.didi.beatles.p101im.picture.utils.IMPictureFileUtils;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MediaMuxerWrapper {

    /* renamed from: a */
    private static final boolean f37424a = false;

    /* renamed from: b */
    private static final String f37425b = "MediaMuxerWrapper";

    /* renamed from: c */
    private static final String f37426c = "Liveness-Video";

    /* renamed from: d */
    private static final SimpleDateFormat f37427d = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);

    /* renamed from: e */
    private final MediaMuxer f37428e;

    /* renamed from: f */
    private String f37429f;

    /* renamed from: g */
    private int f37430g;

    /* renamed from: h */
    private int f37431h;

    /* renamed from: i */
    private boolean f37432i;

    /* renamed from: j */
    private MediaEncoder f37433j;

    /* renamed from: k */
    private MediaEncoder f37434k;

    public MediaMuxerWrapper(Context context, String str) throws IOException {
        this(context, (String) null, str);
    }

    public MediaMuxerWrapper(Context context, String str, String str2) throws IOException {
        str2 = TextUtils.isEmpty(str2) ? IMPictureFileUtils.POST_VIDEO : str2;
        if (str == null) {
            try {
                this.f37429f = getCaptureFile(context, str2).toString();
            } catch (NullPointerException unused) {
                throw new RuntimeException("This app has no permission of writing external storage");
            }
        } else {
            this.f37429f = str + str2;
        }
        SystemUtils.log(6, f37425b, "path = " + this.f37429f, (Throwable) null, "com.didi.safety.god.mediacodec.MediaMuxerWrapper", 55);
        this.f37428e = new MediaMuxer(this.f37429f, 0);
        this.f37431h = 0;
        this.f37430g = 0;
        this.f37432i = false;
    }

    public static final File getCaptureFile(Context context, String str) {
        if (context == null) {
            return null;
        }
        File externalFilesDir = context.getExternalFilesDir(f37426c);
        externalFilesDir.mkdirs();
        if (!externalFilesDir.canWrite()) {
            return null;
        }
        return new File(externalFilesDir, m28213c() + str);
    }

    /* renamed from: c */
    private static final String m28213c() {
        return f37427d.format(new GregorianCalendar().getTime());
    }

    public String getOutputPath() {
        return this.f37429f;
    }

    public void prepare() throws IOException {
        MediaEncoder mediaEncoder = this.f37433j;
        if (mediaEncoder != null) {
            mediaEncoder.prepare();
        }
        MediaEncoder mediaEncoder2 = this.f37434k;
        if (mediaEncoder2 != null) {
            mediaEncoder2.prepare();
        }
    }

    public void startRecording() {
        MediaEncoder mediaEncoder = this.f37433j;
        if (mediaEncoder != null) {
            mediaEncoder.startRecording();
        }
        MediaEncoder mediaEncoder2 = this.f37434k;
        if (mediaEncoder2 != null) {
            mediaEncoder2.startRecording();
        }
    }

    public void stopRecording() {
        MediaEncoder mediaEncoder = this.f37433j;
        if (mediaEncoder != null) {
            mediaEncoder.mo96267b();
        }
        this.f37433j = null;
        MediaEncoder mediaEncoder2 = this.f37434k;
        if (mediaEncoder2 != null) {
            mediaEncoder2.mo96267b();
        }
        this.f37434k = null;
    }

    public synchronized boolean isStarted() {
        return this.f37432i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo96292a(MediaEncoder mediaEncoder) {
        if (!(mediaEncoder instanceof MediaVideoEncoder)) {
            throw new IllegalArgumentException("unsupported encoder");
        } else if (this.f37433j == null) {
            this.f37433j = mediaEncoder;
            int i = 1;
            int i2 = mediaEncoder != null ? 1 : 0;
            if (this.f37434k == null) {
                i = 0;
            }
            this.f37430g = i2 + i;
        } else {
            throw new IllegalArgumentException("Video encoder already added.");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo96293a() {
        int i = this.f37431h + 1;
        this.f37431h = i;
        if (this.f37430g > 0 && i == this.f37430g) {
            this.f37428e.start();
            this.f37432i = true;
            notifyAll();
        }
        return this.f37432i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo96294b() {
        int i = this.f37431h - 1;
        this.f37431h = i;
        if (this.f37430g > 0 && i <= 0) {
            this.f37428e.stop();
            this.f37428e.release();
            this.f37432i = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized int mo96290a(MediaFormat mediaFormat) {
        if (!this.f37432i) {
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return this.f37428e.addTrack(mediaFormat);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo96291a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f37431h > 0) {
            this.f37428e.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }
}
