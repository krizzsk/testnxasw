package com.didi.map.global.component.line.component.traffic;

import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import java.util.Collection;
import java.util.List;

public class TrafficUtils {

    /* renamed from: a */
    private static final String f28059a = "TrafficUtils";

    public static boolean isSameTrafficData(List<TrafficData> list, List<TrafficData> list2) {
        if (list == null && list2 == null) {
            DLog.m10773d(f28059a, "data is null", new Object[0]);
            return true;
        } else if (CollectionUtil.isEmpty((Collection<?>) list2) || CollectionUtil.isEmpty((Collection<?>) list) || list2.size() != list.size()) {
            return false;
        } else {
            int i = 0;
            while (i < list.size()) {
                TrafficData trafficData = list.get(i);
                TrafficData trafficData2 = list2.get(i);
                if (trafficData == null || trafficData2 == null || trafficData.isSameData(trafficData2)) {
                    i++;
                } else {
                    DLog.m10773d(f28059a, "color, fromIndex or toIndex inconsistent", new Object[0]);
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean checkDataValid(List<TrafficData> list, int i) {
        boolean z;
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            TrafficData trafficData = list.get(i2);
            int i3 = i2 + 1;
            TrafficData trafficData2 = i3 < size ? list.get(i3) : null;
            if (trafficData != null && trafficData.color == -1) {
                DLog.m10773d(f28059a, "current item color is null", new Object[0]);
                return false;
            } else if (trafficData2 == null || trafficData2.color != -1) {
                if (trafficData2 == null) {
                    if (i2 == 0) {
                        z = m22079a(trafficData, (TrafficData) null, true, i);
                    } else {
                        z = m22079a(trafficData, (TrafficData) null, false, i);
                    }
                } else if (i2 == 0) {
                    z = m22079a(trafficData, trafficData2, true, i);
                } else {
                    z = m22079a(trafficData, trafficData2, false, i);
                }
                if (!z) {
                    return false;
                }
                i2 = i3;
            } else {
                DLog.m10773d(f28059a, "next item color is null", new Object[0]);
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m22079a(TrafficData trafficData, TrafficData trafficData2, boolean z, int i) {
        if (trafficData == null || trafficData.fromIndex >= trafficData.toIndex || trafficData.toIndex >= i) {
            return false;
        }
        if (trafficData2 == null) {
            if (z) {
                if (!(trafficData.fromIndex == 0 && trafficData.toIndex == i - 1)) {
                    DLog.m10773d(f28059a, "first item, fromIndex is not 0, or toIndex out of bound. fromIndex: " + trafficData.fromIndex + ", toIndex: " + trafficData.toIndex, new Object[0]);
                    return false;
                }
            } else if (trafficData.fromIndex <= 0 || trafficData.toIndex != i - 1) {
                DLog.m10773d(f28059a, "not first item, fromIndex is <= 0, or toIndex out of bound. fromIndex: " + trafficData.fromIndex + ", toIndex: " + trafficData.toIndex, new Object[0]);
                return false;
            }
        } else if (z) {
            if (!(trafficData.fromIndex == 0 && trafficData.toIndex == trafficData2.fromIndex && trafficData2.toIndex < i)) {
                DLog.m10773d(f28059a, "first item, fromIndex is not 0 or next item toIndex out of bound or current item toIndex != next.fromIndex, current item fromIndex:" + trafficData.fromIndex + ", current item toIndex:" + trafficData.toIndex + ", next item fromIndex:" + trafficData2.fromIndex + ", next item toIndex:" + trafficData2.toIndex, new Object[0]);
                return false;
            }
        } else if (trafficData.fromIndex <= 0 || trafficData.toIndex != trafficData2.fromIndex || trafficData2.toIndex >= i) {
            DLog.m10773d(f28059a, "not first item, fromIndex is <=0 or toIndex out of bound or current item toIndex != next.fromIndex, current item fromIndex:" + trafficData.fromIndex + ", current item toIndex:" + trafficData.toIndex + ", next item fromIndex:" + trafficData2.fromIndex + ", next item toIndex:" + trafficData2.toIndex, new Object[0]);
            return false;
        }
        return true;
    }
}
