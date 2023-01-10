package com.dmap.navigation.ctx;

import android.content.Context;
import com.dmap.navigation.base.ctx.INaviContext;
import com.dmap.navigation.engine.p207a.C18181n;

public class NaviContextFactory {
    private NaviContextFactory() {
    }

    public static INaviContext createNaviContext(Context context) {
        return new C18181n(context);
    }
}
