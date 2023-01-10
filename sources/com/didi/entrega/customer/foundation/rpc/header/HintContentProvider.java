package com.didi.entrega.customer.foundation.rpc.header;

import com.didi.entrega.customer.foundation.util.GsonUtil;
import com.didi.entrega.customer.foundation.util.LocationUtil;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.ILocaleService;
import com.didi.foundation.sdk.utils.LocalizationUtils;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;

public class HintContentProvider extends AbsHttpHeaderContentProvider {

    /* renamed from: a */
    private static final String f21869a = "didi-header-hint-content";

    public String getParamKey() {
        return f21869a;
    }

    public HintContentProvider(HttpRpcRequest httpRpcRequest, HttpRpcClient httpRpcClient) {
        super(httpRpcRequest, httpRpcClient);
    }

    public String getParamContent() {
        return m18199c();
    }

    /* renamed from: c */
    private String m18199c() {
        HintContentStruct hintContentStruct = new HintContentStruct();
        hintContentStruct.setLang(((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag());
        hintContentStruct.setAppTimeout(mo65729a().getReadTimeout() + mo65729a().getWriteTimeout());
        hintContentStruct.setCityId(LocationUtil.getCityId());
        hintContentStruct.setUtcOffset(String.valueOf(LocalizationUtils.getTimeZoneUtcOffset()));
        return GsonUtil.toJson(hintContentStruct);
    }
}
