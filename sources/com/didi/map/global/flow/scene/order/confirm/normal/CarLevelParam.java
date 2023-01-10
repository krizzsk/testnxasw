package com.didi.map.global.flow.scene.order.confirm.normal;

import android.view.View;
import com.didi.map.global.flow.scene.CarSlidingParam;
import com.didi.map.global.flow.scene.minibus.param.MiniBusParamInterface;
import com.didi.map.global.flow.scene.order.confirm.RoutePlanParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import java.util.List;

public class CarLevelParam {

    /* renamed from: a */
    private CircleParam f29143a;

    /* renamed from: b */
    private View f29144b;

    /* renamed from: c */
    private CarSlidingParam f29145c;

    /* renamed from: d */
    private RoutePlanParam f29146d;

    /* renamed from: e */
    private MiniBusParamInterface f29147e;

    /* renamed from: f */
    private List<CommonMarkerParam> f29148f;

    /* renamed from: g */
    private int f29149g = 0;

    public CircleParam getCircleParam() {
        return this.f29143a;
    }

    public void setCircleParam(CircleParam circleParam) {
        this.f29143a = circleParam;
    }

    public View getViewTip() {
        return this.f29144b;
    }

    public void setViewTip(View view) {
        this.f29144b = view;
    }

    public CarSlidingParam getCarSlidingParam() {
        return this.f29145c;
    }

    public void setCarSlidingParam(CarSlidingParam carSlidingParam) {
        this.f29145c = carSlidingParam;
    }

    public RoutePlanParam getRoutePlanParam() {
        return this.f29146d;
    }

    public void setRoutePlanParam(RoutePlanParam routePlanParam) {
        this.f29146d = routePlanParam;
    }

    public MiniBusParamInterface getMiniBusParamInterface() {
        return this.f29147e;
    }

    public void setMiniBusParamInterface(MiniBusParamInterface miniBusParamInterface) {
        this.f29147e = miniBusParamInterface;
    }

    public List<CommonMarkerParam> getMarkerParams() {
        return this.f29148f;
    }

    public void setMarkerParams(List<CommonMarkerParam> list) {
        this.f29148f = list;
    }

    public void setSceneType(int i) {
        this.f29149g = i;
    }

    public int getSceneType() {
        return this.f29149g;
    }
}
