package com.didi.globalsafetoolkit.business.triprecording;

import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/globalsafetoolkit/business/triprecording/RecordListenerImpl;", "", "onAlreadyStart", "", "onError", "errCode", "", "onPause", "onResume", "onStart", "onStop", "globalsafe-toolkit_release"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: GlobalTripRecordingManagerNew.kt */
public interface RecordListenerImpl {

    @Metadata(mo148866bv = {1, 0, 3}, mo148869k = 3, mo148870mv = {1, 1, 15})
    /* compiled from: GlobalTripRecordingManagerNew.kt */
    public static final class DefaultImpls {
        public static void onAlreadyStart(RecordListenerImpl recordListenerImpl) {
        }
    }

    void onAlreadyStart();

    void onError(int i);

    void onPause();

    void onResume();

    void onStart();

    void onStop();
}
