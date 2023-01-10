package net.lingala.zip4j.crypto.PBKDF2;

/* renamed from: net.lingala.zip4j.crypto.PBKDF2.b */
/* compiled from: PBKDF2HexFormatter */
class C2949b {
    C2949b() {
    }

    /* renamed from: a */
    public boolean mo29341a(PBKDF2Parameters pBKDF2Parameters, String str) {
        if (pBKDF2Parameters == null || str == null) {
            return true;
        }
        String[] split = str.split(":");
        if (split.length != 3) {
            return true;
        }
        byte[] a = C2948a.m6454a(split[0]);
        int parseInt = Integer.parseInt(split[1]);
        byte[] a2 = C2948a.m6454a(split[2]);
        pBKDF2Parameters.setSalt(a);
        pBKDF2Parameters.setIterationCount(parseInt);
        pBKDF2Parameters.setDerivedKey(a2);
        return false;
    }

    /* renamed from: a */
    public String mo29340a(PBKDF2Parameters pBKDF2Parameters) {
        return C2948a.m6453a(pBKDF2Parameters.getSalt()) + ":" + String.valueOf(pBKDF2Parameters.getIterationCount()) + ":" + C2948a.m6453a(pBKDF2Parameters.getDerivedKey());
    }
}
