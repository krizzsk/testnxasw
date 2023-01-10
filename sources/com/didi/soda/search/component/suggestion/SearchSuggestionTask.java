package com.didi.soda.search.component.suggestion;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.SearchSuggestionEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcResult;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.task.CustomerAsyncTask;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchSuggestionTask extends CustomerAsyncTask<SearchSuggestionEntity> {

    /* renamed from: a */
    private static final String f46315a = "SearchAddressTask";

    /* renamed from: b */
    private static final String f46316b = "tag";

    /* renamed from: c */
    private int f46317c = 0;

    /* renamed from: d */
    private CustomerRpcService f46318d;

    /* renamed from: e */
    private String f46319e;

    /* renamed from: f */
    private String f46320f;

    public SearchSuggestionTask(CustomerRpcCallback customerRpcCallback, String str, String str2, int i) {
        super(customerRpcCallback);
        this.f46319e = str;
        this.f46320f = str2;
        this.f46317c = i;
        this.f46318d = CustomerRpcManagerProxy.get();
    }

    public void onCancel() {
        super.onCancel();
        LogUtil.m32588i(f46315a, toString() + "-onCancel");
    }

    public void onMainThread() {
        super.onMainThread();
        LogUtil.m32588i(f46315a, toString() + "-onMainThread");
    }

    public void onWorkThread() {
        super.onWorkThread();
        LogUtil.m32588i(f46315a, toString() + "-onWorkThread");
    }

    /* access modifiers changed from: protected */
    public CRpcResult<SearchSuggestionEntity> execute() {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tag", this.f46319e);
            str = jSONObject.toString();
        } catch (JSONException unused) {
            str = "";
        }
        return this.f46318d.getSearchSuggestion(str, this.f46320f, this.f46317c);
    }
}
