package com.didi.dqr.datamatrix.encoder;

/* renamed from: com.didi.dqr.datamatrix.encoder.e */
/* compiled from: EdifactEncoder */
final class C8431e implements C8432f {
    /* renamed from: a */
    public int mo63288a() {
        return 4;
    }

    C8431e() {
    }

    /* renamed from: a */
    public void mo63289a(C8433g gVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!gVar.mo63306h()) {
                break;
            }
            m17269a(gVar.mo63298b(), sb);
            gVar.f20519a++;
            if (sb.length() >= 4) {
                gVar.mo63297a(m17268a((CharSequence) sb));
                sb.delete(0, 4);
                if (HighLevelEncoder.m17240a(gVar.mo63292a(), gVar.f20519a, mo63288a()) != mo63288a()) {
                    gVar.mo63299b(0);
                    break;
                }
            }
        }
        sb.append(31);
        m17270a(gVar, (CharSequence) sb);
    }

    /* renamed from: a */
    private static void m17270a(C8433g gVar, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length != 0) {
                boolean z = true;
                if (length == 1) {
                    gVar.mo63309k();
                    int dataCapacity = gVar.mo63308j().getDataCapacity() - gVar.mo63303e();
                    int i = gVar.mo63307i();
                    if (i > dataCapacity) {
                        gVar.mo63301c(gVar.mo63303e() + 1);
                        dataCapacity = gVar.mo63308j().getDataCapacity() - gVar.mo63303e();
                    }
                    if (i <= dataCapacity && dataCapacity <= 2) {
                        gVar.mo63299b(0);
                        return;
                    }
                }
                if (length <= 4) {
                    int i2 = length - 1;
                    String a = m17268a(charSequence);
                    if (!(!gVar.mo63306h()) || i2 > 2) {
                        z = false;
                    }
                    if (i2 <= 2) {
                        gVar.mo63301c(gVar.mo63303e() + i2);
                        if (gVar.mo63308j().getDataCapacity() - gVar.mo63303e() >= 3) {
                            gVar.mo63301c(gVar.mo63303e() + a.length());
                            z = false;
                        }
                    }
                    if (z) {
                        gVar.mo63310l();
                        gVar.f20519a -= i2;
                    } else {
                        gVar.mo63297a(a);
                    }
                    gVar.mo63299b(0);
                    return;
                }
                throw new IllegalStateException("Count must not exceed 4");
            }
        } finally {
            gVar.mo63299b(0);
        }
    }

    /* renamed from: a */
    private static void m17269a(char c, StringBuilder sb) {
        if (c >= ' ' && c <= '?') {
            sb.append(c);
        } else if (c < '@' || c > '^') {
            HighLevelEncoder.m17245c(c);
        } else {
            sb.append((char) (c - '@'));
        }
    }

    /* renamed from: a */
    private static String m17268a(CharSequence charSequence) {
        int length = charSequence.length();
        if (length != 0) {
            char c = 0;
            char charAt = charSequence.charAt(0);
            char charAt2 = length >= 2 ? charSequence.charAt(1) : 0;
            char charAt3 = length >= 3 ? charSequence.charAt(2) : 0;
            if (length >= 4) {
                c = charSequence.charAt(3);
            }
            int i = (charAt << 18) + (charAt2 << 12) + (charAt3 << 6) + c;
            char c2 = (char) ((i >> 8) & 255);
            char c3 = (char) (i & 255);
            StringBuilder sb = new StringBuilder(3);
            sb.append((char) ((i >> 16) & 255));
            if (length >= 2) {
                sb.append(c2);
            }
            if (length >= 3) {
                sb.append(c3);
            }
            return sb.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }
}
