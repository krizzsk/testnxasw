package com.didi.soda.customer.component.flutterordermap.data;

import com.didi.common.map.model.LatLng;
import com.didi.sdk.util.TextUtil;
import java.util.Objects;

public class OrderMapUtil {
    public static boolean checkRiderForBusinessPrepare(int i, int i2, int i3) {
        return i3 != 220 && i >= 2 && (i2 == 2 || i2 == 3 || i2 == 4);
    }

    public static boolean isOrderIdChange(OrderMapStatusModel orderMapStatusModel, OrderMapStatusModel orderMapStatusModel2) {
        if (orderMapStatusModel != null) {
            return !orderMapStatusModel.getOrderId().equals(orderMapStatusModel2.getOrderId());
        }
        return false;
    }

    public static boolean isOrderStatusChange(OrderMapStatusModel orderMapStatusModel, OrderMapStatusModel orderMapStatusModel2) {
        return orderMapStatusModel == null || orderMapStatusModel.getOrderStatus() != orderMapStatusModel2.getOrderStatus();
    }

    public static boolean hasNoOrderBubble(OrderMapStatusModel orderMapStatusModel) {
        if (orderMapStatusModel.mMapData == null || orderMapStatusModel.mMapData.getBubble() == null) {
            return true;
        }
        if ((!TextUtil.isEmpty(orderMapStatusModel.mMapData.getBubble().getDistanceRich()) || !TextUtil.isEmpty(orderMapStatusModel.mMapData.getBubble().getEtaRich())) && orderMapStatusModel.getOrderStatus() > 0 && orderMapStatusModel.getOrderStatus() < 600) {
            return false;
        }
        return true;
    }

    public static boolean isOrderBubbleContentChange(OrderMapStatusModel orderMapStatusModel, OrderMapStatusModel orderMapStatusModel2) {
        if (orderMapStatusModel == null || orderMapStatusModel.mMapData == null) {
            return true;
        }
        return !Objects.equals(orderMapStatusModel.mMapData.getBubble(), orderMapStatusModel2.mMapData.getBubble());
    }

    public static LatLng getLineCenter(LatLng latLng, LatLng latLng2) {
        return new LatLng((latLng.latitude + latLng2.latitude) / 2.0d, (latLng.longitude + latLng2.longitude) / 2.0d);
    }

    public static boolean needShowRiderForBusinessPrepare(OrderMapStatusModel orderMapStatusModel) {
        return orderMapStatusModel != null && checkRiderForBusinessPrepare(orderMapStatusModel.mCeta21AB, orderMapStatusModel.mShowDeliveryStatus, orderMapStatusModel.mBusinessMode);
    }

    public static boolean isDeliveryStatusChange(OrderMapStatusModel orderMapStatusModel, OrderMapStatusModel orderMapStatusModel2) {
        if (orderMapStatusModel == null) {
            return false;
        }
        if ((orderMapStatusModel.getOrderStatus() == 200 || orderMapStatusModel.getOrderStatus() == 300) && orderMapStatusModel.getOrderStatus() == orderMapStatusModel2.getOrderStatus() && orderMapStatusModel.mShowDeliveryStatus != orderMapStatusModel2.mShowDeliveryStatus) {
            return true;
        }
        return false;
    }
}
