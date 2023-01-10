package com.didi.sdk.audiorecorder.service.multiprocess.conn;

import android.os.Handler;
import com.didi.sdk.audiorecorder.IFileSliceListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;

/* renamed from: com.didi.sdk.audiorecorder.service.multiprocess.conn.b */
/* compiled from: BinderFileSliceListener */
final class C12926b extends IFileSliceListener.Stub {

    /* renamed from: a */
    AudioRecorder.FileSliceListener f38256a;

    /* renamed from: b */
    private Handler f38257b;

    C12926b(Handler handler) {
        this.f38257b = handler;
    }

    public void onAudioFileCreated(String str) {
        if (this.f38256a != null) {
            this.f38257b.post(new BinderFileSliceListener$1(this, str));
        }
    }

    public void onAudioFileSliced(String str) {
        if (this.f38256a != null) {
            this.f38257b.post(new BinderFileSliceListener$2(this, str));
        }
    }
}
