package com.didi.map.global.flow.scene.order.waiting.p124v2;

import com.didi.map.global.component.slideCars.api.CarNavigatorRequest;

/* renamed from: com.didi.map.global.flow.scene.order.waiting.v2.WaitingCarParam */
public class WaitingCarParam {

    /* renamed from: a */
    private int f29494a;

    /* renamed from: b */
    private ICarPositionFlushCallback f29495b;

    /* renamed from: c */
    private CarNavigatorRequest f29496c;

    public WaitingCarParam(int i, CarNavigatorRequest carNavigatorRequest) {
        this.f29494a = i;
        this.f29496c = carNavigatorRequest;
    }

    public int getPullIntervalMs() {
        return this.f29494a;
    }

    public void setPullIntervalMs(int i) {
        this.f29494a = i;
    }

    public ICarPositionFlushCallback getCarPositionFlushCallback() {
        return this.f29495b;
    }

    public void setCarPositionFlushCallback(ICarPositionFlushCallback iCarPositionFlushCallback) {
        this.f29495b = iCarPositionFlushCallback;
    }

    public CarNavigatorRequest getCarNavigatorRequest() {
        return this.f29496c;
    }

    public void setCarNavigatorRequest(CarNavigatorRequest carNavigatorRequest) {
        this.f29496c = carNavigatorRequest;
    }
}
