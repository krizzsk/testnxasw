package com.didi.sdk.global.common.utils;

import android.content.Context;
import com.didi.payment.base.utils.PayBaseParamUtil;
import java.util.HashMap;

public class RpcParameterBuilder {

    /* renamed from: a */
    private Context f38866a;

    /* renamed from: b */
    private HashMap<String, Object> f38867b;

    public RpcParameterBuilder(Context context) {
        this.f38866a = context;
        HashMap<String, Object> hashMap = new HashMap<>();
        this.f38867b = hashMap;
        hashMap.putAll(PayBaseParamUtil.getHttpBaseParams(this.f38866a));
    }

    public RpcParameterBuilder addParam(String str, Object obj) {
        this.f38867b.put(str, obj);
        return this;
    }

    public HashMap<String, Object> build() {
        return this.f38867b;
    }
}
