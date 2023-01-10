package com.threatmetrix.TrustDefender;

import com.facebook.imagepipeline.memory.BitmapPoolType;
import com.threatmetrix.TrustDefender.yyyyqy;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class yqyqqy {
    public static final int b006500650065eee = -99;
    public static final int b00650065eeee = 2;
    public static final int b0065e0065eee = 4;
    public static final int b0065eeeee = 0;
    public static final int be00650065eee = 5;
    public static final int be0065eeee = 1;
    public static final int bee0065eee = 3;
    private static final String beee0065ee = yyyyqy.b0074t007400740074t(yqyqqy.class);
    @Nullable
    private String b0065006500650065ee = null;
    @Nullable
    private String b00650065e0065ee = null;
    @Nullable
    private String b0065e00650065ee = null;
    @Nullable
    private String b0065ee0065ee = null;
    @Nullable
    private String b0065eee0065e = null;
    @Nullable
    private String be006500650065ee = null;
    @Nullable
    private String be0065e0065ee = null;
    @Nullable
    private String bee00650065ee = null;
    @Nullable
    private String beeee0065e = null;

    public static class qqyqqy {
        @Nullable
        public final String b00650065ee0065e;
        @Nonnull
        public final String be0065ee0065e;
        @Nonnull
        public final InetAddress[] bee0065e0065e;

        public qqyqqy(@Nonnull String str, @Nullable String str2, @Nonnull InetAddress[] inetAddressArr) {
            this.be0065ee0065e = str;
            this.b00650065ee0065e = str2;
            this.bee0065e0065e = inetAddressArr;
        }
    }

    public enum yyqqqy {
        BLUETOOTH("bluetooth tethering"),
        CELLULAR("cellular"),
        MOBILE("mobile"),
        WIFI("wifi"),
        ETHERNET("ethernet"),
        VPN("vpn"),
        MOBILE_DUN("mobile_dun");
        
        public final String b0065e0065e0065e;

        private yyqqqy(String str) {
            this.b0065e0065e0065e = str;
        }

        public String getValue() {
            return this.b0065e0065e0065e;
        }
    }

    public yqyqqy() {
        TreeMap treeMap = new TreeMap();
        TreeMap treeMap2 = new TreeMap();
        TreeMap treeMap3 = new TreeMap();
        qqyqqy[] bgggg0067g = qqqyqy.bgggg0067g();
        if (bgggg0067g == null || bgggg0067g.length <= 0) {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                if (networkInterfaces != null) {
                    while (networkInterfaces.hasMoreElements()) {
                        NetworkInterface nextElement = networkInterfaces.nextElement();
                        String name = nextElement.getName();
                        if (nextElement.getHardwareAddress() != null) {
                            String bii006900690069i = yqqyqq.bii006900690069i(nextElement.getHardwareAddress());
                            if (yqqyqq.biii0069i0069(bii006900690069i)) {
                                treeMap3.put(bii006900690069i, name);
                            }
                        }
                        if (!name.startsWith(BitmapPoolType.DUMMY)) {
                            bgg0067g00670067(nextElement.getInetAddresses(), name, treeMap, treeMap2);
                        }
                    }
                }
            } catch (SocketException e) {
                yyyyqy.qyyyqy.b007400740074ttt(beee0065ee, "Declared exception: Can't get IP Addresses due to SocketException :{} ", e.toString());
            } catch (Throwable th) {
                yyyyqy.qyyyqy.bt00740074ttt(beee0065ee, "Unexpected exception happened " + th.toString());
            }
        } else {
            for (qqyqqy qqyqqy2 : bgggg0067g) {
                if (yqqyqq.biii0069i0069(qqyqqy2.b00650065ee0065e)) {
                    treeMap3.put(qqyqqy2.b00650065ee0065e, qqyqqy2.be0065ee0065e);
                }
                if (!qqyqqy2.be0065ee0065e.startsWith(BitmapPoolType.DUMMY)) {
                    b0067g0067g00670067(qqyqqy2.bee0065e0065e, qqyqqy2.be0065ee0065e, treeMap, treeMap2);
                }
            }
        }
        this.b0065e00650065ee = yqqyqq.b0069i006900690069i(treeMap);
        this.be006500650065ee = yqqyqq.b00690069006900690069i(treeMap2, false, -1);
        this.b0065006500650065ee = yqqyqq.b0069i006900690069i(treeMap3);
    }

    private void b00670067gg00670067(InetAddress inetAddress, String str, Map<String, Object> map, Map<String, Object> map2) {
        if (inetAddress.isLoopbackAddress()) {
            return;
        }
        if (inetAddress instanceof Inet4Address) {
            map.put(inetAddress.getHostAddress(), str);
        } else if (inetAddress instanceof Inet6Address) {
            String hostAddress = inetAddress.getHostAddress();
            int indexOf = hostAddress.indexOf("%");
            if (indexOf > 0) {
                hostAddress = hostAddress.substring(0, indexOf);
            }
            map2.put(hostAddress, str);
        }
    }

    private void b0067g0067g00670067(InetAddress[] inetAddressArr, String str, Map<String, Object> map, Map<String, Object> map2) {
        if (inetAddressArr != null && inetAddressArr.length != 0) {
            for (InetAddress b00670067gg00670067 : inetAddressArr) {
                b00670067gg00670067(b00670067gg00670067, str, map, map2);
            }
        }
    }

    private void bgg0067g00670067(Enumeration<InetAddress> enumeration, String str, Map<String, Object> map, Map<String, Object> map2) {
        if (enumeration != null) {
            while (enumeration.hasMoreElements()) {
                b00670067gg00670067(enumeration.nextElement(), str, map, map2);
            }
        }
    }

    @Nullable
    public String b006700670067g00670067() {
        return this.b0065e00650065ee;
    }

    @Nullable
    public String b00670067g006700670067() {
        return this.beeee0065e;
    }

    @Nullable
    public String b0067g0067006700670067() {
        return this.b00650065e0065ee;
    }

    @Nullable
    public String b0067gg006700670067() {
        return this.b0065006500650065ee;
    }

    public void b00780078xxxx(String str) {
        this.b00650065e0065ee = str;
    }

    public void b0078x0078xxx(String str) {
        this.b0065eee0065e = str;
    }

    public void b0078xxxxx() {
        this.be0065e0065ee = null;
        this.b0065ee0065ee = null;
        this.bee00650065ee = null;
    }

    @Nullable
    public String bg00670067006700670067() {
        return this.b0065eee0065e;
    }

    @Nullable
    public String bg00670067g00670067() {
        return this.be0065e0065ee;
    }

    @Nullable
    public String bg0067g006700670067() {
        return this.bee00650065ee;
    }

    @Nullable
    public String bgg0067006700670067() {
        return this.b0065ee0065ee;
    }

    @Nullable
    public String bggg006700670067() {
        return this.be006500650065ee;
    }

    public void bx0078xxxx(String str) {
        this.beeee0065e = str;
    }

    public boolean bxx0078xxx(@Nullable String[] strArr) {
        if (strArr != null && strArr.length >= 5) {
            if (this.be0065e0065ee == null && strArr[0] != null) {
                this.be0065e0065ee = qyqqqy.b0078x00780078xx(strArr[0]);
            }
            if (this.b0065ee0065ee == null && strArr[1] != null) {
                this.b0065ee0065ee = qyqqqy.bx007800780078xx(strArr[1]);
            }
            if (this.bee00650065ee == null && strArr[2] != null) {
                this.bee00650065ee = strArr[2];
            }
            if (this.b00650065e0065ee == null && strArr[3] != null) {
                this.b00650065e0065ee = strArr[3];
            }
            if (this.b0065eee0065e == null && strArr[4] != null) {
                this.b0065eee0065e = strArr[4];
            }
        }
        return (this.be0065e0065ee == null || this.b0065ee0065ee == null || this.bee00650065ee == null || this.b00650065e0065ee == null) ? false : true;
    }
}
