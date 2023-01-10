package com.didi.map.sdk.departure.internal.special;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class SpecialPois implements Serializable {
    @SerializedName("base_area_info")
    public SAreaInfo area;
    @SerializedName("result")
    public List<SPoi> pois;
}
