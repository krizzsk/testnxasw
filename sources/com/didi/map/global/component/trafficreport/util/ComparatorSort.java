package com.didi.map.global.component.trafficreport.util;

import com.didi.map.global.component.trafficreport.model.ReportGroup;
import com.didi.map.global.component.trafficreport.model.ReportItem;
import java.util.Comparator;

public class ComparatorSort<T> implements Comparator<T> {
    public int compare(T t, T t2) {
        int intValue;
        int intValue2;
        if (!(t instanceof ReportGroup) || !(t2 instanceof ReportGroup)) {
            if (!(t instanceof ReportItem) || !(t2 instanceof ReportItem)) {
                return 0;
            }
            if (t == null && t2 == null) {
                return 0;
            }
            if (t == null) {
                return -1;
            }
            if (t2 == null) {
                return 1;
            }
            intValue = ((ReportItem) t).getItemIndex().intValue();
            intValue2 = ((ReportItem) t2).getItemIndex().intValue();
        } else if (t == null && t2 == null) {
            return 0;
        } else {
            if (t == null) {
                return -1;
            }
            if (t2 == null) {
                return 1;
            }
            intValue = ((ReportGroup) t).getCateCode();
            intValue2 = ((ReportGroup) t2).getCateCode();
        }
        return intValue - intValue2;
    }
}
