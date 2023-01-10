package didihttpdns.p233db;

import android.content.Context;
import android.os.SystemClock;
import com.didi.sdk.apm.SystemUtils;
import didihttpdns.cache.HttpDnsCache;
import didihttpdns.model.DnsRecord;
import didinet.Logger;
import java.util.List;

/* renamed from: didihttpdns.db.UseOneTTLStrategy */
public class UseOneTTLStrategy implements DBCacheStrategy {
    public static final String TAG = "UseOneTTLStrategy";

    /* renamed from: a */
    Thread f59800a = new Thread() {
        public void run() {
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            List<DnsRecord> queryAllDnsInfo = UseOneTTLStrategy.this.f59802c.queryAllDnsInfo();
            if (queryAllDnsInfo != null && queryAllDnsInfo.size() > 0) {
                for (DnsRecord next : queryAllDnsInfo) {
                    Logger.m45047d(UseOneTTLStrategy.TAG, "-->" + next.getHost());
                    next.setT(Math.min(next.getT(), 60));
                    next.setType(DBCacheType.USE_CACHE_ONE_TTL.getValue());
                    UseOneTTLStrategy.this.f59803d.put(next.getHost(), next);
                }
                long currentThreadTimeMillis2 = SystemClock.currentThreadTimeMillis();
                Logger.m45047d(UseOneTTLStrategy.TAG, "query " + queryAllDnsInfo.size() + " data waste " + (currentThreadTimeMillis2 - currentThreadTimeMillis) + "ms");
            }
        }
    };

    /* renamed from: b */
    private Context f59801b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DnsDBHelper f59802c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public HttpDnsCache f59803d;

    public UseOneTTLStrategy(Context context, HttpDnsCache httpDnsCache) {
        this.f59801b = context;
        this.f59802c = DnsDBHelper.getInstance(context);
        this.f59803d = httpDnsCache;
    }

    public void readFromDb() {
        SystemUtils.startThread(this.f59800a);
    }

    public void writeToDb(DnsRecord dnsRecord) {
        this.f59802c.insertOrUpdateDnsRecord(dnsRecord);
    }
}
