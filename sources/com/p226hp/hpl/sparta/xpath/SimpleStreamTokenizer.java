package com.p226hp.hpl.sparta.xpath;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.io.IOException;
import java.io.Reader;

/* renamed from: com.hp.hpl.sparta.xpath.SimpleStreamTokenizer */
public class SimpleStreamTokenizer {
    public static final int TT_EOF = -1;
    public static final int TT_NUMBER = -2;
    public static final int TT_WORD = -3;

    /* renamed from: a */
    private static final int f56810a = -5;

    /* renamed from: b */
    private static final int f56811b = -6;

    /* renamed from: c */
    private final StringBuffer f56812c = new StringBuffer();

    /* renamed from: d */
    private int f56813d;

    /* renamed from: e */
    private final Reader f56814e;

    /* renamed from: f */
    private final int[] f56815f = new int[256];

    /* renamed from: g */
    private boolean f56816g;

    /* renamed from: h */
    private char f56817h;
    public int nval = Integer.MIN_VALUE;
    public String sval = "";
    public int ttype = Integer.MIN_VALUE;

    public String toString() {
        int i = this.ttype;
        if (i != -3) {
            if (i == -2) {
                return Integer.toString(this.nval);
            }
            if (i == -1) {
                return "(EOF)";
            }
            if (i != 34) {
                if (i != 39) {
                    return "'" + ((char) this.ttype) + "'";
                }
                return "'" + this.sval + "'";
            }
        }
        return Const.jsQuote + this.sval + Const.jsQuote;
    }

    public SimpleStreamTokenizer(Reader reader) throws IOException {
        this.f56816g = false;
        this.f56817h = 0;
        this.f56814e = reader;
        for (int i = 0; i < this.f56815f.length; i = (char) (i + 1)) {
            if ((65 <= i && i <= 90) || ((97 <= i && i <= 122) || i == 45)) {
                this.f56815f[i] = -3;
            } else if (48 <= i && i <= 57) {
                this.f56815f[i] = -2;
            } else if (i < 0 || i > 32) {
                this.f56815f[i] = i;
            } else {
                this.f56815f[i] = -5;
            }
        }
        nextToken();
    }

    public void ordinaryChar(char c) {
        this.f56815f[c] = c;
    }

    public void wordChars(char c, char c2) {
        while (c <= c2) {
            this.f56815f[c] = -3;
            c = (char) (c + 1);
        }
    }

    public int nextToken() throws IOException {
        int read;
        char c;
        boolean z;
        boolean z2;
        int i;
        if (this.f56816g) {
            this.f56816g = false;
            return this.ttype;
        }
        this.ttype = this.f56813d;
        do {
            boolean z3 = false;
            do {
                read = this.f56814e.read();
                if (read != -1) {
                    c = this.f56815f[read];
                } else if (this.f56817h == 0) {
                    c = -1;
                } else {
                    throw new IOException("Unterminated quote");
                }
                z = this.f56817h == 0 && c == -5;
                if (z3 || z) {
                    z3 = true;
                    continue;
                } else {
                    z3 = false;
                    continue;
                }
            } while (z);
            if (c == 39 || c == 34) {
                char c2 = this.f56817h;
                if (c2 == 0) {
                    this.f56817h = (char) c;
                } else if (c2 == c) {
                    this.f56817h = 0;
                }
            }
            char c3 = this.f56817h;
            if (c3 != 0) {
                c = c3;
            }
            z2 = z3 || !(((i = this.ttype) < -1 || i == 39 || i == 34) && this.ttype == c);
            if (z2) {
                int i2 = this.ttype;
                if (i2 == -3) {
                    this.sval = this.f56812c.toString();
                    this.f56812c.setLength(0);
                } else if (i2 == -2) {
                    this.nval = Integer.parseInt(this.f56812c.toString());
                    this.f56812c.setLength(0);
                } else if (i2 == 34 || i2 == 39) {
                    this.sval = this.f56812c.toString().substring(1, this.f56812c.length() - 1);
                    this.f56812c.setLength(0);
                }
                if (c != -5) {
                    this.f56813d = c == -6 ? read : c;
                }
            }
            if (c == -3 || c == -2 || c == 34 || c == 39) {
                this.f56812c.append((char) read);
                continue;
            }
        } while (!z2);
        return this.ttype;
    }

    public void pushBack() {
        this.f56816g = true;
    }
}
