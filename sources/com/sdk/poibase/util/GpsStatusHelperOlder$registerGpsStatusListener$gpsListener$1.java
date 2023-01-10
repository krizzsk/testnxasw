package com.sdk.poibase.util;

import android.location.GpsStatus;
import com.sdk.poibase.util.BaseGpsStatusHelper;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo148868d2 = {"<anonymous>", "", "event", "", "onGpsStatusChanged"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: GpsStatusHelperOlder.kt */
final class GpsStatusHelperOlder$registerGpsStatusListener$gpsListener$1 implements GpsStatus.Listener {
    final /* synthetic */ BaseGpsStatusHelper.IGpsStatusChanged $listener;

    GpsStatusHelperOlder$registerGpsStatusListener$gpsListener$1(BaseGpsStatusHelper.IGpsStatusChanged iGpsStatusChanged) {
        this.$listener = iGpsStatusChanged;
    }

    public final void onGpsStatusChanged(int i) {
        if (i == 1) {
            this.$listener.onStarted();
        } else if (i == 2) {
            this.$listener.onStopped();
        } else if (i == 3) {
            this.$listener.onFirstFix();
        } else if (i == 4) {
            this.$listener.onSatelliteStatusChanged();
        }
    }
}
