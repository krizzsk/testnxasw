package com.didi.globalsafetoolkit.business.emergency.request;

import com.didi.globalsafetoolkit.net.ISfNetService;
import com.didi.globalsafetoolkit.net.ISfRpcRequest;
import com.didi.globalsafetoolkit.net.SfRpcParam;
import com.didi.globalsafetoolkit.net.SfUrls;

public class SfStopEmergencyCallRequest implements ISfRpcRequest<ISfNetService> {
    @SfRpcParam("country_code")
    public String countryCode;
    @SfRpcParam("oid")
    public String orderId;
    @SfRpcParam("product_id")
    public int productId;

    public String getPathParameter() {
        return null;
    }

    public String getServiceName() {
        return "stopEmergencyCall";
    }

    public String getBaseUrl() {
        return SfUrls.getBaseUrl();
    }
}
