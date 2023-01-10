package com.didi.dqr.datamatrix.encoder;

/* renamed from: com.didi.dqr.datamatrix.encoder.a */
/* compiled from: ASCIIEncoder */
final class C8427a implements C8432f {
    /* renamed from: a */
    public int mo63288a() {
        return 0;
    }

    C8427a() {
    }

    /* renamed from: a */
    public void mo63289a(C8433g gVar) {
        if (HighLevelEncoder.determineConsecutiveDigitCount(gVar.mo63292a(), gVar.f20519a) >= 2) {
            gVar.mo63293a(m17255a(gVar.mo63292a().charAt(gVar.f20519a), gVar.mo63292a().charAt(gVar.f20519a + 1)));
            gVar.f20519a += 2;
            return;
        }
        char b = gVar.mo63298b();
        int a = HighLevelEncoder.m17240a(gVar.mo63292a(), gVar.f20519a, mo63288a());
        if (a != mo63288a()) {
            if (a == 1) {
                gVar.mo63293a(230);
                gVar.mo63299b(1);
            } else if (a == 2) {
                gVar.mo63293a(239);
                gVar.mo63299b(2);
            } else if (a == 3) {
                gVar.mo63293a(238);
                gVar.mo63299b(3);
            } else if (a == 4) {
                gVar.mo63293a(240);
                gVar.mo63299b(4);
            } else if (a == 5) {
                gVar.mo63293a(231);
                gVar.mo63299b(5);
            } else {
                throw new IllegalStateException("Illegal mode: " + a);
            }
        } else if (HighLevelEncoder.m17244b(b)) {
            gVar.mo63293a(235);
            gVar.mo63293a((char) ((b - 128) + 1));
            gVar.f20519a++;
        } else {
            gVar.mo63293a((char) (b + 1));
            gVar.f20519a++;
        }
    }

    /* renamed from: a */
    private static char m17255a(char c, char c2) {
        if (HighLevelEncoder.m17243a(c) && HighLevelEncoder.m17243a(c2)) {
            return (char) (((c - '0') * 10) + (c2 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c + c2);
    }
}
