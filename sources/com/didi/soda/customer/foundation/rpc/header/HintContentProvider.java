package com.didi.soda.customer.foundation.rpc.header;

import com.didi.foundation.sdk.utils.LocalizationUtils;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;

public class HintContentProvider extends AbsHttpHeaderContentProvider {

    /* renamed from: a */
    private static final String f43641a = "didi-header-hint-content";

    public String getParamKey() {
        return f43641a;
    }

    public HintContentProvider(HttpRpcRequest httpRpcRequest, HttpRpcClient httpRpcClient) {
        super(httpRpcRequest, httpRpcClient);
    }

    public String getParamContent() {
        return m32609c();
    }

    /* renamed from: c */
    private String m32609c() {
        HintContentStruct hintContentStruct = new HintContentStruct();
        hintContentStruct.setLang(((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag());
        hintContentStruct.setAppTimeout(mo111215a().getReadTimeout() + mo111215a().getWriteTimeout());
        int cityId = LocationUtil.getCityId();
        hintContentStruct.setCityId(cityId);
        hintContentStruct.setUtcOffset(String.valueOf(LocalizationUtils.getTimeZoneUtcOffset()));
        hintContentStruct.setLocationCityId(cityId);
        hintContentStruct.setLocationCountryId(LocationUtil.getCountryCode());
        hintContentStruct.setLocale(((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocaleTag());
        return GsonUtil.toJson(hintContentStruct);
    }
}
