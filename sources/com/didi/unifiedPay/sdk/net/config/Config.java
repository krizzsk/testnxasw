package com.didi.unifiedPay.sdk.net.config;

import com.didi.unifiedPay.sdk.internal.PayConstant;

public class Config {
    public static final String URL_ONLINE_HEAD = "https://cashier.didiglobal.com";

    /* renamed from: a */
    private static final String f47230a = "/gulfstream/pay/v1/client/";

    /* renamed from: b */
    private static final String f47231b = "/gulfstream/pay/v1/didipay/";

    /* renamed from: c */
    private static final String f47232c = "/gulfstream/pay/v1/didipay/";

    /* renamed from: d */
    private static String f47233d = "https://cashier.didiglobal.com/gulfstream/pay/v1/client/";

    /* renamed from: e */
    private static String f47234e = "https://cashier.didiglobal.com/gulfstream/pay/v1/didipay/";

    /* renamed from: f */
    private static String f47235f = "https://cashier.didiglobal.com/gulfstream/pay/v1/didipay/";

    /* renamed from: g */
    private final PayConstant.PayBillType f47236g;

    public Config(PayConstant.PayBillType payBillType) {
        this.f47236g = payBillType;
    }

    /* renamed from: com.didi.unifiedPay.sdk.net.config.Config$1 */
    static /* synthetic */ class C153111 {

        /* renamed from: $SwitchMap$com$didi$unifiedPay$sdk$internal$PayConstant$PayBillType */
        static final /* synthetic */ int[] f47237xf898f1eb;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.unifiedPay.sdk.internal.PayConstant$PayBillType[] r0 = com.didi.unifiedPay.sdk.internal.PayConstant.PayBillType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f47237xf898f1eb = r0
                com.didi.unifiedPay.sdk.internal.PayConstant$PayBillType r1 = com.didi.unifiedPay.sdk.internal.PayConstant.PayBillType.Trip     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f47237xf898f1eb     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.unifiedPay.sdk.internal.PayConstant$PayBillType r1 = com.didi.unifiedPay.sdk.internal.PayConstant.PayBillType.NoneTrip     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f47237xf898f1eb     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.unifiedPay.sdk.internal.PayConstant$PayBillType r1 = com.didi.unifiedPay.sdk.internal.PayConstant.PayBillType.Merchant     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.unifiedPay.sdk.net.config.Config.C153111.<clinit>():void");
        }
    }

    public String getBaseUrl() {
        int i = C153111.f47237xf898f1eb[this.f47236g.ordinal()];
        if (i == 1) {
            return f47233d;
        }
        if (i == 2) {
            return f47234e;
        }
        if (i != 3) {
            return null;
        }
        return f47235f;
    }
}
