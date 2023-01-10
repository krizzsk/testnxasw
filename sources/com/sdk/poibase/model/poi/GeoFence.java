package com.sdk.poibase.model.poi;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Arrays;

public class GeoFence implements Serializable {
    @SerializedName("id")

    /* renamed from: id */
    public String[] f58765id;

    public String toString() {
        return "GeoFence{id=" + Arrays.toString(this.f58765id) + '}';
    }
}
