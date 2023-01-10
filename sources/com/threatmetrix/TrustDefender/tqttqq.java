package com.threatmetrix.TrustDefender;

import android.app.admin.DevicePolicyManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.SparseIntArray;
import androidx.exifinterface.media.ExifInterface;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.onehotpatch.openapi.HotpatchStateConst;
import com.didiglobal.enginecore.data.parser.XEParseConst;
import com.threatmetrix.TrustDefender.kkjkjk;
import com.threatmetrix.TrustDefender.yyyyqy;
import global.didi.pay.newview.pix.IPixView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class tqttqq {
    private static final String b006E006Enn006En = "getInstance";
    /* access modifiers changed from: private */
    public static final String b006Ennn006En = yyyyqy.b0074t007400740074t(tqttqq.class);
    private static final String bn006Enn006En = "User refuse granting permission ";

    public static class qqqqqt {
        @Nullable
        private static final Class<?> b006C006C006C006C006Cl = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.SUBSCRIPTION_INFO);
        private static final boolean b006C006C006Cll006C;
        @Nullable
        private static final Class<?> b006C006Cl006C006Cl = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.TELEPHONY_MANAGER);
        private static final boolean b006C006Clll006C = bv007600760076v0076(kkjkjk.jjkkjk.CELL_INFO_CDMA, kkjkjk.jjkkjk.CELL_IDENTITY_CDMA);
        @Nullable
        private static final Class<?> b006Cl006C006C006Cl = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.CELL_SIGNAL_STRENGTH);
        private static final boolean b006Cl006Cll006C = bv007600760076v0076(kkjkjk.jjkkjk.CELL_INFO_LTE, kkjkjk.jjkkjk.CELL_IDENTITY_LTE);
        @Nullable
        private static final Class<?> b006Cllll006C = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.CDMA_CELL_LOCATION);
        @Nullable
        private static final Class<?> bl006C006C006C006Cl = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.NEIGHBOR_CELL_INFO);
        private static final boolean bl006C006Cll006C = bv007600760076v0076(kkjkjk.jjkkjk.CELL_INFO_WCDMA, kkjkjk.jjkkjk.CELL_IDENTITY_WCDMA);
        @Nullable
        private static final Class<?> bl006Clll006C = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.GSM_CELL_LOCATION);
        @Nullable
        private static final Class<?> bll006C006C006Cl = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.CELL_INFO);
        private static final boolean bll006Cll006C = bv007600760076v0076(kkjkjk.jjkkjk.CELL_INFO_GSM, kkjkjk.jjkkjk.CELL_IDENTITY_GSM);
        @Nullable
        private static final Class<?> blllll006C = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.SUBSCRIPTION_MANAGER);

        static {
            boolean z = false;
            if (!(kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.CELL_LOCATION) == null || kkjkjk.b00730073ss007300730073(b006C006Cl006C006Cl, "getCellLocation", new Class[0]) == null)) {
                z = true;
            }
            b006C006C006Cll006C = z;
        }

        private qqqqqt() {
        }

        public static boolean b0076007600760076v0076() {
            return b006C006Clll006C;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
            r0 = b006C006C006C006C006Cl;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean b007600760076v00760076() {
            /*
                java.lang.Class<?> r0 = blllll006C
                r1 = 0
                if (r0 == 0) goto L_0x0068
                java.lang.Class<?> r0 = b006C006C006C006C006Cl
                if (r0 == 0) goto L_0x0068
                java.lang.Class[] r2 = new java.lang.Class[r1]
                java.lang.String r3 = "getSimSlotIndex"
                java.lang.reflect.Method r0 = com.threatmetrix.TrustDefender.kkjkjk.b00730073ss007300730073(r0, r3, r2)
                if (r0 == 0) goto L_0x0068
                java.lang.Class<?> r0 = b006C006C006C006C006Cl
                java.lang.Class[] r2 = new java.lang.Class[r1]
                java.lang.String r3 = "getCarrierName"
                java.lang.reflect.Method r0 = com.threatmetrix.TrustDefender.kkjkjk.b00730073ss007300730073(r0, r3, r2)
                if (r0 == 0) goto L_0x0068
                java.lang.Class<?> r0 = b006C006C006C006C006Cl
                java.lang.Class[] r2 = new java.lang.Class[r1]
                java.lang.String r3 = "getDisplayName"
                java.lang.reflect.Method r0 = com.threatmetrix.TrustDefender.kkjkjk.b00730073ss007300730073(r0, r3, r2)
                if (r0 == 0) goto L_0x0068
                java.lang.Class<?> r0 = b006C006C006C006C006Cl
                java.lang.Class[] r2 = new java.lang.Class[r1]
                java.lang.String r3 = "getIccId"
                java.lang.reflect.Method r0 = com.threatmetrix.TrustDefender.kkjkjk.b00730073ss007300730073(r0, r3, r2)
                if (r0 == 0) goto L_0x0068
                java.lang.Class<?> r0 = b006C006C006C006C006Cl
                java.lang.Class[] r2 = new java.lang.Class[r1]
                java.lang.String r3 = "getNumber"
                java.lang.reflect.Method r0 = com.threatmetrix.TrustDefender.kkjkjk.b00730073ss007300730073(r0, r3, r2)
                if (r0 == 0) goto L_0x0068
                java.lang.Class<?> r0 = b006C006C006C006C006Cl
                java.lang.Class[] r2 = new java.lang.Class[r1]
                java.lang.String r3 = "getCountryIso"
                java.lang.reflect.Method r0 = com.threatmetrix.TrustDefender.kkjkjk.b00730073ss007300730073(r0, r3, r2)
                if (r0 == 0) goto L_0x0068
                java.lang.Class<?> r0 = b006C006C006C006C006Cl
                java.lang.Class[] r2 = new java.lang.Class[r1]
                java.lang.String r3 = "getDataRoaming"
                java.lang.reflect.Method r0 = com.threatmetrix.TrustDefender.kkjkjk.b00730073ss007300730073(r0, r3, r2)
                if (r0 == 0) goto L_0x0068
                java.lang.Class<?> r0 = blllll006C
                java.lang.Class[] r2 = new java.lang.Class[r1]
                java.lang.String r3 = "getActiveSubscriptionInfoList"
                java.lang.reflect.Method r0 = com.threatmetrix.TrustDefender.kkjkjk.b00730073ss007300730073(r0, r3, r2)
                if (r0 == 0) goto L_0x0068
                r1 = 1
            L_0x0068:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.tqttqq.qqqqqt.b007600760076v00760076():boolean");
        }

        public static boolean b00760076vv00760076() {
            return (!b006C006C006Cll006C || kkjkjk.b00730073ss007300730073(b006Cllll006C, "getSystemId", new Class[0]) == null || kkjkjk.b00730073ss007300730073(b006Cllll006C, "getBaseStationId", new Class[0]) == null || kkjkjk.b00730073ss007300730073(b006Cllll006C, "getBaseStationLatitude", new Class[0]) == null || kkjkjk.b00730073ss007300730073(b006Cllll006C, "getBaseStationLongitude", new Class[0]) == null) ? false : true;
        }

        public static boolean b0076v0076v00760076() {
            Class<?> cls = b006C006Cl006C006Cl;
            return (cls == null || kkjkjk.b00730073ss007300730073(cls, "getDataState", new Class[0]) == null || kkjkjk.b0073s00730073s00730073(b006C006Cl006C006Cl, "DATA_CONNECTED") == null || kkjkjk.b0073s00730073s00730073(b006C006Cl006C006Cl, "DATA_CONNECTING") == null || kkjkjk.b0073s00730073s00730073(b006C006Cl006C006Cl, "DATA_SUSPENDED") == null) ? false : true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0009, code lost:
            r0 = bll006C006C006Cl;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean b0076vv007600760076() {
            /*
                java.lang.Class<?> r0 = b006C006Cl006C006Cl
                r1 = 0
                if (r0 == 0) goto L_0x0024
                java.lang.Class<?> r0 = b006Cl006C006C006Cl
                if (r0 == 0) goto L_0x0024
                java.lang.Class<?> r0 = bll006C006C006Cl
                if (r0 == 0) goto L_0x0024
                java.lang.Class[] r2 = new java.lang.Class[r1]
                java.lang.String r3 = "isRegistered"
                java.lang.reflect.Method r0 = com.threatmetrix.TrustDefender.kkjkjk.b00730073ss007300730073(r0, r3, r2)
                if (r0 == 0) goto L_0x0024
                java.lang.Class<?> r0 = b006C006Cl006C006Cl
                java.lang.Class[] r2 = new java.lang.Class[r1]
                java.lang.String r3 = "getAllCellInfo"
                java.lang.reflect.Method r0 = com.threatmetrix.TrustDefender.kkjkjk.b00730073ss007300730073(r0, r3, r2)
                if (r0 == 0) goto L_0x0024
                r1 = 1
            L_0x0024:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.tqttqq.qqqqqt.b0076vv007600760076():boolean");
        }

        public static boolean b0076vvv00760076() {
            return b006Cl006Cll006C;
        }

        private static boolean bv007600760076v0076(@Nonnull kkjkjk.jjkkjk jjkkjk, @Nonnull kkjkjk.jjkkjk jjkkjk2) {
            Class b00730073s0073s00730073 = kkjkjk.b00730073s0073s00730073(jjkkjk);
            return (kkjkjk.b00730073s0073s00730073(jjkkjk2) == null || kkjkjk.bss00730073s00730073(b00730073s0073s00730073, "getCellSignalStrength", new Class[0]) == null || kkjkjk.bss00730073s00730073(b00730073s0073s00730073, "getCellIdentity", new Class[0]) == null) ? false : true;
        }

        public static boolean bv00760076v00760076() {
            Class<?> cls = bl006C006C006C006Cl;
            return (cls == null || kkjkjk.b00730073ss007300730073(cls, "getCid", new Class[0]) == null || kkjkjk.b00730073ss007300730073(bl006C006C006C006Cl, "getRssi", new Class[0]) == null) ? false : true;
        }

        public static boolean bv0076vv00760076() {
            return bl006C006Cll006C;
        }

        public static boolean bvv0076v00760076() {
            return (!b006C006C006Cll006C || kkjkjk.b00730073ss007300730073(bl006Clll006C, "getCid", new Class[0]) == null || kkjkjk.b00730073ss007300730073(bl006Clll006C, "getLac", new Class[0]) == null || kkjkjk.b00730073ss007300730073(bl006Clll006C, "getPsc", new Class[0]) == null) ? false : true;
        }

        public static boolean bvvv007600760076() {
            Class<?> cls = b006C006Cl006C006Cl;
            return (cls == null || kkjkjk.b00730073ss007300730073(cls, "getNetworkOperator", new Class[0]) == null || kkjkjk.b00730073ss007300730073(b006C006Cl006C006Cl, "getNetworkCountryIso", new Class[0]) == null || kkjkjk.bss00730073s00730073(b006C006Cl006C006Cl, "getNetworkOperatorName", new Class[0]) == null) ? false : true;
        }

        public static boolean bvvvv00760076() {
            return bll006Cll006C;
        }
    }

    public static class qqqttq {
        private static final boolean b006B006Bkk006B006B;
        private static final boolean b006Bk006Bk006B006B;
        private static final boolean b006Bkkk006B006B;
        private static final boolean bk006B006Bk006B006B;
        private static final boolean bk006Bkk006B006B;
        private static final boolean bkk006Bk006B006B;

        static {
            Class b00730073s0073s00730073 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.CONNECTIVITY_MANAGER);
            Class b00730073s0073s007300732 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.NETWORK_INFO);
            Class b00730073s0073s007300733 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.WIFI_INFO);
            Class b00730073s0073s007300734 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.WIFI_MANAGER);
            Class b00730073s0073s007300735 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.STATE);
            boolean z = kkjkjk.b00730073ss007300730073(b00730073s0073s00730073, "getActiveNetworkInfo", new Class[0]) != null;
            boolean z2 = kkjkjk.b00730073ss007300730073(b00730073s0073s007300732, "getState", new Class[0]) != null;
            boolean z3 = kkjkjk.b00730073ss007300730073(b00730073s0073s007300732, "getType", new Class[0]) != null;
            boolean z4 = kkjkjk.b00730073ss007300730073(b00730073s0073s007300732, "getExtraInfo", new Class[0]) != null;
            boolean z5 = kkjkjk.b00730073ss007300730073(b00730073s0073s007300733, "getBSSID", new Class[0]) != null;
            boolean z6 = kkjkjk.b00730073ss007300730073(b00730073s0073s007300733, "getSSID", new Class[0]) != null;
            boolean z7 = kkjkjk.b00730073ss007300730073(b00730073s0073s007300733, "getRssi", new Class[0]) != null;
            boolean z8 = kkjkjk.b00730073ss007300730073(b00730073s0073s007300734, "getConnectionInfo", new Class[0]) != null;
            boolean z9 = kkjkjk.b00730073ss007300730073(b00730073s0073s007300732, "isConnectedOrConnecting", new Class[0]) != null;
            boolean z10 = kkjkjk.b0073s00730073s00730073(b00730073s0073s00730073, "CONNECTIVITY_ACTION") != null;
            boolean z11 = kkjkjk.b0073s00730073s00730073(b00730073s0073s00730073, "TYPE_MOBILE") != null;
            boolean z12 = kkjkjk.b0073s00730073s00730073(b00730073s0073s00730073, "TYPE_WIFI") != null;
            boolean z13 = z8;
            boolean z14 = kkjkjk.b0073s00730073s00730073(b00730073s0073s00730073, "TYPE_BLUETOOTH") != null;
            boolean z15 = kkjkjk.b0073s00730073s00730073(b00730073s0073s00730073, "TYPE_ETHERNET") != null;
            boolean z16 = z7;
            boolean z17 = kkjkjk.b0073s00730073s00730073(b00730073s0073s007300734, "NETWORK_STATE_CHANGED_ACTION") != null;
            boolean z18 = kkjkjk.b0073s00730073s00730073(b00730073s0073s007300735, "CONNECTED") != null;
            b006Bkkk006B006B = z && z9;
            boolean z19 = kkjkjk.b00730073ss007300730073(b00730073s0073s007300734, "getScanResults", new Class[0]) != null;
            b006Bk006Bk006B006B = z19;
            bk006B006Bk006B006B = z19 && kkjkjk.b00730073ss007300730073(b00730073s0073s007300734, "startScan", new Class[0]) != null;
            bk006Bkk006B006B = z10 && z18 && z2 && z4 && z3 && z11 && z12 && z15 && z14;
            b006B006Bkk006B006B = z17 && z18 && z5 && z6 && z16 && z2 && z4;
            bkk006Bk006B006B = z13 && z5 && z6 && z16;
        }

        private qqqttq() {
        }

        public static boolean b0076007600760076vv() {
            return bk006B006Bk006B006B;
        }

        public static boolean b0076v00760076vv() {
            return b006B006Bkk006B006B;
        }

        public static boolean b0076vvv0076v() {
            return b006Bkkk006B006B;
        }

        public static boolean bv007600760076vv() {
            return bkk006Bk006B006B;
        }

        public static boolean bvv00760076vv() {
            return bk006Bkk006B006B;
        }

        public static boolean bvvvv0076v() {
            return b006Bk006Bk006B006B;
        }
    }

    public static class qqtqtq {
        private static final boolean b006B006Bkk006Bk;
        private static final boolean bk006Bkk006Bk;
        private static final boolean bkk006Bk006Bk;

        static {
            boolean z;
            int i;
            boolean z2;
            int i2;
            boolean z3;
            int i3;
            boolean z4;
            int i4;
            boolean z5;
            int i5;
            boolean z6;
            int i6;
            boolean z7;
            int i7;
            boolean z8;
            int i8;
            boolean z9;
            int i9;
            boolean z10;
            int i10;
            boolean z11;
            int i11;
            Class b00730073s0073s00730073 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.CERTIFICATE);
            Class b00730073s0073s007300732 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.KEY_PAIR);
            Class b00730073s0073s007300733 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.KEY);
            Class b00730073s0073s007300734 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.KEY_STORE);
            Class b00730073s0073s007300735 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.LOAD_STORE_PARAM);
            Class b00730073s0073s007300736 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.PROTECTION_PARAM);
            Class b00730073s0073s007300737 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.KEY_ENTRY);
            Class b00730073s0073s007300738 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.PRIVATE_KEY_ENTRY);
            Class b00730073s0073s007300739 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.PRIVATE_KEY);
            Class b00730073s0073s0073007310 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.KEY_PAIR_GENERATOR);
            Class b00730073s0073s0073007311 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.ALG_PARAMETER_SPEC);
            Class b00730073s0073s0073007312 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.KEY_CHAIN);
            Class b00730073s0073s0073007313 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.SIGNATURE);
            Class b00730073s0073s0073007314 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.KEY_PROPERTIES);
            Class b00730073s0073s0073007315 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.KEY_PAIR_GEN_SPEC);
            Class b00730073s0073s0073007316 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.KEY_PAIR_GEN_SPEC_BUILDER);
            Class b00730073s0073s0073007317 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.X_500_PRINCIPAL);
            Class b00730073s0073s0073007318 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.KEY_GEN_PARAM_SPEC);
            Class cls = b00730073s0073s0073007315;
            Class b00730073s0073s0073007319 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.KEY_GEN_PARAM_SPEC_BUILDER);
            Class cls2 = b00730073s0073s007300737;
            Class b00730073s0073s0073007320 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.KEY_FACTORY);
            Class cls3 = b00730073s0073s0073007314;
            Class b00730073s0073s0073007321 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.KEY_INFO);
            Class cls4 = b00730073s0073s0073007320;
            Class cls5 = b00730073s0073s0073007319;
            if (kkjkjk.b00730073ss007300730073(b00730073s0073s007300734, tqttqq.b006E006Enn006En, String.class) != null) {
                i = 1;
                z = true;
            } else {
                i = 1;
                z = false;
            }
            Class[] clsArr = new Class[i];
            clsArr[0] = b00730073s0073s007300735;
            boolean z12 = kkjkjk.b00730073ss007300730073(b00730073s0073s007300734, HotpatchStateConst.LOAD, clsArr) != null;
            boolean z13 = kkjkjk.b00730073ss007300730073(b00730073s0073s007300734, "getEntry", String.class, b00730073s0073s007300736) != null;
            boolean z14 = kkjkjk.b00730073ss007300730073(b00730073s0073s007300734, "getCertificate", String.class) != null;
            boolean z15 = kkjkjk.b00730073ss007300730073(b00730073s0073s007300734, "getCreationDate", String.class) != null;
            boolean z16 = kkjkjk.b00730073ss007300730073(b00730073s0073s007300738, "getPrivateKey", new Class[0]) != null;
            if (kkjkjk.b00730073ss007300730073(b00730073s0073s007300733, "getAlgorithm", new Class[0]) != null) {
                i2 = 0;
                z2 = true;
            } else {
                i2 = 0;
                z2 = false;
            }
            if (kkjkjk.b00730073ss007300730073(b00730073s0073s007300732, "getPrivate", new Class[i2]) != null) {
                i3 = 0;
                z3 = true;
            } else {
                i3 = 0;
                z3 = false;
            }
            if (kkjkjk.b00730073ss007300730073(b00730073s0073s007300732, "getPublic", new Class[i3]) != null) {
                i4 = 0;
                z4 = true;
            } else {
                i4 = 0;
                z4 = false;
            }
            boolean z17 = kkjkjk.b00730073ss007300730073(b00730073s0073s00730073, "getPublicKey", new Class[i4]) != null;
            boolean z18 = kkjkjk.b00730073ss007300730073(b00730073s0073s0073007310, "generateKeyPair", new Class[i4]) != null;
            Class[] clsArr2 = new Class[2];
            clsArr2[i4] = String.class;
            clsArr2[1] = String.class;
            boolean z19 = kkjkjk.b00730073ss007300730073(b00730073s0073s0073007310, tqttqq.b006E006Enn006En, clsArr2) != null;
            boolean z20 = kkjkjk.b00730073ss007300730073(b00730073s0073s0073007310, "initialize", b00730073s0073s0073007311) != null;
            boolean z21 = kkjkjk.b00730073ss007300730073(b00730073s0073s0073007313, tqttqq.b006E006Enn006En, String.class) != null;
            boolean z22 = kkjkjk.b00730073ss007300730073(b00730073s0073s0073007313, "initSign", b00730073s0073s007300739) != null;
            boolean z23 = kkjkjk.b00730073ss007300730073(b00730073s0073s0073007313, XEParseConst.CHILD_UPDATE_MODE_TAG, byte[].class) != null;
            boolean z24 = kkjkjk.b00730073ss007300730073(b00730073s0073s0073007313, "sign", new Class[0]) != null;
            if (kkjkjk.b00730073ss007300730073(b00730073s0073s0073007312, "isKeyAlgorithmSupported", String.class) != null) {
                i5 = 1;
                z5 = true;
            } else {
                i5 = 1;
                z5 = false;
            }
            Class[] clsArr3 = new Class[i5];
            clsArr3[0] = String.class;
            if (kkjkjk.b00730073ss007300730073(b00730073s0073s0073007316, "setAlias", clsArr3) != null) {
                i6 = 1;
                z6 = true;
            } else {
                i6 = 1;
                z6 = false;
            }
            Class[] clsArr4 = new Class[i6];
            clsArr4[0] = b00730073s0073s0073007317;
            boolean z25 = kkjkjk.b00730073ss007300730073(b00730073s0073s0073007316, "setSubject", clsArr4) != null;
            if (kkjkjk.b00730073ss007300730073(b00730073s0073s0073007316, "setSerialNumber", BigInteger.class) != null) {
                i7 = 1;
                z7 = true;
            } else {
                i7 = 1;
                z7 = false;
            }
            Class[] clsArr5 = new Class[i7];
            clsArr5[0] = Date.class;
            if (kkjkjk.b00730073ss007300730073(b00730073s0073s0073007316, "setStartDate", clsArr5) != null) {
                i8 = 1;
                z8 = true;
            } else {
                i8 = 1;
                z8 = false;
            }
            Class[] clsArr6 = new Class[i8];
            clsArr6[0] = Date.class;
            if (kkjkjk.b00730073ss007300730073(b00730073s0073s0073007316, "setEndDate", clsArr6) != null) {
                i9 = 1;
                z9 = true;
            } else {
                i9 = 1;
                z9 = false;
            }
            Class[] clsArr7 = new Class[i9];
            clsArr7[0] = String.class;
            if (kkjkjk.b00730073ss007300730073(b00730073s0073s0073007316, "setKeyType", clsArr7) != null) {
                i10 = 1;
                z10 = true;
            } else {
                i10 = 1;
                z10 = false;
            }
            Class[] clsArr8 = new Class[i10];
            clsArr8[0] = String.class;
            boolean z26 = kkjkjk.b00730073ss007300730073(b00730073s0073s0073007312, "isBoundKeyAlgorithm", clsArr8) != null;
            Class cls6 = cls5;
            boolean z27 = kkjkjk.b00730073ss007300730073(cls6, "setDigests", String[].class) != null;
            boolean z28 = z26;
            boolean z29 = kkjkjk.b00730073ss007300730073(cls6, "setSignaturePaddings", String[].class) != null;
            Class cls7 = cls4;
            boolean z30 = kkjkjk.b00730073ss007300730073(cls7, tqttqq.b006E006Enn006En, String.class, String.class) != null;
            boolean z31 = kkjkjk.b00730073ss007300730073(cls7, "getKeySpec", b00730073s0073s007300733, Class.class) != null;
            Class cls8 = b00730073s0073s0073007321;
            if (kkjkjk.b00730073ss007300730073(cls8, "isInsideSecureHardware", new Class[0]) != null) {
                i11 = 0;
                z11 = true;
            } else {
                i11 = 0;
                z11 = false;
            }
            boolean z32 = kkjkjk.b00730073ss007300730073(cls8, "getOrigin", new Class[i11]) != null;
            Class cls9 = cls3;
            boolean z33 = kkjkjk.b0073s00730073s00730073(cls9, "PURPOSE_SIGN") != null;
            boolean z34 = kkjkjk.b0073s00730073s00730073(cls9, "PURPOSE_ENCRYPT") != null;
            boolean z35 = kkjkjk.b0073s00730073s00730073(cls9, "DIGEST_SHA256") != null;
            boolean z36 = kkjkjk.b0073s00730073s00730073(cls9, "SIGNATURE_PADDING_RSA_PKCS1") != null;
            boolean z37 = kkjkjk.b0073s00730073s00730073(cls9, "ORIGIN_GENERATED") != null;
            boolean z38 = cls2 != null && b00730073s0073s007300738 != null && b00730073s0073s007300739 != null && z && z12 && z13 && z16 && z14 && z15 && z2 && z3 && z4 && z17 && z18 && z19 && z20 && z5;
            bkk006Bk006Bk = z21 && z22 && z23 && z24;
            bk006Bkk006Bk = z38 && cls != null && z6 && z25 && z7 && z8 && z9 && z10 && z28;
            b006B006Bkk006Bk = ttttqq.qqqqtq.b006E006En006En006E >= 23 && z38 && b00730073s0073s0073007318 != null && z27 && z29 && z30 && z31 && z11 && z32 && z33 && z34 && z35 && z36 && z37;
        }

        private qqtqtq() {
        }

        public static boolean b007500750075u00750075() {
            return bk006Bkk006Bk || b006B006Bkk006Bk;
        }

        public static boolean b0075u0075u00750075() {
            return bk006Bkk006Bk;
        }

        public static boolean bu00750075u00750075() {
            return b006B006Bkk006Bk;
        }

        public static boolean buu0075u00750075() {
            return bkk006Bk006Bk;
        }
    }

    public static class qqtttq {
        private static final boolean b006C006C006C006Cll;
        public static final String b006C006C006Clll = "mock_location";
        private static final boolean b006C006Cl006Cll;
        private static final String b006C006Cllll = "ALLOW_MOCK_LOCATION";
        private static final boolean b006Cl006C006Cll;
        private static final String b006Cl006Clll = "DEVELOPMENT_SETTINGS_ENABLED";
        public static final String b006Cll006Cll = "development_settings_enabled";
        private static final boolean b006Clll006Cl;
        private static final String b006Clllll = "getString";
        private static final boolean bl006C006C006Cll;
        public static final String bl006C006Clll = "android_id";
        private static final boolean bl006Cl006Cll;
        private static final String bl006Cllll = "ANDROID_ID";
        private static final boolean bll006C006Cll;
        private static final String bll006Clll = "ADB_ENABLED";
        public static final String blll006Cll = "adb_enabled";
        private static final boolean bllll006Cl;

        static {
            Class b00730073s0073s00730073 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.SETTING_SECURE);
            boolean z = false;
            bl006Cl006Cll = kkjkjk.b00730073ss007300730073(b00730073s0073s00730073, b006Clllll, ContentResolver.class, String.class) != null;
            b006C006Cl006Cll = kkjkjk.b0073s00730073s00730073(b00730073s0073s00730073, bl006Cllll) != null;
            bll006C006Cll = kkjkjk.b0073s00730073s00730073(b00730073s0073s00730073, b006C006Cllll) != null;
            b006Cl006C006Cll = kkjkjk.b0073s00730073s00730073(b00730073s0073s00730073, bll006Clll) != null;
            bl006C006C006Cll = kkjkjk.b0073s00730073s00730073(b00730073s0073s00730073, b006Cl006Clll) != null;
            Class b00730073s0073s007300732 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.SETTING_GLOBAL);
            b006C006C006C006Cll = kkjkjk.b00730073ss007300730073(b00730073s0073s007300732, b006Clllll, ContentResolver.class, String.class) != null;
            bllll006Cl = kkjkjk.b0073s00730073s00730073(b00730073s0073s007300732, bll006Clll) != null;
            if (kkjkjk.b0073s00730073s00730073(b00730073s0073s007300732, b006Cl006Clll) != null) {
                z = true;
            }
            b006Clll006Cl = z;
        }

        private qqtttq() {
        }

        @Nullable
        public static String b0076vv00760076v(@Nullable ContentResolver contentResolver, String str) {
            if (contentResolver != null && !yqqyqq.bi0069i0069i0069(str) && b006C006C006C006Cll) {
                try {
                    if (blll006Cll.equals(str) && bllll006Cl) {
                        return Settings.Global.getString(contentResolver, blll006Cll);
                    }
                    if (b006Cll006Cll.equals(str) && b006Clll006Cl) {
                        return Settings.Global.getString(contentResolver, b006Cll006Cll);
                    }
                } catch (SecurityException e) {
                    String bv0076v007600760076 = tqttqq.b006Ennn006En;
                    yyyyqy.qyyyqy.bt0074tttt(bv0076v007600760076, tqttqq.bn006Enn006En + e.toString());
                    qqqtqt.byyyy0079y(e);
                } catch (Exception e2) {
                    yyyyqy.bt0074007400740074t(tqttqq.b006Ennn006En, e2.toString());
                }
            }
            return null;
        }

        @Nullable
        public static String bv0076v00760076v(@Nullable ContentResolver contentResolver, String str) {
            if (contentResolver != null && !yqqyqq.bi0069i0069i0069(str) && bl006Cl006Cll) {
                try {
                    String string = Settings.Secure.getString(contentResolver, str);
                    if (string != null) {
                        return string;
                    }
                    if ("android_id".equals(str) && b006C006Cl006Cll) {
                        return Settings.Secure.getString(contentResolver, "android_id");
                    }
                    if (b006C006C006Clll.equals(str) && bll006C006Cll) {
                        return Settings.Secure.getString(contentResolver, b006C006C006Clll);
                    }
                    if (blll006Cll.equals(str) && b006Cl006C006Cll) {
                        return Settings.Secure.getString(contentResolver, blll006Cll);
                    }
                    if (b006Cll006Cll.equals(str) && bl006C006C006Cll) {
                        return Settings.Secure.getString(contentResolver, b006Cll006Cll);
                    }
                } catch (SecurityException e) {
                    String bv0076v007600760076 = tqttqq.b006Ennn006En;
                    yyyyqy.qyyyqy.bt0074tttt(bv0076v007600760076, tqttqq.bn006Enn006En + e.toString());
                    qqqtqt.byyyy0079y(e);
                } catch (Exception e2) {
                    yyyyqy.bt0074007400740074t(tqttqq.b006Ennn006En, e2.toString());
                }
            }
            return null;
        }
    }

    public static class qtqqtq {
        public static final boolean b006Bkk006Bkk;
        @Nonnull
        private static final SparseIntArray bk006Bk006Bkk = new SparseIntArray(6);
        private static final String bkkk006Bkk = "getStorageEncryptionStatus";

        public static class ttqqtq {
            public static final int b006B006B006B006Bkk = 16;
            public static final int b006B006Bk006Bkk = 1;
            public static final int b006Bk006B006Bkk = 4;
            public static final int b006Bkkk006Bk = 64;
            public static final int bk006B006B006Bkk = 8;
            public static final int bkk006B006Bkk = 2;
            public static final int bkkkk006Bk = 32;
        }

        static {
            Class b00730073s0073s00730073 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.DEVICE_POLICY_MANAGER);
            boolean z = false;
            if (kkjkjk.b00730073ss007300730073(b00730073s0073s00730073, bkkk006Bkk, new Class[0]) != null) {
                z = true;
            }
            b006Bkk006Bkk = z;
            Object bssss007300730073 = kkjkjk.bssss007300730073(b00730073s0073s00730073, "ENCRYPTION_STATUS_UNSUPPORTED", (Object) null);
            if (bssss007300730073 != null) {
                bk006Bk006Bkk.put(((Integer) bssss007300730073).intValue(), 1);
            }
            Object bssss0073007300732 = kkjkjk.bssss007300730073(b00730073s0073s00730073, "ENCRYPTION_STATUS_INACTIVE", (Object) null);
            if (bssss0073007300732 != null) {
                bk006Bk006Bkk.put(((Integer) bssss0073007300732).intValue(), 2);
            }
            Object bssss0073007300733 = kkjkjk.bssss007300730073(b00730073s0073s00730073, "ENCRYPTION_STATUS_ACTIVATING", (Object) null);
            if (bssss0073007300733 != null) {
                bk006Bk006Bkk.put(((Integer) bssss0073007300733).intValue(), 4);
            }
            Object bssss0073007300734 = kkjkjk.bssss007300730073(b00730073s0073s00730073, "ENCRYPTION_STATUS_ACTIVE", (Object) null);
            if (bssss0073007300734 != null) {
                bk006Bk006Bkk.put(((Integer) bssss0073007300734).intValue(), 8);
            }
            Object bssss0073007300735 = kkjkjk.bssss007300730073(b00730073s0073s00730073, "ENCRYPTION_STATUS_ACTIVE_DEFAULT_KEY", (Object) null);
            if (bssss0073007300735 != null) {
                bk006Bk006Bkk.put(((Integer) bssss0073007300735).intValue(), 32);
            }
            Object bssss0073007300736 = kkjkjk.bssss007300730073(b00730073s0073s00730073, "ENCRYPTION_STATUS_ACTIVE_PER_USER", (Object) null);
            if (bssss0073007300736 != null) {
                bk006Bk006Bkk.put(((Integer) bssss0073007300736).intValue(), 64);
            }
        }

        private qtqqtq() {
        }

        public static int b00750075uu00750075(Context context) {
            int i;
            if (!b006Bkk006Bkk) {
                return 16;
            }
            try {
                Object systemService = context.getSystemService("device_policy");
                if ((systemService instanceof DevicePolicyManager) && (i = bk006Bk006Bkk.get(((DevicePolicyManager) systemService).getStorageEncryptionStatus())) != 0) {
                    return i;
                }
                return 16;
            } catch (SecurityException e) {
                String bv0076v007600760076 = tqttqq.b006Ennn006En;
                yyyyqy.qyyyqy.bt0074tttt(bv0076v007600760076, tqttqq.bn006Enn006En + e.toString());
                qqqtqt.byyyy0079y(e);
                return 16;
            } catch (Exception e2) {
                yyyyqy.bt0074007400740074t(tqttqq.b006Ennn006En, e2.toString());
                return 16;
            }
        }
    }

    public class qtqttq {
        @Nullable
        private PackageManager b006Bkk006B006B006B = null;

        public qtqttq(Context context) {
            if (tqtqtq.bk006Bk006B006Bk) {
                try {
                    this.b006Bkk006B006B006B = context.getPackageManager();
                } catch (SecurityException e) {
                    String bv0076v007600760076 = tqttqq.b006Ennn006En;
                    yyyyqy.qyyyqy.bt0074tttt(bv0076v007600760076, tqttqq.bn006Enn006En + e.toString());
                    qqqtqt.byyyy0079y(e);
                } catch (Exception e2) {
                    yyyyqy.bt0074007400740074t(tqttqq.b006Ennn006En, e2.toString());
                }
            }
        }

        public boolean b0076v0076v0076v(String str, String str2) {
            PackageManager packageManager;
            boolean z = false;
            if (tqtqtq.bkk006B006B006Bk && (packageManager = this.b006Bkk006B006B006B) != null) {
                try {
                    if (packageManager.checkPermission(str, str2) == 0) {
                        z = true;
                    }
                } catch (SecurityException e) {
                    String bv0076v007600760076 = tqttqq.b006Ennn006En;
                    yyyyqy.qyyyqy.bt0074tttt(bv0076v007600760076, tqttqq.bn006Enn006En + e.toString());
                    qqqtqt.byyyy0079y(e);
                } catch (Exception e2) {
                    yyyyqy.bt0074007400740074t(tqttqq.b006Ennn006En, e2.toString());
                }
            }
            if (!z) {
                qqqtqt.by0079yy0079y(str);
            }
            return z;
        }

        public boolean bv00760076v0076v(String str, int i) {
            PackageManager packageManager;
            if (!tqtqtq.bk006Bk006B006Bk || !tqtqtq.b006B006Bk006B006Bk || (packageManager = this.b006Bkk006B006B006B) == null) {
                return false;
            }
            try {
                SystemUtils.getPackageInfo(packageManager, str, i);
                return true;
            } catch (PackageManager.NameNotFoundException e) {
                yyyyqy.qyyyqy.bttt0074tt(tqttqq.b006Ennn006En, "Invalid package name. {} {}", str, e);
                return false;
            } catch (SecurityException e2) {
                String bv0076v007600760076 = tqttqq.b006Ennn006En;
                yyyyqy.qyyyqy.bt0074tttt(bv0076v007600760076, tqttqq.bn006Enn006En + e2.toString());
                qqqtqt.byyyy0079y(e2);
                return false;
            } catch (Exception e3) {
                yyyyqy.bt0074007400740074t(tqttqq.b006Ennn006En, e3.toString());
                return false;
            }
        }

        public boolean bvv0076v0076v() {
            return tqtqtq.bk006Bk006B006Bk && tqtqtq.bk006B006Bk006Bk && this.b006Bkk006B006B006B != null;
        }
    }

    public private static class qttqtq {
        private static final String b006B006B006B006B006Bk = "getInt";
        /* access modifiers changed from: private */
        public static final boolean b006B006B006Bkk006B;
        /* access modifiers changed from: private */
        public static final boolean b006B006Bk006Bk006B;
        private static final String b006B006Bkkk006B = "putLong";
        /* access modifiers changed from: private */
        public static final boolean b006Bk006B006Bk006B;
        private static final String b006Bk006Bkk006B = "apply";
        /* access modifiers changed from: private */
        public static final boolean b006Bkk006Bk006B;
        private static final String b006Bkkkk006B = "getString";
        /* access modifiers changed from: private */
        public static final boolean bk006B006B006Bk006B;
        /* access modifiers changed from: private */
        public static final boolean bk006B006Bkk006B;
        /* access modifiers changed from: private */
        public static final boolean bk006Bk006Bk006B;
        private static final String bk006Bkkk006B = "putInt";
        /* access modifiers changed from: private */
        public static final boolean bkk006B006Bk006B;
        private static final String bkk006Bkk006B = "putString";
        /* access modifiers changed from: private */
        public static final boolean bkkk006Bk006B;
        private static final String bkkkkk006B = "getLong";

        static {
            Class b00730073s0073s00730073 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.SHARED_PREFERENCES);
            boolean z = true;
            bk006B006Bkk006B = b00730073s0073s00730073 != null;
            Class b00730073s0073s007300732 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.SHARED_PREFERENCES_EDITOR);
            b006B006B006Bkk006B = b00730073s0073s007300732 != null;
            b006Bkk006Bk006B = kkjkjk.b00730073ss007300730073(b00730073s0073s00730073, b006B006B006B006B006Bk, String.class, Integer.TYPE) != null;
            bk006Bk006Bk006B = kkjkjk.b00730073ss007300730073(b00730073s0073s00730073, bkkkkk006B, String.class, Long.TYPE) != null;
            bkkk006Bk006B = kkjkjk.b00730073ss007300730073(b00730073s0073s00730073, b006Bkkkk006B, String.class, String.class) != null;
            b006Bk006B006Bk006B = kkjkjk.b00730073ss007300730073(b00730073s0073s007300732, bk006Bkkk006B, String.class, Integer.TYPE) != null;
            bkk006B006Bk006B = kkjkjk.b00730073ss007300730073(b00730073s0073s007300732, b006B006Bkkk006B, String.class, Long.TYPE) != null;
            b006B006Bk006Bk006B = kkjkjk.b00730073ss007300730073(b00730073s0073s007300732, bkk006Bkk006B, String.class, String.class) != null;
            if (kkjkjk.b00730073ss007300730073(b00730073s0073s007300732, "apply", new Class[0]) == null) {
                z = false;
            }
            bk006B006B006Bk006B = z;
        }

        private qttqtq() {
        }
    }

    public static class qtttqq {
        @Nullable
        private ApplicationInfo bnn006En006En = null;

        public qtttqq(@Nonnull tqtqqt tqtqqt) {
            if (tqtqtq.bk006B006Bk006Bk && tqtqtq.b006B006B006Bk006Bk) {
                this.bnn006En006En = tqtqqt.bll006C006C006C006C.getApplicationInfo();
            }
        }

        public String b0075007500750075u0075() {
            ApplicationInfo applicationInfo = this.bnn006En006En;
            return applicationInfo != null ? applicationInfo.packageName : "";
        }

        public int b0075u00750075u0075() {
            ApplicationInfo applicationInfo = this.bnn006En006En;
            if (applicationInfo != null) {
                return applicationInfo.flags;
            }
            return 0;
        }

        public int b0075uuu00750075() {
            ApplicationInfo applicationInfo = this.bnn006En006En;
            if (applicationInfo != null) {
                return applicationInfo.uid;
            }
            return -1;
        }

        public String bu007500750075u0075() {
            ApplicationInfo applicationInfo = this.bnn006En006En;
            return applicationInfo != null ? applicationInfo.nativeLibraryDir : "";
        }

        public String buu00750075u0075() {
            ApplicationInfo applicationInfo = this.bnn006En006En;
            return applicationInfo != null ? applicationInfo.dataDir : "";
        }

        public String buuuu00750075() {
            ApplicationInfo applicationInfo = this.bnn006En006En;
            return applicationInfo != null ? applicationInfo.sourceDir : "";
        }
    }

    public static class qttttq {
        private static final boolean b006C006Cll006Cl;
        private static final boolean bl006Cll006Cl;
        private static final boolean bll006Cl006Cl;

        static {
            boolean z;
            int i;
            boolean z2;
            int i2;
            boolean z3;
            int i3;
            Class<byte[]> cls = byte[].class;
            Class b00730073s0073s00730073 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.SECRET_KEY_SPEC);
            Class b00730073s0073s007300732 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.CIPHER);
            Class b00730073s0073s007300733 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.KEY);
            Class b00730073s0073s007300734 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.PRIVATE_KEY);
            Class b00730073s0073s007300735 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.PUBLIC_KEY);
            Class b00730073s0073s007300736 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.KEY_FACTORY);
            Class b00730073s0073s007300737 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.KEY_SPEC);
            Class b00730073s0073s007300738 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.PKCS8_ENC_KEY_SPEC);
            Class b00730073s0073s007300739 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.X509_ENC_KEY_SPEC);
            Class b00730073s0073s0073007310 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.EC_GEN_KEY_SPEC);
            Class b00730073s0073s0073007311 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.RSA_GEN_KEY_SPEC);
            Class b00730073s0073s0073007312 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.KEY_PAIR);
            Class b00730073s0073s0073007313 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.KEY_PAIR_GENERATOR);
            Class b00730073s0073s0073007314 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.ALG_PARAMETER_SPEC);
            Class b00730073s0073s0073007315 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.SIGNATURE);
            Class cls2 = b00730073s0073s007300735;
            Class cls3 = b00730073s0073s0073007310;
            Class cls4 = b00730073s0073s007300739;
            if (kkjkjk.b00730073ss007300730073(b00730073s0073s007300732, tqttqq.b006E006Enn006En, String.class, String.class) != null) {
                i = 2;
                z = true;
            } else {
                i = 2;
                z = false;
            }
            Class[] clsArr = new Class[i];
            Class cls5 = b00730073s0073s007300738;
            clsArr[0] = Integer.TYPE;
            clsArr[1] = b00730073s0073s007300733;
            boolean z4 = kkjkjk.b00730073ss007300730073(b00730073s0073s007300732, IPixView.PAGE_STATUS_INIT, clsArr) != null;
            boolean z5 = kkjkjk.b00730073ss007300730073(b00730073s0073s007300732, "doFinal", cls) != null;
            boolean z6 = kkjkjk.b00730073ss007300730073(b00730073s0073s007300736, tqttqq.b006E006Enn006En, String.class) != null;
            boolean z7 = kkjkjk.b00730073ss007300730073(b00730073s0073s007300736, "generatePrivate", b00730073s0073s007300737) != null;
            boolean z8 = kkjkjk.b00730073ss007300730073(b00730073s0073s007300736, "generatePublic", b00730073s0073s007300737) != null;
            boolean z9 = kkjkjk.b00730073ss007300730073(b00730073s0073s0073007312, "getPrivate", new Class[0]) != null;
            boolean z10 = kkjkjk.b00730073ss007300730073(b00730073s0073s0073007312, "getPublic", new Class[0]) != null;
            boolean z11 = kkjkjk.b00730073ss007300730073(b00730073s0073s0073007313, tqttqq.b006E006Enn006En, String.class, String.class) != null;
            boolean z12 = kkjkjk.b00730073ss007300730073(b00730073s0073s0073007313, "initialize", b00730073s0073s0073007314) != null;
            if (kkjkjk.b00730073ss007300730073(b00730073s0073s0073007313, "generateKeyPair", new Class[0]) != null) {
                i2 = 1;
                z2 = true;
            } else {
                i2 = 1;
                z2 = false;
            }
            Class[] clsArr2 = new Class[i2];
            clsArr2[0] = String.class;
            if (kkjkjk.b00730073ss007300730073(b00730073s0073s0073007315, tqttqq.b006E006Enn006En, clsArr2) != null) {
                i3 = 1;
                z3 = true;
            } else {
                i3 = 1;
                z3 = false;
            }
            Class[] clsArr3 = new Class[i3];
            clsArr3[0] = b00730073s0073s007300734;
            boolean z13 = kkjkjk.b00730073ss007300730073(b00730073s0073s0073007315, "initSign", clsArr3) != null;
            Class[] clsArr4 = new Class[i3];
            clsArr4[0] = cls;
            boolean z14 = kkjkjk.b00730073ss007300730073(b00730073s0073s0073007315, XEParseConst.CHILD_UPDATE_MODE_TAG, clsArr4) != null;
            boolean z15 = kkjkjk.b00730073ss007300730073(b00730073s0073s0073007315, "sign", new Class[0]) != null;
            boolean z16 = kkjkjk.b0073s00730073s00730073(b00730073s0073s0073007311, "F0") != null;
            bll006Cl006Cl = z3 && z13 && z14 && z15;
            bl006Cll006Cl = b00730073s0073s00730073 != null && cls5 != null && cls4 != null && z && z4 && z5 && z6 && z7 && z8;
            b006C006Cll006Cl = (cls3 != null || (b00730073s0073s0073007311 != null && z16)) && b00730073s0073s007300734 != null && cls2 != null && z11 && z12 && z2 && z9 && z10 && z4 && z5;
        }

        private qttttq() {
        }

        public static boolean b0076vv0076v0076() {
            return bll006Cl006Cl;
        }

        public static boolean bv0076v0076v0076() {
            return bl006Cll006Cl;
        }

        public static boolean bvvv0076v0076() {
            return b006C006Cll006Cl;
        }
    }

    public class tqqttq {
        @Nullable
        private PackageInfo b006B006B006Bk006B006B = null;

        public tqqttq(Context context, @Nonnull String str, int i) {
            if (tqtqtq.b006B006Bk006B006Bk && tqtqtq.bk006Bk006B006Bk) {
                try {
                    this.b006B006B006Bk006B006B = SystemUtils.getPackageInfo(context.getPackageManager(), str, i);
                } catch (PackageManager.NameNotFoundException e) {
                    yyyyqy.qyyyqy.bttt0074tt(tqttqq.b006Ennn006En, "Invalid package name. {} {}", str, e.toString());
                } catch (SecurityException e2) {
                    String bv0076v007600760076 = tqttqq.b006Ennn006En;
                    yyyyqy.qyyyqy.bt0074tttt(bv0076v007600760076, tqttqq.bn006Enn006En + e2.toString());
                    qqqtqt.byyyy0079y(e2);
                } catch (Exception e3) {
                    yyyyqy.bt0074007400740074t(tqttqq.b006Ennn006En, e3.toString());
                }
            }
        }

        @Nullable
        public String b00760076vv0076v() {
            PackageInfo packageInfo;
            if (!tqtqtq.bk006B006B006B006Bk || (packageInfo = this.b006B006B006Bk006B006B) == null) {
                return null;
            }
            return packageInfo.versionName;
        }

        public int bv0076vv0076v() {
            PackageInfo packageInfo;
            if (!tqtqtq.b006Bk006B006B006Bk || (packageInfo = this.b006B006B006Bk006B006B) == null) {
                return -1;
            }
            return packageInfo.versionCode;
        }
    }

    public static class tqtqtq {
        /* access modifiers changed from: private */
        public static final boolean b006B006B006Bk006Bk;
        /* access modifiers changed from: private */
        public static final boolean b006B006Bk006B006Bk;
        /* access modifiers changed from: private */
        public static final boolean b006Bk006B006B006Bk;
        private static final String b006Bk006Bk006Bk = "checkPermission";
        public static final int b006Bkk006B006Bk = 128;
        /* access modifiers changed from: private */
        public static final boolean bk006B006B006B006Bk;
        /* access modifiers changed from: private */
        public static final boolean bk006B006Bk006Bk = (kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.APPLICATION_INFO) != null);
        /* access modifiers changed from: private */
        public static final boolean bk006Bk006B006Bk;
        /* access modifiers changed from: private */
        public static final boolean bkk006B006B006Bk;
        public static final int bkkk006B006Bk = 1;

        static {
            Class b00730073s0073s00730073 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.PACKAGE_MANAGER);
            boolean z = false;
            bk006Bk006B006Bk = b00730073s0073s00730073 != null;
            Class b00730073s0073s007300732 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.PACKAGE_INFO);
            b006B006Bk006B006Bk = b00730073s0073s007300732 != null;
            bkk006B006B006Bk = kkjkjk.b00730073ss007300730073(b00730073s0073s00730073, b006Bk006Bk006Bk, String.class, String.class) != null;
            b006Bk006B006B006Bk = kkjkjk.b0073s00730073s00730073(b00730073s0073s007300732, "versionCode") != null;
            bk006B006B006B006Bk = kkjkjk.b0073s00730073s00730073(b00730073s0073s007300732, "versionName") != null;
            if (kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.PACKAGE_ITEM_INFO) != null) {
                z = true;
            }
            b006B006B006Bk006Bk = z;
            boolean z2 = bk006Bk006B006Bk;
        }

        private tqtqtq() {
        }
    }

    public static class tqtttq {
        private tqtttq() {
        }

        public static long b00760076007600760076v(@Nonnull tqtqqt tqtqqt, @Nonnull String str, String str2, long j) {
            return (!qttqtq.bk006B006Bkk006B || !qttqtq.bk006Bk006Bk006B) ? j : SystemUtils.getSharedPreferences(tqtqqt.bll006C006C006C006C, str, 0).getLong(str2, j);
        }

        public static void b007600760076vv0076(@Nonnull tqtqqt tqtqqt, @Nonnull String str, @Nonnull String str2, @Nonnull String str3) {
            SharedPreferences.Editor edit;
            if (qttqtq.bk006B006Bkk006B && qttqtq.b006B006B006Bkk006B && qttqtq.bk006B006B006Bk006B && qttqtq.b006B006Bk006Bk006B && (edit = SystemUtils.getSharedPreferences(tqtqqt.bll006C006C006C006C, str, 0).edit()) != null) {
                edit.putString(str2, str3);
                edit.apply();
            }
        }

        @Nullable
        public static SharedPreferences.Editor b00760076v00760076v(@Nonnull SharedPreferences sharedPreferences) {
            if (!qttqtq.bk006B006Bkk006B || !qttqtq.b006B006B006Bkk006B || !qttqtq.bk006B006B006Bk006B) {
                return null;
            }
            return sharedPreferences.edit();
        }

        public static boolean b00760076vvv0076() {
            return qttqtq.bkkk006Bk006B && qttqtq.b006B006Bk006Bk006B;
        }

        public static int b0076v007600760076v(@Nonnull tqtqqt tqtqqt, @Nonnull String str, String str2, int i) {
            return (!qttqtq.bk006B006Bkk006B || !qttqtq.b006Bkk006Bk006B) ? i : SystemUtils.getSharedPreferences(tqtqqt.bll006C006C006C006C, str, 0).getInt(str2, i);
        }

        public static void b0076v0076vv0076(String str, long j, @Nonnull SharedPreferences.Editor editor) {
            if (qttqtq.bkk006B006Bk006B) {
                editor.putLong(str, j);
            }
        }

        @Nullable
        public static String b0076vvvv0076(@Nonnull tqtqqt tqtqqt, @Nonnull String str, @Nonnull String str2, @Nullable String str3) {
            return (!qttqtq.bk006B006Bkk006B || !qttqtq.bkkk006Bk006B) ? str3 : SystemUtils.getSharedPreferences(tqtqqt.bll006C006C006C006C, str, 0).getString(str2, str3);
        }

        public static long bv0076007600760076v(@Nonnull SharedPreferences sharedPreferences, String str, long j) {
            return (!qttqtq.bk006B006Bkk006B || !qttqtq.bk006Bk006Bk006B) ? j : sharedPreferences.getLong(str, j);
        }

        public static void bv00760076vv0076(String str, String str2, @Nonnull SharedPreferences.Editor editor) {
            if (qttqtq.b006B006Bk006Bk006B) {
                editor.putString(str, str2);
            }
        }

        public static boolean bv0076vvv0076() {
            return qttqtq.bk006B006Bkk006B && qttqtq.b006B006B006Bkk006B;
        }

        public static int bvv007600760076v(@Nonnull SharedPreferences sharedPreferences, String str, int i) {
            return (!qttqtq.bk006B006Bkk006B || !qttqtq.b006Bkk006Bk006B) ? i : sharedPreferences.getInt(str, i);
        }

        public static void bvv0076vv0076(String str, int i, @Nonnull SharedPreferences.Editor editor) {
            if (qttqtq.b006Bk006B006Bk006B) {
                editor.putInt(str, i);
            }
        }

        @Nullable
        public static String bvvvvv0076(@Nonnull SharedPreferences sharedPreferences, @Nonnull String str, @Nullable String str2) {
            return (!qttqtq.bk006B006Bkk006B || !qttqtq.bkkk006Bk006B) ? str2 : sharedPreferences.getString(str, str2);
        }
    }

    public static class ttqttq {
        private static final String b006B006Bk006B006B006B = "isInteractive";
        private static final boolean b006Bk006B006B006B006B;
        private static final boolean bk006B006B006B006B006B;
        private static final String bkk006B006B006B006B = "isScreenOn";

        static {
            Class b00730073s0073s00730073 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.POWER_MANAGER);
            boolean z = false;
            b006Bk006B006B006B006B = kkjkjk.b00730073ss007300730073(b00730073s0073s00730073, b006B006Bk006B006B006B, new Class[0]) != null;
            if (kkjkjk.b00730073ss007300730073(b00730073s0073s00730073, bkk006B006B006B006B, new Class[0]) != null) {
                z = true;
            }
            bk006B006B006B006B006B = z;
        }

        private ttqttq() {
        }

        public static boolean b007600760076v0076v() {
            return b006Bk006B006B006B006B;
        }

        public static boolean bvvv00760076v() {
            return bk006B006B006B006B006B;
        }
    }

    public static class tttqtq {
        private static final boolean b006B006B006B006Bk006B;
        private static final boolean bkkkk006B006B;

        static {
            boolean z;
            int i;
            boolean z2;
            int i2;
            Class b00730073s0073s00730073 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.CRITERIA);
            Class b00730073s0073s007300732 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.LOCATION);
            Class b00730073s0073s007300733 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.LOCATION_PROVIDER);
            Class b00730073s0073s007300734 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.LOCATION_LISTENER);
            boolean z3 = kkjkjk.b00730073ss007300730073(b00730073s0073s00730073, "setAccuracy", Integer.TYPE) != null;
            boolean z4 = kkjkjk.b00730073ss007300730073(b00730073s0073s00730073, "setAltitudeRequired", Boolean.TYPE) != null;
            boolean z5 = kkjkjk.b00730073ss007300730073(b00730073s0073s00730073, "setBearingAccuracy", Integer.TYPE) != null;
            boolean z6 = kkjkjk.b00730073ss007300730073(b00730073s0073s00730073, "setCostAllowed", Boolean.TYPE) != null;
            boolean z7 = kkjkjk.b00730073ss007300730073(b00730073s0073s00730073, "setSpeedAccuracy", Integer.TYPE) != null;
            boolean z8 = kkjkjk.b00730073ss007300730073(b00730073s0073s00730073, "setSpeedRequired", Boolean.TYPE) != null;
            boolean z9 = kkjkjk.b00730073ss007300730073(b00730073s0073s00730073, "setVerticalAccuracy", Integer.TYPE) != null;
            boolean z10 = kkjkjk.b00730073ss007300730073(b00730073s0073s00730073, "setPowerRequirement", Integer.TYPE) != null;
            boolean z11 = kkjkjk.b00730073ss007300730073(b00730073s0073s007300732, "getTime", new Class[0]) != null;
            boolean z12 = kkjkjk.b00730073ss007300730073(b00730073s0073s007300732, "getProvider", new Class[0]) != null;
            if (kkjkjk.b00730073ss007300730073(b00730073s0073s007300732, "getAccuracy", new Class[0]) != null) {
                i = 0;
                z = true;
            } else {
                i = 0;
                z = false;
            }
            if (kkjkjk.b00730073ss007300730073(b00730073s0073s007300732, "getLatitude", new Class[i]) != null) {
                i2 = 0;
                z2 = true;
            } else {
                i2 = 0;
                z2 = false;
            }
            boolean z13 = kkjkjk.b00730073ss007300730073(b00730073s0073s007300732, "getLongitude", new Class[i2]) != null;
            boolean z14 = kkjkjk.b0073s00730073s00730073(b00730073s0073s00730073, "NO_REQUIREMENT") != null;
            boolean z15 = z13;
            boolean z16 = kkjkjk.b0073s00730073s00730073(b00730073s0073s00730073, "POWER_LOW") != null;
            boolean z17 = z12;
            boolean z18 = kkjkjk.b0073s00730073s00730073(b00730073s0073s00730073, "ACCURACY_LOW") != null;
            boolean z19 = kkjkjk.b0073s00730073s00730073(b00730073s0073s00730073, "ACCURACY_COARSE") != null;
            boolean z20 = kkjkjk.b0073s00730073s00730073(b00730073s0073s007300733, "AVAILABLE") != null;
            boolean z21 = kkjkjk.b0073s00730073s00730073(b00730073s0073s007300733, "TEMPORARILY_UNAVAILABLE") != null;
            boolean z22 = kkjkjk.b0073s00730073s00730073(b00730073s0073s007300733, "OUT_OF_SERVICE") != null;
            b006B006B006B006Bk006B = z3 && z4 && z5 && z6 && z7 && z8 && z9 && z10 && z14 && z16 && z18 && z19;
            bkkkk006B006B = b00730073s0073s007300734 != null && z11 && z17 && z2 && z15 && z && z20 && z21 && z22;
        }

        private tttqtq() {
        }

        public static boolean b00760076v0076vv() {
            return bkkkk006B006B;
        }

        public static boolean bv0076v0076vv() {
            return b006B006B006B006Bk006B;
        }
    }

    public static class ttttqq {
        @Nullable
        public static final String b006E006E006E006E006En = (kkjkjk.b0073s00730073s00730073(bnnn006En006E, "DISPLAY") != null ? Build.DISPLAY : null);
        @Nullable
        public static final String b006E006E006En006En = (kkjkjk.b0073s00730073s00730073(bnnn006En006E, "TAGS") != null ? Build.TAGS : null);
        @Nullable
        public static final Field b006E006E006Enn006E = kkjkjk.b0073s00730073s00730073(bnnn006En006E, "SUPPORTED_ABIS");
        @Nullable
        public static final String b006E006En006E006En = (kkjkjk.b0073s00730073s00730073(bnnn006En006E, "ID") != null ? Build.ID : null);
        @Nullable
        public static final String b006E006Ennn006E = (kkjkjk.b0073s00730073s00730073(bnnn006En006E, "CPU_ABI") != null ? Build.CPU_ABI : null);
        @Nullable
        public static final String b006En006E006E006En = (kkjkjk.b0073s00730073s00730073(bnnn006En006E, "DEVICE") != null ? Build.DEVICE : null);
        public static final long b006En006En006En = (kkjkjk.b0073s00730073s00730073(bnnn006En006E, "TIME") != null ? Build.TIME : Long.MAX_VALUE);
        @Nullable
        public static final String[] b006En006Enn006E;
        @Nullable
        public static final String b006Enn006E006En = (kkjkjk.b0073s00730073s00730073(bnnn006En006E, "BRAND") != null ? Build.BRAND : null);
        @Nullable
        public static final String b006Ennnn006E = (kkjkjk.b0073s00730073s00730073(bnnn006En006E, "MANUFACTURER") != null ? Build.MANUFACTURER : null);
        @Nullable
        public static final String bn006E006E006E006En = (kkjkjk.b0073s00730073s00730073(bnnn006En006E, "MODEL") != null ? Build.MODEL : null);
        @Nullable
        public static final String bn006E006En006En = (kkjkjk.b0073s00730073s00730073(bnnn006En006E, "TYPE") != null ? Build.TYPE : null);
        @Nullable
        public static final Method bn006E006Enn006E;
        @Nullable
        public static final String bn006En006E006En = (kkjkjk.b0073s00730073s00730073(bnnn006En006E, "USER") != null ? Build.USER : null);
        @Nullable
        public static final String bn006Ennn006E = (kkjkjk.b0073s00730073s00730073(bnnn006En006E, "BOARD") != null ? Build.BOARD : null);
        @Nullable
        public static final String bnn006E006E006En = (kkjkjk.b0073s00730073s00730073(bnnn006En006E, "SERIAL") != null ? Build.SERIAL : null);
        @Nullable
        public static final String bnn006Enn006E = (kkjkjk.b0073s00730073s00730073(bnnn006En006E, "CPU_ABI2") != null ? Build.CPU_ABI2 : null);
        @Nullable
        public static final String bnnn006E006En = (kkjkjk.b0073s00730073s00730073(bnnn006En006E, "HOST") != null ? Build.HOST : null);
        @Nullable
        private static final Class<?> bnnn006En006E;
        @Nullable
        public static final String bnnnnn006E = (kkjkjk.b0073s00730073s00730073(bnnn006En006E, "PRODUCT") != null ? Build.PRODUCT : null);

        public static class qqqqtq {
            public static final int b006E006En006En006E;
            @Nullable
            public static final String b006Enn006En006E;
            @Nullable
            public static final String bn006En006En006E;
            public static final String bnn006E006En006E;

            static {
                Class b00730073s0073s00730073 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.VERSION);
                String str = null;
                b006Enn006En006E = kkjkjk.b0073s00730073s00730073(b00730073s0073s00730073, "RELEASE") != null ? Build.VERSION.RELEASE : null;
                b006E006En006En006E = kkjkjk.b0073s00730073s00730073(b00730073s0073s00730073, "SDK_INT") != null ? Build.VERSION.SDK_INT : -1;
                bn006En006En006E = kkjkjk.b0073s00730073s00730073(b00730073s0073s00730073, "CODENAME") != null ? Build.VERSION.CODENAME : null;
                if (kkjkjk.b0073s00730073s00730073(b00730073s0073s00730073, "SECURITY_PATCH") != null) {
                    str = Build.VERSION.SECURITY_PATCH;
                }
                bnn006E006En006E = str;
            }

            private qqqqtq() {
            }
        }

        public static class tqqqtq {
            @Nullable
            private static final Class<?> b006B006B006Bkkk;
            public static final int b006B006Bkkkk = 28;
            public static final int b006Bk006Bkkk = 30;
            public static final int b006Bkkkkk = 26;
            public static final int b006E006E006E006En006E = 10;
            public static final int b006E006E006En006E006E = 18;
            public static final int b006E006En006E006E006E = 22;
            public static final int b006E006Enn006E006E = 14;
            public static final int b006En006E006E006E006E = 24;
            public static final int b006En006E006En006E = 8;
            public static final int b006En006En006E006E = 16;
            public static final int b006Enn006E006E006E = 20;
            public static final int b006Ennn006E006E = 12;
            public static final int bk006B006Bkkk = 31;
            public static final int bk006Bkkkk = 27;
            public static final int bkk006Bkkk = 29;
            public static final int bn006E006E006E006E006E = 25;
            public static final int bn006E006E006En006E = 9;
            public static final int bn006E006En006E006E = 17;
            public static final int bn006En006E006E006E = 21;
            public static final int bn006Enn006E006E = 13;
            public static final int bnn006E006E006E006E = 23;
            public static final int bnn006En006E006E = 15;
            public static final int bnnn006E006E006E = 19;
            public static final int bnnnn006E006E = 11;

            static {
                Class<?> b00730073s0073s00730073 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.VERSION_CODES);
                b006B006B006Bkkk = b00730073s0073s00730073;
                Field b0073s00730073s00730073 = kkjkjk.b0073s00730073s00730073(b00730073s0073s00730073, "FROYO");
                Field b0073s00730073s007300732 = kkjkjk.b0073s00730073s00730073(b006B006B006Bkkk, "GINGERBREAD");
                Field b0073s00730073s007300733 = kkjkjk.b0073s00730073s00730073(b006B006B006Bkkk, "GINGERBREAD_MR1");
                Field b0073s00730073s007300734 = kkjkjk.b0073s00730073s00730073(b006B006B006Bkkk, "HONEYCOMB");
                Field b0073s00730073s007300735 = kkjkjk.b0073s00730073s00730073(b006B006B006Bkkk, "HONEYCOMB_MR1");
                Field b0073s00730073s007300736 = kkjkjk.b0073s00730073s00730073(b006B006B006Bkkk, "HONEYCOMB_MR2");
                Field b0073s00730073s007300737 = kkjkjk.b0073s00730073s00730073(b006B006B006Bkkk, "ICE_CREAM_SANDWICH");
                Field b0073s00730073s007300738 = kkjkjk.b0073s00730073s00730073(b006B006B006Bkkk, "ICE_CREAM_SANDWICH_MR1");
                Field b0073s00730073s007300739 = kkjkjk.b0073s00730073s00730073(b006B006B006Bkkk, "JELLY_BEAN");
                Field b0073s00730073s0073007310 = kkjkjk.b0073s00730073s00730073(b006B006B006Bkkk, "JELLY_BEAN_MR1");
                Field b0073s00730073s0073007311 = kkjkjk.b0073s00730073s00730073(b006B006B006Bkkk, "JELLY_BEAN_MR2");
                Field b0073s00730073s0073007312 = kkjkjk.b0073s00730073s00730073(b006B006B006Bkkk, "KITKAT");
                Field b0073s00730073s0073007313 = kkjkjk.b0073s00730073s00730073(b006B006B006Bkkk, "KITKAT_WATCH");
                Field b0073s00730073s0073007314 = kkjkjk.b0073s00730073s00730073(b006B006B006Bkkk, "LOLLIPOP");
                Field b0073s00730073s0073007315 = kkjkjk.b0073s00730073s00730073(b006B006B006Bkkk, "LOLLIPOP_MR1");
                Field b0073s00730073s0073007316 = kkjkjk.b0073s00730073s00730073(b006B006B006Bkkk, "M");
                Field b0073s00730073s0073007317 = kkjkjk.b0073s00730073s00730073(b006B006B006Bkkk, "N");
                Field b0073s00730073s0073007318 = kkjkjk.b0073s00730073s00730073(b006B006B006Bkkk, "N_MR1");
                Field b0073s00730073s0073007319 = kkjkjk.b0073s00730073s00730073(b006B006B006Bkkk, "O");
                Field b0073s00730073s0073007320 = kkjkjk.b0073s00730073s00730073(b006B006B006Bkkk, "O_MR1");
                Field b0073s00730073s0073007321 = kkjkjk.b0073s00730073s00730073(b006B006B006Bkkk, "P");
                Field b0073s00730073s0073007322 = kkjkjk.b0073s00730073s00730073(b006B006B006Bkkk, "Q");
                Field b0073s00730073s0073007323 = kkjkjk.b0073s00730073s00730073(b006B006B006Bkkk, "R");
                Field b0073s00730073s0073007324 = kkjkjk.b0073s00730073s00730073(b006B006B006Bkkk, ExifInterface.LATITUDE_SOUTH);
            }

            private tqqqtq() {
            }
        }

        static {
            Class<?> b00730073s0073s00730073 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.BUILD);
            bnnn006En006E = b00730073s0073s00730073;
            bn006E006Enn006E = kkjkjk.b00730073ss007300730073(b00730073s0073s00730073, "getSerial", new Class[0]);
            String[] strArr = null;
            Field field = b006E006E006Enn006E;
            if (field != null) {
                strArr = (String[]) kkjkjk.b0073s0073s007300730073((Object) null, field);
            }
            b006En006Enn006E = strArr;
        }

        private ttttqq() {
        }

        public static String bu0075uu00750075() {
            Object bs00730073s007300730073;
            Method method = bn006E006Enn006E;
            if (method == null || (bs00730073s007300730073 = kkjkjk.bs00730073s007300730073((Object) null, method, new Object[0])) == null) {
                return null;
            }
            return (String) bs00730073s007300730073;
        }
    }

    public static class tttttq {
        private static final String b006C006C006Cl006Cl = "elapsedRealtimeNanos";
        private static final String b006Cl006Cl006Cl = "uptimeMillis";
        private static final boolean b006Cll006C006Cl;
        private static final String bl006C006Cl006Cl = "elapsedRealtime";
        private static final boolean bl006Cl006C006Cl;
        private static final boolean blll006C006Cl;

        static {
            Class b00730073s0073s00730073 = kkjkjk.b00730073s0073s00730073(kkjkjk.jjkkjk.SYSTEM_CLOCK);
            boolean z = false;
            blll006C006Cl = kkjkjk.b00730073ss007300730073(b00730073s0073s00730073, b006Cl006Cl006Cl, new Class[0]) != null;
            b006Cll006C006Cl = kkjkjk.b00730073ss007300730073(b00730073s0073s00730073, bl006C006Cl006Cl, new Class[0]) != null;
            if (kkjkjk.b00730073ss007300730073(b00730073s0073s00730073, b006C006C006Cl006Cl, new Class[0]) != null) {
                z = true;
            }
            bl006Cl006C006Cl = z;
        }

        private tttttq() {
        }

        public static long b00760076v0076v0076() {
            if (b006Cll006C006Cl) {
                return SystemClock.elapsedRealtime();
            }
            return 0;
        }

        public static long b0076v00760076v0076() {
            if (blll006C006Cl) {
                return SystemClock.uptimeMillis();
            }
            return 0;
        }

        public static boolean bvv00760076v0076() {
            return bl006Cl006C006Cl;
        }
    }
}
