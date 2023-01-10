package com.didi.beatles.p101im.thirty.greenrobot.dao.internal;

import com.didi.beatles.p101im.thirty.greenrobot.dao.DaoException;
import com.didi.beatles.p101im.thirty.greenrobot.dao.Property;
import com.google.common.base.Ascii;
import kotlin.text.Typography;
import org.osgi.framework.VersionRange;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.internal.SqlUtils */
public class SqlUtils {

    /* renamed from: a */
    private static final char[] f11541a = C2948a.f6666a.toCharArray();

    public static StringBuilder appendProperty(StringBuilder sb, String str, Property property) {
        if (str != null) {
            sb.append(str);
            sb.append('.');
        }
        sb.append(Typography.quote);
        sb.append(property.columnName);
        sb.append(Typography.quote);
        return sb;
    }

    public static StringBuilder appendColumn(StringBuilder sb, String str) {
        sb.append(Typography.quote);
        sb.append(str);
        sb.append(Typography.quote);
        return sb;
    }

    public static StringBuilder appendColumn(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(".\"");
        sb.append(str2);
        sb.append(Typography.quote);
        return sb;
    }

    public static StringBuilder appendColumns(StringBuilder sb, String str, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            appendColumn(sb, str, strArr[i]);
            if (i < length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder appendColumns(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(Typography.quote);
            sb.append(strArr[i]);
            sb.append(Typography.quote);
            if (i < length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder appendPlaceholders(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < i - 1) {
                sb.append("?,");
            } else {
                sb.append('?');
            }
        }
        return sb;
    }

    public static StringBuilder appendColumnsEqualPlaceholders(StringBuilder sb, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            appendColumn(sb, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder appendColumnsEqValue(StringBuilder sb, String str, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            appendColumn(sb, str, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static String createSqlInsert(String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(Typography.quote);
        sb.append(str2);
        sb.append(Typography.quote);
        sb.append(" (");
        appendColumns(sb, strArr);
        sb.append(") VALUES (");
        appendPlaceholders(sb, strArr.length);
        sb.append(VersionRange.RIGHT_OPEN);
        return sb.toString();
    }

    public static String createSqlSelect(String str, String str2, String[] strArr) {
        if (str2 == null || str2.length() < 0) {
            throw new DaoException("Table alias required");
        }
        StringBuilder sb = new StringBuilder("SELECT ");
        appendColumns(sb, str2, strArr).append(" FROM ");
        sb.append(Typography.quote);
        sb.append(str);
        sb.append(Typography.quote);
        sb.append(' ');
        sb.append(str2);
        sb.append(' ');
        return sb.toString();
    }

    public static String createSqlSelectCountStar(String str, String str2) {
        StringBuilder sb = new StringBuilder("SELECT COUNT(*) FROM ");
        sb.append(Typography.quote);
        sb.append(str);
        sb.append(Typography.quote);
        sb.append(' ');
        if (str2 != null) {
            sb.append(str2);
            sb.append(' ');
        }
        return sb.toString();
    }

    public static String createSqlDelete(String str, String[] strArr) {
        String str2 = Typography.quote + str + Typography.quote;
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(str2);
        if (strArr != null && strArr.length > 0) {
            sb.append(" WHERE ");
            appendColumnsEqValue(sb, str2, strArr);
        }
        return sb.toString();
    }

    public static String createSqlUpdate(String str, String[] strArr, String[] strArr2) {
        String str2 = Typography.quote + str + Typography.quote;
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(str2);
        sb.append(" SET ");
        appendColumnsEqualPlaceholders(sb, strArr);
        sb.append(" WHERE ");
        appendColumnsEqValue(sb, str2, strArr2);
        return sb.toString();
    }

    public static String escapeBlobArgument(byte[] bArr) {
        return "X'" + toHex(bArr) + '\'';
    }

    public static String toHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i] & 255;
            int i2 = i * 2;
            char[] cArr2 = f11541a;
            cArr[i2] = cArr2[b >>> 4];
            cArr[i2 + 1] = cArr2[b & Ascii.f55148SI];
        }
        return new String(cArr);
    }
}
