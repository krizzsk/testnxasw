package com.didichuxing.sdk.alphaface.video_capture;

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
    private static final boolean f51390a = false;

    /* renamed from: b */
    private static final String f51391b = "MediaMuxerWrapper";

    /* renamed from: c */
    private final MediaMuxer f51392c;

    /* renamed from: d */
    private String f51393d;

    /* renamed from: e */
    private int f51394e;

    /* renamed from: f */
    private int f51395f;

    /* renamed from: g */
    private boolean f51396g;

    /* renamed from: h */
    private MediaEncoder f51397h;

    /* renamed from: i */
    private MediaEncoder f51398i;

    public MediaMuxerWrapper(Context context, String str) throws IOException {
        boolean isEmpty = TextUtils.isEmpty(str);
        this.f51392c = new MediaMuxer(this.f51393d, 0);
        this.f51395f = 0;
        this.f51394e = 0;
        this.f51396g = false;
    }

    public MediaMuxerWrapper(Context context, String str, String str2) throws IOException {
        try {
            this.f51393d = DiFaceVideoCaptureManager.getCaptureFile(context, TextUtils.isEmpty(str) ? IMPictureFileUtils.POST_VIDEO : str, str2).toString();
            this.f51392c = new MediaMuxer(this.f51393d, 0);
            this.f51395f = 0;
            this.f51394e = 0;
            this.f51396g = false;
        } catch (NullPointerException unused) {
            throw new RuntimeException("This app has no permission of writing external storage");
        }
    }

    public String getOutputPath() {
        return this.f51393d;
    }

    public void prepare() throws IOException {
        MediaEncoder mediaEncoder = this.f51397h;
        if (mediaEncoder != null) {
            mediaEncoder.prepare();
        }
        MediaEncoder mediaEncoder2 = this.f51398i;
        if (mediaEncoder2 != null) {
            mediaEncoder2.prepare();
        }
    }

    public void startRecording() {
        MediaEncoder mediaEncoder = this.f51397h;
        if (mediaEncoder != null) {
            mediaEncoder.startRecording();
        }
        MediaEncoder mediaEncoder2 = this.f51398i;
        if (mediaEncoder2 != null) {
            mediaEncoder2.startRecording();
        }
    }

    public void stopRecording() {
        MediaEncoder mediaEncoder = this.f51397h;
        if (mediaEncoder != null) {
            mediaEncoder.mo127204b();
        }
        this.f51397h = null;
        MediaEncoder mediaEncoder2 = this.f51398i;
        if (mediaEncoder2 != null) {
            mediaEncoder2.mo127204b();
        }
        this.f51398i = null;
    }

    public synchronized boolean isStarted() {
        return this.f51396g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo127214a(MediaEncoder mediaEncoder) {
        if (mediaEncoder instanceof MediaVideoEncoder) {
            if (this.f51397h == null) {
                this.f51397h = mediaEncoder;
            } else {
                throw new IllegalArgumentException("Video encoder already added.");
            }
        } else if (!(mediaEncoder instanceof MediaAudioEncoder)) {
            throw new IllegalArgumentException("unsupported encoder");
        } else if (this.f51398i == null) {
            this.f51398i = mediaEncoder;
        } else {
            throw new IllegalArgumentException("Video encoder already added.");
        }
        int i = 1;
        int i2 = this.f51397h != null ? 1 : 0;
        if (this.f51398i == null) {
            i = 0;
        }
        this.f51394e = i2 + i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo127215a() {
        int i = this.f51395f + 1;
        this.f51395f = i;
        if (this.f51394e > 0 && i == this.f51394e) {
            this.f51392c.start();
            this.f51396g = true;
            notifyAll();
        }
        return this.f51396g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo127216b() {
        int i = this.f51395f - 1;
        this.f51395f = i;
        if (this.f51394e > 0 && i <= 0) {
            this.f51392c.stop();
            this.f51392c.release();
            this.f51396g = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized int mo127212a(MediaFormat mediaFormat) {
        if (!this.f51396g) {
        } else {
            throw new IllegalStateException("muxer already started");
        }
        return this.f51392c.addTrack(mediaFormat);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo127213a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f51395f > 0) {
            this.f51392c.writeSampleData(i, byteBuffer, bufferInfo);
        }
    }
}
