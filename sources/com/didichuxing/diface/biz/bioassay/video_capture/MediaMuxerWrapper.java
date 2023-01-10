package com.didichuxing.diface.biz.bioassay.video_capture;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.text.TextUtils;
import com.didi.beatles.p101im.picture.utils.IMPictureFileUtils;
import java.io.IOException;
import java.nio.ByteBuffer;

public class MediaMuxerWrapper {

    /* renamed from: a */
    private static final boolean f49998a = false;

    /* renamed from: b */
    private static final String f49999b = "MediaMuxerWrapper";

    /* renamed from: c */
    private final MediaMuxer f50000c;

    /* renamed from: d */
    private String f50001d;

    /* renamed from: e */
    private int f50002e;

    /* renamed from: f */
    private int f50003f;

    /* renamed from: g */
    private boolean f50004g;

    /* renamed from: h */
    private MediaEncoder f50005h;

    /* renamed from: i */
    private MediaEncoder f50006i;

    public MediaMuxerWrapper(Context context, String str) throws IOException {
        try {
            this.f50001d = DiFaceVideoCaptureManager.getCaptureFile(context, TextUtils.isEmpty(str) ? IMPictureFileUtils.POST_VIDEO : str).toString();
            this.f50000c = new MediaMuxer(this.f50001d, 0);
            this.f50003f = 0;
            this.f50002e = 0;
            this.f50004g = false;
        } catch (NullPointerException unused) {
            throw new RuntimeException("This app has no permission of writing external storage");
        }
    }

    public String getOutputPath() {
        return this.f50001d;
    }

    public void prepare() throws IOException {
        MediaEncoder mediaEncoder = this.f50005h;
        if (mediaEncoder != null) {
            mediaEncoder.prepare();
        }
        MediaEncoder mediaEncoder2 = this.f50006i;
        if (mediaEncoder2 != null) {
            mediaEncoder2.prepare();
        }
    }

    public void startRecording() {
        MediaEncoder mediaEncoder = this.f50005h;
        if (mediaEncoder != null) {
            mediaEncoder.startRecording();
        }
        MediaEncoder mediaEncoder2 = this.f50006i;
        if (mediaEncoder2 != null) {
            mediaEncoder2.startRecording();
        }
    }

    public void stopRecording() {
        MediaEncoder mediaEncoder = this.f50005h;
        if (mediaEncoder != null) {
            mediaEncoder.mo122931b();
        }
        this.f50005h = null;
        MediaEncoder mediaEncoder2 = this.f50006i;
        if (mediaEncoder2 != null) {
            mediaEncoder2.mo122931b();
        }
        this.f50006i = null;
    }

    public synchronized boolean isStarted() {
        return this.f50004g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo122941a(MediaEncoder mediaEncoder) {
        if (mediaEncoder instanceof MediaVideoEncoder) {
            if (this.f50005h == null) {
                this.f50005h = mediaEncoder;
            } else {
                throw new IllegalArgumentException("Video encoder already added.");
            }
        } else if (!(mediaEncoder instanceof MediaAudioEncoder)) {
            throw new IllegalArgumentException("unsupported encoder");
        } else if (this.f50006i == null) {
            this.f50006i = mediaEncoder;
        } else {
            throw new IllegalArgumentException("Video encoder already added.");
        }
        int i = 1;
        int i2 = this.f50005h != null ? 1 : 0;
        if (this.f50006i == null) {
            i = 0;
        }
        this.f50002e = i2 + i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo122942a() {
        int i = this.f50003f + 1;
        this.f50003f = i;
        if (this.f50002e > 0 && i == this.f50002e) {
            this.f50000c.start();
            this.f50004g = true;
            notifyAll();
        }
        return this.f50004g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo122943b() {
        int i = this.f50003f - 1;
        this.f50003f = i;
        if (this.f50002e > 0 && i <= 0) {
            this.f50000c.stop();
            this.f50000c.release();
            this.f50004g = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized int mo122939a(MediaFormat mediaFormat) {
        if (!this.f50004g) {
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return this.f50000c.addTrack(mediaFormat);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo122940a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f50003f > 0) {
            this.f50000c.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }
}
