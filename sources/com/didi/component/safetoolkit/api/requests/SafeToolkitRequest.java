package com.didi.component.safetoolkit.api.requests;

import android.content.Context;
import com.didi.component.business.constant.HostConstants;
import com.didi.component.safetoolkit.api.SafeToolkitRequestService;
import com.didi.travel.psnger.common.net.base.BaseRequest;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.util.Map;

public class SafeToolkitRequest extends BaseRequest {

    /* renamed from: a */
    private SafeToolkitRequestService f17214a;

    /* renamed from: b */
    private Context f17215b;

    public void reportUserState() {
    }

    public SafeToolkitRequest(Context context) {
        this.f17215b = context;
        this.f17214a = (SafeToolkitRequestService) new RpcServiceFactory(context).newRpcService(SafeToolkitRequestService.class, HostConstants.getHostApi());
    }

    public void querySafeToolkitStatus(Map<String, Object> map, RpcService.Callback callback) {
        Map<String, Object> createBaseParams = createBaseParams(this.f17215b);
        if (map != null) {
            createBaseParams.putAll(map);
        }
        this.f17214a.queryStatus(createBaseParams, callback);
    }
}
