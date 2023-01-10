package com.didi.entrega.customer.foundation.rpc.task;

import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.net.CRpcResult;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcResult;
import com.didi.nova.assembly.serial.Task;

public abstract class CustomerAsyncTask<T> extends Task {

    /* renamed from: a */
    private static final String f21878a = "CustomerAsyncTask";

    /* renamed from: b */
    private CustomerRpcCallback<T> f21879b;

    /* renamed from: c */
    private CRpcResult<T> f21880c;

    /* renamed from: d */
    private Exception f21881d;

    /* access modifiers changed from: protected */
    public abstract CRpcResult<T> execute() throws Exception;

    public void onCancel() {
    }

    public CustomerAsyncTask(CustomerRpcCallback<T> customerRpcCallback) {
        this.f21879b = customerRpcCallback;
    }

    public void onMainThread() {
        CustomerRpcCallback<T> customerRpcCallback = this.f21879b;
        if (customerRpcCallback != null) {
            CRpcResult<T> cRpcResult = this.f21880c;
            if (cRpcResult != null) {
                customerRpcCallback.onSuccess((SFRpcResult<T>) cRpcResult);
                return;
            }
            this.f21879b.onRpcFailure(new SFRpcException((Throwable) this.f21881d));
        }
    }

    public void onWorkThread() {
        try {
            CRpcResult<T> execute = execute();
            this.f21880c = execute;
            LogUtil.m18185i(f21878a, execute.toString());
        } catch (Exception e) {
            this.f21881d = e;
            LogUtil.m18185i(f21878a, e.toString());
        }
    }
}
