package com.didi.entrega.customer.map;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;

public class MapStateRepo extends Repo<MapStateModel> {

    /* renamed from: a */
    private static final String f22037a = "MapStateRepo";

    public boolean mapReady() {
        return GlobalContext.mapViewReady();
    }

    public void mapInitComplete() {
        LogUtil.m18185i(f22037a, "mapInitComplete");
        MapStateModel mapStateModel = new MapStateModel();
        mapStateModel.mapReady = true;
        setValue(mapStateModel);
    }

    public void mapDestroyComplete() {
        LogUtil.m18185i(f22037a, "mapDestroyComplete");
        MapStateModel mapStateModel = new MapStateModel();
        mapStateModel.mapReady = false;
        setValue(mapStateModel);
    }
}
