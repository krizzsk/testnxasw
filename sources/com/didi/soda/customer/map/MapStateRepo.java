package com.didi.soda.customer.map;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;

public class MapStateRepo extends Repo<MapStateModel> {

    /* renamed from: a */
    private static final String f43964a = "MapStateRepo";

    public boolean mapReady() {
        return GlobalContext.mapViewReady();
    }

    public void mapInitComplete() {
        LogUtil.m32588i(f43964a, "mapInitComplete");
        MapStateModel mapStateModel = new MapStateModel();
        mapStateModel.mapReady = true;
        setValue(mapStateModel);
    }

    public void mapDestroyComplete() {
        LogUtil.m32588i(f43964a, "mapDestroyComplete");
        MapStateModel mapStateModel = new MapStateModel();
        mapStateModel.mapReady = false;
        setValue(mapStateModel);
    }
}
