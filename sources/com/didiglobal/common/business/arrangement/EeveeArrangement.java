package com.didiglobal.common.business.arrangement;

import com.didiglobal.common.business.arrangement.model.EeveeArrangementBizConfig;
import com.didiglobal.common.business.arrangement.model.EeveeArrangementComponentModel;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EeveeArrangement {

    /* renamed from: a */
    private static final Map<String, List<EeveeArrangementComponentModel>> f52303a = new HashMap();

    /* renamed from: b */
    private static EeveeArrangementBizConfig f52304b = new EeveeArrangementBizConfig();

    /* renamed from: c */
    private static Map<String, JsonObject> f52305c = new HashMap();

    public static Map<String, List<EeveeArrangementComponentModel>> getArrangementMap() {
        return f52303a;
    }

    public static void putModel(String str, List<EeveeArrangementComponentModel> list) {
        f52303a.put(str, list);
    }

    public static List<EeveeArrangementComponentModel> getModel(String str) {
        return f52303a.get(str);
    }

    public static void putAll(Map<String, List<EeveeArrangementComponentModel>> map) {
        f52303a.clear();
        f52303a.putAll(map);
    }

    public static EeveeArrangementBizConfig getBizConfig() {
        return f52304b;
    }

    public static void setConfig(EeveeArrangementBizConfig eeveeArrangementBizConfig) {
        f52304b = eeveeArrangementBizConfig;
    }
}
