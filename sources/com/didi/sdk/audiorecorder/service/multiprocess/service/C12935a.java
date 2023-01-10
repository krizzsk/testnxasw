package com.didi.sdk.audiorecorder.service.multiprocess.service;

import com.didi.sdk.audiorecorder.IErrorListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import java.util.concurrent.ExecutorService;

/* renamed from: com.didi.sdk.audiorecorder.service.multiprocess.service.a */
/* compiled from: ErrorListenerWrapper */
final class C12935a implements AudioRecorder.OnErrorListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public IErrorListener f38287a;

    /* renamed from: b */
    private ExecutorService f38288b;

    C12935a(ExecutorService executorService) {
        this.f38288b = executorService;
    }

    /* renamed from: a */
    public void mo97626a(IErrorListener iErrorListener) {
        this.f38287a = iErrorListener;
    }

    public void onError(int i) {
        if (this.f38287a != null) {
            this.f38288b.execute(new ErrorListenerWrapper$1(this, i));
        }
    }
}
