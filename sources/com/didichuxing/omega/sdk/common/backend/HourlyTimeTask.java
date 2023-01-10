package com.didichuxing.omega.sdk.common.backend;

import com.didichuxing.omega.sdk.analysis.OMGUserStateSetting;
import com.didichuxing.omega.sdk.analysis.SystemTrack;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.threadpool.ScheduledTaskObject;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;

public class HourlyTimeTask {
    public static void startHourlyTimeTask() {
        SyncStrategy.async();
        OMGUserStateSetting.trackODAT();
        SyncStrategy.delaySync();
        ScheduledTaskObject.getInstance().start(new Runnable() {
            public void run() {
                SystemTrack.trackHourly();
            }
        }, 0, (long) OmegaConfig.SYNC_REMOTE_INTERVAL);
        CommonUtil.initPrismYun();
    }
}
