package p218io.socket.utf8;

import java.util.ArrayList;
import java.util.List;
import okio.Utf8;

/* renamed from: io.socket.utf8.UTF8 */
public final class UTF8 {

    /* renamed from: a */
    private static final String f55292a = "Invalid continuation byte";

    /* renamed from: b */
    private static int[] f55293b;

    /* renamed from: c */
    private static int f55294c;

    /* renamed from: d */
    private static int f55295d;

    /* renamed from: io.socket.utf8.UTF8$Options */
    public static class Options {
        public boolean strict = true;
    }

    private UTF8() {
    }

    public static String encode(String str) throws UTF8Exception {
        return encode(str, new Options());
    }

    public static String encode(String str, Options options) throws UTF8Exception {
        boolean z = options.strict;
        int[] a = m41103a(str);
        int length = a.length;
        StringBuilder sb = new StringBuilder();
        int i = -1;
        while (true) {
            i++;
            if (i >= length) {
                return sb.toString();
            }
            sb.append(m41100a(a[i], z));
        }
    }

    public static String decode(String str) throws UTF8Exception {
        return decode(str, new Options());
    }

    public static String decode(String str, Options options) throws UTF8Exception {
        boolean z = options.strict;
        int[] a = m41103a(str);
        f55293b = a;
        f55294c = a.length;
        f55295d = 0;
        ArrayList arrayList = new ArrayList();
        while (true) {
            int a2 = m41099a(z);
            if (a2 == -1) {
                return m41101a(m41104a((List<Integer>) arrayList));
            }
            arrayList.add(Integer.valueOf(a2));
        }
    }

    /* renamed from: a */
    private static int[] m41103a(String str) {
        int length = str.length();
        int i = 0;
        int[] iArr = new int[str.codePointCount(0, length)];
        int i2 = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            iArr[i2] = codePointAt;
            i += Character.charCount(codePointAt);
            i2++;
        }
        return iArr;
    }

    /* renamed from: a */
    private static String m41100a(int i, boolean z) throws UTF8Exception {
        StringBuilder sb = new StringBuilder();
        if ((i & -128) == 0) {
            sb.append(Character.toChars(i));
            return sb.toString();
        }
        if ((i & -2048) == 0) {
            sb.append(Character.toChars(((i >> 6) & 31) | 192));
        } else if ((-65536 & i) == 0) {
            if (!m41105b(i, z)) {
                i = Utf8.REPLACEMENT_CODE_POINT;
            }
            sb.append(Character.toChars(((i >> 12) & 15) | 224));
            sb.append(m41102a(i, 6));
        } else if ((-2097152 & i) == 0) {
            sb.append(Character.toChars(((i >> 18) & 7) | 240));
            sb.append(m41102a(i, 12));
            sb.append(m41102a(i, 6));
        }
        sb.append(Character.toChars((i & 63) | 128));
        return sb.toString();
    }

    /* renamed from: a */
    private static char[] m41102a(int i, int i2) {
        return Character.toChars(((i >> i2) & 63) | 128);
    }

    /* renamed from: a */
    private static int m41099a(boolean z) throws UTF8Exception {
        int i = f55295d;
        int i2 = f55294c;
        if (i > i2) {
            throw new UTF8Exception("Invalid byte index");
        } else if (i == i2) {
            return -1;
        } else {
            int i3 = f55293b[i] & 255;
            f55295d = i + 1;
            if ((i3 & 128) == 0) {
                return i3;
            }
            if ((i3 & 224) == 192) {
                int a = m41098a() | ((i3 & 31) << 6);
                if (a >= 128) {
                    return a;
                }
                throw new UTF8Exception(f55292a);
            } else if ((i3 & 240) == 224) {
                int a2 = (m41098a() << 6) | ((i3 & 15) << 12) | m41098a();
                if (a2 >= 2048) {
                    return m41105b(a2, z) ? a2 : Utf8.REPLACEMENT_CODE_POINT;
                }
                throw new UTF8Exception(f55292a);
            } else {
                if ((i3 & 248) == 240) {
                    int a3 = (m41098a() << 12) | ((i3 & 15) << 18) | (m41098a() << 6) | m41098a();
                    if (a3 >= 65536 && a3 <= 1114111) {
                        return a3;
                    }
                }
                throw new UTF8Exception(f55292a);
            }
        }
    }

    /* renamed from: a */
    private static int m41098a() throws UTF8Exception {
        int i = f55295d;
        if (i < f55294c) {
            int i2 = f55293b[i] & 255;
            f55295d = i + 1;
            if ((i2 & 192) == 128) {
                return i2 & 63;
            }
            throw new UTF8Exception(f55292a);
        }
        throw new UTF8Exception("Invalid byte index");
    }

    /* renamed from: a */
    private static String m41101a(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int appendCodePoint : iArr) {
            sb.appendCodePoint(appendCodePoint);
        }
        return sb.toString();
    }

    /* renamed from: b */
    private static boolean m41105b(int i, boolean z) throws UTF8Exception {
        if (i < 55296 || i > 57343) {
            return true;
        }
        if (!z) {
            return false;
        }
        throw new UTF8Exception("Lone surrogate U+" + Integer.toHexString(i).toUpperCase() + " is not a scalar value");
    }

    /* renamed from: a */
    private static int[] m41104a(List<Integer> list) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }
}
