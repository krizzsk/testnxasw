package com.didi.sdk.audiorecorder.service.multiprocess.conn;

import android.os.Handler;
import com.didi.sdk.audiorecorder.ISpeechDetectListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.utils.LogUtil;

/* renamed from: com.didi.sdk.audiorecorder.service.multiprocess.conn.d */
/* compiled from: BinderSpeechDetectListener */
final class C12928d extends ISpeechDetectListener.Stub {

    /* renamed from: b */
    private static final String f38260b = "BinderSpeechDetectListener -> ";

    /* renamed from: a */
    AudioRecorder.WordsDetectListener f38261a;

    /* renamed from: c */
    private Handler f38262c;

    C12928d(Handler handler) {
        this.f38262c = handler;
    }

    public void onWordDetected(String str) {
        LogUtil.log("BinderSpeechDetectListener -> onWordDetected : " + str);
        if (this.f38261a != null) {
            this.f38262c.post(new BinderSpeechDetectListener$1(this, str));
        }
    }
}
