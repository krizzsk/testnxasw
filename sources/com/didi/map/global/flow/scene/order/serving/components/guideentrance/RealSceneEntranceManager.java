package com.didi.map.global.flow.scene.order.serving.components.guideentrance;

import com.didi.map.global.flow.scene.order.serving.param.ServingParam;

public class RealSceneEntranceManager {

    /* renamed from: a */
    private static RealSceneEntranceManager f29395a;

    /* renamed from: b */
    private ServingParam f29396b;

    private RealSceneEntranceManager(ServingParam servingParam) {
        this.f29396b = servingParam;
    }

    public static RealSceneEntranceManager getInstance(ServingParam servingParam) {
        if (f29395a == null) {
            f29395a = new RealSceneEntranceManager(servingParam);
        }
        return f29395a;
    }

    public void showReal() {
        ServingParam servingParam = this.f29396b;
        if (servingParam != null && servingParam.getGuideEntranceCallback() != null && this.f29396b.getOrderParams() != null) {
            this.f29396b.getGuideEntranceCallback().onNavigateToRealScene(this.f29396b.getOrderParams().stationWalkGuideLink);
        }
    }

    public void destroy() {
        this.f29396b = null;
    }
}
