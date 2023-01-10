package com.didi.dqr.datamatrix.encoder;

import com.didi.dqr.Dimension;
import java.nio.charset.StandardCharsets;

/* renamed from: com.didi.dqr.datamatrix.encoder.g */
/* compiled from: EncoderContext */
final class C8433g {

    /* renamed from: a */
    int f20519a;

    /* renamed from: b */
    private final String f20520b;

    /* renamed from: c */
    private SymbolShapeHint f20521c;

    /* renamed from: d */
    private Dimension f20522d;

    /* renamed from: e */
    private Dimension f20523e;

    /* renamed from: f */
    private final StringBuilder f20524f;

    /* renamed from: g */
    private int f20525g;

    /* renamed from: h */
    private SymbolInfo f20526h;

    /* renamed from: i */
    private int f20527i;

    C8433g(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        int i = 0;
        while (i < length) {
            char c = (char) (bytes[i] & 255);
            if (c != '?' || str.charAt(i) == '?') {
                sb.append(c);
                i++;
            } else {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
        }
        this.f20520b = sb.toString();
        this.f20521c = SymbolShapeHint.FORCE_NONE;
        this.f20524f = new StringBuilder(str.length());
        this.f20525g = -1;
    }

    /* renamed from: a */
    public void mo63296a(SymbolShapeHint symbolShapeHint) {
        this.f20521c = symbolShapeHint;
    }

    /* renamed from: a */
    public void mo63295a(Dimension dimension, Dimension dimension2) {
        this.f20522d = dimension;
        this.f20523e = dimension2;
    }

    /* renamed from: a */
    public String mo63292a() {
        return this.f20520b;
    }

    /* renamed from: a */
    public void mo63294a(int i) {
        this.f20527i = i;
    }

    /* renamed from: b */
    public char mo63298b() {
        return this.f20520b.charAt(this.f20519a);
    }

    /* renamed from: c */
    public char mo63300c() {
        return this.f20520b.charAt(this.f20519a);
    }

    /* renamed from: d */
    public StringBuilder mo63302d() {
        return this.f20524f;
    }

    /* renamed from: a */
    public void mo63297a(String str) {
        this.f20524f.append(str);
    }

    /* renamed from: a */
    public void mo63293a(char c) {
        this.f20524f.append(c);
    }

    /* renamed from: e */
    public int mo63303e() {
        return this.f20524f.length();
    }

    /* renamed from: f */
    public int mo63304f() {
        return this.f20525g;
    }

    /* renamed from: b */
    public void mo63299b(int i) {
        this.f20525g = i;
    }

    /* renamed from: g */
    public void mo63305g() {
        this.f20525g = -1;
    }

    /* renamed from: h */
    public boolean mo63306h() {
        return this.f20519a < m17275m();
    }

    /* renamed from: m */
    private int m17275m() {
        return this.f20520b.length() - this.f20527i;
    }

    /* renamed from: i */
    public int mo63307i() {
        return m17275m() - this.f20519a;
    }

    /* renamed from: j */
    public SymbolInfo mo63308j() {
        return this.f20526h;
    }

    /* renamed from: k */
    public void mo63309k() {
        mo63301c(mo63303e());
    }

    /* renamed from: c */
    public void mo63301c(int i) {
        SymbolInfo symbolInfo = this.f20526h;
        if (symbolInfo == null || i > symbolInfo.getDataCapacity()) {
            this.f20526h = SymbolInfo.lookup(i, this.f20521c, this.f20522d, this.f20523e, true);
        }
    }

    /* renamed from: l */
    public void mo63310l() {
        this.f20526h = null;
    }
}
