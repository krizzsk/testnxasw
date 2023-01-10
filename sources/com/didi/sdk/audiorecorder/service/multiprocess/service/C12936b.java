package com.didi.sdk.audiorecorder.service.multiprocess.service;

import com.didi.sdk.audiorecorder.IFileSliceListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import java.util.concurrent.ExecutorService;

/* renamed from: com.didi.sdk.audiorecorder.service.multiprocess.service.b */
/* compiled from: FileSliceListenerWrapper */
final class C12936b implements AudioRecorder.FileSliceListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public IFileSliceListener f38289a;

    /* renamed from: b */
    private ExecutorService f38290b;

    C12936b(ExecutorService executorService) {
        this.f38290b = executorService;
    }

    /* renamed from: a */
    public void mo97627a(IFileSliceListener iFileSliceListener) {
        this.f38289a = iFileSliceListener;
    }

    public void onAudioFileCreated(String str) {
        if (this.f38289a != null) {
            this.f38290b.execute(new FileSliceListenerWrapper$1(this, str));
        }
    }

    public void onAudioFileSliced(String str) {
        if (this.f38289a != null) {
            this.f38290b.execute(new FileSliceListenerWrapper$2(this, str));
        }
    }
}
