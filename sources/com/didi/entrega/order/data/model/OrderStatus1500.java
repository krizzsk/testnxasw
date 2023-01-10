package com.didi.entrega.order.data.model;

import com.didi.common.map.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class OrderStatus1500 extends AbstractOrderStatus {
    public LatLng getTipLocation() {
        return null;
    }

    public boolean isMarkerInfoWindowTip() {
        return true;
    }

    public boolean isSupportSliding() {
        return true;
    }

    public List<LatLng> getBestViewLocation() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mReceiverLatLng);
        arrayList.add(this.mRiderLatLng);
        return arrayList;
    }
}
