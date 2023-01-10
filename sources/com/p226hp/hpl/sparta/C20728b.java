package com.p226hp.hpl.sparta;

/* renamed from: com.hp.hpl.sparta.b */
/* compiled from: CharCircBuffer */
class C20728b {

    /* renamed from: a */
    private final int[] f56741a;

    /* renamed from: b */
    private int f56742b = 0;

    /* renamed from: c */
    private int f56743c = 0;

    /* renamed from: d */
    private boolean f56744d = true;

    C20728b(int i) {
        this.f56741a = new int[i];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171196a() {
        this.f56744d = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo171200b() {
        this.f56744d = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171198a(int i) {
        m42747b(i + 65536);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171197a(char c) {
        m42747b(c);
    }

    /* renamed from: b */
    private void m42747b(int i) {
        if (this.f56744d) {
            int[] iArr = this.f56741a;
            int i2 = this.f56742b;
            iArr[i2] = i;
            this.f56742b = (i2 + 1) % iArr.length;
            this.f56743c++;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171199a(String str) {
        for (char a : str.toCharArray()) {
            mo171197a(a);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer((this.f56741a.length * 11) / 10);
        int i = this.f56743c;
        int[] iArr = this.f56741a;
        int length = i < iArr.length ? iArr.length - i : 0;
        while (true) {
            int[] iArr2 = this.f56741a;
            if (length >= iArr2.length) {
                return stringBuffer.toString();
            }
            int i2 = iArr2[(this.f56742b + length) % iArr2.length];
            if (i2 < 65536) {
                stringBuffer.append((char) i2);
            } else {
                stringBuffer.append(Integer.toString(i2 - 65536));
            }
            length++;
        }
    }
}
