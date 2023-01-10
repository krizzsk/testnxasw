package didihttp.internal.tls;

import javax.security.auth.x500.X500Principal;

/* renamed from: didihttp.internal.tls.a */
/* compiled from: DistinguishedNameParser */
final class C21785a {

    /* renamed from: a */
    private final String f59664a;

    /* renamed from: b */
    private final int f59665b;

    /* renamed from: c */
    private int f59666c;

    /* renamed from: d */
    private int f59667d;

    /* renamed from: e */
    private int f59668e;

    /* renamed from: f */
    private int f59669f;

    /* renamed from: g */
    private char[] f59670g;

    public C21785a(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f59664a = name;
        this.f59665b = name.length();
    }

    /* renamed from: a */
    private String m44964a() {
        while (true) {
            int i = this.f59666c;
            if (i >= this.f59665b || this.f59670g[i] != ' ') {
                int i2 = this.f59666c;
            } else {
                this.f59666c = i + 1;
            }
        }
        int i22 = this.f59666c;
        if (i22 == this.f59665b) {
            return null;
        }
        this.f59667d = i22;
        this.f59666c = i22 + 1;
        while (true) {
            int i3 = this.f59666c;
            if (i3 >= this.f59665b) {
                break;
            }
            char[] cArr = this.f59670g;
            if (cArr[i3] == '=' || cArr[i3] == ' ') {
                break;
            }
            this.f59666c = i3 + 1;
        }
        int i4 = this.f59666c;
        if (i4 < this.f59665b) {
            this.f59668e = i4;
            if (this.f59670g[i4] == ' ') {
                while (true) {
                    int i5 = this.f59666c;
                    if (i5 >= this.f59665b) {
                        break;
                    }
                    char[] cArr2 = this.f59670g;
                    if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                        break;
                    }
                    this.f59666c = i5 + 1;
                }
                char[] cArr3 = this.f59670g;
                int i6 = this.f59666c;
                if (cArr3[i6] != '=' || i6 == this.f59665b) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f59664a);
                }
            }
            this.f59666c++;
            while (true) {
                int i7 = this.f59666c;
                if (i7 >= this.f59665b || this.f59670g[i7] != ' ') {
                    int i8 = this.f59668e;
                    int i9 = this.f59667d;
                } else {
                    this.f59666c = i7 + 1;
                }
            }
            int i82 = this.f59668e;
            int i92 = this.f59667d;
            if (i82 - i92 > 4) {
                char[] cArr4 = this.f59670g;
                if (cArr4[i92 + 3] == '.' && (cArr4[i92] == 'O' || cArr4[i92] == 'o')) {
                    char[] cArr5 = this.f59670g;
                    int i10 = this.f59667d;
                    if (cArr5[i10 + 1] == 'I' || cArr5[i10 + 1] == 'i') {
                        char[] cArr6 = this.f59670g;
                        int i11 = this.f59667d;
                        if (cArr6[i11 + 2] == 'D' || cArr6[i11 + 2] == 'd') {
                            this.f59667d += 4;
                        }
                    }
                }
            }
            char[] cArr7 = this.f59670g;
            int i12 = this.f59667d;
            return new String(cArr7, i12, this.f59668e - i12);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f59664a);
    }

    /* renamed from: b */
    private String m44965b() {
        int i = this.f59666c + 1;
        this.f59666c = i;
        this.f59667d = i;
        this.f59668e = i;
        while (true) {
            int i2 = this.f59666c;
            if (i2 != this.f59665b) {
                char[] cArr = this.f59670g;
                if (cArr[i2] == '\"') {
                    this.f59666c = i2 + 1;
                    while (true) {
                        int i3 = this.f59666c;
                        if (i3 >= this.f59665b || this.f59670g[i3] != ' ') {
                            char[] cArr2 = this.f59670g;
                            int i4 = this.f59667d;
                        } else {
                            this.f59666c = i3 + 1;
                        }
                    }
                    char[] cArr22 = this.f59670g;
                    int i42 = this.f59667d;
                    return new String(cArr22, i42, this.f59668e - i42);
                }
                if (cArr[i2] == '\\') {
                    cArr[this.f59668e] = m44968e();
                } else {
                    cArr[this.f59668e] = cArr[i2];
                }
                this.f59666c++;
                this.f59668e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f59664a);
            }
        }
    }

    /* renamed from: c */
    private String m44966c() {
        int i = this.f59666c;
        if (i + 4 < this.f59665b) {
            this.f59667d = i;
            this.f59666c = i + 1;
            while (true) {
                int i2 = this.f59666c;
                if (i2 == this.f59665b) {
                    break;
                }
                char[] cArr = this.f59670g;
                if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                    break;
                } else if (cArr[i2] == ' ') {
                    this.f59668e = i2;
                    this.f59666c = i2 + 1;
                    while (true) {
                        int i3 = this.f59666c;
                        if (i3 >= this.f59665b || this.f59670g[i3] != ' ') {
                            break;
                        }
                        this.f59666c = i3 + 1;
                    }
                } else {
                    if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                        cArr[i2] = (char) (cArr[i2] + ' ');
                    }
                    this.f59666c++;
                }
            }
            this.f59668e = this.f59666c;
            int i4 = this.f59668e;
            int i5 = this.f59667d;
            int i6 = i4 - i5;
            if (i6 < 5 || (i6 & 1) == 0) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f59664a);
            }
            int i7 = i6 / 2;
            byte[] bArr = new byte[i7];
            int i8 = i5 + 1;
            for (int i9 = 0; i9 < i7; i9++) {
                bArr[i9] = (byte) m44963a(i8);
                i8 += 2;
            }
            return new String(this.f59670g, this.f59667d, i6);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f59664a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009b, code lost:
        r1 = r8.f59670g;
        r2 = r8.f59667d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a7, code lost:
        return new java.lang.String(r1, r2, r8.f59669f - r2);
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m44967d() {
        /*
            r8 = this;
            int r0 = r8.f59666c
            r8.f59667d = r0
            r8.f59668e = r0
        L_0x0006:
            int r0 = r8.f59666c
            int r1 = r8.f59665b
            if (r0 < r1) goto L_0x0019
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f59670g
            int r2 = r8.f59667d
            int r3 = r8.f59668e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0019:
            char[] r1 = r8.f59670g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L_0x0060
            if (r2 == r5) goto L_0x0053
            r5 = 92
            if (r2 == r5) goto L_0x0040
            if (r2 == r4) goto L_0x0053
            if (r2 == r3) goto L_0x0053
            int r2 = r8.f59668e
            int r3 = r2 + 1
            r8.f59668e = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.f59666c = r0
            goto L_0x0006
        L_0x0040:
            int r0 = r8.f59668e
            int r2 = r0 + 1
            r8.f59668e = r2
            char r2 = r8.m44968e()
            r1[r0] = r2
            int r0 = r8.f59666c
            int r0 = r0 + 1
            r8.f59666c = r0
            goto L_0x0006
        L_0x0053:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f59670g
            int r2 = r8.f59667d
            int r3 = r8.f59668e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0060:
            int r2 = r8.f59668e
            r8.f59669f = r2
            int r0 = r0 + 1
            r8.f59666c = r0
            int r0 = r2 + 1
            r8.f59668e = r0
            r1[r2] = r6
        L_0x006e:
            int r0 = r8.f59666c
            int r1 = r8.f59665b
            if (r0 >= r1) goto L_0x0087
            char[] r1 = r8.f59670g
            char r2 = r1[r0]
            if (r2 != r6) goto L_0x0087
            int r2 = r8.f59668e
            int r7 = r2 + 1
            r8.f59668e = r7
            r1[r2] = r6
            int r0 = r0 + 1
            r8.f59666c = r0
            goto L_0x006e
        L_0x0087:
            int r0 = r8.f59666c
            int r1 = r8.f59665b
            if (r0 == r1) goto L_0x009b
            char[] r1 = r8.f59670g
            char r2 = r1[r0]
            if (r2 == r3) goto L_0x009b
            char r2 = r1[r0]
            if (r2 == r4) goto L_0x009b
            char r0 = r1[r0]
            if (r0 != r5) goto L_0x0006
        L_0x009b:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f59670g
            int r2 = r8.f59667d
            int r3 = r8.f59669f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.tls.C21785a.m44967d():java.lang.String");
    }

    /* renamed from: e */
    private char m44968e() {
        int i = this.f59666c + 1;
        this.f59666c = i;
        if (i != this.f59665b) {
            char c = this.f59670g[i];
            if (!(c == ' ' || c == '%' || c == '\\' || c == '_' || c == '\"' || c == '#')) {
                switch (c) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                return m44969f();
                        }
                }
            }
            return this.f59670g[this.f59666c];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f59664a);
    }

    /* renamed from: f */
    private char m44969f() {
        int i;
        int i2;
        int a = m44963a(this.f59666c);
        this.f59666c++;
        if (a < 128) {
            return (char) a;
        }
        if (a < 192 || a > 247) {
            return '?';
        }
        if (a <= 223) {
            i2 = a & 31;
            i = 1;
        } else if (a <= 239) {
            i = 2;
            i2 = a & 15;
        } else {
            i = 3;
            i2 = a & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = this.f59666c + 1;
            this.f59666c = i4;
            if (i4 == this.f59665b || this.f59670g[i4] != '\\') {
                return '?';
            }
            int i5 = i4 + 1;
            this.f59666c = i5;
            int a2 = m44963a(i5);
            this.f59666c++;
            if ((a2 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (a2 & 63);
        }
        return (char) i2;
    }

    /* renamed from: a */
    private int m44963a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.f59665b) {
            char c = this.f59670g[i];
            if (c >= '0' && c <= '9') {
                i2 = c - '0';
            } else if (c >= 'a' && c <= 'f') {
                i2 = c - 'W';
            } else if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f59664a);
            } else {
                i2 = c - '7';
            }
            char c2 = this.f59670g[i4];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f59664a);
            } else {
                i3 = c2 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.f59664a);
    }

    /* renamed from: a */
    public String mo180162a(String str) {
        String str2;
        this.f59666c = 0;
        this.f59667d = 0;
        this.f59668e = 0;
        this.f59669f = 0;
        this.f59670g = this.f59664a.toCharArray();
        String a = m44964a();
        if (a == null) {
            return null;
        }
        do {
            int i = this.f59666c;
            if (i == this.f59665b) {
                return null;
            }
            char c = this.f59670g[i];
            if (c != '\"') {
                str2 = c != '#' ? (c == '+' || c == ',' || c == ';') ? "" : m44967d() : m44966c();
            } else {
                str2 = m44965b();
            }
            if (str.equalsIgnoreCase(a)) {
                return str2;
            }
            int i2 = this.f59666c;
            if (i2 >= this.f59665b) {
                return null;
            }
            char[] cArr = this.f59670g;
            if (cArr[i2] == ',' || cArr[i2] == ';' || cArr[i2] == '+') {
                this.f59666c++;
                a = m44964a();
            } else {
                throw new IllegalStateException("Malformed DN: " + this.f59664a);
            }
        } while (a != null);
        throw new IllegalStateException("Malformed DN: " + this.f59664a);
    }
}
