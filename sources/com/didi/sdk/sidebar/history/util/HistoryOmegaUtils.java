package com.didi.sdk.sidebar.history.util;

import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.sidebar.history.HistoryRecordFragment;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public class HistoryOmegaUtils {

    /* renamed from: a */
    private static final String f40106a = "gp_myOrder_Business_sw";

    /* renamed from: b */
    private static final String f40107b = "gp_myOrder_getBusiness_err";

    /* renamed from: c */
    private static final String f40108c = "gp_myOrder_changeBusiness_ck";

    /* renamed from: d */
    private static final String f40109d = "business_id";

    /* renamed from: e */
    private static final String f40110e = "defaultTabOrder";

    /* renamed from: f */
    private static final String f40111f = "defaultTabList";

    /* renamed from: g */
    private static final String f40112g = "sense";

    /* renamed from: h */
    private static final String f40113h = "err_no";

    /* renamed from: i */
    private static final String f40114i = "url_type";

    /* renamed from: j */
    private static final String f40115j = "from_business_id";

    /* renamed from: k */
    private static final String f40116k = "to_business_id";

    /* renamed from: l */
    private static final String f40117l = "food";

    /* renamed from: m */
    private static final String f40118m = "ride";

    /* renamed from: n */
    private static final String f40119n = "bike";

    public static void sendTabShow(List<HistoryRecordFragment.HistoryListFragmentModel> list) {
        HashMap hashMap = new HashMap();
        hashMap.put("business_id", 0);
        hashMap.put(f40110e, 0);
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            for (HistoryRecordFragment.HistoryListFragmentModel historyListFragmentModel : list) {
                jSONArray.put(historyListFragmentModel.type);
            }
            hashMap.put(f40111f, jSONArray.toString());
        }
        hashMap.put(f40112g, 1);
        OmegaSDKAdapter.trackEvent(f40106a, (Map<String, Object>) hashMap);
        SystemUtils.log(6, "wangwei", "sendTabShow - 0 - " + jSONArray, (Throwable) null, "com.didi.sdk.sidebar.history.util.HistoryOmegaUtils", 53);
    }

    public static void sendTabClick(int i, int i2, List<HistoryRecordFragment.HistoryListFragmentModel> list) {
        HashMap hashMap = new HashMap();
        if (list != null && list.size() > i && list.size() > i2) {
            hashMap.put(f40115j, list.get(i).type);
            hashMap.put(f40116k, list.get(i2).type);
            hashMap.put("business_id", 0);
            JSONArray jSONArray = new JSONArray();
            for (HistoryRecordFragment.HistoryListFragmentModel historyListFragmentModel : list) {
                jSONArray.put(historyListFragmentModel.type);
            }
            hashMap.put(f40111f, jSONArray.toString());
            OmegaSDKAdapter.trackEvent(f40108c, (Map<String, Object>) hashMap);
            SystemUtils.log(6, "wangwei", "sendTabClick - " + i + " - " + i2 + " - " + jSONArray, (Throwable) null, "com.didi.sdk.sidebar.history.util.HistoryOmegaUtils", 68);
        }
    }

    public static void sendTabError(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(f40113h, Integer.valueOf(i));
        if ("soda".equals(str)) {
            hashMap.put(f40114i, "food");
        } else if ("ride".equals(str)) {
            hashMap.put(f40114i, "ride");
        } else if ("bike".equals(str)) {
            hashMap.put(f40114i, "bike");
        }
        hashMap.put(f40114i, str);
        OmegaSDKAdapter.trackEvent(f40107b, (Map<String, Object>) hashMap);
        SystemUtils.log(6, "wangwei", "sendTabError - " + i + " - " + str, (Throwable) null, "com.didi.sdk.sidebar.history.util.HistoryOmegaUtils", 84);
    }
}
