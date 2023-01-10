package com.didi.dqr.oned;

import org.apache.commons.p074io.IOUtils;

public final class CodaBarWriter extends OneDimensionalCodeWriter {

    /* renamed from: a */
    private static final char[] f20550a;

    /* renamed from: b */
    private static final char[] f20551b = {'T', 'N', '*', 'E'};

    /* renamed from: c */
    private static final char[] f20552c = {IOUtils.DIR_SEPARATOR_UNIX, ':', '+', '.'};

    /* renamed from: d */
    private static final char f20553d;

    static {
        char[] cArr = {'A', 'B', 'C', 'D'};
        f20550a = cArr;
        f20553d = cArr[0];
    }

    public boolean[] encode(String str) {
        int i;
        if (str.length() < 2) {
            str = f20553d + str + f20553d;
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            boolean a = CodaBarReader.m17310a(f20550a, upperCase);
            boolean a2 = CodaBarReader.m17310a(f20550a, upperCase2);
            boolean a3 = CodaBarReader.m17310a(f20551b, upperCase);
            boolean a4 = CodaBarReader.m17310a(f20551b, upperCase2);
            if (a) {
                if (!a2) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
            } else if (a3) {
                if (!a4) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
            } else if (a2 || a4) {
                throw new IllegalArgumentException("Invalid start/end guards: " + str);
            } else {
                str = f20553d + str + f20553d;
            }
        }
        int i2 = 20;
        for (int i3 = 1; i3 < str.length() - 1; i3++) {
            if (Character.isDigit(str.charAt(i3)) || str.charAt(i3) == '-' || str.charAt(i3) == '$') {
                i2 += 9;
            } else if (CodaBarReader.m17310a(f20552c, str.charAt(i3))) {
                i2 += 10;
            } else {
                throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i3) + '\'');
            }
        }
        boolean[] zArr = new boolean[(i2 + (str.length() - 1))];
        int i4 = 0;
        for (int i5 = 0; i5 < str.length(); i5++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i5));
            if (i5 == 0 || i5 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i6 = 0;
            while (true) {
                if (i6 >= CodaBarReader.f20540a.length) {
                    i = 0;
                    break;
                } else if (upperCase3 == CodaBarReader.f20540a[i6]) {
                    i = CodaBarReader.f20541b[i6];
                    break;
                } else {
                    i6++;
                }
            }
            int i7 = 0;
            boolean z = true;
            while (true) {
                int i8 = 0;
                while (i7 < 7) {
                    zArr[i4] = z;
                    i4++;
                    if (((i >> (6 - i7)) & 1) == 0 || i8 == 1) {
                        z = !z;
                        i7++;
                    } else {
                        i8++;
                    }
                }
                break;
            }
            if (i5 < str.length() - 1) {
                zArr[i4] = false;
                i4++;
            }
        }
        return zArr;
    }
}
