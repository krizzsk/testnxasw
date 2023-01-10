package com.didi.soda.customer.foundation.rpc.task;

import com.didi.nova.assembly.serial.Task;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.net.CRpcResult;
import com.didi.soda.customer.foundation.rpc.net.SFRpcResult;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;

public abstract class CustomerAsyncTask<T> extends Task {

    /* renamed from: a */
    private static final String f43650a = "CustomerAsyncTask";

    /* renamed from: b */
    private RpcService.Callback<SFRpcResult<T>> f43651b;

    /* renamed from: c */
    private CRpcResult<T> f43652c;

    /* renamed from: d */
    private Exception f43653d;

    /* access modifiers changed from: protected */
    public abstract CRpcResult<T> execute() throws Exception;

    public void onCancel() {
    }

    public CustomerAsyncTask(RpcService.Callback<SFRpcResult<T>> callback) {
        this.f43651b = callback;
    }

    public void onMainThread() {
        RpcService.Callback<SFRpcResult<T>> callback = this.f43651b;
        if (callback != null) {
            CRpcResult<T> cRpcResult = this.f43652c;
            if (cRpcResult != null) {
                callback.onSuccess(cRpcResult);
                return;
            }
            this.f43651b.onFailure(new IOException(this.f43653d));
        }
    }

    public void onWorkThread() {
        try {
            CRpcResult<T> execute = execute();
            this.f43652c = execute;
            LogUtil.m32588i(f43650a, execute.toString());
        } catch (Exception e) {
            this.f43653d = e;
            LogUtil.m32588i(f43650a, e.toString());
        }
    }
}
