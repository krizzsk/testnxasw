package com.didi.raven;

import android.text.TextUtils;
import com.didi.raven.cache.RavenCache;
import com.didi.raven.cache.RavenData;
import com.didi.raven.cache.RavenRequestPool;
import com.didi.raven.config.RavenConstants;
import com.didi.raven.manger.RavenThreadExecutorManger;
import com.didi.raven.model.RavenPoolConfigModel;
import com.didi.raven.utils.RavenLogUtils;
import com.didi.raven.utils.RavenUtils;
import com.tencent.mmkv.MMKV;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

public class RavenDataManger {

    /* renamed from: a */
    private MMKV f35845a;

    /* renamed from: b */
    private final Map<String, RavenData> f35846b = new ConcurrentHashMap();

    /* renamed from: c */
    private RavenPoolConfigModel f35847c = new RavenPoolConfigModel();

    /* renamed from: d */
    private RavenRequestPool f35848d;

    private static class SingleTon {
        /* access modifiers changed from: private */
        public static final RavenDataManger INSTANCE = new RavenDataManger();

        private SingleTon() {
        }
    }

    public static RavenDataManger getInstance() {
        return SingleTon.INSTANCE;
    }

    public void init() {
        this.f35848d = new RavenRequestPool();
        m27004a();
        RavenCache.RAVEN_ID = this.f35848d.loadRavenId();
    }

    /* renamed from: a */
    private void m27004a() {
        this.f35845a = MMKV.mmkvWithID(RavenConstants.MMKV_ID, 1, RavenConstants.CRYPT_KEY);
    }

    public RavenPoolConfigModel getPoolConfig() {
        return this.f35847c;
    }

    public MMKV getMmkv() {
        return this.f35845a;
    }

    public RavenData getRavenData(String str) {
        RavenData ravenData = this.f35846b.get(str);
        if (ravenData != null) {
            return ravenData;
        }
        RavenData ravenData2 = new RavenData();
        this.f35846b.put(str, ravenData2);
        return ravenData2;
    }

    public synchronized void addParams(Map<String, Object> map) {
        String str = (String) map.get("aid");
        if (!TextUtils.isEmpty(str)) {
            map.put("si", Integer.valueOf(getInstance().getRavenData(str).getIndex()));
            m27011d().execute(new Runnable(map) {
                public final /* synthetic */ Map f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    RavenDataManger.this.m27007a(this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27007a(Map map) {
        this.f35848d.addParams(map);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27006a(List list) {
        this.f35848d.addInError(list);
    }

    public void addParams(List<Map<String, Object>> list) {
        m27011d().execute(new Runnable(list) {
            public final /* synthetic */ List f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                RavenDataManger.this.m27006a(this.f$1);
            }
        });
    }

    public void addParams(String str) {
        m27011d().execute(new Runnable(str) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                RavenDataManger.this.m27009b(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m27009b(String str) {
        List<Map<String, Object>> stringToList = RavenUtils.stringToList(str);
        if (stringToList != null && stringToList.size() > 0) {
            this.f35848d.addInError(stringToList);
        }
    }

    public List<Map<String, Object>> getParams() {
        return this.f35848d.getData();
    }

    public synchronized void clearPool() {
        this.f35848d.clear();
    }

    /* renamed from: a */
    private synchronized void m27005a(String str) {
        this.f35848d.clearError(str);
    }

    public int getPoolSize() {
        return this.f35848d.getSize();
    }

    public void uploadLastData() {
        try {
            m27008b();
            m27010c();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m27008b() {
        try {
            String dataWithMMKV = this.f35848d.getDataWithMMKV();
            RavenLogUtils.m27059i(RavenConstants.TAG, "uploadDataWithMMKV data:" + dataWithMMKV);
            if (!TextUtils.isEmpty(dataWithMMKV)) {
                RavenHttpManger.getInstance().trackPool(dataWithMMKV);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m27010c() {
        for (String next : this.f35848d.getMmkvKeys()) {
            RavenLogUtils.m27059i(RavenConstants.TAG, "error_key:" + next);
            String loadData = this.f35848d.loadData(next);
            if (!TextUtils.isEmpty(loadData)) {
                RavenHttpManger.getInstance().trackPool(loadData);
            }
            this.f35848d.removeKey(next);
        }
        this.f35848d.clearAll();
    }

    /* renamed from: d */
    private ExecutorService m27011d() {
        return RavenThreadExecutorManger.getInstance().getEventExecutor();
    }

    public void storeRavenId(String str) {
        this.f35848d.storeData("bid", str);
        RavenCache.RAVEN_ID = str;
    }

    public String loadRavenId() {
        return this.f35848d.loadData("bid");
    }
}
