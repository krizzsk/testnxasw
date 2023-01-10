package com.threatmetrix.TrustDefender;

import android.content.Context;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrength;
import android.telephony.TelephonyManager;
import com.threatmetrix.TrustDefender.tqttqq;
import com.threatmetrix.TrustDefender.yyqyyy;
import com.threatmetrix.TrustDefender.yyyyqy;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ttqtqq {
    private static final int b006E006E006E006Enn = -1;
    private static final String bn006E006E006Enn = yyyyqy.b0074t007400740074t(ttqtqq.class);

    /* renamed from: com.threatmetrix.TrustDefender.ttqtqq$1 */
    public static /* synthetic */ class C215891 {
        public static final /* synthetic */ int[] bnnnn006En;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.threatmetrix.TrustDefender.yyqyyy$yqqyyy[] r0 = com.threatmetrix.TrustDefender.yyqyyy.yqqyyy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                bnnnn006En = r0
                com.threatmetrix.TrustDefender.yyqyyy$yqqyyy r1 = com.threatmetrix.TrustDefender.yyqyyy.yqqyyy.WCDMA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = bnnnn006En     // Catch:{ NoSuchFieldError -> 0x001d }
                com.threatmetrix.TrustDefender.yyqyyy$yqqyyy r1 = com.threatmetrix.TrustDefender.yyqyyy.yqqyyy.GSM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = bnnnn006En     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.threatmetrix.TrustDefender.yyqyyy$yqqyyy r1 = com.threatmetrix.TrustDefender.yyqyyy.yqqyyy.LTE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = bnnnn006En     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.threatmetrix.TrustDefender.yyqyyy$yqqyyy r1 = com.threatmetrix.TrustDefender.yyqyyy.yqqyyy.CDMA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.ttqtqq.C215891.<clinit>():void");
        }
    }

    @Nonnull
    private static yyqyyy.yqqyyy b007500750075uu0075(CellInfo cellInfo) {
        return (!tqttqq.qqqqqt.bv0076vv00760076() || !(cellInfo instanceof CellInfoWcdma)) ? (!tqttqq.qqqqqt.bvvvv00760076() || !(cellInfo instanceof CellInfoGsm)) ? (!tqttqq.qqqqqt.b0076vvv00760076() || !(cellInfo instanceof CellInfoLte)) ? (!tqttqq.qqqqqt.b0076007600760076v0076() || !(cellInfo instanceof CellInfoCdma)) ? yyqyyy.yqqyyy.UNKOWN : yyqyyy.yqqyyy.CDMA : yyqyyy.yqqyyy.LTE : yyqyyy.yqqyyy.GSM : yyqyyy.yqqyyy.WCDMA;
    }

    private static boolean b00750075u0075u0075(int i, int i2, int i3, int i4) {
        return (i == Integer.MAX_VALUE || i3 == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE || i4 == Integer.MAX_VALUE) ? false : true;
    }

    private static void b0075u0075uu0075(yyqyyy.yqqyyy yqqyyy, int i, int i2, int i3, int i4, StringBuilder sb) {
        if (b00750075u0075u0075(i, i2, i3, i4)) {
            sb.append(yqqyyy);
            sb.append(":");
            if (i != -1) {
                sb.append(i);
                sb.append(":");
            }
            if (i3 != -1) {
                sb.append(i3);
                sb.append(":");
            }
            if (i2 != -1) {
                sb.append(i2);
                sb.append(":");
            }
            if (i4 != -1) {
                sb.append(i4);
            }
        }
    }

    @Nullable
    private static List<CellInfo> b0075uu0075u0075(@Nonnull Context context) {
        if (!tqttqq.qqqqqt.b0076vv007600760076()) {
            return null;
        }
        try {
            Object systemService = context.getSystemService("phone");
            if (!(systemService instanceof TelephonyManager)) {
                return null;
            }
            return ((TelephonyManager) systemService).getAllCellInfo();
        } catch (SecurityException e) {
            yyyyqy.qyyyqy.b00740074tttt(bn006E006E006Enn, "User refuse granting permission {}", e.toString());
            qqqtqt.byyyy0079y(e);
            return null;
        } catch (Exception e2) {
            yyyyqy.bt0074007400740074t(bn006E006E006Enn, e2.toString());
            return null;
        }
    }

    private static void bu00750075uu0075(@Nonnull CellSignalStrength cellSignalStrength, String str, @Nonnull Map<String, String> map) {
        if (cellSignalStrength.getAsuLevel() != 99) {
            map.put(yyqyyy.qyqyyy.bf00660066ff0066, String.valueOf(cellSignalStrength.getAsuLevel()));
        }
        map.put(yyqyyy.qyqyyy.b0066f0066ff0066, String.valueOf(cellSignalStrength.getDbm()));
        map.put(yyqyyy.qyqyyy.b006600660066ff0066, String.valueOf(cellSignalStrength.getLevel()));
        map.put(yyqyyy.qyqyyy.b00660066f0066f0066, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0084 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0015 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> bu0075u0075u0075(@javax.annotation.Nonnull android.content.Context r5) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.List r5 = b0075uu0075u0075(r5)
            if (r5 == 0) goto L_0x0086
            int r1 = r5.size()
            if (r1 <= 0) goto L_0x0086
            java.util.Iterator r5 = r5.iterator()
        L_0x0015:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0086
            java.lang.Object r1 = r5.next()
            android.telephony.CellInfo r1 = (android.telephony.CellInfo) r1
            boolean r2 = r1.isRegistered()
            if (r2 == 0) goto L_0x0015
            int[] r2 = com.threatmetrix.TrustDefender.ttqtqq.C215891.bnnnn006En
            com.threatmetrix.TrustDefender.yyqyyy$yqqyyy r3 = b007500750075uu0075(r1)
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 1
            r4 = 3
            if (r2 == r3) goto L_0x006d
            r3 = 2
            if (r2 == r3) goto L_0x005e
            if (r2 == r4) goto L_0x004f
            r3 = 4
            if (r2 == r3) goto L_0x0040
            goto L_0x007e
        L_0x0040:
            android.telephony.CellInfoCdma r1 = (android.telephony.CellInfoCdma) r1
            android.telephony.CellSignalStrengthCdma r2 = r1.getCellSignalStrength()
            android.telephony.CellIdentityCdma r1 = r1.getCellIdentity()
            java.lang.String r1 = r1.toString()
            goto L_0x007b
        L_0x004f:
            android.telephony.CellInfoLte r1 = (android.telephony.CellInfoLte) r1
            android.telephony.CellSignalStrengthLte r2 = r1.getCellSignalStrength()
            android.telephony.CellIdentityLte r1 = r1.getCellIdentity()
            java.lang.String r1 = r1.toString()
            goto L_0x007b
        L_0x005e:
            android.telephony.CellInfoGsm r1 = (android.telephony.CellInfoGsm) r1
            android.telephony.CellSignalStrengthGsm r2 = r1.getCellSignalStrength()
            android.telephony.CellIdentityGsm r1 = r1.getCellIdentity()
            java.lang.String r1 = r1.toString()
            goto L_0x007b
        L_0x006d:
            android.telephony.CellInfoWcdma r1 = (android.telephony.CellInfoWcdma) r1
            android.telephony.CellSignalStrengthWcdma r2 = r1.getCellSignalStrength()
            android.telephony.CellIdentityWcdma r1 = r1.getCellIdentity()
            java.lang.String r1 = r1.toString()
        L_0x007b:
            bu00750075uu0075(r2, r1, r0)
        L_0x007e:
            int r1 = r0.size()
            if (r1 >= r4) goto L_0x0015
            r5 = 0
            return r5
        L_0x0086:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.ttqtqq.bu0075u0075u0075(android.content.Context):java.util.Map");
    }

    public static String buuu0075u0075(@Nonnull Context context) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        StringBuilder sb = new StringBuilder();
        List<CellInfo> b0075uu0075u0075 = b0075uu0075u0075(context);
        yyqyyy.yqqyyy yqqyyy = yyqyyy.yqqyyy.LTE;
        if (b0075uu0075u0075 != null && b0075uu0075u0075.size() > 0) {
            boolean z2 = true;
            for (CellInfo next : b0075uu0075u0075) {
                if (next.isRegistered()) {
                    yyqyyy.yqqyyy b007500750075uu0075 = b007500750075uu0075(next);
                    if (z2) {
                        z = false;
                    } else if (yqqyyy.getPriority() > b007500750075uu0075.getPriority()) {
                        z = z2;
                    }
                    int i5 = C215891.bnnnn006En[b007500750075uu0075.ordinal()];
                    if (i5 == 1) {
                        CellIdentityWcdma cellIdentity = ((CellInfoWcdma) next).getCellIdentity();
                        i4 = cellIdentity.getCid();
                        i2 = cellIdentity.getMcc();
                        i3 = cellIdentity.getMnc();
                        i = cellIdentity.getLac();
                    } else if (i5 == 2) {
                        CellIdentityGsm cellIdentity2 = ((CellInfoGsm) next).getCellIdentity();
                        i4 = cellIdentity2.getCid();
                        i2 = cellIdentity2.getMcc();
                        i3 = cellIdentity2.getMnc();
                        i = cellIdentity2.getLac();
                    } else if (i5 != 3) {
                        if (i5 == 4) {
                            CellIdentityCdma cellIdentity3 = ((CellInfoCdma) next).getCellIdentity();
                            i4 = cellIdentity3.getBasestationId();
                            i3 = cellIdentity3.getSystemId();
                            i = cellIdentity3.getNetworkId();
                            i2 = -1;
                        }
                        yqqyyy = b007500750075uu0075;
                        z2 = z;
                    } else {
                        CellIdentityLte cellIdentity4 = ((CellInfoLte) next).getCellIdentity();
                        i4 = cellIdentity4.getCi();
                        i2 = cellIdentity4.getMcc();
                        i3 = cellIdentity4.getMnc();
                        i = cellIdentity4.getTac();
                    }
                    b0075u0075uu0075(b007500750075uu0075, i4, i3, i2, i, sb);
                    yqqyyy = b007500750075uu0075;
                    z2 = z;
                }
            }
        }
        return sb.toString();
    }
}
