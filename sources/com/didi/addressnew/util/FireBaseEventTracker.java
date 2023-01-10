package com.didi.addressnew.util;

import com.didi.address.FromType;
import com.didi.common.map.util.DLog;
import java.util.Map;

public class FireBaseEventTracker {

    /* renamed from: a */
    private static FireBaseEventTrackListener f9311a;

    public static void trackAddNewFavPlace(FromType fromType) {
        FireBaseEventTrackListener fireBaseEventTrackListener;
        if (f9311a != null) {
            boolean z = false;
            if (fromType == FromType.SETTING || fromType == FromType.HOME) {
                z = true;
            }
            if (z && (fireBaseEventTrackListener = f9311a) != null) {
                fireBaseEventTrackListener.trackEvent("gp_faviritePlace_addNew_ck", (Map<String, Object>) null);
            }
        }
    }

    public static FireBaseEventTrackListener getFireBaseEventTrackListener() {
        DLog.m10773d("Firebase", "getFireBaseEventTrackListener " + f9311a, new Object[0]);
        return f9311a;
    }

    public static void setFireBaseEventTrackListener(FireBaseEventTrackListener fireBaseEventTrackListener) {
        DLog.m10773d("Firebase", "setFireBaseEventTrackListener listener =" + fireBaseEventTrackListener + ",sFireBaseEventTrackListener =" + f9311a, new Object[0]);
        f9311a = fireBaseEventTrackListener;
    }
}
