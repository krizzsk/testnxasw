package com.didi.map.sdk.departure.internal.special;

import com.google.gson.annotations.SerializedName;
import com.sdk.poibase.model.RpcPoi;
import java.io.Serializable;
import java.util.List;

public class SPoi implements Serializable {
    @SerializedName("area_info")
    public SAreaInfo area;
    @SerializedName("pick_points")
    public List<RpcPoi> list;
}
