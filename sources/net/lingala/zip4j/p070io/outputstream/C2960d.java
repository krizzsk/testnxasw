package net.lingala.zip4j.p070io.outputstream;

import java.io.IOException;
import java.util.zip.Deflater;
import net.lingala.zip4j.model.enums.CompressionLevel;

/* renamed from: net.lingala.zip4j.io.outputstream.d */
/* compiled from: DeflaterOutputStream */
class C2960d extends C2959c {

    /* renamed from: a */
    protected Deflater f6759a;

    /* renamed from: b */
    private byte[] f6760b;

    public C2960d(C2958b bVar, CompressionLevel compressionLevel, int i) {
        super(bVar);
        this.f6759a = new Deflater(compressionLevel.getLevel(), true);
        this.f6760b = new byte[i];
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f6759a.setInput(bArr, i, i2);
        while (!this.f6759a.needsInput()) {
            m6579c();
        }
    }

    /* renamed from: c */
    private void m6579c() throws IOException {
        Deflater deflater = this.f6759a;
        byte[] bArr = this.f6760b;
        int deflate = deflater.deflate(bArr, 0, bArr.length);
        if (deflate > 0) {
            super.write(this.f6760b, 0, deflate);
        }
    }

    /* renamed from: a */
    public void mo29455a() throws IOException {
        if (!this.f6759a.finished()) {
            this.f6759a.finish();
            while (!this.f6759a.finished()) {
                m6579c();
            }
        }
        this.f6759a.end();
        super.mo29455a();
    }
}
