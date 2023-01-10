package com.didi.sdk.misconfig.store;

import com.didi.sdk.misconfig.model.CarGrop;
import com.didi.sdk.store.FetchCallback;
import java.util.List;

public class MisRequestParams {

    /* renamed from: a */
    int f39617a;
    public FetchCallback<List<CarGrop>> callback;
    public int cityId = -1;
    public double lat;
    public double lng;
    public String mapType;

    public String toString() {
        return "MisRequestParams{seqId=" + this.f39617a + ", lat=" + this.lat + ", lng=" + this.lng + ", cityId=" + this.cityId + ", mapType='" + this.mapType + '\'' + ", callback=" + this.callback + '}';
    }
}
