package net.lingala.zip4j.model;

public class Zip64EndOfCentralDirectoryLocator extends ZipHeader {

    /* renamed from: a */
    private int f6820a;

    /* renamed from: b */
    private long f6821b;

    /* renamed from: c */
    private int f6822c;

    public int getNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord() {
        return this.f6820a;
    }

    public void setNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord(int i) {
        this.f6820a = i;
    }

    public long getOffsetZip64EndOfCentralDirectoryRecord() {
        return this.f6821b;
    }

    public void setOffsetZip64EndOfCentralDirectoryRecord(long j) {
        this.f6821b = j;
    }

    public int getTotalNumberOfDiscs() {
        return this.f6822c;
    }

    public void setTotalNumberOfDiscs(int i) {
        this.f6822c = i;
    }
}
