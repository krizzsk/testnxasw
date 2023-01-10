package com.didi.sdk.audiorecorder.service.mainprocess;

import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.utils.LogUtil;

/* renamed from: com.didi.sdk.audiorecorder.service.mainprocess.d */
/* compiled from: RecordListenerWrapper */
final class C12915d implements AudioRecorder.DurationChangedListener, AudioRecorder.RecordListener {

    /* renamed from: a */
    private static final String f38214a = "RecordListenerWrapper -> ";

    /* renamed from: b */
    private AudioRecorder f38215b;

    /* renamed from: c */
    private AudioRecorder.FileSlicer f38216c;

    /* renamed from: d */
    private AudioRecorder.RecordListener f38217d;

    /* renamed from: e */
    private AudioRecorder.DurationChangedListener f38218e;

    /* renamed from: f */
    private int f38219f;

    /* renamed from: g */
    private volatile int f38220g;

    /* renamed from: h */
    private long f38221h;

    /* renamed from: i */
    private long f38222i;

    C12915d(AudioRecorder audioRecorder, AudioRecorder.FileSlicer fileSlicer) {
        this.f38215b = audioRecorder;
        this.f38216c = fileSlicer;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo97573a(AudioRecorder.RecordListener recordListener) {
        this.f38217d = recordListener;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo97572a(AudioRecorder.DurationChangedListener durationChangedListener) {
        this.f38218e = durationChangedListener;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo97571a(int i) {
        this.f38219f = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo97575b(int i) {
        this.f38220g = i;
    }

    /* renamed from: a */
    public int mo97570a() {
        return this.f38220g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo97574b() {
        this.f38222i = this.f38221h;
    }

    public void onStart() {
        if (m28824e()) {
            LogUtil.log(f38214a, "onStart handled. (final record state = ", this.f38220g + ")");
            return;
        }
        LogUtil.log(f38214a, "onStart");
        AudioRecorder.RecordListener recordListener = this.f38217d;
        if (recordListener != null) {
            try {
                recordListener.onStart();
            } catch (Exception e) {
                LogUtil.log("RecordListenerWrapper -> Failed to callback onStart. ", e);
            }
        }
    }

    public void onResume() {
        if (m28823d()) {
            LogUtil.log("RecordListenerWrapper -> onResume handled. (final record state = ", this.f38220g + ")");
            return;
        }
        LogUtil.log(f38214a, "onResume");
        AudioRecorder.RecordListener recordListener = this.f38217d;
        if (recordListener != null) {
            try {
                recordListener.onResume();
            } catch (Exception e) {
                LogUtil.log("Failed to callback onResume. ", e);
            }
        }
    }

    public void onPause() {
        if (m28825f()) {
            LogUtil.log("RecordListenerWrapper -> onPause handled. (final record state = " + this.f38220g + ")");
            return;
        }
        LogUtil.log(f38214a, "onPause");
        AudioRecorder.RecordListener recordListener = this.f38217d;
        if (recordListener != null) {
            try {
                recordListener.onPause();
            } catch (Exception e) {
                LogUtil.log("Failed to callback onPause. ", e);
            }
        }
    }

    public void onStop() {
        this.f38221h = 0;
        if (m28826g()) {
            LogUtil.log("RecordListenerWrapper -> onStop handled. (final record state = " + this.f38220g + ")");
            return;
        }
        LogUtil.log(f38214a, "onStop");
        AudioRecorder.RecordListener recordListener = this.f38217d;
        if (recordListener != null) {
            try {
                recordListener.onStop();
            } catch (Exception e) {
                LogUtil.log("Failed to callback onStop listener ", e);
            }
        }
    }

    public void onTimeTick(int i) {
        this.f38221h = (long) i;
        AudioRecorder.DurationChangedListener durationChangedListener = this.f38218e;
        if (durationChangedListener != null) {
            try {
                durationChangedListener.onTimeTick(i);
            } catch (Exception e) {
                LogUtil.log("Failed to callback onTimeTick listener, recordDuration = " + i, e);
            }
        }
        m28827h();
    }

    /* renamed from: d */
    private boolean m28823d() {
        return m28824e();
    }

    /* renamed from: e */
    private boolean m28824e() {
        if (this.f38220g == 2) {
            this.f38215b.stopRecord();
            return true;
        } else if (this.f38220g != 4) {
            return false;
        } else {
            this.f38215b.pauseRecord();
            return true;
        }
    }

    /* renamed from: f */
    private boolean m28825f() {
        return m28826g();
    }

    /* renamed from: g */
    private boolean m28826g() {
        if (this.f38220g == 3) {
            this.f38215b.resumeRecord();
            return true;
        } else if (this.f38220g != 1) {
            return false;
        } else {
            this.f38215b.startRecord();
            return true;
        }
    }

    /* renamed from: h */
    private void m28827h() {
        int i;
        long j = this.f38221h;
        if (j != 0 && (i = this.f38219f) != 0 && (j - this.f38222i) % ((long) i) == 0) {
            LogUtil.log(f38214a, "sliceAudioIfNeed : recordDuration = " + j + ", segmentDuration = " + this.f38219f + ", mLatestSliceDuration = " + this.f38222i);
            this.f38216c.sliceAudioFile();
        }
    }

    /* renamed from: c */
    public boolean mo97576c() {
        return this.f38220g == 1 || this.f38220g == 3;
    }
}
