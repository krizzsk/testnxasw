package com.didichuxing.mlcp.drtc.utils;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didichuxing.mlcp.drtc.utils.d */
/* compiled from: ExAudioRecorder */
public class C16718d implements Runnable {

    /* renamed from: a */
    private boolean f51018a = false;

    /* renamed from: b */
    private AudioRecord f51019b = m38168d();

    /* renamed from: c */
    private C16719a f51020c = null;

    /* renamed from: d */
    private volatile boolean f51021d = true;

    /* renamed from: com.didichuxing.mlcp.drtc.utils.d$a */
    /* compiled from: ExAudioRecorder */
    public interface C16719a {
        /* renamed from: a */
        void mo125513a(byte[] bArr);
    }

    private C16718d() {
    }

    /* renamed from: c */
    public static C16718d m38167c() {
        return new C16718d();
    }

    /* renamed from: d */
    private synchronized AudioRecord m38168d() {
        AudioRecord audioRecord;
        audioRecord = null;
        int minBufferSize = AudioRecord.getMinBufferSize(8000, 16, 2);
        if (minBufferSize == -2) {
            SystemUtils.log(3, "ExAudioRecorder -> ", "createAudioRecord -> error_bad_value.", (Throwable) null, "com.didichuxing.mlcp.drtc.utils.d", 3);
        } else if (minBufferSize == -1) {
            SystemUtils.log(3, "ExAudioRecorder -> ", "createAudioRecord -> error.", (Throwable) null, "com.didichuxing.mlcp.drtc.utils.d", 5);
        } else if (minBufferSize <= 0) {
            SystemUtils.log(3, "ExAudioRecorder -> ", "createAudioRecord -> illegal buffer size: " + minBufferSize, (Throwable) null, "com.didichuxing.mlcp.drtc.utils.d", 7);
        } else {
            audioRecord = Build.VERSION.SDK_INT >= 23 ? m38165a(7, 8000, 16, 2, minBufferSize * 2) : m38166b(7, 8000, 16, 2, minBufferSize * 2);
        }
        return audioRecord;
    }

    /* renamed from: a */
    public boolean mo125574a() {
        return this.f51018a;
    }

    /* renamed from: b */
    public void mo125575b() {
        this.f51021d = false;
    }

    public void run() {
        this.f51019b.startRecording();
        this.f51018a = true;
        this.f51021d = true;
        while (this.f51021d) {
            try {
                byte[] a = C16716b.m38162a(160);
                if (a == null) {
                    SystemUtils.log(2, "ExAudioRecorder", "read record buff is null", (Throwable) null, "com.didichuxing.mlcp.drtc.utils.d", 8);
                } else if (this.f51019b.read(a, 0, a.length) > 0 && this.f51020c != null) {
                    this.f51020c.mo125513a(a);
                }
            } catch (Throwable th) {
                SystemUtils.log(3, "ExAudioRecorder -> ", th.getMessage(), (Throwable) null, "com.didichuxing.mlcp.drtc.utils.d", 19);
            }
        }
        this.f51018a = false;
        AudioRecord audioRecord = this.f51019b;
        if (audioRecord != null) {
            audioRecord.stop();
        }
    }

    /* renamed from: a */
    private static AudioRecord m38165a(int i, int i2, int i3, int i4, int i5) {
        return new AudioRecord.Builder().setAudioSource(i).setAudioFormat(new AudioFormat.Builder().setEncoding(i4).setSampleRate(i2).setChannelMask(i3).build()).setBufferSizeInBytes(i5).build();
    }

    /* renamed from: a */
    public void mo125573a(C16719a aVar) {
        if (this.f51020c == null) {
            this.f51020c = aVar;
        }
    }

    /* renamed from: b */
    private static AudioRecord m38166b(int i, int i2, int i3, int i4, int i5) {
        return new AudioRecord(i, i2, i3, i4, i5);
    }
}
