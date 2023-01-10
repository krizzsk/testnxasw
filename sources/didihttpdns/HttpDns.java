package didihttpdns;

import android.text.TextUtils;
import didihttp.Dns;
import didihttpdns.model.DnsRecord;
import didihttpdns.model.IpRecord;
import didinet.Logger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HttpDns implements Dns {

    /* renamed from: a */
    private static HttpDns f59753a;

    private HttpDns() {
    }

    public static HttpDns getInstance() {
        if (f59753a == null) {
            synchronized (HttpDns.class) {
                f59753a = new HttpDns();
            }
        }
        return f59753a;
    }

    public List<InetAddress> lookup(String str) throws UnknownHostException {
        DnsRecord fullLookup = HttpDnsManager.getInstance().fullLookup(str);
        if (fullLookup != null) {
            ArrayList arrayList = new ArrayList();
            for (IpRecord ip : fullLookup.getIps()) {
                String ip2 = ip.getIp();
                if (!TextUtils.isEmpty(ip2)) {
                    arrayList.add(InetAddress.getByName(ip2));
                }
            }
            if (arrayList.size() > 0) {
                Logger.m45047d("HttpDnsManager", "[use] httpdns for " + str + " success");
                return arrayList;
            }
            Logger.m45047d("HttpDnsManager", "[use] httpdns for " + str + " failed: ip list is empty!");
            return Arrays.asList(InetAddress.getAllByName(str));
        }
        Logger.m45047d("HttpDnsManager", "[use] httpdns for " + str + " failed: dnsRecord is null");
        return Arrays.asList(InetAddress.getAllByName(str));
    }
}
