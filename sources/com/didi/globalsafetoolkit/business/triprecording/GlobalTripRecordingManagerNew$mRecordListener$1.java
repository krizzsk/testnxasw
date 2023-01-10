package com.didi.globalsafetoolkit.business.triprecording;

import com.didi.globalsafetoolkit.GlobalSfBusinessInterface;
import com.didi.globalsafetoolkit.util.SfLog;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, mo148868d2 = {"com/didi/globalsafetoolkit/business/triprecording/GlobalTripRecordingManagerNew$mRecordListener$1", "Lcom/didi/sdk/audiorecorder/helper/recorder/AudioRecorder$RecordListener;", "onPause", "", "onResume", "onStart", "onStop", "globalsafe-toolkit_release"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: GlobalTripRecordingManagerNew.kt */
public final class GlobalTripRecordingManagerNew$mRecordListener$1 implements AudioRecorder.RecordListener {
    final /* synthetic */ GlobalTripRecordingManagerNew this$0;

    GlobalTripRecordingManagerNew$mRecordListener$1(GlobalTripRecordingManagerNew globalTripRecordingManagerNew) {
        this.this$0 = globalTripRecordingManagerNew;
    }

    public void onResume() {
        this.this$0.f25125e = true;
        RecordListenerImpl access$getMOutRecordListener$p = this.this$0.f25124d;
        if (access$getMOutRecordListener$p != null) {
            access$getMOutRecordListener$p.onResume();
        }
        GlobalSfBusinessInterface.onRecordingStatusChanged(true);
        SfLog.m20152i(this.this$0.f25121a, "Recording onResume callback");
    }

    public void onPause() {
        this.this$0.f25125e = false;
        RecordListenerImpl access$getMOutRecordListener$p = this.this$0.f25124d;
        if (access$getMOutRecordListener$p != null) {
            access$getMOutRecordListener$p.onPause();
        }
        GlobalSfBusinessInterface.onRecordingStatusChanged(false);
        SfLog.m20152i(this.this$0.f25121a, "Recording onPause callback");
    }

    public void onStart() {
        this.this$0.f25125e = true;
        RecordListenerImpl access$getMOutRecordListener$p = this.this$0.f25124d;
        if (access$getMOutRecordListener$p != null) {
            access$getMOutRecordListener$p.onStart();
        }
        GlobalSfBusinessInterface.onRecordingStatusChanged(true);
        SfLog.m20152i(this.this$0.f25121a, "Recording onStart callback");
    }

    public void onStop() {
        this.this$0.f25125e = false;
        this.this$0.f25126f = "00:00:00";
        RecordListenerImpl access$getMOutRecordListener$p = this.this$0.f25124d;
        if (access$getMOutRecordListener$p != null) {
            access$getMOutRecordListener$p.onStop();
        }
        GlobalSfBusinessInterface.onRecordingStatusChanged(false);
        SfLog.m20152i(this.this$0.f25121a, "Recording onStop callback");
    }
}
