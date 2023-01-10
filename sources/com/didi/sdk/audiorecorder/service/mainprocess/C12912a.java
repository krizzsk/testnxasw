package com.didi.sdk.audiorecorder.service.mainprocess;

import android.os.RemoteException;
import com.didi.sdk.audiorecorder.IFileSliceListener;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.utils.LogUtil;

/* renamed from: com.didi.sdk.audiorecorder.service.mainprocess.a */
/* compiled from: FileSliceListenerWrapper */
final class C12912a implements AudioRecorder.FileSliceListener {

    /* renamed from: a */
    private IFileSliceListener f38209a;

    C12912a() {
    }

    /* renamed from: a */
    public void mo97568a(IFileSliceListener iFileSliceListener) {
        this.f38209a = iFileSliceListener;
    }

    public void onAudioFileCreated(String str) {
        try {
            this.f38209a.onAudioFileCreated(str);
        } catch (RemoteException e) {
            LogUtil.log("FileSliceListenerWrapper -> callback onAudioFileCreated fail. ", e);
        }
    }

    public void onAudioFileSliced(String str) {
        try {
            this.f38209a.onAudioFileSliced(str);
        } catch (RemoteException e) {
            LogUtil.log("Failed to callback onAudioFileSliced listener", e);
        }
    }
}
