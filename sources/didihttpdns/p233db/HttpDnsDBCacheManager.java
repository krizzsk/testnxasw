package didihttpdns.p233db;

import didihttpdns.model.DnsRecord;

/* renamed from: didihttpdns.db.HttpDnsDBCacheManager */
public class HttpDnsDBCacheManager {

    /* renamed from: a */
    private DBCacheStrategy f59795a;

    public HttpDnsDBCacheManager(DBCacheStrategy dBCacheStrategy) {
        this.f59795a = dBCacheStrategy;
    }

    public void readFromDb() {
        DBCacheStrategy dBCacheStrategy = this.f59795a;
        if (dBCacheStrategy != null) {
            dBCacheStrategy.readFromDb();
        }
    }

    public void writeToDb(DnsRecord dnsRecord) {
        DBCacheStrategy dBCacheStrategy = this.f59795a;
        if (dBCacheStrategy != null) {
            dBCacheStrategy.writeToDb(dnsRecord);
        }
    }
}
