package com.didi.map.global.sctx;

import com.didi.map.global.sctx.model.SctxTripParam;
import com.didi.map.google.util.DLog;
import com.didi.map.utils.ApolloUtils;

public class SctxServiceFactory {

    /* renamed from: a */
    private static final String f30029a = "SctxServiceFactory";

    public SctxService getSctxService(SctxTripParam sctxTripParam) {
        if (ApolloUtils.enableRefreshTraffic()) {
            DLog.m23519d(f30029a, "refresh traffic", new Object[0]);
            return new PassengerSctxServiceTwo(sctxTripParam);
        }
        DLog.m23519d(f30029a, "don't refresh traffic", new Object[0]);
        return new PassengerSctxServiceImp(sctxTripParam);
    }
}
