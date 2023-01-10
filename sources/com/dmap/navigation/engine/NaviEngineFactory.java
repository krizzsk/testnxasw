package com.dmap.navigation.engine;

import com.dmap.navigation.base.ctx.INaviContext;
import com.dmap.navigation.engine.core.INaviEngine;
import com.dmap.navigation.engine.core.INaviEngineVP;
import com.dmap.navigation.engine.p207a.C18182o;
import com.dmap.navigation.engine.p207a.C18185p;

public class NaviEngineFactory {
    public static INaviEngine createNaviEngine(INaviContext iNaviContext) {
        return new C18182o(iNaviContext);
    }

    public static INaviEngineVP createNaviEngineVP(INaviContext iNaviContext) {
        return new C18185p(iNaviContext);
    }
}
