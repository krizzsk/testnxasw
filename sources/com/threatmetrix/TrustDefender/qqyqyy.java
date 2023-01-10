package com.threatmetrix.TrustDefender;

import android.net.ConnectivityManager;
import android.net.ProxyInfo;
import android.net.Uri;
import com.threatmetrix.TrustDefender.yyyyqy;

public class qqyqyy {
    private static final String bf00660066f00660066 = yyyyqy.b0074t007400740074t(qqyqyy.class);

    private qqyqyy() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r2 = (android.net.ConnectivityManager) r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b0071q0071007100710071(@javax.annotation.Nonnull android.content.Context r2) {
        /*
            java.lang.String r0 = "connectivity"
            java.lang.Object r2 = r2.getSystemService(r0)     // Catch:{ SecurityException -> 0x0029, Exception -> 0x001e }
            boolean r0 = r2 instanceof android.net.ConnectivityManager     // Catch:{ SecurityException -> 0x0029, Exception -> 0x001e }
            if (r0 == 0) goto L_0x0036
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2     // Catch:{ SecurityException -> 0x0029, Exception -> 0x001e }
            android.net.Network r0 = r2.getActiveNetwork()     // Catch:{ SecurityException -> 0x0029, Exception -> 0x001e }
            if (r0 == 0) goto L_0x0036
            android.net.NetworkCapabilities r2 = r2.getNetworkCapabilities(r0)     // Catch:{ SecurityException -> 0x0029, Exception -> 0x001e }
            if (r2 == 0) goto L_0x0036
            r0 = 4
            boolean r2 = r2.hasTransport(r0)     // Catch:{ SecurityException -> 0x0029, Exception -> 0x001e }
            return r2
        L_0x001e:
            r2 = move-exception
            java.lang.String r0 = bf00660066f00660066
            java.lang.String r2 = r2.toString()
            com.threatmetrix.TrustDefender.yyyyqy.bt0074007400740074t(r0, r2)
            goto L_0x0036
        L_0x0029:
            r2 = move-exception
            java.lang.String r0 = bf00660066f00660066
            java.lang.String r1 = r2.getMessage()
            com.threatmetrix.TrustDefender.yyyyqy.bt0074007400740074t(r0, r1)
            com.threatmetrix.TrustDefender.qqqtqt.byyyy0079y(r2)
        L_0x0036:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.qqyqyy.b0071q0071007100710071(android.content.Context):boolean");
    }

    public static String bqq0071007100710071(tqtqqt tqtqqt) {
        Object systemService = tqtqqt.bll006C006C006C006C.getSystemService("connectivity");
        if (!(systemService instanceof ConnectivityManager)) {
            yyyyqy.qyyyqy.b00740074tt0074t(bf00660066f00660066, "Service is not valid");
            return null;
        }
        ProxyInfo defaultProxy = ((ConnectivityManager) systemService).getDefaultProxy();
        if (defaultProxy == null) {
            return null;
        }
        String host = defaultProxy.getHost();
        int port = defaultProxy.getPort();
        if (!yqqyqq.b0069ii0069i0069(host) || port <= 0) {
            Uri pacFileUrl = defaultProxy.getPacFileUrl();
            if (pacFileUrl == null) {
                return null;
            }
            String uri = pacFileUrl.toString();
            String str = bf00660066f00660066;
            yyyyqy.qyyyqy.bt0074tttt(str, "proxy information " + uri);
            if (yqqyqq.b0069ii0069i0069(uri)) {
                return uri;
            }
            return null;
        }
        String str2 = bf00660066f00660066;
        yyyyqy.qyyyqy.bt0074tttt(str2, "proxy information " + host + ":" + port);
        return host + ":" + port;
    }
}
