package net.lingala.zip4j.p070io.inputstream;

import java.io.IOException;
import net.lingala.zip4j.crypto.StandardDecrypter;
import net.lingala.zip4j.model.LocalFileHeader;

/* renamed from: net.lingala.zip4j.io.inputstream.f */
/* compiled from: ZipStandardCipherInputStream */
class C2956f extends C2952b<StandardDecrypter> {
    public C2956f(C2955e eVar, LocalFileHeader localFileHeader, char[] cArr, int i) throws IOException {
        super(eVar, localFileHeader, cArr, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public StandardDecrypter mo29372b(LocalFileHeader localFileHeader, char[] cArr) throws IOException {
        return new StandardDecrypter(cArr, localFileHeader.getCrc(), localFileHeader.getLastModifiedTime(), m6549e());
    }

    /* renamed from: e */
    private byte[] m6549e() throws IOException {
        byte[] bArr = new byte[12];
        mo29403a(bArr);
        return bArr;
    }
}
