package com.didi.globalsafetoolkit.business.triprecording;

import com.didi.globalsafetoolkit.business.record.request.SfAutoRecordRequest;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "run"}, mo148869k = 3, mo148870mv = {1, 1, 15})
/* compiled from: TripRecordingActivity.kt */
final class TripRecordingActivity$startRecord$1$onStart$1 implements Runnable {
    public static final TripRecordingActivity$startRecord$1$onStart$1 INSTANCE = new TripRecordingActivity$startRecord$1$onStart$1();

    TripRecordingActivity$startRecord$1$onStart$1() {
    }

    public final void run() {
        SfAutoRecordRequest.requestJarvis(1);
    }
}
