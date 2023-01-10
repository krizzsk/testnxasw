package com.didi.raven.net;

import android.content.Context;
import android.text.TextUtils;
import com.didi.raven.RavenDataManger;
import com.didi.raven.config.RavenConstants;
import com.didi.raven.utils.RavenUtils;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class RavenDidiHttpManger extends RavenNetManger {

    /* renamed from: a */
    private static final String f35871a = "RavenHttpManger";

    /* renamed from: b */
    private static final int f35872b = 1;

    /* renamed from: c */
    private RpcServiceFactory f35873c;

    /* renamed from: d */
    private final Map<String, RavenApiService> f35874d = new ConcurrentHashMap();

    private static class SingleTon {
        /* access modifiers changed from: private */
        public static final RavenDidiHttpManger INSTANCE = new RavenDidiHttpManger();

        private SingleTon() {
        }
    }

    public static RavenDidiHttpManger getInstance() {
        return SingleTon.INSTANCE;
    }

    /* renamed from: a */
    private RavenApiService m27042a(String str) {
        String baseUrl = !TextUtils.isEmpty(str) ? RavenDataManger.getInstance().getRavenData(str).getBaseUrl() : RavenConstants.DEFAULT_PATH;
        if (this.f35874d.get(baseUrl) == null) {
            this.f35874d.put(baseUrl, (RavenApiService) this.f35873c.newRpcService(RavenApiService.class, baseUrl));
        }
        return this.f35874d.get(baseUrl);
    }

    public void init(Context context) {
        if (this.f35873c == null) {
            this.f35873c = new RpcServiceFactory(context);
        }
    }

    public boolean isInit() {
        return this.f35873c != null;
    }

    public void post(String str, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str)) {
            m27042a(str).track(map, str, new RpcCallback((List<Map<String, Object>>) null));
        }
    }

    public void postPool(List<Map<String, Object>> list) {
        ArrayList arrayList = new ArrayList();
        for (Map<String, Object> hashMap : list) {
            arrayList.add(new HashMap(hashMap));
        }
        m27042a("").trackPoolData(arrayList, new RpcCallback(list));
    }

    public void postPool(String str) {
        List<Map<String, Object>> stringToList = RavenUtils.stringToList(str);
        ArrayList arrayList = new ArrayList();
        for (Map<String, Object> hashMap : stringToList) {
            arrayList.add(new HashMap(hashMap));
        }
        m27042a("").trackPoolData(arrayList, new RpcCallback2(str));
    }

    private static class RpcCallback implements RpcService.Callback<JSONObject> {
        private final List<Map<String, Object>> data;

        public RpcCallback(List<Map<String, Object>> list) {
            this.data = list;
        }

        public void onSuccess(JSONObject jSONObject) {
            try {
                RavenDataManger.getInstance().storeRavenId(jSONObject.getString("i"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public void onFailure(IOException iOException) {
            LoggerFactory.getLogger(RavenDidiHttpManger.f35871a).error("Raven post error", (Throwable) iOException);
            if (this.data != null) {
                RavenDataManger.getInstance().addParams(this.data);
            }
        }
    }

    private static class RpcCallback2 implements RpcService.Callback<JSONObject> {
        private final String data;

        public RpcCallback2(String str) {
            this.data = str;
        }

        public void onSuccess(JSONObject jSONObject) {
            try {
                RavenDataManger.getInstance().storeRavenId(jSONObject.getString("i"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public void onFailure(IOException iOException) {
            LoggerFactory.getLogger(RavenDidiHttpManger.f35871a).error("Raven post error", (Throwable) iOException);
            if (!TextUtils.isEmpty(this.data)) {
                RavenDataManger.getInstance().addParams(this.data);
            }
        }
    }
}
