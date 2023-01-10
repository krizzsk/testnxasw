package com.didi.sdk.audiorecorder.helper.recorder;

import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;

public abstract class AudioProcessModule implements Supporter.ErrorObservable, Supporter.OnOffSwitcher {

    /* renamed from: a */
    private AudioRecorder.OnErrorListener f38084a;

    /* renamed from: b */
    private volatile boolean f38085b;

    /* access modifiers changed from: protected */
    public abstract boolean performStart();

    /* access modifiers changed from: protected */
    public abstract void performStop();

    public final synchronized void start() {
        if (!this.f38085b) {
            this.f38085b = performStart();
        }
    }

    public final synchronized void stop() {
        if (this.f38085b) {
            this.f38085b = false;
            performStop();
        }
    }

    public final synchronized boolean isStarted() {
        return this.f38085b;
    }

    public final void setOnErrorListener(AudioRecorder.OnErrorListener onErrorListener) {
        this.f38084a = onErrorListener;
    }

    /* access modifiers changed from: protected */
    public void notifyError(int i) {
        AudioRecorder.OnErrorListener onErrorListener = this.f38084a;
        if (onErrorListener != null) {
            onErrorListener.onError(i);
        }
    }
}
