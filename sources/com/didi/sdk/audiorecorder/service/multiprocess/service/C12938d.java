package com.didi.sdk.audiorecorder.service.multiprocess.service;

import com.didi.sdk.audiorecorder.ISpeechDetectListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import java.util.concurrent.ExecutorService;

/* renamed from: com.didi.sdk.audiorecorder.service.multiprocess.service.d */
/* compiled from: WordsDetectListenerWrapper */
final class C12938d implements AudioRecorder.WordsDetectListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ISpeechDetectListener f38301a;

    /* renamed from: b */
    private ExecutorService f38302b;

    C12938d(ExecutorService executorService) {
        this.f38302b = executorService;
    }

    /* renamed from: a */
    public void mo97634a(ISpeechDetectListener iSpeechDetectListener) {
        this.f38301a = iSpeechDetectListener;
    }

    public void onWordDetected(String str) {
        if (this.f38301a != null) {
            this.f38302b.execute(new WordsDetectListenerWrapper$1(this, str));
        }
    }
}
