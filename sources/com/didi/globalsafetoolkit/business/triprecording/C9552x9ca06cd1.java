package com.didi.globalsafetoolkit.business.triprecording;

import com.didi.sdk.audiorecorder.helper.AudioUploader;
import com.didi.sdk.audiorecorder.model.RecordResult;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000b¸\u0006\u0000"}, mo148868d2 = {"com/didi/globalsafetoolkit/business/triprecording/GlobalTripRecordingManagerNew$setListener$1$1", "Lcom/didi/sdk/audiorecorder/helper/AudioUploader$UploadListener;", "onFail", "", "record", "Lcom/didi/sdk/audiorecorder/model/RecordResult;", "errCode", "", "p2", "", "onSuccess", "globalsafe-toolkit_release"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* renamed from: com.didi.globalsafetoolkit.business.triprecording.GlobalTripRecordingManagerNew$setListener$$inlined$apply$lambda$1 */
/* compiled from: GlobalTripRecordingManagerNew.kt */
public final class C9552x9ca06cd1 implements AudioUploader.UploadListener {
    final /* synthetic */ GlobalTripRecordingManagerNew this$0;

    public void onSuccess(RecordResult recordResult) {
    }

    C9552x9ca06cd1(GlobalTripRecordingManagerNew globalTripRecordingManagerNew) {
        this.this$0 = globalTripRecordingManagerNew;
    }

    public void onFail(RecordResult recordResult, int i, Throwable th) {
        String valueOf = String.valueOf(i);
        RecordingModel access$getMRecordingModel$p = this.this$0.f25122b;
        TripRecordOmageUtils.ibt_gd_safetyrecord_break_error_bt(valueOf, access$getMRecordingModel$p != null ? access$getMRecordingModel$p.getOid() : null);
    }
}
