package com.didichuxing.dfbasesdk.video_capture;

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
    private static final boolean f49487a = false;

    /* renamed from: b */
    private static final String f49488b = "MediaMuxerWrapper";

    /* renamed from: c */
    private final MediaMuxer f49489c;

    /* renamed from: d */
    private String f49490d;

    /* renamed from: e */
    private int f49491e;

    /* renamed from: f */
    private int f49492f;

    /* renamed from: g */
    private boolean f49493g;

    /* renamed from: h */
    private MediaEncoder f49494h;

    /* renamed from: i */
    private MediaEncoder f49495i;

    public MediaMuxerWrapper(Context context, String str) throws IOException {
        try {
            this.f49490d = PathUtils.getCaptureFile(context, TextUtils.isEmpty(str) ? IMPictureFileUtils.POST_VIDEO : str).toString();
            this.f49489c = new MediaMuxer(this.f49490d, 0);
            this.f49492f = 0;
            this.f49491e = 0;
            this.f49493g = false;
        } catch (NullPointerException unused) {
            throw new RuntimeException("This app has no permission of writing external storage");
        }
    }

    public MediaMuxerWrapper(Context context, String str, String str2) throws IOException {
        try {
            this.f49490d = PathUtils.getCaptureFile(context, TextUtils.isEmpty(str) ? IMPictureFileUtils.POST_VIDEO : str, str2).toString();
            this.f49489c = new MediaMuxer(this.f49490d, 0);
            this.f49492f = 0;
            this.f49491e = 0;
            this.f49493g = false;
        } catch (NullPointerException unused) {
            throw new RuntimeException("This app has no permission of writing external storage");
        }
    }

    public String getOutputPath() {
        return this.f49490d;
    }

    public void prepare() throws IOException {
        MediaEncoder mediaEncoder = this.f49494h;
        if (mediaEncoder != null) {
            mediaEncoder.prepare();
        }
        MediaEncoder mediaEncoder2 = this.f49495i;
        if (mediaEncoder2 != null) {
            mediaEncoder2.prepare();
        }
    }

    public void startRecording() {
        MediaEncoder mediaEncoder = this.f49494h;
        if (mediaEncoder != null) {
            mediaEncoder.startRecording();
        }
        MediaEncoder mediaEncoder2 = this.f49495i;
        if (mediaEncoder2 != null) {
            mediaEncoder2.startRecording();
        }
    }

    public void stopRecording() {
        MediaEncoder mediaEncoder = this.f49494h;
        if (mediaEncoder != null) {
            mediaEncoder.mo122471b();
        }
        this.f49494h = null;
        MediaEncoder mediaEncoder2 = this.f49495i;
        if (mediaEncoder2 != null) {
            mediaEncoder2.mo122471b();
        }
        this.f49495i = null;
    }

    public synchronized boolean isStarted() {
        return this.f49493g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo122481a(MediaEncoder mediaEncoder) {
        if (mediaEncoder instanceof MediaVideoEncoder) {
            if (this.f49494h == null) {
                this.f49494h = mediaEncoder;
            } else {
                throw new IllegalArgumentException("Video encoder already added.");
            }
        } else if (!(mediaEncoder instanceof MediaAudioEncoder)) {
            throw new IllegalArgumentException("unsupported encoder");
        } else if (this.f49495i == null) {
            this.f49495i = mediaEncoder;
        } else {
            throw new IllegalArgumentException("Video encoder already added.");
        }
        int i = 1;
        int i2 = this.f49494h != null ? 1 : 0;
        if (this.f49495i == null) {
            i = 0;
        }
        this.f49491e = i2 + i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo122482a() {
        int i = this.f49492f + 1;
        this.f49492f = i;
        if (this.f49491e > 0 && i == this.f49491e) {
            this.f49489c.start();
            this.f49493g = true;
            notifyAll();
        }
        return this.f49493g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo122483b() {
        int i = this.f49492f - 1;
        this.f49492f = i;
        if (this.f49491e > 0 && i <= 0) {
            this.f49489c.stop();
            this.f49489c.release();
            this.f49493g = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized int mo122479a(MediaFormat mediaFormat) {
        if (!this.f49493g) {
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return this.f49489c.addTrack(mediaFormat);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo122480a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f49492f > 0) {
            this.f49489c.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }
}
