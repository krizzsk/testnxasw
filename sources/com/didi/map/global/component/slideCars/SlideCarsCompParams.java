package com.didi.map.global.component.slideCars;

import com.didi.map.global.component.slideCars.api.CarNavigatorRequest;
import com.didi.map.global.component.slideCars.model.ICarBitmapDescriptor;

public class SlideCarsCompParams {

    /* renamed from: a */
    private ICarBitmapDescriptor f28405a;

    /* renamed from: b */
    private int f28406b;

    /* renamed from: c */
    private CarNavigatorRequest f28407c;

    /* renamed from: d */
    private boolean f28408d = true;

    public boolean isShowSlidingCar() {
        return this.f28408d;
    }

    public void setShowSlidingCar(boolean z) {
        this.f28408d = z;
    }

    public ICarBitmapDescriptor getBitmapGetter() {
        return this.f28405a;
    }

    public void setBitmapGetter(ICarBitmapDescriptor iCarBitmapDescriptor) {
        this.f28405a = iCarBitmapDescriptor;
    }

    public int getPullIntervalMs() {
        return this.f28406b;
    }

    public void setPullIntervalMs(int i) {
        this.f28406b = i;
    }

    public CarNavigatorRequest getCarSlidingRequestParam() {
        return this.f28407c;
    }

    public void setCarSlidingRequestParam(CarNavigatorRequest carNavigatorRequest) {
        this.f28407c = carNavigatorRequest;
    }
}
