package net.lingala.zip4j.model;

public class Zip64EndOfCentralDirectoryRecord extends ZipHeader {

    /* renamed from: a */
    private long f6823a;

    /* renamed from: b */
    private int f6824b;

    /* renamed from: c */
    private int f6825c;

    /* renamed from: d */
    private int f6826d;

    /* renamed from: e */
    private int f6827e;

    /* renamed from: f */
    private long f6828f;

    /* renamed from: g */
    private long f6829g;

    /* renamed from: h */
    private long f6830h;

    /* renamed from: i */
    private long f6831i = -1;

    /* renamed from: j */
    private byte[] f6832j;

    public long getSizeOfZip64EndCentralDirectoryRecord() {
        return this.f6823a;
    }

    public void setSizeOfZip64EndCentralDirectoryRecord(long j) {
        this.f6823a = j;
    }

    public int getVersionMadeBy() {
        return this.f6824b;
    }

    public void setVersionMadeBy(int i) {
        this.f6824b = i;
    }

    public int getVersionNeededToExtract() {
        return this.f6825c;
    }

    public void setVersionNeededToExtract(int i) {
        this.f6825c = i;
    }

    public int getNumberOfThisDisk() {
        return this.f6826d;
    }

    public void setNumberOfThisDisk(int i) {
        this.f6826d = i;
    }

    public int getNumberOfThisDiskStartOfCentralDirectory() {
        return this.f6827e;
    }

    public void setNumberOfThisDiskStartOfCentralDirectory(int i) {
        this.f6827e = i;
    }

    public long getTotalNumberOfEntriesInCentralDirectoryOnThisDisk() {
        return this.f6828f;
    }

    public void setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(long j) {
        this.f6828f = j;
    }

    public long getTotalNumberOfEntriesInCentralDirectory() {
        return this.f6829g;
    }

    public void setTotalNumberOfEntriesInCentralDirectory(long j) {
        this.f6829g = j;
    }

    public long getSizeOfCentralDirectory() {
        return this.f6830h;
    }

    public void setSizeOfCentralDirectory(long j) {
        this.f6830h = j;
    }

    public long getOffsetStartCentralDirectoryWRTStartDiskNumber() {
        return this.f6831i;
    }

    public void setOffsetStartCentralDirectoryWRTStartDiskNumber(long j) {
        this.f6831i = j;
    }

    public byte[] getExtensibleDataSector() {
        return this.f6832j;
    }

    public void setExtensibleDataSector(byte[] bArr) {
        this.f6832j = bArr;
    }
}
