package didihttp.internal.http2;

import didihttp.internal.C21750Util;
import java.io.IOException;
import okio.ByteString;

public final class Http2 {

    /* renamed from: a */
    static final ByteString f59511a = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b */
    static final int f59512b = 16384;

    /* renamed from: c */
    static final byte f59513c = 0;

    /* renamed from: d */
    static final byte f59514d = 1;

    /* renamed from: e */
    static final byte f59515e = 2;

    /* renamed from: f */
    static final byte f59516f = 3;

    /* renamed from: g */
    static final byte f59517g = 4;

    /* renamed from: h */
    static final byte f59518h = 5;

    /* renamed from: i */
    static final byte f59519i = 6;

    /* renamed from: j */
    static final byte f59520j = 7;

    /* renamed from: k */
    static final byte f59521k = 8;

    /* renamed from: l */
    static final byte f59522l = 9;

    /* renamed from: m */
    static final byte f59523m = 0;

    /* renamed from: n */
    static final byte f59524n = 1;

    /* renamed from: o */
    static final byte f59525o = 1;

    /* renamed from: p */
    static final byte f59526p = 4;

    /* renamed from: q */
    static final byte f59527q = 4;

    /* renamed from: r */
    static final byte f59528r = 8;

    /* renamed from: s */
    static final byte f59529s = 32;

    /* renamed from: t */
    static final byte f59530t = 32;

    /* renamed from: u */
    static final String[] f59531u = new String[64];

    /* renamed from: v */
    static final String[] f59532v = new String[256];

    /* renamed from: w */
    private static final String[] f59533w = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = f59532v;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = C21750Util.format("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = f59531u;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 = 0; i3 < 1; i3++) {
            int i4 = iArr[i3];
            f59531u[i4 | 8] = f59531u[i4] + "|PADDED";
        }
        String[] strArr3 = f59531u;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 < 1; i7++) {
                int i8 = iArr[i7];
                String[] strArr4 = f59531u;
                int i9 = i8 | i6;
                strArr4[i9] = f59531u[i8] + '|' + f59531u[i6];
                f59531u[i9 | 8] = f59531u[i8] + '|' + f59531u[i6] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr5 = f59531u;
            if (i < strArr5.length) {
                if (strArr5[i] == null) {
                    strArr5[i] = f59532v[i];
                }
                i++;
            } else {
                return;
            }
        }
    }

    private Http2() {
    }

    /* renamed from: a */
    static IllegalArgumentException m44841a(String str, Object... objArr) {
        throw new IllegalArgumentException(C21750Util.format(str, objArr));
    }

    /* renamed from: b */
    static IOException m44844b(String str, Object... objArr) throws IOException {
        throw new IOException(C21750Util.format(str, objArr));
    }

    /* renamed from: a */
    static String m44843a(boolean z, int i, int i2, byte b, byte b2) {
        String[] strArr = f59533w;
        String format = b < strArr.length ? strArr[b] : C21750Util.format("0x%02x", Byte.valueOf(b));
        String a = m44842a(b, b2);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = format;
        objArr[4] = a;
        return C21750Util.format("%s 0x%08x %5d %-13s %s", objArr);
    }

    /* renamed from: a */
    static String m44842a(byte b, byte b2) {
        if (b2 == 0) {
            return "";
        }
        if (!(b == 2 || b == 3)) {
            if (b == 4 || b == 6) {
                return b2 == 1 ? "ACK" : f59532v[b2];
            }
            if (!(b == 7 || b == 8)) {
                String[] strArr = f59531u;
                String str = b2 < strArr.length ? strArr[b2] : f59532v[b2];
                if (b == 5 && (b2 & 4) != 0) {
                    return str.replace("HEADERS", "PUSH_PROMISE");
                }
                if (b != 0 || (b2 & 32) == 0) {
                    return str;
                }
                return str.replace("PRIORITY", "COMPRESSED");
            }
        }
        return f59532v[b2];
    }
}
