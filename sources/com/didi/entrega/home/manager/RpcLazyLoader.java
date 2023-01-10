package com.didi.entrega.home.manager;

import com.didi.entrega.customer.app.ServerConfigManager;

public class RpcLazyLoader {

    /* renamed from: a */
    private static RpcLazyLoader f22562a = new RpcLazyLoader();
    public boolean mIsInit = false;

    public static RpcLazyLoader getLoader() {
        return f22562a;
    }

    public void lazyRpc() {
        if (!this.mIsInit) {
            this.mIsInit = true;
            ServerConfigManager.getInstance().initConfig((ServerConfigManager.OnInitConfigCallback) null);
        }
    }
}
