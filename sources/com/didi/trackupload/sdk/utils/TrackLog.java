package com.didi.trackupload.sdk.utils;

import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class TrackLog {

    /* renamed from: a */
    private static final Logger f46667a = LoggerFactory.getLogger("TrackSDK", InvitationPageActivity.TRACK);

    /* renamed from: d */
    public static void m34830d(String str, String str2) {
        try {
            f46667a.info(str + "|" + str2, new Object[0]);
        } catch (Exception e) {
            SystemUtils.log(3, "TrackLog || DLog", "Exception " + e.toString(), (Throwable) null, "com.didi.trackupload.sdk.utils.TrackLog", 27);
        }
    }
}
