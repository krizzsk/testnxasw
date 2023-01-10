package com.didi.zxing.client;

import android.content.Intent;
import com.didi.dqr.BarcodeFormat;
import com.didi.zxing.client.Intents;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public final class DecodeFormatManager {

    /* renamed from: a */
    static final Set<BarcodeFormat> f48126a = EnumSet.of(BarcodeFormat.UPC_A, new BarcodeFormat[]{BarcodeFormat.UPC_E, BarcodeFormat.EAN_13, BarcodeFormat.EAN_8, BarcodeFormat.RSS_14, BarcodeFormat.RSS_EXPANDED});

    /* renamed from: b */
    static final Set<BarcodeFormat> f48127b = EnumSet.of(BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODE_128, BarcodeFormat.ITF, BarcodeFormat.CODABAR);

    /* renamed from: c */
    static final Set<BarcodeFormat> f48128c = EnumSet.of(BarcodeFormat.QR_CODE);

    /* renamed from: d */
    static final Set<BarcodeFormat> f48129d = EnumSet.of(BarcodeFormat.DATA_MATRIX);

    /* renamed from: e */
    static final Set<BarcodeFormat> f48130e = EnumSet.of(BarcodeFormat.AZTEC);

    /* renamed from: f */
    static final Set<BarcodeFormat> f48131f = EnumSet.of(BarcodeFormat.PDF_417);

    /* renamed from: g */
    private static final Pattern f48132g = Pattern.compile(",");

    /* renamed from: h */
    private static final Set<BarcodeFormat> f48133h;

    /* renamed from: i */
    private static final Map<String, Set<BarcodeFormat>> f48134i;

    static {
        EnumSet<BarcodeFormat> copyOf = EnumSet.copyOf(f48126a);
        f48133h = copyOf;
        copyOf.addAll(f48127b);
        HashMap hashMap = new HashMap();
        f48134i = hashMap;
        hashMap.put(Intents.Scan.ONE_D_MODE, f48133h);
        f48134i.put(Intents.Scan.PRODUCT_MODE, f48126a);
        f48134i.put(Intents.Scan.QR_CODE_MODE, f48128c);
        f48134i.put(Intents.Scan.DATA_MATRIX_MODE, f48129d);
        f48134i.put(Intents.Scan.AZTEC_MODE, f48130e);
        f48134i.put(Intents.Scan.PDF417_MODE, f48131f);
    }

    private DecodeFormatManager() {
    }

    public static Set<BarcodeFormat> parseDecodeFormats(Intent intent) {
        String stringExtra = intent.getStringExtra(Intents.Scan.FORMATS);
        return m36099a(stringExtra != null ? Arrays.asList(f48132g.split(stringExtra)) : null, intent.getStringExtra(Intents.Scan.MODE));
    }

    /* renamed from: a */
    private static Set<BarcodeFormat> m36099a(Iterable<String> iterable, String str) {
        if (iterable != null) {
            EnumSet<E> noneOf = EnumSet.noneOf(BarcodeFormat.class);
            try {
                for (String valueOf : iterable) {
                    noneOf.add(BarcodeFormat.valueOf(valueOf));
                }
                return noneOf;
            } catch (IllegalArgumentException unused) {
            }
        }
        if (str != null) {
            return f48134i.get(str);
        }
        return null;
    }
}
