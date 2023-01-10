package com.didi.globalsafetoolkit.business.triprecording;

import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo148868d2 = {"<anonymous>", "", "recordDuration", "", "onTimeTick"}, mo148869k = 3, mo148870mv = {1, 1, 15})
/* compiled from: GlobalTripRecordingManagerNew.kt */
final class GlobalTripRecordingManagerNew$mDurationChangedListener$1 implements AudioRecorder.DurationChangedListener {
    final /* synthetic */ GlobalTripRecordingManagerNew this$0;

    GlobalTripRecordingManagerNew$mDurationChangedListener$1(GlobalTripRecordingManagerNew globalTripRecordingManagerNew) {
        this.this$0 = globalTripRecordingManagerNew;
    }

    public final void onTimeTick(int i) {
        for (DurationListener durationListener : this.this$0.f25123c) {
            if (durationListener != null) {
                durationListener.onCallback(this.this$0.m20111a(i / 1000));
            }
        }
    }
}
