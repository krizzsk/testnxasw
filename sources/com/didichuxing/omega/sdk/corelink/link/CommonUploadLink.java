package com.didichuxing.omega.sdk.corelink.link;

import com.didichuxing.omega.sdk.analysis.OMGUserStateSetting;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.utils.PrismUtil;
import com.didichuxing.omega.sdk.corelink.node.EventAttrsFilterNode;
import com.didichuxing.omega.sdk.corelink.node.EventFilterNode;
import com.didichuxing.omega.sdk.corelink.node.EventGlobalAttrsNode;
import com.didichuxing.omega.sdk.corelink.node.EventSampleNode;
import com.didichuxing.omega.sdk.corelink.node.EventSeqNode;
import com.didichuxing.omega.sdk.corelink.node.EventSpecialNode;

public class CommonUploadLink {
    public static void track(Event event, float f) {
        String eventId = event.getEventId();
        if ((OmegaConfig.isDebugModel() || !EventFilterNode.filter(event)) && !EventSpecialNode.filterS(event)) {
            boolean filterR = EventSpecialNode.filterR(event);
            EventSpecialNode.filterP(event);
            if (f >= 1.0f || EventSampleNode.isSampled(eventId, f)) {
                EventGlobalAttrsNode.addGlobalAttrs(event);
                EventAttrsFilterNode.attrsFilter(event);
                PrismUtil.invoke("SeqCheckUtil", "addEvent", event);
                EventSeqNode.addSeq(event);
                if (OmegaConfig.isDebugModel()) {
                    DebugUploadLink.track(event, filterR);
                } else if (OMGUserStateSetting.getUserState() == OMGUserStateSetting.OMGUserState.OMGUserStatePartialAuthorized || OMGUserStateSetting.getUserState() == OMGUserStateSetting.OMGUserState.OMGUserStateFullAuthorized) {
                    BatchUploadLink.track(event, filterR);
                }
                if (filterR) {
                    RealTimeUploadLink.track(event);
                }
            }
        }
    }
}
