package com.didi.globalsafetoolkit.business.safeCenter.request;

import com.didi.globalsafetoolkit.net.ISfNetService;
import com.didi.globalsafetoolkit.net.ISfRpcRequest;
import com.didi.globalsafetoolkit.net.SfRpcParam;
import com.didi.globalsafetoolkit.net.SfUrls;

public class SfSafeCenterRequest implements ISfRpcRequest<ISfNetService> {
    @SfRpcParam("lang")
    public String lang;
    @SfRpcParam("origin_id")
    public String originId;
    @SfRpcParam("token")
    public String token;
    @SfRpcParam("oasisDriver")
    public int vamosDriver;

    public String getPathParameter() {
        return null;
    }

    public String getServiceName() {
        return "safetyCenter";
    }

    public String getBaseUrl() {
        return SfUrls.getBaseUrl();
    }
}
