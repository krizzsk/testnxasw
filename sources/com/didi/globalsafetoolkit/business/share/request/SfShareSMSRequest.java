package com.didi.globalsafetoolkit.business.share.request;

import com.didi.globalsafetoolkit.net.ISfNetService;
import com.didi.globalsafetoolkit.net.ISfRpcRequest;
import com.didi.globalsafetoolkit.net.SfRpcParam;
import com.didi.globalsafetoolkit.net.SfUrls;

public class SfShareSMSRequest implements ISfRpcRequest<ISfNetService> {
    @SfRpcParam("contacts")
    public String contacts;
    @SfRpcParam("oid")
    public String orderId;
    @SfRpcParam("product_id")
    public int productId;

    public String getPathParameter() {
        return null;
    }

    public String getServiceName() {
        return "shareSMS";
    }

    public String getBaseUrl() {
        return SfUrls.getBaseUrl();
    }
}
