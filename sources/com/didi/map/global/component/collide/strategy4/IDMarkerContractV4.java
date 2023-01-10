package com.didi.map.global.component.collide.strategy4;

import android.graphics.Rect;
import com.didi.common.map.Map;
import java.util.List;

public interface IDMarkerContractV4 {

    /* renamed from: com.didi.map.global.component.collide.strategy4.IDMarkerContractV4$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static List $default$getDisabledRect(IDMarkerContractV4 iDMarkerContractV4, String str) {
            return null;
        }

        public static int $default$getHot(IDMarkerContractV4 iDMarkerContractV4, String str) {
            return 0;
        }

        public static boolean $default$isCanWork(IDMarkerContractV4 iDMarkerContractV4) {
            return false;
        }

        public static boolean $default$isLabelDirectClockwise(IDMarkerContractV4 iDMarkerContractV4) {
            return false;
        }
    }

    int getCurrentLabelPosition(String str);

    List<Rect> getDisabledRect(String str);

    int getEnableLabelPosition(String str);

    int getHot(String str);

    Map getMap();

    boolean isCanWork();

    boolean isLabelDirectClockwise();

    void setLabelDirect(String str, int i);
}
