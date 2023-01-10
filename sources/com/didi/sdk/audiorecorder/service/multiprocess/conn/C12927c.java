package com.didi.sdk.audiorecorder.service.multiprocess.conn;

import android.os.Handler;
import com.didi.sdk.audiorecorder.IDurationChangedListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;

/* renamed from: com.didi.sdk.audiorecorder.service.multiprocess.conn.c */
/* compiled from: BinderRecordDurationListener */
final class C12927c extends IDurationChangedListener.Stub {

    /* renamed from: a */
    AudioRecorder.DurationChangedListener f38258a;

    /* renamed from: b */
    private Handler f38259b;

    C12927c(Handler handler) {
        this.f38259b = handler;
    }

    public void onTimeTick(int i) {
        if (this.f38258a != null) {
            this.f38259b.post(new BinderRecordDurationListener$1(this, i));
        }
    }
}
