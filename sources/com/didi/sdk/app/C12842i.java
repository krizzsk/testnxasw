package com.didi.sdk.app;

import com.didi.sdk.log.Logger;
import com.didichuxing.apollo.sdk.log.ApolloErrorLog;
import com.didichuxing.apollo.sdk.log.ApolloLog;
import com.didichuxing.swarm.toolkit.TransmissionService;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.didi.sdk.app.i */
/* compiled from: TransmissionService2 */
class C12842i implements TransmissionService {
    C12842i() {
    }

    public void transmit(Object obj) {
        if (obj instanceof ApolloLog) {
            m28672a((ApolloLog) obj);
        } else if (obj instanceof ApolloErrorLog) {
            m28671a((ApolloErrorLog) obj);
        }
    }

    /* renamed from: a */
    private void m28672a(ApolloLog apolloLog) {
        HashMap hashMap = new HashMap();
        Set<Map.Entry<String, String>> logEntrySet = apolloLog.getLogEntrySet();
        if (logEntrySet != null && !logEntrySet.isEmpty()) {
            for (Map.Entry next : logEntrySet) {
                hashMap.put(next.getKey(), next.getValue());
            }
        }
        OmegaSDKAdapter.trackEvent("apollo_log", "", hashMap);
        Logger.easylog("apollo_controller", "saveLog: " + hashMap);
    }

    /* renamed from: a */
    private void m28671a(ApolloErrorLog apolloErrorLog) {
        String logKey = apolloErrorLog.getLogKey();
        String errorMsg = apolloErrorLog.getErrorMsg();
        if (logKey != null && errorMsg != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(logKey, errorMsg);
            OmegaSDKAdapter.trackEvent("apollo_error", "", hashMap);
            Logger.easylog("apollo_controller", "saveErrorLog: " + hashMap);
        }
    }
}
