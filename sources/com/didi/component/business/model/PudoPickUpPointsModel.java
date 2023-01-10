package com.didi.component.business.model;

import com.sdk.poibase.model.RpcPoi;
import java.util.ArrayList;

public class PudoPickUpPointsModel {

    /* renamed from: a */
    private ArrayList<RpcPoi> f13160a;

    public PudoPickUpPointsModel(ArrayList<RpcPoi> arrayList) {
        this.f13160a = arrayList;
    }

    public ArrayList<RpcPoi> getPickUpPoints() {
        return this.f13160a;
    }
}
