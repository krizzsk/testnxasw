package net.lingala.zip4j.p070io.inputstream;

import java.io.IOException;
import net.lingala.zip4j.crypto.Decrypter;
import net.lingala.zip4j.model.LocalFileHeader;

/* renamed from: net.lingala.zip4j.io.inputstream.NoCipherInputStream */
class NoCipherInputStream extends C2952b {
    public NoCipherInputStream(C2955e eVar, LocalFileHeader localFileHeader, char[] cArr, int i) throws IOException {
        super(eVar, localFileHeader, cArr, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Decrypter mo29372b(LocalFileHeader localFileHeader, char[] cArr) {
        return new NoDecrypter();
    }

    /* renamed from: net.lingala.zip4j.io.inputstream.NoCipherInputStream$NoDecrypter */
    static class NoDecrypter implements Decrypter {
        public int decryptData(byte[] bArr, int i, int i2) {
            return i2;
        }

        NoDecrypter() {
        }
    }
}
