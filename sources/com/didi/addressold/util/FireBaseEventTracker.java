package com.didi.addressold.util;

import com.didi.address.FromType;
import com.didi.common.map.util.DLog;
import java.util.Map;

public class FireBaseEventTracker {

    /* renamed from: a */
    private static FireBaseEventTrackListener f9618a;

    public static void trackAddNewFavPlace(FromType fromType) {
        FireBaseEventTrackListener fireBaseEventTrackListener;
        if (f9618a != null) {
            boolean z = false;
            if (fromType == FromType.SETTING || fromType == FromType.HOME) {
                z = true;
            }
            if (z && (fireBaseEventTrackListener = f9618a) != null) {
                fireBaseEventTrackListener.trackEvent("gp_faviritePlace_addNew_ck", (Map<String, Object>) null);
            }
        }
    }

    public static FireBaseEventTrackListener getFireBaseEventTrackListener() {
        DLog.m10773d("Firebase", "getFireBaseEventTrackListener " + f9618a, new Object[0]);
        return f9618a;
    }

    public static void setFireBaseEventTrackListener(FireBaseEventTrackListener fireBaseEventTrackListener) {
        DLog.m10773d("Firebase", "setFireBaseEventTrackListener listener =" + fireBaseEventTrackListener + ",sFireBaseEventTrackListener =" + f9618a, new Object[0]);
        f9618a = fireBaseEventTrackListener;
    }
}
