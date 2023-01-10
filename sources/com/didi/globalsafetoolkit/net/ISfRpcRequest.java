package com.didi.globalsafetoolkit.net;

import com.didichuxing.foundation.rpc.RpcService;

public interface ISfRpcRequest<T extends RpcService> {
    String getBaseUrl();

    String getPathParameter();

    String getServiceName();
}
