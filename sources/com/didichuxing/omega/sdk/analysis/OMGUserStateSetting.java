package com.didichuxing.omega.sdk.analysis;

import com.didichuxing.omega.sdk.common.perforence.RuntimeCheck;
import com.didichuxing.omega.sdk.common.threadpool.ScheduledTaskObject;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;

public class OMGUserStateSetting {

    public enum OMGUserState {
        OMGUserStateUndetermined,
        OMGUserStateNotAuthorized,
        OMGUserStatePartialAuthorized,
        OMGUserStateFullAuthorized
    }

    public static synchronized void setUserState(OMGUserState oMGUserState) {
        synchronized (OMGUserStateSetting.class) {
        }
    }

    public static synchronized OMGUserState getUserState() {
        OMGUserState oMGUserState;
        synchronized (OMGUserStateSetting.class) {
            oMGUserState = OMGUserState.OMGUserStateFullAuthorized;
        }
        return oMGUserState;
    }

    public static void initOaid() {
        if (RuntimeCheck.IsMainProcess()) {
            CommonUtil.setOaidSwitch(CommonUtil.getOaidSwitch());
        }
    }

    public static void trackODAT() {
        ScheduledTaskObject.getInstance().start(new Runnable() {
            public void run() {
                SystemTrack.trackODAT();
            }
        }, 8000);
    }
}
