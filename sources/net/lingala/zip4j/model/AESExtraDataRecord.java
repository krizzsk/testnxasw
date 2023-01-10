package net.lingala.zip4j.model;

import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.AesVersion;
import net.lingala.zip4j.model.enums.CompressionMethod;

public class AESExtraDataRecord extends ZipHeader {

    /* renamed from: a */
    private int f6764a = 7;

    /* renamed from: b */
    private AesVersion f6765b = AesVersion.TWO;

    /* renamed from: c */
    private String f6766c = "AE";

    /* renamed from: d */
    private AesKeyStrength f6767d = AesKeyStrength.KEY_STRENGTH_256;

    /* renamed from: e */
    private CompressionMethod f6768e = CompressionMethod.DEFLATE;

    public AESExtraDataRecord() {
        setSignature(HeaderSignature.AES_EXTRA_DATA_RECORD);
    }

    public int getDataSize() {
        return this.f6764a;
    }

    public void setDataSize(int i) {
        this.f6764a = i;
    }

    public AesVersion getAesVersion() {
        return this.f6765b;
    }

    public void setAesVersion(AesVersion aesVersion) {
        this.f6765b = aesVersion;
    }

    public String getVendorID() {
        return this.f6766c;
    }

    public void setVendorID(String str) {
        this.f6766c = str;
    }

    public AesKeyStrength getAesKeyStrength() {
        return this.f6767d;
    }

    public void setAesKeyStrength(AesKeyStrength aesKeyStrength) {
        this.f6767d = aesKeyStrength;
    }

    public CompressionMethod getCompressionMethod() {
        return this.f6768e;
    }

    public void setCompressionMethod(CompressionMethod compressionMethod) {
        this.f6768e = compressionMethod;
    }
}
