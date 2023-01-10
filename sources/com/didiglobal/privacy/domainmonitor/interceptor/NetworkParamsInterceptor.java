package com.didiglobal.privacy.domainmonitor.interceptor;

import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.privacy.domainmonitor.model.NetworkParam;
import com.didiglobal.privacy.domainmonitor.utils.OmegaUtil;
import com.didiglobal.privacy.domainmonitor.utils.URLConnectionDebugLogUtils;

@ServiceProvider({INetworkParamsInterceptor.class})
public class NetworkParamsInterceptor implements INetworkParamsInterceptor {

    /* renamed from: a */
    private static final String f53046a = "NetworkParamsIntercept";

    public void onRequestFinished(NetworkParam networkParam) {
        URLConnectionDebugLogUtils.m39753d(f53046a, "[onRequestFinished] networkParam = " + networkParam);
        OmegaUtil.tech_driver_network_monitor_extra(networkParam);
    }
}
