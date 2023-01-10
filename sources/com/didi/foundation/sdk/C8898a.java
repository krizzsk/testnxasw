package com.didi.foundation.sdk;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import kotlin.text.Typography;
import org.osgi.framework.VersionRange;

/* renamed from: com.didi.foundation.sdk.a */
/* compiled from: Strings */
final class C8898a {
    private C8898a() {
        throw new AssertionError("No instances.");
    }

    /* renamed from: a */
    static String m18984a(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof CharSequence) {
            return Typography.quote + m18985a(obj.toString()) + Typography.quote;
        }
        Class<?> cls = obj.getClass();
        if (Byte.class == cls) {
            return m18982a((Byte) obj);
        }
        if (cls.isArray()) {
            return m18983a(cls.getComponentType(), obj);
        }
        return obj.toString();
    }

    /* renamed from: a */
    private static String m18985a(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            int type = Character.getType(codePointAt);
            if (type == 0 || type == 15 || type == 16 || type == 18 || type == 19) {
                switch (codePointAt) {
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        sb.append("\\u");
                        sb.append(String.format("%04x", new Object[]{Integer.valueOf(codePointAt)}).toUpperCase(Locale.US));
                        break;
                }
            } else {
                sb.append(Character.toChars(codePointAt));
            }
            i += Character.charCount(codePointAt);
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m18983a(Class<?> cls, Object obj) {
        if (Byte.TYPE == cls) {
            return m18986a((byte[]) obj);
        }
        if (Short.TYPE == cls) {
            return Arrays.toString((short[]) obj);
        }
        if (Character.TYPE == cls) {
            return Arrays.toString((char[]) obj);
        }
        if (Integer.TYPE == cls) {
            return Arrays.toString((int[]) obj);
        }
        if (Long.TYPE == cls) {
            return Arrays.toString((long[]) obj);
        }
        if (Float.TYPE == cls) {
            return Arrays.toString((float[]) obj);
        }
        if (Double.TYPE == cls) {
            return Arrays.toString((double[]) obj);
        }
        if (Boolean.TYPE == cls) {
            return Arrays.toString((boolean[]) obj);
        }
        return m18987a((Object[]) obj);
    }

    /* renamed from: a */
    private static String m18986a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(Const.jaLeft);
        for (int i = 0; i < bArr.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(m18982a(Byte.valueOf(bArr[i])));
        }
        sb.append(VersionRange.RIGHT_CLOSED);
        return sb.toString();
    }

    /* renamed from: a */
    private static String m18982a(Byte b) {
        if (b == null) {
            return "null";
        }
        return "0x" + String.format("%02x", new Object[]{b}).toUpperCase(Locale.US);
    }

    /* renamed from: a */
    private static String m18987a(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        m18988a(objArr, sb, new HashSet());
        return sb.toString();
    }

    /* renamed from: a */
    private static void m18988a(Object[] objArr, StringBuilder sb, Set<Object[]> set) {
        if (objArr == null) {
            sb.append("null");
            return;
        }
        set.add(objArr);
        sb.append(VersionRange.LEFT_CLOSED);
        for (int i = 0; i < objArr.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object[] objArr2 = objArr[i];
            if (objArr2 == null) {
                sb.append("null");
            } else {
                Class<?> cls = objArr2.getClass();
                if (!cls.isArray() || cls.getComponentType() != Object.class) {
                    sb.append(m18984a((Object) objArr2));
                } else {
                    Object[] objArr3 = objArr2;
                    if (set.contains(objArr3)) {
                        sb.append("[...]");
                    } else {
                        m18988a(objArr3, sb, set);
                    }
                }
            }
        }
        sb.append(VersionRange.RIGHT_CLOSED);
        set.remove(objArr);
    }
}
