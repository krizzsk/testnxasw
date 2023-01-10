package com.didichuxing.omega.sdk.corelink;

import android.content.Context;
import com.didichuxing.omega.sdk.analysis.Security;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.utils.OLog;
import com.didichuxing.omega.sdk.common.utils.PrismUtil;
import com.didichuxing.omega.sdk.corelink.link.CommonUploadLink;
import com.didichuxing.omega.sdk.corelink.node.EventConsumerQueueNode;
import com.didichuxing.omega.sdk.corelink.node.EventProduceQueueNode;
import com.didichuxing.omega.sdk.corelink.node.EventRecordPathNode;
import com.tencent.mmkv.MMKV;
import global.didi.pay.newview.pix.IPixView;
import java.util.Set;

public class LinkManager {
    public static void init(Context context) {
        EventProduceQueueNode.init(context);
        Security.init_SecurityCheckUtil(context);
    }

    public static void track(Event event, float f) {
        if (OmegaConfig.IS_INIT && OmegaConfig.SWITCH_EVENT) {
            if (event == null || event.getEventId() == null || event.getEventId().length() == 0) {
                OLog.m38206e("trackEvent fail! event is null.");
                return;
            }
            Security.addEvent_SecurityCheckUtil(event);
            if (OmegaConfig.getYunStatus()) {
                PrismUtil.invoke("YunMachineUtil", IPixView.PAGE_STATUS_INIT, new Object[0]);
                PrismUtil.invoke("YunMachineUtil", "addEvent", event);
            }
            CommonUploadLink.track(event, f);
        }
    }

    private static void seqCheckInit(Set set) {
        String[] allMkKey = EventConsumerQueueNode.getAllMkKey();
        if (allMkKey != null && allMkKey.length > 0) {
            for (String mmkvWithID : allMkKey) {
                MMKV mmkvWithID2 = MMKV.mmkvWithID(mmkvWithID, EventRecordPathNode.getRecordDataPath());
                set.add(Long.valueOf(mmkvWithID2.decodeLong("seq")));
                mmkvWithID2.close();
            }
        }
    }

    private static void seqCheck(Set set, Set set2) {
        for (String mmkvWithID : EventConsumerQueueNode.getAllMkKey()) {
            MMKV mmkvWithID2 = MMKV.mmkvWithID(mmkvWithID, EventRecordPathNode.getRecordDataPath());
            long decodeLong = mmkvWithID2.decodeLong("seq");
            if (!set.contains(Long.valueOf(decodeLong))) {
                set2.add(Long.valueOf(decodeLong));
            }
            mmkvWithID2.close();
        }
    }
}
