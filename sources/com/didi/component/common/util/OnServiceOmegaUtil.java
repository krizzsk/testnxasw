package com.didi.component.common.util;

import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.MapUtils;
import com.didi.sdk.address.address.entity.Address;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import java.util.HashMap;
import java.util.Map;

public class OnServiceOmegaUtil {
    public static final int NOT_SUPPORT_WAY_POINT_SCENE_CLICK = 2;
    public static final int NOT_SUPPORT_WAY_POINT_SCENE_SHOW = 1;

    /* renamed from: a */
    private static final String f13611a = "gp_changeFromAddress_edit_ck";

    /* renamed from: b */
    private static final String f13612b = "gp_changeFromAddress_map_sw";

    /* renamed from: c */
    private static final String f13613c = "gp_changeFromAddress_map_ck";

    /* renamed from: d */
    private static final String f13614d = "gp_changeFromAddress_success_sw";

    /* renamed from: e */
    private static final String f13615e = "gp_changeFromAddress_err_sw";

    /* renamed from: f */
    private static final String f13616f = "gp_changeFromAddress_popup_sw";

    /* renamed from: g */
    private static final String f13617g = "gp_changeFromAddress_mapBtn_ck";

    /* renamed from: h */
    private static final String f13618h = "gp_editRoute_dNotSupport_sw";

    /* renamed from: i */
    private static final String f13619i = "sub_status";

    /* renamed from: j */
    private static final String f13620j = "order_id";

    /* renamed from: k */
    private static final String f13621k = "bf_lat";

    /* renamed from: l */
    private static final String f13622l = "bf_lng";

    /* renamed from: m */
    private static final String f13623m = "bf_address";

    /* renamed from: n */
    private static final String f13624n = "af_lat";

    /* renamed from: o */
    private static final String f13625o = "af_lng";

    /* renamed from: p */
    private static final String f13626p = "af_address";

    /* renamed from: q */
    private static final String f13627q = "distance";

    /* renamed from: r */
    private static final String f13628r = "err_no";

    /* renamed from: s */
    private static final String f13629s = "driver_id";

    /* renamed from: t */
    private static final String f13630t = "scene";

    /* renamed from: u */
    private static final String f13631u = "channel";

    /* renamed from: v */
    private static final String f13632v = "map";

    /* renamed from: w */
    private static final String f13633w = "pre-cancel";

    /* renamed from: x */
    private static String f13634x = "map";

    public static void sendClickEditOmega() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sub_status", Integer.valueOf(order.substatus));
            hashMap.put("order_id", order.oid);
            GlobalOmegaUtils.trackEvent(f13611a, (Map<String, Object>) hashMap);
        }
    }

    public static void sendClickUpdateButtonOmega() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sub_status", Integer.valueOf(order.substatus));
            hashMap.put("order_id", order.oid);
            hashMap.put("channel", f13634x);
            GlobalOmegaUtils.trackEvent(f13617g, (Map<String, Object>) hashMap);
        }
    }

    public static void sendShowUpdatePickUpPageOmega() {
        if (!"pick".equals(OmegaSDK.getGlobalAttr("g_PageId"))) {
            GlobalOmegaUtils.putGlobal("g_PageId", GPageIdConstant.G_PAGE_ID_PICONF);
        }
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sub_status", Integer.valueOf(order.substatus));
            hashMap.put("order_id", order.oid);
            GlobalOmegaUtils.trackEvent(f13612b, (Map<String, Object>) hashMap);
        }
    }

    public static void sendClickUpdatePickUpAddressOmega() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sub_status", Integer.valueOf(order.substatus));
            hashMap.put("order_id", order.oid);
            GlobalOmegaUtils.trackEvent(f13613c, (Map<String, Object>) hashMap);
        }
    }

    public static void sendUpdatePickUpSuccessOmega(Address address) {
        CarOrder order = CarOrderHelper.getOrder();
        GlobalOmegaUtils.putGlobal("g_PageId", "pick");
        if (order != null && order.startAddress != null && address != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sub_status", Integer.valueOf(order.substatus));
            hashMap.put("order_id", order.oid);
            hashMap.put(f13621k, Double.valueOf(order.startAddress.latitude));
            hashMap.put(f13622l, Double.valueOf(order.startAddress.longitude));
            hashMap.put(f13623m, order.startAddress.address);
            hashMap.put("af_lat", Double.valueOf(address.latitude));
            hashMap.put(f13625o, Double.valueOf(address.longitude));
            hashMap.put(f13626p, address.address);
            hashMap.put("distance", Double.valueOf(MapUtils.getDistance(address, order.startAddress)));
            hashMap.put("channel", f13634x);
            GlobalOmegaUtils.trackEvent(f13614d, (Map<String, Object>) hashMap);
        }
    }

    public static void sendUpdatePickUpFailOutOfAreaOmega(Address address) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && order.startAddress != null && address != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sub_status", Integer.valueOf(order.substatus));
            hashMap.put("order_id", order.oid);
            hashMap.put(f13621k, Double.valueOf(order.startAddress.latitude));
            hashMap.put(f13622l, Double.valueOf(order.startAddress.longitude));
            hashMap.put(f13623m, order.startAddress.address);
            hashMap.put("af_lat", Double.valueOf(address.latitude));
            hashMap.put(f13625o, Double.valueOf(address.longitude));
            hashMap.put(f13626p, address.address);
            hashMap.put("distance", Double.valueOf(MapUtils.getDistance(address, order.startAddress)));
            GlobalOmegaUtils.trackEvent(f13616f, (Map<String, Object>) hashMap);
        }
    }

    public static void sendUpdatePickUpFailOmega(int i, Address address) {
        CarOrder order = CarOrderHelper.getOrder();
        GlobalOmegaUtils.putGlobal("g_PageId", GPageIdConstant.G_PAGE_ID_PICONF);
        if (order != null && order.startAddress != null && address != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sub_status", Integer.valueOf(order.substatus));
            hashMap.put("order_id", order.oid);
            hashMap.put(f13621k, Double.valueOf(order.startAddress.latitude));
            hashMap.put(f13622l, Double.valueOf(order.startAddress.longitude));
            hashMap.put(f13623m, order.startAddress.address);
            hashMap.put("af_lat", Double.valueOf(address.latitude));
            hashMap.put(f13625o, Double.valueOf(address.longitude));
            hashMap.put(f13626p, address.address);
            hashMap.put("distance", Double.valueOf(MapUtils.getDistance(address, order.startAddress)));
            hashMap.put(f13628r, Integer.valueOf(i));
            hashMap.put("channel", f13634x);
            GlobalOmegaUtils.trackEvent(f13615e, (Map<String, Object>) hashMap);
        }
    }

    public static void sendNotSupportWayPointOmage(int i, CarOrder carOrder) {
        HashMap hashMap = new HashMap();
        hashMap.put("scene", Integer.valueOf(i));
        if (!(carOrder == null || carOrder.carDriver == null)) {
            hashMap.put("driver_id", carOrder.carDriver.did);
        }
        GlobalOmegaUtils.trackEvent(f13618h, (Map<String, Object>) hashMap);
    }

    public static void setOmegaParamUpdatePickUpChannelPreCancel() {
        f13634x = f13633w;
    }

    public static void setOmegaParamUpdatePickUpChannelMap() {
        f13634x = "map";
    }
}
