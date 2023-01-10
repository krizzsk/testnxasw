package com.didi.dqr.datamatrix.encoder;

/* renamed from: com.didi.dqr.datamatrix.encoder.i */
/* compiled from: X12Encoder */
final class C8435i extends C8429c {
    /* renamed from: a */
    public int mo63288a() {
        return 3;
    }

    C8435i() {
    }

    /* renamed from: a */
    public void mo63289a(C8433g gVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!gVar.mo63306h()) {
                break;
            }
            char b = gVar.mo63298b();
            gVar.f20519a++;
            mo63290a(b, sb);
            if (sb.length() % 3 == 0) {
                m17263a(gVar, sb);
                if (HighLevelEncoder.m17240a(gVar.mo63292a(), gVar.f20519a, mo63288a()) != mo63288a()) {
                    gVar.mo63299b(0);
                    break;
                }
            }
        }
        mo63291b(gVar, sb);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo63290a(char c, StringBuilder sb) {
        if (c == 13) {
            sb.append(0);
        } else if (c == ' ') {
            sb.append(3);
        } else if (c == '*') {
            sb.append(1);
        } else if (c == '>') {
            sb.append(2);
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
        } else if (c < 'A' || c > 'Z') {
            HighLevelEncoder.m17245c(c);
        } else {
            sb.append((char) ((c - 'A') + 14));
        }
        return 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo63291b(C8433g gVar, StringBuilder sb) {
        gVar.mo63309k();
        int dataCapacity = gVar.mo63308j().getDataCapacity() - gVar.mo63303e();
        gVar.f20519a -= sb.length();
        if (gVar.mo63307i() > 1 || dataCapacity > 1 || gVar.mo63307i() != dataCapacity) {
            gVar.mo63293a(254);
        }
        if (gVar.mo63304f() < 0) {
            gVar.mo63299b(0);
        }
    }
}
