package com.didi.sdk.audiorecorder.service.multiprocess.conn;

import android.os.Handler;
import com.didi.sdk.audiorecorder.IErrorListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.utils.LogUtil;

/* renamed from: com.didi.sdk.audiorecorder.service.multiprocess.conn.a */
/* compiled from: BinderErrorListener */
final class C12925a extends IErrorListener.Stub {

    /* renamed from: a */
    AudioRecorder.OnErrorListener f38253a;

    /* renamed from: b */
    private Handler f38254b;

    /* renamed from: c */
    private C12929e f38255c;

    C12925a(Handler handler, C12929e eVar) {
        this.f38254b = handler;
        this.f38255c = eVar;
    }

    public void onError(int i) {
        LogUtil.log("onError : " + i);
        if (this.f38253a != null) {
            this.f38254b.post(new BinderErrorListener$1(this, i));
        }
        if (i == 16) {
            this.f38255c.mo97606a();
        }
    }
}
