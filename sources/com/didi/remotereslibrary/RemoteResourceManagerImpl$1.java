package com.didi.remotereslibrary;

import android.util.Pair;
import com.didi.remotereslibrary.utils.C12329Util;
import com.didi.remotereslibrary.utils.DLog;
import com.didichuxing.apollo.sdk.observer.OnToggleStateChangeListener;

class RemoteResourceManagerImpl$1 implements OnToggleStateChangeListener {
    final /* synthetic */ C12325a this$0;

    RemoteResourceManagerImpl$1(C12325a aVar) {
        this.this$0 = aVar;
    }

    public void onStateChanged() {
        DLog.m27099d(C12329Util.TAG, "apollo数据变更了 重新摘取城市信息");
        Pair<Double, Double> departureLatLng = RemoteResourceManager.getInstance().getDepartureParam().getDepartureLatLng();
        if (departureLatLng != null) {
            this.this$0.pullRemoteResource(((Double) departureLatLng.first).doubleValue(), ((Double) departureLatLng.second).doubleValue());
        } else {
            this.this$0.pullRemoteResource(0.0d, 0.0d);
        }
    }
}
