package com.didi.map.global.component.slideCars.navigator;

import android.content.Context;
import com.didi.map.global.component.slideCars.api.ApiType;
import com.didi.map.global.component.slideCars.api.CarNavigatorApiFactory;
import com.didi.map.global.component.slideCars.api.CarNavigatorRequest;
import com.didi.map.global.component.slideCars.api.ICarNavigatorCallback;

public class NavigatorPresenter {

    /* renamed from: a */
    private String f28466a = "BaseNavigator";

    /* renamed from: b */
    private Context f28467b;

    /* renamed from: c */
    private ApiType f28468c;

    public NavigatorPresenter(Context context, ApiType apiType) {
        this.f28467b = context;
        this.f28468c = apiType;
    }

    public void getCarNavigatorData(CarNavigatorRequest carNavigatorRequest, ICarNavigatorCallback iCarNavigatorCallback) {
        if (carNavigatorRequest != null) {
            m22248a(carNavigatorRequest, this.f28468c, iCarNavigatorCallback);
        }
    }

    /* renamed from: a */
    private void m22248a(CarNavigatorRequest carNavigatorRequest, ApiType apiType, ICarNavigatorCallback iCarNavigatorCallback) {
        Context context = this.f28467b;
        if (context != null) {
            CarNavigatorApiFactory.createCarNavigator(context, apiType).getCarNavigator(carNavigatorRequest, iCarNavigatorCallback);
        }
    }
}
