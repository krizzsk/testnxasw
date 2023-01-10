package didihttpdns.p233db;

import android.content.Context;
import android.os.SystemClock;
import didihttpdns.cache.HttpDnsCache;
import didihttpdns.model.DnsRecord;
import didinet.Logger;
import didinet.NetEngine;
import didinet.OmegaAPI;
import java.util.HashMap;
import java.util.List;

/* renamed from: didihttpdns.db.UseOnceStrategy */
public class UseOnceStrategy implements DBCacheStrategy {
    public static final String TAG = "UseOnceStrategy";

    /* renamed from: a */
    Thread f59796a = new Thread() {
        public void run() {
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            List<DnsRecord> queryAllDnsInfo = UseOnceStrategy.this.f59798c.queryAllDnsInfo();
            if (queryAllDnsInfo != null && queryAllDnsInfo.size() > 0) {
                for (DnsRecord next : queryAllDnsInfo) {
                    Logger.m45047d(UseOnceStrategy.TAG, "- ->" + next.getHost());
                    next.setType(DBCacheType.USE_CACHE_ONCE.getValue());
                    UseOnceStrategy.this.f59799d.put(next.getHost(), next);
                }
                long currentThreadTimeMillis2 = SystemClock.currentThreadTimeMillis();
                StringBuilder sb = new StringBuilder();
                sb.append("query ");
                sb.append(queryAllDnsInfo.size());
                sb.append(" data waste ");
                long j = currentThreadTimeMillis2 - currentThreadTimeMillis;
                sb.append(j);
                sb.append("ms");
                Logger.m45047d(UseOnceStrategy.TAG, sb.toString());
                if (queryAllDnsInfo.size() >= 100) {
                    UseOnceStrategy.this.m45040a(String.valueOf(queryAllDnsInfo.size()), String.valueOf(j / 1000));
                }
            }
        }
    };

    /* renamed from: b */
    private Context f59797b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DnsDBHelper f59798c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public HttpDnsCache f59799d;

    public UseOnceStrategy(Context context, HttpDnsCache httpDnsCache) {
        this.f59797b = context;
        this.f59798c = DnsDBHelper.getInstance(context);
        this.f59799d = httpDnsCache;
    }

    public void readFromDb() {
        this.f59796a.start();
    }

    public void writeToDb(DnsRecord dnsRecord) {
        this.f59798c.insertOrUpdateDnsRecord(dnsRecord);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45040a(String str, String str2) {
        OmegaAPI omegaAPI = NetEngine.getInstance().getOmegaAPI();
        HashMap hashMap = new HashMap();
        hashMap.put("size", str);
        hashMap.put("waste_time", str2);
        omegaAPI.trackEvent("use_cache_stats", (String) null, hashMap);
    }
}
