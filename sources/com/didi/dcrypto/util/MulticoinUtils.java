package com.didi.dcrypto.util;

public class MulticoinUtils {
    public static final String MULTICOIN_NAME_BTC = "Bitcoin";
    public static final String MULTICOIN_NAME_ETH = "Ethereum";
    public static final String MULTICOIN_NAME_MANA = "Mana";
    public static final String MULTICOIN_NAME_SOLANA = "Solana";
    public static final String MULTICOIN_NAME_USDC = "USD coin";

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getMulticoinName(java.lang.String r5) {
        /*
            int r0 = r5.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case 66097: goto L_0x0034;
                case 68985: goto L_0x002a;
                case 82288: goto L_0x0020;
                case 2358855: goto L_0x0016;
                case 2614173: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x003e
        L_0x000c:
            java.lang.String r0 = "USDC"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003e
            r5 = 2
            goto L_0x003f
        L_0x0016:
            java.lang.String r0 = "MANA"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003e
            r5 = 4
            goto L_0x003f
        L_0x0020:
            java.lang.String r0 = "SOL"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003e
            r5 = 3
            goto L_0x003f
        L_0x002a:
            java.lang.String r0 = "ETH"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003e
            r5 = 1
            goto L_0x003f
        L_0x0034:
            java.lang.String r0 = "BTC"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003e
            r5 = 0
            goto L_0x003f
        L_0x003e:
            r5 = -1
        L_0x003f:
            if (r5 == r4) goto L_0x0053
            if (r5 == r3) goto L_0x0050
            if (r5 == r2) goto L_0x004d
            if (r5 == r1) goto L_0x004a
            java.lang.String r5 = "Bitcoin"
            return r5
        L_0x004a:
            java.lang.String r5 = "Mana"
            return r5
        L_0x004d:
            java.lang.String r5 = "Solana"
            return r5
        L_0x0050:
            java.lang.String r5 = "USD coin"
            return r5
        L_0x0053:
            java.lang.String r5 = "Ethereum"
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dcrypto.util.MulticoinUtils.getMulticoinName(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getMulticoinDialogTitle(android.content.Context r5, java.lang.String r6) {
        /*
            int r0 = r6.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case 66097: goto L_0x0034;
                case 68985: goto L_0x002a;
                case 82288: goto L_0x0020;
                case 2358855: goto L_0x0016;
                case 2614173: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x003e
        L_0x000c:
            java.lang.String r0 = "USDC"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003e
            r6 = 2
            goto L_0x003f
        L_0x0016:
            java.lang.String r0 = "MANA"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003e
            r6 = 4
            goto L_0x003f
        L_0x0020:
            java.lang.String r0 = "SOL"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003e
            r6 = 3
            goto L_0x003f
        L_0x002a:
            java.lang.String r0 = "ETH"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003e
            r6 = 1
            goto L_0x003f
        L_0x0034:
            java.lang.String r0 = "BTC"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003e
            r6 = 0
            goto L_0x003f
        L_0x003e:
            r6 = -1
        L_0x003f:
            r0 = 2131956527(0x7f13132f, float:1.9549612E38)
            if (r6 == 0) goto L_0x0071
            if (r6 == r4) goto L_0x0069
            if (r6 == r3) goto L_0x0061
            if (r6 == r2) goto L_0x0059
            if (r6 == r1) goto L_0x0051
            java.lang.String r5 = r5.getString(r0)
            return r5
        L_0x0051:
            r6 = 2131956529(0x7f131331, float:1.9549616E38)
            java.lang.String r5 = r5.getString(r6)
            return r5
        L_0x0059:
            r6 = 2131956530(0x7f131332, float:1.9549618E38)
            java.lang.String r5 = r5.getString(r6)
            return r5
        L_0x0061:
            r6 = 2131956531(0x7f131333, float:1.954962E38)
            java.lang.String r5 = r5.getString(r6)
            return r5
        L_0x0069:
            r6 = 2131956528(0x7f131330, float:1.9549614E38)
            java.lang.String r5 = r5.getString(r6)
            return r5
        L_0x0071:
            java.lang.String r5 = r5.getString(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dcrypto.util.MulticoinUtils.getMulticoinDialogTitle(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getMulticoinDialogSubtitle(android.content.Context r5, java.lang.String r6) {
        /*
            int r0 = r6.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case 66097: goto L_0x0034;
                case 68985: goto L_0x002a;
                case 82288: goto L_0x0020;
                case 2358855: goto L_0x0016;
                case 2614173: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x003e
        L_0x000c:
            java.lang.String r0 = "USDC"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003e
            r6 = 2
            goto L_0x003f
        L_0x0016:
            java.lang.String r0 = "MANA"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003e
            r6 = 4
            goto L_0x003f
        L_0x0020:
            java.lang.String r0 = "SOL"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003e
            r6 = 3
            goto L_0x003f
        L_0x002a:
            java.lang.String r0 = "ETH"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003e
            r6 = 1
            goto L_0x003f
        L_0x0034:
            java.lang.String r0 = "BTC"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003e
            r6 = 0
            goto L_0x003f
        L_0x003e:
            r6 = -1
        L_0x003f:
            r0 = 2131956522(0x7f13132a, float:1.9549602E38)
            if (r6 == 0) goto L_0x0071
            if (r6 == r4) goto L_0x0069
            if (r6 == r3) goto L_0x0061
            if (r6 == r2) goto L_0x0059
            if (r6 == r1) goto L_0x0051
            java.lang.String r5 = r5.getString(r0)
            return r5
        L_0x0051:
            r6 = 2131956524(0x7f13132c, float:1.9549606E38)
            java.lang.String r5 = r5.getString(r6)
            return r5
        L_0x0059:
            r6 = 2131956525(0x7f13132d, float:1.9549608E38)
            java.lang.String r5 = r5.getString(r6)
            return r5
        L_0x0061:
            r6 = 2131956526(0x7f13132e, float:1.954961E38)
            java.lang.String r5 = r5.getString(r6)
            return r5
        L_0x0069:
            r6 = 2131956523(0x7f13132b, float:1.9549604E38)
            java.lang.String r5 = r5.getString(r6)
            return r5
        L_0x0071:
            java.lang.String r5 = r5.getString(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dcrypto.util.MulticoinUtils.getMulticoinDialogSubtitle(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String getMulticoinCurrency(String str) {
        String substring = str.substring(0, str.indexOf("$") + 1);
        String substring2 = str.substring(str.indexOf("$") + 1);
        return substring + " " + substring2;
    }
}
