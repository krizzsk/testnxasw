package okhttp3.internal.p073ws;

import okio.Buffer;
import okio.ByteString;

/* renamed from: okhttp3.internal.ws.WebSocketProtocol */
public final class WebSocketProtocol {

    /* renamed from: a */
    static final String f7423a = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";

    /* renamed from: b */
    static final int f7424b = 128;

    /* renamed from: c */
    static final int f7425c = 64;

    /* renamed from: d */
    static final int f7426d = 32;

    /* renamed from: e */
    static final int f7427e = 16;

    /* renamed from: f */
    static final int f7428f = 15;

    /* renamed from: g */
    static final int f7429g = 8;

    /* renamed from: h */
    static final int f7430h = 128;

    /* renamed from: i */
    static final int f7431i = 127;

    /* renamed from: j */
    static final int f7432j = 0;

    /* renamed from: k */
    static final int f7433k = 1;

    /* renamed from: l */
    static final int f7434l = 2;

    /* renamed from: m */
    static final int f7435m = 8;

    /* renamed from: n */
    static final int f7436n = 9;

    /* renamed from: o */
    static final int f7437o = 10;

    /* renamed from: p */
    static final long f7438p = 125;

    /* renamed from: q */
    static final long f7439q = 123;

    /* renamed from: r */
    static final int f7440r = 126;

    /* renamed from: s */
    static final long f7441s = 65535;

    /* renamed from: t */
    static final int f7442t = 127;

    /* renamed from: u */
    static final int f7443u = 1001;

    /* renamed from: v */
    static final int f7444v = 1005;

    /* renamed from: a */
    static void m6982a(Buffer.UnsafeCursor unsafeCursor, byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        do {
            byte[] bArr2 = unsafeCursor.data;
            int i2 = unsafeCursor.start;
            int i3 = unsafeCursor.end;
            while (i2 < i3) {
                int i4 = i % length;
                bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i4]);
                i2++;
                i = i4 + 1;
            }
        } while (unsafeCursor.next() != -1);
    }

    /* renamed from: a */
    static String m6981a(int i) {
        if (i < 1000 || i >= 5000) {
            return "Code must be in range [1000,5000): " + i;
        } else if ((i < 1004 || i > 1006) && (i < 1012 || i > 2999)) {
            return null;
        } else {
            return "Code " + i + " is reserved and may not be used.";
        }
    }

    /* renamed from: b */
    static void m6983b(int i) {
        String a = m6981a(i);
        if (a != null) {
            throw new IllegalArgumentException(a);
        }
    }

    public static String acceptHeader(String str) {
        return ByteString.encodeUtf8(str + f7423a).sha1().base64();
    }

    private WebSocketProtocol() {
        throw new AssertionError("No instances.");
    }
}
