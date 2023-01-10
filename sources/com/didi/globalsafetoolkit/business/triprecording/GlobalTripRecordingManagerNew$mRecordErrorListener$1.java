package com.didi.globalsafetoolkit.business.triprecording;

import com.didi.globalsafetoolkit.util.SfLog;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo148868d2 = {"<anonymous>", "", "errorCode", "", "onError"}, mo148869k = 3, mo148870mv = {1, 1, 15})
/* compiled from: GlobalTripRecordingManagerNew.kt */
final class GlobalTripRecordingManagerNew$mRecordErrorListener$1 implements AudioRecorder.OnErrorListener {
    final /* synthetic */ GlobalTripRecordingManagerNew this$0;

    GlobalTripRecordingManagerNew$mRecordErrorListener$1(GlobalTripRecordingManagerNew globalTripRecordingManagerNew) {
        this.this$0 = globalTripRecordingManagerNew;
    }

    public final void onError(int i) {
        RecordListenerImpl access$getMOutRecordListener$p = this.this$0.f25124d;
        if (access$getMOutRecordListener$p != null) {
            access$getMOutRecordListener$p.onError(i);
        }
        this.this$0.stop();
        String valueOf = String.valueOf(i);
        RecordingModel access$getMRecordingModel$p = this.this$0.f25122b;
        TripRecordOmageUtils.ibt_gd_safetyrecord_start_error_bt(valueOf, access$getMRecordingModel$p != null ? access$getMRecordingModel$p.getOid() : null);
        String access$get_tag$p = this.this$0.f25121a;
        SfLog.m20152i(access$get_tag$p, "Recording onError callback : " + i);
    }
}
