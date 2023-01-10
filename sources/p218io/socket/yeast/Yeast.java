package p218io.socket.yeast;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* renamed from: io.socket.yeast.Yeast */
public final class Yeast {

    /* renamed from: a */
    private static char[] f55296a;

    /* renamed from: b */
    private static int f55297b;

    /* renamed from: c */
    private static int f55298c = 0;

    /* renamed from: d */
    private static String f55299d;

    /* renamed from: e */
    private static Map<Character, Integer> f55300e = new HashMap(f55297b);

    static {
        char[] charArray = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-_".toCharArray();
        f55296a = charArray;
        f55297b = charArray.length;
        for (int i = 0; i < f55297b; i++) {
            f55300e.put(Character.valueOf(f55296a[i]), Integer.valueOf(i));
        }
    }

    private Yeast() {
    }

    public static String encode(long j) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.insert(0, f55296a[(int) (j % ((long) f55297b))]);
            j /= (long) f55297b;
        } while (j > 0);
        return sb.toString();
    }

    public static long decode(String str) {
        long j = 0;
        for (char valueOf : str.toCharArray()) {
            j = (j * ((long) f55297b)) + ((long) f55300e.get(Character.valueOf(valueOf)).intValue());
        }
        return j;
    }

    public static String yeast() {
        String encode = encode(new Date().getTime());
        if (!encode.equals(f55299d)) {
            f55298c = 0;
            f55299d = encode;
            return encode;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(encode);
        sb.append(".");
        int i = f55298c;
        f55298c = i + 1;
        sb.append(encode((long) i));
        return sb.toString();
    }
}
