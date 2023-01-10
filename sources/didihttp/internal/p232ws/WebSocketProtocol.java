package didihttp.internal.p232ws;

import okio.ByteString;

/* renamed from: didihttp.internal.ws.WebSocketProtocol */
public final class WebSocketProtocol {

    /* renamed from: a */
    static final String f59704a = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";

    /* renamed from: b */
    static final int f59705b = 128;

    /* renamed from: c */
    static final int f59706c = 64;

    /* renamed from: d */
    static final int f59707d = 32;

    /* renamed from: e */
    static final int f59708e = 16;

    /* renamed from: f */
    static final int f59709f = 15;

    /* renamed from: g */
    static final int f59710g = 8;

    /* renamed from: h */
    static final int f59711h = 128;

    /* renamed from: i */
    static final int f59712i = 127;

    /* renamed from: j */
    static final int f59713j = 0;

    /* renamed from: k */
    static final int f59714k = 1;

    /* renamed from: l */
    static final int f59715l = 2;

    /* renamed from: m */
    static final int f59716m = 8;

    /* renamed from: n */
    static final int f59717n = 9;

    /* renamed from: o */
    static final int f59718o = 10;

    /* renamed from: p */
    static final long f59719p = 125;

    /* renamed from: q */
    static final long f59720q = 123;

    /* renamed from: r */
    static final int f59721r = 126;

    /* renamed from: s */
    static final long f59722s = 65535;

    /* renamed from: t */
    static final int f59723t = 127;

    /* renamed from: u */
    static final int f59724u = 1001;

    /* renamed from: v */
    static final int f59725v = 1002;

    /* renamed from: w */
    static final int f59726w = 1005;

    /* renamed from: x */
    static final int f59727x = 1006;

    /* renamed from: a */
    static void m44997a(byte[] bArr, long j, byte[] bArr2, long j2) {
        int length = bArr2.length;
        int i = 0;
        while (((long) i) < j) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[(int) (j2 % ((long) length))]);
            i++;
            j2++;
        }
    }

    /* renamed from: a */
    static String m44996a(int i) {
        if (i < 1000 || i >= 5000) {
            return "Code must be in range [1000,5000): " + i;
        } else if ((i < 1004 || i > 1006) && (i < 1012 || i > 2999)) {
            return null;
        } else {
            return "Code " + i + " is reserved and may not be used.";
        }
    }

    /* renamed from: b */
    static void m44998b(int i) {
        String a = m44996a(i);
        if (a != null) {
            throw new IllegalArgumentException(a);
        }
    }

    public static String acceptHeader(String str) {
        return ByteString.encodeUtf8(str + f59704a).sha1().base64();
    }

    private WebSocketProtocol() {
        throw new AssertionError("No instances.");
    }
}
