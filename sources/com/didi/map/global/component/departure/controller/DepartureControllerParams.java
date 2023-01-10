package com.didi.map.global.component.departure.controller;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.departure.fence.FenceController;
import com.didi.map.global.component.departure.model.DepartureAddress;

public class DepartureControllerParams {

    /* renamed from: a */
    private Context f27298a;

    /* renamed from: b */
    private Map f27299b;

    /* renamed from: c */
    private boolean f27300c;

    /* renamed from: d */
    private LatLng f27301d;

    /* renamed from: e */
    private FenceController f27302e;

    /* renamed from: f */
    private int f27303f;

    public DepartureControllerParams(Context context, Map map, int i, boolean z, LatLng latLng, DepartureAddress departureAddress, FenceController fenceController) {
        this.f27298a = context;
        this.f27299b = map;
        this.f27300c = z;
        this.f27301d = latLng;
        this.f27302e = fenceController;
        this.f27303f = i;
    }

    public Context getContext() {
        return this.f27298a;
    }

    public Map getMap() {
        return this.f27299b;
    }

    public boolean isHasWayPoint() {
        return this.f27300c;
    }

    public LatLng getEndPoint() {
        return this.f27301d;
    }

    public FenceController getFenceController() {
        return this.f27302e;
    }

    public int getSceneType() {
        return this.f27303f;
    }
}
