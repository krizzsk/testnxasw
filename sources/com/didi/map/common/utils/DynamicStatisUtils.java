package com.didi.map.common.utils;

import android.text.TextUtils;
import com.didi.map.MapOmegaUtil;
import com.didi.map.constant.OmegaEventConstant;
import java.util.HashMap;
import java.util.Map;

public class DynamicStatisUtils {
    public static final int DYNAMIC_STATUS_CLOSE = 0;
    public static final int DYNAMIC_STATUS_WAITING_CHOOSE = 1;

    /* renamed from: a */
    static final String f26922a = "map_switchroute_screenaction_ck";

    /* renamed from: b */
    static final String f26923b = "ab_test_id";

    /* renamed from: c */
    static final String f26924c = "action_id";

    /* renamed from: d */
    static final String f26925d = "action_count";

    /* renamed from: e */
    static final String f26926e = "pinch";

    /* renamed from: f */
    static final String f26927f = "expand";

    /* renamed from: g */
    static final String f26928g = "move";

    /* renamed from: h */
    static String f26929h;

    /* renamed from: i */
    static Map<String, Object> f26930i = new HashMap();

    /* renamed from: j */
    static Map<String, Object> f26931j = new HashMap();

    /* renamed from: k */
    static Map<String, Object> f26932k = new HashMap();

    /* renamed from: l */
    private static int f26933l;

    private DynamicStatisUtils() {
    }

    public static void setDynamicStatus(int i) {
        f26933l = i;
    }

    public static int getDynamicStatus() {
        return f26933l;
    }

    public static void setCurrentEvent(String str) {
        f26929h = str;
    }

    public static void resetCurrentEvent() {
        f26929h = null;
    }

    public static void addEvent(String str) {
        if (str.equals(OmegaEventConstant.HAWAII_MAP_FLING)) {
            addFlingEvent();
        } else if (str.equals(OmegaEventConstant.HAWAII_MAP_ZOOMIN_TWO_FINGER)) {
            addZoominEvent();
        } else if (str.equals(OmegaEventConstant.HAWAII_MAP_ZOOMOUT_TWO_FINGER)) {
            addZoomoutEvent();
        }
    }

    public static void addFlingEvent() {
        if (f26932k == null) {
            f26932k = new HashMap();
        }
        if (!f26932k.containsKey("action_id")) {
            f26932k.put("action_id", f26928g);
        }
        if (f26932k.containsKey("action_count")) {
            Map<String, Object> map = f26932k;
            map.put("action_count", Integer.valueOf(Integer.parseInt(String.valueOf(map.get("action_count"))) + 1));
            return;
        }
        f26932k.put("action_count", "1");
    }

    public static void addZoominEvent() {
        if (f26930i == null) {
            f26930i = new HashMap();
        }
        if (!f26930i.containsKey("action_id")) {
            f26930i.put("action_id", f26926e);
        }
        if (f26930i.containsKey("action_count")) {
            Map<String, Object> map = f26930i;
            map.put("action_count", Integer.valueOf(Integer.parseInt(String.valueOf(map.get("action_count"))) + 1));
            return;
        }
        f26930i.put("action_count", "1");
    }

    public static void addZoomoutEvent() {
        if (f26931j == null) {
            f26931j = new HashMap();
        }
        if (!f26931j.containsKey("action_id")) {
            f26931j.put("action_id", f26927f);
        }
        if (f26931j.containsKey("action_count")) {
            Map<String, Object> map = f26931j;
            map.put("action_count", Integer.valueOf(Integer.parseInt(String.valueOf(map.get("action_count"))) + 1));
            return;
        }
        f26931j.put("action_count", "1");
    }

    public static void addCurrentEvent() {
        if (!TextUtils.isEmpty(f26929h)) {
            addEvent(f26929h);
        }
    }

    public static void trackDynamicEvent(String str) {
        if (f26933l == 1) {
            f26933l = 0;
            Map<String, Object> map = f26932k;
            if (map != null && map.size() > 0) {
                f26932k.put(f26923b, str);
                MapOmegaUtil.trackEvent(f26922a, f26932k);
                f26932k.clear();
            }
            Map<String, Object> map2 = f26930i;
            if (map2 != null && map2.size() > 0) {
                f26930i.put(f26923b, str);
                MapOmegaUtil.trackEvent(f26922a, f26930i);
                f26930i.clear();
            }
            Map<String, Object> map3 = f26931j;
            if (map3 != null && map3.size() > 0) {
                f26931j.put(f26923b, str);
                MapOmegaUtil.trackEvent(f26922a, f26931j);
                f26931j.clear();
            }
        }
    }
}
