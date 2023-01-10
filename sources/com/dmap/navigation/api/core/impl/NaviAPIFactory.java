package com.dmap.navigation.api.core.impl;

import com.dmap.navigation.api.core.INormalNaviAPI;
import com.dmap.navigation.api.core.IOrderNaviAPI;
import com.dmap.navigation.base.ctx.INaviContext;
import com.dmap.navigation.engine.p207a.C18163b;
import com.dmap.navigation.engine.p207a.C18164c;

public final class NaviAPIFactory {
    private NaviAPIFactory() {
    }

    public static IOrderNaviAPI createOrderNaviAPI(INaviContext iNaviContext) {
        return new C18164c(iNaviContext);
    }

    public static INormalNaviAPI createNormalNaviAPI(INaviContext iNaviContext) {
        return new C18163b(iNaviContext);
    }
}
