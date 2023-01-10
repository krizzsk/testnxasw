package com.didi.sdk.audiorecorder.service.multiprocess.service;

import com.didi.sdk.audiorecorder.IDurationChangedListener;
import com.didi.sdk.audiorecorder.IRecordListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.utils.LogUtil;
import java.util.concurrent.ExecutorService;

/* renamed from: com.didi.sdk.audiorecorder.service.multiprocess.service.c */
/* compiled from: RecordListenerWrapper */
final class C12937c implements AudioRecorder.DurationChangedListener, AudioRecorder.RecordListener2 {

    /* renamed from: a */
    private static final String f38291a = "RecordListenerWrapper -> ";

    /* renamed from: b */
    private AudioRecorder f38292b;

    /* renamed from: c */
    private AudioRecorder.FileSlicer f38293c;

    /* renamed from: d */
    private ExecutorService f38294d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IRecordListener f38295e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public IDurationChangedListener f38296f;

    /* renamed from: g */
    private int f38297g;

    /* renamed from: h */
    private volatile int f38298h;

    /* renamed from: i */
    private long f38299i;

    /* renamed from: j */
    private long f38300j;

    public void onGetPcmStream(byte[] bArr, int i, int i2) {
    }

    C12937c(AudioRecorder audioRecorder, AudioRecorder.FileSlicer fileSlicer, ExecutorService executorService) {
        this.f38292b = audioRecorder;
        this.f38293c = fileSlicer;
        this.f38294d = executorService;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo97631a(IRecordListener iRecordListener) {
        this.f38295e = iRecordListener;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo97630a(IDurationChangedListener iDurationChangedListener) {
        this.f38296f = iDurationChangedListener;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo97629a(int i) {
        this.f38297g = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo97633b(int i) {
        this.f38298h = i;
    }

    /* renamed from: a */
    public int mo97628a() {
        return this.f38298h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo97632b() {
        this.f38300j = this.f38299i;
    }

    public void onStart() {
        if (m28872d()) {
            LogUtil.log(f38291a, "onStart handled. (final record state = ", this.f38298h + ")");
            return;
        }
        LogUtil.log(f38291a, "onStart");
        if (this.f38295e != null) {
            this.f38294d.execute(new RecordListenerWrapper$1(this));
        }
    }

    public void onResume() {
        if (m28871c()) {
            LogUtil.log("RecordListenerWrapper -> onResume handled. (final record state = ", this.f38298h + ")");
            return;
        }
        LogUtil.log(f38291a, "onResume");
        if (this.f38295e != null) {
            this.f38294d.execute(new RecordListenerWrapper$2(this));
        }
    }

    public void onPause() {
        if (m28873e()) {
            LogUtil.log("RecordListenerWrapper -> onPause handled. (final record state = " + this.f38298h + ")");
            return;
        }
        LogUtil.log(f38291a, "onPause");
        if (this.f38295e != null) {
            this.f38294d.execute(new RecordListenerWrapper$3(this));
        }
    }

    public void onStop() {
        this.f38299i = 0;
        if (m28874f()) {
            LogUtil.log("RecordListenerWrapper -> onStop handled. (final record state = " + this.f38298h + ")");
            return;
        }
        LogUtil.log(f38291a, "onStop");
        if (this.f38295e != null) {
            this.f38294d.execute(new RecordListenerWrapper$4(this));
        }
    }

    public void onTimeTick(int i) {
        this.f38299i = (long) i;
        if (this.f38296f != null) {
            this.f38294d.execute(new RecordListenerWrapper$5(this, i));
        }
        m28875g();
    }

    /* renamed from: c */
    private boolean m28871c() {
        return m28872d();
    }

    /* renamed from: d */
    private boolean m28872d() {
        if (this.f38298h == 2) {
            this.f38292b.stopRecord();
            return true;
        } else if (this.f38298h != 4) {
            return false;
        } else {
            this.f38292b.pauseRecord();
            return true;
        }
    }

    /* renamed from: e */
    private boolean m28873e() {
        return m28874f();
    }

    /* renamed from: f */
    private boolean m28874f() {
        if (this.f38298h == 3) {
            this.f38292b.resumeRecord();
            return true;
        } else if (this.f38298h != 1) {
            return false;
        } else {
            this.f38292b.startRecord();
            return true;
        }
    }

    /* renamed from: g */
    private void m28875g() {
        int i;
        long j = this.f38299i;
        if (j != 0 && (i = this.f38297g) != 0 && (j - this.f38300j) % ((long) i) == 0) {
            LogUtil.log(f38291a, "sliceAudioIfNeed : recordDuration = " + j + ", segmentDuration = " + this.f38297g + ", mLatestSliceDuration = " + this.f38300j);
            this.f38293c.sliceAudioFile();
        }
    }
}
