package net.lingala.zip4j.model;

import java.util.List;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.util.Zip4jUtil;

public abstract class AbstractFileHeader extends ZipHeader {

    /* renamed from: a */
    private int f6769a;

    /* renamed from: b */
    private byte[] f6770b;

    /* renamed from: c */
    private CompressionMethod f6771c;

    /* renamed from: d */
    private long f6772d;

    /* renamed from: e */
    private long f6773e = 0;

    /* renamed from: f */
    private long f6774f = 0;

    /* renamed from: g */
    private long f6775g = 0;

    /* renamed from: h */
    private int f6776h;

    /* renamed from: i */
    private int f6777i;

    /* renamed from: j */
    private String f6778j;

    /* renamed from: k */
    private boolean f6779k;

    /* renamed from: l */
    private EncryptionMethod f6780l = EncryptionMethod.NONE;

    /* renamed from: m */
    private boolean f6781m;

    /* renamed from: n */
    private Zip64ExtendedInfo f6782n;

    /* renamed from: o */
    private AESExtraDataRecord f6783o;

    /* renamed from: p */
    private boolean f6784p;

    /* renamed from: q */
    private List<ExtraDataRecord> f6785q;

    /* renamed from: r */
    private boolean f6786r;

    public int getVersionNeededToExtract() {
        return this.f6769a;
    }

    public void setVersionNeededToExtract(int i) {
        this.f6769a = i;
    }

    public byte[] getGeneralPurposeFlag() {
        return this.f6770b;
    }

    public void setGeneralPurposeFlag(byte[] bArr) {
        this.f6770b = bArr;
    }

    public CompressionMethod getCompressionMethod() {
        return this.f6771c;
    }

    public void setCompressionMethod(CompressionMethod compressionMethod) {
        this.f6771c = compressionMethod;
    }

    public long getLastModifiedTime() {
        return this.f6772d;
    }

    public void setLastModifiedTime(long j) {
        this.f6772d = j;
    }

    public long getLastModifiedTimeEpoch() {
        return Zip4jUtil.dosToExtendedEpochTme(this.f6772d);
    }

    public long getCrc() {
        return this.f6773e;
    }

    public void setCrc(long j) {
        this.f6773e = j;
    }

    public long getCompressedSize() {
        return this.f6774f;
    }

    public void setCompressedSize(long j) {
        this.f6774f = j;
    }

    public long getUncompressedSize() {
        return this.f6775g;
    }

    public void setUncompressedSize(long j) {
        this.f6775g = j;
    }

    public int getFileNameLength() {
        return this.f6776h;
    }

    public void setFileNameLength(int i) {
        this.f6776h = i;
    }

    public int getExtraFieldLength() {
        return this.f6777i;
    }

    public void setExtraFieldLength(int i) {
        this.f6777i = i;
    }

    public String getFileName() {
        return this.f6778j;
    }

    public void setFileName(String str) {
        this.f6778j = str;
    }

    public boolean isEncrypted() {
        return this.f6779k;
    }

    public void setEncrypted(boolean z) {
        this.f6779k = z;
    }

    public EncryptionMethod getEncryptionMethod() {
        return this.f6780l;
    }

    public void setEncryptionMethod(EncryptionMethod encryptionMethod) {
        this.f6780l = encryptionMethod;
    }

    public boolean isDataDescriptorExists() {
        return this.f6781m;
    }

    public void setDataDescriptorExists(boolean z) {
        this.f6781m = z;
    }

    public Zip64ExtendedInfo getZip64ExtendedInfo() {
        return this.f6782n;
    }

    public void setZip64ExtendedInfo(Zip64ExtendedInfo zip64ExtendedInfo) {
        this.f6782n = zip64ExtendedInfo;
    }

    public AESExtraDataRecord getAesExtraDataRecord() {
        return this.f6783o;
    }

    public void setAesExtraDataRecord(AESExtraDataRecord aESExtraDataRecord) {
        this.f6783o = aESExtraDataRecord;
    }

    public boolean isFileNameUTF8Encoded() {
        return this.f6784p;
    }

    public void setFileNameUTF8Encoded(boolean z) {
        this.f6784p = z;
    }

    public List<ExtraDataRecord> getExtraDataRecords() {
        return this.f6785q;
    }

    public void setExtraDataRecords(List<ExtraDataRecord> list) {
        this.f6785q = list;
    }

    public boolean isDirectory() {
        return this.f6786r;
    }

    public void setDirectory(boolean z) {
        this.f6786r = z;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AbstractFileHeader)) {
            return getFileName().equals(((AbstractFileHeader) obj).getFileName());
        }
        return false;
    }
}
