package com.threatmetrix.TrustDefender;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Environment;
import android.os.Looper;
import android.os.PowerManager;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import com.didi.dimina.container.p065ui.custom.SameLayerRenderingUtil;
import com.didi.raven.config.RavenKey;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.threatmetrix.TrustDefender.jkjjkj;
import com.threatmetrix.TrustDefender.kkjkjk;
import com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk;
import com.threatmetrix.TrustDefender.nlunsxbsempjyxm.wvvvvv;
import com.threatmetrix.TrustDefender.qqqqyq;
import com.threatmetrix.TrustDefender.tqttqq;
import com.threatmetrix.TrustDefender.yyyyqy;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kotlin.text.Typography;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.p074io.IOUtils;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.VersionRange;

public class yyqyyy {
    @Nullable
    private static final Method b00660066006600660066f = kkjkjk.bss00730073s00730073(kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.SYSTEM_PROPERTIES), jkkjkk.b0062bbbbbb("\u0010\r\u001b", '4', IOUtils.DIR_SEPARATOR_WINDOWS, 1), String.class);
    private static final String b00660066f00660066f = jkkjkk.b0062bbbbbb("0,0", 218, 'e', 3);
    private static final String b0066f006600660066f = jkkjkk.bb0062bbbbb("J]fXSe=Tb_Uc7XJPRJ7'-@4", 137, 2);
    private static final String bf0066006600660066f = jkkjkk.bb0062bbbbb("\u0001 \u0013!O#\u0017\u0019)(\u001bV\u001f+\u001b)0&,&_1'51.9:188j", 170, 4);
    /* access modifiers changed from: private */
    public static final String bf0066f00660066f = yyyyqy.b0074t007400740074t(yyqyyy.class);
    public static final String bff006600660066f = jkkjkk.bb0062bbbbb("~\u0004\u0001\t\u000ew\u0005\u0006w}w", Typography.degree, 1);

    public static class qqqyyy {
        private qqqyyy() {
        }

        public static qqqqyq.yyyyqq b00710071qqqq(String str) {
            if (yqqyqq.bi0069i0069i0069(str)) {
                return qqqqyq.yyyyqq.COULD_NOT_CHECK;
            }
            try {
                return qqqqyq.yyyyqq.valueOf(str.toUpperCase());
            } catch (IllegalArgumentException unused) {
                return qqqqyq.yyyyqq.COULD_NOT_CHECK;
            }
        }

        public static String b0071q0071qqq(String str) {
            return bqq0071qqq(b00710071qqqq(str));
        }

        public static String bqq0071qqq(qqqqyq.yyyyqq yyyyqq) {
            if (yyyyqq == null) {
                return qqqqyq.bbbbb0062b;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("description", yyyyqq.bb0062bb0062b);
                if (yyyyqq.b00620062bb0062b) {
                    jSONObject.put("result", qqqqyq.b0062b00620062bb);
                }
                return jSONObject.toString();
            } catch (JSONException e) {
                String bq00710071qqq = yyqyyy.bf0066f00660066f;
                yyyyqy.qyyyqy.bt00740074ttt(bq00710071qqq, "JSON creation failure " + e.toString());
                return qqqqyq.b0062bbb0062b;
            }
        }
    }

    public static class qyqyyy {
        public static final String b0066006600660066f0066 = "bsid";
        public static final String b006600660066ff0066 = "sl_int";
        public static final String b00660066f0066f0066 = "cii";
        public static final String b00660066fff0066 = "non";
        public static final String b0066f00660066f0066 = "bs_lng";
        public static final String b0066f0066ff0066 = "ss_dBm";
        public static final String b0066ff0066f0066 = "lac";
        public static final int b0066ffff0066 = 99;
        public static final String bf006600660066f0066 = "sid";
        public static final String bf00660066ff0066 = "sl_ASU";
        public static final String bf0066f0066f0066 = "psc";
        public static final String bf0066fff0066 = "no";
        public static final String bff00660066f0066 = "bs_lat";
        public static final String bff0066ff0066 = "nc_iso";
        public static final String bfff0066f0066 = "cid";
        public static final int bfffff0066 = 3;

        private qyqyyy() {
        }
    }

    public enum yqqyyy {
        CDMA("CDMA", 3),
        GSM("GSM", 1),
        LTE("LTE", 0),
        UNKOWN("OTHER", 99),
        WCDMA("UMTS", 2);
        
        private final int b0066fff00660066;
        private final String bffff00660066;

        private yqqyyy(String str, int i) {
            this.bffff00660066 = str;
            this.b0066fff00660066 = i;
        }

        public String getLabel() {
            return this.bffff00660066;
        }

        public int getPriority() {
            return this.b0066fff00660066;
        }
    }

    public static class yyyqyy {
        public int b00660066ff00660066 = 0;
        public int bff0066f00660066 = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long b00710071007100710071q(@javax.annotation.Nonnull com.threatmetrix.TrustDefender.tqtqqt r10) throws java.lang.InterruptedException {
        /*
            android.content.Context r10 = r10.bll006C006C006C006C
            java.lang.String r0 = "j}\u0007xs\u0006]t\u0003u\u0004WxjprjWGM`T"
            r1 = 130(0x82, float:1.82E-43)
            r2 = 229(0xe5, float:3.21E-43)
            r3 = 2
            java.lang.String r0 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.b0062bbbbbb(r0, r1, r2, r3)
            r1 = 0
            android.content.SharedPreferences r10 = com.didi.sdk.apm.SystemUtils.getSharedPreferences(r10, r0, r1)
            r0 = 5
            r2 = 0
            java.lang.String r4 = "Lal`]qKdtsk{Qthptn]OWlb"
            r5 = 209(0xd1, float:2.93E-43)
            java.lang.String r4 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r4, r5, r0)     // Catch:{ ClassCastException -> 0x002e }
            long r4 = com.threatmetrix.TrustDefender.tqttqq.tqtttq.bv0076007600760076v(r10, r4, r2)     // Catch:{ ClassCastException -> 0x002e }
            boolean r6 = java.lang.Thread.interrupted()     // Catch:{ ClassCastException -> 0x002f }
            if (r6 != 0) goto L_0x0028
            goto L_0x003e
        L_0x0028:
            java.lang.InterruptedException r6 = new java.lang.InterruptedException     // Catch:{ ClassCastException -> 0x002f }
            r6.<init>()     // Catch:{ ClassCastException -> 0x002f }
            throw r6     // Catch:{ ClassCastException -> 0x002f }
        L_0x002e:
            r4 = r2
        L_0x002f:
            java.lang.String r6 = bf0066f00660066f
            r7 = 48
            r8 = 78
            java.lang.String r9 = "+QGTSWI]SMXR\u000eciaW\u0013Zdh\u00179IJZPFKD"
            java.lang.String r1 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.b0062bbbbbb(r9, r7, r8, r1)
            com.threatmetrix.TrustDefender.yyyyqy.qyyyqy.bt0074tttt(r6, r1)
        L_0x003e:
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x006c
            java.lang.String r1 = bf0066f00660066f
            r2 = 26
            r3 = 4
            java.lang.String r4 = "`\u000b\u0012\f\u0003?\u000f\u0011\u0017\f\u000e\u0014\u000eG\u0012\u0018J\u001f\u0015\u000f!\u0015\u0015Q#&\u001a\u001c*cX! *\"0 4*0*c\u0006\u0016\u0017'\u001d\u0013\u0018\u0011"
            java.lang.String r2 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r4, r2, r3)
            com.threatmetrix.TrustDefender.yyyyqy.qyyyqy.bt0074tttt(r1, r2)
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 1000(0x3e8, double:4.94E-321)
            long r4 = r1 / r3
            android.content.SharedPreferences$Editor r10 = com.threatmetrix.TrustDefender.tqttqq.tqtttq.b00760076v00760076v(r10)
            if (r10 == 0) goto L_0x006c
            r1 = 84
            java.lang.String r2 = "RgrfcwQjzyq\u0002WznvztcU]rh"
            java.lang.String r1 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r2, r1, r0)
            com.threatmetrix.TrustDefender.tqttqq.tqtttq.b0076v0076vv0076(r1, r4, r10)
            r10.apply()
        L_0x006c:
            java.lang.String r10 = bf0066f00660066f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 102(0x66, float:1.43E-43)
            java.lang.String r3 = "{%+W\u001a*+[1',%`(532e\u001a0*<00\u001d@466D8B8;Jw?IM{HCX\u001a5JUIFZ4M]\\Td:]QY]WF8@UK$\u0019"
            java.lang.String r0 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r3, r2, r0)
            r1.append(r0)
            r1.append(r4)
            java.lang.String r0 = r1.toString()
            com.threatmetrix.TrustDefender.yyyyqy.qyyyqy.bt0074tttt(r10, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.yyqyyy.b00710071007100710071q(com.threatmetrix.TrustDefender.tqtqqt):long");
    }

    public static String b0071007100710071q0071(@Nonnull tqtqqt tqtqqt) {
        String bqq0071007100710071;
        if (tqttqq.ttttqq.qqqqtq.b006E006En006En006E >= tqttqq.ttttqq.tqqqtq.bnn006E006E006E006E && (bqq0071007100710071 = qqyqyy.bqq0071007100710071(tqtqqt)) != null) {
            return bqq0071007100710071;
        }
        try {
            String property = System.getProperty(jkkjkk.b0062bbbbbb("s~}x5vws{{Iorr", 207, '$', 2), (String) null);
            String property2 = System.getProperty(jkkjkk.bb0062bbbbb("P[ZU\u0012STPXX.LNO", 12, 1), (String) null);
            if (yqqyqq.b0069ii0069i0069(property) && yqqyqq.b0069ii0069i0069(property2)) {
                String str = bf0066f00660066f;
                yyyyqy.qyyyqy.bt0074tttt(str, jkkjkk.b0062bbbbbb("cfdnp\u0018bhakok`tjqq$", 149, Typography.cent, 0) + property + jkkjkk.bb0062bbbbb("0", 10, 2) + property2);
                if (!jkkjkk.bb0062bbbbb("w|", '%', 0).equals(property2)) {
                    if (!jkkjkk.b0062bbbbbb("MOB?IDJMM", 205, 'P', 2).equals(property.toLowerCase())) {
                        return property + jkkjkk.b0062bbbbbb("Z", 'c', 4, 1) + property2;
                    }
                }
                yyyyqy.qyyyqy.bt0074tttt(bf0066f00660066f, jkkjkk.bb0062bbbbb("'DJJLBF>u>BI3=93m=>:BB", 161, 2));
                return null;
            }
        } catch (SecurityException unused) {
            yyyyqy.qyyyqy.bt00740074ttt(bf0066f00660066f, jkkjkk.b0062bbbbbb("\\mj{wmw{Namebn\u001b\\egZah\u0014TUTUba\r`Z\nYZVVJVWKFS", 'p', 248, 1));
        }
        return null;
    }

    public static long b0071007100710071qq(@Nonnull tqtqqt tqtqqt) throws InterruptedException {
        long b0071qqq0071q = b0071qqq0071q(tqtqqt.bll006C006C006C006C.getApplicationInfo().sourceDir);
        return b0071qqq0071q != 0 ? b0071qqq0071q : b00710071007100710071q(tqtqqt);
    }

    public static boolean b007100710071q00710071(@Nonnull tqtqqt tqtqqt) {
        Context context = tqtqqt.bll006C006C006C006C;
        if (tqttqq.ttttqq.qqqqtq.b006E006En006En006E >= tqttqq.ttttqq.tqqqtq.b006Enn006E006E006E) {
            return qyyqyy.bq0071q007100710071(context);
        }
        if (!tqttqq.ttqttq.bvvv00760076v()) {
            return true;
        }
        try {
            Object systemService = context.getSystemService(jkkjkk.bb0062bbbbb("/-4!-", 'A', 2));
            if (!(systemService instanceof PowerManager)) {
                return true;
            }
            return ((PowerManager) systemService).isScreenOn();
        } catch (SecurityException e) {
            String str = bf0066f00660066f;
            yyyyqy.qyyyqy.bt0074tttt(str, jkkjkk.bb0062bbbbb("\u0002!\u0014\"P$\u0018\u001a*)\u001cW ,\u001c*1'-'`2(62/:;299k", 22, 0) + e.toString());
            qqqtqt.byyyy0079y(e);
            return true;
        } catch (Exception e2) {
            yyyyqy.qyyyqy.bt00740074ttt(bf0066f00660066f, e2.toString());
            return true;
        }
    }

    public static String b007100710071q0071q() {
        return jkkjkk.b0062bbbbbb("\u0004\u0010\u0005\u0012\u000e\u0007\u0001", 236, 238, 2);
    }

    @Nullable
    public static String b007100710071qq0071(@Nonnull tqtqqt tqtqqt) {
        try {
            String string = Settings.System.getString(tqtqqt.bll006C006C006C006C.getContentResolver(), jkkjkk.b0062bbbbbb("CCSE>?8F8C:", 'b', 192, 1));
            if (string != null) {
                return string;
            }
        } catch (RuntimeException e) {
            yyyyqy.qyyyqy.b00740074tttt(bf0066f00660066f, jkkjkk.b0062bbbbbb("6jVYej`gg\u001adj\u001d_bcfuvmsm'{n~u{u\u00030w\u0002\u00064y{\u000e\u0002|;\u000b~\f\u0005@\u001d ", 221, 18, 3), e.toString());
        }
        try {
            String string2 = Settings.Secure.getString(tqtqqt.bll006C006C006C006C.getContentResolver(), jkkjkk.bb0062bbbbb("ajraoihl_UcU`W", 255, 2));
            if (string2 != null) {
                return string2;
            }
        } catch (RuntimeException e2) {
            yyyyqy.qyyyqy.b00740074tttt(bf0066f00660066f, jkkjkk.b0062bbbbbb("2fRUaf\\cc\u0016`f\u0019[^_bqrioi#wjz{qwq~,s}\u00020s~\ty\n\u0006\u0007\r\u0002:\n}\u000b\u0004?\u001c\u001f", 'i', 130, 3), e2.toString());
        }
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                return defaultAdapter.getName();
            }
            return null;
        } catch (Exception e3) {
            yyyyqy.qyyyqy.b00740074tttt(bf0066f00660066f, jkkjkk.bb0062bbbbb("+]GHRUINL|EIy:;:;HG<@8o1:B1?98</e))9+$%^9:", '3', 3), e3.toString());
            return null;
        }
    }

    private static String b007100710071qqq(Map<String, String> map) {
        if (map.size() >= 3) {
            return map.toString();
        }
        return null;
    }

    public static int b00710071q00710071q(tqtqqt tqtqqt) {
        return tqttqq.qtqqtq.b00750075uu00750075(tqtqqt.bll006C006C006C006C);
    }

    public static String b00710071q0071q0071() {
        return jkkjkk.b0062bbbbbb("j\u0017\f\u0019\u0015\u000e\b", 7, 'O', 2);
    }

    @Nullable
    public static String b00710071q0071qq(@Nonnull tqtqqt tqtqqt) {
        qqqqyq.yyyyqq yyyyqq;
        tqttqq.qtttqq qtttqq = new tqttqq.qtttqq(tqtqqt);
        String buu00750075u0075 = qtttqq.buu00750075u0075();
        String b0067006700670067g0067 = qqqyqy.bg00670067g0067g().b0067006700670067g0067(buu00750075u0075);
        if (b0067006700670067g0067 != null) {
            return qqqyyy.b0071q0071qqq(b0067006700670067g0067);
        }
        String[] split = buu00750075u0075.split(jkkjkk.bb0062bbbbb("\n", Matrix.MATRIX_TYPE_ZERO, 4));
        int length = split.length;
        int i = 0;
        while (true) {
            if (i < length) {
                String str = split[i];
                if (str.contains(jkkjkk.b0062bbbbbb(RavenKey.STACK, 198, CharUtils.f7473CR, 1)) && !str.equalsIgnoreCase(tqtqqt.bll006C006C006C006C.getPackageName())) {
                    yyyyqq = qqqqyq.yyyyqq.INCONSISTENT_PATH;
                    break;
                }
                i++;
            } else {
                String[] packagesForUid = tqtqqt.bll006C006C006C006C.getPackageManager().getPackagesForUid(qtttqq.b0075uuu00750075());
                yyyyqq = (packagesForUid == null || packagesForUid.length <= 1) ? qqqqyq.yyyyqq.NOT_CLONED : qqqqyq.yyyyqq.MULTIPLE_PID;
            }
        }
        return qqqyyy.bqq0071qqq(yyyyqq);
    }

    public static boolean b00710071qq00710071() {
        return qtqqtt.b0079y007900790079y();
    }

    public static long b00710071qq0071q() {
        long currentTimeMillis = (System.currentTimeMillis() - tqttqq.tttttq.b00760076v0076v0076()) / 1000;
        yyyyqy.bt0074007400740074t(bf0066f00660066f, jkkjkk.b0062bbbbbb("sm~", 150, 219, 2));
        String str = bf0066f00660066f;
        yyyyqy.qyyyqy.bt0074tttt(str, jkkjkk.bb0062bbbbb("\u001ba^l9edhG[^U)\u000e", Typography.leftGuillemete, 3) + currentTimeMillis);
        return currentTimeMillis;
    }

    public static String b00710071qqq0071(String str) {
        String str2 = (String) kkjkjk.bs00730073s007300730073((Object) null, b00660066006600660066f, str);
        if (yqqyqq.b0069ii0069i0069(str2)) {
            return str2;
        }
        return null;
    }

    @Nullable
    public static String b0071q007100710071q(long j, long j2) throws InterruptedException {
        String b0069i00690069i0069 = yqqyqq.b0069i00690069i0069(j + jkkjkk.bb0062bbbbb("(", Typography.leftGuillemete, 3) + j2);
        yyyyqy.bt0074007400740074t(bf0066f00660066f, jkkjkk.bb0062bbbbb("hfv", Matrix.MATRIX_TYPE_RANDOM_UT, 5));
        String str = bf0066f00660066f;
        yyyyqy.qyyyqy.bt0074tttt(str, jkkjkk.b0062bbbbbb("\u0005\u0004\u0014d\u0007\u0019\r\b\u000by\u001c\n\u001e\u0010eL", 232, Matrix.MATRIX_TYPE_RANDOM_LT, 0) + b0069i00690069i0069);
        return b0069i00690069i0069;
    }

    public static String b0071q00710071q0071(tqtqqt tqtqqt) {
        return new tqttqq.qtttqq(tqtqqt).buuuu00750075();
    }

    public static String b0071q00710071qq(tqtqqt tqtqqt) {
        return qttqtt.byyy0079y0079(tqtqqt.bll006C006C006C006C);
    }

    public static boolean b0071q0071q00710071() {
        return true;
    }

    public static String b0071q0071q0071q(@Nonnull tqtqqt tqtqqt) {
        if (!tqttqq.qqqqqt.bvvv007600760076()) {
            return null;
        }
        tqttqq tqttqq = new tqttqq();
        tqttqq.getClass();
        if (!new tqttqq.qtqttq(tqtqqt.bll006C006C006C006C).b0076v0076v0076v(jkkjkk.b0062bbbbbb("%3*972.x<2@<9DE<CC\u0004\u0018\u001b\u001c\u001f./<$(.&A/3(';188", 140, 200, 0), tqtqqt.bll006C006C006C006C.getPackageName())) {
            return null;
        }
        String buuu0075u0075 = ttqtqq.buuu0075u0075(tqtqqt.bll006C006C006C006C);
        if (yqqyqq.bi0069i0069i0069(buuu0075u0075) && (tqttqq.qqqqqt.b00760076vv00760076() || tqttqq.qqqqqt.bvv0076v00760076())) {
            try {
                Object systemService = tqtqqt.bll006C006C006C006C.getApplicationContext().getSystemService(jkkjkk.bb0062bbbbb("%\u001c\" \u0016", 'K', 2));
                if (!(systemService instanceof TelephonyManager)) {
                    return null;
                }
                TelephonyManager telephonyManager = (TelephonyManager) systemService;
                CellLocation cellLocation = telephonyManager.getCellLocation();
                StringBuilder sb = new StringBuilder();
                Object obj = "";
                if (cellLocation instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
                    int cid = gsmCellLocation.getCid();
                    int lac = gsmCellLocation.getLac();
                    if (cid == -1 && lac == -1) {
                        return null;
                    }
                    sb.append(jkkjkk.b0062bbbbbb("GRK7", 250, 131, 2));
                    sb.append(cid == -1 ? obj : Integer.valueOf(cid));
                    sb.append(jkkjkk.b0062bbbbbb("}|{", Typography.half, '}', 2));
                    if (lac != -1) {
                        obj = Integer.valueOf(lac);
                    }
                    sb.append(obj);
                    return sb.toString();
                } else if (cellLocation instanceof CdmaCellLocation) {
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) telephonyManager.getCellLocation();
                    int baseStationId = cdmaCellLocation.getBaseStationId();
                    int systemId = cdmaCellLocation.getSystemId();
                    int networkId = cdmaCellLocation.getNetworkId();
                    if (baseStationId == -1 && systemId == -1 && networkId == -1) {
                        return null;
                    }
                    sb.append(jkkjkk.bb0062bbbbb("BBJ=5", 191, 1));
                    sb.append(baseStationId == -1 ? obj : Integer.valueOf(baseStationId));
                    sb.append(jkkjkk.bb0062bbbbb("d", 21, 0));
                    sb.append(systemId == -1 ? obj : Integer.valueOf(systemId));
                    sb.append(jkkjkk.b0062bbbbbb("\f", 21, 194, 0));
                    if (networkId != -1) {
                        obj = Integer.valueOf(networkId);
                    }
                    sb.append(obj);
                    return sb.toString();
                }
            } catch (SecurityException e) {
                String str = bf0066f00660066f;
                yyyyqy.qyyyqy.bt0074tttt(str, jkkjkk.b0062bbbbbb("_|my&wiiwte\u001feo]inbf^\u0016eYe_ZcbW\\Z\u000b", 31, VersionRange.RIGHT_OPEN, 1) + e.getMessage());
                qqqtqt.byyyy0079y(e);
            } catch (Exception e2) {
                yyyyqy.qyyyqy.bt0074tttt(bf0066f00660066f, e2.toString());
            }
        }
        return buuu0075u0075;
    }

    public static String b0071q0071qq0071() {
        Locale locale = Locale.getDefault();
        StringBuilder sb = new StringBuilder();
        String language = locale.getLanguage();
        if (language != null) {
            sb.append(language);
            String country = locale.getCountry();
            if (country != null) {
                sb.append(jkkjkk.bb0062bbbbb("%", ':', 2));
                sb.append(country);
            }
        }
        return sb.toString();
    }

    public static boolean b0071qq007100710071(@Nonnull Context context) {
        if (tqttqq.ttttqq.qqqqtq.b006E006En006En006E >= tqttqq.ttttqq.tqqqtq.bnn006E006E006E006E) {
            return qqyqyy.b0071q0071007100710071(context);
        }
        return false;
    }

    private static void b0071qq00710071q(Context context, TelephonyManager telephonyManager, Map<String, String> map) {
        CdmaCellLocation cdmaCellLocation;
        String bb0062bbbbb;
        String valueOf;
        Map<String, String> bu0075u0075u0075 = ttqtqq.bu0075u0075u0075(context);
        if (bu0075u0075u0075 != null) {
            map.putAll(bu0075u0075u0075);
        }
        if (tqttqq.qqqqqt.b00760076vv00760076() || tqttqq.qqqqqt.bvv0076v00760076()) {
            try {
                CellLocation cellLocation = telephonyManager.getCellLocation();
                if (cellLocation != null) {
                    if (cellLocation instanceof GsmCellLocation) {
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
                        if (gsmCellLocation != null) {
                            int lac = gsmCellLocation.getLac();
                            if (lac != -1) {
                                map.put(jkkjkk.bb0062bbbbb("@45", 184, 3), String.valueOf(lac));
                            }
                            int cid = gsmCellLocation.getCid();
                            if (cid != -1) {
                                map.put(jkkjkk.b0062bbbbbb("dic", 'e', 'f', 1), String.valueOf(cid));
                            }
                            int psc = gsmCellLocation.getPsc();
                            if (psc != -1) {
                                bb0062bbbbb = jkkjkk.b0062bbbbbb("WYH", 'K', '2', 1);
                                valueOf = String.valueOf(psc);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if ((cellLocation instanceof CdmaCellLocation) && (cdmaCellLocation = (CdmaCellLocation) telephonyManager.getCellLocation()) != null) {
                        int systemId = cdmaCellLocation.getSystemId();
                        if (systemId != -1) {
                            map.put(jkkjkk.bb0062bbbbb("\u0007}y", 218, 5), String.valueOf(systemId));
                        }
                        int baseStationId = cdmaCellLocation.getBaseStationId();
                        if (baseStationId != -1) {
                            map.put(jkkjkk.b0062bbbbbb("CSHB", 185, 227, 2), String.valueOf(baseStationId));
                        }
                        int baseStationLatitude = cdmaCellLocation.getBaseStationLatitude();
                        if (baseStationLatitude != Integer.MAX_VALUE) {
                            map.put(jkkjkk.bb0062bbbbb("\f\u001c\u0007\u0013\u0007\u0019", 'G', 3), String.valueOf(baseStationLatitude));
                        }
                        int baseStationLongitude = cdmaCellLocation.getBaseStationLongitude();
                        if (baseStationLongitude != Integer.MAX_VALUE) {
                            bb0062bbbbb = jkkjkk.bb0062bbbbb("y\fx\u0007\n\u0004", 202, 0);
                            valueOf = String.valueOf(baseStationLongitude);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                    map.put(bb0062bbbbb, valueOf);
                }
            } catch (SecurityException e) {
                String str = bf0066f00660066f;
                yyyyqy.qyyyqy.bt0074tttt(str, jkkjkk.bb0062bbbbb("\"A4BpD8:JI<w@L<JQGMG\u0001RHVROZ[RYY\f", 237, 5) + e.toString());
                qqqtqt.byyyy0079y(e);
            } catch (Exception e2) {
                yyyyqy.qyyyqy.bt00740074ttt(bf0066f00660066f, e2.toString());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b0071qq0071q0071(android.telephony.TelephonyManager r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            int r0 = com.threatmetrix.TrustDefender.tqttqq.ttttqq.qqqqtq.b006E006En006En006E
            int r1 = com.threatmetrix.TrustDefender.tqttqq.ttttqq.tqqqtq.bnn006E006E006E006E
            if (r0 >= r1) goto L_0x00db
            boolean r0 = com.threatmetrix.TrustDefender.tqttqq.qqqqqt.bv00760076v00760076()
            if (r0 != 0) goto L_0x000e
            goto L_0x00db
        L_0x000e:
            r0 = 0
            r1 = 2
            java.lang.Class<android.telephony.TelephonyManager> r2 = android.telephony.TelephonyManager.class
            java.lang.String r3 = "98H#;@?A<JNFLF#FNO-SLV"
            r4 = 208(0xd0, float:2.91E-43)
            r5 = 4
            java.lang.String r3 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r3, r4, r5)     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            r4 = 0
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            java.lang.reflect.Method r2 = com.threatmetrix.TrustDefender.kkjkjk.bss00730073s00730073(r2, r3, r5)     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            if (r2 == 0) goto L_0x0031
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            java.lang.Object r7 = com.threatmetrix.TrustDefender.kkjkjk.bs00730073s007300730073(r7, r2, r3)     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            boolean r2 = r7 instanceof java.util.List     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            if (r2 == 0) goto L_0x0031
            r0 = r7
            java.util.List r0 = (java.util.List) r0     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
        L_0x0031:
            if (r0 == 0) goto L_0x00db
            int r7 = r0.size()     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            if (r7 <= 0) goto L_0x00db
            java.util.Iterator r7 = r0.iterator()     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
        L_0x003d:
            boolean r0 = r7.hasNext()     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            if (r0 == 0) goto L_0x00db
            java.lang.Object r0 = r7.next()     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            android.telephony.NeighboringCellInfo r0 = (android.telephony.NeighboringCellInfo) r0     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            int r2 = r0.getCid()     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            r3 = -1
            if (r2 == r3) goto L_0x003d
            int r2 = r0.getRssi()     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            r3 = 99
            if (r2 == r3) goto L_0x003d
            int r2 = r0.getCid()     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            java.lang.String r3 = "\u000b\u0010\n"
            r4 = 8
            r5 = 47
            r6 = 1
            java.lang.String r3 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.b0062bbbbbb(r3, r4, r5, r6)     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            java.lang.Object r3 = r8.get(r3)     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            if (r2 != 0) goto L_0x0094
            int r2 = r0.getCid()     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            java.lang.String r3 = "O_TN"
            r4 = 218(0xda, float:3.05E-43)
            r5 = 3
            java.lang.String r3 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r3, r4, r5)     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            java.lang.Object r3 = r8.get(r3)     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            if (r2 == 0) goto L_0x003d
        L_0x0094:
            java.lang.String r2 = "um_@QR"
            r3 = 172(0xac, float:2.41E-43)
            r4 = 80
            java.lang.String r2 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.b0062bbbbbb(r2, r3, r4, r1)     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            int r0 = r0.getRssi()     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            r8.put(r2, r0)     // Catch:{ SecurityException -> 0x00b6, Exception -> 0x00ab }
            goto L_0x003d
        L_0x00ab:
            r7 = move-exception
            java.lang.String r8 = bf0066f00660066f
            java.lang.String r7 = r7.toString()
            com.threatmetrix.TrustDefender.yyyyqy.qyyyqy.bt00740074ttt(r8, r7)
            goto L_0x00db
        L_0x00b6:
            r7 = move-exception
            java.lang.String r8 = bf0066f00660066f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r2 = 85
            java.lang.String r3 = "\u001d\u000e\u001aF\u0018\n\n\u0018\u0015\u0006?\u0006\u0010}\n\u000f\u0003\u0007~6\u0006y\u0006z\u0004\u0003w|z+"
            java.lang.String r1 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r3, r2, r1)
            r0.append(r1)
            java.lang.String r1 = r7.getMessage()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.threatmetrix.TrustDefender.yyyyqy.qyyyqy.bt0074tttt(r8, r0)
            com.threatmetrix.TrustDefender.qqqtqt.byyyy0079y(r7)
        L_0x00db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.yyqyyy.b0071qq0071q0071(android.telephony.TelephonyManager, java.util.Map):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0124, code lost:
        if (r3.equalsIgnoreCase(com.threatmetrix.TrustDefender.tqttqq.ttttqq.qqqqtq.bn006En006En006E) != false) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0143, code lost:
        if (r3.equalsIgnoreCase(java.lang.String.valueOf(com.threatmetrix.TrustDefender.tqttqq.ttttqq.b006En006En006En)) != false) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x015a, code lost:
        if (r3.equalsIgnoreCase(com.threatmetrix.TrustDefender.tqttqq.ttttqq.bn006E006En006En) != false) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0171, code lost:
        if (r3.equalsIgnoreCase(com.threatmetrix.TrustDefender.tqttqq.ttttqq.b006E006E006En006En) != false) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x018a, code lost:
        if (r3.equalsIgnoreCase(com.threatmetrix.TrustDefender.tqttqq.ttttqq.bnnn006E006En) != false) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01a4, code lost:
        if (r3.equalsIgnoreCase(com.threatmetrix.TrustDefender.tqttqq.ttttqq.bn006En006E006En) != false) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01bc, code lost:
        if (r3.equalsIgnoreCase(com.threatmetrix.TrustDefender.tqttqq.ttttqq.b006E006En006E006En) != false) goto L_0x0126;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01e0  */
    @javax.annotation.Nonnull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.String> b0071qq0071qq(@javax.annotation.Nonnull com.threatmetrix.TrustDefender.tqtqqt r17, @javax.annotation.Nullable java.util.List<java.lang.String> r18) throws java.lang.InterruptedException {
        /*
            r1 = r18
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            if (r1 == 0) goto L_0x033a
            boolean r0 = r18.isEmpty()
            if (r0 == 0) goto L_0x0011
            goto L_0x033a
        L_0x0011:
            com.threatmetrix.TrustDefender.qqqyqy r0 = com.threatmetrix.TrustDefender.qqqyqy.bg00670067g0067g()
            r3 = 0
            java.lang.String[] r4 = new java.lang.String[r3]
            java.lang.Object[] r4 = r1.toArray(r4)
            java.lang.String[] r4 = (java.lang.String[]) r4
            java.lang.String[] r4 = r0.bg006700670067gg(r4)
            java.lang.String r5 = com.threatmetrix.TrustDefender.tqttqq.ttttqq.b006E006E006En006En
            com.threatmetrix.TrustDefender.tqttqq$qtqttq r6 = new com.threatmetrix.TrustDefender.tqttqq$qtqttq
            com.threatmetrix.TrustDefender.tqttqq r0 = new com.threatmetrix.TrustDefender.tqttqq
            r0.<init>()
            r0.getClass()
            r7 = r17
            android.content.Context r7 = r7.bll006C006C006C006C
            r6.<init>(r7)
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r8 = 0
            r9 = 0
        L_0x003c:
            int r0 = r18.size()
            r11 = 66
            r12 = 2
            r13 = 3
            r14 = 1
            if (r8 >= r0) goto L_0x01ef
            java.lang.Object r0 = r1.get(r8)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Thread r15 = java.lang.Thread.currentThread()
            boolean r15 = r15.isInterrupted()
            if (r15 != 0) goto L_0x01e9
            r15 = 111(0x6f, float:1.56E-43)
            r3 = 150(0x96, float:2.1E-43)
            java.lang.String r10 = "_ac[/#\""
            java.lang.String r3 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.b0062bbbbbb(r10, r15, r3, r12)
            boolean r3 = r0.startsWith(r3)
            if (r3 == 0) goto L_0x00ab
            java.net.URI r3 = new java.net.URI     // Catch:{ URISyntaxException -> 0x009c }
            r3.<init>(r0)     // Catch:{ URISyntaxException -> 0x009c }
            java.lang.String r10 = r3.getScheme()     // Catch:{ URISyntaxException -> 0x009c }
            if (r10 == 0) goto L_0x007e
            java.io.File r10 = new java.io.File     // Catch:{ URISyntaxException -> 0x009c }
            r10.<init>(r3)     // Catch:{ URISyntaxException -> 0x009c }
            boolean r3 = r10.exists()     // Catch:{ URISyntaxException -> 0x009c }
        L_0x007b:
            r14 = r3
            goto L_0x01d8
        L_0x007e:
            java.lang.String r10 = bf0066f00660066f     // Catch:{ URISyntaxException -> 0x009c }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ URISyntaxException -> 0x009c }
            r12.<init>()     // Catch:{ URISyntaxException -> 0x009c }
            java.lang.String r13 = "b|\u0004\u0006}{6\n\u00043yv\u0005/\u0004x+}lplsj$itpm9\u001e"
            r15 = 240(0xf0, float:3.36E-43)
            java.lang.String r13 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r13, r15, r14)     // Catch:{ URISyntaxException -> 0x009c }
            r12.append(r13)     // Catch:{ URISyntaxException -> 0x009c }
            r12.append(r3)     // Catch:{ URISyntaxException -> 0x009c }
            java.lang.String r3 = r12.toString()     // Catch:{ URISyntaxException -> 0x009c }
            com.threatmetrix.TrustDefender.yyyyqy.qyyyqy.bt0074tttt(r10, r3)     // Catch:{ URISyntaxException -> 0x009c }
            goto L_0x01d7
        L_0x009c:
            r0 = move-exception
            java.lang.String r3 = bf0066f00660066f
            r10 = 4
            java.lang.String r12 = "0%1,6:6//k0643<qHFA"
            java.lang.String r10 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r12, r11, r10)
            com.threatmetrix.TrustDefender.yyyyqy.qyyyqy.b0074tt0074tt(r3, r10, r0)
            goto L_0x01e4
        L_0x00ab:
            r3 = 134(0x86, float:1.88E-43)
            r10 = 167(0xa7, float:2.34E-43)
            java.lang.String r11 = "$\u0012\u0019&mcd"
            java.lang.String r3 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.b0062bbbbbb(r11, r3, r10, r13)
            boolean r3 = r0.startsWith(r3)
            r10 = 7
            if (r3 == 0) goto L_0x00cd
            java.lang.String r3 = r0.substring(r10)
            if (r5 == 0) goto L_0x01d7
            boolean r10 = com.threatmetrix.TrustDefender.yqqyqq.b0069ii0069i0069(r3)
            if (r10 == 0) goto L_0x01d7
            boolean r3 = r5.contains(r3)
            goto L_0x007b
        L_0x00cd:
            java.lang.String r3 = "60+|po"
            r11 = 58
            java.lang.String r3 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r3, r11, r12)
            boolean r3 = r0.startsWith(r3)
            if (r3 == 0) goto L_0x00e8
            r3 = 6
            java.lang.String r3 = r0.substring(r3)
            int r10 = com.threatmetrix.TrustDefender.tqttqq.tqtqtq.bkkk006B006Bk
            boolean r14 = r6.bv00760076v0076v(r3, r10)
            goto L_0x01d8
        L_0x00e8:
            java.lang.String r3 = "'($$l`_"
            r15 = 109(0x6d, float:1.53E-43)
            java.lang.String r3 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r3, r15, r13)
            boolean r3 = r0.startsWith(r3)
            if (r3 == 0) goto L_0x01d7
            java.lang.String r3 = r0.substring(r10)
            java.lang.String r10 = "-\u000f"
            java.lang.String r10 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r10, r11, r13)
            java.lang.String[] r3 = r3.split(r10, r12)
            int r10 = r3.length
            if (r10 >= r12) goto L_0x0109
            goto L_0x01e4
        L_0x0109:
            r10 = 0
            r11 = r3[r10]
            r3 = r3[r14]
            r10 = 67
            r15 = 137(0x89, float:1.92E-43)
            java.lang.String r14 = "@>}3G<@9\u0004M=KMDKK\fBOEGQERK"
            java.lang.String r10 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.b0062bbbbbb(r14, r10, r15, r13)
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x0129
            java.lang.String r10 = com.threatmetrix.TrustDefender.tqttqq.ttttqq.qqqqtq.bn006En006En006E
            boolean r3 = r3.equalsIgnoreCase(r10)
            if (r3 == 0) goto L_0x01d7
        L_0x0126:
            r14 = 1
            goto L_0x01d8
        L_0x0129:
            r10 = 138(0x8a, float:1.93E-43)
            r14 = 27
            java.lang.String r15 = "\u0019\u0017V\f \u0015\u0019\u0012\\\u0014\u0012&\u0018a**\u001a"
            java.lang.String r10 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.b0062bbbbbb(r15, r10, r14, r13)
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x0146
            long r10 = com.threatmetrix.TrustDefender.tqttqq.ttttqq.b006En006En006En
            java.lang.String r10 = java.lang.String.valueOf(r10)
            boolean r3 = r3.equalsIgnoreCase(r10)
            if (r3 == 0) goto L_0x01d7
            goto L_0x0126
        L_0x0146:
            r10 = 107(0x6b, float:1.5E-43)
            java.lang.String r14 = "\u0007\u0003@s\u0006xzq:\u0004ym"
            java.lang.String r10 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r14, r10, r12)
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x015d
            java.lang.String r10 = com.threatmetrix.TrustDefender.tqttqq.ttttqq.bn006E006En006En
            boolean r3 = r3.equalsIgnoreCase(r10)
            if (r3 == 0) goto L_0x01d7
            goto L_0x0126
        L_0x015d:
            r10 = 236(0xec, float:3.31E-43)
            java.lang.String r14 = ")%b\u0016(\u001b\u001d\u0014\\\"\u000e\u0013\u001e"
            java.lang.String r10 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r14, r10, r13)
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x0174
            java.lang.String r10 = com.threatmetrix.TrustDefender.tqttqq.ttttqq.b006E006E006En006En
            boolean r3 = r3.equalsIgnoreCase(r10)
            if (r3 == 0) goto L_0x01d7
            goto L_0x0126
        L_0x0174:
            r10 = 39
            r14 = 210(0xd2, float:2.94E-43)
            java.lang.String r15 = "mk+`timf1lty{"
            java.lang.String r10 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.b0062bbbbbb(r15, r10, r14, r13)
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x018d
            java.lang.String r10 = com.threatmetrix.TrustDefender.tqttqq.ttttqq.bnnn006E006En
            boolean r3 = r3.equalsIgnoreCase(r10)
            if (r3 == 0) goto L_0x01d7
            goto L_0x0126
        L_0x018d:
            r10 = 90
            r13 = 29
            java.lang.String r14 = "0.m#7,0)s<;.<"
            r15 = 0
            java.lang.String r10 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.b0062bbbbbb(r14, r10, r13, r15)
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x01a8
            java.lang.String r10 = com.threatmetrix.TrustDefender.tqttqq.ttttqq.bn006En006E006En
            boolean r3 = r3.equalsIgnoreCase(r10)
            if (r3 == 0) goto L_0x01d7
            goto L_0x0126
        L_0x01a8:
            r10 = 74
            java.lang.String r13 = "($a\u0015'\u001a\u001c\u0013[\u0016\u0010"
            java.lang.String r10 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r13, r10, r12)
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x01c0
            java.lang.String r10 = com.threatmetrix.TrustDefender.tqttqq.ttttqq.b006E006En006E006En
            boolean r3 = r3.equalsIgnoreCase(r10)
            if (r3 == 0) goto L_0x01d7
            goto L_0x0126
        L_0x01c0:
            java.lang.Object r10 = r7.get(r11)
            java.util.Map r10 = (java.util.Map) r10
            if (r10 != 0) goto L_0x01d0
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            r7.put(r11, r10)
        L_0x01d0:
            r10.put(r3, r0)
            r14 = 0
            r16 = 1
            goto L_0x01da
        L_0x01d7:
            r14 = 0
        L_0x01d8:
            r16 = 0
        L_0x01da:
            if (r14 == 0) goto L_0x01e0
            r2.add(r0)
            goto L_0x01e4
        L_0x01e0:
            if (r16 != 0) goto L_0x01e4
            int r9 = r9 + 1
        L_0x01e4:
            int r8 = r8 + 1
            r3 = 0
            goto L_0x003c
        L_0x01e9:
            java.lang.InterruptedException r0 = new java.lang.InterruptedException
            r0.<init>()
            throw r0
        L_0x01ef:
            boolean r0 = r7.isEmpty()
            r3 = 5
            r5 = 143(0x8f, float:2.0E-43)
            if (r0 != 0) goto L_0x02a8
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            int r6 = com.threatmetrix.TrustDefender.tqttqq.ttttqq.qqqqtq.b006E006En006En006E
            int r8 = com.threatmetrix.TrustDefender.tqttqq.ttttqq.tqqqtq.bkk006Bkkk
            if (r6 >= r8) goto L_0x023c
            r6 = 72
            java.lang.String r8 = "\b>@B>SKT\u000fRUSU"
            java.lang.String r6 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.b0062bbbbbb(r8, r6, r5, r13)
            java.util.Set r8 = r7.keySet()
            r10 = 14
            r14 = 92
            java.lang.String r15 = "("
            java.lang.String r10 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.b0062bbbbbb(r15, r10, r14, r13)
            java.util.Map r6 = bq007100710071q0071(r6, r8, r10)
            r0.putAll(r6)
            r6 = 152(0x98, float:2.13E-43)
            java.lang.String r8 = "z@GBD6?\u00026J?C<\u0007JMKM"
            java.lang.String r6 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r8, r6, r3)
            java.util.Set r8 = r7.keySet()
            r10 = 250(0xfa, float:3.5E-43)
            java.lang.String r14 = "I"
            java.lang.String r10 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.b0062bbbbbb(r14, r10, r5, r13)
            java.util.Map r6 = bq007100710071q0071(r6, r8, r10)
            r0.putAll(r6)
        L_0x023c:
            java.util.Set r6 = r7.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0244:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x02a8
            java.lang.Object r7 = r6.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r8 = r7.getKey()
            java.lang.Object r8 = r0.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            if (r8 != 0) goto L_0x0266
            java.lang.Object r8 = r7.getKey()
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r8 = b00710071qqq0071(r8)
        L_0x0266:
            if (r8 == 0) goto L_0x0299
            java.lang.Object r10 = r7.getValue()
            java.util.Map r10 = (java.util.Map) r10
            java.lang.Object r8 = r10.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            if (r8 == 0) goto L_0x027b
            r2.add(r8)
            r10 = 1
            goto L_0x027c
        L_0x027b:
            r10 = 0
        L_0x027c:
            java.lang.Object r8 = r7.getValue()
            java.util.Map r8 = (java.util.Map) r8
            r14 = 73
            java.lang.String r15 = "\u0002}\u0002"
            r3 = 0
            java.lang.String r14 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r15, r14, r3)
            java.lang.Object r3 = r8.get(r14)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x029a
            int r10 = r10 + 1
            r2.add(r3)
            goto L_0x029a
        L_0x0299:
            r10 = 0
        L_0x029a:
            java.lang.Object r3 = r7.getValue()
            java.util.Map r3 = (java.util.Map) r3
            int r3 = r3.size()
            int r3 = r3 - r10
            int r9 = r9 + r3
            r3 = 5
            goto L_0x0244
        L_0x02a8:
            java.lang.String r0 = bf0066f00660066f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r6 = 75
            r7 = 249(0xf9, float:3.49E-43)
            java.lang.String r8 = "4)=-311m"
            java.lang.String r6 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.b0062bbbbbb(r8, r6, r7, r13)
            r3.append(r6)
            r3.append(r9)
            java.lang.String r6 = "\u0004"
            r7 = 109(0x6d, float:1.53E-43)
            r8 = 0
            java.lang.String r6 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.b0062bbbbbb(r6, r11, r7, r8)
            r3.append(r6)
            int r1 = r18.size()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.threatmetrix.TrustDefender.yyyyqy.bt0074007400740074t(r0, r1)
            if (r4 == 0) goto L_0x0301
            int r0 = r4.length
            if (r0 <= 0) goto L_0x0301
            int r0 = r4.length
            r3 = 0
        L_0x02e0:
            if (r3 >= r0) goto L_0x0301
            r1 = r4[r3]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r7 = 52
            java.lang.String r8 = "\u001d"
            java.lang.String r7 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.b0062bbbbbb(r8, r5, r7, r12)
            r6.append(r7)
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            r2.add(r1)
            int r3 = r3 + 1
            goto L_0x02e0
        L_0x0301:
            java.util.Collections.sort(r2)
            boolean r0 = r2.isEmpty()
            if (r0 != 0) goto L_0x033a
            boolean r0 = com.threatmetrix.TrustDefender.yyyyqy.b0074tttt0074()
            if (r0 == 0) goto L_0x033a
            java.lang.String r0 = bf0066f00660066f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r3 = 230(0xe6, float:3.22E-43)
            java.lang.String r4 = "\u001e(/) \\"
            r5 = 5
            java.lang.String r3 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r4, r3, r5)
            r1.append(r3)
            r3 = 181(0xb5, float:2.54E-43)
            java.lang.String r4 = "N"
            r5 = 1
            java.lang.String r3 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r4, r3, r5)
            java.lang.String r3 = com.threatmetrix.TrustDefender.yqqyqq.b00690069i0069i0069(r2, r3)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.threatmetrix.TrustDefender.yyyyqy.qyyyqy.bt0074tttt(r0, r1)
        L_0x033a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.yyqyyy.b0071qq0071qq(com.threatmetrix.TrustDefender.tqtqqt, java.util.List):java.util.List");
    }

    public static long b0071qqq00710071() {
        yyqyqq yyqyqq = new yyqyqq(Environment.getDataDirectory().getPath());
        return yyqyqq.bi00690069i0069i() * yyqyqq.b006900690069i0069i();
    }

    public static long b0071qqq0071q(String str) {
        if (str == null) {
            yyyyqy.qyyyqy.bt0074tttt(bf0066f00660066f, jkkjkk.bb0062bbbbb("8ag\u0014Vfg\u0018mcha\u001ddqon\"qyqr'xj~s", Typography.middleDot, 0));
            return 0;
        }
        long b0067ggg0067g = qqqyqy.bg00670067g0067g().b0067ggg0067g(str);
        String str2 = bf0066f00660066f;
        yyyyqy.qyyyqy.bt0074tttt(str2, jkkjkk.b0062bbbbbb("Dms brs$yotm)p}{z.]q\u0006{\ny\\w\f\u0001~\r\u0001\u000f=\u0005\u000f\u0013A\u0013\u0005\u0019\u000e`", 198, '5', 3) + str + jkkjkk.bb0062bbbbb("\f\u0001", 'J', 5) + b0067ggg0067g);
        return b0067ggg0067g;
    }

    @Nonnull
    public static List<String> b0071qqqq0071() {
        ArrayList arrayList = new ArrayList();
        File file = new File(jkkjkk.b0062bbbbbb("\u0010U\\WYKT\u0017OYY``\u001d", '3', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 0));
        String b0062bbbbbb = jkkjkk.b0062bbbbbb("-tuh", '9', 185, 0);
        String[] list = file.list();
        if (list == null) {
            return arrayList;
        }
        for (String str : list) {
            if (str != null && str.endsWith(b0062bbbbbb)) {
                StringBuilder sb = new StringBuilder(str);
                arrayList.add(sb.substring(0, sb.length() - 4));
            }
        }
        return arrayList;
    }

    public static String bq0071007100710071q() {
        return qtqqtt.byy007900790079y();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0066, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006f, code lost:
        throw r8;
     */
    @javax.annotation.Nonnull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> bq007100710071q0071(@javax.annotation.Nullable java.lang.String r6, @javax.annotation.Nullable java.util.Set<java.lang.String> r7, @javax.annotation.Nonnull java.lang.String r8) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            if (r6 == 0) goto L_0x0083
            if (r7 != 0) goto L_0x000b
            goto L_0x0083
        L_0x000b:
            java.io.File r1 = new java.io.File
            r1.<init>(r6)
            boolean r6 = r1.exists()
            if (r6 == 0) goto L_0x0083
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0070 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ IOException -> 0x0070 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0070 }
            r6.<init>(r2)     // Catch:{ IOException -> 0x0070 }
        L_0x0020:
            java.lang.String r1 = r6.readLine()     // Catch:{ all -> 0x0064 }
            if (r1 == 0) goto L_0x0060
            java.lang.String r2 = ""
            java.util.List r1 = com.threatmetrix.TrustDefender.yqqyqq.bi00690069i00690069(r1, r8)     // Catch:{ all -> 0x0064 }
            boolean r3 = r1.isEmpty()     // Catch:{ all -> 0x0064 }
            if (r3 == 0) goto L_0x0033
            goto L_0x0020
        L_0x0033:
            r3 = 0
            java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x0064 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0064 }
            java.lang.String r3 = r3.trim()     // Catch:{ all -> 0x0064 }
            int r4 = r3.length()     // Catch:{ all -> 0x0064 }
            if (r4 != 0) goto L_0x0045
            goto L_0x0020
        L_0x0045:
            boolean r4 = r7.contains(r3)     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x0020
            int r4 = r1.size()     // Catch:{ all -> 0x0064 }
            r5 = 1
            if (r4 <= r5) goto L_0x005c
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0064 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = r1.trim()     // Catch:{ all -> 0x0064 }
        L_0x005c:
            r0.put(r3, r2)     // Catch:{ all -> 0x0064 }
            goto L_0x0020
        L_0x0060:
            r6.close()     // Catch:{ IOException -> 0x0070 }
            goto L_0x0083
        L_0x0064:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r8 = move-exception
            r6.close()     // Catch:{ all -> 0x006b }
            goto L_0x006f
        L_0x006b:
            r6 = move-exception
            r7.addSuppressed(r6)     // Catch:{ IOException -> 0x0070 }
        L_0x006f:
            throw r8     // Catch:{ IOException -> 0x0070 }
        L_0x0070:
            r6 = move-exception
            java.lang.String r7 = bf0066f00660066f
            r8 = 255(0xff, float:3.57E-43)
            r1 = 4
            java.lang.String r2 = "hgw$ntmw)G+RNW[UU2\u000f\u0012"
            java.lang.String r8 = com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk.bb0062bbbbb(r2, r8, r1)
            java.lang.String r6 = r6.toString()
            com.threatmetrix.TrustDefender.yyyyqy.qyyyqy.b007400740074ttt(r7, r8, r6)
        L_0x0083:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.yyqyyy.bq007100710071q0071(java.lang.String, java.util.Set, java.lang.String):java.util.Map");
    }

    public static long bq007100710071qq(@Nonnull tqtqqt tqtqqt) throws InterruptedException {
        long b0071qqq0071q = b0071qqq0071q(tqtqqt.bll006C006C006C006C.getApplicationInfo().dataDir);
        return b0071qqq0071q != 0 ? b0071qqq0071q : b00710071007100710071q(tqtqqt);
    }

    public static boolean bq00710071q00710071(@Nonnull tqtqqt tqtqqt) {
        String bv0076v00760076v = tqttqq.qqtttq.bv0076v00760076v(tqtqqt.bll006C006C006C006C.getContentResolver(), jkkjkk.b0062bbbbbb("\u0007\bz\u0002t\u0001\u0003ur\u0005x}{", 24, 205, 2));
        return bv0076v00760076v != null && bv0076v00760076v.equals(jkkjkk.b0062bbbbbb("\u0012", 'f', 248, 3));
    }

    public static String bq00710071q0071q(@Nonnull tqtqqt tqtqqt) {
        if (!tqttqq.qqqqqt.bvvv007600760076()) {
            return null;
        }
        try {
            Object systemService = tqtqqt.bll006C006C006C006C.getApplicationContext().getSystemService(jkkjkk.bb0062bbbbb("^U[YO", 6, 3));
            if (!(systemService instanceof TelephonyManager)) {
                return null;
            }
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            HashMap hashMap = new HashMap();
            try {
                String networkOperator = telephonyManager.getNetworkOperator();
                String networkCountryIso = telephonyManager.getNetworkCountryIso();
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (networkOperator != null) {
                    if (!"".equals(networkOperator.trim())) {
                        hashMap.put(jkkjkk.bb0062bbbbb("?A", 'P', 4), networkOperator);
                    }
                }
                if (networkOperatorName != null && !"".equals(networkOperatorName.trim())) {
                    hashMap.put(jkkjkk.bb0062bbbbb("BB@", 149, 1), networkOperatorName);
                }
                if (networkCountryIso != null && !"".equals(networkCountryIso.trim())) {
                    hashMap.put(jkkjkk.bb0062bbbbb("%\u0019\u0014\u001d&!", 227, 1), networkCountryIso);
                }
            } catch (SecurityException e) {
                String str = bf0066f00660066f;
                yyyyqy.qyyyqy.bt0074tttt(str, jkkjkk.b0062bbbbbb("}\u001d\u0010\u001eL \u0014\u0016&%\u0018S\u001c(\u0018&-#)#\\.$2.+67.55g", 180, CharUtils.f7473CR, 0) + e.toString());
                qqqtqt.byyyy0079y(e);
            } catch (Exception e2) {
                yyyyqy.qyyyqy.bt00740074ttt(bf0066f00660066f, e2.toString());
            }
            tqttqq tqttqq = new tqttqq();
            tqttqq.getClass();
            tqttqq.qtqttq qtqttq = new tqttqq.qtqttq(tqtqqt.bll006C006C006C006C);
            boolean b0076v0076v0076v = qtqttq.b0076v0076v0076v(jkkjkk.b0062bbbbbb("FRGTPIC\fMAMGBKJ?DB\u0001\u0013\u0014\u0013\u0014! +\u0011\u0013\u0017\r&\u0012\u0014\u0007\u0004\u0016\n\u000f\r", 159, 5, 1), tqtqqt.bll006C006C006C006C.getPackageName());
            boolean b0076v0076v0076v2 = qtqttq.b0076v0076v0076v(jkkjkk.bb0062bbbbb(">LCRPKG\u0012UKYUR]^U\\\\\u001d1458GHU:G:LNA\\JNCBVLSS", IOUtils.DIR_SEPARATOR_WINDOWS, 4), tqtqqt.bll006C006C006C006C.getPackageName());
            if (!b0076v0076v0076v && !b0076v0076v0076v2) {
                return b007100710071qqq(hashMap);
            }
            if (b0076v0076v0076v) {
                b0071qq00710071q(tqtqqt.bll006C006C006C006C, telephonyManager, hashMap);
            }
            b0071qq0071q0071(telephonyManager, hashMap);
            return b007100710071qqq(hashMap);
        } catch (SecurityException e3) {
            String str2 = bf0066f00660066f;
            yyyyqy.qyyyqy.bt0074tttt(str2, jkkjkk.bb0062bbbbb("x\u0016\u0007\u0013?\u0011\u0003\u0003\u0011\u000e~8~\tv\u0003\b{w/~r~xs|{pus$", 'I', 3) + e3.toString());
            qqqtqt.byyyy0079y(e3);
            return null;
        } catch (Exception e4) {
            yyyyqy.qyyyqy.bt00740074ttt(bf0066f00660066f, e4.toString());
            return null;
        }
    }

    @Nonnull
    public static String bq00710071qq0071() {
        HashSet hashSet = new HashSet();
        jkkjkk.bb0062bbbbb("[t}e\u0002\bu\u0002", Typography.registered, 5);
        Collections.addAll(hashSet, new String[]{jkkjkk.b0062bbbbbb("j\u0004\rt\u0011\u0017\u0005\u0011", 142, 240, 0)});
        Map<String, String> bq007100710071q0071 = bq007100710071q0071(jkkjkk.bb0062bbbbb("p12.!k) '\"&\u001d%", '?', 3), hashSet, jkkjkk.b0062bbbbbb("f", 'G', 'd', 3));
        yyyyqy.bt0074007400740074t(bf0066f00660066f, jkkjkk.bb0062bbbbb("\u0012\u0019\u0016", 14, 5));
        String str = bf0066f00660066f;
        yyyyqy.qyyyqy.bt0074tttt(str, jkkjkk.b0062bbbbbb("VSa9PW2VMU\u0005VHVVRMCA\u0016z", 213, 185, 2) + bq007100710071q0071);
        String str2 = bq007100710071q0071.get(jkkjkk.b0062bbbbbb(" 9B*FL:F", 139, 197, 3));
        return str2 == null ? "" : str2;
    }

    public static String bq0071q00710071q(@Nonnull tqtqqt tqtqqt) {
        return tqttqq.qqtttq.b0076vv00760076v(tqtqqt.bll006C006C006C006C.getContentResolver(), jkkjkk.b0062bbbbbb("\u0005\u0005\u0015\u0003\t\u000b\u000b\u0007}\u0006\u000bt\bx\u0007\u0006y}u\u0001kpxjjski", 222, 254, 1));
    }

    @Nonnull
    public static yqyqqy bq0071q0071q0071(@Nonnull tqtqqt tqtqqt) throws InterruptedException {
        return qyqqqy.bx0078x0078xx(tqtqqt.bll006C006C006C006C);
    }

    public static jkjjkj.GenericLocation bq0071q0071qq(@Nullable Location location, boolean z) {
        Float f = null;
        if (location == null) {
            return null;
        }
        boolean b0074ttttt = qqqqyy.b0074ttttt(location);
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        if (location.hasAccuracy()) {
            f = Float.valueOf(location.getAccuracy());
        }
        return new jkjjkj.GenericLocation(latitude, longitude, f, b0074ttttt, z);
    }

    public static String bq0071qq00710071(@Nonnull tqtqqt tqtqqt) {
        return String.valueOf((new tqttqq.qtttqq(tqtqqt).b0075u00750075u0075() & 2) != 0);
    }

    public static Map<String, Object> bq0071qq0071q(tqtqqt tqtqqt) {
        String str;
        char c;
        String str2;
        HashMap hashMap = new HashMap(2);
        Intent intent = null;
        try {
            intent = tqtqqt.bll006C006C006C006C.registerReceiver((BroadcastReceiver) null, new IntentFilter(jkkjkk.b0062bbbbbb("O]Tca\\X#_el^ho*^asipp1FFZ[M[cjOUO]WVV", 'B', 170, 3)));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
        if (intent == null) {
            return hashMap;
        }
        int intExtra = intent.getIntExtra(jkkjkk.bb0062bbbbb("BB.@@=", '1', 2), -1);
        if (intExtra != 2) {
            if (intExtra == 3 || intExtra == 4) {
                c = 'E';
                str2 = "0()$,\u001d\u001c\u0019\u0017";
            } else if (intExtra != 5) {
                str = jkkjkk.b0062bbbbbb("\u0013\r\u000b\u000f\u0011\u001a\u0012", 179, 'h', 3);
            } else {
                c = 181;
                str2 = "0>43";
            }
            str = jkkjkk.bb0062bbbbb(str2, c, 2);
        } else {
            str = jkkjkk.bb0062bbbbb("#)#5+.4.", 21, 5);
        }
        int intExtra2 = intent.getIntExtra(jkkjkk.b0062bbbbbb("\u0019\u0013%\u0015\u001d", Typography.amp, 133, 3), -1);
        int intExtra3 = intent.getIntExtra(jkkjkk.bb0062bbbbb("^ONZT", 233, 4), 100);
        if (intExtra3 <= 0) {
            hashMap.put(jkkjkk.b0062bbbbbb("\u001a\u0014&\u0016\u001e", 221, 205, 3), jkkjkk.bb0062bbbbb("pjhlnwo", '=', 0));
        } else {
            hashMap.put(jkkjkk.bb0062bbbbb("f`rbj", 252, 5), Float.valueOf(((float) intExtra2) / ((float) intExtra3)));
        }
        hashMap.put(jkkjkk.bb0062bbbbb("13!576", 'i', 5), str);
        return hashMap;
    }

    public static long bq0071qqq0071() {
        yyqyqq yyqyqq = new yyqyqq(Environment.getDataDirectory().getPath());
        long b0069i0069i0069i = yyqyqq.b0069i0069i0069i();
        long b006900690069i0069i = yyqyqq.b006900690069i0069i();
        long j = 0;
        if (!(b0069i0069i0069i == 0 || b006900690069i0069i == 0)) {
            j = ((((b0069i0069i0069i * b006900690069i0069i) >> 20) << 20) / 10) * 10;
        }
        yyyyqy.bt0074007400740074t(bf0066f00660066f, jkkjkk.bb0062bbbbb("oo}", 172, 5));
        String str = bf0066f00660066f;
        yyyyqy.qyyyqy.bt0074tttt(str, jkkjkk.b0062bbbbbb("\u000f<01lA?147rCCuK@>yKDLLD", 239, 214, 3) + j);
        return j;
    }

    @Nullable
    public static String bqq007100710071q(@Nonnull tqtqqt tqtqqt) throws InterruptedException {
        yyyyqy.qyyyqy.bt0074tttt(bf0066f00660066f, jkkjkk.b0062bbbbbb("/,:\t)9+$%\u0005'+# ,)* $)[[", 159, 151, 2));
        StringBuilder sb = new StringBuilder();
        if (Thread.currentThread().isInterrupted()) {
            return "";
        }
        try {
            Object systemService = tqtqqt.bll006C006C006C006C.getApplicationContext().getSystemService(jkkjkk.bb0062bbbbb("VMSQG", 178, 3));
            if (!(systemService instanceof TelephonyManager)) {
                return "";
            }
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            String bb0062bbbbb = jkkjkk.bb0062bbbbb("k\u0006\u0004\b\n\u0013\u000b", 138, 0);
            if (telephonyManager.getPhoneType() == 1) {
                bb0062bbbbb = telephonyManager.getNetworkOperatorName();
            }
            sb.append(bb0062bbbbb);
            sb.append(telephonyManager.getSimCountryIso());
            sb.append(((((float) b0071qqq00710071()) / 1024.0f) / 1024.0f) / 1024.0f);
            ttttqt ttttqt = new ttttqt(tqtqqt);
            int b0079yy00790079y = ttttqt.b0079yy00790079y();
            int b007900790079y0079y = ttttqt.b007900790079y0079y();
            if (b0079yy00790079y >= b007900790079y0079y) {
                sb.append(b0079yy00790079y);
                sb.append(jkkjkk.b0062bbbbbb("\u0006", 11, 24, 1));
                sb.append(b007900790079y0079y);
            } else {
                sb.append(b007900790079y0079y);
                sb.append(jkkjkk.b0062bbbbbb("J", 1, 172, 2));
                sb.append(b0079yy00790079y);
            }
            yyyyqy.qyyyqy.bt0074tttt(bf0066f00660066f, jkkjkk.bb0062bbbbb("@]gfbf^\u0016\\Yg5AE8\\S[", 130, 2));
            sb.append(bqq0071q0071q());
            yyyyqy.qyyyqy.bt0074tttt(bf0066f00660066f, jkkjkk.bb0062bbbbb("%BLKGKCzA>L$;B\u001dA8@", 142, 1));
            sb.append(bq00710071qq0071());
            sb.append(tqttqq.ttttqq.b006En006E006E006En);
            sb.append(jkkjkk.b0062bbbbbb("k", Typography.plusMinus, 252, 1));
            sb.append(tqttqq.ttttqq.bn006E006E006E006En);
            sb.append(jkkjkk.bb0062bbbbb("4", 10, 0));
            sb.append(tqttqq.ttttqq.bnnnnn006E);
            sb.append(jkkjkk.bb0062bbbbb("b", 22, 5));
            sb.append(tqttqq.ttttqq.b006Ennnn006E);
            sb.append(jkkjkk.bb0062bbbbb("`", 159, 0));
            sb.append(tqttqq.ttttqq.qqqqtq.b006Enn006En006E);
            String str = bf0066f00660066f;
            yyyyqy.qyyyqy.bt0074tttt(str, jkkjkk.b0062bbbbbb("CBR#EWKFI+OUON\\[^V\\c\u0010cWgigd\\\\3\u001ac]pf'", 17, 'J', 3) + sb.toString() + jkkjkk.bb0062bbbbb("'", 128, 1));
            return yqqyqq.b0069i00690069i0069(sb.toString());
        } catch (SecurityException e) {
            String str2 = bf0066f00660066f;
            yyyyqy.qyyyqy.bt0074tttt(str2, jkkjkk.bb0062bbbbb("\u00198+9g;/1A@3n7C3AH>D>wI?MIFQRIPP\u0003", 'C', 4) + e.toString());
            qqqtqt.byyyy0079y(e);
            return "";
        } catch (Exception e2) {
            yyyyqy.qyyyqy.bt00740074ttt(bf0066f00660066f, e2.toString());
            return "";
        }
    }

    public static qyqqyq bqq00710071q0071() throws InterruptedException {
        qyqqyq bgg006700670067g = qqqyqy.bg00670067g0067g().bgg006700670067g();
        return bgg006700670067g != null ? bgg006700670067g : yyqqyq.b006900690069iii();
    }

    public static String bqq00710071qq(@Nonnull tqtqqt tqtqqt) {
        return tqttqq.qqtttq.b0076vv00760076v(tqtqqt.bll006C006C006C006C.getContentResolver(), jkkjkk.bb0062bbbbb("gkjhoymoztt", 129, 5));
    }

    public static boolean bqq0071q00710071(tqtqqt tqtqqt) {
        return qttqtt.byy00790079y0079(tqtqqt.bll006C006C006C006C);
    }

    @Nonnull
    public static String bqq0071q0071q() {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new String[]{jkkjkk.bb0062bbbbb("\u001697,/>?<@", 23, 5), jkkjkk.b0062bbbbbb("c}\u0010\u0003\u0017\u0002\u0014\b", Typography.half, Typography.cent, 0), jkkjkk.b0062bbbbbb("|\u000e\u001a\u0010\u0007\u0011", 'u', 158, 1)});
        Map<String, String> bq007100710071q0071 = bq007100710071q0071(jkkjkk.b0062bbbbbb("0pqm`+^jnae\\d", 226, 27, 2), new HashSet(arrayList), jkkjkk.bb0062bbbbb(ParamKeys.SIGN_AND, 'k', 4));
        yyyyqy.bt0074007400740074t(bf0066f00660066f, jkkjkk.bb0062bbbbb("0+0", 'g', 3));
        String str = bf0066f00660066f;
        yyyyqy.qyyyqy.bt0074tttt(str, jkkjkk.bb0062bbbbb("21A\u0011\u001f%\u001a@9CtH<LNLIAA\u0018~", 164, 0) + bq007100710071q0071);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = bq007100710071q0071.get((String) it.next());
            if (str2 != null) {
                sb.append(str2);
                sb.append(jkkjkk.bb0062bbbbb("", 'i', 0));
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.lastIndexOf(jkkjkk.bb0062bbbbb(StringUtils.f7475CR, 175, 0)));
        }
        return sb.toString().trim();
    }

    public static String bqq0071qq0071() {
        Locale locale = Locale.getDefault();
        StringBuilder sb = new StringBuilder();
        String language = locale.getLanguage();
        if (language != null) {
            sb.append(language);
            String country = locale.getCountry();
            if (country != null) {
                sb.append(jkkjkk.b0062bbbbbb("\u0006", 'j', 145, 0));
                sb.append(country);
            }
        }
        return sb.toString();
    }

    public static String bqqq007100710071() {
        try {
            return String.valueOf(((Boolean) Class.forName(wvvvvv.b006Ennn006E006En("st\u0002}vp9y|6Kkgyj", 'y', 3)).getMethod(wvvvvv.b006Ennn006E006En("/:\f.,@343A\u0013@@A98J<<", 225, 0), new Class[0]).invoke((Object) null, new Object[0])).booleanValue());
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }

    public static int bqqq00710071q() {
        int bgg0067g0067g = qqqyqy.bg00670067g0067g().bgg0067g0067g();
        return bgg0067g0067g <= 0 ? Runtime.getRuntime().availableProcessors() : bgg0067g0067g;
    }

    @Nonnull
    public static jkjjkj.kkjjkj bqqq0071q0071() {
        return yqyyqq.b00690069ii0069i();
    }

    @Nullable
    public static String bqqq0071qq() {
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        if (stackTrace.length > 0) {
            String className = stackTrace[stackTrace.length - 1].getClassName();
            if (!className.equals(jkkjkk.b0062bbbbbb("GRO\u000fAMBOKD>\u0007AEJ:FA3=}>Az&D18<,\u000f3-7", Typography.registered, 235, 2)) && !className.equals(jkkjkk.b0062bbbbbb("\u0005\u0003\u000f\u001a\u000e\u0011T\u001b\"\u001d\u001f\u0011\u001a[|\u0011%\u001b)\u0019\b*\u0018*-", Typography.section, 135, 0))) {
                int lastIndexOf = className.lastIndexOf(jkkjkk.b0062bbbbbb("Z", 'e', 18, 1));
                return lastIndexOf != -1 ? className.substring(lastIndexOf + 1) : className;
            }
        }
        return null;
    }

    public static boolean bqqqq00710071(@Nullable yyyqyy yyyqyy2) {
        if (yyyqyy2 != null) {
            TimeZone timeZone = TimeZone.getDefault();
            if (timeZone != null) {
                yyyqyy2.b00660066ff00660066 = timeZone.getRawOffset() / 60000;
                yyyqyy2.bff0066f00660066 = timeZone.getDSTSavings() / 60000;
                yyyyqy.bt0074007400740074t(bf0066f00660066f, jkkjkk.b0062bbbbbb("YejX", 28, 'q', 2));
                String str = bf0066f00660066f;
                yyyyqy.qyyyqy.bt0074tttt(str, jkkjkk.bb0062bbbbb("KJZ;QVOE[[S8^Wa-\u0014Yik<b`a9", '!', 5) + yyyqyy2.bff0066f00660066 + jkkjkk.bb0062bbbbb("2x}u]sr~o}E", 245, 1) + yyyqyy2.b00660066ff00660066);
                return true;
            }
            yyyyqy.qyyyqy.b00740074tt0074t(bf0066f00660066f, jkkjkk.b0062bbbbbb("[ZjKaf_UkkcHngq=$KGPTNN", 138, 23, 0));
            return false;
        }
        throw new IllegalArgumentException(jkkjkk.bb0062bbbbb("\u0004\u000bZ\u0001y\u00045yx\u0007\b\n\u0010<\u0004?\u000f\u0017\u000f\u0010", 142, 4));
    }

    public static String bqqqq0071q(tqtqqt tqtqqt) {
        jkkjkk.b0062bbbbbb("6", 5, 240, 2);
        String b0075007500750075u0075 = new tqttqq.qtttqq(tqtqqt).b0075007500750075u0075();
        tqttqq tqttqq = new tqttqq();
        tqttqq.getClass();
        tqttqq.tqqttq tqqttq = new tqttqq.tqqttq(tqtqqt.bll006C006C006C006C, b0075007500750075u0075, tqttqq.tqtqtq.b006Bkk006B006Bk);
        int bv0076vv0076v = tqqttq.bv0076vv0076v();
        String b00760076vv0076v = tqqttq.b00760076vv0076v();
        StringBuilder sb = new StringBuilder();
        sb.append(b0075007500750075u0075);
        sb.append(jkkjkk.bb0062bbbbb("e", 170, 4));
        if (b00760076vv0076v == null) {
            b00760076vv0076v = jkkjkk.bb0062bbbbb(Const.joLeft, 26, 5);
        }
        sb.append(b00760076vv0076v);
        sb.append(jkkjkk.b0062bbbbbb(SameLayerRenderingUtil.KEY_COMP_Y, 'E', 'z', 2));
        sb.append(bv0076vv0076v == -1 ? jkkjkk.bb0062bbbbb(RavenKey.VERSION, 18, 3) : Integer.valueOf(bv0076vv0076v));
        String bg0067gg0067g = qqqyqy.bg00670067g0067g().bg0067gg0067g();
        sb.append(jkkjkk.bb0062bbbbb("H", 134, 0));
        if (bg0067gg0067g == null) {
            bg0067gg0067g = jkkjkk.bb0062bbbbb(RavenKey.TYPE, '8', 2);
        }
        sb.append(bg0067gg0067g);
        yyyyqy.bt0074007400740074t(bf0066f00660066f, jkkjkk.bb0062bbbbb("x\u0005\f", 'g', 2));
        String str = bf0066f00660066f;
        yyyyqy.qyyyqy.bt0074tttt(str, jkkjkk.b0062bbbbbb("\"RSPNIH\\RYY\f6\\U_\u0011", 193, 224, 0) + sb.toString());
        return sb.toString();
    }

    @Nullable
    public static String bqqqqq0071(@Nonnull StringBuilder sb) throws InterruptedException {
        if (qqqyqy.bg00670067g0067g().b00670067ggg0067()) {
            List<String> b0067g0067g0067g = qqqyqy.bg00670067g0067g().b0067g0067g0067g(jkkjkk.bb0062bbbbb("\u001b^c\\\\LS\u0014JRPUS", 147, 2));
            if (b0067g0067g0067g == null || b0067g0067g0067g.isEmpty() || b0067g0067g0067g.size() != 2) {
                return null;
            }
            String str = b0067g0067g0067g.get(0);
            sb.append(b0067g0067g0067g.get(1));
            return str;
        }
        List<String> b0071qqqq0071 = b0071qqqq0071();
        StringBuilder sb2 = new StringBuilder();
        for (String append : b0071qqqq0071) {
            sb2.append(append);
        }
        sb.append(b0071qqqq0071.size());
        return yqqyqq.b0069i00690069i0069(sb2.toString());
    }
}
